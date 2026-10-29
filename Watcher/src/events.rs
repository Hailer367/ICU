//! WebSocket trigger sources.
//!
//! The watcher is event-driven: it subscribes to Base logs (mined or
//! Flashblocks-preconfirmed) and only quotes after an event. This module is a
//! deliberately small raw JSON-RPC WebSocket client so that Alchemy-specific
//! subscription names (`pendingLogs`, `newFlashblockTransactions`) can be used
//! without waiting for a typed client to add support for them.

use std::collections::HashMap;
use std::time::Duration;

use alloy::primitives::{Address, B256};
use alloy::rpc::types::Log;
use futures_util::{SinkExt, StreamExt};
use serde_json::{Value, json};
use tokio::time::{Instant, timeout};
use tokio_tungstenite::tungstenite::Message;
use tokio_tungstenite::{MaybeTlsStream, WebSocketStream, connect_async};
use tracing::{debug, info, warn};

use crate::config::EventSource;

type Ws = WebSocketStream<MaybeTlsStream<tokio::net::TcpStream>>;

#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum SubKind {
    Logs,
    PendingLogs,
    FlashblockTxs,
    Flashblocks,
    Heads,
}

#[derive(Debug, Clone)]
struct Spec {
    method: &'static str,
    params: Value,
    kind: SubKind,
}

fn specs(source: EventSource, pools: &[Address]) -> Vec<Spec> {
    let filter = json!({ "address": pools });
    let logs = Spec {
        method: "logs",
        params: json!(["logs", filter]),
        kind: SubKind::Logs,
    };
    let pending_logs = Spec {
        method: "pendingLogs",
        params: json!(["pendingLogs", filter]),
        kind: SubKind::PendingLogs,
    };
    match source {
        EventSource::Logs => vec![logs],
        EventSource::PendingLogs => vec![pending_logs],
        EventSource::Both => vec![logs, pending_logs],
        EventSource::Flashblocks => vec![
            Spec {
                method: "newFlashblockTransactions",
                params: json!(["newFlashblockTransactions"]),
                kind: SubKind::FlashblockTxs,
            },
            Spec {
                method: "newHeads",
                params: json!(["newHeads"]),
                kind: SubKind::Heads,
            },
        ],
        EventSource::Once => Vec::new(),
    }
}

/// A decoded event that may imply a price change.
#[derive(Debug, Clone)]
pub enum Trigger {
    /// A mined or preconfirmed pool log.
    Log { log: Log, preconfirmed: bool },
    /// A flashblock notification, possibly containing logs or transaction hashes.
    Flashblock { hashes: Vec<B256>, logs: Vec<Log> },
    /// A new chain head.
    Head { number: u64 },
    /// The connection was re-established; a full scan is prudent.
    Reconnect,
}

impl Trigger {
    /// Return the pool addresses mentioned by this event.
    ///
    /// A missing address means the event does not identify a pool, so the
    /// scanner should treat all pools as affected.
    pub fn addresses(&self) -> Vec<Address> {
        match self {
            Self::Log { log, .. } => vec![log.address()],
            Self::Flashblock { logs, .. } => logs.iter().map(|log| log.address()).collect(),
            Self::Head { .. } | Self::Reconnect => Vec::new(),
        }
    }

    pub fn label(&self) -> String {
        match self {
            Self::Log { log, preconfirmed } => {
                let kind = if *preconfirmed { "pending-log" } else { "log" };
                let block = log
                    .block_number
                    .map(|n| n.to_string())
                    .unwrap_or_else(|| "?".to_string());
                let tx = log
                    .transaction_hash
                    .map(|h| format!("{h:#x}"))
                    .unwrap_or_else(|| "?".to_string());
                format!("{kind} pool={} block={block} tx={tx}", log.address())
            }
            Self::Flashblock { hashes, logs } => {
                format!("flashblock txs={} logs={}", hashes.len(), logs.len())
            }
            Self::Head { number } => format!("head={number}"),
            Self::Reconnect => "reconnect".to_string(),
        }
    }
}

struct Conn {
    ws: Ws,
    subscriptions: HashMap<String, SubKind>,
}

/// Reconnecting WebSocket event source.
pub struct EventStream {
    url: String,
    specs: Vec<Spec>,
    conn: Option<Conn>,
    next_id: u64,
    backoff: Duration,
    reconnect_at: Option<Instant>,
    ping_every: Duration,
    last_ping: Instant,
    connected_once: bool,
}

impl EventStream {
    pub fn new(url: impl Into<String>, source: EventSource, pools: &[Address]) -> Self {
        Self {
            url: url.into(),
            specs: specs(source, pools),
            conn: None,
            next_id: 1,
            backoff: Duration::from_secs(1),
            reconnect_at: None,
            ping_every: Duration::from_secs(20),
            last_ping: Instant::now(),
            connected_once: false,
        }
    }

    pub fn source_specs(&self) -> Vec<(String, Value)> {
        self.specs
            .iter()
            .map(|spec| (spec.method.to_string(), spec.params.clone()))
            .collect()
    }

    async fn connect(&mut self) -> anyhow::Result<()> {
        info!(url = %redact_url(&self.url), "connecting WebSocket");
        let (ws, _response) = timeout(Duration::from_secs(20), connect_async(&self.url))
            .await
            .map_err(|_| anyhow::anyhow!("WebSocket connection timed out"))??;
        let mut conn = Conn {
            ws,
            subscriptions: HashMap::new(),
        };

        for spec in &self.specs {
            let id = self.next_id;
            self.next_id += 1;
            let request = json!({
                "jsonrpc": "2.0",
                "id": id,
                "method": "eth_subscribe",
                "params": spec.params,
            });
            conn.ws
                .send(Message::text(request.to_string()))
                .await
                .map_err(|e| anyhow::anyhow!("failed to send subscribe request: {e}"))?;
            debug!(method = spec.method, id, "sent subscription request");
        }

        self.conn = Some(conn);
        self.backoff = Duration::from_secs(1);
        self.last_ping = Instant::now();
        self.reconnect_at = None;
        if self.connected_once {
            info!("WebSocket reconnected");
        } else {
            info!("WebSocket connected");
            self.connected_once = true;
        }
        Ok(())
    }

    /// Return the next trigger, reconnecting transparently.
    pub async fn next(&mut self) -> anyhow::Result<Trigger> {
        loop {
            if self.conn.is_none() {
                if let Some(at) = self.reconnect_at {
                    let now = Instant::now();
                    if now < at {
                        tokio::time::sleep(at - now).await;
                    }
                }
                match self.connect().await {
                    Ok(()) => {
                        if self.connected_once {
                            return Ok(Trigger::Reconnect);
                        }
                    }
                    Err(err) => {
                        warn!(error = %err, backoff_secs = self.backoff.as_secs(), "WebSocket connect failed");
                        self.reconnect_at = Some(Instant::now() + self.backoff);
                        self.backoff = (self.backoff * 2).min(Duration::from_secs(30));
                        continue;
                    }
                }
            }

            let Some(conn) = self.conn.as_mut() else {
                continue;
            };
            let ping_in = self.ping_every.saturating_sub(self.last_ping.elapsed());
            let message = tokio::select! {
                message = conn.ws.next() => message,
                _ = tokio::time::sleep(ping_in) => {
                    self.last_ping = Instant::now();
                    if let Err(err) = conn.ws.send(Message::Ping(Default::default())).await {
                        warn!(error = %err, "WebSocket ping failed");
                        self.conn = None;
                        self.reconnect_at = Some(Instant::now());
                        continue;
                    }
                    continue;
                }
            };

            let message = match message {
                Some(Ok(message)) => message,
                Some(Err(err)) => {
                    warn!(error = %err, "WebSocket read failed");
                    self.conn = None;
                    self.reconnect_at = Some(Instant::now());
                    continue;
                }
                None => {
                    warn!("WebSocket closed by peer");
                    self.conn = None;
                    self.reconnect_at = Some(Instant::now());
                    continue;
                }
            };

            match message {
                Message::Text(text) => {
                    if let Some(trigger) = self.handle_text(text.as_str()) {
                        return Ok(trigger);
                    }
                }
                Message::Binary(bytes) => {
                    if let Ok(text) = std::str::from_utf8(&bytes)
                        && let Some(trigger) = self.handle_text(text)
                    {
                        return Ok(trigger);
                    }
                }
                Message::Ping(payload) => {
                    let _ = conn.ws.send(Message::Pong(payload)).await;
                }
                Message::Pong(_) => {}
                Message::Close(frame) => {
                    warn!(?frame, "WebSocket close frame");
                    self.conn = None;
                    self.reconnect_at = Some(Instant::now() + self.backoff);
                    self.backoff = (self.backoff * 2).min(Duration::from_secs(30));
                }
                Message::Frame(_) => {}
            }
        }
    }

    fn handle_text(&mut self, text: &str) -> Option<Trigger> {
        let value: Value = match serde_json::from_str(text) {
            Ok(value) => value,
            Err(err) => {
                debug!(error = %err, "ignoring non-JSON WebSocket message");
                return None;
            }
        };

        if value.is_array() {
            for item in value.as_array().into_iter().flatten() {
                if let Some(trigger) = self.handle_value(item) {
                    return Some(trigger);
                }
            }
            return None;
        }
        self.handle_value(&value)
    }

    fn handle_value(&mut self, value: &Value) -> Option<Trigger> {
        // Subscription response: {"id":1,"result":"0x..."}
        if let Some(id) = value.get("id").and_then(Value::as_u64) {
            if let Some(result) = value.get("result").and_then(Value::as_str) {
                let index = (id as usize).saturating_sub(1);
                if let Some(spec) = self.specs.get(index)
                    && let Some(conn) = self.conn.as_mut()
                {
                    conn.subscriptions.insert(result.to_string(), spec.kind);
                    info!(method = spec.method, subscription = result, "subscribed");
                }
            } else if let Some(error) = value.get("error") {
                warn!(%error, "subscription request failed");
            }
            return None;
        }

        let method = value.get("method").and_then(Value::as_str)?;
        if method != "eth_subscription" {
            return None;
        }
        let params = value.get("params")?;
        let subscription = params.get("subscription").and_then(Value::as_str)?;
        let kind = self
            .conn
            .as_ref()
            .and_then(|conn| conn.subscriptions.get(subscription).copied())
            .unwrap_or(SubKind::Logs);
        let result = params.get("result")?;

        match kind {
            SubKind::Logs => parse_log(result).map(|log| Trigger::Log {
                log,
                preconfirmed: false,
            }),
            SubKind::PendingLogs => parse_log(result).map(|log| Trigger::Log {
                log,
                preconfirmed: true,
            }),
            SubKind::Heads => parse_head(result).map(|number| Trigger::Head { number }),
            SubKind::FlashblockTxs | SubKind::Flashblocks => {
                let hashes = extract_hashes(result);
                let logs = extract_logs(result);
                if hashes.is_empty() && logs.is_empty() {
                    None
                } else {
                    Some(Trigger::Flashblock { hashes, logs })
                }
            }
        }
    }
}

fn parse_log(value: &Value) -> Option<Log> {
    serde_json::from_value(value.clone()).ok()
}

fn parse_head(value: &Value) -> Option<u64> {
    let raw = value.get("number").and_then(Value::as_str)?;
    u64::from_str_radix(raw.trim_start_matches("0x"), 16).ok()
}

fn extract_logs(value: &Value) -> Vec<Log> {
    let mut logs = Vec::new();
    collect_logs(value, &mut logs);
    logs
}

fn collect_logs(value: &Value, out: &mut Vec<Log>) {
    match value {
        Value::Object(map) => {
            if map.contains_key("topics")
                && map.contains_key("address")
                && let Some(log) = parse_log(value)
            {
                out.push(log);
            }
            for key in ["logs", "result", "data", "diff"] {
                if let Some(inner) = map.get(key) {
                    collect_logs(inner, out);
                }
            }
        }
        Value::Array(items) => {
            for item in items {
                collect_logs(item, out);
            }
        }
        _ => {}
    }
}

fn extract_hashes(value: &Value) -> Vec<B256> {
    let mut hashes = Vec::new();
    collect_hashes(value, &mut hashes);
    hashes.sort_unstable();
    hashes.dedup();
    hashes
}

fn collect_hashes(value: &Value, out: &mut Vec<B256>) {
    match value {
        Value::String(text) => {
            if let Ok(hash) = text.parse::<B256>() {
                out.push(hash);
            }
        }
        Value::Array(items) => {
            for item in items {
                collect_hashes(item, out);
            }
        }
        Value::Object(map) => {
            // Only descend into containers that plausibly hold transactions.
            for key in ["transactions", "txs", "diff"] {
                if let Some(inner) = map.get(key) {
                    collect_hashes(inner, out);
                }
            }
            // A transaction object has a `hash` plus transaction-only fields.
            let looks_like_tx =
                map.contains_key("from") || map.contains_key("nonce") || map.contains_key("input");
            if looks_like_tx
                && let Some(hash) = map.get("hash").and_then(Value::as_str)
                && let Ok(hash) = hash.parse::<B256>()
            {
                out.push(hash);
            }
        }
        _ => {}
    }
}

/// Hide the API key in logs.
pub fn redact_url(url: &str) -> String {
    if let Some((scheme, rest)) = url.split_once("://")
        && let Some((host, _path)) = rest.split_once('/')
    {
        return format!("{scheme}://{host}/<redacted>");
    }
    "<redacted>".to_string()
}

#[cfg(test)]
mod tests {
    use super::*;
    use alloy::primitives::address;

    #[test]
    fn builds_expected_subscriptions() {
        let pool = address!("b4CB800910B228ED3d0834cF79D697127BBB00e5");
        let source = EventSource::PendingLogs;
        let specs = specs(source, &[pool]);
        assert_eq!(specs.len(), 1);
        assert_eq!(specs[0].method, "pendingLogs");
        assert_eq!(specs[0].params[0], "pendingLogs");
        assert_eq!(
            specs[0].params[1]["address"][0],
            format!("{pool}").to_lowercase()
        );
    }

    #[test]
    fn both_source_subscribes_twice() {
        let pool = address!("b4CB800910B228ED3d0834cF79D697127BBB00e5");
        let specs = specs(EventSource::Both, &[pool]);
        assert_eq!(specs.len(), 2);
        assert_eq!(specs[0].method, "logs");
        assert_eq!(specs[1].method, "pendingLogs");
    }

    #[test]
    fn parses_log_notification() {
        let json = serde_json::json!({
            "address": "0xb4CB800910B228ED3d0834cF79D697127BBB00e5",
            "topics": [
                "0xc42079f94a6350d7e6235f29174924f928cc2ac818eb64fed8004e115fbcca67"
            ],
            "data": "0x",
            "blockNumber": "0x1",
            "transactionHash": "0x0000000000000000000000000000000000000000000000000000000000000001",
            "transactionIndex": "0x0",
            "blockHash": "0x0000000000000000000000000000000000000000000000000000000000000002",
            "logIndex": "0x0",
            "removed": false
        });
        let log = parse_log(&json).expect("log parses");
        assert_eq!(
            log.address(),
            address!("b4CB800910B228ED3d0834cF79D697127BBB00e5")
        );
    }

    #[test]
    fn extracts_flashblock_hashes() {
        let json = serde_json::json!({
            "diff": {
                "transactions": [
                    {"hash": "0x0000000000000000000000000000000000000000000000000000000000000001", "from": "0x0000000000000000000000000000000000000002", "nonce": "0x1"},
                    "0x0000000000000000000000000000000000000000000000000000000000000003"
                ]
            }
        });
        let hashes = extract_hashes(&json);
        assert_eq!(hashes.len(), 2);
    }

    #[test]
    fn redacts_url() {
        assert_eq!(
            redact_url("wss://base-mainnet.g.alchemy.com/v2/secret"),
            "wss://base-mainnet.g.alchemy.com/<redacted>"
        );
    }
}

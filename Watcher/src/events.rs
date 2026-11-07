//! WebSocket trigger sources.
//!
//! The watcher is event-driven: it subscribes to Base logs (mined or
//! Flashblocks-preconfirmed) and only quotes after an event. This module is a
//! deliberately small raw JSON-RPC WebSocket client so that Alchemy-specific
//! subscription names (`pendingLogs`, `newFlashblockTransactions`) can be used
//! without waiting for a typed client to add support for them.

use std::collections::{HashMap, VecDeque};
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

/// Bound the trigger queue so a slow scan cannot make the watcher fall
/// arbitrarily far behind the chain. On overflow the queue is flushed and the
/// stream emits a `Reconnect` trigger, which forces one fresh full scan.
const MAX_QUEUED_TRIGGERS: usize = 512;

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
    // Heads are subscribed for every live source: the scanner uses the header
    // to pin reads without a round-trip (§0t), and gap detection already
    // needed them.
    let heads = Spec {
        method: "newHeads",
        params: json!(["newHeads"]),
        kind: SubKind::Heads,
    };
    match source {
        EventSource::Logs => vec![logs, heads],
        EventSource::PendingLogs => vec![pending_logs, heads],
        EventSource::Both => vec![logs, pending_logs, heads],
        EventSource::Flashblocks => vec![
            Spec {
                method: "newFlashblockTransactions",
                params: json!(["newFlashblockTransactions"]),
                kind: SubKind::FlashblockTxs,
            },
            Spec {
                method: "newFlashblocks",
                params: json!(["newFlashblocks"]),
                kind: SubKind::Flashblocks,
            },
            heads,
        ],
        EventSource::Once => Vec::new(),
    }
}

/// The header fields a `newHeads` notification delivers. Base emits these as
/// it produces blocks, so the newest one received *is* the newest confirmed
/// head as far as the socket knows — the scanner pins its reads from here
/// without paying a `latest` round-trip per scan (§0t). `hash` keeps the
/// pinned-by-hash guarantee of §0k; `timestamp` and `base_fee` are what a
/// resolved pin would have read from the block object.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub struct HeadInfo {
    pub number: u64,
    pub hash: B256,
    pub timestamp: u64,
    pub base_fee_per_gas: Option<u64>,
}

/// A decoded event that may imply a price change.
#[derive(Debug, Clone)]
pub enum Trigger {
    /// A mined or preconfirmed pool log.
    Log { log: Log, preconfirmed: bool },
    /// A flashblock notification, possibly containing logs or transaction hashes.
    Flashblock { hashes: Vec<B256>, logs: Vec<Log> },
    /// A new chain head.
    Head { head: HeadInfo },
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
            Self::Head { head } => format!("head={}", head.number),
            Self::Reconnect => "reconnect".to_string(),
        }
    }
}

struct Conn {
    ws: Ws,
    subscriptions: HashMap<String, SubKind>,
    /// Subscription request id -> kind. Kept per-connection so reconnects do
    /// not need to guess from the (ever-increasing) global request id.
    pending: HashMap<u64, SubKind>,
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
    queue: VecDeque<Trigger>,
    overflowed: bool,
}

impl EventStream {
    pub fn new(url: impl Into<String>, source: EventSource, pools: &[Address]) -> Self {
        // Providers hand out the same endpoint as https://; subscriptions
        // need the ws(s):// form.
        let url = crate::chain::normalize_ws_url(&url.into());
        Self {
            url,
            specs: specs(source, pools),
            conn: None,
            next_id: 1,
            backoff: Duration::from_secs(1),
            reconnect_at: None,
            ping_every: Duration::from_secs(20),
            last_ping: Instant::now(),
            connected_once: false,
            queue: VecDeque::new(),
            overflowed: false,
        }
    }

    pub fn source_specs(&self) -> Vec<(String, Value)> {
        self.specs
            .iter()
            .map(|spec| (spec.method.to_string(), spec.params.clone()))
            .collect()
    }

    fn push(&mut self, trigger: Trigger) {
        if self.queue.len() >= MAX_QUEUED_TRIGGERS {
            self.queue.clear();
            self.overflowed = true;
            warn!(
                capacity = MAX_QUEUED_TRIGGERS,
                "event queue overflowed; will force a full rescan"
            );
            return;
        }
        self.queue.push_back(trigger);
    }

    async fn connect(&mut self) -> anyhow::Result<()> {
        info!(url = %redact_url(&self.url), "connecting WebSocket");
        let (ws, _response) = timeout(Duration::from_secs(20), connect_async(&self.url))
            .await
            .map_err(|_| anyhow::anyhow!("WebSocket connection timed out"))??;
        let mut conn = Conn {
            ws,
            subscriptions: HashMap::new(),
            pending: HashMap::new(),
        };

        for spec in &self.specs {
            let id = self.next_id;
            self.next_id += 1;
            conn.pending.insert(id, spec.kind);
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
        info!("WebSocket connected");
        Ok(())
    }

    /// Return the next trigger, reconnecting transparently.
    pub async fn next(&mut self) -> anyhow::Result<Trigger> {
        loop {
            if let Some(trigger) = self.queue.pop_front() {
                return Ok(trigger);
            }
            if self.overflowed {
                self.overflowed = false;
                return Ok(Trigger::Reconnect);
            }
            if self.conn.is_none() {
                if let Some(at) = self.reconnect_at {
                    let now = Instant::now();
                    if now < at {
                        tokio::time::sleep(at - now).await;
                    }
                }
                let reconnecting = self.connected_once;
                match self.connect().await {
                    Ok(()) => {
                        if reconnecting {
                            info!("WebSocket reconnected");
                            return Ok(Trigger::Reconnect);
                        }
                        self.connected_once = true;
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
                    self.ingest_text(text.as_str());
                }
                Message::Binary(bytes) => {
                    if let Ok(text) = std::str::from_utf8(&bytes) {
                        self.ingest_text(text);
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

    fn ingest_text(&mut self, text: &str) {
        let value: Value = match serde_json::from_str(text) {
            Ok(value) => value,
            Err(err) => {
                debug!(error = %err, "ignoring non-JSON WebSocket message");
                return;
            }
        };

        if let Some(items) = value.as_array() {
            for item in items {
                if let Some(trigger) = self.handle_value(item) {
                    self.push(trigger);
                }
            }
        } else if let Some(trigger) = self.handle_value(&value) {
            self.push(trigger);
        }
    }

    fn handle_value(&mut self, value: &Value) -> Option<Trigger> {
        // Subscription response: {"id":1,"result":"0x..."}
        if let Some(id) = value.get("id").and_then(Value::as_u64) {
            if let Some(result) = value.get("result").and_then(Value::as_str) {
                if let Some(conn) = self.conn.as_mut() {
                    let kind = conn.pending.remove(&id).or_else(|| {
                        self.specs
                            .get((id as usize).saturating_sub(1))
                            .map(|s| s.kind)
                    });
                    conn.subscriptions
                        .insert(result.to_string(), kind.unwrap_or(SubKind::Logs));
                    info!(id, subscription = result, kind = ?kind, "subscribed");
                }
            } else if let Some(error) = value.get("error") {
                let kind = self
                    .conn
                    .as_mut()
                    .and_then(|conn| conn.pending.remove(&id));
                // Post-Denim a rejected `pendingLogs`/flashblock subscription is
                // terminal for that feed, and the stream would otherwise look
                // healthy while only `newHeads` (liveness) arrives: zero scans,
                // indistinguishable from a quiet market. Name the cause.
                warn!(
                    %error,
                    id,
                    kind = ?kind,
                    "subscription request failed; this trigger source is unavailable (Base Denim removed pendingLogs/Flashblocks — use --source logs)"
                );
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
            SubKind::Logs => parse_log(result).map(|log| {
                if log.removed {
                    Trigger::Reconnect
                } else {
                    Trigger::Log {
                        log,
                        preconfirmed: false,
                    }
                }
            }),
            SubKind::PendingLogs => parse_log(result).map(|log| Trigger::Log {
                log,
                preconfirmed: true,
            }),
            SubKind::Heads => parse_head(result).map(|head| Trigger::Head { head }),
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

fn parse_hex_u64(value: &Value, field: &str) -> Option<u64> {
    let raw = value.get(field).and_then(Value::as_str)?;
    u64::from_str_radix(raw.trim_start_matches("0x"), 16).ok()
}

fn parse_head(value: &Value) -> Option<HeadInfo> {
    let number = parse_hex_u64(value, "number")?;
    let hash = value
        .get("hash")
        .and_then(Value::as_str)
        .and_then(|s| s.parse::<B256>().ok())?;
    // A zero hash cannot pin anything (that is the `pending` pathology §0k
    // names); treat it as no head at all and let the scanner fall back.
    if hash.is_zero() {
        return None;
    }
    let timestamp = parse_hex_u64(value, "timestamp")?;
    let base_fee_per_gas = parse_hex_u64(value, "baseFeePerGas");
    Some(HeadInfo {
        number,
        hash,
        timestamp,
        base_fee_per_gas,
    })
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
        // §0t: every live source also subscribes to heads, because the
        // scanner pins scans from the delivered header instead of paying a
        // `latest` round-trip per scan.
        assert_eq!(specs.len(), 2);
        assert_eq!(specs[0].method, "pendingLogs");
        assert_eq!(specs[0].params[0], "pendingLogs");
        assert_eq!(
            specs[0].params[1]["address"][0],
            format!("{pool}").to_lowercase()
        );
        assert_eq!(specs[1].method, "newHeads");
    }

    #[test]
    fn both_source_subscribes_logs_pending_and_heads() {
        let pool = address!("b4CB800910B228ED3d0834cF79D697127BBB00e5");
        let both_specs = specs(EventSource::Both, &[pool]);
        assert_eq!(both_specs.len(), 3);
        assert_eq!(both_specs[0].method, "logs");
        assert_eq!(both_specs[1].method, "pendingLogs");
        assert_eq!(both_specs[2].method, "newHeads");
        let log_specs = specs(EventSource::Logs, &[pool]);
        assert_eq!(
            log_specs.iter().map(|s| s.method).collect::<Vec<_>>(),
            vec!["logs", "newHeads"]
        );
    }

    #[test]
    fn parses_a_full_head_notification() {
        let json = serde_json::json!({
            "number": "0x32fcf0d",
            "hash": "0x1111111111111111111111111111111111111111111111111111111111111111",
            "parentHash": "0x2222222222222222222222222222222222222222222222222222222222222222",
            "timestamp": "0x67000000",
            "baseFeePerGas": "0x126889",
        });
        let head = parse_head(&json).expect("head parses");
        assert_eq!(head.number, 0x32fcf0d);
        let expected: alloy::primitives::B256 =
            "0x1111111111111111111111111111111111111111111111111111111111111111"
                .parse()
                .unwrap();
        assert_eq!(head.hash, expected);
        assert_eq!(head.timestamp, 0x67000000);
        assert_eq!(head.base_fee_per_gas, Some(0x126889));
    }

    #[test]
    fn heads_without_usable_hashes_are_dropped() {
        // The `pending` pathology of §0k: a zero hash cannot pin reads.
        let json = serde_json::json!({
            "number": "0x1",
            "hash": "0x0000000000000000000000000000000000000000000000000000000000000000",
            "timestamp": "0x1",
        });
        assert!(parse_head(&json).is_none());
        // Missing timestamp: no staleness math without it — drop, don't guess.
        let json = serde_json::json!({
            "number": "0x1",
            "hash": "0x1111111111111111111111111111111111111111111111111111111111111111",
        });
        assert!(parse_head(&json).is_none());
        // baseFeePerGas is the only optional field.
        let json = serde_json::json!({
            "number": "0x1",
            "hash": "0x1111111111111111111111111111111111111111111111111111111111111111",
            "timestamp": "0x1",
        });
        assert_eq!(parse_head(&json).unwrap().base_fee_per_gas, None);
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

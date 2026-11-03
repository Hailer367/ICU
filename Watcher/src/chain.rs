use alloy::eips::BlockId;
use alloy::network::TransactionBuilder;
use alloy::primitives::{Address, B256, Bytes, U256};
use alloy::providers::{DynProvider, Provider, ProviderBuilder};
use alloy::rpc::types::TransactionRequest;
use alloy::transports::{RpcError, TransportErrorKind};
use anyhow::{Context, Result, anyhow};

use crate::errors;

/// A type-erased Alloy provider. Cheap to clone and usable over HTTP or WebSocket.
pub type ChainProvider = DynProvider;

pub async fn connect(url: &str) -> Result<ChainProvider> {
    let provider = ProviderBuilder::new()
        .connect(url)
        .await
        .with_context(|| format!("failed to connect to {url}"))?;
    Ok(provider.erased())
}

pub async fn connect_http(url: &str) -> Result<ChainProvider> {
    let parsed = url
        .parse()
        .with_context(|| format!("invalid RPC URL {url}"))?;
    let provider = ProviderBuilder::new().connect_http(parsed);
    Ok(provider.erased())
}

/// Alchemy (and most providers) hand out one endpoint per connection type;
/// an `http(s)://` URL used as a WebSocket target is upgraded to `ws(s)://`.
/// Anything else passes through unchanged.
pub fn normalize_ws_url(url: &str) -> String {
    if let Some(rest) = url.strip_prefix("http://") {
        format!("ws://{rest}")
    } else if let Some(rest) = url.strip_prefix("https://") {
        format!("wss://{rest}")
    } else {
        url.to_string()
    }
}

/// The `host[:port]` authority of a URL, lowercased, without credentials or
/// path. Returns `None` when the URL has no recognizable `scheme://authority`.
fn authority(url: &str) -> Option<String> {
    let scheme_end = url.find("://").map(|i| i + 3)?;
    let rest = &url[scheme_end..];
    let host = match rest.find('/') {
        Some(i) => &rest[..i],
        None => rest,
    };
    // Credentials must never take part in endpoint comparison.
    let host = match host.rfind('@') {
        Some(i) => &host[i + 1..],
        None => host,
    };
    if host.is_empty() {
        return None;
    }
    // An explicit default port (`host:443`) names the same server as `host`.
    let host = match host.rsplit_once(':') {
        Some((name, "443")) | Some((name, "80")) => name,
        _ => host,
    };
    Some(host.to_ascii_lowercase())
}

/// True when an HTTP endpoint and a WebSocket endpoint address the same RPC
/// server. Only then may the scan reuse the WebSocket connection: a different
/// host means different state (e.g. live events vs a local fork), where calls
/// must stay on the HTTP endpoint.
pub fn same_endpoint(http: &str, ws: &str) -> bool {
    match (authority(http), authority(ws)) {
        (Some(a), Some(b)) => a == b,
        _ => false,
    }
}

/// Provider for quotes, simulations, and gas estimates.
///
/// When a WebSocket endpoint is configured for the *same* server as HTTP,
/// every call rides the one persistent connection (no TCP+TLS setup per
/// request). Otherwise HTTP is used, unchanged from before.
pub async fn connect_auto(http: &str, ws: Option<&str>) -> Result<ChainProvider> {
    if let Some(ws) = ws {
        let ws = normalize_ws_url(ws);
        if same_endpoint(http, &ws) {
            let provider = connect(&ws)
                .await
                .context("failed to open the WebSocket call provider")?;
            tracing::info!("scanning over the WebSocket endpoint (persistent connection)");
            return Ok(provider);
        }
    }
    connect_http(http).await
}

#[derive(Debug)]
pub enum CallError {
    /// The node executed the call and the EVM reverted with this payload.
    Revert(Bytes),
    /// The node could not execute the call (network, rate limit, bad params, ...).
    Transport(String),
}

impl std::fmt::Display for CallError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            Self::Revert(data) => write!(f, "revert: {data}"),
            Self::Transport(message) => write!(f, "transport: {message}"),
        }
    }
}

impl std::error::Error for CallError {}

pub async fn eth_call(
    provider: &ChainProvider,
    to: Address,
    data: Bytes,
    block: BlockId,
) -> std::result::Result<Bytes, CallError> {
    let request = TransactionRequest::default().with_to(to).with_input(data);
    let call = provider.call(request);
    let result = call.block(block).await;
    match result {
        Ok(bytes) => Ok(bytes),
        Err(err) => Err(classify_rpc_error(err)),
    }
}

fn classify_rpc_error(err: RpcError<TransportErrorKind>) -> CallError {
    if let Some(payload) = err.as_error_resp() {
        if let Some(data) = errors::revert_data_from_payload(payload) {
            return CallError::Revert(data);
        }
        return CallError::Transport(format!("{} (code {})", payload.message, payload.code));
    }
    CallError::Transport(err.to_string())
}

pub async fn eth_call_u256(
    provider: &ChainProvider,
    to: Address,
    data: Bytes,
    block: BlockId,
) -> Result<U256> {
    let bytes = eth_call(provider, to, data, block)
        .await
        .map_err(|e| anyhow!("call to {to} failed: {e}"))?;
    if bytes.len() < 32 {
        return Err(anyhow!(
            "call to {to} returned {} bytes, expected 32",
            bytes.len()
        ));
    }
    Ok(U256::from_be_slice(&bytes[..32]))
}

pub async fn eth_call_bool(
    provider: &ChainProvider,
    to: Address,
    data: Bytes,
    block: BlockId,
) -> Result<bool> {
    Ok(eth_call_u256(provider, to, data, block).await? != U256::ZERO)
}

pub async fn eth_call_u8(
    provider: &ChainProvider,
    to: Address,
    data: Bytes,
    block: BlockId,
) -> Result<u8> {
    let value = eth_call_u256(provider, to, data, block).await?;
    Ok(value.try_into().unwrap_or(0))
}

/// Estimate gas for a call. The node must be able to execute it.
///
/// `from` matters for permissioned functions: `RyoCore.execute` only accepts
/// the operator or owner, so estimating from the zero address always reverts.
pub async fn estimate_gas(provider: &ChainProvider, to: Address, data: Bytes) -> Result<u64> {
    estimate_gas_from(provider, to, data, None).await
}

pub async fn estimate_gas_from(
    provider: &ChainProvider,
    to: Address,
    data: Bytes,
    from: Option<Address>,
) -> Result<u64> {
    let mut request = TransactionRequest::default().with_to(to).with_input(data);
    if let Some(from) = from {
        request = request.with_from(from);
    }
    provider
        .estimate_gas(request)
        .await
        .with_context(|| format!("eth_estimateGas failed for {to}"))
}

pub async fn block_number(provider: &ChainProvider) -> Result<u64> {
    provider
        .get_block_number()
        .await
        .context("failed to read block number")
}

/// One immutable chain state that a whole scan reads and simulates against.
///
/// Resolved once, up front, and then reused for *every* read in that scan:
/// pool reserves, quotes, the contract's own simulation, gas and price feeds.
/// A profit figure stitched together from two different blocks describes a
/// trade that was possible in neither of them, so consistency is not a
/// nicety — without it the number is simply not about anything that happened.
///
/// Pinned by **hash** where the node gives one, because a block *number* can be
/// re-orged into different state part-way through a scan, while a hash
/// identifies exactly the block the quotes came from. Pending state cannot be
/// pinned at all — Base nodes return `0x0000…0000` as its hash — which is
/// exactly why it is unsuitable: "pending" is a moving target by definition. So
/// a scan reads the newest *confirmed* block and reports how far behind head it
/// turned out to be, rather than silently mixing states.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub struct Pin {
    pub number: u64,
    /// `None` only for a provider that withholds the header hash.
    pub hash: Option<B256>,
    pub timestamp: u64,
    pub base_fee_per_gas: Option<u64>,
}

impl Pin {
    /// The newest confirmed block, in one round-trip.
    pub async fn resolve_latest(provider: &ChainProvider) -> Result<Self> {
        let block = provider
            .get_block_by_number(alloy::rpc::types::BlockNumberOrTag::Latest)
            .await
            .context("failed to read the latest block for pinning")?
            .context("latest block not found")?;
        Ok(Self {
            number: block.header.number,
            hash: Some(block.header.hash),
            timestamp: block.header.timestamp,
            base_fee_per_gas: block.header.base_fee_per_gas,
        })
    }

    /// A pin from known header fields, for tests and for callers that already
    /// fetched the block.
    pub fn from_header(
        number: u64,
        hash: Option<B256>,
        timestamp: u64,
        base_fee: Option<u64>,
    ) -> Self {
        Self {
            number,
            hash,
            timestamp,
            base_fee_per_gas: base_fee,
        }
    }

    /// The block id every read in this scan must use.
    pub fn id(self) -> BlockId {
        match self.hash {
            Some(hash) => BlockId::hash(hash),
            None => BlockId::number(self.number),
        }
    }

    /// Has the block this pin names been replaced? Compare against the hash
    /// the node now reports for the same *number*.
    ///
    /// A sequencer can discard blocks it already broadcast, which is the one
    /// thing hash-pinning cannot survive silently: the reads would still
    /// succeed, but against a block that is no longer canonical. `None` means
    /// the node could not say (no header for that number) — never guess.
    pub fn is_superseded_by(&self, current_hash: Option<B256>) -> bool {
        match (self.hash, current_hash) {
            (Some(pinned), Some(current)) => pinned != current,
            _ => false,
        }
    }

    /// How many blocks head moved while the scan ran. Zero is the hope; a
    /// non-zero value is still a *consistent* scan, just one taken against a
    /// state that is now this many blocks old.
    pub fn blocks_behind(self, head: u64) -> u64 {
        head.saturating_sub(self.number)
    }
}

/// The hash the node currently reports for a block *number*, or `None` when it
/// has no such block. Used to notice that a pinned block was replaced.
pub async fn header_hash(provider: &ChainProvider, number: u64) -> Result<Option<B256>> {
    let block = provider
        .get_block_by_number(alloy::rpc::types::BlockNumberOrTag::Number(number))
        .await
        .with_context(|| format!("failed to read block {number} header"))?;
    Ok(block.map(|block| block.header.hash))
}

pub async fn chain_id(provider: &ChainProvider) -> Result<u64> {
    provider
        .get_chain_id()
        .await
        .context("failed to read chain id")
}

pub async fn gas_price(provider: &ChainProvider) -> Result<u128> {
    provider
        .get_gas_price()
        .await
        .context("failed to read gas price")
}

pub async fn code_at(provider: &ChainProvider, address: Address) -> Result<Bytes> {
    provider
        .get_code_at(address)
        .await
        .with_context(|| format!("failed to read code at {address}"))
}

pub async fn balance_of(provider: &ChainProvider, address: Address) -> Result<U256> {
    provider
        .get_balance(address)
        .await
        .with_context(|| format!("failed to read balance of {address}"))
}

pub async fn erc20_balance(
    provider: &ChainProvider,
    token: Address,
    owner: Address,
    block: BlockId,
) -> Result<U256> {
    use alloy::sol_types::SolCall;
    let call = crate::abi::erc20::balanceOfCall { owner };
    let bytes = eth_call(provider, token, call.abi_encode().into(), block)
        .await
        .map_err(|e| anyhow!("balanceOf failed: {e}"))?;
    let result = crate::abi::erc20::balanceOfCall::abi_decode_returns(&bytes)
        .context("failed to decode balanceOf")?;
    Ok(result)
}

pub async fn erc20_decimals(provider: &ChainProvider, token: Address) -> Result<u8> {
    use alloy::sol_types::SolCall;
    let call = crate::abi::erc20::decimalsCall {};
    let bytes = eth_call(provider, token, call.abi_encode().into(), BlockId::latest())
        .await
        .map_err(|e| anyhow!("decimals failed: {e}"))?;
    let result = crate::abi::erc20::decimalsCall::abi_decode_returns(&bytes)
        .context("failed to decode decimals")?;
    Ok(result)
}

pub async fn erc20_symbol(provider: &ChainProvider, token: Address) -> Result<String> {
    use alloy::sol_types::SolCall;
    let call = crate::abi::erc20::symbolCall {};
    let bytes = eth_call(provider, token, call.abi_encode().into(), BlockId::latest())
        .await
        .map_err(|e| anyhow!("symbol failed: {e}"))?;
    let result = crate::abi::erc20::symbolCall::abi_decode_returns(&bytes)
        .context("failed to decode symbol")?;
    Ok(result)
}

/// Run `(target, calldata)` pairs as one Multicall3 `aggregate3` with
/// `allowFailure = true`, returning one entry per call in input order.
///
/// A whole-batch failure (transport, decode, short result) marks *every* entry
/// as `Err` so callers can distinguish "no data" from "this one call reverted".
/// Individual reverts are labelled with the decoded revert reason.
/// One `aggregate3` round-trip that preserves raw revert payloads.
///
/// [`multicall_raw`] collapses a failed inner call into a `String` — fine for
/// reads, useless for `RyoCore.simulate`, whose *success* answer arrives as a
/// revert payload (`SimulationResult(int256)`). This variant returns the
/// untouched `(success, returnData)` pairs so the caller classifies them;
/// `allowFailure = true` guarantees the batch itself never reverts, so any
/// error here is transport/decode level and applies to the whole batch.
pub async fn multicall3_outcomes(
    provider: &ChainProvider,
    calls: &[(Address, Bytes)],
    block: BlockId,
) -> std::result::Result<Vec<crate::abi::multicall3::Result3>, String> {
    use crate::abi::multicall3;
    use alloy::sol_types::SolCall;

    let aggregate = multicall3::aggregate3Call {
        calls: calls
            .iter()
            .map(|(target, data)| multicall3::Call3 {
                target: *target,
                allowFailure: true,
                callData: data.clone(),
            })
            .collect(),
    };
    let bytes = match eth_call(
        provider,
        crate::config::base::MULTICALL3,
        aggregate.abi_encode().into(),
        block,
    )
    .await
    {
        Ok(bytes) => bytes,
        Err(err) => return Err(format!("multicall failed: {err}")),
    };
    let decoded = multicall3::aggregate3Call::abi_decode_returns(&bytes)
        .map_err(|err| format!("failed to decode multicall result: {err}"))?;
    if decoded.len() != calls.len() {
        return Err(format!(
            "multicall returned {} results for {} calls",
            decoded.len(),
            calls.len()
        ));
    }
    Ok(decoded)
}

pub async fn multicall_raw(
    provider: &ChainProvider,
    calls: &[(Address, Bytes)],
    block: BlockId,
) -> Vec<std::result::Result<Bytes, String>> {
    use crate::abi::multicall3;
    use alloy::sol_types::SolCall;

    let all_failed = |reason: String| -> Vec<std::result::Result<Bytes, String>> {
        calls.iter().map(|_| Err(reason.clone())).collect()
    };

    let aggregate = multicall3::aggregate3Call {
        calls: calls
            .iter()
            .map(|(target, data)| multicall3::Call3 {
                target: *target,
                allowFailure: true,
                callData: data.clone(),
            })
            .collect(),
    };
    let bytes = match eth_call(
        provider,
        crate::config::base::MULTICALL3,
        aggregate.abi_encode().into(),
        block,
    )
    .await
    {
        Ok(bytes) => bytes,
        Err(err) => return all_failed(format!("multicall failed: {err}")),
    };
    let decoded = match multicall3::aggregate3Call::abi_decode_returns(&bytes) {
        Ok(decoded) => decoded,
        Err(err) => {
            return all_failed(format!("failed to decode multicall result: {err}"));
        }
    };
    if decoded.len() != calls.len() {
        return all_failed(format!(
            "multicall returned {} results for {} calls",
            decoded.len(),
            calls.len()
        ));
    }
    decoded
        .into_iter()
        .zip(calls.iter())
        .map(|(result, (target, _))| {
            if result.success {
                return Ok(result.returnData);
            }
            let decoded_err = errors::decode(&result.returnData);
            Err(format!("call to {target} reverted: {decoded_err}"))
        })
        .collect()
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn normalizes_endpoints_to_websocket_schemes() {
        assert_eq!(
            normalize_ws_url("https://base-mainnet.g.alchemy.com/v2/KEY"),
            "wss://base-mainnet.g.alchemy.com/v2/KEY"
        );
        assert_eq!(
            normalize_ws_url("http://127.0.0.1:8545"),
            "ws://127.0.0.1:8545"
        );
        // Already WebSocket URLs pass through untouched.
        assert_eq!(normalize_ws_url("wss://x.example/ws"), "wss://x.example/ws");
        assert_eq!(normalize_ws_url("ws://x.example"), "ws://x.example");
    }

    #[test]
    fn detects_same_and_different_endpoints() {
        assert!(same_endpoint(
            "https://base-mainnet.g.alchemy.com/v2/KEY1",
            "wss://base-mainnet.g.alchemy.com/v2/KEY2"
        ));
        assert!(same_endpoint(
            "http://127.0.0.1:8545",
            "ws://127.0.0.1:8545"
        ));
        assert!(same_endpoint(
            "https://Host.Example/path",
            "wss://host.example:443/other"
        ));
        assert!(!same_endpoint(
            "https://mainnet.base.org",
            "wss://base-mainnet.g.alchemy.com/v2/KEY"
        ));
        assert!(!same_endpoint(
            "http://127.0.0.1:8545",
            "ws://127.0.0.1:9999"
        ));
        assert!(!same_endpoint("not a url", "ws://x.example"));
        assert!(!same_endpoint("", "ws://x.example"));
    }

    #[test]
    fn authority_ignores_credentials_and_case_but_keeps_port() {
        assert_eq!(
            authority("https://user:pass@Host.Example/v2/key").as_deref(),
            Some("host.example")
        );
        assert_eq!(
            authority("wss://x.example:9999/path").as_deref(),
            Some("x.example:9999")
        );
        assert_eq!(authority("https:///path"), None);
        assert_eq!(authority("plain text"), None);
    }

    /// The whole point of the pin is that it identifies *one* block, so the
    /// hash must be what the reads use whenever the node provides one.
    #[test]
    fn pin_reads_by_hash_when_the_node_gives_one() {
        let hash = B256::repeat_byte(0x7d);
        let pin = Pin::from_header(1234, Some(hash), 99, Some(5));
        assert_eq!(pin.id(), BlockId::Hash(hash.into()));

        // A node that withholds the hash still gets a fixed block, not a tag.
        let unhashed = Pin::from_header(1234, None, 99, None);
        assert_eq!(unhashed.id(), BlockId::number(1234));
    }

    /// A scan that pins block N and then sees head move must report the
    /// distance honestly — and a head that goes *backwards* (a re-org, or a
    /// node falling behind) must not underflow or panic.
    /// A re-orged block keeps its number but loses its hash.
    #[test]
    fn pin_detects_a_superseded_block() {
        let hash = B256::repeat_byte(0x11);
        let pin = Pin::from_header(100, Some(hash), 10, None);
        assert!(
            !pin.is_superseded_by(Some(hash)),
            "same hash is the same block"
        );
        assert!(
            pin.is_superseded_by(Some(B256::repeat_byte(0x22))),
            "a different hash at the same number is a re-org"
        );
        // Unknown is not evidence of a re-org, and must not be reported as one.
        assert!(!pin.is_superseded_by(None));
        // A number-only pin cannot detect anything.
        assert!(!Pin::from_header(100, None, 10, None).is_superseded_by(Some(hash)));
    }

    #[test]
    fn pin_drift_saturates_and_counts_forward() {
        let pin = Pin::from_header(100, Some(B256::ZERO), 10, None);
        assert_eq!(pin.blocks_behind(100), 0);
        assert_eq!(pin.blocks_behind(101), 1);
        assert_eq!(pin.blocks_behind(u64::MAX), u64::MAX - 100);
        assert_eq!(
            pin.blocks_behind(99),
            0,
            "a head behind the pin is not negative drift"
        );
    }
}

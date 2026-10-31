use alloy::eips::BlockId;
use alloy::network::TransactionBuilder;
use alloy::primitives::{Address, Bytes, U256};
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

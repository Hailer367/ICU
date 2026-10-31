use alloy::eips::BlockId;
use alloy::primitives::{Address, Bytes, U256};
use alloy::sol_types::SolCall;
use anyhow::{Context, Result, bail};
use futures_util::StreamExt;
use tracing::warn;

use crate::abi::{aerodrome_router, multicall3, slipstream_quoter, univ2_router, univ3_quoter};
use crate::chain::{self, ChainProvider};
use crate::config::{Manifest, base};
use crate::routes::{Route, RouteStep, Venue};

/// Encode a single venue quote call.
pub fn encode_quote_call(
    manifest: &Manifest,
    step: &RouteStep,
    amount_in: U256,
) -> Result<(Address, Bytes)> {
    if amount_in == U256::ZERO {
        bail!("quote amount is zero");
    }

    let (target, data) = match step.venue {
        Venue::UniV2 => {
            let router = manifest.router("univ2").unwrap_or(base::UNIV2_ROUTER);
            let call = univ2_router::getAmountsOutCall {
                amountIn: amount_in,
                path: vec![step.token_in, step.token_out],
            };
            (router, call.abi_encode())
        }
        Venue::UniV3 { fee } => {
            let call = univ3_quoter::quoteExactInputSingleCall {
                params: univ3_quoter::QuoteExactInputSingleParams {
                    tokenIn: step.token_in,
                    tokenOut: step.token_out,
                    amountIn: amount_in,
                    fee: alloy::primitives::aliases::U24::try_from(fee)
                        .context("fee does not fit in uint24")?,
                    sqrtPriceLimitX96: alloy::primitives::aliases::U160::ZERO,
                },
            };
            (base::UNIV3_QUOTER, call.abi_encode())
        }
        Venue::Aerodrome { stable } => {
            let router = manifest
                .router("aerodrome")
                .unwrap_or(base::AERODROME_ROUTER);
            let call = aerodrome_router::getAmountsOutCall {
                amountIn: amount_in,
                routes: vec![aerodrome_router::Route {
                    from: step.token_in,
                    to: step.token_out,
                    stable,
                    factory: Address::ZERO,
                }],
            };
            (router, call.abi_encode())
        }
        Venue::Slipstream { tick_spacing } => {
            let call = slipstream_quoter::quoteExactInputSingleCall {
                params: slipstream_quoter::QuoteExactInputSingleParams {
                    tokenIn: step.token_in,
                    tokenOut: step.token_out,
                    amountIn: amount_in,
                    tickSpacing: alloy::primitives::aliases::I24::try_from(tick_spacing)
                        .context("tick spacing does not fit in int24")?,
                    sqrtPriceLimitX96: alloy::primitives::aliases::U160::ZERO,
                },
            };
            (base::SLIPSTREAM_QUOTER, call.abi_encode())
        }
    };
    Ok((target, Bytes::from(data)))
}

/// Decode the return data of a venue quote call.
pub fn decode_quote_result(venue: Venue, data: &[u8]) -> Result<U256> {
    let amount_out = match venue {
        Venue::UniV2 | Venue::Aerodrome { .. } => {
            let words = decode_uint_array(data)?;
            *words
                .last()
                .context("quote returned an empty amount array")?
        }
        Venue::UniV3 { .. } => {
            let decoded = univ3_quoter::quoteExactInputSingleCall::abi_decode_returns(data)
                .context("failed to decode UniV3 quote")?;
            decoded.amountOut
        }
        Venue::Slipstream { .. } => {
            let decoded = slipstream_quoter::quoteExactInputSingleCall::abi_decode_returns(data)
                .context("failed to decode Slipstream quote")?;
            decoded.amountOut
        }
    };
    Ok(amount_out)
}

/// Quote a single route leg.
pub async fn quote_step(
    provider: &ChainProvider,
    manifest: &Manifest,
    step: &RouteStep,
    amount_in: U256,
    block: BlockId,
) -> Result<U256> {
    let (target, data) = encode_quote_call(manifest, step, amount_in)?;
    let result = chain::eth_call(provider, target, data, block)
        .await
        .map_err(|e| anyhow::anyhow!("quote call to {target} failed: {e}"))?;
    let amount_out = decode_quote_result(step.venue, &result)?;
    if amount_out == U256::ZERO {
        bail!("quote returned zero output for {}", step.venue.label());
    }
    Ok(amount_out)
}

/// Quote a route sequentially: the output of leg i is the input of leg i+1.
pub async fn quote_route(
    provider: &ChainProvider,
    manifest: &Manifest,
    route: &Route,
    amount_in: U256,
    block: BlockId,
) -> Result<Vec<U256>> {
    let mut amounts = Vec::with_capacity(route.steps.len() + 1);
    amounts.push(amount_in);
    for step in &route.steps {
        let input = *amounts.last().expect("amounts is non-empty");
        let output = quote_step(provider, manifest, step, input, block).await?;
        amounts.push(output);
    }
    Ok(amounts)
}

/// One quote request inside a batch.
#[derive(Debug, Clone)]
pub struct QuoteRequest {
    pub venue: Venue,
    pub target: Address,
    pub data: Bytes,
}

impl QuoteRequest {
    pub fn new(manifest: &Manifest, step: &RouteStep, amount_in: U256) -> Result<Self> {
        let (target, data) = encode_quote_call(manifest, step, amount_in)?;
        Ok(Self {
            venue: step.venue,
            target,
            data,
        })
    }
}

/// Quote many independent legs in as few `eth_call`s as possible.
///
/// Uses Multicall3 `aggregate3` with `allowFailure = true`, so one bad pool
/// does not discard the rest of the batch. Results are returned in input order.
///
/// Chunks are executed concurrently. Merged probe/refine rounds can carry
/// hundreds of independent legs (routes x amounts, deduped), so the old
/// serialisation of even four RPC round-trips was a measurable part of scan
/// latency.
pub async fn quote_batch(
    provider: &ChainProvider,
    requests: &[QuoteRequest],
    block: BlockId,
) -> Vec<std::result::Result<U256, String>> {
    const CHUNK: usize = 80;
    // Merged probe/refine batches are ~3-5x larger than the old per-amount
    // rounds, so one more in-flight chunk helps; raise further only if the
    // target RPC tolerates it (watch for the whole-chunk warning below).
    const CONCURRENCY: usize = 4;

    let chunks: Vec<&[QuoteRequest]> = requests.chunks(CHUNK).collect();
    let mut by_chunk: Vec<(usize, Vec<std::result::Result<U256, String>>)> =
        futures_util::stream::iter(chunks.into_iter().enumerate())
            .map(|(index, chunk)| async move {
                let results = quote_chunk(provider, chunk, block).await;
                (index, results)
            })
            .buffer_unordered(CONCURRENCY)
            .collect()
            .await;
    by_chunk.sort_by_key(|(index, _)| *index);

    let mut results = Vec::with_capacity(requests.len());
    for (_, mut chunk_results) in by_chunk {
        results.append(&mut chunk_results);
    }
    results
}

async fn quote_chunk(
    provider: &ChainProvider,
    chunk: &[QuoteRequest],
    block: BlockId,
) -> Vec<std::result::Result<U256, String>> {
    let mut results: Vec<std::result::Result<U256, String>> = Vec::with_capacity(chunk.len());
    let calls: Vec<multicall3::Call3> = chunk
        .iter()
        .map(|request| multicall3::Call3 {
            target: request.target,
            allowFailure: true,
            callData: request.data.clone(),
        })
        .collect();
    let call = multicall3::aggregate3Call { calls };
    let bytes =
        match chain::eth_call(provider, base::MULTICALL3, call.abi_encode().into(), block).await {
            Ok(bytes) => bytes,
            Err(err) => {
                // A whole chunk lost to transport/limit failure must not look
                // like "no opportunity": every quote in it reports failure.
                warn!(error = %err, requests = chunk.len(), "multicall chunk failed");
                let message = format!("multicall failed: {err}");
                results.extend(chunk.iter().map(|_| Err(message.clone())));
                return results;
            }
        };

    let decoded = match multicall3::aggregate3Call::abi_decode_returns(&bytes) {
        Ok(decoded) => decoded,
        Err(err) => {
            let message = format!("failed to decode multicall result: {err}");
            results.extend(chunk.iter().map(|_| Err(message.clone())));
            return results;
        }
    };

    if decoded.len() != chunk.len() {
        let message = format!(
            "multicall returned {} results for {} calls",
            decoded.len(),
            chunk.len()
        );
        results.extend(chunk.iter().map(|_| Err(message.clone())));
        return results;
    }

    for (request, result) in chunk.iter().zip(decoded.iter()) {
        if !result.success {
            let decoded_err = crate::errors::decode(&result.returnData);
            results.push(Err(format!(
                "{} quote reverted: {decoded_err}",
                request.venue.label()
            )));
            continue;
        }
        match decode_quote_result(request.venue, &result.returnData) {
            Ok(amount) if amount > U256::ZERO => results.push(Ok(amount)),
            Ok(_) => results.push(Err(format!(
                "{} quote returned zero",
                request.venue.label()
            ))),
            Err(err) => results.push(Err(format!(
                "{} quote decode failed: {err}",
                request.venue.label()
            ))),
        }
    }
    results
}

/// Decode a Solidity `uint256[]` return value.
fn decode_uint_array(data: &[u8]) -> Result<Vec<U256>> {
    if data.len() < 64 {
        bail!("return data too short for uint256[]");
    }
    let offset = U256::from_be_slice(&data[0..32]);
    let offset: usize = offset.try_into().context("array offset overflow")?;
    if data.len() < offset + 32 {
        bail!("return data too short for array length");
    }
    let len: usize = U256::from_be_slice(&data[offset..offset + 32])
        .try_into()
        .context("array length overflow")?;
    let start = offset + 32;
    let end = start.checked_add(len * 32).context("array size overflow")?;
    if data.len() < end {
        bail!("return data too short for array elements");
    }
    let mut values = Vec::with_capacity(len);
    for i in 0..len {
        values.push(U256::from_be_slice(
            &data[start + i * 32..start + (i + 1) * 32],
        ));
    }
    Ok(values)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn decodes_uint_array() {
        let mut data = Vec::new();
        data.extend_from_slice(&U256::from(32u64).to_be_bytes::<32>());
        data.extend_from_slice(&U256::from(2u64).to_be_bytes::<32>());
        data.extend_from_slice(&U256::from(100u64).to_be_bytes::<32>());
        data.extend_from_slice(&U256::from(200u64).to_be_bytes::<32>());
        assert_eq!(
            decode_uint_array(&data).unwrap(),
            vec![U256::from(100), U256::from(200)]
        );
    }

    #[test]
    fn rejects_short_array() {
        assert!(decode_uint_array(&[0u8; 10]).is_err());
    }
}

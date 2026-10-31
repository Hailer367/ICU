use alloy::eips::{BlockId, BlockNumberOrTag};
use alloy::primitives::{Address, I256, U256};
use alloy::providers::Provider;
use alloy::sol_types::SolCall;
use anyhow::{Context, Result, bail};

use crate::abi::{chainlink, gas_oracle};
use crate::chain::{self, ChainProvider};
use crate::config::base;

#[derive(Debug, Clone)]
pub struct GasSnapshot {
    pub block_number: u64,
    /// Timestamp of the block the snapshot was read from. Used as "now" for
    /// feed staleness so historical forks are judged against chain time.
    pub timestamp: u64,
    pub base_fee: U256,
    pub priority_fee: U256,
    pub gas_price: U256,
    pub l1_base_fee: U256,
    pub blob_base_fee: U256,
    pub l1_fee_upper_bound: U256,
}

/// Read the fee market: one latest-block fetch, `eth_gasPrice`,
/// `eth_maxPriorityFeePerGas`, and the three GasPriceOracle reads as one
/// Multicall3 batch — all four groups run concurrently. The previous version
/// issued seven sequential round-trips.
pub async fn snapshot(provider: &ChainProvider, tx_size: usize) -> Result<GasSnapshot> {
    use alloy::primitives::Bytes;
    use alloy::sol_types::SolCall;

    let oracle_calls: Vec<(Address, Bytes)> = vec![
        (
            base::GAS_PRICE_ORACLE,
            gas_oracle::l1BaseFeeCall {}.abi_encode().into(),
        ),
        (
            base::GAS_PRICE_ORACLE,
            gas_oracle::blobBaseFeeCall {}.abi_encode().into(),
        ),
        (
            base::GAS_PRICE_ORACLE,
            gas_oracle::getL1FeeUpperBoundCall {
                unsignedTxSize: U256::from(tx_size),
            }
            .abi_encode()
            .into(),
        ),
    ];

    let (block_result, gas_price_result, priority_result, oracle_result) = tokio::join!(
        provider.get_block_by_number(BlockNumberOrTag::Latest),
        chain::gas_price(provider),
        provider.get_max_priority_fee_per_gas(),
        chain::multicall_raw(provider, &oracle_calls, BlockId::latest()),
    );

    let block = block_result
        .context("failed to read latest block")?
        .context("latest block not found")?;
    let gas_price = U256::from(gas_price_result.context("failed to read eth_gasPrice")?);
    let priority_fee =
        U256::from(priority_result.context("failed to read eth_maxPriorityFeePerGas")?);

    // Oracle reads keep the old per-call tolerance: a failed component falls
    // back to zero rather than blocking the scan.
    let oracle_value = |index: usize, decoded: fn(&Bytes) -> Option<U256>| -> U256 {
        oracle_result
            .get(index)
            .and_then(|data| data.as_ref().ok())
            .and_then(decoded)
            .unwrap_or(U256::ZERO)
    };
    let l1_base_fee = oracle_value(0, |data| {
        gas_oracle::l1BaseFeeCall::abi_decode_returns(data).ok()
    });
    let blob_base_fee = oracle_value(1, |data| {
        gas_oracle::blobBaseFeeCall::abi_decode_returns(data).ok()
    });
    let l1_fee_upper_bound = oracle_value(2, |data| {
        gas_oracle::getL1FeeUpperBoundCall::abi_decode_returns(data).ok()
    });

    Ok(GasSnapshot {
        block_number: block.header.number,
        timestamp: block.header.timestamp,
        base_fee: U256::from(block.header.base_fee_per_gas.unwrap_or(0)),
        priority_fee,
        gas_price,
        l1_base_fee,
        blob_base_fee,
        l1_fee_upper_bound,
    })
}

/// Latest block timestamp, for callers that need chain time without a full
/// gas snapshot.
pub async fn latest_timestamp(provider: &ChainProvider) -> Result<u64> {
    let block = provider
        .get_block_by_number(BlockNumberOrTag::Latest)
        .await
        .context("failed to read latest block")?
        .context("latest block not found")?;
    Ok(block.header.timestamp)
}

/// A feed is stale when the chain is more than `max_age_secs` past its last
/// update. Comparing two chain timestamps keeps historical forks usable.
pub fn is_stale(updated_at: u64, now: u64, max_age_secs: u64) -> bool {
    now > updated_at.saturating_add(max_age_secs)
}

pub async fn chainlink_price(
    provider: &ChainProvider,
    feed: Address,
    max_age_secs: u64,
    now_secs: u64,
) -> Result<f64> {
    let data = chainlink::latestRoundDataCall {}.abi_encode().into();
    let bytes = chain::eth_call(provider, feed, data, BlockId::latest())
        .await
        .map_err(|e| anyhow::anyhow!("latestRoundData failed: {e}"))?;
    let result = chainlink::latestRoundDataCall::abi_decode_returns(&bytes)
        .context("failed to decode latestRoundData")?;
    if result.answer <= I256::ZERO {
        bail!("Chainlink feed {feed} returned a non-positive answer");
    }
    let updated_at: u64 = result.updatedAt.try_into().unwrap_or(0);
    if is_stale(updated_at, now_secs, max_age_secs) {
        bail!("Chainlink feed {feed} is stale: updatedAt={updated_at}, now={now_secs}");
    }

    let decimals = call_u8(
        provider,
        feed,
        chainlink::decimalsCall {}.abi_encode().into(),
    )
    .await?;
    let answer: f64 = result
        .answer
        .to_string()
        .parse()
        .context("answer is not a number")?;
    Ok(answer / 10f64.powi(decimals as i32))
}

async fn call_u8(
    provider: &ChainProvider,
    to: Address,
    data: alloy::primitives::Bytes,
) -> Result<u8> {
    let bytes = chain::eth_call(provider, to, data, BlockId::latest())
        .await
        .map_err(|e| anyhow::anyhow!("call failed: {e}"))?;
    Ok(bytes.last().copied().unwrap_or(0))
}

/// Resolve a token's USD feed and staleness tolerance.
///
/// Stablecoin feeds on Base are intentionally slow; a day-old answer is still
/// a valid peg check. AERO is intentionally unsupported until a feed is
/// verified.
pub fn usd_feed_for_asset(asset: Address) -> Option<(Address, u64)> {
    if asset == base::USDC {
        Some((base::USDC_USD_FEED, 86_400))
    } else if asset == base::WETH {
        Some((base::ETH_USD_FEED, 7_200))
    } else if asset == base::CBBTC {
        Some((base::BTC_USD_FEED, 7_200))
    } else if asset == base::EURC {
        Some((base::EUR_USD_FEED, 86_400))
    } else {
        None
    }
}

/// Decode a `latestRoundData` return with the same bails as
/// [`chainlink_price`], but with pre-fetched decimals instead of a second
/// round-trip. Pure so the staleness and sign gates are unit-testable.
pub fn feed_price_from_round(
    feed: Address,
    data: &[u8],
    max_age_secs: u64,
    now_secs: u64,
    decimals: u8,
) -> Result<f64> {
    let result = chainlink::latestRoundDataCall::abi_decode_returns(data)
        .context("failed to decode latestRoundData")?;
    if result.answer <= I256::ZERO {
        bail!("Chainlink feed {feed} returned a non-positive answer");
    }
    let updated_at: u64 = result.updatedAt.try_into().unwrap_or(0);
    if is_stale(updated_at, now_secs, max_age_secs) {
        bail!("Chainlink feed {feed} is stale: updatedAt={updated_at}, now={now_secs}");
    }
    let answer: f64 = result
        .answer
        .to_string()
        .parse()
        .context("answer is not a number")?;
    Ok(answer / 10f64.powi(decimals as i32))
}

/// Read many Chainlink feeds through one Multicall3 batch.
///
/// `requests` are deduplicated `(feed, max_age_secs)` pairs; `decimals` must
/// contain every feed (see `Scanner::ensure_feed_decimals`). Each feed maps to
/// its price or the reason it is unusable, so one stale feed cannot poison
/// the others.
pub async fn feed_prices(
    provider: &ChainProvider,
    requests: &[(Address, u64)],
    now_secs: u64,
    decimals: &std::collections::HashMap<Address, u8>,
) -> std::collections::HashMap<Address, std::result::Result<f64, String>> {
    use alloy::sol_types::SolCall;
    let calls: Vec<(Address, alloy::primitives::Bytes)> = requests
        .iter()
        .map(|(feed, _)| (*feed, chainlink::latestRoundDataCall {}.abi_encode().into()))
        .collect();
    let raw = chain::multicall_raw(provider, &calls, BlockId::latest()).await;
    requests
        .iter()
        .zip(raw)
        .map(|((feed, max_age), data)| {
            let price = match data {
                Ok(data) => match decimals.get(feed) {
                    Some(decimals) => {
                        feed_price_from_round(*feed, &data, *max_age, now_secs, *decimals)
                            .map_err(|err| err.to_string())
                    }
                    None => Err(format!("Chainlink feed {feed} decimals are unknown")),
                },
                Err(reason) => Err(reason),
            };
            (*feed, price)
        })
        .collect()
}

/// Resolve a token's USD price from the verified Base Chainlink feeds.
pub async fn asset_usd_price(
    provider: &ChainProvider,
    asset: Address,
    now_secs: u64,
) -> Result<f64> {
    let (feed, max_age) = usd_feed_for_asset(asset)
        .with_context(|| format!("no verified USD feed for asset {asset}"))?;
    chainlink_price(provider, feed, max_age, now_secs).await
}

pub async fn eth_usd_price(provider: &ChainProvider, now_secs: u64) -> Result<f64> {
    chainlink_price(provider, base::ETH_USD_FEED, 7_200, now_secs).await
}

pub fn raw_to_f64(value: U256, decimals: u8) -> f64 {
    value.to_string().parse::<f64>().unwrap_or(0.0) / 10f64.powi(decimals as i32)
}

pub fn wei_to_eth(value: U256) -> f64 {
    value.to_string().parse::<f64>().unwrap_or(0.0) / 1e18
}

#[derive(Debug, Clone, Copy)]
pub struct TradeCost {
    pub l2_fee_wei: U256,
    pub l1_fee_wei: U256,
    pub total_fee_wei: U256,
    pub total_fee_usd: f64,
}

pub fn trade_cost(
    gas_used: u64,
    effective_gas_price: U256,
    l1_fee_wei: U256,
    eth_usd: f64,
) -> TradeCost {
    let l2_fee_wei = U256::from(gas_used) * effective_gas_price;
    let total_fee_wei = l2_fee_wei.saturating_add(l1_fee_wei);
    let total_fee_usd = wei_to_eth(total_fee_wei) * eth_usd;
    TradeCost {
        l2_fee_wei,
        l1_fee_wei,
        total_fee_wei,
        total_fee_usd,
    }
}

pub fn profit_usd(profit_raw: U256, asset_decimals: u8, asset_usd: f64) -> f64 {
    raw_to_f64(profit_raw, asset_decimals) * asset_usd
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn converts_raw_units() {
        assert!((raw_to_f64(U256::from(1_000_000u64), 6) - 1.0).abs() < 1e-12);
        assert!((raw_to_f64(U256::from(1_000_000_000_000_000_000u64), 18) - 1.0).abs() < 1e-12);
    }

    #[test]
    fn staleness_uses_the_supplied_chain_time() {
        assert!(!is_stale(1_000, 1_000, 7_200));
        assert!(!is_stale(1_000, 8_200, 7_200));
        assert!(is_stale(1_000, 8_201, 7_200));
        // A fresh chain timestamp keeps an old feed usable.
        assert!(!is_stale(1_000_000, 1_000_600, 7_200));
    }

    #[test]
    fn computes_trade_cost() {
        let cost = trade_cost(
            100_000,
            U256::from(1_000_000_000u64),
            U256::from(2_000_000_000_000u64),
            3_000.0,
        );
        assert_eq!(cost.l2_fee_wei, U256::from(100_000u128 * 1_000_000_000u128));
        assert!(cost.total_fee_usd > 0.0);
    }

    #[test]
    fn maps_assets_to_verified_feeds() {
        assert_eq!(
            usd_feed_for_asset(base::USDC),
            Some((base::USDC_USD_FEED, 86_400))
        );
        assert_eq!(
            usd_feed_for_asset(base::WETH),
            Some((base::ETH_USD_FEED, 7_200))
        );
        assert_eq!(
            usd_feed_for_asset(base::CBBTC),
            Some((base::BTC_USD_FEED, 7_200))
        );
        assert_eq!(
            usd_feed_for_asset(base::EURC),
            Some((base::EUR_USD_FEED, 86_400))
        );
        assert_eq!(usd_feed_for_asset(base::AERO), None);
    }

    fn round_data(answer: i64, updated_at: u64) -> Vec<u8> {
        use alloy::primitives::aliases::U80;
        use alloy::sol_types::SolValue;
        (
            U80::from(1u64),
            I256::unchecked_from(answer),
            U256::from(updated_at),
            U256::from(updated_at),
            U80::from(1u64),
        )
            .abi_encode()
    }

    #[test]
    fn feed_price_accepts_fresh_positive_round() {
        let feed = Address::repeat_byte(0x11);
        let data = round_data(2_274_500_000_000, 1_000);
        let price = feed_price_from_round(feed, &data, 7_200, 1_000, 8).unwrap();
        assert!((price - 22_745.0).abs() < 1e-6, "got {price}");
    }

    #[test]
    fn feed_price_rejects_stale_and_nonpositive() {
        let feed = Address::repeat_byte(0x11);
        let fresh = round_data(1_000, 1_000);
        // Chain time 7_201 s past a 7_200 s window: stale.
        assert!(feed_price_from_round(feed, &fresh, 7_200, 8_201, 8).is_err());
        let zero = round_data(0, 1_000);
        assert!(feed_price_from_round(feed, &zero, 7_200, 1_000, 8).is_err());
        let negative = round_data(-1, 1_000);
        assert!(feed_price_from_round(feed, &negative, 7_200, 1_000, 8).is_err());
    }

    #[test]
    fn feed_price_applies_the_supplied_decimals() {
        // The batch path passes cached decimals instead of re-reading them;
        // the scale must come from the argument.
        let feed = Address::repeat_byte(0x22);
        let data = round_data(1_000_000, 1_000);
        let six = feed_price_from_round(feed, &data, 86_400, 1_000, 6).unwrap();
        let eight = feed_price_from_round(feed, &data, 86_400, 1_000, 8).unwrap();
        assert!((six - 1.0).abs() < 1e-12, "got {six}");
        assert!((eight - 0.01).abs() < 1e-12, "got {eight}");
    }
}

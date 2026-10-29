use std::time::{SystemTime, UNIX_EPOCH};

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
    pub base_fee: U256,
    pub priority_fee: U256,
    pub gas_price: U256,
    pub l1_base_fee: U256,
    pub blob_base_fee: U256,
    pub l1_fee_upper_bound: U256,
}

pub async fn snapshot(provider: &ChainProvider, tx_size: usize) -> Result<GasSnapshot> {
    let block_number = chain::block_number(provider).await?;
    let gas_price = U256::from(chain::gas_price(provider).await?);
    let priority_fee = U256::from(
        provider
            .get_max_priority_fee_per_gas()
            .await
            .context("failed to read eth_maxPriorityFeePerGas")?,
    );
    let block = provider
        .get_block_by_number(BlockNumberOrTag::Latest)
        .await
        .context("failed to read latest block")?
        .context("latest block not found")?;
    let base_fee = U256::from(block.header.base_fee_per_gas.unwrap_or(0));

    let l1_base_fee = call_u256(
        provider,
        base::GAS_PRICE_ORACLE,
        gas_oracle::l1BaseFeeCall {}.abi_encode().into(),
    )
    .await
    .unwrap_or(U256::ZERO);
    let blob_base_fee = call_u256(
        provider,
        base::GAS_PRICE_ORACLE,
        gas_oracle::blobBaseFeeCall {}.abi_encode().into(),
    )
    .await
    .unwrap_or(U256::ZERO);
    let l1_fee_upper_bound = call_u256(
        provider,
        base::GAS_PRICE_ORACLE,
        gas_oracle::getL1FeeUpperBoundCall {
            unsignedTxSize: U256::from(tx_size),
        }
        .abi_encode()
        .into(),
    )
    .await
    .unwrap_or(U256::ZERO);

    Ok(GasSnapshot {
        block_number,
        base_fee,
        priority_fee,
        gas_price,
        l1_base_fee,
        blob_base_fee,
        l1_fee_upper_bound,
    })
}

async fn call_u256(
    provider: &ChainProvider,
    to: Address,
    data: alloy::primitives::Bytes,
) -> Result<U256> {
    let bytes = chain::eth_call(provider, to, data, BlockId::latest())
        .await
        .map_err(|e| anyhow::anyhow!("call failed: {e}"))?;
    let value = U256::from_be_slice(&bytes);
    Ok(value)
}

pub async fn chainlink_price(
    provider: &ChainProvider,
    feed: Address,
    max_age_secs: u64,
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
    let now = SystemTime::now().duration_since(UNIX_EPOCH)?.as_secs();
    if now > updated_at.saturating_add(max_age_secs) {
        bail!("Chainlink feed {feed} is stale: updatedAt={updated_at}, now={now}");
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

/// Resolve a token's USD price from the verified Base Chainlink feeds.
///
/// AERO is intentionally unsupported until a feed is verified.
pub async fn asset_usd_price(provider: &ChainProvider, asset: Address) -> Result<f64> {
    let (feed, max_age) = if asset == base::USDC {
        // Stablecoin feeds on Base are intentionally slow; a day-old answer is
        // still a valid peg check.
        (base::USDC_USD_FEED, 86_400)
    } else if asset == base::WETH {
        (base::ETH_USD_FEED, 7_200)
    } else if asset == base::CBBTC {
        (base::BTC_USD_FEED, 7_200)
    } else if asset == base::EURC {
        (base::EUR_USD_FEED, 86_400)
    } else {
        bail!("no verified USD feed for asset {asset}");
    };
    chainlink_price(provider, feed, max_age).await
}

pub async fn eth_usd_price(provider: &ChainProvider) -> Result<f64> {
    chainlink_price(provider, base::ETH_USD_FEED, 7_200).await
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
}

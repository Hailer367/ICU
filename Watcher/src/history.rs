//! Historical `Swap` log downloader.
//!
//! Writes one JSON object per swap so a run can be replayed or mined for
//! interesting blocks. This only reads logs: replaying a block still needs
//! historical state (pin an Anvil fork at that block and deploy the core).
//!
//! Uniswap V3 and Slipstream pools use the concentrated-liquidity `Swap`
//! event; Uniswap V2 and Aerodrome pools use different four-word `Swap`
//! signatures, so both topics are queried for the constant-product group.
//! Amounts are normalized to signed pool-balance deltas either way.

use std::collections::BTreeMap;
use std::io::Write;
use std::path::Path;
use std::time::Duration;

use alloy::eips::BlockNumberOrTag;
use alloy::primitives::{Address, B256, I256, U256, keccak256};
use alloy::providers::Provider;
use alloy::rpc::types::{Filter, Log};
use anyhow::{Context, Result, bail};
use serde::Serialize;
use tracing::{info, warn};

use crate::chain::ChainProvider;
use crate::routes::{Pool, Registry, Venue};

const SWAP_V3_SIG: &str = "Swap(address,address,int256,int256,uint160,uint128,int24)";
const SWAP_V2_SIG: &str = "Swap(address,uint256,uint256,uint256,uint256,address)";
const SWAP_SOLIDLY_SIG: &str = "Swap(address,address,uint256,uint256,uint256,uint256)";

#[derive(Debug, Clone, Serialize)]
pub struct SwapRecord {
    pub block: u64,
    #[serde(skip_serializing_if = "Option::is_none")]
    pub timestamp: Option<u64>,
    #[serde(skip_serializing_if = "Option::is_none")]
    pub tx_hash: Option<String>,
    pub log_index: u64,
    pub pool: String,
    pub venue: String,
    pub sender: String,
    pub recipient: String,
    /// Pool balance delta for token0: positive when the pool received it.
    /// Concentrated-liquidity events carry this directly; constant-product
    /// events (Uniswap V2 and Solidly/Aerodrome) are normalized as
    /// `amountIn - amountOut`.
    pub amount0: String,
    /// Pool balance delta for token1, with the same sign convention.
    pub amount1: String,
    #[serde(skip_serializing_if = "Option::is_none")]
    pub sqrt_price_x96: Option<String>,
    #[serde(skip_serializing_if = "Option::is_none")]
    pub liquidity: Option<String>,
    #[serde(skip_serializing_if = "Option::is_none")]
    pub tick: Option<i64>,
}

#[derive(Debug, Default)]
pub struct HistorySummary {
    pub from_block: u64,
    pub to_block: u64,
    pub total: usize,
    pub per_venue: BTreeMap<String, usize>,
    pub bytes: u64,
}

struct Group {
    topics: Vec<B256>,
    addresses: Vec<Address>,
    concentrated: bool,
}

fn groups(registry: &Registry) -> Vec<Group> {
    let mut concentrated = Vec::new();
    let mut constant_product = Vec::new();
    for pool in &registry.pools {
        match pool.venue {
            Venue::UniV3 { .. } | Venue::Slipstream { .. } => concentrated.push(pool.address),
            Venue::UniV2 | Venue::Aerodrome { .. } => constant_product.push(pool.address),
        }
    }
    vec![
        Group {
            topics: vec![keccak256(SWAP_V3_SIG.as_bytes())],
            addresses: concentrated,
            concentrated: true,
        },
        Group {
            // Uniswap V2 and Solidly-style (Aerodrome) pools both carry four
            // amount words but use different event signatures.
            topics: vec![
                keccak256(SWAP_V2_SIG.as_bytes()),
                keccak256(SWAP_SOLIDLY_SIG.as_bytes()),
            ],
            addresses: constant_product,
            concentrated: false,
        },
    ]
    .into_iter()
    .filter(|group| !group.addresses.is_empty())
    .collect()
}

fn topic_address(topic: &B256) -> Address {
    Address::from_slice(&topic[12..])
}

fn word(data: &[u8], index: usize) -> Option<U256> {
    let start = index * 32;
    let end = start + 32;
    data.get(start..end).map(U256::from_be_slice)
}

fn int_word(data: &[u8], index: usize) -> Option<I256> {
    word(data, index).map(I256::from_raw)
}

/// Decode one swap log into a record. Returns `None` for a pool or payload
/// shape the registry does not recognise.
pub fn decode_swap(log: &Log, concentrated: bool, registry: &Registry) -> Option<SwapRecord> {
    let pool: &Pool = registry.pools.iter().find(|p| p.address == log.address())?;
    let topics = log.topics();
    let sender = topics.get(1).map(topic_address).unwrap_or(Address::ZERO);
    let recipient = topics.get(2).map(topic_address).unwrap_or(Address::ZERO);
    let data = &log.data().data;

    let (amount0, amount1, sqrt_price_x96, liquidity, tick) = if concentrated {
        if data.len() < 160 {
            return None;
        }
        let tick = i24_from_word(word(data, 4)?);
        (
            int_word(data, 0)?.to_string(),
            int_word(data, 1)?.to_string(),
            Some(word(data, 2)?.to_string()),
            Some(word(data, 3)?.to_string()),
            Some(tick),
        )
    } else {
        if data.len() < 128 {
            return None;
        }
        // Constant-product events carry amount0In, amount1In, amount0Out,
        // amount1Out. Normalize to the V3 convention: the pool's balance delta
        // for the token, positive when the pool received it.
        (
            signed_delta(word(data, 0)?, word(data, 2)?),
            signed_delta(word(data, 1)?, word(data, 3)?),
            None,
            None,
            None,
        )
    };

    Some(SwapRecord {
        block: log.block_number?,
        timestamp: log.block_timestamp,
        tx_hash: log.transaction_hash.map(|hash| hash.to_string()),
        log_index: log.log_index.unwrap_or(0),
        pool: log.address().to_string(),
        venue: pool.venue.label(),
        sender: sender.to_string(),
        recipient: recipient.to_string(),
        amount0,
        amount1,
        sqrt_price_x96,
        liquidity,
        tick,
    })
}

fn signed_delta(input: U256, output: U256) -> String {
    let delta = I256::try_from(input)
        .ok()
        .zip(I256::try_from(output).ok())
        .map(|(input, output)| input - output);
    delta
        .map(|value| value.to_string())
        .unwrap_or_else(|| "0".to_string())
}

/// Interpret the low three bytes of a two's-complement int24 word.
fn i24_from_word(value: U256) -> i64 {
    let raw = (value & U256::from(0xff_ffffu32)).to::<u32>();
    let signed = if raw & 0x80_0000 != 0 {
        (raw | 0xff00_0000) as i32
    } else {
        raw as i32
    };
    signed as i64
}

async fn fetch_segment(
    provider: &ChainProvider,
    group: &Group,
    from: u64,
    to: u64,
    depth: u8,
) -> Result<Vec<Log>> {
    if from > to {
        return Ok(Vec::new());
    }
    let filter = Filter::new()
        .address(group.addresses.clone())
        .event_signature(group.topics.clone())
        .from_block(BlockNumberOrTag::Number(from))
        .to_block(BlockNumberOrTag::Number(to));

    match provider.get_logs(&filter).await {
        Ok(logs) => Ok(logs),
        // Public endpoints cap result size. Split the range instead of
        // failing the whole download.
        Err(err) if depth < 5 && to > from => {
            warn!(from, to, error = %err, "log query failed; splitting range");
            tokio::time::sleep(Duration::from_millis(500)).await;
            let mid = from + (to - from) / 2;
            let mut first = Box::pin(fetch_segment(provider, group, from, mid, depth + 1)).await?;
            let mut second =
                Box::pin(fetch_segment(provider, group, mid + 1, to, depth + 1)).await?;
            first.append(&mut second);
            Ok(first)
        }
        Err(err) => bail!("eth_getLogs {from}..={to} failed: {err}"),
    }
}

/// Download every swap in `from_block..=to_block` for the registry pools.
pub async fn download(
    provider: &ChainProvider,
    registry: &Registry,
    from_block: u64,
    to_block: u64,
    chunk: u64,
    out: &Path,
) -> Result<HistorySummary> {
    if from_block > to_block {
        bail!("from_block {from_block} is after to_block {to_block}");
    }
    if chunk == 0 {
        bail!("chunk must be at least 1 block");
    }
    if let Some(parent) = out.parent()
        && !parent.as_os_str().is_empty()
    {
        std::fs::create_dir_all(parent)
            .with_context(|| format!("failed to create {}", parent.display()))?;
    }

    let groups = groups(registry);
    let mut records = Vec::new();
    let mut cursor = from_block;
    while cursor <= to_block {
        let end = cursor.saturating_add(chunk - 1).min(to_block);
        for group in &groups {
            let logs = fetch_segment(provider, group, cursor, end, 0).await?;
            for log in &logs {
                if log.removed {
                    continue;
                }
                if let Some(record) = decode_swap(log, group.concentrated, registry) {
                    records.push(record);
                }
            }
            tokio::time::sleep(Duration::from_millis(120)).await;
        }
        info!(
            from = cursor,
            to = end,
            records = records.len(),
            "history chunk"
        );
        cursor = end + 1;
    }

    records.sort_by_key(|record| (record.block, record.log_index));

    let mut per_venue: BTreeMap<String, usize> = BTreeMap::new();
    for record in &records {
        *per_venue.entry(record.venue.clone()).or_default() += 1;
    }

    {
        let file = std::fs::File::create(out)
            .with_context(|| format!("failed to create {}", out.display()))?;
        let mut writer = std::io::BufWriter::new(file);
        for record in &records {
            serde_json::to_writer(&mut writer, record).context("failed to serialize swap")?;
            writer.write_all(b"\n")?;
        }
        writer.flush()?;
    }
    let bytes = std::fs::metadata(out)
        .with_context(|| format!("failed to stat {}", out.display()))?
        .len();

    Ok(HistorySummary {
        from_block,
        to_block,
        total: records.len(),
        per_venue,
        bytes,
    })
}

#[cfg(test)]
mod tests {
    use super::*;
    use serde_json::json;

    const POOL: &str = "0xd0b53D9277642d899DF5C87A3966A349A798F224";

    fn hex_word(value: &str) -> String {
        format!("{value:0>64}")
    }

    fn log_from_json(value: serde_json::Value) -> Log {
        serde_json::from_value(value).expect("log json")
    }

    #[test]
    fn decodes_v3_swap() {
        let registry = Registry::base_usdc_weth().unwrap();
        // amount0=-1000, amount1=2000, sqrtPrice=5, liquidity=10, tick=-5
        let negative = format!("{:064x}", I256::from_raw(U256::MAX - U256::from(999u64)));
        let data = format!(
            "0x{}{}{}{}{}",
            &negative[..],
            hex_word("7d0"),
            hex_word("5"),
            hex_word("a"),
            &format!("{:064x}", (-5i64 as u64) & 0xff_ffff)[..],
        );
        let log = log_from_json(json!({
            "address": POOL,
            "topics": [
                format!("{:#x}", keccak256(SWAP_V3_SIG.as_bytes())),
                "0x0000000000000000000000001111111111111111111111111111111111111111",
                "0x0000000000000000000000002222222222222222222222222222222222222222"
            ],
            "data": data,
            "blockNumber": "0x10",
            "transactionIndex": "0x0",
            "transactionHash": "0x0000000000000000000000000000000000000000000000000000000000000001",
            "logIndex": "0x2"
        }));
        let record = decode_swap(&log, true, &registry).expect("decodes");
        assert_eq!(record.block, 16);
        assert_eq!(record.amount0, "-1000");
        assert_eq!(record.amount1, "2000");
        assert_eq!(record.sqrt_price_x96.as_deref(), Some("5"));
        assert_eq!(record.liquidity.as_deref(), Some("10"));
        assert_eq!(record.tick, Some(-5));
        assert_eq!(record.venue, "univ3:500");
    }

    #[test]
    fn decodes_v2_swap() {
        let registry = Registry::base_usdc_weth().unwrap();
        // UniV2 pool address from the registry.
        let pool = registry
            .pools
            .iter()
            .find(|p| p.venue == Venue::UniV2)
            .unwrap();
        // amount0In=100, amount1In=0, amount0Out=0, amount1Out=32
        let data = format!(
            "0x{}{}{}{}",
            hex_word("64"),
            hex_word("0"),
            hex_word("0"),
            hex_word("20")
        );
        let log = log_from_json(json!({
            "address": pool.address.to_string(),
            "topics": [
                format!("{:#x}", keccak256(SWAP_V2_SIG.as_bytes())),
                "0x0000000000000000000000001111111111111111111111111111111111111111",
                "0x0000000000000000000000002222222222222222222222222222222222222222"
            ],
            "data": data,
            "blockNumber": "0x20",
            "transactionIndex": "0x1",
            "logIndex": "0x1"
        }));
        let record = decode_swap(&log, false, &registry).expect("decodes");
        assert_eq!(record.block, 32);
        assert_eq!(record.amount0, "100");
        assert_eq!(record.amount1, "-32");
        assert_eq!(record.venue, "univ2");
        assert!(record.sqrt_price_x96.is_none());
    }

    #[test]
    fn constant_product_group_covers_v2_and_solidly_topics() {
        let registry = Registry::base_usdc_weth().unwrap();
        let groups = groups(&registry);
        assert_eq!(groups.len(), 2);
        let constant = groups
            .iter()
            .find(|group| !group.concentrated)
            .expect("constant-product group");
        assert!(constant.topics.contains(&keccak256(SWAP_V2_SIG.as_bytes())));
        assert!(
            constant
                .topics
                .contains(&keccak256(SWAP_SOLIDLY_SIG.as_bytes()))
        );
        let aerodrome = registry
            .pools
            .iter()
            .find(|p| matches!(p.venue, Venue::Aerodrome { .. }))
            .expect("aerodrome pool");
        assert!(constant.addresses.contains(&aerodrome.address));
    }

    #[test]
    fn int24_sign_extension() {
        assert_eq!(i24_from_word(U256::from(5u64)), 5);
        assert_eq!(i24_from_word(U256::from(0xff_ff_fbu64)), -5);
        assert_eq!(i24_from_word(U256::from(0x7f_ffffu64)), 8_388_607);
        assert_eq!(i24_from_word(U256::from(0x80_0000u64)), -8_388_608);
    }

    #[test]
    fn ignores_unknown_pool_and_short_data() {
        let registry = Registry::base_usdc_weth().unwrap();
        let log = log_from_json(json!({
            "address": "0x0000000000000000000000000000000000000001",
            "topics": [format!("{:#x}", keccak256(SWAP_V3_SIG.as_bytes()))],
            "data": "0x",
            "blockNumber": "0x1",
            "transactionIndex": "0x0",
            "logIndex": "0x0"
        }));
        assert!(decode_swap(&log, true, &registry).is_none());
    }
}

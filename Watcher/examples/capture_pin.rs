//! Regenerate the ground-truth tables pinned in `src/amm.rs`.
//!
//! The constants in that module are `router.getAmountsOut` / `pool.getAmountOut`
//! answers read from real Base state. They are evidence only because they come
//! from *outside* this crate — never retype them by hand, re-run this against a
//! fork (or live Base) and paste the whole table, block number included:
//!
//! ```text
//! anvil --fork-url https://mainnet.base.org --chain-id 8453 --port 8545
//! cargo run --example capture_pin
//!
//! # or straight from a provider of your own
//! RYO_LIVE_RPC=https://base-mainnet.g.alchemy.com/v2/<KEY> cargo run --example capture_pin
//! ```
//!
//! Two blocks back from the head, so the reserves printed here and the quotes
//! taken from them cannot straddle a head change.

use alloy::eips::BlockId;
use alloy::primitives::U256;
use alloy::sol_types::SolCall;
use ryo_watch::abi::{aerodrome_factory, pool};
use ryo_watch::chain;
use ryo_watch::config::{Manifest, base};
use ryo_watch::routes::{Registry, RouteStep};
use ryo_watch::venues;

#[tokio::main]
async fn main() -> anyhow::Result<()> {
    let rpc = std::env::var("RYO_LIVE_RPC").unwrap_or_else(|_| "http://127.0.0.1:8545".to_string());
    let manifest_path = std::env::var("RYO_LIVE_MANIFEST")
        .unwrap_or_else(|_| "deployments/8453.anvil.json".to_string());
    let provider = chain::connect_http(&rpc).await?;
    let manifest = Manifest::load(&manifest_path)?;
    let registry = Registry::base_usdc_weth()?;
    let head = chain::block_number(&provider).await?;
    let block = BlockId::from(head - 2);
    println!("PIN_BLOCK={head} pinned={}", head - 2);
    let weth = base::WETH;
    let usdc = base::USDC;
    for (idx, entry) in registry.pools.iter().enumerate() {
        let venue = entry.venue;
        let stable = matches!(venue, ryo_watch::routes::Venue::Aerodrome { stable: true });
        if !matches!(
            venue,
            ryo_watch::routes::Venue::UniV2 | ryo_watch::routes::Venue::Aerodrome { .. }
        ) {
            continue;
        }
        let raw = chain::eth_call(
            &provider,
            entry.address,
            pool::getReservesCall {}.abi_encode().into(),
            block,
        )
        .await?;
        let r = pool::getReservesCall::abi_decode_returns(&raw)?;
        let fee = if matches!(venue, ryo_watch::routes::Venue::UniV2) {
            U256::ZERO
        } else {
            let f = chain::eth_call(
                &provider,
                base::AERODROME_FACTORY,
                aerodrome_factory::getFeeCall {
                    pool: entry.address,
                    stable,
                }
                .abi_encode()
                .into(),
                block,
            )
            .await?;
            aerodrome_factory::getFeeCall::abi_decode_returns(&f)?
        };
        println!(
            "\n[{}] {} {venue:?} reserve0={} reserve1={} fee={}",
            idx, entry.address, r.reserve0, r.reserve1, fee
        );
        for token_in in [usdc, weth] {
            let token_out = entry.other(token_in).unwrap();
            let step = RouteStep {
                pool_index: idx,
                token_in,
                token_out,
                venue,
                data: venue.data(),
            };
            let amounts: Vec<U256> = if token_in == usdc {
                [
                    "1",
                    "100",
                    "5000",
                    "1000000000",
                    "30000000000",
                    "300000000000",
                ]
                .iter()
                .map(|s| s.parse().unwrap())
                .collect()
            } else {
                [
                    "1",
                    "1000000000000000",
                    "1000000000000000000",
                    "5000000000000000000",
                    "30000000000000000000",
                    "100000000000000000000",
                ]
                .iter()
                .map(|s| s.parse().unwrap())
                .collect()
            };
            for a in amounts {
                match venues::quote_step(&provider, &manifest, &step, a, block).await {
                    Ok(o) => println!("  {token_in} in={a} out={o}"),
                    Err(e) => println!("  {token_in} in={a} ERR {e}"),
                }
            }
        }
    }
    Ok(())
}

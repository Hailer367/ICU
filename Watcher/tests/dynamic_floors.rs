//! Fork integration test for per-pool dynamic trigger floors.
//!
//! Three claims, each checked against a live Base fork:
//!
//! 1. **The floor table is real.** Every registry pool yields a computed
//!    floor from on-chain fee/depth reads (no fallbacks), the fees match the
//!    known tiers, and deep pools get floors orders of magnitude above thin
//!    ones.
//! 2. **The dynamic floor catches what the fixed floor misses.** A ~$300 swap
//!    into a genuinely thin pool moves its price enough to open an
//!    opportunity — but the old fixed $500 filter skipped the event before
//!    any quoting. The dynamic floor admits it, the scanner finds the
//!    opportunity, and the same trigger with `dynamic_floors = false` is
//!    silently dropped.
//! 3. **The dynamic floor skips deep-pool noise the fixed floor wasted on.**
//!    A $600 swap into the ~$40M UniV3:500 pool cannot clear the round-trip
//!    cost; the fixed floor scans it anyway, the dynamic floor refuses and
//!    says which pool floor rejected it.
//!
//! All scenarios share one snapshot and revert it at the end (Anvil consumes
//! a snapshot on revert; take exactly one per run). Failures use `bail!` so
//! `evm_revert` still runs.
//!
//! Run with a local Anvil Base fork and a deployed core:
//!
//! ```text
//! anvil --fork-url https://mainnet.base.org --chain-id 8453 --port 8545
//! RYO_FORK_RPC=http://127.0.0.1:8545 \
//!   cargo test --test dynamic_floors -- --ignored --nocapture
//! ```

use std::time::Duration;

use alloy::network::TransactionBuilder;
use alloy::primitives::{Address, B256, Bytes, U160, U256, address};
use alloy::providers::Provider;
use alloy::rpc::types::{Log, TransactionRequest};
use alloy::sol_types::SolCall;
use anyhow::{Context, Result, bail};
use ryo_watch::chain::{self, ChainProvider};
use ryo_watch::config::{Manifest, Settings, base};
use ryo_watch::events::Trigger;
use ryo_watch::routes::Venue;
use ryo_watch::scanner::{PoolFloors, Scanner};
use serde_json::Value;
use slip_router::{
    ExactInputSingleParams as SlipExactInputSingleParams, exactInputSingleCall as slipExactCall,
};
use uni_router::{
    ExactInputSingleParams as UniExactInputSingleParams, exactInputSingleCall as uniExactCall,
};

/// Balancer V2 vault: impersonated and funded so the fork can source swaps.
const BALANCER_VAULT: Address = address!("BA12222222228d8Ba445958a75a0704d566BF2C8");
/// Uniswap V3 SwapRouter02 on Base.
const SWAP_ROUTER_02: Address = address!("2626664c2603336E57B271c5C0b26F421741e481");
/// Aerodrome Slipstream router on Base.
const SLIPSTREAM_ROUTER: Address = address!("BE6D8f0d05cC4be24d5167a3eF062215bE6D18a5");
/// The $300 notional used to skew the thin pool: above the absolute floor,
/// below the historical fixed default of $500.
const THIN_SKEW_USDC: u64 = 300;
/// The $600 notional used against the deep pool: above the fixed default,
/// far below the deep pool's computed floor.
const DEEP_NOISE_USDC: u64 = 600;

alloy::sol! {
    function approve(address spender, uint256 amount) external returns (bool);
}

/// Both routers expose `exactInputSingle`, but with different parameter
/// structs, so each gets its own module — the selector is derived from the
/// *name*, and renaming it would target a function that does not exist.
mod slip_router {
    alloy::sol! {
        struct ExactInputSingleParams {
            address tokenIn;
            address tokenOut;
            int24 tickSpacing;
            address recipient;
            uint256 deadline;
            uint256 amountIn;
            uint256 amountOutMinimum;
            uint160 sqrtPriceLimitX96;
        }

        function exactInputSingle(ExactInputSingleParams params)
            external
            payable
            returns (uint256 amountOut);
    }
}

mod uni_router {
    alloy::sol! {
        struct ExactInputSingleParams {
            address tokenIn;
            address tokenOut;
            uint24 fee;
            address recipient;
            uint256 amountIn;
            uint256 amountOutMinimum;
            uint160 sqrtPriceLimitX96;
        }

        function exactInputSingle(ExactInputSingleParams params)
            external
            payable
            returns (uint256 amountOut);
    }
}

fn fork_rpc() -> String {
    std::env::var("RYO_FORK_RPC").unwrap_or_else(|_| "http://127.0.0.1:8545".to_string())
}

fn manifest_path() -> String {
    std::env::var("RYO_FORK_MANIFEST").unwrap_or_else(|_| "deployments/8453.anvil.json".to_string())
}

async fn raw<T>(provider: &ChainProvider, method: &str, params: Value) -> Result<T>
where
    T: serde::de::DeserializeOwned + std::fmt::Debug + Send + Sync + Unpin + 'static,
{
    let result = provider
        .raw_request::<_, T>(method.to_string().into(), params)
        .await
        .with_context(|| format!("{method} failed"))?;
    Ok(result)
}

async fn send_and_wait(
    provider: &ChainProvider,
    from: Address,
    to: Address,
    input: Bytes,
    gas: u64,
) -> Result<B256> {
    let request = TransactionRequest::default()
        .with_from(from)
        .with_to(to)
        .with_input(input)
        .with_gas_limit(gas);
    let hash: B256 = provider
        .raw_request("eth_sendTransaction".to_string().into(), (request,))
        .await
        .context("eth_sendTransaction failed")?;
    for _ in 0..100 {
        if let Some(receipt) = provider
            .get_transaction_receipt(hash)
            .await
            .context("failed to poll receipt")?
        {
            if !receipt.status() {
                bail!("transaction {hash} reverted");
            }
            return Ok(hash);
        }
        tokio::time::sleep(Duration::from_millis(50)).await;
    }
    bail!("transaction {hash} was not mined within 5s");
}

async fn fund_vault(provider: &ChainProvider) -> Result<()> {
    raw::<Value>(
        provider,
        "anvil_impersonateAccount",
        serde_json::json!([BALANCER_VAULT]),
    )
    .await?;
    raw::<Value>(
        provider,
        "anvil_setBalance",
        serde_json::json!([BALANCER_VAULT, "0x8ac7230489e80000"]),
    )
    .await?;
    let _ = raw::<Value>(provider, "anvil_setAutomine", serde_json::json!([true])).await;
    Ok(())
}

/// Fetch the receipt and return the swap log emitted by `pool`.
async fn pool_log(provider: &ChainProvider, hash: B256, pool: Address) -> Result<Log> {
    let receipt = provider
        .get_transaction_receipt(hash)
        .await?
        .context("receipt disappeared")?;
    receipt
        .logs()
        .iter()
        .find(|log| log.inner.address == pool)
        .cloned()
        .with_context(|| format!("tx {hash} emitted no log for pool {pool}"))
}

fn build_settings(dynamic: bool) -> Settings {
    Settings {
        http_rpc: fork_rpc(),
        manifest_path: manifest_path().into(),
        max_gas_price_gwei: 5.0,
        min_net_profit_usd: 0.01,
        // Tiny probes: the optimal size behind a $300 skew of a thin pool is
        // itself small, and the default 500+ probes would round-trip it as a
        // loss.
        probe_amounts_usd: vec![100.0, 300.0],
        max_candidates: 12,
        max_simulations: 6,
        dynamic_floors: dynamic,
        ..Settings::default()
    }
}

/// Pick the thinnest usable concentrated pool: depth in [200, 20_000] USD so
/// a $300 swap moves it ≥ 1 % but the pool still has room to pay out.
fn pick_thin_pool(floors: &PoolFloors) -> Result<usize> {
    floors
        .rows()
        .iter()
        .enumerate()
        .filter(|(_, row)| row.venue.starts_with("slipstream") || row.venue.starts_with("univ3"))
        .filter(|(_, row)| row.depth_usd.is_some_and(|d| d > 200.0 && d < 20_000.0))
        .min_by(|(_, a), (_, b)| {
            a.depth_usd
                .unwrap_or(f64::MAX)
                .partial_cmp(&b.depth_usd.unwrap_or(f64::MAX))
                .unwrap_or(std::cmp::Ordering::Equal)
        })
        .map(|(index, _)| index)
        .context("no thin concentrated pool inside [200, 20000] USD depth on this fork")
}

async fn run(provider: &ChainProvider) -> Result<()> {
    let manifest = Manifest::load(manifest_path())?;
    let dynamic = Scanner::new(provider.clone(), manifest.clone(), build_settings(true))?;
    let fixed = Scanner::new(provider.clone(), manifest, build_settings(false))?;

    // ---- Claim 1: the floor table ------------------------------------------------
    let floors = dynamic.pool_floors().await;
    let rows = floors.rows();
    // §0s grew the registry to 33 pools and made every priced side feed the
    // floor math, so all pools — including the ones with no USDC leg — must
    // now compute a dynamic floor.
    let pool_count = dynamic.registry().pools.len();
    if rows.len() != pool_count || !rows.iter().all(|row| row.dynamic) {
        bail!(
            "expected {pool_count} computed floors, got {} dynamic of {}",
            rows.iter().filter(|r| r.dynamic).count(),
            rows.len()
        );
    }
    let univ3_500 = &rows[1];
    if (univ3_500.fee_bps.unwrap_or(0.0) - 5.0).abs() > 0.01 {
        bail!(
            "univ3:500 fee should be 5.0 bps, got {:?}",
            univ3_500.fee_bps
        );
    }
    if univ3_500.depth_usd.unwrap_or(0.0) < 20_000_000.0 {
        bail!(
            "univ3:500 depth should be >$20M, got {:?}",
            univ3_500.depth_usd
        );
    }
    if univ3_500.floor_usd < 20_000.0 {
        bail!(
            "univ3:500 floor should be >$20k, got {}",
            univ3_500.floor_usd
        );
    }
    let thin_index = pick_thin_pool(&floors)?;
    if floors.floor_for(Some(thin_index)) >= build_settings(true).min_swap_usd {
        bail!(
            "thin pool {thin_index} floor {} is not below the fixed $500 default",
            floors.floor_for(Some(thin_index))
        );
    }
    eprintln!(
        "floors OK: univ3:500 depth ${:.0} floor ${:.0}; thin pool #{thin_index} ({}) floor ${:.0}",
        univ3_500.depth_usd.unwrap(),
        univ3_500.floor_usd,
        rows[thin_index].venue,
        floors.floor_for(Some(thin_index)),
    );

    // ---- Claim 2: thin pool, small swap ----------------------------------------
    fund_vault(provider).await?;
    let thin_pool = &dynamic.registry().pools[thin_index];
    let tick_spacing = match thin_pool.venue {
        Venue::Slipstream { tick_spacing } => tick_spacing,
        _ => 0,
    };
    let unit = U256::from(1_000_000u64);
    // Both routers may be used (thin pool venue depends on live depth; claim 3
    // always swaps on SwapRouter02).
    for spender in [SLIPSTREAM_ROUTER, SWAP_ROUTER_02] {
        send_and_wait(
            provider,
            BALANCER_VAULT,
            base::USDC,
            approveCall {
                spender,
                amount: U256::from(10_000) * unit,
            }
            .abi_encode()
            .into(),
            100_000,
        )
        .await?;
    }
    let is_slip = matches!(thin_pool.venue, Venue::Slipstream { .. });
    let skew_hash = if is_slip {
        send_and_wait(
            provider,
            BALANCER_VAULT,
            SLIPSTREAM_ROUTER,
            slipExactCall {
                params: SlipExactInputSingleParams {
                    tokenIn: base::USDC,
                    tokenOut: base::WETH,
                    tickSpacing: alloy::primitives::aliases::I24::from_limbs([
                        tick_spacing.max(0) as u64
                    ]),
                    // Aerodrome's router checks block.timestamp <= deadline
                    // directly; unlike SwapRouter02 it does not accept 0 as
                    // "no deadline".
                    recipient: BALANCER_VAULT,
                    deadline: U256::MAX,
                    amountIn: U256::from(THIN_SKEW_USDC) * unit,
                    amountOutMinimum: U256::ZERO,
                    sqrtPriceLimitX96: U160::ZERO,
                },
            }
            .abi_encode()
            .into(),
            500_000,
        )
        .await?
    } else {
        let fee = match thin_pool.venue {
            Venue::UniV3 { fee } => fee,
            _ => bail!("thin pool selection produced a non-CL pool"),
        };
        send_and_wait(
            provider,
            BALANCER_VAULT,
            SWAP_ROUTER_02,
            uniExactCall {
                params: UniExactInputSingleParams {
                    tokenIn: base::USDC,
                    tokenOut: base::WETH,
                    fee: alloy::primitives::aliases::U24::from_limbs([fee as u64]),
                    recipient: BALANCER_VAULT,

                    amountIn: U256::from(THIN_SKEW_USDC) * unit,
                    amountOutMinimum: U256::ZERO,
                    sqrtPriceLimitX96: U160::ZERO,
                },
            }
            .abi_encode()
            .into(),
            500_000,
        )
        .await?
    };
    let skew_log = pool_log(provider, skew_hash, thin_pool.address).await?;
    let trigger = Trigger::Log {
        log: skew_log,
        preconfirmed: false,
    };

    let report = dynamic
        .scan_triggers(std::slice::from_ref(&trigger))
        .await
        .context("dynamic-mode trigger scan failed")?;
    eprintln!(
        "thin-pool dynamic scan: routes={} quotes={} sims={} opportunities={}",
        report.routes_considered,
        report.quotes,
        report.simulations,
        report.opportunities.len()
    );
    if report.routes_considered == 0 {
        bail!(
            "dynamic filter skipped the thin-pool trigger; notes: {:?}",
            report.notes
        );
    }
    if report.opportunities.is_empty() {
        bail!(
            "a ${THIN_SKEW_USDC} skew of a ~${:.0}-deep pool opened no opportunity; \
             floor/edge model or scan gates are wrong. notes: {:?}",
            rows[thin_index].depth_usd.unwrap(),
            report.notes
        );
    }
    for opportunity in &report.opportunities {
        eprintln!(
            "  opportunity {} profit {} net ${:.2}",
            opportunity.asset_symbol, opportunity.simulated_profit, opportunity.net_usd
        );
    }

    // The same trigger under the old fixed floor: skipped before quoting.
    let fixed_report = fixed
        .scan_triggers(std::slice::from_ref(&trigger))
        .await
        .context("fixed-mode trigger scan failed")?;
    if fixed_report.routes_considered != 0 {
        bail!("fixed mode scanned a $300 swap (expected skip below $500)");
    }
    if !fixed_report
        .notes
        .iter()
        .any(|note| note.contains("below the $500 minimum"))
    {
        bail!(
            "fixed mode did not report the dust skip; notes: {:?}",
            fixed_report.notes
        );
    }
    eprintln!("fixed mode on the same trigger: skipped below $500, as before");

    // ---- Claim 3: deep pool noise ------------------------------------------------
    let noise_hash = send_and_wait(
        provider,
        BALANCER_VAULT,
        SWAP_ROUTER_02,
        uniExactCall {
            params: UniExactInputSingleParams {
                tokenIn: base::USDC,
                tokenOut: base::WETH,
                fee: alloy::primitives::aliases::U24::from_limbs([500u64]),
                recipient: BALANCER_VAULT,

                amountIn: U256::from(DEEP_NOISE_USDC) * unit,
                amountOutMinimum: U256::ZERO,
                sqrtPriceLimitX96: U160::ZERO,
            },
        }
        .abi_encode()
        .into(),
        500_000,
    )
    .await?;
    let noise_log = pool_log(provider, noise_hash, rows[1].address)
        .await
        .context("could not find the noise-swap log on univ3:500")?;
    let noise_trigger = Trigger::Log {
        log: noise_log,
        preconfirmed: false,
    };
    let dyn_noise = dynamic
        .scan_triggers(std::slice::from_ref(&noise_trigger))
        .await
        .context("dynamic deep-pool scan failed")?;
    if dyn_noise.routes_considered != 0 {
        bail!("dynamic mode scanned deep-pool noise (expected a floor skip)");
    }
    if !dyn_noise
        .notes
        .iter()
        .any(|note| note.contains("minimum; skipped"))
    {
        bail!(
            "dynamic mode did not name the pool floor in its skip; notes: {:?}",
            dyn_noise.notes
        );
    }
    eprintln!("dynamic mode on the deep-pool $600 swap: skipped at the pool floor");
    let fixed_noise = fixed
        .scan_triggers(std::slice::from_ref(&noise_trigger))
        .await
        .context("fixed deep-pool scan failed")?;
    if fixed_noise.routes_considered == 0 {
        bail!("fixed mode should still have quoted the $600 deep-pool swap");
    }
    eprintln!(
        "fixed mode on the same swap: scanned routes={} quotes={}",
        fixed_noise.routes_considered, fixed_noise.quotes
    );
    Ok(())
}

#[tokio::test]
#[ignore = "needs a local Anvil Base fork with a deployed core; see the module docs"]
async fn dynamic_floors_admit_thin_pools_and_reject_deep_noise() {
    let provider = chain::connect_http(&fork_rpc())
        .await
        .expect("failed to connect to the fork RPC");
    let node_info: Option<Value> = raw(&provider, "anvil_nodeInfo", serde_json::json!([]))
        .await
        .ok();
    if node_info.is_none() {
        panic!("RYO_FORK_RPC must point at a local Anvil node (anvil_nodeInfo failed)");
    }
    let chain_id = chain::chain_id(&provider)
        .await
        .expect("eth_chainId failed");
    assert_eq!(chain_id, 8453, "expected a Base fork, got chain {chain_id}");

    let snapshot: Option<String> = raw(&provider, "evm_snapshot", serde_json::json!([]))
        .await
        .ok();
    let outcome = run(&provider).await;
    if let Some(snapshot) = snapshot {
        let _reverted: bool = raw(&provider, "evm_revert", serde_json::json!([snapshot]))
            .await
            .unwrap_or(false);
    }
    if let Err(err) = outcome {
        panic!("dynamic floors scenario failed: {err:#}");
    }
}

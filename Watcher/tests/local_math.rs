//! Differential test for optimization #1: the local constant-product quote
//! math must be *behaviour-identical* to the scanner's own remote quote path.
//!
//! Before #1, every Uniswap-V2 / Aerodrome leg was priced on-chain by
//! `venues::quote_step`. After #1, those legs are priced by the closed-form
//! integer math in `ryo_watch::amm`. This test proves the swap loses nothing:
//! given identical pool state and an identical input amount, the local formula
//! returns *exactly* the number the remote path returns, and refuses exactly
//! when the remote path refuses.
//!
//! Built so it cannot pass by accident:
//!   * the pool set, token order and decimals come from the scanner's own
//!     `Registry::base_usdc_weth()` — the same registry the watcher prices from;
//!   * the remote side is `venues::quote_step` itself (the crate's real
//!     encode -> `eth_call` -> decode -> reject-zero path), not a copy of it;
//!   * the local side is fed reserves and fees read back through the crate's own
//!     ABI decoders — the same values `Scanner::cp_pools` fetches;
//!   * both token directions are swept from 1 wei through dust, mid-size,
//!     1/1000, 1/100, 1/10, half of a side's reserve, and the whole side;
//!   * concentrated-liquidity pools are skipped on purpose: they still use the
//!     remote quoter, so they must grow no local expectation here.
//!
//! Run against the local Anvil Base fork (the default) or live Base:
//!
//! ```text
//! # fork: anvil --fork-url https://mainnet.base.org --chain-id 8453 --port 8545
//! cargo test --test local_math -- --ignored --nocapture
//!
//! # live Base
//! RYO_LIVE_RPC=https://base-mainnet.g.alchemy.com/v2/<KEY> \
//!   cargo test --test local_math -- --ignored --nocapture
//! ```

use alloy::eips::BlockId;
use alloy::primitives::{Address, U256};
use alloy::sol_types::SolCall;
use anyhow::{Context, Result, bail};
use ryo_watch::abi::{aerodrome_factory, pool};
use ryo_watch::amm::{ConstantProductPool, Curve, ten_pow};
use ryo_watch::chain::{self, ChainProvider};
use ryo_watch::config::{Manifest, base};
use ryo_watch::routes::{Pool, Registry, RouteStep, Venue};
use ryo_watch::venues;

fn rpc() -> String {
    std::env::var("RYO_LIVE_RPC").unwrap_or_else(|_| "http://127.0.0.1:8545".to_string())
}

fn manifest_path() -> String {
    std::env::var("RYO_LIVE_MANIFEST").unwrap_or_else(|_| "deployments/8453.anvil.json".to_string())
}

/// Load a manifest for a **quote-only** run.
///
/// This differential walks venue routers; it never calls `RyoCore`. So a live
/// mainnet run is meaningful even though the contract is not deployed there,
/// using `8453.example.json`, whose router addresses are the real ones.
/// `Manifest::load` rejects that file over its zero `core`, so it is parsed
/// directly and only the fields this test actually uses are checked.
fn quote_only_manifest(path: &str) -> Result<Manifest> {
    let text =
        std::fs::read_to_string(path).with_context(|| format!("failed to read manifest {path}"))?;
    let manifest: Manifest =
        serde_json::from_str(&text).with_context(|| format!("failed to parse {path}"))?;
    for venue in ["univ2", "aerodrome", "univ3", "slipstream"] {
        match manifest.routers.get(venue) {
            Some(address) if !address.is_zero() => {}
            Some(_) => bail!("manifest router for {venue} is the zero address"),
            None => bail!("manifest has no router entry for {venue}"),
        }
    }
    Ok(manifest)
}

/// The curve the local engine uses for a registry venue, or `None` when that
/// venue is not priced locally at all (concentrated liquidity).
fn curve_of(venue: Venue) -> Option<Curve> {
    match venue {
        Venue::UniV2 => Some(Curve::UniV2),
        Venue::Aerodrome { stable: false } => Some(Curve::AerodromeVolatile),
        Venue::Aerodrome { stable: true } => Some(Curve::AerodromeStable),
        Venue::UniV3 { .. } | Venue::Slipstream { .. } => None,
    }
}

/// Read one pool's state the way `Scanner::cp_pools` does: reserves and fee
/// through the crate's ABI decoders, decimals from the registry.
async fn local_pool(
    provider: &ChainProvider,
    registry: &Registry,
    index: usize,
    curve: Curve,
    block: BlockId,
) -> Result<ConstantProductPool> {
    let entry = registry.pool(index);
    let raw = chain::eth_call(
        provider,
        entry.address,
        pool::getReservesCall {}.abi_encode().into(),
        block,
    )
    .await
    .with_context(|| format!("getReserves for {}", entry.address))?;
    let reserves = pool::getReservesCall::abi_decode_returns(&raw)?;

    let fee_bps = match curve {
        Curve::UniV2 => 0,
        Curve::AerodromeVolatile | Curve::AerodromeStable => {
            let stable = matches!(curve, Curve::AerodromeStable);
            let raw = chain::eth_call(
                provider,
                base::AERODROME_FACTORY,
                aerodrome_factory::getFeeCall {
                    pool: entry.address,
                    stable,
                }
                .abi_encode()
                .into(),
                block,
            )
            .await
            .with_context(|| format!("getFee for {}", entry.address))?;
            let fee = aerodrome_factory::getFeeCall::abi_decode_returns(&raw)?;
            fee.try_into().unwrap_or(u32::MAX)
        }
    };

    let decimals0 = registry
        .token(entry.token0)
        .with_context(|| format!("registry is missing token0 {}", entry.token0))?
        .decimals;
    let decimals1 = registry
        .token(entry.token1)
        .with_context(|| format!("registry is missing token1 {}", entry.token1))?
        .decimals;

    Ok(ConstantProductPool {
        address: entry.address,
        curve,
        token0: entry.token0,
        token1: entry.token1,
        reserve0: reserves.reserve0,
        reserve1: reserves.reserve1,
        fee_bps,
        decimals0: ten_pow(decimals0).context("token0 decimals unrepresentable")?,
        decimals1: ten_pow(decimals1).context("token1 decimals unrepresentable")?,
    })
}

/// A one-leg step built exactly the way `routes` builds the steps it walks.
fn step_for(pool_index: usize, entry: &Pool, token_in: Address) -> Result<RouteStep> {
    let token_out = entry
        .other(token_in)
        .with_context(|| format!("{token_in} is not a token of pool {pool_index}"))?;
    Ok(RouteStep {
        pool_index,
        token_in,
        token_out,
        venue: entry.venue,
        data: entry.venue.data(),
    })
}

/// Inputs to sweep for one side of a pool: dust through the entire side, sized
/// against that side's actual reserve so the sweep stays meaningful at any price
/// level and for any decimal count.
fn sweep(reserve_in: U256, decimals: u8) -> Vec<U256> {
    let unit = ten_pow(decimals).expect("sweep decimals are representable");
    let mut values: Vec<U256> = vec![
        U256::from(1u64),
        U256::from(37u64),
        U256::from(1_000u64),
        U256::from(9_999_999u64),
        unit / U256::from(10_000u64),
        unit / U256::from(100u64),
        unit / U256::from(10u64),
        unit,
        unit * U256::from(10u64),
        unit * U256::from(1_000u64),
        reserve_in / U256::from(1_000u64),
        reserve_in / U256::from(100u64),
        reserve_in / U256::from(10u64),
        reserve_in / U256::from(2u64),
        reserve_in,
    ];
    values.retain(|value| !value.is_zero());
    values.sort_unstable();
    values.dedup();
    values
}

/// Did the remote path decline because it could not produce a positive output?
/// That is the only decline the local formula is expected to mirror. Providers
/// surface a revert either as typed revert data or as a code-3 message, so both
/// spellings count.
fn remote_declined(error: &str) -> bool {
    let text = error.to_ascii_lowercase();
    text.contains("zero")
        || text.contains("revert")
        || text.contains("cannot pay")
        || text.contains("underflow")
}

async fn run(provider: &ChainProvider) -> Result<()> {
    let manifest = quote_only_manifest(&manifest_path())?;
    let registry = Registry::base_usdc_weth()?;

    let head = chain::block_number(provider).await?;
    // Pin two blocks back so the head cannot advance out from under the sweep.
    let block = BlockId::from(head.saturating_sub(2));
    eprintln!("pinned block {block}");

    let mut checked = 0usize;
    let mut declined = 0usize;
    let mut pools_tested = 0usize;

    for (index, entry) in registry.pools.iter().enumerate() {
        let Some(curve) = curve_of(entry.venue) else {
            continue;
        };
        pools_tested += 1;
        let pool = local_pool(provider, &registry, index, curve, block).await?;
        eprintln!(
            "\n[{index}] {} {} {curve:?}\n     reserves=({}, {}) fee_bps={}",
            entry.address,
            entry.venue.label(),
            pool.reserve0,
            pool.reserve1,
            pool.fee_bps
        );

        let sides = [
            (
                pool.token0,
                entry.token0,
                registry.token(entry.token0).map(|t| t.decimals),
            ),
            (
                pool.token1,
                entry.token1,
                registry.token(entry.token1).map(|t| t.decimals),
            ),
        ];
        for (token_in, _, decimals) in sides {
            let decimals = decimals.with_context(|| format!("no decimals for {token_in}"))?;
            let step = step_for(index, entry, token_in)?;
            let reserve_in = pool
                .reserves_for(token_in)
                .with_context(|| format!("no reserve for {token_in}"))?
                .0;

            let mut matched = 0usize;
            for &amount_in in &sweep(reserve_in, decimals) {
                let local = pool.amount_out(token_in, amount_in);
                let remote = venues::quote_step(provider, &manifest, &step, amount_in, block).await;
                match (local, remote) {
                    (Some(out), Ok(quoted)) => {
                        assert_eq!(
                            out, quoted,
                            "{} {token_in} -> {}: local math and the scanner's remote quote path \
                             disagree on amount_in={amount_in}",
                            entry.address, step.token_out
                        );
                        checked += 1;
                        matched += 1;
                    }
                    (None, Err(error)) => {
                        let text = error.to_string();
                        if remote_declined(&text) {
                            declined += 1;
                        } else {
                            bail!(
                                "{} {token_in} -> {}: local math declined and the remote path \
                                 also failed, but not for a price reason, so the comparison is \
                                 meaningless: {text}",
                                entry.address,
                                step.token_out
                            );
                        }
                    }
                    (None, Ok(quoted)) => bail!(
                        "{} {token_in} -> {}: local math declined, but the remote path paid \
                         {quoted} for amount_in={amount_in}",
                        entry.address,
                        step.token_out
                    ),
                    (Some(out), Err(error)) => bail!(
                        "{} {token_in} -> {}: local math paid {out} for amount_in={amount_in}, \
                         but the remote path refused: {error}",
                        entry.address,
                        step.token_out
                    ),
                }
            }
            eprintln!("     {token_in} -> {}: {matched} exact", step.token_out);
        }
    }

    eprintln!("\nEXACT matches: {checked}, consistent declines: {declined}, pools: {pools_tested}");
    if pools_tested < 3 {
        bail!("only {pools_tested} constant-product pools in the registry; expected at least 3");
    }
    if checked < 40 {
        bail!("only {checked} comparable quotes — the sweep was too thin to prove anything");
    }
    Ok(())
}

#[tokio::test]
#[ignore = "needs network (local Base fork or live Base); see the module docs"]
async fn local_math_matches_the_scanner_remote_path() {
    let provider = chain::connect_http(&rpc())
        .await
        .expect("failed to connect to the RPC");
    let chain_id = chain::chain_id(&provider)
        .await
        .expect("eth_chainId failed");
    assert_eq!(chain_id, 8453, "expected a Base RPC, got chain {chain_id}");
    if let Err(err) = run(&provider).await {
        panic!("local-vs-remote differential failed: {err:#}");
    }
}

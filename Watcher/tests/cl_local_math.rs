//! Differential tests: local CLMM math vs the on-chain quoters (§0u).
//!
//! 1. `cl_local_math_matches_the_quoter` — for every concentrated-liquidity
//!    pool in the registry, bootstraps a `ClPoolState` from chain reads
//!    pinned at one historical block, quotes a sweep of amounts in both
//!    directions entirely in RAM, and compares against the very quoter calls
//!    the scanner's remote path makes *at the same pinned block*. Both
//!    `amountOut` and `sqrtPriceX96After` must match exactly; a local answer
//!    the quoter contradicts, or a local payment against a remote revert, is
//!    a hard failure — the bail-style discipline of `tests/local_math.rs`,
//!    extended with `sqrtPriceX96After` agreement and a match-rate floor so
//!    blanket refusals cannot pass vacuously.
//! 2. `maintained_cache_matches_after_live_event_replay` — bootstraps the
//!    same caches, replays *real chain logs* through the event-maintenance
//!    path the Scanner runs (swap after-state words; stale-marking for
//!    everything else), refreshes dynamic fees, then repeats the full
//!    differential at the newer pinned block. Exact matches after replay
//!    prove the incremental maintenance; the designed degrade-to-remote
//!    direction (stale ⇒ refuse) must never produce a wrong number.
//!
//! Against a local Anvil Base fork (deploy nothing; reads only):
//!   anvil --fork-url <base> --chain-id 8545 -> default `http://127.0.0.1:8545`
//! Against live Base (the configuration §0u names as the real check; the
//! event-replay test needs an RPC that serves `eth_getLogs` over a range —
//! Alchemy works, public `mainnet.base.org` rejects it):
//!   RYO_LIVE_RPC=https://base-mainnet.g.alchemy.com/v2/<key> \
//!     cargo test --test cl_local_math -- --ignored --nocapture

use std::collections::HashMap;
use std::env;
use std::time::Duration;

use alloy::eips::BlockId;
use alloy::primitives::{Address, U256, Uint};
use alloy::providers::Provider;
use alloy::rpc::types::Filter;
use alloy::sol_types::SolCall;
use anyhow::{Context, Result, bail};
use ryo_watch::abi::{slipstream_quoter, univ3_quoter};
use ryo_watch::amm::ten_pow;
use ryo_watch::chain::{self, ChainProvider};
use ryo_watch::clamm::{self, ClPoolSpec, ClPoolState};
use ryo_watch::config::Manifest;
use ryo_watch::routes::{Registry, RouteStep, Venue};

fn rpc() -> String {
    env::var("RYO_LIVE_RPC").unwrap_or_else(|_| "http://127.0.0.1:8545".to_string())
}

/// Zero-address manifest: the CL quoter targets are constants in
/// `venues::encode_quote_call`, so nothing here touches the chain.
fn quote_only_manifest() -> Result<Manifest> {
    let json = include_str!("../deployments/8453.example.json");
    serde_json::from_str(json).context("failed to parse the example manifest")
}

fn scaled(decimals: u8, times_1000: u64) -> Option<U256> {
    // amount = 10^decimals * times_1000 / 1000, in token base units.
    let unit = ten_pow(decimals)?;
    Some(unit.checked_mul(U256::from(times_1000))? / U256::from(1000u32)).filter(|v| !v.is_zero())
}

/// Sweep from single-wei dust to multi-unit size: dust (zero-output
/// territory), tiny, sub-unit, unit, and a few-unit size the scanner would
/// actually probe (§0u caps realistic probes at $8k).
fn sweep(decimals: u8) -> Vec<U256> {
    let mut amounts = vec![U256::from(1u8), U256::from(1000u32)];
    for times_1000 in [1u64, 10, 100, 200, 500, 1_000, 2_000, 8_000] {
        if let Some(v) = scaled(decimals, times_1000) {
            amounts.push(v);
        }
    }
    amounts.sort();
    amounts.dedup();
    amounts
}

/// Widen a `uint160` quoter word to U256 for comparison against the local
/// Q64.96 word.
fn widen(v: Uint<160, 3>) -> U256 {
    let l = v.as_limbs();
    U256::from_limbs([l[0], l[1], l[2], 0])
}

fn remote_declined(error: &str) -> bool {
    let text = error.to_lowercase();
    [
        "zero",
        "revert",
        "cannot pay",
        "underflow",
        "'r'",
        "'t'",
        "'as'",
        "'spl'",
        "iia",
        "panic",
    ]
    .iter()
    .any(|needle| text.contains(needle))
}

#[derive(Default)]
struct Tally {
    exact: usize,
    consistent_rejects: usize,
    local_refused_remote_paid: usize,
    /// Same three counters, but only for pools whose cache stayed fresh.
    /// The maintenance test's floor applies here: a stale pool refusing
    /// everything is the designed degrade-to-remote path, not a defect; a
    /// *fresh* pool refusing paid quotes, or disagreeing anywhere, is.
    fresh_exact: usize,
    fresh_consistent_rejects: usize,
    fresh_refused_remote_paid: usize,
    stale_pools: usize,
    fresh_pools: usize,
}

fn cl_specs(registry: &Registry) -> Vec<ClPoolSpec> {
    registry
        .pools
        .iter()
        .enumerate()
        .filter_map(|(index, pool)| match pool.venue {
            Venue::UniV3 { .. } | Venue::PancakeV3 { .. } => Some(ClPoolSpec {
                index,
                address: pool.address,
                token0: pool.token0,
                token1: pool.token1,
                tick_spacing_hint: None,
                dynamic_fee: false,
            }),
            Venue::Slipstream { tick_spacing } => Some(ClPoolSpec {
                index,
                address: pool.address,
                token0: pool.token0,
                token1: pool.token1,
                tick_spacing_hint: Some(tick_spacing),
                dynamic_fee: true,
            }),
            Venue::UniV2 | Venue::Aerodrome { .. } => None,
        })
        .collect()
}

/// The shared sweep: quote every CL pool both ways from `states`, compare
/// against the quoters batched at `block`, and fail on any disagreement.
async fn diff_pool_states(
    provider: &ChainProvider,
    registry: &Registry,
    manifest: &Manifest,
    states: &HashMap<usize, ClPoolState>,
    block: BlockId,
    tally: &mut Tally,
) -> Result<()> {
    for spec in cl_specs(registry) {
        let pool = &registry.pools[spec.index];
        let Some(state) = states.get(&spec.index) else {
            eprintln!(
                "pool {:>2} {}: not cached (remote-only)",
                spec.index,
                pool.venue.label()
            );
            continue;
        };
        let mut pool_exact = 0usize;
        let mut pool_refused = 0usize;
        let fresh = !state.stale;
        if fresh {
            tally.fresh_pools += 1;
        } else {
            tally.stale_pools += 1;
        }

        for (token_in, token_out) in [(pool.token0, pool.token1), (pool.token1, pool.token0)] {
            let decimals = registry
                .token(token_in)
                .map(|t| t.decimals)
                .context("registry is missing the swept token")?;
            let step = RouteStep {
                pool_index: spec.index,
                token_in,
                token_out,
                venue: pool.venue,
                data: pool.venue.data(),
            };
            let zero_for_one = token_in == pool.token0;
            let amounts = sweep(decimals);

            // Remote side, batched: one aggregate3 round per pool side.
            let mut calls = Vec::new();
            for amount in &amounts {
                let (target, data) =
                    ryo_watch::venues::encode_quote_call(manifest, &step, *amount)?;
                calls.push((target, data));
            }
            let remote = chain::multicall_raw(provider, &calls, block).await;

            for (amount, result) in amounts.iter().zip(remote) {
                let decoded = match result {
                    Ok(data) => {
                        let (amount_out, sqrt_after) = match pool.venue {
                            Venue::Slipstream { .. } => {
                                let d =
                                    slipstream_quoter::quoteExactInputSingleCall::abi_decode_returns(
                                        data.as_ref(),
                                    )
                                    .context("slipstream quoter decode")?;
                                (d.amountOut, widen(d.sqrtPriceX96After))
                            }
                            _ => {
                                let d =
                                    univ3_quoter::quoteExactInputSingleCall::abi_decode_returns(
                                        data.as_ref(),
                                    )
                                    .context("univ3 quoter decode")?;
                                (d.amountOut, widen(d.sqrtPriceX96After))
                            }
                        };
                        Ok((amount_out, sqrt_after))
                    }
                    Err(err) => Err(err),
                };

                let local = state.swap_at_limit(zero_for_one, *amount);

                match (&local, &decoded) {
                    (Some(out), Ok((remote_amount, remote_sqrt))) => {
                        if out.amount_out != *remote_amount {
                            bail!(
                                "pool {} ({}) {} amount {amount}: local paid {} but the \
                                 quoter says {remote_amount}",
                                spec.index,
                                pool.venue.label(),
                                token_in,
                                out.amount_out,
                            );
                        }
                        if out.sqrt_price_x96_after != *remote_sqrt {
                            bail!(
                                "pool {} ({}) {} amount {amount}: local sqrt-after {} \
                                 disagrees with the quoter's {remote_sqrt} (amounts matched, \
                                 the tick walk did not)",
                                spec.index,
                                pool.venue.label(),
                                token_in,
                                out.sqrt_price_x96_after,
                            );
                        }
                        tally.exact += 1;
                        pool_exact += 1;
                        if fresh {
                            tally.fresh_exact += 1;
                        }
                    }
                    (Some(out), Err(err)) => {
                        // Local paid, remote reverted: never acceptable.
                        bail!(
                            "pool {} ({}) {} amount {amount}: local paid {} but the quoter \
                             refused: {err}",
                            spec.index,
                            pool.venue.label(),
                            token_in,
                            out.amount_out,
                        );
                    }
                    (None, Ok(_)) => {
                        // A coverage refusal (stale, unfetched ticks, the
                        // iteration cap) against a paid remote quote is the
                        // designed degrade-to-remote direction; counted, but
                        // the match-rate floor keeps it honest.
                        tally.local_refused_remote_paid += 1;
                        pool_refused += 1;
                        if fresh {
                            tally.fresh_refused_remote_paid += 1;
                        }
                    }
                    (None, Err(err)) => {
                        if !remote_declined(err.as_ref()) {
                            bail!(
                                "pool {} ({}) {} amount {amount}: local refused and the remote \
                                 failed for a non-price reason, so the comparison is \
                                 meaningless: {err}",
                                spec.index,
                                pool.venue.label(),
                                token_in,
                            );
                        }
                        tally.consistent_rejects += 1;
                        pool_refused += 1;
                        if fresh {
                            tally.fresh_consistent_rejects += 1;
                        }
                    }
                }
            }

            // Round trip on the same snapshot: buying then selling back at
            // unit size can never return more than went in (fees + rounding
            // are one-directional). Pure-local invariant, no RPC.
            if let Some(unit) = scaled(decimals, 1_000)
                && let Some(a) = state.quote_exact_in(token_in, unit)
                && let Some(back) = state.quote_exact_in(token_out, a)
                && back > unit
            {
                bail!(
                    "pool {} round trip returns more than it paid: {} -> {} -> {}",
                    spec.index,
                    unit,
                    a,
                    back
                );
            }
        }
        eprintln!(
            "pool {:>2} {:<14} exact {:>3} refused {:>2}",
            spec.index,
            pool.venue.label(),
            pool_exact,
            pool_refused
        );
    }
    Ok(())
}

fn report(tally: &Tally, label: &str) -> Result<()> {
    eprintln!(
        "{label}: exact={} consistent_rejects={} local_refused_remote_paid={}          (fresh pools: {} exact / {} refused-paid / {} consistent-rejects;          stale-marked pools: {})",
        tally.exact,
        tally.consistent_rejects,
        tally.local_refused_remote_paid,
        tally.fresh_exact,
        tally.fresh_refused_remote_paid,
        tally.fresh_consistent_rejects,
        tally.stale_pools,
    );
    let comparisons = tally.exact + tally.local_refused_remote_paid;
    if comparisons < 100 {
        bail!("{label}: only {comparisons} priced comparisons; sweep too thin to conclude");
    }
    // Blanket coverage refusals would pass every arm above; they must not
    // pass this one. Of the quotes *fresh caches* had the data to price,
    // at least 80 % must have matched the quoter bit-for-bit. (Stale
    // refuse-everything behavior is expected and excluded here.)
    let fresh_comparisons = tally.fresh_exact + tally.fresh_refused_remote_paid;
    if fresh_comparisons < 100 {
        bail!(
            "{label}: fresh-pool comparisons too thin ({fresh_comparisons});              maintenance path likely over-staling"
        );
    }
    let floor = fresh_comparisons * 4 / 5;
    if tally.fresh_exact < floor {
        bail!(
            "{label}: fresh match rate {} / {fresh_comparisons} is below the 80 % floor ({floor})",
            tally.fresh_exact
        );
    }
    Ok(())
}

async fn run_pinned(provider: &ChainProvider) -> Result<()> {
    let registry = Registry::base_curated()?;
    let manifest = quote_only_manifest()?;

    // Pin two blocks back so live head movement cannot change the block the
    // remote side answers about (the same trick `local_math.rs` uses).
    let head = chain::block_number(provider).await?;
    let pinned = head.saturating_sub(2);
    let block = BlockId::from(pinned);
    eprintln!("pinned block {pinned} (head {head})");

    let specs = cl_specs(&registry);
    if specs.len() != 29 {
        bail!(
            "expected 29 CL pools in the registry, built {}",
            specs.len()
        );
    }
    let states = clamm::bootstrap_pools(provider, &specs, block, pinned).await;
    if states.len() < 24 {
        bail!(
            "bootstrap cached only {}/29 pools; the differential would be vacuous",
            states.len()
        );
    }
    eprintln!(
        "bootstrapped {} pools; words/ticks: {}",
        states.len(),
        states
            .iter()
            .map(|(i, s)| format!("{i}:{}w/{}t", s.cached_words(), s.cached_ticks()))
            .collect::<Vec<_>>()
            .join(" ")
    );

    let mut tally = Tally::default();
    diff_pool_states(provider, &registry, &manifest, &states, block, &mut tally).await?;
    report(&tally, "pinned differential")
}

async fn run_event_maintenance(provider: &ChainProvider) -> Result<()> {
    let registry = Registry::base_curated()?;
    let manifest = quote_only_manifest()?;

    let b0 = chain::block_number(provider).await?;
    let specs = cl_specs(&registry);
    let mut states = clamm::bootstrap_pools(provider, &specs, BlockId::from(b0), b0).await;
    if states.len() < 24 {
        bail!("bootstrap cached only {}/29 pools", states.len());
    }

    // Let the chain move, then pull the window's logs — the exact objects
    // the socket would have delivered — and feed them through the same
    // maintenance entry point the Scanner's trigger loop uses.
    let target = b0 + 8;
    let mut b1 = b0;
    for _ in 0..40 {
        tokio::time::sleep(Duration::from_secs(3)).await;
        b1 = chain::block_number(provider).await?;
        if b1 >= target {
            break;
        }
    }
    if b1 <= b0 {
        bail!("chain did not move; cannot test event maintenance");
    }
    let addrs: Vec<Address> = specs.iter().map(|s| s.address).collect();
    let filter = Filter::new()
        .address(addrs.clone())
        .from_block(b0 + 1)
        .to_block(b1);
    let logs = provider
        .get_logs(&filter)
        .await
        .context("eth_getLogs over the replay window failed")?;
    eprintln!(
        "replaying {} pool logs from blocks {}..={b1}",
        logs.len(),
        b0 + 1
    );

    let by_address: HashMap<Address, usize> = specs.iter().map(|s| (s.address, s.index)).collect();
    let mut swaps = 0usize;
    let mut others = 0usize;
    for log in &logs {
        let Some(&index) = by_address.get(&log.address()) else {
            continue;
        };
        let Some(state) = states.get_mut(&index) else {
            continue;
        };
        match clamm::swap_after_words(log) {
            Some((sqrt, liquidity, tick)) => {
                state.apply_swap_after(sqrt, liquidity, tick);
                swaps += 1;
            }
            None => {
                state.mark_stale();
                others += 1;
            }
        }
    }
    eprintln!("applied {swaps} swap after-states, stale-marked on {others} other logs");

    // Slipstream fees drift between bootstraps; the Scanner refreshes them
    // per scan — read them at the same pinned block the quoters answer on.
    let dyn_specs: Vec<(usize, Address)> = specs
        .iter()
        .filter(|s| s.dynamic_fee)
        .map(|s| (s.index, s.address))
        .collect();
    if !dyn_specs.is_empty() {
        let fees = clamm::fetch_fees(
            provider,
            &dyn_specs.iter().map(|(_, a)| *a).collect::<Vec<_>>(),
            BlockId::from(b1),
        )
        .await;
        for ((index, _), fee) in dyn_specs.iter().zip(fees) {
            if let (Some(fee), Some(state)) = (fee, states.get_mut(index)) {
                state.refresh_fee(fee);
            }
        }
    }

    let fresh = states.iter().filter(|(_, s)| !s.stale).count();
    let block = BlockId::from(b1);
    let mut tally = Tally::default();
    diff_pool_states(provider, &registry, &manifest, &states, block, &mut tally).await?;
    report(&tally, "event-maintained differential")?;
    if fresh < 8 {
        bail!("only {fresh} pools stayed fresh through replay; maintenance path suspect");
    }
    if swaps < 20 {
        bail!("window had only {swaps} swap logs; replay proved little");
    }
    eprintln!(
        "event maintenance: {fresh} pools stayed current across blocks {}..={b1}",
        b0 + 1
    );
    Ok(())
}

#[tokio::test]
#[ignore = "needs network (local Base fork or live Base); see the module docs"]
async fn cl_local_math_matches_the_quoter() {
    let provider = chain::connect_http(&rpc())
        .await
        .expect("failed to connect to the RPC");
    let chain_id = chain::chain_id(&provider)
        .await
        .expect("failed to read the chain id");
    assert_eq!(chain_id, 8453, "expected Base mainnet");
    if let Err(err) = run_pinned(&provider).await {
        panic!("CL local-math differential failed: {err:#}");
    }
}

#[tokio::test]
#[ignore = "needs network (live Base RPC with range getLogs); see the module docs"]
async fn maintained_cache_matches_after_live_event_replay() {
    let provider = chain::connect_http(&rpc())
        .await
        .expect("failed to connect to the RPC");
    let chain_id = chain::chain_id(&provider)
        .await
        .expect("failed to read the chain id");
    assert_eq!(chain_id, 8453, "expected Base mainnet");
    if let Err(err) = run_event_maintenance(&provider).await {
        panic!("event-maintenance differential failed: {err:#}");
    }
}

//! Event-driven opportunity scanner.
//!
//! The scanner never polls for opportunities. A caller gives it a trigger
//! (a pool log, a flashblock, a new head, or a reconnect) and it quotes only
//! the routes that touch the affected pools.

use std::collections::{HashMap, HashSet, VecDeque};
use std::sync::Mutex;
use std::time::{Duration, Instant};

use alloy::eips::BlockId;
use alloy::primitives::{Address, B256, Bytes, I256, U256};
use alloy::rpc::types::Log;
use alloy::sol_types::SolCall;
use anyhow::{Context, Result, bail};
use futures_util::{StreamExt, stream};
use tracing::{debug, info, warn};

use crate::abi::ryo;
use crate::amm::{ConstantProductPool, Curve, ten_pow};
use crate::chain::{self, ChainProvider};
use crate::config::{Manifest, Settings, base};
use crate::events::Trigger;
use crate::gas::{self, GasSnapshot, TradeCost};
use crate::history;
use crate::routes::{Registry, Route, RouteStep, Venue, enumerate_cycles};
use crate::simulate::{self, SimulateError};
use crate::venues::{self, QuoteRequest};

/// Reuse a gas snapshot and ETH/USD price for this long. Bursts of pool logs
/// otherwise re-read the same chain state several times in a row.
const GAS_CACHE_TTL: Duration = Duration::from_secs(2);
/// Identity of a simulation candidate: asset, input amount, and the pools
/// forming the route. Its market state changes only when one of those pools
/// trades.
type FailedSimKey = (Address, U256, Vec<usize>);

/// Losing simulations are remembered at most this many before a reset; the
/// cache is an optimization, and dropping it is always safe.
const FAILED_SIM_CACHE_CAP: usize = 8_192;
/// Remember this many recent triggers so `logs` + `pendingLogs` duplicates do
/// not cause two identical scans.
const DEDUPE_CAPACITY: usize = 2_048;
/// A swap smaller than this cannot repay the minimum profit: at ~0.56 % round
/// trip (pool fees + profit buffer), $0.25 needs about $45 of notional. The
/// floor applies even when `min_swap_usd` is configured lower.
const ABSOLUTE_MIN_SWAP_USD: f64 = 45.0;
/// Upper bound on a sane Aerodrome `getFee` answer, in basis points of 10_000.
const AERO_FEE_MAX: U256 = U256::from_limbs([10_000u64, 0, 0, 0]);

/// How one leg of a scan job gets priced.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum LegPrice {
    /// Priced locally from pinned reserves, at zero RPC cost.
    Local(U256),
    /// Local math has no answer for this leg — concentrated liquidity, a pool
    /// absent from this scan's reserve fetch, or a genuine refusal (dust that
    /// rounds to zero output, a non-converging stable iteration, an over-draw,
    /// an implausible fee). Every one of these must still be quoted on-chain:
    /// "local math is unsure" is not evidence about profitability, and
    /// treating it as such would silently delete a payable route.
    Onchain,
}

/// Decide how to price one leg. Pure and side-effect free so the
/// "local refusal never drops a candidate" invariant is directly testable.
pub fn price_leg(
    cp: &HashMap<usize, ConstantProductPool>,
    step: &RouteStep,
    input: U256,
) -> LegPrice {
    match cp
        .get(&step.pool_index)
        .and_then(|pool| pool.amount_out(step.token_in, input))
    {
        Some(out) => LegPrice::Local(out),
        None => LegPrice::Onchain,
    }
}

#[derive(Debug, Clone)]
pub struct Opportunity {
    pub asset: Address,
    pub asset_symbol: String,
    pub amount: U256,
    pub route: Route,
    /// Quotes including the input amount: `[amount_in, out_1, out_2, ...]`.
    pub quotes: Vec<U256>,
    pub simulated_profit: I256,
    pub floors: Vec<U256>,
    pub min_profit: U256,
    pub route_hash: B256,
    pub calldata: Bytes,
    pub gas_used: u64,
    pub gas_price: U256,
    pub cost: TradeCost,
    pub profit_usd: f64,
    pub net_usd: f64,
    pub block: u64,
    pub preconfirmed: bool,
}

impl Opportunity {
    pub fn venues(&self) -> Vec<String> {
        self.route.venues()
    }
}

/// Everything one asset scan produced. Assets are scanned concurrently and
/// merged into a `ScanReport` in `assets` order, so notes and counters stay
/// deterministic.
#[derive(Debug, Clone, Default)]
struct AssetReport {
    notes: Vec<String>,
    routes_considered: usize,
    quotes: usize,
    /// Legs the chain could not price at all this scan (reverts on the quoter,
    /// transport failures, undecodable returns). Kept apart from `quotes` so a
    /// blinding failure is never reported as an empty market.
    quote_failures: usize,
    simulations: usize,
    sims_cached: usize,
    opportunities: Vec<Opportunity>,
    probe_ms: u64,
    refine_ms: u64,
    simulate_ms: u64,
}

#[derive(Debug, Clone, Default)]
pub struct ScanReport {
    /// The single block every read and the simulation in this scan used.
    pub block: u64,
    /// Hash of that block. Report it alongside the number so a scan can be
    /// replayed against exactly the state that produced it: two blocks can
    /// share a number after a re-org, never a hash.
    pub pin_hash: Option<B256>,
    /// Blocks the chain produced while the scan was running. Zero means the
    /// pinned state was still head when the scan finished; a non-zero value is
    /// still a *consistent* scan, just one whose numbers are now that many
    /// blocks old.
    pub head_drift: u64,
    /// The pinned block was replaced by a re-org while the scan ran, so every
    /// number in this report describes a block that is no longer canonical.
    /// Callers must treat the scan as void rather than as "no opportunity".
    pub reorged: bool,
    pub affected_pools: Vec<Address>,
    pub routes_considered: usize,
    pub quotes: usize,
    /// See `AssetReport::quote_failures`: how much of this scan could not be
    /// answered. Zero with zero opportunities means "nothing to find"; non-zero
    /// means "we could not look properly".
    pub quote_failures: usize,
    pub simulations: usize,
    /// Finalists skipped because their last simulation was a definitive loss
    /// at an unchanged market state.
    pub sims_cached: usize,
    pub opportunities: Vec<Opportunity>,
    pub notes: Vec<String>,
    /// Per-phase wall time in milliseconds, summed across assets. `core_ms`
    /// covers the head block number plus the core state reads.
    pub core_ms: u64,
    pub gas_ms: u64,
    pub probe_ms: u64,
    pub refine_ms: u64,
    pub simulate_ms: u64,
}

/// What woke the scan, not what it reads.
///
/// Every scan pins one concrete block for all of its reads (see `chain::Pin`),
/// so this no longer selects a block tag: `pending` state has no hash and
/// shifts every flashblock interval, and a scan that quotes at one moment and
/// simulates at another reports a trade that was possible in neither. `Pending`
/// still matters for *scheduling* — a pending trigger takes the urgent slot in
/// the queue and widens the batch to a full scan when it cannot be attributed
/// to a known pool.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum ScanBlock {
    Latest,
    Pending,
}

struct CoreState {
    paused: bool,
    max_gas_price: U256,
    caps: HashMap<Address, U256>,
}

#[derive(Debug, Clone, PartialEq, Eq, Hash)]
enum TriggerKey {
    Log { tx: B256, index: u64 },
    Flashblock { hashes: Vec<B256> },
}

impl TriggerKey {
    fn from_trigger(trigger: &Trigger) -> Option<Self> {
        match trigger {
            Trigger::Log { log, .. } => {
                let tx = log.transaction_hash?;
                let index = log.log_index?;
                Some(Self::Log { tx, index })
            }
            Trigger::Flashblock { hashes, .. } if !hashes.is_empty() => Some(Self::Flashblock {
                hashes: hashes.clone(),
            }),
            _ => None,
        }
    }
}

#[derive(Default)]
struct Deduper {
    order: VecDeque<TriggerKey>,
    seen: HashSet<TriggerKey>,
}

impl Deduper {
    fn contains(&self, key: &TriggerKey) -> bool {
        self.seen.contains(key)
    }

    /// Record a key only after its scan succeeded. Marking it up front would
    /// let one transient scan failure suppress the later mined duplicate of
    /// the same log.
    fn mark(&mut self, key: TriggerKey) {
        if self.seen.contains(&key) {
            return;
        }
        if self.order.len() >= DEDUPE_CAPACITY
            && let Some(old) = self.order.pop_front()
        {
            self.seen.remove(&old);
        }
        self.seen.insert(key.clone());
        self.order.push_back(key);
    }
}

struct CachedGas {
    at: Instant,
    snapshot: GasSnapshot,
    eth_usd: f64,
}

/// Skipping re-simulations of losing candidates while their market inputs are
/// unchanged.
///
/// A candidate is `(asset, amount, route's pool indices)`. What a simulation
/// and the USD gates read is the route's quotes plus the gas and USD prices;
/// a definitive loss is stored together with exactly those inputs. A later
/// scan may skip the candidate only when every one of them is bit-identical:
/// equal quotes mean the route's pools produce equal outputs, so the on-chain
/// result could not have changed and skipping can never hide an opportunity.
/// This holds even when the pools traded in between (small trades that leave
/// the quoted outputs untouched) and across full scans.
#[derive(Default, Debug)]
struct FailedSimCache {
    losses: HashMap<FailedSimKey, SimInputs>,
}

/// The inputs a simulation outcome is pinned to.
#[derive(Debug, Clone, PartialEq)]
struct SimInputs {
    /// Refined quotes `[amount_in, out_leg1, out_leg2, ...]`.
    quotes: Vec<U256>,
    gas_price: U256,
    /// USD prices behind the profit gate. Scanned values are always positive
    /// (feeds with no usable price bail before candidates exist), so bitwise
    /// float equality is safe here.
    asset_usd: f64,
    eth_usd: f64,
}

impl FailedSimCache {
    fn is_unchanged_loss(&self, key: &FailedSimKey, inputs: &SimInputs) -> bool {
        self.losses.get(key) == Some(inputs)
    }

    fn remember_loss(&mut self, key: FailedSimKey, inputs: SimInputs) {
        if self.losses.len() >= FAILED_SIM_CACHE_CAP {
            self.losses.clear();
        }
        self.losses.insert(key, inputs);
    }
}

pub struct Scanner {
    provider: ChainProvider,
    manifest: Manifest,
    registry: Registry,
    settings: Settings,
    pool_index: HashMap<Address, usize>,
    assets: Vec<Address>,
    /// Cycles are static for a given registry and hop limit, so enumerate once.
    routes: HashMap<Address, Vec<Route>>,
    gas_cache: Mutex<Option<CachedGas>>,
    /// Chainlink feed decimals are immutable, so each feed is read once and
    /// remembered for the life of the scanner.
    feed_decimals: Mutex<HashMap<Address, u8>>,
    deduper: Mutex<Deduper>,
    sim_cache: Mutex<FailedSimCache>,
    /// Highest block observed by an evaluate call, used to notice skipped
    /// heads (reorg or a dropped WebSocket message) and force one full rescan.
    last_block: Mutex<Option<u64>>,
}

impl Scanner {
    pub fn new(provider: ChainProvider, manifest: Manifest, settings: Settings) -> Result<Self> {
        let registry = Registry::base_usdc_weth()?;
        let mut pool_index = HashMap::new();
        for (index, pool) in registry.pools.iter().enumerate() {
            pool_index.insert(pool.address, index);
        }

        let mut assets = Vec::new();
        for symbol in &settings.assets {
            let address = manifest.token(symbol).or(match symbol.as_str() {
                "USDC" => Some(base::USDC),
                "WETH" => Some(base::WETH),
                _ => None,
            });
            match address {
                Some(address) => {
                    if !assets.contains(&address) {
                        assets.push(address);
                    }
                }
                None => warn!(symbol, "asset is not in the manifest; skipping"),
            }
        }
        if assets.is_empty() {
            bail!("no scannable assets configured");
        }

        let routes = assets
            .iter()
            .map(|asset| {
                (
                    *asset,
                    enumerate_cycles(&registry, *asset, settings.max_hops),
                )
            })
            .collect();

        Ok(Self {
            provider,
            manifest,
            registry,
            settings,
            pool_index,
            assets,
            routes,
            gas_cache: Mutex::new(None),
            feed_decimals: Mutex::new(HashMap::new()),
            deduper: Mutex::new(Deduper::default()),
            sim_cache: Mutex::new(FailedSimCache::default()),
            last_block: Mutex::new(None),
        })
    }

    /// Read a gas snapshot and ETH/USD price, reusing a recent pair when the
    /// watcher is processing a burst of triggers.
    async fn gas_context(&self, pin: chain::Pin) -> Result<(GasSnapshot, f64)> {
        {
            let cache = self.gas_cache.lock().expect("gas cache mutex poisoned");
            if let Some(cached) = cache.as_ref()
                && cached.at.elapsed() < GAS_CACHE_TTL
                // Reuse only for the *same* block. The old time-based reuse
                // could price a scan at block N's fees while everything else
                // in that scan read block N+1.
                && cached.snapshot.block_number == pin.number
            {
                return Ok((cached.snapshot.clone(), cached.eth_usd));
            }
        }
        let snapshot = gas::snapshot(&self.provider, 2_000, &pin).await?;
        // A missing ETH/USD price must not degrade to "free gas": the scan
        // bails on a non-positive price below. `unwrap_or(0.0)` keeps that as
        // the single, explicit gate rather than silently passing it.
        let eth_usd = gas::eth_usd_price(&self.provider, &pin)
            .await
            .unwrap_or(0.0);
        if eth_usd > 0.0 {
            let mut cache = self.gas_cache.lock().expect("gas cache mutex poisoned");
            *cache = Some(CachedGas {
                at: Instant::now(),
                snapshot: snapshot.clone(),
                eth_usd,
            });
        }
        Ok((snapshot, eth_usd))
    }

    /// Read and cache the decimals for every configured asset's USD feed.
    /// These are immutable, so one batched read per scanner replaces a
    /// per-scan round-trip inside the price fetch.
    async fn ensure_feed_decimals(&self, feeds: &[Address], block: BlockId) {
        use crate::abi::chainlink;
        use alloy::sol_types::SolCall;

        let missing: Vec<Address> = {
            let cache = self
                .feed_decimals
                .lock()
                .expect("feed decimals mutex poisoned");
            feeds
                .iter()
                .filter(|feed| !cache.contains_key(*feed))
                .copied()
                .collect()
        };
        if missing.is_empty() {
            return;
        }
        let calls: Vec<(Address, alloy::primitives::Bytes)> = missing
            .iter()
            .map(|feed| (*feed, chainlink::decimalsCall {}.abi_encode().into()))
            .collect();
        let results = chain::multicall_raw(&self.provider, &calls, block).await;
        let mut cache = self
            .feed_decimals
            .lock()
            .expect("feed decimals mutex poisoned");
        for (feed, result) in missing.iter().zip(results) {
            match result {
                Ok(data) => match chainlink::decimalsCall::abi_decode_returns(&data) {
                    Ok(decimals) => {
                        cache.insert(*feed, decimals);
                    }
                    Err(err) => {
                        warn!(feed = %feed, error = %err, "failed to decode feed decimals");
                    }
                },
                Err(err) => {
                    warn!(feed = %feed, error = %err, "failed to read feed decimals");
                }
            }
        }
    }

    /// Resolve USD prices for all assets in one batched feed read, keyed by
    /// asset. Assets without a usable feed are simply absent; the scan path
    /// treats a missing price as "no usable USD feed", matching the old
    /// per-asset bail semantics.
    async fn asset_usd_prices(&self, eth_usd: f64, pin: chain::Pin) -> HashMap<Address, f64> {
        let mut prices = HashMap::new();
        let mut requests: Vec<(Address, u64)> = Vec::new();
        for asset in &self.assets {
            if let Some((feed, max_age)) = gas::usd_feed_for_asset(*asset) {
                // Reuse the ETH/USD price the gas snapshot already fetched.
                if feed == base::ETH_USD_FEED {
                    if eth_usd > 0.0 {
                        prices.insert(*asset, eth_usd);
                    }
                    continue;
                }
                if !requests.iter().any(|(existing, _)| *existing == feed) {
                    requests.push((feed, max_age));
                }
            }
        }
        if requests.is_empty() {
            return prices;
        }
        let feeds: Vec<Address> = requests.iter().map(|(feed, _)| *feed).collect();
        self.ensure_feed_decimals(&feeds, pin.id()).await;
        let decimals = self
            .feed_decimals
            .lock()
            .expect("feed decimals mutex poisoned")
            .clone();
        let resolved = gas::feed_prices(&self.provider, &requests, &pin, &decimals).await;
        for (feed, result) in resolved {
            if let Ok(price) = result
                && price > 0.0
            {
                // Map every asset that uses this feed to the price.
                for asset in &self.assets {
                    if gas::usd_feed_for_asset(*asset).map(|(f, _)| f) == Some(feed) {
                        prices.insert(*asset, price);
                    }
                }
            }
        }
        prices
    }

    pub fn manifest(&self) -> &Manifest {
        &self.manifest
    }

    pub fn registry(&self) -> &Registry {
        &self.registry
    }

    pub fn provider(&self) -> &ChainProvider {
        &self.provider
    }

    /// Effective swap-size filter: the configured value, never below the hard
    /// floor derived from the profit target and round-trip cost.
    fn min_swap_usd(&self) -> f64 {
        effective_min_swap_usd(self.settings.min_swap_usd)
    }

    /// USD notional of a swap log, read from its USDC leg (USDC ≈ $1).
    /// `None` when the log is not a swap or the pool is unknown; those logs are
    /// left unfiltered rather than silently dropped.
    fn swap_notional_usd(&self, log: &Log) -> Option<f64> {
        let pool = self.registry.pool(*self.pool_index.get(&log.address())?);
        let decimals = self
            .registry
            .token(base::USDC)
            .map(|token| token.decimals)
            .unwrap_or(6);
        swap_notional_usd(log, pool, decimals)
    }

    pub async fn scan_once(&self) -> Result<ScanReport> {
        self.evaluate(None, ScanBlock::Latest).await
    }

    pub async fn scan_once_with(&self, block: ScanBlock) -> Result<ScanReport> {
        self.evaluate(None, block).await
    }

    /// Quote and simulate one explicit route. Used by the CLI `plan` command.
    pub async fn plan(&self, route: &Route, amount: U256) -> Result<Option<Opportunity>> {
        let pin = chain::Pin::resolve_latest(&self.provider).await?;
        let block_id = pin.id();
        let core = self.load_core_state(pin).await?;
        if core.paused {
            bail!("core is paused");
        }
        let (gas_snapshot, eth_usd) = self.gas_context(pin).await?;
        let asset_usd = gas::asset_usd_price(&self.provider, route.asset, &pin).await?;
        let symbol = self
            .manifest
            .token_symbol(route.asset)
            .or_else(|| {
                self.registry
                    .token(route.asset)
                    .map(|token| token.symbol.as_str())
            })
            .unwrap_or("?")
            .to_string();
        let decimals = self
            .registry
            .token(route.asset)
            .map(|token| token.decimals)
            .unwrap_or(18);

        if let Some(note) =
            gas_ceiling_note(&self.settings, core.max_gas_price, gas_snapshot.gas_price)
        {
            bail!(note);
        }

        let (quotes, _failed) = self
            .quote_jobs(
                std::slice::from_ref(route),
                &[(0usize, amount)],
                block_id,
                &HashMap::new(),
            )
            .await;
        let Some(Some(quotes)) = quotes.into_iter().next() else {
            bail!("could not quote route");
        };
        Ok(simulate_route(
            &self.provider,
            &self.manifest,
            &self.settings,
            &symbol,
            route.asset,
            decimals,
            route,
            amount,
            &quotes,
            &gas_snapshot,
            eth_usd,
            asset_usd,
            block_id,
            false,
        )
        .await
        .0)
    }

    pub async fn scan_trigger(&self, trigger: &Trigger) -> Result<ScanReport> {
        self.scan_triggers(std::slice::from_ref(trigger)).await
    }

    /// Process a batch of triggers as **at most one** scan.
    ///
    /// Single-trigger semantics are preserved exactly for a one-element batch.
    /// For larger batches: duplicates drop out, dust swaps drop out, head ticks
    /// only update the gap marker, and every surviving trigger contributes its
    /// pools to one union (`Reconnect` or an unknown pool forces the full
    /// scan). Pending-state triggers make the whole batch scan `Pending`.
    /// Trigger keys are recorded only after the shared scan succeeds, keeping
    /// the two-phase dedupe guarantee: a transient failure never suppresses
    /// the later mined duplicate of the same log.
    pub async fn scan_triggers(&self, triggers: &[Trigger]) -> Result<ScanReport> {
        let notional_of = |log: &Log| self.swap_notional_usd(log);
        let is_seen = |key: &TriggerKey| {
            self.deduper
                .lock()
                .expect("dedupe mutex poisoned")
                .contains(key)
        };
        // Scoped so the guard is dropped long before the evaluate await.
        let plan = {
            let mut last_block = self.last_block.lock().expect("last block mutex poisoned");
            plan_batch(
                triggers,
                &mut last_block,
                &self.pool_index,
                self.min_swap_usd(),
                &notional_of,
                &is_seen,
            )
        };

        let mut report = if plan.scan {
            let report = self.evaluate(plan.affected, plan.block).await?;
            // Two-phase dedupe: mark only now, after the scan succeeded.
            let mut deduper = self.deduper.lock().expect("dedupe mutex poisoned");
            for key in plan.keys {
                deduper.mark(key);
            }
            report
        } else {
            ScanReport::default()
        };
        for note in plan.notes {
            report.notes.push(note);
        }
        if plan.gap_rescan {
            report
                .notes
                .push("head gap detected; forced a full rescan".to_string());
        }
        Ok(report)
    }

    pub async fn evaluate(
        &self,
        affected: Option<Vec<usize>>,
        block: ScanBlock,
    ) -> Result<ScanReport> {
        // One block for the whole scan. Every read below, and the contract's
        // own simulation, use this pinned state; nothing re-reads "latest".
        let pin = match chain::Pin::resolve_latest(&self.provider).await {
            Ok(pin) => pin,
            Err(err) => {
                // A failed pin is "unknown", not "no opportunity": say so.
                warn!(error = %err, "could not pin a block; scan aborted");
                return Err(err);
            }
        };
        let block_id = pin.id();
        let head_started = Instant::now();
        let block_number = pin.number;
        // NOTE: deliberately does *not* touch `last_block`. That marker is
        // owned by `newHeads` alone; a scan writing its own pinned block there
        // made every scan slower than one block look like a skipped head, which
        // then forced a full rescan — the polling loop this design exists to
        // avoid. Freshness is reported by `head_drift` instead.

        let core = self.load_core_state(pin).await?;
        let mut report = ScanReport {
            block: block_number,
            pin_hash: pin.hash,
            core_ms: elapsed_millis(head_started),
            ..Default::default()
        };
        if core.paused {
            report.notes.push("core is paused".to_string());
            return Ok(report);
        }

        let gas_started = Instant::now();
        let (gas_snapshot, eth_usd) = self.gas_context(pin).await?;
        let asset_prices = self.asset_usd_prices(eth_usd, pin).await;
        report.gas_ms += elapsed_millis(gas_started);
        if eth_usd <= 0.0 {
            report
                .notes
                .push("ETH/USD feed unavailable; cannot gate on USD profit".to_string());
            return Ok(report);
        }

        let affected_set: Option<HashSet<usize>> =
            affected.map(|indices| indices.into_iter().collect());
        if let Some(indices) = &affected_set {
            report.affected_pools = indices
                .iter()
                .filter_map(|index| self.registry.pools.get(*index).map(|pool| pool.address))
                .collect();
            if indices.is_empty() {
                report.notes.push("no affected pools".to_string());
                return Ok(report);
            }
        }

        // One round-trip fetches every constant-product pool's reserves so the
        // probe/refine below can price those legs locally instead of via the
        // router. Shared across assets (same pinned block).
        let cp = self.cp_pools(block_id).await;

        // Assets are independent after the shared context is resolved, so
        // scan them concurrently. `buffered` (not `buffer_unordered`) keeps
        // completion order equal to `self.assets` order, so note ordering in
        // reports stays deterministic. The context is shared by reference;
        // each future copies the `&` (which is `Copy`) rather than moving the
        // owned value once and reusing it across assets.
        let core_ref = &core;
        let gas_ref = &gas_snapshot;
        let prices_ref = &asset_prices;
        let affected_ref = &affected_set;
        let cp_ref = &cp;
        let asset_reports =
            stream::iter(self.assets.iter().copied().map(move |asset| async move {
                let result = self
                    .scan_asset(
                        asset,
                        core_ref,
                        gas_ref,
                        eth_usd,
                        prices_ref,
                        affected_ref,
                        block,
                        block_id,
                        cp_ref,
                    )
                    .await;
                (asset, result)
            }))
            .buffered(self.assets.len().min(4))
            .collect::<Vec<_>>()
            .await;

        for (asset, result) in asset_reports {
            match result {
                Ok(asset_report) => {
                    report.notes.extend(asset_report.notes);
                    report.routes_considered += asset_report.routes_considered;
                    report.quotes += asset_report.quotes;
                    report.quote_failures += asset_report.quote_failures;
                    report.simulations += asset_report.simulations;
                    report.sims_cached += asset_report.sims_cached;
                    report.probe_ms += asset_report.probe_ms;
                    report.refine_ms += asset_report.refine_ms;
                    report.simulate_ms += asset_report.simulate_ms;
                    report.opportunities.extend(asset_report.opportunities);
                }
                Err(err) => {
                    warn!(asset = %asset, error = %err, "asset scan failed");
                    report
                        .notes
                        .push(format!("asset {asset} scan failed: {err}"));
                }
            }
        }

        report.opportunities.sort_by(|a, b| {
            b.net_usd
                .partial_cmp(&a.net_usd)
                .unwrap_or(std::cmp::Ordering::Equal)
        });

        // Freshness, made visible instead of silently mixed into the numbers.
        // Everything above describes one pinned block; this says how far the
        // chain moved while the scan worked. A failed read here must not
        // invalidate a scan that already completed, so drift is simply not
        // reported in that case.
        // Was the block we just scanned replaced while we worked? Cheaper and
        // safer than assuming: re-read the header at our own number and check
        // its hash. Reads can still succeed against a discarded block, so
        // without this a re-org would produce confident numbers about nothing.
        if pin.hash.is_some() {
            match chain::header_hash(&self.provider, pin.number).await {
                Ok(current) if pin.is_superseded_by(current) => {
                    report.reorged = true;
                    report.notes.push(format!(
                        "block {} was re-orged during this scan (its hash is now {});                          these numbers describe a discarded block and are void",
                        pin.number,
                        current.map(|h| h.to_string()).unwrap_or_default()
                    ));
                }
                // Cannot confirm is not the same as re-orged: say nothing here,
                // and let the numbers stand.
                Ok(None) => {}
                Err(err) => debug!(error = %err, "could not re-check the pinned block"),
                Ok(Some(_)) => {}
            }
        }

        if let Some(note) = scan_health_note(report.quotes, report.quote_failures) {
            report.notes.push(note);
        }
        if let Ok(head_now) = chain::block_number(&self.provider).await {
            report.head_drift = pin.blocks_behind(head_now);
            if report.head_drift > 0 {
                report.notes.push(format!(
                    "numbers describe block {} ({} blocks behind head {head_now})",
                    pin.number, report.head_drift
                ));
            }
        }
        Ok(report)
    }

    /// Read `paused`, `maxGasPrice`, and every asset cap in one Multicall3
    /// round-trip.
    ///
    /// The old code issued `2 + N` serial `eth_call`s. `paused` and
    /// `maxGasPrice` gate the whole scan, so if either cannot be read the scan
    /// bails rather than trading blind. Caps are fail-open exactly as before:
    /// a cap that reverts or is missing decodes to zero, which disables that
    /// asset. All reads share one block, so the state is consistent.
    async fn load_core_state(&self, pin: chain::Pin) -> Result<CoreState> {
        use alloy::sol_types::SolCall;

        let core = self.manifest.core;
        let mut calls: Vec<(Address, alloy::primitives::Bytes)> =
            Vec::with_capacity(2 + self.assets.len());
        calls.push((core, ryo::pausedCall {}.abi_encode().into()));
        calls.push((core, ryo::maxGasPriceCall {}.abi_encode().into()));
        for asset in &self.assets {
            calls.push((
                core,
                ryo::maxTradeSizeCall { asset: *asset }.abi_encode().into(),
            ));
        }
        let results = chain::multicall_raw(&self.provider, &calls, pin.id()).await;

        let paused = match results.first() {
            Some(Ok(data)) => {
                ryo::pausedCall::abi_decode_returns(data).context("failed to decode core.paused")?
            }
            Some(Err(reason)) => bail!("failed to read core.paused: {reason}"),
            None => bail!("core.paused result missing"),
        };
        let max_gas_price = match results.get(1) {
            Some(Ok(data)) => ryo::maxGasPriceCall::abi_decode_returns(data)
                .context("failed to decode core.maxGasPrice")?,
            Some(Err(reason)) => bail!("failed to read core.maxGasPrice: {reason}"),
            None => bail!("core.maxGasPrice result missing"),
        };

        let mut caps = HashMap::new();
        for (asset, result) in self.assets.iter().zip(results.iter().skip(2)) {
            let cap = match result {
                Ok(data) => ryo::maxTradeSizeCall::abi_decode_returns(data).unwrap_or(U256::ZERO),
                Err(_) => U256::ZERO,
            };
            caps.insert(*asset, cap);
        }

        Ok(CoreState {
            paused,
            max_gas_price,
            caps,
        })
    }

    /// Read every constant-product pool's live reserves (and, for Aerodrome,
    /// its governance fee) in **one** Multicall3 round-trip, and build the
    /// local-quote inputs keyed by pool index. Concentrated venues are omitted
    /// and stay on-chain. A pool whose reserve (or fee) read fails is simply
    /// left out, so its legs fall back to the remote quoter — local math is a
    /// pure accelerator and never removes a candidate.
    async fn cp_pools(&self, block: BlockId) -> HashMap<usize, ConstantProductPool> {
        use crate::abi::{aerodrome_factory, pool};
        use alloy::sol_types::SolCall;

        let mut out = HashMap::new();
        // (pool_index, curve, reserve_call_idx, fee_call_idx)
        let mut layout: Vec<(usize, Curve, usize, Option<usize>)> = Vec::new();
        let mut calls: Vec<(Address, alloy::primitives::Bytes)> = Vec::new();
        for (index, cp_pool) in self.registry.pools.iter().enumerate() {
            let curve = match cp_pool.venue {
                Venue::UniV2 => Curve::UniV2,
                Venue::Aerodrome { stable } => {
                    if stable {
                        Curve::AerodromeStable
                    } else {
                        Curve::AerodromeVolatile
                    }
                }
                Venue::UniV3 { .. } | Venue::Slipstream { .. } => continue,
            };
            let reserve_idx = calls.len();
            calls.push((
                cp_pool.address,
                pool::getReservesCall {}.abi_encode().into(),
            ));
            let fee_idx = match curve {
                Curve::UniV2 => None,
                Curve::AerodromeVolatile | Curve::AerodromeStable => {
                    let stable = matches!(curve, Curve::AerodromeStable);
                    let idx = calls.len();
                    calls.push((
                        base::AERODROME_FACTORY,
                        aerodrome_factory::getFeeCall {
                            pool: cp_pool.address,
                            stable,
                        }
                        .abi_encode()
                        .into(),
                    ));
                    Some(idx)
                }
            };
            layout.push((index, curve, reserve_idx, fee_idx));
        }
        if calls.is_empty() {
            return out;
        }

        let results = chain::multicall_raw(&self.provider, &calls, block).await;
        let decode_reserve = |data: &alloy::primitives::Bytes| -> Option<(U256, U256)> {
            let r = pool::getReservesCall::abi_decode_returns(data).ok()?;
            Some((r.reserve0, r.reserve1))
        };
        for (index, curve, reserve_idx, fee_idx) in layout {
            let cp_pool = &self.registry.pools[index];
            let Some((reserve0, reserve1)) = results
                .get(reserve_idx)
                .and_then(|value| value.as_ref().ok())
                .and_then(decode_reserve)
            else {
                continue;
            };
            let fee_bps = match curve {
                Curve::UniV2 => 0,
                Curve::AerodromeVolatile | Curve::AerodromeStable => {
                    match fee_idx
                        .and_then(|idx| results.get(idx))
                        .and_then(|value| value.as_ref().ok())
                        .and_then(|data| {
                            aerodrome_factory::getFeeCall::abi_decode_returns(data).ok()
                        }) {
                        // A fee above the 10_000 basis-point scale cannot be a
                        // price, so it is not priced locally either.
                        Some(fee) if fee <= AERO_FEE_MAX => fee.to::<u32>(),
                        Some(fee) => {
                            warn!(
                                pool = %cp_pool.address,
                                fee = %fee,
                                "implausible Aerodrome fee; pricing this pool remotely"
                            );
                            continue;
                        }
                        // Unknown fee -> do not price locally; remote quoter wins.
                        None => continue,
                    }
                }
            };
            let Some(decimals0) = self.registry.token(cp_pool.token0).map(|t| t.decimals) else {
                continue;
            };
            let Some(decimals1) = self.registry.token(cp_pool.token1).map(|t| t.decimals) else {
                continue;
            };
            // Unrepresentable `decimals` means the registry is wrong, not that
            // the pool is worthless; leave it to the on-chain quoter.
            let (Some(scale0), Some(scale1)) = (ten_pow(decimals0), ten_pow(decimals1)) else {
                warn!(
                    pool = %cp_pool.address,
                    decimals0, decimals1,
                    "token decimals outside the representable range; pricing this pool remotely"
                );
                continue;
            };
            out.insert(
                index,
                ConstantProductPool {
                    address: cp_pool.address,
                    curve,
                    token0: cp_pool.token0,
                    token1: cp_pool.token1,
                    reserve0,
                    reserve1,
                    fee_bps,
                    decimals0: scale0,
                    decimals1: scale1,
                },
            );
        }
        out
    }

    #[allow(clippy::too_many_arguments)]
    async fn scan_asset(
        &self,
        asset: Address,
        core: &CoreState,
        gas_snapshot: &GasSnapshot,
        eth_usd: f64,
        asset_prices: &HashMap<Address, f64>,
        affected: &Option<HashSet<usize>>,
        block: ScanBlock,
        block_id: BlockId,
        cp: &HashMap<usize, ConstantProductPool>,
    ) -> Result<AssetReport> {
        let mut report = AssetReport::default();
        let symbol = self
            .manifest
            .token_symbol(asset)
            .or_else(|| {
                self.registry
                    .token(asset)
                    .map(|token| token.symbol.as_str())
            })
            .unwrap_or("?")
            .to_string();
        let decimals = self
            .registry
            .token(asset)
            .map(|token| token.decimals)
            .unwrap_or(18);

        let manifest_cap = self.manifest.cap(&symbol).unwrap_or(U256::ZERO);
        let core_cap = core.caps.get(&asset).copied().unwrap_or(U256::ZERO);
        let cap = match (manifest_cap.is_zero(), core_cap.is_zero()) {
            (true, true) => {
                report
                    .notes
                    .push(format!("{symbol} cap is zero; asset is not tradable"));
                return Ok(report);
            }
            (true, false) => core_cap,
            (false, true) => manifest_cap,
            (false, false) => manifest_cap.min(core_cap),
        };

        // Gate before quoting: if gas is already too expensive, none of the
        // route work below can produce a tradable opportunity.
        if let Some(note) =
            gas_ceiling_note(&self.settings, core.max_gas_price, gas_snapshot.gas_price)
        {
            report.notes.push(note);
            return Ok(report);
        }

        let price = match asset_prices.get(&asset).copied() {
            Some(price) if price > 0.0 => price,
            _ => {
                report
                    .notes
                    .push(format!("{symbol} has no usable USD feed"));
                return Ok(report);
            }
        };

        let mut all_routes = self.routes.get(&asset).cloned().unwrap_or_default();
        if all_routes.is_empty() {
            all_routes = enumerate_cycles(&self.registry, asset, self.settings.max_hops);
        }
        if let Some(indices) = affected {
            all_routes.retain(|route| {
                route
                    .steps
                    .iter()
                    .any(|step| indices.contains(&step.pool_index))
            });
        }
        report.routes_considered += all_routes.len();
        if all_routes.is_empty() {
            return Ok(report);
        }

        // Coarse probe: quote every candidate at a few dollar amounts.
        let mut probe_amounts = Vec::new();
        for usd in &self.settings.probe_amounts_usd {
            let raw = usd_to_raw(*usd, price, decimals);
            let raw = raw.min(cap);
            if raw > U256::ZERO && !probe_amounts.contains(&raw) {
                probe_amounts.push(raw);
            }
        }
        if probe_amounts.is_empty() {
            report
                .notes
                .push(format!("{symbol} probe amount is zero after cap"));
            return Ok(report);
        }

        let mut best: HashMap<usize, (U256, Vec<U256>, U256)> = HashMap::new();
        let probe_started = Instant::now();
        // Probe every route at every amount in one leg-walking pass. The
        // amounts are independent, so the old per-amount batches were pure
        // latency: three sequential round-trip rounds became one.
        let mut jobs = Vec::with_capacity(all_routes.len() * probe_amounts.len());
        let mut best_keys = Vec::with_capacity(all_routes.len() * probe_amounts.len());
        let mut amounts = Vec::with_capacity(all_routes.len() * probe_amounts.len());
        for amount in &probe_amounts {
            for index in 0..all_routes.len() {
                jobs.push((index, *amount));
                best_keys.push(index);
                amounts.push(*amount);
            }
        }
        let (results, failed) = self.quote_jobs(&all_routes, &jobs, block_id, cp).await;
        report.quote_failures += failed;
        report.quotes += count_quotes(&results);
        update_best_from_jobs(&mut best, &best_keys, &amounts, &results);
        report.probe_ms += elapsed_millis(probe_started);

        // Refine the best routes on a local amount grid. Rank by absolute
        // profit, not by output/input ratio: ratio favours tiny trades and
        // systematically walks the bot away from the most profitable size.
        let mut ranked: Vec<(usize, U256)> = best
            .iter()
            .filter_map(|(index, (_, _, profit))| (!profit.is_zero()).then_some((*index, *profit)))
            .collect();
        ranked.sort_by_key(|entry| std::cmp::Reverse(entry.1));
        ranked.truncate(self.settings.max_candidates.max(1));
        if ranked.is_empty() {
            debug!(asset = %symbol, "no route quoted above break-even");
            return Ok(report);
        }

        let refined_routes: Vec<Route> = ranked
            .iter()
            .map(|(index, _)| all_routes[*index].clone())
            .collect();
        let base_amounts: Vec<U256> = ranked.iter().map(|(index, _)| best[index].0).collect();

        let mut factors = vec![0.5, 0.75, 1.0, 1.5, 2.0];
        factors.truncate(self.settings.amount_grid_points.max(1));
        let refine_started = Instant::now();
        // Build one flattened job list across all factor rounds. A factor
        // whose grid point scales any candidate to zero is skipped *whole*,
        // exactly as the old per-factor loop did.
        let mut refine_jobs: Vec<(usize, U256)> = Vec::new();
        let mut refine_keys: Vec<usize> = Vec::new();
        let mut refine_amounts: Vec<U256> = Vec::new();
        for factor in factors {
            let factor_amounts: Vec<U256> = base_amounts
                .iter()
                .map(|amount| scale_amount(*amount, factor).min(cap))
                .collect();
            if factor_amounts.iter().any(|amount| amount.is_zero()) {
                continue;
            }
            for (local_index, amount) in factor_amounts.into_iter().enumerate() {
                refine_jobs.push((local_index, amount));
                refine_keys.push(ranked[local_index].0);
                refine_amounts.push(amount);
            }
        }
        if !refine_jobs.is_empty() {
            let (quotes, refine_failed) = self
                .quote_jobs(&refined_routes, &refine_jobs, block_id, cp)
                .await;
            report.quote_failures += refine_failed;
            report.quotes += count_quotes(&quotes);
            update_best_from_jobs(&mut best, &refine_keys, &refine_amounts, &quotes);
        }
        report.refine_ms += elapsed_millis(refine_started);

        // Simulate the most promising routes. Quote profitability is only a
        // ranking signal; `simulate` is the source of truth.
        let mut ranked_finalists: Vec<(usize, U256)> = ranked
            .iter()
            .filter_map(|(index, _)| best.get(index).map(|(_, _, profit)| (*index, *profit)))
            .collect();
        ranked_finalists.sort_by_key(|entry| std::cmp::Reverse(entry.1));
        ranked_finalists.truncate(
            self.settings
                .max_candidates
                .min(self.settings.max_simulations.max(1)),
        );

        // Drop candidates whose previous simulation was a definitive loss with
        // bit-identical inputs (quotes, gas price, USD prices): the on-chain
        // outcome is a function of exactly those, so it cannot have changed.
        // Candidates without usable quotes stay `None` and are never cached.
        let mut to_simulate: Vec<(usize, FailedSimKey, Option<SimInputs>)> = Vec::new();
        for (index, _) in &ranked_finalists {
            let route = &all_routes[*index];
            let pools: Vec<usize> = route.steps.iter().map(|step| step.pool_index).collect();
            let (amount, quotes, _) =
                best.get(index)
                    .cloned()
                    .unwrap_or((U256::ZERO, Vec::new(), U256::ZERO));
            let key = (asset, amount, pools);
            let inputs = if amount.is_zero() || quotes.len() != route.steps.len() + 1 {
                None
            } else {
                Some(SimInputs {
                    quotes,
                    gas_price: gas_snapshot.gas_price,
                    asset_usd: price,
                    eth_usd,
                })
            };
            if let Some(inputs) = &inputs
                && self
                    .sim_cache
                    .lock()
                    .expect("sim cache mutex poisoned")
                    .is_unchanged_loss(&key, inputs)
            {
                report.sims_cached += 1;
                continue;
            }
            to_simulate.push((*index, key, inputs));
        }
        if report.sims_cached > 0 {
            debug!(
                asset = %symbol,
                cached = report.sims_cached,
                "losing candidates unchanged since their last simulation were skipped"
            );
        }

        let futures = stream::iter(to_simulate.iter().map(|(index, _, _)| {
            let route = all_routes[*index].clone();
            let (amount, quotes, _) =
                best.get(index)
                    .cloned()
                    .unwrap_or((U256::ZERO, Vec::new(), U256::ZERO));
            let provider = self.provider.clone();
            let manifest = self.manifest.clone();
            let settings = self.settings.clone();
            let symbol = symbol.clone();
            async move {
                if amount.is_zero() || quotes.len() != route.steps.len() + 1 {
                    return (None, false);
                }
                simulate_route(
                    &provider,
                    &manifest,
                    &settings,
                    &symbol,
                    asset,
                    decimals,
                    &route,
                    amount,
                    &quotes,
                    gas_snapshot,
                    eth_usd,
                    price,
                    block_id,
                    block == ScanBlock::Pending,
                )
                .await
            }
        }));

        let simulate_started = Instant::now();
        // `buffered` (not `buffer_unordered`) keeps input order so results
        // still pair with their cache keys after collection.
        let results: Vec<(Option<Opportunity>, bool)> = futures.buffered(4).collect().await;
        report.simulate_ms += elapsed_millis(simulate_started);
        report.simulations += results.len();
        for ((_index, key, inputs), (opportunity, definitive_loss)) in
            to_simulate.into_iter().zip(results)
        {
            if opportunity.is_none()
                && definitive_loss
                && let Some(inputs) = inputs
            {
                self.sim_cache
                    .lock()
                    .expect("sim cache mutex poisoned")
                    .remember_loss(key, inputs);
            }
            if let Some(opportunity) = opportunity {
                info!(
                    asset = %opportunity.asset_symbol,
                    net_usd = opportunity.net_usd,
                    profit_usd = opportunity.profit_usd,
                    gas_usd = opportunity.cost.total_fee_usd,
                    venues = ?opportunity.venues(),
                    "opportunity"
                );
                report.opportunities.push(opportunity);
            }
        }
        Ok(report)
    }

    /// Quote many independent (route, starting amount) jobs in a single
    /// leg-walking pass.
    ///
    /// Each job is `(route_index, amount_in)` where `route_index` addresses
    /// `routes`. Legs are walked one multicall round at a time across *all*
    /// jobs simultaneously: previously one round was issued per probe amount
    /// and per refine factor, serialising three-to-five independent batches.
    /// Identical `(target, calldata)` pairs collapse to one on-chain call.
    ///
    /// Returns one entry per job, parallel to `jobs`: `Some([in, out_leg1, ...])`
    /// on a fully quoted route, `None` if any leg failed or the route did not
    /// complete every step — plus how many remote legs the chain refused to
    /// price, which is missing information rather than a verdict.
    /// Quote many independent (route, starting amount) jobs in a single
    /// leg-walking pass.
    ///
    /// Each job is `(route_index, amount_in)` where `route_index` addresses
    /// `routes`. Legs are walked one round at a time across *all* jobs
    /// simultaneously. Constant-product legs (Uniswap V2, Aerodrome) priced
    /// from `cp` are computed **locally** at zero RPC cost; only concentrated
    /// legs (UniV3 / Slipstream) are batched into one multicall per round. A
    /// constant-product pool absent from `cp` (or a dust input it refuses)
    /// falls back to the on-chain quoter, so local math never changes the
    /// answer — it only removes round-trips. Identical `(target, calldata)`
    /// remote pairs collapse to one call.
    ///
    /// Returns one entry per job, parallel to `jobs`: `Some([in, out_leg1, ...])`
    /// on a fully quoted route, `None` if any leg failed or the route did not
    /// complete every step — plus how many remote legs the chain refused to
    /// price, which is missing information rather than a verdict.
    async fn quote_jobs(
        &self,
        routes: &[Route],
        jobs: &[(usize, U256)],
        block: BlockId,
        cp: &HashMap<usize, ConstantProductPool>,
    ) -> (Vec<Option<Vec<U256>>>, usize) {
        let mut failures = 0usize;
        let mut quotes: Vec<Option<Vec<U256>>> = jobs
            .iter()
            .map(|(route_index, amount)| {
                let route = &routes[*route_index];
                if amount.is_zero() || route.steps.is_empty() {
                    None
                } else {
                    Some(vec![*amount])
                }
            })
            .collect();

        let max_legs = jobs
            .iter()
            .map(|(route_index, _)| routes[*route_index].steps.len())
            .max()
            .unwrap_or(0);
        for leg in 0..max_legs {
            let mut requests: Vec<QuoteRequest> = Vec::new();
            let mut unique: HashMap<(Address, Bytes), usize> = HashMap::new();
            let mut request_for_job: Vec<Option<usize>> = vec![None; jobs.len()];
            let mut job_indices = Vec::new();
            for (job_index, (route_index, _)) in jobs.iter().enumerate() {
                // Copy the leg's running input and step *before* touching
                // `quotes` mutably, so the local branch can push in place.
                let input = match quotes.get(job_index) {
                    Some(Some(current)) => current.last().copied(),
                    _ => None,
                };
                let Some(input) = input else { continue };
                let Some(step) = routes[*route_index].steps.get(leg) else {
                    continue;
                };

                // Local constant-product leg. A refusal (dust input, a
                // non-converging stable iteration, an over-draw, an implausible
                // fee) is *not* evidence that the route is unprofitable, so it
                // must not delete the candidate: fall through to the quoter.
                if let LegPrice::Local(out) = price_leg(cp, step, input) {
                    if let Some(Some(current)) = quotes.get_mut(job_index) {
                        current.push(out);
                    }
                    continue;
                }

                match QuoteRequest::new(&self.manifest, step, input) {
                    Ok(request) => {
                        let key = (request.target, request.data.clone());
                        let request_index = if let Some(existing) = unique.get(&key) {
                            *existing
                        } else {
                            let new_index = requests.len();
                            requests.push(request);
                            unique.insert(key, new_index);
                            new_index
                        };
                        request_for_job[job_index] = Some(request_index);
                        job_indices.push(job_index);
                    }
                    Err(err) => {
                        debug!(error = %err, "failed to encode quote request");
                        failures += 1;
                        quotes[job_index] = None;
                    }
                }
            }
            if requests.is_empty() {
                continue;
            }
            let results = venues::quote_batch(&self.provider, &requests, block).await;
            for job_index in job_indices {
                let Some(request_index) = request_for_job[job_index] else {
                    continue;
                };
                let Some(result) = results.get(request_index) else {
                    failures += 1;
                    quotes[job_index] = None;
                    continue;
                };
                match result {
                    Ok(amount_out) => {
                        if let Some(Some(current)) = quotes.get_mut(job_index) {
                            current.push(*amount_out);
                        }
                    }
                    Err(err) => {
                        debug!(error = %err, "quote failed");
                        failures += 1;
                        quotes[job_index] = None;
                    }
                }
            }
        }

        (
            quotes
                .into_iter()
                .zip(jobs.iter())
                .map(|(quote, (route_index, _))| {
                    let route = &routes[*route_index];
                    quote.filter(|values| values.len() == route.steps.len() + 1)
                })
                .collect(),
            failures,
        )
    }
}

/// Quote-and-simulate one candidate. The flag reports whether the chain gave
/// a **definitive** answer (the route cannot pay at this market state), which
/// is the only kind of loss the failed-simulation cache may remember; network
/// or encoding trouble is inconclusive and must never suppress a retry.
#[allow(clippy::too_many_arguments)]
async fn simulate_route(
    provider: &ChainProvider,
    manifest: &Manifest,
    settings: &Settings,
    symbol: &str,
    asset: Address,
    decimals: u8,
    route: &Route,
    amount: U256,
    quotes: &[U256],
    gas_snapshot: &GasSnapshot,
    eth_usd: f64,
    asset_usd: f64,
    block: BlockId,
    preconfirmed: bool,
) -> (Option<Opportunity>, bool) {
    // Build the *real* trade first, then simulate exactly that. The old order
    // simulated with a permissive floor of 1 on every leg while proposing
    // 0.98x floors, so the profit reported was measured on calldata that would
    // have been a different — and reverting — trade. Quoting, flooring and
    // simulating all happen at the scan's single pinned block, so the floors
    // derived from these quotes describe the state the contract sees.
    let floors = build_floors(quotes, settings.per_leg_slippage_bps);
    let steps = match route.to_steps(manifest, &floors) {
        Ok(steps) => steps,
        Err(err) => {
            debug!(error = %err, "failed to build route steps");
            return (None, false);
        }
    };

    let simulation = match simulate::simulate(
        provider,
        manifest.core,
        asset,
        amount,
        steps.clone(),
        block,
    )
    .await
    {
        Ok(simulation) => simulation,
        Err(SimulateError::Revert { decoded, .. }) => {
            debug!(route = ?route.venues(), %decoded, "simulation reverted");
            return (None, true);
        }
        Err(SimulateError::Transport(message)) => {
            warn!(error = %message, "simulation transport failure");
            return (None, false);
        }
        Err(SimulateError::UnexpectedSuccess(_)) => {
            warn!("simulate unexpectedly succeeded; check the ABI");
            return (None, false);
        }
    };

    if simulation.profit <= I256::ZERO {
        return (None, true);
    }
    let profit_raw: U256 = match simulation.profit.try_into() {
        Ok(value) => value,
        Err(_) => return (None, false),
    };

    let buffer = U256::from(settings.min_profit_buffer_bps.min(9_999));
    let min_profit = profit_raw.saturating_mul(U256::from(10_000) - buffer) / U256::from(10_000);
    let call = ryo::executeCall {
        asset,
        amount,
        steps,
        minProfit: min_profit,
    };
    let calldata = Bytes::from(call.abi_encode());
    let Ok(route_hash) = route.route_hash(manifest, &floors) else {
        return (None, false);
    };

    let gas_used = match chain::estimate_gas_from(
        provider,
        manifest.core,
        calldata.clone(),
        Some(manifest.operator),
    )
    .await
    {
        Ok(gas) => gas,
        Err(err) => {
            debug!(error = %err, "gas estimate failed; using fallback");
            settings.fallback_gas
        }
    };

    let cost = gas::trade_cost(
        gas_used,
        gas_snapshot.gas_price,
        gas_snapshot.l1_fee_upper_bound,
        eth_usd,
    );
    let profit_usd = gas::profit_usd(profit_raw, decimals, asset_usd);
    let net_usd = profit_usd - cost.total_fee_usd;
    debug!(
        route = ?route.venues(),
        amount = %amount,
        profit_raw = %profit_raw,
        profit_usd,
        gas_used,
        gas_price = %gas_snapshot.gas_price,
        gas_usd = cost.total_fee_usd,
        net_usd,
        min_net_usd = settings.min_net_profit_usd,
        "simulation economics"
    );
    if net_usd < settings.min_net_profit_usd {
        return (None, true);
    }

    (
        Some(Opportunity {
            asset,
            asset_symbol: symbol.to_string(),
            amount,
            route: route.clone(),
            quotes: quotes.to_vec(),
            simulated_profit: simulation.profit,
            floors,
            min_profit,
            route_hash,
            calldata,
            gas_used,
            gas_price: gas_snapshot.gas_price,
            cost,
            profit_usd,
            net_usd,
            block: gas_snapshot.block_number,
            preconfirmed,
        }),
        false,
    )
}

fn count_quotes(quotes: &[Option<Vec<U256>>]) -> usize {
    quotes
        .iter()
        .filter_map(|quote| quote.as_ref())
        .map(|quote| quote.len().saturating_sub(1))
        .sum()
}

/// Fold a batch of quoted jobs into `best`, keyed by `best_keys`.
///
/// `jobs` are parallel to the batcher's job list: `best_keys[i]` is the entry
/// in `best` for job `i`, `amounts[i]` is that job's input, and `results[i]`
/// is the `[in, out1, ...]` path (or `None`). Ranking uses absolute profit
/// (`output - amount`) and only replaces on a strict improvement, so iterating
/// the flattened job list reproduces the previous per-amount / per-factor order
/// exactly.
fn update_best_from_jobs(
    best: &mut HashMap<usize, (U256, Vec<U256>, U256)>,
    best_keys: &[usize],
    amounts: &[U256],
    results: &[Option<Vec<U256>>],
) {
    for ((key, amount), result) in best_keys.iter().zip(amounts.iter()).zip(results) {
        let Some(values) = result else { continue };
        let Some(output) = values.last().copied() else {
            continue;
        };
        if amount.is_zero() {
            continue;
        }
        // `asset -> ... -> asset`, so output and input share units. Absolute
        // profit is the right ranking signal; ratio would prefer 1 wei trades.
        let profit = output.saturating_sub(*amount);
        if profit.is_zero() {
            continue;
        }
        let replace = best
            .get(key)
            .map(|(_, _, old_profit)| profit > *old_profit)
            .unwrap_or(true);
        if replace {
            best.insert(*key, (*amount, values.clone(), profit));
        }
    }
}

/// Decide whether a head notification means work was skipped.
///
/// A forward jump means at least one block was never evaluated (dropped
/// message or a stall). A lower head means the chain reorganised and the
/// previous scan is stale. Consecutive heads need no rescan.
fn head_requires_rescan(last: Option<u64>, head: u64) -> bool {
    match last {
        Some(last) => head > last.saturating_add(1) || head < last,
        None => false,
    }
}

/// Distinguish "nothing to find" from "we could not look".
///
/// A leg the chain refuses to price used to be indistinguishable from an
/// unprofitable route, both surfacing as zero opportunities. On a re-org, a
/// rate limit, or a quoter revert that blindness is total and silent, so any
/// failure is reported with its share of the work attempted.
fn scan_health_note(quotes: usize, failures: usize) -> Option<String> {
    if failures == 0 {
        return None;
    }
    let attempted = quotes + failures;
    Some(format!(
        "{failures} of {attempted} leg quotes could not be priced ({:.0}%); this scan is \
         incomplete, and zero opportunities here does not mean no opportunity existed",
        100.0 * failures as f64 / attempted.max(1) as f64
    ))
}

fn effective_min_swap_usd(configured: f64) -> f64 {
    configured.max(ABSOLUTE_MIN_SWAP_USD)
}

/// Everything a trigger batch decides, with no I/O: whether a scan is due,
/// which pools the batch collectively affects, which block state to quote,
/// which trigger keys may be marked seen after a successful scan, and the
/// disposition notes. Kept pure so coalescing semantics are unit-testable.
#[derive(Debug, Clone, PartialEq, Eq)]
struct BatchPlan {
    keys: Vec<TriggerKey>,
    affected: Option<Vec<usize>>,
    block: ScanBlock,
    scan: bool,
    gap_rescan: bool,
    notes: Vec<String>,
}

/// Classify a batch of triggers into at most one scan. Single-trigger
/// semantics are preserved exactly for one-element batches.
fn plan_batch(
    triggers: &[Trigger],
    last_block: &mut Option<u64>,
    pool_index: &HashMap<Address, usize>,
    min_swap_usd: f64,
    notional_of: &dyn Fn(&Log) -> Option<f64>,
    is_seen: &dyn Fn(&TriggerKey) -> bool,
) -> BatchPlan {
    let mut notes = NotesBuilder::new(triggers.len());
    let mut keys: Vec<TriggerKey> = Vec::new();
    let mut batch_keys: HashSet<TriggerKey> = HashSet::new();
    let mut pools: HashSet<usize> = HashSet::new();
    let mut full_scan = false;
    let mut block = ScanBlock::Latest;
    let mut gap_rescan = false;

    for trigger in triggers {
        let key = TriggerKey::from_trigger(trigger);
        if let Some(candidate) = &key
            && (is_seen(candidate) || !batch_keys.insert(candidate.clone()))
        {
            notes.duplicate();
            continue;
        }

        match trigger {
            Trigger::Head { number } => {
                let previous = *last_block;
                // Heads are liveness markers. Advance the marker on every
                // head so idle stretches do not look like gaps; only a real
                // jump or a backwards head triggers the full rescan.
                *last_block = Some(*number);
                if head_requires_rescan(previous, *number) {
                    gap_rescan = true;
                    full_scan = true;
                } else {
                    notes.head_tick(*number);
                }
            }
            Trigger::Reconnect => full_scan = true,
            Trigger::Log { log, preconfirmed } => {
                if let Some(notional) = notional_of(log)
                    && notional < min_swap_usd
                {
                    notes.dust(notional, min_swap_usd);
                    // Never marked as seen: the later mined duplicate of the
                    // same log must still be evaluated.
                    if let Some(candidate) = &key {
                        batch_keys.remove(candidate);
                    }
                    continue;
                }
                if *preconfirmed {
                    block = ScanBlock::Pending;
                }
                match pool_index.get(&log.address()).copied() {
                    Some(index) => {
                        pools.insert(index);
                        if let Some(candidate) = key {
                            keys.push(candidate);
                        }
                    }
                    // An unknown pool tells us nothing about which routes
                    // moved; scan everything rather than guess.
                    None => {
                        full_scan = true;
                        if let Some(candidate) = key {
                            keys.push(candidate);
                        }
                    }
                }
            }
            Trigger::Flashblock { logs, .. } => {
                let mut contributed = false;
                for log in logs {
                    let Some(index) = pool_index.get(&log.address()).copied() else {
                        continue;
                    };
                    if let Some(notional) = notional_of(log)
                        && notional < min_swap_usd
                    {
                        continue;
                    }
                    pools.insert(index);
                    contributed = true;
                }
                if contributed {
                    block = ScanBlock::Pending;
                    if let Some(candidate) = key {
                        keys.push(candidate);
                    }
                } else {
                    // A flashblock transaction list without logs does not
                    // tell us which pools changed. Skip rather than scan
                    // everything on every flashblock.
                    notes.flashblock_empty();
                    if let Some(candidate) = &key {
                        batch_keys.remove(candidate);
                    }
                }
            }
        }
    }

    let scan = full_scan || !pools.is_empty();
    let affected = if scan && !full_scan {
        let mut indices: Vec<usize> = pools.into_iter().collect();
        indices.sort_unstable();
        Some(indices)
    } else {
        None
    };
    let mut out = Vec::new();
    notes.finish_into(&mut out);
    BatchPlan {
        keys,
        affected,
        block,
        scan,
        gap_rescan,
        notes: out,
    }
}

/// Collects batch-disposition notes. A one-element batch must report exactly
/// what the old single-trigger path reported, so single mode keeps the
/// historical strings and larger batches get aggregate counts.
struct NotesBuilder {
    total: usize,
    duplicates: usize,
    head_ticks: Vec<u64>,
    first_dust: Option<String>,
    dust_count: usize,
    flashblocks_empty: usize,
}

impl NotesBuilder {
    fn new(total: usize) -> Self {
        Self {
            total,
            duplicates: 0,
            head_ticks: Vec::new(),
            first_dust: None,
            dust_count: 0,
            flashblocks_empty: 0,
        }
    }

    fn duplicate(&mut self) {
        self.duplicates += 1;
    }

    fn head_tick(&mut self, number: u64) {
        self.head_ticks.push(number);
    }

    fn dust(&mut self, notional: f64, floor: f64) {
        if self.first_dust.is_none() {
            self.first_dust = Some(format!(
                "swap ~${notional:.0} below the ${floor:.0} minimum; skipped"
            ));
        }
        self.dust_count += 1;
    }

    fn flashblock_empty(&mut self) {
        self.flashblocks_empty += 1;
    }

    fn finish_into(self, notes: &mut Vec<String>) {
        if self.total == 1 {
            if self.duplicates == 1 {
                notes.push("duplicate trigger skipped".to_string());
            }
            for number in &self.head_ticks {
                notes.push(format!("head tick {number} (no scan)"));
            }
            if let Some(note) = &self.first_dust {
                notes.push(note.clone());
            }
            if self.flashblocks_empty == 1 {
                notes.push("flashblock contained no qualifying pool logs".to_string());
            }
            return;
        }
        if self.duplicates > 0 {
            notes.push(format!("{} duplicate triggers skipped", self.duplicates));
        }
        if !self.head_ticks.is_empty() {
            notes.push(format!("{} head ticks (no scan)", self.head_ticks.len()));
        }
        if self.dust_count > 0 {
            notes.push(format!(
                "{} swaps skipped below the size minimum",
                self.dust_count
            ));
        }
        if self.flashblocks_empty > 0 {
            notes.push(format!(
                "{} flashblocks contained no qualifying pool logs",
                self.flashblocks_empty
            ));
        }
    }
}

fn elapsed_millis(started: Instant) -> u64 {
    started.elapsed().as_millis() as u64
}

fn swap_notional_usd(log: &Log, pool: &crate::routes::Pool, usdc_decimals: u8) -> Option<f64> {
    let concentrated = matches!(pool.venue, Venue::UniV3 { .. } | Venue::Slipstream { .. });
    let (amount0, amount1) = history::swap_deltas(log, concentrated)?;
    let usdc = if pool.token0 == base::USDC {
        amount0
    } else if pool.token1 == base::USDC {
        amount1
    } else {
        return None;
    };
    Some(gas::raw_to_f64(usdc.unsigned_abs(), usdc_decimals))
}

/// Return the reason gas is too expensive, or `None` when both ceilings pass.
fn gas_ceiling_note(
    settings: &Settings,
    core_max_gas_price: U256,
    gas_price: U256,
) -> Option<String> {
    // `f64 as u128` saturates, so a non-finite or negative setting would
    // otherwise surface as a nonsensical "ceiling 0 wei" and silently blind
    // every scan. Fail closed either way, but name the real cause.
    let ceiling_gwei = settings.max_gas_price_gwei;
    if !ceiling_gwei.is_finite() || ceiling_gwei < 0.0 {
        return Some(format!(
            "configured gas ceiling {ceiling_gwei} gwei is not a number of gwei; \
             refusing to trade (set RYO_MAX_GAS_PRICE_GWEI)"
        ));
    }
    let watcher_max = U256::from((ceiling_gwei * 1e9) as u128);
    if gas_price > watcher_max {
        return Some(format!(
            "gas price {gas_price} wei exceeds watcher ceiling {watcher_max} wei"
        ));
    }
    if !core_max_gas_price.is_zero() && gas_price > core_max_gas_price {
        return Some(format!(
            "gas price {gas_price} wei exceeds core ceiling {core_max_gas_price} wei"
        ));
    }
    None
}

fn build_floors(quotes: &[U256], slippage_bps: u32) -> Vec<U256> {
    let keep = 10_000u32.saturating_sub(slippage_bps.min(9_999));
    quotes
        .iter()
        .skip(1)
        .map(|output| {
            let floor = output.saturating_mul(U256::from(keep)) / U256::from(10_000);
            floor.max(U256::from(1u8))
        })
        .collect()
}

fn usd_to_raw(usd: f64, price: f64, decimals: u8) -> U256 {
    if !usd.is_finite() || !price.is_finite() || usd <= 0.0 || price <= 0.0 {
        return U256::ZERO;
    }
    let raw = usd / price * 10f64.powi(decimals as i32);
    if !raw.is_finite() || raw <= 0.0 || raw > u128::MAX as f64 {
        return U256::ZERO;
    }
    U256::from(raw.round() as u128)
}

fn scale_amount(amount: U256, factor: f64) -> U256 {
    if !factor.is_finite() || factor <= 0.0 {
        return U256::ZERO;
    }
    let scaled = u256_to_f64(amount) * factor;
    if !scaled.is_finite() || scaled <= 0.0 || scaled > u128::MAX as f64 {
        return U256::ZERO;
    }
    U256::from(scaled.round() as u128)
}

fn u256_to_f64(value: U256) -> f64 {
    value.to_string().parse::<f64>().unwrap_or(0.0)
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::routes::{Pool, Registry};
    use alloy::primitives::keccak256;
    use serde_json::json;

    const SWAP_V3_SIG: &str = "Swap(address,address,int256,int256,uint160,uint128,int24)";
    const SWAP_SOLIDLY_SIG: &str = "Swap(address,address,uint256,uint256,uint256,uint256)";

    fn hex_word(value: &str) -> String {
        format!("{value:0>64}")
    }

    fn signed_word(value: i64) -> String {
        let raw = if value < 0 {
            U256::MAX - U256::from(value.unsigned_abs() - 1)
        } else {
            U256::from(value as u64)
        };
        format!("{raw:064x}")
    }

    fn log_from_json(value: serde_json::Value) -> Log {
        serde_json::from_value(value).expect("log json")
    }

    /// All USDC/WETH pools list WETH as token0 and USDC as token1.
    fn weth_usdc_pool(venue: Venue) -> Pool {
        Pool {
            address: base::WETH,
            venue,
            token0: base::WETH,
            token1: base::USDC,
        }
    }

    /// Concentrated swap with `usdc` (6-decimal units) as the token1 leg.
    fn v3_swap(usdc: i64) -> Log {
        let data = format!(
            "0x{}{}{}{}{}",
            hex_word("0"),
            signed_word(usdc),
            hex_word("0"),
            hex_word("0"),
            hex_word("0")
        );
        log_from_json(json!({
            "address": base::WETH.to_string(),
            "topics": [format!("{:#x}", keccak256(SWAP_V3_SIG.as_bytes()))],
            "data": data,
            "blockNumber": "0x1",
            "transactionIndex": "0x0",
            "logIndex": "0x0"
        }))
    }

    /// Solidly swap with the USDC leg as token1: `usdc_in - usdc_out`.
    fn solidly_swap(usdc_in: u64, usdc_out: u64) -> Log {
        let data = format!(
            "0x{}{}{}{}",
            hex_word("0"),
            hex_word(&format!("{usdc_in:x}")),
            hex_word("0"),
            hex_word(&format!("{usdc_out:x}"))
        );
        log_from_json(json!({
            "address": base::WETH.to_string(),
            "topics": [format!("{:#x}", keccak256(SWAP_SOLIDLY_SIG.as_bytes()))],
            "data": data,
            "blockNumber": "0x1",
            "transactionIndex": "0x0",
            "logIndex": "0x0"
        }))
    }

    #[test]
    fn notional_reads_the_usdc_leg() {
        let pool = weth_usdc_pool(Venue::UniV3 { fee: 500 });
        // Direction does not matter for size: +750 and -750 are both $750.
        assert_eq!(
            swap_notional_usd(&v3_swap(750_000_000), &pool, 6),
            Some(750.0)
        );
        assert_eq!(
            swap_notional_usd(&v3_swap(-750_000_000), &pool, 6),
            Some(750.0)
        );
    }

    #[test]
    fn solidly_notional_uses_signed_delta() {
        let pool = weth_usdc_pool(Venue::Aerodrome { stable: false });
        // 2,000 USDC into the pool: positive token1 delta.
        assert_eq!(
            swap_notional_usd(&solidly_swap(2_000_000_000, 0), &pool, 6),
            Some(2_000.0)
        );
        // 500 USDC out and no USDC in: negative delta, same size.
        assert_eq!(
            swap_notional_usd(&solidly_swap(0, 500_000_000), &pool, 6),
            Some(500.0)
        );
    }

    #[test]
    fn dust_swaps_fall_below_the_default_floor() {
        let pool = weth_usdc_pool(Venue::UniV3 { fee: 500 });
        let floor = effective_min_swap_usd(Settings::default().min_swap_usd);
        let dust = swap_notional_usd(&v3_swap(30_000_000), &pool, 6).expect("notional");
        assert!(dust < floor, "dust {dust} should be below floor {floor}");
        let large = swap_notional_usd(&v3_swap(5_000_000_000), &pool, 6).expect("notional");
        assert!(large >= floor, "large {large} should pass floor {floor}");
    }

    #[test]
    fn pool_without_a_usdc_leg_has_no_notional() {
        let pool = Pool {
            address: base::WETH,
            venue: Venue::UniV3 { fee: 500 },
            token0: base::WETH,
            token1: base::EURC,
        };
        assert!(swap_notional_usd(&v3_swap(750_000_000), &pool, 6).is_none());
    }

    #[test]
    fn non_swap_log_has_no_notional() {
        let pool = weth_usdc_pool(Venue::UniV3 { fee: 500 });
        let log = log_from_json(json!({
            "address": base::WETH.to_string(),
            "topics": [format!(
                "{:#x}",
                keccak256("Mint(address,address,int24,int24,uint256,uint256)".as_bytes())
            )],
            "data": format!("0x{}", hex_word("0")),
            "blockNumber": "0x1",
            "transactionIndex": "0x0",
            "logIndex": "0x0"
        }));
        assert!(swap_notional_usd(&log, &pool, 6).is_none());
    }

    #[test]
    fn builds_floors_with_slippage() {
        let floors = build_floors(
            &[U256::from(1_000), U256::from(2_000), U256::from(4_000)],
            100,
        );
        assert_eq!(floors, vec![U256::from(1_980), U256::from(3_960)]);
    }

    #[test]
    fn floors_are_never_zero() {
        let floors = build_floors(&[U256::from(100), U256::from(1)], 9_999);
        assert!(floors.iter().all(|floor| *floor >= U256::from(1)));
    }

    #[test]
    fn usd_conversion_respects_decimals() {
        assert_eq!(usd_to_raw(1_000.0, 2_000.0, 6), U256::from(500_000u64));
        assert_eq!(
            usd_to_raw(1_000.0, 2_000.0, 18),
            U256::from(500_000_000_000_000_000u64)
        );
    }

    #[test]
    fn amount_scaling_round_trips() {
        let base = U256::from(1_000_000u64);
        assert_eq!(scale_amount(base, 1.0), base);
        assert_eq!(scale_amount(base, 0.5), U256::from(500_000u64));
    }

    #[test]
    fn head_gap_logic() {
        assert!(!head_requires_rescan(None, 100));
        assert!(!head_requires_rescan(Some(100), 100));
        assert!(!head_requires_rescan(Some(100), 101));
        assert!(head_requires_rescan(Some(100), 102));
        assert!(head_requires_rescan(Some(100), 99));
    }

    #[test]
    fn swap_size_filter_has_a_hard_floor() {
        assert_eq!(effective_min_swap_usd(0.0), ABSOLUTE_MIN_SWAP_USD);
        assert_eq!(effective_min_swap_usd(10.0), ABSOLUTE_MIN_SWAP_USD);
        assert_eq!(effective_min_swap_usd(500.0), 500.0);
        assert_eq!(effective_min_swap_usd(1_000.0), 1_000.0);
    }

    #[test]
    fn dedupe_marks_only_when_asked() {
        let mut deduper = Deduper::default();
        let key = TriggerKey::Log {
            tx: B256::ZERO,
            index: 7,
        };
        assert!(!deduper.contains(&key));
        deduper.mark(key.clone());
        assert!(deduper.contains(&key));
        deduper.mark(key.clone());
        assert_eq!(deduper.order.len(), 1);
    }

    /// "Nothing to find" and "nothing could be priced" must not look alike.
    #[test]
    fn health_note_separates_an_empty_market_from_a_blinded_scan() {
        assert_eq!(scan_health_note(500, 0), None);

        let note = scan_health_note(0, 40).expect("all legs unpriced must be reported");
        assert!(note.contains("40 of 40"), "{note}");
        assert!(
            note.contains("does not mean no opportunity existed"),
            "the note has to say the failure is not a verdict: {note}"
        );

        // A handful of unpriced legs inside a large scan still gets reported,
        // with the share so an operator can judge it.
        let partial = scan_health_note(990, 10).expect("partial blindness is a note");
        assert!(partial.contains("10 of 1000"), "{partial}");
        assert!(partial.contains("1%"), "{partial}");

        // Never a division by zero on an all-failed, zero-quote scan.
        assert!(scan_health_note(0, 1).is_some());
    }

    #[test]
    fn gas_ceiling_gate() {
        let settings = Settings::default();
        // 0.05 gwei ceiling: 40M wei passes, 60M wei fails.
        assert!(gas_ceiling_note(&settings, U256::ZERO, U256::from(40_000_000u64)).is_none());
        assert!(gas_ceiling_note(&settings, U256::ZERO, U256::from(60_000_000u64)).is_some());
        // A non-zero core ceiling also applies.
        assert!(
            gas_ceiling_note(
                &settings,
                U256::from(30_000_000u64),
                U256::from(40_000_000u64)
            )
            .is_some()
        );
    }

    /// `f64 as u128` saturates, so a typo'd or infinite ceiling used to surface
    /// as "ceiling 0 wei" — every scan rejected for a reason that blamed the
    /// chain rather than the config. It still fails closed; now it says so.
    #[test]
    fn gas_ceiling_names_a_misconfigured_ceiling() {
        let price = U256::from(1_000_000u64);
        for bad in [f64::NAN, f64::INFINITY, -1.0] {
            let settings = Settings {
                max_gas_price_gwei: bad,
                ..Settings::default()
            };
            let note = gas_ceiling_note(&settings, U256::ZERO, price)
                .expect("a non-numeric ceiling must reject, not silently pass");
            assert!(
                note.contains("not a number of gwei") && note.contains("RYO_MAX_GAS_PRICE_GWEI"),
                "note blames the wrong thing: {note}"
            );
        }
        // A sane ceiling still passes its own price.
        let settings = Settings {
            max_gas_price_gwei: 0.05,
            ..Settings::default()
        };
        assert!(gas_ceiling_note(&settings, U256::ZERO, U256::from(40_000_000u64)).is_none());
    }

    /// Pins the current slippage-floor behaviour, including its wart: a leg
    /// whose quoted output is smaller than the floor rounds **up to 1**, which
    /// switches that leg's slippage protection off. Harmless for a paper watcher
    /// (such a route cannot clear a USD profit gate), but it is the kind of
    /// default that must not survive into real execution unnoticed.
    #[test]
    fn floors_saturate_to_one_for_dust_outputs() {
        let quotes = [
            U256::from(1_000_000_000u64),
            U256::from(1u8),
            U256::from(300u64),
        ];
        let floors = build_floors(&quotes, 20);
        assert_eq!(floors.len(), 2, "the starting amount is not a leg output");
        assert_eq!(
            floors[0],
            U256::from(1u8),
            "a dust output floors to 1: no real slippage protection on that leg"
        );
        assert_eq!(
            floors[1],
            U256::from(299u64),
            "300 * 9980 / 10000 truncates"
        );

        // The floor can never exceed the quote, and never underflows.
        for (quote, floor) in quotes.iter().skip(1).zip(&floors) {
            assert!(floor <= quote, "{floor} > {quote}");
        }
    }

    #[test]
    fn affected_filter_selects_routes() {
        let registry = Registry::base_usdc_weth().unwrap();
        let routes = enumerate_cycles(&registry, base::USDC, 2);
        let affected = HashSet::from([0usize]);
        let filtered: Vec<_> = routes
            .into_iter()
            .filter(|route| {
                route
                    .steps
                    .iter()
                    .any(|step| affected.contains(&step.pool_index))
            })
            .collect();
        assert_eq!(filtered.len(), 22);
    }

    #[test]
    fn scan_report_starts_with_zero_timings() {
        let report = ScanReport::default();
        assert_eq!(report.core_ms, 0);
        assert_eq!(report.gas_ms, 0);
        assert_eq!(report.probe_ms, 0);
        assert_eq!(report.refine_ms, 0);
        assert_eq!(report.simulate_ms, 0);
        assert_eq!(report.sims_cached, 0);
    }

    fn sim_inputs(quotes: &[u64], gas_price: u64, asset_usd: f64, eth_usd: f64) -> SimInputs {
        SimInputs {
            quotes: quotes.iter().map(|q| U256::from(*q)).collect(),
            gas_price: U256::from(gas_price),
            asset_usd,
            eth_usd,
        }
    }

    #[test]
    fn failed_sim_cache_skips_only_unchanged_losses() {
        let asset = Address::repeat_byte(0x11);
        let key = |amount: u64, pools: &[usize]| (asset, U256::from(amount), pools.to_vec());
        let mut cache = FailedSimCache::default();
        let base = sim_inputs(&[1000, 900, 990], 20, 0.5, 3000.0);
        cache.remember_loss(key(1000, &[1, 3]), base.clone());

        // Bit-identical inputs ⇒ provably identical simulation outcome.
        assert!(
            cache.is_unchanged_loss(&key(1000, &[1, 3]), &base),
            "same inputs must skip"
        );
        // A later trigger on another pool changes nothing about this check.
        assert!(cache.is_unchanged_loss(&key(1000, &[1, 3]), &base.clone()));

        // Any input the sim or the USD gates read moving invalidates the loss.
        assert!(!cache.is_unchanged_loss(
            &key(1000, &[1, 3]),
            &sim_inputs(&[1000, 899, 990], 20, 0.5, 3000.0)
        ));
        assert!(!cache.is_unchanged_loss(
            &key(1000, &[1, 3]),
            &sim_inputs(&[1000, 900, 990], 21, 0.5, 3000.0)
        ));
        assert!(!cache.is_unchanged_loss(
            &key(1000, &[1, 3]),
            &sim_inputs(&[1000, 900, 990], 20, 0.6, 3000.0)
        ));
        assert!(!cache.is_unchanged_loss(
            &key(1000, &[1, 3]),
            &sim_inputs(&[1000, 900, 990], 20, 0.5, 3100.0)
        ));

        // Amount is part of the identity: another size was never tested.
        assert!(!cache.is_unchanged_loss(&key(2000, &[1, 3]), &base));
        // Route identity too: the same amount over other pools is new work.
        assert!(!cache.is_unchanged_loss(&key(1000, &[1, 4]), &base));
    }

    #[test]
    fn failed_sim_cache_survives_full_scans_when_inputs_match() {
        // The pin is the simulation's inputs, not which scans ran in between:
        // a full scan no longer has to know "what moved" — different quotes
        // simply stop matching, while an unchanged market keeps skipping even
        // across reconnect-triggered full scans.
        let asset = Address::repeat_byte(0x11);
        let key = (asset, U256::from(1000u64), vec![0usize, 1]);
        let mut cache = FailedSimCache::default();
        let base = sim_inputs(&[1000, 900, 990], 20, 0.5, 3000.0);
        cache.remember_loss(key.clone(), base.clone());
        assert!(cache.is_unchanged_loss(&key, &base));
        // Same candidate quoted after more market activity: inputs moved, so
        // the candidate is re-simulated.
        let refreshed = sim_inputs(&[1000, 910, 992], 20, 0.5, 3000.0);
        assert!(!cache.is_unchanged_loss(&key, &refreshed));
        cache.remember_loss(key.clone(), refreshed.clone());
        assert!(cache.is_unchanged_loss(&key, &refreshed));
    }

    #[test]
    fn failed_sim_cache_is_bounded() {
        let asset = Address::repeat_byte(0x11);
        let mut cache = FailedSimCache::default();
        for amount in 0..(FAILED_SIM_CACHE_CAP as u64 + 1) {
            cache.remember_loss(
                (asset, U256::from(amount), vec![0]),
                sim_inputs(&[amount], 20, 0.5, 3000.0),
            );
        }
        assert!(
            cache.losses.len() <= FAILED_SIM_CACHE_CAP,
            "cache must clear itself instead of growing forever"
        );
    }

    #[test]
    fn elapsed_millis_measures_the_sleep() {
        let started = Instant::now();
        std::thread::sleep(std::time::Duration::from_millis(15));
        let first = elapsed_millis(started);
        assert!(first >= 15, "elapsed {first} should include the sleep");
    }

    fn w(v: u32) -> U256 {
        U256::from(v)
    }

    #[test]
    fn update_best_from_jobs_keeps_absolute_profit_winner() {
        // One route (key 7) probed at three amounts; the middle amount is the
        // most profitable in absolute terms. Ranking must follow absolute
        // profit, not output/input ratio (which would prefer the smallest).
        let keys = [7usize, 7, 7];
        let amounts = [w(100), w(1_000), w(5_000)];
        let results = [
            Some(vec![w(100), w(140)]),     // profit 40, ratio 1.4
            Some(vec![w(1_000), w(1_120)]), // profit 120, ratio 1.12
            Some(vec![w(5_000), w(5_050)]), // profit 50
        ];
        let mut best = HashMap::new();
        update_best_from_jobs(&mut best, &keys, &amounts, &results);
        let (amount, _quotes, profit) = best.get(&7).expect("key 7 present");
        assert_eq!(*amount, w(1_000), "most profitable size must win");
        assert_eq!(*profit, w(120));
    }

    #[test]
    fn update_best_from_jobs_does_not_cross_contaminate_jobs() {
        // Distinct (key, amount) so a mis-zip of amounts against results is
        // detectable: key 0 wins at 200, key 1 wins at 300.
        let keys = [0usize, 1, 0, 1];
        let amounts = [w(100), w(100), w(200), w(300)];
        let results = [
            Some(vec![w(100), w(150)]), // key0 a100 profit 50
            Some(vec![w(100), w(180)]), // key1 a100 profit 80
            Some(vec![w(200), w(400)]), // key0 a200 profit 200  <- best for key0
            Some(vec![w(300), w(650)]), // key1 a300 profit 350  <- best for key1
        ];
        let mut best = HashMap::new();
        update_best_from_jobs(&mut best, &keys, &amounts, &results);
        assert_eq!(best[&0].0, w(200), "key0 best amount from its own row");
        assert_eq!(best[&0].2, w(200));
        assert_eq!(best[&1].0, w(300), "key1 best amount from its own row");
        assert_eq!(best[&1].2, w(350));
    }

    #[test]
    fn update_best_from_jobs_skips_zero_and_none() {
        let keys = [0usize, 1, 2];
        let amounts = [w(0), w(100), w(100)];
        let results = [Some(vec![w(0), w(50)]), None, Some(vec![w(100), w(100)])];
        let mut best = HashMap::new();
        update_best_from_jobs(&mut best, &keys, &amounts, &results);
        assert!(
            best.is_empty(),
            "zero amount, failed quote, and zero profit drop"
        );
    }

    #[test]
    fn merged_probe_counts_equal_sequential_counts() {
        // The flattened job list must produce the same total quote count as the
        // old per-amount loop: two routes x two amounts, each a 2-hop path
        // (2 leg outputs per successful job).
        let per_amount_results: Vec<Vec<Option<Vec<U256>>>> = vec![
            vec![Some(vec![w(100), w(101), w(102)]), None],
            vec![
                Some(vec![w(200), w(201), w(202)]),
                Some(vec![w(200), w(190), w(180)]),
            ],
        ];
        let sequential: usize = per_amount_results
            .iter()
            .map(|round| count_quotes(round))
            .sum();
        let flattened: Vec<Option<Vec<U256>>> = per_amount_results.into_iter().flatten().collect();
        assert_eq!(sequential, count_quotes(&flattened));
        assert_eq!(sequential, 3 * 2, "three completed 2-hop paths");
    }

    // ---- trigger-batch planning (coalescing) ----

    fn indexed_log(pool: Address, tx_byte: u8, index: u64) -> Log {
        log_from_json(json!({
            "address": pool.to_string(),
            "topics": ["0xc42079f94a6350d7e6235f29174924f928cc2ac818eb64fed8004e115fbcca67"],
            "data": "0x",
            "blockNumber": "0x1",
            "transactionHash": format!("{:#x}", B256::repeat_byte(tx_byte)),
            "logIndex": format!("0x{index:x}"),
            "transactionIndex": "0x0",
            "removed": false,
        }))
    }

    fn test_pools() -> (Address, Address) {
        (Address::repeat_byte(0xa1), Address::repeat_byte(0xa2))
    }

    fn test_pool_index() -> HashMap<Address, usize> {
        let (a, b) = test_pools();
        HashMap::from([(a, 1usize), (b, 0usize)])
    }

    fn not_a_swap(_: &Log) -> Option<f64> {
        None
    }

    fn never_seen(_: &TriggerKey) -> bool {
        false
    }

    fn plan_of(triggers: &[Trigger]) -> BatchPlan {
        plan_batch(
            triggers,
            &mut None,
            &test_pool_index(),
            500.0,
            &not_a_swap,
            &never_seen,
        )
    }

    fn log_trigger(pool: Address, tx: u8, index: u64, preconfirmed: bool) -> Trigger {
        Trigger::Log {
            log: indexed_log(pool, tx, index),
            preconfirmed,
        }
    }

    #[test]
    fn batch_unions_affected_pools_sorted() {
        let (a, b) = test_pools();
        let plan = plan_of(&[
            log_trigger(a, 1, 0, false),
            log_trigger(b, 2, 0, false),
            log_trigger(a, 3, 0, false),
        ]);
        assert!(plan.scan);
        assert_eq!(plan.affected.as_deref(), Some(&[0usize, 1][..]));
        assert_eq!(plan.keys.len(), 3);
        assert_eq!(plan.block, ScanBlock::Latest);
        assert!(plan.notes.is_empty());
    }

    #[test]
    fn one_preconfirmed_trigger_makes_the_batch_pending() {
        let (a, b) = test_pools();
        let plan = plan_of(&[log_trigger(a, 1, 0, false), log_trigger(b, 2, 0, true)]);
        assert_eq!(plan.block, ScanBlock::Pending);
    }

    #[test]
    fn in_batch_duplicates_are_dropped_once() {
        let (a, _b) = test_pools();
        let same = log_trigger(a, 7, 4, false);
        let plan = plan_of(&[same.clone(), same]);
        assert!(plan.scan);
        assert_eq!(plan.keys.len(), 1, "one key to mark, once");
        assert_eq!(plan.notes, vec!["1 duplicate triggers skipped".to_string()]);
    }

    #[test]
    fn already_seen_batches_do_not_scan() {
        let (a, _b) = test_pools();
        let triggers = vec![log_trigger(a, 1, 0, false)];
        let mut last = None;
        let plan = plan_batch(
            &triggers,
            &mut last,
            &test_pool_index(),
            500.0,
            &not_a_swap,
            &|_| true,
        );
        assert!(!plan.scan);
        assert!(plan.keys.is_empty());
        // Single-trigger batches keep the historical note wording.
        assert_eq!(plan.notes, vec!["duplicate trigger skipped".to_string()]);
    }

    #[test]
    fn unknown_pool_forces_a_full_scan() {
        let stranger = Address::repeat_byte(0xff);
        let plan = plan_of(&[log_trigger(stranger, 1, 0, false)]);
        assert!(plan.scan);
        assert_eq!(plan.affected, None, "unknown pool means scan all");
        assert_eq!(plan.keys.len(), 1);
    }

    #[test]
    fn reconnect_forces_a_full_scan_beside_pool_logs() {
        let (a, _b) = test_pools();
        let plan = plan_of(&[Trigger::Reconnect, log_trigger(a, 1, 0, false)]);
        assert!(plan.scan);
        assert_eq!(plan.affected, None);
    }

    #[test]
    fn dust_logs_are_skipped_and_never_marked() {
        let (a, _b) = test_pools();
        let triggers = vec![log_trigger(a, 1, 0, false)];
        let mut last = None;
        let plan = plan_batch(
            &triggers,
            &mut last,
            &test_pool_index(),
            500.0,
            &|_| Some(100.0), // every log reads as a $100 swap
            &never_seen,
        );
        assert!(!plan.scan, "a batch of only dust does not scan");
        assert!(plan.keys.is_empty(), "dust must not enter the dedupe set");
        assert_eq!(
            plan.notes,
            vec!["swap ~$100 below the $500 minimum; skipped".to_string()]
        );
    }

    #[test]
    fn a_dust_log_does_not_mask_its_later_full_size_twin() {
        // The same key appears twice in one batch: the first pass is dust
        // (below floor), the second is a normal (non-swap, unfiltered) log.
        // The dust must not swallow the twin: it still has to scan.
        let (a, _b) = test_pools();
        let twin = log_trigger(a, 9, 1, false);
        let triggers = vec![twin.clone(), twin];
        let seen = std::cell::Cell::new(0usize);
        let mut last = None;
        let plan = plan_batch(
            &triggers,
            &mut last,
            &test_pool_index(),
            500.0,
            &|_| {
                let n = seen.replace(seen.get() + 1);
                if n == 0 { Some(100.0) } else { None }
            },
            &never_seen,
        );
        assert!(plan.scan, "the qualifying duplicate still scans");
        assert_eq!(plan.keys.len(), 1);
        assert_eq!(plan.affected.as_deref(), Some(&[1usize][..]));
    }

    #[test]
    fn consecutive_heads_do_not_scan_and_move_the_marker() {
        let triggers = vec![Trigger::Head { number: 11 }, Trigger::Head { number: 12 }];
        let mut last = Some(10);
        let plan = plan_batch(
            &triggers,
            &mut last,
            &test_pool_index(),
            500.0,
            &not_a_swap,
            &never_seen,
        );
        assert!(!plan.scan);
        assert_eq!(last, Some(12));
        assert_eq!(plan.notes, vec!["2 head ticks (no scan)".to_string()]);
    }

    #[test]
    fn head_gap_in_a_batch_forces_one_full_rescan() {
        let triggers = vec![Trigger::Head { number: 20 }];
        let mut last = Some(12); // 8 blocks skipped
        let plan = plan_batch(
            &triggers,
            &mut last,
            &test_pool_index(),
            500.0,
            &not_a_swap,
            &never_seen,
        );
        assert!(plan.scan);
        assert!(plan.gap_rescan);
        assert_eq!(plan.affected, None);
    }

    #[test]
    fn flashblocks_follow_the_pool_and_skip_rules() {
        let (a, b) = test_pools();
        let stranger = Address::repeat_byte(0xff);
        let with_logs = Trigger::Flashblock {
            hashes: vec![B256::repeat_byte(1)],
            logs: vec![indexed_log(a, 1, 0), indexed_log(stranger, 2, 0)],
        };
        let plan = plan_of(&[with_logs, log_trigger(b, 3, 0, false)]);
        assert!(plan.scan);
        assert_eq!(plan.block, ScanBlock::Pending);
        assert_eq!(plan.affected.as_deref(), Some(&[0usize, 1][..]));
        assert_eq!(plan.keys.len(), 2);

        let hash_only = Trigger::Flashblock {
            hashes: vec![B256::repeat_byte(2)],
            logs: vec![indexed_log(stranger, 5, 0)],
        };
        let plan = plan_of(&[hash_only]);
        assert!(!plan.scan);
        assert!(
            plan.keys.is_empty(),
            "an uninformative flashblock is not marked"
        );
        assert_eq!(
            plan.notes,
            vec!["flashblock contained no qualifying pool logs".to_string()]
        );
    }

    #[test]
    fn mixed_batches_prefer_full_and_pending() {
        let (a, _b) = test_pools();
        let stranger = Address::repeat_byte(0xff);
        let plan = plan_of(&[
            log_trigger(a, 1, 0, false),
            log_trigger(stranger, 2, 0, true),
            Trigger::Head { number: 5 },
        ]);
        assert!(plan.scan);
        assert_eq!(
            plan.affected, None,
            "unknown pool upgrades the batch to a full scan"
        );
        assert_eq!(plan.block, ScanBlock::Pending, "the pending log dominates");
    }

    fn cp_step(venue: Venue, input: U256) -> (RouteStep, U256) {
        let step = RouteStep {
            pool_index: 0,
            token_in: base::USDC,
            token_out: base::WETH,
            venue,
            data: venue.data(),
        };
        (step, input)
    }

    fn cp(
        curve: Curve,
        reserve0: U256,
        reserve1: U256,
        fee_bps: u32,
    ) -> HashMap<usize, ConstantProductPool> {
        let mut map = HashMap::new();
        map.insert(
            0,
            ConstantProductPool {
                address: base::WETH,
                curve,
                token0: base::WETH,
                token1: base::USDC,
                reserve0,
                reserve1,
                fee_bps,
                decimals0: ten_pow(18).unwrap(),
                decimals1: ten_pow(6).unwrap(),
            },
        );
        map
    }

    /// The invariant that makes local math an optimisation rather than a
    /// strategy change: **local math never deletes a candidate.** A refusal, a
    /// missing pool, or an unusable fee all route to the on-chain quoter.
    #[test]
    fn local_refusals_fall_back_to_the_quoter() {
        let priced = U256::from(1_000_000u64);

        // A pool this scan never fetched reserves for: quote it on chain.
        let (step, input) = cp_step(Venue::UniV2, priced);
        assert_eq!(price_leg(&HashMap::new(), &step, input), LegPrice::Onchain);

        // Empty side: no local answer, but the route is still worth quoting.
        for curve in [
            Curve::UniV2,
            Curve::AerodromeVolatile,
            Curve::AerodromeStable,
        ] {
            let empty = cp(curve, U256::ZERO, U256::from(10u128.pow(18)), 30);
            assert_eq!(
                price_leg(&empty, &step, input),
                LegPrice::Onchain,
                "{curve:?} with an empty side must be quoted on chain"
            );
        }

        // Dust that rounds to a zero output: decline locally, conclude nothing
        // about the route. (The stable curve prices dust at *some* output for
        // these reserves, so it is exercised through its own refusal mode
        // below rather than through rounding.)
        for curve in [Curve::UniV2, Curve::AerodromeVolatile] {
            let full = cp(
                curve,
                U256::from(10u128.pow(18)),
                U256::from(10u128.pow(18)),
                30,
            );
            assert_eq!(
                price_leg(&full, &step, U256::from(1u8)),
                LegPrice::Onchain,
                "{curve:?} dust must fall back, not drop the candidate"
            );
        }

        // An over-scale fee is not a price: every curve that consults it must
        // hand the leg to the quoter instead of pricing garbage.
        for curve in [Curve::AerodromeVolatile, Curve::AerodromeStable] {
            let bogus = cp(
                curve,
                U256::from(10u128.pow(18)),
                U256::from(10u128.pow(18)),
                u32::MAX,
            );
            assert_eq!(
                price_leg(&bogus, &step, input),
                LegPrice::Onchain,
                "{curve:?} with an implausible fee must be quoted on chain"
            );
            let cent = cp(
                curve,
                U256::from(10u128.pow(18)),
                U256::from(10u128.pow(18)),
                10_000,
            );
            assert_eq!(
                price_leg(&cent, &step, input),
                LegPrice::Onchain,
                "{curve:?} at a 100% fee leaves nothing to price"
            );
        }

        // A healthy pool with a real answer is priced locally, at zero RPC cost.
        let healthy = cp(
            Curve::UniV2,
            U256::from(332_274_501_113_338_591_906u128),
            U256::from(754_915_714_028u128),
            0,
        );
        assert!(
            matches!(
                price_leg(&healthy, &step, U256::from(1_000_000_000u64)),
                LegPrice::Local(_)
            ),
            "a normal-size input on a real pool must be priced locally"
        );
    }

    /// A leg is only ever priced locally when the *pool being walked* is the
    /// pool in `cp` — indexing by `pool_index` rather than by venue means a
    /// route cannot borrow another pool's reserves.
    #[test]
    fn price_leg_keys_on_the_walked_pool_index() {
        let (step, input) = cp_step(Venue::UniV2, input_amount());
        let mut other_index = step;
        other_index.pool_index = 7;
        let healthy = cp(
            Curve::UniV2,
            U256::from(332_274_501_113_338_591_906u128),
            U256::from(754_915_714_028u128),
            0,
        );
        assert_eq!(
            price_leg(&healthy, &other_index, input),
            LegPrice::Onchain,
            "pool 7 is not in this scan's reserves; must not reuse pool 0"
        );
    }

    fn input_amount() -> U256 {
        U256::from(1_000_000_000u64)
    }
}

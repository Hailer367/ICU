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
use crate::chain::{self, ChainProvider};
use crate::config::{Manifest, Settings, base};
use crate::events::Trigger;
use crate::gas::{self, GasSnapshot, TradeCost};
use crate::history;
use crate::routes::{Registry, Route, Venue, enumerate_cycles};
use crate::simulate::{self, SimulateError};
use crate::venues::{self, QuoteRequest};

/// Reuse a gas snapshot and ETH/USD price for this long. Bursts of pool logs
/// otherwise re-read the same chain state several times in a row.
const GAS_CACHE_TTL: Duration = Duration::from_secs(2);
/// Remember this many recent triggers so `logs` + `pendingLogs` duplicates do
/// not cause two identical scans.
const DEDUPE_CAPACITY: usize = 2_048;
/// A swap smaller than this cannot repay the minimum profit: at ~0.56 % round
/// trip (pool fees + profit buffer), $0.25 needs about $45 of notional. The
/// floor applies even when `min_swap_usd` is configured lower.
const ABSOLUTE_MIN_SWAP_USD: f64 = 45.0;

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
    simulations: usize,
    opportunities: Vec<Opportunity>,
    probe_ms: u64,
    refine_ms: u64,
    simulate_ms: u64,
}

#[derive(Debug, Clone, Default)]
pub struct ScanReport {
    pub block: u64,
    pub affected_pools: Vec<Address>,
    pub routes_considered: usize,
    pub quotes: usize,
    pub simulations: usize,
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

#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum ScanBlock {
    Latest,
    Pending,
}

impl ScanBlock {
    fn id(self) -> BlockId {
        match self {
            Self::Latest => BlockId::latest(),
            Self::Pending => BlockId::pending(),
        }
    }
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
            last_block: Mutex::new(None),
        })
    }

    /// Read a gas snapshot and ETH/USD price, reusing a recent pair when the
    /// watcher is processing a burst of triggers.
    async fn gas_context(&self) -> Result<(GasSnapshot, f64)> {
        {
            let cache = self.gas_cache.lock().expect("gas cache mutex poisoned");
            if let Some(cached) = cache.as_ref()
                && cached.at.elapsed() < GAS_CACHE_TTL
            {
                return Ok((cached.snapshot.clone(), cached.eth_usd));
            }
        }
        let snapshot = gas::snapshot(&self.provider, 2_000).await?;
        let eth_usd = gas::eth_usd_price(&self.provider, snapshot.timestamp)
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
    async fn ensure_feed_decimals(&self, feeds: &[Address]) {
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
        let results = chain::multicall_raw(&self.provider, &calls, BlockId::latest()).await;
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
    async fn asset_usd_prices(
        &self,
        eth_usd: f64,
        snapshot: &GasSnapshot,
    ) -> HashMap<Address, f64> {
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
        self.ensure_feed_decimals(&feeds).await;
        let decimals = self
            .feed_decimals
            .lock()
            .expect("feed decimals mutex poisoned")
            .clone();
        let resolved =
            gas::feed_prices(&self.provider, &requests, snapshot.timestamp, &decimals).await;
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
        let block_id = BlockId::latest();
        let core = self.load_core_state().await?;
        if core.paused {
            bail!("core is paused");
        }
        let (gas_snapshot, eth_usd) = self.gas_context().await?;
        let asset_usd =
            gas::asset_usd_price(&self.provider, route.asset, gas_snapshot.timestamp).await?;
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

        let quotes = self
            .quote_jobs(std::slice::from_ref(route), &[(0usize, amount)], block_id)
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
        .await)
    }

    pub async fn scan_trigger(&self, trigger: &Trigger) -> Result<ScanReport> {
        let key = TriggerKey::from_trigger(trigger);
        if let Some(key) = &key {
            let deduper = self.deduper.lock().expect("dedupe mutex poisoned");
            if deduper.contains(key) {
                return Ok(ScanReport {
                    notes: vec!["duplicate trigger skipped".to_string()],
                    ..Default::default()
                });
            }
        }

        let block = match trigger {
            Trigger::Log {
                preconfirmed: true, ..
            } => ScanBlock::Pending,
            Trigger::Flashblock { .. } => ScanBlock::Pending,
            _ => ScanBlock::Latest,
        };
        let mut gap_rescan = false;
        let affected = match trigger {
            // A head alone is not an opportunity signal. It is only acted on
            // when blocks were skipped since the last evaluate (a reorg or a
            // dropped WebSocket message), in which case one full rescan is due.
            Trigger::Head { number } => {
                let mut last = self.last_block.lock().expect("last block mutex poisoned");
                let previous = *last;
                // Heads are liveness markers. Advance the marker on every head
                // so idle stretches do not look like gaps; only a real jump or
                // a backwards head triggers the full rescan.
                *last = Some(*number);
                drop(last);
                if head_requires_rescan(previous, *number) {
                    gap_rescan = true;
                    None
                } else {
                    return Ok(ScanReport {
                        notes: vec![format!("head tick {number} (no scan)")],
                        ..Default::default()
                    });
                }
            }
            Trigger::Reconnect => None,
            Trigger::Log { log, .. } => {
                if let Some(notional) = self.swap_notional_usd(log) {
                    let floor = self.min_swap_usd();
                    if notional < floor {
                        return Ok(ScanReport {
                            notes: vec![format!(
                                "swap ~${notional:.0} below the ${floor:.0} minimum; skipped"
                            )],
                            ..Default::default()
                        });
                    }
                }
                self.pool_index
                    .get(&log.address())
                    .map(|index| vec![*index])
            }
            Trigger::Flashblock { logs, .. } => {
                let floor = self.min_swap_usd();
                let mut set = HashSet::new();
                for log in logs {
                    let Some(index) = self.pool_index.get(&log.address()).copied() else {
                        continue;
                    };
                    if let Some(notional) = self.swap_notional_usd(log)
                        && notional < floor
                    {
                        continue;
                    }
                    set.insert(index);
                }
                if set.is_empty() {
                    // A flashblock transaction list without logs does not tell
                    // us which pools changed. Skip rather than scan everything
                    // on every flashblock.
                    return Ok(ScanReport {
                        notes: vec!["flashblock contained no qualifying pool logs".to_string()],
                        ..Default::default()
                    });
                }
                Some(set.into_iter().collect())
            }
        };
        let mut report = self.evaluate(affected, block).await?;
        if let Some(key) = key {
            self.deduper
                .lock()
                .expect("dedupe mutex poisoned")
                .mark(key);
        }
        if gap_rescan {
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
        let block_id = block.id();
        let head_started = Instant::now();
        let block_number = chain::block_number(&self.provider).await?;
        {
            let mut last = self.last_block.lock().expect("last block mutex poisoned");
            *last = Some(block_number);
        }

        let core = self.load_core_state().await?;
        let mut report = ScanReport {
            block: block_number,
            core_ms: elapsed_millis(head_started),
            ..Default::default()
        };
        if core.paused {
            report.notes.push("core is paused".to_string());
            return Ok(report);
        }

        let gas_started = Instant::now();
        let (gas_snapshot, eth_usd) = self.gas_context().await?;
        let asset_prices = self.asset_usd_prices(eth_usd, &gas_snapshot).await;
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
                    report.simulations += asset_report.simulations;
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
    async fn load_core_state(&self) -> Result<CoreState> {
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
        let results = chain::multicall_raw(&self.provider, &calls, BlockId::latest()).await;

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
        let results = self.quote_jobs(&all_routes, &jobs, block_id).await;
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
            let quotes = self
                .quote_jobs(&refined_routes, &refine_jobs, block_id)
                .await;
            report.quotes += count_quotes(&quotes);
            update_best_from_jobs(&mut best, &refine_keys, &refine_amounts, &quotes);
        }
        report.refine_ms += elapsed_millis(refine_started);

        // Simulate the most promising routes. Quote profitability is only a
        // ranking signal; `simulate` is the source of truth.
        let mut finalists: Vec<(usize, U256)> = ranked
            .iter()
            .filter_map(|(index, _)| best.get(index).map(|(_, _, profit)| (*index, *profit)))
            .collect();
        finalists.sort_by_key(|entry| std::cmp::Reverse(entry.1));
        finalists.truncate(
            self.settings
                .max_candidates
                .min(self.settings.max_simulations.max(1)),
        );

        let futures = stream::iter(finalists.into_iter().map(|(index, _)| {
            let route = all_routes[index].clone();
            let (amount, quotes, _) =
                best.get(&index)
                    .cloned()
                    .unwrap_or((U256::ZERO, Vec::new(), U256::ZERO));
            let provider = self.provider.clone();
            let manifest = self.manifest.clone();
            let settings = self.settings.clone();
            let symbol = symbol.clone();
            async move {
                if amount.is_zero() || quotes.len() != route.steps.len() + 1 {
                    return None;
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
        let results: Vec<Option<Opportunity>> = futures.buffer_unordered(4).collect().await;
        report.simulate_ms += elapsed_millis(simulate_started);
        report.simulations += results.len();
        for opportunity in results.into_iter().flatten() {
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
    /// complete every step.
    async fn quote_jobs(
        &self,
        routes: &[Route],
        jobs: &[(usize, U256)],
        block: BlockId,
    ) -> Vec<Option<Vec<U256>>> {
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
                let Some(Some(current)) = quotes.get(job_index) else {
                    continue;
                };
                let Some(input) = current.last().copied() else {
                    continue;
                };
                let Some(step) = routes[*route_index].steps.get(leg) else {
                    continue;
                };
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
                        quotes[job_index] = None;
                    }
                }
            }
            if requests.is_empty() {
                break;
            }
            let results = venues::quote_batch(&self.provider, &requests, block).await;
            for job_index in job_indices {
                let Some(request_index) = request_for_job[job_index] else {
                    continue;
                };
                let Some(result) = results.get(request_index) else {
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
                        quotes[job_index] = None;
                    }
                }
            }
        }

        quotes
            .into_iter()
            .zip(jobs.iter())
            .map(|(quote, (route_index, _))| {
                let route = &routes[*route_index];
                quote.filter(|values| values.len() == route.steps.len() + 1)
            })
            .collect()
    }
}

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
) -> Option<Opportunity> {
    let discovery_steps = match simulate::discovery_steps(route, manifest) {
        Ok(steps) => steps,
        Err(err) => {
            debug!(error = %err, "failed to build discovery steps");
            return None;
        }
    };

    let simulation = match simulate::simulate(
        provider,
        manifest.core,
        asset,
        amount,
        discovery_steps,
        block,
    )
    .await
    {
        Ok(simulation) => simulation,
        Err(SimulateError::Revert { decoded, .. }) => {
            debug!(route = ?route.venues(), %decoded, "simulation reverted");
            return None;
        }
        Err(SimulateError::Transport(message)) => {
            warn!(error = %message, "simulation transport failure");
            return None;
        }
        Err(SimulateError::UnexpectedSuccess(_)) => {
            warn!("simulate unexpectedly succeeded; check the ABI");
            return None;
        }
    };

    if simulation.profit <= I256::ZERO {
        return None;
    }
    let profit_raw: U256 = simulation.profit.try_into().ok()?;

    let floors = build_floors(quotes, settings.per_leg_slippage_bps);
    let steps = route.to_steps(manifest, &floors).ok()?;
    let buffer = U256::from(settings.min_profit_buffer_bps.min(9_999));
    let min_profit = profit_raw.saturating_mul(U256::from(10_000) - buffer) / U256::from(10_000);
    let call = ryo::executeCall {
        asset,
        amount,
        steps,
        minProfit: min_profit,
    };
    let calldata = Bytes::from(call.abi_encode());
    let route_hash = route.route_hash(manifest, &floors).ok()?;

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
        return None;
    }

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
    })
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

fn effective_min_swap_usd(configured: f64) -> f64 {
    configured.max(ABSOLUTE_MIN_SWAP_USD)
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
    let watcher_max = U256::from((settings.max_gas_price_gwei * 1e9) as u128);
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
}

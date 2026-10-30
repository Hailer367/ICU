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

#[derive(Debug, Clone, Default)]
pub struct ScanReport {
    pub block: u64,
    pub affected_pools: Vec<Address>,
    pub routes_considered: usize,
    pub quotes: usize,
    pub simulations: usize,
    pub opportunities: Vec<Opportunity>,
    pub notes: Vec<String>,
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
            .quote_routes_at_amounts(std::slice::from_ref(route), &[amount], block_id)
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
        let block_number = chain::block_number(&self.provider).await?;
        {
            let mut last = self.last_block.lock().expect("last block mutex poisoned");
            *last = Some(block_number);
        }
        let mut report = ScanReport {
            block: block_number,
            ..Default::default()
        };

        let core = self.load_core_state().await?;
        if core.paused {
            report.notes.push("core is paused".to_string());
            return Ok(report);
        }

        let (gas_snapshot, eth_usd) = self.gas_context().await?;
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

        for asset in &self.assets {
            match self
                .scan_asset(
                    *asset,
                    &core,
                    &gas_snapshot,
                    eth_usd,
                    &affected_set,
                    block,
                    block_id,
                    &mut report,
                )
                .await
            {
                Ok(()) => {}
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

    async fn load_core_state(&self) -> Result<CoreState> {
        use alloy::sol_types::SolCall;

        let core = self.manifest.core;
        let paused = chain::eth_call_bool(
            &self.provider,
            core,
            ryo::pausedCall {}.abi_encode().into(),
            BlockId::latest(),
        )
        .await
        .context("failed to read core.paused")?;
        let max_gas_price = chain::eth_call_u256(
            &self.provider,
            core,
            ryo::maxGasPriceCall {}.abi_encode().into(),
            BlockId::latest(),
        )
        .await
        .context("failed to read core.maxGasPrice")?;

        let mut caps = HashMap::new();
        for asset in &self.assets {
            let cap = chain::eth_call_u256(
                &self.provider,
                core,
                ryo::maxTradeSizeCall { asset: *asset }.abi_encode().into(),
                BlockId::latest(),
            )
            .await
            .unwrap_or(U256::ZERO);
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
        affected: &Option<HashSet<usize>>,
        block: ScanBlock,
        block_id: BlockId,
        report: &mut ScanReport,
    ) -> Result<()> {
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
                return Ok(());
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
            return Ok(());
        }

        let price = match gas::asset_usd_price(&self.provider, asset, gas_snapshot.timestamp).await
        {
            Ok(price) if price > 0.0 => price,
            _ => {
                report
                    .notes
                    .push(format!("{symbol} has no usable USD feed"));
                return Ok(());
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
            return Ok(());
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
            return Ok(());
        }

        let mut best: HashMap<usize, (U256, Vec<U256>, U256)> = HashMap::new();
        for amount in &probe_amounts {
            let amounts = vec![*amount; all_routes.len()];
            let quotes = self
                .quote_routes_at_amounts(&all_routes, &amounts, block_id)
                .await;
            report.quotes += count_quotes(&quotes);
            update_best(&mut best, &amounts, quotes);
        }

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
            return Ok(());
        }

        let refined_routes: Vec<Route> = ranked
            .iter()
            .map(|(index, _)| all_routes[*index].clone())
            .collect();
        let base_amounts: Vec<U256> = ranked.iter().map(|(index, _)| best[index].0).collect();

        let mut factors = vec![0.5, 0.75, 1.0, 1.5, 2.0];
        factors.truncate(self.settings.amount_grid_points.max(1));
        for factor in factors {
            let amounts: Vec<U256> = base_amounts
                .iter()
                .map(|amount| scale_amount(*amount, factor).min(cap))
                .collect();
            if amounts.iter().any(|amount| amount.is_zero()) {
                continue;
            }
            let quotes = self
                .quote_routes_at_amounts(&refined_routes, &amounts, block_id)
                .await;
            report.quotes += count_quotes(&quotes);
            let mut local_best = HashMap::new();
            update_best(&mut local_best, &amounts, quotes);
            for (local_index, (amount, quotes, profit)) in local_best {
                let route_index = ranked[local_index].0;
                let replace = best
                    .get(&route_index)
                    .map(|(_, _, old_profit)| profit > *old_profit)
                    .unwrap_or(true);
                if replace {
                    best.insert(route_index, (amount, quotes, profit));
                }
            }
        }

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

        let results: Vec<Option<Opportunity>> = futures.buffer_unordered(4).collect().await;
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
        Ok(())
    }

    async fn quote_routes_at_amounts(
        &self,
        routes: &[Route],
        amounts: &[U256],
        block: BlockId,
    ) -> Vec<Option<Vec<U256>>> {
        assert_eq!(routes.len(), amounts.len());
        let mut quotes: Vec<Option<Vec<U256>>> = routes
            .iter()
            .zip(amounts.iter())
            .map(|(route, amount)| {
                if amount.is_zero() || route.steps.is_empty() {
                    None
                } else {
                    Some(vec![*amount])
                }
            })
            .collect();

        let max_legs = routes
            .iter()
            .map(|route| route.steps.len())
            .max()
            .unwrap_or(0);
        for leg in 0..max_legs {
            let mut requests: Vec<QuoteRequest> = Vec::new();
            let mut unique: HashMap<(Address, Bytes), usize> = HashMap::new();
            let mut request_for_route: Vec<Option<usize>> = vec![None; routes.len()];
            let mut route_indices = Vec::new();
            for (index, route) in routes.iter().enumerate() {
                let Some(Some(current)) = quotes.get(index) else {
                    continue;
                };
                let Some(input) = current.last().copied() else {
                    continue;
                };
                let Some(step) = route.steps.get(leg) else {
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
                        request_for_route[index] = Some(request_index);
                        route_indices.push(index);
                    }
                    Err(err) => {
                        debug!(error = %err, "failed to encode quote request");
                        quotes[index] = None;
                    }
                }
            }
            if requests.is_empty() {
                break;
            }
            let results = venues::quote_batch(&self.provider, &requests, block).await;
            for route_index in route_indices {
                let Some(request_index) = request_for_route[route_index] else {
                    continue;
                };
                let Some(result) = results.get(request_index) else {
                    quotes[route_index] = None;
                    continue;
                };
                match result {
                    Ok(amount_out) => {
                        if let Some(Some(current)) = quotes.get_mut(route_index) {
                            current.push(*amount_out);
                        }
                    }
                    Err(err) => {
                        debug!(error = %err, "quote failed");
                        quotes[route_index] = None;
                    }
                }
            }
        }

        quotes
            .into_iter()
            .zip(routes.iter())
            .map(|(quote, route)| quote.filter(|values| values.len() == route.steps.len() + 1))
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

fn update_best(
    best: &mut HashMap<usize, (U256, Vec<U256>, U256)>,
    amounts: &[U256],
    quotes: Vec<Option<Vec<U256>>>,
) {
    for (index, quote) in quotes.into_iter().enumerate() {
        let Some(values) = quote else { continue };
        let Some(output) = values.last().copied() else {
            continue;
        };
        let Some(amount) = amounts.get(index).copied() else {
            continue;
        };
        if amount.is_zero() {
            continue;
        }
        // `asset -> ... -> asset`, so output and input share units. Absolute
        // profit is the right ranking signal; ratio would prefer 1 wei trades.
        let profit = output.saturating_sub(amount);
        if profit.is_zero() {
            continue;
        }
        let replace = best
            .get(&index)
            .map(|(_, _, old_profit)| profit > *old_profit)
            .unwrap_or(true);
        if replace {
            best.insert(index, (amount, values, profit));
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
}

//! Event-driven opportunity scanner.
//!
//! The scanner never polls for opportunities. A caller gives it a trigger
//! (a pool log, a flashblock, a new head, or a reconnect) and it quotes only
//! the routes that touch the affected pools.

use std::collections::{HashMap, HashSet, VecDeque};
use std::sync::Mutex;
use std::sync::atomic::{AtomicBool, Ordering};
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
use crate::clamm::{self, ClPoolSpec, ClPoolState};
use crate::config::{Manifest, Settings, base};
use crate::events::{HeadInfo, Trigger};
use crate::gas::{self, GasSnapshot, TradeCost};
use crate::history;
use crate::routes::{Registry, Route, RouteStep, Venue, enumerate_cycles};
use crate::simulate::{self, SimulateError};
use crate::venues::{self, QuoteRequest};

/// Reuse a gas snapshot and ETH/USD price for this long. Bursts of pool logs
/// otherwise re-read the same chain state several times in a row.
const GAS_CACHE_TTL: Duration = Duration::from_secs(2);
/// Reuse the per-pool trigger floors for this long. Fees and depth move far
/// slower than prices; the floors are a "should I bother quoting" hint, not a
/// money number, so short staleness is safe and keeps the hot path at zero
/// extra round-trips.
const POOL_FLOORS_TTL: Duration = Duration::from_secs(30);
/// A fully failed CL bootstrap wave is retried no sooner than this; a
/// degraded RPC should not pay the whole read wave every scan.
const CL_BOOT_COOLDOWN: Duration = Duration::from_secs(30);
/// Uniswap V2 pools on Base charge the classic 0.30 % (`amm.rs` hard-codes the
/// same `997/1000` for local pricing). Not readable from the pool contract.
const UNIV2_FEE_BPS: f64 = 30.0;
/// 2^96: `sqrtPriceX96` is the pool price scaled by this.
const Q96: f64 = 79_228_162_514_264_337_593_543_950_336.0;
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
    /// Local math has no answer for this leg — a pool absent from this scan's
    /// state fetch, a stale or uncovered concentrated-liquidity cache entry
    /// (§0u), or a genuine refusal (dust that rounds to zero output, a
    /// non-converging stable iteration, an over-draw, an implausible fee).
    /// Every one of these must still be quoted on-chain: "local math is
    /// unsure" is not evidence about profitability, and treating it as such
    /// would silently delete a payable route.
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

/// Decide how to price one concentrated-liquidity leg from the Scanner's
/// event-maintained cache. The same rule as `price_leg` binds: a refusal is
/// "no local answer", never evidence about profitability. Pure and
/// side-effect free so the invariant stays directly testable.
pub fn price_cl_leg(cl: &HashMap<usize, ClPoolState>, step: &RouteStep, input: U256) -> LegPrice {
    match cl
        .get(&step.pool_index)
        .and_then(|pool| pool.quote_exact_in(step.token_in, input))
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
    pub fn labels(&self, registry: &crate::routes::Registry) -> Vec<String> {
        self.route.labels(registry)
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
    /// Wall time of resolving the block this scan pinned. Normally zero:
    /// §0t serves the pin from the socket's delivered head. Non-zero means
    /// the fallback RPC resolve ran (CLI path, split endpoints, or no head
    /// yet), and its round-trip is visible here for the first time — before
    /// §0t the pin cost was the one phase no metric admitted to.
    pub pin_ms: u64,
    /// Per-phase wall time in milliseconds, summed across assets. `core_ms`
    /// covers the head block number plus the core state reads.
    pub core_ms: u64,
    pub gas_ms: u64,
    pub probe_ms: u64,
    pub refine_ms: u64,
    pub simulate_ms: u64,
    /// Wall time of the freshness pass; zero when it never ran (no
    /// opportunities, or the head did not move).
    pub fresh_ms: u64,
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

struct CachedPoolFloors {
    at: Instant,
    floors: PoolFloors,
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

/// One refreshed finalist's outcome in the freshness pass.
#[derive(Debug)]
enum Refresh<T> {
    /// Re-quoted and re-simulated at the new pin, still profitable.
    Replaced(T),
    /// The new state truthfully says the trade no longer pays — a definitive
    /// simulation verdict or a sub-threshold net. A legitimate removal, not
    /// a failure.
    Gone,
    /// The refresh could not complete (a leg could not be re-quoted, a feed
    /// disappeared, the simulation could not be re-run). Nothing is known, so
    /// the whole pass must be treated as inconclusive.
    Inconclusive(String),
}

/// All-or-nothing merge for the freshness pass. One inconclusive finalist
/// voids the entire refresh: a report where only some numbers moved would
/// stitch two blocks together, exactly the lie §0k removed. Conclusive
/// outcomes replace the set wholesale, dropping `Gone` entries.
fn merge_refreshed<T: Clone>(outcomes: &[Refresh<T>]) -> Result<Vec<T>, String> {
    let mut fresh = Vec::with_capacity(outcomes.len());
    let mut inconclusive: Vec<&str> = Vec::new();
    for outcome in outcomes {
        match outcome {
            Refresh::Replaced(value) => fresh.push(value.clone()),
            Refresh::Gone => {}
            Refresh::Inconclusive(reason) => inconclusive.push(reason.as_str()),
        }
    }
    if inconclusive.is_empty() {
        Ok(fresh)
    } else {
        Err(inconclusive.join("; "))
    }
}

/// Outcome of the freshness pass for one scan.
#[derive(Debug)]
pub enum Fresh {
    /// The head never moved since the first pin: the pass-1 numbers are
    /// already the freshest consistent snapshot, and no work was done.
    Skipped(String),
    /// The refresh could not complete (or the fresh state rejects trading
    /// outright). The pass-1 opportunities are kept untouched — they still
    /// describe the block the report originally named.
    Failed(String),
    /// Every finalist was re-quoted and re-simulated at `pin`; these
    /// opportunities replace the pass-1 set entirely, possibly with fewer
    /// entries (a finalist the fresh state truthfully rejects is gone).
    Applied {
        pin: chain::Pin,
        opportunities: Vec<Opportunity>,
    },
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
    /// Per-pool trigger floors, refreshed when older than `POOL_FLOORS_TTL`.
    pool_floors: Mutex<Option<CachedPoolFloors>>,
    /// The registry's concentrated-liquidity pools, in stable index order.
    cl_specs: Vec<ClPoolSpec>,
    /// Event-maintained CL caches keyed by registry pool index (§0u).
    /// Advisory candidate selection only: finalists and the `plan` path are
    /// always priced on chain at the pin.
    cl_pools: Mutex<HashMap<usize, ClPoolState>>,
    /// When the last CL bootstrap wave failed outright (retry cooldown).
    cl_boot_fail: Mutex<Option<Instant>>,
    /// Whether the local CL cache may be consulted at all. The cache is
    /// only honest while the scanner consumes the log stream that keeps it
    /// current (`scan_triggers`); callers that drive `evaluate` directly
    /// (CLI scans, fork tests) never feed it events, so a stale cache
    /// could silently mis-price legs that have no chance to self-heal.
    /// Armed on the first trigger batch; disarmed forever by `--no-local-cl`.
    cl_armed: AtomicBool,
    /// USD prices backing the floors and the dust screen, refreshed in the
    /// same `POOL_FLOORS_TTL` round. Only feed-resolved assets appear; USDC
    /// is constant and added on read (see `usd_price_map`).
    trigger_prices: Mutex<HashMap<Address, f64>>,
    /// The newest block header the WebSocket has delivered (§0t). When it is
    /// present, scans pin from it instead of paying a `latest` round-trip;
    /// the pinned-by-hash guarantee is identical because the pin carries the
    /// head's own hash, and the post-scan re-read still detects re-orgs.
    /// `None` (CLI paths, before the first head, after a reconnect) falls
    /// back to `Pin::resolve_latest`.
    head_pin: Mutex<Option<chain::Pin>>,
    /// Whether the head pin may be trusted at all: only when the subscription
    /// and the reads share one endpoint. A head from Alchemy names a block
    /// the local fork has never seen — and vice versa — so a split setup
    /// (§0g's test configuration) must keep resolving over the read provider.
    head_pinning: bool,
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
        // Only trust socket-delivered heads when subscriptions and reads
        // share one endpoint (same rule `connect_auto` merges them by).
        let head_pinning = settings
            .ws_rpc
            .as_deref()
            .is_some_and(|ws| chain::same_endpoint(&settings.http_rpc, ws));
        let registry = Registry::base_curated()?;
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
            .collect::<HashMap<Address, Vec<Route>>>();

        // A pool that appears in no enumerated route can never answer a quote,
        // so it must not be bootstrapped or maintained. At the default
        // `max_hops = 2` this excludes every cross-pair (cbBTC/EURC) CL pool,
        // roughly halving the cold-fork bootstrap wave without changing a
        // single candidate: the route set *is* the quoting universe.
        let routed_pools: HashSet<usize> = routes
            .values()
            .flatten()
            .flat_map(|route| route.pool_indices())
            .collect();

        let cl_specs: Vec<ClPoolSpec> = registry
            .pools
            .iter()
            .enumerate()
            .filter(|(index, _)| routed_pools.contains(index))
            .filter_map(|(index, pool)| match pool.venue {
                Venue::UniV3 { .. } | Venue::PancakeV3 { .. } => Some(ClPoolSpec {
                    index,
                    address: pool.address,
                    token0: pool.token0,
                    token1: pool.token1,
                    // V3/Pancake spacing comes from the pool itself.
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
            pool_floors: Mutex::new(None),
            cl_specs,
            cl_pools: Mutex::new(HashMap::new()),
            cl_boot_fail: Mutex::new(None),
            cl_armed: AtomicBool::new(false),
            trigger_prices: Mutex::new(HashMap::new()),
            head_pin: Mutex::new(None),
            head_pinning,
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
        let snapshot = gas::snapshot(&self.provider, &pin).await?;
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

    /// Per-pool trigger floors for the current batch: cached dynamic floors
    /// when enabled, otherwise the single configured floor. Reads happen at
    /// most once per `POOL_FLOORS_TTL` and the state is advisory (fees and
    /// depth), never a reported number — so `latest` here is fine even though
    /// every *money* read stays pinned.
    /// Public view of the per-pool trigger floors (audience: the `floors`
    /// CLI command and integration tests). Cached like the hot path.
    pub async fn pool_floors(&self) -> PoolFloors {
        self.trigger_floors().await
    }

    /// Feed the WETH/cbBTC/EURC legs of the trigger path with fresh USD
    /// prices (one pin + one multicall per `POOL_FLOORS_TTL` round). A feed
    /// that fails or goes stale keeps its previous answer out of the map
    /// instead of poisoning a notional with a dead price; only USDC is ever
    /// assumed ($1, the §0f premise).
    async fn refresh_trigger_prices(&self) -> HashMap<Address, (f64, u8)> {
        let requests: Vec<(Address, Address, u64)> = [base::WETH, base::CBBTC, base::EURC]
            .into_iter()
            .filter_map(|asset| {
                gas::usd_feed_for_asset(asset).map(|(feed, age)| (asset, feed, age))
            })
            .collect();
        let pin = match chain::Pin::resolve_latest(&self.provider).await {
            Ok(pin) => pin,
            Err(err) => {
                warn!(error = %err, "trigger prices: could not resolve a pin; reusing cache");
                return self.usd_price_map();
            }
        };
        let feeds: Vec<Address> = requests.iter().map(|(_, feed, _)| *feed).collect();
        self.ensure_feed_decimals(&feeds, pin.id()).await;
        let decimals = self
            .feed_decimals
            .lock()
            .expect("feed decimals mutex poisoned")
            .clone();
        let resolved = gas::feed_prices(
            &self.provider,
            &requests
                .iter()
                .map(|(_, feed, age)| (*feed, *age))
                .collect::<Vec<_>>(),
            &pin,
            &decimals,
        )
        .await;
        let mut fresh: HashMap<Address, f64> = HashMap::new();
        for (asset, feed, _age) in &requests {
            let asset = *asset;
            match resolved.get(feed) {
                Some(Ok(price)) if *price > 0.0 => {
                    fresh.insert(asset, *price);
                }
                other => {
                    debug!(
                        asset = %self.registry.symbol(asset),
                        reason = ?other,
                        "trigger price unavailable for this round"
                    );
                }
            }
        }
        *self
            .trigger_prices
            .lock()
            .expect("trigger prices mutex poisoned") = fresh;
        self.usd_price_map()
    }

    /// `(address -> (USD price, decimals))` for every token the trigger path
    /// can price: USDC is constant, the rest ride the cached feed round. An
    /// asset missing from the cache is left unpriced — the dust screen and
    /// the depth math then fall back exactly as they did pre-§0s.
    fn usd_price_map(&self) -> HashMap<Address, (f64, u8)> {
        let mut out = HashMap::new();
        if let Some(usdc) = self.registry.token(base::USDC) {
            out.insert(base::USDC, (1.0, usdc.decimals));
        }
        let cache = self
            .trigger_prices
            .lock()
            .expect("trigger prices mutex poisoned");
        for (asset, price) in cache.iter() {
            if let Some(token) = self.registry.token(*asset) {
                out.insert(*asset, (*price, token.decimals));
            }
        }
        out
    }

    async fn trigger_floors(&self) -> PoolFloors {
        if !self.settings.dynamic_floors {
            return PoolFloors::fixed(self.min_swap_usd(), self.registry.pools.len());
        }
        {
            let cache = self.pool_floors.lock().expect("pool floors mutex poisoned");
            if let Some(cached) = cache.as_ref()
                && cached.at.elapsed() < POOL_FLOORS_TTL
            {
                return cached.floors.clone();
            }
        }
        let prices = self.refresh_trigger_prices().await;
        let floors = self.read_pool_floors(&prices).await;
        for (index, pool) in self.registry.pools.iter().enumerate() {
            match floors.per_pool.get(index).and_then(|floor| *floor) {
                Some(floor) => debug!(
                    pool = %pool.address,
                    venue = ?pool.venue,
                    floor_usd = format!("{floor:.0}"),
                    "trigger floor"
                ),
                None => debug!(
                    pool = %pool.address,
                    venue = ?pool.venue,
                    floor_usd = floors.fallback,
                    "trigger floor unavailable; using configured minimum"
                ),
            }
        }
        *self.pool_floors.lock().expect("pool floors mutex poisoned") = Some(CachedPoolFloors {
            at: Instant::now(),
            floors: floors.clone(),
        });
        floors
    }

    /// One Multicall3 round-trip reads every pool's fee and depth: reserves
    /// for constant-product pools (plus the Aerodrome factory fee), and
    /// `fee()` + `slot0` + `liquidity` for the concentrated ones. A pool whose
    /// reads fail — or whose answers are not usable — keeps the fallback
    /// floor; a missing floor means "scan as before", never "skip".
    async fn read_pool_floors(&self, prices: &HashMap<Address, (f64, u8)>) -> PoolFloors {
        use crate::abi::{aerodrome_factory, cl_pool, pool};
        use alloy::sol_types::SolCall;

        let fallback = self.min_swap_usd();
        let n_pools = self.registry.pools.len();

        struct Plan {
            index: usize,
            depth: usize,
            fee: Option<usize>,
            liquidity: Option<usize>,
        }
        let mut calls: Vec<(Address, Bytes)> = Vec::new();
        let mut plans: Vec<Plan> = Vec::new();
        for (index, cp_pool) in self.registry.pools.iter().enumerate() {
            let mut plan = Plan {
                index,
                depth: calls.len(),
                fee: None,
                liquidity: None,
            };
            match cp_pool.venue {
                Venue::UniV2 => {
                    calls.push((
                        cp_pool.address,
                        pool::getReservesCall {}.abi_encode().into(),
                    ));
                }
                Venue::Aerodrome { stable } => {
                    calls.push((
                        cp_pool.address,
                        pool::getReservesCall {}.abi_encode().into(),
                    ));
                    plan.fee = Some(calls.len());
                    calls.push((
                        base::AERODROME_FACTORY,
                        aerodrome_factory::getFeeCall {
                            pool: cp_pool.address,
                            stable,
                        }
                        .abi_encode()
                        .into(),
                    ));
                }
                Venue::UniV3 { .. } | Venue::Slipstream { .. } | Venue::PancakeV3 { .. } => {
                    calls.push((cp_pool.address, cl_pool::slot0Call {}.abi_encode().into()));
                    plan.fee = Some(calls.len());
                    calls.push((cp_pool.address, cl_pool::feeCall {}.abi_encode().into()));
                    plan.liquidity = Some(calls.len());
                    calls.push((
                        cp_pool.address,
                        cl_pool::liquidityCall {}.abi_encode().into(),
                    ));
                }
            }
            plans.push(plan);
        }

        let results = chain::multicall_raw(&self.provider, &calls, BlockId::latest()).await;
        let decoded = |idx: usize| -> Option<Bytes> {
            results
                .get(idx)
                .and_then(|value| value.as_ref().ok())
                .cloned()
        };
        let slot0_sqrt = |data: &Bytes| -> Option<f64> {
            // Word 0 of slot0 is sqrtPriceX96 in every V3-family layout.
            data.get(..32)
                .map(|word| u256_to_f64(U256::from_be_slice(word)))
        };

        let mut fees: Vec<Option<f64>> = vec![None; n_pools];
        let mut depths: Vec<Option<f64>> = vec![None; n_pools];
        for plan in &plans {
            let cp_pool = &self.registry.pools[plan.index];
            match cp_pool.venue {
                Venue::UniV2 | Venue::Aerodrome { .. } => {
                    // Uniswap V2 charges the classic 0.30 % and exposes no fee
                    // getter; Aerodrome's factory answer is already basis
                    // points, bounded like in `cp_pools`.
                    let fee = match cp_pool.venue {
                        Venue::UniV2 => Some(UNIV2_FEE_BPS),
                        _ => match plan.fee.and_then(decoded) {
                            Some(data) => aerodrome_factory::getFeeCall::abi_decode_returns(&data)
                                .ok()
                                .filter(|fee| *fee <= AERO_FEE_MAX)
                                .map(u256_to_f64),
                            None => None,
                        },
                    };
                    fees[plan.index] = fee;
                    // USD depth of a constant-product pool: the smaller
                    // priced side. With only USDC priced this is exactly the
                    // §0f USDC-side reserve.
                    depths[plan.index] = decoded(plan.depth)
                        .and_then(|data| pool::getReservesCall::abi_decode_returns(&data).ok())
                        .and_then(|reserves| {
                            let sides = [
                                (cp_pool.token0, reserves.reserve0),
                                (cp_pool.token1, reserves.reserve1),
                            ];
                            side_min_usd(&sides, prices)
                        });
                }
                Venue::UniV3 { .. } | Venue::Slipstream { .. } | Venue::PancakeV3 { .. } => {
                    fees[plan.index] = plan
                        .fee
                        .and_then(decoded)
                        .and_then(|data| cl_pool::feeCall::abi_decode_returns(&data).ok())
                        // Fee tiers are in millionths; basis points are 1/100
                        // of that (833 raw = 8.33 bps).
                        .map(|fee| f64::from(fee.to::<u32>()) / 100.0);
                    let sqrt = decoded(plan.depth).as_ref().and_then(slot0_sqrt);
                    depths[plan.index] = match (sqrt, plan.liquidity.and_then(decoded)) {
                        (Some(sqrt), Some(liq_data)) => {
                            cl_pool::liquidityCall::abi_decode_returns(&liq_data)
                                .ok()
                                .and_then(|liq| {
                                    cl_depth_usd(
                                        sqrt,
                                        u256_to_f64(U256::from(liq)),
                                        prices.get(&cp_pool.token0).copied(),
                                        prices.get(&cp_pool.token1).copied(),
                                    )
                                })
                        }
                        _ => None,
                    };
                }
            }
        }

        // Cheapest partner fee across the *other* pools with a known fee.
        let cheapest_excluding = |index: usize| -> Option<f64> {
            fees.iter()
                .enumerate()
                .filter(|(other, _)| *other != index)
                .filter_map(|(_, fee)| *fee)
                .fold(None, |min: Option<f64>, fee| {
                    Some(min.map_or(fee, |m| m.min(fee)))
                })
        };

        let slippage = f64::from(self.settings.per_leg_slippage_bps);
        let buffer = f64::from(self.settings.min_profit_buffer_bps);
        let per_pool = (0..n_pools)
            .map(|index| {
                let (Some(depth), Some(fee_self)) = (depths[index], fees[index]) else {
                    return None;
                };
                let fee_partner = cheapest_excluding(index).unwrap_or(fee_self);
                let cost_frac = (fee_self + fee_partner + 2.0 * slippage + buffer) / 10_000.0;
                trigger_floor_usd(depth, cost_frac, self.settings.min_net_profit_usd)
            })
            .collect::<Vec<Option<f64>>>();
        let rows = self
            .registry
            .pools
            .iter()
            .enumerate()
            .map(|(index, pool)| {
                // The bare venue label is no longer unique across pairs;
                // annotate non-legacy pools with the pair they sit on.
                let venue = if pool.is_usdc_weth() {
                    pool.venue.label()
                } else {
                    format!(
                        "{} ({}/{})",
                        pool.venue.label(),
                        self.registry.symbol(pool.token0),
                        self.registry.symbol(pool.token1)
                    )
                };
                PoolFloorRow {
                    address: pool.address,
                    venue,
                    fee_bps: fees[index],
                    depth_usd: depths[index],
                    floor_usd: per_pool[index].unwrap_or(fallback),
                    dynamic: per_pool[index].is_some(),
                }
            })
            .collect();
        PoolFloors {
            per_pool,
            fallback,
            rows,
        }
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

    /// USD notional of a swap log: the larger priced side (both sides are
    /// near-equal by the pool invariant; the max errs toward scanning).
    /// `None` when the log is not a swap, the pool is unknown, or no side has
    /// a usable price — those logs are left unfiltered rather than silently
    /// dropped.
    fn swap_notional_usd(&self, log: &Log) -> Option<f64> {
        let pool = self.registry.pool(*self.pool_index.get(&log.address())?);
        swap_notional_usd(log, pool, &self.usd_price_map())
    }

    /// Record a delivered head as the pin for upcoming scans, keeping the
    /// highest number seen (Base heads arrive in order, but a batch may be
    /// processed out of sequence after coalescing).
    pub fn note_head(&self, head: &HeadInfo) {
        let pin = chain::Pin::from_header(
            head.number,
            Some(head.hash),
            head.timestamp,
            head.base_fee_per_gas,
        );
        let mut cached = self.head_pin.lock().expect("head pin mutex poisoned");
        if cached
            .as_ref()
            .is_none_or(|current| pin.number >= current.number)
        {
            *cached = Some(pin);
        }
    }

    /// Drop the head pin: after a reconnect the socket may be seconds behind,
    /// and the next scan should resolve `latest` until a fresh head lands.
    pub fn forget_head(&self) {
        *self.head_pin.lock().expect("head pin mutex poisoned") = None;
    }

    /// Whether socket-head pinning is active for this scanner (test and CLI
    /// diagnostic): true only when subscriptions and reads share one endpoint.
    pub fn head_pinning(&self) -> bool {
        self.head_pinning
    }

    pub fn cached_pin(&self) -> Option<chain::Pin> {
        let cached = self.head_pin.lock().expect("head pin mutex poisoned");
        cached.as_ref().copied()
    }

    /// The pin for a scan: the socket's newest head when one is known, else
    /// one round-trip behind the node. CLI paths (no subscription) always
    /// resolve; watch paths normally never do.
    async fn scan_pin(&self) -> Result<chain::Pin> {
        match self.cached_pin() {
            Some(pin) if self.head_pinning => {
                debug!(
                    block = pin.number,
                    "pinned from the socket head (no round-trip)"
                );
                Ok(pin)
            }
            _ => chain::Pin::resolve_latest(&self.provider).await,
        }
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

        // The `plan` path is the simulate-what-you-propose path: it must
        // price every leg on chain at the pin (§0u), so both local caches
        // are deliberately empty here.
        let (quotes, _failed) = self
            .quote_jobs(
                std::slice::from_ref(route),
                &[(0usize, amount)],
                block_id,
                &HashMap::new(),
                &HashMap::new(),
            )
            .await;
        let Some(Some(quotes)) = quotes.into_iter().next() else {
            bail!("could not quote route");
        };
        Ok(simulate_route(
            &self.provider,
            &self.registry,
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
        // Feed the head-pin cache from this batch before anything reads the
        // chain. A Reconnect clears it: the socket may have missed heads, and
        // until a fresh one lands the scan resolves `latest` instead of
        // trusting a pin that could be minutes old.
        for trigger in triggers {
            match trigger {
                Trigger::Head { head } => self.note_head(head),
                Trigger::Reconnect => {
                    self.forget_head();
                    self.mark_all_cl_stale();
                }
                _ => {}
            }
        }
        // Cache upkeep runs for every delivered log, before the dust screen
        // and dedupe decide whether this batch is worth a scan at all.
        self.apply_cl_logs(triggers);
        let notional_of = |log: &Log| self.swap_notional_usd(log);
        let is_seen = |key: &TriggerKey| {
            self.deduper
                .lock()
                .expect("dedupe mutex poisoned")
                .contains(key)
        };
        // Cached per-pool floors (or the configured fixed floor when dynamic
        // floors are off). Advisory only: a fetch failure leaves every pool on
        // the configured floor inside `PoolFloors`.
        let floors = self.trigger_floors().await;
        let floor_of = |pool: Option<usize>| floors.floor_for(pool);
        // Scoped so the guard is dropped long before the evaluate await.
        let plan = {
            let mut last_block = self.last_block.lock().expect("last block mutex poisoned");
            plan_batch(
                triggers,
                &mut last_block,
                &self.pool_index,
                &floor_of,
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
        let pin_started = Instant::now();
        let mut pin = match self.scan_pin().await {
            Ok(pin) => pin,
            Err(err) => {
                // A failed pin is "unknown", not "no opportunity": say so.
                warn!(error = %err, "could not pin a block; scan aborted");
                return Err(err);
            }
        };
        let pin_ms = elapsed_millis(pin_started);
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
            pin_ms,
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

        // A trigger only invalidates the routes that contain its pools, so the CL
        // cache needs only the pools those routes walk. Bootstrapping the rest
        // is pure archive I/O (a cold fork pays it tick by tick) and cannot
        // affect this scan. A full scan / reconnect (`affected == None`) still
        // needs everything.
        let relevant_pools: Option<HashSet<usize>> = affected_set.as_ref().map(|affected| {
            let mut set = HashSet::new();
            for routes in self.routes.values() {
                for route in routes {
                    if route
                        .steps
                        .iter()
                        .any(|step| affected.contains(&step.pool_index))
                    {
                        set.extend(route.pool_indices());
                    }
                }
            }
            set
        });

        // One round-trip fetches every constant-product pool's reserves so the
        // probe/refine below can price those legs locally instead of via the
        // router. Shared across assets (same pinned block).
        let (cp, cl) = tokio::join!(
            self.cp_pools(block_id),
            self.cl_states(relevant_pools.as_ref())
        );

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
        let cl_ref = &cl;
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
                        cl_ref,
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

        // Freshness pass. Pinning (§0k) bought internal consistency at the
        // price of one block of staleness; this recovers it for exactly the
        // reported finalists: re-pin, re-quote and re-simulate *only* them
        // at one new pinned block. The common case pays nothing — no
        // opportunities, or a head that has not moved, and it never mixes
        // blocks: the final set is either every finalist at the new pin or
        // the untouched pass-1 set.
        if self.settings.freshness && !report.opportunities.is_empty() {
            let started = Instant::now();
            let first_pin = pin;
            let before = std::mem::take(&mut report.opportunities);
            match self.freshness_pass(first_pin, &before).await {
                Fresh::Skipped(reason) => {
                    report.opportunities = before;
                    report.notes.push(reason);
                }
                Fresh::Failed(reason) => {
                    report.opportunities = before;
                    report.notes.push(format!(
                        "{reason}; opportunities still describe block {}",
                        first_pin.number
                    ));
                }
                Fresh::Applied {
                    pin: fresh_pin,
                    opportunities,
                } => {
                    pin = fresh_pin;
                    report.block = fresh_pin.number;
                    report.pin_hash = fresh_pin.hash;
                    report.opportunities = opportunities;
                    report.notes.push(format!(
                        "freshness pass: finalists re-priced at block {}",
                        fresh_pin.number
                    ));
                }
            }
            report.fresh_ms += elapsed_millis(started);
        }

        // Freshness, made visible instead of silently mixed into the numbers.
        // Everything above describes one pinned block; this says how far the
        // chain moved while the scan worked. A failed read here must not
        // invalidate a scan that already completed, so drift is simply not
        // reported in that case.
        // Was the block we just scanned replaced while we worked? Cheaper and
        // safer than assuming: re-read the header at our own number and check
        // its hash. Reads can still succeed against a discarded block, so
        // without this a re-org would produce confident numbers about nothing.
        // The two post-scan reads are independent (has the pin been replaced?
        // where is head now?) — run them concurrently so the check §0k pays
        // for re-org detection costs one round-trip, not two.
        let reorg_check = chain::header_hash(&self.provider, pin.number);
        let head_now = chain::block_number(&self.provider);
        let (reorg_check, head_now) = tokio::join!(reorg_check, head_now);

        if pin.hash.is_some() {
            match reorg_check {
                Ok(current) if pin.is_superseded_by(current) => {
                    report.reorged = true;
                    self.mark_all_cl_stale();
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
        if let Ok(head_now) = head_now {
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

    /// The second, small pass: re-resolve a pin and re-quote + re-simulate
    /// only the given finalists at that fresh block. Reads its own core
    /// state too, so a core paused (or gas spiked) between the blocks voids
    /// the refresh instead of reporting a stale "yes" as if it were new.
    pub async fn freshness_pass(&self, first: chain::Pin, opportunities: &[Opportunity]) -> Fresh {
        let pin = match chain::Pin::resolve_latest(&self.provider).await {
            Ok(pin) => pin,
            Err(err) => return Fresh::Failed(format!("could not re-pin: {err}")),
        };
        if pin.number == first.number {
            return Fresh::Skipped(format!(
                "head unchanged at block {}; opportunities are already fresh",
                pin.number
            ));
        }
        let block_id = pin.id();

        let core = match self.load_core_state(pin).await {
            Ok(core) => core,
            Err(err) => return Fresh::Failed(format!("fresh core state unreadable: {err}")),
        };
        if core.paused {
            return Fresh::Failed("core is paused at the fresh block".to_string());
        }
        let (gas_snapshot, eth_usd) = match self.gas_context(pin).await {
            Ok(context) => context,
            Err(err) => return Fresh::Failed(format!("fresh gas context failed: {err}")),
        };
        if eth_usd <= 0.0 {
            return Fresh::Failed("ETH/USD unavailable at the fresh block".to_string());
        }
        if let Some(note) =
            gas_ceiling_note(&self.settings, core.max_gas_price, gas_snapshot.gas_price)
        {
            return Fresh::Failed(note);
        }
        let asset_prices = self.asset_usd_prices(eth_usd, pin).await;
        let cp = self.cp_pools(block_id).await;

        // One job per finalist; identical legs dedupe inside quote_jobs, so
        // a handful of two-hop routes costs one multicall round per leg.
        let routes: Vec<Route> = opportunities
            .iter()
            .map(|opportunity| opportunity.route.clone())
            .collect();
        let jobs: Vec<(usize, U256)> = opportunities
            .iter()
            .enumerate()
            .map(|(index, opportunity)| (index, opportunity.amount))
            .collect();
        // Honesty split (§0u): these are finalist legs being re-priced for
        // the money numbers — keep them on chain even where probe rounds
        // used local CL math.
        let (quotes, failed) = self
            .quote_jobs(&routes, &jobs, block_id, &cp, &HashMap::new())
            .await;
        if failed > 0 {
            return Fresh::Failed(format!(
                "{failed} leg quotes could not be re-priced at block {}",
                pin.number
            ));
        }

        let mut outcomes = Vec::with_capacity(opportunities.len());
        for (opportunity, quote) in opportunities.iter().zip(quotes) {
            let Some(quotes) = quote else {
                outcomes.push(Refresh::Inconclusive(format!(
                    "{} route could not be re-quoted",
                    opportunity.asset_symbol
                )));
                continue;
            };
            let Some(asset_usd) = asset_prices.get(&opportunity.asset).copied() else {
                outcomes.push(Refresh::Inconclusive(format!(
                    "{} lost its USD feed",
                    opportunity.asset_symbol
                )));
                continue;
            };
            let decimals = self
                .registry
                .token(opportunity.asset)
                .map(|token| token.decimals)
                .unwrap_or(18);
            // Simulate-what-you-propose holds here too: simulate_route
            // rebuilds the floors from *these* fresh quotes and simulates
            // exactly the steps it returns as calldata.
            let (refreshed, definitive_loss) = simulate_route(
                &self.provider,
                &self.registry,
                &self.manifest,
                &self.settings,
                &opportunity.asset_symbol,
                opportunity.asset,
                decimals,
                &opportunity.route,
                opportunity.amount,
                &quotes,
                &gas_snapshot,
                eth_usd,
                asset_usd,
                block_id,
                opportunity.preconfirmed,
            )
            .await;
            outcomes.push(match refreshed {
                Some(refreshed) => Refresh::Replaced(refreshed),
                None if definitive_loss => Refresh::Gone,
                None => Refresh::Inconclusive(format!(
                    "{} could not be re-simulated",
                    opportunity.asset_symbol
                )),
            });
        }

        match merge_refreshed(&outcomes) {
            Ok(mut refreshed) => {
                refreshed.sort_by(|a, b| {
                    b.net_usd
                        .partial_cmp(&a.net_usd)
                        .unwrap_or(std::cmp::Ordering::Equal)
                });
                Fresh::Applied {
                    pin,
                    opportunities: refreshed,
                }
            }
            Err(reason) => Fresh::Failed(reason),
        }
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
                Venue::UniV3 { .. } | Venue::Slipstream { .. } | Venue::PancakeV3 { .. } => {
                    continue;
                }
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

    /// Warm the CL cache without waiting for the first trigger
    /// (Phase 4a-1): `watch` pays one bootstrap wave at startup instead of
    /// inside the first scan that needs it. Idempotent — the same sync runs
    /// per scan via `cl_states`; calling this with the gate closed still
    /// fills storage, which only becomes readable once armed.
    pub async fn prime_cl(&self) {
        if !self.settings.local_cl {
            return;
        }
        self.cl_cache_sync(None).await;
    }

    /// Warm only the CL pools that a trigger on `affected` can reach. One
    /// trigger invalidates a narrow route set; bootstrapping the other pools
    /// is archive I/O for legs this scan cannot quote.
    pub async fn prime_cl_for(&self, affected: &[usize]) {
        if !self.settings.local_cl {
            return;
        }
        let affected: HashSet<usize> = affected.iter().copied().collect();
        let mut relevant = HashSet::new();
        for routes in self.routes.values() {
            for route in routes {
                if route
                    .steps
                    .iter()
                    .any(|step| affected.contains(&step.pool_index))
                {
                    relevant.extend(route.pool_indices());
                }
            }
        }
        self.cl_cache_sync(Some(&relevant)).await;
    }

    /// Snapshot the CL cache for one scan: re-bootstrap pools that are
    /// missing or stale, refresh Slipstream's dynamic fees, and hand back
    /// owned clones. Every failure mode degrades to "no local answer" (the
    /// leg quotes on chain); nothing in this path can remove a candidate.
    /// Reads are at `latest`, not at the scan's pin: the cache is
    /// event-maintained and advisory — candidate selection only. Finalists
    /// and the `plan` path are always priced on chain at the pin (§0u).
    /// Returns empty until the trigger inbox has run at least once
    /// (`cl_armed`): a cache nobody feeds is not an honest cache.
    async fn cl_states(&self, relevant: Option<&HashSet<usize>>) -> HashMap<usize, ClPoolState> {
        if !self.settings.local_cl || !self.cl_armed.load(Ordering::Relaxed) {
            return HashMap::new();
        }
        self.cl_cache_sync(relevant).await
    }

    async fn cl_cache_sync(
        &self,
        relevant: Option<&HashSet<usize>>,
    ) -> HashMap<usize, ClPoolState> {
        let (mut map, need) = {
            let cache = self.cl_pools.lock().expect("cl cache mutex poisoned");
            let mut need: Vec<ClPoolSpec> = self
                .cl_specs
                .iter()
                .filter(|spec| relevant.is_none_or(|set| set.contains(&spec.index)))
                .filter(|spec| cache.get(&spec.index).is_none_or(|state| state.stale))
                .copied()
                .collect();
            if !need.is_empty() {
                let failed = self
                    .cl_boot_fail
                    .lock()
                    .expect("cl cooldown mutex poisoned");
                if let Some(at) = *failed
                    && at.elapsed() < CL_BOOT_COOLDOWN
                {
                    need.clear();
                }
            }
            (cache.clone(), need)
        };
        if !need.is_empty() {
            let head = chain::block_number(&self.provider).await.unwrap_or(0);
            let fresh =
                clamm::bootstrap_pools(&self.provider, &need, BlockId::latest(), head).await;
            let mut failed = self
                .cl_boot_fail
                .lock()
                .expect("cl cooldown mutex poisoned");
            if fresh.is_empty() {
                *failed = Some(Instant::now());
                debug!("cl bootstrap failed; every CL leg stays remote");
            } else {
                *failed = None;
                debug!(pools = fresh.len(), "cl bootstrap");
            }
            map.extend(fresh);
        }
        // Slipstream's `fee()` is dynamic; refresh it for the pools that were
        // not just re-bootstrapped (those already read a fresh fee).
        let refreshing: Vec<(usize, Address)> = self
            .cl_specs
            .iter()
            .filter(|spec| {
                spec.dynamic_fee
                    && !need.iter().any(|n| n.index == spec.index)
                    && map.contains_key(&spec.index)
            })
            .map(|spec| (spec.index, spec.address))
            .collect();
        if !refreshing.is_empty() {
            let addrs: Vec<Address> = refreshing.iter().map(|(_, addr)| *addr).collect();
            let fees = clamm::fetch_fees(&self.provider, &addrs, BlockId::latest()).await;
            for ((index, _), fee) in refreshing.iter().zip(fees) {
                if let (Some(fee), Some(state)) = (fee, map.get_mut(index)) {
                    state.refresh_fee(fee);
                }
            }
        }
        let out = map.clone();
        *self.cl_pools.lock().expect("cl cache mutex poisoned") = map;
        out
    }

    /// Fold the batch's pool logs into the CL cache before anything else
    /// reads it. Swap events carry the post-state words, so steady-state
    /// maintenance costs no RPC; any other pool log (mint/burn/collect/…)
    /// can flip tick state the cached bitmap has not seen, so it marks the
    /// pool stale. This runs for every delivered log: the dust screen gates
    /// scanning, never cache upkeep.
    fn apply_cl_logs(&self, triggers: &[Trigger]) {
        if !self.settings.local_cl {
            return;
        }
        // Consuming triggers is what certifies the cache: from here on every
        // state change that could move a price passes through this inbox.
        self.cl_armed.store(true, Ordering::Relaxed);
        let mut cache = self.cl_pools.lock().expect("cl cache mutex poisoned");
        for trigger in triggers {
            let logs: &[Log] = match trigger {
                Trigger::Log { log, .. } => std::slice::from_ref(log),
                Trigger::Flashblock { logs, .. } => logs.as_slice(),
                _ => continue,
            };
            for log in logs {
                let Some(&index) = self.pool_index.get(&log.address()) else {
                    continue;
                };
                let Some(state) = cache.get_mut(&index) else {
                    continue; // not cached yet: bootstrap will read the truth
                };
                match clamm::swap_after_words(log) {
                    Some((sqrt, liquidity, tick)) => state.apply_swap_after(sqrt, liquidity, tick),
                    // Collect/Flash/CollectProtocol/SetFeeProtocol/
                    // IncreaseObservationCardinalityNext move fees, oracle
                    // slots or the protocol-fee split only. None of them can
                    // change price, liquidity, the bitmap or the tick nets,
                    // so treating them as "unknown, re-bootstrap" forced a
                    // cold tick wave on the busiest pools for no information.
                    None if log
                        .topics()
                        .first()
                        .is_some_and(|topic| clamm::is_benign_event(*topic)) => {}
                    // Mint/Burn (and any unrecognised event) can flip tick
                    // state the cached bitmap has not seen: re-read.
                    None => state.mark_stale(),
                }
            }
        }
    }

    /// Reconnect/re-org: the socket may have missed pool logs, and a
    /// discarded block's after-state words were applied in good faith. Only
    /// a re-read can vouch for the cache now.
    fn mark_all_cl_stale(&self) {
        let mut cache = self.cl_pools.lock().expect("cl cache mutex poisoned");
        for state in cache.values_mut() {
            state.stale = true;
        }
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
        cl: &HashMap<usize, ClPoolState>,
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
        let Some(cap) = effective_cap(manifest_cap, core_cap) else {
            report.notes.push(format!(
                "{symbol} cap is zero (manifest {manifest_cap}, core {core_cap}); asset is not tradable"
            ));
            return Ok(report);
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
        let (results, failed) = self.quote_jobs(&all_routes, &jobs, block_id, cp, cl).await;
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
                .quote_jobs(&refined_routes, &refine_jobs, block_id, cp, cl)
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
            let registry = self.registry.clone();
            let manifest = self.manifest.clone();
            let settings = self.settings.clone();
            let symbol = symbol.clone();
            async move {
                if amount.is_zero() || quotes.len() != route.steps.len() + 1 {
                    return (None, false);
                }
                simulate_route(
                    &provider,
                    &registry,
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
                    route = ?opportunity.labels(&self.registry),
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
        cl: &HashMap<usize, ClPoolState>,
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

                // Local concentrated-liquidity leg (§0u). The cache is
                // event-maintained ("the chain as the socket saw it"), so it
                // drives probe/refine candidate selection only; a refusal —
                // stale, uncovered ticks, dust — quotes on chain like always.
                if let LegPrice::Local(out) = price_cl_leg(cl, step, input) {
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
    registry: &crate::routes::Registry,
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

    // Gas estimation does not depend on the *value* of `minProfit` (it is one
    // static word and the only branch reads it after the route has run), so
    // price the execute calldata with a placeholder of zero and start the
    // estimate concurrently with the simulate + L1 batch. This overlaps the
    // two expensive EVM executions instead of serialising them. The final
    // calldata length is asserted against the batched L1 bound below, so an
    // ABI change still fails loudly.
    let placeholder = ryo::executeCall {
        asset,
        amount,
        steps: steps.clone(),
        minProfit: U256::ZERO,
    };
    let gas_future = chain::estimate_gas_from(
        provider,
        manifest.core,
        Bytes::from(placeholder.abi_encode()),
        Some(manifest.operator),
    );
    // One pinned batch carries both probes: the simulation and the L1 bound
    // for the execute transaction these same steps will produce (§0t).
    let (sim_result, gas_result) = tokio::join!(
        simulate::simulate_with_l1_fee(provider, manifest.core, asset, amount, steps.clone(), block),
        gas_future,
    );
    let costs = match sim_result {
        Ok(costs) => costs,
        Err(simulate::SimCostError::Definitive(SimulateError::Revert { decoded, .. })) => {
            debug!(route = ?route.labels(registry), %decoded, "simulation reverted");
            return (None, true);
        }
        // A simulate that returns successfully (or a zero-floor step) means
        // ABI/contract mismatch, not a market verdict: inconclusive, never a
        // cached loss — the same classification the separate calls used.
        Err(simulate::SimCostError::Definitive(other)) => {
            warn!(error = %other, "simulate batch produced a non-market verdict");
            return (None, false);
        }
        Err(simulate::SimCostError::Inconclusive(message)) => {
            warn!(error = %message, "simulation batch transport/decode failure");
            return (None, false);
        }
    };
    let simulation = costs.simulation;

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

    // The batch priced the L1 leg at the size predicted from the simulate
    // calldata (`execute_calldata_len`: one extra word for `minProfit`). If
    // the real encode ever disagrees, the prediction priced the wrong fee —
    // skip inconclusively rather than carry it. An ABI change shows up here
    // loudly instead of as a subtly wrong `net_usd`. Fail-closed semantics
    // are unchanged: a missing or mismatched cost never defaults to zero.
    if calldata.len() != costs.expected_execute_len {
        warn!(
            actual = calldata.len(),
            predicted = costs.expected_execute_len,
            "execute calldata length diverged from the L1 bound priced in the batch; candidate skipped"
        );
        return (None, false);
    }
    let l1_fee = costs.l1_fee;

    let Ok(route_hash) = route.route_hash(manifest, &floors) else {
        return (None, false);
    };

    let gas_used = match gas_result {
        Ok(gas) => gas,
        Err(err) => {
            debug!(error = %err, "gas estimate failed; using fallback");
            settings.fallback_gas
        }
    };

    let cost = gas::trade_cost(gas_used, gas_snapshot.gas_price, l1_fee, eth_usd);
    let profit_usd = gas::profit_usd(profit_raw, decimals, asset_usd);
    let net_usd = profit_usd - cost.total_fee_usd;
    debug!(
        route = ?route.labels(registry),
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

/// One row of the trigger-floor table: what the reader measured about a pool
/// and the floor it produced (or the fallback it will use).
#[derive(Debug, Clone, PartialEq)]
pub struct PoolFloorRow {
    pub address: Address,
    pub venue: String,
    /// Swap fee in basis points, read from the pool/factory. `None` when the
    /// read failed.
    pub fee_bps: Option<f64>,
    /// In-range USD depth. `None` when the read failed or is not usable.
    pub depth_usd: Option<f64>,
    /// The floor this pool actually uses (computed, or the fallback).
    pub floor_usd: f64,
    /// Whether `floor_usd` came from live fee/depth reads.
    pub dynamic: bool,
}

/// Per-pool trigger floors for one registry cycle. `per_pool` is indexed by
/// registry pool order; a `None` entry means the pool's fee or depth could
/// not be read this cycle, and it falls back to the configured fixed floor.
/// Floors only decide whether it is worth *quoting* a pool: they never
/// participate in any reported money number.
#[derive(Debug, Clone)]
pub struct PoolFloors {
    per_pool: Vec<Option<f64>>,
    fallback: f64,
    rows: Vec<PoolFloorRow>,
}

impl PoolFloors {
    /// One fixed floor for every pool — dynamic floors disabled, or no
    /// context could be read at all.
    fn fixed(floor_usd: f64, pools: usize) -> Self {
        Self {
            per_pool: vec![None; pools],
            fallback: floor_usd,
            rows: Vec::new(),
        }
    }

    pub fn floor_for(&self, pool: Option<usize>) -> f64 {
        pool.and_then(|index| self.per_pool.get(index))
            .and_then(|floor| *floor)
            .unwrap_or(self.fallback)
    }

    /// Audit view: one row per pool with the measured fee, depth, and floor.
    pub fn rows(&self) -> &[PoolFloorRow] {
        &self.rows
    }
}

/// The smallest swap (USD) that could possibly make a pool worth scanning.
///
/// Model (§0f's edge estimate, made pool-specific): a swap of size `s` into
/// a pool of USD depth `D` moves its price by about `m = 2s/D`. For any route
/// touching that pool to clear the gates, the gap it leaves must at least pay
/// the round-trip cost `c` (this pool's fee + the cheapest partner's fee +
/// per-leg slippage + the profit buffer), so `s ≥ c·D/2`; and the closable
/// edge `≈ ½·m·s = s²/D` must reach the profit target `P`, so `s ≥ √(P·D)`.
/// Both are necessary conditions, hence the `max`. Every approximation here
/// errs toward *overestimating* the achievable edge (an infinitely deep
/// partner pool, constant-product behaviour on stable curves), so a
/// borderline swap still scans: a floor must never skip a trade the gates
/// would have taken.
fn trigger_floor_usd(depth_usd: f64, cost_frac: f64, profit_usd: f64) -> Option<f64> {
    if !depth_usd.is_finite()
        || depth_usd <= 0.0
        || !cost_frac.is_finite()
        || cost_frac < 0.0
        || !profit_usd.is_finite()
        || profit_usd < 0.0
    {
        return None;
    }
    let fee_bound = cost_frac * depth_usd / 2.0;
    let edge_bound = (profit_usd * depth_usd).sqrt();
    Some(fee_bound.max(edge_bound).max(ABSOLUTE_MIN_SWAP_USD))
}

/// In-range USD depth of a V3-family pool from `slot0`'s first word
/// (`sqrtPriceX96`) and `liquidity`: the two virtual reserves are
/// `L·2^96/√P` of token0 and `L·√P/2^96` of token1 (raw units). Either side
/// alone is the pool's USD depth (they are equal by construction, up to
/// range), so the answer is the **smaller priced side** — if one side has no
/// price, the other prices the pool; with no priced side there is no depth
/// and the pool falls back to the configured floor.
fn cl_depth_usd(
    sqrt_price_x96: f64,
    liquidity: f64,
    token0: Option<(f64, u8)>,
    token1: Option<(f64, u8)>,
) -> Option<f64> {
    if !sqrt_price_x96.is_finite()
        || sqrt_price_x96 <= 0.0
        || !liquidity.is_finite()
        || liquidity <= 0.0
    {
        return None;
    }
    let scaled = |raw: f64, (price, decimals): (f64, u8)| -> Option<f64> {
        let usd = raw / 10f64.powi(i32::from(decimals)) * price;
        (usd.is_finite() && usd > 0.0).then_some(usd)
    };
    let side0 = token0.and_then(|p| scaled(liquidity * Q96 / sqrt_price_x96, p));
    let side1 = token1.and_then(|p| scaled(liquidity * sqrt_price_x96 / Q96, p));
    match (side0, side1) {
        (Some(a), Some(b)) => Some(a.min(b)),
        (Some(a), None) | (None, Some(a)) => Some(a),
        (None, None) => None,
    }
}

/// USD depth of a constant-product pool: the smaller priced side of
/// `(token, raw reserve)` pairs. `None` only when no side has a price.
fn side_min_usd(sides: &[(Address, U256)], prices: &HashMap<Address, (f64, u8)>) -> Option<f64> {
    let mut best: Option<f64> = None;
    for (token, raw) in sides {
        let Some((price, decimals)) = prices.get(token) else {
            continue;
        };
        let usd = gas::raw_to_f64(*raw, *decimals) * price;
        if !usd.is_finite() || usd <= 0.0 {
            continue;
        }
        best = Some(best.map_or(usd, |b| b.min(usd)));
    }
    best
}

/// Tradable ceiling for an asset: `min(manifest cap, core cap)` — and **zero
/// on either side disables the asset**. On-chain `maxTradeSize == 0` is the
/// owner's "not tradable" switch (any `execute` reverts), not "unset"; the
/// manifest cap works the same way. Falling back to the other cap would
/// spend a full scan on trades the contract is guaranteed to reject.
/// `None` means: do not scan this asset.
fn effective_cap(manifest_cap: U256, core_cap: U256) -> Option<U256> {
    if manifest_cap.is_zero() || core_cap.is_zero() {
        return None;
    }
    Some(manifest_cap.min(core_cap))
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
    floor_of: &dyn Fn(Option<usize>) -> f64,
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
            Trigger::Head { head } => {
                let number = head.number;
                let previous = *last_block;
                // Heads are liveness markers. Advance the marker on every
                // head so idle stretches do not look like gaps; only a real
                // jump or a backwards head triggers the full rescan.
                *last_block = Some(number);
                if head_requires_rescan(previous, number) {
                    gap_rescan = true;
                    full_scan = true;
                } else {
                    notes.head_tick(number);
                }
            }
            Trigger::Reconnect => full_scan = true,
            Trigger::Log { log, preconfirmed } => {
                let pool = pool_index.get(&log.address()).copied();
                if let Some(notional) = notional_of(log) {
                    let floor = floor_of(pool);
                    if notional < floor {
                        notes.dust(notional, floor);
                        // Never marked as seen: the later mined duplicate of the
                        // same log must still be evaluated.
                        if let Some(candidate) = &key {
                            batch_keys.remove(candidate);
                        }
                        continue;
                    }
                }
                if *preconfirmed {
                    block = ScanBlock::Pending;
                }
                match pool {
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
                        && notional < floor_of(Some(index))
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

fn swap_notional_usd(
    log: &Log,
    pool: &crate::routes::Pool,
    prices: &HashMap<Address, (f64, u8)>,
) -> Option<f64> {
    let concentrated = matches!(
        pool.venue,
        Venue::UniV3 { .. } | Venue::Slipstream { .. } | Venue::PancakeV3 { .. }
    );
    let (amount0, amount1) = history::swap_deltas(log, concentrated)?;
    let mut best: Option<f64> = None;
    for (token, amount) in [(pool.token0, amount0), (pool.token1, amount1)] {
        let Some((price, decimals)) = prices.get(&token) else {
            continue;
        };
        let usd = gas::raw_to_f64(amount.unsigned_abs(), *decimals) * price;
        if usd.is_finite() {
            best = Some(best.map_or(usd, |b| b.max(usd)));
        }
    }
    best
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

    fn head_at(number: u64) -> crate::events::HeadInfo {
        crate::events::HeadInfo {
            number,
            hash: B256::repeat_byte(number as u8),
            timestamp: 1_700_000_000 + number,
            base_fee_per_gas: Some(1_000_000),
        }
    }

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

    /// The pre-§0s pricing: only USDC is priced at its constant $1.
    fn usdc_prices() -> HashMap<Address, (f64, u8)> {
        HashMap::from([(base::USDC, (1.0, 6))])
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
            swap_notional_usd(&v3_swap(750_000_000), &pool, &usdc_prices()),
            Some(750.0)
        );
        assert_eq!(
            swap_notional_usd(&v3_swap(-750_000_000), &pool, &usdc_prices()),
            Some(750.0)
        );
    }

    #[test]
    fn notional_prices_a_cb_btc_leg_when_usdc_is_absent() {
        // The §0s expansion: WETH/cbBTC pools had no USDC leg and were left
        // unfiltered. With the BTC feed cached, the cbBTC leg now has a size.
        let pool = Pool {
            address: base::CBBTC,
            venue: Venue::UniV3 { fee: 500 },
            token0: base::WETH,
            token1: base::CBBTC,
        };
        let prices = HashMap::from([(base::CBBTC, (77_000.0f64, 8u8))]);
        // 0.05 cbBTC (5e6 raw sats) into the pool.
        let notional = swap_notional_usd(&v3_swap(5_000_000), &pool, &prices).expect("notional");
        assert!((notional - 3_850.0).abs() < 1e-6, "notional {notional}");
        // Still unpriced when the feed never landed: unfiltered, not zero.
        assert!(
            swap_notional_usd(&v3_swap(5_000_000), &pool, &usdc_prices()).is_none(),
            "a pool without a priced leg must stay unfiltered"
        );
    }

    #[test]
    fn notional_takes_the_larger_priced_side() {
        // Both sides of a swap carry roughly the same USD; rounding and fees
        // make them differ slightly. Taking the max errs toward scanning —
        // the side a floor must never skip a trade on.
        let pool = weth_usdc_pool(Venue::UniV3 { fee: 500 });
        let data = format!(
            "0x{}{}{}{}{}",
            // token0 (WETH) out: 0.350877 ETH, and token1 (USDC) in: $750.
            signed_word(-350_877_192_982_456_140),
            signed_word(750_000_000),
            hex_word("0"),
            hex_word("0"),
            hex_word("0")
        );
        let log = log_from_json(json!({
            "address": base::WETH.to_string(),
            "topics": [format!("{:#x}", keccak256(SWAP_V3_SIG.as_bytes()))],
            "data": data,
            "blockNumber": "0x1",
            "transactionIndex": "0x0",
            "logIndex": "0x0"
        }));
        assert_eq!(
            swap_notional_usd(&log, &pool, &usdc_prices()),
            Some(750.0),
            "USDC-only pricing is the §0f behaviour"
        );
        let prices_both = HashMap::from([
            (base::USDC, (1.0f64, 6u8)),
            (base::WETH, (2_280.0f64, 18u8)),
        ]);
        let both = swap_notional_usd(&log, &pool, &prices_both).expect("notional");
        assert!(
            (both - 800.0).abs() < 0.1,
            "the WETH side (0.350877 * 2280 ≈ $800) must beat the USDC side, got {both}"
        );
    }

    #[test]
    fn solidly_notional_uses_signed_delta() {
        let pool = weth_usdc_pool(Venue::Aerodrome { stable: false });
        // 2,000 USDC into the pool: positive token1 delta.
        assert_eq!(
            swap_notional_usd(&solidly_swap(2_000_000_000, 0), &pool, &usdc_prices()),
            Some(2_000.0)
        );
        // 500 USDC out and no USDC in: negative delta, same size.
        assert_eq!(
            swap_notional_usd(&solidly_swap(0, 500_000_000), &pool, &usdc_prices()),
            Some(500.0)
        );
    }

    #[test]
    fn dust_swaps_fall_below_the_default_floor() {
        let pool = weth_usdc_pool(Venue::UniV3 { fee: 500 });
        let floor = effective_min_swap_usd(Settings::default().min_swap_usd);
        let dust =
            swap_notional_usd(&v3_swap(30_000_000), &pool, &usdc_prices()).expect("notional");
        assert!(dust < floor, "dust {dust} should be below floor {floor}");
        let large =
            swap_notional_usd(&v3_swap(5_000_000_000), &pool, &usdc_prices()).expect("notional");
        assert!(large >= floor, "large {large} should pass floor {floor}");
    }

    #[test]
    fn trigger_floor_model_is_pool_specific() {
        // Same $0.25 target and cost fraction, different depth: a deep pool
        // needs a monster swap to move price, a thin one barely needs any.
        let cost = (5.0 + 0.8 + 2.0 * 20.0 + 50.0) / 10_000.0;
        let deep = trigger_floor_usd(42_000_000.0, cost, 0.25).expect("deep");
        let thin = trigger_floor_usd(2_500.0, cost, 0.25).expect("thin");
        assert!(deep > 100_000.0, "deep floor {deep}");
        assert!(thin < 100.0, "thin floor {thin}");
        assert!(deep > thin);
        // Monotone in depth and in cost.
        assert!(trigger_floor_usd(84_000_000.0, cost, 0.25).unwrap() > deep);
        assert!(trigger_floor_usd(42_000_000.0, cost * 2.0, 0.25).unwrap() > deep);
        // A higher profit target raises the floor.
        assert!(trigger_floor_usd(2_500.0, cost, 5.0).unwrap() > thin);
    }

    #[test]
    fn trigger_floor_takes_the_wider_of_fee_and_edge_bounds() {
        let cost = 90.0 / 10_000.0;
        // Fee-bound dominated (deep pool): 0.009 * 1e8 / 2 = 450k >> sqrt(0.25*1e8)=5k.
        assert!((trigger_floor_usd(1e8, cost, 0.25).unwrap() - 450_000.0).abs() < 1.0);
        // Edge-bound dominated (thin pool): sqrt(0.25*1e4) = 50 >> 0.009*1e4/2=45.
        assert!((trigger_floor_usd(1e4, cost, 0.25).unwrap() - 50.0).abs() < 0.1);
        // Never below the hard floor, no matter how small the numbers.
        assert_eq!(
            trigger_floor_usd(1.0, 0.0, 0.0).unwrap(),
            ABSOLUTE_MIN_SWAP_USD
        );
    }

    #[test]
    fn trigger_floor_rejects_unusable_inputs() {
        // A missing/absurd depth or cost yields `None`, which the caller turns
        // into the configured fallback floor — never into "skip everything".
        assert!(trigger_floor_usd(0.0, 0.01, 0.25).is_none());
        assert!(trigger_floor_usd(-5.0, 0.01, 0.25).is_none());
        assert!(trigger_floor_usd(f64::NAN, 0.01, 0.25).is_none());
        assert!(trigger_floor_usd(f64::INFINITY, 0.01, 0.25).is_none());
        assert!(trigger_floor_usd(1e6, -0.01, 0.25).is_none());
        assert!(trigger_floor_usd(1e6, 0.01, f64::NAN).is_none());
    }

    #[test]
    fn cl_depth_formula_matches_pinned_chain_reads() {
        // slot0 word 0 (sqrtPriceX96) and liquidity of the live UniV3 0.05%
        // USDC/WETH pool, captured 2026-11-02 from Base mainnet. The derived
        // in-range depth is $42.39M at that moment; the assertion only checks
        // the formula, and the range absorbs a few percent of price drift
        // between capture and run (the numbers themselves are never recomputed
        // from a formula the test re-states — they come off the chain).
        let sqrt_raw = 0x000000000000000000000000000000000000000000031fcb609245c1e477ce4e_u128;
        let liquidity = 0x0000000000000000000000000000000000000000000c5c4f5211f9991a_u128;
        let depth =
            cl_depth_usd(sqrt_raw as f64, liquidity as f64, None, Some((1.0, 6))).expect("depth");
        // Recomputed at read time the answer was $42,392,143; the raw price
        // ratio moves slowly, so the formula output lands in this band for
        // the captured pair of words — this is a formula pin, not a market pin.
        assert!(
            depth > 41.0e6 && depth < 44.0e6,
            "depth {depth} outside the pinned band"
        );
    }

    #[test]
    fn cl_depth_scales_with_sqrt_price_and_declines_on_garbage() {
        // At sqrtPriceX96 = 2^96 (raw price 1.0), depth is L in raw quote
        // units: 2e12 raw USDC at 6 decimals = $2,000,000.
        let q96 = 2f64.powi(96);
        assert!(
            (cl_depth_usd(q96, 2e12, None, Some((1.0, 6))).unwrap() - 2_000_000.0).abs() < 1.0,
            "unit price must reduce to the raw quote reserve"
        );
        // Double the sqrt price quadruples raw price but only doubles depth.
        assert!(
            (cl_depth_usd(2.0 * q96, 2e12, None, Some((1.0, 6))).unwrap() - 4_000_000.0).abs()
                < 1.0
        );
        assert!(cl_depth_usd(0.0, 2e12, None, Some((1.0, 6))).is_none());
        assert!(cl_depth_usd(q96, 0.0, None, Some((1.0, 6))).is_none());
        assert!(cl_depth_usd(q96, f64::NAN, None, Some((1.0, 6))).is_none());
    }

    #[test]
    fn cl_depth_prices_either_side_and_takes_the_min() {
        // §0s generalization: USDC is not always token1. At raw price 1 with
        // L = 1e11, the token0 side holds 1e11 raw token0 and the token1 side
        // 1e11 raw token1. Token0 = USDC (6 dp) -> $100,000. Token1 = cbBTC
        // (8 dp, $77k) -> 1000 BTC-units * 77,000 = $77,000,000. The depth is
        // the *smaller* priced side, and each side alone is enough.
        let q96 = 2f64.powi(96);
        let usdc_side = Some((1.0f64, 6u8));
        let cbbtc_side = Some((77_000.0f64, 8u8));
        assert!((cl_depth_usd(q96, 1e11, usdc_side, cbbtc_side).unwrap() - 100_000.0).abs() < 1.0);
        assert!(
            (cl_depth_usd(q96, 1e11, usdc_side, None).unwrap() - 100_000.0).abs() < 1.0,
            "one priced side prices the pool"
        );
        assert!(
            (cl_depth_usd(q96, 1e11, None, cbbtc_side).unwrap() - 77_000_000.0).abs() < 1_000.0,
            "the other side alone works too (token order independence)"
        );
        assert!(cl_depth_usd(q96, 1e11, None, None).is_none());
    }

    #[test]
    fn constant_product_depth_uses_priced_sides() {
        let usdc = base::USDC;
        let weth = base::WETH;
        let prices = HashMap::from([(usdc, (1.0f64, 6u8)), (weth, (2_000.0f64, 18u8))]);
        // 10,000 WETH ($20M) and 1M USDC: the smaller priced side is $1M.
        let sides = [
            (weth, U256::from(10_000_000_000_000_000_000_000u128)),
            (usdc, U256::from(1_000_000_000_000u128)),
        ];
        assert!((side_min_usd(&sides, &prices).unwrap() - 1_000_000.0).abs() < 1.0);
        // Only the WETH side priced: it becomes the answer, not None.
        let weth_only = HashMap::from([(weth, (2_000.0f64, 18u8))]);
        assert!((side_min_usd(&sides, &weth_only).unwrap() - 20_000_000.0).abs() < 1.0);
        assert!(side_min_usd(&sides, &HashMap::new()).is_none());
    }

    #[test]
    fn pool_floors_fall_back_per_pool() {
        let floors = PoolFloors {
            per_pool: vec![Some(10_000.0), None, Some(200.0)],
            fallback: 500.0,
            rows: Vec::new(),
        };
        assert_eq!(floors.floor_for(Some(0)), 10_000.0);
        // A pool without a computed floor behaves exactly like the old filter.
        assert_eq!(floors.floor_for(Some(1)), 500.0);
        assert_eq!(floors.floor_for(Some(2)), 200.0);
        // Unknown pools use the fallback too.
        assert_eq!(floors.floor_for(None), 500.0);
        // Out-of-range indices cannot panic.
        assert_eq!(floors.floor_for(Some(99)), 500.0);
        let fixed = PoolFloors::fixed(700.0, 3);
        assert_eq!(fixed.floor_for(Some(0)), 700.0);
        assert_eq!(fixed.floor_for(Some(2)), 700.0);
    }

    #[test]
    fn dynamic_floors_are_per_pool_not_per_batch() {
        // Same $300 swap, two pools, two floors: the thin pool scans, the
        // deep pool's noise does not. With the old fixed filter both answers
        // would have been identical.
        let (a, b) = test_pools(); // a -> index 1, b -> index 0
        let floors = PoolFloors {
            per_pool: vec![Some(200.0), Some(50_000.0)],
            fallback: 500.0,
            rows: Vec::new(),
        };
        let floor_of = |pool: Option<usize>| floors.floor_for(pool);
        let notional = |_: &Log| Some(300.0);
        let thin = vec![log_trigger(b, 1, 0, false)]; // pool index 0, floor 200
        let deep = vec![log_trigger(a, 2, 0, false)]; // pool index 1, floor 50k
        let plan = plan_batch(
            &thin,
            &mut None,
            &test_pool_index(),
            &floor_of,
            &notional,
            &never_seen,
        );
        assert!(plan.scan, "thin-pool $300 swap clears its $200 floor");
        assert_eq!(plan.affected, Some(vec![0]));
        let plan = plan_batch(
            &deep,
            &mut None,
            &test_pool_index(),
            &floor_of,
            &notional,
            &never_seen,
        );
        assert!(
            !plan.scan,
            "deep-pool $300 swap is noise under a $50k floor"
        );
        assert!(
            plan.notes
                .iter()
                .any(|n| n.contains("$300") && n.contains("50000")),
            "the skip must name the pool-specific floor: {:?}",
            plan.notes
        );
    }

    #[test]
    fn pool_without_a_usdc_leg_has_no_notional() {
        let pool = Pool {
            address: base::WETH,
            venue: Venue::UniV3 { fee: 500 },
            token0: base::WETH,
            token1: base::EURC,
        };
        assert!(swap_notional_usd(&v3_swap(750_000_000), &pool, &usdc_prices()).is_none());
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
        assert!(swap_notional_usd(&log, &pool, &usdc_prices()).is_none());
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
    fn either_zero_cap_disables_the_asset() {
        let big = U256::from(8_000_000_000u64);
        let small = U256::from(5_000_000u64);
        assert_eq!(effective_cap(big, small), Some(small));
        assert_eq!(effective_cap(small, big), Some(small));
        // The contract-side disable must survive a generous manifest, and
        // vice versa — this was the bug: a zero used to fall back to the
        // other cap and keep scanning a not-tradable asset.
        assert_eq!(effective_cap(big, U256::ZERO), None);
        assert_eq!(effective_cap(U256::ZERO, big), None);
        assert_eq!(effective_cap(U256::ZERO, U256::ZERO), None);
    }

    #[test]
    fn freshness_merge_is_all_or_nothing() {
        // Conclusive outcomes replace wholesale; Gone entries drop out.
        let outcomes = [
            Refresh::Replaced("a"),
            Refresh::Gone,
            Refresh::Replaced("c"),
        ];
        assert_eq!(merge_refreshed(&outcomes).unwrap(), vec!["a", "c"]);

        // All Gone is still a conclusive answer: the fresh state truthfully
        // rejected every finalist.
        let outcomes: [Refresh<u8>; 2] = [Refresh::Gone, Refresh::Gone];
        assert!(merge_refreshed(&outcomes).unwrap().is_empty());

        // One inconclusive finalist voids the whole pass — a partially
        // refreshed list would mix two blocks in one report.
        let outcomes: [Refresh<&str>; 2] = [
            Refresh::Replaced("a"),
            Refresh::Inconclusive("quote failed".to_string()),
        ];
        let err = merge_refreshed(&outcomes).unwrap_err();
        assert_eq!(err, "quote failed");

        // Multiple reasons join for the report note.
        let outcomes: [Refresh<u8>; 2] = [
            Refresh::Inconclusive("one".to_string()),
            Refresh::Inconclusive("two".to_string()),
        ];
        assert_eq!(merge_refreshed(&outcomes).unwrap_err(), "one; two");
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
        let registry = Registry::base_curated().unwrap();
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
        // A pool appears in 2n-2 two-hop cycles *of its own pair*: n as the
        // first leg, n-1 as the second. Pool 0 is WETH/USDC, which has 16
        // pools; cross-pair pools no longer share those cycles.
        let pair_size = registry
            .pools
            .iter()
            .filter(|p| p.token0 == registry.pool(0).token0 && p.token1 == registry.pool(0).token1)
            .count();
        assert_eq!(pair_size, 16);
        assert_eq!(filtered.len(), 2 * pair_size - 2);
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
            &|_: Option<usize>| 500.0,
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
            &|_: Option<usize>| 500.0,
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
            &|_: Option<usize>| 500.0,
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
            &|_: Option<usize>| 500.0,
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
        let triggers = vec![
            Trigger::Head { head: head_at(11) },
            Trigger::Head { head: head_at(12) },
        ];
        let mut last = Some(10);
        let plan = plan_batch(
            &triggers,
            &mut last,
            &test_pool_index(),
            &|_: Option<usize>| 500.0,
            &not_a_swap,
            &never_seen,
        );
        assert!(!plan.scan);
        assert_eq!(last, Some(12));
        assert_eq!(plan.notes, vec!["2 head ticks (no scan)".to_string()]);
    }

    #[test]
    fn head_gap_in_a_batch_forces_one_full_rescan() {
        let triggers = vec![Trigger::Head { head: head_at(20) }];
        let mut last = Some(12); // 8 blocks skipped
        let plan = plan_batch(
            &triggers,
            &mut last,
            &test_pool_index(),
            &|_: Option<usize>| 500.0,
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
            Trigger::Head { head: head_at(5) },
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

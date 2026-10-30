use std::path::{Path, PathBuf};

use alloy::eips::BlockId;
use alloy::primitives::{Address, U256};
use alloy::sol_types::SolCall;
use anyhow::{Context, Result, bail};
use clap::{Parser, Subcommand};
use ryo_watch::abi::{erc20, pool, ryo};
use ryo_watch::chain::{self, ChainProvider};
use ryo_watch::config::{EventSource, Manifest, Mode, Settings, base};
use ryo_watch::errors::{self, DecodedError};
use ryo_watch::events::{EventStream, redact_url};
use ryo_watch::gas;
use ryo_watch::history;
use ryo_watch::routes::{Registry, enumerate_cycles, parse_route};
use ryo_watch::scanner::{Opportunity, ScanBlock, ScanReport, Scanner};
use ryo_watch::simulate;
use ryo_watch::venues;
use tracing::{debug, error, info, warn};

#[derive(Debug, Parser)]
#[command(
    name = "ryo-watch",
    version,
    about = "Event-driven RyoCore arbitrage watcher for Base"
)]
struct Cli {
    #[arg(
        long,
        env = "RYO_HTTP_RPC",
        default_value = "https://mainnet.base.org",
        global = true
    )]
    http_rpc: String,

    #[arg(long, env = "RYO_WS_RPC", global = true)]
    ws_rpc: Option<String>,

    #[arg(
        long,
        env = "RYO_MANIFEST",
        default_value = "deployments/8453.json",
        global = true
    )]
    manifest: PathBuf,

    #[arg(
        long,
        env = "RYO_MODE",
        value_enum,
        default_value = "dry-run",
        global = true
    )]
    mode: Mode,

    #[arg(
        long,
        env = "RYO_SOURCE",
        value_enum,
        default_value = "pending-logs",
        global = true
    )]
    source: EventSource,

    #[arg(
        long,
        env = "RYO_MIN_NET_PROFIT_USD",
        default_value_t = 0.25,
        global = true
    )]
    min_net_profit_usd: f64,

    #[arg(
        long,
        env = "RYO_MAX_GAS_PRICE_GWEI",
        default_value_t = 0.05,
        global = true
    )]
    max_gas_price_gwei: f64,

    #[arg(long, env = "RYO_SLIPPAGE_BPS", default_value_t = 20, global = true)]
    per_leg_slippage_bps: u32,

    #[arg(
        long,
        env = "RYO_PROFIT_BUFFER_BPS",
        default_value_t = 50,
        global = true
    )]
    min_profit_buffer_bps: u32,

    #[arg(long, env = "RYO_GRID_POINTS", default_value_t = 5, global = true)]
    amount_grid_points: usize,

    #[arg(long, env = "RYO_MAX_CANDIDATES", default_value_t = 16, global = true)]
    max_candidates: usize,

    #[arg(long, env = "RYO_MAX_SIMULATIONS", default_value_t = 8, global = true)]
    max_simulations: usize,

    #[arg(
        long,
        env = "RYO_PROBE_USD",
        value_delimiter = ',',
        default_value = "500,2000,8000",
        global = true
    )]
    probe_usd: Vec<f64>,

    #[arg(long, env = "RYO_MAX_HOPS", default_value_t = 2, global = true)]
    max_hops: usize,

    #[arg(
        long,
        env = "RYO_ASSETS",
        value_delimiter = ',',
        default_value = "USDC,WETH",
        global = true
    )]
    assets: Vec<String>,

    #[arg(
        long,
        env = "RYO_FALLBACK_GAS",
        default_value_t = 450_000,
        global = true
    )]
    fallback_gas: u64,

    #[command(subcommand)]
    command: Command,
}

#[derive(Debug, Subcommand)]
enum Command {
    /// Check the manifest, core wiring, adapters, routers, tokens, and pools.
    Validate,
    /// Print the current Base gas snapshot and price feeds.
    Gas,
    /// List the enumerated cycles for an asset.
    Routes {
        #[arg(long, default_value = "USDC")]
        asset: String,
    },
    /// Quote one explicit route.
    Quote {
        #[arg(long, default_value = "USDC")]
        asset: String,
        #[arg(long)]
        amount: String,
        #[arg(long)]
        route: String,
    },
    /// Simulate one explicit route through RyoCore.
    Simulate {
        #[arg(long, default_value = "USDC")]
        asset: String,
        #[arg(long)]
        amount: String,
        #[arg(long)]
        route: String,
    },
    /// Simulate one route and build the execution calldata.
    Plan {
        #[arg(long, default_value = "USDC")]
        asset: String,
        #[arg(long)]
        amount: String,
        #[arg(long)]
        route: String,
    },
    /// Scan once (or a subset of pools).
    Scan {
        #[arg(long, value_delimiter = ',')]
        pools: Vec<usize>,
        #[arg(long)]
        pending: bool,
        #[arg(long)]
        json: bool,
    },
    /// Subscribe to Base events and scan on each trigger.
    Watch {
        #[arg(long)]
        max_events: Option<usize>,
        #[arg(long)]
        json: bool,
        /// Print a report even when the trigger produced no opportunity.
        #[arg(long)]
        show_empty: bool,
        /// Only verify the WebSocket trigger stream; do not quote or simulate.
        #[arg(long)]
        no_scan: bool,
        /// Log an accumulated metrics line every N events (0 disables).
        #[arg(long, env = "RYO_METRICS_EVERY", default_value_t = 0)]
        metrics_every: usize,
    },
    /// Download historical swap logs for the registry pools as JSONL.
    History {
        /// Window length in blocks, ending at `to_block` (or the latest block).
        #[arg(long, default_value_t = 43_200)]
        blocks: u64,
        /// First block to include. Overrides `--blocks` when set.
        #[arg(long)]
        from_block: Option<u64>,
        /// Last block to include. Defaults to the latest block.
        #[arg(long)]
        to_block: Option<u64>,
        /// Output JSONL path.
        #[arg(long, default_value = "data/swaps.jsonl")]
        out: PathBuf,
        /// Blocks per request; failed ranges are split automatically.
        #[arg(long, default_value_t = 500)]
        chunk: u64,
    },
    /// Decode revert data from a selector and payload.
    Decode {
        /// Hex data, with or without the 0x prefix.
        data: String,
    },
}

#[tokio::main]
async fn main() {
    dotenvy::dotenv().ok();
    tracing_subscriber::fmt()
        .with_env_filter(
            tracing_subscriber::EnvFilter::try_from_default_env()
                .unwrap_or_else(|_| tracing_subscriber::EnvFilter::new("info")),
        )
        .with_target(false)
        .init();

    if let Err(err) = run().await {
        error!("{err:#}");
        std::process::exit(1);
    }
}

async fn run() -> Result<()> {
    let cli = Cli::parse();
    let settings = settings_from_cli(&cli);
    settings.validate()?;

    match cli.command {
        Command::Validate => validate(&settings).await,
        Command::Gas => print_gas(&settings).await,
        Command::Routes { asset } => list_routes(&settings, &asset),
        Command::Quote {
            asset,
            amount,
            route,
        } => quote_command(&settings, &asset, &amount, &route).await,
        Command::Simulate {
            asset,
            amount,
            route,
        } => simulate_command(&settings, &asset, &amount, &route).await,
        Command::Plan {
            asset,
            amount,
            route,
        } => plan_command(&settings, &asset, &amount, &route).await,
        Command::Scan {
            pools,
            pending,
            json,
        } => scan_command(&settings, &pools, pending, json).await,
        Command::Watch {
            max_events,
            json,
            show_empty,
            no_scan,
            metrics_every,
        } => {
            watch_command(
                &settings,
                cli.source,
                max_events,
                json,
                show_empty,
                no_scan,
                metrics_every,
            )
            .await
        }
        Command::Decode { data } => decode_command(&data),
        Command::History {
            blocks,
            from_block,
            to_block,
            out,
            chunk,
        } => history_command(&settings, blocks, from_block, to_block, &out, chunk).await,
    }
}

fn settings_from_cli(cli: &Cli) -> Settings {
    Settings {
        http_rpc: cli.http_rpc.clone(),
        ws_rpc: cli.ws_rpc.clone(),
        manifest_path: cli.manifest.clone(),
        mode: cli.mode,
        event_source: cli.source,
        min_net_profit_usd: cli.min_net_profit_usd,
        max_gas_price_gwei: cli.max_gas_price_gwei,
        per_leg_slippage_bps: cli.per_leg_slippage_bps,
        min_profit_buffer_bps: cli.min_profit_buffer_bps,
        amount_grid_points: cli.amount_grid_points,
        max_candidates: cli.max_candidates,
        max_simulations: cli.max_simulations,
        max_hops: cli.max_hops,
        assets: cli.assets.clone(),
        fallback_gas: cli.fallback_gas,
        probe_amounts_usd: cli.probe_usd.clone(),
    }
}

fn load_manifest(settings: &Settings) -> Result<Manifest> {
    Manifest::load(&settings.manifest_path)
}

async fn validate(settings: &Settings) -> Result<()> {
    let manifest = load_manifest(settings)?;
    let provider = chain::connect_http(&settings.http_rpc).await?;
    let chain_id = chain::chain_id(&provider).await?;
    if chain_id != 8453 {
        bail!("RPC chain id is {chain_id}, expected 8453 (Base mainnet)");
    }

    println!("manifest: {}", settings.manifest_path.display());
    println!("core:     {}", manifest.core);

    require_code(&provider, manifest.core, "core").await?;
    require_code(&provider, manifest.vault, "Balancer vault").await?;

    let version = read_u8(&provider, manifest.core, ryo::VERSIONCall {}.abi_encode()).await?;
    let max_steps = read_u256(&provider, manifest.core, ryo::MAX_STEPSCall {}.abi_encode()).await?;
    let paused = read_bool(&provider, manifest.core, ryo::pausedCall {}.abi_encode()).await?;
    let max_gas_price = read_u256(
        &provider,
        manifest.core,
        ryo::maxGasPriceCall {}.abi_encode(),
    )
    .await?;
    let owner = read_address(&provider, manifest.core, ryo::ownerCall {}.abi_encode()).await?;
    let operator =
        read_address(&provider, manifest.core, ryo::operatorCall {}.abi_encode()).await?;
    let recipient = read_address(
        &provider,
        manifest.core,
        ryo::profitRecipientCall {}.abi_encode(),
    )
    .await?;

    println!("version:  {version}");
    println!("maxSteps: {max_steps}");
    println!("paused:   {paused}");
    println!("owner:    {owner}");
    println!("operator: {operator}");
    println!("recipient:{recipient}");
    println!("maxGas:   {max_gas_price} wei");

    if version != 1 {
        bail!("core VERSION is {version}, expected 1");
    }
    if max_steps < U256::from(settings.max_hops) {
        bail!(
            "core MAX_STEPS is {max_steps}, watcher wants {}",
            settings.max_hops
        );
    }
    if paused {
        warn!("core is paused; watcher will not trade until it is unpaused");
    }
    if owner != manifest.owner {
        warn!(manifest = %manifest.owner, chain = %owner, "manifest owner differs from chain owner");
    }
    if operator != manifest.operator {
        warn!(manifest = %manifest.operator, chain = %operator, "manifest operator differs from chain operator");
    }
    if recipient != manifest.profit_recipient {
        warn!(manifest = %manifest.profit_recipient, chain = %recipient, "manifest profitRecipient differs from chain");
    }

    for (name, adapter) in &manifest.adapters {
        require_code(&provider, *adapter, &format!("adapter {name}")).await?;
        let allowed = read_bool(
            &provider,
            manifest.core,
            ryo::isAdapterCall { adapter: *adapter }.abi_encode(),
        )
        .await?;
        if !allowed {
            bail!("adapter {name} at {adapter} is not whitelisted on the core");
        }
        println!("adapter {name:12} {adapter} whitelisted");
    }

    for (name, router) in &manifest.routers {
        require_code(&provider, *router, &format!("router {name}")).await?;
        println!("router  {name:12} {router}");
    }

    for (symbol, token) in &manifest.tokens {
        require_code(&provider, *token, &format!("token {symbol}")).await?;
        let decimals = read_u8(&provider, *token, erc20::decimalsCall {}.abi_encode()).await?;
        println!("token   {symbol:12} {token} decimals={decimals}");
        if decimals == 0 {
            bail!("token {symbol} reports zero decimals");
        }
        let cap = manifest.cap(symbol).unwrap_or(U256::ZERO);
        if cap.is_zero() {
            warn!("manifest cap for {symbol} is zero; the core will reject trades");
        }
    }

    for symbol in ["USDC", "WETH"] {
        let token = manifest.token(symbol).unwrap_or(match symbol {
            "USDC" => base::USDC,
            _ => base::WETH,
        });
        require_code(&provider, token, symbol).await?;
    }
    for (name, address) in [
        ("univ3 quoter", base::UNIV3_QUOTER),
        ("slipstream quoter", base::SLIPSTREAM_QUOTER),
        ("multicall3", base::MULTICALL3),
        ("gas price oracle", base::GAS_PRICE_ORACLE),
    ] {
        require_code(&provider, address, name).await?;
    }

    let registry = Registry::base_usdc_weth()?;
    for pool in &registry.pools {
        require_code(
            &provider,
            pool.address,
            &format!("pool {}", pool.venue.label()),
        )
        .await?;
        let token0 =
            read_address(&provider, pool.address, pool::token0Call {}.abi_encode()).await?;
        let token1 =
            read_address(&provider, pool.address, pool::token1Call {}.abi_encode()).await?;
        let matches = (token0 == pool.token0 && token1 == pool.token1)
            || (token0 == pool.token1 && token1 == pool.token0);
        if !matches {
            bail!(
                "pool {} token order mismatch: chain=({token0},{token1}) registry=({},{})",
                pool.address,
                pool.token0,
                pool.token1
            );
        }
    }
    println!("pools:    {} verified", registry.pools.len());
    println!("OK");
    Ok(())
}

async fn require_code(provider: &ChainProvider, address: Address, label: &str) -> Result<()> {
    let code = chain::code_at(provider, address).await?;
    if code.is_empty() {
        bail!("{label} at {address} has no bytecode");
    }
    Ok(())
}

async fn read_u256(provider: &ChainProvider, to: Address, data: Vec<u8>) -> Result<U256> {
    chain::eth_call_u256(provider, to, data.into(), BlockId::latest()).await
}

async fn read_u8(provider: &ChainProvider, to: Address, data: Vec<u8>) -> Result<u8> {
    chain::eth_call_u8(provider, to, data.into(), BlockId::latest()).await
}

async fn read_bool(provider: &ChainProvider, to: Address, data: Vec<u8>) -> Result<bool> {
    chain::eth_call_bool(provider, to, data.into(), BlockId::latest()).await
}

async fn read_address(provider: &ChainProvider, to: Address, data: Vec<u8>) -> Result<Address> {
    let value = read_u256(provider, to, data).await?;
    Ok(Address::from_slice(&value.to_be_bytes::<32>()[12..]))
}

async fn print_gas(settings: &Settings) -> Result<()> {
    let provider = chain::connect_http(&settings.http_rpc).await?;
    let snapshot = gas::snapshot(&provider, 2_000).await?;
    let eth_usd = gas::eth_usd_price(&provider, snapshot.timestamp).await?;
    println!("block:          {}", snapshot.block_number);
    println!("base fee:       {} wei", snapshot.base_fee);
    println!("priority fee:   {} wei", snapshot.priority_fee);
    println!("gas price:      {} wei", snapshot.gas_price);
    println!("L1 base fee:    {} wei", snapshot.l1_base_fee);
    println!("blob base fee:  {} wei", snapshot.blob_base_fee);
    println!("L1 upper bound: {} wei", snapshot.l1_fee_upper_bound);
    println!("ETH/USD:        ${eth_usd:.2}");
    for (symbol, asset) in [("USDC", base::USDC), ("WETH", base::WETH)] {
        match gas::asset_usd_price(&provider, asset, snapshot.timestamp).await {
            Ok(price) => println!("{symbol}/USD:        ${price:.6}"),
            Err(err) => println!("{symbol}/USD:        unavailable ({err})"),
        }
    }
    let cost = gas::trade_cost(
        450_000,
        snapshot.gas_price,
        snapshot.l1_fee_upper_bound,
        eth_usd,
    );
    println!("450k gas cost:  ${:.6}", cost.total_fee_usd);
    Ok(())
}

fn list_routes(settings: &Settings, asset_symbol: &str) -> Result<()> {
    let registry = Registry::base_usdc_weth()?;
    let asset = match asset_symbol {
        "USDC" => base::USDC,
        "WETH" => base::WETH,
        other => bail!("unknown asset {other}; use USDC or WETH"),
    };
    let routes = enumerate_cycles(&registry, asset, settings.max_hops);
    println!("{} routes for {asset_symbol}", routes.len());
    for (index, route) in routes.iter().enumerate() {
        let pools: Vec<String> = route
            .pool_indices()
            .iter()
            .map(|pool_index| registry.pool(*pool_index).address.to_string())
            .collect();
        println!(
            "{index:3} {}  [{}]",
            route.venues().join(" > "),
            pools.join(", ")
        );
    }
    Ok(())
}

async fn quote_command(
    settings: &Settings,
    asset_symbol: &str,
    amount: &str,
    route_spec: &str,
) -> Result<()> {
    let manifest = load_manifest(settings)?;
    let registry = Registry::base_usdc_weth()?;
    let asset = resolve_asset(&manifest, &registry, asset_symbol)?;
    let decimals = registry
        .token(asset)
        .map(|token| token.decimals)
        .unwrap_or(18);
    let amount = parse_amount(amount, decimals)?;
    let route = parse_route(&registry, asset, route_spec)?;
    let provider = chain::connect_http(&settings.http_rpc).await?;
    let quotes =
        venues::quote_route(&provider, &manifest, &route, amount, BlockId::latest()).await?;
    println!("route: {}", route.venues().join(" > "));
    println!(
        "input: {} {}",
        format_amount(amount, decimals),
        asset_symbol
    );
    for (index, (step, output)) in route.steps.iter().zip(quotes.iter().skip(1)).enumerate() {
        let out_symbol = registry.symbol(step.token_out);
        println!(
            "leg {}: {} -> {}  {} {}",
            index + 1,
            step.venue.label(),
            out_symbol,
            format_amount(
                *output,
                registry
                    .token(step.token_out)
                    .map(|t| t.decimals)
                    .unwrap_or(18)
            ),
            out_symbol
        );
    }
    let output = *quotes.last().context("no output")?;
    println!(
        "output: {} {}",
        format_amount(output, decimals),
        asset_symbol
    );
    println!("ratio:  {:.8}", raw_to_f64(output) / raw_to_f64(amount));
    Ok(())
}

async fn simulate_command(
    settings: &Settings,
    asset_symbol: &str,
    amount: &str,
    route_spec: &str,
) -> Result<()> {
    let manifest = load_manifest(settings)?;
    let registry = Registry::base_usdc_weth()?;
    let asset = resolve_asset(&manifest, &registry, asset_symbol)?;
    let decimals = registry
        .token(asset)
        .map(|token| token.decimals)
        .unwrap_or(18);
    let amount = parse_amount(amount, decimals)?;
    let route = parse_route(&registry, asset, route_spec)?;
    let provider = chain::connect_http(&settings.http_rpc).await?;
    let steps = simulate::discovery_steps(&route, &manifest)?;
    let now_secs = gas::latest_timestamp(&provider).await?;
    println!("core:  {}", manifest.core);
    println!("route: {}", route.venues().join(" > "));
    match simulate::simulate(
        &provider,
        manifest.core,
        asset,
        amount,
        steps,
        BlockId::latest(),
    )
    .await
    {
        Ok(simulation) => {
            if simulation.profit <= alloy::primitives::I256::ZERO {
                println!(
                    "profit: {} {} (loss before gas)",
                    simulation.profit, asset_symbol
                );
            } else {
                let profit_raw: U256 = simulation.profit.try_into().unwrap_or(U256::ZERO);
                let price = gas::asset_usd_price(&provider, asset, now_secs)
                    .await
                    .unwrap_or(0.0);
                let profit_usd = gas::profit_usd(profit_raw, decimals, price);
                println!(
                    "profit: {} {} (~${:.4})",
                    format_amount(profit_raw, decimals),
                    asset_symbol,
                    profit_usd
                );
            }
        }
        Err(simulate::SimulateError::Revert { decoded, raw }) => {
            println!("reverted: {decoded}");
            println!("raw:      {raw}");
            return Ok(());
        }
        Err(err) => return Err(anyhow::anyhow!(err)),
    }
    Ok(())
}

async fn plan_command(
    settings: &Settings,
    asset_symbol: &str,
    amount: &str,
    route_spec: &str,
) -> Result<()> {
    let manifest = load_manifest(settings)?;
    let registry = Registry::base_usdc_weth()?;
    let asset = resolve_asset(&manifest, &registry, asset_symbol)?;
    let decimals = registry
        .token(asset)
        .map(|token| token.decimals)
        .unwrap_or(18);
    let amount = parse_amount(amount, decimals)?;
    let route = parse_route(&registry, asset, route_spec)?;
    let provider = chain::connect_http(&settings.http_rpc).await?;
    let scanner = Scanner::new(provider, manifest, settings.clone())?;
    match scanner.plan(&route, amount).await? {
        Some(opportunity) => print_opportunity(&opportunity),
        None => println!("route is not profitable after gas"),
    }
    Ok(())
}

async fn scan_command(
    settings: &Settings,
    pools: &[usize],
    pending: bool,
    json: bool,
) -> Result<()> {
    let manifest = load_manifest(settings)?;
    let provider = chain::connect_http(&settings.http_rpc).await?;
    let scanner = Scanner::new(provider, manifest, settings.clone())?;
    let block = if pending {
        ScanBlock::Pending
    } else {
        ScanBlock::Latest
    };
    if !pools.is_empty() {
        for index in pools {
            if *index >= scanner.registry().pools.len() {
                bail!(
                    "pool index {index} is out of range (0..{})",
                    scanner.registry().pools.len()
                );
            }
        }
    }
    let report = if pools.is_empty() {
        scanner.scan_once_with(block).await?
    } else {
        scanner.evaluate(Some(pools.to_vec()), block).await?
    };
    if json {
        println!("{}", serde_json::to_string_pretty(&report_json(&report))?);
    } else {
        print_report(&report);
    }
    Ok(())
}

#[derive(Default)]
struct WatchMetrics {
    events: usize,
    scans: usize,
    failed_scans: usize,
    routes: usize,
    quotes: usize,
    simulations: usize,
    opportunities: usize,
    scan_millis: u128,
}

impl WatchMetrics {
    fn record(&mut self, report: &ScanReport, millis: u128) {
        self.scans += 1;
        self.scan_millis += millis;
        self.routes += report.routes_considered;
        self.quotes += report.quotes;
        self.simulations += report.simulations;
        self.opportunities += report.opportunities.len();
    }

    fn summary(&self) -> String {
        let avg = if self.scans == 0 {
            0
        } else {
            self.scan_millis / self.scans as u128
        };
        format!(
            "events={} scans={} failed={} routes={} quotes={} simulations={} opportunities={} avg_scan_ms={avg}",
            self.events,
            self.scans,
            self.failed_scans,
            self.routes,
            self.quotes,
            self.simulations,
            self.opportunities
        )
    }
}

#[allow(clippy::too_many_arguments)]
async fn watch_command(
    settings: &Settings,
    source: EventSource,
    max_events: Option<usize>,
    json: bool,
    show_empty: bool,
    no_scan: bool,
    metrics_every: usize,
) -> Result<()> {
    if source == EventSource::Once {
        bail!("watch requires an event source other than `once`");
    }
    let ws = settings
        .ws_rpc
        .as_ref()
        .context("watch requires RYO_WS_RPC (wss://...Alchemy...)")?;
    let manifest = load_manifest(settings)?;
    let provider = chain::connect_http(&settings.http_rpc).await?;
    let scanner = Scanner::new(provider, manifest, settings.clone())?;
    let pools = scanner.registry().all_pool_addresses();
    let mut stream = EventStream::new(ws, source, &pools);

    if settings.mode == Mode::Live {
        warn!(
            "live mode requested, but transaction sending is not enabled in this build; opportunities will be logged only"
        );
    }
    info!(
        url = %redact_url(ws),
        source = ?source,
        pools = pools.len(),
        no_scan,
        "watching"
    );

    let mut events = 0usize;
    let mut metrics = WatchMetrics::default();
    loop {
        let trigger = tokio::select! {
            _ = tokio::signal::ctrl_c() => {
                info!(metrics = %metrics.summary(), "shutting down");
                return Ok(());
            }
            trigger = stream.next() => trigger?,
        };
        events += 1;
        metrics.events = events;
        info!(event = %trigger.label(), "trigger");
        if no_scan {
            if let Some(max) = max_events
                && events >= max
            {
                info!(events, metrics = %metrics.summary(), "max events reached");
                return Ok(());
            }
            continue;
        }
        let started = std::time::Instant::now();
        let report = match scanner.scan_trigger(&trigger).await {
            Ok(report) => report,
            Err(err) => {
                metrics.failed_scans += 1;
                warn!(error = %err, "scan failed");
                continue;
            }
        };
        let millis = started.elapsed().as_millis();
        metrics.record(&report, millis);
        if json {
            println!("{}", serde_json::to_string(&report_json(&report))?);
        } else if show_empty || !report.opportunities.is_empty() {
            print_report(&report);
        } else {
            debug!(
                block = report.block,
                routes = report.routes_considered,
                quotes = report.quotes,
                simulations = report.simulations,
                millis,
                "scan complete (no opportunity)"
            );
        }
        if metrics_every > 0 && events.is_multiple_of(metrics_every) {
            info!(metrics = %metrics.summary(), "watch metrics");
        }
        if let Some(max) = max_events
            && events >= max
        {
            info!(events, metrics = %metrics.summary(), "max events reached");
            return Ok(());
        }
    }
}

async fn history_command(
    settings: &Settings,
    blocks: u64,
    from_block: Option<u64>,
    to_block: Option<u64>,
    out: &Path,
    chunk: u64,
) -> Result<()> {
    let provider = chain::connect_http(&settings.http_rpc).await?;
    let registry = Registry::base_usdc_weth()?;
    let to_block = match to_block {
        Some(block) => block,
        None => chain::block_number(&provider).await?,
    };
    let from_block = match from_block {
        Some(block) => block,
        None => to_block.saturating_sub(blocks.saturating_sub(1)),
    };
    info!(
        from_block,
        to_block,
        chunk,
        out = %out.display(),
        "downloading swap history"
    );
    let summary = history::download(&provider, &registry, from_block, to_block, chunk, out).await?;
    println!(
        "blocks {}-{} | swaps {} | {} bytes | out {}",
        summary.from_block,
        summary.to_block,
        summary.total,
        summary.bytes,
        out.display()
    );
    for (venue, count) in &summary.per_venue {
        println!("  {venue:20} {count}");
    }
    Ok(())
}

fn decode_command(data: &str) -> Result<()> {
    let hex = data.trim().trim_start_matches("0x");
    let bytes = alloy::hex::decode(hex).context("data is not valid hex")?;
    match errors::decode(&bytes) {
        DecodedError::Unknown { selector, data } => {
            println!("unknown selector 0x{}", alloy::hex::encode(selector));
            println!("payload: {data}");
        }
        other => println!("{other}"),
    }
    Ok(())
}

fn print_report(report: &ScanReport) {
    println!(
        "block {} | routes {} | quotes {} | simulations {} | opportunities {}",
        report.block,
        report.routes_considered,
        report.quotes,
        report.simulations,
        report.opportunities.len()
    );
    for note in &report.notes {
        println!("  note: {note}");
    }
    for opportunity in &report.opportunities {
        println!(
            "  net ${:.4} | profit ${:.4} | gas ${:.4} | {} {} | {}",
            opportunity.net_usd,
            opportunity.profit_usd,
            opportunity.cost.total_fee_usd,
            format_amount(
                opportunity.amount,
                token_decimals(&opportunity.asset_symbol)
            ),
            opportunity.asset_symbol,
            opportunity.venues().join(" > ")
        );
        println!(
            "    amount={} profit_raw={} floors={:?} gas={} gasPrice={} block={} preconfirmed={}",
            opportunity.amount,
            opportunity.simulated_profit,
            opportunity.floors,
            opportunity.gas_used,
            opportunity.gas_price,
            opportunity.block,
            opportunity.preconfirmed
        );
        println!("    calldata={}", opportunity.calldata);
    }
}

fn print_opportunity(opportunity: &Opportunity) {
    println!(
        "asset:      {} ({})",
        opportunity.asset_symbol, opportunity.asset
    );
    println!("amount:     {} raw", opportunity.amount);
    println!("route:      {}", opportunity.venues().join(" > "));
    println!("quotes:     {:?}", opportunity.quotes);
    println!("profit:     {} raw", opportunity.simulated_profit);
    println!("profit USD: ${:.4}", opportunity.profit_usd);
    println!("gas used:   {}", opportunity.gas_used);
    println!("gas price:  {} wei", opportunity.gas_price);
    println!("gas cost:   ${:.6}", opportunity.cost.total_fee_usd);
    println!("net USD:    ${:.4}", opportunity.net_usd);
    println!("floors:     {:?}", opportunity.floors);
    println!("minProfit:  {}", opportunity.min_profit);
    println!("routeHash:  {}", opportunity.route_hash);
    println!("calldata:   {}", opportunity.calldata);
}

fn report_json(report: &ScanReport) -> serde_json::Value {
    serde_json::json!({
        "block": report.block,
        "affectedPools": report.affected_pools.iter().map(ToString::to_string).collect::<Vec<_>>(),
        "routesConsidered": report.routes_considered,
        "quotes": report.quotes,
        "simulations": report.simulations,
        "notes": report.notes,
        "opportunities": report.opportunities.iter().map(opportunity_json).collect::<Vec<_>>(),
    })
}

fn opportunity_json(opportunity: &Opportunity) -> serde_json::Value {
    serde_json::json!({
        "asset": opportunity.asset.to_string(),
        "assetSymbol": opportunity.asset_symbol,
        "amount": opportunity.amount.to_string(),
        "venues": opportunity.venues(),
        "quotes": opportunity.quotes.iter().map(ToString::to_string).collect::<Vec<_>>(),
        "simulatedProfit": opportunity.simulated_profit.to_string(),
        "profitUsd": opportunity.profit_usd,
        "netUsd": opportunity.net_usd,
        "gasUsed": opportunity.gas_used,
        "gasPrice": opportunity.gas_price.to_string(),
        "gasCostUsd": opportunity.cost.total_fee_usd,
        "floors": opportunity.floors.iter().map(ToString::to_string).collect::<Vec<_>>(),
        "minProfit": opportunity.min_profit.to_string(),
        "routeHash": opportunity.route_hash.to_string(),
        "calldata": opportunity.calldata.to_string(),
        "block": opportunity.block,
        "preconfirmed": opportunity.preconfirmed,
    })
}

fn resolve_asset(manifest: &Manifest, registry: &Registry, symbol: &str) -> Result<Address> {
    manifest
        .token(symbol)
        .or(match symbol {
            "USDC" => Some(base::USDC),
            "WETH" => Some(base::WETH),
            _ => None,
        })
        .with_context(|| format!("unknown asset {symbol}"))
        .inspect(|&address| {
            if registry.token(address).is_none() {
                warn!(%address, "asset is not in the quoting registry");
            }
        })
}

fn parse_amount(value: &str, decimals: u8) -> Result<U256> {
    let parsed = alloy::primitives::utils::parse_units(value, decimals)
        .map_err(|e| anyhow::anyhow!("invalid amount {value}: {e}"))?;
    Ok(parsed.into())
}

fn format_amount(value: U256, decimals: u8) -> String {
    alloy::primitives::utils::format_units(value, decimals).unwrap_or_else(|_| value.to_string())
}

fn token_decimals(symbol: &str) -> u8 {
    match symbol {
        "USDC" | "EURC" => 6,
        _ => 18,
    }
}

fn raw_to_f64(value: U256) -> f64 {
    value.to_string().parse().unwrap_or(0.0)
}

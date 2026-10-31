use std::collections::HashMap;
use std::path::{Path, PathBuf};

use alloy::primitives::{Address, U256};
use anyhow::{Context, Result, bail};
use serde::{Deserialize, Serialize};

/// Machine-readable deployment manifest written by `Deploy.s.sol`.
///
/// All `uint256` values are stored as decimal strings so JSON consumers do not
/// lose precision above 2^53.
#[derive(Debug, Clone, Deserialize, Serialize)]
#[serde(rename_all = "camelCase")]
pub struct Manifest {
    pub chain_id: u64,
    pub deployer: Address,
    pub block_number: String,
    pub timestamp: String,
    pub core: Address,
    pub vault: Address,
    pub owner: Address,
    pub operator: Address,
    pub profit_recipient: Address,
    pub adapters: HashMap<String, Address>,
    pub routers: HashMap<String, Address>,
    pub tokens: HashMap<String, Address>,
    pub caps: HashMap<String, String>,
    pub max_gas_price: String,
    pub version: u8,
}

impl Manifest {
    pub fn load(path: impl AsRef<Path>) -> Result<Self> {
        let path = path.as_ref();
        let text = std::fs::read_to_string(path)
            .with_context(|| format!("failed to read manifest {}", path.display()))?;
        let manifest: Self = serde_json::from_str(&text)
            .with_context(|| format!("failed to parse manifest {}", path.display()))?;
        manifest.validate()?;
        Ok(manifest)
    }

    pub fn validate(&self) -> Result<()> {
        if self.chain_id != 8453 {
            bail!(
                "manifest chainId is {}, expected 8453 (Base mainnet)",
                self.chain_id
            );
        }
        if self.version != 1 {
            bail!("manifest version is {}, expected 1", self.version);
        }
        if self.core == Address::ZERO {
            bail!("manifest core is the zero address");
        }
        if self.vault == Address::ZERO {
            bail!("manifest vault is the zero address");
        }
        if self.owner == Address::ZERO {
            bail!("manifest owner is the zero address");
        }
        if self.operator == Address::ZERO {
            bail!("manifest operator is the zero address");
        }
        if self.profit_recipient == Address::ZERO {
            bail!("manifest profitRecipient is the zero address");
        }
        for (name, address) in &self.adapters {
            if *address == Address::ZERO {
                bail!("manifest adapter {name} is the zero address");
            }
        }
        for (name, address) in &self.routers {
            if *address == Address::ZERO {
                bail!("manifest router {name} is the zero address");
            }
        }
        if self.tokens.is_empty() {
            bail!("manifest has no tokens");
        }
        for (symbol, address) in &self.tokens {
            if *address == Address::ZERO {
                bail!("manifest token {symbol} is the zero address");
            }
        }
        for (symbol, cap) in &self.caps {
            cap.parse::<U256>()
                .with_context(|| format!("manifest cap for {symbol} is not a uint256: {cap}"))?;
        }
        self.max_gas_price
            .parse::<U256>()
            .context("manifest maxGasPrice is not a uint256")?;
        Ok(())
    }

    pub fn token(&self, symbol: &str) -> Option<Address> {
        self.tokens.get(symbol).copied()
    }

    pub fn token_symbol(&self, address: Address) -> Option<&str> {
        self.tokens
            .iter()
            .find_map(|(symbol, &addr)| (addr == address).then_some(symbol.as_str()))
    }

    pub fn cap(&self, symbol: &str) -> Option<U256> {
        self.caps.get(symbol).and_then(|v| v.parse().ok())
    }

    pub fn adapter(&self, name: &str) -> Option<Address> {
        self.adapters.get(name).copied()
    }

    pub fn router(&self, name: &str) -> Option<Address> {
        self.routers.get(name).copied()
    }
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, clap::ValueEnum)]
pub enum Mode {
    /// Find and log opportunities; never build or send a transaction.
    DryRun,
    /// Build and log the transaction, but do not send it.
    Paper,
    /// Build and send transactions.
    Live,
}

impl std::str::FromStr for Mode {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        match s.to_ascii_lowercase().as_str() {
            "dry-run" | "dryrun" | "dry_run" => Ok(Self::DryRun),
            "paper" => Ok(Self::Paper),
            "live" => Ok(Self::Live),
            other => Err(format!("unknown mode {other}; use dry-run, paper, or live")),
        }
    }
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, clap::ValueEnum)]
pub enum EventSource {
    /// Standard mined logs.
    Logs,
    /// Flashblocks preconfirmed logs.
    PendingLogs,
    /// Flashblocks preconfirmed transactions.
    Flashblocks,
    /// Both mined logs and preconfirmed logs.
    Both,
    /// No WebSocket; scan once at the current block.
    Once,
}

impl std::str::FromStr for EventSource {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        match s.to_ascii_lowercase().as_str() {
            "logs" => Ok(Self::Logs),
            "pending-logs" | "pendinglogs" | "pending" => Ok(Self::PendingLogs),
            "flashblocks" | "flashblock" => Ok(Self::Flashblocks),
            "both" => Ok(Self::Both),
            "once" => Ok(Self::Once),
            other => Err(format!(
                "unknown event source {other}; use logs, pending-logs, flashblocks, both, or once"
            )),
        }
    }
}

#[derive(Debug, Clone)]
pub struct Settings {
    pub http_rpc: String,
    pub ws_rpc: Option<String>,
    pub manifest_path: PathBuf,
    pub mode: Mode,
    pub event_source: EventSource,
    pub min_net_profit_usd: f64,
    pub max_gas_price_gwei: f64,
    pub per_leg_slippage_bps: u32,
    pub min_profit_buffer_bps: u32,
    pub amount_grid_points: usize,
    pub max_candidates: usize,
    /// Maximum number of finalists simulated per asset per trigger.
    pub max_simulations: usize,
    pub max_hops: usize,
    /// Asset symbols to arbitrage, in the order they should be scanned.
    pub assets: Vec<String>,
    /// Fallback gas estimate for a two-leg route when eth_estimateGas fails.
    pub fallback_gas: u64,
    /// USD amounts used to probe route profitability before grid refinement.
    pub probe_amounts_usd: Vec<f64>,
    /// Swaps smaller than this USD notional are ignored before quoting. Stored
    /// as configured; the scanner always enforces a hard floor on top.
    pub min_swap_usd: f64,
}

impl Default for Settings {
    fn default() -> Self {
        Self {
            http_rpc: "https://mainnet.base.org".to_string(),
            ws_rpc: None,
            manifest_path: PathBuf::from("deployments/8453.json"),
            mode: Mode::DryRun,
            event_source: EventSource::Once,
            min_net_profit_usd: 0.25,
            max_gas_price_gwei: 0.05,
            per_leg_slippage_bps: 20,
            min_profit_buffer_bps: 50,
            amount_grid_points: 5,
            max_candidates: 16,
            max_simulations: 8,
            max_hops: 2,
            assets: vec!["USDC".to_string(), "WETH".to_string()],
            fallback_gas: 450_000,
            probe_amounts_usd: vec![500.0, 2_000.0, 8_000.0],
            min_swap_usd: 500.0,
        }
    }
}

impl Settings {
    pub fn validate(&self) -> Result<()> {
        if self.http_rpc.trim().is_empty() {
            bail!("HTTP RPC URL is empty");
        }
        if !self.http_rpc.starts_with("http://") && !self.http_rpc.starts_with("https://") {
            bail!("HTTP RPC URL must start with http:// or https://");
        }
        if let Some(ws) = &self.ws_rpc {
            // Alchemy hands out one endpoint per scheme; an https form of the
            // WebSocket URL is accepted and upgraded wherever it is used.
            let ok = ["ws://", "wss://", "http://", "https://"]
                .iter()
                .any(|scheme| ws.starts_with(scheme));
            if !ok {
                bail!("WebSocket RPC URL must start with ws://, wss://, http://, or https://");
            }
        }
        if self.amount_grid_points < 2 {
            bail!("amount_grid_points must be at least 2");
        }
        if self.max_candidates == 0 {
            bail!("max_candidates must be at least 1");
        }
        if self.max_simulations == 0 {
            bail!("max_simulations must be at least 1");
        }
        if self.probe_amounts_usd.is_empty() {
            bail!("at least one probe amount is required");
        }
        if self
            .probe_amounts_usd
            .iter()
            .any(|usd| !usd.is_finite() || *usd <= 0.0)
        {
            bail!("probe amounts must be positive finite numbers");
        }
        if !self.min_net_profit_usd.is_finite() || self.min_net_profit_usd < 0.0 {
            bail!("min_net_profit_usd must be a non-negative number");
        }
        if !self.min_swap_usd.is_finite() || self.min_swap_usd < 0.0 {
            bail!("min_swap_usd must be a non-negative number");
        }
        if !self.max_gas_price_gwei.is_finite() || self.max_gas_price_gwei <= 0.0 {
            bail!("max_gas_price_gwei must be a positive number");
        }
        if self.max_hops < 2 || self.max_hops > 8 {
            bail!("max_hops must be between 2 and 8");
        }
        if self.per_leg_slippage_bps > 1_000 {
            bail!("per_leg_slippage_bps must be <= 1000");
        }
        Ok(())
    }
}

/// Known Base mainnet addresses that are not part of the deployment manifest.
pub mod base {
    use alloy::primitives::{Address, address};

    pub const BALANCER_VAULT: Address = address!("BA12222222228d8Ba445958a75a0704d566BF2C8");
    pub const UNIV3_ROUTER: Address = address!("2626664c2603336E57B271c5C0b26F421741e481");
    pub const UNIV2_ROUTER: Address = address!("4752ba5DBc23f44D87826276BF6Fd6b1C372aD24");
    pub const AERODROME_ROUTER: Address = address!("cF77a3Ba9A5CA399B7c97c74d54e5b1Beb874E43");
    pub const SLIPSTREAM_ROUTER: Address = address!("BE6D8f0d05cC4be24d5167a3eF062215bE6D18a5");
    pub const MULTICALL3: Address = address!("cA11bde05977b3631167028862bE2a173976CA11");
    pub const GAS_PRICE_ORACLE: Address = address!("420000000000000000000000000000000000000F");
    pub const UNIV3_FACTORY: Address = address!("33128a8fC17869897dcE68Ed026d694621f6FDfD");
    pub const UNIV2_FACTORY: Address = address!("8909Dc15e40173Ff4699343b6eB8132c65e18eC6");
    pub const AERODROME_FACTORY: Address = address!("420DD381b31aEf6683db6B902084cB0FFECe40Da");
    pub const SLIPSTREAM_FACTORY: Address = address!("5e7BB104d84c7CB9B682AaC2F3d509f5F406809A");
    pub const UNIV3_QUOTER: Address = address!("3d4e44Eb1374240CE5F1B871ab261CD16335B76a");
    pub const SLIPSTREAM_QUOTER: Address = address!("254cF9E1E6e233aa1AC962CB9B05b2cfeAaE15b0");

    pub const WETH: Address = address!("4200000000000000000000000000000000000006");
    pub const USDC: Address = address!("833589fCD6eDb6E08f4c7C32D4f71b54bdA02913");
    pub const CBBTC: Address = address!("cbB7C0000aB88B473b1f5aFd9ef808440eed33Bf");
    pub const EURC: Address = address!("60a3E35Cc302bFA44Cb288Bc5a4F316Fdb1adb42");
    pub const AERO: Address = address!("940181a94A35A4569E4529A3CDfB74e38FD98631");

    pub const ETH_USD_FEED: Address = address!("71041dddad3595F9CEd3DcCFBe3D1F4b0a16Bb70");
    pub const USDC_USD_FEED: Address = address!("7e860098F58bBFC8648a4311b374B1D669a2bc6B");
    pub const BTC_USD_FEED: Address = address!("64c911996D3c6aC71f9b455B1E8E7266BcbD848F");
    pub const EUR_USD_FEED: Address = address!("c91D87E81faB8f93699ECf7Ee9B44D11e1D53F0F");
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn defaults_match_documented_cli_values() {
        let settings = Settings::default();
        assert_eq!(settings.min_profit_buffer_bps, 50);
        assert_eq!(settings.amount_grid_points, 5);
        assert_eq!(settings.per_leg_slippage_bps, 20);
        assert_eq!(settings.max_candidates, 16);
        assert_eq!(settings.max_simulations, 8);
        assert_eq!(settings.probe_amounts_usd, vec![500.0, 2_000.0, 8_000.0]);
        assert_eq!(settings.min_swap_usd, 500.0);
    }
}

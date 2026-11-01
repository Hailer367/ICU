//! Fork integration test for the failed-sim cache (feature 4).
//!
//! Two consecutive full scans must produce the same candidate set. The second
//! scan is only allowed to skip simulations whose outcome is provably unchanged
//! (bit-identical quotes, gas price and USD prices) — and must never hide a
//! winner the first scan found.
//!
//! A genuinely quiet fork cannot exercise this: with no apparently-profitable
//! route there is nothing to simulate, so there is also nothing to remember.
//! The test therefore manufactures an edge first — it skews the UniV3:500 pool
//! with a large swap, exactly like `fork_opportunity`, which produces several
//! losing finalists alongside the winner. Only the losses are cacheable.
//!
//! The fork is snapshotted before the skew and reverted afterwards, so it is
//! left exactly as it was found.
//!
//! Run with a local Anvil Base fork:
//!
//! ```text
//! anvil --fork-url https://mainnet.base.org --chain-id 8453 --port 8545
//! RYO_FORK_RPC=http://127.0.0.1:8545 \
//!   cargo test --test fork_simcache -- --ignored --nocapture
//! ```

use std::time::Duration;

use alloy::network::TransactionBuilder;
use alloy::primitives::aliases::U24;
use alloy::primitives::{Address, B256, Bytes, U160, U256, address};
use alloy::providers::Provider;
use alloy::rpc::types::TransactionRequest;
use alloy::sol_types::SolCall;
use anyhow::{Context, Result, bail};
use ryo_watch::chain::{self, ChainProvider};
use ryo_watch::config::{Manifest, Settings, base};
use ryo_watch::events::Trigger;
use ryo_watch::scanner::{Opportunity, ScanReport, Scanner};
use serde_json::Value;

/// Base Balancer V2 vault: holds a large real USDC balance, so Anvil can
/// impersonate it and fund a market-moving swap.
const BALANCER_VAULT: Address = address!("BA12222222228d8Ba445958a75a0704d566BF2C8");
/// SwapRouter02 on Base (the UniV3 router in the manifest).
const SWAP_ROUTER_02: Address = address!("2626664c2603336E57B271c5C0b26F421741e481");
const MAX_SKEW_USDC: u64 = 60_000;
const MIN_SKEW_USDC: u64 = 5_000;

alloy::sol! {
    function approve(address spender, uint256 amount) external returns (bool);

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

/// Move the UniV3:500 pool far enough that cross-venue routes look profitable
/// on paper, which is what creates the finalists the cache then reasons about.
async fn skew_univ3_500(provider: &ChainProvider) -> Result<()> {
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

    let balance = chain::erc20_balance(provider, base::USDC, BALANCER_VAULT, Default::default())
        .await
        .context("failed to read vault USDC balance")?;
    let unit = U256::from(1_000_000u64);
    let available = balance / unit;
    if available < U256::from(MIN_SKEW_USDC) {
        bail!(
            "vault only holds {} USDC; need at least {MIN_SKEW_USDC} to skew the pool",
            available
        );
    }
    let amount = U256::from(MAX_SKEW_USDC).min(available) * unit;

    send_and_wait(
        provider,
        BALANCER_VAULT,
        base::USDC,
        approveCall {
            spender: SWAP_ROUTER_02,
            amount,
        }
        .abi_encode()
        .into(),
        100_000,
    )
    .await?;

    send_and_wait(
        provider,
        BALANCER_VAULT,
        SWAP_ROUTER_02,
        exactInputSingleCall {
            params: ExactInputSingleParams {
                tokenIn: base::USDC,
                tokenOut: base::WETH,
                fee: U24::from_limbs([500]),
                recipient: BALANCER_VAULT,
                amountIn: amount,
                amountOutMinimum: U256::ZERO,
                sqrtPriceLimitX96: U160::ZERO,
            },
        }
        .abi_encode()
        .into(),
        500_000,
    )
    .await?;
    eprintln!("skewed univ3:500 with {amount} USDC");
    Ok(())
}

fn build_settings(rpc: &str, manifest: &str) -> Settings {
    Settings {
        http_rpc: rpc.to_string(),
        manifest_path: manifest.into(),
        max_gas_price_gwei: 5.0,
        min_net_profit_usd: 0.01,
        probe_amounts_usd: vec![500.0, 1_000.0, 2_000.0, 5_000.0],
        max_candidates: 12,
        max_simulations: 6,
        ..Settings::default()
    }
}

fn fingerprint(opportunity: &Opportunity) -> (String, U256, String) {
    (
        opportunity.asset_symbol.clone(),
        opportunity.amount,
        format!("{:?}", opportunity.venues()),
    )
}

fn log(label: &str, report: &ScanReport) {
    eprintln!(
        "{label}: block={} routes={} quotes={} simulations={} sims_cached={} opportunities={}",
        report.block,
        report.routes_considered,
        report.quotes,
        report.simulations,
        report.sims_cached,
        report.opportunities.len()
    );
    for note in &report.notes {
        eprintln!("  note: {note}");
    }
}

async fn run(provider: &ChainProvider) -> Result<()> {
    let manifest = Manifest::load(manifest_path())?;
    let settings = build_settings(&fork_rpc(), &manifest_path());
    settings.validate()?;
    let scanner = Scanner::new(provider.clone(), manifest, settings)?;

    skew_univ3_500(provider).await?;

    // `Reconnect` forces a full scan, exactly like the watch loop after a
    // dropped connection. Two of them back to back see an unchanged chain.
    let first = scanner
        .scan_triggers(&[Trigger::Reconnect])
        .await
        .context("first full scan failed")?;
    log("scan #1", &first);
    let second = scanner
        .scan_triggers(&[Trigger::Reconnect])
        .await
        .context("second full scan failed")?;
    log("scan #2", &second);

    assert!(
        first.simulations > 0,
        "first scan simulated nothing even after the skew (routes={}, quotes={}); \
         the fork produced no finalist, so the cache cannot be exercised",
        first.routes_considered,
        first.quotes
    );
    assert!(
        second.sims_cached > 0,
        "second full scan re-simulated everything (simulations={}, sims_cached={}); \
         the failed-sim cache never fired on an unchanged chain",
        second.simulations,
        second.sims_cached
    );
    assert!(
        second.simulations < first.simulations,
        "cached losses did not reduce the simulation count: {} vs {}",
        second.simulations,
        first.simulations
    );

    // The cache must never hide a winner: every opportunity from scan #1 has
    // to reappear in scan #2 on the unchanged chain.
    let second_keys: Vec<_> = second.opportunities.iter().map(fingerprint).collect();
    for opportunity in &first.opportunities {
        let key = fingerprint(opportunity);
        assert!(
            second_keys.contains(&key),
            "scan #2 lost an opportunity scan #1 found: {key:?}"
        );
    }
    Ok(())
}

#[tokio::test]
#[ignore = "needs a local Anvil Base fork; see the module docs"]
async fn full_rescan_skips_unchanged_failed_sims() {
    let provider = chain::connect_http(&fork_rpc())
        .await
        .expect("failed to connect to the fork RPC");
    let chain_id = chain::chain_id(&provider)
        .await
        .expect("eth_chainId failed");
    assert_eq!(chain_id, 8453, "expected a Base fork, got chain {chain_id}");

    let snapshot: Option<String> = raw(&provider, "evm_snapshot", serde_json::json!([]))
        .await
        .ok();
    let outcome = run(&provider).await;
    if let Some(snapshot) = snapshot {
        let reverted: bool = raw(&provider, "evm_revert", serde_json::json!([snapshot]))
            .await
            .unwrap_or(false);
        assert!(reverted, "evm_revert failed; the fork was left skewed");
    }
    if let Err(err) = outcome {
        panic!("failed-sim cache scenario failed: {err:#}");
    }
}

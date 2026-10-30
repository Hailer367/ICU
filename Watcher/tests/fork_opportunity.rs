//! Fork integration test: skew a real Base pool, then prove the scanner finds
//! the resulting arbitrage and (optionally) that the calldata actually pays.
//!
//! This test needs a local Anvil fork and is therefore ignored by default:
//!
//! ```text
//! anvil --fork-url https://mainnet.base.org --chain-id 8453 --port 8545 --block-time 1
//! RYO_FORK_RPC=http://127.0.0.1:8545 \
//!   cargo test --test fork_opportunity -- --ignored --nocapture
//! ```
//!
//! Set `RYO_FORK_EXECUTE=1` to also send the winning calldata from the
//! manifest operator and assert the profit recipient's balance grows.
//!
//! The test snapshots the chain first and reverts afterwards, so the fork is
//! left exactly as it was found even if the swap is large.

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
use ryo_watch::routes::Venue;
use ryo_watch::scanner::{ScanBlock, Scanner};
use serde_json::Value;

/// Base Balancer V2 vault. It holds a large USDC balance on the real chain and
/// is the same address the core later flash-borrows from.
const BALANCER_VAULT: Address = address!("BA12222222228d8Ba445958a75a0704d566BF2C8");
/// SwapRouter02 on Base (also the UniV3 router in the manifest).
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

/// Send a transaction from `from` (which Anvil must be able to sign for) and
/// wait for a successful receipt.
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
    // Instant inclusion keeps the test deterministic; the snapshot revert at
    // the end undoes the chain state, not this node setting.
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

    let approve = approveCall {
        spender: SWAP_ROUTER_02,
        amount,
    }
    .abi_encode();
    send_and_wait(
        provider,
        BALANCER_VAULT,
        base::USDC,
        approve.into(),
        100_000,
    )
    .await?;

    let swap = exactInputSingleCall {
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
    .abi_encode();
    send_and_wait(
        provider,
        BALANCER_VAULT,
        SWAP_ROUTER_02,
        swap.into(),
        500_000,
    )
    .await?;
    Ok(())
}

fn build_settings(rpc: &str, manifest_path: &str) -> Settings {
    Settings {
        http_rpc: rpc.to_string(),
        manifest_path: manifest_path.into(),
        // Anvil's gas price is fixed and high (1 gwei); allow it and keep the
        // profit gate low so the manufactured edge is not filtered by USD noise.
        max_gas_price_gwei: 5.0,
        min_net_profit_usd: 0.01,
        probe_amounts_usd: vec![500.0, 1_000.0, 2_000.0, 5_000.0],
        max_candidates: 12,
        max_simulations: 6,
        ..Settings::default()
    }
}

async fn run(provider: &ChainProvider, rpc: &str, manifest_path: &str) -> Result<()> {
    let manifest = Manifest::load(manifest_path)?;
    let settings = build_settings(rpc, manifest_path);
    settings.validate()?;

    let scanner = Scanner::new(provider.clone(), manifest.clone(), settings)?;
    let pool_500 = scanner
        .registry()
        .pools
        .iter()
        .position(|pool| pool.venue == Venue::UniV3 { fee: 500 })
        .context("registry has no univ3:500 pool")?;

    // Baseline: a quiet pool must not report an opportunity at these settings.
    // It is allowed to, if the fork was already skewed, but the skew below is
    // what this test is really about.
    let baseline = scanner
        .evaluate(Some(vec![pool_500]), ScanBlock::Latest)
        .await?;
    eprintln!(
        "baseline: routes={} quotes={} simulations={} opportunities={}",
        baseline.routes_considered,
        baseline.quotes,
        baseline.simulations,
        baseline.opportunities.len()
    );

    skew_univ3_500(provider).await?;

    let report = scanner
        .evaluate(Some(vec![pool_500]), ScanBlock::Latest)
        .await?;
    eprintln!(
        "after skew: routes={} quotes={} simulations={} opportunities={}",
        report.routes_considered,
        report.quotes,
        report.simulations,
        report.opportunities.len()
    );
    for note in &report.notes {
        eprintln!("note: {note}");
    }
    let opportunity = report
        .opportunities
        .first()
        .context("scanner found no opportunity after skewing univ3:500")?;
    eprintln!(
        "best: asset={} route={:?} amount={} profit_usd={:.4} net_usd={:.4} gas={}",
        opportunity.asset_symbol,
        opportunity.venues(),
        opportunity.amount,
        opportunity.profit_usd,
        opportunity.net_usd,
        opportunity.gas_used
    );
    assert!(
        opportunity.net_usd > 0.0,
        "opportunity must be net positive, got {}",
        opportunity.net_usd
    );
    assert!(!opportunity.calldata.is_empty(), "calldata must be built");
    assert!(
        !opportunity.floors.is_empty(),
        "route must carry per-leg floors"
    );

    if std::env::var("RYO_FORK_EXECUTE").as_deref() == Ok("1") {
        let recipient = manifest.profit_recipient;
        let before =
            chain::erc20_balance(provider, opportunity.asset, recipient, Default::default())
                .await?;
        let hash = send_and_wait(
            provider,
            manifest.operator,
            manifest.core,
            opportunity.calldata.clone(),
            opportunity.gas_used + 200_000,
        )
        .await?;
        let after =
            chain::erc20_balance(provider, opportunity.asset, recipient, Default::default())
                .await?;
        let gained = after.saturating_sub(before);
        eprintln!(
            "executed {hash}: recipient gained {gained} {} (simulated profit {})",
            opportunity.asset_symbol, opportunity.simulated_profit
        );
        assert!(
            !gained.is_zero(),
            "recipient balance did not increase after execute"
        );
        let simulated = opportunity
            .simulated_profit
            .try_into()
            .unwrap_or(U256::ZERO);
        assert!(
            gained.abs_diff(simulated) <= simulated / U256::from(100u64),
            "realized {gained} differs from simulated {simulated} by more than 1%"
        );
    }

    Ok(())
}

#[tokio::test]
#[ignore = "needs a local Anvil Base fork; see the module docs"]
async fn skewed_pool_produces_a_profitable_opportunity() {
    let rpc = fork_rpc();
    let manifest_path = manifest_path();
    let provider = chain::connect_http(&rpc)
        .await
        .expect("failed to connect to the fork RPC");

    let chain_id = chain::chain_id(&provider)
        .await
        .expect("eth_chainId failed");
    assert_eq!(chain_id, 8453, "expected a Base fork, got chain {chain_id}");

    let snapshot: Option<String> = raw(&provider, "evm_snapshot", serde_json::json!([]))
        .await
        .ok();
    let outcome = run(&provider, &rpc, &manifest_path).await;
    if let Some(snapshot) = snapshot {
        let reverted: bool = raw(&provider, "evm_revert", serde_json::json!([snapshot]))
            .await
            .unwrap_or(false);
        assert!(reverted, "evm_revert failed; the fork was left skewed");
    }
    if let Err(err) = outcome {
        panic!("fork scenario failed: {err:#}");
    }
}

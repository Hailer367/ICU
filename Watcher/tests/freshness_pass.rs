//! Fork integration test for the freshness pass: the scan's finalists are
//! re-quoted and re-simulated at a *newly resolved* pinned block, and the
//! report stays one-block-consistent either way.
//!
//! Needs a local Anvil Base fork with the core deployed (same setup as the
//! other fork tests):
//!
//! ```text
//! anvil --fork-url https://mainnet.base.org --chain-id 8453 --port 8545
//! RYO_FORK_RPC=http://127.0.0.1:8545 \
//!   cargo test --test freshness_pass -- --ignored --nocapture
//! ```
//!
//! The test pins automine so the head moves only when *it* says so, skews a
//! real pool to manufacture finalists, snapshots the chain, and reverts at
//! the end. Inside `run` every failed expectation is a `bail!`, never an
//! assert: a panicking assert would unwind past the revert and leave the
//! fork skewed for the next test.

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
use ryo_watch::scanner::{Fresh, ScanBlock, Scanner};
use serde_json::Value;

const BALANCER_VAULT: Address = address!("BA12222222228d8Ba445958a75a0704d566BF2C8");
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

async fn raw<T>(provider: &ChainProvider, method: &str, params: Value) -> Result<T>
where
    T: serde::de::DeserializeOwned + std::fmt::Debug + Send + Sync + Unpin + 'static,
{
    provider
        .raw_request::<_, T>(method.to_string().into(), params)
        .await
        .with_context(|| format!("{method} failed"))
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

    let unit = U256::from(1_000_000u64);
    let balance = chain::erc20_balance(provider, base::USDC, BALANCER_VAULT, Default::default())
        .await
        .context("failed to read vault USDC balance")?;
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
        max_gas_price_gwei: 5.0,
        min_net_profit_usd: 0.01,
        probe_amounts_usd: vec![500.0, 1_000.0, 2_000.0, 5_000.0],
        max_candidates: 12,
        max_simulations: 6,
        ..Settings::default()
    }
}

async fn run(provider: &ChainProvider, rpc: &str, manifest_path: &str) -> Result<()> {
    // The head must move only when this test says so: the Skipped branch is
    // only deterministic under automine, and anvil_mine is exact under it.
    raw::<Value>(provider, "anvil_setAutomine", serde_json::json!([true])).await?;
    skew_univ3_500(provider).await?;

    let manifest = Manifest::load(manifest_path)?;
    let scanner = Scanner::new(
        provider.clone(),
        manifest,
        build_settings(rpc, manifest_path),
    )?;
    let pool_500 = scanner
        .registry()
        .pools
        .iter()
        .position(|pool| pool.venue == Venue::UniV3 { fee: 500 })
        .context("registry has no univ3:500 pool")?;

    let report = scanner
        .evaluate(Some(vec![pool_500]), ScanBlock::Latest)
        .await?;
    eprintln!(
        "scan: block={} routes={} simulations={} opportunities={}",
        report.block,
        report.routes_considered,
        report.simulations,
        report.opportunities.len()
    );
    for note in &report.notes {
        eprintln!("note: {note}");
    }
    if report.reorged {
        bail!("the scan was void by a re-org; this test proves nothing");
    }
    let opportunities = &report.opportunities;
    if opportunities.is_empty() {
        bail!("no finalists to refresh; the skew did not produce an opportunity");
    }

    // Branch 1 — same head, no work: under automine nothing mined between
    // the scan and here, so the pass inside the scan must have skipped and a
    // direct call must skip too, leaving the same numbers standing.
    let first_pin = chain::Pin::resolve_latest(provider)
        .await
        .context("failed to resolve the head pin")?;
    if first_pin.number != report.block {
        bail!(
            "automine head {} must equal the scan's pinned block {}",
            first_pin.number,
            report.block
        );
    }
    if !report
        .notes
        .iter()
        .any(|note| note.contains("already fresh"))
    {
        bail!(
            "in-scan pass must report the same-head skip: {:?}",
            report.notes
        );
    }
    match scanner.freshness_pass(first_pin, opportunities).await {
        Fresh::Skipped(reason) => eprintln!("skip branch: {reason}"),
        Fresh::Applied { pin, .. } => bail!("unexpected Applied at unchanged head {pin:?}"),
        Fresh::Failed(reason) => bail!("unexpected Failed at unchanged head: {reason}"),
    }

    // Branch 2 — head moves by one empty block. Trade profits must come
    // back identical (no state changed); net USD is allowed to differ,
    // because an empty block legitimately lowers the EIP-1559 base fee —
    // that fee-market movement is exactly the freshness this pass captures.
    raw::<Value>(provider, "anvil_mine", serde_json::json!(["0x1"])).await?;
    let fresh = scanner.freshness_pass(first_pin, opportunities).await;
    let (pin, refreshed) = match fresh {
        Fresh::Applied { pin, opportunities } => (pin, opportunities),
        Fresh::Skipped(reason) => bail!("unexpected Skipped after mining a block: {reason}"),
        Fresh::Failed(reason) => bail!("unexpected Failed after mining a block: {reason}"),
    };
    if pin.number != first_pin.number + 1 {
        bail!(
            "expected the fresh pin at {}, got {}",
            first_pin.number + 1,
            pin.number
        );
    }
    if refreshed.len() != opportunities.len() {
        bail!(
            "an empty block cannot change any verdict: {} refreshed vs {} finalists",
            refreshed.len(),
            opportunities.len()
        );
    }
    for (old, new) in opportunities.iter().zip(&refreshed) {
        if new.block != pin.number {
            bail!(
                "refreshed numbers must name the new pin: {} vs {}",
                new.block,
                pin.number
            );
        }
        if old.asset != new.asset || old.amount != new.amount {
            bail!(
                "identity must survive the refresh: {} {} vs {} {}",
                old.asset_symbol,
                old.amount,
                new.asset_symbol,
                new.amount
            );
        }
        if old.simulated_profit != new.simulated_profit {
            bail!(
                "unchanged state must reproduce the same trade profit: {} vs {}",
                old.simulated_profit,
                new.simulated_profit
            );
        }
        eprintln!(
            "refreshed {} {} at block {}: net_usd {:.4} -> {:.4} (gas wei {} -> {})",
            new.asset_symbol,
            new.amount,
            new.block,
            old.net_usd,
            new.net_usd,
            old.cost.total_fee_wei,
            new.cost.total_fee_wei
        );
    }

    // The new pin is now the head: a third call must skip again.
    let second_pin = chain::Pin::resolve_latest(provider).await?;
    match scanner.freshness_pass(second_pin, &refreshed).await {
        Fresh::Skipped(_) => {}
        other => bail!("expected Skipped at unchanged head, got {other:?}"),
    }
    Ok(())
}

#[tokio::test]
#[ignore = "needs a local Anvil Base fork with the core deployed; see the module docs"]
async fn finalists_are_repriced_at_a_fresh_pin() {
    let rpc = std::env::var("RYO_FORK_RPC").unwrap_or_else(|_| "http://127.0.0.1:8545".to_string());
    let manifest_path =
        std::env::var("RYO_FORK_MANIFEST").unwrap_or_else(|_| "deployments/8453.anvil.json".into());
    let provider = chain::connect_http(&rpc)
        .await
        .expect("failed to connect to the fork RPC");

    let node: Value = raw(&provider, "anvil_nodeInfo", serde_json::json!([]))
        .await
        .expect("anvil_nodeInfo failed; this test needs a local Anvil fork, not a real node");
    assert!(
        node["forkConfig"].is_object(),
        "expected an Anvil fork (forkConfig missing from nodeInfo)"
    );
    let chain_id = chain::chain_id(&provider)
        .await
        .expect("eth_chainId failed");
    assert_eq!(chain_id, 8453, "expected a Base fork, got chain {chain_id}");

    let snapshot: String = raw(&provider, "evm_snapshot", serde_json::json!([]))
        .await
        .expect("evm_snapshot failed");
    let outcome = run(&provider, &rpc, &manifest_path).await;
    let reverted: bool = raw(&provider, "evm_revert", serde_json::json!([snapshot]))
        .await
        .unwrap_or(false);
    assert!(reverted, "evm_revert failed; the fork was left skewed");
    if let Err(err) = outcome {
        panic!("freshness scenario failed: {err:#}");
    }
}

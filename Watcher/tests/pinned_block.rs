//! Proves the property the pinned-block fix depends on: **a scan's numbers all
//! describe one block, and that block's state does not move underneath it.**
//!
//! Before this, a scan resolved "latest" separately for its reserve reads, its
//! quotes and its simulation, and reported a head number read at yet another
//! moment. Base produces a block roughly every two seconds, so a ~0.5 s scan
//! could easily quote block N and simulate block N+1 — a profit figure that
//! describes a trade that was possible in neither block. These tests check the
//! fix rather than trusting the code shape:
//!
//!   * `pin_block_and_hash_describe_the_same_canonical_block` — the pin is a
//!     real block, and its hash round-trips to the same state as its number.
//!   * `pinned_reads_are_immutable_while_the_chain_moves` — the decisive one:
//!     quote a pool at a pin, then *change that pool's state on chain*, then
//!     quote it at the pin again. The pinned answer must be identical (an
//!     immutable snapshot) and the current answer must differ (the test moved
//!     real state, so the equality above is not vacuous).
//!   * `every_number_in_a_scan_describes_one_block` — the whole pipeline: the
//!     reported block, its hash, the gas snapshot behind every opportunity, and
//!     the drift figure must all agree with a single block.
//!
//! Runs against the local Anvil Base fork by default, or any Base RPC:
//!
//! ```text
//! anvil --fork-url https://mainnet.base.org --chain-id 8453 --port 8545
//! cargo test --test pinned_block -- --ignored --nocapture
//!
//! # live Base (needs `chain.has_code(manifest.core)` for the third test)
//! RYO_LIVE_RPC=https://base-mainnet.g.alchemy.com/v2/<KEY> \
//!   cargo test --test pinned_block -- --ignored --nocapture
//! ```

use std::time::Duration;

use alloy::eips::BlockId;
use alloy::network::TransactionBuilder;
use alloy::primitives::{Address, B256, Bytes, U256, address};
use alloy::providers::Provider;
use alloy::rpc::types::TransactionRequest;
use alloy::sol_types::SolCall;
use anyhow::{Context, Result, bail};
use ryo_watch::chain::{self, Pin};
use ryo_watch::config::{Manifest, Settings, base};
use ryo_watch::scanner::Scanner;
use serde_json::Value;

/// Read-only tests run against any Base RPC.
fn live_rpc() -> String {
    std::env::var("RYO_LIVE_RPC").unwrap_or_else(|_| fork_rpc())
}

/// The tests that skew state, revert blocks or need `RyoCore` need Anvil. Kept
/// separate from `RYO_LIVE_RPC` on purpose: pointing them at a real node must
/// fail with an explanation, not with a confusing "unsupported method".
fn fork_rpc() -> String {
    std::env::var("RYO_FORK_RPC").unwrap_or_else(|_| "http://127.0.0.1:8545".to_string())
}

/// Refuse to run an Anvil-only test against something else.
async fn require_anvil(provider: &ryo_watch::chain::ChainProvider) -> Result<()> {
    match raw::<Value>(provider, "anvil_nodeInfo", serde_json::json!([])).await {
        Ok(_) => Ok(()),
        Err(err) => bail!(
            "this test needs a local Anvil Base fork (it skews pool state and reverts \
             blocks), but the RPC is not Anvil: {err:#}"
        ),
    }
}

fn manifest_path() -> String {
    std::env::var("RYO_LIVE_MANIFEST").unwrap_or_else(|_| "deployments/8453.anvil.json".to_string())
}

/// Base Balancer vault: holds a large USDC balance on the real chain, so the
/// fork can pay for a skew without funding tricks.
const BALANCER_VAULT: Address = address!("BA12222222228d8Ba445958a75a0704d566BF2C8");
const SWAP_ROUTER_02: Address = address!("2626664c2603336E57B271c5C0b26F421741e481");
/// UniV3 WETH/USDC 0.05% — one of the pools the scanner quotes.
const UNIV3_500: Address = address!("d0b53d9277642d899df5c87a3966a349a798f224");

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

    /// `IUniswapV3Pool.slot0()` — the current price, which any swap moves.
    function slot0()
        external
        view
        returns (uint160 sqrtPriceX96, int24 tick, uint16 observationIndex,
                 uint16 observationCardinality, uint16 observationCardinalityNext,
                 uint8 feeProtocol, bool unlocked);
}

async fn raw<T>(
    provider: &ryo_watch::chain::ChainProvider,
    method: &str,
    params: Value,
) -> Result<T>
where
    T: serde::de::DeserializeOwned + std::fmt::Debug + Send + Sync + Unpin + 'static,
{
    provider
        .raw_request::<_, T>(method.to_string().into(), params)
        .await
        .with_context(|| format!("{method} failed"))
}

/// Read the pool's price at one block. Returns `(sqrtPriceX96, tick)` — both
/// move on essentially every swap, which is what makes them a useful witness.
async fn price_at(
    provider: &ryo_watch::chain::ChainProvider,
    block: BlockId,
) -> Result<(alloy::primitives::U160, i64)> {
    let bytes = chain::eth_call(provider, UNIV3_500, slot0Call {}.abi_encode().into(), block)
        .await
        .context("slot0 failed")?;
    let result = slot0Call::abi_decode_returns(&bytes).context("failed to decode slot0")?;
    Ok((result.sqrtPriceX96, result.tick.as_i32() as i64))
}

/// Move real pool state by swapping USDC into WETH on the skewed pool.
async fn skew(provider: &ryo_watch::chain::ChainProvider, usdc: u64) -> Result<()> {
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

    let amount = U256::from(usdc) * U256::from(1_000_000u64);

    // The vault has the balance but not a standing allowance for the router.
    let approve = Bytes::from(
        approveCall {
            spender: SWAP_ROUTER_02,
            amount,
        }
        .abi_encode(),
    );
    send_tx(provider, BALANCER_VAULT, base::USDC, approve, 100_000).await?;

    let params = ExactInputSingleParams {
        tokenIn: base::USDC,
        tokenOut: base::WETH,
        fee: alloy::primitives::aliases::U24::from(500u32),
        recipient: BALANCER_VAULT,
        amountIn: amount,
        amountOutMinimum: U256::ZERO,
        sqrtPriceLimitX96: alloy::primitives::U160::ZERO,
    };
    send_tx(
        provider,
        BALANCER_VAULT,
        SWAP_ROUTER_02,
        Bytes::from(exactInputSingleCall { params }.abi_encode()),
        500_000,
    )
    .await?;
    Ok(())
}

/// Send one transaction from `from` (Anvil must be able to sign for it) and
/// wait for a successful receipt.
async fn send_tx(
    provider: &ryo_watch::chain::ChainProvider,
    from: Address,
    to: Address,
    input: Bytes,
    gas: u64,
) -> Result<()> {
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
            return Ok(());
        }
        tokio::time::sleep(Duration::from_millis(50)).await;
    }
    bail!("transaction {hash} was not mined within 5s");
}

async fn connect(rpc: &str) -> Result<ryo_watch::chain::ChainProvider> {
    let provider = chain::connect_http(rpc)
        .await
        .context("failed to connect to the RPC")?;
    let chain_id = chain::chain_id(&provider)
        .await
        .context("eth_chainId failed")?;
    if chain_id != 8453 {
        bail!("expected Base (8453), got chain {chain_id}");
    }
    Ok(provider)
}

/// The pin must name a block that exists, and its hash must resolve to the
/// same state its number does — otherwise "pinned by hash" is decoration.
#[tokio::test]
#[ignore = "needs a Base RPC (local fork by default)"]
async fn pin_block_and_hash_describe_the_same_canonical_block() {
    let provider = match connect(&live_rpc()).await {
        Ok(provider) => provider,
        Err(err) => panic!("{err:#}"),
    };
    if let Err(err) = run_canonical(&provider).await {
        panic!("pin canonicality check failed: {err:#}");
    }
}

async fn run_canonical(provider: &ryo_watch::chain::ChainProvider) -> Result<()> {
    let pin = Pin::resolve_latest(provider).await?;
    assert!(pin.hash.is_some(), "a mined block must carry a hash");
    eprintln!("pinned block {} at {}", pin.number, pin.hash.unwrap());

    let header = provider
        .get_block_by_number(alloy::rpc::types::BlockNumberOrTag::Number(pin.number))
        .await?
        .context("the pinned block is not on this node")?;
    assert_eq!(
        header.header.hash,
        pin.hash.context("pin has no hash")?,
        "the pinned hash is not the hash of the pinned number"
    );
    assert_eq!(
        header.header.timestamp, pin.timestamp,
        "pin timestamp mismatch"
    );

    // Number-form and hash-form must agree byte-for-byte.
    let by_hash = price_at(provider, pin.id()).await?;
    let by_number = price_at(provider, BlockId::number(pin.number)).await?;
    assert_eq!(
        by_hash, by_number,
        "hash pinning and number pinning disagree at the same block"
    );

    // And the pin must not be a moving target: repeated reads are identical.
    for _ in 0..3 {
        assert_eq!(
            price_at(provider, pin.id()).await?,
            by_hash,
            "pinned read drifted"
        );
    }
    Ok(())
}

/// The decisive test: change pool state *after* pinning, and show the pinned
/// read is untouched while the current read moved.
#[tokio::test]
#[ignore = "needs a local Anvil Base fork (it skews and reverts state)"]
async fn pinned_reads_are_immutable_while_the_chain_moves() {
    let provider = match connect(&fork_rpc()).await {
        Ok(provider) => provider,
        Err(err) => panic!("{err:#}"),
    };
    if let Err(err) = require_anvil(&provider).await {
        panic!("{err:#}");
    }
    if let Err(err) = run_immutable(&provider).await {
        panic!("pinning immutability check failed: {err:#}");
    }
}

async fn run_immutable(provider: &ryo_watch::chain::ChainProvider) -> Result<()> {
    with_reverted_state(provider, immutable_body(provider)).await
}

/// Run `body`, then restore the fork exactly as it was found, so a test that
/// moves 60k USDC through a live pool leaves nothing behind for the next one.
async fn with_reverted_state<Fut>(
    provider: &ryo_watch::chain::ChainProvider,
    body: Fut,
) -> Result<()>
where
    Fut: std::future::Future<Output = Result<()>>,
{
    let snapshot: U256 = raw(provider, "anvil_snapshot", serde_json::json!([])).await?;
    let result = body.await;
    let reverted: bool = raw(provider, "evm_revert", serde_json::json!([snapshot]))
        .await
        .unwrap_or(false);
    assert!(reverted, "evm_revert failed; the fork was left skewed");
    result
}

async fn immutable_body(provider: &ryo_watch::chain::ChainProvider) -> Result<()> {
    let pin = Pin::resolve_latest(provider).await?;
    let pinned_price = price_at(provider, pin.id()).await?;

    skew(provider, 60_000).await?;

    let head_after = chain::block_number(provider).await?;
    assert!(
        head_after > pin.number,
        "the skew did not produce a new block (head {head_after}, pin {}); \
         the fork is not mining and this test proves nothing",
        pin.number
    );

    // The pinned snapshot is untouched, even though the chain moved on.
    let pinned_again = price_at(provider, pin.id()).await?;
    assert_eq!(
        pinned_price, pinned_again,
        "a pinned read changed after the chain advanced; the scan's numbers \
         would not describe one block"
    );

    // Non-vacuousness: the *current* pool state really did move, so matching
    // pinned reads above is a property of pinning, not a quiet chain.
    let current = price_at(provider, BlockId::latest()).await?;
    assert_ne!(
        pinned_price, current,
        "the 60k USDC skew left the price unchanged; cannot tell an immutable \
         pin from a stale node — this test needs a pool that actually moves"
    );
    eprintln!(
        "pin {} price {} (tick {}) — unchanged after chain moved to {head_after}; current price {} (tick {})",
        pin.number, pinned_price.0, pinned_price.1, current.0, current.1
    );

    // A pin older than the newest state must still be served. Base full nodes
    // keep only recent state, so this is also a compatibility check.
    let moved_head = Pin::from_header(pin.number, pin.hash, pin.timestamp, pin.base_fee_per_gas);
    assert_eq!(
        moved_head.blocks_behind(head_after),
        head_after - pin.number
    );
    assert_eq!(moved_head.blocks_behind(pin.number), 0);
    Ok(())
}

/// Whole-pipeline check: nothing in a scan may reference a second block.
#[tokio::test]
#[ignore = "needs a local Anvil Base fork with RyoCore deployed"]
async fn every_number_in_a_scan_describes_one_block() {
    let provider = match connect(&fork_rpc()).await {
        Ok(provider) => provider,
        Err(err) => panic!("{err:#}"),
    };
    if let Err(err) = require_anvil(&provider).await {
        panic!("{err:#}");
    }
    let result = with_reverted_state(&provider, run_one_block(&provider)).await;
    if let Err(err) = result {
        panic!("single-block scan check failed: {err:#}");
    }
}

async fn run_one_block(provider: &ryo_watch::chain::ChainProvider) -> Result<()> {
    let manifest = Manifest::load(manifest_path())?;
    let code = provider.get_code_at(manifest.core).await?;
    if code.is_empty() {
        bail!(
            "no RyoCore at {} on this RPC; the scan needs the contract to \
             simulate against (run the fork deploy from State.md section 9)",
            manifest.core
        );
    }

    // Anvil's base fee is far above the production ceiling, and the point here
    // is block consistency rather than profit filtering, so loosen both. Using
    // `Settings::default()` made the scan reject everything and the test pass
    // on a scan that had considered zero routes.
    let scanner = Scanner::new(
        provider.clone(),
        manifest.clone(),
        Settings {
            http_rpc: live_rpc(),
            manifest_path: manifest_path().into(),
            max_gas_price_gwei: 5.0,
            min_net_profit_usd: 0.01,
            probe_amounts_usd: vec![500.0, 1_000.0, 2_000.0],
            ..Settings::default()
        },
    )?;
    // Skew first: with a quiet pool the scan finds nothing to simulate, and
    // the per-opportunity check below would loop over an empty list and prove
    // nothing. A manufactured edge is what makes it a real assertion.
    skew(provider, 60_000).await?;

    let report = scanner.scan_once().await?;
    eprintln!(
        "scan: block {} hash {:?} drift {} routes {} quotes {} sims {} opportunities {}",
        report.block,
        report.pin_hash.map(|h| h.to_string()),
        report.head_drift,
        report.routes_considered,
        report.quotes,
        report.simulations,
        report.opportunities.len()
    );

    // Guard against a vacuous pass: a scan that considered nothing proves
    // nothing about which block its numbers came from.
    assert!(
        report.routes_considered > 0 && report.quotes > 0,
        "the scan did no work (routes {}, quotes {}); a gate is rejecting \
         everything on this fork, so this test would pass against an empty \
         scan. notes: {:?}",
        report.routes_considered,
        report.quotes,
        report.notes
    );

    let pin_hash = report.pin_hash.context("report has no pinned hash")?;
    assert!(report.block > 0, "report names no block");
    assert!(
        !report.reorged,
        "an ordinary scan must not be flagged as re-orged; a guard that cries \
         wolf will be ignored: {:?}",
        report.notes
    );
    assert!(
        !report.opportunities.is_empty(),
        "the skew produced no simulated opportunity (sims {}), so the opportunity/block \
         agreement check below has nothing to check: {:?}",
        report.simulations,
        report.notes
    );

    // The reported block must exist and carry exactly that hash.
    let header = provider
        .get_block_by_number(alloy::rpc::types::BlockNumberOrTag::Number(report.block))
        .await?
        .context("reported block is not on this node")?;
    assert_eq!(
        header.header.hash, pin_hash,
        "reported block/hash pair is not a real block"
    );

    // Whatever the chain could not price must be *said*, not hidden inside a
    // zero-opportunity result. Checked only when it happens, so a healthy fork
    // run cannot pass by skipping the assertion.
    if report.quote_failures > 0 {
        assert!(
            report
                .notes
                .iter()
                .any(|note| note.contains("could not be priced")),
            "{} legs went unpriced but the report hides it: {:?}",
            report.quote_failures,
            report.notes
        );
    }

    // Every opportunity's gas figures come from the same block the scan pinned.
    // Before the fix, `Opportunity.block` was the gas snapshot's block, which
    // could be a whole block away from the state the trade was quoted at.
    for opportunity in &report.opportunities {
        assert_eq!(
            opportunity.block, report.block,
            "opportunity cites block {} but the scan pinned {}",
            opportunity.block, report.block
        );
    }

    // The drift figure must be the honest distance to head, no more and no
    // less: recompute it independently.
    let head_now = chain::block_number(provider).await?;
    assert!(
        report.head_drift <= head_now.saturating_sub(report.block),
        "reported drift {} exceeds the distance to head {head_now} from block {}",
        report.head_drift,
        report.block
    );
    if report.head_drift > 0 {
        assert!(
            report
                .notes
                .iter()
                .any(|note| note.contains("blocks behind head")),
            "a scan with drift {} must say so in its notes",
            report.head_drift
        );
    }
    Ok(())
}

/// The failure mode hash-pinning cannot survive: the sequencer discards the
/// very block we pinned. Anvil lets us produce that situation on purpose —
/// snapshot, mine a block, revert behind it, mine a *different* block at the
/// same number — so the guard is tested against a genuine re-org rather than
/// assumed correct.
#[tokio::test]
#[ignore = "needs a local Anvil Base fork (it reverts chain state)"]
async fn a_reorg_of_the_pinned_block_is_detected_and_voids_the_scan() {
    let provider = match connect(&fork_rpc()).await {
        Ok(provider) => provider,
        Err(err) => panic!("{err:#}"),
    };
    if let Err(err) = require_anvil(&provider).await {
        panic!("{err:#}");
    }
    let result = with_reverted_state(&provider, reorg_body(&provider)).await;
    if let Err(err) = result {
        panic!("re-org detection check failed: {err:#}");
    }
}

async fn reorg_body(provider: &ryo_watch::chain::ChainProvider) -> Result<()> {
    let account = address!("f39Fd6e51aad88F6F4ce6aB8827279cffFb92266");
    raw::<Value>(
        provider,
        "anvil_setBalance",
        serde_json::json!([account, "0x20000000000000"]),
    )
    .await?;
    let _ = raw::<Value>(provider, "anvil_setAutomine", serde_json::json!([true])).await;

    // Snapshot *behind* the block we are about to pin, so we can re-mine it.
    let behind: U256 = raw(provider, "anvil_snapshot", serde_json::json!([])).await?;
    mine_value_tx(provider, account, "0x1").await?;

    let pin = Pin::resolve_latest(provider).await?;
    let pinned_hash = pin.hash.context("pin has no hash")?;
    assert_eq!(
        chain::header_hash(provider, pin.number).await?,
        Some(pinned_hash),
        "the block we just pinned is not canonical yet; the fork is not mining"
    );
    assert!(
        !pin.is_superseded_by(Some(pinned_hash)),
        "a canonical block must not be reported as re-orged"
    );

    // Revert behind the pin, then mine a different block at the same number.
    let reverted: bool = raw(provider, "evm_revert", serde_json::json!([behind]))
        .await
        .context("evm_revert failed")?;
    assert!(reverted, "evm_revert returned false");
    mine_value_tx(provider, account, "0x2").await?;

    let current = chain::header_hash(provider, pin.number).await?;
    assert_ne!(
        current,
        Some(pinned_hash),
        "block {} kept the same hash after revert + re-mine, so no re-org was \
         actually produced and this test proves nothing",
        pin.number
    );
    assert!(
        pin.is_superseded_by(current),
        "the guard missed a block that really was re-orged"
    );
    eprintln!(
        "re-org reproduced at block {}: pinned {} is now {}",
        pin.number,
        pinned_hash,
        current.map(|h| h.to_string()).unwrap_or_default()
    );

    // Record what the node does with reads against the discarded block. Either
    // answer is survivable — the point is that the guard, not the node, is what
    // tells the operator the numbers are void.
    match price_at(provider, pin.id()).await {
        Ok(price) => eprintln!(
            "note: eth_call at the DISCARDED hash still returned state ({:?}); a \
             re-orged scan would look perfectly consistent and mean nothing",
            price.1
        ),
        Err(err) => eprintln!("note: eth_call at the discarded hash failed: {err:#}"),
    }
    Ok(())
}

/// Send a plain value transfer, which mines a block under automine. Varying
/// `value` changes the transaction and therefore the resulting block hash.
async fn mine_value_tx(
    provider: &ryo_watch::chain::ChainProvider,
    from: Address,
    value: &str,
) -> Result<()> {
    let request = TransactionRequest::default()
        .with_from(from)
        .with_to(from)
        .with_value(
            value
                .parse::<alloy::primitives::U256>()
                .context("bad value")?,
        );
    let hash: B256 = provider
        .raw_request("eth_sendTransaction".to_string().into(), (request,))
        .await
        .context("eth_sendTransaction failed")?;
    for _ in 0..100 {
        if provider
            .get_transaction_receipt(hash)
            .await
            .context("failed to poll receipt")?
            .is_some()
        {
            return Ok(());
        }
        tokio::time::sleep(Duration::from_millis(50)).await;
    }
    bail!("value transaction {hash} was not mined within 5s");
}

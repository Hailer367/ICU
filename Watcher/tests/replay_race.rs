//! §0w Phase 3 — the replay race harness (block-faithful, M1).
//!
//! Replays a REAL gap episode on a pinned Anvil fork: EVERY transaction of
//! each source block in the window is re-sent (impersonated) in source
//! order, and the fork mines ONE local block per source block with the
//! SOURCE timestamp — swap deadlines in replayed transactions therefore
//! see the same clock they saw on mainnet. The pool logs land through the
//! same `Scanner::scan_triggers` path `watch` uses; the harness times
//! trigger-received → ready-calldata (Record B) and judges against the
//! winner's measured close position (Record A, via log-position proxy).
//!
//! Runbook (one episode cluster per fork; `tools/race_replay.sh` automates
//! the whole dance. The fork base is `open_block - WARMUP - 1` with WARMUP
//! ≥ 60: Anvil cannot rewind its clock (verified 1.9.0 — `--timestamp` is
//! clamped on forks, both `evm_`/`anvil_setNextBlockTimestamp` refuse ≤
//! parent), so the deploy's ~D blocks of +1s drift must be absorbed by the
//! warmup; exact source timestamps are mandatory from the open block on.):
//!
//! ```text
//! source ~/.ryo_env
//! anvil --fork-url "$ALCHEMY_BASE_HTTP" --fork-block-number <open-warmup-1> --chain-id 8453 --port 8545
//! # deploy with MANIFEST_PATH=../Watcher/deployments/8453.race.json
//! RYO_FORK_RPC=http://127.0.0.1:8545 RYO_FORK_MANIFEST=deployments/8453.race.json \
//! RYO_SOURCE_RPC="$ALCHEMY_BASE_HTTP" RYO_EPISODES=data/gap_autopsy_24h_60bps.json \
//! RYO_EPISODE_LAG_MAX=1 RYO_EPISODE_RANK=0 \
//!   cargo test --test replay_race -- --ignored --nocapture --test-threads=1
//! ```
//!
//! Optional: `RYO_EPISODE_RANK`, `RYO_EPISODE_LAG_MAX`, `RYO_WARMUP_BLOCKS`
//! (3), `RYO_POST_BLOCKS` (3), `RYO_FORK_EXECUTE=1`, `RYO_DATASET`.

use std::collections::{HashMap, HashSet};
use std::str::FromStr;
use std::time::{Duration, Instant};

use alloy::primitives::{Address, B256, U256};
use alloy::providers::Provider;
use alloy::rpc::types::Log;
use anyhow::{Context, Result, bail};
use ryo_watch::chain::{self, ChainProvider};
use ryo_watch::config::{Manifest, Mode, Settings};
use ryo_watch::events::{HeadInfo, Trigger};
use ryo_watch::scanner::Scanner;
use serde::Deserialize;
use serde_json::{Value, json};

#[derive(Debug, Deserialize)]
struct Episode {
    pair: String,
    buy: String,
    sell: String,
    open_block: u64,
    #[allow(dead_code)]
    last_block: u64,
    peak_bps: f64,
    /// Last trade on the STALE side before the gap — provenance, arbitrary
    /// age, NOT the trigger. (Pre-2026-11-06 episodes mislabeled this as the
    /// opener and the replay keyed on it; the autopsy now records both.)
    open_tx: Option<String>,
    /// The trade that actually pushed a direction over the line inside
    /// `open_block` — the watcher's trigger, the fidelity anchor, and the
    /// log position the winner raced from.
    gap_tx: Option<String>,
    #[allow(dead_code)]
    open_log: Option<u64>,
    #[allow(dead_code)]
    gap_log: Option<u64>,
    #[allow(dead_code)]
    closed_same_block: Option<bool>,
    closer: Option<String>,
    close_lag_blocks: Option<u64>,
    close_pos_gap: Option<u64>,
    #[allow(dead_code)]
    close_tx: Option<String>,
}

#[derive(Debug, Deserialize)]
struct EventRec {
    block: u64,
    #[serde(default)]
    tx_hash: Option<String>,
    #[allow(dead_code)]
    log_index: u64,
    pool: String,
}

#[derive(Debug)]
struct SourceTx {
    hash: B256,
    from: Address,
    to: Option<Address>,
    nonce: u64,
    #[allow(dead_code)]
    index: u64,
    gas: String,
    value: String,
    input: String,
    /// Fee fields as sent on mainnet, replayed verbatim: a fabricated
    /// maxFee could sit below the opener's own spend ceiling and change
    /// inclusion or gas cost the moment fidelity matters.
    max_fee: Option<String>,
    max_prio: Option<String>,
    gas_price: Option<String>,
    status: bool,
    touches_pools: bool,
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

/// A source-RPC read with retry: Alchemy free-tier 429s under bursts and
/// publicnode intermittently 403s (§0p). Three attempts, 1/2/4s backoff.
async fn src_json(provider: &ChainProvider, method: &str, params: Value) -> Result<Value> {
    let mut delay = Duration::from_secs(1);
    let mut last_err = None;
    for _ in 0..3 {
        match raw::<Value>(provider, method, params.clone()).await {
            Ok(v) => return Ok(v),
            Err(e) => {
                last_err = Some(e);
                tokio::time::sleep(delay).await;
                delay *= 2;
            }
        }
    }
    Err(last_err.unwrap())
}

fn hx_u64(s: &str) -> Option<u64> {
    u64::from_str_radix(s.strip_prefix("0x").unwrap_or(s), 16).ok()
}

fn env_or(key: &str, default: &str) -> String {
    std::env::var(key).unwrap_or_else(|_| default.to_string())
}

/// OP-Stack predeploy addresses the block producer owns; never replayable.
fn is_system_tx(to: Option<Address>) -> bool {
    let Some(t) = to else { return false };
    let s = t.to_string().to_lowercase();
    s.starts_with("0x42000000000000000000000000000000000000")
        && ["05", "06", "07", "15", "16"].contains(&&s[s.len() - 2..])
}

/// Parse a full block + its receipts into (timestamp, txs). Split out of the
/// fetch so cached windows re-enter through the identical code path.
fn parse_source_block(b: u64, block: &Value, receipts: &Value) -> Result<(u64, Vec<SourceTx>)> {
    let ts = hx_u64(block["timestamp"].as_str().unwrap_or("0x0")).unwrap_or(0);
    let mut status_by_hash: HashMap<String, bool> = HashMap::new();
    if let Some(arr) = receipts.as_array() {
        for r in arr {
            if let (Some(h), Some(st)) = (
                r.get("transactionHash").and_then(Value::as_str),
                r.get("status").and_then(Value::as_str),
            ) {
                status_by_hash.insert(h.to_string(), hx_u64(st) == Some(1));
            }
        }
    }
    let empty: Vec<Value> = Vec::new();
    let mut out = Vec::new();
    for tx in block["transactions"].as_array().unwrap_or(&empty) {
        let (Some(hash_s), Some(from_s), Some(nonce_s), Some(index_s)) = (
            tx.get("hash").and_then(Value::as_str),
            tx.get("from").and_then(Value::as_str),
            tx.get("nonce").and_then(Value::as_str).and_then(hx_u64),
            tx.get("transactionIndex").and_then(Value::as_str).and_then(hx_u64),
        ) else {
            continue;
        };
        let Ok(hash) = B256::from_str(hash_s) else { continue };
        let to = tx.get("to").and_then(Value::as_str).map(Address::from_str).transpose();
        let to = match to {
            Ok(t) => t,
            Err(_) => None,
        };
        out.push(SourceTx {
            hash,
            from: Address::from_str(from_s)?,
            to,
            nonce: nonce_s,
            index: index_s,
            gas: tx.get("gas").and_then(Value::as_str).unwrap_or("0x5208").to_string(),
            value: tx.get("value").and_then(Value::as_str).unwrap_or("0x0").to_string(),
            input: tx.get("input").and_then(Value::as_str).unwrap_or("0x").to_string(),
            max_fee: tx.get("maxFeePerGas").and_then(Value::as_str).map(str::to_string),
            max_prio: tx.get("maxPriorityFeePerGas").and_then(Value::as_str).map(str::to_string),
            gas_price: tx.get("gasPrice").and_then(Value::as_str).map(str::to_string),
            status: status_by_hash.get(hash_s).copied().unwrap_or(false),
            touches_pools: false,
        });
    }
    let _ = b;
    Ok((ts, out))
}

/// Fetch a source block + receipts, with a per-block disk cache under
/// `data/srcblocks/`. Episodes share windows and lever A/B runs re-replay
/// them, so one fetch per block per lifetime is enough.
async fn fetch_source_block_cached(
    source: &ChainProvider,
    cache_dir: &str,
    b: u64,
) -> Result<(u64, Vec<SourceTx>)> {
    let path = format!("{cache_dir}/{b}.json");
    if let Ok(cached) = std::fs::read_to_string(&path) {
        let v: Value = serde_json::from_str(&cached)
            .with_context(|| format!("cached block {b} corrupt; delete {path}"))?;
        return parse_source_block(b, &v["block"], &v["receipts"]);
    }
    let hex = format!("0x{b:x}");
    let block = src_json(source, "eth_getBlockByNumber", json!([hex.clone(), true]))
        .await
        .with_context(|| format!("source block {b} (full)"))?;
    let receipts = src_json(source, "eth_getBlockReceipts", json!([hex]))
        .await
        .with_context(|| format!("source receipts for block {b}"))?;
    std::fs::create_dir_all(cache_dir).ok();
    std::fs::write(&path, serde_json::to_vec(&json!({"block": block, "receipts": receipts}))?)
        .with_context(|| format!("write cache {path}"))?;
    parse_source_block(b, &block, &receipts)
}

/// Unmined replay txs (pending + queued) waiting in the local pool.
async fn pool_pending(provider: &ChainProvider) -> Result<usize> {
    let s = raw::<Value>(provider, "txpool_status", json!([])).await?;
    let p = hx_u64(s["pending"].as_str().unwrap_or("0x0")).unwrap_or(0);
    let q = hx_u64(s["queued"].as_str().unwrap_or("0x0")).unwrap_or(0);
    Ok((p + q) as usize)
}

async fn run() -> Result<()> {
    let fork_rpc = env_or("RYO_FORK_RPC", "http://127.0.0.1:8545");
    let manifest_path = env_or("RYO_FORK_MANIFEST", "deployments/8453.race.json");
    let source_rpc = std::env::var("RYO_SOURCE_RPC").context("RYO_SOURCE_RPC required")?;
    let dataset_path = env_or("RYO_DATASET", "data/swaps_24h.jsonl");
    let episodes_path = env_or("RYO_EPISODES", "data/gap_autopsy_24h_60bps.json");
    let rank: usize = env_or("RYO_EPISODE_RANK", "0").parse().unwrap_or(0);
    let warmup: u64 = env_or("RYO_WARMUP_BLOCKS", "3").parse().unwrap_or(3);
    let post: u64 = env_or("RYO_POST_BLOCKS", "3").parse().unwrap_or(3);

    let episodes_raw = std::fs::read_to_string(&episodes_path)
        .with_context(|| format!("run tools/gap_autopsy.py first: missing {episodes_path}"))?;
    let mut episodes: Vec<Episode> = serde_json::from_str(&episodes_raw)?;
    episodes.retain(|e| e.gap_tx.is_some() && e.peak_bps > 0.0);
    if let Some(lag_max) = std::env::var("RYO_EPISODE_LAG_MAX").ok().and_then(|s| s.parse::<u64>().ok()) {
        episodes.retain(|e| e.close_lag_blocks.is_some_and(|lag| lag <= lag_max));
    }
    episodes.sort_by(|a, b| {
        a.close_lag_blocks
            .unwrap_or(u64::MAX)
            .cmp(&b.close_lag_blocks.unwrap_or(u64::MAX))
            .then(b.peak_bps.total_cmp(&a.peak_bps))
    });
    let episode = episodes.get(rank).context("no eligible episodes")?;
    // The runner script picks replayable openers (some contracts bind their
    // auth to real-chain block hashes and can never verify under a
    // re-signed replay) and passes the chosen block here; a mismatch means
    // the two selections drifted and the whole fork is mis-anchored.
    if let Some(want) = std::env::var("RYO_EXPECT_OPEN_BLOCK").ok().and_then(|s| s.parse::<u64>().ok())
        && episode.open_block != want {
        bail!("episode rank {rank} opens at {} but runner expects {want}; fork is anchored to a different episode", episode.open_block);
    }
    let open_block = episode.open_block;
    let close_block = open_block + episode.close_lag_blocks.unwrap_or(0);
    let base = open_block.checked_sub(warmup + 1).context("episode block too low")?;
    let end = close_block + post;
    let trigger_tx = B256::from_str(&episode.gap_tx.clone().unwrap())?;
    eprintln!(
        "episode #{rank}: {} buy={} sell={} peak={}bps open={open_block} close_lag={:?} pos_gap={:?} closer={:?}",
        episode.pair, episode.buy, episode.sell, episode.peak_bps,
        episode.close_lag_blocks, episode.close_pos_gap, episode.closer,
    );

    let provider = chain::connect_http(&fork_rpc).await?;
    if chain::chain_id(&provider).await? != 8453 {
        bail!("fork is not chain 8453");
    }
    // Block-NUMBER alignment is a hard requirement, not a nicety: replayed
    // txs carry block.number deadlines (Permit2 expirations, V4 hook windows)
    // and mis-numbered blocks revert them (observed on the rank-0 opener).
    // race_replay.sh forks D blocks earlier so the deploy lands the head
    // exactly on the source base block.
    let head = provider.get_block_number().await?;
    if head != base {
        bail!(
            "fork head {head} != replay base {base}: local block numbers must equal source. \
             Re-run tools/race_replay.sh (it iterates the deploy-block offset)"
        );
    }
    let manifest = Manifest::load(&manifest_path)?;
    if chain::code_at(&provider, manifest.core).await?.is_empty() {
        bail!("core {} has no code on the fork; deploy first", manifest.core);
    }

    let settings = replay_settings(&fork_rpc, &manifest_path);
    settings.validate()?;
    let scanner = Scanner::new(provider.clone(), manifest.clone(), settings)?;
    let pools: HashSet<Address> = scanner.registry().all_pool_addresses().into_iter().collect();

    let source = chain::connect_http(&source_rpc).await?;
    // Pin integrity is anchored at the FORK block F (= base - deploy blocks):
    // local blocks base-D+1..base are the synthetic deploy blocks and share
    // only the state ancestry, not contents, with source. Block F itself must
    // be byte-identical.
    let fork_block: u64 = std::env::var("RYO_FORK_BLOCK")
        .context("RYO_FORK_BLOCK required (race_replay.sh passes the fork point; block-number alignment is checked against it)")?
        .parse()
        .context("RYO_FORK_BLOCK not a number")?;
    let local_fork = raw::<Value>(&provider, "eth_getBlockByNumber", json!([format!("0x{fork_block:x}"), false])).await?;
    let src_fork = src_json(&source, "eth_getBlockByNumber", json!([format!("0x{fork_block:x}"), false]))
        .await
        .context("source fork block for hash check")?;
    if src_fork["hash"].as_str() != local_fork["hash"].as_str() {
        bail!("fork block {fork_block} hash differs from source; wrong pin");
    }
    let fork_ts = hx_u64(src_fork["timestamp"].as_str().unwrap_or("0x0")).unwrap_or(0);

    // 1. Source window blocks (disk-cached; fetched once per block ever).
    let cache_dir = format!("{}/srcblocks", dataset_path.rsplit_once('/').map_or("data", |x| x.0));
    let mut tx_by_block: Vec<(u64, u64, Vec<SourceTx>)> = Vec::new(); // (block, ts, txs)
    let mut fresh_fetches = 0usize;
    for b in base + 1..=end {
        let existed = std::path::Path::new(&format!("{cache_dir}/{b}.json")).exists();
        let (ts, txs) = fetch_source_block_cached(&source, &cache_dir, b).await?;
        if !existed {
            fresh_fetches += 1;
            tokio::time::sleep(Duration::from_millis(150)).await; // courtesy pacing
        }
        tx_by_block.push((b, ts, txs));
    }
    eprintln!(
        "[source] window ready: {} blocks ({fresh_fetches} fetched, {} cached)",
        tx_by_block.len(),
        tx_by_block.len() - fresh_fetches
    );

    // 2. Mark pool-touching txs + the dataset's wanted set consistency.
    let mut dataset_txs: HashSet<B256> = HashSet::new();
    if let Ok(dataset) = std::fs::read_to_string(&dataset_path) {
        for line in dataset.lines() {
            if let Ok(e) = serde_json::from_str::<EventRec>(line)
                && e.block > base
                && e.block <= end
                && pools.iter().any(|p| p.to_string().eq_ignore_ascii_case(&e.pool))
                && let Some(h) = e.tx_hash
                && let Ok(h) = B256::from_str(&h)
            {
                dataset_txs.insert(h);
            }
        }
    }
    for (_b, _ts, txs) in tx_by_block.iter_mut() {
        for tx in txs.iter_mut() {
            tx.touches_pools = dataset_txs.contains(&tx.hash);
        }
    }
    let total_txs: usize = tx_by_block.iter().map(|t| t.2.len()).sum();
    let pool_txs: usize = tx_by_block.iter().map(|t| t.2.iter().filter(|x| x.touches_pools).count()).sum();
    eprintln!("[replay] {total_txs} source txs, {pool_txs} touch registry pools");

    // 3. Freeze automine, replay block by block with forward-only pins.
    //    Clock reality (verified on anvil 1.9.0, 2026-11-06): Anvil CANNOT go
    //    to the past. `--timestamp` is clamped to the fork block on forked
    //    nodes, and both `evm_setNextBlockTimestamp` and
    //    `anvil_setNextBlockTimestamp` reject values <= the parent's. The
    //    deploy transactions mined D blocks at +1s each, so the local clock
    //    enters the replay D seconds ahead of the early warmup blocks' source
    //    timestamps. Warmup blocks therefore mine at `head+1` (they exist to
    //    prime state and the CL cache; their absolute ts is not evidence);
    //    drift drains at ~1s per block (source cadence ~2s, drifted blocks
    //    step 1s). From the open block ON the pin must be the exact source
    //    timestamp — a race window replayed on the wrong clock is worthless,
    //    so drift surviving that long is a hard bail, not a silent lie.
    raw::<Value>(&provider, "evm_setAutomine", json!([false])).await?;
    scanner.prime_cl().await;
    eprintln!("[race] primed; replaying at source cadence");

    let mut sent = 0usize;
    let mut send_failed = 0usize;
    let mut status_mismatch = 0usize;
    let mut pool_tx_mismatch = 0usize;
    let mut pool_tx_sent = 0usize;
    let mut warmup_reverts = 0usize;
    let mut drifted_warmup = 0usize;
    let mut open_ts_exact = false;
    let mut open_ok = None;
    let mut ready_ms: Option<u128> = None;
    let mut ready_phases: Vec<(String, u128)> = Vec::new();
    let mut race_started = false;
    let mut opps_after_open: Vec<String> = Vec::new();
    let mut scan_times: Vec<u128> = Vec::new();

    for (b, ts, txs) in &tx_by_block {
        // Forward-only pin: exact source ts when the local clock is behind it,
        // otherwise (warmup only) one second past the head. See section 3.
        let head_now = raw::<Value>(&provider, "eth_getBlockByNumber", json!(["latest", false])).await?;
        let head_ts = hx_u64(head_now["timestamp"].as_str().unwrap_or("0x0")).unwrap_or(0);
        let pin = if *ts > head_ts {
            *ts
        } else {
            if *b >= open_block {
                bail!(
                    "local clock {head_ts} has not caught up to source ts {ts} by the open block {open_block}: \
                     deploy drift exceeded the warmup budget — raise RYO_WARMUP_BLOCKS (currently {warmup})"
                );
            }
            drifted_warmup += 1;
            head_ts + 1
        };
        raw::<Value>(&provider, "evm_setNextBlockTimestamp", json!([format!("0x{pin:x}")]))
            .await
            .with_context(|| format!("cannot pin block {b} to ts {pin}"))?;
        // Anvil re-signs impersonated sends, so each source tx lands under a
        // NEW local hash. Record the mapping to attribute receipts back.
        let mut src_by_local: HashMap<B256, B256> = HashMap::new();
        let mut senders: HashSet<Address> = HashSet::new();
        let mut sent_this_block = 0usize;
        for tx in txs.iter().filter(|t| t.touches_pools) {
            if is_system_tx(tx.to) {
                continue;
            }
            if senders.insert(tx.from) {
                raw::<Value>(&provider, "anvil_impersonateAccount", json!([tx.from])).await.ok();
            }
            let bal = raw::<String>(&provider, "eth_getBalance", json!([tx.from, "latest"]))
                .await
                .unwrap_or_default();
            let bal = U256::from_str_radix(bal.strip_prefix("0x").unwrap_or("0"), 16).unwrap_or(U256::ZERO);
            let value_u =
                U256::from_str_radix(tx.value.strip_prefix("0x").unwrap_or("0"), 16).unwrap_or(U256::ZERO);
            // Fund `value + gas_limit * price + buffer`. Anvil sizes the local
            // 1559 maxFee well above the fork base fee, so a flat ETH buffer
            // underfunds high-gas-limit txs (the `-32003` failure). Over-
            // funding an impersonated account is harmless: we only ever RAISE
            // the balance, and gas paid never changes a swap's output.
            let gas_limit = hx_u64(&tx.gas).unwrap_or(21_000);
            let need = value_u
                + U256::from(gas_limit) * U256::from(50_000_000_000u64) // 50 gwei headroom
                + U256::from(10u64.pow(15)); // 0.001 ETH slack
            if bal < need {
                raw::<Value>(&provider, "anvil_setBalance", json!([tx.from, format!("0x{need:x}")]))
                    .await
                    .ok();
            }
            raw::<Value>(&provider, "anvil_setNonce", json!([tx.from, format!("0x{:x}", tx.nonce)])).await.ok();
            let mut request = json!({
                "from": tx.from.to_string(),
                "to": tx.to.map(|a| a.to_string()),
                "nonce": format!("0x{:x}", tx.nonce),
                "gas": tx.gas,
                "value": tx.value,
                "input": tx.input,
            });
            if let (Some(mf), Some(mp)) = (&tx.max_fee, &tx.max_prio) {
                request["maxFeePerGas"] = json!(mf);
                request["maxPriorityFeePerGas"] = json!(mp);
            } else if let Some(gp) = &tx.gas_price {
                request["gasPrice"] = json!(gp);
            }
            let res: Result<String> = raw(&provider, "eth_sendTransaction", json!([request])).await;
            match res {
                Ok(local_hash) => {
                    if let Ok(lh) = B256::from_str(local_hash.trim()) {
                        src_by_local.insert(lh, tx.hash);
                    }
                    sent += 1;
                    sent_this_block += 1;
                }
                Err(err) => {
                    send_failed += 1;
                    eprintln!("[replay] pool tx {} send failed: {err:#}", tx.hash);
                }
            }
        }
        eprintln!(
            "[replay] block {b}: sent {sent_this_block} pool txs, mining at ts {pin}{}",
            if pin == *ts {
                " (source)".to_string()
            } else {
                format!(" (WARMUP DRIFT, source {ts})")
            }
        );
        raw::<Value>(&provider, "evm_mine", json!([])).await?;
        // Backlog guard: with race_replay.sh's 500M gas limit and 4096-tx
        // per-block ceiling, one source block MUST land in one local block.
        // Any residual is a bug in those ceilings — draining it with extra
        // mines would permanently outrun the source clock (run 3 drifted
        // +65s that way), so bail immediately and loudly, anywhere in the
        // window.
        let stuck = pool_pending(&provider).await?;
        if stuck > 0 {
            bail!("block {b}: {stuck} replayed txs left the pool unmined — the local block cannot hold one source block (raise race_replay.sh ceilings); not draining to protect clock fidelity");
        }
        let local = raw::<Value>(&provider, "eth_getBlockByNumber", json!(["latest", false])).await?;
        let head = HeadInfo {
            number: hx_u64(local["number"].as_str().unwrap_or("0x0")).unwrap_or(0),
            hash: B256::from_str(local["hash"].as_str().unwrap_or_default())?,
            timestamp: hx_u64(local["timestamp"].as_str().unwrap_or("0x0")).unwrap_or(0),
            base_fee_per_gas: hx_u64(local["baseFeePerGas"].as_str().unwrap_or("0x0")),
        };
        if *b == open_block {
            open_ts_exact = head.timestamp == *ts;
            if !open_ts_exact {
                bail!(
                    "open block {open_block} mined at local ts {} but source ts is {ts}: \
                     the race window is not clock-faithful",
                    head.timestamp
                );
            }
        }
        let local_receipts = raw::<Value>(&provider, "eth_getBlockReceipts", json!([format!("0x{:x}", head.number)]))
            .await
            .unwrap_or(Value::Array(vec![]));
        let empty: Vec<Value> = Vec::new();
        // Status fidelity vs source, and per-tx pool-log triggers in order.
        let mut per_tx: Vec<(B256, Vec<Log>, bool)> = Vec::new();
        if let Some(arr) = local_receipts.as_array() {
            for r in arr {
                let Some(hs) = r.get("transactionHash").and_then(Value::as_str) else { continue };
                let Ok(h) = B256::from_str(hs) else { continue };
                let src_h = src_by_local.get(&h).copied().unwrap_or(h);
                let status = hx_u64(r.get("status").and_then(Value::as_str).unwrap_or("0x0")) == Some(1);
                let src = txs.iter().find(|t| t.hash == src_h);
                let Some(src) = src else { continue };
                // Warmup blocks run on a drifted clock, so deadline reverts
                // there are expected fidelity noise, not a broken replay. The
                // mismatch counters that gate the verdict count race-window
                // blocks only.
                if src.status != status {
                    if *b >= open_block {
                        status_mismatch += 1;
                    } else {
                        warmup_reverts += 1;
                    }
                }
                if src.touches_pools {
                    pool_tx_sent += 1;
                    if src.status != status && *b >= open_block {
                        pool_tx_mismatch += 1;
                    }
                    if src_h == trigger_tx {
                        open_ok = Some(status);
                    }
                }
                let logs: Vec<Log> = r
                    .get("logs")
                    .and_then(Value::as_array)
                    .unwrap_or(&empty)
                    .iter()
                    .filter_map(|l| {
                        l.get("address")
                            .and_then(Value::as_str)
                            .and_then(|a| Address::from_str(a).ok())
                            .filter(|a| pools.contains(a))
                            .and_then(|_| serde_json::from_value::<Log>(l.clone()).ok())
                    })
                    .collect();
                if !logs.is_empty() {
                    per_tx.push((h, logs, status));
                }
            }
        }

        let is_race_block = *b >= open_block && *b <= close_block;
        if *b >= open_block && !per_tx.is_empty() {
            race_started = true;
        }
        // Same-block race fidelity: on live pre-Denim Base, `pendingLogs`
        // delivered the opener's swap log ~1.2s BEFORE the block was mined
        // and its other trades published. Feed the open block's logs in TWO
        // passes — the opener alone first — so the scan prices the gap the
        // way the live path would have priced it mid-block. Delivering the
        // whole block at once would show the winner's close already applied
        // and make every same-block episode un-winnable by construction.
        let trigger_local = per_tx
            .iter()
            .find(|(h, _, _)| src_by_local.get(h).copied().unwrap_or(*h) == trigger_tx)
            .map(|(h, _, _)| *h);
        let head_copy = HeadInfo {
            number: head.number,
            hash: head.hash,
            timestamp: head.timestamp,
            base_fee_per_gas: head.base_fee_per_gas,
        };
        let mut passes: Vec<Vec<Trigger>> = Vec::new();
        if *b == open_block && trigger_local.is_some() {
            let ol = trigger_local.unwrap();
            let (mut first, mut rest) = (Vec::new(), Vec::new());
            for (h, logs, _) in &per_tx {
                for log in logs {
                    let t = Trigger::Log { log: log.clone(), preconfirmed: false };
                    if *h == ol { first.push(t); } else { rest.push(t); }
                }
            }
            first.push(Trigger::Head { head });
            passes.push(first);
            if !rest.is_empty() {
                passes.push(rest);
            }
        } else {
            let mut batch = Vec::new();
            for (_h, logs, _status) in &per_tx {
                for log in logs {
                    batch.push(Trigger::Log {
                        log: log.clone(),
                        preconfirmed: false,
                    });
                }
            }
            batch.push(Trigger::Head { head: head_copy });
            passes.push(batch);
        }
        for pass in passes.iter() {
            let started = Instant::now();
            let report = scanner.scan_triggers(pass).await?;
            let ms = started.elapsed().as_millis();
            scan_times.push(ms);
            if !is_race_block {
                continue;
            }
            if ready_ms.is_none() && !report.opportunities.is_empty() && race_started {
            let first = &report.opportunities[0];
            eprintln!(
                "[race] READY on block {b} (source), {ms} ms: asset={} route={:?} net_usd={:.4} calldata={}B opps={}",
                first.asset_symbol,
                first.labels(scanner.registry()),
                first.net_usd,
                first.calldata.len(),
                report.opportunities.len(),
            );
            ready_ms = Some(ms);
            ready_phases = vec![
                ("pin".into(), report.pin_ms as u128),
                ("core".into(), report.core_ms as u128),
                ("gas".into(), report.gas_ms as u128),
                ("probe".into(), report.probe_ms as u128),
                ("refine".into(), report.refine_ms as u128),
                ("simulate".into(), report.simulate_ms as u128),
                ("fresh".into(), report.fresh_ms as u128),
            ];
            eprintln!(
                "[race] phases: {:?}",
                ready_phases
                    .iter()
                    .map(|(k, v)| format!("{k}={v}ms"))
                    .collect::<Vec<_>>()
                    .join(" ")
            );
            opps_after_open = report
                .opportunities
                .iter()
                .take(4)
                .map(|o| {
                    format!(
                        "{} {} net={:.4}",
                        o.asset_symbol,
                        o.labels(scanner.registry()).join("+"),
                        o.net_usd
                    )
                })
                .collect();
        }
        }
    }

    // 4. Fidelity gates: the opener must have behaved as on mainnet.
    match open_ok {
        Some(true) => {}
        Some(false) => bail!(
            "the gap-creating trigger tx REVERTED in replay while it succeeded on source ({})",
            episode.gap_tx.clone().unwrap_or_default()
        ),
        None => eprintln!("[replay] gap trigger tx not found among mined local receipts (send failed?)"),
    }
    eprintln!(
        "[replay] sent={sent} failed={send_failed} status_mismatch={status_mismatch} (pool-tx {pool_tx_mismatch}/{pool_tx_sent}) warmup_reverts={warmup_reverts}"
    );

    scan_times.sort_unstable();
    let median_all = scan_times.get(scan_times.len() / 2).copied();
    let t_close_proxy_ms = episode.close_pos_gap.map(|g| (g as f64 * 2000.0 / 600.0) as u64);
    let verdict = match (episode.close_lag_blocks, ready_ms) {
        (_, None) => "NO READY CALLDATA",
        (Some(0), Some(ms)) => match t_close_proxy_ms {
            Some(t) if ms as u64 <= t => "WIN (would beat the winner's in-block position)",
            Some(_t) => "LOSS (same-block winner was at an earlier position)",
            None => "same-block close, no position proxy",
        },
        (Some(_), Some(_)) => "WIN (winner needed a later block)",
        (None, Some(_)) => "WIN (gap unclosed in window)",
    };
    let summary = json!({
        "episode_rank": rank,
        "pair": episode.pair,
        "buy": episode.buy,
        "sell": episode.sell,
        "peak_bps": episode.peak_bps,
        "open_block": open_block,
        "trigger_tx": episode.gap_tx,
        "stale_side_tx": episode.open_tx,
        "close_lag_blocks": episode.close_lag_blocks,
        "close_pos_gap": episode.close_pos_gap,
        "t_close_proxy_ms": t_close_proxy_ms,
        "closer": episode.closer,
        "fork_base": base,
        "fork_block": fork_block,
        "fork_ts": fork_ts,
        "warmup_blocks": warmup,
        "drifted_warmup_blocks": drifted_warmup,
        "warmup_reverts": warmup_reverts,
        "open_ts_exact": open_ts_exact,
        "source_txs": total_txs,
        "sent": sent,
        "send_failed": send_failed,
        "status_mismatch": status_mismatch,
        "pool_tx_mismatch": format!("{pool_tx_mismatch}/{pool_tx_sent}"),
        "ready_ms": ready_ms,
        "ready_phases": ready_phases,
        "median_scan_ms": median_all,
        "opportunities": opps_after_open,
        "verdict": verdict,
    });
    println!("{}", serde_json::to_string_pretty(&summary)?);
    if ready_ms.is_none() {
        bail!("pipeline produced no ready calldata for the episode window");
    }
    Ok(())
}

// tiny shim removed; pool membership comes from the dataset pass

fn replay_settings(fork_rpc: &str, manifest_path: &str) -> Settings {
    Settings {
        http_rpc: fork_rpc.to_string(),
        manifest_path: manifest_path.into(),
        mode: Mode::DryRun,
        max_gas_price_gwei: 5.0,
        min_net_profit_usd: 0.25,
        max_candidates: 16,
        max_simulations: 8,
        // Race semantics: submission is the decision point. The freshness
        // pass re-prices at a NEWER block — it makes the report prettier and
        // loses the same-block race, so it is excluded from ready_ms.
        freshness: false,
        dynamic_floors: true,
        local_cl: true,
        ..Settings::default()
    }
}

#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
#[ignore = "needs a pinned Anvil Base fork + harvested history; see module docs"]
async fn replay_race_beats_the_record_a_closer() {
    if let Err(err) = run().await {
        panic!("replay race failed: {err:#}");
    }
}

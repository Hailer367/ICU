//! Fork integration test for the failed-sim cache (feature 4).
//!
//! Two consecutive full scans of a quiet fork must produce the same candidate
//! set. The second scan is only allowed to skip simulations whose outcome is
//! provably unchanged (no new pool events for any leg) — and must never hide a
//! winner the first scan found.
//!
//! Run with a local Anvil Base fork:
//!
//! ```text
//! RYO_FORK_RPC=http://127.0.0.1:8545 \
//!   cargo test --test fork_simcache -- --ignored --nocapture
//! ```

use alloy::primitives::U256;
use anyhow::{Context, Result};
use ryo_watch::chain::{self, ChainProvider};
use ryo_watch::config::{Manifest, Settings};
use ryo_watch::events::Trigger;
use ryo_watch::scanner::{Opportunity, ScanReport, Scanner};

fn fork_rpc() -> String {
    std::env::var("RYO_FORK_RPC").unwrap_or_else(|_| "http://127.0.0.1:8545".to_string())
}

fn manifest_path() -> String {
    std::env::var("RYO_FORK_MANIFEST").unwrap_or_else(|_| "deployments/8453.anvil.json".to_string())
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
        "first scan simulated nothing; the fork state cannot exercise the cache"
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
    if let Err(err) = run(&provider).await {
        panic!("failed-sim cache scenario failed: {err:#}");
    }
}

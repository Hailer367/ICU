# Ryo Watcher — Development State

Last updated: 2026-10-31 (scan-path speed overhaul; see §0h)

This file is written so that a fresh session can resume the watcher without
re-reading the whole chat. It records what exists, what was tested, what is
still open, and the exact commands used.

---

## 0. Session update — 2026-10-30

This session continued the Rust watcher (language and event-driven design
unchanged). It did **not** enable transaction sending.

Implemented and unit-tested:

- Fixed `EventStream` first-connect behaviour: the first successful connection
  is no longer reported as `Reconnect`.
- Fixed subscription-ack mapping across reconnects. Request ids keep increasing
  (`4,5,6, ...`), so the old `id - 1` lookup silently mapped later acks to the
  wrong subscription kind. Acks are now tracked per connection.
- Multiple subscription notifications in one WebSocket frame are queued instead
  of dropping all but the first. The queue is bounded (512); overflow forces one
  full rescan instead of growing without limit.
- Removed (`removed: true`) logs now force a full rescan. `newHeads` no longer
  triggers a full scan on every block (that was effectively polling); it is a
  liveness hint only.
- Added `newFlashblocks` alongside `newFlashblockTransactions` for the
  `flashblocks` source.
- Added duplicate-trigger suppression (`tx hash + log index`, and flashblock
  hash sets) so `both` mode does not scan the same event twice.
- Added a 2-second gas/ETH-USD cache for trigger bursts.
- Route enumeration is cached per asset at scanner construction.
- Quote batches now deduplicate identical calls, use chunks of 80, and run up to
  three chunks concurrently. This targets scan latency.
- `eth_estimateGas` now estimates from `manifest.operator`. The old zero-address
  sender made `execute` revert with `NotOperator`, so every opportunity silently
  used the fallback gas number.
- `plan` now enforces the watcher gas ceiling and `min_net_profit_usd`, not only
  the core's on-chain ceiling.
- New CLI settings: `--max-simulations` (`RYO_MAX_SIMULATIONS`),
  `--probe-usd` (`RYO_PROBE_USD`), and `watch --show-empty`,
  `watch --no-scan`, `watch --metrics-every`.
- `scan --pending` now also applies to a full scan (previously it only applied
  when `--pools` was passed).
- Added `Watcher/tests/events_ws.rs`, an in-process mock-WebSocket integration
  test covering first connect, queued frames, reconnect, and ack-id mapping
  across reconnects.

Local verification this session:

- `cargo test`: 27 lib tests + 1 WebSocket integration test pass.
- `cargo clippy --all-targets`: clean (after formatting).
- Foundry 1.8.7 installed locally; `ryo` dependencies installed and contracts
  built successfully.
- Anvil Base fork deployed with the standard `Deploy.s.sol` command.
- `validate`, `quote`, and `simulate` passed on the fork.
- A full pre-optimisation `scan` completed end-to-end:
  `264 routes, 1582 quotes, 0 simulations, 0 opportunities` in ~1m47s against
  a cold Anvil fork. The quote dedupe/concurrency changes above are intended to
  cut this; re-measure before drawing conclusions.

Not done in this session (later completed in §0g): live Alchemy WebSocket
test, a profitable-route fork scenario after the batching changes, the
manifest writer, and transaction sending.

### 0b. Continuation later on 2026-10-30

The watcher was then exercised end-to-end against a profitable fork scenario and
the contract/deploy backlog items were implemented.

Watcher changes:

- **Profit ranking fixed.** `update_best` ranked routes by output/input *ratio*,
  which favours tiny trades (a 1 wei round trip can have a great ratio). It now
  ranks by absolute profit in asset units. This was the reason a real
  `$12.50` WETH opportunity was ranked below a `$0.51` one.
- Added a `simulation economics` debug line (route, amount, profit, gas, net) so
  filtered opportunities can be explained without re-running.
- `min_net_profit_usd` is now the single gate (previously a separate
  `net_usd <= 0` check plus the settings gate).

Verification:

- Foundry suite: **122 tests pass**, including the 14 Base fork tests.
- New fork integration test `tests/fork_opportunity.rs` (ignored, env-gated):
  impersonates the Balancer vault, swaps 60,000 USDC into UniV3 0.05%, asserts
  the scanner reports an opportunity, and — with `RYO_FORK_EXECUTE=1` — sends
  the built calldata and asserts realized profit equals simulated profit.
  Ran green three times; the test snapshots and reverts the fork.
- Manual `plan` + `cast send` on a skewed fork: `execute` succeeded, `Executed`
  was emitted, and the recipient received exactly the simulated
  `5,630,906,016,821,367` WETH wei.
- Full scan on a **cold** fork: 1m47s (dominated by Anvil fetching missing
  state from the upstream RPC). Same scan on a **warm** fork: **0.6s** for
  264 routes / 1584 quotes. The watcher itself is no longer the bottleneck.

Contract/deploy changes:

- `ryo/script/Deploy.s.sol` now writes the watcher manifest
  (`MANIFEST_PATH`, default `../Watcher/deployments/<chainId>.json`,
  `SKIP_MANIFEST=true` to disable). Shape matches `Watcher::Manifest`; every
  `uint256` is a decimal string. `ryo/foundry.toml` grants write access to
  `../Watcher/deployments`.
- `RyoCore.renounceOwnership()` now always reverts with
  `OwnershipRenunciationDisabled`; renouncing would brick pause/adapters/caps/
  operator rotation. Two-step transfer still works (3 new tests).
- Added `Watcher/README.md` and `Watcher/deployments/8453.example.json`.

Transaction sending remains intentionally out of scope (live WebSocket
verification was later completed in §0g).

### 0c. Full review + continuation (2026-10-30)

A later session did a full read-through of every source file, test, manifest,
and doc, then committed and pushed the §0b work that was still uncommitted.

Verified at review time (this machine, Rust 1.99.1):

- `cargo test`: 27 lib tests + 1 WebSocket integration test pass; the fork
  test is `#[ignore]`d as designed.
- `cargo clippy --all-targets`: clean.
- `cargo fmt --all --check`: clean.
- `Watcher/target`: 3.8 GB (the 2.9 GB figure earlier in this file was stale).
- The 1.1 GB `Watcher.tar.gz` at the repo root was deleted and never pushed.

Findings recorded at review time (some fixed in §0d below):

- Adapter `ZeroAddress` / `NotContract` / `ZeroAmount` selectors collide with
  the core's; core is decoded first, so adapter instances are labelled `Core`.
  Cosmetic only.
- `Trigger::addresses()` and `EventStream::source_specs()` have no production
  callers.
- `venues.rs` said "chunks of 40" while the code uses 80.
- `Settings::default()` disagreed with the CLI defaults for
  `min_profit_buffer_bps` (10 vs 50) and `amount_grid_points` (6 vs 5). The
  fork test uses `..Settings::default()`, so it inherited the old values.
- Trigger dedupe marked an event as seen before the scan ran, so a transient
  scan failure suppressed the later mined duplicate of the same log.
- `newHeads` was parsed but had no gap/reorg use: a skipped block was never
  re-scanned.
- The gas-ceiling gate ran after all quoting, wasting RPC work when gas was
  already too high.
- Hash-only flashblock notifications are skipped by design (the payload does
  not identify a pool); `newFlashblockTransactions` is therefore only useful
  if the real endpoint includes logs. Still unverified live.
- `deployments/8453.json` (the CLI default) does not exist until a mainnet
  deployment writes it.

### 0d. Completion pass (2026-10-30, same session)

Fixes applied after the §0c review:

- `Settings::default()` now matches the CLI and README
  (`min_profit_buffer_bps: 50`, `amount_grid_points: 5`), so the fork test no
  longer silently uses different economics from a real run.
- **Head gap / reorg handling.** `Scanner` records the last evaluated block.
  A head that jumps more than one block, or goes backwards, forces one full
  rescan; consecutive heads stay free. This closes the "reorg beyond removed
  logs" item without reintroducing per-block polling.
- **Dedupe is two-phase.** An event is recorded only after `evaluate`
  succeeds. A transient scan failure no longer suppresses the later mined
  duplicate of the same log. Flashblock hash-only events are still skipped
  without being recorded.
- **Gas gate runs before quoting.** The watcher and core gas ceilings are
  checked at the start of each asset scan and shared with `plan`, instead of
  after all Multicall3 work.
- Corrected stale docs: Multicall3 chunk size is 80, target size is 3.8 GB.
- New unit tests: settings defaults, dedupe semantics, head-gap predicate,
  gas ceiling gate.

Verification after the changes:

- `cargo test`: **31 lib tests + 1 WebSocket integration test pass**; the
  fork test remains `#[ignore]`d.
- `cargo clippy --all-targets`: clean.
- `cargo fmt --all --check`: clean.

What is still open, and why:

- **Live Alchemy WebSocket** — resolved in §0g. The user supplied a Base
  endpoint; `logs`, `pendingLogs`, and `newHeads` work. `pendingLogs` delivers
  swap logs ~1 s early, so it is the live trigger source (`pending-logs` or
  `both`). `newFlashblocks` / `newFlashblockTransactions` carry no logs, so a
  flashblock trigger cannot identify a pool.
- **Mainnet deployment manifest** (`deployments/8453.json`) — requires an
  actual deployment transaction and owner/operator keys.
- **Transaction sending** — intentionally out of scope. `--mode live` still
  logs only.
- **Core-state batching** — `paused`, `maxGasPrice`, and per-asset caps are
  read individually. With two assets this is a handful of calls per trigger;
  batching through Multicall3 is an optional latency optimization, not a
  correctness gap.
- **Caching caps** — deliberately not cached; the owner can change them.
  Token decimals/symbols are registry constants and are not read on-chain.
- **Adapter/core selector collision** — adapter `ZeroAddress`, `NotContract`,
  and `ZeroAmount` decode as core errors. Cosmetic only.
- **Per-stage latency metrics** — total scan time and counters exist; split
  quote/simulate timings are not instrumented.

### 0e. Historical swap dataset (2026-10-30, same session)

Added `src/history.rs` and a `history` subcommand so scanner work can be tested
against real Base activity instead of only live/fork snapshots.

- Lists the 12 verified USDC/WETH pools from `Registry::base_usdc_weth()`.
- Queries `eth_getLogs` in chunks (default 500 blocks) and splits a range
  recursively (up to 5 levels, 500 ms pause) when the RPC rejects a result that
  is too large.
- Decodes two event shapes:
  - concentrated liquidity (UniV3, Slipstream):
    `Swap(address,address,int256,int256,uint160,uint128,int24)`
    (topic `0xc42079f9...`), keeping `sqrtPriceX96`, liquidity, and tick;
  - constant product: Uniswap V2
    `Swap(address,uint256,uint256,uint256,uint256,address)` and
    **Solidly/Aerodrome** `Swap(address,address,uint256,uint256,uint256,uint256)`.
    Aerodrome pools do **not** emit the V2 signature (verified on-chain:
    209 Solidly logs vs 0 V2 logs for the volatile pool in the same window),
    so both topic0 values are queried for the group and amount words are
    normalized to `amountIn - amountOut`, matching the V3 sign convention
    (positive = pool received the token).
- Writes one JSON object per swap to JSONL, sorted by `(block, log_index)`,
  skipping `removed` logs. `data/` is git-ignored.

RPC note: `https://mainnet.base.org` rejects `eth_getLogs` with
`{"code":-32011,"message":"request limit reached"}` even for small ranges.
`https://base-rpc.publicnode.com` serves the same queries, so the dataset was
built with:

```bash
cargo run -- --http-rpc https://base-rpc.publicnode.com \
  history --blocks 43200 --chunk 500 --out data/swaps_24h.jsonl
```

Dataset written on 2026-10-30 (`data/swaps_24h.jsonl`, 76,592,413 bytes):

| metric | value |
| --- | --- |
| blocks | 53,255,340 – 53,298,539 (43,200 blocks ≈ 24 h) |
| swaps | 166,623 |
| blocks with ≥1 swap | 36,214 (83.8 %) |
| busiest block | 53,258,575 (147 swaps) |
| time span | 2026-10-29 18:53:47 – 2026-10-30 18:53:45 UTC |
| venues | all 12 (counts below) |

```
univ3:100        73,374     slipstream:100   29,537
univ3:500        30,796     aerodrome:volatile 7,719
univ3:3000       13,216     slipstream:1      7,409
univ2             3,197     univ3:10000         374
aerodrome:stable    586     slipstream:10       285
slipstream:50        93     slipstream:200       37
```

The dataset is a log-only record. Replaying a block still requires historical
state: pin Anvil with `--fork-block-number` and deploy the core to that block
(the manifest written by `Deploy.s.sol` is a starting point). The file is
deliberately not committed; regenerate it with the command above.

Tests added with the module (36 lib tests then; 37 after the replay fix below):
V3 decode, V2 decode, int24 sign extension, unknown-pool/short-data rejection,
and a group test asserting the constant-product query covers both the V2 and
Solidly topics and includes an Aerodrome pool. The replay fix added a pure
`is_stale` test.

Replay verification against the dataset (same session):

- Forked Anvil at **53,258,575** (the busiest dataset block, 147 swaps) via
  `https://mainnet.base.org` (publicnode serves storage at that block but
  rejects archive `eth_feeHistory` with "Archive requests require a personal
  token", which breaks deployment), then ran `Deploy.s.sol` onto the fork and
  `validate` → 12 pools OK.
- **Price cross-check:** the last `univ3:500` swap in that block implies
  2,277.10 USDC/WETH from `sqrtPriceX96`; the fork quote for 1,000 USDC →
  WETH → USDC executed leg 1 at 2,278.32 USDC/WETH. The 0.05% pool fee
  explains the 0.05% difference, confirming the dataset decodes the same state
  the chain serves.
- **Blocker found and fixed:** the full `scan` first aborted with
  "ETH/USD feed unavailable" because Chainlink `updatedAt` was compared to the
  host clock — a 22 h-old fork looked stale. Staleness now uses the latest
  block timestamp (`GasSnapshot.timestamp`, `gas::latest_timestamp`), which is
  correct for live runs too. After the fix, `scan` at that block completed:
  **264 routes, 1,624 quotes, 4 simulations, 0 opportunities** (the 4
  pre-gas-profitable routes did not clear the net threshold). `gas` on live
  mainnet still reports ETH/USD normally after the change.
- The manifest produced by the fork deploy was restored to the checked-in
  `deployments/8453.anvil.json` afterwards.

Replay recipe:

```bash
anvil --fork-url https://mainnet.base.org --fork-block-number 53258575 \
  --chain-id 8453 --port 8545
# from ryo/: deploy with MANIFEST_PATH=../Watcher/deployments/8453.anvil.json
cargo run -- --http-rpc http://127.0.0.1:8545 \
  --manifest deployments/8453.anvil.json --max-gas-price-gwei 3 scan
```

### 0f. Swap-size trigger filter (2026-10-30, same session)

The 24h dataset showed most trigger traffic is dust: 40 % of swaps are under
$50, 78 % under $500, 86 % under $1,000. A simple model (closable edge ≈
½ × price move × swap size) puts only ~5 % of swaps above the $0.25 profit
threshold, and 99 % of those are ≥ $500.

- **Hard floor $45** (`ABSOLUTE_MIN_SWAP_USD`): at ~0.56 % round-trip cost
  (pool fees + profit buffer), $0.25 needs ~$45 of notional; smaller swaps
  cannot pay for a scan regardless of configuration.
- **`--min-swap-usd` / `RYO_MIN_SWAP_USD`, default 500**: swaps below this USD
  notional are skipped before quoting (effective floor is
  `max(configured, 45)`). A $500 default removes ~78 % of trigger scans and
  loses ~0.7 % of the estimated ≥ $0.25 events.
- **Only decodable `Swap` logs are filtered.** Notional comes from the USDC
  leg, so no ETH price fetch is needed. Non-swap pool events (Mint/Burn/
  Collect) stay unfiltered, as do logs whose pool is unknown.
- `history::swap_deltas` now checks topic0 against the V3/V2/Solidly swap
  signatures before decoding; previously a V3 Mint (five data words) could be
  mis-decoded as a swap.
- **Registry token order corrected.** All 12 pools list WETH as `token0` and
  USDC as `token1` on-chain (verified for every pool). The registry had them
  reversed. Quoting was unaffected (routers read the pool's own order), but
  amount decoding now depends on the correct mapping.
- **Head marker fix.** `last_block` advanced only inside `evaluate`, so in idle
  stretches consecutive `newHeads` looked like gaps and forced a full rescan
  every other block — effectively 2-block polling, and much worse once dust
  filtering made idle periods common. Every head now advances the marker; only
  a real jump or a backwards head triggers the gap rescan.

Tests: 44 lib tests + 1 WS test pass (`swap_size_filter_has_a_hard_floor`,
`rejects_non_swap_events`, and five notional tests: USDC-leg reading, Solidly
signed deltas, dust vs. large, non-USDC pool, non-swap log). Clippy/fmt clean.

### 0g. Live Alchemy WebSocket test (2026-10-30, same session)

Ran the watcher against the user's Alchemy Base endpoint (key inline in the
environment only; never written to a file or the repo).

Subscription support and payloads:

- `logs` (mined) — works; pool swaps arrive as normal log objects.
- `pendingLogs` — works, and delivers the swap log roughly 1 s before the
  block lands. This is the useful preconfirmation signal.
- `newFlashblocks` — **returns a preconfirmed block object with transactions
  but no `logs` field**; `newFlashblockTransactions` returns a single tx hash
  per message. Neither can identify which pool traded, so a flashblock trigger
  carries no pool information and the scanner skips it. `newHeads` also
  subscribed; heads are only used for gap detection.
- Therefore `--source pending-logs` (default) or `both` is the working live
  configuration; `flashblocks` alone cannot produce scans with Alchemy's
  current Base API.

Full scan loop against live events (local Anvil fork of Base at the latest
block, core + adapters deployed from `script/Deploy.s.sol`, fork manifest in
`deployments/8453.fork.json`, deleted afterwards):

- Unskewed run: 120 live triggers, 120 scans, 0 failures, 1,232 routes,
  7,392 quotes, 0 simulations. Real markets showed no positive edge in the
  sample window.
- Skewed run (60,000 USDC into univ3:500, same method as the fork test):
  100 live triggers, 0 failures, 924 routes, 6,044 quotes, 50 simulations,
  16 opportunities. Best was `univ3:500 -> slipstream:100`, 4 WETH, simulated
  profit $12.01, gas $1.51 (Anvil reports 1 gwei; real Base is ~0.005), net
  $10.50. A $0.227 net near-miss was correctly rejected by the $0.25 gate.
- Dust filter and duplicate suppression both visible in the trigger log
  (e.g. `swap ~$354 below the $500 minimum`, `duplicate trigger skipped`).
- `--mode live` prints the "transaction sending is not enabled" warning and
  sends nothing; every scan was an `eth_call`/quote against the fork.

Anvil reports a synthetic ~1 gwei gas price, so the default 0.05 gwei watcher
ceiling blocks every scan on a fork; use `--max-gas-price-gwei 2` for local
runs. Real Base gas is ~0.005 gwei, which passes the default.

### 0h. Scan-path speed overhaul (2026-10-31)

This session made the event-triggered scan path faster without touching any
correctness gate (profit/gas/dust gates, two-phase dedupe, watch single-flight,
`--pending`, and the economics are unchanged). The trigger never polls; each
step only removes sequential RPC round-trips from the work the trigger already
requires. Machine: Rust 1.99.1, Foundry 1.8.x installed locally this session.

Changes, in order:

- **Per-phase timing (new).** `ScanReport` carries `core_ms`, `gas_ms`,
  `probe_ms`, `refine_ms`, `simulate_ms`; `watch` logs running averages
  (`avg_core_ms` … `avg_simulate_ms`) alongside `avg_scan_ms`, and `--json`
  emits a `timingsMs` object. Closes the §6G "per-stage latency metrics" item.
  Note: with the per-asset parallelism below, `probe/refine/simulate_ms` are
  per-asset wall time and the two assets overlap, so they can exceed the scan
  wall time; `avg_scan_ms` is the honest end-to-end number.
- **Multi-amount quote batching (biggest win).** `quote_routes_at_amounts`
  became `quote_jobs(routes, jobs)`, where `jobs` is a list of
  `(route_index, amount_in)`. The probe now quotes every route at every amount
  in **one** leg-walking pass (one multicall per leg across all amounts), and
  refine flattens all factor rounds the same way. Previously the three probe
  amounts and five refine factors each issued their own sequential batch.
  Identical `(target, calldata)` pairs across amounts collapse to one call.
  `update_best_from_jobs` is the ranking fold; iterating the flattened job list
  reproduces the old per-amount / per-factor result exactly (verified by tests).
- **Batched core-state read.** `load_core_state` reads `paused`, `maxGasPrice`,
  and every asset cap in **one** Multicall3 `aggregate3` instead of `2 + N`
  serial `eth_call`s. `paused`/`maxGasPrice` fail closed (bail the scan if
  unreadable); caps stay fail-open (a failed cap reads as zero, disabling that
  asset) — same semantics as before, and all reads now pin a single block.
- **Batched USD feeds.** New `gas::feed_prices` reads every configured asset's
  Chainlink `latestRoundData` in one multicall, with per-feed staleness and
  non-positive bails preserved. The scanner caches each feed's immutable
  `decimals()` once (new `chain::multicall_raw` + `Scanner::feed_decimals`)
  instead of re-reading it per scan, and reuses the ETH/USD price already
  fetched for gas for WETH.
- **Gas snapshot 7 → concurrent.** `gas::snapshot` now runs the latest block,
  `eth_gasPrice`, `eth_maxPriorityFeePerGas`, and the three GasPriceOracle reads
  (as one multicall) concurrently via `tokio::join!` instead of seven sequential
  awaits. `eth_gasPrice` is kept as its own RPC — it is **not** derived as
  base+priority, so the gas ceiling gate and `trade_cost` are unchanged.
- **Parallel asset scans.** USDC and WETH are scanned concurrently
  (`buffered(assets.len().min(4))` — ordered, so report note order is
  deterministic) after the shared gas/core context is resolved.
- **Batch plumbing.** `quote_batch` concurrency 3 → 4 chunks (probe rounds are
  now larger). A whole multicall chunk lost to transport/rate-limit is logged at
  `warn`, so a dropped chunk can no longer look like "no opportunity".

Verification (local Anvil Base fork, core+adapters deployed via
`script/Deploy.s.sol`, manifest `deployments/8453.anvil.json`):

- `cargo test`: **54 lib tests + 1 WebSocket integration test pass** (was 44;
  added: timings, `update_best_from_jobs` absolute-profit/no-cross-contamination/
  skip semantics, merged-vs-sequential quote-count equality, feed map/decode/
  decimals tests). Clippy clean, fmt clean.
- `tests/fork_opportunity.rs` with `RYO_FORK_EXECUTE=1` passes unchanged after
  every step: `routes=44 quotes=412 simulations=6 opportunities=4`, and the
  executed payout equals the simulated profit exactly (6014960213482186 WETH
  wei). This is the end-to-end proof that merging amounts did not corrupt
  per-(route, amount) integrity.
- Warm full-scan latency, local fork (network latency ≈ 0): **~0.90 s → ~0.54 s**
  (`core 1 ms, gas 3–6 ms, probe ~510–545 ms` overlapping across the two assets,
  refine 0, simulate 0). On a cold fork the run is still dominated by Anvil's
  upstream state fetch (~90 s), unchanged. On live high-latency RPC the ~20
  sequential round-trips removed per scan (probe/refine batching, single
  core-state call, batched feeds/decimals, concurrent gas) save far more than
  the local fork shows, because there each round-trip costs milliseconds instead
  of sub-millisecond loopback.

Not done (deferred, unchanged from §0d–§0g): mainnet manifest
(`deployments/8453.json`), transaction sending (still logs only; `--mode live`
warns), live pending `eth_call` against Alchemy HTTP, watch-loop pipelining
(deliberately not added — single-flight with the bounded queue is intended).

---

## 1. Goal and hard constraints

Build a Rust, event-driven arbitrage watcher for `RyoCore` on Base.

Constraints agreed with the user:

- Event-driven only. No constant opportunity polling.
- Fetching fresh quotes/prices after an event is allowed.
- Fast trigger: Alchemy Base WebSocket / Flashblocks.
- Webhooks are only for optional alerts/admin events, not the fast trigger.
- No priority-fee bidding. Use the network minimum/default tip and accept a
  lower win rate.
- Flashblocks only if they add no separate fee. Alchemy still bills bandwidth
  and compute units.
- Do **not** send transactions from the watcher yet. Current build is
  dry-run/paper only.
- Explain technical topics in simple language to the user.

The Alchemy Base `https://` and `wss://` endpoints were supplied and tested on
2026-10-30 (§0g). The key is kept in the environment only; it is not stored in
the repo or any file. HTTP/fork testing still works against public Base RPC and
Anvil.

---

## 2. Repository layout

Repo: `https://github.com/Hailer367/ICU`

Relevant paths:

```
WATCHER_PLAN.md                 design document (already on main)
Watcher/                        Rust crate (this work)
  Cargo.toml                    package `ryo-watch`, Rust 2024
  Cargo.lock                    locked dependency graph
  State.md                      this file
  README.md                     quick start, commands, settings, fork test
  .env.example                  documented environment variables (no secrets)
  .gitignore                    ignores target/, data/, .env, local manifests
  deployments/
    8453.anvil.json             manifest for the local Anvil deployment
    8453.example.json           placeholder manifest showing the expected shape
  data/                         generated swap history (git-ignored)
  src/
    abi.rs                      hand-written sol! bindings
    chain.rs                    Alloy provider + eth_call helpers
    config.rs                   manifest, Base addresses, Settings, Mode, EventSource
    errors.rs                   revert decoding for core/adapters/OZ/routers
    events.rs                   raw WebSocket event stream + trigger parser
    gas.rs                      gas snapshot, L1 fee, Chainlink USD, cost math
    history.rs                  historical Swap log downloader (JSONL)
    lib.rs                      module exports
    main.rs                     CLI (validate/gas/routes/quote/simulate/plan/scan/watch/history/decode)
    routes.rs                   pool registry, cycle enumeration, route parser
    scanner.rs                  event-driven affected-pool scanning + simulation
    simulate.rs                 core.simulate call and decode
    venues.rs                   per-venue quote encoding, decoding, Multicall3 batches
  tests/
    events_ws.rs                mock-WebSocket reconnect/queue/ack integration test
    fork_opportunity.rs         ignored Anvil-fork end-to-end arb test
  target/                       build output (exclude from zip)
```

`Watcher/target` is ~3.8 GB. Never commit or zip it. A 1.1 GB
`Watcher.tar.gz` created by an earlier session was deleted on 2026-10-30 and
was never pushed.

---

## 3. Dependencies

`Cargo.toml`:

- `alloy = { version = "2.5.0", features = ["full", "json-rpc"] }`
- `tokio = { version = "1.54.1", features = ["full"] }`
- `tokio-tungstenite = { version = "0.30.0", features = ["rustls-tls-webpki-roots"] }`
- `futures-util = "0.3.31"`
- `clap = { version = "4.6.7", features = ["derive", "env"] }`
- `serde`, `serde_json`, `anyhow`, `thiserror`, `tracing`,
  `tracing-subscriber`, `dotenvy`, `chrono`, `async-trait`
- dev: `tempfile`

Rust: 1.99.1. Foundry: 1.8.6. Machine: 4 cores, 15 GB RAM.

---

## 4. Module details

### `src/abi.rs`

Hand-written `sol!` definitions:

- `ryo`: `Step`, `execute`, `simulate`, views (`owner`, `pendingOwner`,
  `operator`, `profitRecipient`, `vault`, `paused`, `isAdapter`,
  `maxTradeSize`, `maxGasPrice`, `VERSION`, `MAX_STEPS`), errors, events.
- `erc20`, `pool` (`token0`/`token1`), `univ3_quoter`,
  `slipstream_quoter`, `univ2_router`, `aerodrome_router`,
  `gas_oracle`, `chainlink`, `balancer_vault`, factories, `multicall3`.

Important Alloy mapping details:

- `uint24` -> `alloy::primitives::aliases::U24`
- `int24` -> `alloy::primitives::aliases::I24`
- `uint160` -> `alloy::primitives::aliases::U160`
- `sol!` structs already derive `Clone`/`Debug`; do not add those derives.
- `abi_decode_returns` takes **one** argument in alloy-sol-types 1.7.3.
- Single return values decode to the raw type; named multiple returns decode
  to a generated struct.
- `aggregate3` with a single named return decodes to `Vec<Result3>` directly.

### `src/config.rs`

- `Manifest` mirrors the future deployment JSON. `uint256` values are decimal
  strings. `validate()` enforces chain 8453, version 1, non-zero core/vault/
  owner/operator/recipient, non-zero adapters/routers/tokens, parseable caps
  and `maxGasPrice`.
- `Settings` holds runtime knobs: RPC URLs, mode, source, profit/gas gates,
  slippage, buffer, grid points, candidates, hops, asset symbols, fallback gas,
  probe USD amounts, and the swap-size filter (`min_swap_usd`, default 500).
- `Mode`: `dry-run`, `paper`, `live` (clap `ValueEnum`).
- `EventSource`: `logs`, `pending-logs`, `flashblocks`, `both`, `once`.
- `base`: verified Base mainnet constants (see section 7).

### `src/errors.rs`

- Computes selectors with `keccak256`.
- Decodes `SimulationResult(int256)`, `Error(string)`, `Panic(uint256)`.
- Decodes `RyoCore` errors, adapter errors, OpenZeppelin errors.
- `revert_data_from_payload` walks provider JSON (`data`, `result`,
  `returnData`, `originalError`, nested strings).
- Unit tests cover selectors and several payloads.

### `src/chain.rs`

- `ChainProvider = DynProvider` (type-erased Alloy provider).
- `connect`, `connect_http`.
- `eth_call(provider, to, data, BlockId) -> Result<Bytes, CallError>`.
  `CallError::Revert(Bytes)` vs `CallError::Transport(String)`.
- `eth_call_u256/u8/bool`, `erc20_balance/decimals/symbol`,
  `block_number`, `chain_id`, `gas_price`, `code_at`, `balance_of`,
  `estimate_gas`.
- `multicall_raw(provider, calls, block)` (§0h): one `aggregate3` over
  heterogeneous `(target, calldata)` reads, returning raw bytes per call with
  whole-batch vs per-call failure distinguished. Used by the batched core-state
  read, feed reads, and gas-snapshot oracle reads.

### `src/events.rs`

Raw JSON-RPC WebSocket client because Alchemy exposes custom subscription
names (`pendingLogs`, `newFlashblockTransactions`) that Alloy’s typed
`subscribe_logs` does not.

- `EventStream::new(url, source, pools)`.
- Subscriptions:
  - `logs` + filter `{address:[pools]}`
  - `pendingLogs` + same filter
  - `newFlashblockTransactions`
  - `newFlashblocks` (full payload; logs are extracted if present)
  - `newHeads`
- Reconnects with 1s..30s exponential backoff; 20s ping.
- Per-connection subscription-id table; acks are mapped to the request that
  created them even after `next_id` has advanced across reconnects.
- Bounded trigger queue (512). Multiple notifications in one frame are kept.
  Overflow clears the queue and emits `Reconnect`, forcing one fresh scan.
- Emits `Trigger`:
  - `Log { log, preconfirmed }`; a `removed` log becomes `Reconnect`
  - `Flashblock { hashes, logs }`
  - `Head { number }` (liveness only; scanner does not scan on head)
  - `Reconnect`
- `Trigger::addresses()` and `label()`.
- `redact_url()` hides API keys in logs.
- Unit tests cover subscription params, log parsing, flashblock hash
  extraction, URL redaction.
- `tests/events_ws.rs` runs a local mock server and covers first connect,
  multi-notification frames, reconnect, and post-reconnect ack mapping.

**Verified live (2026-10-30, §0g):** against the real Alchemy endpoint,
`logs`, `pendingLogs`, and `newHeads` subscribe and deliver the expected
payloads; `pendingLogs` carries full pool logs ~1 s before the block.
`newFlashblocks` returns a preconfirmed block object with transactions but no
`logs` field, and `newFlashblockTransactions` returns a bare transaction hash:
neither identifies a pool, so flashblock triggers are skipped. Reconnect
against the live endpoint was not exercised (the mock test covers it).

### `src/gas.rs`

- `snapshot(provider, tx_size)`: block number/timestamp/base fee (one latest
  block), `eth_gasPrice`, `eth_maxPriorityFeePerGas`, and the three L1 oracle
  reads (as one multicall) — fetched concurrently via `tokio::join!` (§0h).
- `chainlink_price(provider, feed, max_age_secs, now_secs)`;
  `latest_timestamp(provider)`; `is_stale(updated_at, now, max_age)`.
- §0h: `usd_feed_for_asset(asset) -> Option<(feed, max_age)>`,
  `feed_price_from_round(...)` (pure decode + staleness/sign bails), and
  `feed_prices(provider, requests, now, decimals)` (batched `latestRoundData`).
- Staleness is measured against the latest **block timestamp**, not the local
  clock, so a historical fork judges feeds as of its fork point.
- `asset_usd_price(provider, asset, now_secs)`: USDC/EURC 24h staleness,
  WETH/cbBTC 2h.
- `trade_cost(gas_used, effective_gas_price, l1_fee, eth_usd)`.
- `profit_usd`, `raw_to_f64`, `wei_to_eth`.

### `src/routes.rs`

- `Venue`: `UniV2`, `UniV3{fee}`, `Aerodrome{stable}`,
  `Slipstream{tick_spacing}`.
- `Venue::data()` encodes adapter-specific bytes (empty for UniV2, 32-byte
  word for fee/stable/tick spacing).
- `Registry::base_usdc_weth()`: **12 verified pools** (see section 7). Pools
  declare the chain order, WETH first and USDC second.
- `enumerate_cycles(registry, asset, max_hops)` with pool/token reuse rules.
- `parse_route(registry, asset, "univ3:500,univ3:100")`.
- `Route::to_steps(manifest, floors)` and `route_hash(manifest, floors)`.
- `route_hash` = `keccak256(abi.encode(VERSION, steps))`; use
  `(U256::from(1), steps).abi_encode()` (a bare `u8` is not `SolValue`).

### `src/venues.rs`

- `encode_quote_call` / `decode_quote_result`.
- `quote_step` / `quote_route`.
- `QuoteRequest` + `quote_batch` using Multicall3 `aggregate3`
  (`allowFailure = true`, chunks of 80, up to four chunks concurrently; §0h).
- UniV2/Aerodrome return `uint256[]`; UniV3/Slipstream return a tuple.

### `src/simulate.rs`

- `simulate(provider, core, asset, amount, steps, BlockId)`.
- `simulate` always reverts. `SimulationResult(int256)` means success.
- Discovery floors must be non-zero; use `1`.
- `discovery_steps(route, manifest)` builds floors of 1.
- `SimulateError` distinguishes revert/transport/unexpected success.
- `#[allow(clippy::result_large_err)]` on `simulate`.

### `src/history.rs`

- `download(provider, registry, from_block, to_block, chunk, out)` writes
  sorted JSONL and returns `HistorySummary` (range, total, per-venue counts,
  bytes).
- `decode_swap(log, concentrated, registry)` → `SwapRecord` with `block`,
  optional `timestamp`/`tx_hash`, `log_index`, `pool`, `venue`, `sender`,
  `recipient`, signed `amount0`/`amount1`, and (concentrated only)
  `sqrt_price_x96`, `liquidity`, `tick`.
- Groups: concentrated pools query the V3 topic; Uniswap V2 and Aerodrome
  query their own V2/Solidly topics in one request.
- Failed `eth_getLogs` ranges split recursively (5 levels) instead of aborting.

### `src/scanner.rs`

- `Scanner::new(provider, manifest, settings)`.
- `scan_once()`, `scan_once_with(block)`, `scan_trigger(&Trigger)`,
  `evaluate(affected, block)`.
- `plan(route, amount)` for the CLI; enforces watcher gas ceiling, core gas
  ceiling, and `min_net_profit_usd`.
- Routes are enumerated once per asset at construction.
- `scan_trigger` drops duplicate `(tx hash, log index)` events and duplicate
  flashblock hash sets.
- Swap triggers below `max(min_swap_usd, $45)` USD notional return before any
  quoting; non-swap logs are not size-filtered.
- Every `newHeads` tick advances the last-seen block marker; only a forward
  jump or a backwards head forces a full rescan.
- Reads core `paused`, `maxGasPrice`, `maxTradeSize(asset)` — all in **one**
  Multicall3 batch (§0h); `paused`/`maxGasPrice` unreadable fail closed, a
  failed cap decodes to zero (that asset disabled).
- Resolves caps as `min(manifest cap, core cap)`, skips zero caps.
- Event filter: only routes containing affected pool indices.
- If a flashblock has no known pool logs, it skips instead of scanning all.
- Asset USD prices are fetched once per scan via `gas::feed_prices` (§0h),
  reusing the ETH/USD price already read for gas; feed `decimals()` are cached
  per scanner.
- Assets are scanned concurrently after the shared context (`buffered` in
  `assets` order, so note order stays deterministic; §0h).
- Probe: every candidate route at every `probe_amounts_usd` (CLI `--probe-usd`,
  default `[500, 2000, 8000]`) quoted in **one** leg-walking batch, then refine
  on factors flattened the same way (§0h; was one sequential batch per amount /
  per factor).
- Ranking uses **absolute profit** (`output - amount` in asset units), not
  output/input ratio. Ratio favoured 1 wei trades and pushed the most
  profitable size out of the simulator's top list.
- Refine top `max_candidates` on factors `[0.5, 0.75, 1.0, 1.5, 2.0]`,
  truncated by `amount_grid_points`; the best absolute profit is kept.
- Simulate top `min(max_candidates, max_simulations)` concurrently (buffer 4).
- `eth_estimateGas` uses `manifest.operator` as the sender.
- Gas snapshot + ETH/USD is cached for 2 seconds to smooth event bursts.
- Builds execution floors with `per_leg_slippage_bps`, `minProfit` with
  `min_profit_buffer_bps`, calldata, route hash, gas estimate.
- Gates on:
  - core not paused
  - gas price <= watcher ceiling
  - gas price <= core `maxGasPrice` (if non-zero)
  - positive simulated profit
  - `net_usd >= min_net_profit_usd`
- `ScanReport` includes block, affected pools, routes/quotes/simulations,
  notes, and opportunities, plus §0h per-phase milliseconds (`core_ms`,
  `gas_ms`, `probe_ms`, `refine_ms`, `simulate_ms`); `watch --json` emits them
  under `timingsMs` and the metrics line logs running averages.

### `src/main.rs` (CLI)

Commands:

```
validate
gas
routes --asset USDC
quote  --asset USDC --amount 1000 --route univ3:500,univ3:100
simulate --asset USDC --amount 1000 --route univ3:500,univ3:100
plan   --asset USDC --amount 1000 --route univ3:500,univ3:100
scan   [--pools 0,1] [--pending] [--json]
watch  [--max-events N] [--json] [--show-empty] [--no-scan] [--metrics-every N]
history [--blocks 43200] [--from-block N] [--to-block N] [--chunk 500] [--out data/swaps.jsonl]
decode 0x...
```

Global options and env vars:

```
--http-rpc       RYO_HTTP_RPC
--ws-rpc         RYO_WS_RPC
--manifest       RYO_MANIFEST
--mode           RYO_MODE
--source         RYO_SOURCE
--min-net-profit-usd  RYO_MIN_NET_PROFIT_USD
--max-gas-price-gwei  RYO_MAX_GAS_PRICE_GWEI
--per-leg-slippage-bps RYO_SLIPPAGE_BPS
--min-profit-buffer-bps RYO_PROFIT_BUFFER_BPS
--grid-points    RYO_GRID_POINTS
--max-candidates RYO_MAX_CANDIDATES
--max-simulations RYO_MAX_SIMULATIONS
--probe-usd      RYO_PROBE_USD
--min-swap-usd   RYO_MIN_SWAP_USD
--max-hops       RYO_MAX_HOPS
--assets         RYO_ASSETS
--fallback-gas   RYO_FALLBACK_GAS
```

`watch` currently **logs opportunities only**. In `--mode live` it prints a
warning and does not send transactions.

---

## 5. Tests and verification done

### Rust tests

```
cd Watcher
cargo test
```

Result: **54 lib tests + 1 WebSocket integration test passed, 0 failed**
(2026-10-31 §0h; 27 before the completion pass, 31 after it, 36 after the history
module, 37 after the replay staleness fix, 39 after the swap-size filter,
44 after adding notional decoding tests, 54 after the speed-overhaul batch
integrity/decoding tests). `cargo clippy --all-targets` is
clean after fixes.
`tests/events_ws.rs` uses an in-process mock server and needs no network.
`tests/fork_opportunity.rs` is `#[ignore]`d and needs a local Anvil fork; it is
not part of a plain `cargo test`.

Coverage of unit tests:

- selectors and revert decoding
- simulation result positive/negative
- gas cost math
- route enumeration (132 two-hop cycles)
- venue parsing and route parsing
- adapter data encoding
- Multicall `uint256[]` decoding
- event subscription params, log parsing, flashblock extraction, URL redaction
- scanner floor math, USD conversion, amount scaling, affected-route filter
- settings defaults, dedupe semantics, head-gap rescan, gas ceiling gate
- historical swap decoding (V3, V2, Solidly topics, int24 sign)
- Chainlink staleness against chain time (historical fork replay)
- swap-size filter floor, USDC-leg notional decoding (V3 and Solidly), and
  non-swap event rejection
- (§0h) merged quote batching: `update_best_from_jobs` absolute-profit ranking,
  per-(route, amount) no-cross-contamination, zero/failed-job skips, merged vs
  sequential quote-count equality; Chainlink feed mapping, round decoding,
  staleness/sign bails, and decimal scaling

### Live Base HTTP checks

Public RPC `https://mainnet.base.org` worked (chain 8453). Verified:

- UniV3 quoter `0x3d4e44...B76a` returns a quote for 1000 USDC -> WETH.
- Slipstream quoter `0x254cF9...15b0` works; only tick spacing 1 and 100 have
  deep liquidity for USDC/WETH, 10/50/200 are thin.
- UniV2 router, Aerodrome router (factory `0x0` works), factory
  `getPool`/`getPair` addresses match the registry.
- All 12 pool addresses exist and match the expected token pair.
- `gas` command works. Snapshot at test time:
  - base fee `5,000,000` wei (0.005 gwei)
  - priority fee `1,000,000` wei (0.001 gwei)
  - gas price `6,000,000` wei (0.006 gwei)
  - ETH/USD ~`$2334.53`
  - USDC/USD `$0.999737` (chain feed was ~5h old; 24h tolerance added)
  - 450k gas cost ~`$0.00646`

### Anvil Base fork deployment

Anvil fork was started with:

```
anvil --fork-url https://mainnet.base.org --chain-id 8453 --port 8545
```

`forge script` is run from `ryo/` (with Foundry deps installed) and now writes
the watcher manifest itself:

```
PRIVATE_KEY=0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80 \
MAX_GAS_PRICE=3000000000 \
MAX_TRADE_USDC=8000000000 \
MAX_TRADE_WETH=4000000000000000000 \
MANIFEST_PATH=../Watcher/deployments/8453.anvil.json \
forge script script/Deploy.s.sol:Deploy --rpc-url http://127.0.0.1:8545 --broadcast
```

Deployed addresses (also in `deployments/8453.anvil.json`):

```
RyoCore:            0x7Be6E341624D7f730f91CAa7867416D63DbEA219
UniV3Adapter:       0x9eaEb6Ffb89E80A5f7e926ef7cee0831C9348516
UniV2Adapter:       0x5c7e41E0bDc3C406a3c99BC5f03D79e8cABE7Cad
AerodromeAdapter:   0x9EEaBc0705aecfd61dDb488598261EB11e7C2438
SlipstreamAdapter:  0x9Ba9F602B84D46f9c511518520aFb773162A0df3
deployer/owner/operator/recipient: 0xf39Fd6e51aad88F6F4ce6aB8827279cffFb92266
```

Anvil’s priority-fee estimate made gas price ~1 gwei, above the original
50M wei core cap. `setMaxGasPrice(3000000000)` was called on the fork and the
manifest was updated to `3000000000`.

Verified on the fork:

```
cargo run -- --http-rpc http://127.0.0.1:8545 \
  --manifest deployments/8453.anvil.json validate
# OK, 12 pools verified

cargo run -- --http-rpc http://127.0.0.1:8545 \
  --manifest deployments/8453.anvil.json \
  quote --asset USDC --amount 1000 --route univ3:500,univ3:100
# 1000 USDC -> 0.427576284948883526 WETH -> 999.354666 USDC
# ratio 0.99935467

cargo run -- --http-rpc http://127.0.0.1:8545 \
  --manifest deployments/8453.anvil.json \
  simulate --asset USDC --amount 1000 --route univ3:500,univ3:100
# profit: -645334 USDC (loss before gas)

cargo run -- --http-rpc http://127.0.0.1:8545 \
  --manifest deployments/8453.anvil.json \
  plan --asset USDC --amount 1000 --route univ3:500,univ3:100
# route is not profitable after gas
```

`decode` was tested with a `MinProfitNotMet` payload and printed correctly.

### Full scan on the fork

Full scans on the Anvil fork:

```
# cold fork (Anvil fetches missing Base state on demand)
block 53295421 | routes 264 | quotes 1584 | simulations 0 | opportunities 0
real 1m47

# same scan again, state now cached in Anvil
block 53295421 | routes 264 | quotes 1584 | simulations 0 | opportunities 0
real 0m0.646
```

The watcher's own work is sub-second. The cold number is Anvil's upstream
fetch cost, not RPC round-trip count from the watcher; quote batching and
dedupe did their job.

### Profitable-route scenario (proven end-to-end)

Manufactured on the fork by impersonating the Balancer vault and swapping
60,000 USDC into UniV3 0.05%:

```
cast rpc anvil_impersonateAccount 0xBA12222222228d8Ba445958a75a0704d566BF2C8
cast rpc anvil_setBalance 0xBA12222222228d8Ba445958a75a0704d566BF2C8 0x8ac7230489e80000
cast send <USDC> "approve(address,uint256)" <SwapRouter02> 60000000000 --from <vault> --unlocked
cast send <SwapRouter02> "exactInputSingle((address,address,uint24,address,uint256,uint256,uint160))" \
  "(<USDC>,<WETH>,500,<vault>,60000000000,0,0)" --from <vault> --unlocked
```

`scan --pools 1 --min-net-profit-usd 0.05 --max-gas-price-gwei 3` then reported:

```
opportunity asset=WETH net_usd=11.07 profit_usd=12.50 gas_usd=1.43
  venues=["univ3:500", "slipstream:100"]
```

`plan --asset WETH --amount 4 --route univ3:500,slipstream:100` produced
calldata; sending it from the operator with `cast send` succeeded, emitted
`Executed`, and the recipient received exactly `5630906016821367` WETH wei —
the same number `simulate` reported.

### `tests/fork_opportunity.rs`

Same scenario, automated. The test snapshots the fork, impersonates the vault,
does the approval + swap, runs `Scanner::evaluate` on the affected pool,
asserts an opportunity, and with `RYO_FORK_EXECUTE=1` sends the calldata and
asserts `realized == simulated` (exact match observed, 1% tolerance in the
assertion). It reverts the snapshot afterwards, so it is re-runnable.

```
RYO_FORK_RPC=http://127.0.0.1:8545 RYO_FORK_EXECUTE=1 \
  cargo test --test fork_opportunity -- --ignored --nocapture
```

Observed: `routes=44 quotes=452 simulations=10 opportunities=4`,
best `WETH univ3:500 > slipstream:100` at 4 WETH, then 4.1s on a warm fork.

### Manifest writer verification

`forge script ... --broadcast` with `MANIFEST_PATH=../Watcher/deployments/8453.anvil.json`
produced the same addresses as before, plus a correct `blockNumber`/`timestamp`.
`ryo-watch validate` accepts it (`pools: 12 verified`, `OK`).

---

## 6. What is left (ordered)

### A. Scanner validation — done

1. ~~Re-run `scan` and record runtime.~~ Done: cold 1m47s (Anvil upstream
   fetch), warm **0.6s** for 264 routes / 1584 quotes.
2. ~~Manufacture a profitable route and verify plan/estimateGas.~~ Done: see
   "Profitable-route scenario" above. `eth_estimateGas` succeeds from the
   operator and the built calldata pays out exactly the simulated profit.
3. ~~Add a fork integration test.~~ Done: `tests/fork_opportunity.rs`.

Open sub-item: `eth_call` with `BlockId::pending()` against Alchemy's HTTP
endpoint is still unverified. The live run used Alchemy for the WebSocket and
Anvil for HTTP/pending calls; the public HTTP endpoint and Anvil both accept
the `pending` tag.

### B. Live Alchemy WebSocket verification — done 2026-10-30

Results are in §0g. Summary:

1. ~~Add the real Alchemy Base `wss://` URL via `RYO_WS_RPC`.~~ Done (key kept
   in the environment only).
2. Ran `watch --no-scan` per source, then full `watch --source both` against a
   local Anvil fork with the core deployed.
3. Findings:
   - `pendingLogs` is supported on Base and delivers `Log` objects ~1 s before
     the block; this is the preconfirmation signal.
   - `newFlashblocks` returns a preconfirmed block object with transactions
     and **no logs**; `newFlashblockTransactions` returns a single tx hash.
     Neither can identify the affected pool, so `flashblocks` alone cannot
     trigger scans.
   - `newHeads` parses and is used only for gap detection.
4. Reconnect against the live socket was not exercised; `tests/events_ws.rs`
   covers the state machine locally.
5. Live scan results (skewed fork): 100 triggers, 924 routes, 6,044 quotes,
   50 simulations, 16 opportunities, best net $10.50. Unskewed: 120 triggers,
   7,392 quotes, 0 opportunities.

### C. Execution path (not built)

Current code only logs. To send transactions later:

- Add a local signer (`alloy-signer-local`) and `Provider` with wallet layer.
- Use network/default priority fee; **no priority-fee bidding**.
- Respect core `maxGasPrice` and watcher `max_gas_price_gwei`.
- Never replace a stuck transaction by bidding up fees (disabled by default).
- Build `execute` with the same floors/minProfit used in `plan`.
- Track nonce, pending tx, receipts, reverts, and `Executed` events.
- Add a kill switch (`paused` check + local flag).
- Add a dry-run/paper/live mode gate; live must require explicit opt-in.
- Consider private orderflow / sequencer submission later; not now.

### D. Deployment manifest writer — done

- `ryo/script/Deploy.s.sol` writes the manifest (`MANIFEST_PATH`, default
  `../Watcher/deployments/<chainId>.json`, `SKIP_MANIFEST=true` to skip).
- Shape matches `config::Manifest` (camelCase, every `uint256` a decimal string).
- `ryo/foundry.toml` allows writes to `../Watcher/deployments`.
- Verified by broadcasting on the fork and then running
  `ryo-watch validate` against the written file.
- No automated Solidity test asserts the JSON; it is covered by that manual
  round trip. Adding a small test would need file reads in Forge.

### E. Docs and packaging — done

- `Watcher/README.md`: what it does/does not do, layout, commands, settings,
  tests, local Anvil playbook, safety notes.
- `Watcher/deployments/8453.example.json` shows the manifest shape with
  placeholder addresses.
- `.env.example` and `.gitignore` updated.

### F. Contract safety changes — done

- `renounceOwnership()` override always reverts with
  `OwnershipRenunciationDisabled`; two-step transfer still works.
- Three new tests in `test/RyoSecurity.t.sol` (renounce reverts, transfer then
  renounce reverts, non-owner cannot renounce or setOperator).
- Full Foundry suite after changes: **122/122 pass** (108 non-fork + 14 fork).

### G. Performance and robustness

Done: route enumeration cache, gas/ETH cache, quote dedupe + concurrent chunks,
two-phase duplicate-trigger suppression, bounded event queue, metrics line,
debug-level quote failures, head-gap/reorg full rescan, gas gate before
quoting, and (§0h) multi-amount quote batching, single-call core-state read,
batched Chainlink feeds with cached decimals, concurrent gas snapshot, and
parallel per-asset scans.

Still open:

- Token decimals/symbols need no cache: the registry holds them as constants
  and the scanner never reads them on-chain.
- Caps are deliberately not cached because the owner can change them (§0h
  batches the reads into the single core-state multicall; it does not cache
  them, so the owner can still change them live).
- Per-stage latency metrics are now instrumented (§0h: `probe/refine/simulate/
  core/gas_ms` in `ScanReport` and `watch` averages). Only total-scan and
  per-asset overlap remain a reading caveat, not a gap.
- Watch-loop pipelining (process the next trigger while a scan runs) is still
  intentionally not done: single-flight + the bounded queue is the designed
  behaviour. A short-window trigger coalesce is a possible future option.

---

## 7. Verified Base mainnet addresses

Core tokens:

```
WETH   0x4200000000000000000000000000000000000006
USDC   0x833589fCD6eDb6E08f4c7C32D4f71b54bdA02913
cbBTC  0xcbB7C0000aB88B473b1f5aFd9ef808440eed33Bf
EURC   0x60a3E35Cc302bFA44Cb288Bc5a4F316Fdb1adb42
AERO   0x940181a94A35A4569E4529A3CDfB74e38FD98631
```

Routers / helpers:

```
Balancer Vault     0xBA12222222228d8Ba445958a75a0704d566BF2C8
UniV3 Router       0x2626664c2603336E57B271c5C0b26F421741e481
UniV2 Router       0x4752ba5DBc23f44D87826276BF6Fd6b1C372aD24
Aerodrome Router   0xcF77a3Ba9A5CA399B7c97c74d54e5b1Beb874E43
Slipstream Router  0xBE6D8f0d05cC4be24d5167a3eF062215bE6D18a5
Multicall3         0xcA11bde05977b3631167028862bE2a173976CA11
GasPriceOracle     0x420000000000000000000000000000000000000F
UniV3 Factory      0x33128a8fC17869897dcE68Ed026d694621f6FDfD
UniV2 Factory      0x8909Dc15e40173Ff4699343b6eB8132c65e18eC6
Aerodrome Factory  0x420DD381b31aEf6683db6B902084cB0FFECe40Da
Slipstream Factory 0x5e7BB104d84c7CB9B682AaC2F3d509f5F406809A
UniV3 Quoter       0x3d4e44Eb1374240CE5F1B871ab261CD16335B76a
Slipstream Quoter  0x254cF9E1E6e233aa1AC962CB9B05b2cfeAaE15b0
```

Chainlink feeds:

```
ETH/USD   0x71041dddad3595F9CEd3DcCFBe3D1F4b0a16Bb70
USDC/USD  0x7e860098F58bBFC8648a4311b374B1D669a2bc6B
BTC/USD   0x64c911996D3c6aC71f9b455B1E8E7266BcbD848F
EUR/USD   0xc91D87E81faB8f93699ECf7Ee9B44D11e1D53F0F
```

USDC/WETH pools (12, all verified):

```
UniV3 100    0xb4CB800910B228ED3d0834cF79D697127BBB00e5
UniV3 500    0xd0b53D9277642d899DF5C87A3966A349A798F224
UniV3 3000   0x6c561B446416E1A00E8E93E221854d6eA4171372
UniV3 10000  0x0b1C2DCbBfA744ebD3fC17fF1A96A1E1Eb4B2d69
UniV2        0x88A43bbDF9D098eEC7bCEda4e2494615dfD9bB9C
Aero volatile 0xcDAC0d6c6C59727a65F871236188350531885C43
Aero stable   0x3548029694fbB241D45FB24Ba0cd9c9d4E745f16
Slip 1       0xdbc6998296caA1652A810dc8D3BaF4A8294330f1
Slip 10      0xb150768CF55d1625E2337a08FBd1b0f02ff94bdB
Slip 50      0xAaD23a67F2AC693ABBe543489aeB3F24F561D517
Slip 100     0xb2cc224c1c9feE385f8ad6a55b4d94E92359DC59
Slip 200     0x148BC43946a902258916e580B0e6D92Aaa74746F
```

Pool indexes are in registry insertion order (0..11 as above). `scan --pools`
uses these indexes.

Balancer Vault balances at test time (for context; flash-loan fee is 0):

```
USDC   81,722.073075
WETH   21.880893047221778992
cbBTC  0.01412383
EURC   3.072645
AERO   0.00157
```

Only USDC and WETH have meaningful Vault liquidity; the scanner starts with
those two.

---

## 8. Key protocol facts / gotchas

- `RyoCore.simulate` **always reverts**. Success is
  `SimulationResult(int256)` selector `0x00cf1ea6`.
- `simulate` requires every leg’s `minAmountOut != 0`; use `1` for discovery.
- `simulate` does **not** enforce `paused`, cap, `maxGasPrice`, or operator.
  The watcher must enforce those off-chain.
- `routeHash = keccak256(abi.encode(VERSION, steps))`, so it includes
  `minAmountOut` and `data`. Discovery and execution hashes differ.
- Core selectors:
  - `execute(address,uint256,(address,address,address,uint256,bytes)[],uint256)`
    = `0x76af4222`
  - `simulate(address,uint256,(address,address,address,uint256,bytes)[])`
    = `0x2d66c4e3`
  - `Executed` event = `0xa05f8c54`
- `maxTradeSize == 0` means the asset is not tradable.
- `maxGasPrice == 0` disables the core gas check.
- Base has a private sequencer mempool, priority-fee ordering, and 200ms
  Flashblocks. Preconfirmation is not finality.
- Alchemy `alchemy_pendingTransactions` is not supported on Base, but the
  `pendingLogs` subscription is (verified live 2026-10-30). Webhooks require a
  public HTTPS endpoint and are not the fast trigger.
- No priority-fee bidding: use the network/default tip. This will lose some
  contested races; measure it rather than hide it.
- USDC/USD Chainlink on Base can be hours old; use a 24h staleness window.
- Anvil’s priority-fee estimate can be ~1 gwei, so its effective gas price can
  exceed a mainnet-tuned core `maxGasPrice`. Set a fork-only cap; the live run
  used `--max-gas-price-gwei 2`. Real Base gas was ~0.005 gwei and passes the
  default 0.05 gwei ceiling.

---

## 9. Exact resume commands

```bash
cd /home/runner/ICU/Watcher   # or your clone path

# Unit tests + mock WebSocket integration test + lints
cargo test
cargo clippy --all-targets
cargo fmt --all --check

# Public Base read-only tests
cargo run -- gas
cargo run -- routes --asset USDC
cargo run -- decode 0x2c10b304...

# Anvil fork (if not running)
anvil --fork-url https://mainnet.base.org --chain-id 8453 --port 8545

# Deploy + write the manifest in one step (from ryo/)
cd ../ryo
PRIVATE_KEY=0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80 \
MAX_GAS_PRICE=3000000000 MAX_TRADE_USDC=8000000000 MAX_TRADE_WETH=4000000000000000000 \
MANIFEST_PATH=../Watcher/deployments/8453.anvil.json \
  forge script script/Deploy.s.sol:Deploy --rpc-url http://127.0.0.1:8545 --broadcast
cd ../Watcher

# Foundry contract tests (fork tests hit Base over the network)
cd ../ryo && forge test && cd ../Watcher

# Validate the fork deployment
cargo run -- --http-rpc http://127.0.0.1:8545 \
  --manifest deployments/8453.anvil.json validate

# Quote / simulate / plan
cargo run -- --http-rpc http://127.0.0.1:8545 \
  --manifest deployments/8453.anvil.json \
  quote --asset USDC --amount 1000 --route univ3:500,univ3:100

cargo run -- --http-rpc http://127.0.0.1:8545 \
  --manifest deployments/8453.anvil.json \
  simulate --asset USDC --amount 1000 --route univ3:500,univ3:100

cargo run -- --http-rpc http://127.0.0.1:8545 \
  --manifest deployments/8453.anvil.json --max-gas-price-gwei 3 \
  plan --asset WETH --amount 4 --route univ3:500,slipstream:100

# Full scan (first run is slow on a cold fork; the repeat is ~0.6s)
cargo run -- --http-rpc http://127.0.0.1:8545 \
  --manifest deployments/8453.anvil.json --max-gas-price-gwei 3 scan

# Automated fork scenario: skew the pool, scan, optionally execute
RYO_FORK_RPC=http://127.0.0.1:8545 RYO_FORK_EXECUTE=1 \
  cargo test --test fork_opportunity -- --ignored --nocapture

# Historical swap dataset (Base public RPC; mainnet.base.org rejects getLogs)
cargo run -- --http-rpc https://base-rpc.publicnode.com \
  history --blocks 43200 --chunk 500 --out data/swaps_24h.jsonl

# Live watch (needs the Alchemy WSS key in the environment, not a file)
cargo run -- --http-rpc <alchemy-http> --ws-rpc <alchemy-wss> \
  --manifest deployments/8453.json --source both watch --show-empty --metrics-every 25

# Live triggers + local fork state (the configuration used in §0g)
# 1) anvil --fork-url <alchemy-http> --chain-id 8453
# 2) deploy with script/Deploy.s.sol (see the forge command above) to
#    MANIFEST_PATH=../Watcher/deployments/8453.fork.json
RYO_WS_RPC=<alchemy-wss> RYO_HTTP_RPC=http://127.0.0.1:8545 \
  cargo run -- --manifest deployments/8453.fork.json --source both \
  --max-gas-price-gwei 2 watch --show-empty --metrics-every 25
```

If the Anvil fork was restarted, its deployed addresses and state are gone.
Redeploy with the forge command above; it rewrites `deployments/8453.anvil.json`
for you.

---

## 10. Warnings / security

- Two GitHub tokens were pasted in chat (the first expired before the final
  push; a fine-grained PAT completed it). Both are session-scoped.
  **Revoke them after use.** Do not put them in the repo, State.md, `.env`, or
  the zip.
- Never commit `PRIVATE_KEY`, Alchemy URLs with API keys, or `.env`.
- The zip intentionally excludes `target/`, `.git/`, and any `.env`.
- `watch --mode live` currently does not send transactions. Do not assume it
  trades.

---

## 11. Next move (one line)

Decide whether to deploy `RyoCore` to Base mainnet (real gas, owner/operator
keys, writes `deployments/8453.json`); only then can the watcher scan against
real mainnet state. Everything that can be verified without that deployment is
done: live Alchemy events (use `--source pending-logs` or `both`), full scan
loop on a deployed fork, and the 24h dataset for replay.

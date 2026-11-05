# Ryo Watcher — Development State

Last updated: 2026-11-04 (§0w scopes the next big program — race-readiness:
gap autopsy on historical market data, replay benchmarking, and the
optimization loop until the pipeline beats measured competitor close times;
§0v shipped §0u's local CL math, live-differentiated wei-for-wei)

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

### 0i. WebSocket transport, trigger coalescing, failed-sim cache (2026-10-31)

Three latency features requested after the §0h overhaul and the max-speed
benchmark; all implemented, unit-tested, fork-tested, and verified live.

**Feature 2 — RPC calls over the WebSocket.** `chain::connect_auto(http, ws)`
normalizes the configured WS URL (`http→ws`, `https→wss` via
`normalize_ws_url`), compares endpoints after stripping credentials and
default ports (`authority`), and returns a single WS-backed provider iff they
point at the same endpoint:
one persistent connection for both subscriptions and all calls. All eight
provider-construction sites in `main.rs` were switched over. On a split
HTTP/WS setup (e.g. anvil fork behind HTTP + Alchemy WS) the rule keeps calls
on HTTP and only subscribes over the configured WS. Live-verified twice:
`gas` on Alchemy prints identical values over HTTP and WS and logs
"scanning over the WebSocket endpoint (persistent connection)".

**Feature 3 — burst coalescing.** `Scanner::scan_triggers(&[Trigger])` joins
a batch through the new pure `plan_batch` (duplicate/dust/head-tick handling
identical to the single-trigger path; affected pools union; a batch member
needing a full scan forces the whole batch full; pending-state members scan
`Pending`; dedupe keys are marked only after the shared scan succeeds).
The watch loop now actively bundles after every trigger: each additional
fetch gets a 2 ms budget, so the socket backlog that built up during the
previous scan drains into one batch for free, while an idle socket pays one
2 ms timeout; `--coalesce-ms N` (`RYO_COALESCE_MS`, default 0) additionally
waits up to N ms for events that have not arrived yet; batches cap at 32.
Discovery worth keeping: the original "drain only what is already queued"
(`EventStream::drain_pending`) coalesced nothing in practice because
tungstenite frames stay in the socket until `next()` reads them; the
2 ms-budgeted `next()` loop replaced it and `drain_pending` was deleted.
Measured on the fork under a 24-swap burst: default mode **events 34 →
scans 25**; `--coalesce-ms 150` **events 22 → scans 8**; identical findings
either way, `failed=0`.

**Feature 4 — failed-sim cache — with a design fix caught by integration.**
The first implementation keyed losses to per-pool *event epochs* and skipped
a candidate while none of its pools had new events. The new fork integration
test (`tests/fork_simcache.rs`) proved that construction dead: every scan
only simulates routes containing the *triggering* pools, and those pools
advance by construction, while full scans reset the cache — the skip could
never fire in production. Redesigned to pin the loss to its **simulation
inputs**: `(asset, amount, route pools) → (quotes, gas price, asset USD,
ETH USD)`, skipped only when every input is bit-identical. Equal quotes mean
the route's pools produce equal outputs, so the on-chain result cannot have
changed even if those pools traded in between (trades that do not move the
quoted outputs); equal gas/USD prices keep the net-profit gate honest. No
full-scan reset is needed any more — mismatching inputs skip nothing.
Measured: fork test scan #1 `simulations=4` → scan #2 `simulations=2,
sims_cached=2` with both opportunities re-found; live watch bursts now show
`sims_cached` climbing (8 in the final 34-event burst). `ScanReport` gained
`sims_cached`; metrics line, `--json` (`simsCached`), and `print_report`
surface it.

Verification (all on 2026-10-31):

- `cargo test`: **72 lib tests + 1 WS integration test**, both fork tests
  green; `cargo clippy --all-targets -D warnings` and `cargo fmt --all --check`
  clean.
- `tests/fork_opportunity.rs` with `RYO_FORK_EXECUTE=1` still pays
  **exactly** the simulated profit (`894041505887578` wei WETH, byte-for-byte
  equal), so the cache never hides a winner.
- New `tests/fork_simcache.rs` (ignored; `RYO_FORK_RPC`): two consecutive
  full scans of a quiet fork must skip changed-input nothing and re-find
  everything.
- Live Alchemy: trigger stream on the persistent WS with the key redacted;
  every scan against the (non-existent on mainnet) anvil core errors
  "failed to decode core.paused" and reports no opportunity — the fail-closed
  read path behaves correctly against a real address holding no code.

### 0j. Local constant-product quote math (#1) — DONE 2026-11-01

Speed work started this session (2026-11-01). Environment now has Foundry
1.8.7 installed (`~/.config/.foundry/bin`), and an Anvil Base fork was
redeployed with `Deploy.s.sol` so the watcher runs end-to-end locally.

Baseline (warm fork, `scan`): ~0.52 s, with the `probe` phase ~480 ms = ~92% of
the scan. That phase is on-chain `eth_call` quoting through Multicall3, so the
whole optimization targets it.

Goal of #1: price the constant-product legs (Uniswap V2, Aerodrome classic)
locally instead of via a router round-trip. Concentrated venues (UniV3,
Slipstream) and the Aerodrome stable curve's on-chain path are left remote.

Implemented and verified so far:

- New `src/amm.rs`: a `ConstantProductPool` with three exact curves —
  `UniV2`, `AerodromeVolatile` (fee-subtracted-then `x*y`), and
  `AerodromeStable` (`x^3*y + y^3*x` Newton `_get_y`, a faithful port of the
  Aerodrome `Pool.sol`, including the fixed-order invariant and the same
  truncation). Fees/reserves were reverse-checked against live Base and matched
  the contract source: V2 keeps 997/1000; Aerodrome `factory.getFee` returns
  30 bps (volatile) and 5 bps (stable).
- 5 offline ground-truth unit tests in `amm.rs` (assert local output equals
  recorded on-chain values) — all pass; lib suite now **77 tests**, clippy and
  fmt clean.
- Wired into the scanner: `abi.rs` gained `pool.getReserves` and
  `aerodrome_factory.getFee`; `Scanner::cp_pools` reads every constant-product
  pool's reserves (+ Aerodrome fee) in **one** Multicall3 per scan; `quote_jobs`
  prices a leg locally when its pool is in that map and otherwise falls back to
  the remote quoter (fail-open, so local math can never drop a candidate).
  `plan` passes an empty map (stays remote).
- `tests/fork_opportunity.rs` with `RYO_FORK_EXECUTE=1` on the wired build
  still executes and pays **exactly** the simulated profit
  (`8373837482213898` wei WETH, byte-for-byte) — the substitution did not
  change any outcome.
- `tests/local_math.rs` (ignored; `RYO_LIVE_RPC`) pinned a block, pulled each
  pool's live reserves/fee/decimals, and diffed local math vs the live routers
  over 1 wei → ~$300k USDC and up to 150 WETH, both directions:
  **51 exact matches, 0 mismatches**.

FINISHED this session (2026-11-01, later). Three gaps closed:

- **The fail-open claim above was not true in code.** `quote_jobs` priced a
  local leg and, when `ConstantProductPool::amount_out` returned `None`, set
  `quotes[job] = None` and `continue`d — the candidate was deleted, never
  quoted. The leg decision is now extracted into `scanner::price_leg` returning
  `LegPrice::{Local, Onchain}`, and *every* non-`Local` outcome (pool absent
  from this scan's reserves, dust rounding to zero, a non-converging stable
  iteration, an empty side, an implausible fee) falls through to the on-chain
  quoter. `scanner::tests::local_refusals_fall_back_to_the_quoter` pins the
  table per curve so the deletion cannot come back.
- **`amm.rs` arithmetic is now fully checked.** Important correction: `U256`'s
  `+`, `-` and `*` are implemented via `wrapping_*` (ruint
  `impl_bin_op!`), so they **silently wrap in every profile** — they do *not*
  panic; only `/` and `%` trap, on a zero divisor. An unchecked intermediate
  therefore returns a plausible-looking wrong price that can rank, gate and get
  logged, which is worse than a crash. All of `stable_k`/`_f`/`_d`/`_get_y`,
  `subtract_fee_bps` and the stable output scaling are `checked_*`, with `None`
  meaning "quote it on chain", never "this route is unprofitable". The
  truncation *order* is unchanged, so the pinned on-chain values still match.
  `raw_u256_operators_wrap_silently` pins the premise;
  `absurd_inputs_decline_or_stay_bounded` sweeps ~750 adversarial
  (curve, reserve, decimals, fee, amount) combinations asserting no panic and
  no quote exceeding the destination side.
- **`ten_pow` returns `Option`** (it used to panic for `decimals > 77`), and
  `cp_pools` now refuses to price a pool locally on an unrepresentable
  `decimals` or an out-of-scale `getFee`. The old code did
  `fee.try_into().unwrap_or(u32::MAX)`, feeding a 4-billion-bps "fee" into local
  math.

Verification now, all green:

- `cargo test --lib` — **88 tests** (was 77): the pinned tables plus the new
  `amm` and `scanner` guards. `cargo clippy --all-targets` and
  `cargo fmt --check` clean.
- `amm.rs` pins **33** on-chain outputs across 3 pools in **both** directions
  at Base block 53371076 — this is what closes the earlier hole where only
  USDC→WETH (`token_in_is_token0 == false`) was ever exercised offline, even
  though the stable branch swaps `reserve_a`/`reserve_b` *and* picks
  `decimals_out` by that same flag.
- `examples/capture_pin.rs` regenerates every pinned number from the fork and
  prints its block. Re-run it rather than editing a constant by hand; that is
  the difference between evidence and a restatement of the formula.
- `tests/local_math.rs` (ignored; local fork by default, `RYO_LIVE_RPC` for
  live) now diffs against **`venues::quote_step` itself** — the scanner's real
  encode → `eth_call` → decode → reject-zero path — not a hand-written router
  call: **78 exact matches, 12 consistent declines, 0 mismatches** across 3
  pools, both directions. `(None, Ok(_))` and `(Some(_), Err(_))` both `bail`,
  so a local refusal that the chain would have paid for fails the test.
- `tests/fork_opportunity.rs` (ignored): still finds 3 opportunities after a
  real skew, best `net_usd=12.96`. `tests/fork_simcache.rs` (ignored): now
  manufactures its own skew, so it no longer needs a busy fork — scan #1
  `simulations=4 cached=0`, scan #2 `simulations=3 cached=1`, opportunities
  preserved at 3.

STILL OPEN for #1 (all optional, none blocking):

- Latency of the *targeted* case (one V2/Aerodrome pool triggers a scan, so all
  its routes gain a free leg) has still not been measured. A full `scan` stays
  ~0.52 s because 9 of 12 pools are concentrated. The fallback adds round-trips
  only for refusals, which the refine grid's `0.5×probe` floor makes rare in
  practice.
- Reserves are still re-read per scan (one multicall). Incremental updates from
  arriving `Swap` events are not implemented.
- Coverage remains the 3 constant-product pools; concentrated-venue local math is
  out of scope.
- The differential and both fork tests need a live Anvil Base fork and are
  `#[ignore]`d. There is no CI, so nothing here runs on push — see §6.

---

### 0k. One pinned block per scan (#2) — DONE 2026-11-01

The bug: `evaluate` resolved a block *tag* (`latest`/`pending`) and passed it to
every read, while separately calling `eth_blockNumber` for the report. Base
produces a block every ~2 s and a scan takes ~0.5 s, so a scan routinely quoted
block N and simulated block N+1. A profit figure like that describes a trade
that was possible in neither block. Three related lies came out of the same
root: `Opportunity.block` was the *gas snapshot's* block (a cache up to 2 s
old), the simulation used a `minAmountOut` floor of 1 on every leg while the
proposed calldata used 0.98x floors, and the head marker `last_block` was
written both by `newHeads` and by scans, which made any slow scan look like a
missed block and forced a full rescan.

The fix:

- `chain::Pin` — number, **hash**, timestamp and base fee, resolved once at the
  start of `evaluate` (and of `plan`, `gas`, `simulate`). Every read after it —
  core state, constant-product reserves, leg quotes, the GasPriceOracle batch,
  Chainlink feeds and `RyoCore.simulate` — uses `pin.id()`. `gas::snapshot` no
  longer fetches a block of its own, so it is also one round-trip cheaper.
- Pinned by hash, not number. Base nodes (Alchemy documents it) accept a
  32-byte block hash for `eth_call`, and a hash cannot be re-interpreted by a
  re-org the way a number can.
- **`pending` cannot be pinned**: on Base it reports a hash of `0x0000…0000`
  (measured), which is exactly why it is unsuitable — it is a moving target by
  definition. Scans now read the newest *confirmed* block and report
  `head_drift` (blocks produced during the scan) instead of silently mixing
  states. `ScanBlock::Pending` survives as a *scheduling* signal only.
- The gas cache is reused only when `snapshot.block_number == pin.number`. The
  old time-based reuse could price a scan at block N's fees while quoting N+1.
- **Simulate the trade that is proposed.** Floors are built first, then the
  simulation runs those exact steps, and the same steps become the `execute`
  calldata. Consequence, verified below: the executed transaction now pays
  *exactly* the simulated profit, because they are the same trade.
- Re-org guard: after the scan, re-read the header at `pin.number`; if its hash
  differs, the report is `reorged` and the CLI prints `SCAN VOID` and suppresses
  the opportunities. A discarded block can still answer reads, so without this
  a re-org would produce confident numbers about nothing.
- Failure visibility: `quote_failures` counts legs the chain could not price at
  all, and `scan_health_note` turns any non-zero count into a report note
  ("N of M leg quotes could not be priced; zero opportunities here does not
  mean no opportunity existed"). Previously a re-org, a rate limit or a quoter
  revert was indistinguishable from an empty market — it looked like the
  watcher had looked and found nothing.
- `evaluate` no longer writes `last_block`; `newHeads` owns that marker, which
  is what the "no polling loop" design claimed.

Field facts learned while testing (measured, not assumed):

- Alchemy Base `eth_call` accepts number, tag **or block hash** for the block
  parameter.
- Archive depth: Alchemy treats state older than ~128 blocks as archive data.
  A scan's pin is seconds old, so a standard node is enough.
- After a genuine re-org on Anvil, `eth_call` at the discarded hash fails with
  `-32001 Resource not found` rather than returning stale state — the failure
  mode `quote_failures` exists to surface.
- Base sequencer re-orgs are real (the sequencer can discard blocks it already
  broadcast); they are rare, which is why the guard detects rather than assumes.

Verification, all green:

- `cargo test --lib` — **92 tests**, clippy and fmt clean. New: `Pin` id/drift/
  supersession units, `scan_health_note`, plus a `!report.reorged` no-false-
  positive assertion in the fork test.
- `tests/pinned_block.rs` (new, 4 ignored tests):
  * `pinned_reads_are_immutable_while_the_chain_moves` — the decisive one. Pin,
    read the UniV3 price, move 60k USDC through that pool, read again: the
    pinned answer is **identical** (`tick -199056`) while the current price
    moved (`tick -199026`). It `bail`s if the skew left the price unchanged, so
    the equality can never be vacuous.
  * `a_reorg_of_the_pinned_block_is_detected_and_voids_the_scan` — snapshot
    *behind* a block, mine it, revert, mine a different block at the same
    number, then assert the guard fires. It fails loudly if no real re-org was
    produced (`block kept the same hash … this test proves nothing`).
  * `every_number_in_a_scan_describes_one_block` — full scan (264 routes, 1622
    quotes, 4 opportunities after a manufactured skew): the reported block/hash
    pair is a real block, every `Opportunity.block` equals the scan's block,
    drift is honest, and unpriced legs are noted. It asserts the scan did work,
    because with `Settings::default()` it had found nothing and passed vacuously.
  * `pin_block_and_hash_describe_the_same_canonical_block` — hash form and
    number form agree byte-for-byte.
- Live Base (Alchemy, real mainnet state): canonicality test 10/10 across
  successive heads; `local_math` differential against mainnet routers **77
  exact, 13 consistent declines** on pools whose reserves had moved since the
  fork snapshot; `gas` prints one pinned block (53373732) with real oracle and
  feed values.
- Fork end-to-end: `fork_opportunity` with `RYO_FORK_EXECUTE=1` now sends the
  *simulated* trade and the recipient gains exactly `6397428454595845` WETH —
  equal to the simulated profit, which is the first time measurement and
  execution describe the same calldata. `fork_simcache` unchanged in behavior
  (`simulations 4 -> 3`, `sims_cached 1`, opportunities preserved).
- Fork-only tests now take `RYO_FORK_RPC` and call `anvil_nodeInfo` first, so
  pointing them at a real node fails with an explanation instead of a
  transport error (verified against live).

NOT done, in order of value:

- **Flashblock freshness.** Pinning trades ~200 ms of freshness for internal
  consistency. The right recovery is a second, small pass: re-resolve a pin and
  re-quote+re-simulate only the finalists, so each pass is consistent and the
  final number is fresh. Not built.
- `gas.rs` still defaults the L1 fee upper bound to **zero** when the oracle
  read fails (`gas.rs:68-83`), which invents profit; and the tx size for it is
  a hardcoded 2000 for every candidate.
- Any revert (`errors.rs` `Empty`/`Unknown`) is still cached as a definitive
  loss in the failed-sim cache with no TTL; adapter/core error namespaces still
  collide; router/Balancer selectors are still unmapped despite the README
  claim.
- No CI: every behavioural test here is `#[ignore]`d and needs a live fork.

### 0l. Fail-closed cost reads (#3) — DONE 2026-11-01

First item on the §0k "NOT done" list (the L1 bullet there is now fixed; the
flashblock-freshness, cache-precision and CI bullets remain). `gas::snapshot`
silently defaulted the L1 fee upper bound to **zero** when the oracle read
failed (`gas.rs:68-85`), and `simulate_route` fed that value into
`trade_cost` — the cost leg of the profit gate could therefore *invent*
profit. Every candidate also paid for a hardcoded 2,000-byte tx size
regardless of its calldata.

Spec fact (verified against the OP Stack Fjord predeploy spec):
`getL1FeeUpperBound(unsignedTxSize)` adds `+68` for the signature and
`+size/255+16` for the FastLZ compression margin itself ("covers 99.99 % of
transactions"); callers pass the unsigned size without the signature. So a
calldata-derived size plus a documented envelope is a legitimate bound.

Changes:

- `GasSnapshot` no longer carries the upper bound and `snapshot` no longer
  takes `tx_size`. The two remaining oracle reads (`l1BaseFee`, `blobBaseFee`)
  are display-only in the `gas` CLI and became `Option<U256>`: a failed read
  prints `unavailable` instead of a fake zero.
- New `gas::l1_fee_upper_bound(provider, tx_size, block)`: one pinned
  `eth_call` + decode, error on failure — no zero default anywhere.
- New `gas::unsigned_tx_size(calldata_len) = calldata_len + ENVELOPE_OVERHEAD
  (120)`, the envelope documented (type byte + RLP of the tx fields; the
  contract adds the signature and compression margin itself). A typical 2-hop
  `execute` carries ~616 B of calldata → a 736 B bound against the old 2,000;
  the MAX_STEPS=8 worst case is ~1,956 B → 2,076.
- `simulate_route` reads the bound **at each candidate's own calldata size**,
  after building the calldata and *before* `eth_estimateGas` (the cheaper
  round-trip gates first). A failed read skips the candidate as
  *inconclusive* — `(None, false)`, so the failed-sim cache never learns a
  network artifact as a definitive loss — matching the existing
  `SimulateError::Transport` handling. Failure direction follows the
  codebase rule: a wrong "no" is safe, a zero-fee "yes" was not.
- `opportunity_json` now exposes `l1FeeWei`/`l2FeeWei` for cost-path auditing.

Cost: up to `max_simulations` (8) extra pinned `eth_call`s per asset per
trigger. Sizes cluster (same step count + data width ⇒ same calldata length),
so a size-keyed cache is a possible follow-up; not built.

Verification (this machine; Foundry 1.8.7 installed via `foundryup`, Anvil
Base fork + `Deploy.s.sol` deployment, fork block 53376203):

- `cargo test --lib` — **93 tests** (new:
  `unsigned_tx_size_adds_a_documented_envelope`), plus the WS integration
  test; `cargo clippy --all-targets` clean, `cargo fmt --all --check` clean.
- Live public Base `gas`: one pinned block (53375874); L1 base fee
  47,564,549 wei, blob base fee 2,601,635 wei, L1 upper bound
  2,889,221,452 wei **for a labeled 736-byte tx**, 450k gas cost $0.006117.
- `tests/fork_opportunity.rs` with `RYO_FORK_EXECUTE=1`: `routes=44
  quotes=412 simulations=6 opportunities=4`; the executed transaction paid
  **exactly** `7795257470845533` WETH wei, byte-for-byte equal to the
  simulated profit — the new per-candidate cost leg never changed an outcome.
- `tests/fork_simcache.rs`: scan #1 `simulations=6 cached=0` → scan #2
  `simulations=4 cached=2`, all 4 opportunities re-found.
- `tests/pinned_block.rs` (4 ignored tests): all pass, including the full-scan
  consistency test (264 routes, 1,644 quotes, 6 simulations, 6 opportunities).
- `tests/local_math.rs` on the fork: 78 exact matches, 12 consistent declines
  — identical to the §0j record.
- Warm fork full scan: 292 ms probe / ~0.3 s total, no regression. The extra
  `eth_call`s land only on simulate finalists (the fork run made 6); the
  quote/refine path is untouched.
- Scale note: Base L1 fees are sub-cent, so at ~736 B vs the old 2,000 B the
  bound differs by well under a hundredth of a cent — `net_usd` barely moves.
  The point of §0l is the failure mode (zero no longer means "free"), not a
  cheaper-looking trade.

### 0m. Freshness pass — finalists re-priced at a new pin (#4) — DONE 2026-11-01

Closes the first §0k "NOT done" item. Pinning (§0k) traded ~one block of
staleness for internal consistency; this wins it back for exactly the
reported finalists.

Design (as proposed in §0k): after pass 1 produces opportunities, resolve a
**new** pin and re-quote + re-simulate *only the finalists* there — never a
re-search. Rules:

- Runs only when pass 1 found something (the common case costs zero RPC) and
  skips itself when the new pin equals the old one ("head unchanged;
  opportunities are already fresh").
- **All-or-nothing merge** (`merge_refreshed`, pure + unit-tested): every
  finalist must reach a conclusive outcome at the new pin, or the pass-1 set
  stands untouched with a report note. A partially refreshed list would mix
  two blocks — exactly the lie §0k removed.
- Outcomes per finalist: `Replaced` (still profitable at the fresh pin),
  `Gone` (the fresh state truthfully rejects it — definitive sim verdict or
  sub-threshold net: a legitimate removal), `Inconclusive` (re-quote failed,
  feed missing, sim transport — voids the whole pass).
- The pass re-reads its **own core state** at the fresh pin: a core paused
  between the blocks, or a gas spike past either ceiling, voids the refresh
  rather than reporting a stale "yes" as if it were new.
- `simulate_route` is reused unchanged, so simulate-what-you-propose still
  holds: pass-2 floors are built from pass-2 quotes and become the calldata.
- On success the report's `block`/`pin_hash`/re-org guard/`head_drift` all
  move to the fresh pin; a new `fresh_ms` phase timer surfaces in `--json`
  (`timingsMs.fresh`) and the watch metrics (`avg_fresh_ms`).
- Settings knob `freshness` (default on) with `--no-freshness` on `scan` and
  `watch` for latency A/B; no env var, matching `--show-empty`.

Findings while verifying:

- **An empty block legitimately changes the cost numbers.** Mining one
  transaction-free block lowers the EIP-1559 base fee, so `net_usd` may move
  (and gas wei did: 648,196,556,074,030 → 648,183,842,828,380). The honest
  unchanged-state invariant is therefore **exact `simulated_profit`
  equality** (no state moved ⇒ the trade pays the same), with cost differences
  expected — the first version of the test asserted net equality and was
  wrong about the chain, not about the code.
- **Fork tests must fail via `bail!`, not `assert!`**: a panicking assert
  unwinds past `evm_revert` and leaves the fork skewed for the next test
  (observed: the leftover skew drained the vault's USDC and the next run's
  skew tx reverted). `tests/freshness_pass.rs` is written bail-style
  throughout; the older fork tests keep the latent flaw.

Verification (fresh Anvil Base fork at 53377305, clean redeploy; foundry
1.8.7):

- `cargo test --lib` — **94 tests** (new `freshness_merge_is_all_or_nothing`
  covering Replaced/Gone/Inconclusive, all-Gone as a valid empty verdict, and
  reason joining); clippy `-D warnings` and fmt clean.
- New `tests/freshness_pass.rs` (ignored): 4 finalists at block 53377309 →
  one empty block mined → all four Applied at 53377310 with identical
  simulated profits, `block` fields naming the new pin, and both Skipped
  branches (in-scan same-head, and post-refresh head) verified. Passed.
- Regression, unchanged forks: `fork_opportunity` with `RYO_FORK_EXECUTE=1`
  still pays **exactly** the simulated profit (`6713490651707550` WETH wei);
  `fork_simcache` and all four `pinned_block` tests (including the
  every-number-one-block invariant) green; `local_math` differential green.

### 0n. End-to-end campaign — every feature exercised on a real Base fork (2026-11-01)

Goal: before any talk of going live, run the whole watcher against manufactured
opportunity situations, log what it said, check whether it was right, and fix
whatever was not. Setup: an Anvil fork of Base mainnet over a private upstream
RPC, `RyoCore` redeployed into it (`deployments/8453.anvil.json` regenerated),
then skew → `scan --json` → execute the calldata the scanner proposed on chain
→ compare the recipient's real balance delta against the scanner's
`simulatedProfit`. That last comparison is the only honest test of the stack: it
proves the quotes, the local AMM math, the gas model, the gates and the adapter
calldata all describe the *same* trade.

What was exercised, all on chain:

- **Every venue family, both asset directions**: Uniswap V3 (500/3000),
  Slipstream, Uniswap V2, Aerodrome volatile and Aerodrome stable, including
  one route priced end-to-end by local math on both legs. Each produced a
  finalist, each finalist's calldata was executed, and
  `realized_gain == simulated_profit` byte-for-byte on every one (e.g. the
  `aerodrome:volatile > univ2` route realised `127339409904744644` wei exactly
  as predicted).
- **Triggers and the live loop**: WS subscriptions against the real stream,
  `pendingLogs` arriving ~1.25 s ahead of `logs`, burst coalescing, and a
  forced mid-run disconnect through a relay that drops the socket on a timer —
  which proved backoff → resubscribe → `Trigger::Reconnect` → full rescan.
- **Gates and failure paths**: `min_net_profit_usd`, `max_gas_price_gwei`,
  dust floor, zero caps, unpriced legs, `head_drift`, re-org voiding, and the
  failed-sim cache on an unchanged chain (scan #2 `sims_cached>0`, fewer
  simulations, no lost opportunity).
- **Live-mode safety**: `--mode live` was run against the fork with a signer
  configured and sent **nothing** — operator nonce and recipient balances were
  identical before and after 66 manufactured opportunities. The watcher still
  cannot submit; that remains by design.
- **CLI surface**: `keys`, `routes`, `reserve`, `scan`, `gas`, `watch`,
  `--json`, `--no-freshness`, all read back from the logs.

Three real defects found and fixed:

- **`--json` was not machine-readable.** `INFO`-level opportunity lines went to
  the same stream as the JSON payload, so `scan --json | jq` failed. The tracing
  subscriber now writes to **stderr** (`main.rs`); stdout is pure. This is a
  correctness bug for anything piping the watcher, not cosmetics.
- **A core-side cap of zero fell back to the manifest cap.** On chain
  `maxTradeSize == 0` means "this asset is disabled". `scanner::effective_cap`
  now returns `None` when *either* side is zero and notes the asset as not
  tradable; `either_zero_cap_disables_the_asset` pins it. Before this, a
  disabled asset could still be scanned at the manifest size.
- **No-op batches inflated the metrics.** A scan that resolved a head but found
  nothing still counted toward `scans` and its average latency. There is now a
  separate `skipped` counter, so `avg=` means "a scan that did work".

Findings worth remembering:

- Anvil **crashed on the 6th consecutive `evm_snapshot`** and `evm_revert`
  **consumes** the snapshot it restores (the second revert returns `false`).
  Fork tests must take one snapshot per run and stop stacking them.
- Several older fork tests assert with `assert!` *inside* the scenario function,
  so a failure unwinds past `evm_revert` and leaves the fork skewed for the next
  run — which then fails for an unrelated reason. `tests/freshness_pass.rs` is
  written with `bail!` to avoid this; the older files still have the flaw.
- The vault's USDC balance is **66.8k**, not the 81.7k figure quoted earlier in
  this file; skews are sized against the real number.
- `unpriced 1` on an Aerodrome **stable** pool is not a bug: its quoter
  `Panic(17)`s at probe sizes beyond the thin reserve, and the scanner reports
  the leg as unpriced rather than guessing.
- Empty blocks legitimately move `net_usd` because the EIP-1559 base fee drops;
  the invariant a freshness test can assert is **`simulated_profit` equality**,
  not `net_usd` equality.

Final integrated run: `events=135 scans=5 skipped=3 failed=0 routes=300
quotes=2500 simulations=66 opportunities=66`, and the executed finalist
(`aerodrome:volatile > univ2`, both legs priced by local math) realised
`127339409904744644` wei — exactly its own `simulated_profit`.

Speed, measured on the fork. Warm (state already cached by the node), a
trigger-targeted scan over ~44 routes: `avg_scan_ms=50`, `probe 41 ms`,
`simulate 43 ms`, `gas 0 ms`, `fresh 0 ms` — i.e. one pinned block's worth of
work fits comfortably inside Base's ~2 s block time, and `pendingLogs` buys a
further ~1.25 s. A warm *full* scan (all 12 pools, ~500 quotes) is ~0.3 s. The
freshness pass re-prices finalists in ~138 ms. Cold (a freshly redeployed fork
that has to fetch storage from the upstream node slot by slot) the same full
scan reported `avg_scan_ms=19742` and `avg_probe_ms=38217` — and note that the
phase totals can exceed the wall average because phases are batched concurrently,
so a cold `avg_probe_ms` is an upstream-fetch number, not a watcher number. Do
not use cold timings to judge readiness; they say nothing about this code.

Zero key leakage across every log: the upstream credential lived in a
`chmod 600` temp file, was redacted in all output, and is deleted; it never
entered the repo, the manifest, git config or any commit. All suites green
after the fixes: `cargo test --lib` **95 tests**, `cargo clippy --all-targets
-- -D warnings`, `cargo fmt --check`, and every `#[ignore]`d fork suite re-run
against the fork.

**Verdict**: the watching half is behaviourally ready — it pins one block,
prices honestly, fails closed, and never overstates what it found. What still
stands between this and "live" is not watcher logic: there is no submission
path, no mainnet deployment, and no CI running any of the above on push.

---

### 0o. Live 30-minute run on the real websocket, audited against chain history (2026-11-01)

`watch --source both` was left running against real Base (live websocket for
triggers, live HTTP for reads) for 42m40s — the intended 30 minutes overran for
a reason recorded below — covering blocks **53382446..53383726** with full
logging, and its output was then checked against the same window's history
pulled from the chain itself.

**Ground truth first, independently.** `history --from-block .. --to-block ..
--chunk 10` (the watcher's own decoder) downloaded **1,500 swaps** across 773 of
those blocks; a separate Python screen over the same records reproduced the
per-venue counts exactly (572 univ3:100, 256 aero:volatile, 255 univ3:500, 163
slipstream:100, 149 univ3:3000, 55 slipstream:1, 36 univ2, 13 aero:stable,
1 slipstream:10), which validates the screen as well as the download.

**What the watcher did with it:**

- 4,337 trigger lines → **1,512 distinct (tx, pool)** against 1,500 real swaps:
  it saw essentially every event once, and the `pendingLogs`/`logs` pair arrived
  2,172 / 2,165 times — the two feeds are balanced, so dedupe is not dropping
  one of them.
- **Zero swaps of $500 or more went untriggered** (0 of 112). The other 1,388
  were below the dust floor and were correctly skipped *with a note saying so*.
- Reaction timing over 2,094 joinable events: a pre-confirmation log is seen a
  median of **1.24 s before the block it belongs to is mined** (min 1.79 s);
  a mined log 0.16 s after. On a 2 s chain that is the whole point of the
  `pending-logs` source, now measured on mainnet rather than asserted.
- 1 WebSocket connection, 0 reconnects, 0 failed reads, `head_drift` 0 in every
  one of the 1,222 batch reports.
- 807 scan attempts, **all refused** with `failed to decode core.paused`, and 0
  opportunities. That is the correct live behaviour: `RyoCore` is not deployed
  on Base mainnet, so there is no cap, no `paused` flag and nothing to simulate.
  `validate` says the same thing in one line: *"core at 0x… has no bytecode"*.
  The watcher never invented work, never traded against a contract that is not
  there, and said out loud why it was idle.

**Would it have been right about the market?** The window's cross-venue gaps,
computed from `sqrtPriceX96` where both sides are concentrated (so exact, not
trade-average): **median 3.1 bps, max 18.6 bps** over 175 blocks. The scan needs
roughly 90 bps gross (50 bps profit buffer + 2 × 20 bps per-leg slippage), so
"nothing" is the arithmetically correct answer.

To make that a proof rather than an estimate, the two most interesting blocks
were replayed through the real scanner: fork Base mainnet *at that block*, deploy
a core into the fork, run the same binary, and also ask it for the round trip on
the pair the screen flagged.

| Block | Screen said | Scanner (same block) | Watcher's own round trip at $2,000 |
|---|---|---|---|
| 53382472 | 114 bps (widest, trade-average) | 264 routes, 1,584 quotes, 0 simulations, 0 opportunities | −0.61 % one way, −1.67 % the other |
| 53382600 | 18.6 bps (widest *exact* gap) | 264 routes, 1,584 quotes, 0 simulations, 0 opportunities | −0.18 % one way, −0.56 % the other |

The screen's 114 bps was an artefact — a large swap's *average* execution price
on one venue compared against another venue's *marginal* price. The scanner,
which quotes at real sizes, prices both directions as losses. And at 53382600 the
widest exact gap in the whole window, 18.6 bps, sits on top of two pools whose
fees alone cost about 31 bps for the round trip (30 bps + 1 bps): the gap is not
free money, it is smaller than the toll. In both
cases the watcher's "nothing here" is the true answer, obtained by a different
route than the one that would have been used to catch it.

Other live mainnet features exercised in the same sitting: `gas` (base fee
0.005 gwei, `L1 upper bound 2614967593 wei` for a 736-byte tx,
ETH/USD $2,265.33, 450k gas = **$0.0061** — execution on Base is nearly free, so
the binding constraint is the profit buffer, not cost), `quote` (two-leg round
trips priced as −0.62 % and −0.045 %), `routes` (132 USDC cycles), `decode`, and
`watch --json` (**12 of 12 stdout lines parseable**, zero log lines mixed in).

Three defects surfaced, all fixed:

- **Logs were painted with ANSI escapes even when redirected to a file** — a
  regression introduced by §0n's stderr writer, because choosing the writer by
  hand switches off the subscriber's TTY auto-detection. The 42-minute live log
  contains thousands of escape sequences; `with_ansi(stderr().is_terminal())`
  fixes it and the rebuilt binary writes **zero** escapes to a file. `grep` and
  log shippers depend on this.
- **SIGTERM was not handled.** Only `ctrl_c()` (SIGINT) reached the graceful
  path, and a supervisor (systemd, Docker, Kubernetes) sends SIGTERM — so a
  routine restart would have killed the process by default action with no
  metrics summary and no clean socket close. Both signals now take the same
  path; verified live: `shutting down on SIGTERM metrics=events=91 ...` then
  `Pubsub service request channel closed`.
- **`--metrics-every` could silently stop reporting.** It fired on
  `events.is_multiple_of(every)`, but events arrive in bundled batches, so a
  batch that strides the boundary is never a multiple again: 42 minutes at
  `--metrics-every 300` produced **2** summaries instead of ~13. Replaced by a
  pure `metrics_deadline` that advances past every multiple the batch jumped
  over, with two unit tests on the `ryo-watch` binary target (the reason:
  `cargo test --lib` does not run them; `cargo test` does).

Operational trap, worth keeping: launching as `setsid nohup script &` makes the
shell **ignore SIGINT for the whole subtree**, so `timeout -s INT 1800` logged
its 124 "timed out" status while the watcher kept running for another 12 minutes.
Either stop with SIGTERM (now handled) or use `timeout --kill-after`. This is why
the recorded window is 42m40s, not 30m.

Also recorded so nobody re-learns it: a free-tier Alchemy key rejects
`eth_getLogs` beyond a **10-block range**; `history` auto-splits ranges when
that happens, and `--chunk 10` avoids the retries entirely (1,281 blocks in
about 40 s).

Tests now: **95 lib + 2 bin**, `clippy --all-targets -D warnings` and
`fmt --check` clean. The credential used for the live run stayed in a
`chmod 600` temp file, is redacted by the watcher's own log line
(`url=wss://base-mainnet.g.alchemy.com/<redacted>`), appears nowhere in the repo
and never entered a process command line for the replay forks (those used the
public endpoint).

### 0p. Per-pool dynamic trigger floors (2026-11-02)

The fixed $500 dust filter (§0f) asked "is this swap big?"; the honest question
is "could this swap move *this pool* enough to matter?". A $500 swap into the
~$42M univ3:500 pool moves it ~1 bp — hopeless; a $300 swap into a $2.4k pool
moves it 12 % — the fixed floor simply misses those. This session shipped
pool-specific floors; the fixed floor remains as the fallback and as
`--no-dynamic-floors` for A/B.

Design (`scanner.rs`, all additive to the trigger path):

- `PoolFloors` + `read_pool_floors`: **one** Multicall3 batch (≤ 32 calls) reads
  every registry pool's fee and depth — `getReserves` (+ Aerodrome factory
  `getFee`) for constant-product pools, `slot0` + `fee()` + `liquidity()` for
  V3/Slipstream. Cached 30 s (`POOL_FLOORS_TTL`); fetched once per trigger
  batch before `plan_batch`, never per trigger. Reads are advisory state
  (`latest`), so the pinned-money-block rules of §0k are untouched.
- Depth: CP pools use the USDC-side reserve; concentrated pools use the virtual
  in-range quote reserve `L·√P` (word 0 of `slot0` is `sqrtPriceX96` in every
  V3-family layout, so it is parsed as a raw word instead of trusting a tuple
  — Uni and Slipstream disagree on the trailing fields).
- Fee source is **measured, never assumed**: an earlier note here implied
  slipstream fees followed tick spacing; live `fee()` reads disproved it
  (ts=10 and ts=50 both charge 5 bps, ts=100 charges 8.33, ts=1 charges 0.8).
  UniV2 stays the documented 30 bps (no on-chain getter, same constant as
  `amm.rs`).
- Floor math (`trigger_floor_usd`, pure): with price move `m ≈ 2s/D` and
  round-trip cost `c = fee_self + cheapest other fee + 2×slippage + buffer`,
  a scan is pointless unless **both** `m > c` (you cannot even cover fees) and
  the §0f edge estimate `s²/D ≥ min_net_profit_usd` hold, so
  `floor = max(c·D/2, √(P·D))`, then clamped by the existing $45 absolute floor.
  `max`, not sum — both are *necessary* conditions, anything stronger would
  skip trades the gates might take. Every approximation errs toward scanning.
- Integration: `plan_batch` takes `floor_of: &dyn Fn(Option<usize>) -> f64`
  instead of one scalar; the Log arm now resolves the pool index before the
  dust check. Unknown pools, non-swap logs, and `Reconnect`/gap full scans are
  untouched. Skipped dust still never marks the dedupe key (two-phase rule).
  The note line now names the pool's own floor: `swap ~$263 below the $865
  minimum; skipped`.
- Fail-open: any pool whose fee/depth/floor is missing or non-finite uses
  `--min-swap-usd` (which becomes exactly that: the fallback floor).
- New CLI: `ryo-watch floors [--json]` prints venue / fee bps / USD depth /
  floor per pool — the audit surface for tuning, new venues, and debugging.
  `PoolFloors::rows()` exposes the same for tests.
- Settings: `dynamic_floors: bool` (default `true`; matches the freshness
  pattern — subcommand flag only, no env var).

Measured floors on live Base (2026-11-02): univ3:100 $12.4k, univ3:500
$203k, univ3:3000 $9.7M (depth $1.6B — the floor is the fee term, it can never
be cleared by anything the caps allow), univ3:10000 $56k, slip:1 $865,
slip:10/50/200 $45 (their floors compute below it and clamp), slip:100 $113k,
univ2 $4.5k, aero volatile $4.1k, aero stable $59.

Verification, all green:

- `cargo test --lib`: **102 tests** (was 95) — new: floor-model table
  (`trigger_floor_model_is_pool_specific`), bound-selection
  (`takes_the_wider_of_fee_and_edge_bounds`), input rejection
  (`rejects_unusable_inputs`), `cl_depth` pinned to captured live
  `slot0`/liquidity words of univ3:500 (±price-drift band) and unit-scaled at
  `sqrtPriceX96 = 2^96`, `pool_floors_fall_back_per_pool`, and
  `dynamic_floors_are_per_pool_not_per_batch` — the same $300 notional on two
  pools gets one scan and one named skip. Clippy `-D warnings` and fmt clean.
- New `tests/dynamic_floors.rs` (ignored; Anvil fork + deployed core) proved
  all three claims on a real fork in one snapshot: 12 computed floors with the
  expected fees/depths; **a $300 slipstream:10 skew that the fixed floor
  silently drops yields 7 opportunities at ~$39 net each under dynamic mode**;
  the same trigger under `--no-dynamic-floors` is skipped with the historical
  note; a $600 univ3:500 noise swap is skipped by the pool floor while fixed
  mode burns 44 routes/196 quotes on it.
- Live A/B on the user's Alchemy endpoint (key env-only, redacted): 4-minute
  windows over the deployed fork — fixed `events=405 scans=94
  avg_scan_ms=126`, dynamic `events=337 scans=24 avg_scan_ms=121` (warm).
  **~3.5× fewer scans, per-scan latency unchanged** — the floor refresh costs
  one multicall per 30 s, and it rides the same socket as the quotes. A first
  cold-fork run reported 4.6 s scans; per §0n that is Anvil's upstream fetch,
  not the watcher. `floors --json` over Alchemy: 12/12 dynamic.
- Replay over a fresh 2h dataset (10,538 events): fixed mode would scan 2,569,
  dynamic scans 0 swaps — every one of those scans was a swap smaller than its
  own pool could ever pay for (largest events in-window: $39k on univ3:500 →
  18.6 bps vs ~97 bps cost; $970k on univ3:3000 → 12.1 bps vs ~121 bps).
  Safety audit of all 10,538 skips: **0 contradictions ≥ $45**; the 14
  borderline cases are $5–$10 swaps on the two near-empty slipstream pools
  sitting under the pre-existing $45 absolute floor, which applies identically
  in both modes and predates this work. (The 24 real-time dynamic scans were
  non-swap logs — mints/collects on univ3:100/500 — which stay unfiltered by
  design; reconciled from the logs.)

Lessons and gotchas learned the hard way this session:

- **Aerodrome's Slipstream router does not accept `deadline = 0`** as
  "no deadline": it `require`s `block.timestamp <= deadline` straight through,
  so a 0 deadline reverts with no data. SwapRouter02 special-cases 0. Traced on
  the fork (`TIMESTAMP → GT → ISZERO → REVERT` at ~25k gas, no subcalls).
- In a `sol!` binding the **function name is the selector**. Renaming the
  UniV3 copy to `exactInputSingleUni` to dodge a collision produced a selector
  that does not exist; two routers with the same-named function need two
  modules (as done in the test).
- Fork-test approvals must cover *every* router a scenario may use; the noise
  swap reverted until SwapRouter02 got one too.
- Old lesson re-confirmed: a panicking `assert!` inside a fork scenario
  unwinds past `evm_revert` and poisons the next run (observed again as a
  `fork_simcache` failure that only reproduced in batch order after an
  assert-style suite; the pristine-HEAD A/B proved the code innocent). New
  suites stay `bail!`-style.
- Free-tier caveats unchanged: publicnode intermittently 403s; `--chunk 20`
  and retries kept the download inside the limit.

Extension points for the coming work (new pairs, new venues):

- `read_pool_floors` is registry-driven: a new venue needs one arm in the call
  builder (how to read fee + depth) and its quote path, and it gets floors for
  free. A second USDC-less pair would additionally need
  `swap_notional_usd`/`swap_deltas` generalized to *some* quote leg with a
  price feed — currently non-USDC pools simply stay unfiltered (safe, honest).
- Floors for pools whose depth is below the clamp cost nothing: they become
  `$45` and behave like the old "always scan dust-plus" for that pool.
- The cheapest-partner term is global-minimum fee; if a future universe
  restricts partners (side rules), that is the one line to revisit
  (`cheapest_excluding`).

NOT done (deliberate):

- Floors are not refreshed by the trigger itself (a huge swap changes depth —
  the next scan's own quotes see it; floors are advisory by design).
- No per-pair USD legs beyond USDC (see above).
- No cap on the dynamic floor for absurdly deep pools: univ3:3000's $9.7M
  floor just means "never" — correct, since its fees can never be cleared at
  any allowed size; if the manifest caps grow, revisit sizing terms.

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
- `erc20`, `pool` (`token0`/`token1`), `cl_pool` (V3/Slipstream `fee()`,
  `liquidity()`, `slot0` — only word 0 is trusted, the tuple layout differs
  across the family; §0p), `univ3_quoter`,
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
- §0i: `normalize_ws_url`, `same_endpoint`, and `connect_auto(http, ws)` —
  when the configured WS points at the same endpoint as HTTP (credentials and
  default ports ignored), all calls run over the persistent WebSocket
  connection instead of per-request HTTP; otherwise plain HTTP is used.

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
  `scan_triggers(&[Trigger])` (§0i: a whole trigger batch becomes at most one
  scan via the pure `plan_batch`), `evaluate(affected, block)`.
- `plan(route, amount)` for the CLI; enforces watcher gas ceiling, core gas
  ceiling, and `min_net_profit_usd`.
- Routes are enumerated once per asset at construction.
- `scan_trigger` drops duplicate `(tx hash, log index)` events and duplicate
  flashblock hash sets.
- Swap triggers below the pool's **dynamic floor** (fee/depth read in one
  cached 30 s Multicall3; `max(c·D/2, √(P·D))`, §0p), or below
  `max(min_swap_usd, $45)` when floors are off or unreadable, return before
  any quoting; non-swap logs are not size-filtered. `pool_floors()` / the
  `floors` CLI expose the table.
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
- §0i failed-sim cache: a definitive loss is stored with its simulation inputs
  `(quotes, gas price, asset/ETH USD)` keyed by `(asset, amount, route pools)`
  and skipped only on a bit-identical later candidate; capacity 8192 with
  clear-on-overflow. `ScanReport.sims_cached` counts skips.
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
  `gas_ms`, `probe_ms`, `refine_ms`, `simulate_ms`) and §0i `sims_cached`;
  `watch --json` emits them under `timingsMs`/`simsCached` and the metrics
  line logs running averages. §0m adds `fresh_ms` (`timingsMs.fresh`,
  `avg_fresh_ms`).
- §0m freshness pass: when pass 1 finds opportunities and the head has moved,
  `Scanner::freshness_pass` re-pins, re-reads core/gas/USD context, re-quotes
  and re-simulates only the finalists, and replaces the report set
  all-or-nothing (any inconclusive finalist keeps the pass-1 numbers and the
  original pin). `--no-freshness` disables it on `scan`/`watch`.

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
watch  [--max-events N] [--json] [--show-empty] [--no-scan] [--metrics-every N] [--coalesce-ms N]
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
--coalesce-ms    RYO_COALESCE_MS   (watch only; 0 = bundle backlog only)
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

Result: **72 lib tests + 1 WebSocket integration test passed, 0 failed**
(2026-10-31 §0i; 27 before the completion pass, 31 after it, 36 after the
history module, 37 after the replay staleness fix, 39 after the swap-size
filter, 44 after adding notional decoding tests, 54 after the speed-overhaul
batch integrity/decoding tests, 72 after the coalescing/WS/batch-transport
tests). `cargo clippy --all-targets` is
clean after fixes.
`tests/events_ws.rs` uses an in-process mock server and needs no network.
`tests/fork_opportunity.rs` and `tests/fork_simcache.rs` are `#[ignore]`d and
need a local Anvil fork; they are not part of a plain `cargo test`.

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
- (§0i) `plan_batch` coalescing semantics (12 cases: dedupe, dust twins, head
  ticks, union of affected pools, pending-state promotion, full-scan forcing),
  WS-endpoint normalization/matching (incl. credentials and default ports),
  and the input-pinned failed-sim cache (skip only on bit-identical quotes,
  gas, and USD prices; identity covers amount and route; bounded)

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
quoting, (§0h) multi-amount quote batching, single-call core-state read,
batched Chainlink feeds with cached decimals, concurrent gas snapshot, and
parallel per-asset scans, (§0i) same-endpoint WebSocket call transport,
burst trigger coalescing, and the input-pinned failed-sim cache, and (§0j)
local constant-product pricing with a verified-on-chain differential and
guaranteed fallback to the remote quoter.

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
  behaviour. Burst coalescing (§0i, `--coalesce-ms`) is now the implemented
  middle ground; pipelining stays out.

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

### 0q. PancakeSwap V3 as a fifth venue (2026-11-02)

All facts below were read from live Base at block ~53.42M plus the upstream
sources (`pancakeswap/pancake-v3-contracts` @ 9868479, `pancake-document`
@ 7af8352, `infinity-core` @ 3c5ef1b).

**Addresses (Base 8453).** Factory `0x0BFbCF9fa4f9C56B0F40a671Ad40E0805A091865`,
SwapRouter `0x1b81D678ffb9C0263b24A97847620C99d213eB14`, QuoterV2
`0xB048Bbc1Ee6b733FFfCFb9e9CeF7375518e25997`. The router is *not* Uniswap's:
`deployer()` on it returns Pancake's pool deployer
`0x41ff9AA7e16B8B1a8a8dc4f0eFacd93D02d071c9`, and Uniswap's router at
`0x2626664c…` has no `deployer()`.

**Fee tiers are Pancake's own.** Live `feeAmountTickSpacing` gives
`100→1, 500→10, 2500→50, 10000→200`; Uniswap's `3000` tier returns 0, and
`60000`/dynamic returns 0 — there is no dynamic-fee V3 pool on this factory.
`Venue::PancakeV3 { fee }` therefore takes the fee, exactly like `UniV3`, but
the valid set differs; encoding `3000` reverts at swap time (covered by
`test_fork_pancake_rejects_uniswap_only_tier`).

**Router ABI differs.** Pancake's `ExactInputSingleParams` keeps a `deadline`
field, so the selector is `0x414bf389`, not Uniswap's `0x04e45aaf`. Verified by
probe: the Pancake router answers `0x414bf389` with its own `STF` revert (it
reached `transferFrom`) and returns a bare revert for the Uniswap selector.
`PancakeV3Adapter` therefore mirrors `UniV3Adapter` but binds
`deadline = block.timestamp`. Output still goes straight to `params.recipient`
(the core), so the adapter's "input consumed / output retained" invariants hold
unchanged.

**Quoting is drop-in.** Pancake's QuoterV2 is ABI-identical to Uniswap's
(`quoteExactInputSingle((address,address,uint256,uint24,uint160))` → 0.1 WETH
quoted 224.963696 USDC against a 2250.17 spot), so `venues.rs` reuses
`univ3_quoter` with a different target address.

**Event topic differs.** Pancake V3's `Swap` event appends
`uint128 protocolFeesToken0, uint128 protocolFeesToken1`. The first five data
words are unchanged, so `history::swap_deltas` reads the same offsets; only
`is_swap_topic` and the log filter needed the second signature.

**Fork results** (`forge test --match-path test/fork/PancakeFork.t.sol`, 6/6):
one WETH through the real adapter → 2249.99 USDC for ~507k gas; a 2-hop
`pancake:100 → univ3:500` cycle after a 4M USDC skew simulated +32.34 USDC on a
100k loan and executed for **~3.00M gas** end to end.

**Pool depth.** `getPool` over the 5 tracked assets × 4 tiers returns 32 live
pools; 21 of them carry non-zero in-range liquidity. WETH/USDC Pancake depth is
comparable to the Uniswap 0.01% pool, and the fee=100 tier is deep enough that
1.5M USDC of one-way flow moves it only ~2 bps. Only the four WETH/USDC pools
are in the registry so far, because those are the assets the core currently
trades.

**Scan latency after the registry grew 12 → 16 pools** (Anvil fork of
53427742, `--max-gas-price-gwei 2`, three full sweeps each way after a warm-up):

| pools in sweep | routes | quotes | probe ms |
| --- | --- | --- | --- |
| 16 (all) | 480 | 2878 | 831 / 819 / 794 |
| 12 (Pancake-only cycles dropped) | 456 | 2734 | 750 / 802 / 822 |

Roughly +5 % of cycles and +3 % of probe time, which is inside the spread of
the 12-pool runs themselves. Probe cost is dominated by fixed Multicall3
round-trips, not by per-quote work, so four more pools barely move it. The
event-driven path is stricter still: a Pancake swap only re-prices cycles that
contain a Pancake pool. Caveat: `--pools` filters *affected* cycles rather than
shrinking the registry, so this is an upper bound on the added cost, not a
clean A/B.

**Deployed on the fork** (`Deploy.s.sol` broadcast, `8453.fork.json`): five
adapters whitelisted, caps USDC 500k / WETH 250, `validate` green on the new
manifest. Note for whoever re-runs this: the node this session used has a
non-standard dev mnemonic, so `PRIVATE_KEY`
`0xac0974…` maps to `0xeb81a4a2…5e5e…`, which must be funded with
`anvil_setBalance` before the broadcast, otherwise the script dies in the
simulation pass with `lack of funds (0)`.

**Pancake V2 is not worth wiring.** Its Base pairs are dust: WETH/USDC holds
0.165 WETH + 373 USDC, WETH/cbBTC and USDC/cbBTC are effectively empty.

**Pancake Infinity is a much larger job.** It is deployed on Base (Vault
`0x238a358808379702088667322f80aC48bAd5e6c4`, CLPoolManager
`0xa0FfB9c1CE1Fe56963B0321B32E7A0302114058b`), but it has no `unlock`/
`SwapReceipt`: swaps must run inside `Vault.lock(...)` + `lockAcquired` and
settle every delta (`settle`/`take` are `isLocked`-gated, one lock per tx), so
an Infinity adapter is a callback state machine rather than a `step()`
implementation. Pool state is read per-`PoolId` (`getSlot0`/`getLiquidity`,
where `PoolId = keccak256` of the 6-slot `PoolKey` with `parameters` packing
`tickSpacing << 16 | hook bitmap`), and a hook can override the LP fee and take
a delta, so raw-state quoting is only valid for `hooks = 0` pools. Protocol fee
is deducted from the input (`fee = pf + lp - pf*lp/1e6`, capped 0.4%), which the
off-chain curve must model. Defer.

---

### 0r. Tier 1 pair expansion - researched, deliberately NOT wired (2026-11-02)

Deferred by decision after the venue work; this section is the whole handoff, so
a fresh session needs nothing from the conversation that produced it.

**Why expanding assets is not the same as expanding pools.** Two facts bound the
design:

- `RyoCore.execute` checks `maxTradeSize[asset]` against the *flash-loaned
  amount only* (`src/RyoCore.sol:189-191`); intermediate legs are unbounded and
  are guarded solely by per-leg `minAmountOut` floors and route continuity.
- The Base Balancer Vault holds meaningful USDC and WETH and little else.

Consequence: every cycle must still start and end at USDC or WETH, but cbBTC /
EURC / USDT can be *intermediate* legs with no Vault liquidity at all. Adding
them buys triangles (`USDC -> cbBTC -> WETH -> USDC`), which is where genuinely
new edges live, and also multiplies the cycle set far more than four extra Pancake
pools did.

**Measured pool set** (live `getPool` on each factory, Base block ~53,427,000,
2026-11-02; `L` = in-range liquidity in raw units at that moment, so treat it as
an order-of-magnitude signal, not a constant). Pools marked dead returned `L = 0`
and must NOT go in the registry.

*cbBTC/USDC* (`cbBTC = 0xcbB7C0000aB88B473b1f5aFd9ef808440eed33Bf`, 8 dp)
- Pancake: 100 `0xb94b22332abf5f89877a14cc88f2abc48c34b3df` (L 5.4e11),
  500 `0x26e263efdc91f0d3279e2ec2bd58a7ca5c2fce62` (2.6e10),
  2500 `0x748bb91fc5f4200302d9a79185bc161260a1b461` (2.9e9),
  10000 `0xbd65764c8eb1b8858d323066f488b73f6fe22dc9` (dead)
- UniV3: 500 `0xfbb6eed8e7aa03b138556eedaf5d271a5e1e43ef` (2.3e12 - deepest),
  3000 `0xec558e484cc9f2210714e345298fdc53b253c27d` (4.7e11),
  100 `0xe9e25e35aa99a2a60155010802b81a25c45ba185` (1.1e8),
  10000 `0x3e7586d52a9d07f8611b8ecf6ccc8a689c34a659` (1.0e9)
- Slipstream: 100 `0x4e962bb3889bf030368f56810a9c96b83cb3e778` (2.9e11)
- Aerodrome volatile: `0x9c38b55f9a9aba91bbcedeb12bf4428f47a6a0b8` (dead)
- **Not checked: UniV2 `getPair`.** Do it before writing the registry entry.

*cbBTC/WETH*
- Pancake: 100 `0xc211e1f853a898bd1302385ccde55f33a8c4b3f3` (6.9e16),
  500 `0xd974d59e30054cf1abeded0c9947b0d8baf90029` (3.5e15),
  2500 `0x5b3613ef9a535b48e82e2800acb77053dfec93b1` (5.2e14),
  10000 `0xa97c08bc49c246e583a3557f2922daa9e5d1b404` (dead)
- UniV3: 500 `0x7aea2e8a3843516afa07293a10ac8e49906dabd1` (3.5e17 - by far the
  deepest), 3000 `0x8c7080564b5a792a33ef2fd473fba6364d5495e5` (1.0e17),
  10000 `0x233571eae953d9d59eefc0769f71dc19287ddccb`, 100 `0x4c1e404a013bf1917faf2dbf5e5cef3e9bafb5aa`
- Slipstream: 100 `0x70acdf2ad0bf2402c957154f944c19ef4e1cbae1` (2.3e16),
  10 `0xffa192f04b1e5f9f5124fb40a96407564492ed20` (4.8e8, effectively dead)
- Aerodrome volatile: `0x2578365b3dfa7ffe60108e181efb79feddec2319` (dead)

*USDC/EURC* (`EURC = 0x60a3E35Cc302bFA44Cb288Bc5a4F316Fdb1adb42`, 6 dp)
- UniV3: 500 `0x7279c08a36333e12c3fc81747963264c100d66fb` (4.7e12 - deepest),
  100 `0x6a1c74e023fe2619516f89408e9d8c541e4e3eef` (1.8e10),
  3000 `0x03d8219070e54a55a9ce60889ead2ffd18eb6aa9`, 10000 `0xd99fad95b3d1235b403ee26c5b16531d9aa8e576`
- Pancake: 100 `0x1ca42c7219f0cb1b67927e26502320cb98f725bd` (5.9e11); 500 /
  2500 / 10000 (`0xbcc009c3ae38374944b73bb00334f50aa7bfd29a`,
  `0x1f4fee8d9e0a3afa3ee0ac1051e323f4369ff465`,
  `0xcd83e5e45ee238a88717b2b20aec93c616d698dc`) were all dead
- Aerodrome **stable**: `0xef0d374fe41fc6da7f8ed7c56c10a8f2a4f75313` (L 0 at that
  block - recheck, stable EUR/USD is exactly what an Aerodrome stable pool is for)
- Slipstream 10 `0x2e63586d8e385aba0800b061fdd0eb65d23b87e7` (dead)

Second-order candidates already found: `WETH/EURC` (Pancake 500
`0xb4a43d89b5d356065646389fd677ca762efcd780` L 8.5e15, UniV3 3000
`0x260441e9574c0633c70c5cff3a47d75dc9bc3e22`), `WETH/AERO` (four venues,
Slipstream 200 `0x82321f3beb69f503380d6b233857d5c43562e2d0` L 2.3e22 is the
deepest AERO pool anywhere), `USDT/USDC`, and a batch of high-volume /
low-reserve tokenized-equity pairs (MSTRc, SNDKc, xdp, SPCXc vs USDC) whose
spreads were the widest observed but whose ~$1M reserves cap size at a few
thousand dollars per trade.

**Volume context** (GeckoTerminal, dex-scoped endpoint, 2026-11-02, third-party
and not independently confirmed): Pancake V3 WETH/USDC 0.01% $35.7M/24h,
cbBTC/WETH 0.01% $35.0M, cbBTC/USDC 0.01% $24.7M; UniV3 WETH/USDC 0.3% $65.8M
($149M reserve), cbBTC/WETH 0.05% $24.9M, cbBTC/USDC 0.05% $9.97M; Slipstream
WETH/USDC 0.05% $14.5M, cbBTC/USDC 0.05% $3.6M, EURC/USDC 0.05% $2.15M.
The `dexes/{dex_id}/pools` endpoint works; `pools?dex_id=` is silently ignored
and returns an unfiltered global list - that mistake produced a bogus
"every venue trades this pair" table on the first pass, so use the scoped form.

**Five questions to settle before writing code**, in the order that matters:

1. Cycle count. The registry is 16 pools / 480 routes today. Adding ~12 live
   Tier 1 pools takes two-hop cycles from 240 toward 500+ and three-hop far
   more. §0q measured the 12 -> 16 step at ~3 % of probe time; 16 -> 28 is a
   different regime and must be re-measured with the same method before merge.
2. `Registry::base_usdc_weth()` is named for, and structured around, two
   tokens: its `tokens` map holds only USDC and WETH, and the comment above the
   pool list warns that token0/token1 order matters for amount decoding. It
   needs a real rename plus `Token` entries (symbol + decimals) for cbBTC/EURC.
3. Anything that assumes the quote asset is USDC. `swap_notional_usd`
   (`scanner.rs:2475`) returns `None` for pools without a USDC leg, so cbBTC/WETH
   swaps silently skip the freshness/dust screen. Decide: screen on a USD proxy,
   or accept the gap knowingly.
4. USD prices for the new assets. `config::base` already carries
   `BTC_USD_FEED` and `EUR_USD_FEED`; check `gas::asset_usd_price` actually
   walks them, because profit-in-USD and the sqrt(P*D) floors both depend on it.
5. Caps. `Deploy.s.sol` already reads `MAX_TRADE_CBBTC` / `MAX_TRADE_EURC`, but
   those set caps on assets that would become *intermediates*, which the cap
   check never reads. Confirm no dead config is left implying otherwise.

**Test plan when it is picked up:** extend `test/fork/PancakeFork.t.sol` style
coverage with (a) a `USDC -> cbBTC -> USDC` two-venue cycle through the real
Vault, (b) a three-asset triangle `USDC -> cbBTC -> WETH -> USDC`, (c) the same
for EURC, and note that 8-decimal cbBTC makes `minAmountOut` floors and the
dust constants decimals-sensitive - every literal in those tests must be
written with the right exponent. Re-run `cargo test --lib`, the foundry suite,
and the §0q latency A/B.

**Venue gap worth more than any new pair:** Uniswap V4 on Base does roughly
$11.5M/day and is unsupported. Pancake Infinity CLMM is live on Base but its
best pool was $0.53M/24h on a $0.1M reserve, which empirically supports keeping
Infinity deferred (§0q).

**Environment gotchas that cost real time this session:**
- Foundry now installs to `/home/runner/.config/.foundry/bin` (not
  `~/.foundry/bin`); `foundryup` alone may not have run, and `forge`/`cast`
  are not on PATH by default here.
- The local anvil used a non-standard dev mnemonic: `PRIVATE_KEY 0xac0974...`
  derives `0xeb81a4a25e5e1b0B96a863F70682f25F4317C902`, which is unfunded, so
  `forge script` dies in the simulation pass with `lack of funds (0)` before
  broadcasting anything. Fix: `anvil_setBalance` that address first. Check with
  `eth_getCode` on the manifest core - the script prints addresses and writes
  the manifest even when nothing was broadcast.
- Scans on an Anvil fork need `--max-gas-price-gwei 2`; the fork's ~1 gwei
  estimate otherwise trips the watcher's 0.05 gwei ceiling and the scan reports
  `routes 0` in a way that looks like "no opportunity" rather than "skipped".
- Free-tier Alchemy: `eth_getLogs` is capped at a **10-block** range, and
  large `eth_call` batches 429 under load - batch ~60 and back off
  exponentially. The public `mainnet.base.org` rejects `eth_getLogs` outright;
  `publicnode` works for logs but not archive state.

---

### 0s. Tier-1 pair expansion shipped: cbBTC and EURC (2026-11-03)

The §0r handoff was picked up and completed. The registry grows 16 → **33
pools** across four tokens (USDC, WETH, cbBTC 8 dp, EURC 6 dp); borrow assets
stay USDC/WETH, so cbBTC/EURC enter only as *intermediate* legs and their core
caps stay 0 (asserted as an invariant in the Foundry suite). All five §0r
design questions were answered with measurements, not assumptions.

**Verification of §0r's data first.** Every address in §0r was re-checked
against live Base (~block 53,469,965): 39/39 factory claims confirmed. Two
corrections the doc itself warned about: the Aerodrome cbBTC/WETH pool §0r
marked dead was **alive** ($72k depth) and is now registered — the "dead"
flags are a momentary liquidity observation, never a permanent fact; and the
UniV2 `getPair` §0r left unchecked exists for cbBTC/USDC and cbBTC/WETH but
holds ~$1.6k — correctly skipped, along with every pool under ~$50k USD depth.
Token0/token1 order was read from each pool (`token0()`), not derived: cbBTC
pools have USDC as token0 (0x8335 < 0xcbB7) and EURC pools have EURC as
token0 — the "WETH is always token0" comment in the registry only ever held
for the original sixteen pools and is now scoped as such.

**The five §0r questions, answered:**

1. **Cycle count.** USDC 2-hop: 240 → 272; 3-hop adds 1,600 triangles (total
   1,872; WETH 1,896). Measured like §0q (Anvil fork of live Base, redeployed
   core, three warm full sweeps): 2-hop full scan ~950 ms probe (was ~292 ms
   at 16 pools — the growth is linear in quotes, ~3,400 leg quotes per scan);
   3-hop full scan 6.2 s (manual path only); 3-hop **trigger-targeted** scan
   (one cbBTC hub pool affected) 836 ms warm-fork / ~730 ms live probe.
   Default `max_hops` stays 2 — the conservative-default rule — but `--max-hops 3`
   is now proven safe to run live: the 250 s live A/B below measured avg scan
   153 ms (hops 2) vs 399 ms (hops 3) with failed=0, both inside the 2 s
   block window with `pendingLogs`' ~1.2 s lead.
2. **Registry restructure.** `Registry::base_usdc_weth()` → `Registry::base_curated()`
   everywhere (7 call sites). New pools are **appended**: indices 0–15 keep
   their meaning, which `--pools` and the older fork tests address pools by.
   A unit test pins it (`registry.pools[..16].all(is_usdc_weth)`).
3. **Non-USDC quote legs.** Both screens were generalized, fail-open:
   - `swap_notional_usd` now prices **any leg with a USD price** and takes the
     max (the max errs toward scanning; USDC stays constant $1 per §0f).
     WETH/cbBTC/EURC prices come from their Chainlink feeds, refreshed once
     per 30 s alongside the pool floors (one pin + one multicall). A pool with
     no priced leg behaves exactly as before: unfiltered, never zeroed.
   - `read_pool_floors` computes USD depth from the **smaller priced side**
     instead of the USDC reserve — required because cbBTC pools list USDC as
     token0 and cbBTC/WETH has no USDC side at all. `cl_depth_usd` gained the
     second virtual reserve (`L·2^96/√P` for token0, `L·√P/2^96` for token1)
     and takes the min of priced sides; the old pinned-value test passes with
     the token1-side call shape unchanged, proving the rewrite is equivalent
     on the legacy pools.
4. **USD feeds.** `gas::usd_feed_for_asset` already walked BTC/USD (2 h stale)
   and EUR/USD (24 h) — the floors' 30 s price refresh simply uses it. Live
   floors table: **33/33 pools dynamic** on Alchemy (three consecutive runs;
   one cold run showed 24/33 during a transient feed failure — the fail-open
   worked exactly as designed: nine pools fell back to `$--min-swap-usd`, none
   to a wrong price).
5. **Caps.** cbBTC/EURC are never flash-loaned, so `maxTradeSize` is never
   consulted for them; `Deploy.s.sol`'s `MAX_TRADE_CBBTC`/`MAX_TRADE_EURC`
   env knobs write caps that stay 0 by default. The Foundry suite asserts
   `maxTradeSize[cbBTC] == 0` as the "intermediate-only" invariant.

**Route labels needed a grammar (new, not in §0r).** With `univ3:500` living
on three pairs, a bare label is ambiguous. Labels now accept an optional exit
token: `univ3:500:cbbtc` = "the 0.05% pool that swaps *into* cbBTC". Bare
labels keep working — ambiguity resolves to the legacy USDC/WETH pool when one
candidate is legacy; otherwise the parser errors and lists the suffixed
options. `Route::labels(registry)` replaces `Route::venues()` everywhere
(printing, JSON, debug logs) and round-trips through `parse_route` (unit
tested on seven specs including triangles and the aerodrome 8-decimal leg).
The `floors` table now annotates non-legacy pools with their pair
(`univ3:500 (USDC/cbBTC)`).

**Execution model: zero contract changes.** The adapters were already
token-generic (balance-delta accounting, per-step approve/reset). The new
paths needed only off-chain work — verified by execution on forks, which is
the only proof that matters:

- Rust fork suite `tests/tier1_expansion.rs` (4 tests, all green with
  `RYO_FORK_EXECUTE=1`): cbBTC/USDC two-venue cycle executed — recipient
  gained `6,950,641` USDC wei, exactly the simulated profit; EURC/USDC cycle
  executed the same way (`13,443,639,577` wei = simulated); the **three-hop
  triangle** `slipstream:100 > pancake:500:eurc > univ3:500` was found among
  16 opportunities after a 60k USDC skew, executed and paid exactly its
  simulation; registry coverage test asserts ≥6/7/2/1 pools per new pair.
- Foundry `test/fork/Tier1Fork.t.sol` (6 tests, all green on live Base):
  `USDC → cbBTC → USDC` through the real Balancer vault (+1,375.66 USDC
  simulated = realized), the `USDC → WETH → cbBTC → USDC` triangle
  (+584.01 USDC, 1.24M gas executed), EURC/USDC cycle, the shallow Aerodrome
  cbBTC/WETH pool traded **in the correct direction** (buy cheap on Pancake,
  sell into the skewed pool — the first draft had it backwards and simulated
  a loss, which is exactly how a wrong-direction bug should fail), and
  the intermediate-only cap invariant.
- Two Foundry lessons cost real time: a manufactured 400k-USDC skew looks
  huge until a 200k loan slips *more than the gap earns* (simulated −838
  USDC); at 50k loan it clears. And a 1%+ price-impact swap on a
  concentrated pool crosses many uninitialized ticks — measured **2.1M
  gas**, so the fork tests' hard-coded 500k gas cap was out-of-gas-reverting
  the EURC skew (status=false looks identical to a contract revert). Caps
  raised to 3M with the reasoning inlined.
- One latent bug fixed by re-reading my own new code: zipping `[WETH, CBBTC,
  EURC]` against a `filter_map`'ed feed list would misattribute prices if a
  feed mapping were ever removed; the pairs are now built atomically.
- Regression after the change: **112 lib + 2 bin + mock-WS tests**, every
  pre-existing fork suite (`fork_opportunity` with execute, `fork_simcache`,
  `freshness_pass`, `pinned_block` ×4, `dynamic_floors`, `local_math`) green
  on a fresh fork; full Foundry suite green.
- `fork_simcache` needed one honest amendment: its "scan #2 must simulate
  *fewer*" assertion encoded a 16-pool artifact. With a bigger candidate set
  the simulation slots are refilled by the next-ranked routes when cached
  losers are skipped (scan #1: sims 10 → scan #2: sims 8, cached 2 — the
  cache fires, every winner reappears). The test now asserts the two real
  invariants (cache fired; no winner disappeared) and its `assert!`s became
  `bail!`s — the old file still had the §0n flaw: an assert panic unwinds
  past `evm_revert` and poisons the fork for every later suite (observed
  again during this session's first batch).
- `dynamic_floors` expected "12 computed floors"; the correct expectation is
  every registry pool dynamic (33/33), now derived from the registry.

**Live watch campaign on the real websocket** (Alchemy WS + fork HTTP, the
§0g configuration, 250 s each):

| run | events | scans | skipped | failed | avg_scan_ms | avg_probe_ms | routes avg |
| --- | --- | --- | --- | --- | --- | --- | --- |
| hops=2 (default) | 1,211 | 46 | 353 | 0 | 153 | 289 | 56 |
| hops=3 | 1,204 | 29 | 382 | 0 | 399 | 730 | 303 |

Nine of the seventeen new pools produced triggers inside the 250 s window —
`pancake:100 (USDC/cbBTC)` alone fired 150 times, `univ3:500 (USDC/cbBTC)` 48,
`pancake:100 (WETH/cbBTC)` 56, plus slipstream/univ3-3000/pancake-500-500/
weth-eurc pools — **traffic the 16-pool registry was blind to by construction**.
174 swaps were skipped by per-pool floors that named their own pool's minimum
(`swap ~$963 below the $304,642 minimum` — the live cbBTC/USDC 0.05% floor),
and one Aerodrome stable-side leg legitimately reported `unpriced` (thin-pool
quoter panic, same §0n behaviour). No head gaps, no reconnects, SIGTERM
shutdown clean, key redacted in every line (`wss://base-mainnet.g.alchemy.com/<redacted>`).

**Live mainnet round-trip sanity:** `quote --asset USDC --amount 2000 --route
univ3:500:cbbtc,pancake:100:usdc` → 0.02582063 cbBTC → 1,997.99 USDC
(−0.10%): 8-decimal scaling and cross-venue routing priced honestly on real
state. Live `floors`: univ3:500 (cbbtc/usdc) depth $63.6M floor $304,809;
univ3:500 (cbbtc/weth) $433M floor $2.07M; pancake:500 (weth/eurc) $456k floor
$2,187; every legacy pool's floor unchanged from §0p within fee-drift noise
— evidence the depth rewrite is neutral on the old pools.

**Files touched:** `src/routes.rs` (registry, label grammar, `labels()`),
`src/scanner.rs` (trigger prices, notional/depth generalization, labels in
logs), `src/main.rs` (labels threaded through prints/JSON; floors pair
annotation), `tests/tier1_expansion.rs` (new), `tests/fork_simcache.rs`,
`tests/dynamic_floors.rs` (expectations amended), `ryo/test/fork/Tier1Fork.t.sol`
(new), README (label grammar, 33-pool language, floors generalization).
`deployments/8453.anvil.json` regenerated (5 adapters, block 53,466,7xx).

**Environment notes this session:** Foundry 1.9.0 (new lint pass flags
RyoCore's intentional per-step external calls — pre-existing, not errors);
the node's anvil had the standard dev keys this time (§0r's funded-address
gotcha did not recur); Alchemy serves 79-call `aggregate3` floor batches
without complaint at normal rates.

**Open threads left for the next session:** Pancake Infinity stays deferred
(unchanged §0q verdict); Uniswap V4 support remains the biggest venue gap
(~$11.5M/day unwatched); the second-order pairs from §0r (WETH/AERO,
USDT/USDC, tokenized equity pools) were deliberately *not* added — same
regime, same five questions apply; `--max-hops 3` as default is a judgment
call the live A/B above now supports; and the mainnet deployment (core + 5
adapters) is still the gating item for everything.

---

### 0t. Latency: socket-head pins and batched candidate costs (2026-11-03)

Two round-trip-elimination changes, requested as the speed follow-up to §0s.
Both were scoped by first re-reading what already exists (the §0s review
showed `chain::Pin::from_header` was sitting there unused, and recon proved
`newHeads` was subscribed **only** for the `flashblocks` source).

**#2 — the scan pins from the delivered header, not from a `latest` RPC.**
- `newHeads` is now subscribed for every live source (`logs`,
  `pending-logs`, `both` as well as `flashblocks`).
- `parse_head` reads the full header shape (number, **hash**, timestamp,
  baseFeePerGas); a zero hash (the `pending` pathology of §0k) or a missing
  timestamp drops the head instead of pinning garbage. `Trigger::Head` now
  carries `HeadInfo` (unit-tested parsing + an in-process WS fixture).
- `Scanner` keeps the newest head as a `chain::Pin`; `evaluate` uses it with
  **zero round-trips**. The freshness pass deliberately keeps
  `Pin::resolve_latest`: the socket's heads are consumed in the batch
  *before* the scan (single-flight), so during a scan the cached pin cannot
  know about a newer block — resolving is the only honest way to find one.
  The pinned-by-hash and
  re-org guarantees are untouched: the pin carries the head's own hash, and
  the post-scan header re-read still voids discarded blocks.
- Trust rule: the head may only pin reads when the subscription and the
  reads are the **same endpoint** (`chain::same_endpoint`, the §0i rule — a
  head from Alchemy names a block a local fork has never seen and vice
  versa). Split endpoints (the §0g test configuration) keep the old
  `resolve_latest` behaviour exactly. `Reconnect` drops the cached head
  until a fresh one lands.
- New timing `pin_ms` (`timingsMs.pin`, `avg_pin_ms`): the pin RTT was the
  one phase no metric admitted to (`head_started` began *after* resolving
  it); now its elimination is visible as `avg_pin_ms=0`.
- The post-scan re-org check and the drift read run concurrently
  (`tokio::join!`) — one RTT where there were two.
- Proof (fork, deterministic): `tests/pinned_block.rs::
  scans_pin_from_delivered_head` pins the scanner to block `head-1` via a
  synthetic head; the scan **must** report `head-1` (an RPC resolve can only
  return the head), the hash must match, and a split-endpoint scanner must
  ignore the same head. Reconnect restores the resolve path.

**#3 — one batched cost probe per candidate.** `simulate_route` now issues
`RyoCore.simulate` **and** `getL1FeeUpperBound` in a single pinned
`aggregate3` (`chain::multicall3_outcomes`, which keeps raw revert payloads
— `multicall_raw` collapses them to strings, and `simulate` answers through
its revert). The L1 input is derived from the simulate calldata length:
execute is the same encoding plus exactly one 32-byte `minProfit` word
(`simulate::execute_calldata_len`, unit-pinned for every step count
2..8 and every `data` width, and value-independent). The caller still
asserts the real execute calldata matches that length — ABI drift becomes a
loud inconclusive skip instead of a subtly mispriced fee. Classification is
byte-identical to before: revert payload → definitive loss (cached);
success-return, oracle failure, batch/transport error → inconclusive (never
cached). The freshness pass (a sequential per-finalist loop) inherits the
same batching.

**What was considered and rejected:** `eth_simulateV1` works on Alchemy
(hash-pinnable, per-call gasUsed, revert capture — all verified live) and
would additionally let the execute dry-run itself report real gas. It is
**unsupported by Anvil 1.9.0**, and every behavioural proof in this project
runs on a fork, so it stays out until that changes.

Measured (loopback + `tc netem 25 ms` one-way ≈ 50 ms RTT, matched
workload: 5 scans, 300 routes, 80 simulations, 80 opportunities each side):

| | old (a314e17) | new |
| --- | --- | --- |
| avg_scan_ms | 4331 | **3522** |
| avg_simulate_ms | 1943 | **1422** |
| avg_fresh_ms | 2236 | **1755** |
| avg_probe_ms | 618 | 604 (unchanged — control) |
| avg_core_ms / avg_gas_ms | 50 / 294 | 50 / 294 (controls) |
| avg_pin_ms | (invisible, ≈1 RTT) | **0** |

The deltas land exactly where RTTs were removed: one wave per candidate
(sim+l1 merged: 80 sims over 5 scans × ~50 ms), one sequential RTT per
freshness finalist, one pin RTT and one post-scan RTT per scan. Phase sums
can exceed the wall-time delta (§0h overlap caveat). On the public endpoints
measured today (RTT 35–65 ms from this box) the same structure removes
~2 RTT per scan outright and halves the candidate-path waves. Live watch
sanity on the Alchemy socket (unified endpoints): heads parse, no failed
scans, split-config §0s numbers unaffected.

Environment notes: `tc netem` needs the delay *off* before fork runs
(foundry's fork provider fails its initial balance fetch under it, with a
misleading "lack of funds"); `anvil_setStorageAt` seeding needs the real
Base-USDC balances slot (9 on this implementation — slot 2 silently wrote a
different mapping); the Balancer vault on the fork holds little USDC
(~66k at fork base, drained by repeated skews — re-seed between A/B
series). One test-design trap hit here: the head-pin proof must run with
`freshness: false` — the freshness pass re-pins to the newer head **by
design** (§0m), so a scan on a fork with live opportunities legitimately
reports the fresh block, not the pinned one; the first draft of the test
read that correct behaviour as a failure.

---

### 0u. The remaining big latency item: local swap math for the concentrated pools — scoped, NOT started (2026-11-03)

This is the whole handoff for the next task; a fresh session needs nothing
from the conversation that produced it.

**What and why.** §0j priced only the constant-product pools locally (4 of
the registry's 33: UniV2, both Aerodrome classic pools, aero cbBTC/WETH).
The other **29 concentrated-liquidity pools** (UniV3 ×8 tiers, Slipstream ×7
incl. cbBTC, Pancake V3 ×11 + the four new EURC/cbBTC tiers) are still
quoted on chain via QuoterV2 `eth_call` batches. That quoting is now the
dominant scan cost by every measurement taken this week: live `probe_ms`
p50 = 314 ms (hops 2) / 730 ms (hops 3) vs core 50 ms and gas ~1 ms; warm
fork full scan = ~1.0 s of which probe is ~95 %. §0t removed the pins and
the per-candidate waves; the probe is what stands between this watcher and
sub-100 ms reaction times. The bots that win cross-venue races keep pool
state in RAM and compute quotes locally in microseconds.

**The shape of the solution.** `amm.rs` already proves the pattern; the CL
version needs one more piece: per-pool tick state, maintained incrementally
from the Swap events the watcher *already receives* on its socket.

1. Port the V3 swap-step math bit-for-bit: `SwapMath.computeSwapStep` +
   `SqrtPriceMath` (direction-dependent rounding is part of the contract —
   a "close enough" port will disagree with the quoter at the last wei and
   fail the differential). Reference: `uniswap-v3-sdk` on docs.rs (a
   feature-complete Rust port with the official unit tests),
   `aleexeyy/clmm-swap-math` (in-memory V3Pool simulator), and the
   computeSwapStep walkthroughs at uniswapv3book.com. Verify the choice
   against upstream `v3-core` source, not a crate README.
2. Per-pool cache: `slot0` (sqrtPriceX96, tick, liquidity) + initialized
   ticks with their gross liquidity. Bootstrap per pool (tick bitmap walk,
   batched through Multicall3, bounded to the tick range a probe size can
   realistically cross), then apply each live Swap event's own
   `sqrtPriceX96/liquidity/tick` words — the event carries the *answer*, so
   steady-state maintenance is free. Reconnect and §0t's re-org-void path
   force a re-bootstrap; staleness beyond a few blocks must degrade to
   remote quoting, never to a wrong price.
3. Fees: `fee()` is per-pool static state (already read for floors every
   30 s); Slipstream fees do **not** follow tick spacing (§0p measured:
   ts=10 and ts=50 charge 5 bps, ts=100 charges 8.33, ts=1 charges 0.8).
   Pancake uses the same math with its own tier set (§0q); its Swap event's
   extra `protocolFeesToken{0,1}` words do not affect quote math.
4. The §0j rules bind again, non-negotiable: every operator `checked_*`
   (U256's `+ - *` wrap silently); a local refusal means *quote it on
   chain*, never *this route is unprofitable* (`price_leg`'s
   `LegPrice::{Local, Onchain}` already has the right shape); and
   `examples/capture_pin.rs`-style pinned ground truth generated from a
   fork, not hand-written constants.

**Decisions to make early (they shape everything else).**
- *Pinned-state honesty.* Quotes computed from a cache updated by live
  events describe "the chain as the socket saw it", not "one pinned block".
  That is already how floors work (advisory, §0p), but quotes feed money
  numbers: the opportunity path (`plan`, simulate-what-you-propose) must
  keep quoting at the pin. The safe split — and probably the right one —
  is local math for the PROBE/REFINE search (candidate selection, already
  advisory: finalists are always re-simulated on chain at the pin by
  `simulate_route`, so a stale quote can only mis-rank, never mis-pay) and
  quoter calls for the finalists. Write this choice down in the code
  before porting a single function.
- *Where the cache lives*: the Scanner (it owns the event stream and the
  dedupe/reconnect lifecycle) with a `HashMap<pool_index, ClPoolState>` +
  tick cursors; not a global.
- *Tick discovery bound*: cap ticks walked per direction per bootstrap
  (probe sizes are ≤ $8k; the cheapest deep pools need tens of ticks,
  thin ones hundreds — refuse and go remote past the cap).

**Test plan.** Extend `tests/local_math.rs` (it already diffs local vs
`venues::quote_step` itself, the scanner's real encode→eth_call→decode→
reject-zero path, bail-style) with concentrated pools: amounts that (a) stay
inside one tick, (b) cross initialized ticks, (c) cross initialized-and-
zero-liquidity ranges, (d) large one-sided flows on the thin Slipstream
pools — in both directions, per pool family. `amm.rs`-style adversarial
sweeps for overflow discipline. A fork differential run + live Base run
must both show exact-match counts (not tolerance) or consistent refusal.
Then the §0p-style live A/B on the Alchemy socket: probe_ms p50 before/after
over matched windows (this file's §0s/§0t tables are the template), and
`fork_opportunity`/`tier1_expansion` execute runs to prove
realized == simulated is untouched.

**Measured baseline to beat** (2026-11-03, live Alchemy, unified endpoint,
§0s/§0t builds): probe p50 314 ms / p95 334 ms (hops 2), 641/811 (hops 3);
avg scan 153/399 ms; full warm-fork scan ~1.0 s / 6.2 s.

**Related-but-separate leftovers** from the same review: `eth_simulateV1`
would fold the execute gas estimate into §0t's batch (verified available on
Alchemy Base — hash-pinnable, per-call `gasUsed`, revert capture — currently
blocked: Anvil 1.9.0 returns a parse error for it, and every behavioural
proof here runs on a fork); the freshness pass could consume socket heads
instead of re-resolving once single-flight ordering is revisited; and
`--max-hops 3` as the default (the §0s A/B supports it, and the local math
makes 3-hop probes cheap too).

---


### 0v. Local CLMM swap math shipped: bit-for-bit, live-differentialed (2026-11-04)

§0u was executed in full. The watcher now prices all 29 concentrated pools
from RAM during probe/refine, and the quotes are **identical to the on-chain
quoters at the last wei** — verified repeatedly against live Base through the
Alchemy endpoint, including the quoters' `sqrtPriceX96After` word (agreement
there proves the tick *walk* matches, not just the final amount).

**What was built.**

- `src/clamm.rs` (~1,150 lines): a line-for-line port of the V3 quoting path
  — `TickMath.getSqrtRatioAtTick/getTickAtSqrtRatio`, `FullMath.mulDiv(+Up)`,
  `SqrtPriceMath`, `SwapMath.computeSwapStep`, `TickBitmap` word search, and
  the `pool.swap` main loop. The port mirrors upstream **arithmetic flavour
  per call site**: v3-core compiles at solc 0.7.6, where plain `uint` ops
  wrap, explicit casts truncate, and only SafeMath helpers revert. Wrapping
  where the contract wraps (`mulmod`-style products, the tick-magic ladder),
  `checked_*` where it uses SafeCast/LowGasSafeMath/LiquidityMath, assembly
  div-by-zero semantics where it uses assembly. Every refusal is a `None`
  meaning "quote on chain", never "unprofitable" — the §0j rules, restated
  in the module header.
- **Protocol fees are not modelled, on purpose**: `swap()` deducts
  `amountIn + feeAmount` from the remaining input *before* the protocol
  carve-out moves part of the fee aside, so quoted amounts are independent
  of `slot0.feeProtocol` (verified against Pancake, whose defaults run
  32–34 % protocol share, and Pancake's 6-field slot0 layout).
- **Bootstrap**: 3-round Multicall3 read per pool at one block — slot0/fee/
  liquidity/tickSpacing, a ±16-word tick-bitmap band, then every initialized
  tick inside the chosen coverage (soft cap 300 ticks, denser side wins;
  the band always covers the current word). `tickSpacing` is read from the
  pool, never derived from the fee tier. A Slipstream spacing hint mismatch
  against the pool's own answer ⇒ the pool is dropped (remote), never trusted.
- **Maintenance**: Swap events carry the post-state (`sqrtPriceX96`,
  `liquidity`, `tick`) — applied from the trigger stream at zero RPC cost.
  Any *other* pool log (Mint/Burn/Collect/unknown shape) marks the pool
  stale: re-bootstrap on the next scan. `Trigger::Reconnect` and the §0k
  re-org-void path mark the whole cache stale. Slipstream `fee()` is
  refreshed per scan for non-rebootstrapped dynamic pools.
- **Honesty split (§0u's pinned decision, written into the code first)**:
  local CL math serves probe/refine candidate selection only. `plan`,
  finalist quoting in the freshness pass, and `simulate` all stay on chain
  at the pin — the money numbers never read from this cache.
- **The armed gate.** A cache is only honest while its owner consumes the
  log stream that keeps it current. `evaluate` called directly (CLI `scan`,
  the fork tests) never feeds events, so a pre-skew cache would silently
  mis-price legs that can never self-heal. Found the hard way:
  `fork_opportunity` went to 0 opportunities because its first `evaluate`
  bootstrapped the cache *before* the skew and the second trusted it after.
  Fix: `cl_armed` — the local path engages only after `scan_triggers` has
  consumed a batch (watch mode); direct-evaluate callers are pure remote,
  exactly the pre-§0v behaviour. `--no-local-cl` disables the path entirely
  (A/B and safety valve; finalists/plan unaffected).

**Verification (all on 2026-11-04, this machine: Rust 1.99.1, Foundry/Anvil
1.9.0 installed from the release tarball into `~/.foundry/bin`).**

- **Upstream-vector unit tests** (`clamm::tests`, 11): the 28 explicit
  `getSqrtRatioAtTick` rows from v3-core's own `TickMath.spec.ts.snap`;
  MIN/MAX tick and sqrt-ratio boundaries; the `getTickAtSqrtRatio` spec
  vectors incl. `MAX_SQRT_RATIO-1 = MAX_TICK-1`; `mulDiv`/`mulDivRoundingUp`
  MaxUint256 and Q128 ratios against independently computed decimal
  constants; all five fully-explicit upstream `computeSwapStep` vectors
  (incl. the insufficient-liquidity exact-output ones); bitmap word search
  incl. negative-tick floor compression and unknown-word refusal; a dense
  round trip (8,200 ticks + the 19 magic-number cut points); monotonicity;
  dust/absurd-input refusals. `cargo test --lib`: 128 pass.
- **Live differential** (`tests/cl_local_math.rs`, ignored, `RYO_LIVE_RPC`):
  every CL pool × both directions × a 10-step amount sweep (1 wei dust to
  ~$8k-scale units), local vs the exact quoter calls the remote path makes,
  **both at the same pinned block**. Four independent runs: exact matches
  531/556 every time, `sqrtPriceX96After` agreement on all of them, **0
  mismatches**, 25 coverage refusals (thin pools at the biggest sizes —
  the designed degrade-to-remote), 0 dangerous refusals. `cl_local_math`
  also asserts a local in→out→in round trip never returns more than it paid.
- **Event-replay differential** (`maintained_cache_matches_after_live_event_replay`):
  bootstrap, replay real chain logs from a ~9-block window through the same
  entry point the trigger loop uses (161–262 swap after-states applied; 34–76
  non-swap logs stale-marked), refresh dynamic fees, then repeat the full
  differential at the newer pin. Fresh caches: 493/518 exact (95 %),
  0 mismatches; stale-marked pools refused everything they should. Floor
  applies to *fresh-pool* comparisons only — stale ⇒ refuse is designed
  behaviour, not a defect.
- **Fork playbook** (anvil fork of the Alchemy HTTP endpoint, standard
  `Deploy.s.sol` + manifest): `validate` 33 pools OK; `local_math` (CP) pass;
  `pinned_block` 5/5; `tier1_expansion` 4/4 (incl. the executing triangle);
  `fork_opportunity` with `RYO_FORK_EXECUTE=1`: skew → scan (with the armed
  gate: pure remote, deterministic) → 8 opportunities → `execute` broadcast →
  **recipient gained exactly the simulated profit** (7154041966121413 WETH
  wei, realized == simulated); Foundry suite 133/134 (one pre-existing
  market-drift flake in `test_fork_core_arbitrage_aerodrome_to_univ3` whose
  fixed 60k skew no longer clears the fee threshold on today's deeper pool
  state — passes on retry; no Solidity was touched).
- **Latency A/B** (watch, live pending-logs socket + fork HTTP, 100 triggers
  each, same warm fork): `--no-local-cl` avg_probe_ms 6594 (4 scans) vs
  local CL avg_probe_ms **119** (9 scans, simulations exercised): ~50x on
  the probe stage and >2x scan throughput in the same window. The fork
  exaggerates the remote side (QuoterV2 `eth_call` through anvil's EVM on
  fetched state), so treat 119 ms as fork-bound evidence of *eliminated*
  round-trips, not the live floor; the honest live number (vs §0u's 314 ms
  p50) can only be measured once the core is deployed on mainnet and the
  full read path runs live.
- `cargo clippy --all-targets` clean, `cargo fmt --check` clean,
  `events_ws` pass, README + `--no-local-cl` documented.

**Known bounds and leftovers (deliberate).**

- Coverage refusals at oversized probes (~25/556): thin pools cross past the
  cached tick budget. The right lever is raising `TICK_CAP_PER_DIRECTION`
  or making it size-aware, not chasing 100 %.
- A swap that lands *while* a bootstrap read is in flight can miss that
  one event (window ≤ 1 scan); the price self-heals on the pool's next
  event, and finalists are on-chain-verified regardless.
- Slipstream fee staleness between per-scan refreshes can only mis-rank a
  probe candidate; it can never mis-pay.
- `local_math.rs`'s CP sweep still skips CL legs on purpose; the CL side has
  its own differential (`cl_local_math`) which additionally checks the
  sqrt-after word.
- `examples/capture_pin.rs` could grow a CL mode (generate pinned CL ground
  truth the way §0j did for CP). Not needed: the live differential is the
  stronger oracle.
- Fork tests and live tests must not run concurrently against one Alchemy
  key (429s); serialized runs are stable. `pinned_block`/`fork_opportunity`
  snapshot+revert per test: run fork suites with `--test-threads=1`.
- The skew tests (this one and `fork_opportunity`) fund themselves from the
  **Balancer vault's live USDC balance, which oscillates between ~$0 and
  ~$75k** as pools rebalance; a freshly forked head can fail them outright
  ("vault only holds 0 USDC"). Deterministic recipe: `anvil --fork-url
  <alchemy> --chain-id 8453 --fork-block-number <block>` pinned to a moment
  when the vault was funded (53510471 worked on 2026-11-04), then redeploy.
  Worth fixing properly later: fund a fresh test address with `cast`-style
  impersonation of a big USDC holder (e.g. an exchange whale) or
  `anvil_setStorageAt` the vault slot, instead of depending on a
  third-party's balance luck. Same category as §0r's note that the fixed
  60k skew is market-state-sensitive.

---


### 0w. Race-readiness program: gap autopsy → replay benchmark → optimize, in a loop (started 2026-11-04, Phases 1–2 done, 3–4 open)

This is the full handoff for the next session; nothing from the conversation
is needed to execute it. §0v made the watcher *reflex-fast and provably
correct*; what nobody has yet measured is **whether it can win real races**:
every live watch run so far (§0o, and §0v's A/B runs again) found 0
opportunities on un-skewed traffic. The inference is that cross-venue gaps
close before a same-block-late scanner arrives — but that has never been
quantified, and neither has our own time-to-ready-calldata. This program
turns both into numbers and then optimizes against them.

**PROGRESS 2026-11-04 (later hours of the §0v session) — Phases 1–2 landed.**

- Phase 1: the harvester bug was real and is FIXED (`history.rs`: filters
  chunked to ≤10 addresses, range-split depth raised to 8; unit test
  `filters_respect_the_address_cap`). 24 h of events downloaded to
  `data/swaps_24h.jsonl` (157 MB, 340,396 events, git-ignored — regenerate
  per session with the runbook command below; it takes ~5 minutes against
  publicnode).
- Phase 2: `tools/gap_autopsy.py` works and produced **Record A** (reports
  committed nowhere; regenerate with
  `python3 tools/gap_autopsy.py data/swaps_24h.jsonl data/gap_autopsy_24h.md 2.0`,
  and at 20/60/200 bps). Headline numbers from the 24 h window
  (blocks ~53470.7k..53513.9k, 2026-11-04):
  * ≥2 bps episodes: **63,630** (~44/min), 25% closed in the opening block,
    median lifetime 3 blocks (~6 s), p90 12 blocks;
  * ≥60 bps (the bot's approximate round-trip cost line): **22,624**
    episodes/day, only 19% same-block-closed;
  * ≥200 bps: **1,537**/day, 29% same-block-closed → **71% of ≥2% gaps
    survived the opening block**, median life still ~3 blocks;
  * the largest (≈470–494 bps) cluster on the thin `slipstream:50`
    WETH/USDC pool and concentrate in two blocks (53506881, 53507843) —
    ideal replay targets: one fork pin covers several episodes;
  * named competitors (recipient of the closing trade):
    `0x51C72848c68a965f66FA7a88855F9f7784502a7F` closed **3,265** episodes in
    24 h (one every ~26 s), then `0x278d858f…` 814, `0x29BE31E7…` 758,
    `0x7c4c7Ac3…` 611, `0x8F10B468…` 574 — study and decode their closing
    txs first (Phase 4 lever 8 now has concrete targets).
  * Verdict shift: opportunities are NOT scarce — the open question is now
    precisely "why does the watcher's live path see zero": pin staleness
    (head−2 ≈ 4 s into a median-6 s lifetime), the floor/dust screens, or
    real-size slippage eating price gaps on thin pools. The replay harness
    answers this.
- Remaining §0v tails as of this push: `dynamic_floors` PASSED on the warm
  pinned fork (1190 s); `fork_simcache` still FAILED there ("re-simulated
  everything, sims_cached=0") — hypothesis unchanged (its 60k-skew scenario
  outcome is market-state-sensitive: on the pinned block the vault funded
  only a 15.8k skew). Next session: rerun with `--nocapture` on a fork
  pinned where the vault holds ≥ 60k, and only suspect the code if the two
  scans pin the same block and the cache still misses.
- Phase 3 prep note: the autopsy currently stores `open_block`/`peak_bps`
  per episode but NOT the opener tx hash / log index; add
  `open_tx`/`open_log`/`open_pool` fields (the per-pool last event of the
  opening block) before building the replay harness — a draft of this
  extension exists in the session history pattern: track `last_event[p]`
  alongside `last[p]`. The replay draft example was deliberately NOT
  committed (incomplete; raw-tx re-broadcast is fragile — use
  anvil-impersonation re-send of the opener's `to`/`input` from the source
  tx instead).
- Phase 4a-1 (prime the CL cache at watch startup instead of inside the
  first scan) is DONE (`Scanner::prime_cl`, called from `watch_command`
  before the loop). Phase 4a-2 (per-scan `cl_states` HashMap clone cost)
  not measured yet — measure inside the replay harness.

**The scoreboard we are trying to beat (the "records").**
- *Record A (competitor):* the distribution of **gap close times** on Base,
  measured from mined history: for each detected gap opening, the ordering
  of events within the opening block (logIndex) shows whether a searcher
  closed it in the same block, the next one, or later. Mined data gives
  2-second bucket + within-block ordering, not sub-block wall time —
  enough to build a close-time distribution and a hard bar.
- *Record B (ours):* **trigger-received → ready-calldata** latency of this
  pipeline, replayed against those exact historical moments. Today's
  evidence points (probe_ms p50 314 ms remote / fork A/B 119 ms with local
  CL, §0v) are starting values, not results — the replay harness produces
  the real series.
- *Winning condition, raised every pass:* our B distribution beats the A
  distribution's median → then its p75 → then p90. When we can send (mainnet
  deploy + live mode), the scoreboard flips to empirical: simulated-winner
  rate vs landed-vs-gone ratio. Until then, paper-racing only — the hard
  constraints below hold.

**Phase 1 — Harvest the history (fix the harvest first; it is broken today).**

- Bug found 2026-11-04 while attempting the first download: `history.rs`
  `groups()` puts **all 29 CL pools in one filter**; `base-rpc.publicnode.com`
  rejects any `eth_getLogs` with >10 addresses (`error -32602: A maximum of
  10 addresses is allowed`), and the failure handler splits only the *block
  range* (down to 15-block chunks) while re-sending the same 29 addresses —
  so it can never succeed. **Fix:** slice each group's addresses into ≤10
  per request (4 CL groups: 10+10+9 plus the CP group's 4 — and note the
  group split must not mix CL and CP signatures since topic0s are grouped
  too: keep the two event-shape groups separate, sub-split addresses inside
  each). Also worth trying: publicnode's *dedicated* free endpoints, which
  their error message itself advertises as uncapped.
- Endpoint budgets: Alchemy free caps `eth_getLogs` at **10 blocks per
  request** (§0r) → 24h = ~4,320 range-requests; publicnode takes 500-block
  ranges but 10 addresses → 24h ≈ 86×4 requests per address-group. Harvest
  from publicnode, keep Alchemy for state/simulation work, never run both
  heavy paths against the Alchemy key concurrently (429s, §0v note).
- Runbook:
  `./target/debug/ryo-watch --http-rpc https://base-rpc.publicnode.com history --blocks 43200 --chunk 500 --out data/swaps_24h.jsonl`
  `SwapRecord` already carries, per event: block, **block timestamp**, tx
  hash, **log_index**, pool, venue, signed deltas, and for CL pools
  **sqrt_price_x96 / liquidity / tick** — every CL pool's full price state
  after every swap, offline. That is the entire raw material for Phase 2.

**Phase 2 — Gap autopsy (offline analysis; Python over the JSONL is fine).**

- Price reconstruction: for each CL pool, price = (sqrtPriceX96/2^96)^2 ×
  10^(dec0-dec1); event order = (block, log_index); state after each event
  is the event's own words (no RPC).
- Pair pools by token pair (USDC/WETH ×12 pools, USDC/cbBTC ×6, WETH/cbBTC
  ×7, EURC pairs ×3); for each ordered pair of pools on the same pair, a
  **gap** exists when the cross price after fees+buffer clears:
  p_out/p_in − (fee_i + fee_j + slippage + profit buffer) > 0 using the
  watcher's own cost model constants; report gap opens, their USD size at
  the $500–8k probe sizes (use the local CL math itself to size them), and
  their lifetime in blocks and in log-position.
- **Who closed it:** same-block sequences `big trade → gap opens →
  counter-trade(s) by the same tx or address across the other pool` =
  searcher close. Record: did it close in-block or later, and how many
  log-positions the winner had after the open (queue-position proxy). This
  builds Record A and, as a bonus, names the competitor txs worth reading
  (they are public on Base — their *timing*, gas and route choices are the
  market intel).
- Granularity caveat to state in every chart: mined blocks are 2 s buckets
  and Flashblocks (200 ms) do not exist in mined history at sub-block
  resolution — treat "closed in the same block it opened" as the fast
  bucket and size our target against it, not against 2 s.

**Phase 3 — Replay benchmark (our pipeline against those moments).**

- Determinism recipe proven today: `anvil --fork-url <alchemy> --chain-id
  8453 --fork-block-number <N>` reproduces exact chain state (the vault
  balance oscillation that broke §0v's fork runs disappears when pinned).
- Harness (new, `examples/` or an ignored test): fork pinned to `block_of_gap_open − 1`;
  bootstrap the CL cache as a watcher's would (a first `scan_triggers` batch
  arms it); feed the recorded events from `block+1..` as synthetic
  `Trigger::Log`s through `scan_triggers`; measure trigger→scan-report→
  ready-calldata (`plan`'s output shape, never sent); assert the *prices we
  see in replay match the autopsy's* (independent oracle chain: autopsy
  price vs local math vs quoter). Then compare B vs Record A.
- The paper-race verdict per replayed gap: `ready_time` vs the gap's
  measured close position ⇒ would we have made it, given same-block
  inclusion? Report the win-rate curve, not a single number.
- Reuse from today, do not rebuild: `clamm.rs` (local CL math + cache),
  `tests/cl_local_math.rs` (bootstrap at any pinned block + diff arms),
  the A/B flag (`--no-local-cl`), and `history.rs` (the dataset).

**Phase 4 — Optimize in a loop (every lever: side-test with the replay,
keep only real wins, update State.md records each pass).** Use web search
+ GitHub aggressively here — the ecosystem is public. Non-exhaustive list,
roughly ordered by expected yield:

1. **Bootstrap-before-first-trigger**: today the cache builds *inside* the
   first evaluate (the wave delays the very first scans). On `watch` start
   (and on every re-bootstrap wave), do the CL bootstrap concurrently with
   waiting for triggers, not serially before the first scan.
2. **Per-scan cache clone**: `cl_states` clones every pool's bitmap+ticks
   HashMap per scan; measure it, then share via `Arc<Mutex<..>>` interior
   patterns or diff-apply, if it shows up in `probe_ms`.
3. **`eth_simulateV1` for candidate batches** — works on Alchemy today,
   blocked only for *fork-proofing* the tests (Anvil 1.9.0 parse error);
   the replay harness can verify it live-first (fold execute-gas into §0t's
   batched probes). Search: `eth_simulateV1` examples on Base/OP Stack.
4. **Trigger source**: `pendingLogs` (~1 s early, lands pool+words) is the
   default; Flashblocks (200 ms) give `newFlashblockTransactions` (tx hash
   only — cannot identify the pool, §6.B) — research whether Alchemy's
   flashblock payloads can be paired with a fast `eth_getBlockReceipts`-style
   enrich, and what dedicated node services expose. This is the single
   biggest potential cut to *observed* price-change time.
5. **Single-flight pipelining** (next trigger starts while a scan runs):
   deliberately out per §6.G; the replay benchmark is the right place to
   re-evaluate with data rather than re-litigate it by argument.
6. **Coalescing default** (`--coalesce-ms`) tuned against Record A, not vibes.
7. **Tick budget by probe size**: `TICK_CAP_PER_DIRECTION`/`WORDS_PER_DIRECTION`
   currently fixed; size them from the probe grid so ~all realistic probes
   resolve locally (today's leftovers: ~25/556 coverage refusals).
8. **Competitor study**: decode the fast-close txs found in Phase 2
   (`decode` CLI + public traces) — their routes, sizes, and venues tell
   us where the crowding is; prefer the uncrowded corners (Slipstream odd
   spacings, cross-venue legs) for the $0.25-floor probes.
9. Long shots (research first, timebox): private orderflow / sequencer
   submission on Base (docs), running our own full node with local
   Flashblocks stream, Rust-side hot-path profiling of
   scanner→multicall→WS (flamegraph the replay runs).

**Hard constraints inherited, unchanged:** dry-run/paper only until the core
is deployed on mainnet AND the user opts into live explicitly; no
priority-fee bidding; no separate flashblock fee; finalists/plan always
priced on chain; every local refusal means "quote on chain", never
"unprofitable"; keys live in the environment only; explain state simply to
the user at every handoff.

**Open §0v tails to close before/at the start (housekeeping, small):**

- `fork_simcache` failed twice on 2026-11-04 (first run: the vault-skew
  funding drift documented in §0v; second, at the pinned solvent block, on a
  *cold* fork: "second full scan re-simulated everything (simulations=8,
  sims_cached=0)" after 1396 s). Working hypothesis: with multi-second state
  fetches the two scans pinned different heads, so the input-pinned cache
  correctly refused to reuse (not a §0v regression: the armed gate makes the
  scanner's read path identical to the pre-§0v build that passed this test
  on 2026-11-01). Verify by rerunning **on the now-warm pinned fork** with
  `--nocapture`; if it still fails with equal pins, bisect against
  `git stash`/revert of §0v's `quote_jobs` signature change — the behavior
  difference surface is provably only the two map arguments.
- `dynamic_floors` was mid-run at §0w writing time (on the same pinned
  fork); record its outcome here when in.
- `deployments/8453.anvil.json` was rewritten by today's redeploys (different
  nonce-dependent addresses than the committed one). Local-fork file only;
  decide whether to commit it or keep the October version.

**Definition of done for the program (v1):** Phase 1 dataset downloaded with
the fixed harvester; Phase 2 gap/close report + Record A distribution
committed under `data/`; Phase 3 replay harness merged as a test/example
with its first B-vs-A win-rate curve; Phase 4 items 1–2 done and recorded,
each lever's keep/drop evidenced in this file. That is when we can answer
"can it compete today" with numbers instead of inference.

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

# #1/#2 verification (needs the Anvil fork below, or RYO_LIVE_RPC for live Base)
cargo run --example capture_pin                      # reprint the pinned tables
cargo test --test local_math -- --ignored --nocapture # local vs venues::quote_step
cargo test --test pinned_block -- --ignored --nocapture --test-threads=1
cargo test --test fork_simcache -- --ignored --nocapture
cargo test --test dynamic_floors -- --ignored --nocapture
./target/debug/ryo-watch --manifest deployments/8453.anvil.json floors

# Read-only checks against live Base (no RyoCore needed; real prices)
RYO_LIVE_RPC="$BASE_HTTP_RPC" RYO_LIVE_MANIFEST=deployments/8453.example.json \
  cargo test --test pinned_block pin_block_and_hash -- --ignored --nocapture
RYO_LIVE_RPC="$BASE_HTTP_RPC" RYO_LIVE_MANIFEST=deployments/8453.example.json \
  cargo test --test local_math -- --ignored --nocapture

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

> **Race-readiness program (§0w Phase 3–4) has its own dedicated, always-current
> handoff: see `RACE_PROGRAM.md` at the repo root. It is the single resume point
> for that program and records the exact in-flight blocker (the replay
> harness's clock-pin vs deploy-blocks bug) and the post-Denim 200ms win bar.**

Pick up **§0w: the race-readiness program** — it is the full handoff
(harvest bug fixes, gap-autopsy method, replay harness design, the record
definitions, the ordered optimization levers, and the small §0v tails to
close first). Then, in value order: deploy the core + adapters on Base
mainnet (the gating item for going live — it also unlocks the honest live
probe-latency number vs §0u's 314 ms baseline), decide `--max-hops 3` as
the default (the §0s live A/B — 153 ms vs 399 ms — supports it, and local
CL math makes 3-hop probes cheap too), `eth_simulateV1` candidate batches
once Anvil supports fork proofs of it (it works on Alchemy today), Uniswap
V4 as the largest venue gap (start hookless-only pools; hook fields are
immutable per pool, so a hookless whitelist never needs revisiting; audit
hook contracts separately if ever included), size-aware CL tick budgets,
profit-only failed-sim caching, and CI.

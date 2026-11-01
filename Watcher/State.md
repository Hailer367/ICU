# Ryo Watcher — Development State

Last updated: 2026-11-01 (end-to-end campaign; see §0n)

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

#1 (local constant-product math, §0j), #2 (one pinned block per scan plus
simulate-what-you-propose, §0k), the fail-closed cost reads (§0l — the L1
fee upper bound is read per candidate at its real tx size and can no longer
default to zero), the freshness pass (§0m — finalists re-priced at a new
pin, all-or-nothing) and the end-to-end campaign (§0n — every venue executed
on chain with `realized_gain == simulated_profit`, plus three fixes: stderr log
writer, `effective_cap`, `skipped` metric) are finished and verified against
real Base.
Next in value order: cache only
profit-related reverts in the failed-sim cache and separate the `RyoCore` and
adapter error namespaces, which currently both claim `ZeroAddress()`. Then CI,
because every behavioural proof above is `#[ignore]`d and needs a live fork.
Everything else that can be verified without a mainnet deployment is done: live
Alchemy events (use `--source pending-logs` or `both`), full scan loop on a
deployed fork, and the 24h dataset for replay.

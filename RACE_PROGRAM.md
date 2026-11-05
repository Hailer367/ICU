# RACE-READINESS PROGRAM — dedicated handoff (§0w Phase 3–4)

> **This file is the single resume point for the race-readiness program.** It
> exists so a fresh session can pick up mid-loop with zero chat context. Read
> it top-to-bottom once, then run the "RESUME HERE" block. It complements (does
> not replace) `Watcher/State.md` §0w, which is the running log.
>
> Status date: **2026-11-05 (~20:00 UTC).** Denim activated today at 18:00 UTC.
> Last green unit-test count on this box: **129 lib tests** (`cargo test --lib`).

---

## 0. What this program IS (read first)

The watcher (`Watcher/`, Rust crate `ryo-watch`) already **finds and prices
trades correctly** and is **reflex-fast in isolation** (§0v shipped bit-for-bit
local CLMM math). What has NEVER been measured, and is the whole point of this
program, is whether it can **win real races** against incumbent Base arbitrage
bots. Every live watch run to date found **0 opportunities on un-skewed
traffic**. The open question is *why*, and the answer is a number we don't have
yet: our trigger→ready-calldata time vs the market's gap close-time.

**The mission, restated as the user gave it:** pin the watcher against REAL
historical market data, measure our speed, measure how fast OTHER bots close
gaps, then **constantly edit the bot's code, side-test each change, search the
web and reference GitHub code, use subagents, and repeat until the bot is
demonstrably faster than those bots and actually lands the close first —
LOCALLY, with NO real money ever.** It is a loop, not a one-shot. Keep iterating
until `Record B` (ours) beats `Record A` (theirs).

### ABSOLUTE MUSTS (do not violate, every iteration)
- **Dry-run / paper only. NEVER sign or send a transaction.** `--mode live`
  still logs only; sending is intentionally unimplemented and must stay so until
  the user opts in AND the core is deployed on mainnet.
- **No priority-fee bidding.** Minimum/default tip only. This is a user policy,
  not a bug to optimize away. (See §5: the market data shows winners pay only
  ~0.4–1.2× base fee, so this costs little — that is the whole reason the policy
  is survivable.)
- **Every local refusal means "quote it on chain", never "this route is
  unprofitable."** Fail closed on config/oracle/unknown-revert.
- **Finalists and `plan` are always priced on chain at the pin**; local RAM math
  (clamm.rs) is advisory candidate selection only.
- **No secrets in the repo.** Alchemy key lives only in `~/.ryo_env` (outside the
  repo, chmod 600, never committed). The GitHub PAT is session-scoped — the user
  must revoke after pushing. Never write either into any file.
- **Correctness before speed.** Every lever change must keep `fork_opportunity`
  paying *exactly* the simulated profit and every pinned-block invariant green.
- Explain state simply to the user at each handoff.

---

## 1. Environment on this machine (already set up)

- Rust `1.99.1`, cargo. Foundry **1.9.0** installed at `~/.foundry/bin` and
  `~/.config/.foundry/bin` (add to PATH: `export PATH="$PATH:$HOME/.foundry/bin"`).
- 4 cores / 15 GB RAM. `Watcher/target` grows to several GB — never commit/zip.
- Alchemy Base endpoints live in **`~/.ryo_env`** (`ALCHEMY_BASE_HTTP`,
  `ALCHEMY_BASE_WS`), never in the repo. `source ~/.ryo_env` before any command
  that needs Alchemy. The key is free-tier: bulk `eth_getLogs` 429s on
  CU/s (~44% through a 24h pull); it is fine for WS, state, and fork fetch.
- `data/` is git-ignored (holds the multi-hundred-MB JSONL datasets — regenerate,
  do not commit).

### Free-tier / endpoint facts (measured this session)
- publicnode serves bulk `eth_getLogs` (500-block ranges) and is the harvest
  source; it caps **10 addresses per request** (harvester already sub-splits).
- `mainnet.base.org` rejects `eth_getLogs` outright.
- Alchemy free: `eth_getLogs` ≤ **10 blocks**/request; 429 on heavy concurrent
  reads — serialize fork tests vs live runs.

---

## 2. What was BUILT this session (all committed or in the working tree)

New/changed files (Phase 1–4 scaffolding):

- `Watcher/tools/gap_autopsy.py` — **rewritten closers logic**: now finds the
  FIRST counter-pool trade strictly after the gap opens (the actual race winner,
  not the last trade in the block), and emits per-episode: `close_lag_blocks`,
  `close_pos_gap` (in-block log-index distance opener→winner = queue-position
  proxy), `close_tx`, `closer`. Fixed an O(events×episodes) blowup with bisect so
  309k events analyze in ~3.7 s (was timing out at >300 s).
- `Watcher/tools/winrate_curve.py` — **NEW.** Turns episode JSON + a ready_ms
  threshold into a win-rate curve. Models: same-block close needs
  `ready_ms ≤ lead`; later-block close needs `ready_ms ≤ lag × block_period`.
  Flags `--period 2.0 --lead 1200` (pre-Denim) vs `--period 0.2 --lead 0`
  (post-Denim canonical 200ms blocks, no preconf lead).
- `Watcher/tools/race_replay.sh` — **NEW.** One-shot harness runner: computes the
  fork base block from the episode, starts a pinned Anvil fork, deploys core +
  5 adapters, snapshots, runs `tests/replay_race.rs`, appends the JSON summary to
  `data/race_results.jsonl`. Supports `--reuse` (revert to snapshot, keep warm
  fork cache) and forces a cold restart when base differs or reuse is unsafe.
- `Watcher/tools/denim_cutover.sh` — **NEW.** Verifies Denim landed (block time),
  harvests a post-Denim window from publicnode, rebuilds Record A at 2/60/200bps,
  prints post-Denim win-rate curves (`--period 0.2 --lead 0`).
- `Watcher/tests/replay_race.rs` — **NEW, ~560 lines, `#[ignore]`d.** The Phase-3
  block-faithful replay harness (§4 below).
- `Watcher/src/clamm.rs` — added an optional `RYO_TRACE_BOOT=1` bootstrap-chunk
  trace (harmless, env-gated) used to watch progress.

Datasets produced (git-ignored, under `data/`): `swaps_24h.jsonl` (309k events,
publicnode), `swaps_post_denim.jsonl`, and `gap_autopsy_24h_{2,60,200}bps.{md,json}`
+ `gap_autopsy_denim_*.{md,json}`.

---

## 3. RECORD A — what the market actually does (the bar to beat)

Two regimes because **Denim fired at 18:00 UTC today**. This matters enormously
for interpreting deadlines.

### Pre-Denim (2000ms blocks, 200ms flashblocks, pendingLogs ~1.2s lead)
24h window, blocks ~53548970..53592170, strict first-counter-trade measurement:
- ≥60 bps episodes: **3624**; same-block-close only **6**; lag 6+ = 3605.
- ≥2 bps episodes: **48832**; same-block 4%, lag 6+ 88%.
- Contested cohort (close_lag ≤ 1, both sides deep pools) at ≥60bps: **~11/day** —
  extremely thin. Deep↔deep gaps almost never get raced; the fast same-block
  action is on **thin pools** (slipstream:50/200 as the BUY/stale side).
- Same-block close POSITION gap (log-index distance opener→winner): **median ~200–344**.
- Dominant 2bps same-block closer: `0x51C72848…` (**500/day** = one every ~26 s),
  then `0x7c4c7Ac3…` 166, `0x29BE31E7…` 95, `0x278d858f…` 91.

### Post-Denim (canonical 200ms blocks — pendingLogs/Flashblocks GONE)
Verified live: **190 ms/block**. This is the new reality. From
`tools/denim_cutover.sh` over a 1h window:
- ≥60 bps contested (lag ≤1) ≈ **46/h**; winnable fraction:
  - ready ≤100ms → ~36%, ≤200ms → ~36%, **≤400ms → 0%**.
  The whole post-Denim race lives inside **one 200ms block**. If ready_ms > ~200,
  you are structurally too late for the contested cohort at every bps level.
- **Implication: post-Denim the winnable bar is `ready_ms ≲ 200ms`, and the
  contested sample is small.** Pre-Denim history (2s blocks) is a *far* more
  forgiving target and is the better replay substrate for building Record B.

**Verdict shift (the key insight the next session must not lose):**
opportunities are NOT scarce in count, but the *monetizable, contested,
fast-closed* subset is tiny, and the constraint that makes live runs report zero
is most likely **pin staleness + the preconf-lead loss at Denim**, not a lack of
gaps. The replay harness is what turns that inference into a number.

---

## 4. RECORD B — the replay harness (`tests/replay_race.rs`)

### Design (block-faithful, M1)
Pick a real gap episode. Pin an Anvil fork to `open_block - warmup - 1`. For each
source block in the window: re-send **every transaction that touches a registry
pool** via `anvil_impersonateAccount` in source order, mine **one local block per
source block at the source timestamp**, feed the resulting pool logs through the
production `Scanner::scan_triggers(&[Trigger])` path, and time
trigger-delivered → ready-calldata (`ready_ms`, when the report first carries a
non-empty-calldata opportunity on/after the open block). Judge vs Record A's
close position (`close_pos_gap × 2000/600` ms proxy for pre-Denim).

### What it reports
`data/race_results.jsonl`, one JSON per run: `ready_ms`, `ready_phases`
(pin/core/gas/probe/refine/simulate/fresh ms), `sent`, `send_failed`,
`status_mismatch`, `pool_tx_mismatch`, `t_close_proxy_ms`, `verdict`
(WIN / LOSS / NO READY CALLDATA / same-block nuances), plus the episode fields.
`freshness` is turned **off** in replay settings: the freshness pass re-prices at
a *newer* block (prettier number, loses the race), so it is excluded from
ready_ms by design.

### Bugs found and FIXED this session (all in the committed harness)
1. Re-signed replay txs get a **new local hash** — receipts are keyed by source
   hash, so attribution needed a source↔local map (`src_by_local`). Fixed.
2. Funding under-sized: `value + 0.001 ETH` ignores `gas_limit × price`; high-gas
   senders hit `-32003`. Fixed to fund `value + gas_limit×50gwei + 0.001` (raising
   balance is harmless to swap outputs; we only ever raise, never lower).
3. `nonce too low` on consecutive same-sender pool txs → send with an **explicit
   source nonce** per tx.
4. Per-tx automine collapsed 2s blocks into +20s each → **64% of deadline swaps
   reverted**. Fixed by the M1 per-block mining + source-timestamp design.
5. Receipt attribution counted pool-tx status flips wrong. Fixed the counter.

### STILL OPEN — the one blocker (start here next session)
The run stops with:
`cannot pin local block timestamp to source ts 1793890777: … 1793890777 is lower
than previous block's timestamp` (`evm_setNextBlockTimestamp` → `-32602`).

**Root cause (diagnosed, not yet fixed): Anvil clamps `--timestamp` to the fork
block's own timestamp — you cannot set the local clock BEFORE the forked base
block.** So the ~40 deploy transactions (forge broadcast, each mining a block,
each +1s) advance the head to roughly `base_ts + 40`, which is already *past*
the first replay source ts (`base_ts + warmup*2 + 2` with warmup=3 ≈ +8s). The
`-300`/`-30s` pre-pin in `race_replay.sh` is therefore a no-op past the clamp,
and the very first `setNextBlockTimestamp(source_ts)` is rejected as "in the
past". The window simply starts too close to the fork block for the deploy
consumption.

**Fix options (pick one, verify, record):**
- (A, simplest, most robust) **Increase `warmup`** so the first replay source ts
  sits comfortably after the deploy-consumed blocks. Deploy creates ~40–45 blocks
  ⇒ need `warmup ≥ 30` (window ≥60s) OR, better, set the fork base a *fixed
  margin of real seconds* before open and make the harness **skip the first
  (deploy_block_count) replayable blocks**, i.e. start the source-timestamp pin
  only once `source_ts > current_head_ts`. In `replay_race.rs`, replace the hard
  fail with: `let want = max(ts, head_ts+1)` for the WARMUP blocks only, and
  require the exact source ts from the open block onward (the contested block is
  what must be deadline-faithful; warmup blocks may drift harmlessly).
- (B) **Deploy with fewer blocks**: pass `anvil --timestamp` won't help; instead
  record `head_ts` right after deploy in `race_replay.sh` and choose
  `BASE = open_block - warmup - 1 - deploy_blocks` where `deploy_blocks` is
  measured from the deploy receipt count, then pin normally.
- (C) Set `evm_setNextBlockTimestamp` only when `ts > head_ts`, else rely on
  automine and log the skip; assert the *open block specifically* got its exact
  source ts (that is the only block whose deadlines matter for the verdict).

Whichever is chosen: **re-run rank 0, confirm the opener does NOT revert
(`open_ok == Some(true)`) and `pool_tx_mismatch` is near zero**, then read
`ready_ms`.

---

## 5. Competitor tx study (Phase 4 intel — actionable)

Decoded same-block winners' closing txs (publicnode/Alchemy):
- Executed via **custom executor contracts**, not raw routers:
  e.g. `awesome()` (selector `0xf61daca8`) on `0x45a16A56…`; a 12-byte
  ultra-compact calldata on `0x7acE44EA…` (pre-staged route, zero pre-reads).
- **Tips are tiny**: median winner priority fee **~0.005–0.013 gwei**; 14/70
  sampled winners paid ≤0.006 gwei (i.e. effectively the no-bid floor and still
  won). Position correlates weakly with tip (0.011 early vs 0.014 late gwei).
  **⇒ arrival time, not bid, wins these races** — which is exactly why our
  no-bidding policy is viable and latency is the whole game.
- Winner profiles: small calldata, **0 pre-swap reads, ~50% success** matches the
  arXiv "To Wait or To Probe" (2606.00720) winning cohort; our design (quote
  locally, route-committed, submit) is already in that class.
- Top named wallets to study further: `0x51C72848…`, `0x7c4c7Ac3…`,
  `0x29BE31E7…`, `0x278d858f…`, `0xB8C6f7Fb…`, `0xbeeB9eeE…`.
- Opener side is usually a **real user swap via Uniswap Universal Router
  (`0x9008d1…`)** — so races react to organic flow; not manufacturable.

---

## 6. Denim migration (now REQUIRED, was future)

Denim activated 2026-11-05 18:00 UTC. Consequences for this codebase:
- `pendingLogs`, `newFlashblocks`, `newFlashblockTransactions`, and **all
  `"pending"` reads are gone**; block time is now canonical 200 ms.
- `--source pending-logs` (the old default) is dead ⇒ use `logs` / `newHeads`.
- The old `ready_ms ≤ 1200ms (pendingLogs lead)` win model is obsolete post-Denim;
  the new bar is `ready_ms ≲ 200ms`. `winrate_curve.py` already supports
  `--period 0.2 --lead 0`.
- `race_replay.sh`/`denim_cutover.sh` use PUBLIC endpoints so they never contend
  with the Alchemy key the replay fork needs.
- Dead code now that Denim is real (cleanup, not urgent): `Trigger::Flashblock`,
  `ScanBlock::Pending`, `events.rs` flashblock subscriptions, and the §0t/§0k
  pending notes. `eth_simulateV1` folds execute-gas into a batch on Alchemy but
  is **unsupported by Anvil 1.9.0** — blocked for fork proof-of-correctness.

---

## 7. Phase 4 optimization levers (the loop — apply, side-test, keep winners)

Once Record B is measured (ready_ms per phase), iterate these, each with a
before/after replay + the correctness invariants green, updating Record A/B and
this file every pass:
1. **Bootstrap-before-first-trigger** — largely done (`prime_cl` at startup).
   Post-Denim it matters MORE (200ms budget).
2. **Per-scan `cl_states` HashMap clone** — measure inside replay; if it shows in
   probe_ms, share via Arc / diff-apply. (§0v left this unmeasured.)
3. **Tick budget by probe size** — `TICK_CAP_PER_DIRECTION` is fixed; the ~25/556
   coverage refusals waste remote round-trips. Make it size-aware.
4. **Trigger source** — post-Denim, `logs` on the persistent WS is the feed; the
   big question is beating the ~indexer latency (self-hosted op-node/Reth local
   flashblocks-equivalent, bloXroute state-diff feed). Biggest potential cut to
   *observed* change time. Requires web research + a side test.
5. **Coalescing default** tuned against Record A, not vibes (`--coalesce-ms`).
6. **Single-flight pipelining** — still out by design (§6G); the replay is the
   place to re-evaluate with data.
7. **Route-committed tiny calldata** — mirror the winners' compact execute (fewer
   legs / packed args) so our submission is light within the 200ms window.
Use subagents for (4)/(7) research and any GitHub reference dig (e.g.
`evm-amm-state`, `rm-uniswap` replay fixtures, `uniswap-v3-sdk` TickMap
one-call bootstrap) — all MIT/Apache-2.0, patterns reusable, do not vendored-pull
revm.

---

## 8. RESUME HERE (exact commands)

```bash
export PATH="$PATH:$HOME/.foundry/bin"           # forge/anvil
cd /home/runner/ICU/Watcher
source ~/.ryo_env                                 # ALCHEMY_BASE_HTTP/_WS (env-only)

# sanity (must be green): cargo test --lib  → 129 pass; cargo clippy --all-targets; cargo fmt --check

# ---- FIRST TASK: fix §4 "STILL OPEN" (clock-pin vs deploy-blocks), then: ----
cargo test --test replay_race --no-run
./tools/race_replay.sh data/gap_autopsy_24h_60bps.json 0 1      # rank 0, lag<=1
# expect: opener status == source, pool_tx_mismatch ~ 0, and a ready_ms number.
# If reuse is safe (same base, warm fork): ./tools/race_replay.sh <eps> <rank> 1 "" --reuse

# rebuild Record A anytime after re-harvest:
python3 tools/gap_autopsy.py data/swaps_24h.jsonl data/gap_autopsy_24h_60bps.md 60.0
python3 tools/winrate_curve.py data/gap_autopsy_24h_60bps.json 100 200 400 800

# post-Denim re-baseline (public endpoints, safe to run alongside):
./tools/denim_cutover.sh 18000
```

Episodes/ranks available in `data/gap_autopsy_24h_60bps.json` (ranked by lag then
peak_bps). rank 0 = `slipstream:50 -> pancake:100`, open_block 53550718, 236bps,
same-block, `close_pos_gap 212`, closer `0x45a16A56…`. Ranks 1–9 are the
thin-pool slipstream:50/200 same-block + lag-1 cluster around blocks
53550718/53552121 (see §3) — good first Record-B substrate because they are the
most-contested.

### Fork gotchas (from State.md, still true)
- Anvil **consumes** a snapshot on revert; never stack >1; `--reuse` handles this.
- Skew/vault funding oscillates; the replay uses real historical txs so it is
  self-funding, but if you hand-skew, pin a fork block where the vault holds ≥60k USDC.
- `assert!` inside a fork scenario unwinds past `evm_revert` and poisons the fork;
  use `bail!` (replay_race.rs already does).
- Run fork suites with `--test-threads=1`; never concurrently with a live Alchemy
  run on the same key (429s).

---

## 9. Definition of done (v1)
- Phase 3 replay harness runs green end-to-end on a pinned fork with a real
  opener (`open_ok==true`, `pool_tx_mismatch` near 0).
- First **Record B** distribution committed (`data/race_results.jsonl` + a chart
  or table in this file), with the win-rate curve vs Record A filled in.
- Phase 4 levers #1–#3 attempted, each keep/drop evidenced here, and ready_ms
  moved measurably toward the post-Denim ~200ms bar.
- That is when we can answer "can it compete today" with numbers, not inference.

## 10. Security / cleanup reminders
- **Revoke the GitHub PAT** after this push (session-scoped, was shared in chat).
- Rotate the Alchemy key when done; it is only in `~/.ryo_env`, never in the repo.
- `Watcher/deployments/8453.race.json` contains only addresses (no secrets) — safe
  to commit; it is regenerated per fork and is local-fork-only.

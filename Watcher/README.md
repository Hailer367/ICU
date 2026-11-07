# Ryo Watcher (`ryo-watch`)

Event-driven arbitrage watcher for [`RyoCore`](../ryo) on Base.

The watcher **finds** trades. The contract **executes** them. This build is
dry-run/paper only: it builds and logs calldata but never signs or sends a
transaction, and it never bids up priority fees.

## How it works

```
WebSocket trigger ─► affected pools ─► quote routes touching them
      │                                      │
      │                                      ├─► rank by absolute profit
      │                                      ├─► refine amount on a local grid
      │                                      └─► simulate through RyoCore
      │                                              │
      └─ newHeads are liveness only                  └─► gas/L1/profit gates
         (no scan on every block)                        → log opportunity
```

There is no "is there a trade yet?" polling loop. Fresh quotes and gas prices
are fetched only after an event. `scan` exists for manual checks and tests.
In `watch` the scan's pinned block comes from the `newHeads` header the same
socket already delivers — zero round-trips — and it is only trusted when
subscriptions and reads share one endpoint (a head from one chain cannot pin
reads on another; `Reconnect` drops it). CLI paths resolve `latest` normally.

Per simulated candidate, `RyoCore.simulate` and the L1 fee bound arrive in
one pinned `aggregate3`; the execute calldata is exactly one word longer
than the simulate one (`minProfit`), so the fee is priced for the real
transaction without a second round-trip.

Every scan reads **one pinned block**. It resolves the newest confirmed block
(by hash) at the start and uses that same state for reserves, quotes, the price
feeds, the gas oracle and `RyoCore.simulate` — then simulates the *same* floors
it proposes in the `execute` calldata. Base produces a block roughly every two
seconds and a scan takes half a second, so without this the profit figure would
stitch two blocks together and describe a trade that was possible in neither.
`pending` is not used for reads: on Base it has no hash and changes every
flashblock, so it cannot be pinned; a scan reports `head_drift` instead. If the
pinned block turns out to have been re-orged, the scan is reported as void
rather than as an empty market — as is any scan where legs could not be priced.

When a scan *does* find opportunities, a second **freshness pass** re-runs
only those finalists: it resolves a new block, re-quotes and re-simulates the
trades there, and the report then describes that block. The pass costs
nothing when nothing was found, skips itself when the head has not moved, and
is all-or-nothing — if any finalist cannot be re-priced, the pass-1 numbers
stand and the report says so. One report never mixes two blocks.

## Layout

```
src/events.rs    raw JSON-RPC WebSocket client, subscriptions, reconnect, trigger queue
src/routes.rs    venue/pool registry, cycle enumeration, adapter calldata, route hash
src/venues.rs    per-venue quote encoding/decoding, Multicall3 batching
src/amm.rs       local exact-price math for constant-product pools (checked U256 only)
src/clamm.rs     bit-for-bit V3-style concentrated-liquidity swap math + the event-maintained pool cache (§0u)
src/scanner.rs   event-driven scan: quotes → rank → refine → simulate → gates → freshness pass
src/simulate.rs  RyoCore.simulate call and result decoding
src/gas.rs       Base gas snapshot, per-candidate L1 fee upper bound (fail-closed), ETH/USD feed
src/chain.rs     provider helpers (eth_call, estimate_gas, ERC20 reads)
src/config.rs    settings, manifest, Base addresses
src/abi.rs       hand-written call selectors for the venues and oracles
src/errors.rs    revert decoding (RyoCore, adapters, OZ; routers/Balancer are not mapped)
src/history.rs   historical Swap dataset for replay
src/main.rs      CLI
tests/           mock-WebSocket test, local-vs-onchain differential, ignored Anvil fork tests
                 (opportunity, failed-sim cache, freshness pass, pinned block,
                 dynamic floors, Tier-1 pair expansion)
examples/        capture_pin.rs — regenerates the ground-truth tables pinned in src/amm.rs
deployments/     machine-readable manifests written by ryo/script/Deploy.s.sol
```

`src/amm.rs` prices Uniswap V2 and Aerodrome classic legs from the pool's
reserves instead of paying a router round-trip. Two rules make it safe: every
operator is `checked_*` (`U256`'s `+ - *` wrap silently, which would return a
plausible wrong price rather than failing), and a local refusal means *quote it
on chain* — never *this route is unprofitable*. `tests/local_math.rs` diffs it
against the scanner's own remote path.

## Quick start

```bash
cd Watcher
cp .env.example .env          # fill in HTTP/WS RPC URLs
cargo build --release

cargo run --release -- validate
cargo run --release -- scan
cargo run --release -- watch --show-empty
```

`--manifest` defaults to `deployments/8453.json`. Deploy the contracts first:

```bash
cd ../ryo
PRIVATE_KEY=... MANIFEST_PATH=../Watcher/deployments/8453.json \
  forge script script/Deploy.s.sol:Deploy --rpc-url "$BASE_RPC_URL" --broadcast
```

The script writes the manifest in the exact shape this crate expects
(`config::Manifest`). Set `SKIP_MANIFEST=true` to disable it.

## Commands

| Command | What it does |
|---|---|
| `validate` | Checks manifest, core wiring, adapter whitelist, routers, tokens, pools |
| `gas` | Prints the current gas snapshot and USD feeds |
| `routes --asset USDC` | Lists the enumerated cycles for an asset |
| `quote --asset USDC --amount 1000 --route univ3:500,univ3:100` | Quotes one route |
| `simulate ...` | Runs one route through `RyoCore.simulate` |
| `plan ...` | `simulate` plus calldata, floors, route hash, gas estimate |
| `scan [--pools 0,1] [--pending] [--json] [--no-freshness] [--no-dynamic-floors] [--no-local-cl]` | One scan (all pools, or only affected ones) |
| `watch [--show-empty] [--no-scan] [--metrics-every N] [--coalesce-ms N] [--json] [--no-freshness] [--no-dynamic-floors] [--no-local-cl]` | Event loop |
| `floors [--json]` | Per-pool trigger table: live fee, USD depth, and the minimum swap the watcher reacts to |
| `history [--blocks 43200] [--chunk 500] [--out data/swaps.jsonl]` | Downloads historical swap logs for the 33 registry pools as JSONL |
| `decode 0x...` | Decodes revert data |

`--pools` uses the indices printed by `routes` / `validate`.

With `--json`, **stdout is the JSON payload and nothing else**: logs, metrics and
opportunity lines all go to stderr, so `scan --json | jq` never has to strip a
prefix. Anything that consumes the watcher programmatically should rely on that
separation.

Route specs use `venue[:param][:token]` labels, comma separated, starting and
ending at `--asset`:

```
univ2
univ3:100  univ3:500  univ3:3000  univ3:10000
aerodrome:stable  aerodrome:volatile
slipstream:1  slipstream:10  slipstream:50  slipstream:100  slipstream:200
pancake:100  pancake:500  pancake:2500  pancake:10000
```

The optional `:token` names the leg's **exit** token and disambiguates a venue
parameter that exists on several trading pairs: the registry now spans
USDC, WETH, cbBTC and EURC, so `univ3:500:cbbtc` means "the 0.05% Uniswap V3
pool that swaps into cbBTC". A bare label keeps working: when several pools
match, it resolves to the USDC/WETH one (the legacy default every pre-expansion
route string meant); when the candidates belong to no legacy pair the CLI
errors out and lists the suffixed options to choose from. Route listings print
exactly the strings that parse back to the same pools.

Pancake's fee tiers are its own set: `3000` does not exist there and `2500`
does not exist on Uniswap, so a `pancake:3000` label never resolves to a pool.

Borrow assets are USDC and WETH only (the Balancer vault's deep holdings);
cbBTC and EURC appear as *intermediate* legs, never as the flash-loaned asset
— their `maxTradeSize` is deliberately 0 on the core. `--max-hops 3` unlocks
cross-pair triangles (USDC → cbBTC → WETH → USDC and friends): full scans then
enumerate ~1,900 routes per asset instead of ~280, so keep it for the
trigger-driven path or budget for it.

`history` only reads logs and writes them under `data/` (git-ignored). The
default `mainnet.base.org` endpoint rejects `eth_getLogs` with
`-32011 request limit reached`; point `--http-rpc` at
`https://base-rpc.publicnode.com` for this command.

## Settings

| Flag | Env | Default | Meaning |
|---|---|---|---|
| `--http-rpc` | `RYO_HTTP_RPC` | `https://mainnet.base.org` | HTTP RPC for quotes/simulation |
| `--ws-rpc` | `RYO_WS_RPC` | – | WebSocket RPC, required by `watch`; an `http(s)://` value is auto-upgraded, and when it is the same endpoint as `--http-rpc` all calls run over this one persistent connection |
| `--manifest` | `RYO_MANIFEST` | `deployments/8453.json` | Deployment manifest |
| `--mode` | `RYO_MODE` | `dry-run` | `dry-run` / `paper` / `live` (live still logs only) |
| `--source` | `RYO_SOURCE` | `logs` | `logs`, `pending-logs`, `flashblocks`, `both`, `once` (post-Denim only `logs` exists on Base) |
| `--min-net-profit-usd` | `RYO_MIN_NET_PROFIT_USD` | `0.25` | Minimum profit after gas |
| `--max-gas-price-gwei` | `RYO_MAX_GAS_PRICE_GWEI` | `0.05` | Watcher-side gas ceiling |
| `--per-leg-slippage-bps` | `RYO_SLIPPAGE_BPS` | `20` | Per-leg floor tolerance |
| `--min-profit-buffer-bps` | `RYO_PROFIT_BUFFER_BPS` | `50` | `minProfit` buffer below simulated profit |
| `--amount-grid-points` | `RYO_GRID_POINTS` | `5` | Amount refinement steps |
| `--max-candidates` | `RYO_MAX_CANDIDATES` | `16` | Routes refined per asset |
| `--max-simulations` | `RYO_MAX_SIMULATIONS` | `8` | `simulate` calls per asset per trigger |
| `--probe-usd` | `RYO_PROBE_USD` | `500,2000,8000` | Probe sizes in USD |
| `--min-swap-usd` | `RYO_MIN_SWAP_USD` | `500` | Fallback trigger floor: used in fixed mode, and for any pool whose fee/depth read failed ($45 hard floor always applies) |
| `--max-hops` | `RYO_MAX_HOPS` | `2` | Route length (2 = one pool out, one back) |
| `--assets` | `RYO_ASSETS` | `USDC,WETH` | Assets scanned, in order |
| `--fallback-gas` | `RYO_FALLBACK_GAS` | `450000` | Gas estimate used if `eth_estimateGas` fails |
| `--coalesce-ms` | `RYO_COALESCE_MS` | `0` | `watch` only: also wait up to N ms for more triggers before scanning |
| `--no-local-cl` | – | off | disable local concentrated-liquidity pricing for probe/refine (latency A/B and safety valve; finalists and `plan` always quote on chain) |

`--no-local-cl` off (the default) the scanner prices the 29 concentrated pools
from a RAM copy of each pool's state — bootstrapped over Multicall3 and
maintained from the swap events the socket already delivers — so probe/refine
rounds need no per-pool `eth_call`. The cache is advisory "the chain as the
socket saw it": any staleness, missing tick, or coverage gap degrades to the
remote quoter, never to a price, and every finalist is still simulated on
chain at the pin.

Opportunities must pass **all** gates: core not paused, watcher gas ceiling,
core `maxGasPrice`, positive simulated profit, and net USD ≥
`min-net-profit-usd`. Trade size is capped by `min(manifest cap, core cap)`.

In `watch`, a swap in one of the 33 registry pools is the trigger. Swaps are ignored
before any quoting when they are smaller than the pool's **dynamic trigger
floor** (on by default; `--no-dynamic-floors` restores the fixed
`--min-swap-usd`). One Multicall3 round-trip every 30 s reads each pool's live
fee and depth, and the floor is the smaller swap that could even theoretically
move that pool enough to clear its own round-trip cost plus the configured
buffers: a $500 swap moves the $40M UniV3 0.05% pool ~1 bp (skipped), while a
$50 swap can clear a shallow pool (scanned). Every term of the model errs
toward scanning; a floor must never skip a trade the gates would have taken.
Depth and swap notional are priced in USD on **either** leg: USDC is constant,
WETH/cbBTC/EURC ride their Chainlink feeds (30 s cache shared with the floor
reads), so pools without a USDC side (cbBTC/WETH, WETH/EURC) are filtered too.
Fail-open: any pool whose fee/depth cannot be read falls back to
`--min-swap-usd`, and the $45 absolute floor applies in every mode. A skipped
swap is never marked seen, so the two-phase dedupe semantics are unchanged.
Non-swap logs (mint, burn, collect) are not size-filtered. The old 24h
dataset's ~78 % scan reduction is conservative for this filter; measured
2026-11-02: the same live window produced 94 fixed-mode scans vs 24
dynamic-mode scans, with per-scan latency unchanged (~120 ms warm).

During a burst the watch loop bundles whatever triggers the socket can hand
over into one scan (a 2 ms budget per extra event, so a backlog drains for
free while an idle market pays nothing); `--coalesce-ms` waits longer on
purpose. Losing candidates are also skipped in later scans when their exact
simulation inputs (quotes, gas, USD prices) are unchanged — `sims_cached` in
the metrics line counts those skips, and opportunities are never affected.

**Denim changed the trigger source.** Since 2026-11-05 18:00 UTC Base has
canonical 200 ms blocks; `pendingLogs`, the Flashblocks subscriptions and all
`pending` reads are gone, and Alchemy rejects `pendingLogs` with
`-32602 unknown variant pendingLogs`. The live trigger is now `--source logs`
(the default). `pending-logs`/`flashblocks` remain parseable for historical
configs and replay fixtures but cannot produce a live trigger on mainnet.
`newHeads` is subscribed alongside every source: it supplies the socket pin
(zero per-scan round-trip) and gap/reorg detection.

Historical note (pre-Denim, kept for reading old logs): `newFlashblocks` sent
preconfirmed block objects and `newFlashblockTransactions` bare hashes;
neither carried logs, so a Flashblock could not identify which pool traded.
`pendingLogs` delivered the swap roughly a second before the block.

## Tests

```bash
cargo test            # unit tests + in-process mock WebSocket test
cargo clippy --all-targets
cargo fmt --all --check
```

### Fork test

`tests/fork_opportunity.rs` skews the real UniV3 USDC/WETH 0.05% pool on a
local Anvil fork, asserts the scanner finds the arbitrage, and (with
`RYO_FORK_EXECUTE=1`) sends the calldata and checks the recipient is paid.

```bash
anvil --fork-url https://mainnet.base.org --chain-id 8453 --port 8545

# deploy first, e.g. with MANIFEST_PATH=../Watcher/deployments/8453.anvil.json
RYO_FORK_RPC=http://127.0.0.1:8545 RYO_FORK_EXECUTE=1 \
  cargo test --test fork_opportunity -- --ignored --nocapture
```

The test snapshots the fork and reverts afterwards, so it can be re-run without
a reset. It is `#[ignore]`d because it needs a live fork.

Two more ignored fork suites cover the rest of the loop:
`tests/fork_simcache.rs` (a second full scan on an unchanged chain must reuse the
failed-simulation cache without hiding a winner) and
`tests/freshness_pass.rs` (finalists re-quoted and re-simulated at a newly
resolved pin; under automine it proves both the same-head skip and the
applied-at-the-next-block path). Anvil **consumes** a snapshot on revert — a
second `evm_revert` of the same id returns `false` — and stacking snapshots
crashed the node after the sixth one, so take exactly one per run.

## Local Anvil playbook

```bash
export PATH="$PATH:$HOME/.config/.foundry/bin"
anvil --fork-url https://mainnet.base.org --chain-id 8453 --port 8545

cd ryo
PRIVATE_KEY=0xac09...bff80 \
MAX_GAS_PRICE=3000000000 \
MAX_TRADE_USDC=8000000000 \
MAX_TRADE_WETH=4000000000000000000 \
MANIFEST_PATH=../Watcher/deployments/8453.anvil.json \
forge script script/Deploy.s.sol:Deploy --rpc-url http://127.0.0.1:8545 --broadcast

cd ../Watcher
cargo run -q -- --http-rpc http://127.0.0.1:8545 \
  --manifest deployments/8453.anvil.json --max-gas-price-gwei 3 scan
```

Anvil's gas price sits near 1 gwei, so fork runs need `--max-gas-price-gwei 3`.
A cold fork scan is slow because Anvil fetches missing state from the upstream
RPC on demand; repeat runs are sub-second.

## Running it for long stretches

`watch` handles both Ctrl-C (SIGINT) and SIGTERM: either one prints the metrics
summary and closes the socket cleanly, so it can be supervised by systemd, Docker
or Kubernetes without a restart looking like a crash. Logs go to **stderr** and
are uncoloured whenever stderr is not a terminal, so a redirected or shipped log
stays greppable; with `--json`, stdout carries only JSON. `--metrics-every N`
prints at every N events even when they arrive inside one bundled batch.

One operational trap, learned the hard way: starting the watcher from a script
that is itself detached (`setsid nohup script &`) makes the shell ignore SIGINT
for the whole subtree, so `timeout -s INT` will report a timeout while the
watcher keeps running. Stop it with SIGTERM, or use `timeout --kill-after`.

## Safety notes

- No private key, API key, or seed phrase is read by this crate.
- `--mode live` is accepted but only logs; sending is not implemented. This was
  verified on a fork — including with a funded dev `PRIVATE_KEY` present in the
  environment: across 66 manufactured opportunities the operator nonce and the
  recipient balances never moved.
- No priority-fee bidding: fees come from the node's default estimate.
- Treat `deployments/*.json` as data. Only the address fields matter at runtime.

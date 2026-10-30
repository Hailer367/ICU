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

## Layout

```
src/events.rs    raw JSON-RPC WebSocket client, subscriptions, reconnect, trigger queue
src/routes.rs    venue/pool registry, cycle enumeration, adapter calldata, route hash
src/venues.rs    per-venue quote encoding/decoding, Multicall3 batching
src/scanner.rs   event-driven scan: quotes → rank → refine → simulate → gates
src/simulate.rs  RyoCore.simulate call and result decoding
src/gas.rs       Base gas snapshot, L1 fee upper bound, ETH/USD feed
src/chain.rs     provider helpers (eth_call, estimate_gas, ERC20 reads)
src/config.rs    settings, manifest, Base addresses
src/errors.rs    revert decoding (core, adapters, routers, Balancer, OZ)
src/main.rs      CLI
tests/           mock-WebSocket test, ignored Anvil fork test
deployments/     machine-readable manifests written by ryo/script/Deploy.s.sol
```

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
| `scan [--pools 0,1] [--pending] [--json]` | One scan (all pools, or only affected ones) |
| `watch [--show-empty] [--no-scan] [--metrics-every N] [--json]` | Event loop |
| `history [--blocks 43200] [--chunk 500] [--out data/swaps.jsonl]` | Downloads historical swap logs for the 12 pools as JSONL |
| `decode 0x...` | Decodes revert data |

`--pools` uses the indices printed by `routes` / `validate`.

Route specs use `venue[:param]` labels, comma separated, starting and ending at
`--asset`:

```
univ2
univ3:100  univ3:500  univ3:3000  univ3:10000
aerodrome:stable  aerodrome:volatile
slipstream:1  slipstream:10  slipstream:50  slipstream:100  slipstream:200
```

`history` only reads logs and writes them under `data/` (git-ignored). The
default `mainnet.base.org` endpoint rejects `eth_getLogs` with
`-32011 request limit reached`; point `--http-rpc` at
`https://base-rpc.publicnode.com` for this command.

## Settings

| Flag | Env | Default | Meaning |
|---|---|---|---|
| `--http-rpc` | `RYO_HTTP_RPC` | `https://mainnet.base.org` | HTTP RPC for quotes/simulation |
| `--ws-rpc` | `RYO_WS_RPC` | – | WebSocket RPC, required by `watch` |
| `--manifest` | `RYO_MANIFEST` | `deployments/8453.json` | Deployment manifest |
| `--mode` | `RYO_MODE` | `dry-run` | `dry-run` / `paper` / `live` (live still logs only) |
| `--source` | `RYO_SOURCE` | `pending-logs` | `logs`, `pending-logs`, `flashblocks`, `both`, `once` |
| `--min-net-profit-usd` | `RYO_MIN_NET_PROFIT_USD` | `0.25` | Minimum profit after gas |
| `--max-gas-price-gwei` | `RYO_MAX_GAS_PRICE_GWEI` | `0.05` | Watcher-side gas ceiling |
| `--per-leg-slippage-bps` | `RYO_SLIPPAGE_BPS` | `20` | Per-leg floor tolerance |
| `--min-profit-buffer-bps` | `RYO_PROFIT_BUFFER_BPS` | `50` | `minProfit` buffer below simulated profit |
| `--amount-grid-points` | `RYO_GRID_POINTS` | `5` | Amount refinement steps |
| `--max-candidates` | `RYO_MAX_CANDIDATES` | `16` | Routes refined per asset |
| `--max-simulations` | `RYO_MAX_SIMULATIONS` | `8` | `simulate` calls per asset per trigger |
| `--probe-usd` | `RYO_PROBE_USD` | `500,2000,8000` | Probe sizes in USD |
| `--max-hops` | `RYO_MAX_HOPS` | `2` | Route length (2 = one pool out, one back) |
| `--assets` | `RYO_ASSETS` | `USDC,WETH` | Assets scanned, in order |
| `--fallback-gas` | `RYO_FALLBACK_GAS` | `450000` | Gas estimate used if `eth_estimateGas` fails |

Opportunities must pass **all** gates: core not paused, watcher gas ceiling,
core `maxGasPrice`, positive simulated profit, and net USD ≥
`min-net-profit-usd`. Trade size is capped by `min(manifest cap, core cap)`.

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

## Safety notes

- No private key, API key, or seed phrase is read by this crate.
- `--mode live` is accepted but only logs; sending is not implemented.
- No priority-fee bidding: fees come from the node's default estimate.
- Treat `deployments/*.json` as data. Only the address fields matter at runtime.

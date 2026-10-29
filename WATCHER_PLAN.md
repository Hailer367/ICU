# RyoWatch — Analysis & Build Plan

> Working design document for the off-chain watcher that drives the `RyoCore` arbitrage
> contract. The contract is intentionally dumb: it borrows, swaps through whitelisted
> adapters, repays, and forwards profit. The watcher holds the strategy, quoting, route
> search, risk policy, and execution logic.
>
> **Status:** design only. No watcher code has been written. `RyoCore` is not deployed.
> **Last revised:** 2026-10-29.

---

## 0. Locked decisions

| Area | Decision |
|---|---|
| Language | **Rust** |
| Trigger | **Event-driven Alchemy Base WebSocket subscriptions** |
| Primary stream | Base Flashblocks: `newFlashblockTransactions`, `pendingLogs`, `newFlashblocks`; plus standard `newHeads` / `logs` |
| Webhooks | Optional. Alerts and admin notifications only. They require a publicly reachable HTTPS endpoint. |
| Opportunity polling | **No.** No 2-second "is there a trade yet?" loop. |
| Price / quote refresh | Allowed after an event, and on a slow safety heartbeat (not opportunity scanning). |
| Priority fees | **No bidding.** Use the network's minimum/default tip. Never raise the tip to win a race. |
| Contract changes | Add a `renounceOwnership()` override; make `Deploy.s.sol` write `deployments/8453.json`. |
| Deployment | None yet. Free Base fork/simulator first. |
| First milestone | Undecided. Recommendation in §13. |

### 0.1 Plain-English summary

- The bot sleeps until Base tells it that something happened.
- It then checks only the pools affected by that event.
- It quotes, simulates, and subtracts costs.
- If the trade is profitable and safe, it sends one transaction with the normal minimum tip.
- It does not constantly scan, and it does not pay extra to jump the queue.

### 0.2 Honest expectation

Base arbitrage is crowded. A bot that does not bid above the minimum tip will lose some
races to bots that do. That is an accepted trade-off, not a bug. The early versions exist to
measure whether the edge is real after gas, the L1 data fee, and failed transactions.

---

## 1. What changed in this revision

This revision replaces the earlier draft's assumptions with the decisions and facts below.

1. **Stack changed from TypeScript to Rust.** The plan, examples, layout, and milestones now
   assume Rust with `alloy` for ABI/RPC work.
2. **The trigger is a WebSocket subscription, not a webhook.**
   - Alchemy webhooks are HTTP push notifications. Alchemy sends them **to our server**, so
     our server needs a public HTTPS address.
   - Pending transactions are a **WebSocket subscription**, not a webhook type.
   - Alchemy's `alchemy_pendingTransactions` is **not supported on Base** (it is limited to
     Ethereum, Ethereum Sepolia, and Polygon).
   - On Base, the earliest useful signal is the **Flashblocks** stream.
3. **The Base execution model is corrected.** Base has a private sequencer mempool, orders
   transactions by priority fee and arrival time, and builds blocks in 200ms Flashblocks.
   There is no public pending-transaction pool to watch.
4. **No priority-fee bidding.** The bot uses the minimum/default tip. It does not escalate
   fees to compete. Stuck-transaction replacement is disabled by default.
5. **Sequential quoting is fixed.** The old "batch all legs in one Multicall3 call" idea is
   impossible with vanilla `aggregate3`, because each leg's input depends on the previous
   leg's output. The plan now uses multi-round quoting plus `simulate`, or a helper contract
   later.
6. **Revert decoding is expanded.** A bad fill usually reverts in the router, not in
   `RyoCore`. The watcher must decode router, adapter, Balancer, and OpenZeppelin errors too.
7. **Contract safety work is explicit.** The inherited `renounceOwnership()` can permanently
   brick admin functions. It will be disabled before deployment, and the deploy script will
   emit a machine-readable manifest.
8. **Flashblocks are treated as replaceable.** Base docs say Flashblocks may be deprecated in
   the upcoming Denim hardfork in favor of canonical 200ms blocks. The event layer must be
   abstracted so the source can change without rewriting the strategy.

---

## 2. Snapshot of what was analyzed

| Item | Value |
|---|---|
| Repo | `Hailer367/ICU` |
| Project | Ryo — Base-only Balancer flash-loan arbitrage executor |
| Contract language | Solidity `^0.8.28`, built with Foundry |
| Core | `ryo/src/RyoCore.sol` (472 lines, 12,013 bytes runtime) |
| Adapters | UniV3, UniV2, Aerodrome classic, Aerodrome Slipstream (single-hop) |
| Tests | 119 total: 105 unit/security/invariant + 14 Base-fork |
| Coverage | Core 98.30% lines / 72.41% branches; adapters 100% |
| Toolchain | solc 0.8.38, Cancun, via-IR, optimizer 1,000,000 runs |
| Dependencies | OpenZeppelin 5.7.0, forge-std 1.17.0 |
| Deployment | **None.** The only broadcast artifact is a local Anvil simulation. |

The fork tests pass against real Base contracts, but they **manufacture** an opportunity by
skewing a real pool. They prove the plumbing, not live profitability.

---

## 3. What the contract actually does

### 3.1 One transaction, one linear cyclic route

```
operator
   │ execute(asset, amount, steps[], minProfit)
   ▼
RyoCore ── flashLoan(asset, amount) ──► Balancer V2 Vault
   │                                        │
   │◄──────────── receiveFlashLoan ─────────┘
   │
   ├─ step 0: asset   ──► token B
   ├─ step 1: token B ──► token C
   ├─ ...
   └─ step n: token N ──► asset
   │
   ├─ repay amount + Balancer fee
   ├─ require final balance ≥ starting balance
   ├─ require profit ≥ minProfit
   └─ transfer profit to profitRecipient
```

- **No capital at rest.** The core borrows, trades, repays, and forwards profit in one tx.
- **No proxy, no upgrade key.** Core code and the Balancer Vault address are immutable.
- **Adapters are permanently bound** to one core and one router.
- **The core knows nothing about DEXes.** It moves tokens through whitelisted adapters and
  measures balances.

### 3.2 Roles

| Role | Can do | Cannot do |
|---|---|---|
| Owner (Safe/hardware) | Configure everything, unpause, sweep dust, transfer ownership | — |
| Operator (hot wallet) | `execute`, `pause` | Change config, unpause, move funds |
| Profit recipient | Receive profit | Call anything |
| Anyone | `simulate` | Execute, configure, pause |

- `Ownable2Step`: ownership handoff requires `acceptOwnership()`.
- A compromised operator can waste gas and pause, but cannot steal principal or redirect
  profit.
- A compromised owner can do anything the contract allows. The owner should be a Safe.

### 3.3 Mutable configuration

| Setting | Meaning | Watcher implication |
|---|---|---|
| `operator` | Hot wallet allowed to execute/pause | Signer must match; monitor `OperatorSet` |
| `profitRecipient` | Where profit goes | PnL tracking; monitor changes |
| `isAdapter[adapter]` | Whitelisted adapters | Routes must use these; monitor `AdapterSet` |
| `maxTradeSize[asset]` | Max borrow per asset; **0 disables** | Respect and refresh |
| `maxGasPrice` | Optional `tx.gasprice` ceiling (wei); 0 disables | Enforce separately; does not cover L1 fee |
| `paused` | Execution stop; simulation still works | Check before executing |

### 3.4 Immutable / constants

- `VERSION = 1` — envelope version in `abi.encode(uint8(1), steps)`.
- `MAX_STEPS = 8`.
- Minimum route length = 2.
- Balancer Vault is immutable.

### 3.5 The `renounceOwnership()` risk

`RyoCore` inherits `Ownable2Step`, which inherits `Ownable.renounceOwnership()`. There is no
override. Calling it sets `owner = address(0)` and permanently disables:

- `unpause()`,
- `sweep()`,
- `setOperator()`,
- `setProfitRecipient()`,
- `setAdapter()`,
- `setMaxTradeSize()`,
- `setMaxGasPrice()`.

The operator can still execute and pause, but nobody can unpause. This was confirmed with a
temporary Foundry test. Since no core is deployed yet, the override in §11 will be added
before deployment.

---

## 4. Watcher-facing ABI

### 4.1 Structs

```solidity
struct Step {
    address adapter;       // whitelisted adapter
    address tokenIn;       // token handed to the adapter
    address tokenOut;      // token the adapter must return
    uint256 minAmountOut;  // hard floor for this leg; must be non-zero
    bytes data;            // adapter-specific parameters
}
```

ABI tuple: `(address,address,address,uint256,bytes)`.

### 4.2 Functions

```solidity
function execute(
    address asset,
    uint256 amount,
    Step[] calldata steps,
    uint256 minProfit
) external returns (uint256 profit);

function simulate(
    address asset,
    uint256 amount,
    Step[] calldata steps
) external; // always reverts with SimulationResult(int256)
```

Selectors:

| Function | Selector |
|---|---|
| `execute(address,uint256,(address,address,address,uint256,bytes)[],uint256)` | `0x76af4222` |
| `simulate(address,uint256,(address,address,address,uint256,bytes)[])` | `0x2d66c4e3` |
| `SimulationResult(int256)` error | `0x00cf1ea6` |
| `Executed(address,address,uint256,uint256,address,bytes32)` event | `0xa05f8c54…` |

### 4.3 Simulation decoding

`simulate` never returns normally. It reverts with:

```
0x00cf1ea6
<32-byte int256 profit>
```

Illustrative Rust:

```rust
use alloy::primitives::{I256, U256};

const SIMULATION_RESULT: [u8; 4] = [0x00, 0xcf, 0x1e, 0xa6];

/// `simulate` always reverts. A `SimulationResult(int256)` payload is the
/// selector followed by one 32-byte two's-complement word.
fn decode_simulation(revert: &[u8]) -> Option<I256> {
    if revert.len() < 36 || revert[..4] != SIMULATION_RESULT {
        return None;
    }
    Some(I256::from_raw(U256::from_be_slice(&revert[4..36])))
}
```

The helper is illustrative; compile-check it in Phase 1.

For batches, use Multicall3 `aggregate3` with `allowFailure = true`. Each failed call's
`returnData` is the revert payload, so the outer call succeeds and every result can be
decoded in one RPC round trip.

Multicall3 on Base: `0xcA11bde05977b3631167028862bE2a173976CA11`.

**Important:** Multicall3 can batch **independent** `simulate` calls. It cannot chain
sequential quotes, because the calldata is fixed before the call runs.

### 4.4 Events to index

```solidity
event Executed(address indexed operator, address indexed asset, uint256 amount,
               uint256 profit, address indexed recipient, bytes32 routeHash);
event AdapterSet(address indexed adapter, bool allowed);
event OperatorSet(address indexed operator);
event ProfitRecipientSet(address indexed recipient);
event MaxTradeSizeSet(address indexed asset, uint256 maxAmount);
event MaxGasPriceSet(uint256 maxGasPrice);
event Paused(address indexed by);
event Unpaused(address indexed by);
event Swept(address indexed token, address indexed to, uint256 amount);
```

`routeHash = keccak256(abi.encode(uint8(1), steps))`. The watcher can recompute it to
correlate an `Executed` event with a candidate route. Because the hash includes
`minAmountOut` and `data`, a discovery route with `minAmountOut = 1` has a different hash
from the executed route with real floors. Store the exact steps sent.

### 4.5 Read-only getters

`vault()`, `operator()`, `profitRecipient()`, `paused()`, `isAdapter(address)`,
`maxTradeSize(address)`, `maxGasPrice()`, `owner()`, `pendingOwner()`, `VERSION()`,
`MAX_STEPS()`.

---

## 5. Hard rules the watcher must encode

These are enforced by the contract. Violating any of them burns gas on a revert.

1. **Route must be a cycle.** `steps[0].tokenIn == asset`, each
   `steps[i].tokenIn == steps[i-1].tokenOut`, and `steps[last].tokenOut == asset`.
2. **Length 2..8.**
3. **No self-swap.** `tokenIn != tokenOut` in every step.
4. **Non-zero floors.** Every `minAmountOut != 0`.
5. **Whitelisted adapters only.** Check `core.isAdapter(adapter)` at build time and refresh
   when `AdapterSet` fires.
6. **Cap must be non-zero and amount ≤ cap.** `maxTradeSize[asset] == 0` means the asset is
   disabled. Check before simulating.
7. **`paused == false` for `execute`.** `simulate` works while paused; `execute` reverts.
8. **Operator key must be the configured `operator` (or owner).** The watcher signs as the
   hot wallet.
9. **`maxGasPrice != 0` → `tx.gasprice ≤ maxGasPrice`.** This is the L2 gas price only; it
   does not cover the L1 data fee.
10. **One flash-loan callback per tx.** No nested executions.
11. **Exact input consumption.** Fee-on-transfer / rebasing tokens revert; do not route them.
12. **No loss after repayment.** Even `minProfit = 0` requires
    `balanceAfter ≥ balanceBefore`.
13. **Profit is in the borrowed asset.** PnL is denominated in `asset`.
14. **No ETH.** The core has no `receive`/`fallback`; only ERC20s.
15. **Adapters are single-hop.** Multi-hop is composed by the core as multiple `Step`s.

### 5.1 Adapter `data` encodings

| Venue | Adapter | `data` | Notes |
|---|---|---|---|
| Uniswap V3 / SwapRouter02 | `UniV3Adapter` | `abi.encode(uint24 fee)` | 32 bytes; fee tier must exist |
| Uniswap V2 | `UniV2Adapter` | `""` | empty bytes |
| Aerodrome classic | `AerodromeClassicAdapter` | `abi.encode(bool stable)` | 32 bytes |
| Aerodrome Slipstream | `SlipstreamAdapter` | `abi.encode(int24 tickSpacing)` | 32 bytes; must be > 0 |

### 5.2 Base addresses from the repo

| Contract | Address |
|---|---|
| Balancer V2 Vault | `0xBA12222222228d8Ba445958a75a0704d566BF2C8` |
| UniV3 SwapRouter02 | `0x2626664c2603336E57B271c5C0b26F421741e481` |
| UniV2 Router | `0x4752ba5DBc23f44D87826276BF6Fd6b1C372aD24` |
| Aerodrome classic Router | `0xcF77a3Ba9A5CA399B7c97c74d54e5b1Beb874E43` |
| Aerodrome Slipstream Router | `0xBE6D8f0d05cC4be24d5167a3eF062215bE6D18a5` |
| Multicall3 | `0xcA11bde05977b3631167028862bE2a173976CA11` |
| WETH | `0x4200000000000000000000000000000000000006` |
| USDC | `0x833589fCD6eDb6E08f4c7C32D4f71b54bdA02913` |
| cbBTC | `0xcbB7C0000aB88B473b1f5aFd9ef808440eed33Bf` |
| EURC | `0x60a3E35Cc302bFA44Cb288Bc5a4F316Fdb1adb42` |
| AERO | `0x940181a94A35A4569E4529A3CDfB74e38FD98631` |

> Verify every address on-chain before use. The repo is a snapshot, not an oracle.

### 5.3 Verified Base infrastructure snapshot

Checked against `https://mainnet.base.org` at Base block ~`53,249,5xx` on 2026-10-29.
Re-read all of it dynamically; state changes.

| Item | Verified value |
|---|---|
| Chain ID | `8453` |
| Balancer `getProtocolFeesCollector()` | `0xce88686553686DA562CE7Cea497CE749DA109f9F` |
| Balancer flash-loan fee | `0` (0 bps) |
| Vault USDC balance | `81,722.073075` USDC |
| Vault WETH balance | `21.880893047221778992` WETH |
| Vault cbBTC balance | `0.01412383` cbBTC |
| Vault EURC balance | `3.072645` EURC |
| Vault AERO balance | `0.00157` AERO |
| UniV3 QuoterV2 | `0x3d4e44Eb1374240CE5F1B871ab261CD16335B76a` |
| UniV3 Factory | `0x33128a8fC17869897dcE68Ed026d694621f6FDfD` |
| UniV2 Factory | `0x8909Dc15e40173Ff4699343b6eB8132c65e18eC6` |
| Aerodrome classic Factory | `0x420DD381b31aEf6683db6B902084cB0FFECe40Da` |
| Slipstream QuoterV2 | `0x254cF9E1E6e233aa1AC962CB9B05b2cfeAaE15b0` |
| Slipstream PoolFactory | `0x5e7BB104d84c7CB9B682AaC2F3d509f5F406809A` |
| GasPriceOracle | `0x420000000000000000000000000000000000000F` |
| Gas price (snapshot) | ~`0.006` gwei |
| Suggested priority fee | `0.001` gwei |
| L1 fee upper bound, 1000-byte tx | ~`22,853,711,214` wei |
| Fork-test execute gas (2 steps) | `~663,706` gas |

**Implication:** only USDC and WETH have meaningful Balancer Vault liquidity. Start with
those as borrowed assets. cbBTC/EURC/AERO are effectively unborrowable at this snapshot.
Query the Vault balance dynamically before sizing.

**Implication:** the flash-loan fee is 0 today, but it is governance-controlled. Read
`getProtocolFeesCollector().getFlashLoanFeePercentage()` or rely on `simulate` (which
includes the fee). Never hard-code zero in sizing logic.

**Implication:** at ~0.006 gwei and ~664k gas, L2 gas is a few thousandths of a cent in ETH
terms. The L1 data fee can still dominate small trades. Model both.

### 5.4 Verified quoter call shapes

**UniV3 QuoterV2** (struct order matters):

```solidity
struct QuoteExactInputSingleParams {
    address tokenIn;
    address tokenOut;
    uint256 amountIn;
    uint24 fee;
    uint160 sqrtPriceLimitX96;
}
function quoteExactInputSingle(QuoteExactInputSingleParams memory params)
    external returns (uint256 amountOut, uint160 sqrtPriceX96After,
                      uint32 initializedTicksCrossed, uint256 gasEstimate);
```

**Slipstream QuoterV2** (different struct order — `amountIn` before `tickSpacing`):

```solidity
struct QuoteExactInputSingleParams {
    address tokenIn;
    address tokenOut;
    uint256 amountIn;
    int24 tickSpacing;
    uint160 sqrtPriceLimitX96;
}
function quoteExactInputSingle(QuoteExactInputSingleParams memory params)
    external returns (uint256 amountOut, uint160 sqrtPriceX96After,
                      uint32 initializedTicksCrossed, uint256 gasEstimate);
```

**UniV2 Router:**

```solidity
function getAmountsOut(uint256 amountIn, address[] calldata path)
    external view returns (uint256[] memory amounts);
```

**Aerodrome classic Router:**

```solidity
struct Route { address from; address to; bool stable; address factory; }
function getAmountsOut(uint256 amountIn, Route[] calldata routes)
    external view returns (uint256[] memory amounts);
```

Aerodrome works with `factory = address(0)` (the router's default factory). Confirm the
deployed router's default factory matches the pools used.

Pool discovery verified:

```solidity
// UniV3
factory.getPool(USDC, WETH, 500)      // 0xd0b53D9277642d899DF5C87A3966A349A798F224
// UniV2
factory.getPair(USDC, WETH)           // 0x88A43bbDF9D098eEC7bCEda4e2494615dfD9bB9C
// Aerodrome classic
factory.getPool(USDC, WETH, false)    // 0xcDAC0d6c6C59727a65F871236188350531885C43
// Slipstream
factory.getPool(USDC, WETH, 100)      // 0xb2cc224c1c9feE385f8ad6a55b4d94E92359DC59
```

Slipstream tick spacings found for USDC/WETH: `1, 10, 50, 100, 200`. The adapter accepts any
positive `int24`; the watcher must only use spacings that map to a real pool.

---

## 6. Base execution model (corrected)

### 6.1 How Base actually orders transactions

- Base produces a full block every **2 seconds**.
- Each block is built from **10 Flashblocks**, one every **200ms**.
- Transactions are ordered by **priority fee (tip per gas)** and **arrival time** within each
  Flashblock.
- Once a Flashblock is built and broadcast, its ordering is **locked**. A later transaction
  with a higher tip cannot enter an earlier Flashblock.
- Base's mempool is **private to the sequencer**. There is no public pending-transaction pool
  to watch.
- A Flashblock preconfirmation is a sequencer promise, **not L1 finality**. Reorgs are still
  possible until the block settles on Ethereum.
- Base docs say Flashblocks **may be deprecated in the upcoming Denim hardfork** in favor of
  canonical 200ms blocks. This is planned, not final.

### 6.2 What this means for the watcher

- The watcher cannot see other bots' pending transactions on Base.
- The watcher *can* see transactions as they are preconfirmed in Flashblocks.
- Being fast gets the watcher into the next 200ms auction. It does not guarantee inclusion.
- A minimum-tip transaction is still eligible, but it loses ties to higher-tip transactions.
  The bot accepts that.
- The event source must be abstracted. If Flashblocks disappear in Denim, the bot switches to
  standard 200ms `newHeads`/`logs` without changing the strategy.

### 6.3 Event sources

**Primary: Alchemy Base Mainnet WebSocket (`wss://base-mainnet.g.alchemy.com/v2/...`).**

Subscriptions:

| Subscription | Use |
|---|---|
| `newFlashblockTransactions` | Each transaction as it is preconfirmed. Full objects/logs optional. |
| `pendingLogs` | Contract events from preconfirmed transactions, filtered by pool address and topic. Lowest latency for swaps. |
| `newFlashblocks` | Full accumulated preconfirmed block state. |
| `newHeads` | Standard block headers; fallback and reconciliation. |
| `logs` | Standard mined logs; fallback and reconciliation. |
| `newPendingTransactions` | Supported on Base, but only reflects what the node sees. Base's sequencer mempool is private, so this is **not** a full public pending pool. Do not rely on it. |

Use narrow filters: only the pool addresses and swap topics that matter. Alchemy bills
WebSocket subscriptions by bandwidth/compute units, so unfiltered streams are expensive and
noisy.

**Secondary: Alchemy webhooks (optional).**

- Webhook types: Custom, Address Activity, NFT Activity. `BASE_MAINNET` is supported.
- Webhooks fire after the event is included, not before. They are useful for alerts, admin
  changes, and reconciliation.
- They require a public HTTPS endpoint that Alchemy can reach. A local machine needs a tunnel
  (for example, `ngrok`) or a small VPS.
- They are **not** the fast trading trigger.

### 6.4 Cost of Flashblocks and priority fees

- Flashblocks have **no separate chain fee**. They are how Base builds blocks. Access uses the
  normal Alchemy Base endpoint.
- Alchemy WebSocket subscriptions are billed by **bandwidth/compute units**. Keep filters
  narrow and payloads small.
- Gas has two parts:
  - **Base fee**: burned by the network; everyone pays it.
  - **Priority fee (tip)**: paid to the block builder.
- **No bidding policy:** set the tip to the node's suggested minimum, or the minimum the
  network accepts. Never raise it to win a race. `maxFeePerGas` may be set with headroom for
  base-fee movement, but that is a cap, not a bid.
- Stuck-transaction replacement (same nonce, higher fee) is **disabled by default**. If
  enabled later, it is an operational exception, not an opportunity bid.

---

## 7. Watcher architecture (Rust)

### 7.1 Design principles

1. **Event-driven.** No opportunity scan loop. Events wake the bot.
2. **Narrow reaction.** An event only invalidates the pools and routes it touches.
3. **Single decision task.** One task owns nonce, pending tx, and execution decisions. This
   avoids races and double-sends.
4. **Latest wins.** If work is stale or the queue is full, drop it. A stale opportunity is
   worthless.
5. **Fail closed.** Missing config, stale oracle, unknown revert, or failed validation means
   do not trade.
6. **Measure everything.** Latency, quotes, simulations, sends, reverts, gas, and PnL.

### 7.2 Event-to-trade flow

```
Alchemy WebSocket
   │
   ▼
┌──────────────────┐
│ Decode / classify│  swap? admin? block? transfer?
└────────┬─────────┘
         ▼
┌──────────────────┐
│ Update state     │  mark affected pools dirty
└────────┬─────────┘
         ▼
┌──────────────────┐
│ Candidate routes │  only cycles containing affected pools
└────────┬─────────┘
         ▼
┌──────────────────┐
│ Quote            │  multi-round, parallel, bounded
└────────┬─────────┘
         ▼
┌──────────────────┐
│ Simulate top N   │  core.simulate, minAmountOut = 1
└────────┬─────────┘
         ▼
┌──────────────────┐
│ Risk gate        │  paused, cap, operator, gas, PnL, freshness
└────────┬─────────┘
         ▼
┌──────────────────┐
│ Build / send tx  │  default tip, no bidding
└────────┬─────────┘
         ▼
┌──────────────────┐
│ Receipt / PnL    │  decode Executed, reconcile, persist
└──────────────────┘
```

Multiple logs in the same Flashblock are processed as one batch. There is no artificial
debounce delay; deduplicate by `(pool, block)` and keep only the newest work item.

### 7.3 Components

1. **Config and manifest loader**
   - Read `deployments/8453.json`.
   - Load tokens, pools, adapters, routers, caps, thresholds, and mode.
   - Validate everything at startup (§10.2).
   - Reload safely on admin events or SIGHUP.

2. **Chain client**
   - HTTP for reads, simulations, and sending.
   - WebSocket for subscriptions.
   - Retries with backoff, request timeouts, block pinning, and endpoint failover.
   - `eth_call` at `latest`, `pending`, and historical blocks (archive for replay).

3. **Event ingest**
   - One Tokio task per subscription.
   - Reconnect with exponential backoff and resubscribe.
   - Decode into typed events: `Swap`, `Admin`, `Block`, `Transfer`, `Unknown`.
   - Send work items into a bounded channel.

4. **State cache**
   - V2/Aerodrome: reserves per pool.
   - V3/Slipstream: `sqrtPriceX96`, `liquidity`, `tick`, and tick-spacing metadata.
   - Phase 1: mark pools dirty and quote on-chain. Do not attempt full local tick math yet.
   - Phase 2: local math for V2/Aerodrome; on-chain quotes for V3/Slipstream.
   - Always treat cached state as a hint, not ground truth. `simulate` is the arbiter.

5. **Route graph**
   - Nodes: tokens. Edges: `(venue, pool, tokenIn -> tokenOut, fee/params)`.
   - Enumerate simple cycles starting and ending at the borrowed asset.
   - Phase 1: 2-hop. Phase 2: 3-hop. Later: up to `MAX_STEPS = 8`.
   - Reject cycles that reuse the same pool.
   - Prefilter with a price matrix or negative-cycle detection before quoting.

6. **Quoter**
   - Per-venue quote functions.
   - **Sequential quoting:** quote leg 1 for all candidates in parallel; feed outputs into
     leg 2; repeat. Two rounds for 2-hop, three for 3-hop.
   - Do **not** try to chain legs inside one Multicall3 `aggregate3` call.
   - Add a small safety margin to each leg's `minAmountOut`.

7. **Simulation engine**
   - `core.simulate(asset, amount, steps)` with `minAmountOut = 1` per leg for discovery.
   - Decode `SimulationResult(int256)`.
   - Batch independent simulations through Multicall3 with `allowFailure = true`, chunked to
     stay under provider `eth_call` gas limits.
   - Re-simulate the chosen route with the **actual** floors immediately before sending.

8. **Risk gate**
   - Check paused, cap, adapter whitelist, operator, gas ceiling, Vault balance, token
     decimals, expected profit after gas and L1 fee, route freshness, and daily loss limits.
   - Optional: max trades per hour, max daily gas spend, max consecutive failures.
   - Optional: pause the contract automatically on anomaly (human unpauses).

9. **Transaction builder / sender**
   - Encode `execute(asset, amount, steps, minProfit)`.
   - Per-leg `minAmountOut` from fresh quotes minus a buffer.
   - `minProfit` from expected profit minus a buffer, floored at gas cost × k.
   - Gas: `eth_estimateGas` with a buffer; EIP-1559 fees with a minimum tip.
   - Nonce management: one sender, serialized sends, reconcile with
     `eth_getTransactionCount(..., "pending")`.
   - Submission: Alchemy Base HTTP endpoint. No private bundle required on Base.
   - Wait for receipt; decode `Executed`; compute actual profit and cost.

10. **PnL / operations**
    - Index `Executed` events; reconcile with receipt gas (L2 + L1).
    - Persist nonce, pending tx, last processed block, trade records, and config version.
    - Metrics: opportunities, simulations, executions, success rate, profit, gas, latency.
    - Alerts: low operator balance, paused, cap zero, repeated reverts, RPC lag, admin
      changes, owner/operator/recipient changes, adapter removal.
    - Health endpoint: `/health` and `/metrics`.

### 7.4 Suggested repo layout

A single crate first; split into a workspace only if it grows.

```
ryo-watch/
  Cargo.toml
  rust-toolchain.toml
  .env.example
  config/
    base.json
  deployments/
    8453.json
  src/
    main.rs
    config.rs
    manifest.rs
    chain.rs              // HTTP + WS clients, retries, multicall
    abi/
      mod.rs
      ryo_core.rs
      adapters.rs
      quoters.rs
      erc20.rs
      multicall3.rs
    events/
      mod.rs
      ingest.rs           // subscriptions, reconnect
      decode.rs           // typed events
      classify.rs
    state/
      mod.rs
      pools.rs
      tokens.rs
    routes/
      mod.rs
      registry.rs
      cycles.rs
      price_matrix.rs
    strategy/
      quoter.rs
      optimizer.rs
      scanner.rs
      risk.rs
    core/
      encode.rs           // Step[] + execute/simulate
      decode.rs           // SimulationResult + errors
      simulate.rs
      execute.rs
    venues/
      uniswap_v2.rs
      uniswap_v3.rs
      aerodrome.rs
      slipstream.rs
    ops/
      gas.rs              // L1 + L2 fee, USD conversion
      pnl.rs
      metrics.rs
      alerts.rs
      health.rs
      persistence.rs
  tests/
    unit/
    fork/
    replay/
```

### 7.5 Concurrency model

- **Tokio** runtime.
- One task per WebSocket subscription.
- Bounded `mpsc` channel from ingest to strategy. `try_send`; on full, drop the oldest/stale
  item and increment a metric.
- One **strategy task** owns route selection, nonce, pending tx, and execution.
- A separate sender task signs and broadcasts, so the strategy task never blocks on network
  I/O.
- `ArcSwap` for read-mostly config and pool state; immutable snapshots per decision.
- Cancellation token for shutdown and for superseded work.
- Generation counters: if a newer event arrives for the same pool, ignore older in-flight
  results.

### 7.6 Latency budget

Targets, measured p50/p95/p99:

| Stage | Target |
|---|---|
| WebSocket delivery | 5–30ms |
| Decode / classify | <5ms |
| State update / candidate set | <10ms |
| Quotes (parallel) | 20–80ms |
| Simulate top N | 30–100ms |
| Risk gate / encode | <5ms |
| Sign / send | 5–20ms |
| **Total** | **~100–200ms** |

Network round-trip to Alchemy dominates. Local CPU work should be negligible. Log every
stage so regressions are visible.

---

## 8. Quoting and route search

### 8.1 Universe

Start curated, not exhaustive:

- **Borrowed assets:** USDC, WETH. (Vault liquidity is meaningful only for these.)
- **Other tokens:** cbBTC, EURC, AERO, but only if Vault liquidity and pool depth justify it.
- **Venues:** UniV3 (fee tiers 100/500/3000/10000), UniV2, Aerodrome classic
  (stable/volatile), Slipstream (tick spacings 1/10/50/100/200).
- **Pools:** only pools with real liquidity and code. Verify via factory
  `getPool`/`getPair` and/or a subgraph.

### 8.2 Cycle enumeration

- **2-hop:** for each token pair `(A,B)`, compare every venue's `A->B` rate with every other
  venue's `B->A` rate.
- **3-hop:** for each triple `(A,B,C)`, combine venues; restrict to tokens with deep
  liquidity.
- **4+ hop:** only around a detected mispricing; do not brute-force the full graph.
- **Negative-cycle prefilter:** assign edge weight `-ln(rate_after_fee)` using current pool
  prices; Bellman-Ford finds candidate cycles. Then quote/simulate the actual amounts.
- **Avoid pool reuse.** A route that uses the same pool twice needs sequential quoting; reject
  it in the first version.

### 8.3 Quoting: three options

The old plan said "batch all legs in one Multicall3 call" and "quote sequentially." Those are
incompatible. Pick one:

1. **Simulate-only discovery (most accurate, simplest).**
   - Call `core.simulate` with `minAmountOut = 1` for each candidate and amount.
   - It returns exact net profit after real swaps and the Balancer fee.
   - No sequential quoting needed.
   - Cost: one `eth_call` per candidate, roughly 1M gas each. Prefilter first, chunk batches.

2. **Multi-round quoting (fastest for prefiltering).**
   - Quote leg 1 for every candidate in parallel.
   - Feed outputs into leg 2, then leg 3.
   - Two rounds for 2-hop, three for 3-hop.
   - Then simulate the top few candidates with real floors.
   - Cost: more RPC round trips, but cheap calls.

3. **QuoteHelper contract (best for scale).**
   - A small deployed contract loops legs and calls venue quoters, returning all intermediate
     amounts in one call per route.
   - Cleanest for latency and RPC count, but adds a contract to test, verify, and maintain.

**Recommendation:** Phase 2 uses multi-round quoting for the prefilter and `simulate` for the
top 2–3 candidates. Add a QuoteHelper only if the scanner is latency-bound.

### 8.4 Amount sizing

For a route with amount `x`:

```
profit(x) = output_n(...output_1(x)...) - x - flashLoanFee(x)
```

- `profit(x)` is generally concave/unimodal for AMM routes, but concentrated liquidity
  introduces kinks. A grid plus local refinement handles both.
- Bound `x` by `min(maxTradeSize[asset], vaultBalance(asset), liquidityEstimate)`.
- Coarse log-spaced grid (about 10 points), then ternary/golden-section refinement around the
  best.
- Finally `simulate` the top 2–3 amounts.

### 8.5 Net profitability

```
netProfitUsd = profitInAsset * assetUsdPrice - gasCostUsd - l1FeeUsd
```

- `gasCostUsd` = L2 gas (`gasUsed * effectiveGasPrice`) plus the L1 data fee, converted to
  USD.
- Require `netProfitUsd > minNetProfitUsd` (config, e.g., $0.25–$1.00 to start) and
  `netProfitUsd > gasCostUsd * safetyMultiple` (e.g., 2–3×).
- Also require `profit > 0` in asset units.
- Include **failed-transaction gas** in the budget. A revert still costs gas.

### 8.6 `simulate` as ground truth

- `simulate` executes the real flash loan and every real swap, so it captures fees, pool
  state, and interactions that off-chain quotes miss.
- It requires **non-zero** `minAmountOut` on every leg. Use `1` for discovery.
- It does **not** enforce `maxTradeSize`, `paused`, `maxGasPrice`, or operator. Check those
  separately.
- It excludes pre-existing core dust and gas, includes the Balancer fee, and can return a
  negative `int256`.
- It is not guaranteed to revert with `SimulationResult`; handle every other error.
- A simulation with `minAmountOut = 1` is not proof that the floor-bearing route will pass.
  Re-simulate with the actual floors before sending.

### 8.7 Route hash and floor policy

- `routeHash` includes `minAmountOut` and `data`. Discovery and execution routes have
  different hashes. Store the exact steps sent.
- Per-leg floors compound: 20 bps on each of three legs is about 60 bps total. Budget for it.
- The final leg's floor should be at least `amount + flashLoanFee + minProfit`; otherwise a
  low final floor can still end in `MinProfitNotMet` or `Loss`.
- Too tight = reverts; too loose = sandwich bait.

---

## 9. Execution policy

### 9.1 Event-to-execution pipeline

1. **Event arrives.** A swap, a block, or an admin change.
2. **Narrow the universe.** Only routes containing the affected pool(s).
3. **Quote.** Multi-round, parallel, bounded.
4. **Simulate.** Top 2–3 candidates and amounts, with `minAmountOut = 1`.
5. **Gate.** Paused, cap, adapter, operator, gas, Vault liquidity, net profit, freshness.
6. **Re-simulate** the winner with actual floors.
7. **Build and send.** Default tip, no bidding.
8. **Confirm.** Decode `Executed`, compute PnL, persist, alert on anomaly.
9. **On revert.** Decode the reason, log, back off, and do not blindly retry the same route.

### 9.2 Gas and L1 fee

```
l2_fee_wei = gas_used * effective_gas_price
l1_fee_wei = GasPriceOracle.getL1Fee(serialized_tx)
           // or getL1FeeUpperBound(tx_size) before signing
total_fee_wei = l2_fee_wei + l1_fee_wei
```

- `effective_gas_price = base_fee + priority_fee` for EIP-1559.
- GasPriceOracle: `0x420000000000000000000000000000000000000F`.
- Current oracle `decimals = 6`; the returned value is in wei.
- `maxGasPrice` in `RyoCore` covers `tx.gasprice`, not the L1 data fee.
- Convert to USD with Chainlink feeds:
  - ETH/USD `0x71041dddad3595F9CEd3DcCFBe3D1F4b0a16Bb70`
  - USDC/USD `0x7e860098F58bBFC8648a4311b374B1D669a2bc6B`
  - BTC/USD `0x64c911996D3c6aC71f9b455B1E8E7266BcbD848F`
  - EUR/USD `0xc91D87E81faB8f93699ECf7Ee9B44D11e1D53F0F`
- Check `updatedAt` staleness and positive answers. If a feed is stale, fail closed or skip
  USD-gated execution.
- AERO/USD was not verified. Derive from a DEX quote or skip AERO PnL.

### 9.3 Submission / MEV

- Base has a private sequencer mempool. There is no public pending pool to front-run.
- The relevant competition is a priority-fee auction inside 200ms Flashblocks.
- **This bot does not bid.** It uses the minimum/default tip and accepts a lower win rate.
- `maxFeePerGas` may include headroom for base-fee movement, but it is a cap, not a bid.
- Do not split large opportunities into many transactions by default; the operator nonce
  serializes them and each extra tx adds cost.
- Keep `minProfit` tight enough that a copier cannot profit after you, but loose enough to
  land.

### 9.4 Nonce / failure handling

- One hot EOA, one in-flight tx at a time (simplest).
- Track nonce locally; reconcile with `eth_getTransactionCount(..., "pending")`.
- On stuck tx: **by default, wait and alert**. Optional replacement with the same nonce and a
  higher fee is disabled by default because it conflicts with the no-bidding policy.
- On revert: log the decoded error; do not retry the same route blindly.
- Circuit breaker: pause after N consecutive failures or abnormal gas spend; alert.
- Reorg handling: a receipt means included, not final. Track canonical blocks, reorged logs,
  and reconcile PnL after finality.

### 9.5 Persistence

Store in SQLite (or an embedded key-value store):

- last processed block / Flashblock,
- nonce and pending transaction,
- recent simulations and executions,
- PnL records,
- config/manifest version and hash.

On restart, reconcile with chain state before trading.

---

## 10. Operations and security

### 10.1 Key management

- **Owner:** Safe or hardware wallet. Not the watcher.
- **Operator:** dedicated hot wallet with minimal ETH for gas.
- **Profit recipient:** separate address.
- Store the operator key in a secret manager or encrypted environment variable; never in the
  repo.
- Rotate the operator key periodically via `setOperator` (owner action).
- The watcher never needs the owner key.

### 10.2 Startup validation

Validate more than the earlier draft listed:

- Manifest chain ID is `8453`.
- `core.owner() != address(0)` and matches the expected owner/Safe.
- `core.pendingOwner()` is understood; a pending transfer is not ownership yet.
- `core.vault()` equals the expected Balancer Vault.
- `core.operator()` equals the signer, or `core.owner()` equals the signer.
- `core.profitRecipient()` matches the expected address.
- `core.paused() == false` for live mode.
- `core.VERSION() == 1` and `core.MAX_STEPS() == 8`.
- `core.isAdapter(adapter) == true` for every adapter.
- `adapter.core() == core` and `adapter.router() == expected router`.
- `core.maxTradeSize(asset) > 0` for every traded asset.
- Code exists at every core, adapter, router, quoter, Vault, token, and Multicall3 address.
- Token decimals and symbols match config.
- Vault balance for each borrowed asset is above the minimum.
- `getFlashLoanFeePercentage()` is read, not assumed zero.
- Gas balance is above the minimum.
- Chainlink feeds are fresh and positive.

### 10.3 Monitoring and alerts

- **Contract admin:** `AdapterSet`, `OperatorSet`, `ProfitRecipientSet`,
  `MaxTradeSizeSet`, `MaxGasPriceSet`, `Paused`, `Unpaused`, `OwnershipTransferStarted`,
  `OwnershipTransferred`, `Swept`.
- **Execution:** `Executed` (profit, asset, routeHash), reverts, gas cost, latency.
- **Infra:** RPC errors, block lag, WebSocket disconnects, low ETH balance, high revert rate.
- **Alerts:** Telegram/Discord/PagerDuty; include tx hash and decoded reason.
- Deduplicate and rate-limit alerts.

### 10.4 Runbook

- **Pause:** operator calls `pause()`; owner calls `unpause()` after review.
- **Adapter issue:** owner calls `setAdapter(adapter, false)`; watcher refreshes.
- **Cap change:** owner calls `setMaxTradeSize`; watcher refreshes.
- **Operator compromise:** owner calls `setOperator(new)`; stop the watcher.
- **Stuck funds:** owner calls `sweep(token, to)` when no execution is in flight.
- **RPC outage:** fail over to a backup endpoint; do not send blind.
- **Owner renounce alert:** if `OwnershipTransferred(previousOwner, 0)` is observed on an
  already-deployed core, treat it as critical. New deployments use the override in §11.

### 10.5 Health endpoint

Expose:

- mode (`dry-run`, `paper`, `live`, `paused`, `emergency`),
- last processed block/Flashblock,
- WebSocket status and reconnect count,
- operator ETH balance,
- paused state, caps, owner, operator,
- recent opportunity/simulation/execution counts,
- p50/p95/p99 latency,
- last error.

---

## 11. Contract changes (approved)

Do these before any bot code.

### 11.1 Disable `renounceOwnership()`

Add to `RyoCore.sol`:

```solidity
error RenounceDisabled();

/// @notice Ownership can never be renounced: it would permanently disable
///         unpause, sweep, and every admin setter.
function renounceOwnership() public pure override {
    revert RenounceDisabled();
}
```

Test:

```solidity
function test_renounce_is_disabled() public {
    vm.expectRevert(RyoCore.RenounceDisabled.selector);
    core.renounceOwnership();
    assertEq(core.owner(), address(this));
}
```

Also keep a test that normal `Ownable2Step` transfer still works:

- `transferOwnership(newOwner)` sets `pendingOwner`,
- `acceptOwnership()` from the new owner completes the transfer.

### 11.2 Deployment manifest

`script/Deploy.s.sol` currently only logs addresses. Make it write
`deployments/8453.json`:

```json
{
  "chainId": 8453,
  "deployer": "0x...",
  "blockNumber": "123456",
  "timestamp": "1234567890",
  "core": "0x...",
  "vault": "0xBA12222222228d8Ba445958a75a0704d566BF2C8",
  "owner": "0x...",
  "operator": "0x...",
  "profitRecipient": "0x...",
  "adapters": {
    "univ2": "0x...",
    "univ3": "0x...",
    "aerodrome": "0x...",
    "slipstream": "0x..."
  },
  "routers": {
    "univ2": "0x4752ba5DBc23f44D87826276BF6Fd6b1C372aD24",
    "univ3": "0x2626664c2603336E57B271c5C0b26F421741e481",
    "aerodrome": "0xcF77a3Ba9A5CA399B7c97c74d54e5b1Beb874E43",
    "slipstream": "0xBE6D8f0d05cC4be24d5167a3eF062215bE6D18a5"
  },
  "tokens": {
    "USDC": "0x833589fCD6eDb6E08f4c7C32D4f71b54bdA02913",
    "WETH": "0x4200000000000000000000000000000000000006",
    "cbBTC": "0xcbB7C0000aB88B473b1f5aFd9ef808440eed33Bf",
    "EURC": "0x60a3E35Cc302bFA44Cb288Bc5a4F316Fdb1adb42",
    "AERO": "0x940181a94A35A4569E4529A3CDfB74e38FD98631"
  },
  "caps": {
    "USDC": "100000000",
    "WETH": "1000000000000000000"
  },
  "maxGasPrice": "0",
  "version": 1
}
```

Use strings for all `uint256` values to avoid JSON precision loss.

Implementation notes:

- Use `vm.serializeAddress`, `vm.serializeUint`, `vm.serializeString`, then `vm.writeJson`.
- Add write permission in `foundry.toml`:
  ```toml
  fs_permissions = [
    { access = "read", path = "./" },
    { access = "read-write", path = "./deployments" }
  ]
  ```
- Create `deployments/` before writing.
- Commit the manifest after deployment. It contains no secrets.
- The watcher refuses to start if the manifest is missing, malformed, or its chain ID is not
  8453.

### 11.3 Acceptance for Phase 0

- `forge test` passes, including the new renounce test.
- `forge script script/Deploy.s.sol` on a Base fork writes a valid `deployments/8453.json`.
- The manifest parses and every address in it has code.
- The watcher's startup validation passes against the fork deployment.

---

## 12. Testing strategy

### 12.1 Unit tests

- ABI encoding/decoding of `Step[]`, `execute`, `simulate`.
- `SimulationResult` decoding (positive, zero, negative).
- Error selector decoding for core, adapter, router, Balancer, and OpenZeppelin errors.
- Route graph: cycle enumeration, no pool reuse, token continuity.
- Amount optimizer: monotonic sanity, bounds, integer safety.
- Gas/PnL math: decimals, L1 fee, USD conversion, stale oracle handling.
- Config validation: bad addresses, zero caps, wrong operator, missing manifest.

### 12.2 Fork integration tests

- Anvil fork of Base (`anvil --fork-url $BASE_RPC_URL`).
- Deploy core and adapters via `Deploy.s.sol`.
- Configure caps and operator.
- Manufacture an opportunity (large swap into a real pool, as `RyoFork.t.sol` does).
- Run the watcher in dry-run: assert it finds the route and the simulation matches.
- Run in execute mode: assert `Executed`, profit arrives, core dust unchanged, Vault repaid.
- Failure cases: paused, cap too low, stale quote, wrong fee tier, non-operator signer,
  insufficient Vault liquidity.

### 12.3 Replay and backtests

- Use an archive RPC to replay scanning at historical blocks.
- Measure opportunity frequency, profit distribution, false positives, and gas costs.
- Tune thresholds and the token/pool universe.
- Compare event-driven triggers against a simple block-based replay to verify the event path
  sees the same opportunities.

### 12.4 Chaos / soak

- RPC timeouts, 429s, WebSocket drops, reorgs, nonce conflicts.
- 24–72h dry-run on mainnet before enabling execution.
- Verify reconnect and resubscribe behavior.
- Verify that a dropped or superseded event does not cause a stale trade.

---

## 13. Build milestones

> The first milestone is still "decide later." The recommendation is Phase 0 and Phase 1,
> then Phase 2 (dry-run), because that produces something useful without risking money.

### Phase 0 — Contract safety and manifest (1 day)

- Add the `renounceOwnership()` override and test.
- Make `Deploy.s.sol` write `deployments/8453.json`.
- Rerun the full test suite.
- **Acceptance:** all tests pass; fork deploy writes a valid manifest.

### Phase 1 — Rust skeleton and simulation CLI (2–3 days)

- Rust crate, config, manifest loader, ABIs.
- `Step[]` encoding; `execute`/`simulate` encoding.
- `SimulationResult` and error decoding.
- CLI: `simulate --asset --amount --route`.
- Startup validation.
- **Acceptance:** simulate a USDC→WETH→USDC route on a Base fork and decode the profit and
  every error type.

### Phase 2 — Event-driven dry-run scanner (3–5 days)

- Alchemy WebSocket ingest with reconnect.
- Pool registry for USDC/WETH on UniV3, UniV2, Aerodrome classic, Slipstream.
- 2-hop cycle enumeration from affected pools.
- Multi-round quoting plus `simulate`.
- Ranked opportunity log with expected profit, gas, and L1 fee. No transactions.
- **Acceptance:** 24–72h dry-run; every logged opportunity survives a fresh simulation; no
  stale or duplicate trades.

### Phase 3 — Fork executor (3–4 days)

- Tx builder with per-leg floors and `minProfit`.
- Gas estimation, EIP-1559 fees with minimum tip, nonce management.
- Persistence and restart reconciliation.
- Execute on an Anvil fork; verify `Executed`, profit, dust, and Vault repayment.
- **Acceptance:** end-to-end execution on a fork; every revert reason decoded; PnL reconciles.

### Phase 4 — Tiny live pilot (1 week, tiny caps)

- Deploy to Base or attach to a real core.
- Caps: 50–100 USDC equivalent.
- 24–72h mainnet dry-run before enabling execution.
- Monitor every tx; reconcile PnL.
- **Acceptance:** N successful trades, no unexpected reverts, PnL reconciles.

### Phase 5 — Scale and harden

- 3–4 hop routes; more tokens/pools.
- Optional QuoteHelper contract.
- Priority-fee **measurement** (not bidding): log how often a higher-tip tx wins.
- Denim readiness: switch from Flashblocks to canonical 200ms blocks without strategy changes.
- Dashboard, Docker/systemd, full observability.
- **Acceptance:** stable 24/7 operation within risk limits.

---

## 14. Open decisions and inputs needed

1. **Alchemy Base Mainnet URLs.** Need both:
   - `https://base-mainnet.g.alchemy.com/v2/...` for reads and sending,
   - `wss://base-mainnet.g.alchemy.com/v2/...` for event subscriptions.
   Keep them private; store them in `.env`, never in the repo.
2. **First milestone.** Still undecided. Recommendation: Phase 0 + Phase 1, then Phase 2.
3. **Deployment target.** Fork only for now, or a tiny Base mainnet deployment later?
4. **Wallet setup.**
   - Owner: Safe or hardware wallet.
   - Operator: hot wallet with minimal ETH.
   - Profit recipient: separate address.
5. **Risk limits.** Starting cap per asset, minimum net profit, max gas price, max daily gas
   spend, max consecutive failures.
6. **Hosting.** Local machine, VPS, Docker, or systemd? WebSocket needs outbound access only;
   webhooks need a public endpoint.
7. **Alert channel.** Telegram, Discord, PagerDuty, or none.
8. **Stuck-tx policy.** Wait and alert by default. Enable same-nonce replacement later only if
   needed.

---

## 15. Research checklist

- [x] Analyze `RyoCore`, adapters, interfaces, tests, deploy script, README, and setup docs.
- [x] Run the full test suite: 119/119 pass (105 non-fork + 14 fork).
- [x] Verify core/function/error selectors.
- [x] Verify adapter `data` encodings.
- [x] Verify Base addresses, routers, quoters, factories, and Multicall3 have code.
- [x] Verify quoter call shapes and pool discovery.
- [x] Verify Balancer flash-loan fee and Vault balances.
- [x] Verify Chainlink ETH/USD, USDC/USD, BTC/USD, EUR/USD feeds.
- [x] Verify GasPriceOracle behavior and `getL1FeeUpperBound`.
- [x] Verify Base block time, Flashblocks, ordering, and private mempool.
- [x] Verify Alchemy Base Flashblocks subscriptions and webhook limitations.
- [x] Confirm `renounceOwnership()` bricks admin functions (temporary Foundry test).
- [ ] Alchemy Base Mainnet HTTPS and WSS URLs.
- [ ] Actual deployment or a fork-only decision.
- [ ] First milestone decision.
- [ ] Wallet setup.
- [ ] Risk limits.
- [ ] Hosting and alert channel.
- [ ] AERO/USD feed, or skip AERO PnL.
- [ ] Generate exact router and Balancer error selectors from their ABIs.
- [ ] Denim migration test (canonical 200ms blocks).

---

## 16. Appendix

### 16.1 Route encoding example (Rust, illustrative)

```rust
use alloy::sol_types::SolCall;

let steps = vec![
    Step {
        adapter: aerodrome_adapter,
        tokenIn: USDC,
        tokenOut: WETH,
        minAmountOut: min_weth_out,
        data: encode_bool(false).into(), // volatile
    },
    Step {
        adapter: univ3_adapter,
        tokenIn: WETH,
        tokenOut: USDC,
        minAmountOut: min_usdc_out,
        data: encode_uint24(500).into(), // 0.05%
    },
];

let call = executeCall {
    asset: USDC,
    amount,
    steps,
    minProfit,
};
let calldata = call.abi_encode();
```

### 16.2 Core error selectors

| Error | Selector |
|---|---|
| `SimulationResult(int256)` | `0x00cf1ea6` |
| `MinProfitNotMet(uint256,uint256)` | `0x2c10b304` |
| `InsufficientOutput(uint256,uint256,uint256)` | `0x3f612d47` |
| `Loss(uint256,uint256)` | `0x86f83f02` |
| `TradeTooLarge(address,uint256,uint256)` | `0x8e8dd3a9` |
| `AdapterNotAllowed(address)` | `0xfae021e8` |
| `GasPriceTooHigh(uint256,uint256)` | `0x94118333` |
| `Executed(address,address,uint256,uint256,address,bytes32)` event | `0xa05f8c54` |

> Regenerate selectors from the ABI; do not rely on this table forever.

### 16.3 Error sources the watcher must decode

A bad fill usually reverts in the **router**, not in `RyoCore`. Decode all of these:

| Source | Examples |
|---|---|
| Core | `Loss`, `MinProfitNotMet`, `InsufficientOutput`, `TradeTooLarge`, `AdapterNotAllowed`, `ContractPaused`, `NotOperator`, `GasPriceTooHigh`, `RouteMismatch`, `InvalidStep`, `InvalidMinOut`, `InputNotConsumed`, `AdapterKeptInput`, `NegativeOutput`, `UnauthorizedCallback`, `CallbackAlreadyConsumed`, `CallbackNotCalled`, `InvalidFlashLoanData`, `SimulationFailed` |
| Adapters | `Unauthorized`, `ZeroAddress`, `NotContract`, `ZeroAmount`, `InvalidTokenPair`, `InvalidMinAmountOut`, `InvalidDataLength`, `LeftoverToken`, `InvalidTickSpacing` |
| UniV3 / Slipstream routers | `Error(string)` (for example, `Too little received`), router custom errors |
| UniV2 / Aerodrome routers | `Error(string)` (for example, `INSUFFICIENT_OUTPUT_AMOUNT`), router custom errors |
| Balancer Vault | Vault custom errors (load from `IBalancerVault` ABI) |
| OpenZeppelin | `OwnableUnauthorizedAccount(address)`, `OwnableInvalidOwner(address)`, `ReentrancyGuardReentrantCall()`, `SafeERC20FailedOperation(address)` |
| Solidity | `Error(string)` (`0x08c379a0`), `Panic(uint256)` (`0x4e487b71`) |
| Unknown | Log the raw selector and data; alert; do not guess |

### 16.4 Error taxonomy and watcher reaction

| Revert | Likely cause | Watcher action |
|---|---|---|
| `TradeNotAllowed(asset)` | Cap is 0 | Disable asset, alert |
| `TradeTooLarge(asset,amount,max)` | Amount above cap | Re-size, refresh cap |
| `ContractPaused()` | Owner/operator paused | Stop executing, alert |
| `NotOperator(caller)` | Signer not operator | Stop, alert, check `OperatorSet` |
| `AdapterNotAllowed(adapter)` | Adapter removed | Refresh registry, alert |
| `GasPriceTooHigh(gas,max)` | Fee above ceiling | Wait or raise cap |
| `RouteTooShort` / `RouteTooLong` | Encoder bug | Fix code, unit test |
| `RouteMismatch(i)` | Route graph bug | Fix code, unit test |
| `InvalidStep(i)` | Zero token or self-swap | Fix route |
| `InvalidMinOut(i)` | Zero floor | Fix encoder |
| `InvalidRouteVersion(v)` | Version byte mismatch | Fix encoder |
| `InputNotConsumed(i,...)` | Router pulled less / fee-on-transfer | Blacklist token/pool |
| `AdapterKeptInput(i,...)` | Router left input in adapter | Blacklist pool |
| `InsufficientOutput(i,...)` | Price moved / thin pool | Re-quote, back off |
| `NegativeOutput(i)` | Rebasing/weird token | Blacklist token |
| `Loss(after,before)` | Route unprofitable | Re-quote, skip |
| `MinProfitNotMet(profit,min)` | Profit below floor | Re-quote, lower size |
| `UnauthorizedCallback()` | Callback guard (should not happen) | Critical alert |
| `CallbackAlreadyConsumed()` | Double callback (should not happen) | Critical alert |
| `CallbackNotCalled()` | Vault did not call back | Critical alert |
| `InvalidFlashLoanData()` | Wrong token/amount (should not happen) | Critical alert |
| `SimulationFailed()` | Vault did not run route | Check asset/Vault |
| `SimulationResult(int256)` | Expected simulate revert | Decode profit |
| Router `Error(string)` | Router `minAmountOut` failed | Decode message; re-quote |
| Balancer error | Loan or callback problem | Alert; check Vault state |
| OZ `SafeERC20FailedOperation` | Token transfer failed | Blacklist token |

---

## 17. One-paragraph summary

RyoWatch is a Rust, event-driven watcher for the `RyoCore` arbitrage contract on Base. It
subscribes to Alchemy's Base WebSocket, primarily the 200ms Flashblocks streams, and wakes
only when a pool or admin event occurs. It updates only the affected pools, quotes the
candidate cycles, simulates the top few through `core.simulate`, subtracts gas and the L1
data fee, checks the contract's safety rules, and sends one transaction with the network's
minimum tip. It does not poll for opportunities and does not bid up priority fees. Before any
of this runs, the contract gets two safety changes: `renounceOwnership()` is disabled, and
the deploy script writes a machine-readable `deployments/8453.json` manifest. Everything is
tested on a free Base fork first; real money comes only after a dry-run proves the edge.

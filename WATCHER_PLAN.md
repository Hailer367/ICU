# RyoWatch — Analysis & Build Plan

> Draft working document for the off-chain watcher that drives the `RyoCore` arbitrage
> contract. The contract itself is intentionally dumb: the watcher is where the strategy,
> quoting, route search, and execution policy live.

---

## 0. Snapshot of what was analyzed

| Item | Value |
|---|---|
| Repo | `Hailer367/ICU` |
| Archive | `ryo-next.tar.gz` (15.8 MB) |
| Extracted to | `extracted/ryo-next/` (local analysis path; generated from the archive) |
| Project | Ryo — Base-only Balancer flash-loan arbitrage executor |
| Language | Solidity `^0.8.28`, built with Foundry |
| Core | `src/RyoCore.sol` (472 lines) |
| Adapters | UniV3, UniV2, Aerodrome classic, Aerodrome Slipstream (single-hop) |
| Tests | 3.5k lines total; 98% line coverage on core, 100% on adapters |
| Toolchain | solc 0.8.38, Cancun, via-IR, optimizer 1,000,000 runs |
| Dependencies | OpenZeppelin 5.7.0, forge-std 1.17.0 |

### Important finding: no real deployment yet

`broadcast/Deploy.s.sol/8453/run-latest.json` is a **local Anvil simulation**:

- deployer/sender is `0xf39Fd6e51aad88F6F4ce6aB8827279cffFb92266` (Anvil account #0),
- nonce is `0x3484f6`,
- the broadcast was made against a fork, not Base mainnet.

Do **not** hard-code those addresses as live contracts. The watcher must be configured from
a real deployment artifact. The current deploy script also does **not** write an address
manifest, which is a gap we should fix before building the watcher.

---

## 1. What the contract actually does

### 1.1 One transaction, one linear cyclic route

```
operator
   │ execute(asset, amount, steps[], minProfit)
   ▼
RyoCore ── flashLoan(asset, amount) ──► Balancer V2 Vault
   │                                        │
   │◄──────────── receiveFlashLoan ─────────┘
   │
   ├─ step 0: asset ──► token B
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
- **The core knows nothing about DEXes.** It only moves tokens through whitelisted adapters
  and measures balances.

### 1.2 Roles

| Role | Can do | Cannot do |
|---|---|---|
| Owner (Safe/hardware) | Configure everything, unpause, sweep dust, transfer ownership | — |
| Operator (hot wallet) | `execute`, `pause` | Change config, unpause, move funds |
| Profit recipient | Receive profit | Call anything |
| Anyone | `simulate` | Execute, configure, pause |

- `Ownable2Step`: ownership handoff requires `acceptOwnership()`.
- A compromised operator can waste gas and pause, but cannot steal principal or redirect
  profit.
- A compromised owner can do anything the contract allows. Owner should be a Safe.

### 1.3 Mutable configuration

| Setting | Meaning | Watcher implication |
|---|---|---|
| `operator` | Hot wallet allowed to execute/pause | Watcher's signer must match; monitor `OperatorSet` |
| `profitRecipient` | Where profit goes | PnL tracking; monitor changes |
| `isAdapter[adapter]` | Whitelisted adapters | Routes must use these; monitor `AdapterSet` |
| `maxTradeSize[asset]` | Max borrow per asset; **0 disables** | Watcher must respect and refresh |
| `maxGasPrice` | Optional `tx.gasprice` ceiling (wei); 0 disables | Watcher enforces its own, plus L1 fee |
| `paused` | Execution stop; simulation still works | Watcher must check `paused()` |

### 1.4 Immutable / constants

- `VERSION = 1` — envelope version in `abi.encode(uint8(1), steps)`.
- `MAX_STEPS = 8`.
- Minimum route length = 2.
- Balancer Vault is immutable.

---

## 2. Watcher-facing ABI

### 2.1 Structs

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

### 2.2 Functions

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
| `Executed(address,address,uint256,uint256,address,bytes32)` event | `0xa05f8c54...` |

### 2.3 Simulation decoding

`simulate` never returns normally. It reverts with:

```
0x00cf1ea6
<32-byte int256 profit>
```

In TypeScript/viem:

```ts
// Single call: raw eth_call, catch the revert payload.
const data = await client.request({
  method: "eth_call",
  params: [{ to: core, data: encodeFunctionData({ abi, functionName: "simulate", args }) }, "latest"],
}).catch((e) => e.data ?? e.cause?.data);

if (data?.startsWith("0x00cf1ea6")) {
  const word = BigInt("0x" + data.slice(10, 74)); // 32-byte int256
  const profit = word & (1n << 255n) ? word - (1n << 256n) : word;
}
```

For batches, use Multicall3 `aggregate3` with `allowFailure = true`. Each failed call's
`returnData` is the revert payload, so the outer call succeeds and you can decode every
result in one RPC round trip.

Multicall3 on Base: `0xcA11bde05977b3631167028862bE2a173976CA11`.

### 2.4 Events to index

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
correlate an `Executed` event with a candidate route.

### 2.5 Read-only getters

`vault()`, `operator()`, `profitRecipient()`, `paused()`, `isAdapter(address)`,
`maxTradeSize(address)`, `maxGasPrice()`, `owner()`, `pendingOwner()`, `VERSION()`,
`MAX_STEPS()`.

---

## 3. Hard rules the watcher must encode

These are enforced by the contract; violating any of them burns gas on a revert.

1. **Route must be a cycle.** `steps[0].tokenIn == asset`, each `steps[i].tokenIn ==
   steps[i-1].tokenOut`, and `steps[last].tokenOut == asset`.
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
9. **`maxGasPrice != 0` → `tx.gasprice ≤ maxGasPrice`.** This is L2 gas price only; it does
   not cover the L1 data fee.
10. **One flash-loan callback per tx.** No nested executions.
11. **Exact input consumption.** Fee-on-transfer / rebasing tokens will revert; do not route
    them.
12. **No loss after repayment.** Even `minProfit = 0` requires `balanceAfter ≥
    balanceBefore`.
13. **Profit is in the borrowed asset.** PnL is denominated in `asset`.
14. **No ETH.** The core has no `receive`/`fallback`; only ERC20s.
15. **Adapters are single-hop.** Multi-hop is composed by the core as multiple `Step`s.

### 3.1 Adapter `data` encodings

| Venue | Adapter | `data` | Notes |
|---|---|---|---|
| Uniswap V3 / SwapRouter02 | `UniV3Adapter` | `abi.encode(uint24 fee)` | 32 bytes; fee tier must exist |
| Uniswap V2 | `UniV2Adapter` | `""` | empty bytes |
| Aerodrome classic | `AerodromeClassicAdapter` | `abi.encode(bool stable)` | 32 bytes |
| Aerodrome Slipstream | `SlipstreamAdapter` | `abi.encode(int24 tickSpacing)` | 32 bytes; must be > 0 |

### 3.2 Base addresses from the repo

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

### 3.3 Verified Base infrastructure (live checks, block 53,211,658 on 2026-10-28)

These were confirmed with `cast` against `https://mainnet.base.org` while analyzing the
repo. Re-check before deployment; state changes.

| Item | Verified value |
|---|---|
| Chain ID | `8453` |
| Balancer `getProtocolFeesCollector()` | `0xce88686553686DA562CE7Cea497CE749DA109f9F` |
| Balancer flash-loan fee | `0` (0 bps) |
| Vault USDC balance | `76,784.938053` USDC |
| Vault WETH balance | `21.897308430286233829` WETH |
| Vault cbBTC balance | `0.01422013` cbBTC |
| Vault EURC balance | `3.072645` EURC |
| Vault AERO balance | `0.00157` AERO |
| UniV3 QuoterV2 | `0x3d4e44Eb1374240CE5F1B871ab261CD16335B76a` |
| UniV3 Factory | `0x33128a8fC17869897dcE68Ed026d694621f6FDfD` |
| UniV2 Factory | `0x8909Dc15e40173Ff4699343b6eB8132c65e18eC6` |
| Aerodrome classic Factory | `0x420DD381b31aEf6683db6B902084cB0FFECe40Da` |
| Slipstream QuoterV2 | `0x254cF9E1E6e233aa1AC962CB9B05b2cfeAaE15b0` |
| Slipstream PoolFactory | `0x5e7BB104d84c7CB9B682AaC2F3d509f5F406809A` |
| Gas price (snapshot) | `0.007749` gwei |
| Suggested priority fee | `0.001` gwei |
| Fork-test execute gas (2 steps) | `~693,232` gas |

**Implication:** only USDC and WETH have meaningful Balancer Vault liquidity right now. Start
the watcher with USDC and WETH as the borrowed assets. cbBTC/EURC/AERO are effectively
unborrowable at this snapshot. Query the Vault balance dynamically before sizing.

**Implication:** the flash-loan fee is 0 today, but it is governance-controlled. The watcher
should read `getProtocolFeesCollector().getFlashLoanFeePercentage()` (or simply rely on
`simulate`, which includes the fee) and never hard-code zero in the sizing logic.

**Implication:** at 0.0077 gwei and ~693k gas, L2 gas costs ~`0.0000054 ETH` (~$0.016 at
$3k/ETH). At a 1 gwei priority fee it becomes ~$2.10. Gas is not the main constraint at
current base fees, but priority-fee competition is. Model both.

### 3.4 Verified quoter call shapes

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

Verified: 1 USDC → WETH at fee 500 returns ~`0.0004234` WETH.

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

Verified: 1 USDC → WETH at tick spacing 100 returns ~`0.0004243` WETH.

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

Verified with `factory = address(0)` (router default): 1 USDC → WETH volatile returns
~`0.0004225` WETH.

Pool discovery verified:

```solidity
// UniV3
factory.getPool(USDC, WETH, 500) // 0xd0b53D9277642d899DF5C87A3966A349A798F224
// UniV2
factory.getPair(USDC, WETH)      // 0x88A43bbDF9D098eEC7bCEda4e2494615dfD9bB9C
// Aerodrome classic
factory.getPool(USDC, WETH, false) // 0xcDAC0d6c6C59727a65F871236188350531885C43
// Slipstream
factory.getPool(USDC, WETH, 100) // 0xb2cc224c1c9feE385f8ad6a55b4d94E92359DC59
```

Slipstream tick spacings found for USDC/WETH: `1, 10, 50, 100, 200` all have pools. The
repo's `SlipstreamAdapter` accepts any positive `int24`; the watcher must only use spacings
that map to a real pool.

---

## 4. Gotchas, gaps, and trust assumptions

### 4.1 Contract-level gotchas

- **`simulate` is permissionless and unpaid.** It checks route validity, but **does not**
  check `paused`, `maxTradeSize`, `maxGasPrice`, or operator. The watcher must check those
  itself.
- **`simulate` always reverts.** Do not use `eth_estimateGas` against it expecting a
  return; decode the revert payload.
- **`simulate` result excludes gas**, includes the Balancer fee, and excludes pre-existing
  core dust (`_balanceBefore`).
- **`maxGasPrice` is not a total cost cap.** On Base, the L1 data fee is separate from
  `tx.gasprice`. Compute total cost with the GasPriceOracle predeploy
  (`0x420000000000000000000000000000000000000F`) or the receipt's L1 fee fields.
- **No deadline in the core.** Adapters pass `block.timestamp` to routers, so a pending tx
  does not expire. `minAmountOut` / `minProfit` are the only protections.
- **No `multicall` in the core.** Batch quotes/simulations through Multicall3, but remember
  `execute` must be called directly by the operator (Multicall3 is not the operator).
- **Exact-input check rejects fee-on-transfer tokens.** Avoid them entirely.
- **Adapter approvals are reset to zero after each step.** If a router is upgradeable or
  malicious, that is a trust assumption.
- **Aerodrome classic uses `factory: address(0)`** (the router's default factory). Confirm
  the deployed router's default factory matches the pools you intend to use.
- **Slipstream uses `deadline: block.timestamp`** and requires `tickSpacing > 0`.
- **Profit is transferred out before `execute` returns.** The core keeps only pre-existing
  dust.

### 4.2 Deployment / repo gaps

- No real deployment addresses.
- `script/Deploy.s.sol` does not emit a machine-readable address manifest. Add
  `deployments/8453.json` (core, adapters, router, owner, operator, recipient, caps) and
  have the watcher read it.
- `broadcast/` currently contains an Anvil run; treat it as test data only.
- Foundry is not installed in this environment. We can either install it or use the
  prebuilt `out/` ABIs. For watcher development, hand-written viem ABIs are enough.

### 4.3 Market / execution risks

- **Public visibility.** Execution txs can be copied. The contract has no MEV protection.
  Use private submission if available; otherwise accept the risk.
- **State drift.** A quote/simulation at block N may be stale by block N+1. Re-simulate
  immediately before send; use Flashblocks/preconfirmations if available.
- **Balancer liquidity.** The practical borrow size is limited by the Vault's balance of
  the asset, not just the cap.
- **Router/pool changes.** Pools can be added/removed; fee tiers/tick spacings/stable flags
  must match real pools.
- **Gas griefing.** A sandwich can force your tx to revert; you pay gas. Budget for failed
  attempts and monitor the revert rate.
- **Unaudited.** The contract is personal-use software. Start with tiny caps.

---

## 5. Watcher architecture

### 5.1 High-level loop

```
┌──────────────┐   ┌───────────────┐   ┌──────────────┐   ┌────────────────┐
│ Data ingest  │──►│ State / quote │──►│ Route search │──►│ Amount optimizer│
│ (block/logs) │   │ cache         │   │ (graph)      │   │ (grid + ternary)│
└──────────────┘   └───────────────┘   └──────────────┘   └────────┬───────┘
                                                                    │
┌──────────────┐   ┌───────────────┐   ┌──────────────┐   ┌────────▼───────┐
│ PnL / alerts │◄──│ Receipt /     │◄──│ Tx builder   │◄──│ Simulation     │
│ / monitoring │   │ confirmation  │   │ + submitter  │   │ (Multicall3)   │
└──────────────┘   └───────────────┘   └──────────────┘   └────────────────┘
```

### 5.2 Components

1. **Chain client**
   - HTTP + WebSocket RPC, retries with backoff, request timeout, block pinning.
   - `newHeads` subscription; optional `logs` subscription for pool events.
   - `eth_call` at `latest`, `pending`, and historical blocks (archive for backtests).

2. **Config / registry**
   - Core address, adapter addresses, token metadata (address, symbol, decimals), pool
     registry, venue encodings, caps, thresholds.
   - Startup validation: code exists at every address, `core.isAdapter(adapter) == true`,
     `maxTradeSize[asset] > 0`, operator matches signer, `paused == false` (or dry-run).
   - Refresh config on admin events; never assume static values.

3. **Pool state / quoting layer**
   - v1: on-chain quoters via Multicall3 per scan cycle. Simple, no state sync.
   - v2: event-driven local state (reserves, sqrtPriceX96, liquidity, ticks) + on-chain
     quotes for changed pools. Faster, more complex.
   - v3: local quote math for V2/Aerodrome, tick math for V3/Slipstream, on-chain
     simulation as validation.

4. **Route graph**
   - Nodes: tokens. Edges: `(venue, pool, tokenIn -> tokenOut, fee/params)`.
   - Enumerate simple cycles starting and ending at the borrowed asset.
   - v1: 2-hop and 3-hop cycles. v2: up to 4 hops. v3: up to `MAX_STEPS = 8`.
   - Reject cycles that reuse the same pool (independent leg quoting would be wrong and
     it is almost always unprofitable).
   - Prefilter with a price matrix / negative-cycle detection to avoid quoting every
     combination.

5. **Quoter**
   - Per-venue quote functions:
     - UniV2: `getAmountsOut(amountIn, path)`.
     - Aerodrome classic: `getAmountsOut(amountIn, routes)`.
     - UniV3: QuoterV2 `quoteExactInputSingle`.
     - Slipstream: Slipstream Quoter (verify ABI/address).
   - Batch all legs across all candidates in one Multicall3 call.
   - Quote sequentially: output of leg i is input to leg i+1.
   - Add a small safety margin to each leg's `minAmountOut`.

6. **Amount optimizer**
   - For each route, search over `amount` in `(0, min(cap, vaultBalance)]`.
   - Coarse log-spaced grid (e.g., 10 points), then ternary/golden-section refinement
     (5–10 iterations) around the best.
   - Re-quote at each step; finally `simulate` the top 2–3 amounts.
   - Use `simulate` as ground truth; quoters are only for candidate generation.

7. **Simulation engine**
   - Batch `simulate` calls through Multicall3 `aggregate3(allowFailure=true)`.
   - Decode `SimulationResult(int256)`.
   - Track revert reasons for diagnostics (`AdapterNotAllowed`, `InsufficientOutput`,
     `Loss`, `MinProfitNotMet`, etc.).
   - Simulate at `latest` for scanning; re-simulate at `pending`/latest immediately before
     sending.

8. **Risk gate**
   - Check paused, cap, adapter whitelist, operator, gas ceiling, Vault balance, token
     decimals, expected profit > gas + margin, route freshness.
   - Optional: max trades per hour, max daily gas spend, max consecutive failures.
   - Optional: pause the contract automatically on anomaly (human unpauses).

9. **Transaction builder / submitter**
   - Encode `execute(asset, amount, steps, minProfit)`.
   - `minAmountOut` per leg from fresh quotes minus slippage buffer (e.g., 10–50 bps).
   - `minProfit` from expected profit minus a buffer, floored at gas cost × k.
   - Gas: `eth_estimateGas` with buffer; `maxFeePerGas` / `maxPriorityFeePerGas` policy.
   - Nonce management: single sender, serialized sends, replacement/cancel logic.
   - Submission adapter interface: public RPC, private RPC, bundle service.
   - Wait for receipt; decode `Executed`; compute actual profit and gas cost.

10. **PnL / monitoring / alerts**
    - Index `Executed` events; reconcile with receipt gas (L2 + L1).
    - Metrics: opportunities, simulations, executions, success rate, profit, gas, latency.
    - Alerts: operator balance low, paused, cap zero, repeated reverts, RPC lag, admin
      changes, owner/operator/recipient changes, adapter removal.
    - Dashboard: per-asset PnL, per-venue hit rate, revert reasons.

### 5.3 Suggested repo layout

```
ryo-watch/
  package.json
  tsconfig.json
  .env.example
  src/
    config.ts
    chain.ts              // clients, retries, multicall
    abi/
      ryoCore.ts
      adapters.ts
      quoters.ts
      erc20.ts
      multicall3.ts
    core/
      encode.ts           // Step[] + execute/simulate encoding
      decode.ts           // SimulationResult and error decoding
      simulate.ts         // single + batch simulation
      execute.ts          // tx build, gas, send, receipt
    venues/
      uniswapV2.ts
      uniswapV3.ts
      aerodrome.ts
      slipstream.ts
    graph/
      registry.ts         // tokens, pools, adapters
      cycles.ts           // cycle enumeration
      priceMatrix.ts      // prefilter / negative cycles
    strategy/
      quoter.ts
      optimizer.ts
      scanner.ts
      risk.ts
    ops/
      gas.ts              // L1 + L2 fee, USD conversion
      pnl.ts
      metrics.ts
      alerts.ts
      adminWatcher.ts
    main.ts
  test/
    unit/
    fork/
  config/
    base.json
```

### 5.4 Stack recommendation

**TypeScript + viem + Node/Bun.** Reasons:

- First-class Base support, `bigint`, ABI encoding/decoding, Multicall3.
- Easy WebSocket subscriptions and private-RPC adapters.
- Fast iteration; the heavy lifting is on-chain anyway.
- Rust can replace hot paths later if latency demands it.

---

## 6. Route search details

### 6.1 Universe

Start curated, not exhaustive:

- Assets: WETH, USDC, cbBTC, EURC, AERO (the five the deploy script knows).
- Venues: UniV3 (fee tiers 100/500/3000/10000), UniV2, Aerodrome classic
  (stable/volatile), Slipstream (tick spacings 1/10/50/100/200 — verify).
- Pools: only pools with real liquidity and code; verify via factory `getPool`/`getPair`
  and/or a subgraph.

### 6.2 Cycle enumeration

- **2-hop:** for each token pair `(A,B)`, compare every venue's `A->B` rate with every
  other venue's `B->A` rate.
- **3-hop:** for each triple `(A,B,C)`, combine venues; restrict to tokens with deep
  liquidity.
- **4+ hop:** only around a detected mispricing; do not brute-force the full graph.
- **Negative-cycle prefilter:** assign edge weight `-ln(rate_after_fee)` using current
  pool prices; Bellman-Ford finds candidate cycles. Then quote/simulate the actual
  amounts.
- **Avoid pool reuse.** A route that uses the same pool twice needs sequential quoting;
  v1 should reject it.

### 6.3 Amount sizing

For a route with amount `x`, profit is:

```
profit(x) = output_n(...output_1(x)...) - x - flashLoanFee(x)
```

- `profit(x)` is generally concave/unimodal for AMM routes, but concentrated liquidity
  introduces kinks. A grid + local refinement handles both.
- Bound `x` by `min(maxTradeSize[asset], vaultBalance(asset), liquidityEstimate)`.
- Start with a coarse grid; refine around the best; verify with `simulate`.

### 6.4 Net profitability

```
netProfitUsd = profitInAsset * assetUsdPrice - gasCostUsd
```

- `gasCostUsd` = L2 gas (`gasUsed * effectiveGasPrice`) + L1 data fee, converted to USD.
- Require `netProfitUsd > minNetProfitUsd` (config, e.g., $0.25–$1.00 to start) and
  `netProfitUsd > gasCostUsd * safetyMultiple` (e.g., 2–3×).
- Also require `profit > 0` in asset units.

### 6.5 `simulate` as the ground truth

- `simulate` is the final arbiter. It executes the real flash loan and every real swap, so
  it captures fees, pool state, and interactions that off-chain quotes miss.
- For candidate discovery, you can call `simulate` with `minAmountOut = 1` on each leg. It
  will return the exact net profit (or revert), without needing a quoter.
- You still need per-leg quotes for sensible `minAmountOut` floors. If a venue quoter is
  unavailable, use a local model or a conservative floor derived from the previous
  simulation, and rely on `minProfit` as the final backstop.
- Do not use `simulate` as the only amount-search oracle if RPC latency is high; quoters
  are cheaper and can be batched. Use `simulate` for the top few candidates.

---

## 7. Execution policy

### 7.1 Two-phase loop

1. **Scan phase (every block / Flashblock):**
   - Refresh pool states/quotes.
   - Enumerate candidates, size them, simulate the top N.
   - Produce a ranked list of `{route, amount, expectedProfit, gasCost}`.

2. **Execute phase (only for the best candidate that clears the gate):**
   - Re-quote/re-simulate at the latest state.
   - Build per-leg `minAmountOut` and `minProfit`.
   - Send via the configured submitter.
   - Confirm receipt, decode `Executed`, update PnL.
   - On revert, decode the reason, log, and back off.

### 7.2 Floor policy

- **Per-leg `minAmountOut`:** quote × (1 − `perLegSlippageBps`). Start at 10–30 bps;
  widen for thin pools. Must be ≥ 1.
- **`minProfit`:** `max(expectedProfit − buffer, gasCostInAsset × k, fixedFloor)`, but
  always `< expectedProfit` to avoid self-reverts.
- **Rationale:** per-leg floors stop a bad fill early; `minProfit` is the final backstop.
  Too tight = reverts; too loose = sandwich bait.
- **Decimals:** every floor and amount is in raw token units. Keep a `decimals` field per
  token and never mix human units with on-chain units. `minAmountOut` is in `tokenOut`
  units; `minProfit` and `profit` are in the borrowed `asset` units.
- **Block pinning:** fetch a block number, then run the whole quote/simulate batch against
  that exact block tag. Do not mix `latest` calls across a state change. If the node
  rejects the block tag, retry with the next block.

### 7.3 Gas policy

- Read `eth_gasPrice` / `eth_maxPriorityFeePerGas`; cap at `maxGasPrice` if set.
- Compute L1 data fee from the GasPriceOracle predeploy or receipt fields.
- Do not execute if `netProfitUsd` is below threshold after gas.
- Use `eth_estimateGas` with a 20–30% buffer; handle out-of-gas by retrying with a higher
  limit once.
- On Base, priority fee/FCFS behavior should be verified; do not assume Ethereum-style
  ordering.

### 7.4 Submission / MEV

- Treat every tx as public unless proven otherwise.
- Prefer a private submission path if a reliable Base provider offers one; otherwise use a
  competitive priority fee and accept copy risk.
- Keep `minProfit` tight enough that a copier cannot profit after you, but loose enough to
  land.
- Consider splitting large opportunities into smaller txs if the cap allows; but note the
  operator nonce serializes them.

### 7.5 Nonce / failure handling

- One hot EOA, one in-flight tx at a time (simplest).
- Track nonce locally; reconcile with `eth_getTransactionCount(..., "pending")`.
- On stuck tx: replace with same nonce + higher fee, or cancel with a 0-value self-transfer.
- On revert: log the decoded error; do not retry the same route blindly.
- Circuit breaker: pause after N consecutive failures or abnormal gas spend; alert.

---

## 8. Operations & security

### 8.1 Key management

- Owner: Safe/hardware wallet. Not the watcher.
- Operator: dedicated hot wallet with minimal ETH for gas.
- Store the operator key in a KMS/HSM or an encrypted secret manager; never in the repo.
- Rotate the operator key periodically via `setOperator` (owner action).
- The watcher should never need the owner key.

### 8.2 Startup validation

- Core has code; `vault()` matches the expected Balancer Vault.
- Every adapter has code and `isAdapter(adapter) == true`.
- `maxTradeSize[asset] > 0` for every traded asset.
- `operator()` equals the signer address.
- `profitRecipient()` is the expected address.
- `paused() == false` for live mode.
- RPC chain ID is 8453.
- Token decimals/symbols match config.
- Gas balance > minimum.

### 8.3 Monitoring / alerts

- **Contract admin:** `AdapterSet`, `OperatorSet`, `ProfitRecipientSet`,
  `MaxTradeSizeSet`, `MaxGasPriceSet`, `Paused`, `Unpaused`,
  `OwnershipTransferStarted`, `OwnershipTransferred`, `Swept`.
- **Execution:** `Executed` (profit, asset, routeHash), reverts, gas cost, latency.
- **Infra:** RPC errors, block lag, websocket disconnects, low ETH balance, high revert
  rate.
- **Alerts:** Telegram/Discord/PagerDuty; include tx hash and decoded reason.

### 8.4 Runbook

- **Pause:** operator calls `pause()`; owner calls `unpause()` after review.
- **Adapter issue:** owner calls `setAdapter(adapter, false)`; watcher refreshes.
- **Cap change:** owner calls `setMaxTradeSize`; watcher refreshes.
- **Operator compromise:** owner calls `setOperator(new)`; stop the watcher.
- **Stuck funds:** owner calls `sweep(token, to)` when no execution is in flight.
- **RPC outage:** fail over to a backup endpoint; do not send blind.

---

## 9. Testing strategy

### 9.1 Unit tests

- ABI encoding/decoding of `Step[]`, `execute`, `simulate`.
- `SimulationResult` decoding (positive, zero, negative).
- Error selector decoding for all core errors.
- Route graph: cycle enumeration, no pool reuse, token continuity.
- Amount optimizer: monotonic sanity, bounds, integer safety.
- Gas/PnL math: decimals, L1 fee, USD conversion.
- Config validation: bad addresses, zero caps, wrong operator.

### 9.2 Fork integration tests

- Anvil fork of Base (`anvil --fork-url $BASE_RPC_URL`).
- Deploy core + adapters via `Deploy.s.sol`.
- Configure caps and operator.
- Manufacture an opportunity (large swap into a real pool, like `RyoFork.t.sol`).
- Run the watcher in dry-run: assert it finds the route and the simulation matches.
- Run the watcher in execute mode: assert `Executed`, profit arrives, core dust
  unchanged, Vault repaid.
- Failure cases: paused, cap too low, stale quote, wrong fee tier, non-operator signer,
  insufficient Vault liquidity.

### 9.3 Backtests

- Archive RPC; replay scanning at historical blocks.
- Measure opportunity frequency, profit distribution, false positives, and gas costs.
- Tune thresholds and the token/pool universe.

### 9.4 Chaos / soak

- RPC timeouts, 429s, websocket drops, reorgs, nonce conflicts.
- 24–72h dry-run on mainnet before enabling execution.

---

## 10. Build milestones

### Phase 0 — Foundation (1–2 days)

- Scaffold `ryo-watch` (TS + viem).
- Hand-write ABIs for core, adapters, ERC20, Multicall3.
- Implement `Step[]` encoding, `execute`/`simulate` encoding, `SimulationResult` decoding.
- Config loader + startup validation.
- Read-only script: given a route, print quote/simulation result.
- **Acceptance:** can simulate the README's USDC→WETH→USDC route on a Base fork and decode
  the profit.

### Phase 1 — Scanner (2–4 days)

- Pool registry for WETH/USDC/cbBTC on UniV3 + Aerodrome classic + UniV2.
- 2-hop cycle enumeration + quoter batching.
- Amount grid + ternary refinement.
- Ranked opportunity log (no tx).
- **Acceptance:** 24h dry-run logs plausible opportunities with expected profit and gas
  cost; no false positives that fail simulation.

### Phase 2 — Executor (2–3 days)

- Tx builder with per-leg floors and `minProfit`.
- Gas estimation, EIP-1559 fees, nonce management.
- Submit on Anvil fork; verify `Executed` and PnL.
- Private submission adapter (public RPC fallback).
- **Acceptance:** end-to-end execution on a fork; profit accounted; revert reasons decoded.

### Phase 3 — Live pilot (1 week, tiny caps)

- Deploy to Base (or use an existing deployment).
- Set caps to 50–100 USDC equivalent.
- Run with conservative thresholds; monitor every tx.
- Tune slippage, gas margin, and scan cadence.
- **Acceptance:** N successful live trades; no unexpected reverts; PnL reconciles.

### Phase 4 — Scale / harden

- Expand token/pool universe; 3–4 hop routes.
- Event-driven state + Flashblocks for lower latency.
- Backtests and parameter tuning.
- Full observability, alerts, runbook, Docker deployment.
- **Acceptance:** stable 24/7 operation within risk limits.

---

## 11. Open decisions

1. **Stack:** TypeScript + viem (recommended), Rust, or Python?
2. **First milestone:** read-only scanner, or scanner + fork executor?
3. **Deployment:** do you already have a live `RyoCore`, or should we deploy to Base first?
4. **RPC / submission:** public Base RPC, paid provider (Alchemy/QuickNode/etc.), or local
   node? Is a private tx path available?
5. **Risk limits:** starting cap per asset, minimum net profit, max gas price, max daily
   gas spend?
6. **Operating environment:** local machine, VPS, Docker, systemd?

---

## 12. Research checklist (verify on-chain before coding)

- [ ] Real `RyoCore` deployment address (or deploy one).
- [ ] Adapter addresses and `isAdapter` status.
- [ ] `operator`, `profitRecipient`, `owner`, `paused`, caps, `maxGasPrice`.
- [x] Balancer Vault `flashLoan` fee on Base at the current block: **0**.
- [x] Balancer Vault balances for the assets we intend to borrow: **USDC ~76.8k, WETH
      ~21.9; cbBTC/EURC/AERO negligible**.
- [x] UniV3 QuoterV2 address/ABI on Base: `0x3d4e44Eb1374240CE5F1B871ab261CD16335B76a`.
- [x] Slipstream Quoter address/ABI and supported tick spacings:
      `0x254cF9E1E6e233aa1AC962CB9B05b2cfeAaE15b0`; struct order `(tokenIn, tokenOut,
      amountIn, tickSpacing, sqrtPriceLimitX96)`.
- [x] Aerodrome classic router `getAmountsOut` ABI and default factory: works with
      `factory = address(0)`.
- [x] UniV2 router `getAmountsOut` ABI: works.
- [x] Pool discovery: factory `getPool`/`getPair` for each venue.
- [ ] Base block time / Flashblocks availability and endpoint.
- [ ] Private tx / bundle submission options on Base.
- [ ] GasPriceOracle predeploy `getL1Fee(bytes)` behavior on Base (partially checked; the
      predeploy returns a value but the exact scaling/units should be validated against
      receipt `l1Fee`).
- [ ] Chainlink ETH/USD feed on Base (for USD conversion), or a fallback.

---

## 13. Appendix — quick reference

### 13.1 Route encoding example

```ts
const steps = [
  {
    adapter: aerodromeAdapter,
    tokenIn: USDC,
    tokenOut: WETH,
    minAmountOut: minWethOut,
    data: encodeAbiParameters([{ type: "bool" }], [false]), // volatile
  },
  {
    adapter: uniV3Adapter,
    tokenIn: WETH,
    tokenOut: USDC,
    minAmountOut: minUsdcOut,
    data: encodeAbiParameters([{ type: "uint24" }], [500]), // 0.05%
  },
];

const data = encodeFunctionData({
  abi: ryoCoreAbi,
  functionName: "execute",
  args: [USDC, amount, steps, minProfit],
});
```

### 13.2 Simulation decoding example

```ts
const SIMULATION_RESULT_SELECTOR = "0x00cf1ea6";

function decodeSimulation(revertData: `0x${string}`): bigint | null {
  if (!revertData.startsWith(SIMULATION_RESULT_SELECTOR)) return null;
  const word = BigInt("0x" + revertData.slice(10, 74));
  const sign = 1n << 255n;
  return word & sign ? word - (1n << 256n) : word;
}
```

### 13.3 Core error selectors

| Error | Selector |
|---|---|
| `SimulationResult(int256)` | `0x00cf1ea6` |
| `MinProfitNotMet(uint256,uint256)` | `0x2c10b304` |
| `InsufficientOutput(uint256,uint256,uint256)` | `0x3f612d47` |
| `Loss(uint256,uint256)` | `0x86f83f02` |
| `TradeTooLarge(address,uint256,uint256)` | `0x8e8dd3a9` |
| `AdapterNotAllowed(address)` | `0xfae021e8` |
| `GasPriceTooHigh(uint256,uint256)` | `0x94118333` |

### 13.4 Error taxonomy and watcher reaction

| Revert | Likely cause | Watcher action |
|---|---|---|
| `TradeNotAllowed(asset)` | Cap is 0 | Disable asset, alert |
| `TradeTooLarge(asset,amount,max)` | Amount above cap | Re-size, refresh cap |
| `ContractPaused()` | Owner/operator paused | Stop executing, alert |
| `NotOperator(caller)` | Signer not operator | Stop, alert, check `OperatorSet` |
| `AdapterNotAllowed(adapter)` | Adapter removed | Refresh registry, alert |
| `GasPriceTooHigh(gas,max)` | Fee above ceiling | Wait or raise cap |
| `RouteTooShort/RouteTooLong` | Encoder bug | Fix code, unit test |
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

> Regenerate selectors from the ABI; do not rely on this table forever.

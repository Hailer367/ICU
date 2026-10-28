# Ryo

Ryo is a personal-use arbitrage executor for Base. It borrows one token with a Balancer flash
loan, walks a linear route through whitelisted DEX adapters, repays the loan, and sends the
realized profit to a configured address. It never holds trading capital between transactions.

This repository contains **only the smart contract**. The watcher (RyoWatch) is a separate
project and is not part of this codebase.

> **Status: unaudited, personal-use software.** The test suite is extensive, but no external
> audit has been performed. Deploy only what you can afford to lose.

---

## 1. The mental model

1. Someone (your watcher) sees a price difference between two venues.
2. It calls `execute(asset, amount, steps, minProfit)`.
3. Ryo borrows `amount` of `asset` from Balancer. No upfront capital is needed.
4. Ryo sends the borrowed tokens through each step:
   `asset → token B → token C → ... → asset`.
5. Ryo repays the flash loan (principal + Balancer's fee, usually zero on Base).
6. If the final balance is higher than the starting balance, the difference is profit. Ryo sends
   it to the profit recipient and keeps nothing.
7. If the route would lose money, the whole transaction reverts. No funds move.

Because the loan is repaid inside the same transaction, the only capital at risk is gas. The
contract is designed so that a bad route cannot touch pre-existing balances.

```
                 ┌──────────────────────────────┐
   operator ───► │            RyoCore           │
                 │  flash loan + route engine   │
                 └───────┬──────────────┬───────┘
                         │              │
              borrow/repay│              │ step(tokenIn, tokenOut, amount, minOut, data)
                         ▼              ▼
                 ┌──────────────┐  ┌──────────────┐
                 │ Balancer     │  │   Adapters    │
                 │ V2 Vault     │  │ UniV3/V2/Aero │
                 └──────────────┘  │ Slipstream    │
                                   └──────┬────────┘
                                          │ swap
                                          ▼
                                   ┌──────────────┐
                                   │ Real DEX     │
                                   │ pools        │
                                   └──────────────┘
```

---

## 2. What is immutable, and what the owner can change

There is **no proxy and no upgrade key**. The core's code and the Balancer Vault address are
immutable. Each adapter is permanently bound to one core and one router. If the core needs a
logic change, you deploy a new core and new adapters.

The owner (ideally a Safe or hardware wallet) can change:

| Setting | Meaning |
|---|---|
| `operator` | Hot wallet allowed to `execute` and `pause`. The owner can also execute. |
| `profitRecipient` | Where realized profit is sent. Cannot be the core itself. |
| `isAdapter[adapter]` | Which adapters are trusted. Default deny. |
| `maxTradeSize[asset]` | Maximum borrow size per asset. **Zero disables the asset.** |
| `maxGasPrice` | Optional gas-price ceiling in wei. Zero disables the check. |
| `paused` | Emergency stop. The operator or owner can pause; only the owner unpauses. |

Two-step ownership (`Ownable2Step`) means a new owner must explicitly accept.

### Roles

| Role | Can do | Cannot do |
|---|---|---|
| Owner (Safe/hardware) | Configure everything, unpause, sweep dust, transfer ownership | — |
| Operator (hot wallet) | Execute routes, pause | Change config, unpause, move funds |
| Profit recipient | Receive profit | Call anything |
| Anyone | `simulate` (dry run) | Execute, configure, pause |

A compromised operator can waste gas and pause, but cannot steal principal or redirect profit.
A compromised owner can do anything the contract allows; that is why the owner should be a
Safe with a hardware signer, not the hot wallet.

---

## 3. The safety rules the core enforces

Every `execute` call is checked at multiple layers:

1. **Whitelisted adapters only.** A route cannot call an arbitrary contract.
2. **Linear route, 2–8 steps.** `tokenIn` of step `i` must equal `tokenOut` of step `i-1`, the
   first input must be the borrowed asset, and the last output must be the borrowed asset.
3. **Per-step floor.** Every step must set `minAmountOut != 0`. If the venue returns less, the
   transaction reverts before the next step.
4. **Exact input consumption.** The core measures its own balance before and after each step.
   It must have spent exactly `amountIn`; a refund or a router that pulls less is rejected. A loan
   that under-delivers (for example a fee-on-transfer token) fails closed with a named error rather
   than an arithmetic panic.
5. **Output measured by balance delta.** Router return values are ignored. Ryo only trusts its
   own token balances.
6. **No loss.** After repayment, the core must still hold at least what it started with. Dust
   that was already in the contract cannot be used to hide a losing trade.
7. **Minimum profit.** `minProfit` is checked after the loan is repaid.
8. **One callback per transaction.** The Balancer callback is accepted only from the immutable
   Vault, only with the exact route hash that `execute`/`simulate` set, and only once.
9. **Reentrancy guard.** `execute`, `simulate`, and `sweep` share a transient-storage guard.
10. **Caps and optional gas ceiling.** A trade larger than `maxTradeSize[asset]` is rejected
    before any external call. A zero cap means the asset is disabled.
11. **No funds at rest.** The core transfers the full profit out. It has no `receive` function
    and never holds ETH.

Adapters add their own checks: they only accept calls from their core, approve the router for
exactly the input amount, reset the approval to zero afterwards, require the input to be fully
consumed, and require the output to go to the core rather than staying in the adapter. Dust
donated to an adapter does not block it and is not counted as output.

---

## 4. Supported venues (Base mainnet)

| Venue | Adapter | Router | `data` encoding |
|---|---|---|---|
| Uniswap V3 (SwapRouter02) | `UniV3Adapter` | `0x2626664c2603336E57B271c5C0b26F421741e481` | `abi.encode(uint24 fee)` |
| Uniswap V2 | `UniV2Adapter` | `0x4752ba5DBc23f44D87826276BF6Fd6b1C372aD24` | empty bytes |
| Aerodrome classic | `AerodromeClassicAdapter` | `0xcF77a3Ba9A5CA399B7c97c74d54e5b1Beb874E43` | `abi.encode(bool stable)` |
| Aerodrome Slipstream | `SlipstreamAdapter` | `0xBE6D8f0d05cC4be24d5167a3eF062215bE6D18a5` | `abi.encode(int24 tickSpacing)` |

All adapters are **single-hop**. Multi-hop routes are composed by the core, so each leg keeps its
own independent floor. For example, a two-hop route through WETH is two `Step`s.

Common `data` values:

```solidity
abi.encode(uint24(100))   // UniV3 0.01% fee tier
abi.encode(uint24(500))   // UniV3 0.05% fee tier
abi.encode(false)         // Aerodrome volatile pool
abi.encode(true)          // Aerodrome stable pool
abi.encode(int24(100))    // Slipstream pool with tick spacing 100
```

The correct fee tier / tick spacing / stable flag is **part of the route**. A wrong value will
usually make the router revert, but always dry-run first.

Base token addresses:

| Token | Address |
|---|---|
| WETH | `0x4200000000000000000000000000000000000006` |
| USDC | `0x833589fCD6eDb6E08f4c7C32D4f71b54bdA02913` |
| cbBTC | `0xcbB7C0000aB88B473b1f5aFd9ef808440eed33Bf` |
| EURC | `0x60a3E35Cc302bFA44Cb288Bc5a4F316Fdb1adb42` |
| AERO | `0x940181a94A35A4569E4529A3CDfB74e38FD98631` |
| Balancer Vault | `0xBA12222222228d8Ba445958a75a0704d566BF2C8` |

---

## 5. Route encoding

```solidity
struct Step {
    address adapter;       // whitelisted adapter
    address tokenIn;       // token handed to the adapter
    address tokenOut;      // token the adapter must return
    uint256 minAmountOut;  // hard floor for this leg; must be non-zero
    bytes data;            // adapter-specific parameters (fee, tick spacing, stable flag)
}
```

`execute` and `simulate` take the same `Step[]`. The core wraps it as
`abi.encode(uint8(1), steps)` for the Balancer callback, so the envelope has a version byte for
future compatibility.

A USDC → WETH → USDC route, buying WETH on Aerodrome and selling it on Uniswap V3:

```solidity
RyoCore.Step[] memory steps = new RyoCore.Step[](2);

steps[0] = RyoCore.Step({
    adapter: address(aerodromeAdapter),
    tokenIn: USDC,
    tokenOut: WETH,
    minAmountOut: minWethOut,          // from a quote, with a slippage buffer
    data: abi.encode(false)            // volatile pool
});

steps[1] = RyoCore.Step({
    adapter: address(uniV3Adapter),
    tokenIn: WETH,
    tokenOut: USDC,
    minAmountOut: minUsdcOut,          // must be > borrowed amount + fee + minProfit
    data: abi.encode(uint24(500))      // 0.05% fee tier
});

uint256 profit = core.execute(USDC, 10_000e6, steps, 1e6);
```

### Dry runs

`simulate` is permissionless and works while the contract is paused. It **always reverts** with
`SimulationResult(int256 profit)`. A positive number is the exact profit after the flash-loan fee
and before gas; a negative number is the exact loss.

```solidity
try core.simulate(USDC, 10_000e6, steps) {
    revert("unreachable");
} catch (bytes memory data) {
    // data is abi.encodeWithSelector(RyoCore.SimulationResult.selector, profit)
}
```

For batching many candidate routes in one RPC call, use Multicall3 with `allowFailure = true`:

```solidity
IMulticall3.Call3[] memory calls = new IMulticall3.Call3[](2);
calls[0] = IMulticall3.Call3({
    target: address(core),
    allowFailure: true,
    callData: abi.encodeCall(RyoCore.simulate, (USDC, amount, routeA))
});
calls[1] = IMulticall3.Call3({
    target: address(core),
    allowFailure: true,
    callData: abi.encodeCall(RyoCore.simulate, (USDC, amount, routeB))
});

IMulticall3.Result[] memory results =
    IMulticall3(0xcA11bde05977b3631167028862bE2a173976CA11).aggregate3(calls);
```

Each `results[i].returnData` is the revert payload; decode the first 4 bytes as
`SimulationResult.selector` and the next 32 bytes as the `int256` profit.

---

## 6. Testing without spending anything

All tests are local. Fork tests copy Base state through an RPC; they do not send transactions,
need no private key, and spend no gas or funds.

```bash
export PATH="$PATH:$HOME/.config/.foundry/bin"

forge build --sizes
forge test
forge test --match-contract RyoForkTest -vv     # real Balancer + real routers
forge test --match-contract RyoInvariantTest    # stateful invariants
```

The fork tests default to the public `https://mainnet.base.org` endpoint. To use your own RPC or
pin a block:

```bash
BASE_RPC_URL="https://your-base-rpc" \
BASE_FORK_BLOCK=53083653 \
forge test --match-contract RyoForkTest -vv
```

### What the fork tests actually do

A live arbitrage rarely exists at the exact moment a test runs, so the suite **manufactures** one
on the local fork: it swaps a large amount of USDC into the real Uniswap V3 WETH/USDC pool with a
cheat-coded balance, which moves the real pool price. It then runs Ryo's real flash loan and real
router calls to capture that gap. This exercises the complete path without relying on market
conditions.

The suite covers:

- each adapter against its real Base router (correct ABI, correct output, zero leftovers);
- full arbitrage through the real Balancer Vault + real Aerodrome, Uniswap V2, Uniswap V3, and
  Slipstream routers;
- `simulate` matching `execute` to the wei, including the flash-loan fee and excluding dust;
- permissionless simulation and Multicall3 batching;
- a losing route reverting and leaving the Vault untouched;
- pause blocking execution but not simulation;
- trade caps enforced before borrowing;
- non-operator execution rejected;
- dust preserved, never used to subsidize a loss, and sweepable.

### Test inventory

| Suite | What it covers |
|---|---|
| `RyoCoreTest` | Profit, loss, events, caps, gas cap, pause, ownership, simulation, dust, sweep |
| `RyoSecurityTest` | Route validation, adapter misbehaviour, fake/replayed callbacks, reentrancy, fee-on-transfer, fuzzing |
| `AdaptersTest` | Exact router parameters, approval reset, leftover input/output, dust griefing, access, constructors |
| `RyoInvariantTest` | Stateful invariants: core holds no funds, Vault stays solvent, profit accounting is exact, adapters end empty |
| `RyoForkTest` | Real Base contracts, real swaps, full flash-loan arbitrage, Multicall3, gas |

Fuzzing runs 512 cases per property; invariants run 128 sequences at depth 32 (4,096 calls) with
`fail-on-revert` enabled.

---

## 7. Deploying to Base

### Prerequisites

- [Foundry](https://book.getfoundry.sh/getting-started/installation)
- A Base RPC URL
- A deployer key with a small amount of ETH for **deployment gas only** (no trading capital)
- Optional: a BaseScan API key for verification

### Configure

```bash
cp .env.example .env
```

Set at least:

```bash
BASE_RPC_URL=https://your-base-rpc
PRIVATE_KEY=0x...                 # deployer; never commit .env
OWNER=0x...                       # Safe or hardware wallet
OPERATOR=0x...                    # hot wallet
PROFIT_RECIPIENT=0x...
```

Every trade cap starts at **zero**, which disables that asset. To enable one during deployment,
set for example:

```bash
MAX_TRADE_USDC=10000000000        # 10,000 USDC (6 decimals)
MAX_TRADE_WETH=10000000000000000000   # 10 WETH (18 decimals)
MAX_GAS_PRICE=1000000000          # 1 gwei
```

Or leave them at zero and set caps later from the owner wallet.

### Dry run, then broadcast

```bash
forge script script/Deploy.s.sol:Deploy \
  --rpc-url "$BASE_RPC_URL"

forge script script/Deploy.s.sol:Deploy \
  --rpc-url "$BASE_RPC_URL" \
  --broadcast \
  --verify --etherscan-api-key "$BASESCAN_API_KEY"
```

The script deploys one core and four adapters, whitelists all four, applies the configured caps
and gas ceiling, and optionally starts a two-step ownership handoff.

**Address source of truth:** if Forge's printed simulation addresses differ from the broadcasted
ones, read `broadcast/Deploy.s.sol/8453/run-latest.json`. It contains the actual deployed
addresses.

If you set `OWNER` to a different address, the script calls `transferOwnership(OWNER)`. The new
owner must then call `acceptOwnership()` on the core. Until it does, the deployer remains the
owner.

### First-run checklist

1. Confirm `owner()`, `operator()`, and `profitRecipient()` are what you expect.
2. Confirm all four adapters return `true` from `isAdapter(...)`.
3. Set a **small** cap for one asset, e.g. 50–100 USDC.
4. Set the operator to the hot wallet that will run the watcher.
5. From the operator, call `simulate` on a route. Confirm a positive result.
6. Execute the smallest viable trade. Confirm the profit arrives at the recipient and the core
   balance returns to its previous dust level.
7. Raise caps gradually. Never set a cap larger than the liquidity you are willing to move.

### Verification

```bash
forge verify-contract <CORE_ADDRESS> src/RyoCore.sol:RyoCore \
  --chain base --constructor-args <encoded args>
```

The adapters can be verified the same way with `src/adapters/...`. The deploy script does not
currently emit constructor-argument files, so pass them explicitly if you verify manually.

---

## 8. Operating the contract

- **Always simulate first.** The watcher should call `simulate` (or a Multicall3 batch) and only
  execute when the result clears gas plus a safety margin.
- **Set per-step floors from quotes.** `minAmountOut` is your sandwich protection. Set it from a
  recent quote with a small slippage buffer. Too tight reverts; too loose invites worse fills.
- **Set `minProfit`.** It is the final backstop after the loan is repaid.
- **Start tiny.** Caps are the blast radius. A compromised operator can only trade within them.
- **Pause on anomalies.** The operator can pause immediately; the owner unpauses.
- **Disable a venue, don't patch it.** If a router or pool looks wrong, the owner can remove its
  adapter. There is no upgrade path.
- **Sweep dust.** If tokens are ever stuck in the core (donations, forced transfers), the owner can
  `sweep(token, to)` when no execution is in progress.
- **Rotate the operator.** The operator key is hot; treat it as disposable. It cannot move funds.

---

## 9. Known limitations and non-goals

- **Only cyclic DEX arbitrage.** No liquidations, no CEX hedging, no cross-chain, no directional
  trading.
- **Base only.** Addresses and the deploy script are hard-coded for Base mainnet.
- **Balancer only.** Flash loans come from the Balancer V2 Vault. If it is unavailable, execution
  stops. The practical borrow size is also limited by what the Vault actually holds for that asset
  at that moment, not just by your cap, so check its balance before sizing a trade.
- **Single-hop adapters.** Multi-hop is composed by the core, which is deliberate: each leg gets
  its own floor and its own accounting.
- **Public mempool.** Execution transactions are visible before inclusion. A watcher should use
  private order flow or accept that competition may copy the route. The contract itself has no
  MEV protection.
- **No ETH.** The core has no `receive`/`fallback`; it only handles ERC20s. Forced ETH (e.g. via
  `selfdestruct`) would be stuck.
- **Unaudited.** The tests are thorough, but they are not a substitute for an audit.

---

## 10. Repository layout

```
src/
  RyoCore.sol                 core: flash loan, routing, roles, caps, simulation
  interfaces/                 minimal Balancer, router, adapter, Multicall3 interfaces
  adapters/
    AdapterBase.sol           shared adapter checks and immutable bindings
    UniV3Adapter.sol          Uniswap V3 / SwapRouter02, single hop
    UniV2Adapter.sol          Uniswap V2, single hop
    AerodromeClassicAdapter.sol
    SlipstreamAdapter.sol
test/
  BaseTest.sol                shared fixture
  RyoCore.t.sol               behavior and admin
  RyoSecurity.t.sol           adversarial and fuzz
  Adapters.t.sol              adapter-level checks
  RyoInvariant.t.sol          stateful invariants
  handlers/ExecuteHandler.sol invariant driver
  fork/RyoFork.t.sol          real Base contracts
  mocks/                      tokens, Vault, adapters, routers
script/
  Deploy.s.sol                Base deployment
```

---

## 11. Security contact

This is personal-use software. If you find a bug, do not exploit it on a live deployment; report
it privately to the owner. If you deploy this yourself, you are the owner and the only person
responsible for its configuration and operation.

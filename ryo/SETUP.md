# Ryo contracts — source tree

This directory is the pure source tree from `ryo-next.tar.gz`: contracts, adapters,
interfaces, tests, and the deployment script. Build artifacts, caches, broadcast logs, and
the vendored Foundry dependencies are intentionally excluded.

## Install dependencies

Foundry is required:

```bash
curl -L https://foundry.paradigm.xyz | bash
foundryup
```

From this directory:

```bash
forge install foundry-rs/forge-std@v1.17.0 --no-commit
forge install OpenZeppelin/openzeppelin-contracts@v5.7.0 --no-commit
```

## Build and test

```bash
forge build --sizes
forge test --no-match-path "test/fork/*"
```

Fork tests read Base state through an RPC and spend nothing:

```bash
BASE_RPC_URL=https://mainnet.base.org \
  forge test --match-contract RyoForkTest -vv
```

To pin a block:

```bash
BASE_RPC_URL="https://your-base-rpc" \
BASE_FORK_BLOCK=53083653 \
  forge test --match-contract RyoForkTest -vv
```

## Layout

```
src/
  RyoCore.sol                 core: flash loan, routing, roles, caps, simulation
  interfaces/                 Balancer, router, adapter, Multicall3 interfaces
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

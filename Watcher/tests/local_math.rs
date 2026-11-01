//! MAX correctness test for local constant-product quote math (#1).
//!
//! Proves `ryo_watch::amm` reproduces the *exact* router output the scanner
//! uses — not an approximation. For every constant-product pool it pins one
//! block, reads that pool's real `token0/token1/getReserves` (and the Aerodrome
//! `factory.getFee`) so the local formula is fed identical inputs, then sweeps a
//! wide range of `amountIn` in *both* token directions and asserts the local
//! output equals the live `router.getAmountsOut` word-for-word.
//!
//! Ignored by default (needs network). Run against live Base or the fork:
//!
//! ```text
//! RYO_LIVE_RPC=https://base-mainnet.g.alchemy.com/v2/<KEY> \
//!   cargo test --test local_math -- --ignored --nocapture
//! ```

use alloy::eips::BlockId;
use alloy::primitives::{Address, Bytes, U256, address};
use alloy::sol_types::SolCall;
use anyhow::{Result, bail};
use ryo_watch::amm::{ConstantProductPool, Curve, ten_pow};
use ryo_watch::chain::{self, CallError, ChainProvider};

alloy::sol! {
    function token0() external view returns (address);
    function token1() external view returns (address);
    function getReserves() external view returns (uint112 reserve0, uint112 reserve1, uint32 blockTimestampLast);
    function decimals() external view returns (uint8);

    // Aerodrome factory fee lookup.
    function getFee(address pool, bool stable) external view returns (uint256);
}

// Both routers expose `getAmountsOut`; the ABI name fixes the selector, so each
// lives in its own module rather than being renamed.
mod univ2_router {
    alloy::sol! {
        function getAmountsOut(uint256 amountIn, address[] calldata path)
            external
            view
            returns (uint256[] memory amounts);
    }
}
mod aerodrome_router {
    alloy::sol! {
        struct Route { address from; address to; bool stable; address factory; }
        function getAmountsOut(uint256 amountIn, Route[] calldata routes)
            external
            view
            returns (uint256[] memory amounts);
    }
}

const WETH: Address = address!("4200000000000000000000000000000000000006");
const USDC: Address = address!("833589fCD6eDb6E08f4c7C32D4f71b54bdA02913");
const UNIV2_ROUTER: Address = address!("4752ba5DBc23f44D87826276BF6Fd6b1C372aD24");
const AERODROME_ROUTER: Address = address!("cF77a3Ba9A5CA399B7c97c74d54e5b1Beb874E43");
const AERODROME_FACTORY: Address = address!("420DD381b31aEf6683db6B902084cB0FFECe40Da");

// Registry pools, pinned to block for the whole run.
const UNIV2_POOL: Address = address!("88A43bbDF9D098eEC7bCEda4e2494615dfD9bB9C");
const AERO_VOLATILE: Address = address!("cDAC0d6c6C59727a65F871236188350531885C43");
const AERO_STABLE: Address = address!("3548029694fbB241D45FB24Ba0cd9c9d4E745f16");

async fn read_pool(
    provider: &ChainProvider,
    block: BlockId,
    pool: Address,
    curve: Curve,
) -> Result<ConstantProductPool> {
    let token0 = call_addr(provider, pool, token0Call {}.abi_encode(), block).await?;
    let token1 = call_addr(provider, pool, token1Call {}.abi_encode(), block).await?;
    let raw = chain::eth_call(
        provider,
        pool,
        getReservesCall {}.abi_encode().into(),
        block,
    )
    .await
    .map_err(|e| anyhow::anyhow!("getReserves: {e}"))?;
    let reserves = getReservesCall::abi_decode_returns(&raw)?;
    let (r0, r1) = (reserves.reserve0, reserves.reserve1);
    let d0 = ten_pow(call_u8(provider, token0, decimalsCall {}.abi_encode(), block).await?);
    let d1 = ten_pow(call_u8(provider, token1, decimalsCall {}.abi_encode(), block).await?);
    let fee_bps = match curve {
        Curve::UniV2 => 0,
        Curve::AerodromeVolatile | Curve::AerodromeStable => {
            let stable = matches!(curve, Curve::AerodromeStable);
            let raw = chain::eth_call(
                provider,
                AERODROME_FACTORY,
                getFeeCall { pool, stable }.abi_encode().into(),
                block,
            )
            .await
            .map_err(|e| anyhow::anyhow!("getFee: {e}"))?;
            let fee = getFeeCall::abi_decode_returns(&raw)?;
            fee.try_into().unwrap_or(0u32)
        }
    };
    Ok(ConstantProductPool {
        address: pool,
        curve,
        token0,
        token1,
        reserve0: U256::from(r0),
        reserve1: U256::from(r1),
        fee_bps,
        decimals0: d0,
        decimals1: d1,
    })
}

async fn call_addr(
    provider: &ChainProvider,
    to: Address,
    data: Vec<u8>,
    block: BlockId,
) -> Result<Address> {
    let raw = chain::eth_call(provider, to, data.into(), block)
        .await
        .map_err(|e| anyhow::anyhow!("addr call to {to}: {e}"))?;
    let word = U256::from_be_slice(&raw[..32]);
    Ok(Address::from_slice(&word.to_be_bytes::<32>()[12..]))
}

async fn call_u8(
    provider: &ChainProvider,
    to: Address,
    data: Vec<u8>,
    block: BlockId,
) -> Result<u8> {
    let raw = chain::eth_call(provider, to, data.into(), block)
        .await
        .map_err(|e| anyhow::anyhow!("u8 call to {to}: {e}"))?;
    Ok(*raw.last().unwrap_or(&0))
}

/// Live `getAmountsOut` from the correct router for the pool's venue.
async fn router_amount_out(
    provider: &ChainProvider,
    block: BlockId,
    curve: Curve,
    token_in: Address,
    token_out: Address,
    amount_in: U256,
) -> Result<Option<U256>> {
    let (to, data): (Address, Vec<u8>) = match curve {
        Curve::UniV2 => (
            UNIV2_ROUTER,
            univ2_router::getAmountsOutCall {
                amountIn: amount_in,
                path: vec![token_in, token_out],
            }
            .abi_encode(),
        ),
        Curve::AerodromeVolatile | Curve::AerodromeStable => {
            let stable = matches!(curve, Curve::AerodromeStable);
            (
                AERODROME_ROUTER,
                aerodrome_router::getAmountsOutCall {
                    amountIn: amount_in,
                    routes: vec![aerodrome_router::Route {
                        from: token_in,
                        to: token_out,
                        stable,
                        factory: Address::ZERO,
                    }],
                }
                .abi_encode(),
            )
        }
    };
    match chain::eth_call(provider, to, Bytes::from(data), block).await {
        Ok(raw) => {
            let amounts = if curve == Curve::UniV2 {
                univ2_router::getAmountsOutCall::abi_decode_returns(&raw)?
            } else {
                aerodrome_router::getAmountsOutCall::abi_decode_returns(&raw)?
            };
            // The scanner treats a zero-output leg as "no usable quote"
            // (`venues.rs` rejects `amount_out == 0`), and local math returns
            // `None` for the same dust inputs. Collapse `Some(0)` to `None` so
            // the two sides are compared on identical semantics.
            Ok(amounts.last().copied().filter(|value| !value.is_zero()))
        }
        // The router reverts when an input cannot be paid. Providers differ on
        // how they surface a revert (typed revert data vs. a code-3 message), so
        // classify either form as a decline. Local math returns `None` for the
        // same degenerate cases, so a revert must pair with a local decline.
        Err(CallError::Revert(_)) => Ok(None),
        Err(CallError::Transport(message)) => {
            if message.contains("revert") {
                Ok(None)
            } else {
                bail!("router transport error: {message}")
            }
        }
    }
}

async fn run(provider: &ChainProvider) -> Result<()> {
    let head = chain::block_number(provider).await?;
    // Pin two blocks back so the head cannot advance out from under the sweep.
    let block = BlockId::from(head.saturating_sub(2));
    eprintln!("pinned block {block:?}");

    let usdc_sweep: Vec<U256> = [
        1u64,
        50,
        999,
        1_000,
        49_999,
        1_000_000,
        12_345_678,
        500_000_000,
        1_000_000_000,
        30_000_000_000,
        100_000_000_000,
        300_000_000_000,
    ]
    .iter()
    .map(|v| U256::from(*v))
    .collect();
    // WETH raw amounts (18 decimals); big values are built from strings.
    let mut weth_sweep: Vec<U256> = [
        1u64,
        1_000_000_000_000_000_000u64, // 1 WETH
        500_000_000_000_000_000u64,
    ]
    .iter()
    .map(|v| U256::from(*v))
    .collect();
    weth_sweep.push("42000000000000000000".parse().unwrap()); // ~pool-fraction
    weth_sweep.push("100000000000000000000".parse().unwrap());
    weth_sweep.push("150000000000000000000".parse().unwrap());

    let pools = [
        ("univ2", UNIV2_POOL, Curve::UniV2),
        ("aero-volatile", AERO_VOLATILE, Curve::AerodromeVolatile),
        ("aero-stable", AERO_STABLE, Curve::AerodromeStable),
    ];

    let mut checked = 0usize;
    let mut declined = 0usize;
    for (name, pool_addr, curve) in pools {
        let pool = read_pool(provider, block, pool_addr, curve).await?;
        eprintln!(
            "{name}: reserves ({}, {}) fee_bps={}",
            pool.reserve0, pool.reserve1, pool.fee_bps
        );

        for (token_in, token_out, sweep) in [(USDC, WETH, &usdc_sweep), (WETH, USDC, &weth_sweep)] {
            for &amount in sweep {
                let local = pool.amount_out(token_in, amount);
                let router =
                    router_amount_out(provider, block, curve, token_in, token_out, amount).await?;
                match (local, router) {
                    (Some(a), Some(b)) => {
                        assert_eq!(a, b, "{name} {token_in}->{token_out} amount={amount}");
                        checked += 1;
                    }
                    (None, None) => declined += 1, // both refuse: consistent
                    (a, b) => panic!(
                        "{name} {token_in}->{token_out} amount={amount}: local={a:?} router={b:?}"
                    ),
                }
            }
        }
    }
    eprintln!("EXACT matches: {checked}, consistent declines: {declined}");
    if checked < 30 {
        bail!("only {checked} comparable quotes — the sweep was too thin to be meaningful");
    }
    Ok(())
}

#[tokio::test]
#[ignore = "needs network; see module docs"]
async fn local_math_matches_live_routers() {
    let rpc = std::env::var("RYO_LIVE_RPC").expect("set RYO_LIVE_RPC to a Base HTTP RPC");
    let provider = chain::connect_http(&rpc).await.expect("connect");
    if let Err(err) = run(&provider).await {
        panic!("local-math differential failed: {err:#}");
    }
}

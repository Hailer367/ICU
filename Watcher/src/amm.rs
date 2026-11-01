//! Local exact-price math for constant-product pools.
//!
//! The scanner normally quotes *every* leg through an on-chain `eth_call`. For
//! the constant-product venues (Uniswap V2 and Aerodrome classic) that is pure
//! waste: the output is a closed-form function of the pool's two reserves,
//! which we can read once and then compute locally for every candidate amount.
//! Concentrated liquidity (UniV3 / Slipstream) still needs the on-chain quoter,
//! so those keep going to the RPC.
//!
//! The functions here replicate the on-chain formulas **bit-for-bit**, including
//! integer truncation and the Aerodrome `x^3*y + y^3*x` Newton iteration, so a
//! local quote equals what `router.getAmountsOut` / `pool.getAmountOut` returns
//! at the same reserves. See `tests/local_math.rs`, which pins a block and
//! diffs local math against live Base for all three pools over a wide amount
//! sweep.

use alloy::primitives::{Address, U256};

/// Fee scale for Aerodrome: `getFee` returns basis points of 10_000.
const AERO_FEE_DENOM: u32 = 10_000;
/// Uniswap V2 keeps 997/1000 of the input (0.30% fee) in `getAmountOut`.
const UNIV2_FEE_NUM: u64 = 997;
const UNIV2_FEE_DEN: u64 = 1_000;

/// Which constant-product curve a pool follows.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum Curve {
    /// Uniswap V2 / `UniswapV2Library.getAmountOut` (fee `997/1000`).
    UniV2,
    /// Aerodrome classic volatile (`x*y = k`, fee subtracted first).
    AerodromeVolatile,
    /// Aerodrome classic stable (`x^3*y + y^3*x >= k`, Newton `_get_y`).
    AerodromeStable,
}

/// Everything needed to price one constant-product pool locally.
///
/// `token0`/`token1` order and `decimals` scale only matter for the stable
/// curve; the volatile curves use raw reserves directly.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub struct ConstantProductPool {
    pub address: Address,
    pub curve: Curve,
    /// Pool `token0` address (defines reserve0 ordering).
    pub token0: Address,
    /// Pool `token1` address (defines reserve1 ordering).
    pub token1: Address,
    /// Live reserves, `(reserve0, reserve1)` in raw token units.
    pub reserve0: U256,
    pub reserve1: U256,
    /// Aerodrome `factory.getFee` basis points of 10_000; ignored for UniV2.
    pub fee_bps: u32,
    /// `10 ** token0.decimals()`, used only by the stable curve.
    pub decimals0: U256,
    /// `10 ** token1.decimals()`, used only by the stable curve.
    pub decimals1: U256,
}

impl ConstantProductPool {
    /// Reserves oriented for a swap of `token_in`, returning
    /// `(reserve_in, reserve_out)`. `None` when `token_in` is not a pool token.
    pub fn reserves_for(&self, token_in: Address) -> Option<(U256, U256)> {
        if token_in == self.token0 {
            Some((self.reserve0, self.reserve1))
        } else if token_in == self.token1 {
            Some((self.reserve1, self.reserve0))
        } else {
            None
        }
    }

    /// Exact local `getAmountOut`. `None` if the amount is zero, the token is
    /// not in the pool, a reserve is empty, or the result would be zero (a
    /// quoter would return `0`, so the caller treats zero-output as "no
    /// usable quote" and falls back rather than mis-ranking).
    pub fn amount_out(&self, token_in: Address, amount_in: U256) -> Option<U256> {
        if amount_in.is_zero() {
            return None;
        }
        let (reserve_in, reserve_out) = self.reserves_for(token_in)?;
        if reserve_in.is_zero() || reserve_out.is_zero() {
            return None;
        }
        let out = match self.curve {
            Curve::UniV2 => univ2_amount_out(amount_in, reserve_in, reserve_out),
            Curve::AerodromeVolatile => {
                aerodrome_volatile_amount_out(amount_in, reserve_in, reserve_out, self.fee_bps)
            }
            // The stable curve is direction-sensitive in the contract: the
            // invariant `_k` always uses the pool's fixed `reserve0/reserve1`
            // and their decimals, while reserves are *then* oriented for the
            // swap. So it takes the whole pool, not the pre-oriented reserves.
            Curve::AerodromeStable => {
                let net_in = subtract_fee_bps(amount_in, self.fee_bps)?;
                if net_in.is_zero() {
                    return None;
                }
                aerodrome_stable_amount_out(self, token_in == self.token0, net_in)
            }
        };
        out.filter(|value| !value.is_zero())
    }
}

/// `UniswapV2Library.getAmountOut`: fee is applied inside the numerator and the
/// `reserve_in * 1000` denominator, so it is *not* the same as subtracting the
/// fee first. Kept separate for exact truncation parity.
pub fn univ2_amount_out(amount_in: U256, reserve_in: U256, reserve_out: U256) -> Option<U256> {
    let amount_in = U256::from(amount_in);
    let amount_in_with_fee = amount_in.checked_mul(U256::from(UNIV2_FEE_NUM))?;
    let numerator = amount_in_with_fee.checked_mul(reserve_out)?;
    let denominator = reserve_in.checked_mul(U256::from(UNIV2_FEE_DEN))? + amount_in_with_fee;
    if denominator.is_zero() {
        return None;
    }
    Some(numerator / denominator)
}

/// Aerodrome volatile: subtract fee (basis points) from the input first, then
/// the plain `x*y = k` output. Mirrors `Pool._getAmountOut` non-stable branch.
pub fn aerodrome_volatile_amount_out(
    amount_in: U256,
    reserve_in: U256,
    reserve_out: U256,
    fee_bps: u32,
) -> Option<U256> {
    let net_in = subtract_fee_bps(amount_in, fee_bps)?;
    if net_in.is_zero() {
        return None;
    }
    let numerator = net_in.checked_mul(reserve_out)?;
    let denominator = reserve_in + net_in;
    if denominator.is_zero() {
        return None;
    }
    Some(numerator / denominator)
}

/// Aerodrome stable: `x^3*y + y^3*x >= k`, solved with the contract's own
/// Newton-Raphson `_get_y` (same iteration cap and same rounding at every step)
/// so the output matches `Pool.getAmountOut` exactly.
///
/// `token_in_is_token0` mirrors the pool's `_getAmountOut` branching: the
/// invariant `_k` is computed from the pool's fixed `reserve0/reserve1` and
/// their decimals, reserves are *then* oriented, and the result is scaled back
/// by the *output* token's decimals.
pub fn aerodrome_stable_amount_out(
    pool: &ConstantProductPool,
    token_in_is_token0: bool,
    net_in: U256,
) -> Option<U256> {
    let one = ten_pow(18);
    let d0 = pool.decimals0;
    let d1 = pool.decimals1;
    // Invariant from the pool's *fixed* reserves (never direction-oriented).
    let xy = stable_k(pool.reserve0, pool.reserve1, d0, d1, one)?;
    let n0 = (pool.reserve0 * one) / d0;
    let n1 = (pool.reserve1 * one) / d1;
    // reserveA = side being fed, reserveB = side being drawn.
    let (reserve_a, reserve_b) = if token_in_is_token0 {
        (n0, n1)
    } else {
        (n1, n0)
    };
    let norm_amount_in = if token_in_is_token0 {
        (net_in * one) / d0
    } else {
        (net_in * one) / d1
    };
    let x0 = norm_amount_in + reserve_a;
    let y = stable_get_y(x0, xy, reserve_b, d0, d1, one)?;
    if y > reserve_b {
        return None;
    }
    let out = reserve_b - y;
    // Scale the drawn amount back by the output token's decimals.
    let decimals_out = if token_in_is_token0 { d1 } else { d0 };
    Some((out * decimals_out) / one)
}

/// `amountIn - (amountIn * fee_bps / 10000)`, Solidity integer division.
fn subtract_fee_bps(amount_in: U256, fee_bps: u32) -> Option<U256> {
    let fee = (amount_in * U256::from(fee_bps)) / U256::from(AERO_FEE_DENOM);
    amount_in.checked_sub(fee)
}

/// Pool `_k`: `x^3*y + y^3*x` in 1e18-normalized space.
fn stable_k(x: U256, y: U256, decimals0: U256, decimals1: U256, one: U256) -> Option<U256> {
    let nx = (x * one) / decimals0;
    let ny = (y * one) / decimals1;
    let a = (nx * ny) / one;
    let b = (nx * nx) / one + (ny * ny) / one;
    Some((a * b) / one)
}

/// Pool `_f(x0, y)`.
fn stable_f(x0: U256, y: U256, one: U256) -> U256 {
    let a = (x0 * y) / one;
    let b = (x0 * x0) / one + (y * y) / one;
    (a * b) / one
}

/// Pool `_d(x0, y)` (the derivative used for the Newton step).
fn stable_d(x0: U256, y: U256, one: U256) -> U256 {
    let three = U256::from(3u8);
    let dy_term = (three * x0 * ((y * y) / one)) / one;
    let dx_term = (((x0 * x0) / one) * x0) / one;
    dy_term + dx_term
}

/// Pool `_get_y` — Newton iteration with the identical early-exit conditions.
/// Returns `None` only if the loop fails to converge (the contract reverts with
/// `!y`; a caller treats `None` as "no local quote" and falls back on-chain).
fn stable_get_y(
    x0: U256,
    xy: U256,
    mut y: U256,
    decimals0: U256,
    decimals1: U256,
    one: U256,
) -> Option<U256> {
    // The contract loops `for (uint256 i = 0; i < 255; i++)` and reverts `!y`
    // if it never converges. `x0` here is already in 1e18-normalized units, so
    // reusing it inside `_k`/`_f`/`_d` matches the pool's own calls.
    for _ in 0..255u32 {
        let k = stable_f(x0, y, one);
        if k < xy {
            let d = stable_d(x0, y, one);
            if d.is_zero() {
                return None;
            }
            let mut dy = ((xy - k) * one) / d;
            if dy.is_zero() {
                if k == xy {
                    return Some(y);
                }
                if stable_k(x0, y + U256::from(1u8), decimals0, decimals1, one)? > xy {
                    return Some(y + U256::from(1u8));
                }
                dy = U256::from(1u8);
            }
            y += dy;
        } else {
            let d = stable_d(x0, y, one);
            if d.is_zero() {
                return None;
            }
            let mut dy = ((k - xy) * one) / d;
            if dy.is_zero() {
                if k == xy {
                    return Some(y);
                }
                if stable_f(x0, y - U256::from(1u8), one) < xy {
                    return Some(y);
                }
                dy = U256::from(1u8);
            }
            y = y.checked_sub(dy)?;
        }
    }
    None
}

/// `10 ** decimals` as a U256 (`decimals` is a token's `uint8`).
pub fn ten_pow(decimals: u8) -> U256 {
    U256::from(10u64).pow(U256::from(decimals as u64))
}

#[cfg(test)]
mod tests {
    use super::*;
    use alloy::primitives::address;

    const WETH: Address = address!("4200000000000000000000000000000000000006");
    const USDC: Address = address!("833589fCD6eDb6E08f4c7C32D4f71b54bdA02913");

    fn u(v: &str) -> U256 {
        v.parse().unwrap()
    }

    // Ground truth captured from live Base mainnet at block 0x32e4c40,
    // pool.getAmountOut / router.getAmountsOut, USDC(token1) -> WETH(token0).

    #[test]
    fn univ2_matches_onchain() {
        // reserves at pin: token0 WETH, token1 USDC
        let pool = ConstantProductPool {
            address: address!("88A43bbDF9D098eEC7bCEda4e2494615dfD9bB9C"),
            curve: Curve::UniV2,
            token0: WETH,
            token1: USDC,
            reserve0: u("332281898883266007348"),
            reserve1: u("755060367805"),
            fee_bps: 0,
            decimals0: ten_pow(18),
            decimals1: ten_pow(6),
        };
        // 1000 USDC -> 438174492166393695 WETH (router).
        assert_eq!(
            pool.amount_out(USDC, u("1000000000")),
            Some(u("438174492166393695"))
        );
    }

    #[test]
    fn aerodrome_volatile_matches_onchain() {
        let pool = ConstantProductPool {
            address: address!("cDAC0d6c6C59727a65F871236188350531885C43"),
            curve: Curve::AerodromeVolatile,
            token0: WETH,
            token1: USDC,
            reserve0: u("311242401685482878122"),
            reserve1: u("707301497653"),
            fee_bps: 30,
            decimals0: ten_pow(18),
            decimals1: ten_pow(6),
        };
        let cases = [
            ("1", "440042050"),
            ("100", "44004205091"),
            ("5000", "2193609608654"),
            ("1000000000", "438104380439401481"),
            ("30000000000", "12627665553304477667"),
            ("300000000000", "92500460861024661118"),
        ];
        for (a, o) in cases {
            assert_eq!(pool.amount_out(USDC, u(a)), Some(u(o)), "amountIn={a}");
        }
    }

    #[test]
    fn aerodrome_stable_matches_onchain() {
        let pool = ConstantProductPool {
            address: address!("3548029694fbB241D45FB24Ba0cd9c9d4E745f16"),
            curve: Curve::AerodromeStable,
            token0: WETH,
            token1: USDC,
            reserve0: u("1817544473561387101"),
            reserve1: u("12361462420"),
            fee_bps: 5,
            decimals0: ten_pow(18),
            decimals1: ten_pow(6),
        };
        let cases = [
            ("1", "441099355"),
            ("1000000", "440807519920099"),
            ("1000000000", "378144858936473179"),
            ("30000000000", "1772333567832587268"),
            ("100000000000", "1815121088827700131"),
            ("500000000000", "1817518911190917406"),
        ];
        for (a, o) in cases {
            assert_eq!(pool.amount_out(USDC, u(a)), Some(u(o)), "amountIn={a}");
        }
    }

    #[test]
    fn unknown_token_and_zero_are_none() {
        let pool = ConstantProductPool {
            address: WETH,
            curve: Curve::UniV2,
            token0: WETH,
            token1: USDC,
            reserve0: u("1000"),
            reserve1: u("1000"),
            fee_bps: 0,
            decimals0: ten_pow(18),
            decimals1: ten_pow(6),
        };
        let stranger = Address::repeat_byte(0x99);
        assert_eq!(pool.amount_out(stranger, u("1")), None);
        assert_eq!(pool.amount_out(USDC, U256::ZERO), None);
    }

    #[test]
    fn volatile_and_stable_round_trips_are_monotonic() {
        // Bigger input must never yield a smaller output (sanity for ranking).
        let vol = ConstantProductPool {
            address: WETH,
            curve: Curve::AerodromeVolatile,
            token0: WETH,
            token1: USDC,
            reserve0: u("311242401685482878122"),
            reserve1: u("707301497653"),
            fee_bps: 30,
            decimals0: ten_pow(18),
            decimals1: ten_pow(6),
        };
        let mut prev = U256::ZERO;
        for shift in 0..40u32 {
            let amt = U256::from(10u64).pow(U256::from(shift as u64));
            if let Some(out) = vol.amount_out(USDC, amt) {
                assert!(out >= prev, "output must be monotonic in input");
                prev = out;
            }
        }
    }
}

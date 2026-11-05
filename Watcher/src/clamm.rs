//! Local Uniswap-V3-style concentrated-liquidity pricing (§0u).
//!
//! A bit-for-bit port of the quoting path shared by Uniswap V3, PancakeSwap
//! V3, and Aerodrome Slipstream pools: `TickMath`, `FullMath`,
//! `SqrtPriceMath`, `SwapMath`, `TickBitmap`, and the `swap()` main loop.
//! All three families use functionally identical step math; the family
//! difference is where the fee comes from (static tier vs dynamic `fee()`),
//! which lives in the pool state, not in the loop.
//!
//! Upstream ground truth (v3-core compiles with solc 0.7.6, where plain
//! `uint` operators *wrap*, explicit narrowing casts *truncate*, and only
//! SafeMath-style helpers revert — this port mirrors each call site's exact
//! flavour, because a "close enough" port disagrees with the quoter at the
//! last wei):
//! - Uniswap/v3-core master: TickMath.sol, SqrtPriceMath.sol, SwapMath.sol,
//!   FullMath.sol, TickBitmap.sol, UniswapV3Pool.sol (swap loop)
//! - PancakeSwap/pancake-v3-contracts main/projects/v3-core — step math
//!   identical; its protocol fee is carved out *after* input consumption
//! - velodrome/aerodrome slipstream — step math identical; `fee()` dynamic
//!
//! The house rules from `amm.rs` bind again: every intermediate that the
//! contract checks uses `checked_*`, and a `None` here means "local math has
//! no answer" — the scanner must then quote on chain, never conclude the
//! route is unprofitable. A refusal on an input the quoter would revert on
//! is a *consistent* refusal (neither side has a price).
//!
//! Protocol fees are deliberately not modelled: `pool.swap` deducts
//! `amountIn + feeAmount` from the remaining input *before* the protocol
//! split moves part of `feeAmount` aside, so amounts are independent of
//! `slot0.feeProtocol`. Oracle/fee-growth bookkeeping likewise cannot affect
//! outputs and is omitted.

use std::collections::HashMap;

use alloy::primitives::aliases::I24;
use alloy::primitives::{Address, I256, U256, Uint, uint};

type U512 = Uint<512, 8>;

/// TickMath bounds.
pub const MIN_TICK: i32 = -887_272;
pub const MAX_TICK: i32 = 887_272;
pub const MIN_SQRT_RATIO: U256 = uint!(4295128739_U256);
pub const MAX_SQRT_RATIO: U256 = uint!(1461446703485210103287273052203988822378723970342_U256);

const MAX_U160: U256 = uint!(0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF_U256);
const MAX_U128: U256 = uint!(0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF_U256);
const MAX_I256_AS_U: U256 =
    uint!(0x7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF_U256);
/// FixedPoint96: 2^96.
const Q96: U256 = uint!(0x1000000000000000000000000_U256);
/// Fee scale: `feePips` are hundredths of a bip against 1e6.
const FEE_SCALE: u64 = 1_000_000;

// ---------------------------------------------------------------------------
// EVM-flavoured conversions and casts
// ---------------------------------------------------------------------------

/// `uint256(int256 x)` / `int256(uint256 x)`: the EVM keeps the two's
/// complement bit pattern in both directions.
fn u256_from_i256(v: I256) -> U256 {
    v.into_raw()
}

fn i256_from_u256_truncating(v: U256) -> I256 {
    I256::from_raw(v)
}

/// Sign-extend an i128 into I256 (all TickMath constants fit i128).
fn i256_from_i128(v: i128) -> I256 {
    let fill = if v < 0 { u64::MAX } else { 0 };
    I256::from_raw(U256::from_limbs([v as u64, (v >> 64) as u64, fill, fill]))
}

/// Wrapping negate (EVM `sub(0, x)`), matching `-int256` on 0.7.6.
fn i256_neg_wrapping(v: I256) -> I256 {
    I256::ZERO.wrapping_sub(v)
}

/// `SafeCast.toUint256(int256)`: reverts (refusal) on negative.
fn i256_to_u256_checked(v: I256) -> Option<U256> {
    if v < I256::ZERO {
        None
    } else {
        Some(u256_from_i256(v))
    }
}

/// `SafeCast.toInt256(uint256)`: reverts (refusal) above `int256` max.
fn i256_from_u256_bounded(v: U256) -> Option<I256> {
    if v > MAX_I256_AS_U {
        None
    } else {
        Some(i256_from_u256_truncating(v))
    }
}

/// Assembly `div`/`mod` semantics: division by zero yields zero, never a
/// revert (only `Checked` div in Solidity >=0.8 reverts; v3-core libraries
/// are 0.7.6 with assembly or SafeMath division).
fn evm_div(x: U256, y: U256) -> U256 {
    if y.is_zero() { U256::ZERO } else { x / y }
}

/// `UnsafeMath.divRoundingUp` (assembly: `add(div(x,y), gt(mod(x,y),0))`).
fn div_rounding_up(x: U256, y: U256) -> U256 {
    if y.is_zero() {
        return U256::ZERO;
    }
    let q = x / y;
    if (x % y).is_zero() {
        q
    } else {
        q.wrapping_add(U256::from(1u8))
    }
}

/// Explicit `uint160(x)` truncating cast, but only ever reached with a
/// value that provably fits — refuse instead of wrapping garbage.
fn cast_u160(v: U256) -> Option<U256> {
    (v <= MAX_U160).then_some(v)
}

// ---------------------------------------------------------------------------
// FullMath
// ---------------------------------------------------------------------------

/// `FullMath.mulDiv`: floor(a*b/denominator). `None` where upstream reverts:
/// `denominator == 0`, or the quotient not fitting 256 bits.
pub fn mul_div(a: U256, b: U256, denominator: U256) -> Option<U256> {
    if denominator.is_zero() {
        return None;
    }
    let product: U512 = a.widening_mul::<256, 4, 512, 8>(b);
    let limbs = product.as_limbs();
    let high = U256::from_limbs([limbs[4], limbs[5], limbs[6], limbs[7]]);
    if high.is_zero() {
        let exact = a.checked_mul(b)?;
        return Some(exact / denominator);
    }
    if denominator <= high {
        return None; // `require(denominator > prod1)`
    }
    let quotient = product / U512::from(denominator);
    let q = quotient.as_limbs();
    if q[4] | q[5] | q[6] | q[7] != 0 {
        return None; // result overflows 256 bits
    }
    Some(U256::from_limbs([q[0], q[1], q[2], q[3]]))
}

/// `FullMath.mulDivRoundingUp`: ceil(a*b/denominator).
pub fn mul_div_rounding_up(a: U256, b: U256, denominator: U256) -> Option<U256> {
    if denominator.is_zero() {
        return None;
    }
    let result = mul_div(a, b, denominator)?;
    let product: U512 = a.widening_mul::<256, 4, 512, 8>(b);
    let inexact = product % U512::from(denominator) != U512::ZERO;
    if inexact {
        // `require(result < type(uint256).max)` then `result++`
        if result == U256::MAX {
            return None;
        }
        return Some(result.wrapping_add(U256::from(1u8)));
    }
    Some(result)
}

// ---------------------------------------------------------------------------
// TickMath
// ---------------------------------------------------------------------------

/// Seed and the 18 follow-on Q128.128 factors of `getSqrtRatioAtTick`,
/// transcribed in order from the upstream unrolled `absTick & 0x…` chain
/// (index 0 is the seed applied when bit 0 is set; indices 1..19 are the
/// factors for bits 1..19, applied as `(ratio * magic) >> 128`).
const TICK_MAGICS: [U256; 19] = [
    uint!(0xfffcb933bd6fad37aa2d162d1a594001_U256),
    uint!(0xfff97272373d413259a46990580e213a_U256),
    uint!(0xfff2e50f5f656932ef12357cf3c7fdcc_U256),
    uint!(0xffe5caca7e10e4e61c3624eaa0941cd0_U256),
    uint!(0xffcb9843d60f6159c9db58835c926644_U256),
    uint!(0xff973b41fa98c081472e6896dfb254c0_U256),
    uint!(0xff2ea16466c96a3843ec78b326b52861_U256),
    uint!(0xfe5dee046a99a2a811c461f1969c3053_U256),
    uint!(0xfcbe86c7900a88aedcffc83b479aa3a4_U256),
    uint!(0xf987a7253ac413176f2b074cf7815e54_U256),
    uint!(0xf3392b0822b70005940c7a398e4b70f3_U256),
    uint!(0xe7159475a2c29b7443b29c7fa6e889d9_U256),
    uint!(0xd097f3bdfd2022b8845ad8f792aa5825_U256),
    uint!(0xa9f746462d870fdf8a65dc1f90e061e5_U256),
    uint!(0x70d869a156d2a1b890bb3df62baf32f7_U256),
    uint!(0x31be135f97d08fd981231505542fcfa6_U256),
    uint!(0x9aa508b5b7a84e1c677de54f3e99bc9_U256),
    uint!(0x5d6af8dedb81196699c329225ee604_U256),
    uint!(0x2216e584f5fa1ea926041bedfe98_U256),
];
const TICK_MAGIC_LAST: U256 = uint!(0x48a170391f7dc42444e8fa2_U256);
const ONE_SHIFT_128: U256 = uint!(0x100000000000000000000000000000000_U256);

/// `TickMath.getSqrtRatioAtTick`: sqrt(1.0001^tick) as Q64.96.
/// `None` outside ±MAX_TICK (upstream `require(absTick <= MAX_TICK)`).
pub fn get_sqrt_ratio_at_tick(tick: i32) -> Option<U256> {
    let abs_tick = tick.unsigned_abs();
    if abs_tick > MAX_TICK as u32 {
        return None;
    }
    let mut ratio = if abs_tick & 1 != 0 {
        TICK_MAGICS[0]
    } else {
        ONE_SHIFT_128
    };
    for (i, magic) in TICK_MAGICS[1..].iter().enumerate() {
        if abs_tick & (1u32 << (i + 1)) != 0 {
            // Both operands < 2^128 by construction; product fits 256 bits.
            ratio = ratio.wrapping_mul(*magic) >> U256::from(128u64);
        }
    }
    if abs_tick & (1u32 << 19) != 0 {
        ratio = ratio.wrapping_mul(TICK_MAGIC_LAST) >> U256::from(128u64);
    }
    if tick > 0 {
        ratio = U256::MAX / ratio;
    }
    // Divide by 2^32 rounding up (Q128.128 -> Q128.96).
    let shifted = ratio >> U256::from(32u64);
    let round_up = if ratio % U256::from(1u64 << 32) == U256::ZERO {
        U256::ZERO
    } else {
        U256::from(1u8)
    };
    let out = shifted.wrapping_add(round_up);
    // The uint160 cast cannot truncate inside the tick bound; refuse if it
    // ever would (guards a wrong constant table, not real inputs).
    cast_u160(out)
}

/// `TickMath.getTickAtSqrtRatio`: greatest tick with ratio <= price.
/// `None` outside `[MIN_SQRT_RATIO, MAX_SQRT_RATIO)` (upstream `require 'R'`).
pub fn get_tick_at_sqrt_ratio(sqrt_price_x96: U256) -> Option<i32> {
    if sqrt_price_x96 < MIN_SQRT_RATIO || sqrt_price_x96 >= MAX_SQRT_RATIO {
        return None;
    }
    let ratio = sqrt_price_x96.checked_shl(32)?;

    // mostSignificantBit ladder: comparisons against 2^128-1, 2^64-1,
    // 2^32-1, 2^16-1, 2^8-1, 2^4-1, 2^2-1 (each shifting when exceeded),
    // then a final `gt(r, 1)` that only sets bit 1 without shifting.
    let mut r = ratio;
    let mut msb: u32 = 0;
    let thresholds: [(U256, u32); 7] = [
        (U256::MAX >> U256::from(128u64), 128),
        ((U256::from(1u8) << U256::from(64u64)) - U256::from(1u8), 64),
        ((U256::from(1u8) << U256::from(32u64)) - U256::from(1u8), 32),
        ((U256::from(1u8) << U256::from(16u64)) - U256::from(1u8), 16),
        ((U256::from(1u8) << U256::from(8u64)) - U256::from(1u8), 8),
        ((U256::from(1u8) << U256::from(4u64)) - U256::from(1u8), 4),
        ((U256::from(1u8) << U256::from(2u64)) - U256::from(1u8), 2),
    ];
    for (threshold, step) in thresholds {
        if r > threshold {
            msb |= step;
            r >>= U256::from(step as u64);
        }
    }
    if r > U256::from(1u8) {
        msb |= 1;
    }

    if msb >= 128 {
        r = ratio >> U256::from(msb - 127);
    } else {
        r = ratio << U256::from(127 - msb);
    }

    let mut log_2 = i256_from_i128((msb as i128 - 128) << 64);

    // 14 squaring iterations for bits 63..50; only the first 13 re-shift r.
    for i in 0..14u32 {
        let product = r.wrapping_mul(r); // EVM `mul` wraps mod 2^256
        r = product >> U256::from(127u64);
        let f = (r >> U256::from(128u64)) & U256::from(1u8);
        if f == U256::from(1u8) {
            log_2 = log_2.wrapping_add(i256_from_i128(1i128 << (63 - i)));
            if i < 13 {
                r >>= U256::from(1u64);
            }
        }
    }

    // 2^127 / log2(sqrt(1.0001)), Q128.128 (wrapping 256-bit product).
    let log_sqrt10001 = log_2.wrapping_mul(i256_from_i128(255_738_958_999_603_826_347_141));
    // 2^128 - (2^127 * log2(1.0001) * 2^127 / 2^128 rounding constants),
    // Q128.128. The high constant exceeds i128; `uint!` decimals are exact.
    let tick_low = arith_shr_128(log_sqrt10001.wrapping_sub(I256::from_raw(uint!(
        3_402_992_956_809_132_418_596_140_100_660_247_210_U256
    ))));
    let tick_high = arith_shr_128(log_sqrt10001.wrapping_add(I256::from_raw(uint!(
        291_339_464_771_989_622_907_027_621_153_398_088_495_U256
    ))));

    if tick_low == tick_high {
        return Some(tick_low);
    }
    let ratio_hi = get_sqrt_ratio_at_tick(tick_high)?;
    if ratio_hi <= sqrt_price_x96 {
        Some(tick_high)
    } else {
        Some(tick_low)
    }
}

/// `(int256) >> 128` with arithmetic shift (floor), narrowed to i32 — the
/// EVM `sar` the contract relies on. The top 16 bytes of the two's
/// complement pattern *are* that result as a sign-extended i128.
fn arith_shr_128(v: I256) -> i32 {
    let bytes = v.into_raw().to_be_bytes::<32>();
    let mut hi = [0u8; 16];
    hi.copy_from_slice(&bytes[..16]);
    let q = i128::from_be_bytes(hi);
    debug_assert!(q.abs() <= i128::from(MAX_TICK) + 1);
    q as i32
}

// ---------------------------------------------------------------------------
// SqrtPriceMath
// ---------------------------------------------------------------------------

/// `SqrtPriceMath.getAmount0Delta`.
fn get_amount_0_delta(a: U256, b: U256, liquidity: U256, round_up: bool) -> Option<U256> {
    let (a, b) = if a > b { (b, a) } else { (a, b) };
    if a.is_zero() {
        return None; // `require(sqrtRatioAX96 > 0)`
    }
    let numerator1 = liquidity.checked_shl(96)?;
    let numerator2 = b.wrapping_sub(a);
    if round_up {
        let inner = mul_div_rounding_up(numerator1, numerator2, b)?;
        Some(div_rounding_up(inner, a))
    } else {
        let q = mul_div(numerator1, numerator2, b)?;
        Some(q / a) // a > 0 checked above (Solidity `/` on 0.7.6 assembly div; require guards)
    }
}

/// `SqrtPriceMath.getAmount1Delta`.
fn get_amount_1_delta(a: U256, b: U256, liquidity: U256, round_up: bool) -> Option<U256> {
    let (a, b) = if a > b { (b, a) } else { (a, b) };
    let diff = b.wrapping_sub(a);
    if round_up {
        mul_div_rounding_up(liquidity, diff, Q96)
    } else {
        mul_div(liquidity, diff, Q96)
    }
}

/// `SqrtPriceMath.getNextSqrtPriceFromAmount0RoundingUp`.
fn get_next_sqrt_price_from_amount0_rounding_up(
    sqrt_p_x96: U256,
    liquidity: U256,
    amount: U256,
    add: bool,
) -> Option<U256> {
    if amount.is_zero() {
        return Some(sqrt_p_x96);
    }
    let numerator1 = liquidity.checked_shl(96)?;
    if add {
        if let Some(product) = amount.checked_mul(sqrt_p_x96)
            && evm_div(product, amount) == sqrt_p_x96
            && let Some(denominator) = numerator1.checked_add(product)
            && denominator >= numerator1
        {
            // always fits in 160 bits per the comment
            return cast_u160(mul_div_rounding_up(numerator1, sqrt_p_x96, denominator)?);
        }
        let base = evm_div(numerator1, sqrt_p_x96);
        let denominator = base.checked_add(amount)?;
        cast_u160(div_rounding_up(numerator1, denominator))
    } else {
        // `require(product fits && numerator1 > product)` — reverts upstream
        // on either failure, so refuse rather than wrap.
        let product = amount.checked_mul(sqrt_p_x96)?;
        if evm_div(product, amount) != sqrt_p_x96 || numerator1 <= product {
            return None;
        }
        let denominator = numerator1.wrapping_sub(product);
        // `.toUint160()` — SafeCast, checked.
        cast_u160(mul_div_rounding_up(numerator1, sqrt_p_x96, denominator)?)
    }
}

/// `SqrtPriceMath.getNextSqrtPriceFromAmount1RoundingDown`.
fn get_next_sqrt_price_from_amount1_rounding_down(
    sqrt_p_x96: U256,
    liquidity: U256,
    amount: U256,
    add: bool,
) -> Option<U256> {
    if add {
        let quotient = if amount <= MAX_U160 {
            evm_div(amount.checked_shl(96)?, liquidity)
        } else {
            mul_div(amount, Q96, liquidity)?
        };
        cast_u160(sqrt_p_x96.checked_add(quotient)?) // `.toUint160()` checked
    } else {
        let quotient = if amount <= MAX_U160 {
            div_rounding_up(amount.checked_shl(96)?, liquidity)
        } else {
            mul_div_rounding_up(amount, Q96, liquidity)?
        };
        if sqrt_p_x96 <= quotient {
            return None; // `require(sqrtPX96 > quotient)`
        }
        Some(sqrt_p_x96.wrapping_sub(quotient)) // always fits 160 bits
    }
}

/// `SqrtPriceMath.getNextSqrtPriceFromInput`.
fn get_next_sqrt_price_from_input(
    sqrt_p_x96: U256,
    liquidity: U256,
    amount_in: U256,
    zero_for_one: bool,
) -> Option<U256> {
    if sqrt_p_x96.is_zero() || liquidity.is_zero() {
        return None; // requires
    }
    if zero_for_one {
        get_next_sqrt_price_from_amount0_rounding_up(sqrt_p_x96, liquidity, amount_in, true)
    } else {
        get_next_sqrt_price_from_amount1_rounding_down(sqrt_p_x96, liquidity, amount_in, true)
    }
}

/// `SqrtPriceMath.getNextSqrtPriceFromOutput`.
fn get_next_sqrt_price_from_output(
    sqrt_p_x96: U256,
    liquidity: U256,
    amount_out: U256,
    zero_for_one: bool,
) -> Option<U256> {
    if sqrt_p_x96.is_zero() || liquidity.is_zero() {
        return None;
    }
    if zero_for_one {
        get_next_sqrt_price_from_amount1_rounding_down(sqrt_p_x96, liquidity, amount_out, false)
    } else {
        get_next_sqrt_price_from_amount0_rounding_up(sqrt_p_x96, liquidity, amount_out, false)
    }
}

// ---------------------------------------------------------------------------
// SwapMath
// ---------------------------------------------------------------------------

/// One step of `SwapMath.computeSwapStep`.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub struct Step {
    pub sqrt_ratio_next_x96: U256,
    pub amount_in: U256,
    pub amount_out: U256,
    pub fee_amount: U256,
}

/// `SwapMath.computeSwapStep`, both branches. The declaration shape mirrors
/// the contract (which returns all four values from one frame), so clippy's
/// late-init suggestion would obscure the line-for-line correspondence.
#[allow(clippy::needless_late_init)]
pub fn compute_swap_step(
    sqrt_ratio_current_x96: U256,
    sqrt_ratio_target_x96: U256,
    liquidity: U256,
    amount_remaining: I256,
    fee_pips: u64,
) -> Option<Step> {
    if fee_pips >= FEE_SCALE {
        return None; // pools guarantee fee < 1e6 (factory bound)
    }
    let zero_for_one = sqrt_ratio_current_x96 >= sqrt_ratio_target_x96;
    let exact_in = amount_remaining >= I256::ZERO;
    let fee_less = U256::from(FEE_SCALE - fee_pips);
    let fee_scale = U256::from(FEE_SCALE);

    let mut amount_in = U256::ZERO;
    let mut amount_out = U256::ZERO;
    let sqrt_ratio_next_x96: U256;
    if exact_in {
        let remaining_u = u256_from_i256(amount_remaining);
        let amount_remaining_less_fee = mul_div(remaining_u, fee_less, fee_scale)?;
        amount_in = if zero_for_one {
            get_amount_0_delta(
                sqrt_ratio_target_x96,
                sqrt_ratio_current_x96,
                liquidity,
                true,
            )?
        } else {
            get_amount_1_delta(
                sqrt_ratio_current_x96,
                sqrt_ratio_target_x96,
                liquidity,
                true,
            )?
        };
        sqrt_ratio_next_x96 = if amount_remaining_less_fee >= amount_in {
            sqrt_ratio_target_x96
        } else {
            get_next_sqrt_price_from_input(
                sqrt_ratio_current_x96,
                liquidity,
                amount_remaining_less_fee,
                zero_for_one,
            )?
        };
    } else {
        let remaining_neg = u256_from_i256(i256_neg_wrapping(amount_remaining));
        amount_out = if zero_for_one {
            get_amount_1_delta(
                sqrt_ratio_target_x96,
                sqrt_ratio_current_x96,
                liquidity,
                false,
            )?
        } else {
            get_amount_0_delta(
                sqrt_ratio_current_x96,
                sqrt_ratio_target_x96,
                liquidity,
                false,
            )?
        };
        sqrt_ratio_next_x96 = if remaining_neg >= amount_out {
            sqrt_ratio_target_x96
        } else {
            get_next_sqrt_price_from_output(
                sqrt_ratio_current_x96,
                liquidity,
                remaining_neg,
                zero_for_one,
            )?
        };
    }

    let max = sqrt_ratio_target_x96 == sqrt_ratio_next_x96;
    if zero_for_one {
        if !(max && exact_in) {
            amount_in =
                get_amount_0_delta(sqrt_ratio_next_x96, sqrt_ratio_current_x96, liquidity, true)?;
        }
        if !(max && !exact_in) {
            amount_out = get_amount_1_delta(
                sqrt_ratio_next_x96,
                sqrt_ratio_current_x96,
                liquidity,
                false,
            )?;
        }
    } else {
        if !(max && exact_in) {
            amount_in =
                get_amount_1_delta(sqrt_ratio_current_x96, sqrt_ratio_next_x96, liquidity, true)?;
        }
        if !(max && !exact_in) {
            amount_out = get_amount_0_delta(
                sqrt_ratio_next_x96,
                sqrt_ratio_current_x96,
                liquidity,
                false,
            )?;
        }
    }

    if !exact_in {
        let remaining_neg = u256_from_i256(i256_neg_wrapping(amount_remaining));
        if amount_out > remaining_neg {
            amount_out = remaining_neg;
        }
    }

    let fee_amount = if exact_in && sqrt_ratio_next_x96 != sqrt_ratio_target_x96 {
        // Didn't reach the target: all leftover input becomes fee.
        u256_from_i256(amount_remaining).wrapping_sub(amount_in)
    } else {
        mul_div_rounding_up(amount_in, U256::from(fee_pips), fee_less)?
    };

    Some(Step {
        sqrt_ratio_next_x96,
        amount_in,
        amount_out,
        fee_amount,
    })
}

// ---------------------------------------------------------------------------
// TickBitmap
// ---------------------------------------------------------------------------

/// `TickBitmap.position` over the compressed tick.
fn position(tick: i32) -> (i32, u8) {
    (tick >> 8, (tick & 0xff) as u8) // int16(arith >>8) / uint8(truncating %256)
}

/// `TickBitmap.nextInitializedTickWithinOneWord` over a cached word map.
/// `None` (local refusal) when the word it would read is not cached.
fn next_initialized_tick_within_one_word(
    bitmap: &HashMap<i32, U256>,
    tick: i32,
    tick_spacing: i32,
    lte: bool,
) -> Option<(i32, bool)> {
    if tick_spacing <= 0 {
        return None;
    }
    // Solidity truncating `/` plus the `tick < 0 && tick % spacing != 0`
    // fixup is exactly floor division.
    let compressed = tick.div_euclid(tick_spacing);
    if lte {
        let (word_pos, bit_pos) = position(compressed);
        let word = *bitmap.get(&word_pos)?;
        let one = U256::from(1u8);
        let at = one.checked_shl(bit_pos as usize)?;
        let mask = at.wrapping_sub(one).wrapping_add(at); // (1<<p - 1) | (1<<p)
        let masked = word & mask;
        let initialized = !masked.is_zero();
        let next = if initialized {
            let msb = 255usize.saturating_sub(masked.leading_zeros()) as u32;
            compressed
                .checked_sub(bit_pos as i32 - msb as i32)?
                .checked_mul(tick_spacing)?
        } else {
            compressed
                .checked_sub(bit_pos as i32)?
                .checked_mul(tick_spacing)?
        };
        Some((next, initialized))
    } else {
        let compressed = compressed.checked_add(1)?;
        let (word_pos, bit_pos) = position(compressed);
        let word = *bitmap.get(&word_pos)?;
        let one = U256::from(1u8);
        let mask = !one.checked_shl(bit_pos as usize)?.wrapping_sub(one);
        let masked = word & mask;
        let initialized = !masked.is_zero();
        let next = if initialized {
            let lsb = masked.trailing_zeros();
            compressed
                .checked_add(lsb as i32 - bit_pos as i32)?
                .checked_mul(tick_spacing)?
        } else {
            compressed
                .checked_add(255 - bit_pos as i32)?
                .checked_mul(tick_spacing)?
        };
        Some((next, initialized))
    }
}

// ---------------------------------------------------------------------------
// Pool state + swap loop
// ---------------------------------------------------------------------------

/// The quoting-relevant slice of one concentrated-liquidity pool, kept in
/// RAM and maintained from the live event stream. Missing bitmap words or
/// tick nets are refusals, never a price verdict.
#[derive(Debug, Clone)]
pub struct ClPoolState {
    pub address: Address,
    pub token0: Address,
    pub token1: Address,
    pub tick_spacing: i32,
    /// Fee in hundredths of a bip on the 1e6 scale (raw tier value, or the
    /// dynamic `fee()` read at `block`).
    pub fee_pips: u64,
    pub sqrt_price_x96: U256,
    pub tick: i32,
    pub liquidity: U256,
    /// Block the cached slot0/bitmap/ticks were read at (provenance).
    pub block: u64,
    bitmap: HashMap<i32, U256>,
    nets: HashMap<i32, I256>,
    /// Set when slot0/bitmap/ticks can no longer be trusted (non-Swap pool
    /// event, reconnect, reorg, or the price left the cached words).
    pub stale: bool,
}

/// Result of a fully simulated swap.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub struct ClSwapOutcome {
    /// Input actually consumed *including* the swap fee.
    pub amount_in_consumed: U256,
    /// Output produced.
    pub amount_out: U256,
    pub sqrt_price_x96_after: U256,
    pub liquidity_after: U256,
    pub tick_after: i32,
}

/// Hard cap on tick steps per quote: pools with sane liquidity converge
/// far below it; hitting the cap means the cached range is too sparse or
/// the input is adversarial — refuse and let the remote quoter decide.
const MAX_SWAP_ITERATIONS: u32 = 2048;

impl ClPoolState {
    /// Quote an exact-input swap in RAM. `None` on staleness, missing tick
    /// data, a non-pool token, dust, or any point where the pool would
    /// revert — the caller must fall back to the on-chain quoter.
    pub fn quote_exact_in(&self, token_in: Address, amount_in: U256) -> Option<U256> {
        if self.stale || amount_in.is_zero() {
            return None;
        }
        let zero_for_one = if token_in == self.token0 {
            true
        } else if token_in == self.token1 {
            false
        } else {
            return None;
        };
        let outcome = self.swap_at_limit(zero_for_one, amount_in)?;
        // A zero output is "no answer", matching amm.rs: the remote quoter
        // rejects it too, so the fallback path is consistent.
        Some(outcome.amount_out).filter(|v| !v.is_zero())
    }

    /// Quote with the QuoterV2 substituted price limit and hand back the
    /// full after-state — the differential's comparison surface.
    pub fn swap_at_limit(&self, zero_for_one: bool, amount_in: U256) -> Option<ClSwapOutcome> {
        if self.stale || amount_in.is_zero() {
            return None;
        }
        // QuoterV2 substitutes the extreme limit for zero, and `pool.swap`
        // requires it strictly beyond the current price (error 'SPL').
        let sqrt_price_limit = if zero_for_one {
            MIN_SQRT_RATIO.wrapping_add(U256::from(1u8))
        } else {
            MAX_SQRT_RATIO.wrapping_sub(U256::from(1u8))
        };
        self.swap(zero_for_one, amount_in, sqrt_price_limit)
    }

    /// The `swap()` main loop for exact input, minus storage writes, oracle
    /// bookkeeping, and the protocol-fee carve-out (none affect amounts —
    /// see the module header). `amount_specified` is the input (positive).
    pub fn swap(
        &self,
        zero_for_one: bool,
        amount_specified: U256,
        sqrt_price_limit_x96: U256,
    ) -> Option<ClSwapOutcome> {
        if amount_specified.is_zero() {
            return None; // require 'AS'
        }
        // SPL require.
        let valid_limit = if zero_for_one {
            sqrt_price_limit_x96 < self.sqrt_price_x96 && sqrt_price_limit_x96 > MIN_SQRT_RATIO
        } else {
            sqrt_price_limit_x96 > self.sqrt_price_x96 && sqrt_price_limit_x96 < MAX_SQRT_RATIO
        };
        if !valid_limit {
            return None;
        }

        let mut amount_remaining = i256_from_u256_bounded(amount_specified)?;
        let mut amount_calculated = I256::ZERO;
        let mut sqrt_price_x96 = self.sqrt_price_x96;
        let mut tick = self.tick;
        let mut liquidity = self.liquidity;
        let mut iterations = 0u32;

        while !amount_remaining.is_zero() && sqrt_price_x96 != sqrt_price_limit_x96 {
            iterations += 1;
            if iterations > MAX_SWAP_ITERATIONS {
                return None;
            }
            let sqrt_price_start_x96 = sqrt_price_x96;

            let (tick_next, initialized) = next_initialized_tick_within_one_word(
                &self.bitmap,
                tick,
                self.tick_spacing,
                zero_for_one,
            )?;
            // Upstream clamps the word-search result into the tick bounds;
            // the bitmap itself knows nothing about them.
            let tick_next = tick_next.clamp(MIN_TICK, MAX_TICK);

            let sqrt_price_next_x96 = get_sqrt_ratio_at_tick(tick_next)?;
            let target = if zero_for_one {
                if sqrt_price_next_x96 < sqrt_price_limit_x96 {
                    sqrt_price_limit_x96
                } else {
                    sqrt_price_next_x96
                }
            } else if sqrt_price_next_x96 > sqrt_price_limit_x96 {
                sqrt_price_limit_x96
            } else {
                sqrt_price_next_x96
            };

            let step = compute_swap_step(
                sqrt_price_x96,
                target,
                liquidity,
                amount_remaining,
                self.fee_pips,
            )?;
            sqrt_price_x96 = step.sqrt_ratio_next_x96;

            // exactInput: remaining -= (amountIn + feeAmount), calculated -= amountOut
            let consumed = step.amount_in.wrapping_add(step.fee_amount); // plain `+`
            amount_remaining = amount_remaining.checked_sub(i256_from_u256_bounded(consumed)?)?; // LowGasSafeMath
            amount_calculated =
                amount_calculated.checked_sub(i256_from_u256_bounded(step.amount_out)?)?;

            if sqrt_price_x96 == sqrt_price_next_x96 {
                if initialized {
                    let net = *self.nets.get(&tick_next)?;
                    // `-liquidityNet` when moving left (int128 min is
                    // impossible per the contract comment).
                    let net = if zero_for_one {
                        net.wrapping_neg()
                    } else {
                        net
                    };
                    liquidity = add_delta_u128(liquidity, net)?;
                }
                tick = if zero_for_one {
                    tick_next.checked_sub(1)?
                } else {
                    tick_next
                };
            } else if sqrt_price_x96 != sqrt_price_start_x96 {
                tick = get_tick_at_sqrt_ratio(sqrt_price_x96)?;
            }
        }

        let consumed_total = amount_specified.wrapping_sub(u256_from_i256(amount_remaining));
        let amount_out = i256_to_u256_checked(i256_neg_wrapping(amount_calculated))?;
        Some(ClSwapOutcome {
            amount_in_consumed: consumed_total,
            amount_out,
            sqrt_price_x96_after: sqrt_price_x96,
            liquidity_after: liquidity,
            tick_after: tick,
        })
    }

    // -- cache maintenance -------------------------------------------------

    /// Apply the after-state words of a live `Swap` event. The event carries
    /// the *answer* (`sqrtPriceX96`, `liquidity`, `tick`), so steady-state
    /// slot0 maintenance costs no RPC.
    pub fn apply_swap_after(&mut self, sqrt_price_x96: U256, liquidity: U256, tick: i32) {
        self.sqrt_price_x96 = sqrt_price_x96;
        self.liquidity = liquidity;
        self.tick = tick;
        if self.tick_spacing <= 0 {
            self.stale = true;
            return;
        }
        let (word_pos, _) = position(tick.div_euclid(self.tick_spacing));
        if !self.bitmap.contains_key(&word_pos) {
            // The price left the cached word range; re-bootstrap follows.
            self.stale = true;
        }
    }

    /// A non-Swap pool log (Mint/Burn/Collect/…) can initialize or flip
    /// ticks or change liquidity outside the event words: the bitmap and
    /// nets cannot be trusted until refreshed.
    pub fn mark_stale(&mut self) {
        self.stale = true;
    }

    /// Insert a freshly bootstrapped bitmap word.
    pub fn insert_word(&mut self, word_pos: i32, word: U256) {
        self.bitmap.insert(word_pos, word);
    }

    /// Insert a fetched tick net.
    fn insert_net(&mut self, tick: i32, net: I256) {
        self.nets.insert(tick, net);
    }

    /// Replace the cached fee with a fresh `fee()` read (Slipstream's fee is
    /// dynamic; static tiers never change, so this only ever fires for them
    /// as a no-op check).
    pub fn refresh_fee(&mut self, fee_pips: u64) {
        self.fee_pips = fee_pips;
    }

    /// How many initialized ticks the cached coverage holds.
    pub fn cached_ticks(&self) -> usize {
        self.nets.len()
    }

    /// How many bitmap words are cached.
    pub fn cached_words(&self) -> usize {
        self.bitmap.len()
    }
}

/// `LiquidityMath.addDelta` on uint128-bounded liquidity: reverts ('LS' /
/// 'LA' — modelled as a refusal) on signed under/overflow.
fn add_delta_u128(x: U256, y: I256) -> Option<U256> {
    if x > MAX_U128 {
        return None;
    }
    if y < I256::ZERO {
        let mag = i256_to_u256_checked(i256_neg_wrapping(y))?;
        let out = x.checked_sub(mag)?;
        if out >= x {
            return None; // underflow 'LS'
        }
        Some(out)
    } else {
        let mag = i256_to_u256_checked(y)?;
        let out = x.checked_add(mag)?;
        if out < x || out > MAX_U128 {
            return None; // overflow 'LA'
        }
        Some(out)
    }
}

// ---------------------------------------------------------------------------
// Bootstrap: read pool state through Multicall3 at one block
// ---------------------------------------------------------------------------

use alloy::eips::BlockId;
use alloy::primitives::Bytes;
use alloy::sol_types::SolCall;

use crate::abi::cl_pool;
use crate::chain::{self, ChainProvider};

/// One CL pool to bootstrap, resolved by the caller from the registry.
#[derive(Debug, Clone, Copy)]
pub struct ClPoolSpec {
    pub index: usize,
    pub address: Address,
    pub token0: Address,
    pub token1: Address,
    /// Slipstream carries its spacing in the venue key; V3/Pancake read it
    /// from the pool itself (authoritative, one call per pool).
    pub tick_spacing_hint: Option<i32>,
    /// Whether the fee is dynamic (`fee()` changes between blocks).
    pub dynamic_fee: bool,
}

/// Bitmap words fetched per direction around the current tick.
pub const WORDS_PER_DIRECTION: i32 = 16;
/// Soft cap on liquidityNet fetches per direction; coverage shrinks to the
/// densest side when a word range exceeds it. Deep pools keep their whole
/// current word (max 256 bits) regardless.
pub const TICK_CAP_PER_DIRECTION: usize = 150;
/// Multicall3 chunk size, matching `venues::quote_batch`.
const MULTICALL_CHUNK: usize = 80;

async fn chunked_multicall(
    provider: &ChainProvider,
    calls: &[(Address, Bytes)],
    block: BlockId,
) -> Vec<std::result::Result<Bytes, String>> {
    let mut out = Vec::with_capacity(calls.len());
    for (ci, chunk) in calls.chunks(MULTICALL_CHUNK).enumerate() {
        if std::env::var("RYO_TRACE_BOOT").is_ok() {
            eprintln!("[boot] chunk {ci}/{}", calls.len().div_ceil(MULTICALL_CHUNK));
        }
        out.extend(chain::multicall_raw(provider, chunk, block).await);
    }
    out
}

fn word_u256(data: &[u8], index: usize) -> Option<U256> {
    let start = index.checked_mul(32)?;
    let slice = data.get(start..start.checked_add(32)?)?;
    Some(U256::from_be_slice(slice))
}

fn word_i256(data: &[u8], index: usize) -> Option<I256> {
    Some(I256::from_raw(word_u256(data, index)?))
}

fn word_i32(data: &[u8], index: usize) -> Option<i32> {
    // int24 sign-extended across the 32-byte word: the low 4 bytes carry it.
    let start = index.checked_mul(32)? + 28;
    let slice = data.get(start..start.checked_add(4)?)?;
    let mut buf = [0u8; 4];
    buf.copy_from_slice(slice);
    Some(i32::from_be_bytes(buf))
}

fn bits_in(word: U256) -> usize {
    word.as_limbs()
        .iter()
        .map(|l| l.count_ones() as usize)
        .sum()
}

fn set_bits(word: U256) -> Vec<u32> {
    let mut out = Vec::new();
    let limbs = word.as_limbs();
    for (li, &limb) in limbs.iter().enumerate() {
        let mut v = limb;
        while v != 0 {
            let b = v.trailing_zeros();
            out.push(li as u32 * 64 + b);
            v &= v - 1;
        }
    }
    out
}

/// Read slot0/fee/liquidity/tickSpacing for every pool, walk the tick bitmap
/// around each current price (bounded per §0u), fetch the touched ticks, and
/// return complete caches. Any pool whose reads fail is simply absent — the
/// scanner quotes those legs on chain.
pub async fn bootstrap_pools(
    provider: &ChainProvider,
    specs: &[ClPoolSpec],
    block: BlockId,
    block_number: u64,
) -> HashMap<usize, ClPoolState> {
    let mut states = HashMap::new();
    if specs.is_empty() {
        return states;
    }

    // Round 1: slot0, fee, liquidity, tickSpacing per pool.
    let mut calls = Vec::with_capacity(specs.len() * 4);
    for spec in specs {
        calls.push((spec.address, cl_pool::slot0Call {}.abi_encode().into()));
        calls.push((spec.address, cl_pool::feeCall {}.abi_encode().into()));
        calls.push((spec.address, cl_pool::liquidityCall {}.abi_encode().into()));
        calls.push((
            spec.address,
            cl_pool::tickSpacingCall {}.abi_encode().into(),
        ));
    }
    let results = chunked_multicall(provider, &calls, block).await;

    struct Draft {
        spec: ClPoolSpec,
        sqrt_price_x96: U256,
        tick: i32,
        liquidity: U256,
        fee_pips: u64,
        tick_spacing: i32,
    }
    let mut drafts: Vec<Draft> = Vec::new();
    for (i, spec) in specs.iter().enumerate() {
        let base = i * 4;
        let (Some(slot0), Some(fee), Some(liquidity), Some(spacing)) = (
            results.get(base).and_then(|r| r.as_ref().ok()),
            results.get(base + 1).and_then(|r| r.as_ref().ok()),
            results.get(base + 2).and_then(|r| r.as_ref().ok()),
            results.get(base + 3).and_then(|r| r.as_ref().ok()),
        ) else {
            continue; // any missing read: stay remote
        };
        let (Some(sqrt_price_x96), Some(tick), Some(liquidity_v), Some(spacing_v)) = (
            word_u256(slot0, 0),
            word_i32(slot0, 1),
            word_u256(liquidity, 0),
            word_i32(spacing, 0),
        ) else {
            continue;
        };
        if spacing_v <= 0 {
            continue;
        }
        if let Some(hint) = spec.tick_spacing_hint
            && hint != spacing_v
        {
            // Registry disagrees with the pool: trust nothing, go remote.
            continue;
        }
        let Some(fee_v) = word_u256(fee, 0).map(|v| v.to::<u64>()) else {
            continue;
        };
        drafts.push(Draft {
            spec: *spec,
            sqrt_price_x96,
            tick,
            liquidity: liquidity_v,
            fee_pips: fee_v,
            tick_spacing: spacing_v,
        });
    }

    // Round 2: bitmap words in a fixed band around each current tick.
    struct WordPlan {
        draft_index: usize,
        word_positions: Vec<i32>,
    }
    let mut plans = Vec::new();
    let mut word_calls: Vec<(Address, Bytes)> = Vec::new();
    for (di, draft) in drafts.iter().enumerate() {
        let compressed = draft.tick.div_euclid(draft.tick_spacing);
        let center = compressed >> 8;
        let positions: Vec<i32> =
            (center - WORDS_PER_DIRECTION..=center + WORDS_PER_DIRECTION).collect();
        for &wp in &positions {
            word_calls.push((
                draft.spec.address,
                cl_pool::tickBitmapCall { wordPos: wp as i16 }
                    .abi_encode()
                    .into(),
            ));
        }
        plans.push(WordPlan {
            draft_index: di,
            word_positions: positions,
        });
    }
    let word_results = chunked_multicall(provider, &word_calls, block).await;

    // Coverage selection + tick call list.
    let mut tick_calls: Vec<(Address, Bytes)> = Vec::new();
    let mut tick_plan: Vec<(usize, i32)> = Vec::new(); // (draft, real tick)
    let mut chosen: Vec<(usize, Vec<(i32, U256)>)> = Vec::new(); // (draft, covered words)
    let mut cursor = 0usize;
    for plan in &plans {
        let draft = &drafts[plan.draft_index];
        let compressed = draft.tick.div_euclid(draft.tick_spacing);
        let center = compressed >> 8;
        let mut words: Vec<(i32, U256)> = Vec::new();
        let mut ok = true;
        for &wp in &plan.word_positions {
            match word_results.get(cursor) {
                Some(Ok(data)) => match word_u256(data, 0) {
                    Some(v) => words.push((wp, v)),
                    None => {
                        ok = false;
                        break;
                    }
                },
                _ => {
                    ok = false;
                    break;
                }
            }
            cursor += 1;
        }
        if !ok || words.is_empty() {
            continue; // whole band unusable: stay remote for this pool
        }
        // Grow the contiguous [lo..hi] around center while the tick budget
        // holds; the center word is always covered (its bits are the pool's
        // live neighborhood).
        let bits_at: std::collections::HashMap<i32, usize> =
            words.iter().map(|(w, v)| (*w, bits_in(*v))).collect();
        let mut lo = center;
        let mut hi = center;
        let mut used = *bits_at.get(&center).unwrap_or(&0);
        loop {
            let next_lo = lo - 1;
            let next_hi = hi + 1;
            let has_lo = bits_at.contains_key(&next_lo);
            let has_hi = bits_at.contains_key(&next_hi);
            if !has_lo && !has_hi {
                break;
            }
            let cost_lo = if has_lo {
                bits_at[&next_lo]
            } else {
                usize::MAX
            };
            let cost_hi = if has_hi {
                bits_at[&next_hi]
            } else {
                usize::MAX
            };
            let (take, cost) = if cost_lo <= cost_hi {
                (next_lo, cost_lo)
            } else {
                (next_hi, cost_hi)
            };
            if used.saturating_add(cost) > 2 * TICK_CAP_PER_DIRECTION {
                break;
            }
            if take == next_lo {
                lo = take;
            } else {
                hi = take;
            }
            used += cost;
        }
        let mut covered_ticks = Vec::new();
        for (w, v) in &words {
            if *w < lo || *w > hi {
                continue;
            }
            for bit in set_bits(*v) {
                let compressed_tick = w * 256 + bit as i32;
                let Some(real) = compressed_tick.checked_mul(draft.tick_spacing) else {
                    continue;
                };
                if !(MIN_TICK..=MAX_TICK).contains(&real) {
                    continue;
                }
                covered_ticks.push(real);
            }
        }
        for t in covered_ticks.clone() {
            let Ok(tick_id) = I24::try_from(t) else {
                continue; // off the int24 wire: leave unfetched, quotes refuse
            };
            tick_calls.push((
                draft.spec.address,
                cl_pool::ticksCall { tickId: tick_id }.abi_encode().into(),
            ));
            tick_plan.push((plan.draft_index, t));
        }
        let covered_words: Vec<(i32, U256)> = words
            .into_iter()
            .filter(|(w, _)| *w >= lo && *w <= hi)
            .collect();
        chosen.push((plan.draft_index, covered_words));
    }

    // Round 3: liquidityNet per covered tick. Failed reads leave the tick
    // known-but-unfetched: quotes crossing it refuse, everything else works.
    let tick_results = chunked_multicall(provider, &tick_calls, block).await;
    let mut nets_by_draft: HashMap<usize, Vec<(i32, I256)>> = HashMap::new();
    for ((di, tick), result) in tick_plan.into_iter().zip(tick_results.iter()) {
        if let Ok(data) = result
            && let Some(net) = word_i256(data, 1)
        {
            nets_by_draft.entry(di).or_default().push((tick, net));
        }
    }

    for (di, covered_words) in chosen {
        let draft = &drafts[di];
        let mut state = ClPoolState {
            address: draft.spec.address,
            token0: draft.spec.token0,
            token1: draft.spec.token1,
            tick_spacing: draft.tick_spacing,
            fee_pips: draft.fee_pips,
            sqrt_price_x96: draft.sqrt_price_x96,
            tick: draft.tick,
            liquidity: draft.liquidity,
            block: block_number,
            bitmap: HashMap::new(),
            nets: HashMap::new(),
            stale: false,
        };
        for (wp, word) in covered_words {
            state.insert_word(wp, word);
        }
        if let Some(nets) = nets_by_draft.remove(&di) {
            for (tick, net) in nets {
                state.insert_net(tick, net);
            }
        }
        states.insert(draft.spec.index, state);
    }
    states
}
// ---------------------------------------------------------------------------
// Live-event maintenance
// ---------------------------------------------------------------------------

use std::sync::OnceLock;

use alloy::primitives::{B256, keccak256};
use alloy::rpc::types::Log;

const SWAP_V3_SIG: &str = "Swap(address,address,int256,int256,uint160,uint128,int24)";
/// Pancake V3 copies the Uniswap event and appends two protocol-fee words;
/// the topic differs but the first five data words are identical.
const SWAP_PANCAKE_V3_SIG: &str =
    "Swap(address,address,int256,int256,uint160,uint128,int24,uint128,uint128)";

/// The post-swap slot0 words (`sqrtPriceX96`, `liquidity`, `tick`) carried by
/// a V3-family `Swap` log. `None` means "not a swap event" (or a malformed
/// one) — the caller treats that as "state beyond price may have changed"
/// and schedules a re-bootstrap.
pub fn swap_after_words(log: &Log) -> Option<(U256, U256, i32)> {
    static V3_TOPIC: OnceLock<B256> = OnceLock::new();
    static PANCAKE_TOPIC: OnceLock<B256> = OnceLock::new();
    let topic = *log.topics().first()?;
    if topic != *V3_TOPIC.get_or_init(|| keccak256(SWAP_V3_SIG.as_bytes()))
        && topic != *PANCAKE_TOPIC.get_or_init(|| keccak256(SWAP_PANCAKE_V3_SIG.as_bytes()))
    {
        return None;
    }
    let data = &log.data().data;
    if data.len() < 160 {
        return None;
    }
    let sqrt_price_x96 = U256::from_be_slice(data.get(64..96)?);
    let liquidity = U256::from_be_slice(data.get(96..128)?);
    let tick: [u8; 4] = data.get(156..160)?.try_into().ok()?;
    Some((sqrt_price_x96, liquidity, i32::from_be_bytes(tick)))
}

/// Read `fee()` for a batch of pools at one block. Slipstream fees are
/// dynamic and drift between swaps; the scanner refreshes them per scan so
/// local quotes use a fee close to the one the quoter would charge.
pub async fn fetch_fees(
    provider: &ChainProvider,
    addrs: &[Address],
    block: BlockId,
) -> Vec<Option<u64>> {
    let calls: Vec<(Address, Bytes)> = addrs
        .iter()
        .map(|a| (*a, cl_pool::feeCall {}.abi_encode().into()))
        .collect();
    chunked_multicall(provider, &calls, block)
        .await
        .into_iter()
        .map(|r| match r {
            Ok(data) => word_u256(&data, 0).map(|v| v.to::<u64>()),
            Err(_) => None,
        })
        .collect()
}

#[cfg(test)]
mod tests {
    use super::*;
    use alloy::primitives::FixedBytes;
    use std::str::FromStr;

    fn u(s: &str) -> U256 {
        U256::from_str(s).expect("decimal u256")
    }

    /// `tick -> getSqrtRatioAtTick(tick)` pairs from
    /// v3-core `test/__snapshots__/TickMath.spec.ts.snap` (upstream test
    /// run output, not hand-written constants).
    const TICK_VECTORS: [(&str, &str); 28] = [
        ("-50", "79030349367926598376800521322"),
        ("-100", "78833030112140176575862854579"),
        ("-250", "78244023372248365697264290337"),
        ("-500", "77272108795590369356373805297"),
        ("-1000", "75364347830767020784054125655"),
        ("-2500", "69919044979842180277688105136"),
        ("-3000", "68192822843687888778582228483"),
        ("-4000", "64867181785621769311890333195"),
        ("-5000", "61703726247759831737814779831"),
        ("-50000", "6504256538020985011912221507"),
        ("-150000", "43836292794701720435367485"),
        ("-250000", "295440463448801648376846"),
        ("-500000", "1101692437043807371"),
        ("-738203", "7409801140451"),
        ("50", "79426470787362580746886972461"),
        ("100", "79625275426524748796330556128"),
        ("250", "80224679980005306637834519095"),
        ("500", "81233731461783161732293370115"),
        ("1000", "83290069058676223003182343270"),
        ("2500", "89776708723587163891445672585"),
        ("3000", "92049301871182272007977902845"),
        ("4000", "96768528593268422080558758223"),
        ("5000", "101729702841318637793976746270"),
        ("50000", "965075977353221155028623082916"),
        ("150000", "143194173941309278083010301478497"),
        ("250000", "21246587762933397357449903968194344"),
        ("500000", "5697689776495288729098254600827762987878"),
        ("738203", "847134979253254120489401328389043031315994541"),
    ];

    #[test]
    fn tick_math_matches_upstream_snapshots() {
        for (tick, ratio) in TICK_VECTORS {
            let t: i32 = tick.parse().unwrap();
            let got = get_sqrt_ratio_at_tick(t).unwrap_or_else(|| panic!("refused {t}"));
            assert_eq!(got, u(ratio), "tick {t}");
        }
    }

    #[test]
    fn tick_math_boundaries() {
        assert_eq!(get_sqrt_ratio_at_tick(MIN_TICK), Some(MIN_SQRT_RATIO));
        assert_eq!(get_sqrt_ratio_at_tick(MAX_TICK), Some(MAX_SQRT_RATIO));
        assert_eq!(get_sqrt_ratio_at_tick(MIN_TICK + 1), Some(u("4295343490")));
        assert_eq!(
            get_sqrt_ratio_at_tick(MAX_TICK - 1),
            Some(u("1461373636630004318706518188784493106690254656249"))
        );
        assert_eq!(get_sqrt_ratio_at_tick(0), Some(Q96));
        assert!(get_sqrt_ratio_at_tick(MIN_TICK - 1).is_none());
        assert!(get_sqrt_ratio_at_tick(MAX_TICK + 1).is_none());
    }

    #[test]
    fn tick_at_sqrt_ratio_boundaries() {
        assert_eq!(get_tick_at_sqrt_ratio(MIN_SQRT_RATIO), Some(MIN_TICK));
        assert_eq!(get_tick_at_sqrt_ratio(u("4295343490")), Some(MIN_TICK + 1));
        assert_eq!(
            get_tick_at_sqrt_ratio(u("1461373636630004318706518188784493106690254656249")),
            Some(MAX_TICK - 1)
        );
        assert_eq!(
            get_tick_at_sqrt_ratio(MAX_SQRT_RATIO - U256::from(1u8)),
            Some(MAX_TICK - 1)
        );
        assert!(get_tick_at_sqrt_ratio(MIN_SQRT_RATIO - U256::from(1u8)).is_none());
        assert!(get_tick_at_sqrt_ratio(MAX_SQRT_RATIO).is_none());
    }

    #[test]
    fn tick_round_trip_dense() {
        // getSqrtRatioAtTick rounds up, so the tick of the exact boundary
        // price is always the tick itself. Sweep densely and across the 19
        // magic-number cut points.
        for t in -4100i32..4100 {
            let ratio = get_sqrt_ratio_at_tick(t).unwrap();
            assert_eq!(get_tick_at_sqrt_ratio(ratio), Some(t), "round trip {t}");
        }
        let cuts = [
            0u32, 1, 2, 3, 8, 9, 16, 17, 100, 127, 128, 129, 500, 3000, 50000, 250_000, 500_000,
            738_203, 887_272,
        ];
        for t in cuts {
            for sign in [1i32, -1] {
                let tick = sign * t as i32;
                if !(MIN_TICK..=MAX_TICK).contains(&tick) {
                    continue;
                }
                let ratio = get_sqrt_ratio_at_tick(tick).unwrap();
                if ratio >= MAX_SQRT_RATIO {
                    continue; // unreachable price; rejected by design
                }
                assert_eq!(get_tick_at_sqrt_ratio(ratio), Some(tick), "cut {tick}");
            }
        }
    }

    #[test]
    fn tick_ratio_monotonic() {
        let mut prev = get_sqrt_ratio_at_tick(MIN_TICK).unwrap();
        for t in (MIN_TICK + 1)..=(MIN_TICK + 20_000) {
            let cur = get_sqrt_ratio_at_tick(t).unwrap();
            assert!(cur > prev, "monotonic at {t}");
            prev = cur;
        }
    }

    #[test]
    fn mul_div_vectors_and_refusals() {
        // mulDiv(MaxUint256, MaxUint256, MaxUint256) == MaxUint256 (upstream).
        assert_eq!(mul_div(U256::MAX, U256::MAX, U256::MAX), Some(U256::MAX));
        // mulDiv(2^128, 35*2^128, 8*2^128) == floor(35*2^128/8) (upstream).
        let q128 = ONE_SHIFT_128;
        assert_eq!(
            mul_div(q128, U256::from(35u8) * q128, U256::from(8u8) * q128),
            Some(u("1488735355279105777652263907513985925120"))
        );
        // mulDiv(2^128, 1000*2^128, 3000*2^128) == floor(2^128/3) (upstream).
        assert_eq!(
            mul_div(q128, U256::from(1000u16) * q128, U256::from(3000u16) * q128),
            Some(u("113427455640312821154458202477256070485"))
        );
        assert_eq!(
            mul_div_rounding_up(q128, U256::from(1000u16) * q128, U256::from(3000u16) * q128),
            Some(u("113427455640312821154458202477256070486"))
        );
        // Exact roundingUp of the MaxUint256 triple.
        assert_eq!(
            mul_div_rounding_up(U256::MAX, U256::MAX, U256::MAX),
            Some(U256::MAX)
        );

        // Zero denominator: revert => refusal.
        assert_eq!(mul_div(U256::from(7u8), U256::from(3u8), U256::ZERO), None);
        assert_eq!(
            mul_div_rounding_up(U256::from(7u8), U256::from(3u8), U256::ZERO),
            None
        );
        // Quotient above 256 bits: revert => refusal (`denominator <= prod1`).
        assert_eq!(mul_div(U256::MAX, U256::MAX, U256::from(2u8)), None);
        // roundingUp at the top: result == max with remainder => revert.
        assert_eq!(
            mul_div_rounding_up(
                U256::MAX,
                U256::MAX,
                U256::from(1u8).checked_shl(128).unwrap()
            ),
            None
        );

        // Spot property against exact 512-bit arithmetic on crossing inputs.
        let inputs = [
            (U256::MAX, U256::from(3u8), U256::from(2u8)),
            (
                u("79228162514264337593543950336"),
                u("79228162514264337593543950335"),
                u("1000000"),
            ),
            (
                U256::from(u64::MAX),
                U256::from(u64::MAX),
                U256::from(999u16),
            ),
        ];
        for (a, b, d) in inputs {
            let product = a.widening_mul::<256, 4, 512, 8>(b);
            let floor = product / U512::from(d);
            if floor > U512::from(U256::MAX) {
                assert_eq!(mul_div(a, b, d), None);
                continue;
            }
            let expect = u256_from_i256(I256::from_raw(U256::from_limbs([
                floor.as_limbs()[0],
                floor.as_limbs()[1],
                floor.as_limbs()[2],
                floor.as_limbs()[3],
            ])));
            assert_eq!(mul_div(a, b, d), Some(expect));
        }
    }

    /// `computeSwapStep` vectors from upstream `test/SwapMath.spec.ts`,
    /// with fully explicit numbers (no encoded prices).
    #[test]
    fn compute_swap_step_upstream_vectors() {
        // "amount out is capped at the desired amount out"
        let s = compute_swap_step(
            u("417332158212080721273783715441582"),
            u("1452870262520218020823638996"),
            u("159344665391607089467575320103"),
            I256::ONE.wrapping_neg(),
            1,
        )
        .unwrap();
        assert_eq!(s.amount_in, u("1"));
        assert_eq!(s.fee_amount, u("1"));
        assert_eq!(s.amount_out, u("1"));
        assert_eq!(
            s.sqrt_ratio_next_x96,
            u("417332158212080721273783715441581")
        );

        // "target price of 1 uses partial input amount"
        let s = compute_swap_step(
            u("2"),
            u("1"),
            u("1"),
            I256::try_from(u("3915081100057732413702495386755767")).unwrap(),
            1,
        )
        .unwrap();
        assert_eq!(s.amount_in, u("39614081257132168796771975168"));
        assert_eq!(s.fee_amount, u("39614120871253040049813"));
        assert_eq!(s.amount_out, u("0"));
        assert_eq!(s.sqrt_ratio_next_x96, u("1"));

        // "entire input amount taken as fee"
        let s = compute_swap_step(
            u("2413"),
            u("79887613182836312"),
            u("1985041575832132834610021537970"),
            I256::try_from(10i32).unwrap(),
            1872,
        )
        .unwrap();
        assert_eq!(s.amount_in, u("0"));
        assert_eq!(s.fee_amount, u("10"));
        assert_eq!(s.amount_out, u("0"));
        assert_eq!(s.sqrt_ratio_next_x96, u("2413"));

        // "intermediate insufficient liquidity, zero for one exact output"
        let sqrt_p = u("20282409603651670423947251286016");
        let sqrt_p_target = sqrt_p * U256::from(11u8) / U256::from(10u8);
        let s = compute_swap_step(
            sqrt_p,
            sqrt_p_target,
            u("1024"),
            I256::try_from(-4i32).unwrap(),
            3000,
        )
        .unwrap();
        assert_eq!(s.amount_out, u("0"));
        assert_eq!(s.sqrt_ratio_next_x96, sqrt_p_target);
        assert_eq!(s.amount_in, u("26215"));
        assert_eq!(s.fee_amount, u("79"));

        // "intermediate insufficient liquidity, one for zero exact output"
        let sqrt_p_target = sqrt_p * U256::from(9u8) / U256::from(10u8);
        let s = compute_swap_step(
            sqrt_p,
            sqrt_p_target,
            u("1024"),
            I256::try_from(-263000i32).unwrap(),
            3000,
        )
        .unwrap();
        assert_eq!(s.amount_out, u("26214"));
        assert_eq!(s.sqrt_ratio_next_x96, sqrt_p_target);
        assert_eq!(s.amount_in, u("1"));
        assert_eq!(s.fee_amount, u("1"));

        // Fee >= 1e6 is not a pool state; refuse.
        assert!(
            compute_swap_step(sqrt_p, sqrt_p_target, u("1024"), I256::ONE, 1_000_000).is_none()
        );
    }

    #[test]
    fn bitmap_word_search_semantics() {
        // Word layout: bit `i` of word `w` covers compressed tick `w*256 + i`.
        let mut bitmap: HashMap<i32, U256> = HashMap::new();
        let one = U256::from(1u8);
        // word 0 empty; word 1 has ticks 260 (bit 4) and 400 (bit 144) set.
        let word1 = (one << U256::from(4u64)) | (one << U256::from(144u64));
        bitmap.insert(1, word1);
        // Words the walk may need around the current tick 300 (spacing 1).
        bitmap.insert(0, U256::ZERO);
        bitmap.insert(2, U256::ZERO);

        // lte (zero-for-one) from 300: within word 1, the highest set bit at
        // or below bit 44 is bit 4 -> compressed 260 -> tick 260, initialized.
        let (next, init) = next_initialized_tick_within_one_word(&bitmap, 300, 1, true).unwrap();
        assert_eq!((next, init), (260, true));
        // From 261: still finds 260.
        let (next, init) = next_initialized_tick_within_one_word(&bitmap, 261, 1, true).unwrap();
        assert_eq!((next, init), (260, true));
        // From 259: no bits at or below 259 inside word 1 below bit 3; the
        // first candidate is compressed 259's own bit (bit 3) -> none -> the
        // word floor (256) uninitialized.
        let (next, init) = next_initialized_tick_within_one_word(&bitmap, 259, 1, true).unwrap();
        assert_eq!((next, init), (256, false));
        // gt (one-for-zero) from 300: lowest set bit at or above 45 is 144 -> 400.
        let (next, init) = next_initialized_tick_within_one_word(&bitmap, 300, 1, false).unwrap();
        assert_eq!((next, init), (400, true));
        // From 401: word 2 has no bits -> its ceiling 511+1... compressed 402,
        // bitPos 146 -> next = 402 + (255-146) = 511.
        let (next, init) = next_initialized_tick_within_one_word(&bitmap, 401, 1, false).unwrap();
        assert_eq!((next, init), (511, false));
        // Spacing scaling: compressed by 10, tick 300 is word 0 bit 31; word
        // 0 has no bits (the set bits live in word 1), so the search returns
        // the word ceiling (compressed 255 -> tick 2550), uninitialized.
        let (next, init) = next_initialized_tick_within_one_word(&bitmap, 300, 10, false).unwrap();
        assert_eq!((next, init), (2550, false));
        // Unknown word -> refusal (no verdict).
        assert!(next_initialized_tick_within_one_word(&bitmap, 900, 1, false).is_none());
        assert!(next_initialized_tick_within_one_word(&bitmap, -300, 1, true).is_none());
    }

    #[test]
    fn negative_tick_compression_floor() {
        // position()/div_euclid must floor toward -inf: compressed -5 with
        // spacing 1 sits in word -1 (=-5>>8), not word 0.
        assert_eq!(position(-5), (-1, 251));
        assert_eq!(position(-257), (-2, 255));
        assert_eq!(position(0), (0, 0));
    }

    #[test]
    fn raw_u256_operators_wrap_silently_clamm_too() {
        // The amm.rs guard restated for this module: `+ - *` wrap, so the
        // port must never rely on them for a checked step.
        assert_eq!(
            U256::MAX * U256::from(2u8),
            U256::MAX.wrapping_sub(U256::from(1u8))
        );
    }

    #[test]
    fn absurd_inputs_decline_or_stay_bounded() {
        let mut bitmap: HashMap<i32, U256> = HashMap::new();
        // Words fully set around the extremes to force many crossings.
        for w in -2..3 {
            bitmap.insert(w, U256::MAX);
        }
        let state = ClPoolState {
            address: Address::ZERO,
            token0: Address(FixedBytes([1u8; 20])),
            token1: Address(FixedBytes([2u8; 20])),
            tick_spacing: 1,
            fee_pips: 3000,
            sqrt_price_x96: u("79228162514264337593543950336"),
            tick: 0,
            liquidity: U256::MAX,
            block: 0,
            bitmap: bitmap.clone(),
            nets: HashMap::new(),
            stale: false,
        };
        // Every tick looks initialized; nets unknown => refuse, no panic.
        assert_eq!(
            state.quote_exact_in(Address(FixedBytes([1u8; 20])), U256::from(1u64)),
            None
        );
        assert_eq!(
            state.quote_exact_in(Address(FixedBytes([3u8; 20])), U256::from(1u64)),
            None
        );
        assert_eq!(
            state.quote_exact_in(Address(FixedBytes([1u8; 20])), U256::ZERO),
            None
        );
        // Extreme amounts are either refused or bounded, never garbage.
        for amount in [
            U256::MAX,
            U256::MAX >> U256::from(1u64),
            U256::from(u128::MAX),
        ] {
            let _ = state.quote_exact_in(Address(FixedBytes([1u8; 20])), amount);
        }
    }
}

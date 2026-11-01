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
//!
//! # Arithmetic rule: every operator here must be checked
//!
//! `U256`'s `+`, `-` and `*` are implemented with `wrapping_*` and therefore
//! **silently wrap on overflow in every profile**; only `/` and `%` trap, and
//! then only on a zero divisor. A wrapped intermediate is worse than a crash in
//! this module: it is still a number, so it flows into ranking, through the
//! profit gate, and out as a logged opportunity. So all arithmetic below uses
//! `checked_*`, and a `None` here means "local math has no answer", which the
//! scanner treats as *quote it on chain* — never as *this route is unprofitable*.
//! `raw_u256_operators_wrap_silently` pins that premise.

use alloy::primitives::{Address, U256};

/// Fee scale for Aerodrome: `getFee` returns basis points of 10_000.
const AERO_FEE_DENOM: u32 = 10_000;
/// Uniswap V2 keeps 997/1000 of the input (0.30% fee) in `getAmountOut`.
const UNIV2_FEE_NUM: u64 = 997;
const UNIV2_FEE_DEN: u64 = 1_000;
/// Aerodrome's stable curve normalizes both sides into 1e18 space.
const NORM: U256 = U256::from_limbs([1_000_000_000_000_000_000u64, 0, 0, 0]);
/// `ruint` exponentiation is exact up to this `decimals`; above it `10 ** d`
/// overflows `U256`, which is a bad token, not a bad quote.
const MAX_SAFE_DECIMALS: u8 = 77;

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
    let amount_in_with_fee = amount_in.checked_mul(U256::from(UNIV2_FEE_NUM))?;
    let numerator = amount_in_with_fee.checked_mul(reserve_out)?;
    let denominator = reserve_in
        .checked_mul(U256::from(UNIV2_FEE_DEN))?
        .checked_add(amount_in_with_fee)?;
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
    let denominator = reserve_in.checked_add(net_in)?;
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
    let one = NORM;
    let d0 = pool.decimals0;
    let d1 = pool.decimals1;
    if d0.is_zero() || d1.is_zero() {
        return None;
    }
    // Invariant from the pool's *fixed* reserves (never direction-oriented).
    let xy = stable_k(pool.reserve0, pool.reserve1, d0, d1, one)?;
    let n0 = pool.reserve0.checked_mul(one)?.checked_div(d0)?;
    let n1 = pool.reserve1.checked_mul(one)?.checked_div(d1)?;
    // reserveA = side being fed, reserveB = side being drawn.
    let (reserve_a, reserve_b) = if token_in_is_token0 {
        (n0, n1)
    } else {
        (n1, n0)
    };
    let norm_amount_in = if token_in_is_token0 {
        net_in.checked_mul(one)?.checked_div(d0)?
    } else {
        net_in.checked_mul(one)?.checked_div(d1)?
    };
    let x0 = norm_amount_in.checked_add(reserve_a)?;
    let y = stable_get_y(x0, xy, reserve_b, d0, d1, one)?;
    if y > reserve_b {
        return None;
    }
    let out = reserve_b.checked_sub(y)?;
    // Scale the drawn amount back by the output token's decimals.
    let decimals_out = if token_in_is_token0 { d1 } else { d0 };
    out.checked_mul(decimals_out)?.checked_div(one)
}

/// `amountIn - (amountIn * fee_bps / 10000)`, Solidity integer division.
fn subtract_fee_bps(amount_in: U256, fee_bps: u32) -> Option<U256> {
    let fee = amount_in
        .checked_mul(U256::from(fee_bps))?
        .checked_div(U256::from(AERO_FEE_DENOM))?;
    amount_in.checked_sub(fee)
}

/// Pool `_k`: `x^3*y + y^3*x` in 1e18-normalized space.
///
/// The division order here is load-bearing: `(nx*nx)/one + (ny*ny)/one`
/// truncates twice and is *not* equal to `(nx*nx + ny*ny)/one`. Every step is
/// checked only so an absurd input reports "no local quote" instead of
/// panicking; the arithmetic itself is unchanged.
fn stable_k(x: U256, y: U256, decimals0: U256, decimals1: U256, one: U256) -> Option<U256> {
    let nx = x.checked_mul(one)?.checked_div(decimals0)?;
    let ny = y.checked_mul(one)?.checked_div(decimals1)?;
    let a = nx.checked_mul(ny)?.checked_div(one)?;
    let b = nx
        .checked_mul(nx)?
        .checked_div(one)?
        .checked_add(ny.checked_mul(ny)?.checked_div(one)?)?;
    a.checked_mul(b)?.checked_div(one)
}

/// Pool `_f(x0, y)`.
fn stable_f(x0: U256, y: U256, one: U256) -> Option<U256> {
    let a = x0.checked_mul(y)?.checked_div(one)?;
    let b = x0
        .checked_mul(x0)?
        .checked_div(one)?
        .checked_add(y.checked_mul(y)?.checked_div(one)?)?;
    a.checked_mul(b)?.checked_div(one)
}

/// Pool `_d(x0, y)` (the derivative used for the Newton step).
fn stable_d(x0: U256, y: U256, one: U256) -> Option<U256> {
    let three = U256::from(3u8);
    let dy_term = three
        .checked_mul(x0)?
        .checked_mul(y.checked_mul(y)?.checked_div(one)?)?
        .checked_div(one)?;
    let dx_term = x0
        .checked_mul(x0)?
        .checked_div(one)?
        .checked_mul(x0)?
        .checked_div(one)?;
    dy_term.checked_add(dx_term)
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
    let one_unit = U256::from(1u8);
    for _ in 0..255u32 {
        let k = stable_f(x0, y, one)?;
        if k < xy {
            let d = stable_d(x0, y, one)?;
            if d.is_zero() {
                return None;
            }
            let mut dy = ((xy - k) * one) / d;
            if dy.is_zero() {
                if k == xy {
                    return Some(y);
                }
                let bumped = y.checked_add(one_unit)?;
                if stable_k(x0, bumped, decimals0, decimals1, one)? > xy {
                    return Some(bumped);
                }
                dy = one_unit;
            }
            y = y.checked_add(dy)?;
        } else {
            let d = stable_d(x0, y, one)?;
            if d.is_zero() {
                return None;
            }
            let mut dy = ((k - xy) * one) / d;
            if dy.is_zero() {
                if k == xy {
                    return Some(y);
                }
                let lowered = y.checked_sub(one_unit)?;
                if stable_f(x0, lowered, one)? < xy {
                    return Some(y);
                }
                dy = one_unit;
            }
            y = y.checked_sub(dy)?;
        }
    }
    None
}

/// `10 ** decimals` as a `U256`, or `None` when `decimals` is too large to
/// represent. Callers must treat `None` as "this token is not priceable"
/// rather than substituting a default scale, which silently mis-scales every
/// quote that touches it.
pub fn ten_pow(decimals: u8) -> Option<U256> {
    if decimals > MAX_SAFE_DECIMALS {
        return None;
    }
    U256::checked_pow(U256::from(10u64), U256::from(decimals))
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

    /// `10 ** d`, panicking on an unrepresentable `d` (test inputs are fixed).
    fn pow(d: u8) -> U256 {
        ten_pow(d).unwrap()
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
            decimals0: pow(18),
            decimals1: pow(6),
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
            decimals0: pow(18),
            decimals1: pow(6),
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
            decimals0: pow(18),
            decimals1: pow(6),
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
            decimals0: pow(18),
            decimals1: pow(6),
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
            decimals0: pow(18),
            decimals1: pow(6),
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

    // -----------------------------------------------------------------------
    // Provenance for every pinned number in this module
    // -----------------------------------------------------------------------
    // These are `router.getAmountsOut` / `pool.getAmountOut` answers read off
    // Base mainnet state. They cannot be regenerated by this module, which is
    // what makes them evidence rather than a restatement of the formula. To
    // re-derive the table (and the block it belongs to):
    //
    //   anvil --fork-url https://mainnet.base.org --chain-id 8453 --port 8545
    //   cargo run --example capture_pin
    //
    // The block above already covers the `tests/local_math.rs` differential.
    // `0x32e4c40` cases are the earlier single-direction capture; both are kept
    // so a regression against either vintage is caught.

    /// Pool state plus quoted outputs captured at Base block 53371076, for
    /// **both** swap directions.
    struct Pin {
        pool: ConstantProductPool,
        /// `(token_in, amount_in, amount_out)` triples.
        cases: &'static [(&'static str, &'static str, &'static str)],
    }

    fn pool(address: Address, curve: Curve, reserve0: &str, reserve1: &str, fee_bps: u32) -> Pin {
        Pin {
            pool: ConstantProductPool {
                address,
                curve,
                token0: WETH,
                token1: USDC,
                reserve0: u(reserve0),
                reserve1: u(reserve1),
                fee_bps,
                decimals0: pow(18),
                decimals1: pow(6),
            },
            cases: &[],
        }
    }

    const WETH_IN: &str = "4200000000000000000000000000000000000006";
    const USDC_IN: &str = "833589fCD6eDb6E08f4c7C32D4f71b54bdA02913";

    fn pins() -> Vec<Pin> {
        [
            (
                address!("88A43bbDF9D098eEC7bCEda4e2494615dfD9bB9C"),
                Curve::UniV2,
                "332274501113338591906",
                "754915714028",
                0u32,
                &[
                    (USDC_IN, "1", "438827370"),
                    (USDC_IN, "100", "43882737027"),
                    (USDC_IN, "5000", "2194136837176"),
                    (USDC_IN, "1000000000", "438248585401789677"),
                    (USDC_IN, "30000000000", "12663104878779991588"),
                    (USDC_IN, "300000000000", "94290153325322670232"),
                    (WETH_IN, "1000000000000000", "2265141"),
                    (WETH_IN, "1000000000000000000", "2258371821"),
                    (WETH_IN, "5000000000000000000", "11158336005"),
                    (WETH_IN, "30000000000000000000", "62342615261"),
                    (WETH_IN, "100000000000000000000", "174235045111"),
                ][..],
            ),
            (
                address!("cDAC0d6c6C59727a65F871236188350531885C43"),
                Curve::AerodromeVolatile,
                "310886983046483655813",
                "706864506047",
                30,
                &[
                    (USDC_IN, "1", "439811279"),
                    (USDC_IN, "100", "43981127973"),
                    (USDC_IN, "5000", "2192459214318"),
                    (USDC_IN, "1000000000", "437874244395999286"),
                    (USDC_IN, "30000000000", "12620726676347772532"),
                    (USDC_IN, "300000000000", "92434967705370330403"),
                    (WETH_IN, "1000000000000000", "2266874"),
                    (WETH_IN, "1000000000000000000", "2259634834"),
                    (WETH_IN, "5000000000000000000", "11155530568"),
                    (WETH_IN, "30000000000000000000", "62037865437"),
                    (WETH_IN, "100000000000000000000", "171643023677"),
                ][..],
            ),
            (
                // The asymmetric-decimals stable pool: WETH-in exercises the
                // `token_in_is_token0 == true` branch, which the earlier
                // single-direction captures never touched.
                address!("3548029694fbB241D45FB24Ba0cd9c9d4E745f16"),
                Curve::AerodromeStable,
                "1816768450928577779",
                "12363222217",
                5,
                &[
                    (USDC_IN, "1", "440848262"),
                    (USDC_IN, "100", "44084825582"),
                    (USDC_IN, "5000", "2203357836791"),
                    (USDC_IN, "1000000000", "377937443059930710"),
                    (USDC_IN, "30000000000", "1771563181193399707"),
                    (USDC_IN, "300000000000", "1816655642710141575"),
                    (WETH_IN, "1000000000000000", "2266388"),
                    (WETH_IN, "1000000000000000000", "1680707210"),
                    (WETH_IN, "5000000000000000000", "4406057421"),
                    (WETH_IN, "30000000000000000000", "7601749242"),
                    (WETH_IN, "100000000000000000000", "9133097768"),
                ][..],
            ),
        ]
        .into_iter()
        .map(|(address, curve, r0, r1, fee, cases)| {
            let mut pin = pool(address, curve, r0, r1, fee);
            pin.cases = cases;
            pin
        })
        .collect()
    }

    /// Every curve, both directions, against live-Base answers.
    #[test]
    fn pinned_outputs_match_onchain_in_both_directions() {
        let mut checked = 0usize;
        for pin in pins() {
            for (token_in, amount_in, amount_out) in pin.cases {
                let token_in = token_in.parse::<Address>().expect("pin token address");
                let got = pin.pool.amount_out(token_in, u(amount_in));
                assert_eq!(
                    got,
                    Some(u(amount_out)),
                    "{} {token_in} amount_in={amount_in}",
                    pin.pool.address
                );
                checked += 1;
            }
        }
        assert_eq!(checked, 33, "pinned table lost rows");
    }

    /// Overflowing intermediates must mean "no local quote" (the caller then
    /// quotes on-chain). Never a wrapped number: because the operators wrap
    /// silently, an unchecked intermediate would otherwise come back as a
    /// *plausible-looking* price that can rank, gate and get logged.
    #[test]
    fn absurd_inputs_decline_or_stay_bounded() {
        let cases = [
            U256::MAX,
            U256::MAX - U256::from(1u8),
            u("340282366920938463463374607431768211455"), // u128::MAX
            pow(77),
            pow(60),
            U256::from(u128::MAX),
        ];
        let decimals = [pow(1u8), pow(6), pow(18), pow(30)];
        let fees = [0u32, 1, 5, 30, 9_999, 10_000, u32::MAX];
        let mut exercises = 0usize;
        let mut declined = 0usize;
        for curve in [
            Curve::UniV2,
            Curve::AerodromeVolatile,
            Curve::AerodromeStable,
        ] {
            for reserve in [U256::from(1u8), pow(30), U256::MAX] {
                for d0 in &decimals {
                    for d1 in &decimals {
                        for fee in &fees {
                            for amount in &cases {
                                let pool = ConstantProductPool {
                                    address: WETH,
                                    curve,
                                    token0: WETH,
                                    token1: USDC,
                                    reserve0: reserve,
                                    reserve1: reserve,
                                    fee_bps: *fee,
                                    decimals0: *d0,
                                    decimals1: *d1,
                                };
                                let outcome =
                                    std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
                                        pool.amount_out(WETH, *amount)
                                    }));
                                let got = outcome.unwrap_or_else(|_| {
                                    panic!(
                                        "curve {curve:?} amount={amount} reserves={reserve} \
                                         decimals=({d0},{d1}) fee={fee} panicked"
                                    )
                                });
                                if let Some(out) = got {
                                    assert!(
                                        out <= reserve,
                                        "curve {curve:?} amount={amount} reserves={reserve} \
                                         decimals=({d0},{d1}) fee={fee} quoted {out} out of a \
                                         {reserve} side — this is wrapped arithmetic, not a price"
                                    );
                                } else {
                                    declined += 1;
                                }
                                exercises += 1;
                            }
                        }
                    }
                }
            }
        }
        assert!(exercises > 500, "sweep too thin to be a guard: {exercises}");
        assert!(declined > exercises / 2, "{declined}/{exercises} declined");
    }

    /// The guard above only has teeth because the `U256` operators *silently
    /// wrap* on overflow — `+`, `-` and `*` are all implemented in terms of
    /// their `wrapping_*` counterparts, in every profile, and only `/` and `%`
    /// trap (on a zero divisor). A wrapped intermediate is far worse than a
    /// crash here: it is still a number, so it can rank, gate and get logged as
    /// an opportunity. Pin that behaviour so this module's rule against raw
    /// operators stays justified — and so the test above cannot pass vacuously.
    #[test]
    fn raw_u256_operators_wrap_silently() {
        let wrapped = U256::MAX * U256::from(2u8);
        assert!(
            wrapped < U256::MAX,
            "expected a wrapped product, not a panic or a saturating one"
        );
        assert_eq!(
            wrapped,
            U256::MAX - U256::from(1u8),
            "`U256::MAX * 2` must wrap to 2^256-2; if ruint starts trapping, the \
             checked-arithmetic rule in this module can be relaxed"
        );
        assert_eq!(U256::MAX + U256::from(1u8), U256::ZERO);
        assert_eq!(U256::ZERO - U256::from(1u8), U256::MAX);
        // A zero divisor *does* trap, which is why every division below checks.
        assert!(
            std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| U256::from(7u8) / U256::ZERO))
                .is_err(),
            "division by zero is expected to trap; checked_div must be used instead"
        );
    }

    /// A fee at or above the whole input cannot produce a quote, and a fee
    /// outside the 10_000 basis-point scale is rejected rather than priced.
    #[test]
    fn fee_boundaries_decline() {
        for curve in [Curve::AerodromeVolatile, Curve::AerodromeStable] {
            let pool = ConstantProductPool {
                address: WETH,
                curve,
                token0: WETH,
                token1: USDC,
                reserve0: u("310886983046483655813"),
                reserve1: u("706864506047"),
                fee_bps: 10_000,
                decimals0: pow(18),
                decimals1: pow(6),
            };
            assert_eq!(
                pool.amount_out(USDC, pow(6)),
                None,
                "{curve:?}: a 100% fee leaves nothing to swap"
            );
            let pool = ConstantProductPool {
                fee_bps: 20_000,
                ..pool
            };
            assert_eq!(
                pool.amount_out(USDC, pow(6)),
                None,
                "{curve:?}: an over-scale fee must not be priced"
            );
        }
    }

    /// Local pricing must never offer more than the pool holds, and must be
    /// monotonic in the input — ranking assumes both.
    #[test]
    fn output_is_bounded_by_reserve_and_monotonic() {
        for pin in pins() {
            for token_in in [WETH, USDC] {
                let reserve_out = match pin.pool.reserves_for(token_in) {
                    Some((_, out)) => out,
                    None => continue,
                };
                let mut prev = U256::ZERO;
                for shift in 0..45u32 {
                    let amount = U256::from(10u64).pow(U256::from(shift as u64));
                    let Some(out) = pin.pool.amount_out(token_in, amount) else {
                        continue;
                    };
                    assert!(
                        out <= reserve_out,
                        "{} {token_in}: quoted {out} out of a {reserve_out} side",
                        pin.pool.address
                    );
                    assert!(
                        out >= prev,
                        "{} {token_in}: output fell as input grew ({prev} -> {out})",
                        pin.pool.address
                    );
                    prev = out;
                }
            }
        }
    }

    #[test]
    fn ten_pow_covers_tokens_and_refuses_the_unrepresentable() {
        // Real tokens span 0..=18; a hostile `decimals()` answer must not
        // silently become a wrong scale.
        for decimals in 0u8..=18 {
            assert!(ten_pow(decimals).is_some(), "decimals={decimals}");
        }
        assert_eq!(ten_pow(6), Some(u("1000000")));
        assert_eq!(ten_pow(18), Some(u("1000000000000000000")));
        assert_eq!(ten_pow(77).map(|value| value.is_zero()), Some(false));
        assert_eq!(ten_pow(78), None);
        assert_eq!(ten_pow(255), None);
    }
}

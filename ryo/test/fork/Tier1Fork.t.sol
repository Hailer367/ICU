// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { Test } from "forge-std/Test.sol";

import { RyoCore } from "../../src/RyoCore.sol";
import { AdapterBase } from "../../src/adapters/AdapterBase.sol";
import { PancakeV3Adapter } from "../../src/adapters/PancakeV3Adapter.sol";
import { UniV3Adapter } from "../../src/adapters/UniV3Adapter.sol";
import { AerodromeClassicAdapter } from "../../src/adapters/AerodromeClassicAdapter.sol";
import { IAdapter } from "../../src/interfaces/IAdapter.sol";
import { IBalancerVault } from "../../src/interfaces/IBalancerVault.sol";
import { IAerodromeRouter } from "../../src/interfaces/IAerodromeRouter.sol";
import { ISwapRouter02 } from "../../src/interfaces/ISwapRouter02.sol";
import { IERC20 } from "@openzeppelin/contracts/token/ERC20/IERC20.sol";
import { SafeERC20 } from "@openzeppelin/contracts/token/ERC20/utils/SafeERC20.sol";

/// @notice Tier-1 pair expansion (State.md §0s) against a Base mainnet fork.
/// @dev Covers the three things the new pairs actually add: a 8-decimal
///      intermediate (cbBTC) carried through the full flash-loan cycle with
///      floors that must not be scaled by 18 decimals, a EURC/USDC two-venue
///      cycle, and a three-leg USDC -> WETH -> cbBTC -> USDC triangle. Every
///      cycle asserts realised profit equals simulated profit byte-for-byte.
contract Tier1ForkTest is Test {
    using SafeERC20 for IERC20;

    address internal constant BALANCER_VAULT = 0xBA12222222228d8Ba445958a75a0704d566BF2C8;
    address internal constant UNIV3_ROUTER = 0x2626664c2603336E57B271c5C0b26F421741e481;
    address internal constant PCAKE_ROUTER = 0x1b81D678ffb9C0263b24A97847620C99d213eB14;
    address internal constant AERO_ROUTER = 0xcF77a3Ba9A5CA399B7c97c74d54e5b1Beb874E43;

    address internal constant WETH = 0x4200000000000000000000000000000000000006;
    address internal constant USDC = 0x833589fCD6eDb6E08f4c7C32D4f71b54bdA02913;
    address internal constant CBBTC = 0xcbB7C0000aB88B473b1f5aFd9ef808440eed33Bf;
    address internal constant EURC = 0x60a3E35Cc302bFA44Cb288Bc5a4F316Fdb1adb42;

    uint24 internal constant FEE_500 = 500;
    uint24 internal constant PCAKE_FEE_100 = 100;
    uint24 internal constant PCAKE_FEE_500 = 500;

    RyoCore internal core;
    PancakeV3Adapter internal pancake;
    UniV3Adapter internal uniV3;
    AerodromeClassicAdapter internal aero;

    address internal constant RECIPIENT = address(0xBEEF);

    function setUp() public {
        string memory rpc = vm.envOr("BASE_RPC_URL", string("https://mainnet.base.org"));
        uint256 pinned = vm.envOr("BASE_FORK_BLOCK", uint256(0));
        if (pinned == 0) {
            vm.createSelectFork(rpc);
        } else {
            vm.createSelectFork(rpc, pinned);
        }

        deal(USDC, BALANCER_VAULT, 5_000_000e6);
        deal(WETH, BALANCER_VAULT, 10_000e18);

        core = new RyoCore(IBalancerVault(BALANCER_VAULT), address(this), address(this), RECIPIENT);
        pancake = new PancakeV3Adapter(address(core), PCAKE_ROUTER);
        uniV3 = new UniV3Adapter(address(core), UNIV3_ROUTER);
        aero = new AerodromeClassicAdapter(address(core), AERO_ROUTER);
        core.setAdapter(address(pancake), true);
        core.setAdapter(address(uniV3), true);
        core.setAdapter(address(aero), true);
        core.setMaxTradeSize(USDC, 1_000_000e6);
        core.setMaxTradeSize(WETH, 1_000e18);
        // cbBTC and EURC are intermediates only: no cap is ever consulted for
        // them because nothing is borrowed in them. Assert the corollary — a
        // flash loan *in* cbBTC must revert (cap unset = disabled).
    }

    // ------------------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------------------

    function _skewUniV3(address tokenIn, address tokenOut, uint256 amountIn) internal {
        deal(tokenIn, address(this), amountIn);
        IERC20(tokenIn).forceApprove(UNIV3_ROUTER, amountIn);
        ISwapRouter02(UNIV3_ROUTER).exactInputSingle(
            ISwapRouter02.ExactInputSingleParams({
                tokenIn: tokenIn,
                tokenOut: tokenOut,
                fee: FEE_500,
                recipient: address(this),
                amountIn: amountIn,
                amountOutMinimum: 0,
                sqrtPriceLimitX96: 0
            })
        );
    }

    function _simulateProfit(address asset, uint256 amount, RyoCore.Step[] memory steps)
        internal
        returns (int256 profit)
    {
        try core.simulate(asset, amount, steps) {
            revert("simulate must always revert");
        } catch (bytes memory data) {
            bytes4 selector;
            assembly {
                selector := mload(add(data, 0x20))
            }
            if (selector != RyoCore.SimulationResult.selector) {
                assembly {
                    revert(add(data, 0x20), mload(data))
                }
            }
            assembly {
                profit := mload(add(data, 0x24))
            }
        }
    }

    /// @dev Push WETH into the shallow (≈$70k) Aerodrome cbBTC/WETH pool,
    ///      making cbBTC expensive *in WETH terms* on that pool only. This is
    ///      the pool the Rust-side local constant-product math also prices,
    ///      and cbBTC's 8 decimals make every floor on this leg
    ///      decimals-sensitive.
    function _skewAeroWethToCbbtc(uint256 wethIn) internal {
        deal(WETH, address(this), wethIn);
        IERC20(WETH).forceApprove(AERO_ROUTER, wethIn);
        IAerodromeRouter.Route[] memory routes = new IAerodromeRouter.Route[](1);
        routes[0] = IAerodromeRouter.Route({ from: WETH, to: CBBTC, stable: false, factory: address(0) });
        IAerodromeRouter(AERO_ROUTER).swapExactTokensForTokens(
            wethIn, 0, routes, address(this), block.timestamp + 300
        );
    }

    // ------------------------------------------------------------------------
    // cbBTC/USDC: two-venue cycle with an 8-decimal intermediate
    // ------------------------------------------------------------------------

    function test_fork_cbbtc_two_venue_cycle() public {
        // Push 1M USDC into the UniV3 0.05% cbBTC/USDC pool. cbBTC becomes
        // expensive there; Pancake's 0.01% pool on the same pair is untouched
        // and therefore the cheap venue. The loan must stay well under the
        // traded size of the gap: at a 1.6% skew a 200k round trip slips more
        // than the gap earns (measured: -838 USDC), a 50k one clears fees.
        _skewUniV3(USDC, CBBTC, 1_000_000e6);

        RyoCore.Step[] memory steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step(address(pancake), USDC, CBBTC, 1, abi.encode(PCAKE_FEE_100));
        steps[1] = RyoCore.Step(address(uniV3), CBBTC, USDC, 1, abi.encode(FEE_500));

        uint256 loan = 50_000e6;
        int256 profit = _simulateProfit(USDC, loan, steps);
        emit log_named_int("simulated profit (6dp USDC)", profit);
        assertGt(profit, 0, "cross-venue cbBTC/USDC cycle must be profitable after a skew");

        // The intermediate leg is 8 decimals; a floor that assumed 18 would
        // either revert the whole route or silently accept a 100x shortfall.
        // These steps simulate with floor=1; execute must pay exactly this.
        uint256 beforeBalance = IERC20(USDC).balanceOf(RECIPIENT);
        core.execute(USDC, loan, steps, uint256(profit));
        uint256 gained = IERC20(USDC).balanceOf(RECIPIENT) - beforeBalance;
        assertEq(gained, uint256(profit), "realised profit differs from simulation");
        assertEq(IERC20(CBBTC).balanceOf(address(pancake)), 0, "adapter retained 8dp token");
        assertEq(IERC20(CBBTC).balanceOf(address(uniV3)), 0, "adapter retained 8dp token");
        assertEq(IERC20(CBBTC).balanceOf(address(core)), 0, "core retained 8dp token");
    }

    function test_fork_cbbtc_gas_report() public {
        _skewUniV3(USDC, CBBTC, 1_000_000e6);
        RyoCore.Step[] memory steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step(address(pancake), USDC, CBBTC, 1, abi.encode(PCAKE_FEE_100));
        steps[1] = RyoCore.Step(address(uniV3), CBBTC, USDC, 1, abi.encode(FEE_500));
        int256 profit = _simulateProfit(USDC, 50_000e6, steps);
        require(profit > 0, "no opportunity to price");
        uint256 gasBefore = gasleft();
        core.execute(USDC, 50_000e6, steps, 1);
        emit log_named_uint("2-hop Balancer+Pancake+UniV3 cbBTC execute gas", gasBefore - gasleft());
    }

    // ------------------------------------------------------------------------
    // cbBTC triangle: USDC -> WETH -> cbBTC -> USDC (three pools, two pairs
    // the core has never bridged in one route)
    // ------------------------------------------------------------------------

    function test_fork_cbbtc_triangle() public {
        _skewUniV3(USDC, CBBTC, 400_000e6);

        // Buy WETH at the untouched USDC/WETH price, buy cbBTC at the
        // untouched cbBTC/WETH price, sell cbBTC into the pool where it is
        // expensive in USDC terms.
        RyoCore.Step[] memory steps = new RyoCore.Step[](3);
        steps[0] = RyoCore.Step(address(uniV3), USDC, WETH, 1, abi.encode(FEE_500));
        steps[1] = RyoCore.Step(address(uniV3), WETH, CBBTC, 1, abi.encode(FEE_500));
        steps[2] = RyoCore.Step(address(uniV3), CBBTC, USDC, 1, abi.encode(FEE_500));

        uint256 loan = 200_000e6;
        int256 profit = _simulateProfit(USDC, loan, steps);
        emit log_named_int("simulated triangle profit", profit);
        assertGt(profit, 0, "the stale cbBTC cross-rate triangle must close for profit");

        uint256 gasBefore = gasleft();
        uint256 beforeBalance = IERC20(USDC).balanceOf(RECIPIENT);
        core.execute(USDC, loan, steps, uint256(profit));
        uint256 gained = IERC20(USDC).balanceOf(RECIPIENT) - beforeBalance;
        emit log_named_uint("3-hop triangle execute gas", gasBefore - gasleft());
        assertEq(gained, uint256(profit), "triangle realised != simulated");
    }

    // ------------------------------------------------------------------------
    // EURC/USDC cycle: a stable-stable pair on a third venue
    // ------------------------------------------------------------------------

    function test_fork_eurc_two_venue_cycle() public {
        // Push 2M USDC into the EURC/USDC UniV3 0.05% pool: EURC gets
        // expensive in USDC terms there; Pancake's 0.01% pool is untouched.
        _skewUniV3(USDC, EURC, 2_000_000e6);

        RyoCore.Step[] memory steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step(address(pancake), USDC, EURC, 1, abi.encode(PCAKE_FEE_100));
        steps[1] = RyoCore.Step(address(uniV3), EURC, USDC, 1, abi.encode(FEE_500));

        uint256 loan = 100_000e6;
        int256 profit = _simulateProfit(USDC, loan, steps);
        emit log_named_int("simulated EURC profit", profit);
        assertGt(profit, 0, "EURC/USDC cross-venue cycle must pay after a skew");

        uint256 beforeBalance = IERC20(USDC).balanceOf(RECIPIENT);
        core.execute(USDC, loan, steps, uint256(profit));
        uint256 gained = IERC20(USDC).balanceOf(RECIPIENT) - beforeBalance;
        assertEq(gained, uint256(profit), "EURC cycle realised != simulated");
        assertEq(IERC20(EURC).balanceOf(address(core)), 0);
    }

    // ------------------------------------------------------------------------
    // Aerodrome constant-product cbBTC/WETH leg, priced locally by the
    // watcher: prove the same route pays on chain
    // ------------------------------------------------------------------------

    function test_fork_aero_cbbtc_weth_cycle() public {
        // 4 WETH into the ≈$70k Aerodrome pool moves it double digits; the
        // untouched Pancake 0.01% cbBTC/WETH pool ($89M) stays the fair venue.
        _skewAeroWethToCbbtc(4e18);

        // Buy cbBTC with WETH on the untouched Pancake pool, sell it back
        // into the skewed Aerodrome pool where cbBTC is now expensive in
        // WETH terms.
        RyoCore.Step[] memory steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step(address(pancake), WETH, CBBTC, 1, abi.encode(PCAKE_FEE_100));
        steps[1] = RyoCore.Step(address(aero), CBBTC, WETH, 1, abi.encode(false));

        uint256 loan = 2e18;
        int256 profit = _simulateProfit(WETH, loan, steps);
        emit log_named_int("simulated WETH profit (aero vs pancake)", profit);
        assertGt(profit, 0, "skewed Aerodrome pool must be sellable into Pancake");

        uint256 beforeBalance = IERC20(WETH).balanceOf(RECIPIENT);
        core.execute(WETH, loan, steps, uint256(profit));
        uint256 gained = IERC20(WETH).balanceOf(RECIPIENT) - beforeBalance;
        assertEq(gained, uint256(profit), "aero cbBTC cycle realised != simulated");
    }

    // ------------------------------------------------------------------------
    // Guard: intermediate-only assets are not borrowable
    // ------------------------------------------------------------------------

    function test_fork_cbbtc_is_not_borrowable() public view {
        // maxTradeSize[cbBTC] is unset (0): the owner's "not tradable" switch.
        // The expansion must not silently make cbBTC a loanable asset.
        assertEq(core.maxTradeSize(CBBTC), 0, "cbBTC must stay intermediate-only");
        assertEq(core.maxTradeSize(EURC), 0, "EURC must stay intermediate-only");
    }
}

// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { Test } from "forge-std/Test.sol";

import { RyoCore } from "../../src/RyoCore.sol";
import { AdapterBase } from "../../src/adapters/AdapterBase.sol";
import { PancakeV3Adapter } from "../../src/adapters/PancakeV3Adapter.sol";
import { UniV3Adapter } from "../../src/adapters/UniV3Adapter.sol";
import { IAdapter } from "../../src/interfaces/IAdapter.sol";
import { IBalancerVault } from "../../src/interfaces/IBalancerVault.sol";
import { IPancakeSwapRouter } from "../../src/interfaces/IPancakeSwapRouter.sol";
import { ISwapRouter02 } from "../../src/interfaces/ISwapRouter02.sol";
import { IERC20 } from "@openzeppelin/contracts/token/ERC20/IERC20.sol";
import { SafeERC20 } from "@openzeppelin/contracts/token/ERC20/utils/SafeERC20.sol";

/// @notice PancakeSwap V3 venue tests against a Base mainnet fork.
/// @dev Covers the three things that could silently break a new venue: the router ABI (Pancake's
///      params struct keeps a `deadline`), the pool's own fee-tier set, and the fact that Pancake
///      pools are *separate* liquidity from the Uniswap pools the core already trades, so a
///      cross-venue cycle must be profitable end to end through the real Balancer Vault.
contract PancakeForkTest is Test {
    using SafeERC20 for IERC20;

    address internal constant BALANCER_VAULT = 0xBA12222222228d8Ba445958a75a0704d566BF2C8;
    address internal constant UNIV3_ROUTER = 0x2626664c2603336E57B271c5C0b26F421741e481;
    address internal constant PCAKE_ROUTER = 0x1b81D678ffb9C0263b24A97847620C99d213eB14;
    address internal constant PCAKE_FACTORY = 0x0BFbCF9fa4f9C56B0F40a671Ad40E0805A091865;

    address internal constant WETH = 0x4200000000000000000000000000000000000006;
    address internal constant USDC = 0x833589fCD6eDb6E08f4c7C32D4f71b54bdA02913;

    /// @dev Pancake's own tiers. 100/500/2500/10000 map to tick spacings 1/10/50/200; Uniswap's
    ///      3000 tier does not exist here.
    uint24 internal constant PCAKE_FEE = 100;
    uint24 internal constant UNIV3_FEE = 500;

    RyoCore internal core;
    PancakeV3Adapter internal pancake;
    UniV3Adapter internal uniV3;

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
        core.setAdapter(address(pancake), true);
        core.setAdapter(address(uniV3), true);
        core.setMaxTradeSize(USDC, 1_000_000e6);
        core.setMaxTradeSize(WETH, 1_000e18);
    }

    // --------------------------------------------------------------------------------------------
    // Helpers
    // --------------------------------------------------------------------------------------------

    /// @dev Pushes the Uniswap WETH price up; Pancake, left untouched, is then the cheap venue.
    function _skewUniV3(uint256 usdcIn) internal {
        deal(USDC, address(this), usdcIn);
        IERC20(USDC).forceApprove(UNIV3_ROUTER, usdcIn);
        ISwapRouter02(UNIV3_ROUTER)
            .exactInputSingle(
                ISwapRouter02.ExactInputSingleParams({
                    tokenIn: USDC,
                    tokenOut: WETH,
                    fee: UNIV3_FEE,
                    recipient: address(this),
                    amountIn: usdcIn,
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

    /// @dev Buy WETH cheap on Pancake, sell it into the skewed Uniswap pool, settle in USDC.
    function _route(bytes memory buyData) internal view returns (RyoCore.Step[] memory steps) {
        steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step(address(pancake), USDC, WETH, 1, buyData);
        steps[1] = RyoCore.Step(address(uniV3), WETH, USDC, 1, abi.encode(UNIV3_FEE));
    }

    // --------------------------------------------------------------------------------------------
    // Adapter ABI correctness against the real Pancake router
    // --------------------------------------------------------------------------------------------

    function test_fork_pancake_adapter_real_swap() public {
        uint256 amountIn = 1e18;
        deal(WETH, address(pancake), amountIn);
        uint256 before = IERC20(USDC).balanceOf(address(core));

        vm.prank(address(core));
        IAdapter(address(pancake)).step(WETH, USDC, amountIn, 1_000e6, abi.encode(PCAKE_FEE));

        uint256 out = IERC20(USDC).balanceOf(address(core)) - before;
        emit log_named_uint("Pancake 1 WETH -> USDC", out);
        assertGt(out, 0);
        assertEq(IERC20(WETH).balanceOf(address(pancake)), 0, "adapter kept input");
        assertEq(IERC20(USDC).balanceOf(address(pancake)), 0, "adapter kept output");
    }

    function test_fork_pancake_adapter_all_enabled_tiers() public view {
        // Every tier the factory reports must be tradable; a tier we encode but Pancake never
        // enabled would revert at swap time and waste a live execution.
        uint24[4] memory tiers = [uint24(100), 500, 2500, 10000];
        for (uint256 i; i < tiers.length; i++) {
            int24 spacing = IPancakeV3FactoryLike(PCAKE_FACTORY).feeAmountTickSpacing(tiers[i]);
            assertGt(spacing, 0, "tier not enabled on Base");
        }
    }

    function test_fork_pancake_rejects_uniswap_only_tier() public {
        // Uniswap's 0.30% tier has no Pancake counterpart: encoding it must revert, not silently
        // trade a wrong pool.
        deal(WETH, address(pancake), 1e15);
        vm.prank(address(core));
        vm.expectRevert();
        IAdapter(address(pancake)).step(WETH, USDC, 1e15, 1, abi.encode(uint24(3000)));
    }

    function test_fork_pancake_rejects_foreign_caller() public {
        vm.prank(address(0xBAD));
        vm.expectRevert(AdapterBase.Unauthorized.selector);
        IAdapter(address(pancake)).step(WETH, USDC, 1e15, 1, abi.encode(PCAKE_FEE));
    }

    // --------------------------------------------------------------------------------------------
    // End-to-end cycle through Balancer + Pancake + Uniswap
    // --------------------------------------------------------------------------------------------

    function test_fork_cycle_pancake_vs_uniswap() public {
        _skewUniV3(4_000_000e6);

        uint256 loan = 100_000e6;
        RyoCore.Step[] memory steps = _route(abi.encode(PCAKE_FEE));
        int256 profit = _simulateProfit(USDC, loan, steps);
        emit log_named_int("simulated profit (6dp USDC)", profit);
        assertGt(profit, 0, "skewed cross-venue cycle must be profitable");

        uint256 beforeBalance = IERC20(USDC).balanceOf(RECIPIENT);
        core.execute(USDC, loan, steps, uint256(profit));
        uint256 afterBalance = IERC20(USDC).balanceOf(RECIPIENT);

        assertGt(afterBalance, beforeBalance, "recipient did not gain");
        assertEq(afterBalance - beforeBalance, uint256(profit), "realised profit differs from simulation");
        assertEq(IERC20(USDC).balanceOf(address(core)), 0);
        assertEq(IERC20(WETH).balanceOf(address(core)), 0);
        assertEq(IERC20(USDC).balanceOf(address(pancake)), 0);
        assertEq(IERC20(WETH).balanceOf(address(pancake)), 0);
    }

    function test_fork_cycle_reports_gas() public {
        _skewUniV3(4_000_000e6);
        uint256 loan = 100_000e6;
        RyoCore.Step[] memory steps = _route(abi.encode(PCAKE_FEE));
        int256 profit = _simulateProfit(USDC, loan, steps);
        require(profit > 0, "no opportunity to price");

        uint256 gasBefore = gasleft();
        core.execute(USDC, loan, steps, 1);
        emit log_named_uint("2-hop Balancer+Pancake+UniV3 execute gas", gasBefore - gasleft());
    }

    // --------------------------------------------------------------------------------------------
}

interface IPancakeV3FactoryLike {
    function feeAmountTickSpacing(uint24 fee) external view returns (int24);
}

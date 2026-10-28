// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { Test } from "forge-std/Test.sol";

import { RyoCore } from "../../src/RyoCore.sol";
import { AerodromeClassicAdapter } from "../../src/adapters/AerodromeClassicAdapter.sol";
import { SlipstreamAdapter } from "../../src/adapters/SlipstreamAdapter.sol";
import { UniV2Adapter } from "../../src/adapters/UniV2Adapter.sol";
import { UniV3Adapter } from "../../src/adapters/UniV3Adapter.sol";
import { IAdapter } from "../../src/interfaces/IAdapter.sol";
import { IBalancerVault } from "../../src/interfaces/IBalancerVault.sol";
import { IERC20 } from "@openzeppelin/contracts/token/ERC20/IERC20.sol";
import { SafeERC20 } from "@openzeppelin/contracts/token/ERC20/utils/SafeERC20.sol";
import { IMulticall3 } from "../../src/interfaces/IMulticall3.sol";
import { ISwapRouter02 } from "../../src/interfaces/ISwapRouter02.sol";

/// @notice End-to-end tests against a Base mainnet fork. No real funds or gas are spent: all
///         token balances are cheat-code funded, and the fork is a local copy of chain state.
/// @dev Each test manufactures its own arbitrage opportunity by swapping into the real Uniswap V3
///      pool, then lets the core capture it through real Balancer + real venue routers. This keeps
///      the result deterministic instead of depending on a live opportunity existing.
contract RyoForkTest is Test {
    using SafeERC20 for IERC20;

    // --- Base mainnet addresses -------------------------------------------------------------
    address internal constant BALANCER_VAULT = 0xBA12222222228d8Ba445958a75a0704d566BF2C8;
    address internal constant UNIV3_ROUTER = 0x2626664c2603336E57B271c5C0b26F421741e481;
    address internal constant UNIV2_ROUTER = 0x4752ba5DBc23f44D87826276BF6Fd6b1C372aD24;
    address internal constant AERO_ROUTER = 0xcF77a3Ba9A5CA399B7c97c74d54e5b1Beb874E43;
    address internal constant SLIP_ROUTER = 0xBE6D8f0d05cC4be24d5167a3eF062215bE6D18a5;
    address internal constant MULTICALL3 = 0xcA11bde05977b3631167028862bE2a173976CA11;

    address internal constant WETH = 0x4200000000000000000000000000000000000006;
    address internal constant USDC = 0x833589fCD6eDb6E08f4c7C32D4f71b54bdA02913;

    uint24 internal constant UNIV3_FEE = 500;
    int24 internal constant SLIP_TICK_SPACING = 100;

    // --- System under test ------------------------------------------------------------------
    RyoCore internal core;
    UniV3Adapter internal uniV3;
    UniV2Adapter internal uniV2;
    AerodromeClassicAdapter internal aerodrome;
    SlipstreamAdapter internal slipstream;

    address internal constant RECIPIENT = address(0xBEEF);
    address internal constant STRANGER = address(0xBAD);

    uint256 internal constant SKEW = 1_500_000e6;

    function setUp() public {
        string memory rpc = vm.envOr("BASE_RPC_URL", string("https://mainnet.base.org"));
        uint256 pinned = vm.envOr("BASE_FORK_BLOCK", uint256(0));
        if (pinned == 0) {
            vm.createSelectFork(rpc);
        } else {
            vm.createSelectFork(rpc, pinned);
        }

        // Make sure the real Vault can service the loans used below, even if its live balance is
        // lower at the selected block. This only changes the local fork.
        deal(USDC, BALANCER_VAULT, 5_000_000e6);
        deal(WETH, BALANCER_VAULT, 10_000e18);

        core = new RyoCore(IBalancerVault(BALANCER_VAULT), address(this), address(this), RECIPIENT);
        uniV3 = new UniV3Adapter(address(core), UNIV3_ROUTER);
        uniV2 = new UniV2Adapter(address(core), UNIV2_ROUTER);
        aerodrome = new AerodromeClassicAdapter(address(core), AERO_ROUTER);
        slipstream = new SlipstreamAdapter(address(core), SLIP_ROUTER);

        core.setAdapter(address(uniV3), true);
        core.setAdapter(address(uniV2), true);
        core.setAdapter(address(aerodrome), true);
        core.setAdapter(address(slipstream), true);

        core.setMaxTradeSize(USDC, 100_000e6);
        core.setMaxTradeSize(WETH, 100e18);
    }

    // --------------------------------------------------------------------------------------------
    // Helpers
    // --------------------------------------------------------------------------------------------

    /// @dev Pushes the real Uniswap V3 WETH/USDC price up by buying WETH with fresh USDC.
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

    function _simulateProfit(RyoCore.Step[] memory steps, uint256 amount)
        internal
        returns (int256 profit)
    {
        try core.simulate(USDC, amount, steps) {
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

    function _route(address buyAdapter, bytes memory buyData)
        internal
        view
        returns (RyoCore.Step[] memory steps)
    {
        steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step(buyAdapter, USDC, WETH, 1, buyData);
        steps[1] = RyoCore.Step(address(uniV3), WETH, USDC, 1, abi.encode(UNIV3_FEE));
    }

    function _assertClean() internal view {
        assertEq(IERC20(USDC).balanceOf(address(core)), 0);
        assertEq(IERC20(WETH).balanceOf(address(core)), 0);
        assertEq(IERC20(USDC).balanceOf(address(uniV3)), 0);
        assertEq(IERC20(WETH).balanceOf(address(uniV3)), 0);
        assertEq(IERC20(USDC).balanceOf(address(uniV2)), 0);
        assertEq(IERC20(WETH).balanceOf(address(uniV2)), 0);
        assertEq(IERC20(USDC).balanceOf(address(aerodrome)), 0);
        assertEq(IERC20(WETH).balanceOf(address(aerodrome)), 0);
        assertEq(IERC20(USDC).balanceOf(address(slipstream)), 0);
        assertEq(IERC20(WETH).balanceOf(address(slipstream)), 0);
    }

    // --------------------------------------------------------------------------------------------
    // Adapter ABI correctness against the real routers
    // --------------------------------------------------------------------------------------------

    function _exerciseAdapter(
        address adapter,
        address tokenIn,
        address tokenOut,
        uint256 amountIn,
        uint256 minOut,
        bytes memory data
    ) internal returns (uint256 out) {
        deal(tokenIn, adapter, amountIn);
        uint256 before = IERC20(tokenOut).balanceOf(address(core));

        vm.prank(address(core));
        IAdapter(adapter).step(tokenIn, tokenOut, amountIn, minOut, data);

        out = IERC20(tokenOut).balanceOf(address(core)) - before;
        assertGe(out, minOut);
        assertEq(IERC20(tokenIn).balanceOf(adapter), 0);
        assertEq(IERC20(tokenOut).balanceOf(adapter), 0);
    }

    function test_fork_uniV3_adapter_real_swap() public {
        uint256 out =
            _exerciseAdapter(address(uniV3), WETH, USDC, 1e18, 1_000e6, abi.encode(UNIV3_FEE));
        emit log_named_uint("UniV3 1 WETH -> USDC", out);
        assertGt(out, 1_000e6);
    }

    function test_fork_uniV2_adapter_real_swap() public {
        uint256 out = _exerciseAdapter(address(uniV2), WETH, USDC, 0.5e18, 500e6, "");
        emit log_named_uint("UniV2 0.5 WETH -> USDC", out);
        assertGt(out, 500e6);
    }

    function test_fork_aerodrome_adapter_real_swap() public {
        uint256 out =
            _exerciseAdapter(address(aerodrome), WETH, USDC, 1e18, 1_000e6, abi.encode(false));
        emit log_named_uint("Aerodrome 1 WETH -> USDC", out);
        assertGt(out, 1_000e6);
    }

    function test_fork_slipstream_adapter_real_swap() public {
        uint256 out = _exerciseAdapter(
            address(slipstream), USDC, WETH, 1_000e6, 0.1e18, abi.encode(SLIP_TICK_SPACING)
        );
        emit log_named_uint("Slipstream 1,000 USDC -> WETH", out);
        assertGt(out, 0.1e18);
    }

    // --------------------------------------------------------------------------------------------
    // Full flash-loan arbitrage through the real Balancer Vault
    // --------------------------------------------------------------------------------------------

    function test_fork_core_arbitrage_aerodrome_to_univ3() public {
        _skewUniV3(SKEW);
        RyoCore.Step[] memory steps = _route(address(aerodrome), abi.encode(false));

        int256 simulated = _simulateProfit(steps, 15_000e6);
        emit log_named_int("simulated profit (USDC, 6dp)", simulated);
        assertGt(simulated, 0);

        uint256 recipientBefore = IERC20(USDC).balanceOf(RECIPIENT);
        uint256 gasBefore = gasleft();
        uint256 profit = core.execute(USDC, 15_000e6, steps, uint256(simulated));
        uint256 gasUsed = gasBefore - gasleft();

        emit log_named_uint("executed profit (USDC, 6dp)", profit);
        emit log_named_uint("execute gas", gasUsed);

        assertEq(profit, uint256(simulated));
        assertEq(IERC20(USDC).balanceOf(RECIPIENT) - recipientBefore, profit);
        assertGe(IERC20(USDC).balanceOf(BALANCER_VAULT), 5_000_000e6);
        assertLt(gasUsed, 700_000);
        _assertClean();
    }

    function test_fork_core_arbitrage_slipstream_to_univ3() public {
        _skewUniV3(SKEW);
        RyoCore.Step[] memory steps = _route(address(slipstream), abi.encode(SLIP_TICK_SPACING));

        int256 simulated = _simulateProfit(steps, 20_000e6);
        emit log_named_int("simulated profit (USDC, 6dp)", simulated);
        assertGt(simulated, 0);

        uint256 profit = core.execute(USDC, 20_000e6, steps, uint256(simulated));

        emit log_named_uint("executed profit (USDC, 6dp)", profit);
        assertEq(profit, uint256(simulated));
        assertGe(IERC20(USDC).balanceOf(BALANCER_VAULT), 5_000_000e6);
        _assertClean();
    }

    function test_fork_core_arbitrage_univ2_to_univ3() public {
        _skewUniV3(SKEW);
        RyoCore.Step[] memory steps = _route(address(uniV2), "");

        int256 simulated = _simulateProfit(steps, 5_000e6);
        emit log_named_int("simulated profit (USDC, 6dp)", simulated);
        assertGt(simulated, 0);

        uint256 profit = core.execute(USDC, 5_000e6, steps, uint256(simulated));

        emit log_named_uint("executed profit (USDC, 6dp)", profit);
        assertEq(profit, uint256(simulated));
        _assertClean();
    }

    // --------------------------------------------------------------------------------------------
    // Core safety and operations on the fork
    // --------------------------------------------------------------------------------------------

    function test_fork_simulate_is_permissionless_and_matches() public {
        _skewUniV3(SKEW);
        RyoCore.Step[] memory steps = _route(address(aerodrome), abi.encode(false));

        vm.prank(STRANGER);
        int256 simulated = _simulateProfit(steps, 15_000e6);
        assertGt(simulated, 0);

        uint256 profit = core.execute(USDC, 15_000e6, steps, 0);
        assertEq(profit, uint256(simulated));
    }

    function test_fork_multicall3_batches_simulations() public {
        _skewUniV3(SKEW);

        IMulticall3.Call3[] memory calls = new IMulticall3.Call3[](2);
        calls[0] = IMulticall3.Call3({
            target: address(core),
            allowFailure: true,
            callData: abi.encodeCall(
                RyoCore.simulate, (USDC, 15_000e6, _route(address(aerodrome), abi.encode(false)))
            )
        });
        calls[1] = IMulticall3.Call3({
            target: address(core),
            allowFailure: true,
            callData: abi.encodeCall(
                RyoCore.simulate,
                (USDC, 20_000e6, _route(address(slipstream), abi.encode(SLIP_TICK_SPACING)))
            )
        });

        IMulticall3.Result[] memory results = IMulticall3(MULTICALL3).aggregate3(calls);

        assertFalse(results[0].success);
        assertFalse(results[1].success);

        int256 p0 = _decodeSimulation(results[0].returnData);
        int256 p1 = _decodeSimulation(results[1].returnData);
        emit log_named_int("multicall aerodrome profit", p0);
        emit log_named_int("multicall slipstream profit", p1);
        assertGt(p0, 0);
        assertGt(p1, 0);
    }

    function test_fork_losing_route_reverts_and_keeps_vault_whole() public {
        RyoCore.Step[] memory steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step(address(uniV3), USDC, WETH, 1, abi.encode(UNIV3_FEE));
        steps[1] = RyoCore.Step(address(uniV3), WETH, USDC, 1, abi.encode(UNIV3_FEE));

        uint256 vaultBefore = IERC20(USDC).balanceOf(BALANCER_VAULT);

        vm.expectRevert();
        core.execute(USDC, 1_000e6, steps, 0);

        assertEq(IERC20(USDC).balanceOf(BALANCER_VAULT), vaultBefore);
        assertEq(IERC20(USDC).balanceOf(address(core)), 0);
    }

    function test_fork_pause_blocks_execute_but_not_simulate() public {
        _skewUniV3(SKEW);
        RyoCore.Step[] memory steps = _route(address(aerodrome), abi.encode(false));

        core.pause();

        vm.expectRevert(RyoCore.ContractPaused.selector);
        core.execute(USDC, 15_000e6, steps, 0);

        int256 simulated = _simulateProfit(steps, 15_000e6);
        assertGt(simulated, 0);
    }

    function test_fork_trade_cap_is_enforced_before_borrowing() public {
        core.setMaxTradeSize(USDC, 1_000e6);

        RyoCore.Step[] memory steps = _route(address(aerodrome), abi.encode(false));

        vm.expectRevert(
            abi.encodeWithSelector(RyoCore.TradeTooLarge.selector, USDC, 2_000e6, 1_000e6)
        );
        core.execute(USDC, 2_000e6, steps, 0);
    }

    function test_fork_non_operator_cannot_execute() public {
        _skewUniV3(SKEW);
        RyoCore.Step[] memory steps = _route(address(aerodrome), abi.encode(false));

        vm.prank(STRANGER);
        vm.expectRevert(abi.encodeWithSelector(RyoCore.NotOperator.selector, STRANGER));
        core.execute(USDC, 15_000e6, steps, 0);
    }

    function test_fork_dust_is_preserved_and_cannot_subsidize() public {
        _skewUniV3(SKEW);
        deal(USDC, address(core), 1_000e6); // pre-existing dust

        RyoCore.Step[] memory steps = _route(address(aerodrome), abi.encode(false));
        int256 simulated = _simulateProfit(steps, 15_000e6);

        uint256 recipientBefore = IERC20(USDC).balanceOf(RECIPIENT);
        uint256 profit = core.execute(USDC, 15_000e6, steps, 0);

        assertEq(profit, uint256(simulated));
        assertEq(IERC20(USDC).balanceOf(RECIPIENT) - recipientBefore, profit);
        assertEq(IERC20(USDC).balanceOf(address(core)), 1_000e6);

        core.sweep(USDC, RECIPIENT);
        assertEq(IERC20(USDC).balanceOf(address(core)), 0);
        assertEq(IERC20(USDC).balanceOf(RECIPIENT), recipientBefore + profit + 1_000e6);
    }

    // --------------------------------------------------------------------------------------------
    // Decoding
    // --------------------------------------------------------------------------------------------

    function _decodeSimulation(bytes memory returnData) internal pure returns (int256 profit) {
        require(returnData.length == 36, "unexpected return data length");
        bytes4 selector;
        assembly {
            selector := mload(add(returnData, 0x20))
            profit := mload(add(returnData, 0x24))
        }
        require(selector == RyoCore.SimulationResult.selector, "not a simulation result");
    }
}


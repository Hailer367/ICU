// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { Ownable } from "@openzeppelin/contracts/access/Ownable.sol";
import { IERC20 } from "@openzeppelin/contracts/token/ERC20/IERC20.sol";

import { RyoCore } from "../src/RyoCore.sol";
import { IAdapter } from "../src/interfaces/IAdapter.sol";
import { IBalancerVault } from "../src/interfaces/IBalancerVault.sol";

import { BaseTest } from "./BaseTest.sol";
import { FakeVault } from "./mocks/FakeVault.sol";
import { MockAdapter } from "./mocks/MockAdapter.sol";
import { MockBalancerVault } from "./mocks/MockBalancerVault.sol";
import { MockERC20 } from "./mocks/MockERC20.sol";
import { MockFeeERC20 } from "./mocks/MockFeeERC20.sol";
import { MockSoftERC20 } from "./mocks/MockSoftERC20.sol";
import { ReentrantAdapter } from "./mocks/ReentrantAdapter.sol";
import { RyoHarness } from "./harness/RyoHarness.sol";

contract RyoSecurityTest is BaseTest {
    uint256 internal constant AMOUNT = 100e18;

    // ---------------------------------------------------------------------------------------------
    // Route validation
    // ---------------------------------------------------------------------------------------------

    function _oneStep(address adapter, address tokenIn, address tokenOut)
        internal
        pure
        returns (RyoCore.Step[] memory steps)
    {
        steps = new RyoCore.Step[](1);
        steps[0] = RyoCore.Step(adapter, tokenIn, tokenOut, 1, "");
    }

    function test_route_empty_reverts() public {
        RyoCore.Step[] memory steps = new RyoCore.Step[](0);
        vm.expectRevert(RyoCore.RouteTooShort.selector);
        core.execute(address(tokenA), 1e18, steps, 0);
    }

    function test_route_one_step_reverts() public {
        RyoCore.Step[] memory steps = _oneStep(address(adapterA), address(tokenA), address(tokenB));
        vm.expectRevert(RyoCore.RouteTooShort.selector);
        core.execute(address(tokenA), 1e18, steps, 0);
    }

    function test_route_too_long_reverts() public {
        RyoCore.Step[] memory steps = _alternatingSteps(9);
        vm.expectRevert(abi.encodeWithSelector(RyoCore.RouteTooLong.selector, 9));
        core.execute(address(tokenA), 1e18, steps, 0);
    }

    function test_route_max_steps_works() public {
        adapterA.setRateBps(10_000);
        adapterB.setRateBps(10_000);
        RyoCore.Step[] memory steps = _alternatingSteps(8);

        uint256 profit = core.execute(address(tokenA), 10e18, steps, 0);

        assertEq(profit, 0);
        assertEq(tokenA.balanceOf(address(core)), 0);
        assertEq(tokenA.balanceOf(address(vault)), INITIAL_VAULT_BALANCE);
    }

    function test_route_first_token_mismatch() public {
        RyoCore.Step[] memory steps = _steps();
        steps[0].tokenIn = address(tokenB);
        steps[0].tokenOut = address(tokenA);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.RouteMismatch.selector, 0));
        core.execute(address(tokenA), 1e18, steps, 0);
    }

    function test_route_broken_chain() public {
        RyoCore.Step[] memory steps = _steps();
        steps[1].tokenIn = address(tokenA);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.RouteMismatch.selector, 1));
        core.execute(address(tokenA), 1e18, steps, 0);
    }

    function test_route_final_token_mismatch() public {
        RyoCore.Step[] memory steps = new RyoCore.Step[](3);
        steps[0] = RyoCore.Step(address(adapterA), address(tokenA), address(tokenB), 1, "");
        steps[1] = RyoCore.Step(address(adapterB), address(tokenB), address(tokenA), 1, "");
        steps[2] = RyoCore.Step(address(adapterA), address(tokenA), address(tokenB), 1, "");

        vm.expectRevert(abi.encodeWithSelector(RyoCore.RouteMismatch.selector, 3));
        core.execute(address(tokenA), 1e18, steps, 0);
    }

    function test_route_zero_token_reverts() public {
        RyoCore.Step[] memory steps = _steps();
        steps[0].tokenOut = address(0);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.InvalidStep.selector, 0));
        core.execute(address(tokenA), 1e18, steps, 0);
    }

    function test_route_same_token_reverts() public {
        RyoCore.Step[] memory steps = _steps();
        steps[0].tokenOut = address(tokenA);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.InvalidStep.selector, 0));
        core.execute(address(tokenA), 1e18, steps, 0);
    }

    function test_route_zero_min_out_reverts() public {
        RyoCore.Step[] memory steps = _steps();
        steps[0].minAmountOut = 0;

        vm.expectRevert(abi.encodeWithSelector(RyoCore.InvalidMinOut.selector, 0));
        core.execute(address(tokenA), 1e18, steps, 0);
    }

    function test_route_zero_adapter_reverts() public {
        RyoCore.Step[] memory steps = _steps();
        steps[0].adapter = address(0);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.AdapterNotAllowed.selector, address(0)));
        core.execute(address(tokenA), 1e18, steps, 0);
    }

    function test_route_unlisted_adapter_reverts() public {
        MockAdapter rogue = new MockAdapter(address(core));
        RyoCore.Step[] memory steps = _steps();
        steps[0].adapter = address(rogue);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.AdapterNotAllowed.selector, address(rogue)));
        core.execute(address(tokenA), 1e18, steps, 0);
    }

    function test_zero_asset_and_amount_revert() public {
        vm.expectRevert(RyoCore.ZeroAddress.selector);
        core.execute(address(0), 1e18, _steps(), 0);

        vm.expectRevert(RyoCore.ZeroAmount.selector);
        core.execute(address(tokenA), 0, _steps(), 0);
    }

    function test_simulate_validates_route() public {
        RyoCore.Step[] memory steps = new RyoCore.Step[](0);
        vm.expectRevert(RyoCore.RouteTooShort.selector);
        core.simulate(address(tokenA), 1e18, steps);
    }

    function test_simulate_zero_asset_and_amount_revert() public {
        vm.expectRevert(RyoCore.ZeroAddress.selector);
        core.simulate(address(0), 1e18, _steps());

        vm.expectRevert(RyoCore.ZeroAmount.selector);
        core.simulate(address(tokenA), 0, _steps());
    }

    // ---------------------------------------------------------------------------------------------
    // Per-step floor
    // ---------------------------------------------------------------------------------------------

    function test_core_enforces_first_step_floor() public {
        RyoCore.Step[] memory steps = _steps();
        steps[0].minAmountOut = 102e18;

        vm.expectRevert(
            abi.encodeWithSelector(RyoCore.InsufficientOutput.selector, 0, 101e18, 102e18)
        );
        core.execute(address(tokenA), AMOUNT, steps, 0);
    }

    function test_core_enforces_second_step_floor() public {
        adapterB.setRateBps(9_900);
        RyoCore.Step[] memory steps = _steps();
        steps[1].minAmountOut = 100e18;

        vm.expectRevert(
            abi.encodeWithSelector(RyoCore.InsufficientOutput.selector, 1, 99.99e18, 100e18)
        );
        core.execute(address(tokenA), AMOUNT, steps, 0);
    }

    // ---------------------------------------------------------------------------------------------
    // Adapter misbehaviour
    // ---------------------------------------------------------------------------------------------

    function test_adapter_refund_triggers_input_check() public {
        adapterA.setRefundInput(true);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.InputNotConsumed.selector, 0, 0, AMOUNT));
        core.execute(address(tokenA), AMOUNT, _steps(), 0);
    }

    function test_adapter_keeps_input_reverts() public {
        adapterA.setLeaveInput(true);

        vm.expectRevert(
            abi.encodeWithSelector(
                RyoCore.AdapterKeptInput.selector, 0, address(adapterA), 0, AMOUNT
            )
        );
        core.execute(address(tokenA), AMOUNT, _steps(), 0);
    }

    function test_adapter_no_output_reverts() public {
        adapterA.setSendOutput(false);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.InsufficientOutput.selector, 0, 0, 1));
        core.execute(address(tokenA), AMOUNT, _steps(), 0);
    }

    function test_adapter_revert_bubbles() public {
        adapterA.setRevertStep(true);

        vm.expectRevert(MockAdapter.MockRevert.selector);
        core.execute(address(tokenA), AMOUNT, _steps(), 0);
    }

    // ---------------------------------------------------------------------------------------------
    // Callback security
    // ---------------------------------------------------------------------------------------------

    function _loanArrays(address asset, uint256 amount)
        internal
        pure
        returns (IERC20[] memory tokens, uint256[] memory amounts, uint256[] memory fees)
    {
        tokens = new IERC20[](1);
        tokens[0] = IERC20(asset);
        amounts = new uint256[](1);
        amounts[0] = amount;
        fees = new uint256[](1);
    }

    function test_callback_rejects_fake_vault() public {
        FakeVault fake = new FakeVault();
        (IERC20[] memory tokens, uint256[] memory amounts, uint256[] memory fees) =
            _loanArrays(address(tokenA), AMOUNT);
        bytes memory userData = abi.encode(uint8(1), _steps());

        vm.expectRevert(RyoCore.UnauthorizedCallback.selector);
        fake.callReceive(core, tokens, amounts, fees, userData);
    }

    function test_callback_silent_vault_reverts() public {
        vault.setSilent(true);

        vm.expectRevert(RyoCore.CallbackNotCalled.selector);
        core.execute(address(tokenA), AMOUNT, _steps(), 0);
    }

    function test_callback_double_reverts() public {
        vault.setDoubleCallback(true);

        vm.expectRevert(RyoCore.CallbackAlreadyConsumed.selector);
        core.execute(address(tokenA), AMOUNT, _steps(), 0);
    }

    function test_callback_wrong_token_reverts() public {
        vault.setCallbackOverrides(address(tokenB), AMOUNT);

        vm.expectRevert(RyoCore.InvalidFlashLoanData.selector);
        core.execute(address(tokenA), AMOUNT, _steps(), 0);
    }

    function test_callback_wrong_amount_reverts() public {
        vault.setCallbackOverrides(address(tokenA), AMOUNT - 1);

        vm.expectRevert(RyoCore.InvalidFlashLoanData.selector);
        core.execute(address(tokenA), AMOUNT, _steps(), 0);
    }

    function test_callback_wrong_user_data_reverts() public {
        vault.setOverrideUserData(abi.encode(uint8(1), _alternatingSteps(4)));

        vm.expectRevert(RyoCore.UnauthorizedCallback.selector);
        core.execute(address(tokenA), AMOUNT, _steps(), 0);
    }

    function test_callback_direct_reverts() public {
        (IERC20[] memory tokens, uint256[] memory amounts, uint256[] memory fees) =
            _loanArrays(address(tokenA), AMOUNT);
        bytes memory userData = abi.encode(uint8(1), _steps());

        vm.expectRevert(RyoCore.UnauthorizedCallback.selector);
        vault.callCallbackDirect(core, tokens, amounts, fees, userData);
    }

    function test_callback_invalid_version_reverts() public {
        RyoHarness harness =
            new RyoHarness(IBalancerVault(address(vault)), address(this), address(this), recipient);

        bytes memory userData = abi.encode(uint8(2), _steps());
        harness.setTransient(keccak256(userData), address(tokenA), AMOUNT, 0, false);

        (IERC20[] memory tokens, uint256[] memory amounts, uint256[] memory fees) =
            _loanArrays(address(tokenA), AMOUNT);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.InvalidRouteVersion.selector, 2));
        vault.callCallbackDirect(harness, tokens, amounts, fees, userData);
    }

    // ---------------------------------------------------------------------------------------------
    // Reentrancy
    // ---------------------------------------------------------------------------------------------

    function test_reentrancy_is_blocked() public {
        ReentrantAdapter reentrantA = new ReentrantAdapter(address(core));
        ReentrantAdapter reentrantB = new ReentrantAdapter(address(core));
        core.setAdapter(address(reentrantA), true);
        core.setAdapter(address(reentrantB), true);

        RyoCore.Step[] memory steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step(address(reentrantA), address(tokenA), address(tokenB), 1, "");
        steps[1] = RyoCore.Step(address(reentrantB), address(tokenB), address(tokenA), 1, "");

        uint256 profit = core.execute(address(tokenA), 10e18, steps, 0);

        assertEq(profit, 0);
        assertTrue(reentrantA.reentryBlocked());
        assertTrue(reentrantB.reentryBlocked());
        assertFalse(reentrantA.reentrySucceeded());
        assertFalse(reentrantB.reentrySucceeded());

        bytes4 guard = bytes4(keccak256("ReentrancyGuardReentrantCall()"));
        assertEq(reentrantA.reentryError(), guard);
        assertEq(reentrantB.reentryError(), guard);
    }

    // ---------------------------------------------------------------------------------------------
    // Fee-on-transfer tokens fail closed
    // ---------------------------------------------------------------------------------------------

    function test_fee_on_transfer_asset_reverts_safely() public {
        MockFeeERC20 feeToken = new MockFeeERC20("Fee Token", "FEE", 18, 100);
        MockERC20 other = new MockERC20("Other", "OTH", 18);
        MockBalancerVault feeVault = new MockBalancerVault();
        feeToken.mint(address(feeVault), 1_000_000e18);

        RyoCore feeCore =
            new RyoCore(IBalancerVault(address(feeVault)), address(this), address(this), recipient);
        MockAdapter a1 = new MockAdapter(address(feeCore));
        MockAdapter a2 = new MockAdapter(address(feeCore));
        feeCore.setAdapter(address(a1), true);
        feeCore.setAdapter(address(a2), true);
        feeCore.setMaxTradeSize(address(feeToken), 1_000_000e18);

        RyoCore.Step[] memory steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step(address(a1), address(feeToken), address(other), 1, "");
        steps[1] = RyoCore.Step(address(a2), address(other), address(feeToken), 1, "");

        // The Vault sends AMOUNT but 1% is burned in flight, so the core receives less than it
        // borrowed and can never hand the adapter the full amount. The transaction must fail
        // closed and leave the Vault whole.
        vm.expectRevert();
        feeCore.execute(address(feeToken), AMOUNT, steps, 0);

        assertEq(feeToken.balanceOf(address(feeVault)), 1_000_000e18);
        assertEq(feeToken.balanceOf(address(feeCore)), 0);
    }

    /// @notice A token that under-delivers without reverting must produce a named error, not an
    ///         arithmetic panic. Reverts are cheap to reason about; panics are not.
    function test_soft_token_short_delivery_is_rejected_with_named_error() public {
        MockSoftERC20 soft = new MockSoftERC20("Soft", "SOFT", 18, 100);
        MockERC20 other = new MockERC20("Other", "OTH", 18);
        MockBalancerVault softVault = new MockBalancerVault();
        soft.mint(address(softVault), 1_000_000e18);

        RyoCore softCore = new RyoCore(
            IBalancerVault(address(softVault)), address(this), address(this), recipient
        );
        NoopAdapter noop = new NoopAdapter(address(softCore));
        softCore.setAdapter(address(noop), true);
        softCore.setMaxTradeSize(address(soft), 1_000_000e18);

        RyoCore.Step[] memory steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step(address(noop), address(soft), address(other), 1, "");
        steps[1] = RyoCore.Step(address(noop), address(other), address(soft), 1, "");

        uint256 delivered = AMOUNT - (AMOUNT * 100) / 10_000;
        vm.expectRevert(
            abi.encodeWithSelector(RyoCore.InputNotConsumed.selector, 0, AMOUNT, delivered)
        );
        softCore.execute(address(soft), AMOUNT, steps, 0);
    }

    // ---------------------------------------------------------------------------------------------
    // Fuzz
    // ---------------------------------------------------------------------------------------------

    function testFuzz_simulation_matches_execute(
        uint96 amountSeed,
        uint16 rateSeed1,
        uint16 rateSeed2,
        uint16 feeSeed
    ) public {
        uint256 amount = bound(uint256(amountSeed), 1e18, 100_000e18);
        uint256 rate1 = bound(uint256(rateSeed1), 10_100, 10_500);
        uint256 rate2 = bound(uint256(rateSeed2), 10_100, 10_500);
        uint256 feeBps = bound(uint256(feeSeed), 0, 10);

        adapterA.setRateBps(rate1);
        adapterB.setRateBps(rate2);
        vault.setFeeBps(feeBps);

        uint256 out1 = (amount * rate1) / 10_000;
        uint256 out2 = (out1 * rate2) / 10_000;
        uint256 fee = (amount * feeBps) / 10_000;
        uint256 expectedProfit = out2 - amount - fee;

        int256 simulated = _simulationResult(_steps(), amount);
        assertEq(simulated, int256(expectedProfit));

        uint256 recipientBefore = tokenA.balanceOf(recipient);
        uint256 profit = core.execute(address(tokenA), amount, _steps(), 0);

        assertEq(profit, expectedProfit);
        assertEq(tokenA.balanceOf(recipient), recipientBefore + expectedProfit);
        assertEq(tokenA.balanceOf(address(core)), 0);
        assertGe(tokenA.balanceOf(address(vault)), INITIAL_VAULT_BALANCE);
    }

    function testFuzz_min_profit_reverts(
        uint96 amountSeed,
        uint16 rateSeed1,
        uint16 rateSeed2,
        uint96 extraSeed
    ) public {
        uint256 amount = bound(uint256(amountSeed), 1e18, 10_000e18);
        uint256 rate1 = bound(uint256(rateSeed1), 10_100, 10_500);
        uint256 rate2 = bound(uint256(rateSeed2), 10_100, 10_500);
        uint256 extra = bound(uint256(extraSeed), 1, 1e18);

        adapterA.setRateBps(rate1);
        adapterB.setRateBps(rate2);

        uint256 out1 = (amount * rate1) / 10_000;
        uint256 out2 = (out1 * rate2) / 10_000;
        uint256 profit = out2 - amount;
        uint256 minProfit = profit + extra;

        vm.expectRevert(abi.encodeWithSelector(RyoCore.MinProfitNotMet.selector, profit, minProfit));
        core.execute(address(tokenA), amount, _steps(), minProfit);
    }

    function testFuzz_route_lengths(uint8 pairSeed) public {
        uint256 pairs = bound(uint256(pairSeed), 1, 4);
        adapterA.setRateBps(10_000);
        adapterB.setRateBps(10_000);

        RyoCore.Step[] memory steps = _alternatingSteps(pairs * 2);
        uint256 profit = core.execute(address(tokenA), 10e18, steps, 0);

        assertEq(profit, 0);
        assertEq(tokenA.balanceOf(address(core)), 0);
    }

    // ---------------------------------------------------------------------------------------------
    // Ownership
    // ---------------------------------------------------------------------------------------------

    /// @dev Renouncing would brick configuration (pause, adapters, caps, operator rotation).
    function test_renounce_ownership_reverts() public {
        vm.expectRevert(RyoCore.OwnershipRenunciationDisabled.selector);
        core.renounceOwnership();
    }

    function test_two_step_transfer_still_works_and_cannot_renounce() public {
        core.transferOwnership(newOwner);
        assertEq(core.owner(), address(this));
        assertEq(core.pendingOwner(), newOwner);

        vm.prank(newOwner);
        core.acceptOwnership();
        assertEq(core.owner(), newOwner);
        assertEq(core.pendingOwner(), address(0));

        vm.prank(newOwner);
        vm.expectRevert(RyoCore.OwnershipRenunciationDisabled.selector);
        core.renounceOwnership();
    }

    function test_non_owner_cannot_change_admin_settings() public {
        vm.startPrank(stranger);
        vm.expectRevert(
            abi.encodeWithSelector(Ownable.OwnableUnauthorizedAccount.selector, stranger)
        );
        core.setOperator(newOperator);
        vm.expectRevert(
            abi.encodeWithSelector(Ownable.OwnableUnauthorizedAccount.selector, stranger)
        );
        core.renounceOwnership();
        vm.stopPrank();
    }
}

/// @dev Adapter that accepts the call and does nothing. Used to isolate core-side accounting
///      checks from any adapter behaviour.
contract NoopAdapter is IAdapter {
    address public immutable core;

    constructor(address core_) {
        core = core_;
    }

    function step(address, address, uint256, uint256, bytes calldata) external view {
        if (msg.sender != core) revert("unauthorized");
    }
}

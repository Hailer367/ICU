// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { Ownable } from "@openzeppelin/contracts/access/Ownable.sol";

import { RyoCore } from "../src/RyoCore.sol";
import { IBalancerVault } from "../src/interfaces/IBalancerVault.sol";

import { BaseTest } from "./BaseTest.sol";
import { MockAdapter } from "./mocks/MockAdapter.sol";

contract RyoCoreTest is BaseTest {
    event Executed(
        address indexed operator,
        address indexed asset,
        uint256 amount,
        uint256 profit,
        address indexed recipient,
        bytes32 routeHash
    );
    event Swept(address indexed token, address indexed to, uint256 amount);

    uint256 internal constant AMOUNT = 100e18;
    uint256 internal constant PROFIT = 2.01e18;

    // ---------------------------------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------------------------------

    function test_constructor_defaults() public view {
        assertEq(core.owner(), address(this));
        assertEq(core.operator(), address(this));
        assertEq(core.profitRecipient(), recipient);
        assertEq(address(core.vault()), address(vault));
        assertEq(core.VERSION(), 1);
        assertEq(core.MAX_STEPS(), 8);
        assertEq(core.maxTradeSize(address(tokenA)), INITIAL_VAULT_BALANCE);
        assertTrue(core.isAdapter(address(adapterA)));
        assertTrue(core.isAdapter(address(adapterB)));
        assertFalse(core.paused());
    }

    function test_constructor_rejects_zero_vault() public {
        vm.expectRevert(RyoCore.ZeroAddress.selector);
        new RyoCore(IBalancerVault(address(0)), address(this), address(this), recipient);
    }

    function test_constructor_rejects_eoa_vault() public {
        vm.expectRevert(abi.encodeWithSelector(RyoCore.NotContract.selector, stranger));
        new RyoCore(IBalancerVault(stranger), address(this), address(this), recipient);
    }

    function test_constructor_rejects_zero_operator() public {
        vm.expectRevert(RyoCore.ZeroAddress.selector);
        new RyoCore(IBalancerVault(address(vault)), address(this), address(0), recipient);
    }

    function test_constructor_rejects_zero_recipient() public {
        vm.expectRevert(RyoCore.InvalidProfitRecipient.selector);
        new RyoCore(IBalancerVault(address(vault)), address(this), address(this), address(0));
    }

    function test_constructor_rejects_zero_owner() public {
        vm.expectRevert(abi.encodeWithSelector(Ownable.OwnableInvalidOwner.selector, address(0)));
        new RyoCore(IBalancerVault(address(vault)), address(0), address(this), recipient);
    }

    // ---------------------------------------------------------------------------------------------
    // Execute
    // ---------------------------------------------------------------------------------------------

    function test_execute_profit() public {
        uint256 profit = _execute(AMOUNT, 0);

        assertEq(profit, PROFIT);
        assertEq(tokenA.balanceOf(recipient), PROFIT);
        assertEq(tokenA.balanceOf(address(core)), 0);
        assertEq(tokenB.balanceOf(address(core)), 0);
        assertEq(tokenA.balanceOf(address(vault)), INITIAL_VAULT_BALANCE);
    }

    function test_execute_zero_profit() public {
        adapterA.setRateBps(10_000);
        adapterB.setRateBps(10_000);

        uint256 profit = _execute(AMOUNT, 0);

        assertEq(profit, 0);
        assertEq(tokenA.balanceOf(recipient), 0);
        assertEq(tokenA.balanceOf(address(core)), 0);
        assertEq(tokenA.balanceOf(address(vault)), INITIAL_VAULT_BALANCE);
    }

    function test_execute_event() public {
        vm.expectEmit(true, true, true, true, address(core));
        emit Executed(
            address(this), address(tokenA), AMOUNT, PROFIT, recipient, _routeHash(_steps())
        );

        _execute(AMOUNT, 0);
    }

    function test_execute_minProfit_exact() public {
        uint256 profit = _execute(AMOUNT, PROFIT);
        assertEq(profit, PROFIT);
    }

    function test_execute_minProfit_above() public {
        uint256 required = PROFIT + 1;
        vm.expectRevert(abi.encodeWithSelector(RyoCore.MinProfitNotMet.selector, PROFIT, required));
        _execute(AMOUNT, required);
    }

    function test_execute_loss_reverts() public {
        adapterA.setRateBps(9_900);
        adapterB.setRateBps(9_900);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.Loss.selector, 0, 0));
        _execute(AMOUNT, 0);

        assertEq(tokenA.balanceOf(recipient), 0);
        assertEq(tokenA.balanceOf(address(core)), 0);
        assertEq(tokenA.balanceOf(address(vault)), INITIAL_VAULT_BALANCE);
    }

    function test_execute_respects_trade_cap() public {
        core.setMaxTradeSize(address(tokenA), 50e18);

        vm.expectRevert(
            abi.encodeWithSelector(RyoCore.TradeTooLarge.selector, address(tokenA), 51e18, 50e18)
        );
        _execute(51e18, 0);

        uint256 profit = _execute(50e18, 0);
        assertEq(profit, (50e18 * 10_100 / 10_000) * 10_100 / 10_000 - 50e18);
    }

    function test_execute_disabled_asset_reverts() public {
        core.setMaxTradeSize(address(tokenA), 0);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.TradeNotAllowed.selector, address(tokenA)));
        _execute(AMOUNT, 0);
    }

    function test_execute_respects_gas_cap() public {
        core.setMaxGasPrice(100 gwei);
        vm.txGasPrice(101 gwei);

        vm.expectRevert(
            abi.encodeWithSelector(RyoCore.GasPriceTooHigh.selector, 101 gwei, 100 gwei)
        );
        _execute(AMOUNT, 0);

        vm.txGasPrice(100 gwei);
        uint256 profit = _execute(AMOUNT, 0);
        assertEq(profit, PROFIT);

        vm.txGasPrice(0);
    }

    // ---------------------------------------------------------------------------------------------
    // Access and pause
    // ---------------------------------------------------------------------------------------------

    function test_only_operator_can_execute() public {
        vm.prank(stranger);
        vm.expectRevert(abi.encodeWithSelector(RyoCore.NotOperator.selector, stranger));
        core.execute(address(tokenA), AMOUNT, _steps(), 0);
    }

    function test_owner_and_operator_can_execute() public {
        core.setOperator(newOperator);

        vm.prank(newOperator);
        uint256 p1 = core.execute(address(tokenA), AMOUNT, _steps(), 0);
        assertEq(p1, PROFIT);

        uint256 p2 = _execute(AMOUNT, 0);
        assertEq(p2, PROFIT);
    }

    function test_pause_unpause() public {
        core.pause();
        assertTrue(core.paused());

        vm.expectRevert(RyoCore.ContractPaused.selector);
        _execute(AMOUNT, 0);

        core.unpause();
        assertFalse(core.paused());

        uint256 profit = _execute(AMOUNT, 0);
        assertEq(profit, PROFIT);
    }

    function test_pause_access() public {
        vm.prank(stranger);
        vm.expectRevert(abi.encodeWithSelector(RyoCore.NotOperator.selector, stranger));
        core.pause();

        core.pause();

        vm.prank(stranger);
        vm.expectRevert(
            abi.encodeWithSelector(Ownable.OwnableUnauthorizedAccount.selector, stranger)
        );
        core.unpause();
    }

    // ---------------------------------------------------------------------------------------------
    // Simulation
    // ---------------------------------------------------------------------------------------------

    function test_simulation_profit() public {
        int256 result = _simulationResult(_steps(), AMOUNT);
        assertEq(result, int256(PROFIT));
    }

    function test_simulation_zero() public {
        adapterA.setRateBps(10_000);
        adapterB.setRateBps(10_000);

        int256 result = _simulationResult(_steps(), AMOUNT);
        assertEq(result, 0);
    }

    function test_simulation_loss() public {
        adapterA.setRateBps(9_900);
        adapterB.setRateBps(9_900);

        int256 result = _simulationResult(_steps(), AMOUNT);
        assertEq(result, -1.99e18);
    }

    function test_simulation_includes_flash_loan_fee() public {
        vault.setFeeBps(10);

        int256 result = _simulationResult(_steps(), AMOUNT);
        assertEq(result, 1.91e18);
    }

    function test_simulation_excludes_dust() public {
        _mintToCore(5e18);

        int256 result = _simulationResult(_steps(), AMOUNT);
        assertEq(result, int256(PROFIT));
        assertEq(tokenA.balanceOf(address(core)), 5e18);
    }

    function test_simulation_is_permissionless() public {
        vm.prank(stranger);
        int256 result = _simulationResult(_steps(), AMOUNT);
        assertEq(result, int256(PROFIT));
    }

    function test_simulation_works_while_paused() public {
        core.pause();

        int256 result = _simulationResult(_steps(), AMOUNT);
        assertEq(result, int256(PROFIT));
    }

    function test_simulation_does_not_change_state() public {
        uint256 coreA = tokenA.balanceOf(address(core));
        uint256 coreB = tokenB.balanceOf(address(core));
        uint256 vaultA = tokenA.balanceOf(address(vault));
        uint256 recipientA = tokenA.balanceOf(recipient);

        _simulationResult(_steps(), AMOUNT);

        assertEq(tokenA.balanceOf(address(core)), coreA);
        assertEq(tokenB.balanceOf(address(core)), coreB);
        assertEq(tokenA.balanceOf(address(vault)), vaultA);
        assertEq(tokenA.balanceOf(recipient), recipientA);
    }

    // ---------------------------------------------------------------------------------------------
    // Profit recipient, dust, sweep
    // ---------------------------------------------------------------------------------------------

    function test_profit_recipient_is_configurable() public {
        core.setProfitRecipient(newOwner);

        _execute(AMOUNT, 0);

        assertEq(tokenA.balanceOf(newOwner), PROFIT);
        assertEq(tokenA.balanceOf(recipient), 0);
    }

    function test_profit_recipient_rejects_zero_and_core() public {
        vm.expectRevert(RyoCore.InvalidProfitRecipient.selector);
        core.setProfitRecipient(address(0));

        vm.expectRevert(RyoCore.InvalidProfitRecipient.selector);
        core.setProfitRecipient(address(core));
    }

    function test_dust_is_preserved() public {
        _mintToCore(5e18);

        uint256 profit = _execute(AMOUNT, 0);

        assertEq(profit, PROFIT);
        assertEq(tokenA.balanceOf(recipient), PROFIT);
        assertEq(tokenA.balanceOf(address(core)), 5e18);
    }

    function test_dust_cannot_subsidize_a_loss() public {
        _mintToCore(1e18);
        adapterA.setRateBps(9_900);
        adapterB.setRateBps(9_900);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.Loss.selector, 0, 1e18));
        _execute(AMOUNT, 0);

        assertEq(tokenA.balanceOf(address(core)), 1e18);
    }

    function test_sweep() public {
        _mintToCore(5e18);

        vm.expectEmit(true, true, false, true, address(core));
        emit Swept(address(tokenA), recipient, 5e18);
        core.sweep(address(tokenA), recipient);

        assertEq(tokenA.balanceOf(recipient), 5e18);
        assertEq(tokenA.balanceOf(address(core)), 0);
    }

    function test_sweep_access() public {
        _mintToCore(5e18);

        vm.prank(stranger);
        vm.expectRevert(
            abi.encodeWithSelector(Ownable.OwnableUnauthorizedAccount.selector, stranger)
        );
        core.sweep(address(tokenA), recipient);
    }

    function test_sweep_rejects_zero_addresses() public {
        vm.expectRevert(RyoCore.ZeroAddress.selector);
        core.sweep(address(0), recipient);

        vm.expectRevert(RyoCore.ZeroAddress.selector);
        core.sweep(address(tokenA), address(0));
    }

    // ---------------------------------------------------------------------------------------------
    // Admin setters and ownership
    // ---------------------------------------------------------------------------------------------

    function test_set_adapter_checks() public {
        vm.expectRevert(RyoCore.ZeroAddress.selector);
        core.setAdapter(address(0), true);

        vm.expectRevert(abi.encodeWithSelector(RyoCore.NotContract.selector, stranger));
        core.setAdapter(stranger, true);

        core.setAdapter(address(adapterA), false);
        assertFalse(core.isAdapter(address(adapterA)));

        vm.expectRevert(
            abi.encodeWithSelector(RyoCore.AdapterNotAllowed.selector, address(adapterA))
        );
        _execute(AMOUNT, 0);
    }

    function test_set_operator() public {
        core.setOperator(newOperator);
        assertEq(core.operator(), newOperator);

        vm.prank(stranger);
        vm.expectRevert(abi.encodeWithSelector(RyoCore.NotOperator.selector, stranger));
        core.execute(address(tokenA), AMOUNT, _steps(), 0);
    }

    function test_set_max_gas_price() public {
        core.setMaxGasPrice(1 gwei);
        assertEq(core.maxGasPrice(), 1 gwei);

        core.setMaxGasPrice(0);
        assertEq(core.maxGasPrice(), 0);
    }

    function test_ownership_is_two_step() public {
        core.transferOwnership(newOwner);
        assertEq(core.owner(), address(this));
        assertEq(core.pendingOwner(), newOwner);

        vm.prank(newOwner);
        core.acceptOwnership();
        assertEq(core.owner(), newOwner);

        vm.expectRevert(
            abi.encodeWithSelector(Ownable.OwnableUnauthorizedAccount.selector, address(this))
        );
        core.setOperator(newOperator);
    }

    // ---------------------------------------------------------------------------------------------
    // Envelope
    // ---------------------------------------------------------------------------------------------

    function test_userData_envelope_contains_version_and_steps() public {
        _execute(AMOUNT, 0);

        (uint8 version, RyoCore.Step[] memory steps) =
            abi.decode(vault.lastUserData(), (uint8, RyoCore.Step[]));

        assertEq(version, 1);
        assertEq(steps.length, 2);
        assertEq(steps[0].adapter, address(adapterA));
        assertEq(steps[0].tokenIn, address(tokenA));
        assertEq(steps[0].tokenOut, address(tokenB));
        assertEq(steps[1].adapter, address(adapterB));
        assertEq(steps[1].tokenIn, address(tokenB));
        assertEq(steps[1].tokenOut, address(tokenA));
    }
}

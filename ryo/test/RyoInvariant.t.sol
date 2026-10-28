// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { Test } from "forge-std/Test.sol";

import { RyoCore } from "../src/RyoCore.sol";
import { IBalancerVault } from "../src/interfaces/IBalancerVault.sol";

import { MockAdapter } from "./mocks/MockAdapter.sol";
import { MockBalancerVault } from "./mocks/MockBalancerVault.sol";
import { MockERC20 } from "./mocks/MockERC20.sol";
import { ExecuteHandler } from "./handlers/ExecuteHandler.sol";

/// forge-config: default.invariant.runs = 128
/// forge-config: default.invariant.depth = 32
/// forge-config: default.invariant.fail-on-revert = true
contract RyoInvariantTest is Test {
    MockERC20 internal tokenA;
    MockERC20 internal tokenB;
    MockBalancerVault internal vault;
    RyoCore internal core;
    MockAdapter internal adapterA;
    MockAdapter internal adapterB;
    ExecuteHandler internal handler;

    address internal recipient = address(0xBEEF);

    uint256 internal constant VAULT_BALANCE = 1_000_000e18;

    function setUp() public {
        tokenA = new MockERC20("Token A", "A", 18);
        tokenB = new MockERC20("Token B", "B", 18);

        vault = new MockBalancerVault();
        tokenA.mint(address(vault), VAULT_BALANCE);

        core = new RyoCore(IBalancerVault(address(vault)), address(this), address(this), recipient);

        adapterA = new MockAdapter(address(core));
        adapterB = new MockAdapter(address(core));
        core.setAdapter(address(adapterA), true);
        core.setAdapter(address(adapterB), true);
        core.setMaxTradeSize(address(tokenA), VAULT_BALANCE);

        handler = new ExecuteHandler(core, tokenA, tokenB, adapterA, adapterB, recipient);
        core.setOperator(address(handler));
        targetContract(address(handler));

        bytes4[] memory selectors = new bytes4[](2);
        selectors[0] = ExecuteHandler.execute.selector;
        selectors[1] = ExecuteHandler.simulate.selector;
        targetSelector(FuzzSelector({ addr: address(handler), selectors: selectors }));
    }

    /// @notice The core must never retain tokens between transactions.
    function invariant_core_holds_no_funds() public view {
        assertEq(tokenA.balanceOf(address(core)), 0);
        assertEq(tokenB.balanceOf(address(core)), 0);
    }

    /// @notice Every loan is repaid in full, so the Vault can never become insolvent.
    function invariant_vault_is_solvent() public view {
        assertGe(tokenA.balanceOf(address(vault)), VAULT_BALANCE);
    }

    /// @notice Profit accounting is exact: the recipient receives every unit the core reports.
    function invariant_profit_accounting_matches_recipient() public view {
        assertEq(tokenA.balanceOf(recipient), handler.totalProfit());
    }

    /// @notice Adapter allowances are always reset after each step.
    function invariant_adapter_balances_empty() public view {
        assertEq(tokenA.balanceOf(address(adapterA)), 0);
        assertEq(tokenB.balanceOf(address(adapterA)), 0);
        assertEq(tokenA.balanceOf(address(adapterB)), 0);
        assertEq(tokenB.balanceOf(address(adapterB)), 0);
    }
}

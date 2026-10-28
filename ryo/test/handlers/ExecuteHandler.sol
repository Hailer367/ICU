// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { Test } from "forge-std/Test.sol";

import { RyoCore } from "../../src/RyoCore.sol";

import { MockAdapter } from "../mocks/MockAdapter.sol";
import { MockERC20 } from "../mocks/MockERC20.sol";

/// @notice Drives random profitable (or break-even) executions against the core.
/// @dev Rates are never below 100%, so `execute` must never revert for a loss. Any revert is a
///      genuine invariant failure, which is why the suite enables `fail-on-revert`.
contract ExecuteHandler is Test {
    RyoCore public immutable core;
    MockERC20 public immutable tokenA;
    MockERC20 public immutable tokenB;
    MockAdapter public immutable adapterA;
    MockAdapter public immutable adapterB;
    address public immutable recipient;

    uint256 public totalProfit;
    uint256 public executions;

    constructor(
        RyoCore core_,
        MockERC20 tokenA_,
        MockERC20 tokenB_,
        MockAdapter adapterA_,
        MockAdapter adapterB_,
        address recipient_
    ) {
        core = core_;
        tokenA = tokenA_;
        tokenB = tokenB_;
        adapterA = adapterA_;
        adapterB = adapterB_;
        recipient = recipient_;
    }

    function execute(uint96 amountSeed, uint16 rate1Seed, uint16 rate2Seed) external {
        uint256 cap = core.maxTradeSize(address(tokenA));
        uint256 amount = bound(uint256(amountSeed), 1, cap);
        uint256 rate1 = bound(uint256(rate1Seed), 10_000, 10_050);
        uint256 rate2 = bound(uint256(rate2Seed), 10_000, 10_050);

        adapterA.setRateBps(rate1);
        adapterB.setRateBps(rate2);

        RyoCore.Step[] memory steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step(address(adapterA), address(tokenA), address(tokenB), 1, "");
        steps[1] = RyoCore.Step(address(adapterB), address(tokenB), address(tokenA), 1, "");

        uint256 recipientBefore = tokenA.balanceOf(recipient);
        uint256 profit = core.execute(address(tokenA), amount, steps, 0);

        assertEq(tokenA.balanceOf(recipient) - recipientBefore, profit);
        totalProfit += profit;
        executions += 1;
    }

    function simulate(uint96 amountSeed, uint16 rate1Seed, uint16 rate2Seed) external {
        uint256 cap = core.maxTradeSize(address(tokenA));
        uint256 amount = bound(uint256(amountSeed), 1, cap);
        uint256 rate1 = bound(uint256(rate1Seed), 10_000, 10_050);
        uint256 rate2 = bound(uint256(rate2Seed), 10_000, 10_050);

        adapterA.setRateBps(rate1);
        adapterB.setRateBps(rate2);

        RyoCore.Step[] memory steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step(address(adapterA), address(tokenA), address(tokenB), 1, "");
        steps[1] = RyoCore.Step(address(adapterB), address(tokenB), address(tokenA), 1, "");

        try core.simulate(address(tokenA), amount, steps) {
            revert("simulate returned instead of reverting");
        } catch (bytes memory data) {
            bytes4 selector;
            assembly {
                selector := mload(add(data, 0x20))
            }
            require(selector == RyoCore.SimulationResult.selector, "unexpected simulate revert");
        }
    }
}

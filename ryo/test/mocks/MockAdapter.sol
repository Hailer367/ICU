// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { IAdapter } from "../../src/interfaces/IAdapter.sol";
import { MockERC20 } from "./MockERC20.sol";

/// @notice Configurable adapter for core tests. It mints output rather than trading.
contract MockAdapter is IAdapter {
    address public immutable core;

    uint256 public rateBps = 10_000;
    bool public leaveInput;
    bool public refundInput;
    bool public sendOutput = true;
    bool public revertStep;

    error Unauthorized();
    error MockRevert();

    constructor(address core_) {
        core = core_;
    }

    function setRateBps(uint256 newRateBps) external {
        rateBps = newRateBps;
    }

    function setLeaveInput(bool value) external {
        leaveInput = value;
    }

    function setRefundInput(bool value) external {
        refundInput = value;
    }

    function setSendOutput(bool value) external {
        sendOutput = value;
    }

    function setRevertStep(bool value) external {
        revertStep = value;
    }

    function step(address tokenIn, address tokenOut, uint256 amountIn, uint256, bytes calldata)
        external
    {
        if (msg.sender != core) revert Unauthorized();
        if (revertStep) revert MockRevert();

        if (refundInput) {
            MockERC20(tokenIn).transfer(core, amountIn);
        } else if (!leaveInput) {
            MockERC20(tokenIn).burn(address(this), amountIn);
        }
        if (sendOutput) {
            uint256 amountOut = (amountIn * rateBps) / 10_000;
            MockERC20(tokenOut).mint(core, amountOut);
        }
    }
}

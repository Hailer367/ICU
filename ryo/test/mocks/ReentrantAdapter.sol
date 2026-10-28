// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { IAdapter } from "../../src/interfaces/IAdapter.sol";
import { RyoCore } from "../../src/RyoCore.sol";
import { MockERC20 } from "./MockERC20.sol";

/// @notice Adapter that tries to re-enter `simulate` while the core is executing.
contract ReentrantAdapter is IAdapter {
    address public immutable core;
    bool public reentryBlocked;
    bool public reentrySucceeded;
    bytes4 public reentryError;

    constructor(address core_) {
        core = core_;
    }

    function step(address tokenIn, address tokenOut, uint256 amountIn, uint256, bytes calldata)
        external
    {
        require(msg.sender == core, "unauthorized");

        RyoCore.Step[] memory empty = new RyoCore.Step[](0);
        try RyoCore(core).simulate(tokenIn, amountIn, empty) {
            reentrySucceeded = true;
        } catch (bytes memory reason) {
            reentryBlocked = true;
            if (reason.length >= 4) {
                bytes4 selector;
                assembly {
                    selector := mload(add(reason, 0x20))
                }
                reentryError = selector;
            }
        }

        MockERC20(tokenIn).burn(address(this), amountIn);
        MockERC20(tokenOut).mint(core, amountIn);
    }
}

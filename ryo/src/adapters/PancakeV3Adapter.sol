// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { IPancakeSwapRouter } from "../interfaces/IPancakeSwapRouter.sol";
import { AdapterBase } from "./AdapterBase.sol";

/// @notice PancakeSwap V3 single-hop adapter. `data = abi.encode(uint24 fee)`.
/// @dev Pancake's router still takes a `deadline`; it is bound to the current block so a route
///      that is mined later simply reverts instead of filling at a stale price.
contract PancakeV3Adapter is AdapterBase {
    constructor(address core_, address router_) AdapterBase(core_, router_) { }

    function step(
        address tokenIn,
        address tokenOut,
        uint256 amountIn,
        uint256 minAmountOut,
        bytes calldata data
    ) external onlyCore {
        if (data.length != 32) revert InvalidDataLength();
        uint24 fee = abi.decode(data, (uint24));
        _checkStep(tokenIn, tokenOut, amountIn, minAmountOut);

        uint256 inBefore = _selfBalance(tokenIn);
        uint256 outBefore = _selfBalance(tokenOut);

        _approve(tokenIn, amountIn);
        IPancakeSwapRouter(router)
            .exactInputSingle(
                IPancakeSwapRouter.ExactInputSingleParams({
                    tokenIn: tokenIn,
                    tokenOut: tokenOut,
                    fee: fee,
                    recipient: msg.sender,
                    deadline: block.timestamp,
                    amountIn: amountIn,
                    amountOutMinimum: minAmountOut,
                    sqrtPriceLimitX96: 0
                })
            );
        _resetApproval(tokenIn);

        _requireInputConsumed(tokenIn, inBefore, amountIn);
        _requireNoOutputRetained(tokenOut, outBefore);
    }
}

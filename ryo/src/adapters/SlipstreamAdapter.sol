// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { ISlipstreamSwapRouter } from "../interfaces/ISlipstreamSwapRouter.sol";
import { AdapterBase } from "./AdapterBase.sol";

/// @notice Aerodrome Slipstream single-hop adapter. `data = abi.encode(int24 tickSpacing)`.
contract SlipstreamAdapter is AdapterBase {
    error InvalidTickSpacing();

    constructor(address core_, address router_) AdapterBase(core_, router_) { }

    function step(
        address tokenIn,
        address tokenOut,
        uint256 amountIn,
        uint256 minAmountOut,
        bytes calldata data
    ) external onlyCore {
        if (data.length != 32) revert InvalidDataLength();
        int24 tickSpacing = abi.decode(data, (int24));
        if (tickSpacing <= 0) revert InvalidTickSpacing();
        _checkStep(tokenIn, tokenOut, amountIn, minAmountOut);

        uint256 inBefore = _selfBalance(tokenIn);
        uint256 outBefore = _selfBalance(tokenOut);

        _approve(tokenIn, amountIn);
        ISlipstreamSwapRouter(router)
            .exactInputSingle(
                ISlipstreamSwapRouter.ExactInputSingleParams({
                    tokenIn: tokenIn,
                    tokenOut: tokenOut,
                    tickSpacing: tickSpacing,
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

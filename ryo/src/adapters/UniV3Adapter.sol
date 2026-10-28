// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { ISwapRouter02 } from "../interfaces/ISwapRouter02.sol";
import { AdapterBase } from "./AdapterBase.sol";

/// @notice Uniswap V3 / SwapRouter02 single-hop adapter.
/// @dev `data = abi.encode(uint24 fee)`.
contract UniV3Adapter is AdapterBase {
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
        ISwapRouter02(router)
            .exactInputSingle(
                ISwapRouter02.ExactInputSingleParams({
                    tokenIn: tokenIn,
                    tokenOut: tokenOut,
                    fee: fee,
                    recipient: msg.sender,
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

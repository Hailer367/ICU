// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { IUniswapV2Router02 } from "../interfaces/IUniswapV2Router02.sol";
import { AdapterBase } from "./AdapterBase.sol";

/// @notice Uniswap V2-style single-hop adapter. `data` must be empty.
/// @dev Multi-hop routes are composed by the core, which keeps every leg's floor independent.
contract UniV2Adapter is AdapterBase {
    constructor(address core_, address router_) AdapterBase(core_, router_) { }

    function step(
        address tokenIn,
        address tokenOut,
        uint256 amountIn,
        uint256 minAmountOut,
        bytes calldata data
    ) external onlyCore {
        if (data.length != 0) revert InvalidDataLength();
        _checkStep(tokenIn, tokenOut, amountIn, minAmountOut);

        uint256 inBefore = _selfBalance(tokenIn);
        uint256 outBefore = _selfBalance(tokenOut);

        address[] memory path = new address[](2);
        path[0] = tokenIn;
        path[1] = tokenOut;

        _approve(tokenIn, amountIn);
        IUniswapV2Router02(router)
            .swapExactTokensForTokens(amountIn, minAmountOut, path, msg.sender, block.timestamp);
        _resetApproval(tokenIn);

        _requireInputConsumed(tokenIn, inBefore, amountIn);
        _requireNoOutputRetained(tokenOut, outBefore);
    }
}

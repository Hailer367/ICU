// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

/// @notice PancakeSwap V3 `SwapRouter` interface.
/// @dev Differs from Uniswap's SwapRouter02: the params struct keeps a `deadline` field and the
///      pools are keyed by `fee` in Pancake's own tier set (100/500/2500/10000), which maps to
///      tick spacings 1/10/50/200 rather than Uniswap's.
///      Base mainnet router: 0x1b81D678ffb9C0263b24A97847620C99d213eB14.
interface IPancakeSwapRouter {
    struct ExactInputSingleParams {
        address tokenIn;
        address tokenOut;
        uint24 fee;
        address recipient;
        uint256 deadline;
        uint256 amountIn;
        uint256 amountOutMinimum;
        uint160 sqrtPriceLimitX96;
    }

    function exactInputSingle(ExactInputSingleParams calldata params)
        external
        payable
        returns (uint256 amountOut);
}

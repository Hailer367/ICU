// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

/// @notice Aerodrome Slipstream concentrated-liquidity router interface.
/// @dev Base mainnet router: 0xBE6D8f0d05cC4be24d5167a3eF062215bE6D18a5.
///      Slipstream identifies a pool by tick spacing rather than a fee tier, and its params carry
///      an explicit deadline. Field order must match the deployed router.
interface ISlipstreamSwapRouter {
    struct ExactInputSingleParams {
        address tokenIn;
        address tokenOut;
        int24 tickSpacing;
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

// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

/// @notice One venue-specific swap primitive.
/// @dev The core transfers exactly `amountIn` of `tokenIn` to the adapter before calling this.
///      The adapter must consume all input, send output directly to `msg.sender` (the core), and
///      leave zero token balance behind. The core measures the real output by balance delta.
interface IAdapter {
    function step(
        address tokenIn,
        address tokenOut,
        uint256 amountIn,
        uint256 minAmountOut,
        bytes calldata data
    ) external;
}

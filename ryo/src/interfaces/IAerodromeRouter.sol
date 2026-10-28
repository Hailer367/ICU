// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

/// @notice Aerodrome classic router interface.
/// @dev Base mainnet router: 0xcF77a3Ba9A5CA399B7c97c74d54e5b1Beb874E43.
///      `factory == address(0)` means "use the router's default factory".
interface IAerodromeRouter {
    struct Route {
        address from;
        address to;
        bool stable;
        address factory;
    }

    function swapExactTokensForTokens(
        uint256 amountIn,
        uint256 amountOutMin,
        Route[] calldata routes,
        address to,
        uint256 deadline
    ) external returns (uint256[] memory amounts);
}

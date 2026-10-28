// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { IAerodromeRouter } from "../interfaces/IAerodromeRouter.sol";
import { AdapterBase } from "./AdapterBase.sol";

/// @notice Aerodrome classic single-hop adapter. `data = abi.encode(bool stable)`.
/// @dev Uses the router's default factory. Multi-hop routes are composed by the core.
contract AerodromeClassicAdapter is AdapterBase {
    constructor(address core_, address router_) AdapterBase(core_, router_) { }

    function step(
        address tokenIn,
        address tokenOut,
        uint256 amountIn,
        uint256 minAmountOut,
        bytes calldata data
    ) external onlyCore {
        if (data.length != 32) revert InvalidDataLength();
        bool stable = abi.decode(data, (bool));
        _checkStep(tokenIn, tokenOut, amountIn, minAmountOut);

        uint256 inBefore = _selfBalance(tokenIn);
        uint256 outBefore = _selfBalance(tokenOut);

        IAerodromeRouter.Route[] memory routes = new IAerodromeRouter.Route[](1);
        routes[0] = IAerodromeRouter.Route({
            from: tokenIn, to: tokenOut, stable: stable, factory: address(0)
        });

        _approve(tokenIn, amountIn);
        IAerodromeRouter(router)
            .swapExactTokensForTokens(amountIn, minAmountOut, routes, msg.sender, block.timestamp);
        _resetApproval(tokenIn);

        _requireInputConsumed(tokenIn, inBefore, amountIn);
        _requireNoOutputRetained(tokenOut, outBefore);
    }
}

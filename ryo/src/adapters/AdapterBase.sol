// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { IERC20 } from "@openzeppelin/contracts/token/ERC20/IERC20.sol";
import { SafeERC20 } from "@openzeppelin/contracts/token/ERC20/utils/SafeERC20.sol";

/// @notice Shared safety checks for stateless venue adapters.
/// @dev An adapter is bound to one core. It receives the exact input before `step`, approves the
///      router for exactly that amount, verifies that no token remains in the adapter, and resets
///      the approval. Output is sent directly to the core by the venue.
abstract contract AdapterBase {
    using SafeERC20 for IERC20;

    address public immutable core;
    address public immutable router;

    error Unauthorized();
    error ZeroAddress();
    error NotContract(address target);
    error ZeroAmount();
    error InvalidTokenPair();
    error InvalidMinAmountOut();
    error InvalidDataLength();
    error LeftoverToken(address token, uint256 balance);

    modifier onlyCore() {
        if (msg.sender != core) revert Unauthorized();
        _;
    }

    constructor(address core_, address router_) {
        if (core_ == address(0) || router_ == address(0)) revert ZeroAddress();
        if (core_.code.length == 0) revert NotContract(core_);
        if (router_.code.length == 0) revert NotContract(router_);
        core = core_;
        router = router_;
    }

    function _checkStep(address tokenIn, address tokenOut, uint256 amountIn, uint256 minAmountOut)
        internal
        pure
    {
        if (tokenIn == address(0) || tokenOut == address(0)) revert ZeroAddress();
        if (tokenIn == tokenOut) revert InvalidTokenPair();
        if (amountIn == 0) revert ZeroAmount();
        if (minAmountOut == 0) revert InvalidMinAmountOut();
    }

    function _approve(address token, uint256 amount) internal {
        IERC20(token).forceApprove(router, amount);
    }

    function _resetApproval(address token) internal {
        IERC20(token).forceApprove(router, 0);
    }

    function _selfBalance(address token) internal view returns (uint256) {
        return IERC20(token).balanceOf(address(this));
    }

    /// @dev The core transfers `amountIn` immediately before `step`, so the adapter's balance at
    ///      entry already includes it. After a correct swap the balance must fall back to the
    ///      adapter's pre-existing dust. This tolerates donations (which would otherwise let
    ///      anyone brick an adapter with 1 wei) while still catching a router that pulls less.
    function _requireInputConsumed(address token, uint256 balanceBefore, uint256 amountIn)
        internal
        view
    {
        uint256 balanceAfter = IERC20(token).balanceOf(address(this));
        if (balanceBefore < amountIn || balanceAfter != balanceBefore - amountIn) {
            revert LeftoverToken(token, balanceAfter);
        }
    }

    /// @dev Output must go straight to the core. Pre-existing dust is allowed to stay, but the
    ///      adapter must not end up holding more of the output token than it started with.
    function _requireNoOutputRetained(address token, uint256 balanceBefore) internal view {
        uint256 balanceAfter = IERC20(token).balanceOf(address(this));
        if (balanceAfter > balanceBefore) revert LeftoverToken(token, balanceAfter);
    }
}

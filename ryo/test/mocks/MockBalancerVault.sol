// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { IERC20 } from "@openzeppelin/contracts/token/ERC20/IERC20.sol";
import { SafeERC20 } from "@openzeppelin/contracts/token/ERC20/utils/SafeERC20.sol";

import { IBalancerVault } from "../../src/interfaces/IBalancerVault.sol";
import { IFlashLoanRecipient } from "../../src/interfaces/IFlashLoanRecipient.sol";

/// @notice Local Balancer Vault double with configurable failure modes.
contract MockBalancerVault is IBalancerVault {
    using SafeERC20 for IERC20;

    uint256 public feeBps;
    bool public silent;
    bool public doubleCallback;

    bool public useCallbackOverrides;
    address public callbackTokenOverride;
    uint256 public callbackAmountOverride;

    bool public overrideUserData;
    bytes public callbackUserDataOverride;

    bytes public lastUserData;
    address public lastLoanToken;
    uint256 public lastLoanAmount;

    function setFeeBps(uint256 newFeeBps) external {
        feeBps = newFeeBps;
    }

    function setSilent(bool value) external {
        silent = value;
    }

    function setDoubleCallback(bool value) external {
        doubleCallback = value;
    }

    function setCallbackOverrides(address token, uint256 amount) external {
        useCallbackOverrides = true;
        callbackTokenOverride = token;
        callbackAmountOverride = amount;
    }

    function clearCallbackOverrides() external {
        useCallbackOverrides = false;
        callbackTokenOverride = address(0);
        callbackAmountOverride = 0;
    }

    function setOverrideUserData(bytes calldata data) external {
        overrideUserData = true;
        callbackUserDataOverride = data;
    }

    function clearOverrideUserData() external {
        overrideUserData = false;
        delete callbackUserDataOverride;
    }

    function flashLoan(
        IFlashLoanRecipient recipient,
        IERC20[] memory tokens,
        uint256[] memory amounts,
        bytes memory userData
    ) external override {
        require(tokens.length == amounts.length, "length");

        uint256 n = tokens.length;
        uint256[] memory balancesBefore = new uint256[](n);
        uint256[] memory fees = new uint256[](n);

        lastUserData = userData;
        if (n == 1) {
            lastLoanToken = address(tokens[0]);
            lastLoanAmount = amounts[0];
        }

        for (uint256 i = 0; i < n; ++i) {
            balancesBefore[i] = tokens[i].balanceOf(address(this));
            fees[i] = (amounts[i] * feeBps) / 10_000;
            tokens[i].safeTransfer(address(recipient), amounts[i]);
        }

        if (!silent) {
            IERC20[] memory cbTokens = tokens;
            uint256[] memory cbAmounts = amounts;
            if (useCallbackOverrides) {
                cbTokens = new IERC20[](1);
                cbTokens[0] = IERC20(callbackTokenOverride);
                cbAmounts = new uint256[](1);
                cbAmounts[0] = callbackAmountOverride;
            }
            bytes memory cbUserData = overrideUserData ? callbackUserDataOverride : userData;

            recipient.receiveFlashLoan(cbTokens, cbAmounts, fees, cbUserData);
            if (doubleCallback) {
                recipient.receiveFlashLoan(cbTokens, cbAmounts, fees, cbUserData);
            }

            for (uint256 i = 0; i < n; ++i) {
                // The Vault sent `amounts[i]` out and must receive it back. Its balance before
                // the loan was `balancesBefore[i]`, so after repayment it must be at least that
                // plus the fee. The principal is not added on top.
                uint256 expected = balancesBefore[i] + fees[i];
                require(tokens[i].balanceOf(address(this)) >= expected, "not repaid");
            }
        }
    }

    /// @notice Call the recipient hook directly, as the Vault would. Used for replay tests.
    function callCallbackDirect(
        IFlashLoanRecipient recipient,
        IERC20[] memory tokens,
        uint256[] memory amounts,
        uint256[] memory fees,
        bytes memory userData
    ) external {
        recipient.receiveFlashLoan(tokens, amounts, fees, userData);
    }
}

// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { IERC20 } from "@openzeppelin/contracts/token/ERC20/IERC20.sol";
import { IFlashLoanRecipient } from "../../src/interfaces/IFlashLoanRecipient.sol";

/// @notice Calls the callback from an address that is not the configured Vault.
contract FakeVault {
    function callReceive(
        IFlashLoanRecipient recipient,
        IERC20[] memory tokens,
        uint256[] memory amounts,
        uint256[] memory fees,
        bytes memory userData
    ) external {
        recipient.receiveFlashLoan(tokens, amounts, fees, userData);
    }
}

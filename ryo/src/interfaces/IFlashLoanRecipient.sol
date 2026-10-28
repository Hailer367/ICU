// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { IERC20 } from "@openzeppelin/contracts/token/ERC20/IERC20.sol";

/// @notice Balancer V2 flash-loan recipient interface.
/// @dev The Vault transfers the loan to the recipient, calls this hook, and then verifies that its
///      own balance has increased by `amount + fee`. The recipient must push the repayment back.
interface IFlashLoanRecipient {
    function receiveFlashLoan(
        IERC20[] memory tokens,
        uint256[] memory amounts,
        uint256[] memory feeAmounts,
        bytes memory userData
    ) external;
}

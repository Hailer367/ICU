// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { IERC20 } from "@openzeppelin/contracts/token/ERC20/IERC20.sol";
import { SafeERC20 } from "@openzeppelin/contracts/token/ERC20/utils/SafeERC20.sol";

import { IAerodromeRouter } from "../../src/interfaces/IAerodromeRouter.sol";
import { MockERC20 } from "./MockERC20.sol";

contract MockAerodromeRouter is IAerodromeRouter {
    using SafeERC20 for IERC20;

    uint256 public rateBps = 10_000;
    uint256 public pullBps = 10_000;
    bool public sendToRecipient = true;

    address public lastFrom;
    address public lastToToken;
    bool public lastStable;
    address public lastFactory;
    address public lastToAddress;
    uint256 public lastDeadline;
    uint256 public lastAmountIn;
    uint256 public lastAmountOutMin;

    function setRateBps(uint256 value) external {
        rateBps = value;
    }

    function setPullBps(uint256 value) external {
        pullBps = value;
    }

    function setSendToRecipient(bool value) external {
        sendToRecipient = value;
    }

    function swapExactTokensForTokens(
        uint256 amountIn,
        uint256 amountOutMin,
        Route[] calldata routes,
        address to,
        uint256 deadline
    ) external returns (uint256[] memory amounts) {
        Route calldata route = routes[0];
        lastFrom = route.from;
        lastToToken = route.to;
        lastStable = route.stable;
        lastFactory = route.factory;
        lastToAddress = to;
        lastDeadline = deadline;
        lastAmountIn = amountIn;
        lastAmountOutMin = amountOutMin;

        uint256 pulled = (amountIn * pullBps) / 10_000;
        IERC20(route.from).safeTransferFrom(msg.sender, address(this), pulled);
        uint256 out = (pulled * rateBps) / 10_000;

        address recipient = sendToRecipient ? to : msg.sender;
        MockERC20(route.to).mint(recipient, out);

        amounts = new uint256[](2);
        amounts[0] = amountIn;
        amounts[1] = out;
    }
}

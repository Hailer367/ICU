// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { IERC20 } from "@openzeppelin/contracts/token/ERC20/IERC20.sol";
import { SafeERC20 } from "@openzeppelin/contracts/token/ERC20/utils/SafeERC20.sol";

import { ISlipstreamSwapRouter } from "../../src/interfaces/ISlipstreamSwapRouter.sol";
import { MockERC20 } from "./MockERC20.sol";

contract MockSlipstreamRouter is ISlipstreamSwapRouter {
    using SafeERC20 for IERC20;

    uint256 public rateBps = 10_000;
    uint256 public pullBps = 10_000;
    bool public sendToRecipient = true;

    address public lastTokenIn;
    address public lastTokenOut;
    int24 public lastTickSpacing;
    address public lastRecipient;
    uint256 public lastDeadline;
    uint256 public lastAmountIn;
    uint256 public lastAmountOutMinimum;
    uint160 public lastSqrtPriceLimitX96;

    function setRateBps(uint256 value) external {
        rateBps = value;
    }

    function setPullBps(uint256 value) external {
        pullBps = value;
    }

    function setSendToRecipient(bool value) external {
        sendToRecipient = value;
    }

    function exactInputSingle(ExactInputSingleParams calldata params)
        external
        payable
        returns (uint256 amountOut)
    {
        lastTokenIn = params.tokenIn;
        lastTokenOut = params.tokenOut;
        lastTickSpacing = params.tickSpacing;
        lastRecipient = params.recipient;
        lastDeadline = params.deadline;
        lastAmountIn = params.amountIn;
        lastAmountOutMinimum = params.amountOutMinimum;
        lastSqrtPriceLimitX96 = params.sqrtPriceLimitX96;

        uint256 pulled = (params.amountIn * pullBps) / 10_000;
        IERC20(params.tokenIn).safeTransferFrom(msg.sender, address(this), pulled);
        amountOut = (pulled * rateBps) / 10_000;

        address to = sendToRecipient ? params.recipient : msg.sender;
        MockERC20(params.tokenOut).mint(to, amountOut);
    }
}

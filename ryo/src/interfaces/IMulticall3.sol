// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

/// @notice Minimal Multicall3 interface. Base has Multicall3 at the canonical address.
interface IMulticall3 {
    struct Call3 {
        address target;
        bool allowFailure;
        bytes callData;
    }

    struct Result {
        bool success;
        bytes returnData;
    }

    function aggregate3(Call3[] calldata calls) external payable returns (Result[] memory);
}

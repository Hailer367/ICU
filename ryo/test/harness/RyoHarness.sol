// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { RyoCore } from "../../src/RyoCore.sol";
import { IBalancerVault } from "../../src/interfaces/IBalancerVault.sol";

/// @notice Exposes transient execution state for callback-security tests.
contract RyoHarness is RyoCore {
    constructor(
        IBalancerVault vault_,
        address initialOwner,
        address initialOperator,
        address initialProfitRecipient
    ) RyoCore(vault_, initialOwner, initialOperator, initialProfitRecipient) { }

    function setTransient(
        bytes32 routeHash,
        address loanAsset,
        uint256 loanAmount,
        uint256 balanceBefore,
        bool simulation
    ) external {
        _routeHash = routeHash;
        _loanAsset = loanAsset;
        _loanAmount = loanAmount;
        _balanceBefore = balanceBefore;
        _simulation = simulation;
        _routeConsumed = 0;
    }

    function routeConsumed() external view returns (uint256) {
        return _routeConsumed;
    }
}

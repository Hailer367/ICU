// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { ERC20 } from "@openzeppelin/contracts/token/ERC20/ERC20.sol";

/// @notice ERC20 that burns a fee on every transfer. Used to prove the core rejects
///         fee-on-transfer input tokens instead of silently under-accounting.
contract MockFeeERC20 is ERC20 {
    uint8 private immutable _decimals;
    uint256 public feeBps;

    constructor(string memory name_, string memory symbol_, uint8 decimals_, uint256 feeBps_)
        ERC20(name_, symbol_)
    {
        _decimals = decimals_;
        feeBps = feeBps_;
    }

    function decimals() public view override returns (uint8) {
        return _decimals;
    }

    function setFeeBps(uint256 newFeeBps) external {
        feeBps = newFeeBps;
    }

    function mint(address to, uint256 amount) external {
        _mint(to, amount);
    }

    function burn(address from, uint256 amount) external {
        _burn(from, amount);
    }

    function _update(address from, address to, uint256 value) internal override {
        if (feeBps != 0 && from != address(0) && to != address(0)) {
            uint256 fee = (value * feeBps) / 10_000;
            if (fee != 0) {
                super._update(from, address(0), fee);
                value -= fee;
            }
        }
        super._update(from, to, value);
    }
}

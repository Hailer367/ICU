// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

/// @notice Deliberately non-compliant ERC20 used to reach defensive branches.
/// @dev Transfers never revert. If the sender lacks funds the amount is clamped, and an optional
///      fee is burned. Tokens with this kind of behaviour (or rebasing tokens) exist in the wild,
///      so the core must fail closed with a named error instead of panicking on an underflow.
contract MockSoftERC20 {
    string public name;
    string public symbol;
    uint8 public immutable decimals;
    uint256 public totalSupply;
    uint256 public feeBps;

    mapping(address => uint256) public balanceOf;
    mapping(address => mapping(address => uint256)) public allowance;

    event Transfer(address indexed from, address indexed to, uint256 value);
    event Approval(address indexed owner, address indexed spender, uint256 value);

    constructor(string memory name_, string memory symbol_, uint8 decimals_, uint256 feeBps_) {
        name = name_;
        symbol = symbol_;
        decimals = decimals_;
        feeBps = feeBps_;
    }

    function mint(address to, uint256 amount) external {
        totalSupply += amount;
        balanceOf[to] += amount;
        emit Transfer(address(0), to, amount);
    }

    function setFeeBps(uint256 newFeeBps) external {
        feeBps = newFeeBps;
    }

    function approve(address spender, uint256 value) external returns (bool) {
        allowance[msg.sender][spender] = value;
        emit Approval(msg.sender, spender, value);
        return true;
    }

    function transfer(address to, uint256 value) external returns (bool) {
        _move(msg.sender, to, value);
        return true;
    }

    function transferFrom(address from, address to, uint256 value) external returns (bool) {
        uint256 allowed = allowance[from][msg.sender];
        if (value > allowed) value = allowed;
        allowance[from][msg.sender] = allowed - value;
        _move(from, to, value);
        return true;
    }

    /// @dev Never reverts: clamps to the sender's balance, then burns the fee if configured.
    function _move(address from, address to, uint256 value) internal {
        uint256 balance = balanceOf[from];
        if (value > balance) value = balance;

        if (feeBps != 0) {
            uint256 fee = (value * feeBps) / 10_000;
            if (fee != 0) {
                balanceOf[from] -= fee;
                totalSupply -= fee;
                value -= fee;
                emit Transfer(from, address(0), fee);
            }
        }

        balanceOf[from] -= value;
        balanceOf[to] += value;
        emit Transfer(from, to, value);
    }
}

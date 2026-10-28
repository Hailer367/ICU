// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { IERC20 } from "@openzeppelin/contracts/token/ERC20/IERC20.sol";
import { SafeERC20 } from "@openzeppelin/contracts/token/ERC20/utils/SafeERC20.sol";
import { Ownable } from "@openzeppelin/contracts/access/Ownable.sol";
import { Ownable2Step } from "@openzeppelin/contracts/access/Ownable2Step.sol";
import {
    ReentrancyGuardTransient
} from "@openzeppelin/contracts/utils/ReentrancyGuardTransient.sol";

import { IAdapter } from "./interfaces/IAdapter.sol";
import { IBalancerVault } from "./interfaces/IBalancerVault.sol";
import { IFlashLoanRecipient } from "./interfaces/IFlashLoanRecipient.sol";

/// @title RyoCore
/// @notice Immutable Balancer-flash-loan executor for linear, multi-venue arbitrage routes.
/// @dev The core knows nothing about individual DEXes. It moves tokens through whitelisted
///      adapters, measures every output by balance delta, enforces per-step floors, repays the
///      loan, and forwards the realized profit. It holds no funds between transactions.
contract RyoCore is IFlashLoanRecipient, Ownable2Step, ReentrancyGuardTransient {
    using SafeERC20 for IERC20;

    // --------------------------------------------------------------------------------------------
    // Constants and types
    // --------------------------------------------------------------------------------------------

    /// @notice Envelope version used by `execute` and `simulate`.
    uint8 public constant VERSION = 1;

    /// @notice Maximum number of steps in one route. Bounds gas and calldata.
    uint256 public constant MAX_STEPS = 8;

    /// @notice One leg of a route.
    /// @param adapter Whitelisted venue adapter.
    /// @param tokenIn Token handed to the adapter.
    /// @param tokenOut Token the adapter must send back to the core.
    /// @param minAmountOut Hard floor for this leg, in `tokenOut` units.
    /// @param data Adapter-specific parameters (fee tier, tick spacing, stable flag, ...).
    struct Step {
        address adapter;
        address tokenIn;
        address tokenOut;
        uint256 minAmountOut;
        bytes data;
    }

    // --------------------------------------------------------------------------------------------
    // Immutable and configuration
    // --------------------------------------------------------------------------------------------

    /// @notice Balancer V2 Vault used for flash loans.
    IBalancerVault public immutable vault;

    /// @notice Hot wallet allowed to execute and pause. Owner can also execute.
    address public operator;

    /// @notice Address that receives realized profit.
    address public profitRecipient;

    /// @notice Emergency stop for execution. Simulations remain available while paused.
    bool public paused;

    /// @notice Approved adapters. Default deny.
    mapping(address adapter => bool allowed) public isAdapter;

    /// @notice Per-asset maximum borrow size. Zero disables trading for that asset.
    mapping(address asset => uint256 maxAmount) public maxTradeSize;

    /// @notice Optional gas-price ceiling in wei. Zero disables the check.
    uint256 public maxGasPrice;

    // --------------------------------------------------------------------------------------------
    // Transient execution state (cleared automatically at the end of the transaction)
    // --------------------------------------------------------------------------------------------

    bytes32 internal _routeHash;
    uint256 internal _routeConsumed;
    address internal _loanAsset;
    uint256 internal _loanAmount;
    uint256 internal _balanceBefore;
    bool internal _simulation;

    // --------------------------------------------------------------------------------------------
    // Events
    // --------------------------------------------------------------------------------------------

    event Executed(
        address indexed operator,
        address indexed asset,
        uint256 amount,
        uint256 profit,
        address indexed recipient,
        bytes32 routeHash
    );
    event AdapterSet(address indexed adapter, bool allowed);
    event OperatorSet(address indexed operator);
    event ProfitRecipientSet(address indexed recipient);
    event MaxTradeSizeSet(address indexed asset, uint256 maxAmount);
    event MaxGasPriceSet(uint256 maxGasPrice);
    event Paused(address indexed by);
    event Unpaused(address indexed by);
    event Swept(address indexed token, address indexed to, uint256 amount);

    // --------------------------------------------------------------------------------------------
    // Errors
    // --------------------------------------------------------------------------------------------

    error ZeroAddress();
    error ZeroAmount();
    error NotContract(address target);
    error NotOperator(address caller);
    error ContractPaused();
    error ContractNotPaused();
    error AdapterNotAllowed(address adapter);
    error TradeNotAllowed(address asset);
    error TradeTooLarge(address asset, uint256 amount, uint256 maxAmount);
    error GasPriceTooHigh(uint256 gasPrice, uint256 maxGasPrice);
    error InvalidProfitRecipient();
    error RouteTooShort();
    error RouteTooLong(uint256 length);
    error RouteMismatch(uint256 index);
    error InvalidStep(uint256 index);
    error InvalidMinOut(uint256 index);
    error InputNotConsumed(uint256 index, uint256 expected, uint256 actual);
    error AdapterKeptInput(
        uint256 index, address adapter, uint256 beforeBalance, uint256 afterBalance
    );
    error InsufficientOutput(uint256 index, uint256 amountOut, uint256 minAmountOut);
    error NegativeOutput(uint256 index);
    error UnauthorizedCallback();
    error CallbackAlreadyConsumed();
    error CallbackNotCalled();
    error InvalidFlashLoanData();
    error InvalidRouteVersion(uint8 version);
    error Loss(uint256 balanceAfter, uint256 balanceBefore);
    error MinProfitNotMet(uint256 profit, uint256 minProfit);
    error SimulationFailed();

    /// @notice Simulation result. `simulate` always reverts with this error.
    error SimulationResult(int256 profit);

    // --------------------------------------------------------------------------------------------
    // Construction
    // --------------------------------------------------------------------------------------------

    constructor(
        IBalancerVault vault_,
        address initialOwner,
        address initialOperator,
        address initialProfitRecipient
    ) Ownable(initialOwner) {
        if (address(vault_) == address(0)) revert ZeroAddress();
        if (address(vault_).code.length == 0) revert NotContract(address(vault_));
        if (initialOperator == address(0)) revert ZeroAddress();
        if (initialProfitRecipient == address(0) || initialProfitRecipient == address(this)) {
            revert InvalidProfitRecipient();
        }

        vault = vault_;
        operator = initialOperator;
        profitRecipient = initialProfitRecipient;

        emit OperatorSet(initialOperator);
        emit ProfitRecipientSet(initialProfitRecipient);
    }

    // --------------------------------------------------------------------------------------------
    // Execution
    // --------------------------------------------------------------------------------------------

    /// @notice Borrow `asset`, run `steps`, repay the loan, and send the profit to the recipient.
    /// @param asset Borrowed asset. Must be the first `tokenIn` and the last `tokenOut`.
    /// @param amount Amount to borrow.
    /// @param steps Linear route. At least 2 steps, at most `MAX_STEPS`.
    /// @param minProfit Minimum profit in `asset` after repayment. Reverts if not met.
    /// @return profit Realized profit sent to the profit recipient.
    function execute(address asset, uint256 amount, Step[] calldata steps, uint256 minProfit)
        external
        nonReentrant
        onlyOperator
        whenNotPaused
        returns (uint256 profit)
    {
        if (asset == address(0)) revert ZeroAddress();
        if (amount == 0) revert ZeroAmount();

        uint256 cap = maxTradeSize[asset];
        if (cap == 0) revert TradeNotAllowed(asset);
        if (amount > cap) revert TradeTooLarge(asset, amount, cap);

        _checkGasPrice();
        _validateSteps(asset, steps);

        uint256 balanceBefore = IERC20(asset).balanceOf(address(this));
        bytes memory userData = abi.encode(VERSION, steps);
        bytes32 routeHash = keccak256(userData);

        _routeHash = routeHash;
        _routeConsumed = 0;
        _loanAsset = asset;
        _loanAmount = amount;
        _balanceBefore = balanceBefore;
        _simulation = false;

        _flashLoan(asset, amount, userData);

        if (_routeConsumed == 0) revert CallbackNotCalled();

        _routeHash = bytes32(0);
        _loanAsset = address(0);
        _loanAmount = 0;
        _balanceBefore = 0;
        _simulation = false;

        uint256 balanceAfter = IERC20(asset).balanceOf(address(this));
        if (balanceAfter < balanceBefore) revert Loss(balanceAfter, balanceBefore);
        profit = balanceAfter - balanceBefore;

        if (profit < minProfit) revert MinProfitNotMet(profit, minProfit);

        address recipient = profitRecipient;
        emit Executed(msg.sender, asset, amount, profit, recipient, routeHash);
        if (profit != 0) IERC20(asset).safeTransfer(recipient, profit);
    }

    /// @notice Dry-run a route. Always reverts with `SimulationResult(int256 profit)`.
    /// @dev Permissionless and available while paused. No state survives the call. A negative
    ///      result is the exact loss after the flash-loan fee and before gas.
    function simulate(address asset, uint256 amount, Step[] calldata steps) external nonReentrant {
        if (asset == address(0)) revert ZeroAddress();
        if (amount == 0) revert ZeroAmount();
        _validateSteps(asset, steps);

        uint256 balanceBefore = IERC20(asset).balanceOf(address(this));
        bytes memory userData = abi.encode(VERSION, steps);
        bytes32 routeHash = keccak256(userData);

        _routeHash = routeHash;
        _routeConsumed = 0;
        _loanAsset = asset;
        _loanAmount = amount;
        _balanceBefore = balanceBefore;
        _simulation = true;

        _flashLoan(asset, amount, userData);

        // A compliant Vault always calls the callback, which reverts with `SimulationResult`.
        // Reaching this point means the Vault did not run the route.
        revert SimulationFailed();
    }

    // --------------------------------------------------------------------------------------------
    // Balancer callback
    // --------------------------------------------------------------------------------------------

    /// @inheritdoc IFlashLoanRecipient
    /// @dev Security model:
    ///      1. Only the immutable Balancer Vault may call.
    ///      2. The transient hash must match the exact `userData` set by execute/simulate.
    ///      3. A consumed flag rejects a second callback in the same transaction.
    ///      4. Borrowed token and amount must match the transient expectation.
    ///      5. Every output is measured by balance delta, never by a router return value.
    function receiveFlashLoan(
        IERC20[] memory tokens,
        uint256[] memory amounts,
        uint256[] memory feeAmounts,
        bytes memory userData
    ) external override {
        if (msg.sender != address(vault)) revert UnauthorizedCallback();
        if (_routeConsumed != 0) revert CallbackAlreadyConsumed();

        bytes32 expected = _routeHash;
        if (expected == bytes32(0) || keccak256(userData) != expected) {
            revert UnauthorizedCallback();
        }
        _routeConsumed = 1;

        if (tokens.length != 1 || amounts.length != 1 || feeAmounts.length != 1) {
            revert InvalidFlashLoanData();
        }

        address asset = address(tokens[0]);
        uint256 amount = amounts[0];
        if (asset == address(0) || asset != _loanAsset || amount != _loanAmount) {
            revert InvalidFlashLoanData();
        }

        (uint8 version, Step[] memory steps) = abi.decode(userData, (uint8, Step[]));
        if (version != VERSION) revert InvalidRouteVersion(version);

        uint256 len = steps.length;
        if (len < 2) revert RouteTooShort();
        if (len > MAX_STEPS) revert RouteTooLong(len);

        address currentToken = asset;
        uint256 amountIn = amount;

        for (uint256 i = 0; i < len; ++i) {
            Step memory s = steps[i];

            if (s.tokenIn != currentToken) revert RouteMismatch(i);
            if (s.tokenIn == address(0) || s.tokenOut == address(0)) revert InvalidStep(i);
            if (s.tokenIn == s.tokenOut) revert InvalidStep(i);
            if (s.adapter == address(0) || !isAdapter[s.adapter]) {
                revert AdapterNotAllowed(s.adapter);
            }
            if (s.minAmountOut == 0) revert InvalidMinOut(i);

            uint256 inBefore = IERC20(s.tokenIn).balanceOf(address(this));
            uint256 adapterInBefore = IERC20(s.tokenIn).balanceOf(s.adapter);
            uint256 outBefore = IERC20(s.tokenOut).balanceOf(address(this));

            IERC20(s.tokenIn).safeTransfer(s.adapter, amountIn);
            IAdapter(s.adapter).step(s.tokenIn, s.tokenOut, amountIn, s.minAmountOut, s.data);

            // The core must have spent exactly `amountIn` of tokenIn and received no refund.
            uint256 inAfter = IERC20(s.tokenIn).balanceOf(address(this));
            if (inBefore < amountIn) revert InputNotConsumed(i, amountIn, inBefore);
            uint256 expectedIn = inBefore - amountIn;
            if (inAfter != expectedIn) revert InputNotConsumed(i, expectedIn, inAfter);

            // The adapter must not retain any of the input. This catches buggy adapters and
            // fee-on-transfer tokens that leave value behind.
            uint256 adapterInAfter = IERC20(s.tokenIn).balanceOf(s.adapter);
            if (adapterInAfter > adapterInBefore) {
                revert AdapterKeptInput(i, s.adapter, adapterInBefore, adapterInAfter);
            }

            uint256 outAfter = IERC20(s.tokenOut).balanceOf(address(this));
            if (outAfter < outBefore) revert NegativeOutput(i);
            uint256 amountOut = outAfter - outBefore;
            if (amountOut < s.minAmountOut) {
                revert InsufficientOutput(i, amountOut, s.minAmountOut);
            }

            amountIn = amountOut;
            currentToken = s.tokenOut;
        }

        if (currentToken != asset) revert RouteMismatch(len);

        uint256 available = IERC20(asset).balanceOf(address(this));
        uint256 owed = amount + feeAmounts[0];

        if (_simulation) {
            int256 p = int256(available) - int256(owed) - int256(_balanceBefore);
            revert SimulationResult(p);
        }

        // Never let pre-existing dust subsidize a losing route.
        if (available < owed || available - owed < _balanceBefore) {
            revert Loss(available > owed ? available - owed : 0, _balanceBefore);
        }

        // Balancer does not pull repayment; it checks its own balance after this callback.
        IERC20(asset).safeTransfer(address(vault), owed);
    }

    // --------------------------------------------------------------------------------------------
    // Admin
    // --------------------------------------------------------------------------------------------

    /// @notice Pause execution. Callable by the operator or owner.
    function pause() external {
        if (msg.sender != operator && msg.sender != owner()) revert NotOperator(msg.sender);
        if (paused) revert ContractPaused();
        paused = true;
        emit Paused(msg.sender);
    }

    /// @notice Unpause execution. Owner only.
    function unpause() external onlyOwner {
        if (!paused) revert ContractNotPaused();
        paused = false;
        emit Unpaused(msg.sender);
    }

    function setOperator(address newOperator) external onlyOwner {
        if (newOperator == address(0)) revert ZeroAddress();
        operator = newOperator;
        emit OperatorSet(newOperator);
    }

    function setProfitRecipient(address newRecipient) external onlyOwner {
        if (newRecipient == address(0) || newRecipient == address(this)) {
            revert InvalidProfitRecipient();
        }
        profitRecipient = newRecipient;
        emit ProfitRecipientSet(newRecipient);
    }

    function setAdapter(address adapter, bool allowed) external onlyOwner {
        if (adapter == address(0)) revert ZeroAddress();
        if (allowed && adapter.code.length == 0) revert NotContract(adapter);
        isAdapter[adapter] = allowed;
        emit AdapterSet(adapter, allowed);
    }

    /// @notice Set the maximum borrow size for an asset. Zero disables trading for it.
    function setMaxTradeSize(address asset, uint256 maxAmount) external onlyOwner {
        if (asset == address(0)) revert ZeroAddress();
        maxTradeSize[asset] = maxAmount;
        emit MaxTradeSizeSet(asset, maxAmount);
    }

    /// @notice Set the optional gas-price ceiling in wei. Zero disables the check.
    function setMaxGasPrice(uint256 newMaxGasPrice) external onlyOwner {
        maxGasPrice = newMaxGasPrice;
        emit MaxGasPriceSet(newMaxGasPrice);
    }

    /// @notice Sweep the full balance of a token. Owner only, never during an execution.
    function sweep(address token, address to) external nonReentrant onlyOwner {
        if (token == address(0) || to == address(0)) revert ZeroAddress();
        uint256 balance = IERC20(token).balanceOf(address(this));
        emit Swept(token, to, balance);
        if (balance != 0) IERC20(token).safeTransfer(to, balance);
    }

    // --------------------------------------------------------------------------------------------
    // Internal
    // --------------------------------------------------------------------------------------------

    function _flashLoan(address asset, uint256 amount, bytes memory userData) private {
        IERC20[] memory tokens = new IERC20[](1);
        tokens[0] = IERC20(asset);
        uint256[] memory amounts = new uint256[](1);
        amounts[0] = amount;
        vault.flashLoan(this, tokens, amounts, userData);
    }

    function _validateSteps(address asset, Step[] calldata steps) private view {
        uint256 len = steps.length;
        if (len < 2) revert RouteTooShort();
        if (len > MAX_STEPS) revert RouteTooLong(len);

        address previous = asset;
        for (uint256 i = 0; i < len; ++i) {
            Step calldata s = steps[i];
            if (s.tokenIn != previous) revert RouteMismatch(i);
            if (s.tokenIn == address(0) || s.tokenOut == address(0)) revert InvalidStep(i);
            if (s.tokenIn == s.tokenOut) revert InvalidStep(i);
            if (s.adapter == address(0) || !isAdapter[s.adapter]) {
                revert AdapterNotAllowed(s.adapter);
            }
            if (s.minAmountOut == 0) revert InvalidMinOut(i);
            previous = s.tokenOut;
        }

        if (previous != asset) revert RouteMismatch(len);
    }

    function _checkGasPrice() private view {
        uint256 max = maxGasPrice;
        if (max != 0 && tx.gasprice > max) revert GasPriceTooHigh(tx.gasprice, max);
    }

    // --------------------------------------------------------------------------------------------
    // Modifiers
    // --------------------------------------------------------------------------------------------

    modifier onlyOperator() {
        if (msg.sender != operator && msg.sender != owner()) revert NotOperator(msg.sender);
        _;
    }

    modifier whenNotPaused() {
        if (paused) revert ContractPaused();
        _;
    }
}

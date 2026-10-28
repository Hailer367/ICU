// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { Test } from "forge-std/Test.sol";

import { RyoCore } from "../src/RyoCore.sol";
import { IBalancerVault } from "../src/interfaces/IBalancerVault.sol";

import { MockAdapter } from "./mocks/MockAdapter.sol";
import { MockBalancerVault } from "./mocks/MockBalancerVault.sol";
import { MockERC20 } from "./mocks/MockERC20.sol";

abstract contract BaseTest is Test {
    MockERC20 internal tokenA;
    MockERC20 internal tokenB;
    MockBalancerVault internal vault;
    RyoCore internal core;
    MockAdapter internal adapterA;
    MockAdapter internal adapterB;

    address internal recipient = address(0xBEEF);
    address internal stranger = address(0xBAD);
    address internal newOwner = address(0xCAFE);
    address internal newOperator = address(0xF00D);

    uint256 internal constant INITIAL_VAULT_BALANCE = 1_000_000e18;

    function setUp() public virtual {
        tokenA = new MockERC20("Token A", "A", 18);
        tokenB = new MockERC20("Token B", "B", 18);

        vault = new MockBalancerVault();
        tokenA.mint(address(vault), INITIAL_VAULT_BALANCE);

        core = new RyoCore(IBalancerVault(address(vault)), address(this), address(this), recipient);

        adapterA = new MockAdapter(address(core));
        adapterB = new MockAdapter(address(core));
        adapterA.setRateBps(10_100);
        adapterB.setRateBps(10_100);

        core.setAdapter(address(adapterA), true);
        core.setAdapter(address(adapterB), true);
        core.setMaxTradeSize(address(tokenA), INITIAL_VAULT_BALANCE);
    }

    function _steps() internal view returns (RyoCore.Step[] memory steps) {
        steps = new RyoCore.Step[](2);
        steps[0] = RyoCore.Step({
            adapter: address(adapterA),
            tokenIn: address(tokenA),
            tokenOut: address(tokenB),
            minAmountOut: 1,
            data: ""
        });
        steps[1] = RyoCore.Step({
            adapter: address(adapterB),
            tokenIn: address(tokenB),
            tokenOut: address(tokenA),
            minAmountOut: 1,
            data: ""
        });
    }

    function _alternatingSteps(uint256 length) internal view returns (RyoCore.Step[] memory steps) {
        steps = new RyoCore.Step[](length);
        for (uint256 i = 0; i < length; ++i) {
            if (i % 2 == 0) {
                steps[i] = RyoCore.Step({
                    adapter: address(adapterA),
                    tokenIn: address(tokenA),
                    tokenOut: address(tokenB),
                    minAmountOut: 1,
                    data: ""
                });
            } else {
                steps[i] = RyoCore.Step({
                    adapter: address(adapterB),
                    tokenIn: address(tokenB),
                    tokenOut: address(tokenA),
                    minAmountOut: 1,
                    data: ""
                });
            }
        }
    }

    function _routeHash(RyoCore.Step[] memory steps) internal pure returns (bytes32) {
        return keccak256(abi.encode(uint8(1), steps));
    }

    function _execute(uint256 amount, uint256 minProfit) internal returns (uint256) {
        return core.execute(address(tokenA), amount, _steps(), minProfit);
    }

    function _simulationResult(RyoCore.Step[] memory steps, uint256 amount)
        internal
        returns (int256 result)
    {
        try core.simulate(address(tokenA), amount, steps) {
            revert("simulate returned");
        } catch (bytes memory data) {
            bytes4 selector;
            assembly {
                selector := mload(add(data, 0x20))
            }
            if (selector != RyoCore.SimulationResult.selector) {
                assembly {
                    revert(add(data, 0x20), mload(data))
                }
            }
            assembly {
                result := mload(add(data, 0x24))
            }
        }
    }

    function _expectExecuteRevert(bytes memory err, RyoCore.Step[] memory steps, uint256 amount)
        internal
    {
        vm.expectRevert(err);
        core.execute(address(tokenA), amount, steps, 0);
    }

    function _mintToCore(uint256 amount) internal {
        tokenA.mint(address(core), amount);
    }
}

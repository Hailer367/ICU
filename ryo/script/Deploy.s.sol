// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { Script } from "forge-std/Script.sol";
import { console2 } from "forge-std/console2.sol";

import { RyoCore } from "../src/RyoCore.sol";
import { AerodromeClassicAdapter } from "../src/adapters/AerodromeClassicAdapter.sol";
import { SlipstreamAdapter } from "../src/adapters/SlipstreamAdapter.sol";
import { UniV2Adapter } from "../src/adapters/UniV2Adapter.sol";
import { UniV3Adapter } from "../src/adapters/UniV3Adapter.sol";
import { IBalancerVault } from "../src/interfaces/IBalancerVault.sol";

/// @notice Deploys Ryo on Base: one core, four venue adapters, all whitelisted.
/// @dev Every trade cap starts at zero (disabled). The owner must explicitly enable an asset and
///      set a size before the contract can trade. If OWNER differs from the deployer, ownership is
///      handed off at the end and the new owner must call `acceptOwnership()` afterwards.
///
///      Required env:
///        PRIVATE_KEY        deployer key (never commit it)
///      Optional env:
///        OWNER              final owner; defaults to the deployer
///        OPERATOR           hot wallet allowed to execute and pause; defaults to the deployer
///        PROFIT_RECIPIENT   profit receiver; defaults to OWNER
///        MAX_GAS_PRICE      execution gas-price ceiling in wei; 0 disables (default)
///        MAX_TRADE_WETH     per-trade WETH cap in wei (18 decimals); 0 disables
///        MAX_TRADE_USDC     per-trade USDC cap in 6-decimal units; 0 disables
///        MAX_TRADE_CBBTC    per-trade cbBTC cap in 8-decimal units; 0 disables
///        MAX_TRADE_EURC     per-trade EURC cap in 6-decimal units; 0 disables
///        MAX_TRADE_AERO     per-trade AERO cap in wei (18 decimals); 0 disables
contract Deploy is Script {
    // --- Base mainnet addresses -------------------------------------------------------------
    address public constant BALANCER_VAULT = 0xBA12222222228d8Ba445958a75a0704d566BF2C8;
    address public constant UNIV3_ROUTER = 0x2626664c2603336E57B271c5C0b26F421741e481;
    address public constant UNIV2_ROUTER = 0x4752ba5DBc23f44D87826276BF6Fd6b1C372aD24;
    address public constant AERO_ROUTER = 0xcF77a3Ba9A5CA399B7c97c74d54e5b1Beb874E43;
    address public constant SLIP_ROUTER = 0xBE6D8f0d05cC4be24d5167a3eF062215bE6D18a5;

    address public constant WETH = 0x4200000000000000000000000000000000000006;
    address public constant USDC = 0x833589fCD6eDb6E08f4c7C32D4f71b54bdA02913;
    address public constant CBBTC = 0xcbB7C0000aB88B473b1f5aFd9ef808440eed33Bf;
    address public constant EURC = 0x60a3E35Cc302bFA44Cb288Bc5a4F316Fdb1adb42;
    address public constant AERO = 0x940181a94A35A4569E4529A3CDfB74e38FD98631;

    function run() external {
        uint256 privateKey = vm.envUint("PRIVATE_KEY");
        address deployer = vm.addr(privateKey);

        address owner = vm.envOr("OWNER", deployer);
        address operator = vm.envOr("OPERATOR", deployer);
        address recipient = vm.envOr("PROFIT_RECIPIENT", owner);
        uint256 maxGasPrice = vm.envOr("MAX_GAS_PRICE", uint256(0));

        vm.startBroadcast(privateKey);

        // The deployer is the initial owner so it can configure the system in the same run.
        RyoCore core = new RyoCore(IBalancerVault(BALANCER_VAULT), deployer, operator, recipient);

        UniV3Adapter uniV3 = new UniV3Adapter(address(core), UNIV3_ROUTER);
        UniV2Adapter uniV2 = new UniV2Adapter(address(core), UNIV2_ROUTER);
        AerodromeClassicAdapter aerodrome = new AerodromeClassicAdapter(address(core), AERO_ROUTER);
        SlipstreamAdapter slipstream = new SlipstreamAdapter(address(core), SLIP_ROUTER);

        core.setAdapter(address(uniV3), true);
        core.setAdapter(address(uniV2), true);
        core.setAdapter(address(aerodrome), true);
        core.setAdapter(address(slipstream), true);

        if (maxGasPrice != 0) core.setMaxGasPrice(maxGasPrice);
        _setCapIfConfigured(core, WETH, vm.envOr("MAX_TRADE_WETH", uint256(0)));
        _setCapIfConfigured(core, USDC, vm.envOr("MAX_TRADE_USDC", uint256(0)));
        _setCapIfConfigured(core, CBBTC, vm.envOr("MAX_TRADE_CBBTC", uint256(0)));
        _setCapIfConfigured(core, EURC, vm.envOr("MAX_TRADE_EURC", uint256(0)));
        _setCapIfConfigured(core, AERO, vm.envOr("MAX_TRADE_AERO", uint256(0)));

        if (owner != deployer) core.transferOwnership(owner);

        vm.stopBroadcast();

        console2.log("RyoCore:            ", address(core));
        console2.log("UniV3Adapter:       ", address(uniV3));
        console2.log("UniV2Adapter:       ", address(uniV2));
        console2.log("AerodromeAdapter:   ", address(aerodrome));
        console2.log("SlipstreamAdapter:  ", address(slipstream));
        console2.log("deployer:           ", deployer);
        console2.log("owner:              ", owner);
        console2.log("operator:           ", operator);
        console2.log("profit recipient:   ", recipient);
        if (owner != deployer) {
            console2.log("ACTION: new owner must call acceptOwnership() on RyoCore.");
        }
        console2.log("All trade caps default to zero; enable assets explicitly.");
    }

    function _setCapIfConfigured(RyoCore core, address asset, uint256 cap) private {
        if (cap != 0) core.setMaxTradeSize(asset, cap);
    }
}

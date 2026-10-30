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
///      The script also writes a machine-readable manifest for the Rust watcher. Its shape must
///      stay in sync with `Watcher/src/config.rs::Manifest`.
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
///        MANIFEST_PATH      where to write the watcher manifest;
///                           defaults to ../Watcher/deployments/<chainId>.json
///        SKIP_MANIFEST      set to "true" to skip writing the manifest
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

    /// @dev Everything the manifest needs, gathered in one place so the writer and the deploy
    ///      step cannot drift apart.
    struct Deployment {
        address core;
        address uniV3;
        address uniV2;
        address aerodrome;
        address slipstream;
        address deployer;
        address owner;
        address operator;
        address recipient;
        uint256 maxGasPrice;
        uint256 capWeth;
        uint256 capUsdc;
        uint256 capCbbtc;
        uint256 capEurk;
        uint256 capAero;
        uint256 blockNumber;
        uint256 timestamp;
    }

    function run() external {
        uint256 privateKey = vm.envUint("PRIVATE_KEY");
        address deployer = vm.addr(privateKey);

        address owner = vm.envOr("OWNER", deployer);
        address operator = vm.envOr("OPERATOR", deployer);
        address recipient = vm.envOr("PROFIT_RECIPIENT", owner);
        uint256 maxGasPrice = vm.envOr("MAX_GAS_PRICE", uint256(0));

        uint256 capWeth = vm.envOr("MAX_TRADE_WETH", uint256(0));
        uint256 capUsdc = vm.envOr("MAX_TRADE_USDC", uint256(0));
        uint256 capCbbtc = vm.envOr("MAX_TRADE_CBBTC", uint256(0));
        uint256 capEurk = vm.envOr("MAX_TRADE_EURC", uint256(0));
        uint256 capAero = vm.envOr("MAX_TRADE_AERO", uint256(0));

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
        _setCapIfConfigured(core, WETH, capWeth);
        _setCapIfConfigured(core, USDC, capUsdc);
        _setCapIfConfigured(core, CBBTC, capCbbtc);
        _setCapIfConfigured(core, EURC, capEurk);
        _setCapIfConfigured(core, AERO, capAero);

        if (owner != deployer) core.transferOwnership(owner);

        vm.stopBroadcast();

        Deployment memory deployment = Deployment({
            core: address(core),
            uniV3: address(uniV3),
            uniV2: address(uniV2),
            aerodrome: address(aerodrome),
            slipstream: address(slipstream),
            deployer: deployer,
            owner: owner,
            operator: operator,
            recipient: recipient,
            maxGasPrice: maxGasPrice,
            capWeth: capWeth,
            capUsdc: capUsdc,
            capCbbtc: capCbbtc,
            capEurk: capEurk,
            capAero: capAero,
            blockNumber: block.number,
            timestamp: block.timestamp
        });
        _writeManifest(deployment);

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

    /// @dev Write `Watcher/src/config.rs::Manifest`. Every uint256 is a decimal string so JSON
    ///      consumers cannot lose precision above 2^53.
    ///      The document is assembled in small pieces because one large `string.concat` runs the
    ///      compiler out of stack slots.
    function _writeManifest(Deployment memory d) private {
        if (vm.envOr("SKIP_MANIFEST", false)) return;
        string memory path = vm.envOr(
            "MANIFEST_PATH",
            string.concat("../Watcher/deployments/", vm.toString(block.chainid), ".json")
        );

        // `forge script` simulates the whole script before broadcasting, so the script's
        // `block.number` is the chain head *immediately before* the deployment transactions.
        // The watcher never reads these two fields; they are metadata.
        uint256 deployBlock = d.blockNumber;
        uint256 deployTime = d.timestamp;

        string memory head = string.concat(
            "{\n",
            '  "chainId": ',
            vm.toString(block.chainid),
            ",\n",
            '  "deployer": "',
            vm.toString(d.deployer),
            '",\n',
            '  "blockNumber": "',
            vm.toString(deployBlock),
            '",\n'
        );
        string memory meta = string.concat(
            '  "timestamp": "',
            vm.toString(deployTime),
            '",\n',
            '  "core": "',
            vm.toString(d.core),
            '",\n',
            '  "vault": "',
            vm.toString(BALANCER_VAULT),
            '",\n',
            '  "owner": "',
            vm.toString(d.owner),
            '",\n'
        );
        string memory roles = string.concat(
            '  "operator": "',
            vm.toString(d.operator),
            '",\n',
            '  "profitRecipient": "',
            vm.toString(d.recipient),
            '",\n',
            _adapters(d),
            _routers(),
            _tokens(),
            _caps(d)
        );
        string memory tail = string.concat(
            '  "maxGasPrice": "', vm.toString(d.maxGasPrice), '",\n', '  "version": 1\n', "}\n"
        );

        vm.writeJson(string.concat(head, meta, roles, tail), path);
        console2.log("manifest written:   ", path);
    }

    function _adapters(Deployment memory d) private view returns (string memory) {
        return string.concat(
            '  "adapters": {\n',
            '    "univ3": "',
            _str(d.uniV3),
            '",\n',
            '    "univ2": "',
            _str(d.uniV2),
            '",\n',
            '    "aerodrome": "',
            _str(d.aerodrome),
            '",\n',
            '    "slipstream": "',
            _str(d.slipstream),
            '"\n',
            "  },\n"
        );
    }

    function _routers() private view returns (string memory) {
        return string.concat(
            '  "routers": {\n',
            '    "univ3": "',
            _str(UNIV3_ROUTER),
            '",\n',
            '    "univ2": "',
            _str(UNIV2_ROUTER),
            '",\n',
            '    "aerodrome": "',
            _str(AERO_ROUTER),
            '",\n',
            '    "slipstream": "',
            _str(SLIP_ROUTER),
            '"\n',
            "  },\n"
        );
    }

    function _tokens() private view returns (string memory) {
        return string.concat(
            '  "tokens": {\n',
            '    "WETH": "',
            _str(WETH),
            '",\n',
            '    "USDC": "',
            _str(USDC),
            '",\n',
            '    "cbBTC": "',
            _str(CBBTC),
            '",\n',
            '    "EURC": "',
            _str(EURC),
            '",\n',
            '    "AERO": "',
            _str(AERO),
            '"\n',
            "  },\n"
        );
    }

    function _caps(Deployment memory d) private view returns (string memory) {
        return string.concat(
            '  "caps": {\n',
            '    "WETH": "',
            vm.toString(d.capWeth),
            '",\n',
            '    "USDC": "',
            vm.toString(d.capUsdc),
            '",\n',
            '    "cbBTC": "',
            vm.toString(d.capCbbtc),
            '",\n',
            '    "EURC": "',
            vm.toString(d.capEurk),
            '",\n',
            '    "AERO": "',
            vm.toString(d.capAero),
            '"\n',
            "  },\n"
        );
    }

    function _str(address value) private view returns (string memory) {
        return vm.toString(value);
    }
}

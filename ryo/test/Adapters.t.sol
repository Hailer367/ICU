// SPDX-License-Identifier: MIT
pragma solidity ^0.8.28;

import { Test } from "forge-std/Test.sol";

import { AdapterBase } from "../src/adapters/AdapterBase.sol";
import { AerodromeClassicAdapter } from "../src/adapters/AerodromeClassicAdapter.sol";
import { SlipstreamAdapter } from "../src/adapters/SlipstreamAdapter.sol";
import { UniV2Adapter } from "../src/adapters/UniV2Adapter.sol";
import { UniV3Adapter } from "../src/adapters/UniV3Adapter.sol";

import { MockAerodromeRouter } from "./mocks/MockAerodromeRouter.sol";
import { MockERC20 } from "./mocks/MockERC20.sol";
import { MockSlipstreamRouter } from "./mocks/MockSlipstreamRouter.sol";
import { MockV2Router } from "./mocks/MockV2Router.sol";
import { MockV3Router } from "./mocks/MockV3Router.sol";

contract AdaptersTest is Test {
    MockERC20 internal tokenA;
    MockERC20 internal tokenB;

    MockV3Router internal v3Router;
    MockV2Router internal v2Router;
    MockAerodromeRouter internal aeroRouter;
    MockSlipstreamRouter internal slipRouter;

    UniV3Adapter internal uniV3;
    UniV2Adapter internal uniV2;
    AerodromeClassicAdapter internal aerodrome;
    SlipstreamAdapter internal slipstream;

    address internal stranger = address(0xBAD);
    uint256 internal constant AMOUNT = 100e18;
    uint256 internal constant MIN_OUT = 99e18;

    function setUp() public {
        tokenA = new MockERC20("Token A", "A", 18);
        tokenB = new MockERC20("Token B", "B", 18);
        tokenA.mint(address(this), 1_000_000e18);

        v3Router = new MockV3Router();
        v2Router = new MockV2Router();
        aeroRouter = new MockAerodromeRouter();
        slipRouter = new MockSlipstreamRouter();

        uniV3 = new UniV3Adapter(address(this), address(v3Router));
        uniV2 = new UniV2Adapter(address(this), address(v2Router));
        aerodrome = new AerodromeClassicAdapter(address(this), address(aeroRouter));
        slipstream = new SlipstreamAdapter(address(this), address(slipRouter));
    }

    function _fund(address adapter) internal {
        tokenA.transfer(adapter, AMOUNT);
    }

    function _assertNoAdapterBalance(address adapter) internal view {
        assertEq(tokenA.balanceOf(adapter), 0);
        assertEq(tokenB.balanceOf(adapter), 0);
    }

    // ---------------------------------------------------------------------------------------------
    // Uniswap V3
    // ---------------------------------------------------------------------------------------------

    function test_uniV3_happy_path() public {
        _fund(address(uniV3));

        uniV3.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(uint24(500)));

        assertEq(tokenB.balanceOf(address(this)), AMOUNT);
        assertEq(v3Router.lastTokenIn(), address(tokenA));
        assertEq(v3Router.lastTokenOut(), address(tokenB));
        assertEq(v3Router.lastFee(), 500);
        assertEq(v3Router.lastRecipient(), address(this));
        assertEq(v3Router.lastAmountIn(), AMOUNT);
        assertEq(v3Router.lastAmountOutMinimum(), MIN_OUT);
        assertEq(v3Router.lastSqrtPriceLimitX96(), 0);
        assertEq(tokenA.allowance(address(uniV3), address(v3Router)), 0);
        _assertNoAdapterBalance(address(uniV3));
    }

    function test_uniV3_invalid_data_length() public {
        vm.expectRevert(AdapterBase.InvalidDataLength.selector);
        uniV3.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, new bytes(31));
    }

    function test_uniV3_unauthorized() public {
        vm.prank(stranger);
        vm.expectRevert(AdapterBase.Unauthorized.selector);
        uniV3.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(uint24(500)));
    }

    function test_uniV3_zero_amount_reverts() public {
        vm.expectRevert(AdapterBase.ZeroAmount.selector);
        uniV3.step(address(tokenA), address(tokenB), 0, MIN_OUT, abi.encode(uint24(500)));
    }

    function test_uniV3_zero_min_out_reverts() public {
        vm.expectRevert(AdapterBase.InvalidMinAmountOut.selector);
        uniV3.step(address(tokenA), address(tokenB), AMOUNT, 0, abi.encode(uint24(500)));
    }

    function test_uniV3_same_token_reverts() public {
        vm.expectRevert(AdapterBase.InvalidTokenPair.selector);
        uniV3.step(address(tokenA), address(tokenA), AMOUNT, MIN_OUT, abi.encode(uint24(500)));
    }

    function test_uniV3_leftover_input_reverts() public {
        v3Router.setPullBps(9_900);
        _fund(address(uniV3));

        vm.expectRevert(
            abi.encodeWithSelector(AdapterBase.LeftoverToken.selector, address(tokenA), 1e18)
        );
        uniV3.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(uint24(500)));
    }

    function test_uniV3_output_sent_to_adapter_reverts() public {
        v3Router.setSendToRecipient(false);
        _fund(address(uniV3));

        vm.expectRevert(
            abi.encodeWithSelector(AdapterBase.LeftoverToken.selector, address(tokenB), AMOUNT)
        );
        uniV3.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(uint24(500)));
    }

    function test_uniV3_preexisting_dust_does_not_block_or_leak() public {
        // Anyone can donate dust. It must not brick the adapter, and it must not be counted as
        // output or consumed as input.
        tokenA.transfer(address(uniV3), 1);
        tokenB.mint(address(this), 1);
        tokenB.transfer(address(uniV3), 1);
        _fund(address(uniV3));

        uniV3.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(uint24(500)));

        assertEq(tokenB.balanceOf(address(this)), AMOUNT);
        assertEq(tokenA.balanceOf(address(uniV3)), 1);
        assertEq(tokenB.balanceOf(address(uniV3)), 1);
        assertEq(tokenA.allowance(address(uniV3), address(v3Router)), 0);
    }

    // ---------------------------------------------------------------------------------------------
    // Uniswap V2
    // ---------------------------------------------------------------------------------------------

    function test_uniV2_happy_path() public {
        _fund(address(uniV2));

        uniV2.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, "");

        assertEq(tokenB.balanceOf(address(this)), AMOUNT);
        assertEq(v2Router.lastPath(0), address(tokenA));
        assertEq(v2Router.lastPath(1), address(tokenB));
        assertEq(v2Router.lastTo(), address(this));
        assertEq(v2Router.lastAmountIn(), AMOUNT);
        assertEq(v2Router.lastAmountOutMin(), MIN_OUT);
        assertEq(v2Router.lastDeadline(), block.timestamp);
        assertEq(tokenA.allowance(address(uniV2), address(v2Router)), 0);
        _assertNoAdapterBalance(address(uniV2));
    }

    function test_uniV2_invalid_data_length() public {
        vm.expectRevert(AdapterBase.InvalidDataLength.selector);
        uniV2.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, hex"00");
    }

    function test_uniV2_unauthorized() public {
        vm.prank(stranger);
        vm.expectRevert(AdapterBase.Unauthorized.selector);
        uniV2.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, "");
    }

    function test_uniV2_leftover_input_reverts() public {
        v2Router.setPullBps(9_900);
        _fund(address(uniV2));

        vm.expectRevert(
            abi.encodeWithSelector(AdapterBase.LeftoverToken.selector, address(tokenA), 1e18)
        );
        uniV2.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, "");
    }

    function test_uniV2_output_sent_to_adapter_reverts() public {
        v2Router.setSendToRecipient(false);
        _fund(address(uniV2));

        vm.expectRevert(
            abi.encodeWithSelector(AdapterBase.LeftoverToken.selector, address(tokenB), AMOUNT)
        );
        uniV2.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, "");
    }

    // ---------------------------------------------------------------------------------------------
    // Aerodrome classic
    // ---------------------------------------------------------------------------------------------

    function test_aerodrome_happy_path() public {
        _fund(address(aerodrome));

        aerodrome.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(true));

        assertEq(tokenB.balanceOf(address(this)), AMOUNT);
        assertEq(aeroRouter.lastFrom(), address(tokenA));
        assertEq(aeroRouter.lastToToken(), address(tokenB));
        assertTrue(aeroRouter.lastStable());
        assertEq(aeroRouter.lastFactory(), address(0));
        assertEq(aeroRouter.lastToAddress(), address(this));
        assertEq(aeroRouter.lastAmountIn(), AMOUNT);
        assertEq(aeroRouter.lastAmountOutMin(), MIN_OUT);
        assertEq(aeroRouter.lastDeadline(), block.timestamp);
        assertEq(tokenA.allowance(address(aerodrome), address(aeroRouter)), 0);
        _assertNoAdapterBalance(address(aerodrome));
    }

    function test_aerodrome_volatile_flag() public {
        _fund(address(aerodrome));

        aerodrome.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(false));

        assertFalse(aeroRouter.lastStable());
    }

    function test_aerodrome_invalid_data_length() public {
        vm.expectRevert(AdapterBase.InvalidDataLength.selector);
        aerodrome.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, new bytes(31));
    }

    function test_aerodrome_unauthorized() public {
        vm.prank(stranger);
        vm.expectRevert(AdapterBase.Unauthorized.selector);
        aerodrome.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(true));
    }

    function test_aerodrome_leftover_input_reverts() public {
        aeroRouter.setPullBps(9_900);
        _fund(address(aerodrome));

        vm.expectRevert(
            abi.encodeWithSelector(AdapterBase.LeftoverToken.selector, address(tokenA), 1e18)
        );
        aerodrome.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(true));
    }

    function test_aerodrome_output_sent_to_adapter_reverts() public {
        aeroRouter.setSendToRecipient(false);
        _fund(address(aerodrome));

        vm.expectRevert(
            abi.encodeWithSelector(AdapterBase.LeftoverToken.selector, address(tokenB), AMOUNT)
        );
        aerodrome.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(true));
    }

    // ---------------------------------------------------------------------------------------------
    // Slipstream
    // ---------------------------------------------------------------------------------------------

    function test_slipstream_happy_path() public {
        _fund(address(slipstream));

        slipstream.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(int24(50)));

        assertEq(tokenB.balanceOf(address(this)), AMOUNT);
        assertEq(slipRouter.lastTokenIn(), address(tokenA));
        assertEq(slipRouter.lastTokenOut(), address(tokenB));
        assertEq(slipRouter.lastTickSpacing(), 50);
        assertEq(slipRouter.lastRecipient(), address(this));
        assertEq(slipRouter.lastDeadline(), block.timestamp);
        assertEq(slipRouter.lastAmountIn(), AMOUNT);
        assertEq(slipRouter.lastAmountOutMinimum(), MIN_OUT);
        assertEq(slipRouter.lastSqrtPriceLimitX96(), 0);
        assertEq(tokenA.allowance(address(slipstream), address(slipRouter)), 0);
        _assertNoAdapterBalance(address(slipstream));
    }

    function test_slipstream_invalid_tick_spacing() public {
        vm.expectRevert(SlipstreamAdapter.InvalidTickSpacing.selector);
        slipstream.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(int24(0)));
    }

    function test_slipstream_invalid_data_length() public {
        vm.expectRevert(AdapterBase.InvalidDataLength.selector);
        slipstream.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, new bytes(31));
    }

    function test_slipstream_unauthorized() public {
        vm.prank(stranger);
        vm.expectRevert(AdapterBase.Unauthorized.selector);
        slipstream.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(int24(50)));
    }

    function test_slipstream_leftover_input_reverts() public {
        slipRouter.setPullBps(9_900);
        _fund(address(slipstream));

        vm.expectRevert(
            abi.encodeWithSelector(AdapterBase.LeftoverToken.selector, address(tokenA), 1e18)
        );
        slipstream.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(int24(50)));
    }

    function test_slipstream_output_sent_to_adapter_reverts() public {
        slipRouter.setSendToRecipient(false);
        _fund(address(slipstream));

        vm.expectRevert(
            abi.encodeWithSelector(AdapterBase.LeftoverToken.selector, address(tokenB), AMOUNT)
        );
        slipstream.step(address(tokenA), address(tokenB), AMOUNT, MIN_OUT, abi.encode(int24(50)));
    }

    // ---------------------------------------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------------------------------------

    function test_adapter_constructor_rejects_zero_core() public {
        vm.expectRevert(AdapterBase.ZeroAddress.selector);
        new UniV3Adapter(address(0), address(v3Router));
    }

    function test_adapter_constructor_rejects_zero_router() public {
        vm.expectRevert(AdapterBase.ZeroAddress.selector);
        new UniV3Adapter(address(this), address(0));
    }

    function test_adapter_constructor_rejects_eoa_core() public {
        vm.expectRevert(abi.encodeWithSelector(AdapterBase.NotContract.selector, stranger));
        new UniV3Adapter(stranger, address(v3Router));
    }

    function test_adapter_constructor_rejects_eoa_router() public {
        vm.expectRevert(abi.encodeWithSelector(AdapterBase.NotContract.selector, stranger));
        new UniV3Adapter(address(this), stranger);
    }
}

//! Solidity ABI definitions used by the watcher.
//!
//! These are hand-written `sol!` bindings so the watcher does not need the
//! Foundry build artifacts at runtime. Selectors and event topics are derived
//! by Alloy from the signatures.

pub mod ryo {
    alloy::sol! {
        struct Step {
            address adapter;
            address tokenIn;
            address tokenOut;
            uint256 minAmountOut;
            bytes data;
        }

        function execute(
            address asset,
            uint256 amount,
            Step[] calldata steps,
            uint256 minProfit
        ) external returns (uint256 profit);

        function simulate(
            address asset,
            uint256 amount,
            Step[] calldata steps
        ) external;

        function owner() external view returns (address);
        function pendingOwner() external view returns (address);
        function operator() external view returns (address);
        function profitRecipient() external view returns (address);
        function vault() external view returns (address);
        function paused() external view returns (bool);
        function isAdapter(address adapter) external view returns (bool);
        function maxTradeSize(address asset) external view returns (uint256);
        function maxGasPrice() external view returns (uint256);
        function VERSION() external view returns (uint8);
        function MAX_STEPS() external view returns (uint256);

        error SimulationResult(int256 profit);

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
    }
}

pub mod pool {
    alloy::sol! {
        function token0() external view returns (address);
        function token1() external view returns (address);
        // Declared as uint256 to keep the return words in the same 32-byte ABI
        // slots the pool emits (uint112/uint32 are left-padded on the wire, so
        // the decoded values are identical). Return types never affect the
        // selector, and this avoids a lossy uint112 conversion at the call site.
        function getReserves()
            external
            view
            returns (uint256 reserve0, uint256 reserve1, uint256 blockTimestampLast);
    }
}

pub mod erc20 {
    alloy::sol! {
        function balanceOf(address owner) external view returns (uint256);
        function decimals() external view returns (uint8);
        function symbol() external view returns (string);
    }
}

/// Getters shared by Uniswap V3 and Aerodrome Slipstream pools.
pub mod cl_pool {
    alloy::sol! {
        function fee() external view returns (uint24);
        function liquidity() external view returns (uint128);
        // V3-family pools all lead with the `sqrtPriceX96` word but differ in
        // how many fields follow it, so callers read the raw first word rather
        // than trusting a full tuple layout. Return types never affect the
        // selector.
        function slot0() external view returns (uint160 sqrtPriceX96);
        // Selectors only: every V3-family pool returns its `slot0`/`ticks`
        // struct with slightly different field counts and signedness, so the
        // local-CL cache decodes the raw 32-byte words itself (`clamm::words`).
        function tickSpacing() external view returns (int24);
        function tickBitmap(int16 wordPos) external view returns (uint256);
        function ticks(int24 tickId)
            external
            view
            returns (uint256, int256, uint256, uint256, int256, uint256, uint256, uint256);
    }
}

pub mod univ3_quoter {
    alloy::sol! {
        struct QuoteExactInputSingleParams {
            address tokenIn;
            address tokenOut;
            uint256 amountIn;
            uint24 fee;
            uint160 sqrtPriceLimitX96;
        }

        function quoteExactInputSingle(QuoteExactInputSingleParams params)
            external
            returns (
                uint256 amountOut,
                uint160 sqrtPriceX96After,
                uint32 initializedTicksCrossed,
                uint256 gasEstimate
            );
    }
}

pub mod slipstream_quoter {
    alloy::sol! {
        struct QuoteExactInputSingleParams {
            address tokenIn;
            address tokenOut;
            uint256 amountIn;
            int24 tickSpacing;
            uint160 sqrtPriceLimitX96;
        }

        function quoteExactInputSingle(QuoteExactInputSingleParams params)
            external
            returns (
                uint256 amountOut,
                uint160 sqrtPriceX96After,
                uint32 initializedTicksCrossed,
                uint256 gasEstimate
            );
    }
}

pub mod univ2_router {
    alloy::sol! {
        function getAmountsOut(uint256 amountIn, address[] calldata path)
            external
            view
            returns (uint256[] memory amounts);
    }
}

pub mod aerodrome_router {
    alloy::sol! {
        struct Route {
            address from;
            address to;
            bool stable;
            address factory;
        }

        function getAmountsOut(uint256 amountIn, Route[] calldata routes)
            external
            view
            returns (uint256[] memory amounts);
    }
}

pub mod gas_oracle {
    alloy::sol! {
        function getL1Fee(bytes calldata data) external view returns (uint256);
        function getL1FeeUpperBound(uint256 unsignedTxSize) external view returns (uint256);
        function l1BaseFee() external view returns (uint256);
        function blobBaseFee() external view returns (uint256);
        function baseFee() external view returns (uint256);
        function decimals() external view returns (uint256);
    }
}

pub mod chainlink {
    alloy::sol! {
        function latestRoundData()
            external
            view
            returns (
                uint80 roundId,
                int256 answer,
                uint256 startedAt,
                uint256 updatedAt,
                uint80 answeredInRound
            );
        function decimals() external view returns (uint8);
        function description() external view returns (string);
    }
}

pub mod balancer_vault {
    alloy::sol! {
        function getProtocolFeesCollector() external view returns (address);
        function getFlashLoanFeePercentage() external view returns (uint256);
    }
}

pub mod univ3_factory {
    alloy::sol! {
        function getPool(address tokenA, address tokenB, uint24 fee)
            external
            view
            returns (address pool);
    }
}

pub mod univ2_factory {
    alloy::sol! {
        function getPair(address tokenA, address tokenB)
            external
            view
            returns (address pair);
    }
}

pub mod aerodrome_factory {
    alloy::sol! {
        function getPool(address tokenA, address tokenB, bool stable)
            external
            view
            returns (address pool);
        // Per-pool swap fee in basis points of 10_000 (e.g. 30 = 0.30%).
        // Governance-controlled, so it is read fresh alongside reserves.
        function getFee(address pool, bool stable) external view returns (uint256);
    }
}

pub mod slipstream_factory {
    alloy::sol! {
        function getPool(address tokenA, address tokenB, int24 tickSpacing)
            external
            view
            returns (address pool);
    }
}

pub mod multicall3 {
    alloy::sol! {
        struct Call3 {
            address target;
            bool allowFailure;
            bytes callData;
        }
        struct Result3 {
            bool success;
            bytes returnData;
        }

        function aggregate3(Call3[] calldata calls)
            external
            payable
            returns (Result3[] memory returnData);
    }
}

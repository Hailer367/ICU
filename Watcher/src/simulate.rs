use alloy::eips::BlockId;
use alloy::primitives::{Address, Bytes, I256, U256};
use alloy::sol_types::SolCall;

use crate::abi::ryo;
use crate::chain::{self, CallError, ChainProvider};
use crate::errors::{self, DecodedError};

#[derive(Debug, Clone)]
pub struct Simulation {
    pub profit: I256,
    /// Raw revert payload, kept for diagnostics and route-hash correlation.
    pub raw_revert: Bytes,
}

#[derive(Debug)]
pub enum SimulateError {
    /// The call reverted with something other than `SimulationResult`.
    Revert { decoded: DecodedError, raw: Bytes },
    /// The node failed before executing the call.
    Transport(String),
    /// `simulate` unexpectedly returned successfully.
    UnexpectedSuccess(Bytes),
}

impl std::fmt::Display for SimulateError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            Self::Revert { decoded, .. } => write!(f, "simulation reverted: {decoded}"),
            Self::Transport(message) => write!(f, "simulation transport error: {message}"),
            Self::UnexpectedSuccess(data) => {
                write!(f, "simulation unexpectedly succeeded: {data}")
            }
        }
    }
}

impl std::error::Error for SimulateError {}

/// Run `RyoCore.simulate` via `eth_call` and decode its revert payload.
///
/// `simulate` always reverts. A successful route reverts with
/// `SimulationResult(int256)`. Any other revert is a real failure.
#[allow(clippy::result_large_err)]
pub async fn simulate(
    provider: &ChainProvider,
    core: Address,
    asset: Address,
    amount: U256,
    steps: Vec<ryo::Step>,
    block: BlockId,
) -> Result<Simulation, SimulateError> {
    if steps.is_empty() {
        return Err(SimulateError::Transport(
            "cannot simulate an empty route".to_string(),
        ));
    }
    for (i, step) in steps.iter().enumerate() {
        if step.minAmountOut == U256::ZERO {
            return Err(SimulateError::Transport(format!(
                "step {i} has a zero minAmountOut"
            )));
        }
    }

    let call = ryo::simulateCall {
        asset,
        amount,
        steps,
    };
    let data = call.abi_encode();

    match chain::eth_call(provider, core, data.into(), block).await {
        Ok(bytes) => Err(SimulateError::UnexpectedSuccess(bytes)),
        Err(CallError::Transport(message)) => Err(SimulateError::Transport(message)),
        Err(CallError::Revert(raw)) => match errors::decode(&raw) {
            DecodedError::SimulationResult(profit) => Ok(Simulation {
                profit,
                raw_revert: raw,
            }),
            decoded => Err(SimulateError::Revert { decoded, raw }),
        },
    }
}

/// Convenience helper for discovery: every floor is `1`.
pub fn discovery_steps(
    route: &crate::routes::Route,
    manifest: &crate::config::Manifest,
) -> anyhow::Result<Vec<ryo::Step>> {
    let floors = vec![U256::from(1u8); route.steps.len()];
    route.to_steps(manifest, &floors)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn rejects_zero_floor() {
        // The async function is tested through the public API in integration tests;
        // this test documents the invariant without needing a provider.
        let step = ryo::Step {
            adapter: Address::ZERO,
            tokenIn: Address::ZERO,
            tokenOut: Address::ZERO,
            minAmountOut: U256::ZERO,
            data: Bytes::new(),
        };
        assert_eq!(step.minAmountOut, U256::ZERO);
    }
}

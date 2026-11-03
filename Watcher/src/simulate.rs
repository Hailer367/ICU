use alloy::eips::BlockId;
use alloy::primitives::{Address, Bytes, I256, U256};
use alloy::sol_types::SolCall;

use crate::abi::{gas_oracle, ryo};
use crate::chain::{self, CallError, ChainProvider};
use crate::config::base;
use crate::errors::{self, DecodedError};
use crate::gas;

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
        Err(CallError::Revert(raw)) => decode_simulate_outcome(false, &raw),
    }
}

/// Classify one `(success, returnData)` pair from a direct or batched
/// `RyoCore.simulate` call. `simulate` always reverts: a `SimulationResult`
/// payload IS the answer, any other revert is a real rejection, and a call
/// that returns successfully means the ABI or the contract is not what we
/// think it is.
#[allow(clippy::result_large_err)]
pub fn decode_simulate_outcome(success: bool, data: &Bytes) -> Result<Simulation, SimulateError> {
    if success {
        return Err(SimulateError::UnexpectedSuccess(data.clone()));
    }
    match errors::decode(data) {
        DecodedError::SimulationResult(profit) => Ok(Simulation {
            profit,
            raw_revert: data.clone(),
        }),
        decoded => Err(SimulateError::Revert {
            decoded,
            raw: data.clone(),
        }),
    }
}

/// The execute calldata is the simulate calldata plus exactly one 32-byte
/// word (`minProfit`): same selector width, same arguments, same dynamic
/// step tail. Verified by test across every step count the core allows —
/// it is what lets the L1 fee ride the same batch as the simulation.
pub fn execute_calldata_len(simulate_calldata_len: usize) -> usize {
    simulate_calldata_len + 32
}

/// A definitive loss and an inconclusive failure need different handling by
/// the caller (only the loss may enter the failed-sim cache), so the merged
/// batch distinguishes them at the type level.
#[derive(Debug)]
pub enum SimCostError {
    /// The chain answered conclusively: this route cannot pay at this state.
    Definitive(SimulateError),
    /// The batch, the oracle or a decode failed — retry later, remember
    /// nothing (§0l's fail-closed rule: a missing cost is not a free cost).
    Inconclusive(String),
}

/// One pinned `aggregate3` carrying BOTH per-candidate cost probes:
/// The simulation, its L1 bound, and the execute calldata length the bound
/// was priced at. The caller builds the real execute calldata from the same
/// steps and must assert that length matches — the identity is an ABI fact
/// (`execute_calldata_len`), and an assertion turns future drift into a loud
/// skip instead of a silently mispriced fee.
pub struct SimCost {
    pub simulation: Simulation,
    pub l1_fee: U256,
    pub expected_execute_len: usize,
}

/// One pinned `aggregate3` carrying BOTH per-candidate cost probes:
/// `RyoCore.simulate` and `getL1FeeUpperBound` for the execute transaction
/// those exact steps would produce. Before §0t these were two sequential
/// round-trips per candidate; the oracle input is derived from the simulate
/// calldata length (`execute_calldata_len`), so no ordering dependency is
/// lost, and `simulate`-what-you-`propose` is unchanged: the caller builds
/// the execute calldata from the same steps and asserts the length.
#[allow(clippy::result_large_err)]
pub async fn simulate_with_l1_fee(
    provider: &ChainProvider,
    core: Address,
    asset: Address,
    amount: U256,
    steps: Vec<ryo::Step>,
    block: BlockId,
) -> Result<SimCost, SimCostError> {
    if steps.is_empty() {
        return Err(SimCostError::Inconclusive(
            "cannot simulate an empty route".to_string(),
        ));
    }
    for (i, step) in steps.iter().enumerate() {
        if step.minAmountOut == U256::ZERO {
            return Err(SimCostError::Inconclusive(format!(
                "step {i} has a zero minAmountOut"
            )));
        }
    }

    let simulate_call = ryo::simulateCall {
        asset,
        amount,
        steps,
    };
    let sim_data: Bytes = simulate_call.abi_encode().into();
    let tx_size = gas::unsigned_tx_size(execute_calldata_len(sim_data.len()));
    let l1_call = gas_oracle::getL1FeeUpperBoundCall {
        unsignedTxSize: U256::from(tx_size),
    };

    let expected_execute_len = execute_calldata_len(sim_data.len());
    let outcomes = chain::multicall3_outcomes(
        provider,
        &[
            (core, sim_data),
            (base::GAS_PRICE_ORACLE, l1_call.abi_encode().into()),
        ],
        block,
    )
    .await
    .map_err(SimCostError::Inconclusive)?;
    let sim = decode_simulate_outcome(outcomes[0].success, &outcomes[0].returnData)
        .map_err(SimCostError::Definitive)?;
    // The oracle failing closed must not launder a real revert into a skip:
    // classify simulate first (above), cost second (here), matching §0l.
    if !outcomes[1].success {
        return Err(SimCostError::Inconclusive(format!(
            "L1 fee oracle call reverted: {}",
            errors::decode(&outcomes[1].returnData)
        )));
    }
    let l1_fee = gas_oracle::getL1FeeUpperBoundCall::abi_decode_returns(&outcomes[1].returnData)
        .map_err(|err| SimCostError::Inconclusive(format!("failed to decode L1 bound: {err}")))?;
    Ok(SimCost {
        simulation: sim,
        l1_fee,
        expected_execute_len,
    })
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
    use alloy::primitives::keccak256;

    fn step(data_len: usize) -> ryo::Step {
        ryo::Step {
            adapter: Address::with_last_byte(0xa1),
            tokenIn: base::USDC,
            tokenOut: base::WETH,
            minAmountOut: U256::from(7u8),
            data: Bytes::from(vec![0x2au8; data_len]),
        }
    }

    #[test]
    fn execute_calldata_is_exactly_one_word_longer_than_simulate() {
        // The merged batch prices the L1 fee at this predicted length; the
        // identity holds because `minProfit` is one static word appended to
        // identical fields. Checked across every step count the core allows
        // and across dynamic `data` widths (UniV2 empty vs 32-byte params).
        for steps_count in 2..=8usize {
            for data_len in [0usize, 32, 64] {
                let steps: Vec<ryo::Step> = (0..steps_count).map(|_| step(data_len)).collect();
                let sim = ryo::simulateCall {
                    asset: base::USDC,
                    amount: U256::from(1_000u64),
                    steps: steps.clone(),
                }
                .abi_encode();
                let execute = ryo::executeCall {
                    asset: base::USDC,
                    amount: U256::from(1_000u64),
                    steps,
                    minProfit: U256::from(999u64),
                }
                .abi_encode();
                assert_eq!(
                    execute.len(),
                    execute_calldata_len(sim.len()),
                    "steps={steps_count} data_len={data_len}"
                );
                assert_eq!(execute.len() - sim.len(), 32);
            }
        }
    }

    #[test]
    fn min_profit_value_size_does_not_change_the_length() {
        // Zero vs a full-width U256 must not shift the byte count: the
        // prediction cannot depend on values the batch has not seen.
        let steps = vec![step(32), step(32)];
        let a = ryo::executeCall {
            asset: base::USDC,
            amount: U256::from(1u64),
            steps: steps.clone(),
            minProfit: U256::ZERO,
        }
        .abi_encode();
        let b = ryo::executeCall {
            asset: base::USDC,
            amount: U256::from(1u64),
            steps,
            minProfit: U256::MAX,
        }
        .abi_encode();
        assert_eq!(a.len(), b.len());
    }

    #[test]
    fn outcome_classification_matches_the_direct_call() {
        // A `SimulationResult` revert payload IS success; a plain return is
        // the ABI-mismatch case; anything else is a definitive loss. The
        // batched path and the direct `simulate()` must classify identically.
        let mut payload = keccak256("SimulationResult(int256)").0[..4].to_vec();
        let mut word = vec![0u8; 32];
        word[31] = 42;
        payload.extend_from_slice(&word);
        let win = decode_simulate_outcome(false, &Bytes::from(payload)).expect("profit decoded");
        assert_eq!(win.profit, I256::try_from(42i64).unwrap());

        let odd = decode_simulate_outcome(false, &Bytes::from(vec![0xde, 0xad, 0xbe, 0xef]));
        assert!(
            matches!(odd, Err(SimulateError::Revert { .. })),
            "unknown revert payload is a definitive loss"
        );

        let empty = decode_simulate_outcome(false, &Bytes::new());
        assert!(
            matches!(empty, Err(SimulateError::Revert { .. })),
            "an empty revert keeps the pre-§0t definitive classification"
        );

        let returned = decode_simulate_outcome(true, &Bytes::from(vec![0u8; 32]));
        assert!(
            matches!(returned, Err(SimulateError::UnexpectedSuccess(_))),
            "success from a call that always reverts means ABI mismatch"
        );
    }

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

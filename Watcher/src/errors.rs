//! Decoding for contract, adapter, router, Balancer, and OpenZeppelin reverts.
//!
//! A failed swap usually reverts in the venue router before `RyoCore` sees it.
//! The watcher therefore cannot assume that every failure is a core error.

use std::fmt;

use alloy::primitives::{Address, Bytes, I256, U256, keccak256};
use alloy::rpc::json_rpc::ErrorPayload;
use serde_json::Value;

pub fn selector(signature: &str) -> [u8; 4] {
    let hash = keccak256(signature.as_bytes());
    [hash[0], hash[1], hash[2], hash[3]]
}

fn word(data: &[u8], index: usize) -> U256 {
    let start = 4 + index * 32;
    let end = start + 32;
    if data.len() < end {
        return U256::ZERO;
    }
    U256::from_be_slice(&data[start..end])
}

fn address_at(data: &[u8], index: usize) -> Address {
    let start = 4 + index * 32;
    let end = start + 32;
    if data.len() < end {
        return Address::ZERO;
    }
    Address::from_slice(&data[end - 20..end])
}

fn uint_at(data: &[u8], index: usize) -> U256 {
    word(data, index)
}

fn int_at(data: &[u8], index: usize) -> I256 {
    I256::from_raw(word(data, index))
}

fn u8_at(data: &[u8], index: usize) -> u8 {
    let value = word(data, index);
    value.try_into().unwrap_or(0)
}

fn string_at(data: &[u8], index: usize) -> String {
    // `data` includes the 4-byte selector.
    let offset = word(data, index).try_into().unwrap_or(usize::MAX);
    let base = 4usize.saturating_add(offset);
    if offset == usize::MAX || data.len() < base + 32 {
        return String::new();
    }
    let len = U256::from_be_slice(&data[base..base + 32])
        .try_into()
        .unwrap_or(0usize);
    let start = base + 32;
    let end = start.saturating_add(len);
    if data.len() < end {
        return String::new();
    }
    String::from_utf8_lossy(&data[start..end]).into_owned()
}

#[derive(Debug, Clone, PartialEq, Eq)]
pub enum CoreError {
    ZeroAddress,
    ZeroAmount,
    NotContract(Address),
    NotOperator(Address),
    ContractPaused,
    ContractNotPaused,
    AdapterNotAllowed(Address),
    TradeNotAllowed(Address),
    TradeTooLarge {
        asset: Address,
        amount: U256,
        max: U256,
    },
    GasPriceTooHigh {
        gas_price: U256,
        max: U256,
    },
    InvalidProfitRecipient,
    RouteTooShort,
    RouteTooLong(U256),
    RouteMismatch(U256),
    InvalidStep(U256),
    InvalidMinOut(U256),
    InputNotConsumed {
        index: U256,
        expected: U256,
        actual: U256,
    },
    AdapterKeptInput {
        index: U256,
        token: Address,
        expected: U256,
        actual: U256,
    },
    InsufficientOutput {
        index: U256,
        amount_out: U256,
        min_amount_out: U256,
    },
    NegativeOutput(U256),
    UnauthorizedCallback,
    CallbackAlreadyConsumed,
    CallbackNotCalled,
    InvalidFlashLoanData,
    InvalidRouteVersion(u8),
    Loss {
        after: U256,
        before: U256,
    },
    MinProfitNotMet {
        profit: U256,
        min_profit: U256,
    },
    SimulationFailed,
}

#[derive(Debug, Clone, PartialEq, Eq)]
pub enum AdapterError {
    Unauthorized,
    ZeroAddress,
    NotContract(Address),
    ZeroAmount,
    InvalidTokenPair,
    InvalidMinAmountOut,
    InvalidDataLength,
    LeftoverToken { token: Address, balance: U256 },
    InvalidTickSpacing,
}

#[derive(Debug, Clone, PartialEq, Eq)]
pub enum OzError {
    OwnableUnauthorizedAccount(Address),
    OwnableInvalidOwner(Address),
    ReentrancyGuardReentrantCall,
    SafeERC20FailedOperation(Address),
}

#[derive(Debug, Clone, PartialEq, Eq)]
pub enum DecodedError {
    SimulationResult(I256),
    ErrorString(String),
    Panic(U256),
    Core(CoreError),
    Adapter(AdapterError),
    Oz(OzError),
    Known {
        selector: [u8; 4],
        name: &'static str,
        data: Bytes,
    },
    Unknown {
        selector: [u8; 4],
        data: Bytes,
    },
    Empty,
}

impl fmt::Display for DecodedError {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self {
            Self::SimulationResult(profit) => write!(f, "SimulationResult(profit={profit})"),
            Self::ErrorString(message) => write!(f, "Error({message})"),
            Self::Panic(code) => write!(f, "Panic({code})"),
            Self::Core(err) => write!(f, "{err:?}"),
            Self::Adapter(err) => write!(f, "{err:?}"),
            Self::Oz(err) => write!(f, "{err:?}"),
            Self::Known { name, .. } => write!(f, "{name}"),
            Self::Unknown { selector, data } => {
                write!(
                    f,
                    "Unknown(selector=0x{}, data={data})",
                    alloy::hex::encode(selector)
                )
            }
            Self::Empty => write!(f, "Empty revert data"),
        }
    }
}

pub fn decode(data: &[u8]) -> DecodedError {
    if data.len() < 4 {
        return DecodedError::Empty;
    }
    let sel: [u8; 4] = [data[0], data[1], data[2], data[3]];

    if sel == selector("SimulationResult(int256)") {
        return DecodedError::SimulationResult(int_at(data, 0));
    }
    if sel == [0x08, 0xc3, 0x79, 0xa0] {
        return DecodedError::ErrorString(string_at(data, 0));
    }
    if sel == [0x4e, 0x48, 0x7b, 0x71] {
        return DecodedError::Panic(uint_at(data, 0));
    }

    // --- RyoCore -------------------------------------------------------------------------
    let core = if sel == selector("ZeroAddress()") {
        Some(CoreError::ZeroAddress)
    } else if sel == selector("ZeroAmount()") {
        Some(CoreError::ZeroAmount)
    } else if sel == selector("NotContract(address)") {
        Some(CoreError::NotContract(address_at(data, 0)))
    } else if sel == selector("NotOperator(address)") {
        Some(CoreError::NotOperator(address_at(data, 0)))
    } else if sel == selector("ContractPaused()") {
        Some(CoreError::ContractPaused)
    } else if sel == selector("ContractNotPaused()") {
        Some(CoreError::ContractNotPaused)
    } else if sel == selector("AdapterNotAllowed(address)") {
        Some(CoreError::AdapterNotAllowed(address_at(data, 0)))
    } else if sel == selector("TradeNotAllowed(address)") {
        Some(CoreError::TradeNotAllowed(address_at(data, 0)))
    } else if sel == selector("TradeTooLarge(address,uint256,uint256)") {
        Some(CoreError::TradeTooLarge {
            asset: address_at(data, 0),
            amount: uint_at(data, 1),
            max: uint_at(data, 2),
        })
    } else if sel == selector("GasPriceTooHigh(uint256,uint256)") {
        Some(CoreError::GasPriceTooHigh {
            gas_price: uint_at(data, 0),
            max: uint_at(data, 1),
        })
    } else if sel == selector("InvalidProfitRecipient()") {
        Some(CoreError::InvalidProfitRecipient)
    } else if sel == selector("RouteTooShort()") {
        Some(CoreError::RouteTooShort)
    } else if sel == selector("RouteTooLong(uint256)") {
        Some(CoreError::RouteTooLong(uint_at(data, 0)))
    } else if sel == selector("RouteMismatch(uint256)") {
        Some(CoreError::RouteMismatch(uint_at(data, 0)))
    } else if sel == selector("InvalidStep(uint256)") {
        Some(CoreError::InvalidStep(uint_at(data, 0)))
    } else if sel == selector("InvalidMinOut(uint256)") {
        Some(CoreError::InvalidMinOut(uint_at(data, 0)))
    } else if sel == selector("InputNotConsumed(uint256,uint256,uint256)") {
        Some(CoreError::InputNotConsumed {
            index: uint_at(data, 0),
            expected: uint_at(data, 1),
            actual: uint_at(data, 2),
        })
    } else if sel == selector("AdapterKeptInput(uint256,address,uint256,uint256)") {
        Some(CoreError::AdapterKeptInput {
            index: uint_at(data, 0),
            token: address_at(data, 1),
            expected: uint_at(data, 2),
            actual: uint_at(data, 3),
        })
    } else if sel == selector("InsufficientOutput(uint256,uint256,uint256)") {
        Some(CoreError::InsufficientOutput {
            index: uint_at(data, 0),
            amount_out: uint_at(data, 1),
            min_amount_out: uint_at(data, 2),
        })
    } else if sel == selector("NegativeOutput(uint256)") {
        Some(CoreError::NegativeOutput(uint_at(data, 0)))
    } else if sel == selector("UnauthorizedCallback()") {
        Some(CoreError::UnauthorizedCallback)
    } else if sel == selector("CallbackAlreadyConsumed()") {
        Some(CoreError::CallbackAlreadyConsumed)
    } else if sel == selector("CallbackNotCalled()") {
        Some(CoreError::CallbackNotCalled)
    } else if sel == selector("InvalidFlashLoanData()") {
        Some(CoreError::InvalidFlashLoanData)
    } else if sel == selector("InvalidRouteVersion(uint8)") {
        Some(CoreError::InvalidRouteVersion(u8_at(data, 0)))
    } else if sel == selector("Loss(uint256,uint256)") {
        Some(CoreError::Loss {
            after: uint_at(data, 0),
            before: uint_at(data, 1),
        })
    } else if sel == selector("MinProfitNotMet(uint256,uint256)") {
        Some(CoreError::MinProfitNotMet {
            profit: uint_at(data, 0),
            min_profit: uint_at(data, 1),
        })
    } else if sel == selector("SimulationFailed()") {
        Some(CoreError::SimulationFailed)
    } else {
        None
    };
    if let Some(err) = core {
        return DecodedError::Core(err);
    }

    // --- Adapters -------------------------------------------------------------------------
    let adapter = if sel == selector("Unauthorized()") {
        Some(AdapterError::Unauthorized)
    } else if sel == selector("ZeroAddress()") {
        Some(AdapterError::ZeroAddress)
    } else if sel == selector("NotContract(address)") {
        Some(AdapterError::NotContract(address_at(data, 0)))
    } else if sel == selector("ZeroAmount()") {
        Some(AdapterError::ZeroAmount)
    } else if sel == selector("InvalidTokenPair()") {
        Some(AdapterError::InvalidTokenPair)
    } else if sel == selector("InvalidMinAmountOut()") {
        Some(AdapterError::InvalidMinAmountOut)
    } else if sel == selector("InvalidDataLength()") {
        Some(AdapterError::InvalidDataLength)
    } else if sel == selector("LeftoverToken(address,uint256)") {
        Some(AdapterError::LeftoverToken {
            token: address_at(data, 0),
            balance: uint_at(data, 1),
        })
    } else if sel == selector("InvalidTickSpacing()") {
        Some(AdapterError::InvalidTickSpacing)
    } else {
        None
    };
    if let Some(err) = adapter {
        return DecodedError::Adapter(err);
    }

    // --- OpenZeppelin ---------------------------------------------------------------------
    let oz = if sel == selector("OwnableUnauthorizedAccount(address)") {
        Some(OzError::OwnableUnauthorizedAccount(address_at(data, 0)))
    } else if sel == selector("OwnableInvalidOwner(address)") {
        Some(OzError::OwnableInvalidOwner(address_at(data, 0)))
    } else if sel == selector("ReentrancyGuardReentrantCall()") {
        Some(OzError::ReentrancyGuardReentrantCall)
    } else if sel == selector("SafeERC20FailedOperation(address)") {
        Some(OzError::SafeERC20FailedOperation(address_at(data, 0)))
    } else {
        None
    };
    if let Some(err) = oz {
        return DecodedError::Oz(err);
    }

    DecodedError::Unknown {
        selector: sel,
        data: Bytes::copy_from_slice(data),
    }
}

/// Extract revert bytes from an Alloy RPC error payload.
///
/// Providers are inconsistent: some return a hex string, some return an object
/// with `data`, and some nest the useful value under `originalError`.
pub fn revert_data_from_payload(payload: &ErrorPayload) -> Option<Bytes> {
    let raw = payload.data.as_ref()?;
    let value: Value = serde_json::from_str(raw.get()).ok()?;
    value_to_bytes(&value)
}

fn value_to_bytes(value: &Value) -> Option<Bytes> {
    match value {
        Value::String(s) => {
            if let Some(hex) = s.strip_prefix("0x")
                && hex.len() % 2 == 0
            {
                return alloy::hex::decode(hex).ok().map(Bytes::from);
            }
            // Some providers return a JSON string that itself contains JSON.
            serde_json::from_str::<Value>(s)
                .ok()
                .and_then(|nested| value_to_bytes(&nested))
        }
        Value::Object(map) => {
            for key in ["data", "result", "returnData", "originalError"] {
                if let Some(inner) = map.get(key)
                    && let Some(bytes) = value_to_bytes(inner)
                {
                    return Some(bytes);
                }
            }
            None
        }
        _ => None,
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn selectors_match_known_core_values() {
        assert_eq!(
            selector("execute(address,uint256,(address,address,address,uint256,bytes)[],uint256)"),
            [0x76, 0xaf, 0x42, 0x22]
        );
        assert_eq!(
            selector("simulate(address,uint256,(address,address,address,uint256,bytes)[])"),
            [0x2d, 0x66, 0xc4, 0xe3]
        );
        assert_eq!(
            selector("SimulationResult(int256)"),
            [0x00, 0xcf, 0x1e, 0xa6]
        );
        assert_eq!(
            selector("MinProfitNotMet(uint256,uint256)"),
            [0x2c, 0x10, 0xb3, 0x04]
        );
        assert_eq!(
            selector("InsufficientOutput(uint256,uint256,uint256)"),
            [0x3f, 0x61, 0x2d, 0x47]
        );
        assert_eq!(selector("Loss(uint256,uint256)"), [0x86, 0xf8, 0x3f, 0x02]);
        assert_eq!(
            selector("TradeTooLarge(address,uint256,uint256)"),
            [0x8e, 0x8d, 0xd3, 0xa9]
        );
        assert_eq!(
            selector("AdapterNotAllowed(address)"),
            [0xfa, 0xe0, 0x21, 0xe8]
        );
        assert_eq!(
            selector("GasPriceTooHigh(uint256,uint256)"),
            [0x94, 0x11, 0x83, 0x33]
        );
    }

    #[test]
    fn decodes_simulation_result() {
        let mut data = vec![0x00, 0xcf, 0x1e, 0xa6];
        data.extend_from_slice(&U256::from(1234u64).to_be_bytes::<32>());
        assert_eq!(
            decode(&data),
            DecodedError::SimulationResult(I256::try_from(1234).unwrap())
        );
    }

    #[test]
    fn decodes_negative_simulation_result() {
        let mut data = vec![0x00, 0xcf, 0x1e, 0xa6];
        let negative = I256::try_from(-42).unwrap();
        data.extend_from_slice(&negative.to_be_bytes::<32>());
        assert_eq!(decode(&data), DecodedError::SimulationResult(negative));
    }

    #[test]
    fn decodes_error_string() {
        let mut data = vec![0x08, 0xc3, 0x79, 0xa0];
        // offset 32, length 5, "hello"
        data.extend_from_slice(&U256::from(32u64).to_be_bytes::<32>());
        data.extend_from_slice(&U256::from(5u64).to_be_bytes::<32>());
        let mut text = b"hello".to_vec();
        text.resize(32, 0);
        data.extend_from_slice(&text);
        assert_eq!(
            decode(&data),
            DecodedError::ErrorString("hello".to_string())
        );
    }

    #[test]
    fn decodes_trade_too_large() {
        let mut data = Vec::new();
        data.extend_from_slice(&selector("TradeTooLarge(address,uint256,uint256)"));
        data.extend_from_slice(&U256::from(0x1234u64).to_be_bytes::<32>());
        data.extend_from_slice(&U256::from(500u64).to_be_bytes::<32>());
        data.extend_from_slice(&U256::from(100u64).to_be_bytes::<32>());
        let decoded = decode(&data);
        assert!(matches!(
            decoded,
            DecodedError::Core(CoreError::TradeTooLarge { amount, max, .. })
                if amount == U256::from(500) && max == U256::from(100)
        ));
    }

    #[test]
    fn unknown_selector_is_preserved() {
        let data = vec![0xde, 0xad, 0xbe, 0xef, 0x00];
        match decode(&data) {
            DecodedError::Unknown { selector, .. } => {
                assert_eq!(selector, [0xde, 0xad, 0xbe, 0xef])
            }
            other => panic!("expected unknown, got {other:?}"),
        }
    }
}

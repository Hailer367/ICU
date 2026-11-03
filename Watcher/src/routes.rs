use std::collections::HashMap;

use alloy::primitives::{Address, Bytes, I256, U256, address, keccak256};
use alloy::sol_types::SolValue;
use anyhow::{Result, bail};

use crate::abi::ryo;
use crate::config::Manifest;

#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum Venue {
    UniV2,
    UniV3 {
        fee: u32,
    },
    Aerodrome {
        stable: bool,
    },
    Slipstream {
        tick_spacing: i32,
    },
    /// PancakeSwap V3. `fee` is one of Pancake's own tiers (100/500/2500/10000); Uniswap's 3000
    /// tier does not exist there.
    PancakeV3 {
        fee: u32,
    },
}

impl Venue {
    pub fn adapter_name(&self) -> &'static str {
        match self {
            Self::UniV2 => "univ2",
            Self::UniV3 { .. } => "univ3",
            Self::Aerodrome { .. } => "aerodrome",
            Self::Slipstream { .. } => "slipstream",
            Self::PancakeV3 { .. } => "pancake",
        }
    }

    pub fn label(&self) -> String {
        match self {
            Self::UniV2 => "univ2".to_string(),
            Self::UniV3 { fee } => format!("univ3:{fee}"),
            Self::Aerodrome { stable } => {
                if *stable {
                    "aerodrome:stable".to_string()
                } else {
                    "aerodrome:volatile".to_string()
                }
            }
            Self::Slipstream { tick_spacing } => format!("slipstream:{tick_spacing}"),
            Self::PancakeV3 { fee } => format!("pancake:{fee}"),
        }
    }

    /// Encode the adapter-specific `data` field for this venue.
    pub fn data(&self) -> Bytes {
        match self {
            Self::UniV2 => Bytes::new(),
            Self::UniV3 { fee } => {
                let word = U256::from(*fee).to_be_bytes::<32>();
                Bytes::copy_from_slice(&word)
            }
            Self::Aerodrome { stable } => {
                let word = U256::from(u8::from(*stable)).to_be_bytes::<32>();
                Bytes::copy_from_slice(&word)
            }
            Self::Slipstream { tick_spacing } => {
                let word = I256::try_from(*tick_spacing as i64)
                    .expect("tick spacing fits in i256")
                    .to_be_bytes::<32>();
                Bytes::copy_from_slice(&word)
            }
            Self::PancakeV3 { fee } => {
                let word = U256::from(*fee).to_be_bytes::<32>();
                Bytes::copy_from_slice(&word)
            }
        }
    }
}

#[derive(Debug, Clone)]
pub struct Token {
    pub address: Address,
    pub symbol: String,
    pub decimals: u8,
}

#[derive(Debug, Clone)]
pub struct Pool {
    pub address: Address,
    pub venue: Venue,
    pub token0: Address,
    pub token1: Address,
}

impl Pool {
    pub fn other(&self, token: Address) -> Option<Address> {
        if token == self.token0 {
            Some(self.token1)
        } else if token == self.token1 {
            Some(self.token0)
        } else {
            None
        }
    }

    pub fn contains(&self, token: Address) -> bool {
        token == self.token0 || token == self.token1
    }

    /// The legacy venue set this watcher was built around. An ambiguous bare
    /// route label resolves here (see `parse_route`).
    pub fn is_usdc_weth(&self) -> bool {
        let usdc = crate::config::base::USDC;
        let weth = crate::config::base::WETH;
        (self.token0 == usdc && self.token1 == weth) || (self.token0 == weth && self.token1 == usdc)
    }
}

impl std::str::FromStr for Venue {
    type Err = String;

    fn from_str(spec: &str) -> std::result::Result<Self, Self::Err> {
        let spec = spec.trim().to_ascii_lowercase();
        let (name, detail) = spec.split_once(':').unwrap_or((spec.as_str(), ""));
        match name {
            "univ2" => Ok(Self::UniV2),
            "univ3" => {
                let fee: u32 = detail
                    .parse()
                    .map_err(|_| format!("univ3 fee must be a number, got {detail:?}"))?;
                Ok(Self::UniV3 { fee })
            }
            "aerodrome" | "aero" => match detail {
                "stable" => Ok(Self::Aerodrome { stable: true }),
                "volatile" | "vol" | "" => Ok(Self::Aerodrome { stable: false }),
                other => Err(format!(
                    "aerodrome kind must be stable or volatile, got {other:?}"
                )),
            },
            "slipstream" | "slip" => {
                let tick_spacing: i32 = detail.parse().map_err(|_| {
                    format!("slipstream tick spacing must be a number, got {detail:?}")
                })?;
                Ok(Self::Slipstream { tick_spacing })
            }
            "pancake" | "pcake" => {
                let fee: u32 = detail
                    .parse()
                    .map_err(|_| format!("pancake fee must be a number, got {detail:?}"))?;
                Ok(Self::PancakeV3 { fee })
            }
            other => Err(format!("unknown venue {other:?}")),
        }
    }
}

/// Split one route label into a venue and an optional exit-token symbol.
///
/// Grammar: `venue[:param][:token]`. The token names the leg's *output*, so
/// `univ3:500:cbbtc` means "the 0.05% Uniswap V3 pool that swaps into cbBTC".
/// It only disambiguates when one venue parameter exists across several
/// trading pairs (e.g. univ3:500 sits on WETH/USDC, cbBTC/USDC and cbBTC/WETH
/// on Base today).
fn parse_label(label: &str) -> std::result::Result<(Venue, Option<String>), String> {
    let parts: Vec<String> = label
        .split(':')
        .map(|p| p.trim().to_ascii_lowercase())
        .filter(|p| !p.is_empty())
        .collect();
    let name = parts
        .first()
        .ok_or_else(|| "empty route label".to_string())?;
    let symbol = |i: usize| parts.get(i).cloned();
    match name.as_str() {
        "univ2" => Ok((Venue::UniV2, symbol(1))),
        "univ3" | "pancake" | "pcake" | "slipstream" | "slip" => {
            let detail = parts
                .get(1)
                .ok_or_else(|| format!("{name} needs a fee/tick-spacing parameter"))?;
            let venue: Venue = format!("{name}:{detail}").parse()?;
            Ok((venue, symbol(2)))
        }
        "aerodrome" | "aero" => match parts.get(1).map(String::as_str) {
            None => Ok((Venue::Aerodrome { stable: false }, None)),
            Some(kind @ ("stable" | "volatile" | "vol")) => Ok((
                Venue::Aerodrome {
                    stable: kind == "stable",
                },
                symbol(2),
            )),
            Some(other) => Ok((Venue::Aerodrome { stable: false }, Some(other.to_string()))),
        },
        other => Err(format!("unknown venue {other:?}")),
    }
}

/// Parse a human-readable venue list into a route starting and ending at `asset`.
///
/// Example: `univ3:500,univ3:100` means USDC -> WETH on the 0.05% pool, then
/// WETH -> USDC on the 0.01% pool. Once a venue parameter exists on several
/// pairs, the exit token must be named: `univ3:500:cbbtc,univ3:500:weth`
/// round-trips USDC -> cbBTC -> USDC. A bare label resolves to the USDC/WETH
/// pool when one candidate is legacy; otherwise it must be unambiguous.
pub fn parse_route(registry: &Registry, asset: Address, spec: &str) -> Result<Route> {
    let labels: Vec<&str> = spec
        .split([',', '>'])
        .map(str::trim)
        .filter(|label| !label.is_empty())
        .collect();
    if labels.len() < 2 {
        bail!("a route needs at least two venues, got {labels:?}");
    }

    let mut current = asset;
    let mut steps = Vec::with_capacity(labels.len());
    for label in labels {
        let (venue, symbol) = parse_label(label).map_err(|e| anyhow::anyhow!(e))?;
        let mut matches: Vec<usize> = registry
            .pools
            .iter()
            .enumerate()
            .filter_map(|(index, pool)| {
                (pool.venue == venue && pool.contains(current)).then_some(index)
            })
            .collect();
        if let Some(symbol) = &symbol {
            let target = registry
                .token_by_symbol(symbol)
                .ok_or_else(|| anyhow::anyhow!("unknown token {symbol:?} in {label}"))?;
            matches.retain(|index| {
                registry
                    .pool(*index)
                    .other(current)
                    .is_some_and(|other| other == target)
            });
            if matches.is_empty() {
                bail!("no {venue:?} pool from {current} into {target} (label {label:?})");
            }
        }
        if matches.len() > 1 {
            // Legacy default: an ambiguous bare label means the USDC/WETH
            // pool, the one every route string predating multi-pair venues
            // referred to.
            let legacy: Vec<usize> = matches
                .iter()
                .copied()
                .filter(|index| registry.pool(*index).is_usdc_weth())
                .collect();
            if legacy.len() == 1 {
                matches = legacy;
            } else {
                let options: Vec<String> = matches
                    .iter()
                    .map(|index| {
                        let pool = registry.pool(*index);
                        let out = registry
                            .symbol(pool.other(current).unwrap_or_default())
                            .to_ascii_lowercase();
                        format!("{}:{out}", venue.label())
                    })
                    .collect();
                bail!(
                    "multiple pools for {label:?} containing {current}; disambiguate with one of {}",
                    options.join(", ")
                );
            }
        }
        let [pool_index] = matches.as_slice() else {
            bail!("no pool for {label} containing {current}");
        };
        let pool_index = *pool_index;
        let pool = registry.pool(pool_index);
        let token_out = pool
            .other(current)
            .ok_or_else(|| anyhow::anyhow!("pool {pool_index} does not contain {current}"))?;
        steps.push(RouteStep {
            pool_index,
            token_in: current,
            token_out,
            venue,
            data: venue.data(),
        });
        current = token_out;
    }

    if current != asset {
        bail!("route must return to the starting asset, but it ends at {current}");
    }
    Ok(Route { asset, steps })
}

#[derive(Debug, Clone)]
pub struct Edge {
    pub pool_index: usize,
    pub token_in: Address,
    pub token_out: Address,
}

#[derive(Debug, Clone)]
pub struct Registry {
    pub pools: Vec<Pool>,
    pub tokens: HashMap<Address, Token>,
    pub edges: Vec<Edge>,
}

impl Registry {
    pub fn token(&self, address: Address) -> Option<&Token> {
        self.tokens.get(&address)
    }

    /// Case-insensitive symbol lookup (route labels are lowercased).
    pub fn token_by_symbol(&self, symbol: &str) -> Option<Address> {
        self.tokens
            .iter()
            .find(|(_, token)| token.symbol.eq_ignore_ascii_case(symbol))
            .map(|(address, _)| *address)
    }

    pub fn symbol(&self, address: Address) -> &str {
        self.tokens
            .get(&address)
            .map(|t| t.symbol.as_str())
            .unwrap_or("?")
    }

    pub fn pool(&self, index: usize) -> &Pool {
        &self.pools[index]
    }

    /// The verified multi-pair venue set on Base mainnet (USDC, WETH, cbBTC,
    /// EURC).
    ///
    /// This is deliberately curated: every pool address below was checked
    /// on-chain against its factory (`getPool`/`getPair`), with token order,
    /// decimals and live depth recorded in State.md §0s. Add pools only after
    /// the same verification. New pools are **appended**: `scan --pools` and
    /// the integration tests address pools by registry index, so the indices
    /// of earlier entries must never shift.
    pub fn base_curated() -> Result<Self> {
        let usdc = crate::config::base::USDC;
        let weth = crate::config::base::WETH;
        let cbbtc = crate::config::base::CBBTC;
        let eurc = crate::config::base::EURC;

        let mut tokens = HashMap::new();
        tokens.insert(
            usdc,
            Token {
                address: usdc,
                symbol: "USDC".to_string(),
                decimals: 6,
            },
        );
        tokens.insert(
            weth,
            Token {
                address: weth,
                symbol: "WETH".to_string(),
                decimals: 18,
            },
        );
        tokens.insert(
            cbbtc,
            Token {
                address: cbbtc,
                symbol: "cbBTC".to_string(),
                decimals: 8,
            },
        );
        tokens.insert(
            eurc,
            Token {
                address: eurc,
                symbol: "EURC".to_string(),
                decimals: 6,
            },
        );

        let pools = vec![
            // Chain order for the original sixteen pools: WETH is token0,
            // USDC is token1. Quoting does not depend on this, but amount
            // decoding does (see scanner::swap_notional_usd). The appended
            // cbBTC/EURC pools record their own order per entry, verified
            // 2026-11-03 against live Base (`token0`/`token1` on each pool).
            Pool {
                address: address!("b4cb800910b228ed3d0834cf79d697127bbb00e5"),
                venue: Venue::UniV3 { fee: 100 },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("d0b53d9277642d899df5c87a3966a349a798f224"),
                venue: Venue::UniV3 { fee: 500 },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("6c561b446416e1a00e8e93e221854d6ea4171372"),
                venue: Venue::UniV3 { fee: 3000 },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("0b1c2dcbbfa744ebd3fc17ff1a96a1e1eb4b2d69"),
                venue: Venue::UniV3 { fee: 10000 },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("88a43bbdf9d098eec7bceda4e2494615dfd9bb9c"),
                venue: Venue::UniV2,
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("cdac0d6c6c59727a65f871236188350531885c43"),
                venue: Venue::Aerodrome { stable: false },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("3548029694fbb241d45fb24ba0cd9c9d4e745f16"),
                venue: Venue::Aerodrome { stable: true },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("dbc6998296caa1652a810dc8d3baf4a8294330f1"),
                venue: Venue::Slipstream { tick_spacing: 1 },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("b150768cf55d1625e2337a08fbd1b0f02ff94bdb"),
                venue: Venue::Slipstream { tick_spacing: 10 },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("aad23a67f2ac693abbe543489aeb3f24f561d517"),
                venue: Venue::Slipstream { tick_spacing: 50 },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("b2cc224c1c9fee385f8ad6a55b4d94e92359dc59"),
                venue: Venue::Slipstream { tick_spacing: 100 },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("148bc43946a902258916e580b0e6d92aaa74746f"),
                venue: Venue::Slipstream { tick_spacing: 200 },
                token0: weth,
                token1: usdc,
            },
            // PancakeSwap V3. Checked with `pancakeV3Factory.getPool(WETH, USDC, fee)`; the
            // 3000-tier that Uniswap has does not exist on Pancake, and Pancake's 2500 tier has
            // no Uniswap counterpart.
            Pool {
                address: address!("72ab388e2e2f6facef59e3c3fa2c4e29011c2d38"),
                venue: Venue::PancakeV3 { fee: 100 },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("b775272e537cc670c65dc852908ad47015244eaf"),
                venue: Venue::PancakeV3 { fee: 500 },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("e9d76696f8a35e2e2520e3125875c3af23f1e69c"),
                venue: Venue::PancakeV3 { fee: 2500 },
                token0: weth,
                token1: usdc,
            },
            Pool {
                address: address!("118efef7db0712f03e067122b8f89e7a4b79262f"),
                venue: Venue::PancakeV3 { fee: 10000 },
                token0: weth,
                token1: usdc,
            },
            // Tier-1 expansion (State.md §0s). Every address re-verified live
            // on 2026-11-03 through its factory plus token0/token1; pools are
            // included only at USD depth >= ~$50k measured the same day.
            // cbBTC/USDC: USDC is token0 (0x8335.. < 0xcbB7..).
            Pool {
                address: address!("fbb6eed8e7aa03b138556eedaf5d271a5e1e43ef"),
                venue: Venue::UniV3 { fee: 500 },
                token0: usdc,
                token1: cbbtc,
            },
            Pool {
                address: address!("ec558e484cc9f2210714e345298fdc53b253c27d"),
                venue: Venue::UniV3 { fee: 3000 },
                token0: usdc,
                token1: cbbtc,
            },
            Pool {
                address: address!("b94b22332abf5f89877a14cc88f2abc48c34b3df"),
                venue: Venue::PancakeV3 { fee: 100 },
                token0: usdc,
                token1: cbbtc,
            },
            Pool {
                address: address!("26e263efdc91f0d3279e2ec2bd58a7ca5c2fce62"),
                venue: Venue::PancakeV3 { fee: 500 },
                token0: usdc,
                token1: cbbtc,
            },
            Pool {
                address: address!("748bb91fc5f4200302d9a79185bc161260a1b461"),
                venue: Venue::PancakeV3 { fee: 2500 },
                token0: usdc,
                token1: cbbtc,
            },
            Pool {
                address: address!("4e962bb3889bf030368f56810a9c96b83cb3e778"),
                venue: Venue::Slipstream { tick_spacing: 100 },
                token0: usdc,
                token1: cbbtc,
            },
            // cbBTC/WETH: WETH is token0 (0x4200.. < 0xcbB7..).
            Pool {
                address: address!("7aea2e8a3843516afa07293a10ac8e49906dabd1"),
                venue: Venue::UniV3 { fee: 500 },
                token0: weth,
                token1: cbbtc,
            },
            Pool {
                address: address!("8c7080564b5a792a33ef2fd473fba6364d5495e5"),
                venue: Venue::UniV3 { fee: 3000 },
                token0: weth,
                token1: cbbtc,
            },
            Pool {
                address: address!("233571eae953d9d59eefc0769f71dc19287ddccb"),
                venue: Venue::UniV3 { fee: 10000 },
                token0: weth,
                token1: cbbtc,
            },
            Pool {
                address: address!("c211e1f853a898bd1302385ccde55f33a8c4b3f3"),
                venue: Venue::PancakeV3 { fee: 100 },
                token0: weth,
                token1: cbbtc,
            },
            Pool {
                address: address!("d974d59e30054cf1abeded0c9947b0d8baf90029"),
                venue: Venue::PancakeV3 { fee: 500 },
                token0: weth,
                token1: cbbtc,
            },
            Pool {
                address: address!("5b3613ef9a535b48e82e2800acb77053dfec93b1"),
                venue: Venue::PancakeV3 { fee: 2500 },
                token0: weth,
                token1: cbbtc,
            },
            Pool {
                address: address!("70acdf2ad0bf2402c957154f944c19ef4e1cbae1"),
                venue: Venue::Slipstream { tick_spacing: 100 },
                token0: weth,
                token1: cbbtc,
            },
            Pool {
                address: address!("2578365b3dfa7ffe60108e181efb79feddec2319"),
                venue: Venue::Aerodrome { stable: false },
                token0: weth,
                token1: cbbtc,
            },
            // USDC/EURC: EURC is token0 (0x60a3.. < 0x8335..).
            Pool {
                address: address!("7279c08a36333e12c3fc81747963264c100d66fb"),
                venue: Venue::UniV3 { fee: 500 },
                token0: eurc,
                token1: usdc,
            },
            Pool {
                address: address!("1ca42c7219f0cb1b67927e26502320cb98f725bd"),
                venue: Venue::PancakeV3 { fee: 100 },
                token0: eurc,
                token1: usdc,
            },
            // WETH/EURC: WETH is token0.
            Pool {
                address: address!("b4a43d89b5d356065646389fd677ca762efcd780"),
                venue: Venue::PancakeV3 { fee: 500 },
                token0: weth,
                token1: eurc,
            },
        ];

        let mut edges = Vec::new();
        for (index, pool) in pools.iter().enumerate() {
            edges.push(Edge {
                pool_index: index,
                token_in: pool.token0,
                token_out: pool.token1,
            });
            edges.push(Edge {
                pool_index: index,
                token_in: pool.token1,
                token_out: pool.token0,
            });
        }

        Ok(Self {
            pools,
            tokens,
            edges,
        })
    }

    pub fn edges_from(&self, token: Address) -> impl Iterator<Item = &Edge> {
        self.edges.iter().filter(move |edge| edge.token_in == token)
    }

    pub fn pools_containing(&self, token: Address) -> Vec<usize> {
        self.pools
            .iter()
            .enumerate()
            .filter_map(|(i, p)| p.contains(token).then_some(i))
            .collect()
    }

    pub fn all_pool_addresses(&self) -> Vec<Address> {
        self.pools.iter().map(|p| p.address).collect()
    }
}

#[derive(Debug, Clone)]
pub struct RouteStep {
    pub pool_index: usize,
    pub token_in: Address,
    pub token_out: Address,
    pub venue: Venue,
    pub data: Bytes,
}

#[derive(Debug, Clone)]
pub struct Route {
    pub asset: Address,
    pub steps: Vec<RouteStep>,
}

impl Route {
    /// Human labels for each leg, round-trippable through `parse_route`. A
    /// label gains its `:token` suffix only when the bare venue would resolve
    /// to a different pool on that leg.
    pub fn labels(&self, registry: &Registry) -> Vec<String> {
        self.steps
            .iter()
            .map(|step| {
                let bare = step.venue.label();
                let mut candidates: Vec<usize> = registry
                    .pools
                    .iter()
                    .enumerate()
                    .filter_map(|(index, pool)| {
                        (pool.venue == step.venue && pool.contains(step.token_in)).then_some(index)
                    })
                    .collect();
                if candidates.len() > 1 {
                    let legacy: Vec<usize> = candidates
                        .iter()
                        .copied()
                        .filter(|index| registry.pool(*index).is_usdc_weth())
                        .collect();
                    if legacy.len() == 1 {
                        candidates = legacy;
                    }
                }
                if candidates == [step.pool_index] {
                    bare
                } else {
                    format!(
                        "{bare}:{}",
                        registry.symbol(step.token_out).to_ascii_lowercase()
                    )
                }
            })
            .collect()
    }

    pub fn pool_indices(&self) -> Vec<usize> {
        self.steps.iter().map(|s| s.pool_index).collect()
    }

    pub fn to_steps(&self, manifest: &Manifest, floors: &[U256]) -> Result<Vec<ryo::Step>> {
        if floors.len() != self.steps.len() {
            bail!(
                "floors length {} does not match route length {}",
                floors.len(),
                self.steps.len()
            );
        }
        let mut steps = Vec::with_capacity(self.steps.len());
        for (i, step) in self.steps.iter().enumerate() {
            let adapter = manifest.adapter(step.venue.adapter_name()).ok_or_else(|| {
                anyhow::anyhow!("manifest has no adapter for {}", step.venue.adapter_name())
            })?;
            let floor = floors[i];
            if floor == U256::ZERO {
                bail!("step {i} has a zero minAmountOut");
            }
            steps.push(ryo::Step {
                adapter,
                tokenIn: step.token_in,
                tokenOut: step.token_out,
                minAmountOut: floor,
                data: step.data.clone(),
            });
        }
        Ok(steps)
    }

    pub fn route_hash(
        &self,
        manifest: &Manifest,
        floors: &[U256],
    ) -> Result<alloy::primitives::B256> {
        let steps = self.to_steps(manifest, floors)?;
        let encoded = (U256::from(1u8), steps).abi_encode();
        Ok(keccak256(encoded))
    }
}

/// Enumerate simple cycles starting and ending at `asset`.
///
/// `max_hops` is the maximum number of steps. Pools cannot be reused inside a
/// route, and intermediate tokens cannot repeat.
pub fn enumerate_cycles(registry: &Registry, asset: Address, max_hops: usize) -> Vec<Route> {
    let mut routes = Vec::new();
    let mut used_pools = Vec::new();
    let mut visited_tokens = vec![asset];
    let mut current_steps = Vec::new();
    dfs(
        registry,
        asset,
        asset,
        max_hops,
        &mut used_pools,
        &mut visited_tokens,
        &mut current_steps,
        &mut routes,
    );
    routes
}

#[allow(clippy::too_many_arguments)]
fn dfs(
    registry: &Registry,
    asset: Address,
    current: Address,
    max_hops: usize,
    used_pools: &mut Vec<usize>,
    visited_tokens: &mut Vec<Address>,
    current_steps: &mut Vec<RouteStep>,
    routes: &mut Vec<Route>,
) {
    if current_steps.len() >= max_hops {
        return;
    }

    for edge in registry.edges_from(current) {
        if used_pools.contains(&edge.pool_index) {
            continue;
        }
        let next = edge.token_out;
        let pool = registry.pool(edge.pool_index);
        let step = RouteStep {
            pool_index: edge.pool_index,
            token_in: current,
            token_out: next,
            venue: pool.venue,
            data: pool.venue.data(),
        };

        if next == asset {
            if current_steps.len() + 1 >= 2 {
                let mut steps = current_steps.clone();
                steps.push(step);
                routes.push(Route { asset, steps });
            }
            continue;
        }

        if visited_tokens.contains(&next) {
            continue;
        }

        used_pools.push(edge.pool_index);
        visited_tokens.push(next);
        current_steps.push(step);
        dfs(
            registry,
            asset,
            next,
            max_hops,
            used_pools,
            visited_tokens,
            current_steps,
            routes,
        );
        current_steps.pop();
        visited_tokens.pop();
        used_pools.pop();
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn registry_has_expected_pools() {
        let registry = Registry::base_curated().unwrap();
        assert_eq!(registry.pools.len(), 33);
        assert_eq!(registry.edges.len(), 66);
        assert_eq!(registry.tokens.len(), 4);
        // Addresses are unique and every leg endpoint has decimal knowledge.
        let mut seen = std::collections::HashSet::new();
        for pool in &registry.pools {
            assert!(
                seen.insert(pool.address),
                "duplicate pool address {}",
                pool.address
            );
            assert!(
                registry.token(pool.token0).is_some() && registry.token(pool.token1).is_some(),
                "pool {} references an unknown token",
                pool.address
            );
            assert_ne!(pool.token0, pool.token1, "pool lists one token twice");
        }
        // Every venue must be represented, otherwise a whole adapter sits unused.
        for venue in [
            Venue::UniV2,
            Venue::UniV3 { fee: 100 },
            Venue::Aerodrome { stable: false },
            Venue::Slipstream { tick_spacing: 1 },
            Venue::PancakeV3 { fee: 100 },
        ] {
            assert!(
                registry.pools.iter().any(|p| p.venue == venue),
                "registry is missing {}",
                venue.label()
            );
        }
        // The legacy USDC/WETH block keeps its indices: `scan --pools` and the
        // fork tests address pools by number.
        assert!(registry.pools[..16].iter().all(Pool::is_usdc_weth));
        assert!(registry.pools[16..].iter().all(|p| !p.is_usdc_weth()));
    }

    #[test]
    fn enumerates_two_hop_cycles() {
        let registry = Registry::base_curated().unwrap();
        let asset = crate::config::base::USDC;
        let routes = enumerate_cycles(&registry, asset, 2);
        // A two-hop cycle leaves and returns through pools sharing the asset;
        // for every neighbour token with n pools that is n*(n-1) ordered pairs.
        let expected: usize = registry
            .tokens
            .keys()
            .filter(|t| *t != &asset)
            .map(|other| {
                let n = registry
                    .pools
                    .iter()
                    .filter(|p| p.contains(asset) && p.contains(*other))
                    .count();
                n * n.saturating_sub(1)
            })
            .sum();
        assert_eq!(routes.len(), expected);
        assert_eq!(expected, 240 + 30 + 2); // WETH 16 pools, cbBTC 6, EURC 2
        for route in &routes {
            assert_eq!(route.steps.len(), 2);
            assert_eq!(route.steps[0].token_in, asset);
            assert_eq!(route.steps[1].token_out, asset);
            assert_ne!(route.steps[0].pool_index, route.steps[1].pool_index);
        }
    }

    #[test]
    fn parses_venue_labels() {
        assert_eq!("univ2".parse::<Venue>().unwrap(), Venue::UniV2);
        assert_eq!(
            "pancake:2500".parse::<Venue>().unwrap(),
            Venue::PancakeV3 { fee: 2500 }
        );
        assert_eq!(Venue::PancakeV3 { fee: 2500 }.adapter_name(), "pancake");
        assert_eq!(
            Venue::PancakeV3 { fee: 2500 }.data(),
            Venue::UniV3 { fee: 2500 }.data()
        );
        assert_eq!(
            "univ3:500".parse::<Venue>().unwrap(),
            Venue::UniV3 { fee: 500 }
        );
        assert_eq!(
            "aerodrome:stable".parse::<Venue>().unwrap(),
            Venue::Aerodrome { stable: true }
        );
        assert_eq!(
            "slipstream:10".parse::<Venue>().unwrap(),
            Venue::Slipstream { tick_spacing: 10 }
        );
        assert!("univ3:abc".parse::<Venue>().is_err());
    }

    #[test]
    fn parses_route_spec() {
        let registry = Registry::base_curated().unwrap();
        let asset = crate::config::base::USDC;
        let route = parse_route(&registry, asset, "univ3:500,univ3:100").unwrap();
        assert_eq!(route.asset, asset);
        assert_eq!(route.steps.len(), 2);
        assert_eq!(route.steps[0].token_in, asset);
        assert_eq!(route.steps[1].token_out, asset);
        assert_eq!(route.steps[0].venue, Venue::UniV3 { fee: 500 });
        assert_eq!(route.steps[1].venue, Venue::UniV3 { fee: 100 });
    }

    #[test]
    fn rejects_route_that_does_not_return() {
        let registry = Registry::base_curated().unwrap();
        assert!(parse_route(&registry, crate::config::base::USDC, "univ3:500").is_err());
    }

    #[test]
    fn token_suffix_labels_reach_the_named_pair() {
        let registry = Registry::base_curated().unwrap();
        let usdc = crate::config::base::USDC;
        let cbbtc = crate::config::base::CBBTC;
        // Two-hop USDC -> cbBTC -> USDC, one pool on each side.
        let route = parse_route(&registry, usdc, "univ3:500:cbbtc,univ3:500:usdc").unwrap();
        assert_eq!(route.steps.len(), 2);
        assert_eq!(route.steps[0].token_out, cbbtc);
        assert_eq!(route.steps[1].token_out, usdc);
        assert!(!registry.pool(route.steps[0].pool_index).is_usdc_weth());
        assert!(!registry.pool(route.steps[1].pool_index).is_usdc_weth());
        // A two-hop cbBTC round trip through two different venues.
        let route = parse_route(&registry, usdc, "univ3:500:cbbtc,pancake:100:usdc").unwrap();
        assert_eq!(route.steps[1].token_out, usdc);
        assert_ne!(route.steps[0].pool_index, route.steps[1].pool_index);
        for index in route.pool_indices() {
            let pool = registry.pool(index);
            assert!(pool.contains(cbbtc) && pool.contains(usdc) && !pool.is_usdc_weth());
        }
    }

    #[test]
    fn bare_labels_default_to_the_legacy_pair() {
        let registry = Registry::base_curated().unwrap();
        let usdc = crate::config::base::USDC;
        // univ3:500 exists on three pairs; bare form must mean WETH/USDC,
        // exactly as every pre-expansion route string did.
        let route = parse_route(&registry, usdc, "univ3:500,univ3:100").unwrap();
        assert!(registry.pool(route.steps[0].pool_index).is_usdc_weth());
        assert!(registry.pool(route.steps[1].pool_index).is_usdc_weth());
    }

    #[test]
    fn ambiguous_non_legacy_labels_are_rejected_with_options() {
        let registry = Registry::base_curated().unwrap();
        let cbbtc = crate::config::base::CBBTC;
        // From cbBTC, univ3:500 sits on both USDC and WETH pairs with no
        // legacy pool to fall back to.
        let err = parse_route(&registry, cbbtc, "univ3:500,univ3:500").unwrap_err();
        let message = err.to_string();
        assert!(message.contains("disambiguate"), "{message}");
        assert!(message.contains("univ3:500:usdc"), "{message}");
        assert!(message.contains("univ3:500:weth"), "{message}");
    }

    #[test]
    fn route_labels_round_trip_through_parse() {
        let registry = Registry::base_curated().unwrap();
        for (asset, spec) in [
            (crate::config::base::USDC, "univ3:500,univ3:100"),
            (crate::config::base::USDC, "univ3:500:cbbtc,univ3:500:usdc"),
            (
                crate::config::base::USDC,
                "pancake:100:cbbtc,pancake:100:usdc",
            ),
            (
                crate::config::base::USDC,
                "univ3:500:cbbtc,aerodrome:volatile:weth,aerodrome:volatile",
            ),
            (crate::config::base::WETH, "univ3:500:cbbtc,univ3:500:weth"),
            (crate::config::base::USDC, "univ3:500:eurc,pancake:100:usdc"),
            (
                crate::config::base::WETH,
                "pancake:500:cbbtc,pancake:500:usdc,univ3:500",
            ),
        ] {
            let route = parse_route(&registry, asset, spec)
                .unwrap_or_else(|err| panic!("parse {spec}: {err}"));
            let printed = route.labels(&registry).join(",");
            let again = parse_route(&registry, asset, &printed)
                .unwrap_or_else(|err| panic!("reparse {spec} -> {printed}: {err}"));
            assert_eq!(
                again.pool_indices(),
                route.pool_indices(),
                "round trip of {spec} changed pools"
            );
        }
    }

    #[test]
    fn three_hop_triangles_enumerate() {
        let registry = Registry::base_curated().unwrap();
        let usdc = crate::config::base::USDC;
        let two = enumerate_cycles(&registry, usdc, 2);
        let three = enumerate_cycles(&registry, usdc, 3);
        assert!(three.len() > 2 * two.len(), "hops=3 must add triangles");
        let mut triangles = three
            .iter()
            .filter(|route| route.steps.len() == 3)
            .filter(|route| {
                route
                    .steps
                    .iter()
                    .any(|step| step.token_out == crate::config::base::CBBTC)
            });
        let triangle = triangles
            .next()
            .expect("USDC -> WETH/cbBTC -> cbBTC -> USDC triangles must exist");
        assert_eq!(triangle.steps.len(), 3);
        assert_eq!(triangle.steps[0].token_in, usdc);
        assert_eq!(triangle.steps[2].token_out, usdc);
        let tokens: Vec<_> = triangle.steps.iter().map(|s| s.token_out).collect();
        assert_eq!(
            tokens,
            vec![crate::config::base::WETH, crate::config::base::CBBTC, usdc]
        );
        // Intermediate tokens never repeat and pools never repeat.
        for route in &three {
            let pools = route.pool_indices();
            assert_eq!(
                pools.len(),
                pools.iter().collect::<std::collections::HashSet<_>>().len()
            );
        }
    }

    #[test]
    fn encodes_adapter_data() {
        assert_eq!(Venue::UniV2.data(), Bytes::new());
        assert_eq!(Venue::UniV3 { fee: 500 }.data().len(), 32);
        assert_eq!(Venue::Aerodrome { stable: true }.data().len(), 32);
        assert_eq!(Venue::Slipstream { tick_spacing: 100 }.data().len(), 32);
    }
}

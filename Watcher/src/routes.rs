use std::collections::HashMap;

use alloy::primitives::{Address, Bytes, I256, U256, address, keccak256};
use alloy::sol_types::SolValue;
use anyhow::{Result, bail};

use crate::abi::ryo;
use crate::config::Manifest;

#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum Venue {
    UniV2,
    UniV3 { fee: u32 },
    Aerodrome { stable: bool },
    Slipstream { tick_spacing: i32 },
}

impl Venue {
    pub fn adapter_name(&self) -> &'static str {
        match self {
            Self::UniV2 => "univ2",
            Self::UniV3 { .. } => "univ3",
            Self::Aerodrome { .. } => "aerodrome",
            Self::Slipstream { .. } => "slipstream",
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
            other => Err(format!("unknown venue {other:?}")),
        }
    }
}

/// Parse a human-readable venue list into a route starting and ending at `asset`.
///
/// Example: `univ3:500,univ3:100` means USDC -> WETH on the 0.05% pool, then
/// WETH -> USDC on the 0.01% pool.
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
        let venue: Venue = label.parse().map_err(|e: String| anyhow::anyhow!(e))?;
        let matches: Vec<usize> = registry
            .pools
            .iter()
            .enumerate()
            .filter_map(|(index, pool)| {
                (pool.venue == venue && pool.contains(current)).then_some(index)
            })
            .collect();
        let pool_index = match matches.as_slice() {
            [index] => *index,
            [] => bail!("no pool for {label} containing {current}"),
            _ => bail!("multiple pools for {label} containing {current}"),
        };
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

    pub fn symbol(&self, address: Address) -> &str {
        self.tokens
            .get(&address)
            .map(|t| t.symbol.as_str())
            .unwrap_or("?")
    }

    pub fn pool(&self, index: usize) -> &Pool {
        &self.pools[index]
    }

    /// The verified USDC/WETH venue set on Base mainnet.
    ///
    /// This is deliberately curated: every pool address below was checked
    /// on-chain. Add pools only after verifying `getPool`/`getPair` and code.
    pub fn base_usdc_weth() -> Result<Self> {
        let usdc = crate::config::base::USDC;
        let weth = crate::config::base::WETH;

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

        let pools = vec![
            // Chain order for every pool below: WETH is token0, USDC is
            // token1. Quoting does not depend on this, but amount decoding
            // does (see scanner::swap_notional_usd).
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
    pub fn venues(&self) -> Vec<String> {
        self.steps.iter().map(|s| s.venue.label()).collect()
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
    fn usdc_weth_registry_has_expected_pools() {
        let registry = Registry::base_usdc_weth().unwrap();
        assert_eq!(registry.pools.len(), 12);
        assert_eq!(registry.edges.len(), 24);
    }

    #[test]
    fn enumerates_two_hop_cycles() {
        let registry = Registry::base_usdc_weth().unwrap();
        let asset = crate::config::base::USDC;
        let routes = enumerate_cycles(&registry, asset, 2);
        // 12 ordered first legs, 11 remaining second legs (no pool reuse).
        assert_eq!(routes.len(), 12 * 11);
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
        let registry = Registry::base_usdc_weth().unwrap();
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
        let registry = Registry::base_usdc_weth().unwrap();
        assert!(parse_route(&registry, crate::config::base::USDC, "univ3:500").is_err());
    }

    #[test]
    fn encodes_adapter_data() {
        assert_eq!(Venue::UniV2.data(), Bytes::new());
        assert_eq!(Venue::UniV3 { fee: 500 }.data().len(), 32);
        assert_eq!(Venue::Aerodrome { stable: true }.data().len(), 32);
        assert_eq!(Venue::Slipstream { tick_spacing: 100 }.data().len(), 32);
    }
}

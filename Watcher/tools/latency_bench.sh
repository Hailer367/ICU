#!/usr/bin/env bash
# Fast latency bench: live Base triggers + latest-state fork with the core
# injected. No historical archive, no replay — this measures the real
# trigger -> ready-calldata pipeline in minutes.
#
#   tools/latency_bench.sh [minutes] [port]
#
# It primes once in-process (watch calls Scanner::prime_cl), then scans the
# live `logs` stream. The reported avg_scan_ms / phase averages are the
# production latency shape; compare them to Record A's offline close-time
# distribution (tools/winrate_curve.py). Use the historical replay only for
# head-to-head validation.
set -euo pipefail
cd "$(dirname "$0")/.."            # Watcher/
source "$HOME/.ryo_env"
export PATH="$PATH:$HOME/.foundry/bin:$HOME/.config/.foundry/bin"

MINUTES="${1:-5}"
PORT="${2:-8545}"
RPC="http://127.0.0.1:$PORT"
MANIFEST="${RYO_MANIFEST:-deployments/8453.race.json}"
TAG="$(date -u +%Y%m%dT%H%M%SZ)"
mkdir -p data/runs

if [ ! -f data/race_deploy_state.json ]; then
  echo "[bench] missing data/race_deploy_state.json; run tools/capture_deploy_state.py first" >&2
  exit 1
fi

pkill -x anvil 2>/dev/null || true
sleep 1
# --gas-price pins eth_gasPrice to the market (~0.015 gwei); without it Anvil
# echoes the last tx's bid (searchers here bid ~300 gwei) and every scan is
# rejected by the gas ceiling.
nohup anvil --fork-url "$ALCHEMY_BASE_HTTP" --chain-id 8453 --order fifo \
  --gas-limit 400000000 --gas-price 15000000 --max-transactions 4096 \
  --port "$PORT" >/tmp/anvil_bench.log 2>&1 &
for _ in $(seq 1 30); do
  curl -s -X POST "$RPC" -H 'content-type: application/json' \
    --data '{"jsonrpc":"2.0","id":1,"method":"eth_blockNumber","params":[]}' >/dev/null && break
  sleep 1
done

python3 tools/inject_deploy.py "$RPC"

LOG="data/runs/latency_${TAG}.log"
echo "[bench] live logs + latest fork for ${MINUTES}m -> $LOG"
set +e
timeout --kill-after=10s -s TERM "$((MINUTES * 60))" \
  ./target/debug/ryo-watch \
    --http-rpc "$RPC" \
    --ws-rpc "$ALCHEMY_BASE_WS" \
    --manifest "$MANIFEST" \
    --source logs \
    --max-gas-price-gwei 5 \
    watch --metrics-every 50 >/dev/null 2>"$LOG"
set -e
echo "[bench] done; metrics summary:"
grep -E "watch metrics|shutting down" "$LOG" | tail -5
echo "[bench] log: $LOG"
#!/usr/bin/env bash
# One-shot replay-race runner: fresh fork pinned to the episode base, fresh
# deploy, one harness run, result appended to data/race_results.jsonl.
#
#   tools/race_replay.sh <episodes.json> <rank> [lag_max] [execute]
#
# Requires ~/.ryo_env with ALCHEMY_BASE_HTTP and a built
# target/debug/deps/replay_race-* binary.
set -euo pipefail
cd "$(dirname "$0")/.."                    # Watcher/
source "$HOME/.ryo_env"
export PATH="$PATH:$HOME/.foundry/bin:$HOME/.config/.foundry/bin"

EPISODES="${1:?episodes json}"
RANK="${2:-0}"
LAG_MAX="${3:-1}"
EXECUTE="${4:-}"
REUSE="${5:-}"
WARMUP=3
POST="${RYO_POST_BLOCKS:-3}"

BASE=$(python3 - "$EPISODES" "$RANK" "$LAG_MAX" <<'EOF'
import json, sys
eps = json.load(open(sys.argv[1]))
eps = [e for e in eps if e.get("open_tx") and e["peak_bps"] > 0]
if (lag := sys.argv[3]) != "":
    m = int(lag)
    eps = [e for e in eps if e.get("close_lag_blocks") is not None and e["close_lag_blocks"] <= m]
eps.sort(key=lambda e: (e["close_lag_blocks"] if e.get("close_lag_blocks") is not None else 10**9, -e["peak_bps"]))
print(eps[int(sys.argv[2])]["open_block"] - 4)
EOF
)
echo "[race] episode rank $RANK needs fork base block $BASE"

rpc() { curl -s -X POST http://127.0.0.1:8545 -H 'content-type: application/json' --data "{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"$1\",\"params\":$2}"; }

# NOTE: snapshot REUSE is deliberately disabled: evm_revert does not reliably
# restore the block-clock parent, and setNextBlockTimestamp(source_ts) calls
# then silently fail ("not in the future"), mining the whole window ~an hour
# in the future and reverting every deadline-bearing swap. A full restart
# pins the clock to the fork block and makes source timestamps valid.
BASE_TS=$(curl -s -X POST "$ALCHEMY_BASE_HTTP" -H 'content-type: application/json' --data "{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"eth_getBlockByNumber\",\"params\":[\"$(printf '0x%x' $BASE)\",false]}" | python3 -c "import json,sys;print(int(json.load(sys.stdin)['result']['timestamp'],16))")

rpc() { curl -s -X POST http://127.0.0.1:8545 -H 'content-type: application/json' --data "{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"$1\",\"params\":$2}"; }

# With the clock pinned 30 s behind the fork point, snapshot reuse is safe:
# evm_revert restores a head whose ts is still below every replayable
# source block. Guard: reuse only when base matches AND head ts < base ts.
REUSED=0
if [ "$REUSE" = "--reuse" ] && [ -f /tmp/race_snap.txt ] && [ -f /tmp/race_base.txt ] && [ "$(cat /tmp/race_base.txt)" = "$BASE" ]; then
    SNAP=$(cat /tmp/race_snap.txt)
    OK=$(rpc evm_revert "[\"$SNAP\"]" | python3 -c "import json,sys;print(json.load(sys.stdin).get('result'))" 2>/dev/null || echo None)
    HEAD_TS_NOW=$(rpc eth_getBlockByNumber '["latest",false]' | python3 -c "import json,sys;print(int(json.load(sys.stdin)['result']['timestamp'],16))" 2>/dev/null || echo 99999999999)
    if [ "$OK" = "True" ] && [ "$HEAD_TS_NOW" -lt $((BASE_TS-60)) ]; then
        rpc evm_snapshot '[]' | python3 -c "import json,sys;print(json.load(sys.stdin)['result'])" > /tmp/race_snap.txt
        echo "[race] reverted to post-deploy snapshot (head ts $HEAD_TS_NOW < base ts $BASE_TS); warm fork reused"
        REUSED=1
    else
        echo "[race] reuse refused (revert=$OK head_ts=$HEAD_TS_NOW base_ts=$BASE_TS); full restart"
    fi
fi

if [ "$REUSED" = "0" ]; then
echo "[race] base block ts $BASE_TS; pinning anvil clock to $((BASE_TS-300))"
pkill -x anvil 2>/dev/null || true
sleep 1
nohup anvil --fork-url "$ALCHEMY_BASE_HTTP" --fork-block-number "$BASE" --timestamp "$((BASE_TS-300))" --chain-id 8453 --port 8545 >/tmp/anvil_race.log 2>&1 &
for i in $(seq 1 20); do curl -s -X POST http://127.0.0.1:8545 -H 'content-type: application/json' --data '{"jsonrpc":"2.0","id":1,"method":"eth_blockNumber","params":[]}' >/dev/null && break; sleep 1; done

cd ../ryo
PRIVATE_KEY=0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80 \
MAX_GAS_PRICE=3000000000 MAX_TRADE_USDC=8000000000 MAX_TRADE_WETH=4000000000000000000 \
MANIFEST_PATH=../Watcher/deployments/8453.race.json \
  forge script script/Deploy.s.sol:Deploy --rpc-url http://127.0.0.1:8545 --broadcast >/tmp/race_deploy.log 2>&1
cd ../Watcher
echo "$BASE" > /tmp/race_base.txt
rpc evm_snapshot '[]' | python3 -c "import json,sys;print(json.load(sys.stdin)['result'])" > /tmp/race_snap.txt
fi

BIN=$(ls -t target/debug/deps/ | grep '^replay_race-' | grep -v '\.d$' | head -1)
set +e
RYO_FORK_EXECUTE="$EXECUTE" RYO_TRACE_BOOT="${RYO_TRACE_BOOT:-}" \
RYO_FORK_RPC=http://127.0.0.1:8545 RYO_FORK_MANIFEST=deployments/8453.race.json \
RYO_SOURCE_RPC="$ALCHEMY_BASE_HTTP" RYO_EPISODES="$EPISODES" \
RYO_EPISODE_LAG_MAX="$LAG_MAX" RYO_EPISODE_RANK="$RANK" RYO_WARMUP_BLOCKS=$WARMUP \
RYO_POST_BLOCKS="$POST" \
  "./target/debug/deps/$BIN" --ignored --nocapture --test-threads=1 >/tmp/race_run.log 2>&1
RC=$?
set -e
grep -E "READY|verdict|fidelity|panick" /tmp/race_run.log | tail -6
# Persist the JSON summary line (pretty-printed block between the braces)
python3 - <<'EOF'
import json, re
log = open("/tmp/race_run.log").read()
m = re.search(r"^\{\n(?:.*\n)*?\}", log, re.M)
if not m:
    print("[race] no summary JSON in log")
else:
    rec = json.loads(m.group(0))
    with open("data/race_results.jsonl", "a") as fh:
        fh.write(json.dumps(rec) + "\n")
    print("[race] appended:", rec.get("verdict"), "ready_ms:", rec.get("ready_ms"))
EOF
exit $RC

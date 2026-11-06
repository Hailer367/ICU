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
# Warmup must absorb the deploy clock. Measured on anvil 1.9.0 (2026-11-06):
# anvil cannot travel to the PAST — --timestamp on a forked node is clamped to
# the fork block's own timestamp, and BOTH evm_setNextBlockTimestamp and
# anvil_setNextBlockTimestamp reject values <= previous block ts ("lower than
# previous block's timestamp"). Deploy mines D blocks at +1s each, so the local
# clock enters the replay D seconds ahead. Warmup blocks may drift (they only
# prime state and the CL cache); the harness pins EXACT source timestamps from
# the open block and bails if drift survived that long. Drift drains at ~1s
# per warmup block (source advances ~2s/block, a drifted block 1s), so
# warmup >= D - 2 suffices; 60 covers any plausible D.
WARMUP="${RYO_WARMUP_BLOCKS:-60}"
POST="${RYO_POST_BLOCKS:-3}"

BASE_INFO=$(python3 - "$EPISODES" "$RANK" "$LAG_MAX" "$WARMUP" <<'EOF'
import json, sys, subprocess
# Un-replayable opener classes: contracts whose auth binds to real-chain
# block hashes — an impersonated re-signed replay can never reproduce them
# (observed 2026-11-06: CoW GPv2Settlement openers die with
# "GPv2: invalid eip1271 signature" even under perfect clock/number alignment).
SKIP_TO = set(t.lower() for t in (
    "0x9008d19f58aabd9ed0d60971565aa8510560ab41",   # CoW Swap GPv2Settlement
    *(x.strip().lower() for x in __import__("os").environ.get("RYO_SKIP_OPENER_TO", "").split(",")),
) if t and t.strip())
def tx_to(txh):
    p=json.dumps({"jsonrpc":"2.0","id":1,"method":"eth_getTransactionByHash","params":[txh]})
    out=subprocess.run(["curl","-s","-m","20","-X","POST","https://base-rpc.publicnode.com",
                        "-H","content-type: application/json","--data",p],capture_output=True,text=True).stdout
    try: return (json.loads(out).get("result") or {}).get("to","")
    except Exception: return None
eps = json.load(open(sys.argv[1]))
eps = [e for e in eps if e.get("gap_tx") and e["peak_bps"] > 0]
if (lag := sys.argv[3]) != "":
    m = int(lag)
    eps = [e for e in eps if e.get("close_lag_blocks") is not None and e["close_lag_blocks"] <= m]
eps.sort(key=lambda e: (e["close_lag_blocks"] if e.get("close_lag_blocks") is not None else 10**9, -e["peak_bps"]))
want_rank = int(sys.argv[2])
# Walk from the requested rank, skipping un-replayable gap-creating trades.
skipped = []
idx = want_rank
while idx < len(eps):
    e = eps[idx]
    to = tx_to(e["gap_tx"])
    if to and to.lower() in SKIP_TO:
        skipped.append((idx, to))
        idx += 1
        continue
    if skipped:
        print(f"SKIPPED {skipped}", file=sys.stderr)
    print(e["open_block"], idx)
    break
else:
    sys.exit("no replayable episodes remaining")
EOF
)
read -r OPEN_BLOCK_BASE RANK_EFF <<< "$BASE_INFO"
BASE=$((OPEN_BLOCK_BASE - WARMUP - 1))
echo "[race] episode rank $RANK_EFF (requested $RANK), open $OPEN_BLOCK_BASE → base $BASE (warmup $WARMUP)"

rpc() { curl -s -X POST http://127.0.0.1:8545 -H 'content-type: application/json' --data "{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"$1\",\"params\":$2}"; }

# Reuse rule: the post-deploy snapshot may be reused ONLY for an episode whose
# BASE matches AND whose revert lands head exactly on BASE (block numbers must
# stay source-aligned for the harness).
REUSED=0
if [ "$REUSE" = "--reuse" ] && [ -f /tmp/race_snap.txt ] && [ -f /tmp/race_base.txt ] && [ -f /tmp/race_fork.txt ] && [ "$(cat /tmp/race_base.txt)" = "$BASE" ]; then
    SNAP=$(cat /tmp/race_snap.txt)
    OK=$(rpc evm_revert "[\"$SNAP\"]" | python3 -c "import json,sys;print(json.load(sys.stdin).get('result'))" 2>/dev/null || echo None)
    HEAD_NUM=$(rpc eth_blockNumber '[]' | python3 -c "import json,sys;print(int(json.load(sys.stdin)['result'],16))" 2>/dev/null || echo 0)
    if [ "$OK" = "True" ] && [ "$HEAD_NUM" = "$BASE" ]; then
        rpc evm_snapshot '[]' | python3 -c "import json,sys;print(json.load(sys.stdin)['result'])" > /tmp/race_snap.txt
        echo "[race] reverted to post-deploy snapshot (head $HEAD_NUM == base $BASE); warm fork reused"
        REUSED=1
    else
        echo "[race] reuse refused (revert=$OK head=$HEAD_NUM base=$BASE); full restart"
    fi
fi

if [ "$REUSED" = "0" ]; then
# --- Block-NUMBER alignment -------------------------------------------------
# Replayed txs often carry block.number deadlines (Permit2 expirations, V4
# hook windows — observed 2026-11-06: the rank-0 opener reverts with a
# block-number error when local numbers run ahead of source). Deploy consumes
# D local blocks, so we fork D blocks EARLIER: after deploy, local head number
# == source base block, and every replayed block lands on its true source
# number — and, because pre-Denim source blocks are 2s apart while deploy
# blocks step 1s, also behind every source timestamp: exact pins from block 1.
# D is not perfectly deterministic across nodes (observed 15 and 16), so we
# iterate: fork, deploy, measure head vs BASE, adjust the fork point, redo.
D_GUESS="${RYO_DEPLOY_BLOCKS:-16}"
ATTEMPT=0
while :; do
    ATTEMPT=$((ATTEMPT+1))
    FORK_BLOCK=$((BASE - D_GUESS))
    echo "[race] attempt $ATTEMPT: forking at $FORK_BLOCK (D guess $D_GUESS, base $BASE)"
    pkill -x anvil 2>/dev/null || true
    sleep 1
    # --order fifo: replayed txs must execute in SOURCE order inside a block;
    # the default `fees` re-sorts by tip and reorders the world (observed
    # 2026-11-06: the rank-0 opener reverted purely because its blockmates
    # were permuted).
    # --gas-limit 500M + --max-transactions 4096: a whole source block's
    # pool-touching txs (observed up to 117 txs) MUST fit in the single local
    # block we mine for it. Overflow is not just messy — the harness's drain
    # guard mines leftovers as extra +1s blocks, and every extra mine pushes
    # the local clock ahead of source cadence permanently (run 3 died of
    # exactly that: +65s drift by the open block). Size ceilings must make
    # the guard unreachable, not exercise it.
    nohup anvil --fork-url "$ALCHEMY_BASE_HTTP" --fork-block-number "$FORK_BLOCK" --chain-id 8453 --order fifo --gas-limit 500000000 --max-transactions 4096 --port 8545 >/tmp/anvil_race.log 2>&1 &
    for i in $(seq 1 20); do curl -s -X POST http://127.0.0.1:8545 -H 'content-type: application/json' --data '{"jsonrpc":"2.0","id":1,"method":"eth_blockNumber","params":[]}' >/dev/null && break; sleep 1; done
    # forge script estimates EIP-1559 fees via eth_feeHistory; on a fresh fork
    # the request falls through to Alchemy, which errors "invalid block range"
    # for the pre-Cobalt range (foundry-rs/foundry#17950). Mine enough local
    # blocks to serve it; those count toward D and get folded into the next
    # attempt's guess, so alignment survives this hack too.
    PRE_MINES=12
    for i in $(seq 1 $PRE_MINES); do rpc evm_mine '[]' >/dev/null; done

    cd ../ryo
    PRIVATE_KEY=0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80 \
    MAX_GAS_PRICE=3000000000 MAX_TRADE_USDC=8000000000 MAX_TRADE_WETH=4000000000000000000 \
    MANIFEST_PATH=../Watcher/deployments/8453.race.json \
      forge script script/Deploy.s.sol:Deploy --rpc-url http://127.0.0.1:8545 --broadcast >/tmp/race_deploy.log 2>&1
    cd ../Watcher
    HEAD_AFTER=$(rpc eth_blockNumber '[]' | python3 -c "import json,sys;print(int(json.load(sys.stdin)['result'],16))")
    if [ "$HEAD_AFTER" = "$BASE" ]; then
        echo "[race] aligned: head $HEAD_AFTER == base $BASE (fork $FORK_BLOCK + D=$((HEAD_AFTER-FORK_BLOCK)))"
        break
    fi
    if [ "$ATTEMPT" -ge 3 ]; then
        echo "[race] FAILED to converge block-number alignment after $ATTEMPT attempts (head $HEAD_AFTER, want $BASE)"; exit 1
    fi
    D_MEASURED=$((HEAD_AFTER - FORK_BLOCK))
    echo "[race] head $HEAD_AFTER != base $BASE; measured D=$D_MEASURED (guess was $D_GUESS); re-forking"
    D_GUESS=$D_MEASURED
done
echo "$BASE" > /tmp/race_base.txt
echo "$FORK_BLOCK" > /tmp/race_fork.txt
rpc evm_snapshot '[]' | python3 -c "import json,sys;print(json.load(sys.stdin)['result'])" > /tmp/race_snap.txt
fi
FORK_BLOCK=$(cat /tmp/race_fork.txt)

BIN=$(ls -t target/debug/deps/ | grep '^replay_race-' | grep -v '\.d$' | head -1)
set +e
RYO_FORK_EXECUTE="$EXECUTE" RYO_TRACE_BOOT="${RYO_TRACE_BOOT:-}" \
RYO_FORK_RPC=http://127.0.0.1:8545 RYO_FORK_MANIFEST=deployments/8453.race.json \
RYO_FORK_BLOCK="$FORK_BLOCK" \
RYO_SOURCE_RPC="${RYO_SOURCE_RPC:-https://base-rpc.publicnode.com}" RYO_EPISODES="$EPISODES" \
RYO_EPISODE_LAG_MAX="$LAG_MAX" RYO_EPISODE_RANK="$RANK_EFF" RYO_WARMUP_BLOCKS=$WARMUP \
RYO_EXPECT_OPEN_BLOCK="$OPEN_BLOCK_BASE" \
RYO_POST_BLOCKS="$POST" \
  "./target/debug/deps/$BIN" --ignored --nocapture --test-threads=1 >/tmp/race_run.log 2>&1
RC=$?
set -e
# Preserve this run's evidence (run 3's log was overwritten by a rerun before
# diagnosis — never again): rotate logs per attempt under data/runs/.
RUNTAG="$(basename "$EPISODES" .json)_rank${RANK}_$(date -u +%Y%m%dT%H%M%SZ)"
mkdir -p data/runs
cp /tmp/race_run.log "data/runs/${RUNTAG}_harness.log" 2>/dev/null || true
cp /tmp/race_deploy.log "data/runs/${RUNTAG}_deploy.log" 2>/dev/null || true
cp /tmp/anvil_race.log "data/runs/${RUNTAG}_anvil.log" 2>/dev/null || true
echo "[race] logs saved: data/runs/${RUNTAG}_*"
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

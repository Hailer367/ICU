#!/usr/bin/env bash
# Post-Denim (2026-11-05 18:00 UTC) re-measurement: verify the cutover landed,
# harvest a fresh window under canonical 200ms blocks, rebuild Record A, and
# print the win-rate curve under the new timing regime. Uses PUBLIC endpoints
# for everything so it never contends with the Alchemy key the replay fork
# needs. Run after ~18:10 UTC:
#
#   tools/denim_cutover.sh [blocks]   # default 18000 blocks = 1h at 200ms
set -euo pipefail
cd "$(dirname "$0")/.."
BLOCKS="${1:-18000}"
PUB=https://base-rpc.publicnode.com

head_ts() {
    curl -s -X POST "$PUB" -H 'content-type: application/json' --data \
      '{"jsonrpc":"2.0","id":1,"method":"eth_getBlockByNumber","params":["latest",false]}' |
    python3 -c "import json,sys; b=json.load(sys.stdin)['result']; print(int(b['number'],16), int(b['timestamp'],16))"
}
read -r N1 T1 <<< "$(head_ts)"; sleep 4; read -r N2 T2 <<< "$(head_ts)"
DT=$((T2-T1)); DN=$((N2-N1))
echo "head $N1 -> $N2 in $DT s wall ($DN blocks): $(( (DN==0 ? 0 : DT*1000/DN) )) ms/block"
if [ "$DN" -gt 0 ] && [ $(( 1000*DT/DN )) -gt 1000 ]; then
    echo "[cutover] still ~2s blocks — Denim has NOT activated yet; run this later"
    exit 1
fi

./target/debug/ryo-watch --http-rpc "$PUB" history --blocks "$BLOCKS" --chunk 500 \
    --out data/swaps_post_denim.jsonl

for BPS in 2 60 200; do
    python3 tools/gap_autopsy.py data/swaps_post_denim.jsonl "data/gap_autopsy_denim_${BPS}bps.md" "$BPS" >/dev/null
    python3 tools/winrate_curve.py "data/gap_autopsy_denim_${BPS}bps.json" \
        --period 0.2 --lead 0 100 200 400 800 \
        | tee "data/winrate_denim_${BPS}bps.md"
done
echo "[cutover] done: Record A rebuilt for canonical 200ms blocks"

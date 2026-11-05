#!/usr/bin/env python3
"""Record B vs Record A win-rate curve (§0w Phase 3).

Reads a gap-autopsy episode JSON plus one or more measured ready times
(`--ready-ms`) and reports, per reaction speed, the share of contested
episodes our pipeline would have closed first.

Deadline model (pre-Denim, 2 s blocks):
  * close_lag_blocks == 0 (won inside the opening block): catchable only
    with a preconfirmation lead (`--lead-ms`, default 1200 = measured
    pendingLogs advantage); winnable iff ready_ms <= lead.
  * close_lag_blocks >= 1: the gap stayed open through at least one full
    block; winnable iff ready_ms <= block_seconds*1000*lag (the winner's
    earliest landing window), by construction ready during block N+1 lands
    before the winner's block N+1 only if strictly faster; we conservatively
    use ready_ms <= lag*period.
  * never closed in the harvested window: winnable at any ready_ms.

Post-Denim data (200 ms blocks) needs no code change: pass --period 0.2 and
--lead 0 (pendingLogs is gone); lags in that data are already in 200 ms
blocks.
"""
import json
import sys


def winnable(eps, ready_ms, period_s, lead_ms):
    wins = total = 0
    for e in eps:
        lag = e.get("close_lag_blocks")
        if not e.get("open_tx"):
            continue
        total += 1
        if lag is None:
            win = True
        elif lag == 0:
            win = ready_ms <= lead_ms
        else:
            win = ready_ms <= lag * period_s * 1000.0
        wins += win
    return wins, total


def main():
    path = sys.argv[1] if len(sys.argv) > 1 else "data/gap_autopsy_24h_60bps.json"
    eps = json.load(open(path))
    period = 2.0
    lead = 1200
    restys = []
    args = sys.argv[2:]
    i = 0
    while i < len(args):
        if args[i] == "--period":
            period = float(args[i + 1]); i += 2
        elif args[i] == "--lead":
            lead = float(args[i + 1]); i += 2
        else:
            restys.append(float(args[i])); i += 1
    if not restys:
        restys = [50, 100, 150, 200, 300, 500, 1000, 1500, 2000]
    contested = [e for e in eps if e.get("close_lag_blocks") is not None and e["close_lag_blocks"] <= 1]
    print(f"# win-rate curve — {path} (period {period}s, preconf lead {lead:.0f}ms)")
    print("| ready_ms | all episodes | contested (lag<=1) |")
    print("|---|---|---|")
    for t in restys:
        wa, ta = winnable(eps, t, period, lead)
        wc, tc = winnable(contested, t, period, lead)
        pa = 100 * wa // ta if ta else 0
        pc = 100 * wc // tc if tc else 0
        print(f"| {t:.0f} | {wa}/{ta} ({pa}%) | {wc}/{tc} ({pc}%) |")
    print(f"\ncontested cohort size: {len(contested)} episodes")


if __name__ == "__main__":
    main()

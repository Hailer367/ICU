#!/usr/bin/env python3
"""Gap autopsy (§0w Phase 2): reconstruct pool prices from recorded swap
events, detect cross-venue gaps, and measure who closed them and how fast.

Input: JSONL from `ryo-watch history` (one swap event per line).
Output: a markdown report + a JSON record of every gap episode.

Method
  * Each CL pool's price is constant between its own swap events, and every
    event carries the post-swap state (sqrtPriceX96, liquidity, tick) — the
    full price history needs no RPC.
  * price(pool, block) = (sqrt/2^96)^2 * 10^(dec0-dec1) = token1-per-token0.
  * Round trip base->quote on pool i, quote->base on pool j is profitable
    when P_j * (1 - f_j) > P_i * (1 + f_i). The excess is the gap.
  * Episodes are detected on block granularity (last event per block);
    within a block, log_index order shows whether a counter-pool trade
    followed the gap-opening trade in the same block (a searcher close).

Fee notes: UniV3/Pancake tiers are static. Slipstream fees are dynamic;
defaults use §0p's measured values (ts1 0.8bps, ts10/50 5bps, ts100 8.33,
ts200 assumed 8.33 — approximate and flagged).
"""
import bisect
import json
import sys
from collections import defaultdict

Q96 = 2 ** 96

# pool address -> (pair, venue, fee_bps, decimals0, decimals1)
# token0/token1 order per routes.rs Registry::base_curated (verified 2026-11-04).
REGISTRY = {
    "0xb4cb800910b228ed3d0834cf79d697127bbb00e5": ("WETH/USDC", "univ3:100", 1.0, 18, 6),
    "0xd0b53d9277642d899df5c87a3966a349a798f224": ("WETH/USDC", "univ3:500", 5.0, 18, 6),
    "0x6c561b446416e1a00e8e93e221854d6ea4171372": ("WETH/USDC", "univ3:3000", 30.0, 18, 6),
    "0x0b1c2dcbbfa744ebd3fc17ff1a96a1e1eb4b2d69": ("WETH/USDC", "univ3:10000", 100.0, 18, 6),
    "0xdbc6998296caa1652a810dc8d3baf4a8294330f1": ("WETH/USDC", "slipstream:1", 0.8, 18, 6),
    "0xb150768cf55d1625e2337a08fbd1b0f02ff94bdb": ("WETH/USDC", "slipstream:10", 5.0, 18, 6),
    "0xaad23a67f2ac693abbe543489aeb3f24f561d517": ("WETH/USDC", "slipstream:50", 5.0, 18, 6),
    "0xb2cc224c1c9fee385f8ad6a55b4d94e92359dc59": ("WETH/USDC", "slipstream:100", 8.33, 18, 6),
    "0x148bc43946a902258916e580b0e6d92aaa74746f": ("WETH/USDC", "slipstream:200", 8.33, 18, 6),
    "0x72ab388e2e2f6facef59e3c3fa2c4e29011c2d38": ("WETH/USDC", "pancake:100", 1.0, 18, 6),
    "0xb775272e537cc670c65dc852908ad47015244eaf": ("WETH/USDC", "pancake:500", 5.0, 18, 6),
    "0xe9d76696f8a35e2e2520e3125875c3af23f1e69c": ("WETH/USDC", "pancake:2500", 25.0, 18, 6),
    "0x118efef7db0712f03e067122b8f89e7a4b79262f": ("WETH/USDC", "pancake:10000", 100.0, 18, 6),
    "0xfbb6eed8e7aa03b138556eedaf5d271a5e1e43ef": ("USDC/cbBTC", "univ3:500", 5.0, 6, 8),
    "0xec558e484cc9f2210714e345298fdc53b253c27d": ("USDC/cbBTC", "univ3:3000", 30.0, 6, 8),
    "0xb94b22332abf5f89877a14cc88f2abc48c34b3df": ("USDC/cbBTC", "pancake:100", 1.0, 6, 8),
    "0x26e263efdc91f0d3279e2ec2bd58a7ca5c2fce62": ("USDC/cbBTC", "pancake:500", 5.0, 6, 8),
    "0x748bb91fc5f4200302d9a79185bc161260a1b461": ("USDC/cbBTC", "pancake:2500", 25.0, 6, 8),
    "0x4e962bb3889bf030368f56810a9c96b83cb3e778": ("USDC/cbBTC", "slipstream:100", 8.33, 6, 8),
    "0x7aea2e8a3843516afa07293a10ac8e49906dabd1": ("WETH/cbBTC", "univ3:500", 5.0, 18, 8),
    "0x8c7080564b5a792a33ef2fd473fba6364d5495e5": ("WETH/cbBTC", "univ3:3000", 30.0, 18, 8),
    "0x233571eae953d9d59eefc0769f71dc19287ddccb": ("WETH/cbBTC", "univ3:10000", 100.0, 18, 8),
    "0xc211e1f853a898bd1302385ccde55f33a8c4b3f3": ("WETH/cbBTC", "pancake:100", 1.0, 18, 8),
    "0xd974d59e30054cf1abeded0c9947b0d8baf90029": ("WETH/cbBTC", "pancake:500", 5.0, 18, 8),
    "0x5b3613ef9a535b48e82e2800acb77053dfec93b1": ("WETH/cbBTC", "pancake:2500", 25.0, 18, 8),
    "0x70acdf2ad0bf2402c957154f944c19ef4e1cbae1": ("WETH/cbBTC", "slipstream:100", 8.33, 18, 8),
    "0x7279c08a36333e12c3fc81747963264c100d66fb": ("EURC/USDC", "univ3:500", 5.0, 6, 6),
    "0x1ca42c7219f0cb1b67927e26502320cb98f725bd": ("EURC/USDC", "pancake:100", 1.0, 6, 6),
    "0xb4a43d89b5d356065646389fd677ca762efcd780": ("WETH/EURC", "pancake:500", 5.0, 18, 6),
}


def load(jsonl_path):
    events = []
    with open(jsonl_path) as fh:
        for line in fh:
            r = json.loads(line)
            pool = r["pool"].lower()
            if pool not in REGISTRY:
                continue  # constant-product pools: no sqrt state here
            if r.get("sqrt_price_x96") is None:
                continue
            events.append(r)
    events.sort(key=lambda r: (r["block"], r["log_index"]))
    return events


def price(r):
    sqrt = int(r["sqrt_price_x96"])
    _, _, _, d0, d1 = REGISTRY[r["pool"].lower()]
    return (sqrt / Q96) ** 2 * (10 ** (d0 - d1))


def analyze(events, gap_bps=5.0):
    # Event-wise state machine (rewritten 2026-11-06). The old block-wise
    # detector recorded open_tx = the last event of the STALE pool — which
    # can predate the gap by a thousand blocks and is NOT the trade that
    # opens anything. The gap is created by the event that pushes a direction
    # over the line; the replay must key on that trade (gap_tx): the trigger
    # the watcher would react to, the transaction whose fidelity matters,
    # and the position the winner beat. Peak/last are tracked continuously
    # per open run.
    by_pair = defaultdict(list)
    for r in events:
        pool = r["pool"].lower()
        p = price(r)
        if not (0.001 < p < 1e9):
            continue
        by_pair[REGISTRY[pool][0]].append((r, pool, p))

    episodes = []
    for pair, rows in by_pair.items():
        pools = sorted({pool for _, pool, _ in rows})
        fee = {p: REGISTRY[p][2] / 10_000.0 for p in pools}
        last = {p: None for p in pools}
        last_event = {p: None for p in pools}
        # open runs per direction (i = stale/buy side, j = sell side)
        runs = {}
        def edges_after(pool):
            """directions whose edge can move when `pool` traded"""
            out = []
            for j in pools:
                if j != pool:
                    out.append((pool, j))   # pool went stale-cheap
            for i in pools:
                if i != pool:
                    out.append((i, pool))   # pool rose to expensive
            return out
        for r, pool, p in rows:
            last[pool] = p
            last_event[pool] = r
            if any(v is None for v in last.values()):
                continue
            for (i, j) in edges_after(pool):
                edge = (last[j] * (1 - fee[j])) / (last[i] * (1 + fee[i])) - 1
                ebps = edge * 10_000
                above = ebps >= gap_bps
                run = runs.get((i, j))
                if above and run is None:
                    ev = last_event[i] or {}
                    runs[(i, j)] = dict(
                        pair=pair,
                        buy_pool=REGISTRY[i][1] + "/" + i[:8],
                        sell_pool=REGISTRY[j][1] + "/" + j[:8],
                        open_block=r["block"],
                        edge_bps=round(ebps, 2),
                        open_tx=ev.get("tx_hash"),
                        open_log=ev.get("log_index"),
                        open_pool=i,
                        gap_tx=r["tx_hash"],
                        gap_log=r["log_index"],
                        gap_pool=pool,
                        last_block=r["block"],
                    )
                elif above:
                    run["peak_bps_row"] = max(
                        run.get("peak_bps_row", run["edge_bps"]), ebps)
                    run["last_block"] = r["block"]
                elif run is not None:
                    run["peak_bps"] = max(run["edge_bps"],
                                          run.get("peak_bps_row", 0.0))
                    episodes.append(run)
                    runs[(i, j)] = None
        for key, run in runs.items():
            if run:
                run["peak_bps"] = max(run["edge_bps"],
                                      run.get("peak_bps_row", 0.0))
                episodes.append(run)
    # merge consecutive-block episodes for the same direction
    merged = []
    by_dir = defaultdict(list)
    for e in episodes:
        e = dict(e)
        e.pop("peak_bps_row", None)
        by_dir[(e["pair"], e["buy_pool"], e["sell_pool"])].append(e)
    for (pair, bi, sj), rows in by_dir.items():
        rows.sort(key=lambda r: r["open_block"])
        cur = None
        for r in rows:
            if cur and r["open_block"] - cur["last_block"] <= 1:
                cur["last_block"] = r["open_block"]
                cur["peak_bps"] = max(cur["peak_bps"], r["peak_bps"])
            else:
                if cur:
                    merged.append(cur)
                cur = dict(pair=pair, buy=bi, sell=sj,
                           open_block=r["open_block"],
                           last_block=r["open_block"],
                           peak_bps=r["peak_bps"],
                           open_tx=r.get("open_tx"), open_log=r.get("open_log"),
                           open_pool=r.get("open_pool"),
                           gap_tx=r.get("gap_tx"), gap_log=r.get("gap_log"),
                           gap_pool=r.get("gap_pool"))
        if cur:
            merged.append(cur)
    for e in merged:
        e.setdefault("edge_bps", e.get("peak_bps"))
    return merged, events


def closers(events, episodes):
    """For each episode: did a trade on the SELL pool occur within the
    opening block, after the opening event's log position? Who did it?

    Records, as the Record A close-time proxy:
      * `close_lag_blocks`: blocks from open until the first counter-pool
        trade (0 = same block, None = never closed in window);
      * `close_pos_gap`: for same-block closes, the log-index distance
        between the opening event and the closing event within the block
        (queue-position proxy — sub-block wall time is unobservable in
        mined history, but ordering is);
      * `close_tx`/`close_log`: the FIRST closing trade, i.e. the bot that
        actually won the race (not the last one in the block).
    """
    out = []
    idx_by_pool = defaultdict(list)
    for r in events:
        idx_by_pool[r["pool"].lower()].append(r)
    # events arrive sorted by (block, log_index); keep the key arrays for bisect
    keys_by_pool = {
        p: [(r["block"], r["log_index"]) for r in evs] for p, evs in idx_by_pool.items()
    }
    for e in episodes:
        sell_addr = e["sell"].split("/")[1]
        full = [p for p in idx_by_pool if p.startswith(sell_addr)]
        closed_same_block = None
        closer = None
        close_lag_blocks = None
        close_pos_gap = None
        close_tx = None
        close_log = None
        if full:
            pool_key = full[0]
            pool_ev = idx_by_pool[pool_key]
            # first counter-pool trade strictly after the GAP-CREATING event
            # (2026-11-06: was keyed on open_log — the stale pool's last
            # trade, which can predate the block and is not the race start)
            race_start = e.get("gap_log")
            if race_start is None:
                race_start = e["open_log"] if e["open_log"] is not None else -1
            closed_same_block = None
            closer = None
            close_lag_blocks = None
            close_pos_gap = None
            close_tx = None
            close_log = None
            start = bisect.bisect_right(
                keys_by_pool[pool_key], (e["open_block"], race_start),
            )
            if start < len(pool_ev):
                first = pool_ev[start]
                close_lag_blocks = first["block"] - e["open_block"]
                closer = first["recipient"] or first["sender"]
                close_tx = first.get("tx_hash")
                close_log = first["log_index"]
                closed_same_block = first["block"] == e["open_block"]
                if closed_same_block:
                    close_pos_gap = first["log_index"] - race_start
        out.append(
            dict(
                e,
                closed_same_block=closed_same_block,
                closer=closer,
                close_lag_blocks=close_lag_blocks,
                close_pos_gap=close_pos_gap,
                close_tx=close_tx,
                close_log=close_log,
            )
        )
    return out


def _percentile(sorted_vals, q):
    if not sorted_vals:
        return None
    i = min(len(sorted_vals) - 1, int(q * len(sorted_vals)))
    return sorted_vals[i]


def report(episodes, ts_min, ts_max, gap_bps):
    from statistics import median

    lifetimes = [e["last_block"] - e["open_block"] + 1 for e in episodes]
    same_block = sum(1 for e in episodes if e["closed_same_block"])
    closed = [e for e in episodes if e["close_lag_blocks"] is not None]
    lags = sorted(e["close_lag_blocks"] for e in closed)
    lag_hist = defaultdict(int)
    for L in lags:
        lag_hist[0 if L == 0 else 1 if L == 1 else 2 if L == 2 else 3 if L <= 5 else 4] += 1
    pos_gaps = sorted(
        e["close_pos_gap"] for e in closed if e.get("close_pos_gap") is not None
    )
    never = len(episodes) - len(closed)
    top_edges = sorted(episodes, key=lambda e: -e["peak_bps"])[:12]
    by_closer = defaultdict(int)
    for e in episodes:
        if e["closer"]:
            by_closer[e["closer"]] += 1
    lines = [
        f"# Gap autopsy — {gap_bps} bps threshold",
        "",
        f"- episodes >= {gap_bps} bps: **{len(episodes)}**",
        f"- closed by a counter-pool trade (first one wins the race): "
        f"**{len(closed)}**, never in window: **{never}**",
        f"- closed in the SAME block it opened: **{same_block} "
        f"({100*same_block//max(1,len(episodes))}%)**",
        f"- median lifetime (blocks): **{median(lifetimes) if lifetimes else 0}**; "
        f"p90: **{_percentile(sorted(lifetimes), 0.9)}**"
        if lifetimes
        else "- no episodes",
        f"- window: blocks ts {ts_min}..{ts_max}",
        "",
        "## Record A — close-lag distribution (blocks from open to first counter-trade)",
        "| lag | count | share |",
        "|---|---|---|",
    ]
    labels = {0: "0 (same block)", 1: "1", 2: "2", 3: "3-5", 4: "6+"}
    for k in (0, 1, 2, 3, 4):
        n = lag_hist.get(k, 0)
        lines.append(f"| {labels[k]} | {n} | {100*n//max(1,len(lags))}% |")
    lines += [
        "",
        f"- same-block close POSITION gap (log indexes between opener and winner): "
        f"median **{_percentile(pos_gaps, 0.5)}**, p90 **{_percentile(pos_gaps, 0.9)}** "
        f"over {len(pos_gaps)} same-block closes",
        "",
        "## Largest gap episodes",
        "| pair | buy at | sell at | open block | peak bps | lag | pos gap | closer |",
        "|---|---|---|---|---|---|---|---|",
    ]
    for e in top_edges:
        lines.append(
            f"| {e['pair']} | {e['buy']} | {e['sell']} | {e['open_block']} | "
            f"{e['peak_bps']} | {e['close_lag_blocks']} | {e.get('close_pos_gap')} | "
            f"{str(e['closer'])[:14]} |"
        )
    lines += ["", "## Most frequent closers", ""]
    for addr, n in sorted(by_closer.items(), key=lambda kv: -kv[1])[:10]:
        lines.append(f"- `{addr}` closed {n} episodes")
    return "\n".join(lines)


def main():
    path = sys.argv[1] if len(sys.argv) > 1 else "data/swaps_24h.jsonl"
    out_md = sys.argv[2] if len(sys.argv) > 2 else "data/gap_autopsy.md"
    gap_bps = float(sys.argv[3]) if len(sys.argv) > 3 else 5.0
    events = load(path)
    if not events:
        print("no CL events in file")
        return
    ts = [r["timestamp"] for r in events if r.get("timestamp")]
    episodes, _ = analyze(events, gap_bps)
    episodes = closers(events, episodes)
    text = report(episodes, min(ts), max(ts), gap_bps)
    print(text)
    with open(out_md, "w") as fh:
        fh.write(text + "\n")
    with open(out_md.replace(".md", ".json"), "w") as fh:
        json.dump(episodes, fh)


if __name__ == "__main__":
    main()

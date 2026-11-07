#!/usr/bin/env python3
"""Capture a Ryo deployment as injectable state for the replay harness.

`tools/race_replay.sh` no longer deploys into the replay fork: a `forge
script` broadcast mines D local blocks, and forking D blocks earlier keeps
block *numbers* aligned only by discarding D source blocks of pool state.
Instead the harness forks exactly at the episode base and injects the
already-built core + adapters with `anvil_setCode` / `anvil_setStorageAt`.

This tool produces `data/race_deploy_state.json` (git-ignored) once:

  1. start a throwaway anvil forked at the latest Base block,
  2. deploy core + 5 adapters with the normal script,
  3. read each contract's runtime code and the core's storage,
  4. write the state file (addresses + code + nonzero storage slots).

The deployment is block-independent, so the same file works for every
episode. Regenerate only after changing Solidity or the deploy parameters.

Usage:
    python3 tools/capture_deploy_state.py [--fork-block N] [--rpc URL]

Defaults: latest block, publicnode (the Alchemy key is reserved for replay
forks; the deploy needs only a handful of latest-state reads).
"""
import argparse
import json
import os
import pathlib
import subprocess
import sys
import time
import urllib.request

WATCHER = pathlib.Path(__file__).resolve().parent.parent
RPC_PORT = 8546
RPC = f"http://127.0.0.1:{RPC_PORT}"
PRIVATE_KEY = "0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80"
IS_ADAPTER_SLOT = 4
MAX_TRADE_SIZE_SLOT = 5
SCALAR_SLOTS = range(8)  # owner, pendingOwner, operator, profitRecipient, paused, ..., maxGasPrice


def rpc(method, params):
    body = json.dumps({"jsonrpc": "2.0", "id": 1, "method": method, "params": params}).encode()
    req = urllib.request.Request(RPC, data=body, headers={"content-type": "application/json"})
    with urllib.request.urlopen(req, timeout=30) as response:
        payload = json.loads(response.read())
    if "error" in payload:
        raise SystemExit(f"{method} failed: {payload['error']}")
    return payload["result"]


def hex_u64(value):
    return int(value, 16) if isinstance(value, str) else int(value)


def cast(*args):
    result = subprocess.run(
        ["cast", *args, "--rpc-url", RPC], capture_output=True, text=True
    )
    if result.returncode:
        raise SystemExit(f"cast {' '.join(args)} failed: {result.stderr}")
    return result.stdout.strip()


def wait_ready():
    for _ in range(40):
        try:
            rpc("eth_blockNumber", [])
            return
        except Exception:
            time.sleep(0.5)
    raise SystemExit("throwaway anvil did not become ready")


def capture(manifest):
    core = manifest["core"]
    adapters = manifest["adapters"]
    tokens = manifest["tokens"]
    state = {
        "core": core,
        "core_code": cast("code", core),
        "adapters": {name: {"address": address, "code": cast("code", address)}
                     for name, address in adapters.items()},
        "core_storage": {},
        "manifest": manifest,
    }
    # Scalar slots: inject every slot that is not zero. Which variable lives in
    # which slot is the compiler's business; copying the raw word preserves
    # packed fields (profitRecipient + paused share slot 3).
    for slot in SCALAR_SLOTS:
        value = cast("storage", core, str(slot))
        if int(value, 16):
            state["core_storage"][hex(slot)] = value
    # Mapping entries: discover the bases from the contract's own getters so a
    # layout change cannot silently produce an empty whitelist or zero caps.
    for name, address in adapters.items():
        expected = cast("call", core, "isAdapter(address)(bool)", address)
        if expected.lower() != "true":
            raise SystemExit(f"isAdapter({name}) is {expected}; deploy did not whitelist it")
        for base in range(12):
            slot = cast("index", "address", address, str(base))
            value = cast("storage", core, slot)
            if int(value, 16) == 1:
                state["core_storage"][slot] = value
                break
        else:
            raise SystemExit(f"could not locate isAdapter slot for {name}")
    for symbol in ("WETH", "USDC"):
        expected = int(cast("call", core, "maxTradeSize(address)(uint256)", tokens[symbol]).split()[0])
        if expected == 0:
            raise SystemExit(f"maxTradeSize({symbol}) is zero; pass caps to the deploy")
        for base in range(12):
            slot = cast("index", "address", tokens[symbol], str(base))
            value = cast("storage", core, slot)
            if int(value, 16) == expected:
                state["core_storage"][slot] = value
                break
        else:
            raise SystemExit(f"could not locate maxTradeSize slot for {symbol}")
    return state


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("--fork-block", type=int, default=None,
                        help="block to fork (default: latest)")
    parser.add_argument("--rpc", default=os.environ.get(
        "RYO_DEPLOY_RPC", "https://base-rpc.publicnode.com"),
        help="upstream RPC for the throwaway fork")
    args = parser.parse_args()

    env = os.environ.copy()
    env["PATH"] = env.get("PATH", "") + ":" + os.path.expanduser("~/.config/.foundry/bin")
    ryo = WATCHER.parent / "ryo"
    tmp_manifest = "/tmp/ryo_race_manifest.json"
    if os.path.exists(tmp_manifest):
        os.remove(tmp_manifest)

    cmd = ["anvil", "--fork-url", args.rpc, "--chain-id", "8453", "--order", "fifo",
           "--gas-limit", "400000000", "--max-transactions", "4096",
           "--port", str(RPC_PORT)]
    if args.fork_block is not None:
        cmd += ["--fork-block-number", str(args.fork_block)]
    anvil = subprocess.Popen(cmd, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL, env=env)
    try:
        wait_ready()
        deploy_env = env.copy()
        deploy_env.update(
            PRIVATE_KEY=PRIVATE_KEY,
            MAX_GAS_PRICE="3000000000",
            MAX_TRADE_USDC="8000000000",
            MAX_TRADE_WETH="4000000000000000000",
            MANIFEST_PATH=tmp_manifest,
        )
        subprocess.run(
            ["forge", "script", "script/Deploy.s.sol:Deploy", "--rpc-url", RPC, "--broadcast"],
            cwd=ryo, env=deploy_env, check=True,
            stdout=subprocess.DEVNULL, stderr=subprocess.STDOUT,
        )
        manifest = json.load(open(tmp_manifest))
        state = capture(manifest)
        out = WATCHER / "data" / "race_deploy_state.json"
        out.parent.mkdir(parents=True, exist_ok=True)
        json.dump(state, open(out, "w"), indent=1)
        print(f"wrote {out}: core {state['core']}, "
              f"{len(state['core_storage'])} storage slots, "
              f"{len(state['adapters'])} adapters")
    finally:
        anvil.terminate()
        try:
            anvil.wait(timeout=10)
        except subprocess.TimeoutExpired:
            anvil.kill()


if __name__ == "__main__":
    main()
#!/usr/bin/env python3
"""Inject the captured Ryo deployment into a running anvil fork.

Reads `data/race_deploy_state.json` (see tools/capture_deploy_state.py) and
applies the six contracts' runtime code plus the core's nonzero storage with
`anvil_setCode` / `anvil_setStorageAt`, then funds owner/operator/recipient.
No block is mined, so the fork stays exactly at its base block — this is what
keeps replay block numbers and source state aligned.
"""
import json
import pathlib
import subprocess
import sys

WATCHER = pathlib.Path(__file__).resolve().parent.parent
STATE = WATCHER / "data" / "race_deploy_state.json"
RPC = sys.argv[1] if len(sys.argv) > 1 else "http://127.0.0.1:8545"
FUND_WEI = "0x21e19e0c9bab2400000"  # 10,000 ETH


def cast(*args):
    result = subprocess.run(
        ["cast", *args, "--rpc-url", RPC], capture_output=True, text=True
    )
    if result.returncode:
        raise SystemExit(f"cast {' '.join(args)} failed: {result.stderr}")
    return result.stdout.strip()


def main():
    state = json.load(open(STATE))
    core = state["core"]
    cast("rpc", "anvil_setCode", core, state["core_code"])
    for adapter in state["adapters"].values():
        cast("rpc", "anvil_setCode", adapter["address"], adapter["code"])
    for slot, value in state["core_storage"].items():
        cast("rpc", "anvil_setStorageAt", core, slot, value)
    manifest = state["manifest"]
    for role in {manifest["owner"], manifest["operator"], manifest["profitRecipient"]}:
        cast("rpc", "anvil_setBalance", role, FUND_WEI)
    print(
        "[inject] core", core,
        "paused", cast("call", core, "paused()(bool)"),
        "maxGas", cast("call", core, "maxGasPrice()(uint256)"),
        "wethCap", cast("call", core, "maxTradeSize(address)(uint256)",
                        manifest["tokens"]["WETH"]),
    )


if __name__ == "__main__":
    main()
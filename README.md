# ICU — Decompiled App Sources

Decompiled source code of two Android apps, extracted with **JADX 1.5.0**.

## Contents

| Folder | Package | APK |
|--------|---------|-----|
| `decompiled/com.icaremc.doctors/` | `com.icaremc.doctors` | `app-release.apk` |
| `decompiled/com.icaremc.app/` | `com.icaremc.app` | `app-release (2).apk` |

Each folder contains:
- `sources/` — decompiled Java source code
- `resources/` — extracted resources (including `AndroidManifest.xml`)

## Notes

- These are **release** builds, so the code is **obfuscated** (single-letter
  class/method names via R8/ProGuard). This is expected and cannot be fully
  reversed; JADX recovers structure and logic but not original names.
- A small number of methods may show as decompilation errors — JADX falls back
  to raw smali/comments for those. This is normal for large release APKs.

## Tooling

Extracted with [JADX](https://github.com/skylot/jadx):

```bash
jadx -d ./decompiled/com.icaremc.doctors app-release.apk
jadx -d ./decompiled/com.icaremc.app "app-release (2).apk"
```

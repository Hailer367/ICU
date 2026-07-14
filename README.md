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

## Architecture documentation

Detailed, reverse-engineered architecture write-ups (generated from static
analysis of the release APKs — the bundled `.env`, `AndroidManifest.xml`, and
Dart AOT metadata/strings inside `libapp.so`) are provided as PDFs in the repo
root:

| PDF | Focus |
|-----|-------|
| `iCareMC_API_Architecture.pdf` | How the API is configured and used — Supabase (REST/Auth/Realtime/Storage/Edge), the `.env` contract, auth & token flow, Chapa payments, SMS/push micro-APIs, FCM, request headers & security. |
| `iCareMC_Backend_Architecture.pdf` | Server side — shared Supabase project, the PostgreSQL data model & tables, Row-Level Security, Edge/serverless responsibilities, companion backends, and end-to-end domain workflows. |
| `iCareMC_UI_Architecture.pdf` | Flutter presentation layer — GetX (bindings/controllers/views), navigation & routes, the tab shell, per-app module maps, reusable widgets, theming, and trilingual localisation. |

Both apps are **Flutter** apps sharing one Supabase backend
(`bjripaytpikgjvroypru.supabase.co`). Because business logic is AOT-compiled
into `libapp.so`, the documents are derived from recoverable Dart library URIs,
class names and string literals rather than the obfuscated Java layer.

The PDFs are built by the scripts under `docs/build/` (Python + ReportLab):

```bash
pip install reportlab
cd docs/build
python3 gen_api.py && python3 gen_backend.py && python3 gen_ui.py
```

> Security note: the patient app ships a Supabase **service-role** key in its
> bundled `.env`. This bypasses Row-Level Security and should be rotated and
> removed from any client build. See the API PDF, §10.

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

# APK Analysis Report: Mark43_OnScene_2024.06.0

**Date:** 2026-02-20  
**APK:** `Mark43_OnScene_2024.06.0-39.1_APKPure.apk`  
**Package:** `com.mark43.android/scanner`

---

## Summary

- **File Size:** 119 MB  
- **Decompilation:** Successful (341 parsing errors — normal for large builds)
- **Analysis Tool:** jadx dev

---

## External Services Found

### Firebase (Google)
- Firebase Installations (Installation ID + auth token)
- Required config: API Key, App ID, Project ID
- Deprecation warnings: KTX migration required

### Pendo (Analytics)
- Endpoints: `https://us1.data.pendo.io`, `https://data.pendo.io`, `https://data.jpn.pendo.io`, `https://data.eu.pendo.io`
- Purpose: Product analytics/telemetry

### YouTube
- `https://www.youtube.com` — Video player integration

---

## API Endpoints

| Service | Endpoint | Purpose |
|---------|----------|---------|
| Pendo Analytics | `https://us1.data.pendo.io` | US data collection |
| Pendo Analytics | `https://data.pendo.io` | Global fallback |
| Pendo Analytics | `https://data.jpn.pendo.io` | Japan region |
| Pendo Analytics | `https://data.eu.pendo.io` | EU region |

---

## Suspicious Patterns

| Pattern | Location | Status |
|---------|----------|--------|
| Hardcoded secrets (API keys, tokens, passwords) | None | ✅ Clean |
| Insecure storage (SharedPreferences, plaintext) | Scanned | — |
| WebView JS interface usage | Scanned | — |
| Certificate validation bypass | Scanned | — |

---

## Tech Stack

- Mark43 OnScene (public safety dispatch)
- Firebase (Analytics, Installations)
- Pendo (Product analytics)
- YouTube integration
- OkHttp (HTTP client)
- RxJava (ReactiveX)
- Android Media3 (ExoPlayer)

---

## Recommendations

1. **Pendo API Key** — Verify not exposed in client config
2. **Network Security Config** — Check for cleartext HTTP allowed
3. **Permissions** — Review `AndroidManifest.xml` for over-permissive declarations
4. **Proguard/R8** — Build appears obfuscated — ensure sensitive logic is protected

---

## Full Extracted Sources

Location: `/projects/apks/Mark43_OnScene_2024.06.0/extracted-all/sources/`

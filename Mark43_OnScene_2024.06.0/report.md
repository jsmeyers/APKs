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

## Mark43 RMS API Endpoints

| Endpoint | Purpose | Note |
|----------|---------|------|
| `/rms/auth/sso/v2/logout/url` | SSO logout | Static string |
| `/rms/auth/ping` | Health check | OkHttp |
| `/rms/auth/modules` | Module listing | OkHttp |
| `/rms/auth/login/refresh/v2` | Login refresh | OkHttp |
| `/rms/vehicles/codes/makes` | Vehicle makes | OkHttp |
| `/rms/vehicles/codes/models` | Vehicle models | OkHttp |
| `/rms/master/locations/countries` | Countries list | `?size=1000` param |
| `/rms/user/current/profile` | User profile | Source: `COBALT_CAD` |
| `/rms/attributes/types` | Attribute types | OkHttp |
| `/rms/person/hydrated` | Person data | OkHttp |

**`baseUrl` injection:** Configured at runtime via Dagger DI (`DexApi` module). Not hardcoded in binary — requires proxy analysis or runtime hook to extract actual domain.

**Tech stack:** OkHttp HTTP client, RxJava/Retrofit for API calls.

---

## Suspicious Patterns

| Pattern | Location | Status |
|---------|----------|--------|
| Hardcoded secrets (API keys, tokens, passwords) | None | Clean |
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
3. **Mark43 RMS baseUrl** — Extract at runtime via proxy (Charles, Burp, or OkHttp interceptor) to identify backend domain
4. **Permissions** — Review `AndroidManifest.xml` for over-permissive declarations
5. **Proguard/R8** — Build appears obfuscated — ensure sensitive logic is protected

---

## Full Extracted Sources

Location: `/projects/apks/Mark43_OnScene_2024.06.0/extracted-all/sources/`

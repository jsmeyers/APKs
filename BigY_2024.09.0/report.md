# APK Analysis Report: BigY_2024.09.0

**Date:** 2026-02-20  
**APK:** `Mark43_OnScene_2024.09.0.apk` renamed (29 MB XAPK)  
**Package:** `sysnify.com.bigyrelationshop`  
**App:** Big Y shopping app

---

## Summary

- **File Size:** 29 MB (XAPK containing multiple APKs)  
- **Decompilation:** jadx: 10308 classes (705 errors), apktool: decoded 4 dex files  
- **Tools Used:** jadx dev, apktool 2.7.0-dirty

---

## Extracted APKs

| File | Size | Description |
|------|------|-------------|
| `sysnify.com.bigyrelationshop.apk` | 24.7 MB | Main APK (Big Y shopping app) |
| `config.arm64_v8a.apk` | 4.9 MB | ARM64 native libs |
| `config.en.apk` | 53 KB | English language pack |
| `config.fr.apk` | 37 KB | French language pack |
| `config.xxhdpi.apk` | 227 KB | XXHDPI resources |

---

## External Services Found

### Google Firebase
- Firebase Crashlytics (`https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings`)
- Required config: API Key, App ID, Project ID
- **API Key:** `google_api_key` hardcoded in `strings.xml` (same pattern as NCSOLogger)

### Google Services
- Google Maps (`StreetViewUtils` — `https://maps.googleapis.com/maps/api/streetview/metadata`)
- Google Measurement (`app-measurement.com`, `pagead2.googlesyndication.com`)
- Google Ads (`pagead2.googlesyndication.com/pagead/gen_204`)

---

## API Endpoints

No custom backend API endpoints found. App uses Google services only.

---

## Suspicious Patterns

| Pattern | Location | Status |
|---------|----------|--------|
| Hardcoded API keys | `strings.xml`: `google_api_key`, `google_crash_reporting_api_key` | ⚠️ Exposed |
| Insecure storage (SharedPreferences, plaintext) | Scanned | — |
| WebView JS interface usage | Scanned | — |
| Certificate validation bypass | Scanned | — |

---

## Tech Stack

- Big Y shopping app (sysnify)
- Firebase Crashlytics
- Google Maps API
- Google Measurement (Analytics)
- Google Ads

---

## Recommendations

1. **Google API Key** — Verify it's not exposed in client config (only Firebase config found)
2. **Network Security Config** — Check for cleartext HTTP allowed (not found)
3. **Permissions** — Review `AndroidManifest.xml` for over-permissive declarations
4. **Proguard/R8** — Build appears obfuscated — ensure sensitive logic is protected

---

## Full Extracted Sources

Location: `/projects/apks/BigY_2024.09.0/extracted-all/sources/`

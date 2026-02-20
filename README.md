# APKs

Static analysis of Android APK/XAPK files for security review.

## Tech Stack

- GitHub: `jsmeyers/APKs`
- Tools: `jadx`, `apktool`, `strings`, custom scripts
- Workflow: See `projects/apks/WORKFLOW.md`

## Owner

John

## Status

- Created: 2026-02-20
- Status: active

## Analyzed APKs

### Cyolo_Connect_1.3.0
- **Date:** 2026-02-20
- **File:** `Cyolo_Connect_1.3.0.xapk` (55 MB)
- **Report:** [Cyolo_Connect_1.3.0/report.md](Cyolo_Connect_1.3.0/report.md)
- **Tech Stack:**
  - Flutter (dart:io, flutter_native_splash)
  - AppAuth (OAuth2)
  - OkHttp3 (HTTP client)
  - kotlinx.coroutines
  - QR scanning (flutterqr)
- **Findings:**
  - Decompilation: Success
  - External services: Google Firebase
  - Hardcoded secrets: None
  - ARM64 native libs: Present

### Mark43_OnScene_2024.06.0
- **Date:** 2026-02-20
- **File:** `Mark43_OnScene_2024.06.0-39.1_APKPure.apk` (119 MB)
- **Report:** [Mark43_OnScene_2024.06.0/report.md](Mark43_OnScene_2024.06.0/report.md)
- **Tech Stack:**
  - Mark43 OnScene (public safety dispatch)
  - Firebase (Analytics, Installations)
  - Pendo (Product analytics: US/EU/JPN endpoints)
  - YouTube integration
  - OkHttp, RxJava, Media3
- **Findings:**
  - Decompilation: Success
  - External services: Firebase, Pendo Analytics
  - Hardcoded secrets: None
  - Analytics tracking active

### BigY_2024.09.0
- **Date:** 2026-02-20
- **File:** `BigY_2024.09.0.xapk` (29 MB XAPK) — original filename
- **Report:** [BigY_2024.09.0/report.md](BigY_2024.09.0/report.md)
- **Package:** `sysnify.com.bigyrelationshop` (Big Y shopping app)
- **Tech Stack:**
  - Big Y shopping app (sysnify)
  - Firebase Crashlytics
  - Google Maps API
  - Google Measurement, Google Ads
- **Findings:**
  - Decompilation: Success
  - External services: Firebase, Google Maps, Analytics
  - Google API key exposed in `strings.xml`
  - No custom backend RMS endpoints (different app)

### NCSOLogger
- **Date:** 2026-02-20
- **File:** `NCSOLogger.apk` (7.5 MB XAPK)
- **Report:** [NCSOLogger/report.md](NCSOLogger/report.md)
- **Tech Stack:**
  - LiteTrace SmartLight (IoT lighting control)
  - Firebase Crashlytics
  - ZXing (QR scanning)
  - OkHttp, Retrofit
- **Findings:**
  - Decompilation: Success
  - External services: Firebase
  - `baseUrl`: `https://ble.litetrace.com` (hardcoded)
  - 5 RMS API endpoints: `getdata.php`, `getemdata.php`, `version.php`, `putdata.php`, `putemdata.php`
  - `PARAM_MESH_PASSWORD` stored in sharedprefs (weak crypto)
  - Custom SSL pinning implemented

---

## Roadmap

- [x] Verify `jadx` installed (`jadx --version`)
- [x] Create analysis script template (`scripts/analyze_apk.sh`)
- [x] Define report format (`report.md` schema)
- [x] Add samples to `samples/` for testing
- [ ] Automate analysis pipeline
- [ ] Add static analysis rules (certificate pinning, insecure storage)

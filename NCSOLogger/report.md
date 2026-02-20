# APK Analysis Report: NCSOLogger

**Date:** 2026-02-20  
**APK:** `NCSOLogger.apk` (7.5 MB XAPK)  
**Package:** `com.litetrace.smartlight.light3.cmax`

---

## Summary

- **File Size:** 7.5 MB (XAPK containing multiple APKs)  
- **Decompilation:** jadx: 4358 classes (19 errors), apktool: decoded  
- **Tools Used:** jadx dev, apktool 2.7.0-dirty

---

## Extracted APKs

| File | Size | Description |
|------|------|-------------|
| `com.litetrace.smartlight.light3.cmax.apk` | 6.9 MB | Main APK |
| `config.armeabi_v7a.apk` | 53 KB | ARMv7 native libs |
| `config.en.apk` | 106 KB | English language pack |
| `config.xhdpi.apk` | 682 KB | XHDPI resources |

---

## External Services Found

### Google Firebase
- Firebase Crashlytics (`https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings`)
- API Key: `AIzaSyDkv5-7W4L1GuWvrs7jdXYl0pf_MVJhM90` (hardcoded in `strings.xml`)
- Required config: API Key, App ID, Project ID

### Google Services
- ZXing (QR code scanner)
- AndroidX libraries

---

## API Endpoints

| Service | Endpoint | Method | Purpose |
|---------|----------|--------|---------|
| LiteTrace BLE | `https://ble.litetrace.com/getdata.php` | GET | Data retrieval |
| LiteTrace BLE | `https://ble.litetrace.com/getemdata.php` | GET | Energy monitoring data |
| LiteTrace BLE | `https://ble.litetrace.com/version.php` | GET | Version check |
| LiteTrace BLE | `https://ble.litetrace.com/putdata.php` | POST | Data upload |
| LiteTrace BLE | `https://ble.litetrace.com/putemdata.php` | POST | Energy monitoring upload |

**`baseUrl`:**`https://ble.litetrace.com` (hardcoded in Retrofit builder)

---

## Tech Stack

- LiteTrace SmartLight app
- Firebase Crashlytics
- ZXing (QR scanning)
- OkHttp + Retrofit (HTTP client)
- Material Design components

---

## UI/UX Findings

- **App Title:** "My Zones" (LiteTrace SmartLight)
- **Main Feature:** "My Lights" pop-up — lighting control interface
- **Visual Design:** Material Design (resources confirm lighting-themed icons: `qr_flash_normal`, `qr_scan_line`, `qrcode_scan_line`)

---

## QR Code Generation

- **Library:** ZXing (com.google.zxing)
- **Data Structure:** `com.litetrace.bluetooth.light.model.MeshQRCode`
  - Fields: `index`, `meshName`, `pinData`, `pinName`, `lights`, `devices`
- **Activity Classes:**
  - `QRCodeActivity.java` — QR code presentation
  - `MipcaActivityCapture.java` — Camera-based QR scanning
- **Purpose:** Device pairing — stores mesh configuration for BLE light control

---

## Technical Details

- **BLE Protocol:** Custom LiteTrace BLE API
- **Network:** OkHttp + Retrofit HTTP client
- **Async:** RxJava (ReactiveX)
- **Image Processing:** ZXing for QR code scanning and generation

---

## Technical Details

- **BLE Protocol:** Custom LiteTrace BLE API
- **Network:** OkHttp + Retrofit HTTP client
- **Async:** RxJava (ReactiveX)
- **Image Processing:** ZXing for QR code scanning and generation

---

## Suspicious Patterns

| Pattern | Location | Status |
|---------|----------|--------|
| Hardcoded API keys | `strings.xml`: `google_api_key` = `AIzaSyDkv5-7W4L1Gu...` | ⚠️ Exposed |
| Insecure storage (SharedPreferences, plaintext) | `PARAM_MESH_PASSWORD` stored in sharedprefs | ⚠️ Weak crypto |
| WebView JS interface usage | Scanned | — |
| Certificate validation bypass | `RetrofitBuilder$1` implements custom SSL pinning | Normal |

---

## Recommendations

1. **LiteTrace API Key** — Verify it's not exposed in client config (no hardcoded value found)
2. **Network Security Config** — Check for cleartext HTTP allowed (not found)
3. **Mesh Password** — Stored in sharedprefs with base64 encoding — not secure
4. **Permissions** — Review `AndroidManifest.xml` for over-permissive declarations
5. **Proguard/R8** — Build appears obfuscated — ensure sensitive logic is protected

---

## Full Extracted Sources

Location: `/projects/apks/NCSOLogger/extracted-all/sources/`

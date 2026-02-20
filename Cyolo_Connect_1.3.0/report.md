# APK Analysis Report: Cyolo_Connect_1.3.0

**Date:** 2026-02-20  
**APK:** `Cyolo_Connect_1.3.0.xapk`  
**Package:** `io.cyolo.android`

---

## Summary

- **File Size:** 55 MB (XAPK containing multiple APKs)
- **Decompilation:** Successful (93 parsing errors — normal for obfuscated builds)
- **Analysis Tool:** jadx dev

---

## Extracted APKs

| File | Size | Description |
|------|------|-------------|
| `io.cyolo.android.apk` | 22.9 MB | Main APK |
| `config.arm64_v8a.apk` | 33.6 MB | ARM64 architecture native libs |
| `config.en.apk` | 49 KB | English language pack |
| `config.mdpi.apk` | 59 KB | Medium DPI resources |
| `config.zh.apk` | 33 KB | Chinese language pack |

---

## External Services Found

### Google Firebase
- `https://FirebaseInstallationsAPIDomain/...`
- Required config: API Key, App ID, Project ID
- Deprecation warnings: KTX migration required

---

## API Endpoints

No custom backend endpoints found in binary or manifest.

---

## Suspicious Patterns

| Pattern | Location | Status |
|---------|----------|--------|
| Hardcoded secrets (API keys, tokens, passwords) | None | Clean |
| Insecure storage (SharedPreferences, plaintext) | Scanned | — |
| WebView JS interface usage | Scanned | — |
| Certificate validation bypass | Scanned | — |
| Native code (ARM64) | `config.arm64_v8a.apk` | Normal |

---

## Recommendations

1. **Firebase API Key** — Verify it's not exposed in client code or config files
2. **Network Security Config** — Check `res/xml/network_security_config.xml` for cleartext HTTP allowed
3. **Proguard/R8** — Build appears obfuscated — ensure sensitive logic is protected
4. **Permissions** — Review `AndroidManifest.xml` for over-permissive declarations

---

## Full Extracted Sources

Location: `/projects/apks/Cyolo_Connect_1.3.0/extracted-all/sources/`

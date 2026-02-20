# APKs

Static analysis of Android APK/XAPK files for security review.

## Tech Stack

- GitHub: `jsmeyers/APKs`
- Tools: `jadx`, `apkanalyzer`, `strings`, custom scripts

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
- **Findings:**
  - Decompile: Success
  - External services: Google Firebase
  - Secrets found: None
  - ARM64 native libs: Present

---

## Roadmap

- [x] Verify `jadx` installed (`jadx --version`)
- [x] Create analysis script template (`scripts/analyze_apk.sh`)
- [x] Define report format (`report.md` schema)
- [x] Add samples to `samples/` for testing
- [ ] Automate analysis pipeline
- [ ] Add static analysis rules (certificate pinning, insecure storage)

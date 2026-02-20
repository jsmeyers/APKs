# APKs

Static analysis of Android APK/XAPK files for security review.

## Purpose

- Decompile APKs, extract assets & manifests
- Identify suspicious practices (API calls, endpoints, hardcoded credentials)
- Generate reports per APK under its own subdirectory
- Aggregate findings in root `README.md`

## Tech Stack

- GitHub: `jsmeyers/APKs`
- Tools: `jadx`, `apkanalyzer`, `strings`, custom scripts

## Owner

John

## Usage

1. Place `app.apk` or `app.xapk` in `projects/apks/`
2. Run analysis script
3. Report generated at `projects/apks/<filename>/report.md`
4. Aggregated findings in root `README.md`

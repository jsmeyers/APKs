# APK Analysis Workflow - APks Project

## Setup

### Required Tools

```bash
# Java (jadx requirement)
apt-get install -y default-jdk

# jadx (source decompiler)
cd /tmp && git clone https://github.com/skylot/jadx.git && cd jadx && ./gradlew dist

# apktool (resource/manifest extraction)
apt-get install -y apktool

# Ensure jadx binary is in PATH
export PATH="/tmp/jadx/build/jadx/bin:$PATH"
```

### Tools Usage

| Tool | Purpose |
|------|---------|
| `jadx` | Java source decompilation, API endpoint hunting |
| `apktool` | Manifest, resources, smali, config files |

## Analysis Workflow

### 1. Extract APK
```bash
mkdir -p projects/apks/<name> && cd projects/apks/<name>
mkdir apktool && apktool d <apk-file> -o apktool -f
```

### 2. Decompile with jadx
```bash
jadx -d extracted-all <apk-file>
```

### 3. Scan for API endpoints
```bash
grep -rE "(baseUrl|api|endpoint|@GET|@POST)" extracted-all/sources/ --include="*.java" | head -30
```

### 4. Scan for hardcoded secrets
```bash
grep -rE "(api_key|apiKey|SECRET|PASSWORD|token|Bearer)" extracted-all/sources/ --include="*.java" | head -20
```

### 5. Check external services
```bash
grep -rE "(http|https)://[^\"']+" extracted-all/sources/ --include="*.java" | grep -v "google.com\|androidx" | head -20
```

## Report Template

Save to `report.md`:

```markdown
# APK Analysis Report: <name>

**Date:** YYYY-MM-DD  
**APK:** `<filename>.apk`  
**Package:** `package.name`

---

## Summary

- **File Size:** X MB  
- **Decompilation:** Success/Partial (N errors)
- **Tools Used:** jadx, apktool

---

## External Services Found

### [Service Name]
- Endpoints: `https://...`
- Purpose: ...

---

## API Endpoints

| Endpoint | Purpose | Note |
|----------|---------|------|
| `/api/endpoint` | Description | OkHttp/Retrofit |

**`baseUrl` injection:** Configured at runtime — not hardcoded.

---

## Suspicious Patterns

| Pattern | Status |
|---------|--------|
| Hardcoded secrets | Clean |
| Insecure storage | Scanned |
| WebView JS interface | Scanned |
| Cert validation bypass | Scanned |

---

## Tech Stack

- App framework
- Firebase/Pendo/etc
- HTTP client: OkHttp
- Reactive: RxJava

---

## Recommendations

1. Verify API key exposure
2. Check Network Security Config
3. ...

---

## Full Extracted Sources

Location: `/projects/apks/<name>/extracted-all/sources/`
```

## Output Directory Structure

```
projects/apks/<name>/
├── report.md
├── apktool/              # apktool extraction
├── extracted-all/        # jadx extraction
├── lib/                  # architecture-specific libs (if multi-APK)
└── [other extracted files]
```

## Reproducibility Checklist

- [ ] jadx version documented (`jadx --version`)
- [ ] apktool version documented (`apktool --version`)
- [ ] Java version documented (`java -version`)
- [ ] Full command-line commands in workflow
- [ ] No hardcoded secrets — all injected at runtime
- [ ] `baseUrl` explicitly noted as runtime-injected (if used)
- [ ] Report includes external services (Firebase, Pendo, Bugsnag, etc.)
- [ ] Report includes RMS API endpoints (if applicable)

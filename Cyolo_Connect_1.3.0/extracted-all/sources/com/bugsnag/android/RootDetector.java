package com.bugsnag.android;

import android.os.SystemClock;
import io.cyolo.android.MethodNames;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RootDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B3\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000fJ\r\u0010\u0010\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0011J\r\u0010\u0012\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0013J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0015\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u0017J\u0006\u0010\u0018\u001a\u00020\rJ\b\u0010\u0019\u001a\u00020\rH\u0002J\t\u0010\u001a\u001a\u00020\rH\u0082 J\u0014\u0010\u001b\u001a\u00020\r*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\f\u0010\u001f\u001a\u00020\r*\u00020 H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bugsnag/android/RootDetector;", "", "deviceBuildInfo", "Lcom/bugsnag/android/DeviceBuildInfo;", "rootBinaryLocations", "", "", "buildProps", "Ljava/io/File;", "logger", "Lcom/bugsnag/android/Logger;", "(Lcom/bugsnag/android/DeviceBuildInfo;Ljava/util/List;Ljava/io/File;Lcom/bugsnag/android/Logger;)V", "libraryLoaded", "", "checkBuildProps", "checkBuildProps$bugsnag_android_core_release", "checkBuildTags", "checkBuildTags$bugsnag_android_core_release", "checkRootBinaries", "checkRootBinaries$bugsnag_android_core_release", "checkSuExists", "processBuilder", "Ljava/lang/ProcessBuilder;", "checkSuExists$bugsnag_android_core_release", MethodNames.isRooted, "nativeCheckRoot", "performNativeRootChecks", "fallbackWaitFor", "Ljava/lang/Process;", "timeout", "", "isNotBlank", "Ljava/io/Reader;", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RootDetector {
    private static final long PROCESS_POLL_DELAY = 50;
    private static final long PROCESS_TIMEOUT = 250;
    private final File buildProps;
    private final DeviceBuildInfo deviceBuildInfo;
    private volatile boolean libraryLoaded;
    private final Logger logger;
    private final List<String> rootBinaryLocations;
    private static final File BUILD_PROP_FILE = new File("/system/build.prop");
    private static final List<String> ROOT_INDICATORS = CollectionsKt.listOf((Object[]) new String[]{"/system/xbin/su", "/system/bin/su", "/system/app/Superuser.apk", "/system/app/SuperSU.apk", "/system/app/Superuser", "/system/app/SuperSU", "/system/xbin/daemonsu", "/su/bin"});

    public RootDetector(DeviceBuildInfo deviceBuildInfo, Logger logger) {
        this(deviceBuildInfo, null, null, logger, 6, null);
    }

    public RootDetector(DeviceBuildInfo deviceBuildInfo, List<String> list, Logger logger) {
        this(deviceBuildInfo, list, null, logger, 4, null);
    }

    public RootDetector(Logger logger) {
        this(null, null, null, logger, 7, null);
    }

    private final native boolean performNativeRootChecks();

    public RootDetector(DeviceBuildInfo deviceBuildInfo, List<String> list, File file, Logger logger) {
        this.deviceBuildInfo = deviceBuildInfo;
        this.rootBinaryLocations = list;
        this.buildProps = file;
        this.logger = logger;
        try {
            System.loadLibrary("bugsnag-root-detection");
            this.libraryLoaded = true;
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public /* synthetic */ RootDetector(DeviceBuildInfo deviceBuildInfo, List list, File file, Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DeviceBuildInfo.INSTANCE.defaultInfo() : deviceBuildInfo, (i & 2) != 0 ? ROOT_INDICATORS : list, (i & 4) != 0 ? BUILD_PROP_FILE : file, logger);
    }

    public final boolean isRooted() {
        try {
            return checkBuildTags$bugsnag_android_core_release() || checkSuExists() || checkBuildProps$bugsnag_android_core_release() || checkRootBinaries$bugsnag_android_core_release() || nativeCheckRoot();
        } catch (Throwable th) {
            this.logger.w("Root detection failed", th);
            return false;
        }
    }

    private final boolean checkSuExists() {
        return checkSuExists$bugsnag_android_core_release(new ProcessBuilder(new String[0]));
    }

    public final boolean checkBuildTags$bugsnag_android_core_release() {
        String tags = this.deviceBuildInfo.getTags();
        return tags != null && StringsKt.contains$default((CharSequence) tags, (CharSequence) "test-keys", false, 2, (Object) null);
    }

    public final boolean checkRootBinaries$bugsnag_android_core_release() {
        try {
            Result.Companion companion = Result.INSTANCE;
            RootDetector rootDetector = this;
            Iterator<String> it = this.rootBinaryLocations.iterator();
            while (it.hasNext()) {
                if (new File(it.next()).exists()) {
                    return true;
                }
            }
            Result.m442constructorimpl(Unit.INSTANCE);
            return false;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m442constructorimpl(ResultKt.createFailure(th));
            return false;
        }
    }

    public final boolean checkBuildProps$bugsnag_android_core_release() {
        try {
            Result.Companion companion = Result.INSTANCE;
            RootDetector rootDetector = this;
            Reader inputStreamReader = new InputStreamReader(new FileInputStream(this.buildProps), Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            BufferedReader bufferedReader2 = bufferedReader instanceof BufferedReader ? bufferedReader : new BufferedReader(bufferedReader, 8192);
            try {
                boolean zAny = SequencesKt.any(SequencesKt.filter(SequencesKt.map(TextStreamsKt.lineSequence(bufferedReader2), new Function1<String, String>() { // from class: com.bugsnag.android.RootDetector$checkBuildProps$1$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(String str) {
                        return new Regex("\\s").replace(str, "");
                    }
                }), new Function1<String, Boolean>() { // from class: com.bugsnag.android.RootDetector$checkBuildProps$1$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(String str) {
                        return Boolean.valueOf(StringsKt.startsWith$default(str, "ro.debuggable=[1]", false, 2, (Object) null) || StringsKt.startsWith$default(str, "ro.secure=[0]", false, 2, (Object) null));
                    }
                }));
                CloseableKt.closeFinally(bufferedReader2, null);
                return zAny;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader2, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m442constructorimpl(ResultKt.createFailure(th3));
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0075, code lost:
    
        if (r1 == null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean checkSuExists$bugsnag_android_core_release(java.lang.ProcessBuilder r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "which"
            java.lang.String r1 = "su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            r7.command(r0)
            r0 = 0
            r1 = 0
            java.lang.Process r7 = r7.start()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74 java.lang.InterruptedException -> L7c
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            r3 = 26
            r4 = 250(0xfa, double:1.235E-321)
            if (r2 < r3) goto L24
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            boolean r2 = com.bugsnag.android.RootDetector$$ExternalSyntheticApiModelOutline0.m(r7, r4, r2)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            goto L28
        L24:
            boolean r2 = r6.fallbackWaitFor(r7, r4)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
        L28:
            if (r2 != 0) goto L31
            if (r7 != 0) goto L2d
            goto L30
        L2d:
            r7.destroy()
        L30:
            return r0
        L31:
            java.io.InputStream r2 = r7.getInputStream()     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            r4.<init>(r2, r3)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            java.io.Reader r4 = (java.io.Reader) r4     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            boolean r2 = r4 instanceof java.io.BufferedReader     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            if (r2 == 0) goto L45
            java.io.BufferedReader r4 = (java.io.BufferedReader) r4     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            goto L4d
        L45:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            r3 = 8192(0x2000, float:1.148E-41)
            r2.<init>(r4, r3)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            r4 = r2
        L4d:
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            r2 = r4
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch: java.lang.Throwable -> L63
            java.io.Reader r2 = (java.io.Reader) r2     // Catch: java.lang.Throwable -> L63
            boolean r2 = r6.isNotBlank(r2)     // Catch: java.lang.Throwable -> L63
            kotlin.io.CloseableKt.closeFinally(r4, r1)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            if (r7 != 0) goto L5e
            goto L61
        L5e:
            r7.destroy()
        L61:
            r0 = r2
            goto L85
        L63:
            r1 = move-exception
            throw r1     // Catch: java.lang.Throwable -> L65
        L65:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r1)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
            throw r2     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.lang.InterruptedException -> L70
        L6a:
            r0 = move-exception
            r1 = r7
            goto L86
        L6d:
            r1 = r7
            goto L75
        L70:
            r1 = r7
            goto L7c
        L72:
            r0 = move-exception
            goto L86
        L74:
        L75:
            if (r1 != 0) goto L78
            goto L85
        L78:
            r1.destroy()
            goto L85
        L7c:
            java.lang.Thread r7 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L72
            r7.interrupt()     // Catch: java.lang.Throwable -> L72
            if (r1 != 0) goto L78
        L85:
            return r0
        L86:
            if (r1 != 0) goto L89
            goto L8c
        L89:
            r1.destroy()
        L8c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.RootDetector.checkSuExists$bugsnag_android_core_release(java.lang.ProcessBuilder):boolean");
    }

    private final boolean isNotBlank(Reader reader) throws IOException {
        int i;
        do {
            i = reader.read();
            if (i == -1) {
                return false;
            }
        } while (CharsKt.isWhitespace((char) i));
        return true;
    }

    private final boolean nativeCheckRoot() {
        if (this.libraryLoaded) {
            return performNativeRootChecks();
        }
        return false;
    }

    private final boolean fallbackWaitFor(Process process, long j) throws InterruptedException {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j;
        while (SystemClock.elapsedRealtime() < jElapsedRealtime) {
            try {
                process.exitValue();
                return true;
            } catch (IllegalThreadStateException unused) {
                java.lang.Thread.sleep(Math.min(PROCESS_POLL_DELAY, jElapsedRealtime - SystemClock.elapsedRealtime()));
            }
        }
        return false;
    }
}

package com.bugsnag.android.internal;

import android.content.pm.ApplicationInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;

/* JADX INFO: compiled from: DexBuildIdGenerator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0002\b\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bugsnag/android/internal/DexBuildIdGenerator;", "", "()V", "CHECKSUM_BYTE_COUNT", "", "HEADER_SIZE", "MAGIC_NUMBER_BYTE_COUNT", "SIGNATURE_BYTE_COUNT", "SIGNATURE_START_BYTE", "extractDexSignature", "", "header", "extractDexSignature$bugsnag_android_core_release", "generateApkBuildId", "apk", "Ljava/io/File;", "generateApkBuildId$bugsnag_android_core_release", "generateBuildId", "", "appInfo", "Landroid/content/pm/ApplicationInfo;", "mergeSignatureInfoBuildId", "", "buildId", "signature", "signatureFromZipEntry", "zip", "Ljava/util/zip/ZipFile;", "dexEntry", "Ljava/util/zip/ZipEntry;", "unsafeGenerateBuildId", "validateHeader", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DexBuildIdGenerator {
    private static final int CHECKSUM_BYTE_COUNT = 4;
    private static final int HEADER_SIZE = 32;
    public static final DexBuildIdGenerator INSTANCE = new DexBuildIdGenerator();
    private static final int MAGIC_NUMBER_BYTE_COUNT = 8;
    private static final int SIGNATURE_BYTE_COUNT = 20;
    private static final int SIGNATURE_START_BYTE = 12;

    private DexBuildIdGenerator() {
    }

    public final String generateBuildId(ApplicationInfo appInfo) {
        try {
            byte[] bArrUnsafeGenerateBuildId = unsafeGenerateBuildId(appInfo);
            if (bArrUnsafeGenerateBuildId == null) {
                return null;
            }
            return ByteArrayExtensionsKt.toHexString(bArrUnsafeGenerateBuildId);
        } catch (Throwable unused) {
            return null;
        }
    }

    private final byte[] unsafeGenerateBuildId(ApplicationInfo appInfo) {
        File file = new File(appInfo.sourceDir);
        if (file.canRead()) {
            return generateApkBuildId$bugsnag_android_core_release(file);
        }
        return null;
    }

    public final byte[] generateApkBuildId$bugsnag_android_core_release(File apk) throws Throwable {
        byte[] bArrSignatureFromZipEntry;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(apk, 1);
            try {
                ZipEntry entry = zipFile2.getEntry("classes.dex");
                if (entry == null) {
                    zipFile2.close();
                    return null;
                }
                byte[] bArrSignatureFromZipEntry2 = signatureFromZipEntry(zipFile2, entry);
                if (bArrSignatureFromZipEntry2 == null) {
                    zipFile2.close();
                    return null;
                }
                int i = 2;
                while (true) {
                    ZipEntry entry2 = zipFile2.getEntry("classes" + i + ".dex");
                    if (entry2 == null || (bArrSignatureFromZipEntry = signatureFromZipEntry(zipFile2, entry2)) == null) {
                        break;
                        break;
                    }
                    mergeSignatureInfoBuildId(bArrSignatureFromZipEntry2, bArrSignatureFromZipEntry);
                    i++;
                }
                zipFile2.close();
                return bArrSignatureFromZipEntry2;
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void mergeSignatureInfoBuildId(byte[] buildId, byte[] signature) {
        int length = buildId.length;
        for (int i = 0; i < length; i++) {
            buildId[i] = (byte) (buildId[i] ^ signature[i]);
        }
    }

    private final byte[] signatureFromZipEntry(ZipFile zip, ZipEntry dexEntry) throws IOException {
        byte[] bArrExtractDexSignature$bugsnag_android_core_release;
        InputStream inputStream = zip.getInputStream(dexEntry);
        try {
            byte[] bArr = new byte[32];
            if (inputStream.read(bArr, 0, 32) == 32) {
                bArrExtractDexSignature$bugsnag_android_core_release = INSTANCE.extractDexSignature$bugsnag_android_core_release(bArr);
            } else {
                bArrExtractDexSignature$bugsnag_android_core_release = null;
            }
            CloseableKt.closeFinally(inputStream, null);
            return bArrExtractDexSignature$bugsnag_android_core_release;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }

    public final byte[] extractDexSignature$bugsnag_android_core_release(byte[] header) {
        if (!validateHeader(header)) {
            return null;
        }
        return ArraysKt.copyOfRange(header, 12, 32);
    }

    private final boolean validateHeader(byte[] header) {
        return (header[0] & 255) == 100 && (header[1] & 255) == 101 && (header[2] & 255) == 120 && (header[3] & 255) == 10 && (header[7] & 255) == 0;
    }
}

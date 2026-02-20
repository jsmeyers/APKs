package com.bugsnag.android;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: Deliverable.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bugsnag/android/Deliverable;", "", "integrityToken", "", "getIntegrityToken", "()Ljava/lang/String;", "toByteArray", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Deliverable {
    String getIntegrityToken();

    byte[] toByteArray() throws IOException;

    /* JADX INFO: compiled from: Deliverable.kt */
    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static String getIntegrityToken(Deliverable deliverable) {
            try {
                Result.Companion companion = Result.INSTANCE;
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                StringBuilder sb = new StringBuilder("sha1 ");
                OutputStream digestOutputStream = new DigestOutputStream(new NullOutputStream(), messageDigest);
                try {
                    OutputStream outputStream = (DigestOutputStream) digestOutputStream;
                    BufferedOutputStream bufferedOutputStream = outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, 8192);
                    try {
                        bufferedOutputStream.write(deliverable.toByteArray());
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedOutputStream, null);
                        byte[] bArrDigest = messageDigest.digest();
                        int length = bArrDigest.length;
                        int i = 0;
                        while (i < length) {
                            byte b = bArrDigest[i];
                            i++;
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                            sb.append(str);
                        }
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(digestOutputStream, null);
                        return sb.toString();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(bufferedOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(digestOutputStream, th3);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                if (Result.m445exceptionOrNullimpl(Result.m442constructorimpl(ResultKt.createFailure(th5))) != null) {
                    return null;
                }
                throw new KotlinNothingValueException();
            }
        }
    }
}

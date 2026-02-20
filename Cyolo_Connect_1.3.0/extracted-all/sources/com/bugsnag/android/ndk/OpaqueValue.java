package com.bugsnag.android.ndk;

import com.bugsnag.android.JsonStream;
import io.cyolo.android.MainActivityKt;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: OpaqueValue.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bugsnag/android/ndk/OpaqueValue;", "", "json", "", "(Ljava/lang/String;)V", "getJson", "()Ljava/lang/String;", "Companion", "bugsnag-plugin-android-ndk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OpaqueValue {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int INITIAL_BUFFER_SIZE = 256;
    private static final int MAX_NDK_STRING_LENGTH = 64;
    private static final int US_ASCII_MAX_CODEPOINT = 127;
    private final String json;

    @JvmStatic
    public static final Object makeSafe(Object obj) {
        return INSTANCE.makeSafe(obj);
    }

    /* JADX INFO: compiled from: OpaqueValue.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bugsnag/android/ndk/OpaqueValue$Companion;", "", "()V", "INITIAL_BUFFER_SIZE", "", "MAX_NDK_STRING_LENGTH", "US_ASCII_MAX_CODEPOINT", "encode", "", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "isStringNDKSupported", "", "makeSafe", "bugsnag-plugin-android-ndk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isStringNDKSupported(String value) {
            boolean z;
            if (value.length() >= 64) {
                return false;
            }
            String str = value;
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                }
                char cCharAt = str.charAt(i);
                i++;
                if (!(cCharAt <= 127)) {
                    z = false;
                    break;
                }
            }
            if (z) {
                return true;
            }
            byte[] bytes = value.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes.length < 64;
        }

        public final String encode(Object value) {
            StringWriter stringWriter = new StringWriter(256);
            StringWriter stringWriter2 = stringWriter;
            try {
                new JsonStream(stringWriter2).value(value, false);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(stringWriter2, null);
                return stringWriter.toString();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(stringWriter2, th);
                    throw th2;
                }
            }
        }

        @JvmStatic
        public final Object makeSafe(Object value) {
            if ((value instanceof Boolean) || (value instanceof Number)) {
                return value;
            }
            boolean z = value instanceof String;
            if (z && isStringNDKSupported((String) value)) {
                return value;
            }
            if (z || (value instanceof Map) || (value instanceof Collection) || (value instanceof Object[])) {
                return new OpaqueValue(encode(value));
            }
            return null;
        }
    }

    public OpaqueValue(String str) {
        this.json = str;
    }

    public final String getJson() {
        return this.json;
    }
}

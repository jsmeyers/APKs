package com.bugsnag.android.internal;

import com.bugsnag.android.JsonStream;
import com.bugsnag.android.repackaged.dslplatform.json.DslJson;
import com.bugsnag.android.repackaged.dslplatform.json.JsonWriter;
import io.cyolo.android.MainActivityKt;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FileSystemException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: JsonHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u0012\u0012\u0006\b\u0000\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00010\u00052\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000b\u001a\u0012\u0012\u0006\b\u0000\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0001J\u0016\u0010\u0016\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u0016\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u001cR4\u0010\u0003\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001 \u0007*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000Rh\u0010\b\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001 \u0007*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00050\u0005 \u0007**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001 \u0007*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00050\u0005\u0018\u00010\t0\tX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0002¨\u0006\u001d"}, d2 = {"Lcom/bugsnag/android/internal/JsonHelper;", "", "()V", "dslJson", "Lcom/bugsnag/android/repackaged/dslplatform/json/DslJson;", "", "", "kotlin.jvm.PlatformType", "settings", "Lcom/bugsnag/android/repackaged/dslplatform/json/DslJson$Settings;", "getSettings$annotations", "deserialize", "file", "Ljava/io/File;", "stream", "Ljava/io/InputStream;", "bytes", "", "jsonToLong", "", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "(Ljava/lang/Object;)Ljava/lang/Long;", "serialize", "streamable", "Lcom/bugsnag/android/JsonStream$Streamable;", "", "Ljava/io/OutputStream;", "ulongToHex", "(Ljava/lang/Long;)Ljava/lang/String;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class JsonHelper {
    public static final JsonHelper INSTANCE = new JsonHelper();
    private static final DslJson<Map<String, Object>> dslJson;
    private static final DslJson.Settings<Map<String, Object>> settings;

    private static /* synthetic */ void getSettings$annotations() {
    }

    private JsonHelper() {
    }

    static {
        DslJson.Settings<Map<String, Object>> settingsFallbackTo = new DslJson.Settings().fallbackTo(new FallbackWriter());
        settings = settingsFallbackTo;
        DslJson<Map<String, Object>> dslJson2 = new DslJson<>(settingsFallbackTo);
        dslJson = dslJson2;
        dslJson2.registerWriter(Date.class, new JsonWriter.WriteObject() { // from class: com.bugsnag.android.internal.JsonHelper$$ExternalSyntheticLambda0
            @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
            public final void write(JsonWriter jsonWriter, Object obj) {
                JsonHelper.m258_init_$lambda1(jsonWriter, (Date) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    public static final void m258_init_$lambda1(JsonWriter jsonWriter, Date date) {
        if (date == null) {
            return;
        }
        jsonWriter.writeString(DateUtils.toIso8601(date));
    }

    public final byte[] serialize(JsonStream.Streamable streamable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            JsonStream jsonStream = new JsonStream(new PrintWriter(byteArrayOutputStream2));
            try {
                streamable.toStream(jsonStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(jsonStream, null);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                return byteArray;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(jsonStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(byteArrayOutputStream, th3);
                throw th4;
            }
        }
    }

    public final byte[] serialize(Object value) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            INSTANCE.serialize(value, byteArrayOutputStream2);
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            CloseableKt.closeFinally(byteArrayOutputStream, null);
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }

    public final void serialize(Object value, OutputStream stream) throws IOException {
        dslJson.serialize(value, stream);
    }

    public final void serialize(Object value, File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new FileSystemException(file, null, "Could not create parent dirs of file");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                dslJson.serialize(value, fileOutputStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new IOException(Intrinsics.stringPlus("Could not serialize JSON document to ", file), e);
        }
    }

    public final Map<String, Object> deserialize(byte[] bytes) {
        Map map = (Map) dslJson.deserialize(Map.class, bytes, bytes.length);
        if (map == null) {
            throw new IllegalArgumentException("JSON document is invalid".toString());
        }
        return TypeIntrinsics.asMutableMap(map);
    }

    public final Map<? super String, ? extends Object> deserialize(InputStream stream) {
        Map map = (Map) dslJson.deserialize(Map.class, stream);
        if (map == null) {
            throw new IllegalArgumentException("JSON document is invalid".toString());
        }
        return TypeIntrinsics.asMutableMap(map);
    }

    public final Map<? super String, ? extends Object> deserialize(File file) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                Map<? super String, ? extends Object> mapDeserialize = INSTANCE.deserialize(fileInputStream);
                CloseableKt.closeFinally(fileInputStream, null);
                return mapDeserialize;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileInputStream, th);
                    throw th2;
                }
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e2) {
            throw new IOException(Intrinsics.stringPlus("Could not deserialize from ", file), e2);
        }
    }

    public final String ulongToHex(Long value) {
        if (value == null) {
            return null;
        }
        if (value.longValue() >= 0) {
            String str = String.format("0x%x", Arrays.copyOf(new Object[]{value}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
            return str;
        }
        String str2 = String.format("0x%x%02x", Arrays.copyOf(new Object[]{Long.valueOf(value.longValue() >>> 8), Long.valueOf(value.longValue() & 255)}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(this, *args)");
        return str2;
    }

    public final Long jsonToLong(Object value) {
        long jLongValue;
        Long lValueOf;
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return Long.valueOf(((Number) value).longValue());
        }
        if (value instanceof String) {
            String str = (String) value;
            if (str.length() == 0) {
                return null;
            }
            try {
                lValueOf = Long.decode((String) value);
            } catch (NumberFormatException e) {
                if (StringsKt.startsWith$default(str, "0x", false, 2, (Object) null)) {
                    if (str.length() != 18) {
                        throw e;
                    }
                    int length = str.length() - 2;
                    String strSubstring = str.substring(0, length);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    long jLongValue2 = Long.decode(strSubstring).longValue() << 8;
                    String strSubstring2 = str.substring(length, str.length());
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    jLongValue = Long.parseLong(strSubstring2, CharsKt.checkRadix(16)) | jLongValue2;
                } else {
                    if (str.length() < 19) {
                        throw e;
                    }
                    int length2 = str.length() - 3;
                    String strSubstring3 = str.substring(0, length2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    long jLongValue3 = Long.decode(strSubstring3).longValue() * ((long) 1000);
                    String strSubstring4 = str.substring(length2, str.length());
                    Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                    jLongValue = Long.decode(strSubstring4).longValue() + jLongValue3;
                }
                lValueOf = Long.valueOf(jLongValue);
            }
            return lValueOf;
        }
        throw new IllegalArgumentException("Cannot convert " + value + " to long");
    }
}

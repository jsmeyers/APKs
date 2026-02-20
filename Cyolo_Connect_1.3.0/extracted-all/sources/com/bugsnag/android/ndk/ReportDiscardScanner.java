package com.bugsnag.android.ndk;

import android.util.JsonReader;
import android.util.JsonToken;
import com.bugsnag.android.Logger;
import com.bugsnag.android.NativeInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ReportDiscardScanner.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\fJ\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bugsnag/android/ndk/ReportDiscardScanner;", "", "logger", "Lcom/bugsnag/android/Logger;", "enabledReleaseStages", "", "", "(Lcom/bugsnag/android/Logger;Ljava/util/Collection;)V", "shouldDiscard", "", "json", "Landroid/util/JsonReader;", "shouldDiscard$bugsnag_plugin_android_ndk_release", "report", "Ljava/io/File;", "shouldDiscardException", "shouldDiscardForApp", "shouldDiscardForExceptions", "bugsnag-plugin-android-ndk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ReportDiscardScanner {
    private final Collection<String> enabledReleaseStages;
    private final Logger logger;

    public ReportDiscardScanner(Logger logger, Collection<String> collection) {
        this.logger = logger;
        this.enabledReleaseStages = collection;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ReportDiscardScanner(Logger logger, Collection collection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0 && (collection = NativeInterface.getEnabledReleaseStages()) == null) {
            collection = SetsKt.emptySet();
        }
        this(logger, collection);
    }

    public final boolean shouldDiscard(File report) {
        if (!StringsKt.endsWith$default(report.getName(), ".json", false, 2, (Object) null) || StringsKt.endsWith$default(report.getName(), ".static_data.json", false, 2, (Object) null)) {
            return true;
        }
        try {
            Reader inputStreamReader = new InputStreamReader(new FileInputStream(report), Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                JsonReader jsonReader = new JsonReader(bufferedReader);
                try {
                    boolean zShouldDiscard$bugsnag_plugin_android_ndk_release = shouldDiscard$bugsnag_plugin_android_ndk_release(jsonReader);
                    CloseableKt.closeFinally(jsonReader, null);
                    CloseableKt.closeFinally(bufferedReader, null);
                    return zShouldDiscard$bugsnag_plugin_android_ndk_release;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(jsonReader, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(bufferedReader, th3);
                    throw th4;
                }
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean shouldDiscard$bugsnag_plugin_android_ndk_release(JsonReader json) throws IOException {
        boolean zShouldDiscardForExceptions;
        json.beginObject();
        boolean z = true;
        boolean z2 = true;
        do {
            zShouldDiscardForExceptions = false;
            if (!json.hasNext() || (!z && !z2)) {
                return false;
            }
            String strNextName = json.nextName();
            if (Intrinsics.areEqual(strNextName, "app")) {
                zShouldDiscardForExceptions = shouldDiscardForApp(json);
                z = false;
            } else if (Intrinsics.areEqual(strNextName, "exceptions")) {
                zShouldDiscardForExceptions = shouldDiscardForExceptions(json);
                z2 = false;
            } else {
                json.skipValue();
            }
        } while (!zShouldDiscardForExceptions);
        return true;
    }

    private final boolean shouldDiscardForApp(JsonReader json) throws IOException {
        if (this.enabledReleaseStages.isEmpty()) {
            json.skipValue();
            return false;
        }
        json.beginObject();
        while (json.peek() != JsonToken.END_OBJECT) {
            if (Intrinsics.areEqual(json.nextName(), "releaseStage")) {
                if (!this.enabledReleaseStages.contains(json.nextString())) {
                    return true;
                }
            } else {
                json.skipValue();
            }
        }
        json.endObject();
        return false;
    }

    private final boolean shouldDiscardForExceptions(JsonReader json) throws IOException {
        json.beginArray();
        while (json.peek() != JsonToken.END_ARRAY) {
            if (shouldDiscardException(json)) {
                this.logger.d("Discarding native report due to errorClass");
                return true;
            }
        }
        json.endArray();
        return false;
    }

    private final boolean shouldDiscardException(JsonReader json) throws IOException {
        json.beginObject();
        while (json.peek() != JsonToken.END_OBJECT) {
            if (Intrinsics.areEqual(json.nextName(), "errorClass")) {
                if (NativeInterface.isDiscardErrorClass(json.nextString())) {
                    return true;
                }
            } else {
                json.skipValue();
            }
        }
        json.endObject();
        return false;
    }
}

package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.bugsnag.android.internal.StringUtils;
import com.bugsnag.android.internal.TrimMetrics;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BreadcrumbInternal.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bugsnag/android/BreadcrumbInternal;", "Lcom/bugsnag/android/JsonStream$Streamable;", "message", "", "(Ljava/lang/String;)V", "type", "Lcom/bugsnag/android/BreadcrumbType;", "metadata", "", "", "timestamp", "Ljava/util/Date;", "(Ljava/lang/String;Lcom/bugsnag/android/BreadcrumbType;Ljava/util/Map;Ljava/util/Date;)V", "toStream", "", "writer", "Lcom/bugsnag/android/JsonStream;", "trimMetadataStringsTo", "Lcom/bugsnag/android/internal/TrimMetrics;", "maxStringLength", "", "trimMetadataStringsTo$bugsnag_android_core_release", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BreadcrumbInternal implements JsonStream.Streamable {
    public String message;
    public Map<String, Object> metadata;
    public final Date timestamp;
    public BreadcrumbType type;

    public BreadcrumbInternal(String str, BreadcrumbType breadcrumbType, Map<String, Object> map, Date date) {
        this.message = str;
        this.type = breadcrumbType;
        this.metadata = map;
        this.timestamp = date;
    }

    public /* synthetic */ BreadcrumbInternal(String str, BreadcrumbType breadcrumbType, Map map, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, breadcrumbType, map, (i & 8) != 0 ? new Date() : date);
    }

    public BreadcrumbInternal(String str) {
        this(str, BreadcrumbType.MANUAL, new LinkedHashMap(), new Date());
    }

    public final TrimMetrics trimMetadataStringsTo$bugsnag_android_core_release(int maxStringLength) {
        Map<String, Object> map = this.metadata;
        return map == null ? new TrimMetrics(0, 0) : StringUtils.INSTANCE.trimStringValuesTo(maxStringLength, map);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws Throwable {
        writer.beginObject();
        writer.name("timestamp").value(this.timestamp);
        writer.name("name").value(this.message);
        writer.name("type").value(this.type.getType());
        writer.name("metaData");
        writer.value(this.metadata, true);
        writer.endObject();
    }
}

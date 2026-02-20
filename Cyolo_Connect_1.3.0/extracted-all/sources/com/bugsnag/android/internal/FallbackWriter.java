package com.bugsnag.android.internal;

import com.bugsnag.android.repackaged.dslplatform.json.DslJson;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: FallbackWriter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0005J.\u0010\b\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J6\u0010\b\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0014H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bugsnag/android/internal/FallbackWriter;", "Lcom/bugsnag/android/repackaged/dslplatform/json/DslJson$Fallback;", "", "", "", "()V", "placeholder", "", "deserialize", "context", "manifest", "Ljava/lang/reflect/Type;", "stream", "Ljava/io/InputStream;", "body", "size", "", "serialize", "", "instance", "Ljava/io/OutputStream;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FallbackWriter implements DslJson.Fallback<Map<String, Object>> {
    private final byte[] placeholder;

    public FallbackWriter() {
        byte[] bytes = "\"[OBJECT]\"".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        this.placeholder = bytes;
    }

    @Override // com.bugsnag.android.repackaged.dslplatform.json.DslJson.Fallback
    public void serialize(Object instance, OutputStream stream) throws IOException {
        stream.write(this.placeholder);
    }

    @Override // com.bugsnag.android.repackaged.dslplatform.json.DslJson.Fallback
    public Object deserialize(Map<String, Object> context, Type manifest, byte[] body, int size) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bugsnag.android.repackaged.dslplatform.json.DslJson.Fallback
    public Object deserialize(Map<String, Object> context, Type manifest, InputStream stream) {
        throw new UnsupportedOperationException();
    }
}

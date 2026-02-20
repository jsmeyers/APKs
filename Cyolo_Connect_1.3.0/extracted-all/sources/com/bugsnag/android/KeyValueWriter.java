package com.bugsnag.android;

import io.cyolo.android.MainActivityKt;

/* JADX INFO: compiled from: LastRunInfoStore.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bugsnag/android/KeyValueWriter;", "", "()V", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "add", "", "key", "", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "toString", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class KeyValueWriter {
    private final StringBuilder sb = new StringBuilder();

    public final void add(String key, Object value) {
        this.sb.append(key + '=' + value);
        this.sb.append(org.apache.commons.io.IOUtils.LINE_SEPARATOR_UNIX);
    }

    public String toString() {
        return this.sb.toString();
    }
}

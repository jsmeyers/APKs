package androidx.work.impl.utils;

import j$.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DurationApi26.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¨\u0006\u0003"}, d2 = {"j$/time/Duration", "", "toMillisCompat", "work-runtime_release"}, k = 2, mv = {1, 8, 0})
public final class DurationApi26Impl {
    public static final long toMillisCompat(Duration duration) {
        Intrinsics.checkNotNullParameter(duration, "<this>");
        return duration.toMillis();
    }
}

package com.bugsnag.android;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ThreadSendPolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/bugsnag/android/ThreadSendPolicy;", "", "(Ljava/lang/String;I)V", "ALWAYS", "UNHANDLED_ONLY", "NEVER", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum ThreadSendPolicy {
    ALWAYS,
    UNHANDLED_ONLY,
    NEVER;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ThreadSendPolicy.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bugsnag/android/ThreadSendPolicy$Companion;", "", "()V", "fromString", "Lcom/bugsnag/android/ThreadSendPolicy;", "str", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Found duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Found duplicated region for block: B:9:0x001a  */
        public final ThreadSendPolicy fromString(String str) {
            ThreadSendPolicy threadSendPolicy;
            ThreadSendPolicy[] threadSendPolicyArrValues = ThreadSendPolicy.values();
            int length = threadSendPolicyArrValues.length;
            int i = 0;
            while (i < length) {
                threadSendPolicy = threadSendPolicyArrValues[i];
                i++;
                if (kotlin.jvm.internal.Intrinsics.areEqual(threadSendPolicy.name(), str)) {
                    return threadSendPolicy == null ? ThreadSendPolicy.ALWAYS : threadSendPolicy;
                }
            }
            threadSendPolicy = null;
            if (threadSendPolicy == null) {
            }
        }
    }
}

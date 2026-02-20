package com.bugsnag.android;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EndpointConfiguration.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bugsnag/android/EndpointConfiguration;", "", "notify", "", "sessions", "(Ljava/lang/String;Ljava/lang/String;)V", "getNotify", "()Ljava/lang/String;", "getSessions", "equals", "", "other", "hashCode", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EndpointConfiguration {
    private final String notify;
    private final String sessions;

    /* JADX WARN: Multi-variable type inference failed */
    public EndpointConfiguration() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public EndpointConfiguration(String str, String str2) {
        this.notify = str;
        this.sessions = str2;
    }

    public /* synthetic */ EndpointConfiguration(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "https://notify.bugsnag.com" : str, (i & 2) != 0 ? "https://sessions.bugsnag.com" : str2);
    }

    public final String getNotify() {
        return this.notify;
    }

    public final String getSessions() {
        return this.sessions;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), other == null ? null : other.getClass())) {
            return false;
        }
        if (other != null) {
            EndpointConfiguration endpointConfiguration = (EndpointConfiguration) other;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.notify, endpointConfiguration.notify) && kotlin.jvm.internal.Intrinsics.areEqual(this.sessions, endpointConfiguration.sessions);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.bugsnag.android.EndpointConfiguration");
    }

    public int hashCode() {
        return (this.notify.hashCode() * 31) + this.sessions.hashCode();
    }
}

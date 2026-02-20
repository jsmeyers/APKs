package com.bugsnag.android;

/* JADX INFO: compiled from: ConnectivityCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/bugsnag/android/Connectivity;", "", "hasNetworkConnection", "", "registerForNetworkChanges", "", "retrieveNetworkAccessState", "", "unregisterForNetworkChanges", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Connectivity {
    boolean hasNetworkConnection();

    void registerForNetworkChanges();

    String retrieveNetworkAccessState();

    void unregisterForNetworkChanges();
}

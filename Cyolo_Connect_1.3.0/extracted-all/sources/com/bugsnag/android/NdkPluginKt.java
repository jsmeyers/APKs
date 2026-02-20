package com.bugsnag.android;

/* JADX INFO: compiled from: NdkPlugin.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"ndkPlugin", "Lcom/bugsnag/android/NdkPlugin;", "Lcom/bugsnag/android/Client;", "getNdkPlugin", "(Lcom/bugsnag/android/Client;)Lcom/bugsnag/android/NdkPlugin;", "bugsnag-plugin-android-ndk_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class NdkPluginKt {
    public static final NdkPlugin getNdkPlugin(Client client) {
        return (NdkPlugin) client.getPlugin(NdkPlugin.class);
    }
}

package com.bugsnag.android.ndk;

import com.bugsnag.android.Bugsnag;
import com.bugsnag.android.NdkPlugin;
import com.bugsnag.android.NdkPluginKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: BugsnagNDK.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/bugsnag/android/ndk/BugsnagNDK;", "", "()V", "refreshSymbolTable", "", "bugsnag-plugin-android-ndk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BugsnagNDK {
    public static final BugsnagNDK INSTANCE = new BugsnagNDK();

    private BugsnagNDK() {
    }

    @JvmStatic
    public static final void refreshSymbolTable() {
        NdkPlugin ndkPlugin;
        NativeBridge nativeBridge;
        if (!Bugsnag.isStarted() || (ndkPlugin = NdkPluginKt.getNdkPlugin(Bugsnag.getClient())) == null || (nativeBridge = ndkPlugin.getNativeBridge()) == null) {
            return;
        }
        nativeBridge.refreshSymbolTable();
    }
}

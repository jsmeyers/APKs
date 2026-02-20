package io.cyolo.android;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.net.IpPrefix;
import android.security.keystore.KeyGenParameterSpec;
import java.net.InetAddress;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ NotificationChannel m(Object obj) {
        return (NotificationChannel) obj;
    }

    public static /* synthetic */ NotificationChannel m(String str, CharSequence charSequence, int i) {
        return new NotificationChannel(str, charSequence, i);
    }

    public static /* synthetic */ NotificationChannelGroup m(String str, CharSequence charSequence) {
        return new NotificationChannelGroup(str, charSequence);
    }

    public static /* synthetic */ JobWorkItem m(Intent intent) {
        return new JobWorkItem(intent);
    }

    public static /* synthetic */ IpPrefix m(InetAddress inetAddress, int i) {
        return new IpPrefix(inetAddress, i);
    }

    public static /* synthetic */ KeyGenParameterSpec.Builder m(String str, int i) {
        return new KeyGenParameterSpec.Builder(str, i);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m365m() {
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m371m$1() {
    }

    /* JADX INFO: renamed from: m$2, reason: collision with other method in class */
    public static /* synthetic */ void m373m$2() {
    }

    public static /* synthetic */ void m$3() {
    }
}

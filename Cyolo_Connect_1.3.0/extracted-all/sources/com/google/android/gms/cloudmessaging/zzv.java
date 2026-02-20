package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzv {
    private final Context zza;
    private int zzb;
    private int zzc = 0;

    public zzv(Context context) {
        this.zza = context;
    }

    public final synchronized int zza() {
        PackageInfo packageInfo;
        if (this.zzb == 0) {
            try {
                packageInfo = Wrappers.packageManager(this.zza).getPackageInfo("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("Metadata", "Failed to find package ".concat(e.toString()));
                packageInfo = null;
            }
            if (packageInfo != null) {
                this.zzb = packageInfo.versionCode;
            }
        }
        return this.zzb;
    }

    /* JADX WARN: Found duplicated region for block: B:19:0x0046 A[Catch: all -> 0x0077, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x001d, B:12:0x0026, B:14:0x002d, B:16:0x003f, B:24:0x0060, B:19:0x0046, B:21:0x0059, B:27:0x0064, B:31:0x0073), top: B:37:0x0001 }] */
    /* JADX WARN: Found duplicated region for block: B:29:0x0071  */
    /* JADX WARN: Found duplicated region for block: B:30:0x0072  */
    public final synchronized int zzb() {
        List<ResolveInfo> listQueryBroadcastReceivers;
        int i = this.zzc;
        if (i != 0) {
            return i;
        }
        Context context = this.zza;
        PackageManager packageManager = context.getPackageManager();
        if (Wrappers.packageManager(context).checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return 0;
        }
        int i2 = 1;
        if (PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.iid.TOKEN_REQUEST");
            intent.setPackage("com.google.android.gms");
            listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
            if (listQueryBroadcastReceivers != null) {
            }
            Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
            if (true != PlatformVersion.isAtLeastO()) {
                i2 = 2;
            }
            this.zzc = i2;
            return i2;
        }
        Intent intent2 = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent2, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            Intent intent3 = new Intent("com.google.iid.TOKEN_REQUEST");
            intent3.setPackage("com.google.android.gms");
            listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent3, 0);
            if (listQueryBroadcastReceivers != null || listQueryBroadcastReceivers.isEmpty()) {
                Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
                if (true != PlatformVersion.isAtLeastO()) {
                    i2 = 2;
                }
                this.zzc = i2;
                return i2;
            }
            i2 = 2;
        }
        this.zzc = i2;
        return i2;
    }
}

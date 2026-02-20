package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.RemoteException;
import android.os.storage.StorageManager;

/* JADX INFO: compiled from: ContextExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0001¢\u0006\u0002\b\u0003\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0001¢\u0006\u0002\b\u0006\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0002H\u0001\u001a\u0013\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u0002H\u0001¢\u0006\u0002\b\u000b\u001a.\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0001\u001a$\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0006\b\u0000\u0010\u0015\u0018\u0001*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0082\b¢\u0006\u0002\u0010\u0018\u001a\"\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0000¨\u0006\u001b"}, d2 = {"getActivityManager", "Landroid/app/ActivityManager;", "Landroid/content/Context;", "getActivityManagerFrom", "getConnectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManagerFrom", "getLocationManager", "Landroid/location/LocationManager;", "getStorageManager", "Landroid/os/storage/StorageManager;", "getStorageManagerFrom", "registerReceiverSafe", "Landroid/content/Intent;", "receiver", "Landroid/content/BroadcastReceiver;", "filter", "Landroid/content/IntentFilter;", "logger", "Lcom/bugsnag/android/Logger;", "safeGetSystemService", "T", "name", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;", "unregisterReceiverSafe", "", "bugsnag-android-core_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ContextExtensionsKt {
    public static /* synthetic */ Intent registerReceiverSafe$default(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Logger logger, int i, Object obj) {
        if ((i & 4) != 0) {
            logger = null;
        }
        return registerReceiverSafe(context, broadcastReceiver, intentFilter, logger);
    }

    public static final Intent registerReceiverSafe(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Logger logger) {
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                return context.registerReceiver(broadcastReceiver, intentFilter, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (RemoteException e) {
            if (logger == null) {
                return null;
            }
            logger.w("Failed to register receiver", e);
            return null;
        } catch (IllegalArgumentException e2) {
            if (logger == null) {
                return null;
            }
            logger.w("Failed to register receiver", e2);
            return null;
        } catch (SecurityException e3) {
            if (logger == null) {
                return null;
            }
            logger.w("Failed to register receiver", e3);
            return null;
        }
    }

    public static /* synthetic */ void unregisterReceiverSafe$default(Context context, BroadcastReceiver broadcastReceiver, Logger logger, int i, Object obj) {
        if ((i & 2) != 0) {
            logger = null;
        }
        unregisterReceiverSafe(context, broadcastReceiver, logger);
    }

    public static final void unregisterReceiverSafe(Context context, BroadcastReceiver broadcastReceiver, Logger logger) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (RemoteException e) {
            if (logger == null) {
                return;
            }
            logger.w("Failed to register receiver", e);
        } catch (IllegalArgumentException e2) {
            if (logger == null) {
                return;
            }
            logger.w("Failed to register receiver", e2);
        } catch (SecurityException e3) {
            if (logger == null) {
                return;
            }
            logger.w("Failed to register receiver", e3);
        }
    }

    private static final /* synthetic */ <T> T safeGetSystemService(Context context, String str) {
        try {
            T t = (T) context.getSystemService(str);
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(2, "T");
            return t;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static final ActivityManager getActivityManagerFrom(Context context) {
        try {
            Object systemService = context.getSystemService("activity");
            if (!(systemService instanceof ActivityManager)) {
                systemService = null;
            }
            return (ActivityManager) systemService;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static final ConnectivityManager getConnectivityManagerFrom(Context context) {
        try {
            Object systemService = context.getSystemService("connectivity");
            if (!(systemService instanceof ConnectivityManager)) {
                systemService = null;
            }
            return (ConnectivityManager) systemService;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static final StorageManager getStorageManagerFrom(Context context) {
        try {
            Object systemService = context.getSystemService("storage");
            if (!(systemService instanceof StorageManager)) {
                systemService = null;
            }
            return (StorageManager) systemService;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static final LocationManager getLocationManager(Context context) {
        try {
            Object systemService = context.getSystemService("location");
            if (!(systemService instanceof LocationManager)) {
                systemService = null;
            }
            return (LocationManager) systemService;
        } catch (RuntimeException unused) {
            return null;
        }
    }
}

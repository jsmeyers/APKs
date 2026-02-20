package io.cyolo.android;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CyoloTunnelService {
    public static final String ACTION_POLICY_CHANGE = "io.cyolo.action.POLICY_CHANGE";
    public static final String ACTION_START = "io.cyolo.android.action.START";
    public static final String ACTION_STOP = "io.cyolo.action.STOP";

    public static void startTunnel(Context context) {
        connect(context, CyoloVpnService.class);
    }

    public static void stopTunnel(Context context) {
        disconnect(context, CyoloVpnService.class);
    }

    public static void connect(Context context, Class<? extends Service> cls) {
        Intent action = getServiceIntent(context, cls).setAction(ACTION_START);
        Timber.i("Starting CyoloVpnService from CyoloTunnelService", new Object[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            Timber.d("Starting foreground service", new Object[0]);
            context.startForegroundService(action);
        } else {
            context.startService(action);
        }
    }

    public static void disconnect(Context context, Class<? extends Service> cls) {
        context.startService(getServiceIntent(context, cls).setAction(ACTION_STOP));
    }

    private static Intent getServiceIntent(Context context, Class<? extends Service> cls) {
        return new Intent(context, cls);
    }
}

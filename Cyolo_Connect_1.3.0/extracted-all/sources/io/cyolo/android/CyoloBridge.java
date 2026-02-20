package io.cyolo.android;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;
import timber.log.Timber;

/* JADX INFO: compiled from: CyoloBridge.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lio/cyolo/android/CyoloBridge;", "", "()V", "Companion", "CyoloBridgeException", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CyoloBridge {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Context appContext;

    @JvmStatic
    public static final void policyChangeCallback() {
        INSTANCE.policyChangeCallback();
    }

    /* JADX INFO: compiled from: CyoloBridge.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0086 J\t\u0010\u000b\u001a\u00020\fH\u0086 J\t\u0010\r\u001a\u00020\nH\u0086 J\t\u0010\u000e\u001a\u00020\u000fH\u0086 J\t\u0010\u0010\u001a\u00020\u000fH\u0086 J\t\u0010\u0011\u001a\u00020\u000fH\u0086 J\t\u0010\u0012\u001a\u00020\u000fH\u0086 J\t\u0010\u0013\u001a\u00020\fH\u0086 J\t\u0010\u0014\u001a\u00020\fH\u0086 J)\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086 J\t\u0010\u001b\u001a\u00020\nH\u0086 J\u0011\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086 J\b\u0010\u001f\u001a\u00020\nH\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Lio/cyolo/android/CyoloBridge$Companion;", "", "()V", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "Close", "", "Configure", "", "Disconnect", "GetDNSAddress", "", "GetDNSResolvers", "GetRoutes", "GetTunnelAddress", "IsLoggedIn", "IsReady", "LoginWithToken", "loginURL", ResponseTypeValues.TOKEN, "tokenType", "expiresOn", "", "StartServices", "TunnelOpen", "fd", "", "policyChangeCallback", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final native void Close();

        public final native boolean Configure() throws CyoloBridgeException;

        public final native void Disconnect();

        public final native String GetDNSAddress();

        public final native String GetDNSResolvers();

        public final native String GetRoutes();

        public final native String GetTunnelAddress();

        public final native boolean IsLoggedIn();

        public final native boolean IsReady() throws CyoloBridgeException;

        public final native boolean LoginWithToken(String loginURL, String token, String tokenType, long expiresOn) throws CyoloBridgeException;

        public final native void StartServices();

        public final native boolean TunnelOpen(int fd) throws CyoloBridgeException;

        private Companion() {
        }

        public final Context getAppContext() {
            return CyoloBridge.appContext;
        }

        public final void setAppContext(Context context) {
            CyoloBridge.appContext = context;
        }

        @JvmStatic
        public final void policyChangeCallback() {
            Timber.INSTANCE.d("policyChangeCallback called", new Object[0]);
            Context appContext = getAppContext();
            if (appContext != null) {
                appContext.startService(new Intent(getAppContext(), (Class<?>) CyoloVpnService.class).setAction(CyoloTunnelService.ACTION_POLICY_CHANGE));
            }
        }
    }

    public CyoloBridge() {
        System.loadLibrary("libcyolo");
    }

    /* JADX INFO: compiled from: CyoloBridge.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/cyolo/android/CyoloBridge$CyoloBridgeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class CyoloBridgeException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CyoloBridgeException(String message) {
            super(message);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }
}

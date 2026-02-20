package androidx.tracing;

import android.app.Notification;
import android.media.AudioFocusRequest;
import android.media.session.MediaSessionManager;
import android.security.keystore.KeyGenParameterSpec;
import android.webkit.TracingConfig;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Trace$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ Notification.DecoratedMediaCustomViewStyle m() {
        return new Notification.DecoratedMediaCustomViewStyle();
    }

    public static /* synthetic */ AudioFocusRequest.Builder m(int i) {
        return new AudioFocusRequest.Builder(i);
    }

    public static /* synthetic */ MediaSessionManager.RemoteUserInfo m(String str, int i, int i2) {
        return new MediaSessionManager.RemoteUserInfo(str, i, i2);
    }

    public static /* synthetic */ KeyGenParameterSpec.Builder m(String str, int i) {
        return new KeyGenParameterSpec.Builder(str, i);
    }

    public static /* bridge */ /* synthetic */ KeyGenParameterSpec m(Object obj) {
        return (KeyGenParameterSpec) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ TracingConfig.Builder m181m() {
        return new TracingConfig.Builder();
    }

    public static /* synthetic */ WebMessage m(String str, WebMessagePort[] webMessagePortArr) {
        return new WebMessage(str, webMessagePortArr);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m192m() {
    }

    public static /* synthetic */ void m$1() {
    }
}

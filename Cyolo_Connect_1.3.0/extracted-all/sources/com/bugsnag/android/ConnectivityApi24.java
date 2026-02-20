package com.bugsnag.android;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.core.os.EnvironmentCompat;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ConnectivityCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0015BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012>\u0010\u0004\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005j\u0004\u0018\u0001`\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bugsnag/android/ConnectivityApi24;", "Lcom/bugsnag/android/Connectivity;", "cm", "Landroid/net/ConnectivityManager;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "hasConnection", "", "networkState", "", "Lcom/bugsnag/android/NetworkChangeCallback;", "(Landroid/net/ConnectivityManager;Lkotlin/jvm/functions/Function2;)V", "networkCallback", "Lcom/bugsnag/android/ConnectivityApi24$ConnectivityTrackerCallback;", "hasNetworkConnection", "registerForNetworkChanges", "retrieveNetworkAccessState", "unregisterForNetworkChanges", "ConnectivityTrackerCallback", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ConnectivityApi24 implements Connectivity {
    private final ConnectivityManager cm;
    private final ConnectivityTrackerCallback networkCallback;

    public ConnectivityApi24(ConnectivityManager connectivityManager, Function2<? super Boolean, ? super String, Unit> function2) {
        this.cm = connectivityManager;
        this.networkCallback = new ConnectivityTrackerCallback(function2);
    }

    @Override // com.bugsnag.android.Connectivity
    public void registerForNetworkChanges() {
        this.cm.registerDefaultNetworkCallback(this.networkCallback);
    }

    @Override // com.bugsnag.android.Connectivity
    public void unregisterForNetworkChanges() {
        this.cm.unregisterNetworkCallback(this.networkCallback);
    }

    @Override // com.bugsnag.android.Connectivity
    public boolean hasNetworkConnection() {
        return this.cm.getActiveNetwork() != null;
    }

    @Override // com.bugsnag.android.Connectivity
    public String retrieveNetworkAccessState() {
        Network activeNetwork = this.cm.getActiveNetwork();
        NetworkCapabilities networkCapabilities = activeNetwork != null ? this.cm.getNetworkCapabilities(activeNetwork) : null;
        return networkCapabilities == null ? "none" : networkCapabilities.hasTransport(1) ? "wifi" : networkCapabilities.hasTransport(3) ? "ethernet" : networkCapabilities.hasTransport(0) ? "cellular" : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    /* JADX INFO: compiled from: ConnectivityCompat.kt */
    @kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BE\u0012>\u0010\u0002\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016RF\u0010\u0002\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bugsnag/android/ConnectivityApi24$ConnectivityTrackerCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "cb", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "hasConnection", "", "networkState", "", "Lcom/bugsnag/android/NetworkChangeCallback;", "(Lkotlin/jvm/functions/Function2;)V", "receivedFirstCallback", "Ljava/util/concurrent/atomic/AtomicBoolean;", "invokeNetworkCallback", "onAvailable", "network", "Landroid/net/Network;", "onUnavailable", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ConnectivityTrackerCallback extends ConnectivityManager.NetworkCallback {
        private final Function2<Boolean, String, Unit> cb;
        private final AtomicBoolean receivedFirstCallback = new AtomicBoolean(false);

        /* JADX WARN: Multi-variable type inference failed */
        public ConnectivityTrackerCallback(Function2<? super Boolean, ? super String, Unit> function2) {
            this.cb = function2;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            invokeNetworkCallback(false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            invokeNetworkCallback(true);
        }

        private final void invokeNetworkCallback(boolean hasConnection) {
            Function2<Boolean, String, Unit> function2;
            if (!this.receivedFirstCallback.getAndSet(true) || (function2 = this.cb) == null) {
                return;
            }
            function2.invoke(Boolean.valueOf(hasConnection), UnknownConnectivity.INSTANCE.retrieveNetworkAccessState());
        }
    }
}

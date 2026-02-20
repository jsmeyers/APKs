package com.bugsnag.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ConnectivityCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001bBU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012>\u0010\u0006\u001a:\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\u0004\u0018\u0001`\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00060\u0016R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bugsnag/android/ConnectivityLegacy;", "Lcom/bugsnag/android/Connectivity;", "context", "Landroid/content/Context;", "cm", "Landroid/net/ConnectivityManager;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "hasConnection", "", "networkState", "", "Lcom/bugsnag/android/NetworkChangeCallback;", "(Landroid/content/Context;Landroid/net/ConnectivityManager;Lkotlin/jvm/functions/Function2;)V", "activeNetworkInfo", "Landroid/net/NetworkInfo;", "getActiveNetworkInfo", "()Landroid/net/NetworkInfo;", "changeReceiver", "Lcom/bugsnag/android/ConnectivityLegacy$ConnectivityChangeReceiver;", "hasNetworkConnection", "registerForNetworkChanges", "retrieveNetworkAccessState", "unregisterForNetworkChanges", "ConnectivityChangeReceiver", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ConnectivityLegacy implements Connectivity {
    private final ConnectivityChangeReceiver changeReceiver;
    private final ConnectivityManager cm;
    private final Context context;

    public ConnectivityLegacy(Context context, ConnectivityManager connectivityManager, Function2<? super Boolean, ? super String, Unit> function2) {
        this.context = context;
        this.cm = connectivityManager;
        this.changeReceiver = new ConnectivityChangeReceiver(function2);
    }

    private final NetworkInfo getActiveNetworkInfo() {
        try {
            return this.cm.getActiveNetworkInfo();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // com.bugsnag.android.Connectivity
    public void registerForNetworkChanges() {
        ContextExtensionsKt.registerReceiverSafe$default(this.context, this.changeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, 4, null);
    }

    @Override // com.bugsnag.android.Connectivity
    public void unregisterForNetworkChanges() {
        ContextExtensionsKt.unregisterReceiverSafe$default(this.context, this.changeReceiver, null, 2, null);
    }

    @Override // com.bugsnag.android.Connectivity
    public boolean hasNetworkConnection() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isConnectedOrConnecting();
    }

    @Override // com.bugsnag.android.Connectivity
    public String retrieveNetworkAccessState() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        Integer numValueOf = activeNetworkInfo == null ? null : Integer.valueOf(activeNetworkInfo.getType());
        return numValueOf == null ? "none" : numValueOf.intValue() == 1 ? "wifi" : numValueOf.intValue() == 9 ? "ethernet" : "cellular";
    }

    /* JADX INFO: compiled from: ConnectivityCompat.kt */
    @kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001BE\u0012>\u0010\u0002\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016RF\u0010\u0002\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bugsnag/android/ConnectivityLegacy$ConnectivityChangeReceiver;", "Landroid/content/BroadcastReceiver;", "cb", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "hasConnection", "", "networkState", "", "Lcom/bugsnag/android/NetworkChangeCallback;", "(Lcom/bugsnag/android/ConnectivityLegacy;Lkotlin/jvm/functions/Function2;)V", "receivedFirstCallback", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class ConnectivityChangeReceiver extends BroadcastReceiver {
        private final Function2<Boolean, String, Unit> cb;
        private final AtomicBoolean receivedFirstCallback = new AtomicBoolean(false);

        /* JADX WARN: Multi-variable type inference failed */
        public ConnectivityChangeReceiver(Function2<? super Boolean, ? super String, Unit> function2) {
            this.cb = function2;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Function2<Boolean, String, Unit> function2;
            if (!this.receivedFirstCallback.getAndSet(true) || (function2 = this.cb) == null) {
                return;
            }
            function2.invoke(Boolean.valueOf(ConnectivityLegacy.this.hasNetworkConnection()), ConnectivityLegacy.this.retrieveNetworkAccessState());
        }
    }
}

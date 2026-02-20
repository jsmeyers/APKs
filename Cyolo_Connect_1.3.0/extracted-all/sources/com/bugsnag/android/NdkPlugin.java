package com.bugsnag.android;

import com.bugsnag.android.ndk.NativeBridge;
import com.google.firebase.messaging.Constants;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NdkPlugin.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u000e\u001a\u00020\u000fH\u0082 J\t\u0010\u0010\u001a\u00020\u000fH\u0082 J\t\u0010\u0011\u001a\u00020\u0012H\u0082 J\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00150\u0014J\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00170\u0014J\u0006\u0010\u0018\u001a\u00020\u0019J\u001a\u0010\u001a\u001a\u00020\u000f2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00150\u0014J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0012J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0017J\u001a\u0010$\u001a\u00020\u000f2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020&0\u0014J\b\u0010'\u001a\u00020\u000fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bugsnag/android/NdkPlugin;", "Lcom/bugsnag/android/Plugin;", "()V", "client", "Lcom/bugsnag/android/Client;", "libraryLoader", "Lcom/bugsnag/android/LibraryLoader;", "<set-?>", "Lcom/bugsnag/android/ndk/NativeBridge;", "nativeBridge", "getNativeBridge", "()Lcom/bugsnag/android/ndk/NativeBridge;", "oneTimeSetupPerformed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "disableCrashReporting", "", "enableCrashReporting", "getBinaryArch", "", "getCurrentCallbackSetCounts", "", "", "getCurrentNativeApiCallUsage", "", "getSignalUnwindStackFunction", "", "initCallbackCounts", "counts", "initNativeBridge", "load", "notifyAddCallback", "callback", "notifyRemoveCallback", "performOneTimeSetup", "setInternalMetricsEnabled", "enabled", "setStaticData", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "unload", "Companion", "bugsnag-plugin-android-ndk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NdkPlugin implements Plugin {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final String LOAD_ERR_MSG = "Native library could not be linked. Bugsnag will not report NDK errors. See https://docs.bugsnag.com/platforms/android/ndk-link-errors";
    private Client client;
    private NativeBridge nativeBridge;
    private final LibraryLoader libraryLoader = new LibraryLoader();
    private final AtomicBoolean oneTimeSetupPerformed = new AtomicBoolean(false);

    private final native void disableCrashReporting();

    private final native void enableCrashReporting();

    private final native String getBinaryArch();

    /* JADX INFO: compiled from: NdkPlugin.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bugsnag/android/NdkPlugin$Companion;", "", "()V", "LOAD_ERR_MSG", "", "bugsnag-plugin-android-ndk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final NativeBridge getNativeBridge() {
        return this.nativeBridge;
    }

    private final NativeBridge initNativeBridge(Client client) {
        NativeBridge nativeBridge = new NativeBridge(client.bgTaskService);
        client.addObserver(nativeBridge);
        client.setupNdkPlugin();
        return nativeBridge;
    }

    @Override // com.bugsnag.android.Plugin
    public void load(Client client) {
        this.client = client;
        if (!this.oneTimeSetupPerformed.getAndSet(true)) {
            performOneTimeSetup(client);
        }
        if (this.libraryLoader.isLoaded()) {
            enableCrashReporting();
            client.logger.i("Initialised NDK Plugin");
        }
    }

    private final void performOneTimeSetup(Client client) {
        this.libraryLoader.loadLibrary("bugsnag-ndk", client, new OnErrorCallback() { // from class: com.bugsnag.android.NdkPlugin$$ExternalSyntheticLambda0
            @Override // com.bugsnag.android.OnErrorCallback
            public final boolean onError(Event event) {
                return NdkPlugin.m236performOneTimeSetup$lambda0(event);
            }
        });
        if (this.libraryLoader.isLoaded()) {
            client.setBinaryArch(getBinaryArch());
            this.nativeBridge = initNativeBridge(client);
        } else {
            client.logger.e(LOAD_ERR_MSG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: performOneTimeSetup$lambda-0, reason: not valid java name */
    public static final boolean m236performOneTimeSetup$lambda0(Event event) {
        Error error = event.getErrors().get(0);
        event.addMetadata("LinkError", "errorClass", error.getErrorClass());
        event.addMetadata("LinkError", "errorMessage", error.getErrorMessage());
        error.setErrorClass("NdkLinkError");
        error.setErrorMessage(LOAD_ERR_MSG);
        return true;
    }

    @Override // com.bugsnag.android.Plugin
    public void unload() {
        Client client;
        if (this.libraryLoader.isLoaded()) {
            disableCrashReporting();
            NativeBridge nativeBridge = this.nativeBridge;
            if (nativeBridge == null || (client = this.client) == null) {
                return;
            }
            client.removeObserver(nativeBridge);
        }
    }

    public final void setInternalMetricsEnabled(boolean enabled) {
        NativeBridge nativeBridge = this.nativeBridge;
        if (nativeBridge == null) {
            return;
        }
        nativeBridge.setInternalMetricsEnabled(enabled);
    }

    public final long getSignalUnwindStackFunction() {
        NativeBridge nativeBridge = this.nativeBridge;
        if (nativeBridge == null) {
            return 0L;
        }
        return nativeBridge.getSignalUnwindStackFunction();
    }

    public final Map<String, Integer> getCurrentCallbackSetCounts() {
        NativeBridge nativeBridge = this.nativeBridge;
        Map<String, Integer> currentCallbackSetCounts = nativeBridge == null ? null : nativeBridge.getCurrentCallbackSetCounts();
        return currentCallbackSetCounts == null ? MapsKt.emptyMap() : currentCallbackSetCounts;
    }

    public final Map<String, Boolean> getCurrentNativeApiCallUsage() {
        NativeBridge nativeBridge = this.nativeBridge;
        Map<String, Boolean> currentNativeApiCallUsage = nativeBridge == null ? null : nativeBridge.getCurrentNativeApiCallUsage();
        return currentNativeApiCallUsage == null ? MapsKt.emptyMap() : currentNativeApiCallUsage;
    }

    public final void initCallbackCounts(Map<String, Integer> counts) {
        NativeBridge nativeBridge = this.nativeBridge;
        if (nativeBridge == null) {
            return;
        }
        nativeBridge.initCallbackCounts(counts);
    }

    public final void notifyAddCallback(String callback) {
        NativeBridge nativeBridge = this.nativeBridge;
        if (nativeBridge == null) {
            return;
        }
        nativeBridge.notifyAddCallback(callback);
    }

    public final void notifyRemoveCallback(String callback) {
        NativeBridge nativeBridge = this.nativeBridge;
        if (nativeBridge == null) {
            return;
        }
        nativeBridge.notifyRemoveCallback(callback);
    }

    public final void setStaticData(Map<String, ? extends Object> data) {
        StringWriter stringWriter = new StringWriter();
        StringWriter stringWriter2 = stringWriter;
        try {
            JsonStream jsonStream = new JsonStream(stringWriter2);
            try {
                jsonStream.value(data);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(jsonStream, null);
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(stringWriter2, null);
                String string = stringWriter.toString();
                NativeBridge nativeBridge = this.nativeBridge;
                if (nativeBridge == null) {
                    return;
                }
                nativeBridge.setStaticJsonData(string);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(jsonStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(stringWriter2, th3);
                throw th4;
            }
        }
    }
}

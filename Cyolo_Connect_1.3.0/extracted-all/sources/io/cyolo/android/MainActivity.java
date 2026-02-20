package io.cyolo.android;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import androidx.biometric.BiometricManager;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scottyab.rootbeer.RootBeer;
import io.cyolo.android.CyoloBridge;
import io.cyolo.android.CyoloPreferences;
import io.cyolo.android.model.Network;
import io.cyolo.android.model.ProxyPolicy;
import io.cyolo.android.model.ServiceStatus;
import io.cyolo.android.model.Site;
import io.cyolo.android.model.Status;
import io.flutter.embedding.android.FlutterFragmentActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;
import timber.log.Timber;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J&\u0010\u0017\u001a\u00020\n2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\"\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0012\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020\nH\u0014J\u0018\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010,\u001a\u00020\nH\u0002J&\u0010-\u001a\u00020\n2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001e\u0010.\u001a\u00020\n2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019H\u0002J\u0010\u0010/\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J&\u00100\u001a\u00020\n2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lio/cyolo/android/MainActivity;", "Lio/flutter/embedding/android/FlutterFragmentActivity;", "()V", "attachEvent", "Lio/flutter/plugin/common/EventChannel$EventSink;", "gson", "Lcom/google/gson/Gson;", "serviceStatusReceiver", "Landroid/content/BroadcastReceiver;", "configureFlutterEngine", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "configureServiceStatusReceiver", "disconnectVpnService", "getDNSSearchDomains", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "getServiceStatus", "isVpnInterfaceActive", "", "isVpnServicePrepared", "isVpnServiceRunning", "login", "args", "", "", "", "notifyAboutServiceUpdate", NotificationCompat.CATEGORY_STATUS, "Lio/cyolo/android/model/ServiceStatus;", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDevicePostureMethodCall", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", "prepareVpnService", "setProxyPolicy", "showStatusUpdate", "startTunnel", "updateConfig", "Companion", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MainActivity extends FlutterFragmentActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static MethodChannel vpnMethodChannel;
    private EventChannel.EventSink attachEvent;
    private final Gson gson = new Gson();
    private BroadcastReceiver serviceStatusReceiver;

    private final boolean isVpnServicePrepared() {
        return true;
    }

    private final void prepareVpnService() {
    }

    public MainActivity() {
        System.loadLibrary("bridge");
    }

    @Override // io.flutter.embedding.android.FlutterFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.INSTANCE.plant(new Timber.DebugTree());
        CyoloBridge.INSTANCE.setAppContext(getApplicationContext());
    }

    private final void configureServiceStatusReceiver() {
        FlutterEngine flutterEngine = getFlutterEngine();
        new EventChannel(flutterEngine != null ? flutterEngine.getDartExecutor() : null, "io.cyolo.cyolo_vpn_state").setStreamHandler(new EventChannel.StreamHandler() { // from class: io.cyolo.android.MainActivity.configureServiceStatusReceiver.1
            @Override // io.flutter.plugin.common.EventChannel.StreamHandler
            public void onListen(Object args, EventChannel.EventSink events) {
                Intrinsics.checkNotNullParameter(events, "events");
                MainActivity.this.attachEvent = events;
            }

            @Override // io.flutter.plugin.common.EventChannel.StreamHandler
            public void onCancel(Object args) {
                MainActivity.this.attachEvent = null;
            }
        });
        this.serviceStatusReceiver = new BroadcastReceiver() { // from class: io.cyolo.android.MainActivity.configureServiceStatusReceiver.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Bundle extras;
                EventChannel.EventSink eventSink;
                if (intent == null || (extras = intent.getExtras()) == null || (eventSink = MainActivity.this.attachEvent) == null) {
                    return;
                }
                eventSink.success(extras.getString(MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE));
            }
        };
        IntentFilter intentFilter = new IntentFilter(MainActivityKt.INTENT_SERVICE_STATUS);
        if (Build.VERSION.SDK_INT >= 26) {
            registerReceiver(this.serviceStatusReceiver, intentFilter, 4);
        } else {
            registerReceiver(this.serviceStatusReceiver, intentFilter);
        }
    }

    @Override // io.flutter.embedding.android.FlutterFragmentActivity, io.flutter.embedding.android.FlutterEngineConfigurator
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "io.cyolo.cyolo_vpn");
        vpnMethodChannel = methodChannel;
        methodChannel.setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: io.cyolo.android.MainActivity$$ExternalSyntheticLambda3
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                MainActivity.configureFlutterEngine$lambda$1(this.f$0, methodCall, result);
            }
        });
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), MethodChannels.devicePosture).setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: io.cyolo.android.MainActivity$$ExternalSyntheticLambda4
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                this.f$0.onDevicePostureMethodCall(methodCall, result);
            }
        });
        configureServiceStatusReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void configureFlutterEngine$lambda$1(MainActivity this$0, MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = call.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1806924936:
                    if (str.equals("update_config")) {
                        this$0.updateConfig((Map) call.arguments(), result);
                        break;
                    }
                    break;
                case -1782449886:
                    if (str.equals("get_current_state")) {
                        this$0.getServiceStatus(result);
                        break;
                    }
                    break;
                case -1279552451:
                    if (str.equals("prepared")) {
                        result.success(Boolean.valueOf(this$0.isVpnServicePrepared()));
                        break;
                    }
                    break;
                case -318370553:
                    if (str.equals("prepare")) {
                        this$0.prepareVpnService();
                        result.success(true);
                        break;
                    }
                    break;
                case 103149417:
                    if (str.equals("login")) {
                        this$0.login((Map) call.arguments(), result);
                        break;
                    }
                    break;
                case 289284084:
                    if (str.equals("show_status_update")) {
                        result.success(true);
                        break;
                    }
                    break;
                case 530405532:
                    if (str.equals("disconnect")) {
                        this$0.disconnectVpnService();
                        result.success(true);
                        break;
                    }
                    break;
                case 951351530:
                    if (str.equals("connect")) {
                        this$0.startTunnel(result);
                        break;
                    }
                    break;
                case 989740256:
                    if (str.equals(MethodNames.setProxyPolicy)) {
                        this$0.setProxyPolicy((Map) call.arguments(), result);
                        break;
                    }
                    break;
                case 1278462516:
                    if (str.equals("getDNSSearchDomains")) {
                        this$0.getDNSSearchDomains(result);
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void onDevicePostureMethodCall(MethodCall call, MethodChannel.Result result) {
        String str = call.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1696813097:
                    if (str.equals(MethodNames.requestPasswordComplexityPermission)) {
                        if (Build.VERSION.SDK_INT < 29) {
                            result.success(true);
                            return;
                        }
                        z = ContextCompat.checkSelfPermission(this, "android.permission.REQUEST_PASSWORD_COMPLEXITY") == 0;
                        if (!z) {
                            ActivityCompat.requestPermissions(this, new String[]{"android.permission.REQUEST_PASSWORD_COMPLEXITY"}, 2);
                        }
                        result.success(Boolean.valueOf(z));
                        return;
                    }
                    break;
                case -1534323533:
                    if (str.equals(MethodNames.isBiometricEnabled)) {
                        BiometricManager biometricManagerFrom = BiometricManager.from(this);
                        Intrinsics.checkNotNullExpressionValue(biometricManagerFrom, "from(...)");
                        result.success(Boolean.valueOf(biometricManagerFrom.canAuthenticate(255) == 0));
                        return;
                    }
                    break;
                case -1107875961:
                    if (str.equals(MethodNames.getDeviceId)) {
                        result.success(Settings.Secure.getString(getContentResolver(), "android_id"));
                        return;
                    }
                    break;
                case -251277621:
                    if (str.equals(MethodNames.isRooted)) {
                        result.success(Boolean.valueOf(new RootBeer(this).isRooted()));
                        return;
                    }
                    break;
                case 904023545:
                    if (str.equals(MethodNames.requestDeviceAdminPermission)) {
                        ComponentName componentName = CyoloDeviceAdminReceiver.INSTANCE.getComponentName(this);
                        Object systemService = getSystemService("device_policy");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
                        if (((DevicePolicyManager) systemService).isAdminActive(componentName)) {
                            result.success(true);
                            return;
                        }
                        Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
                        intent.putExtra("android.app.extra.DEVICE_ADMIN", componentName);
                        startActivityForResult(intent, 3);
                        result.success(false);
                        return;
                    }
                    break;
                case 1231174900:
                    if (str.equals(MethodNames.getScreenLockTimeout)) {
                        result.success(Integer.valueOf(Settings.System.getInt(getContentResolver(), "screen_off_timeout")));
                        return;
                    }
                    break;
                case 1246391684:
                    if (str.equals(MethodNames.isDeviceEncrypted)) {
                        Object systemService2 = getSystemService("device_policy");
                        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
                        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) systemService2;
                        if (devicePolicyManager.getStorageEncryptionStatus() != 2 && devicePolicyManager.getStorageEncryptionStatus() != 1 && devicePolicyManager.getStorageEncryptionStatus() != 0) {
                            z = true;
                        }
                        result.success(Boolean.valueOf(z));
                        return;
                    }
                    break;
                case 1649463520:
                    if (str.equals(MethodNames.isScreenLocked)) {
                        Object systemService3 = getSystemService("keyguard");
                        Intrinsics.checkNotNull(systemService3, "null cannot be cast to non-null type android.app.KeyguardManager");
                        KeyguardManager keyguardManager = (KeyguardManager) systemService3;
                        result.success(Boolean.valueOf(Build.VERSION.SDK_INT >= 23 ? keyguardManager.isDeviceSecure() : keyguardManager.isKeyguardSecure()));
                        return;
                    }
                    break;
                case 1822063433:
                    if (str.equals(MethodNames.isPasswordProtected)) {
                        Object systemService4 = getSystemService("device_policy");
                        Intrinsics.checkNotNull(systemService4, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
                        DevicePolicyManager devicePolicyManager2 = (DevicePolicyManager) systemService4;
                        if (Build.VERSION.SDK_INT >= 29) {
                            result.success(Boolean.valueOf(devicePolicyManager2.getPasswordComplexity() >= 196608));
                            return;
                        }
                        ComponentName componentName2 = CyoloDeviceAdminReceiver.INSTANCE.getComponentName(this);
                        int passwordQuality = devicePolicyManager2.getPasswordQuality(componentName2);
                        devicePolicyManager2.setPasswordQuality(componentName2, 131072);
                        boolean zIsActivePasswordSufficient = devicePolicyManager2.isActivePasswordSufficient();
                        devicePolicyManager2.setPasswordQuality(componentName2, passwordQuality);
                        result.success(Boolean.valueOf(zIsActivePasswordSufficient));
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    @Override // io.flutter.embedding.android.FlutterFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1) {
            return;
        }
        if (resultCode == -1) {
            CyoloTunnelService.startTunnel(this);
        } else {
            if (resultCode != 0) {
                return;
            }
            Timber.INSTANCE.d("User cancelled VPN permission", new Object[0]);
            notifyAboutServiceUpdate(ServiceStatus.DISCONNECTED);
        }
    }

    private final void notifyAboutServiceUpdate(ServiceStatus status) {
        CyoloVpnService.INSTANCE.setStatus$app_cyoloRelease(status);
        Intent intent = new Intent(MainActivityKt.INTENT_SERVICE_STATUS);
        intent.putExtra(MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, status.name());
        sendBroadcast(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        unregisterReceiver(this.serviceStatusReceiver);
        super.onDestroy();
    }

    private final void login(Map<String, ? extends Object> args, MethodChannel.Result result) {
        String string;
        if (args == null) {
            result.error("SERVICE_NOT_LOADED", "No args passed", null);
            return;
        }
        Object obj = args.get("base_url");
        String string2 = obj != null ? obj.toString() : null;
        Object obj2 = args.get("login_url");
        String string3 = obj2 != null ? obj2.toString() : null;
        Object obj3 = args.get(ResponseTypeValues.TOKEN);
        String string4 = obj3 != null ? obj3.toString() : null;
        Object obj4 = args.get("token_type");
        String string5 = obj4 != null ? obj4.toString() : null;
        Object obj5 = args.get("expires_in");
        Long lValueOf = (obj5 == null || (string = obj5.toString()) == null) ? null : Long.valueOf(Long.parseLong(string));
        String str = string2;
        if (str == null || str.length() == 0) {
            result.error("SERVICE_NOT_LOADED", "Got empty baseUrl", null);
            return;
        }
        String str2 = string3;
        if (str2 == null || str2.length() == 0) {
            result.error("SERVICE_NOT_LOADED", "Got empty loginUrl", null);
            return;
        }
        String str3 = string4;
        if (str3 == null || str3.length() == 0) {
            result.error("SERVICE_NOT_LOADED", "Got empty token", null);
            return;
        }
        String str4 = string5;
        if (str4 == null || str4.length() == 0) {
            result.error("SERVICE_NOT_LOADED", "Got empty tokenType", null);
            return;
        }
        if (lValueOf != null && lValueOf.longValue() > 0) {
            WorkManager.getInstance(this).enqueueUniqueWork("access-expiration", ExistingWorkPolicy.REPLACE, new OneTimeWorkRequest.Builder(ExpiryWorker.class).setInitialDelay((lValueOf.longValue() * ((long) 1000)) - System.currentTimeMillis(), TimeUnit.MILLISECONDS).build());
        }
        CyoloPreferences.Companion companion = CyoloPreferences.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.setBaseUrl(applicationContext, string2);
        CyoloPreferences.Companion companion2 = CyoloPreferences.INSTANCE;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        companion2.setAuthorization(applicationContext2, string4);
        try {
            CyoloBridge.INSTANCE.StartServices();
            try {
                CyoloBridge.INSTANCE.LoginWithToken(string3, string4, string5, lValueOf != null ? lValueOf.longValue() : 0L);
                result.success(true);
            } catch (CyoloBridge.CyoloBridgeException e) {
                result.error("SERVICE_NOT_LOADED", "Error happened while logging in with Bridge", e.getMessage());
            }
        } catch (CyoloBridge.CyoloBridgeException e2) {
            result.error("SERVICE_NOT_LOADED", "Error happened while starting Bridge services", e2.getMessage());
        }
    }

    private final void updateConfig(Map<String, ? extends Object> args, MethodChannel.Result result) {
        Timber.INSTANCE.d("Parameters " + args, new Object[0]);
        if (args == null) {
            result.error("SERVICE_NOT_LOADED", "No args passed", null);
            return;
        }
        Type type = new TypeToken<List<? extends Site>>() { // from class: io.cyolo.android.MainActivity$updateConfig$sitesType$1
        }.getType();
        Type type2 = new TypeToken<List<? extends Network>>() { // from class: io.cyolo.android.MainActivity$updateConfig$networksType$1
        }.getType();
        List<Site> list = (List) this.gson.fromJson(String.valueOf(args.get("sites")), type);
        List<Network> list2 = (List) this.gson.fromJson(String.valueOf(args.get("networks")), type2);
        CyoloPreferences.Companion companion = CyoloPreferences.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        Intrinsics.checkNotNull(list2);
        companion.setNetworks(applicationContext, list2);
        CyoloPreferences.Companion companion2 = CyoloPreferences.INSTANCE;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        Intrinsics.checkNotNull(list);
        companion2.setSites(applicationContext2, list);
        result.success(true);
    }

    private final void startTunnel(MethodChannel.Result result) {
        MainActivity mainActivity = this;
        Intent intentPrepare = VpnService.prepare(mainActivity);
        if (intentPrepare != null) {
            startActivityForResult(intentPrepare, 1);
            result.success(true);
        } else {
            CyoloTunnelService.startTunnel(mainActivity);
            result.success(true);
        }
    }

    private final void disconnectVpnService() {
        CyoloTunnelService.stopTunnel(this);
    }

    private final void showStatusUpdate(Map<String, ? extends Object> args) {
        if (args == null || !args.containsKey(NotificationCompat.CATEGORY_STATUS)) {
            return;
        }
        Status.Companion companion = Status.INSTANCE;
        Object obj = args.get(NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        Status statusByNameIgnoreCaseOrNull = companion.byNameIgnoreCaseOrNull((String) obj);
        if (statusByNameIgnoreCaseOrNull != null) {
            MainActivity mainActivity = this;
            NotificationsHelper.INSTANCE.registerStatusChannel(mainActivity, null);
            NotificationsHelper.INSTANCE.createStatusNotification(mainActivity, statusByNameIgnoreCaseOrNull);
        }
    }

    private final void getServiceStatus(MethodChannel.Result result) {
        boolean zIsVpnServiceRunning = isVpnServiceRunning();
        boolean zIsVpnInterfaceActive = isVpnInterfaceActive();
        if (!zIsVpnServiceRunning || !zIsVpnInterfaceActive) {
            CyoloVpnService.INSTANCE.setStatus$app_cyoloRelease(ServiceStatus.DISCONNECTED);
        }
        result.success(CyoloVpnService.INSTANCE.getStatus().name());
    }

    private final boolean isVpnServiceRunning() {
        Object systemService = getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) systemService).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(CyoloVpnService.class.getName(), it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private final boolean isVpnInterfaceActive() {
        try {
            String strGetTunnelAddress = CyoloBridge.INSTANCE.GetTunnelAddress();
            return (strGetTunnelAddress.length() > 0) && !Intrinsics.areEqual(strGetTunnelAddress, "0.0.0.0");
        } catch (Exception e) {
            Timber.INSTANCE.d("Error checking VPN interface: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    private final void setProxyPolicy(Map<String, ? extends Object> args, MethodChannel.Result result) {
        boolean z = true;
        if (args == null) {
            result.success(true);
            return;
        }
        Object obj = args.get(ParamNames.policy);
        String string = obj != null ? obj.toString() : null;
        String str = string;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            CyoloPreferences.Companion companion = CyoloPreferences.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            companion.clearProxyPolicy(applicationContext);
            result.success(true);
            return;
        }
        ProxyPolicy proxyPolicy = (ProxyPolicy) this.gson.fromJson(string, new TypeToken<ProxyPolicy>() { // from class: io.cyolo.android.MainActivity$setProxyPolicy$proxyPolicyType$1
        }.getType());
        CyoloPreferences.Companion companion2 = CyoloPreferences.INSTANCE;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        Intrinsics.checkNotNull(proxyPolicy);
        companion2.setProxyPolicy(applicationContext2, proxyPolicy);
        result.success(true);
    }

    private final void getDNSSearchDomains(final MethodChannel.Result result) {
        try {
            MethodChannel methodChannel = vpnMethodChannel;
            if (methodChannel != null) {
                methodChannel.invokeMethod("getDNSSearchDomains", null, new MethodChannel.Result() { // from class: io.cyolo.android.MainActivity.getDNSSearchDomains.1
                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void success(Object domains) {
                        result.success(domains);
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void error(String errorCode, String errorMessage, Object errorDetails) {
                        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                        Timber.INSTANCE.e("Failed to get DNS search domains: " + errorCode + " - " + errorMessage, new Object[0]);
                        result.success(CollectionsKt.emptyList());
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void notImplemented() {
                        Timber.INSTANCE.w("getDNSSearchDomains not implemented in Flutter", new Object[0]);
                        result.success(CollectionsKt.emptyList());
                    }
                });
            }
        } catch (Exception e) {
            Timber.INSTANCE.e("Exception calling getDNSSearchDomains: " + e.getMessage(), e);
            result.success(CollectionsKt.emptyList());
        }
    }

    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/cyolo/android/MainActivity$Companion;", "", "()V", "vpnMethodChannel", "Lio/flutter/plugin/common/MethodChannel;", "getVpnMethodChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setVpnMethodChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MethodChannel getVpnMethodChannel() {
            return MainActivity.vpnMethodChannel;
        }

        public final void setVpnMethodChannel(MethodChannel methodChannel) {
            MainActivity.vpnMethodChannel = methodChannel;
        }
    }
}

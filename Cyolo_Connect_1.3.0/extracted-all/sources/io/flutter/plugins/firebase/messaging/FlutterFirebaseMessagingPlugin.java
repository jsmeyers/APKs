package io.flutter.plugins.firebase.messaging;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.messaging.FlutterFirebasePermissionManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseMessagingPlugin implements FlutterFirebasePlugin, MethodChannel.MethodCallHandler, PluginRegistry.NewIntentListener, FlutterPlugin, ActivityAware {
    private MethodChannel channel;
    private RemoteMessage initialMessage;
    private Map<String, Object> initialMessageNotification;
    private Activity mainActivity;
    FlutterFirebasePermissionManager permissionManager;
    private Observer<RemoteMessage> remoteMessageObserver;
    private Observer<String> tokenObserver;
    private final HashMap<String, Boolean> consumedInitialMessages = new HashMap<>();
    private final LiveData<RemoteMessage> liveDataRemoteMessage = FlutterFirebaseRemoteMessageLiveData.getInstance();
    private final LiveData<String> liveDataToken = FlutterFirebaseTokenLiveData.getInstance();

    private void initInstance(BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/firebase_messaging");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.permissionManager = new FlutterFirebasePermissionManager();
        this.remoteMessageObserver = new Observer() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.m407x60a054b4((RemoteMessage) obj);
            }
        };
        this.tokenObserver = new Observer() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.m408x9980b553((String) obj);
            }
        };
        this.liveDataRemoteMessage.observeForever(this.remoteMessageObserver);
        this.liveDataToken.observeForever(this.tokenObserver);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_messaging", this);
    }

    /* JADX INFO: renamed from: lambda$initInstance$0$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin, reason: not valid java name */
    /* synthetic */ void m407x60a054b4(RemoteMessage remoteMessage) {
        this.channel.invokeMethod("Messaging#onMessage", FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage));
    }

    /* JADX INFO: renamed from: lambda$initInstance$1$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin, reason: not valid java name */
    /* synthetic */ void m408x9980b553(String str) {
        this.channel.invokeMethod("Messaging#onTokenRefresh", str);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.liveDataToken.removeObserver(this.tokenObserver);
        this.liveDataRemoteMessage.removeObserver(this.remoteMessageObserver);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addOnNewIntentListener(this);
        activityPluginBinding.addRequestPermissionsResultListener(this.permissionManager);
        Activity activity = activityPluginBinding.getActivity();
        this.mainActivity = activity;
        if (activity.getIntent() == null || this.mainActivity.getIntent().getExtras() == null || (this.mainActivity.getIntent().getFlags() & 1048576) == 1048576) {
            return;
        }
        onNewIntent(this.mainActivity.getIntent());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.mainActivity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addOnNewIntentListener(this);
        this.mainActivity = activityPluginBinding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.mainActivity = null;
    }

    private Task<Void> deleteToken() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.lambda$deleteToken$2(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$deleteToken$2(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(FirebaseMessaging.getInstance().deleteToken());
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Map<String, Object>> getToken() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m406x3d7973d3(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: renamed from: lambda$getToken$3$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin, reason: not valid java name */
    /* synthetic */ void m406x3d7973d3(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(new HashMap<String, Object>((String) Tasks.await(FirebaseMessaging.getInstance().getToken())) { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin.1
                final /* synthetic */ String val$token;

                {
                    this.val$token = str;
                    put(ResponseTypeValues.TOKEN, str);
                }
            });
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> subscribeToTopic(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.lambda$subscribeToTopic$4(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$subscribeToTopic$4(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map).subscribeToTopic((String) Objects.requireNonNull(map.get("topic"))));
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> unsubscribeFromTopic(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.lambda$unsubscribeFromTopic$5(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$unsubscribeFromTopic$5(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map).unsubscribeFromTopic((String) Objects.requireNonNull(map.get("topic"))));
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> sendMessage(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.lambda$sendMessage$6(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$sendMessage$6(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map).send(FlutterFirebaseMessagingUtils.getRemoteMessageForArguments(map));
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Map<String, Object>> setAutoInitEnabled(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m411x1419fe12(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: renamed from: lambda$setAutoInitEnabled$7$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin, reason: not valid java name */
    /* synthetic */ void m411x1419fe12(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingForArguments = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map);
            firebaseMessagingForArguments.setAutoInitEnabled(((Boolean) Objects.requireNonNull(map.get("enabled"))).booleanValue());
            taskCompletionSource.setResult(new HashMap<String, Object>(firebaseMessagingForArguments) { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin.2
                final /* synthetic */ FirebaseMessaging val$firebaseMessaging;

                {
                    this.val$firebaseMessaging = firebaseMessagingForArguments;
                    put("isAutoInitEnabled", Boolean.valueOf(firebaseMessagingForArguments.isAutoInitEnabled()));
                }
            });
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> setDeliveryMetricsExportToBigQuery(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.lambda$setDeliveryMetricsExportToBigQuery$8(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$setDeliveryMetricsExportToBigQuery$8(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map).setDeliveryMetricsExportToBigQuery(((Boolean) Objects.requireNonNull(map.get("enabled"))).booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Map<String, Object>> getInitialMessage() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m404x6a1ec711(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX WARN: Found duplicated region for block: B:33:0x0076 A[PHI: r0
      0x0076: PHI (r0v11 com.google.firebase.messaging.RemoteMessage) = (r0v8 com.google.firebase.messaging.RemoteMessage), (r0v13 com.google.firebase.messaging.RemoteMessage) binds: [B:29:0x0063, B:31:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: lambda$getInitialMessage$9$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin, reason: not valid java name */
    /* synthetic */ void m404x6a1ec711(TaskCompletionSource taskCompletionSource) {
        Map map;
        try {
            RemoteMessage remoteMessage = this.initialMessage;
            if (remoteMessage != null) {
                Map<String, Object> mapRemoteMessageToMap = FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage);
                Map<String, Object> map2 = this.initialMessageNotification;
                if (map2 != null) {
                    mapRemoteMessageToMap.put("notification", map2);
                }
                taskCompletionSource.setResult(mapRemoteMessageToMap);
                this.initialMessage = null;
                this.initialMessageNotification = null;
                return;
            }
            Activity activity = this.mainActivity;
            if (activity == null) {
                taskCompletionSource.setResult(null);
                return;
            }
            Intent intent = activity.getIntent();
            if (intent != null && intent.getExtras() != null) {
                String string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID);
                if (string == null) {
                    string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
                }
                if (string != null && this.consumedInitialMessages.get(string) == null) {
                    RemoteMessage remoteMessageForArguments = FlutterFirebaseMessagingReceiver.notifications.get(string);
                    if (remoteMessageForArguments == null) {
                        Map<String, Object> firebaseMessageMap = FlutterFirebaseMessagingStore.getInstance().getFirebaseMessageMap(string);
                        if (firebaseMessageMap != null) {
                            remoteMessageForArguments = FlutterFirebaseMessagingUtils.getRemoteMessageForArguments(firebaseMessageMap);
                            map = firebaseMessageMap.get("notification") != null ? (Map) firebaseMessageMap.get("notification") : null;
                        }
                        FlutterFirebaseMessagingStore.getInstance().removeFirebaseMessage(string);
                    } else {
                        map = null;
                    }
                    if (remoteMessageForArguments == null) {
                        taskCompletionSource.setResult(null);
                        return;
                    }
                    this.consumedInitialMessages.put(string, true);
                    Map<String, Object> mapRemoteMessageToMap2 = FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessageForArguments);
                    if (remoteMessageForArguments.getNotification() == null && map != null) {
                        mapRemoteMessageToMap2.put("notification", map);
                    }
                    taskCompletionSource.setResult(mapRemoteMessageToMap2);
                    return;
                }
                taskCompletionSource.setResult(null);
                return;
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Map<String, Integer>> requestPermissions() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m410x7111fdcf(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: renamed from: lambda$requestPermissions$12$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin, reason: not valid java name */
    /* synthetic */ void m410x7111fdcf(final TaskCompletionSource taskCompletionSource) {
        final HashMap map = new HashMap();
        try {
            if (!checkPermissions().booleanValue()) {
                this.permissionManager.requestPermissions(this.mainActivity, new FlutterFirebasePermissionManager.RequestPermissionsSuccessCallback() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda11
                    @Override // io.flutter.plugins.firebase.messaging.FlutterFirebasePermissionManager.RequestPermissionsSuccessCallback
                    public final void onSuccess(int i) {
                        FlutterFirebaseMessagingPlugin.lambda$requestPermissions$10(map, taskCompletionSource, i);
                    }
                }, new ErrorCallback() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda12
                    @Override // io.flutter.plugins.firebase.messaging.ErrorCallback
                    public final void onError(String str) {
                        taskCompletionSource.setException(new Exception(str));
                    }
                });
            } else {
                map.put("authorizationStatus", 1);
                taskCompletionSource.setResult(map);
            }
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    static /* synthetic */ void lambda$requestPermissions$10(Map map, TaskCompletionSource taskCompletionSource, int i) {
        map.put("authorizationStatus", Integer.valueOf(i));
        taskCompletionSource.setResult(map);
    }

    private Boolean checkPermissions() {
        return Boolean.valueOf(ContextHolder.getApplicationContext().checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0);
    }

    private Task<Map<String, Integer>> getPermissions() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m405x6f4ba4c7(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: renamed from: lambda$getPermissions$13$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin, reason: not valid java name */
    /* synthetic */ void m405x6f4ba4c7(TaskCompletionSource taskCompletionSource) {
        boolean zAreNotificationsEnabled;
        try {
            HashMap map = new HashMap();
            if (Build.VERSION.SDK_INT >= 33) {
                zAreNotificationsEnabled = checkPermissions().booleanValue();
            } else {
                zAreNotificationsEnabled = NotificationManagerCompat.from(this.mainActivity).areNotificationsEnabled();
            }
            map.put("authorizationStatus", Integer.valueOf(zAreNotificationsEnabled ? 1 : 0));
            taskCompletionSource.setResult(map);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        Task initialMessage;
        long jLongValue;
        long jLongValue2;
        String str = methodCall.method;
        str.hashCode();
        switch (str) {
            case "Messaging#getInitialMessage":
                initialMessage = getInitialMessage();
                break;
            case "Messaging#setAutoInitEnabled":
                initialMessage = setAutoInitEnabled((Map) methodCall.arguments());
                break;
            case "Messaging#deleteToken":
                initialMessage = deleteToken();
                break;
            case "Messaging#unsubscribeFromTopic":
                initialMessage = unsubscribeFromTopic((Map) methodCall.arguments());
                break;
            case "Messaging#subscribeToTopic":
                initialMessage = subscribeToTopic((Map) methodCall.arguments());
                break;
            case "Messaging#setDeliveryMetricsExportToBigQuery":
                initialMessage = setDeliveryMetricsExportToBigQuery((Map) methodCall.arguments());
                break;
            case "Messaging#startBackgroundIsolate":
                Map map = (Map) methodCall.arguments;
                Object obj = map.get("pluginCallbackHandle");
                Object obj2 = map.get("userCallbackHandle");
                if (obj instanceof Long) {
                    jLongValue = ((Long) obj).longValue();
                } else if (obj instanceof Integer) {
                    jLongValue = Long.valueOf(((Integer) obj).intValue()).longValue();
                } else {
                    throw new IllegalArgumentException("Expected 'Long' or 'Integer' type for 'pluginCallbackHandle'.");
                }
                if (obj2 instanceof Long) {
                    jLongValue2 = ((Long) obj2).longValue();
                } else if (obj2 instanceof Integer) {
                    jLongValue2 = Long.valueOf(((Integer) obj2).intValue()).longValue();
                } else {
                    throw new IllegalArgumentException("Expected 'Long' or 'Integer' type for 'userCallbackHandle'.");
                }
                Activity activity = this.mainActivity;
                FlutterShellArgs flutterShellArgsFromIntent = activity != null ? FlutterShellArgs.fromIntent(activity.getIntent()) : null;
                FlutterFirebaseMessagingBackgroundService.setCallbackDispatcher(jLongValue);
                FlutterFirebaseMessagingBackgroundService.setUserCallbackHandle(jLongValue2);
                FlutterFirebaseMessagingBackgroundService.startBackgroundIsolate(jLongValue, flutterShellArgsFromIntent);
                initialMessage = Tasks.forResult(null);
                break;
            case "Messaging#sendMessage":
                initialMessage = sendMessage((Map) methodCall.arguments());
                break;
            case "Messaging#requestPermission":
                if (Build.VERSION.SDK_INT >= 33) {
                    initialMessage = requestPermissions();
                    break;
                } else {
                    initialMessage = getPermissions();
                    break;
                }
                break;
            case "Messaging#getNotificationSettings":
                initialMessage = getPermissions();
                break;
            case "Messaging#getToken":
                initialMessage = getToken();
                break;
            default:
                result.notImplemented();
                return;
        }
        initialMessage.addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda15
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.m409xbbae7b76(result, task);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onMethodCall$14$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin, reason: not valid java name */
    /* synthetic */ void m409xbbae7b76(MethodChannel.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
        } else {
            Exception exception = task.getException();
            result.error("firebase_messaging", exception != null ? exception.getMessage() : null, getExceptionDetails(exception));
        }
    }

    private Map<String, Object> getExceptionDetails(Exception exc) {
        HashMap map = new HashMap();
        map.put(ResponseTypeValues.CODE, EnvironmentCompat.MEDIA_UNKNOWN);
        if (exc != null) {
            map.put("message", exc.getMessage());
        } else {
            map.put("message", "An unknown error has occurred.");
        }
        return map;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.NewIntentListener
    public boolean onNewIntent(Intent intent) {
        Map<String, Object> remoteMessageNotificationForArguments;
        Map<String, Object> map;
        Map<String, Object> firebaseMessageMap;
        if (intent.getExtras() == null) {
            return false;
        }
        String string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID);
        if (string == null) {
            string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
        }
        if (string == null) {
            return false;
        }
        RemoteMessage remoteMessageForArguments = FlutterFirebaseMessagingReceiver.notifications.get(string);
        if (remoteMessageForArguments != null || (firebaseMessageMap = FlutterFirebaseMessagingStore.getInstance().getFirebaseMessageMap(string)) == null) {
            remoteMessageNotificationForArguments = null;
        } else {
            remoteMessageForArguments = FlutterFirebaseMessagingUtils.getRemoteMessageForArguments(firebaseMessageMap);
            remoteMessageNotificationForArguments = FlutterFirebaseMessagingUtils.getRemoteMessageNotificationForArguments(firebaseMessageMap);
        }
        if (remoteMessageForArguments == null) {
            return false;
        }
        this.initialMessage = remoteMessageForArguments;
        this.initialMessageNotification = remoteMessageNotificationForArguments;
        FlutterFirebaseMessagingReceiver.notifications.remove(string);
        Map<String, Object> mapRemoteMessageToMap = FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessageForArguments);
        if (remoteMessageForArguments.getNotification() == null && (map = this.initialMessageNotification) != null) {
            mapRemoteMessageToMap.put("notification", map);
        }
        this.channel.invokeMethod("Messaging#onMessageOpenedApp", mapRemoteMessageToMap);
        this.mainActivity.setIntent(intent);
        return true;
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(final FirebaseApp firebaseApp) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.lambda$getPluginConstantsForFirebaseApp$15(firebaseApp, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$getPluginConstantsForFirebaseApp$15(FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        try {
            HashMap map = new HashMap();
            if (firebaseApp.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                map.put("AUTO_INIT_ENABLED", Boolean.valueOf(FirebaseMessaging.getInstance().isAutoInitEnabled()));
            }
            taskCompletionSource.setResult(map);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                taskCompletionSource.setResult(null);
            }
        });
        return taskCompletionSource.getTask();
    }
}

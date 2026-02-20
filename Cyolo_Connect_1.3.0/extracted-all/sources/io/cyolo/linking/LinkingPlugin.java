package io.cyolo.linking;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LinkingPlugin.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001-B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00142\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001cH\u0016J\u001a\u0010$\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010%\u001a\u00020\u0012H\u0016J\u001c\u0010&\u001a\u00020\u00142\b\b\u0001\u0010'\u001a\u00020(2\b\b\u0001\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010,\u001a\u00020\u00142\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lio/cyolo/linking/LinkingPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "Lio/flutter/plugin/common/PluginRegistry$NewIntentListener;", "()V", "changeReceiver", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "initialIntent", "", "initialLink", "", "latestLink", "createChangeReceiver", "events", "Lio/flutter/plugin/common/EventChannel$EventSink;", "handleIntent", "", "intent", "Landroid/content/Intent;", "onAttachedToActivity", "activityPluginBinding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onCancel", "o", "", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "binding", "onListen", "eventSink", "onMethodCall", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onNewIntent", "onReattachedToActivityForConfigChanges", "Companion", "linking_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LinkingPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, EventChannel.StreamHandler, ActivityAware, PluginRegistry.NewIntentListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EVENTS_CHANNEL = "cyolo/events";
    private static final String MESSAGES_CHANNEL = "cyolo/messages";
    private BroadcastReceiver changeReceiver;
    private Context context;
    private boolean initialIntent = true;
    private String initialLink;
    private String latestLink;

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleIntent(Context context, Intent intent) {
        String action = intent.getAction();
        String dataString = intent.getDataString();
        if (Intrinsics.areEqual("android.intent.action.VIEW", action)) {
            if (this.initialIntent) {
                this.initialLink = dataString;
                this.initialIntent = false;
            }
            this.latestLink = dataString;
            BroadcastReceiver broadcastReceiver = this.changeReceiver;
            if (broadcastReceiver == null || broadcastReceiver == null) {
                return;
            }
            broadcastReceiver.onReceive(context, intent);
        }
    }

    private final BroadcastReceiver createChangeReceiver(final EventChannel.EventSink events) {
        return new BroadcastReceiver() { // from class: io.cyolo.linking.LinkingPlugin.createChangeReceiver.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String dataString = intent.getDataString();
                if (dataString == null) {
                    events.error("UNAVAILABLE", "Link unavailable", null);
                } else {
                    events.success(dataString);
                }
            }
        };
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        this.context = flutterPluginBinding.getApplicationContext();
        Companion companion = INSTANCE;
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "getBinaryMessenger(...)");
        companion.register(binaryMessenger, this);
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object o, EventChannel.EventSink eventSink) {
        Intrinsics.checkNotNullParameter(eventSink, "eventSink");
        this.changeReceiver = createChangeReceiver(eventSink);
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object o) {
        this.changeReceiver = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        if (call.method.equals("getInitialLink")) {
            result.success(this.initialLink);
        } else if (call.method.equals("getLatestLink")) {
            result.success(this.latestLink);
        } else {
            result.notImplemented();
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.NewIntentListener
    public boolean onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        handleIntent(this.context, intent);
        return false;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "activityPluginBinding");
        activityPluginBinding.addOnNewIntentListener(this);
        Context context = this.context;
        Intent intent = activityPluginBinding.getActivity().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        handleIntent(context, intent);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "activityPluginBinding");
        activityPluginBinding.addOnNewIntentListener(this);
        Context context = this.context;
        Intent intent = activityPluginBinding.getActivity().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        handleIntent(context, intent);
    }

    /* JADX INFO: compiled from: LinkingPlugin.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/cyolo/linking/LinkingPlugin$Companion;", "", "()V", "EVENTS_CHANNEL", "", "MESSAGES_CHANNEL", "register", "", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "plugin", "Lio/cyolo/linking/LinkingPlugin;", "registerWith", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "linking_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void register(BinaryMessenger messenger, LinkingPlugin plugin) {
            new MethodChannel(messenger, LinkingPlugin.MESSAGES_CHANNEL).setMethodCallHandler(plugin);
            new EventChannel(messenger, LinkingPlugin.EVENTS_CHANNEL).setStreamHandler(plugin);
        }

        public final void registerWith(PluginRegistry.Registrar registrar) {
            Intrinsics.checkNotNullParameter(registrar, "registrar");
            if (registrar.activity() == null) {
                return;
            }
            LinkingPlugin linkingPlugin = new LinkingPlugin();
            linkingPlugin.context = registrar.context();
            BinaryMessenger binaryMessengerMessenger = registrar.messenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessengerMessenger, "messenger(...)");
            register(binaryMessengerMessenger, linkingPlugin);
            Context context = registrar.context();
            Activity activity = registrar.activity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            linkingPlugin.handleIntent(context, intent);
            registrar.addNewIntentListener(linkingPlugin);
        }
    }
}

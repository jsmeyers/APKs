package dev.fluttercommunity.workmanager;

import android.content.Context;
import dev.fluttercommunity.workmanager.WorkmanagerPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterNativeView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkmanagerPlugin.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkmanagerPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "methodChannel", "Lio/flutter/plugin/common/MethodChannel;", "workmanagerCallHandler", "Ldev/fluttercommunity/workmanager/WorkmanagerCallHandler;", "onAttachedToEngine", "", "context", "Landroid/content/Context;", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "Companion", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WorkmanagerPlugin implements FlutterPlugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static PluginRegistry.PluginRegistrantCallback pluginRegistryCallback;
    private MethodChannel methodChannel;
    private WorkmanagerCallHandler workmanagerCallHandler;

    @JvmStatic
    public static final void registerWith(PluginRegistry.Registrar registrar) {
        INSTANCE.registerWith(registrar);
    }

    @Deprecated(message = "Use the Android v2 embedding method.")
    @JvmStatic
    public static final void setPluginRegistrantCallback(PluginRegistry.PluginRegistrantCallback pluginRegistrantCallback) {
        INSTANCE.setPluginRegistrantCallback(pluginRegistrantCallback);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Context applicationContext = binding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "getBinaryMessenger(...)");
        onAttachedToEngine(applicationContext, binaryMessenger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAttachedToEngine(Context context, BinaryMessenger messenger) {
        this.workmanagerCallHandler = new WorkmanagerCallHandler(context);
        MethodChannel methodChannel = new MethodChannel(messenger, "be.tramckrijte.workmanager/foreground_channel_work_manager");
        this.methodChannel = methodChannel;
        methodChannel.setMethodCallHandler(this.workmanagerCallHandler);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        onDetachedFromEngine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDetachedFromEngine() {
        MethodChannel methodChannel = this.methodChannel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
        }
        this.methodChannel = null;
        this.workmanagerCallHandler = null;
    }

    /* JADX INFO: compiled from: WorkmanagerPlugin.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkmanagerPlugin$Companion;", "", "()V", "pluginRegistryCallback", "Lio/flutter/plugin/common/PluginRegistry$PluginRegistrantCallback;", "getPluginRegistryCallback", "()Lio/flutter/plugin/common/PluginRegistry$PluginRegistrantCallback;", "setPluginRegistryCallback", "(Lio/flutter/plugin/common/PluginRegistry$PluginRegistrantCallback;)V", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "setPluginRegistrantCallback", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PluginRegistry.PluginRegistrantCallback getPluginRegistryCallback() {
            return WorkmanagerPlugin.pluginRegistryCallback;
        }

        public final void setPluginRegistryCallback(PluginRegistry.PluginRegistrantCallback pluginRegistrantCallback) {
            WorkmanagerPlugin.pluginRegistryCallback = pluginRegistrantCallback;
        }

        @JvmStatic
        public final void registerWith(PluginRegistry.Registrar registrar) {
            Intrinsics.checkNotNullParameter(registrar, "registrar");
            final WorkmanagerPlugin workmanagerPlugin = new WorkmanagerPlugin();
            Context context = registrar.context();
            Intrinsics.checkNotNullExpressionValue(context, "context(...)");
            BinaryMessenger binaryMessengerMessenger = registrar.messenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessengerMessenger, "messenger(...)");
            workmanagerPlugin.onAttachedToEngine(context, binaryMessengerMessenger);
            registrar.addViewDestroyListener(new PluginRegistry.ViewDestroyListener() { // from class: dev.fluttercommunity.workmanager.WorkmanagerPlugin$Companion$$ExternalSyntheticLambda0
                @Override // io.flutter.plugin.common.PluginRegistry.ViewDestroyListener
                public final boolean onViewDestroy(FlutterNativeView flutterNativeView) {
                    return WorkmanagerPlugin.Companion.registerWith$lambda$0(workmanagerPlugin, flutterNativeView);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean registerWith$lambda$0(WorkmanagerPlugin plugin, FlutterNativeView it) {
            Intrinsics.checkNotNullParameter(plugin, "$plugin");
            Intrinsics.checkNotNullParameter(it, "it");
            plugin.onDetachedFromEngine();
            return false;
        }

        @Deprecated(message = "Use the Android v2 embedding method.")
        @JvmStatic
        public final void setPluginRegistrantCallback(PluginRegistry.PluginRegistrantCallback pluginRegistryCallback) {
            Intrinsics.checkNotNullParameter(pluginRegistryCallback, "pluginRegistryCallback");
            WorkmanagerPlugin.INSTANCE.setPluginRegistryCallback(pluginRegistryCallback);
        }
    }
}

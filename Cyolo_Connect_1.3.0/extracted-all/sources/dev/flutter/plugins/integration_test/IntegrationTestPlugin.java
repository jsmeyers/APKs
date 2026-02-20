package dev.flutter.plugins.integration_test;

import android.app.Activity;
import android.content.Context;
import com.google.common.util.concurrent.SettableFuture;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public class IntegrationTestPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {
    private static final String CHANNEL = "plugins.flutter.io/integration_test";
    public static final Future<Map<String, String>> testResults;
    private static final SettableFuture<Map<String, String>> testResultsSettable;
    private Activity flutterActivity;
    private MethodChannel methodChannel;

    static {
        SettableFuture<Map<String, String>> settableFutureCreate = SettableFuture.create();
        testResultsSettable = settableFutureCreate;
        testResults = settableFutureCreate;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new IntegrationTestPlugin().onAttachedToEngine(registrar.context(), registrar.messenger());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        onAttachedToEngine(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    private void onAttachedToEngine(Context context, BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, CHANNEL);
        this.methodChannel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.methodChannel.setMethodCallHandler(null);
        this.methodChannel = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.flutterActivity = activityPluginBinding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        this.flutterActivity = activityPluginBinding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.flutterActivity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.flutterActivity = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        switch (str) {
            case "captureScreenshot":
                if (FlutterDeviceScreenshot.hasInstrumentation()) {
                    try {
                        result.success(FlutterDeviceScreenshot.captureWithUiAutomation());
                    } catch (IOException e) {
                        result.error("Could not capture screenshot", "UiAutomation failed", e);
                        return;
                    }
                    break;
                } else {
                    Activity activity = this.flutterActivity;
                    if (activity == null) {
                        result.error("Could not capture screenshot", "Activity not initialized", null);
                    } else {
                        FlutterDeviceScreenshot.captureView(activity, this.methodChannel, result);
                    }
                    break;
                }
                break;
            case "convertFlutterSurfaceToImage":
                Activity activity2 = this.flutterActivity;
                if (activity2 == null) {
                    result.error("Could not convert to image", "Activity not initialized", null);
                    break;
                } else {
                    FlutterDeviceScreenshot.convertFlutterSurfaceToImage(activity2);
                    result.success(null);
                    break;
                }
                break;
            case "revertFlutterImage":
                Activity activity3 = this.flutterActivity;
                if (activity3 == null) {
                    result.error("Could not revert Flutter image", "Activity not initialized", null);
                    break;
                } else {
                    FlutterDeviceScreenshot.revertFlutterImage(activity3);
                    result.success(null);
                    break;
                }
                break;
            case "allTestsFinished":
                testResultsSettable.set((Map) methodCall.argument("results"));
                result.success(null);
                break;
            default:
                result.notImplemented();
                break;
        }
    }
}

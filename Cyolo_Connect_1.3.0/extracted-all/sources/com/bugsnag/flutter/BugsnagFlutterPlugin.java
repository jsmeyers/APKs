package com.bugsnag.flutter;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BugsnagFlutterPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private final BugsnagFlutter bugsnag;
    private MethodChannel channel;
    private final Map<String, BSGFunction<?>> functions = new HashMap();

    public BugsnagFlutterPlugin() {
        final BugsnagFlutter bugsnagFlutter = new BugsnagFlutter();
        this.bugsnag = bugsnagFlutter;
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("createEvent", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda0
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.createEvent((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("deliverEvent", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda2
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.deliverEvent((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("setUser", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda4
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.setUser((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("getUser", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda5
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.getUser((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("setContext", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda6
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.setContext((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("getContext", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda7
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.getContext((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("leaveBreadcrumb", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda8
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.leaveBreadcrumb((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("getBreadcrumbs", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda9
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.getBreadcrumbs((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("addFeatureFlags", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda10
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.addFeatureFlags((JSONArray) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("clearFeatureFlag", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda12
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.clearFeatureFlag((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("clearFeatureFlags", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda11
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.clearFeatureFlags((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("addMetadata", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda13
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.addMetadata((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("clearMetadata", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda14
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.clearMetadata((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("getMetadata", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda15
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.getMetadata((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("startSession", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda16
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.startSession((Void) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("pauseSession", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda17
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.pauseSession((Void) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("resumeSession", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda18
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.resumeSession((Void) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("markLaunchCompleted", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda19
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.markLaunchCompleted((Void) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("getLastRunInfo", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda20
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.getLastRunInfo((Void) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("attach", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda1
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.attach((JSONObject) obj);
            }
        });
        Objects.requireNonNull(bugsnagFlutter);
        addFunction("start", new BSGFunction() { // from class: com.bugsnag.flutter.BugsnagFlutterPlugin$$ExternalSyntheticLambda3
            @Override // com.bugsnag.flutter.BSGFunction
            public final Object invoke(Object obj) {
                return bugsnagFlutter.start((JSONObject) obj);
            }
        });
    }

    private <T> void addFunction(String str, BSGFunction<T> bSGFunction) {
        this.functions.put(str, bSGFunction);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.bugsnag.context = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.bugsnag/client", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        BSGFunction<?> bSGFunction = this.functions.get(methodCall.method);
        if (bSGFunction != null) {
            try {
                result.success(bSGFunction.invoke(methodCall.arguments()));
                return;
            } catch (Exception e) {
                result.error(e.getClass().getSimpleName(), e.getMessage(), e.getStackTrace());
                return;
            }
        }
        result.notImplemented();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.bugsnag.context = null;
        this.channel.setMethodCallHandler(null);
    }
}

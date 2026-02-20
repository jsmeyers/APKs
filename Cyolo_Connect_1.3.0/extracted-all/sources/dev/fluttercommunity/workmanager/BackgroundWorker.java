package dev.fluttercommunity.workmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.app.NotificationCompat;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.common.util.concurrent.ListenableFuture;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterCallbackInformation;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackgroundWorker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020 H\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u001bH\u0016J\u0012\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\f0\f0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Ldev/fluttercommunity/workmanager/BackgroundWorker;", "Landroidx/work/ListenableWorker;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "applicationContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "backgroundChannel", "Lio/flutter/plugin/common/MethodChannel;", "completer", "Landroidx/concurrent/futures/CallbackToFutureAdapter$Completer;", "Landroidx/work/ListenableWorker$Result;", "dartTask", "", "getDartTask", "()Ljava/lang/String;", "engine", "Lio/flutter/embedding/engine/FlutterEngine;", "isInDebug", "", "()Z", "payload", "getPayload", "randomThreadIdentifier", "", "resolvableFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "kotlin.jvm.PlatformType", "startTime", "", "onMethodCall", "", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", "r", "Lio/flutter/plugin/common/MethodChannel$Result;", "onStopped", "startWork", "stopEngine", "result", "Companion", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BackgroundWorker extends ListenableWorker implements MethodChannel.MethodCallHandler {
    public static final String BACKGROUND_CHANNEL_INITIALIZED = "backgroundChannelInitialized";
    public static final String BACKGROUND_CHANNEL_NAME = "be.tramckrijte.workmanager/background_channel_work_manager";
    public static final String DART_TASK_KEY = "be.tramckrijte.workmanager.DART_TASK";
    public static final String IS_IN_DEBUG_MODE_KEY = "be.tramckrijte.workmanager.IS_IN_DEBUG_MODE_KEY";
    public static final String PAYLOAD_KEY = "be.tramckrijte.workmanager.INPUT_DATA";
    public static final String TAG = "BackgroundWorker";
    private MethodChannel backgroundChannel;
    private CallbackToFutureAdapter.Completer<ListenableWorker.Result> completer;
    private FlutterEngine engine;
    private final int randomThreadIdentifier;
    private ListenableFuture<ListenableWorker.Result> resolvableFuture;
    private long startTime;
    private final WorkerParameters workerParams;
    private static final FlutterLoader flutterLoader = new FlutterLoader();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundWorker(Context applicationContext, WorkerParameters workerParams) {
        super(applicationContext, workerParams);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.workerParams = workerParams;
        this.randomThreadIdentifier = new Random().nextInt();
        ListenableFuture<ListenableWorker.Result> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: dev.fluttercommunity.workmanager.BackgroundWorker$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return BackgroundWorker.resolvableFuture$lambda$0(this.f$0, completer);
            }
        });
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        this.resolvableFuture = future;
    }

    private final String getPayload() {
        return this.workerParams.getInputData().getString(PAYLOAD_KEY);
    }

    private final String getDartTask() {
        String string = this.workerParams.getInputData().getString(DART_TASK_KEY);
        Intrinsics.checkNotNull(string);
        return string;
    }

    private final boolean isInDebug() {
        return this.workerParams.getInputData().getBoolean(IS_IN_DEBUG_MODE_KEY, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object resolvableFuture$lambda$0(BackgroundWorker this$0, CallbackToFutureAdapter.Completer completer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(completer, "completer");
        this$0.completer = completer;
        return null;
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        this.startTime = System.currentTimeMillis();
        this.engine = new FlutterEngine(getApplicationContext());
        FlutterLoader flutterLoader2 = flutterLoader;
        if (!flutterLoader2.initialized()) {
            flutterLoader2.startInitialization(getApplicationContext());
        }
        flutterLoader2.ensureInitializationCompleteAsync(getApplicationContext(), null, new Handler(Looper.getMainLooper()), new Runnable() { // from class: dev.fluttercommunity.workmanager.BackgroundWorker$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundWorker.startWork$lambda$2(this.f$0);
            }
        });
        return this.resolvableFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startWork$lambda$2(BackgroundWorker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SharedPreferenceHelper sharedPreferenceHelper = SharedPreferenceHelper.INSTANCE;
        Context applicationContext = this$0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        long callbackHandle = sharedPreferenceHelper.getCallbackHandle(applicationContext);
        FlutterCallbackInformation flutterCallbackInformationLookupCallbackInformation = FlutterCallbackInformation.lookupCallbackInformation(callbackHandle);
        String strFindAppBundlePath = flutterLoader.findAppBundlePath();
        Intrinsics.checkNotNullExpressionValue(strFindAppBundlePath, "findAppBundlePath(...)");
        if (this$0.isInDebug()) {
            DebugHelper debugHelper = DebugHelper.INSTANCE;
            Context applicationContext2 = this$0.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            debugHelper.postTaskStarting(applicationContext2, this$0.randomThreadIdentifier, this$0.getDartTask(), this$0.getPayload(), callbackHandle, flutterCallbackInformationLookupCallbackInformation, strFindAppBundlePath);
        }
        PluginRegistry.PluginRegistrantCallback pluginRegistryCallback = WorkmanagerPlugin.INSTANCE.getPluginRegistryCallback();
        if (pluginRegistryCallback != null) {
            FlutterEngine flutterEngine = this$0.engine;
            Intrinsics.checkNotNull(flutterEngine);
            pluginRegistryCallback.registerWith(new ShimPluginRegistry(flutterEngine));
        }
        FlutterEngine flutterEngine2 = this$0.engine;
        if (flutterEngine2 != null) {
            MethodChannel methodChannel = new MethodChannel(flutterEngine2.getDartExecutor(), BACKGROUND_CHANNEL_NAME);
            this$0.backgroundChannel = methodChannel;
            methodChannel.setMethodCallHandler(this$0);
            flutterEngine2.getDartExecutor().executeDartCallback(new DartExecutor.DartCallback(this$0.getApplicationContext().getAssets(), strFindAppBundlePath, flutterCallbackInformationLookupCallbackInformation));
        }
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        stopEngine(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopEngine(ListenableWorker.Result result) {
        CallbackToFutureAdapter.Completer<ListenableWorker.Result> completer;
        ListenableWorker.Result result2;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.startTime;
        if (isInDebug()) {
            DebugHelper debugHelper = DebugHelper.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            int i = this.randomThreadIdentifier;
            String dartTask = getDartTask();
            String payload = getPayload();
            if (result == null) {
                ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
                Intrinsics.checkNotNullExpressionValue(resultFailure, "failure(...)");
                result2 = resultFailure;
            } else {
                result2 = result;
            }
            debugHelper.postTaskCompleteNotification(applicationContext, i, dartTask, payload, jCurrentTimeMillis, result2);
        }
        if (result != null && (completer = this.completer) != null) {
            completer.set(result);
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: dev.fluttercommunity.workmanager.BackgroundWorker$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundWorker.stopEngine$lambda$3(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopEngine$lambda$3(BackgroundWorker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FlutterEngine flutterEngine = this$0.engine;
        if (flutterEngine != null) {
            flutterEngine.destroy();
        }
        this$0.engine = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result r) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(r, "r");
        if (Intrinsics.areEqual(call.method, BACKGROUND_CHANNEL_INITIALIZED)) {
            MethodChannel methodChannel = this.backgroundChannel;
            if (methodChannel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundChannel");
                methodChannel = null;
            }
            methodChannel.invokeMethod("onResultSend", MapsKt.mapOf(TuplesKt.to(DART_TASK_KEY, getDartTask()), TuplesKt.to(PAYLOAD_KEY, getPayload())), new MethodChannel.Result() { // from class: dev.fluttercommunity.workmanager.BackgroundWorker.onMethodCall.1
                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void notImplemented() {
                    BackgroundWorker.this.stopEngine(ListenableWorker.Result.failure());
                }

                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void error(String errorCode, String errorMessage, Object errorDetails) {
                    Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                    Log.e(BackgroundWorker.TAG, "errorCode: " + errorCode + ", errorMessage: " + errorMessage);
                    BackgroundWorker.this.stopEngine(ListenableWorker.Result.failure());
                }

                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void success(Object receivedResult) {
                    BackgroundWorker.this.stopEngine(receivedResult != null ? Intrinsics.areEqual((Object) receivedResult, (Object) true) : false ? ListenableWorker.Result.success() : ListenableWorker.Result.retry());
                }
            });
        }
    }
}

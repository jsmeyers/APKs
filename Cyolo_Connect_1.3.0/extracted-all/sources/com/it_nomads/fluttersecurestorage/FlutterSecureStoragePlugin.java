package com.it_nomads.fluttersecurestorage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import io.cyolo.android.MainActivityKt;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterSecureStoragePlugin implements MethodChannel.MethodCallHandler, FlutterPlugin {
    private static final String TAG = "FlutterSecureStoragePl";
    private MethodChannel channel;
    private FlutterSecureStorage secureStorage;
    private HandlerThread workerThread;
    private Handler workerThreadHandler;

    public void initInstance(BinaryMessenger binaryMessenger, Context context) {
        try {
            this.secureStorage = new FlutterSecureStorage(context);
            HandlerThread handlerThread = new HandlerThread("com.it_nomads.fluttersecurestorage.worker");
            this.workerThread = handlerThread;
            handlerThread.start();
            this.workerThreadHandler = new Handler(this.workerThread.getLooper());
            MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.it_nomads.com/flutter_secure_storage");
            this.channel = methodChannel;
            methodChannel.setMethodCallHandler(this);
        } catch (Exception e) {
            Log.e(TAG, "Registration failed", e);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        if (this.channel != null) {
            this.workerThread.quitSafely();
            this.workerThread = null;
            this.channel.setMethodCallHandler(null);
            this.channel = null;
        }
        this.secureStorage = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.workerThreadHandler.post(new MethodRunner(methodCall, new MethodResultWrapper(result)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getKeyFromCall(MethodCall methodCall) {
        return addPrefixToKey((String) ((Map) methodCall.arguments).get("key"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getValueFromCall(MethodCall methodCall) {
        return (String) ((Map) methodCall.arguments).get(MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE);
    }

    private String addPrefixToKey(String str) {
        return this.secureStorage.ELEMENT_PREFERENCES_KEY_PREFIX + "_" + str;
    }

    static class MethodResultWrapper implements MethodChannel.Result {
        private final Handler handler = new Handler(Looper.getMainLooper());
        private final MethodChannel.Result methodResult;

        MethodResultWrapper(MethodChannel.Result result) {
            this.methodResult = result;
        }

        /* JADX INFO: renamed from: lambda$success$0$com-it_nomads-fluttersecurestorage-FlutterSecureStoragePlugin$MethodResultWrapper, reason: not valid java name */
        /* synthetic */ void m343x9ec9761e(Object obj) {
            this.methodResult.success(obj);
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void success(final Object obj) {
            this.handler.post(new Runnable() { // from class: com.it_nomads.fluttersecurestorage.FlutterSecureStoragePlugin$MethodResultWrapper$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m343x9ec9761e(obj);
                }
            });
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void error(final String str, final String str2, final Object obj) {
            this.handler.post(new Runnable() { // from class: com.it_nomads.fluttersecurestorage.FlutterSecureStoragePlugin$MethodResultWrapper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m342xdfccd224(str, str2, obj);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$error$1$com-it_nomads-fluttersecurestorage-FlutterSecureStoragePlugin$MethodResultWrapper, reason: not valid java name */
        /* synthetic */ void m342xdfccd224(String str, String str2, Object obj) {
            this.methodResult.error(str, str2, obj);
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void notImplemented() {
            Handler handler = this.handler;
            final MethodChannel.Result result = this.methodResult;
            Objects.requireNonNull(result);
            handler.post(new Runnable() { // from class: com.it_nomads.fluttersecurestorage.FlutterSecureStoragePlugin$MethodResultWrapper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    result.notImplemented();
                }
            });
        }
    }

    class MethodRunner implements Runnable {
        private final MethodCall call;
        private final MethodChannel.Result result;

        MethodRunner(MethodCall methodCall, MethodChannel.Result result) {
            this.call = methodCall;
            this.result = result;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Found duplicated region for block: B:25:0x006d  */
        @Override // java.lang.Runnable
        public void run() {
            Exception e;
            boolean resetOnError;
            byte b = 0;
            try {
                try {
                    FlutterSecureStoragePlugin.this.secureStorage.options = (Map) ((Map) this.call.arguments).get("options");
                    resetOnError = FlutterSecureStoragePlugin.this.secureStorage.getResetOnError();
                } catch (Exception e2) {
                    e = e2;
                    resetOnError = false;
                }
                try {
                    String str = this.call.method;
                    switch (str.hashCode()) {
                        case -1335458389:
                            b = !str.equals("delete") ? (byte) -1 : (byte) 4;
                            break;
                        case -358737930:
                            if (str.equals("deleteAll")) {
                                b = 5;
                            }
                            break;
                        case 3496342:
                            if (str.equals("read")) {
                                b = 1;
                            }
                            break;
                        case 113399775:
                            if (!str.equals("write")) {
                            }
                            break;
                        case 208013248:
                            if (str.equals("containsKey")) {
                                b = 3;
                            }
                            break;
                        case 1080375339:
                            if (str.equals("readAll")) {
                                b = 2;
                            }
                            break;
                        default:
                            break;
                    }
                    if (b == 0) {
                        String keyFromCall = FlutterSecureStoragePlugin.this.getKeyFromCall(this.call);
                        String valueFromCall = FlutterSecureStoragePlugin.this.getValueFromCall(this.call);
                        if (valueFromCall != null) {
                            FlutterSecureStoragePlugin.this.secureStorage.write(keyFromCall, valueFromCall);
                            this.result.success(null);
                            return;
                        } else {
                            this.result.error("null", null, null);
                            return;
                        }
                    }
                    if (b == 1) {
                        String keyFromCall2 = FlutterSecureStoragePlugin.this.getKeyFromCall(this.call);
                        if (FlutterSecureStoragePlugin.this.secureStorage.containsKey(keyFromCall2)) {
                            this.result.success(FlutterSecureStoragePlugin.this.secureStorage.read(keyFromCall2));
                            return;
                        } else {
                            this.result.success(null);
                            return;
                        }
                    }
                    if (b == 2) {
                        this.result.success(FlutterSecureStoragePlugin.this.secureStorage.readAll());
                        return;
                    }
                    if (b == 3) {
                        this.result.success(Boolean.valueOf(FlutterSecureStoragePlugin.this.secureStorage.containsKey(FlutterSecureStoragePlugin.this.getKeyFromCall(this.call))));
                    } else if (b == 4) {
                        FlutterSecureStoragePlugin.this.secureStorage.delete(FlutterSecureStoragePlugin.this.getKeyFromCall(this.call));
                        this.result.success(null);
                    } else if (b == 5) {
                        FlutterSecureStoragePlugin.this.secureStorage.deleteAll();
                        this.result.success(null);
                    } else {
                        this.result.notImplemented();
                    }
                } catch (Exception e3) {
                    e = e3;
                    if (resetOnError) {
                        try {
                            FlutterSecureStoragePlugin.this.secureStorage.deleteAll();
                            this.result.success("Data has been reset");
                            return;
                        } catch (Exception e4) {
                            handleException(e4);
                            return;
                        }
                    }
                    handleException(e);
                }
            } catch (FileNotFoundException e5) {
                Log.i("Creating sharedPrefs", e5.getLocalizedMessage());
            }
        }

        private void handleException(Exception exc) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            this.result.error("Exception encountered", this.call.method, stringWriter.toString());
        }
    }
}

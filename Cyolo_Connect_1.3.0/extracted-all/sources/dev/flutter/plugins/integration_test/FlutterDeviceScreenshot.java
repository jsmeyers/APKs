package dev.flutter.plugins.integration_test;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Choreographer;
import android.view.PixelCopy;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.FlutterFragmentActivity;
import io.flutter.embedding.android.FlutterView;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class FlutterDeviceScreenshot {
    private static Handler backgroundHandler = null;
    private static boolean flutterSurfaceConvertedToImage = false;
    private static Handler mainHandler;

    static byte[] captureWithUiAutomation() throws IOException {
        return new byte[0];
    }

    static boolean hasInstrumentation() {
        return false;
    }

    FlutterDeviceScreenshot() {
    }

    public static FlutterView getFlutterView(Activity activity) {
        if (activity instanceof FlutterActivity) {
            return (FlutterView) activity.findViewById(FlutterActivity.FLUTTER_VIEW_ID);
        }
        if (activity instanceof FlutterFragmentActivity) {
            return (FlutterView) activity.findViewById(FlutterFragment.FLUTTER_VIEW_ID);
        }
        return null;
    }

    static void convertFlutterSurfaceToImage(Activity activity) {
        FlutterView flutterView = getFlutterView(activity);
        if (flutterView == null || flutterSurfaceConvertedToImage) {
            return;
        }
        flutterView.convertToImageView();
        flutterSurfaceConvertedToImage = true;
    }

    static void revertFlutterImage(Activity activity) {
        FlutterView flutterView = getFlutterView(activity);
        if (flutterView == null || !flutterSurfaceConvertedToImage) {
            return;
        }
        flutterView.revertImageView(new Runnable() { // from class: dev.flutter.plugins.integration_test.FlutterDeviceScreenshot$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                FlutterDeviceScreenshot.flutterSurfaceConvertedToImage = false;
            }
        });
    }

    static void captureView(Activity activity, MethodChannel methodChannel, MethodChannel.Result result) {
        FlutterView flutterView = getFlutterView(activity);
        if (flutterView == null) {
            result.error("Could not copy the pixels", "FlutterView is null", null);
            return;
        }
        if (!flutterSurfaceConvertedToImage) {
            result.error("Could not copy the pixels", "Flutter surface must be converted to image first", null);
            return;
        }
        methodChannel.invokeMethod("scheduleFrame", null);
        if (backgroundHandler == null) {
            HandlerThread handlerThread = new HandlerThread("screenshot");
            handlerThread.start();
            backgroundHandler = new Handler(handlerThread.getLooper());
        }
        if (mainHandler == null) {
            mainHandler = new Handler(Looper.getMainLooper());
        }
        takeScreenshot(backgroundHandler, mainHandler, flutterView, result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void waitForAndroidFrame(final Runnable runnable) {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: dev.flutter.plugins.integration_test.FlutterDeviceScreenshot.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                runnable.run();
            }
        });
    }

    private static void takeScreenshot(final Handler handler, final Handler handler2, final FlutterView flutterView, final MethodChannel.Result result) {
        final boolean zAcquireLatestImageViewFrame = flutterView.acquireLatestImageViewFrame();
        waitForAndroidFrame(new Runnable() { // from class: dev.flutter.plugins.integration_test.FlutterDeviceScreenshot$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                FlutterDeviceScreenshot.waitForAndroidFrame(new Runnable() { // from class: dev.flutter.plugins.integration_test.FlutterDeviceScreenshot$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlutterDeviceScreenshot.lambda$takeScreenshot$1(z, flutterView, result, handler, handler);
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$takeScreenshot$1(boolean z, FlutterView flutterView, MethodChannel.Result result, Handler handler, Handler handler2) {
        if (z) {
            convertViewToBitmap(flutterView, result, handler);
        } else {
            takeScreenshot(handler, handler2, flutterView, result);
        }
    }

    private static void convertViewToBitmap(FlutterView flutterView, final MethodChannel.Result result, Handler handler) {
        if (Build.VERSION.SDK_INT < 26) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(flutterView.getWidth(), flutterView.getHeight(), Bitmap.Config.RGB_565);
            flutterView.draw(new Canvas(bitmapCreateBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            result.success(byteArrayOutputStream.toByteArray());
            return;
        }
        final Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(flutterView.getWidth(), flutterView.getHeight(), Bitmap.Config.ARGB_8888);
        int[] iArr = new int[2];
        flutterView.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        PixelCopy.request(((Activity) flutterView.getContext()).getWindow(), new Rect(i, i2, flutterView.getWidth() + i, flutterView.getHeight() + i2), bitmapCreateBitmap2, new PixelCopy.OnPixelCopyFinishedListener() { // from class: dev.flutter.plugins.integration_test.FlutterDeviceScreenshot$$ExternalSyntheticLambda6
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i3) {
                FlutterDeviceScreenshot.lambda$convertViewToBitmap$5(bitmapCreateBitmap2, result, i3);
            }
        }, handler);
    }

    static /* synthetic */ void lambda$convertViewToBitmap$5(Bitmap bitmap, final MethodChannel.Result result, final int i) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (i == 0) {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            handler.post(new Runnable() { // from class: dev.flutter.plugins.integration_test.FlutterDeviceScreenshot$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    result.success(byteArrayOutputStream.toByteArray());
                }
            });
            return;
        }
        handler.post(new Runnable() { // from class: dev.flutter.plugins.integration_test.FlutterDeviceScreenshot$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                result.error("Could not copy the pixels", "result was " + i, null);
            }
        });
    }
}

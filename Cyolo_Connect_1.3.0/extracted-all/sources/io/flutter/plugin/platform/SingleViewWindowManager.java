package io.flutter.plugin.platform;

import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import io.flutter.Log;
import j$.util.function.Consumer;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
abstract class SingleViewWindowManager implements WindowManager {
    private static final String TAG = "PlatformViewsController";
    final WindowManager delegate;
    SingleViewFakeWindowViewGroup fakeWindowRootView;

    @Override // android.view.WindowManager
    public /* synthetic */ void addCrossWindowBlurEnabledListener(Executor executor, Consumer consumer) {
        addCrossWindowBlurEnabledListener(executor, Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // android.view.WindowManager
    public /* synthetic */ void addCrossWindowBlurEnabledListener(java.util.function.Consumer consumer) {
        addCrossWindowBlurEnabledListener(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // android.view.WindowManager
    public /* synthetic */ void removeCrossWindowBlurEnabledListener(java.util.function.Consumer consumer) {
        removeCrossWindowBlurEnabledListener(Consumer.VivifiedWrapper.convert(consumer));
    }

    SingleViewWindowManager(WindowManager windowManager, SingleViewFakeWindowViewGroup singleViewFakeWindowViewGroup) {
        this.delegate = windowManager;
        this.fakeWindowRootView = singleViewFakeWindowViewGroup;
    }

    @Override // android.view.WindowManager
    @Deprecated
    public Display getDefaultDisplay() {
        return this.delegate.getDefaultDisplay();
    }

    @Override // android.view.WindowManager
    public void removeViewImmediate(View view) {
        if (this.fakeWindowRootView == null) {
            Log.w(TAG, "Embedded view called removeViewImmediate while detached from presentation");
        } else {
            view.clearAnimation();
            this.fakeWindowRootView.removeView(view);
        }
    }

    @Override // android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        SingleViewFakeWindowViewGroup singleViewFakeWindowViewGroup = this.fakeWindowRootView;
        if (singleViewFakeWindowViewGroup == null) {
            Log.w(TAG, "Embedded view called addView while detached from presentation");
        } else {
            singleViewFakeWindowViewGroup.addView(view, layoutParams);
        }
    }

    @Override // android.view.ViewManager
    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        SingleViewFakeWindowViewGroup singleViewFakeWindowViewGroup = this.fakeWindowRootView;
        if (singleViewFakeWindowViewGroup == null) {
            Log.w(TAG, "Embedded view called updateViewLayout while detached from presentation");
        } else {
            singleViewFakeWindowViewGroup.updateViewLayout(view, layoutParams);
        }
    }

    @Override // android.view.ViewManager
    public void removeView(View view) {
        SingleViewFakeWindowViewGroup singleViewFakeWindowViewGroup = this.fakeWindowRootView;
        if (singleViewFakeWindowViewGroup == null) {
            Log.w(TAG, "Embedded view called removeView while detached from presentation");
        } else {
            singleViewFakeWindowViewGroup.removeView(view);
        }
    }

    @Override // android.view.WindowManager
    public WindowMetrics getCurrentWindowMetrics() {
        return this.delegate.getCurrentWindowMetrics();
    }

    @Override // android.view.WindowManager
    public WindowMetrics getMaximumWindowMetrics() {
        return this.delegate.getMaximumWindowMetrics();
    }

    @Override // android.view.WindowManager
    public boolean isCrossWindowBlurEnabled() {
        return this.delegate.isCrossWindowBlurEnabled();
    }

    public void addCrossWindowBlurEnabledListener(j$.util.function.Consumer<Boolean> consumer) {
        this.delegate.addCrossWindowBlurEnabledListener(Consumer.Wrapper.convert(consumer));
    }

    public void addCrossWindowBlurEnabledListener(Executor executor, j$.util.function.Consumer<Boolean> consumer) {
        this.delegate.addCrossWindowBlurEnabledListener(executor, Consumer.Wrapper.convert(consumer));
    }

    public void removeCrossWindowBlurEnabledListener(j$.util.function.Consumer<Boolean> consumer) {
        this.delegate.removeCrossWindowBlurEnabledListener(Consumer.Wrapper.convert(consumer));
    }
}

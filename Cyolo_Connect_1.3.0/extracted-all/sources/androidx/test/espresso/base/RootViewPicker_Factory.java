package androidx.test.espresso.base;

import androidx.test.espresso.UiController;
import androidx.test.espresso.base.RootViewPicker;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.internal.platform.os.ControlledLooper;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class RootViewPicker_Factory implements Factory<RootViewPicker> {
    private final Provider<ActivityLifecycleMonitor> activityLifecycleMonitorProvider;
    private final Provider<ControlledLooper> controlledLooperProvider;
    private final Provider<AtomicReference<Boolean>> needsActivityProvider;
    private final Provider<RootViewPicker.RootResultFetcher> rootResultFetcherProvider;
    private final Provider<UiController> uiControllerProvider;

    public RootViewPicker_Factory(Provider<UiController> uiControllerProvider, Provider<RootViewPicker.RootResultFetcher> rootResultFetcherProvider, Provider<ActivityLifecycleMonitor> activityLifecycleMonitorProvider, Provider<AtomicReference<Boolean>> needsActivityProvider, Provider<ControlledLooper> controlledLooperProvider) {
        this.uiControllerProvider = uiControllerProvider;
        this.rootResultFetcherProvider = rootResultFetcherProvider;
        this.activityLifecycleMonitorProvider = activityLifecycleMonitorProvider;
        this.needsActivityProvider = needsActivityProvider;
        this.controlledLooperProvider = controlledLooperProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public RootViewPicker get2() {
        return new RootViewPicker(this.uiControllerProvider.get2(), this.rootResultFetcherProvider.get2(), this.activityLifecycleMonitorProvider.get2(), this.needsActivityProvider.get2(), this.controlledLooperProvider.get2());
    }

    public static RootViewPicker_Factory create(Provider<UiController> uiControllerProvider, Provider<RootViewPicker.RootResultFetcher> rootResultFetcherProvider, Provider<ActivityLifecycleMonitor> activityLifecycleMonitorProvider, Provider<AtomicReference<Boolean>> needsActivityProvider, Provider<ControlledLooper> controlledLooperProvider) {
        return new RootViewPicker_Factory(uiControllerProvider, rootResultFetcherProvider, activityLifecycleMonitorProvider, needsActivityProvider, controlledLooperProvider);
    }

    public static RootViewPicker newInstance(UiController uiController, Object rootResultFetcher, ActivityLifecycleMonitor activityLifecycleMonitor, AtomicReference<Boolean> needsActivity, ControlledLooper controlledLooper) {
        return new RootViewPicker(uiController, (RootViewPicker.RootResultFetcher) rootResultFetcher, activityLifecycleMonitor, needsActivity, controlledLooper);
    }
}

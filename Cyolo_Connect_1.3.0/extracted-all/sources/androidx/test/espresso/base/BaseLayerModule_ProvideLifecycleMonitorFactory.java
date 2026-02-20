package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideLifecycleMonitorFactory implements Factory<ActivityLifecycleMonitor> {
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideLifecycleMonitorFactory(BaseLayerModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public ActivityLifecycleMonitor get2() {
        return provideLifecycleMonitor(this.module);
    }

    public static BaseLayerModule_ProvideLifecycleMonitorFactory create(BaseLayerModule module) {
        return new BaseLayerModule_ProvideLifecycleMonitorFactory(module);
    }

    public static ActivityLifecycleMonitor provideLifecycleMonitor(BaseLayerModule instance) {
        return (ActivityLifecycleMonitor) Preconditions.checkNotNull(instance.provideLifecycleMonitor(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

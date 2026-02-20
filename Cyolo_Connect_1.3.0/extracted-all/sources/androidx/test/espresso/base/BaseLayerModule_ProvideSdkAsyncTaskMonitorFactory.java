package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideSdkAsyncTaskMonitorFactory implements Factory<IdleNotifier<Runnable>> {
    private final Provider<ThreadPoolExecutorExtractor> extractorProvider;
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideSdkAsyncTaskMonitorFactory(BaseLayerModule module, Provider<ThreadPoolExecutorExtractor> extractorProvider) {
        this.module = module;
        this.extractorProvider = extractorProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public IdleNotifier<Runnable> get2() {
        return provideSdkAsyncTaskMonitor(this.module, this.extractorProvider.get2());
    }

    public static BaseLayerModule_ProvideSdkAsyncTaskMonitorFactory create(BaseLayerModule module, Provider<ThreadPoolExecutorExtractor> extractorProvider) {
        return new BaseLayerModule_ProvideSdkAsyncTaskMonitorFactory(module, extractorProvider);
    }

    public static IdleNotifier<Runnable> provideSdkAsyncTaskMonitor(BaseLayerModule instance, Object extractor) {
        return (IdleNotifier) Preconditions.checkNotNull(instance.provideSdkAsyncTaskMonitor((ThreadPoolExecutorExtractor) extractor), "Cannot return null from a non-@Nullable @Provides method");
    }
}

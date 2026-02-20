package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory implements Factory<IdleNotifier<Runnable>> {
    private final Provider<ThreadPoolExecutorExtractor> extractorProvider;
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory(BaseLayerModule module, Provider<ThreadPoolExecutorExtractor> extractorProvider) {
        this.module = module;
        this.extractorProvider = extractorProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public IdleNotifier<Runnable> get2() {
        return provideCompatAsyncTaskMonitor(this.module, this.extractorProvider.get2());
    }

    public static BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory create(BaseLayerModule module, Provider<ThreadPoolExecutorExtractor> extractorProvider) {
        return new BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory(module, extractorProvider);
    }

    public static IdleNotifier<Runnable> provideCompatAsyncTaskMonitor(BaseLayerModule instance, Object extractor) {
        return (IdleNotifier) Preconditions.checkNotNull(instance.provideCompatAsyncTaskMonitor((ThreadPoolExecutorExtractor) extractor), "Cannot return null from a non-@Nullable @Provides method");
    }
}

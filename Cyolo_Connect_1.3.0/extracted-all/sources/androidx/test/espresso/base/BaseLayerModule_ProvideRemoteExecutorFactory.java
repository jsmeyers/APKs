package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListeningExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideRemoteExecutorFactory implements Factory<ListeningExecutorService> {
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideRemoteExecutorFactory(BaseLayerModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public ListeningExecutorService get2() {
        return provideRemoteExecutor(this.module);
    }

    public static BaseLayerModule_ProvideRemoteExecutorFactory create(BaseLayerModule module) {
        return new BaseLayerModule_ProvideRemoteExecutorFactory(module);
    }

    public static ListeningExecutorService provideRemoteExecutor(BaseLayerModule instance) {
        return (ListeningExecutorService) Preconditions.checkNotNull(instance.provideRemoteExecutor(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

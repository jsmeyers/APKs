package androidx.test.espresso.base;

import android.os.Looper;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideMainThreadExecutorFactory implements Factory<Executor> {
    private final Provider<Looper> mainLooperProvider;
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideMainThreadExecutorFactory(BaseLayerModule module, Provider<Looper> mainLooperProvider) {
        this.module = module;
        this.mainLooperProvider = mainLooperProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public Executor get2() {
        return provideMainThreadExecutor(this.module, this.mainLooperProvider.get2());
    }

    public static BaseLayerModule_ProvideMainThreadExecutorFactory create(BaseLayerModule module, Provider<Looper> mainLooperProvider) {
        return new BaseLayerModule_ProvideMainThreadExecutorFactory(module, mainLooperProvider);
    }

    public static Executor provideMainThreadExecutor(BaseLayerModule instance, Looper mainLooper) {
        return (Executor) Preconditions.checkNotNull(instance.provideMainThreadExecutor(mainLooper), "Cannot return null from a non-@Nullable @Provides method");
    }
}

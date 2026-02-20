package androidx.test.espresso.base;

import androidx.test.espresso.FailureHandler;
import androidx.test.espresso.base.BaseLayerModule;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_FailureHandlerHolder_Factory implements Factory<BaseLayerModule.FailureHandlerHolder> {
    private final Provider<FailureHandler> defaultHandlerProvider;

    public BaseLayerModule_FailureHandlerHolder_Factory(Provider<FailureHandler> defaultHandlerProvider) {
        this.defaultHandlerProvider = defaultHandlerProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public BaseLayerModule.FailureHandlerHolder get2() {
        return new BaseLayerModule.FailureHandlerHolder(this.defaultHandlerProvider.get2());
    }

    public static BaseLayerModule_FailureHandlerHolder_Factory create(Provider<FailureHandler> defaultHandlerProvider) {
        return new BaseLayerModule_FailureHandlerHolder_Factory(defaultHandlerProvider);
    }

    public static BaseLayerModule.FailureHandlerHolder newInstance(FailureHandler defaultHandler) {
        return new BaseLayerModule.FailureHandlerHolder(defaultHandler);
    }
}

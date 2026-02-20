package androidx.test.espresso.base;

import android.content.Context;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultFailureHandler_Factory implements Factory<DefaultFailureHandler> {
    private final Provider<Context> appContextProvider;

    public DefaultFailureHandler_Factory(Provider<Context> appContextProvider) {
        this.appContextProvider = appContextProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public DefaultFailureHandler get2() {
        return new DefaultFailureHandler(this.appContextProvider.get2());
    }

    public static DefaultFailureHandler_Factory create(Provider<Context> appContextProvider) {
        return new DefaultFailureHandler_Factory(appContextProvider);
    }

    public static DefaultFailureHandler newInstance(Context appContext) {
        return new DefaultFailureHandler(appContext);
    }
}

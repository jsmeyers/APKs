package androidx.test.espresso.base;

import androidx.test.espresso.UiController;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class UiControllerModule_ProvideUiControllerFactory implements Factory<UiController> {
    private final UiControllerModule module;
    private final Provider<UiControllerImpl> uiControllerImplProvider;

    public UiControllerModule_ProvideUiControllerFactory(UiControllerModule module, Provider<UiControllerImpl> uiControllerImplProvider) {
        this.module = module;
        this.uiControllerImplProvider = uiControllerImplProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public UiController get2() {
        return provideUiController(this.module, this.uiControllerImplProvider.get2());
    }

    public static UiControllerModule_ProvideUiControllerFactory create(UiControllerModule module, Provider<UiControllerImpl> uiControllerImplProvider) {
        return new UiControllerModule_ProvideUiControllerFactory(module, uiControllerImplProvider);
    }

    public static UiController provideUiController(UiControllerModule instance, Object uiControllerImpl) {
        return (UiController) Preconditions.checkNotNull(instance.provideUiController((UiControllerImpl) uiControllerImpl), "Cannot return null from a non-@Nullable @Provides method");
    }
}

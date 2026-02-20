package androidx.test.espresso;

import android.view.View;
import androidx.test.espresso.base.RootViewPicker;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ViewInteractionModule_ProvideRootViewFactory implements Factory<View> {
    private final ViewInteractionModule module;
    private final Provider<RootViewPicker> rootViewPickerProvider;

    public ViewInteractionModule_ProvideRootViewFactory(ViewInteractionModule module, Provider<RootViewPicker> rootViewPickerProvider) {
        this.module = module;
        this.rootViewPickerProvider = rootViewPickerProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public View get2() {
        return provideRootView(this.module, this.rootViewPickerProvider.get2());
    }

    public static ViewInteractionModule_ProvideRootViewFactory create(ViewInteractionModule module, Provider<RootViewPicker> rootViewPickerProvider) {
        return new ViewInteractionModule_ProvideRootViewFactory(module, rootViewPickerProvider);
    }

    public static View provideRootView(ViewInteractionModule instance, RootViewPicker rootViewPicker) {
        return (View) Preconditions.checkNotNull(instance.provideRootView(rootViewPicker), "Cannot return null from a non-@Nullable @Provides method");
    }
}

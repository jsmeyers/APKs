package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewInteractionModule_ProvideNeedsActivityFactory implements Factory<AtomicReference<Boolean>> {
    private final ViewInteractionModule module;

    public ViewInteractionModule_ProvideNeedsActivityFactory(ViewInteractionModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public AtomicReference<Boolean> get2() {
        return provideNeedsActivity(this.module);
    }

    public static ViewInteractionModule_ProvideNeedsActivityFactory create(ViewInteractionModule module) {
        return new ViewInteractionModule_ProvideNeedsActivityFactory(module);
    }

    public static AtomicReference<Boolean> provideNeedsActivity(ViewInteractionModule instance) {
        return (AtomicReference) Preconditions.checkNotNull(instance.provideNeedsActivity(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class ViewInteractionModule_ProvideRootMatcherFactory implements Factory<AtomicReference<Matcher<Root>>> {
    private final ViewInteractionModule module;

    public ViewInteractionModule_ProvideRootMatcherFactory(ViewInteractionModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public AtomicReference<Matcher<Root>> get2() {
        return provideRootMatcher(this.module);
    }

    public static ViewInteractionModule_ProvideRootMatcherFactory create(ViewInteractionModule module) {
        return new ViewInteractionModule_ProvideRootMatcherFactory(module);
    }

    public static AtomicReference<Matcher<Root>> provideRootMatcher(ViewInteractionModule instance) {
        return (AtomicReference) Preconditions.checkNotNull(instance.provideRootMatcher(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

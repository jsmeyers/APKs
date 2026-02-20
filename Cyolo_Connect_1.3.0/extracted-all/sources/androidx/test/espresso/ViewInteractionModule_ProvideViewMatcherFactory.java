package androidx.test.espresso;

import android.view.View;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class ViewInteractionModule_ProvideViewMatcherFactory implements Factory<Matcher<View>> {
    private final ViewInteractionModule module;

    public ViewInteractionModule_ProvideViewMatcherFactory(ViewInteractionModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public Matcher<View> get2() {
        return provideViewMatcher(this.module);
    }

    public static ViewInteractionModule_ProvideViewMatcherFactory create(ViewInteractionModule module) {
        return new ViewInteractionModule_ProvideViewMatcherFactory(module);
    }

    public static Matcher<View> provideViewMatcher(ViewInteractionModule instance) {
        return (Matcher) Preconditions.checkNotNull(instance.provideViewMatcher(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

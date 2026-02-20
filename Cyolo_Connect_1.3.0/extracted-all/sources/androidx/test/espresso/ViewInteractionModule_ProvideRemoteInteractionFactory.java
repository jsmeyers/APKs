package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import androidx.test.espresso.remote.RemoteInteraction;

/* JADX INFO: loaded from: classes.dex */
public final class ViewInteractionModule_ProvideRemoteInteractionFactory implements Factory<RemoteInteraction> {
    private final ViewInteractionModule module;

    public ViewInteractionModule_ProvideRemoteInteractionFactory(ViewInteractionModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public RemoteInteraction get2() {
        return provideRemoteInteraction(this.module);
    }

    public static ViewInteractionModule_ProvideRemoteInteractionFactory create(ViewInteractionModule module) {
        return new ViewInteractionModule_ProvideRemoteInteractionFactory(module);
    }

    public static RemoteInteraction provideRemoteInteraction(ViewInteractionModule instance) {
        return (RemoteInteraction) Preconditions.checkNotNull(instance.provideRemoteInteraction(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

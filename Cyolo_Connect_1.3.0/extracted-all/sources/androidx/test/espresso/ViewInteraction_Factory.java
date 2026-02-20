package androidx.test.espresso;

import android.view.View;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListeningExecutorService;
import androidx.test.espresso.remote.RemoteInteraction;
import androidx.test.internal.platform.os.ControlledLooper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Provider;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class ViewInteraction_Factory implements Factory<ViewInteraction> {
    private final Provider<ControlledLooper> controlledLooperProvider;
    private final Provider<FailureHandler> failureHandlerProvider;
    private final Provider<Executor> mainThreadExecutorProvider;
    private final Provider<AtomicReference<Boolean>> needsActivityProvider;
    private final Provider<ListeningExecutorService> remoteExecutorProvider;
    private final Provider<RemoteInteraction> remoteInteractionProvider;
    private final Provider<AtomicReference<Matcher<Root>>> rootMatcherRefProvider;
    private final Provider<UiController> uiControllerProvider;
    private final Provider<ViewFinder> viewFinderProvider;
    private final Provider<Matcher<View>> viewMatcherProvider;

    public ViewInteraction_Factory(Provider<UiController> uiControllerProvider, Provider<ViewFinder> viewFinderProvider, Provider<Executor> mainThreadExecutorProvider, Provider<FailureHandler> failureHandlerProvider, Provider<Matcher<View>> viewMatcherProvider, Provider<AtomicReference<Matcher<Root>>> rootMatcherRefProvider, Provider<AtomicReference<Boolean>> needsActivityProvider, Provider<RemoteInteraction> remoteInteractionProvider, Provider<ListeningExecutorService> remoteExecutorProvider, Provider<ControlledLooper> controlledLooperProvider) {
        this.uiControllerProvider = uiControllerProvider;
        this.viewFinderProvider = viewFinderProvider;
        this.mainThreadExecutorProvider = mainThreadExecutorProvider;
        this.failureHandlerProvider = failureHandlerProvider;
        this.viewMatcherProvider = viewMatcherProvider;
        this.rootMatcherRefProvider = rootMatcherRefProvider;
        this.needsActivityProvider = needsActivityProvider;
        this.remoteInteractionProvider = remoteInteractionProvider;
        this.remoteExecutorProvider = remoteExecutorProvider;
        this.controlledLooperProvider = controlledLooperProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public ViewInteraction get2() {
        return new ViewInteraction(this.uiControllerProvider.get2(), this.viewFinderProvider.get2(), this.mainThreadExecutorProvider.get2(), this.failureHandlerProvider.get2(), this.viewMatcherProvider.get2(), this.rootMatcherRefProvider.get2(), this.needsActivityProvider.get2(), this.remoteInteractionProvider.get2(), this.remoteExecutorProvider.get2(), this.controlledLooperProvider.get2());
    }

    public static ViewInteraction_Factory create(Provider<UiController> uiControllerProvider, Provider<ViewFinder> viewFinderProvider, Provider<Executor> mainThreadExecutorProvider, Provider<FailureHandler> failureHandlerProvider, Provider<Matcher<View>> viewMatcherProvider, Provider<AtomicReference<Matcher<Root>>> rootMatcherRefProvider, Provider<AtomicReference<Boolean>> needsActivityProvider, Provider<RemoteInteraction> remoteInteractionProvider, Provider<ListeningExecutorService> remoteExecutorProvider, Provider<ControlledLooper> controlledLooperProvider) {
        return new ViewInteraction_Factory(uiControllerProvider, viewFinderProvider, mainThreadExecutorProvider, failureHandlerProvider, viewMatcherProvider, rootMatcherRefProvider, needsActivityProvider, remoteInteractionProvider, remoteExecutorProvider, controlledLooperProvider);
    }

    public static ViewInteraction newInstance(UiController uiController, ViewFinder viewFinder, Executor mainThreadExecutor, FailureHandler failureHandler, Matcher<View> viewMatcher, AtomicReference<Matcher<Root>> rootMatcherRef, AtomicReference<Boolean> needsActivity, RemoteInteraction remoteInteraction, ListeningExecutorService remoteExecutor, ControlledLooper controlledLooper) {
        return new ViewInteraction(uiController, viewFinder, mainThreadExecutor, failureHandler, viewMatcher, rootMatcherRef, needsActivity, remoteInteraction, remoteExecutor, controlledLooper);
    }
}

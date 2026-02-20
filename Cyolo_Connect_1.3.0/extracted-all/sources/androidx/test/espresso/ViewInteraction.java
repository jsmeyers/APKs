package androidx.test.espresso;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.action.ScrollToAction;
import androidx.test.espresso.base.InterruptableUiController;
import androidx.test.espresso.base.MainThread;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableMap;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFutureTask;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListeningExecutorService;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.remote.Bindable;
import androidx.test.espresso.remote.IInteractionExecutionStatus;
import androidx.test.espresso.remote.RemoteInteraction;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.internal.platform.os.ControlledLooper;
import androidx.test.internal.util.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.StringDescription;

/* JADX INFO: loaded from: classes.dex */
public final class ViewInteraction {
    private static final String TAG = "ViewInteraction";
    private final ControlledLooper controlledLooper;
    private volatile FailureHandler failureHandler;
    private boolean hasRootMatcher = false;
    private final Executor mainThreadExecutor;
    private final AtomicReference<Boolean> needsActivity;
    private final ListeningExecutorService remoteExecutor;
    private final RemoteInteraction remoteInteraction;
    private final AtomicReference<Matcher<Root>> rootMatcherRef;
    private final InterruptableUiController uiController;
    private final ViewFinder viewFinder;
    private final Matcher<View> viewMatcher;

    ViewInteraction(UiController uiController, ViewFinder viewFinder, @MainThread Executor mainThreadExecutor, FailureHandler failureHandler, Matcher<View> viewMatcher, AtomicReference<Matcher<Root>> rootMatcherRef, AtomicReference<Boolean> needsActivity, RemoteInteraction remoteInteraction, ListeningExecutorService remoteExecutor, ControlledLooper controlledLooper) {
        this.viewFinder = (ViewFinder) Preconditions.checkNotNull(viewFinder);
        this.uiController = (InterruptableUiController) Preconditions.checkNotNull(uiController);
        this.failureHandler = (FailureHandler) Preconditions.checkNotNull(failureHandler);
        this.mainThreadExecutor = (Executor) Preconditions.checkNotNull(mainThreadExecutor);
        this.viewMatcher = (Matcher) Preconditions.checkNotNull(viewMatcher);
        this.rootMatcherRef = (AtomicReference) Preconditions.checkNotNull(rootMatcherRef);
        this.needsActivity = (AtomicReference) Preconditions.checkNotNull(needsActivity);
        this.remoteInteraction = (RemoteInteraction) Preconditions.checkNotNull(remoteInteraction);
        this.remoteExecutor = (ListeningExecutorService) Preconditions.checkNotNull(remoteExecutor);
        this.controlledLooper = (ControlledLooper) Preconditions.checkNotNull(controlledLooper);
    }

    public ViewInteraction perform(final ViewAction... viewActions) {
        Preconditions.checkNotNull(viewActions);
        for (ViewAction viewAction : viewActions) {
            desugaredPerform(new SingleExecutionViewAction(viewAction, this.viewMatcher));
        }
        return this;
    }

    private static Map<String, IBinder> getIBindersFromBindables(List<Bindable> bindables) {
        HashMap map = new HashMap();
        for (Bindable bindable : bindables) {
            map.put((String) Preconditions.checkNotNull(bindable.getId(), "Bindable id cannot be null!"), (IBinder) Preconditions.checkNotNull(bindable.getIBinder(), "Bindable binder cannot be null!"));
        }
        return ImmutableMap.copyOf((Map) map);
    }

    private static List<Bindable> getBindables(Object... objects) {
        ArrayList arrayListNewArrayListWithCapacity = Lists.newArrayListWithCapacity(objects.length);
        for (Object obj : objects) {
            if (obj instanceof Bindable) {
                arrayListNewArrayListWithCapacity.add((Bindable) obj);
            }
        }
        return arrayListNewArrayListWithCapacity;
    }

    private static Map<String, IBinder> getIBindersFromViewActions(ViewAction... viewActions) {
        return getIBindersFromBindables(getBindables(viewActions));
    }

    private static Map<String, IBinder> getIBindersFromViewAssertions(ViewAssertion... viewAssertions) {
        return getIBindersFromBindables(getBindables(viewAssertions));
    }

    private void desugaredPerform(final SingleExecutionViewAction va) {
        Callable<Void> callable = new Callable<Void>() { // from class: androidx.test.espresso.ViewInteraction.1
            @Override // java.util.concurrent.Callable
            public Void call() {
                ViewInteraction.this.doPerform(va);
                return null;
            }
        };
        ViewAction innerViewAction = va.getInnerViewAction();
        ArrayList arrayList = new ArrayList();
        arrayList.add(postAsynchronouslyOnUiThread(callable));
        if (!this.remoteInteraction.isRemoteProcess()) {
            arrayList.add(this.remoteExecutor.submit((Callable) this.remoteInteraction.createRemotePerformCallable(this.rootMatcherRef.get(), this.viewMatcher, getIBindersFromViewActions(va, innerViewAction), innerViewAction)));
        }
        waitForAndHandleInteractionResults(arrayList);
    }

    public ViewInteraction withFailureHandler(FailureHandler failureHandler) {
        this.failureHandler = (FailureHandler) Preconditions.checkNotNull(failureHandler);
        return this;
    }

    public ViewInteraction inRoot(Matcher<Root> rootMatcher) {
        this.hasRootMatcher = true;
        this.rootMatcherRef.set((Matcher) Preconditions.checkNotNull(rootMatcher));
        return this;
    }

    public ViewInteraction noActivity() {
        if (!this.hasRootMatcher) {
            this.rootMatcherRef.set(Matchers.anyOf(RootMatchers.DEFAULT, Matchers.allOf(RootMatchers.hasWindowLayoutParams(), RootMatchers.isSystemAlertWindow())));
        }
        this.needsActivity.set(false);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPerform(final SingleExecutionViewAction viewAction) {
        Preconditions.checkNotNull(viewAction);
        Matcher matcher = (Matcher) Preconditions.checkNotNull(viewAction.getConstraints());
        this.uiController.loopMainThreadUntilIdle();
        View view = this.viewFinder.getView();
        Log.i(TAG, String.format(Locale.ROOT, "Performing '%s' action on view %s", viewAction.getDescription(), this.viewMatcher));
        if (!matcher.matches(view)) {
            StringDescription stringDescription = new StringDescription(new StringBuilder("Action will not be performed because the target view does not match one or more of the following constraints:\n"));
            matcher.describeTo(stringDescription);
            stringDescription.appendText("\nTarget view: ").appendValue(HumanReadables.describe(view));
            if ((viewAction.getInnerViewAction() instanceof ScrollToAction) && ViewMatchers.isDescendantOfA(ViewMatchers.isAssignableFrom(AdapterView.class)).matches(view)) {
                stringDescription.appendText("\nFurther Info: ScrollToAction on a view inside an AdapterView will not work. Use Espresso.onData to load the view.");
            }
            throw new PerformException.Builder().withActionDescription(viewAction.getDescription()).withViewDescription(this.viewMatcher.toString()).withCause(new RuntimeException(stringDescription.toString())).build();
        }
        viewAction.perform(this.uiController, view);
    }

    public ViewInteraction check(final ViewAssertion viewAssert) {
        Preconditions.checkNotNull(viewAssert);
        final SingleExecutionViewAssertion singleExecutionViewAssertion = new SingleExecutionViewAssertion(viewAssert);
        Callable<Void> callable = new Callable<Void>() { // from class: androidx.test.espresso.ViewInteraction.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                NoMatchingViewException noMatchingViewException;
                View view;
                ViewInteraction.this.uiController.loopMainThreadUntilIdle();
                try {
                    view = ViewInteraction.this.viewFinder.getView();
                    noMatchingViewException = null;
                } catch (NoMatchingViewException e) {
                    noMatchingViewException = e;
                    view = null;
                }
                Log.i(ViewInteraction.TAG, String.format(Locale.ROOT, "Checking '%s' assertion on view %s", viewAssert, ViewInteraction.this.viewMatcher));
                singleExecutionViewAssertion.check(view, noMatchingViewException);
                return null;
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(postAsynchronouslyOnUiThread(callable));
        if (!this.remoteInteraction.isRemoteProcess()) {
            arrayList.add(this.remoteExecutor.submit((Callable) this.remoteInteraction.createRemoteCheckCallable(this.rootMatcherRef.get(), this.viewMatcher, getIBindersFromViewAssertions(singleExecutionViewAssertion, viewAssert), viewAssert)));
        }
        waitForAndHandleInteractionResults(arrayList);
        return this;
    }

    private ListenableFuture<Void> postAsynchronouslyOnUiThread(Callable<Void> interaction) {
        ListenableFutureTask listenableFutureTaskCreate = ListenableFutureTask.create(interaction);
        this.mainThreadExecutor.execute(listenableFutureTaskCreate);
        return listenableFutureTaskCreate;
    }

    private void waitForAndHandleInteractionResults(List<ListenableFuture<Void>> interactions) {
        try {
            try {
                this.controlledLooper.drainMainThreadUntilIdle();
                InteractionResultsHandler.gatherAnyResult(interactions);
            } catch (Error e) {
                this.failureHandler.handle(e, this.viewMatcher);
            } catch (RuntimeException e2) {
                this.failureHandler.handle(e2, this.viewMatcher);
            }
        } finally {
            this.uiController.interruptEspressoTasks();
        }
    }

    private static final class SingleExecutionViewAction implements ViewAction, Bindable {
        private IInteractionExecutionStatus actionExecutionStatus;
        final ViewAction viewAction;
        final Matcher<View> viewMatcher;

        @Override // androidx.test.espresso.remote.Bindable
        public String getId() {
            return RemoteInteraction.BUNDLE_EXECUTION_STATUS;
        }

        private SingleExecutionViewAction(ViewAction viewAction, Matcher<View> viewMatcher) {
            this.actionExecutionStatus = new IInteractionExecutionStatus.Stub(this) { // from class: androidx.test.espresso.ViewInteraction.SingleExecutionViewAction.1
                AtomicBoolean run = new AtomicBoolean(true);

                @Override // androidx.test.espresso.remote.IInteractionExecutionStatus
                public boolean canExecute() throws RemoteException {
                    return this.run.getAndSet(false);
                }
            };
            this.viewAction = viewAction;
            this.viewMatcher = viewMatcher;
        }

        @Override // androidx.test.espresso.ViewAction
        public Matcher<View> getConstraints() {
            return this.viewAction.getConstraints();
        }

        @Override // androidx.test.espresso.ViewAction
        public String getDescription() {
            return this.viewAction.getDescription();
        }

        @Override // androidx.test.espresso.ViewAction
        public void perform(UiController uiController, View view) {
            try {
                if (!this.actionExecutionStatus.canExecute()) {
                    String str = ViewInteraction.TAG;
                    String strValueOf = String.valueOf(this.viewAction);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 63);
                    sb.append("Attempted to execute a Single Execution Action more then once: ");
                    sb.append(strValueOf);
                    LogUtil.logDebugWithProcess(str, sb.toString(), new Object[0]);
                    return;
                }
                this.viewAction.perform(uiController, view);
            } catch (RemoteException e) {
                throw new PerformException.Builder().withActionDescription(this.viewAction.getDescription()).withViewDescription(this.viewMatcher.toString()).withCause(new RuntimeException("Unable to query interaction execution status", e.getCause())).build();
            }
        }

        ViewAction getInnerViewAction() {
            return this.viewAction;
        }

        @Override // androidx.test.espresso.remote.Bindable
        public IBinder getIBinder() {
            return this.actionExecutionStatus.asBinder();
        }

        @Override // androidx.test.espresso.remote.Bindable
        public void setIBinder(IBinder binder) {
            this.actionExecutionStatus = IInteractionExecutionStatus.Stub.asInterface(binder);
        }
    }

    private static final class SingleExecutionViewAssertion implements ViewAssertion, Bindable {
        private IInteractionExecutionStatus assertionExecutionStatus;
        final ViewAssertion viewAssertion;

        @Override // androidx.test.espresso.remote.Bindable
        public String getId() {
            return RemoteInteraction.BUNDLE_EXECUTION_STATUS;
        }

        private SingleExecutionViewAssertion(ViewAssertion viewAssertion) {
            this.assertionExecutionStatus = new IInteractionExecutionStatus.Stub(this) { // from class: androidx.test.espresso.ViewInteraction.SingleExecutionViewAssertion.1
                AtomicBoolean run = new AtomicBoolean(true);

                @Override // androidx.test.espresso.remote.IInteractionExecutionStatus
                public boolean canExecute() throws RemoteException {
                    return this.run.getAndSet(false);
                }
            };
            this.viewAssertion = viewAssertion;
        }

        @Override // androidx.test.espresso.ViewAssertion
        public void check(View view, NoMatchingViewException noViewFoundException) {
            try {
                if (!this.assertionExecutionStatus.canExecute()) {
                    String str = ViewInteraction.TAG;
                    String strValueOf = String.valueOf(this.viewAssertion);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 66);
                    sb.append("Attempted to execute a Single Execution Assertion more then once: ");
                    sb.append(strValueOf);
                    LogUtil.logDebugWithProcess(str, sb.toString(), new Object[0]);
                    return;
                }
                this.viewAssertion.check(view, noViewFoundException);
            } catch (RemoteException e) {
                throw new RuntimeException("Unable to query interaction execution status", e.getCause());
            }
        }

        @Override // androidx.test.espresso.remote.Bindable
        public IBinder getIBinder() {
            return this.assertionExecutionStatus.asBinder();
        }

        @Override // androidx.test.espresso.remote.Bindable
        public void setIBinder(IBinder binder) {
            this.assertionExecutionStatus = IInteractionExecutionStatus.Stub.asInterface(binder);
        }
    }
}

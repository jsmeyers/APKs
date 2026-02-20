package androidx.test.espresso.base;

import android.app.Activity;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.test.espresso.NoActivityResumedException;
import androidx.test.espresso.NoMatchingRootException;
import androidx.test.espresso.Root;
import androidx.test.espresso.UiController;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableList;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.core.internal.deps.guava.collect.UnmodifiableIterator;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.internal.platform.os.ControlledLooper;
import androidx.test.internal.util.LogUtil;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.Stage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Provider;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class RootViewPicker implements Provider<View> {
    private static final ImmutableList<Integer> CREATED_WAIT_TIMES = ImmutableList.of(10, 50, 150, 250);
    private static final ImmutableList<Integer> RESUMED_WAIT_TIMES = ImmutableList.of(10, 50, 100, 500, 2000, 30000);
    private static final String TAG = "RootViewPicker";
    private final ActivityLifecycleMonitor activityLifecycleMonitor;
    private final ControlledLooper controlledLooper;
    private final AtomicReference<Boolean> needsActivity;
    private final RootResultFetcher rootResultFetcher;
    private final UiController uiController;

    RootViewPicker(UiController uiController, RootResultFetcher rootResultFetcher, ActivityLifecycleMonitor activityLifecycleMonitor, AtomicReference<Boolean> needsActivity, ControlledLooper controlledLooper) {
        this.uiController = uiController;
        this.rootResultFetcher = rootResultFetcher;
        this.activityLifecycleMonitor = activityLifecycleMonitor;
        this.needsActivity = needsActivity;
        this.controlledLooper = controlledLooper;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public View get2() {
        Preconditions.checkState(Looper.getMainLooper().equals(Looper.myLooper()), "must be called on main thread.");
        if (this.needsActivity.get().booleanValue()) {
            waitForAtLeastOneActivityToBeResumed();
        }
        return pickRootView();
    }

    private Root waitForRootToBeReady(Root pickedRoot) {
        long jCurrentTimeMillis = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10L);
        RootReadyBackoff rootReadyBackoff = new RootReadyBackoff();
        while (System.currentTimeMillis() <= jCurrentTimeMillis) {
            if (pickedRoot.isReady()) {
                return pickedRoot;
            }
            this.controlledLooper.simulateWindowFocus(pickedRoot.getDecorView());
            this.uiController.loopMainThreadForAtLeast(rootReadyBackoff.getNextBackoffInMillis());
        }
        throw new RuntimeException(String.format(Locale.ROOT, "Waited for the root of the view hierarchy to have window focus and not request layout for 10 seconds. If you specified a non default root matcher, it may be picking a root that never takes focus. Root:\n%s", pickedRoot));
    }

    private Root pickARoot() {
        long jCurrentTimeMillis = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(60L);
        RootResults rootResultsFetch = this.rootResultFetcher.fetch();
        NoActiveRootsBackoff noActiveRootsBackoff = new NoActiveRootsBackoff();
        NoMatchingRootBackoff noMatchingRootBackoff = new NoMatchingRootBackoff();
        while (System.currentTimeMillis() <= jCurrentTimeMillis) {
            int i = AnonymousClass1.$SwitchMap$androidx$test$espresso$base$RootViewPicker$RootResults$State[rootResultsFetch.getState().ordinal()];
            if (i == 1) {
                return rootResultsFetch.getPickedRoot();
            }
            if (i == 2) {
                this.uiController.loopMainThreadForAtLeast(noActiveRootsBackoff.getNextBackoffInMillis());
            } else if (i == 3) {
                this.uiController.loopMainThreadForAtLeast(noMatchingRootBackoff.getNextBackoffInMillis());
            }
            rootResultsFetch = this.rootResultFetcher.fetch();
        }
        if (RootResults.State.ROOTS_PICKED == rootResultsFetch.getState()) {
            return rootResultsFetch.getPickedRoot();
        }
        throw NoMatchingRootException.create(rootResultsFetch.rootSelector, rootResultsFetch.allRoots);
    }

    /* JADX INFO: renamed from: androidx.test.espresso.base.RootViewPicker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$test$espresso$base$RootViewPicker$RootResults$State;

        static {
            int[] iArr = new int[RootResults.State.values().length];
            $SwitchMap$androidx$test$espresso$base$RootViewPicker$RootResults$State = iArr;
            try {
                iArr[RootResults.State.ROOTS_PICKED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$test$espresso$base$RootViewPicker$RootResults$State[RootResults.State.NO_ROOTS_PRESENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$test$espresso$base$RootViewPicker$RootResults$State[RootResults.State.NO_ROOTS_PICKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private View pickRootView() {
        return waitForRootToBeReady(pickARoot()).getDecorView();
    }

    private void waitForAtLeastOneActivityToBeResumed() {
        Collection<Activity> activitiesInStage = this.activityLifecycleMonitor.getActivitiesInStage(Stage.RESUMED);
        if (activitiesInStage.isEmpty()) {
            this.uiController.loopMainThreadUntilIdle();
            activitiesInStage = this.activityLifecycleMonitor.getActivitiesInStage(Stage.RESUMED);
        }
        if (activitiesInStage.isEmpty()) {
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            UnmodifiableIterator<Integer> it = CREATED_WAIT_TIMES.iterator();
            while (it.hasNext()) {
                long jIntValue = it.next().intValue();
                Iterator it2 = EnumSet.range(Stage.PRE_ON_CREATE, Stage.RESTARTED).iterator();
                while (it2.hasNext()) {
                    arrayListNewArrayList.addAll(this.activityLifecycleMonitor.getActivitiesInStage((Stage) it2.next()));
                }
                if (!arrayListNewArrayList.isEmpty()) {
                    break;
                }
                String str = TAG;
                StringBuilder sb = new StringBuilder(72);
                sb.append("No activities found - waiting: ");
                sb.append(jIntValue);
                sb.append("ms for one to appear.");
                Log.w(str, sb.toString());
                this.uiController.loopMainThreadForAtLeast(jIntValue);
            }
            if (arrayListNewArrayList.isEmpty()) {
                throw new RuntimeException("No activities found. Did you forget to launch the activity by calling getActivity() or startActivitySync or similar?");
            }
            UnmodifiableIterator<Integer> it3 = RESUMED_WAIT_TIMES.iterator();
            while (it3.hasNext()) {
                long jIntValue2 = it3.next().intValue();
                String str2 = TAG;
                StringBuilder sb2 = new StringBuilder(82);
                sb2.append("No activity currently resumed - waiting: ");
                sb2.append(jIntValue2);
                sb2.append("ms for one to appear.");
                Log.w(str2, sb2.toString());
                this.uiController.loopMainThreadForAtLeast(jIntValue2);
                if (!this.activityLifecycleMonitor.getActivitiesInStage(Stage.RESUMED).isEmpty()) {
                    return;
                }
            }
            throw new NoActivityResumedException("No activities in stage RESUMED. Did you forget to launch the activity. (test.getActivity() or similar)?");
        }
    }

    private static class RootResults {
        private final List<Root> allRoots;
        private final List<Root> pickedRoots;
        private final Matcher<Root> rootSelector;

        enum State {
            NO_ROOTS_PRESENT,
            NO_ROOTS_PICKED,
            ROOTS_PICKED
        }

        /* synthetic */ RootResults(List list, List list2, Matcher matcher, AnonymousClass1 anonymousClass1) {
            this(list, list2, matcher);
        }

        private RootResults(List<Root> allRoots, List<Root> pickedRoots, Matcher<Root> rootSelector) {
            this.allRoots = allRoots;
            this.pickedRoots = pickedRoots;
            this.rootSelector = rootSelector;
        }

        private static boolean isTopmostRoot(Root topMostRoot, Root root) {
            return root.getWindowLayoutParams().get().type > topMostRoot.getWindowLayoutParams().get().type;
        }

        public State getState() {
            if (this.allRoots.isEmpty()) {
                return State.NO_ROOTS_PRESENT;
            }
            if (this.pickedRoots.isEmpty()) {
                return State.NO_ROOTS_PICKED;
            }
            if (this.pickedRoots.size() >= 1) {
                return State.ROOTS_PICKED;
            }
            return State.NO_ROOTS_PICKED;
        }

        private Root getRootFromMultipleRoots() {
            Root root = this.pickedRoots.get(0);
            if (this.pickedRoots.size() >= 1) {
                for (Root root2 : this.pickedRoots) {
                    if (RootMatchers.isDialog().matches(root2)) {
                        return root2;
                    }
                    if (isTopmostRoot(root, root2)) {
                        root = root2;
                    }
                }
            }
            return root;
        }

        public Root getPickedRoot() {
            if (this.pickedRoots.size() > 1) {
                LogUtil.logDebugWithProcess(RootViewPicker.TAG, "Multiple root windows detected: %s", this.pickedRoots);
                return getRootFromMultipleRoots();
            }
            return this.pickedRoots.get(0);
        }
    }

    static class RootResultFetcher {
        private final ActiveRootLister activeRootLister;
        private final Matcher<Root> selector;

        public RootResultFetcher(ActiveRootLister activeRootLister, AtomicReference<Matcher<Root>> rootMatcherRef) {
            this.activeRootLister = activeRootLister;
            this.selector = rootMatcherRef.get();
        }

        public RootResults fetch() {
            List<Root> listListActiveRoots = this.activeRootLister.listActiveRoots();
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            for (Root root : listListActiveRoots) {
                if (this.selector.matches(root)) {
                    arrayListNewArrayList.add(root);
                }
            }
            return new RootResults(listListActiveRoots, arrayListNewArrayList, this.selector, null);
        }
    }

    private static abstract class BackOff {
        private final List<Integer> backoffTimes;
        private int numberOfAttempts = 0;
        private final TimeUnit timeUnit;

        protected abstract long getNextBackoffInMillis();

        public BackOff(List<Integer> backoffTimes, TimeUnit timeUnit) {
            this.backoffTimes = backoffTimes;
            this.timeUnit = timeUnit;
        }

        protected final long getBackoffForAttempt() {
            if (this.numberOfAttempts >= this.backoffTimes.size()) {
                List<Integer> list = this.backoffTimes;
                return list.get(list.size() - 1).intValue();
            }
            int iIntValue = this.backoffTimes.get(this.numberOfAttempts).intValue();
            this.numberOfAttempts++;
            return this.timeUnit.toMillis(iIntValue);
        }
    }

    private static final class NoActiveRootsBackoff extends BackOff {
        private static final ImmutableList<Integer> NO_ACTIVE_ROOTS_BACKOFF = ImmutableList.of(10, 10, 20, 30, 50, 80, 130, 210, 340);

        public NoActiveRootsBackoff() {
            super(NO_ACTIVE_ROOTS_BACKOFF, TimeUnit.MILLISECONDS);
        }

        @Override // androidx.test.espresso.base.RootViewPicker.BackOff
        public long getNextBackoffInMillis() {
            long backoffForAttempt = getBackoffForAttempt();
            LogUtil.logDebugWithProcess(RootViewPicker.TAG, "No active roots available - waiting: %sms for one to appear.", Long.valueOf(backoffForAttempt));
            return backoffForAttempt;
        }
    }

    private static final class NoMatchingRootBackoff extends BackOff {
        private static final ImmutableList<Integer> NO_MATCHING_ROOT_BACKOFF = ImmutableList.of(10, 20, 200, 400, 1000, 2000);

        public NoMatchingRootBackoff() {
            super(NO_MATCHING_ROOT_BACKOFF, TimeUnit.MILLISECONDS);
        }

        @Override // androidx.test.espresso.base.RootViewPicker.BackOff
        public long getNextBackoffInMillis() {
            long backoffForAttempt = getBackoffForAttempt();
            Log.d(RootViewPicker.TAG, String.format(Locale.ROOT, "No matching root available - waiting: %sms for one to appear.", Long.valueOf(backoffForAttempt)));
            return backoffForAttempt;
        }
    }

    private static final class RootReadyBackoff extends BackOff {
        private static final ImmutableList<Integer> ROOT_READY_BACKOFF = ImmutableList.of(10, 25, 50, 100, 200, 400, 800, 1000);

        public RootReadyBackoff() {
            super(ROOT_READY_BACKOFF, TimeUnit.MILLISECONDS);
        }

        @Override // androidx.test.espresso.base.RootViewPicker.BackOff
        public long getNextBackoffInMillis() {
            long backoffForAttempt = getBackoffForAttempt();
            Log.d(RootViewPicker.TAG, String.format(Locale.ROOT, "Root not ready - waiting: %sms for one to appear.", Long.valueOf(backoffForAttempt)));
            return backoffForAttempt;
        }
    }
}

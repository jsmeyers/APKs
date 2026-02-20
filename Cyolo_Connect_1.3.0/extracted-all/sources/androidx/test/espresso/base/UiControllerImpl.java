package androidx.test.espresso.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.test.espresso.IdlingPolicies;
import androidx.test.espresso.IdlingPolicy;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.base.IdlingResourceRegistry;
import androidx.test.espresso.base.Interrogator;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Throwables;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ThreadFactoryBuilder;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
final class UiControllerImpl implements Handler.Callback, IdlingUiController, InterruptableUiController {
    private static final Callable<Void> NO_OP = new Callable<Void>() { // from class: androidx.test.espresso.base.UiControllerImpl.1
        @Override // java.util.concurrent.Callable
        public Void call() {
            return null;
        }
    };
    private static final String TAG = "UiControllerImpl";
    private IdleNotifier<Runnable> asyncIdle;
    private IdleNotifier<Runnable> compatIdle;
    private Handler controllerHandler;
    private Provider<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> dynamicIdleProvider;
    private final EventInjector eventInjector;
    private final IdlingResourceRegistry idlingResourceRegistry;
    private MainThreadInterrogation interrogation;
    private final Looper mainLooper;
    private final ExecutorService keyEventExecutor = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setNameFormat("Espresso Key Event #%d").build());
    private int generation = 0;
    private final BitSet conditionSet = IdleCondition.createConditionSet();

    private enum InterrogationStatus {
        TIMED_OUT,
        COMPLETED,
        INTERRUPTED
    }

    enum IdleCondition {
        DELAY_HAS_PAST,
        ASYNC_TASKS_HAVE_IDLED,
        COMPAT_TASKS_HAVE_IDLED,
        KEY_INJECT_HAS_COMPLETED,
        MOTION_INJECTION_HAS_COMPLETED,
        DYNAMIC_TASKS_HAVE_IDLED;

        public boolean isSignaled(BitSet conditionSet) {
            return conditionSet.get(ordinal());
        }

        public void reset(BitSet conditionSet) {
            conditionSet.set(ordinal(), false);
        }

        public Message createSignal(Handler handler, int myGeneration) {
            return Message.obtain(handler, ordinal(), myGeneration, 0, null);
        }

        public static boolean handleMessage(Message message, BitSet conditionSet, int currentGeneration) {
            IdleCondition[] idleConditionArrValues = values();
            if (message.what < 0 || message.what >= idleConditionArrValues.length) {
                return false;
            }
            IdleCondition idleCondition = idleConditionArrValues[message.what];
            if (message.arg1 != currentGeneration) {
                String str = UiControllerImpl.TAG;
                String strValueOf = String.valueOf(idleCondition);
                int i = message.arg1;
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 90);
                sb.append("ignoring signal of: ");
                sb.append(strValueOf);
                sb.append(" from previous generation: ");
                sb.append(i);
                sb.append(" current generation: ");
                sb.append(currentGeneration);
                Log.w(str, sb.toString());
                return true;
            }
            idleCondition.signal(conditionSet);
            return true;
        }

        public static BitSet createConditionSet() {
            return new BitSet(values().length);
        }

        protected void signal(BitSet conditionSet) {
            conditionSet.set(ordinal());
        }
    }

    UiControllerImpl(EventInjector eventInjector, @SdkAsyncTask IdleNotifier<Runnable> asyncIdle, @CompatAsyncTask IdleNotifier<Runnable> compatIdle, Provider<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> dynamicIdle, Looper mainLooper, IdlingResourceRegistry idlingResourceRegistry) {
        this.eventInjector = (EventInjector) Preconditions.checkNotNull(eventInjector);
        this.asyncIdle = (IdleNotifier) Preconditions.checkNotNull(asyncIdle);
        this.compatIdle = (IdleNotifier) Preconditions.checkNotNull(compatIdle);
        this.dynamicIdleProvider = (Provider) Preconditions.checkNotNull(dynamicIdle);
        this.mainLooper = (Looper) Preconditions.checkNotNull(mainLooper);
        this.idlingResourceRegistry = (IdlingResourceRegistry) Preconditions.checkNotNull(idlingResourceRegistry);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.test.espresso.UiController
    public boolean injectKeyEvent(final KeyEvent event) throws InjectEventSecurityException {
        Preconditions.checkNotNull(event);
        Preconditions.checkState(Looper.myLooper() == this.mainLooper, "Expecting to be on main thread!");
        initialize();
        loopMainThreadUntilIdle();
        SignalingTask signalingTask = new SignalingTask(new Callable<Boolean>() { // from class: androidx.test.espresso.base.UiControllerImpl.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                return Boolean.valueOf(UiControllerImpl.this.eventInjector.injectKeyEvent(event));
            }
        }, IdleCondition.KEY_INJECT_HAS_COMPLETED, this.generation);
        this.keyEventExecutor.submit(signalingTask);
        loopUntil(IdleCondition.KEY_INJECT_HAS_COMPLETED, this.dynamicIdleProvider.get2());
        try {
            Preconditions.checkState(signalingTask.isDone(), "Key injection was signaled - but it wasnt done.");
            return ((Boolean) signalingTask.get()).booleanValue();
        } catch (InterruptedException e) {
            throw new RuntimeException("impossible.", e);
        } catch (ExecutionException e2) {
            if (e2.getCause() instanceof InjectEventSecurityException) {
                throw ((InjectEventSecurityException) e2.getCause());
            }
            throw new RuntimeException(e2.getCause());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.test.espresso.UiController
    public boolean injectMotionEvent(final MotionEvent motionEvent) throws InjectEventSecurityException {
        Preconditions.checkNotNull(motionEvent);
        Preconditions.checkState(Looper.myLooper() == this.mainLooper, "Expecting to be on main thread!");
        initialize();
        SignalingTask signalingTask = new SignalingTask(new Callable<Boolean>() { // from class: androidx.test.espresso.base.UiControllerImpl.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                return Boolean.valueOf(UiControllerImpl.this.eventInjector.injectMotionEvent(motionEvent));
            }
        }, IdleCondition.MOTION_INJECTION_HAS_COMPLETED, this.generation);
        this.keyEventExecutor.submit(signalingTask);
        loopUntil(IdleCondition.MOTION_INJECTION_HAS_COMPLETED, this.dynamicIdleProvider.get2());
        try {
            try {
                Preconditions.checkState(signalingTask.isDone(), "Motion event injection was signaled - but it wasnt done.");
                boolean zBooleanValue = ((Boolean) signalingTask.get()).booleanValue();
                loopMainThreadUntilIdle();
                return zBooleanValue;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e2) {
                if (e2.getCause() instanceof InjectEventSecurityException) {
                    throw ((InjectEventSecurityException) e2.getCause());
                }
                Throwables.throwIfUnchecked(e2.getCause() != null ? e2.getCause() : e2);
                Throwable cause = e2.getCause();
                ExecutionException cause2 = e2;
                if (cause != null) {
                    cause2 = e2.getCause();
                }
                throw new RuntimeException(cause2);
            }
        } catch (Throwable th) {
            loopMainThreadUntilIdle();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.test.espresso.UiController
    public boolean injectMotionEventSequence(Iterable<MotionEvent> iterable) throws InjectEventSecurityException {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkState(!Iterables.isEmpty(iterable), "Expecting non-empty events to inject");
        Preconditions.checkState(Looper.myLooper() == this.mainLooper, "Expecting to be on main thread!");
        initialize();
        final Iterator<MotionEvent> it = iterable.iterator();
        final long jUptimeMillis = SystemClock.uptimeMillis() - ((MotionEvent) Iterables.getFirst(iterable, null)).getEventTime();
        SignalingTask signalingTask = new SignalingTask(new Callable<Boolean>() { // from class: androidx.test.espresso.base.UiControllerImpl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                boolean zInjectMotionEventAsync = true;
                while (it.hasNext()) {
                    MotionEvent motionEvent = (MotionEvent) it.next();
                    long eventTime = (motionEvent.getEventTime() + jUptimeMillis) - SystemClock.uptimeMillis();
                    if (eventTime > 10) {
                        SystemClock.sleep(eventTime);
                    }
                    zInjectMotionEventAsync &= it.hasNext() ? UiControllerImpl.this.eventInjector.injectMotionEventAsync(motionEvent) : UiControllerImpl.this.eventInjector.injectMotionEvent(motionEvent);
                }
                return Boolean.valueOf(zInjectMotionEventAsync);
            }
        }, IdleCondition.MOTION_INJECTION_HAS_COMPLETED, this.generation);
        this.keyEventExecutor.submit(signalingTask);
        loopUntil(IdleCondition.MOTION_INJECTION_HAS_COMPLETED, this.dynamicIdleProvider.get2());
        try {
            try {
                Preconditions.checkState(signalingTask.isDone(), "MotionEvents injection was signaled - but it wasnt done.");
                boolean zBooleanValue = ((Boolean) signalingTask.get()).booleanValue();
                loopMainThreadUntilIdle();
                return zBooleanValue;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e2) {
                if (e2.getCause() instanceof InjectEventSecurityException) {
                    throw ((InjectEventSecurityException) e2.getCause());
                }
                Throwables.throwIfUnchecked(e2.getCause() != null ? e2.getCause() : e2);
                Throwable cause = e2.getCause();
                ExecutionException cause2 = e2;
                if (cause != null) {
                    cause2 = e2.getCause();
                }
                throw new RuntimeException(cause2);
            }
        } catch (Throwable th) {
            loopMainThreadUntilIdle();
            throw th;
        }
    }

    @Override // androidx.test.espresso.UiController
    public boolean injectString(String str) throws InjectEventSecurityException {
        Preconditions.checkNotNull(str);
        Preconditions.checkState(Looper.myLooper() == this.mainLooper, "Expecting to be on main thread!");
        initialize();
        if (str.isEmpty()) {
            Log.w(TAG, "Supplied string is empty resulting in no-op (nothing is typed).");
            return true;
        }
        KeyEvent[] events = getKeyCharacterMap().getEvents(str.toCharArray());
        if (events == null) {
            throw new RuntimeException(String.format(Locale.ROOT, "Failed to get key events for string %s (i.e. current IME does not understand how to translate the string into key events). As a workaround, you can use replaceText action to set the text directly in the EditText field.", str));
        }
        Log.d(TAG, String.format(Locale.ROOT, "Injecting string: \"%s\"", str));
        boolean zInjectKeyEvent = false;
        for (KeyEvent keyEvent : events) {
            Preconditions.checkNotNull(keyEvent, String.format(Locale.ROOT, "Failed to get event for character (%c) with key code (%s)", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getUnicodeChar())));
            KeyEvent keyEventChangeTimeRepeat = keyEvent;
            zInjectKeyEvent = false;
            for (int i = 0; !zInjectKeyEvent && i < 4; i++) {
                keyEventChangeTimeRepeat = KeyEvent.changeTimeRepeat(keyEventChangeTimeRepeat, SystemClock.uptimeMillis(), 0);
                zInjectKeyEvent = injectKeyEvent(keyEventChangeTimeRepeat);
            }
            if (!zInjectKeyEvent) {
                Log.e(TAG, String.format(Locale.ROOT, "Failed to inject event for character (%c) with key code (%s)", Integer.valueOf(keyEventChangeTimeRepeat.getUnicodeChar()), Integer.valueOf(keyEventChangeTimeRepeat.getKeyCode())));
                break;
            }
        }
        return zInjectKeyEvent;
    }

    public static KeyCharacterMap getKeyCharacterMap() {
        return KeyCharacterMap.load(-1);
    }

    @Override // androidx.test.espresso.base.IdlingUiController
    public IdlingResourceRegistry getIdlingResourceRegistry() {
        return this.idlingResourceRegistry;
    }

    @Override // androidx.test.espresso.UiController
    public void loopMainThreadUntilIdle() {
        initialize();
        Preconditions.checkState(Looper.myLooper() == this.mainLooper, "Expecting to be on main thread!");
        IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> idleNotifierLoopUntil = this.dynamicIdleProvider.get2();
        while (true) {
            EnumSet<IdleCondition> enumSetNoneOf = EnumSet.noneOf(IdleCondition.class);
            if (!this.asyncIdle.isIdleNow()) {
                this.asyncIdle.registerNotificationCallback(new SignalingTask(NO_OP, IdleCondition.ASYNC_TASKS_HAVE_IDLED, this.generation));
                enumSetNoneOf.add(IdleCondition.ASYNC_TASKS_HAVE_IDLED);
            }
            if (!this.compatIdle.isIdleNow()) {
                this.compatIdle.registerNotificationCallback(new SignalingTask(NO_OP, IdleCondition.COMPAT_TASKS_HAVE_IDLED, this.generation));
                enumSetNoneOf.add(IdleCondition.COMPAT_TASKS_HAVE_IDLED);
            }
            if (!idleNotifierLoopUntil.isIdleNow()) {
                final IdlingPolicy dynamicIdlingResourceWarningPolicy = IdlingPolicies.getDynamicIdlingResourceWarningPolicy();
                final IdlingPolicy dynamicIdlingResourceErrorPolicy = IdlingPolicies.getDynamicIdlingResourceErrorPolicy();
                final SignalingTask signalingTask = new SignalingTask(NO_OP, IdleCondition.DYNAMIC_TASKS_HAVE_IDLED, this.generation);
                idleNotifierLoopUntil.registerNotificationCallback(new IdlingResourceRegistry.IdleNotificationCallback() { // from class: androidx.test.espresso.base.UiControllerImpl.5
                    @Override // androidx.test.espresso.base.IdlingResourceRegistry.IdleNotificationCallback
                    public void resourcesStillBusyWarning(List<String> busyResourceNames) {
                        dynamicIdlingResourceWarningPolicy.handleTimeout(busyResourceNames, "IdlingResources are still busy!");
                    }

                    @Override // androidx.test.espresso.base.IdlingResourceRegistry.IdleNotificationCallback
                    public void resourcesHaveTimedOut(List<String> busyResourceNames) {
                        dynamicIdlingResourceErrorPolicy.handleTimeout(busyResourceNames, "IdlingResources have timed out!");
                        UiControllerImpl.this.controllerHandler.post(signalingTask);
                    }

                    @Override // androidx.test.espresso.base.IdlingResourceRegistry.IdleNotificationCallback
                    public void allResourcesIdle() {
                        UiControllerImpl.this.controllerHandler.post(signalingTask);
                    }
                });
                enumSetNoneOf.add(IdleCondition.DYNAMIC_TASKS_HAVE_IDLED);
            }
            try {
                idleNotifierLoopUntil = loopUntil(enumSetNoneOf, idleNotifierLoopUntil);
                this.asyncIdle.cancelCallback();
                this.compatIdle.cancelCallback();
                idleNotifierLoopUntil.cancelCallback();
                if (this.asyncIdle.isIdleNow() && this.compatIdle.isIdleNow() && idleNotifierLoopUntil.isIdleNow()) {
                    return;
                }
            } catch (Throwable th) {
                this.asyncIdle.cancelCallback();
                this.compatIdle.cancelCallback();
                idleNotifierLoopUntil.cancelCallback();
                throw th;
            }
        }
    }

    @Override // androidx.test.espresso.UiController
    public void loopMainThreadForAtLeast(long millisDelay) {
        initialize();
        Preconditions.checkState(Looper.myLooper() == this.mainLooper, "Expecting to be on main thread!");
        Preconditions.checkState(!IdleCondition.DELAY_HAS_PAST.isSignaled(this.conditionSet), "recursion detected!");
        Preconditions.checkArgument(millisDelay > 0);
        this.controllerHandler.postAtTime(new SignalingTask(NO_OP, IdleCondition.DELAY_HAS_PAST, this.generation), Integer.valueOf(this.generation), SystemClock.uptimeMillis() + millisDelay);
        loopUntil(IdleCondition.DELAY_HAS_PAST, this.dynamicIdleProvider.get2());
        loopMainThreadUntilIdle();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        if (IdleCondition.handleMessage(msg, this.conditionSet, this.generation)) {
            return true;
        }
        String str = TAG;
        String strValueOf = String.valueOf(msg);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
        sb.append("Unknown message type: ");
        sb.append(strValueOf);
        Log.i(str, sb.toString());
        return false;
    }

    private void loopUntil(IdleCondition condition, IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> dynamicIdle) {
        loopUntil(EnumSet.of(condition), dynamicIdle);
    }

    private IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> loopUntil(EnumSet<IdleCondition> conditions, IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> dynamicIdle) {
        IdlingPolicy masterIdlingPolicy = IdlingPolicies.getMasterIdlingPolicy();
        try {
            MainThreadInterrogation mainThreadInterrogation = new MainThreadInterrogation(conditions, this.conditionSet, SystemClock.uptimeMillis() + masterIdlingPolicy.getIdleTimeoutUnit().toMillis(masterIdlingPolicy.getIdleTimeout()));
            this.interrogation = mainThreadInterrogation;
            InterrogationStatus interrogationStatus = (InterrogationStatus) Interrogator.loopAndInterrogate(mainThreadInterrogation);
            if (InterrogationStatus.COMPLETED != interrogationStatus) {
                if (InterrogationStatus.INTERRUPTED == interrogationStatus) {
                    Log.w(TAG, "Espresso interrogation of the main thread is interrupted");
                    throw new RuntimeException("Espresso interrogation of the main thread is interrupted");
                }
                ArrayList arrayListNewArrayList = Lists.newArrayList();
                for (IdleCondition idleCondition : conditions) {
                    if (!idleCondition.isSignaled(this.conditionSet)) {
                        arrayListNewArrayList.add(idleCondition.name());
                    }
                }
                masterIdlingPolicy.handleTimeout(arrayListNewArrayList, String.format(Locale.ROOT, "Looped for %s iterations over %s %s.", Integer.valueOf(this.interrogation.execCount), Long.valueOf(masterIdlingPolicy.getIdleTimeout()), masterIdlingPolicy.getIdleTimeoutUnit().name()));
                this.generation++;
                Iterator it = conditions.iterator();
                while (it.hasNext()) {
                    ((IdleCondition) it.next()).reset(this.conditionSet);
                }
                this.interrogation = null;
                return dynamicIdle;
            }
            this.generation++;
            Iterator it2 = conditions.iterator();
            while (it2.hasNext()) {
                ((IdleCondition) it2.next()).reset(this.conditionSet);
            }
            this.interrogation = null;
            return dynamicIdle;
        } catch (Throwable th) {
            this.generation++;
            Iterator it3 = conditions.iterator();
            while (it3.hasNext()) {
                ((IdleCondition) it3.next()).reset(this.conditionSet);
            }
            this.interrogation = null;
            throw th;
        }
    }

    @Override // androidx.test.espresso.base.InterruptableUiController
    public void interruptEspressoTasks() {
        initialize();
        this.controllerHandler.post(new Runnable() { // from class: androidx.test.espresso.base.UiControllerImpl.6
            @Override // java.lang.Runnable
            public void run() {
                if (UiControllerImpl.this.interrogation != null) {
                    UiControllerImpl.this.interrogation.interruptInterrogation();
                    UiControllerImpl.this.controllerHandler.removeCallbacksAndMessages(Integer.valueOf(UiControllerImpl.this.generation));
                }
            }
        });
    }

    private static final class MainThreadInterrogation implements Interrogator.InterrogationHandler<InterrogationStatus> {
        private final BitSet conditionSet;
        private final EnumSet<IdleCondition> conditions;
        private final long giveUpAtMs;
        private InterrogationStatus status = InterrogationStatus.COMPLETED;
        private int execCount = 0;

        @Override // androidx.test.espresso.base.Interrogator.InterrogationHandler
        public void quitting() {
        }

        MainThreadInterrogation(EnumSet<IdleCondition> conditions, BitSet conditionSet, long giveUpAtMs) {
            this.conditions = conditions;
            this.conditionSet = conditionSet;
            this.giveUpAtMs = giveUpAtMs;
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public boolean barrierUp() {
            return continueOrTimeout();
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public boolean queueEmpty() {
            return !conditionsMet();
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public boolean taskDueSoon() {
            return continueOrTimeout();
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public boolean taskDueLong() {
            return !conditionsMet();
        }

        @Override // androidx.test.espresso.base.Interrogator.InterrogationHandler
        public boolean beforeTaskDispatch() {
            this.execCount++;
            return continueOrTimeout();
        }

        private boolean continueOrTimeout() {
            if (InterrogationStatus.INTERRUPTED == this.status) {
                return false;
            }
            if (SystemClock.uptimeMillis() < this.giveUpAtMs) {
                return true;
            }
            this.status = InterrogationStatus.TIMED_OUT;
            return false;
        }

        void interruptInterrogation() {
            this.status = InterrogationStatus.INTERRUPTED;
        }

        @Override // androidx.test.espresso.base.Interrogator.QueueInterrogationHandler
        public InterrogationStatus get() {
            return this.status;
        }

        private boolean conditionsMet() {
            boolean z = true;
            if (InterrogationStatus.INTERRUPTED == this.status) {
                return true;
            }
            int i = this.execCount;
            boolean z2 = i > 0 && i % 100 == 0;
            for (IdleCondition idleCondition : this.conditions) {
                if (!idleCondition.isSignaled(this.conditionSet)) {
                    if (!z2) {
                        return false;
                    }
                    String str = UiControllerImpl.TAG;
                    String strName = idleCondition.name();
                    int i2 = this.execCount;
                    StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 41);
                    sb.append("Waiting for: ");
                    sb.append(strName);
                    sb.append(" for ");
                    sb.append(i2);
                    sb.append(" iterations.");
                    Log.w(str, sb.toString());
                    z = false;
                }
            }
            return z;
        }
    }

    private void initialize() {
        if (this.controllerHandler == null) {
            this.controllerHandler = new Handler(this);
        }
    }

    private class SignalingTask<T> extends FutureTask<T> {
        private final IdleCondition condition;
        private final int myGeneration;

        public SignalingTask(Callable<T> callable, IdleCondition condition, int myGeneration) {
            super(callable);
            this.condition = (IdleCondition) Preconditions.checkNotNull(condition);
            this.myGeneration = myGeneration;
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            UiControllerImpl.this.controllerHandler.sendMessage(this.condition.createSignal(UiControllerImpl.this.controllerHandler, this.myGeneration));
        }
    }
}

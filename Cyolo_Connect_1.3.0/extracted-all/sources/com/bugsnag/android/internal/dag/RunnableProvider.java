package com.bugsnag.android.internal.dag;

import android.os.Looper;
import io.cyolo.android.MainActivityKt;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Provider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 \u0017*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\r\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00028\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0082\b¢\u0006\u0002\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\fJ\u000e\u0010\u0012\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0006\u0010\u0016\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bugsnag/android/internal/dag/RunnableProvider;", "E", "Lcom/bugsnag/android/internal/dag/Provider;", "Ljava/lang/Runnable;", "()V", "state", "Ljava/util/concurrent/atomic/AtomicInteger;", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "", "awaitResult", "", "get", "()Ljava/lang/Object;", "getOr", "failureHandler", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrNull", "invoke", "isComplete", "", "isMainThread", "run", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class RunnableProvider<E> implements Provider<E>, Runnable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TASK_STATE_COMPLETE = 2;
    private static final int TASK_STATE_FAILED = 999;
    private static final int TASK_STATE_PENDING = 0;
    private static final int TASK_STATE_RUNNING = 1;
    private static Thread _mainThread;
    private final AtomicInteger state = new AtomicInteger(0);
    private volatile Object value;

    public abstract E invoke();

    private final E getOr(Function0<? extends E> failureHandler) {
        while (true) {
            int i = this.state.get();
            if (i != 0) {
                if (i == 1) {
                    awaitResult();
                } else {
                    if (i == 2) {
                        return (E) this.value;
                    }
                    if (i == 999) {
                        failureHandler.invoke();
                    }
                }
            } else if (isMainThread()) {
                awaitResult();
            } else {
                run();
            }
        }
    }

    private final boolean isMainThread() {
        return Thread.currentThread() == INSTANCE.getMainThread$bugsnag_android_core_release();
    }

    private final void awaitResult() {
        synchronized (this) {
            while (!isComplete()) {
                wait();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final boolean isComplete() {
        int i = this.state.get();
        return (i == 0 || i == 1) ? false : true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.state.compareAndSet(0, 1)) {
            try {
                this.value = invoke();
                this.state.set(2);
            } catch (Throwable th) {
                try {
                    this.value = th;
                    this.state.set(999);
                    synchronized (this) {
                        notifyAll();
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Throwable th2) {
                    synchronized (this) {
                        notifyAll();
                        Unit unit2 = Unit.INSTANCE;
                        throw th2;
                    }
                }
            }
            synchronized (this) {
                notifyAll();
                Unit unit3 = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: compiled from: Provider.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0081\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u0004\u0018\u00010\t8@@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bugsnag/android/internal/dag/RunnableProvider$Companion;", "", "()V", "TASK_STATE_COMPLETE", "", "TASK_STATE_FAILED", "TASK_STATE_PENDING", "TASK_STATE_RUNNING", "_mainThread", "Ljava/lang/Thread;", "get_mainThread$bugsnag_android_core_release$annotations", "get_mainThread$bugsnag_android_core_release", "()Ljava/lang/Thread;", "set_mainThread$bugsnag_android_core_release", "(Ljava/lang/Thread;)V", "mainThread", "getMainThread$bugsnag_android_core_release", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void get_mainThread$bugsnag_android_core_release$annotations() {
        }

        private Companion() {
        }

        public final void set_mainThread$bugsnag_android_core_release(Thread thread) {
            RunnableProvider._mainThread = thread;
        }

        public final Thread get_mainThread$bugsnag_android_core_release() {
            if (RunnableProvider._mainThread == null) {
                RunnableProvider._mainThread = Looper.getMainLooper().getThread();
            }
            return RunnableProvider._mainThread;
        }

        public final Thread getMainThread$bugsnag_android_core_release() {
            Thread thread = get_mainThread$bugsnag_android_core_release();
            Intrinsics.checkNotNull(thread);
            return thread;
        }
    }

    @Override // com.bugsnag.android.internal.dag.Provider
    public E getOrNull() {
        while (true) {
            int i = this.state.get();
            if (i != 0) {
                if (i == 1) {
                    awaitResult();
                } else {
                    if (i == 2) {
                        return (E) this.value;
                    }
                    if (i == 999) {
                        return null;
                    }
                }
            } else if (isMainThread()) {
                awaitResult();
            } else {
                run();
            }
        }
    }

    @Override // com.bugsnag.android.internal.dag.Provider
    public E get() throws Throwable {
        while (true) {
            int i = this.state.get();
            if (i != 0) {
                if (i == 1) {
                    awaitResult();
                } else {
                    if (i == 2) {
                        return (E) this.value;
                    }
                    if (i == 999) {
                        Object obj = this.value;
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                        throw ((Throwable) obj);
                    }
                }
            } else if (isMainThread()) {
                awaitResult();
            } else {
                run();
            }
        }
    }
}

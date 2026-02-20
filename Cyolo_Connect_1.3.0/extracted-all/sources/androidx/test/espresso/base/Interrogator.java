package androidx.test.espresso.base;

import android.os.Binder;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Throwables;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class Interrogator {
    private static final int LOOKAHEAD_MILLIS = 15;
    private static final String TAG = "Interrogator";
    private static final ThreadLocal<Boolean> interrogating = new ThreadLocal<Boolean>() { // from class: androidx.test.espresso.base.Interrogator.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };
    private static final Field messageQueueHeadField;
    private static final Method messageQueueNextMethod;
    private static final Method recycleUncheckedMethod;

    interface InterrogationHandler<R> extends QueueInterrogationHandler<R> {
        boolean beforeTaskDispatch();

        void quitting();
    }

    interface QueueInterrogationHandler<R> {
        boolean barrierUp();

        R get();

        boolean queueEmpty();

        boolean taskDueLong();

        boolean taskDueSoon();
    }

    Interrogator() {
    }

    static {
        try {
            Method declaredMethod = MessageQueue.class.getDeclaredMethod("next", new Class[0]);
            messageQueueNextMethod = declaredMethod;
            declaredMethod.setAccessible(true);
            Field declaredField = MessageQueue.class.getDeclaredField("mMessages");
            messageQueueHeadField = declaredField;
            declaredField.setAccessible(true);
            Method declaredMethod2 = null;
            try {
                declaredMethod2 = Message.class.getDeclaredMethod("recycleUnchecked", new Class[0]);
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            recycleUncheckedMethod = declaredMethod2;
        } catch (IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException e) {
            Log.e(TAG, "Could not initialize interrogator!", e);
            throw new RuntimeException("Could not initialize interrogator!", e);
        }
    }

    static <R> R loopAndInterrogate(InterrogationHandler<R> handler) {
        checkSanity();
        interrogating.set(Boolean.TRUE);
        MessageQueue messageQueueMyQueue = Looper.myQueue();
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            long jClearCallingIdentity2 = Binder.clearCallingIdentity();
            boolean zInterrogateQueueState = true;
            while (zInterrogateQueueState) {
                zInterrogateQueueState = interrogateQueueState(messageQueueMyQueue, handler);
                if (zInterrogateQueueState) {
                    Message nextMessage = getNextMessage();
                    if (nextMessage == null) {
                        handler.quitting();
                        return handler.get();
                    }
                    boolean zBeforeTaskDispatch = handler.beforeTaskDispatch();
                    nextMessage.getTarget().dispatchMessage(nextMessage);
                    long jClearCallingIdentity3 = Binder.clearCallingIdentity();
                    if (jClearCallingIdentity3 != jClearCallingIdentity2) {
                        String hexString = Long.toHexString(jClearCallingIdentity2);
                        String hexString2 = Long.toHexString(jClearCallingIdentity3);
                        String name = nextMessage.getTarget().getClass().getName();
                        String strValueOf = String.valueOf(nextMessage.getCallback());
                        int i = nextMessage.what;
                        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 77 + String.valueOf(hexString2).length() + String.valueOf(name).length() + String.valueOf(strValueOf).length());
                        sb.append("Thread identity changed from 0x");
                        sb.append(hexString);
                        sb.append(" to 0x");
                        sb.append(hexString2);
                        sb.append(" while dispatching to ");
                        sb.append(name);
                        sb.append(" ");
                        sb.append(strValueOf);
                        sb.append(" what=");
                        sb.append(i);
                        Log.wtf(TAG, sb.toString());
                    }
                    recycle(nextMessage);
                    zInterrogateQueueState = zBeforeTaskDispatch;
                }
            }
            return handler.get();
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            interrogating.set(Boolean.FALSE);
        }
    }

    private static void recycle(Message m) {
        Method method = recycleUncheckedMethod;
        if (method != null) {
            try {
                method.invoke(m, new Object[0]);
                return;
            } catch (IllegalAccessException e) {
                e = e;
                Throwables.throwIfUnchecked(e);
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e2) {
                e = e2;
                Throwables.throwIfUnchecked(e);
                throw new RuntimeException(e);
            } catch (SecurityException e3) {
                e = e3;
                Throwables.throwIfUnchecked(e);
                throw new RuntimeException(e);
            } catch (InvocationTargetException e4) {
                if (e4.getCause() != null) {
                    Throwables.throwIfUnchecked(e4.getCause());
                    throw new RuntimeException(e4.getCause());
                }
                throw new RuntimeException(e4);
            }
        }
        m.recycle();
    }

    private static Message getNextMessage() {
        try {
            return (Message) messageQueueNextMethod.invoke(Looper.myQueue(), new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException | InvocationTargetException e) {
            Throwables.throwIfUnchecked(e);
            throw new RuntimeException(e);
        }
    }

    static <R> R peekAtQueueState(MessageQueue q, QueueInterrogationHandler<R> handler) {
        Preconditions.checkNotNull(q);
        Preconditions.checkNotNull(handler);
        Preconditions.checkState(!interrogateQueueState(q, handler), "It is expected that %s would stop interrogation after a single peak at the queue.", handler);
        return handler.get();
    }

    private static boolean interrogateQueueState(MessageQueue q, QueueInterrogationHandler<?> handler) {
        synchronized (q) {
            try {
                try {
                    Message message = (Message) messageQueueHeadField.get(q);
                    if (message == null) {
                        return handler.queueEmpty();
                    }
                    if (message.getTarget() == null) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "barrier is up");
                        }
                        return handler.barrierUp();
                    }
                    long when = message.getWhen();
                    long jUptimeMillis = SystemClock.uptimeMillis() + 15;
                    if (Log.isLoggable(TAG, 3)) {
                        boolean z = jUptimeMillis < when;
                        StringBuilder sb = new StringBuilder(75);
                        sb.append("headWhen: ");
                        sb.append(when);
                        sb.append(" nowFuz: ");
                        sb.append(jUptimeMillis);
                        sb.append(" due long: ");
                        sb.append(z);
                        Log.d(TAG, sb.toString());
                    }
                    if (jUptimeMillis > when) {
                        return handler.taskDueSoon();
                    }
                    return handler.taskDueLong();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void checkSanity() {
        Preconditions.checkState(Looper.myLooper() != null, "Calling non-looper thread!");
        Preconditions.checkState(Boolean.FALSE.equals(interrogating.get()), "Already interrogating!");
    }
}

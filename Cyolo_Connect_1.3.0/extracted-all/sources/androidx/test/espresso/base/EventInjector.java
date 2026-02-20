package androidx.test.espresso.base;

import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;

/* JADX INFO: loaded from: classes.dex */
final class EventInjector {
    private static final String TAG = "EventInjector";
    private final EventInjectionStrategy injectionStrategy;

    EventInjector(EventInjectionStrategy injectionStrategy) {
        this.injectionStrategy = (EventInjectionStrategy) Preconditions.checkNotNull(injectionStrategy);
    }

    boolean injectKeyEvent(KeyEvent event) throws InjectEventSecurityException {
        long downTime = event.getDownTime();
        long eventTime = event.getEventTime();
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        int repeatCount = event.getRepeatCount();
        int metaState = event.getMetaState();
        int deviceId = event.getDeviceId();
        int scanCode = event.getScanCode();
        int flags = event.getFlags();
        if (eventTime == 0) {
            eventTime = SystemClock.uptimeMillis();
        }
        long j = eventTime;
        return this.injectionStrategy.injectKeyEvent(new KeyEvent(downTime == 0 ? j : downTime, j, action, keyCode, repeatCount, metaState, deviceId, scanCode, flags | 8, event.getSource()));
    }

    boolean injectMotionEvent(MotionEvent event) throws InjectEventSecurityException {
        return this.injectionStrategy.injectMotionEvent(event, true);
    }

    boolean injectMotionEventAsync(MotionEvent event) throws InjectEventSecurityException {
        return this.injectionStrategy.injectMotionEvent(event, false);
    }
}

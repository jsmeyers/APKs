package androidx.test.espresso.base;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class InputManagerEventInjectionStrategy implements EventInjectionStrategy {
    private static final long KEYBOARD_DISMISSAL_DELAY_MILLIS = 1000;
    private static final String TAG = "EventInjectionStrategy";
    private int asyncEventMode;
    private boolean initComplete;
    private Method injectInputEventMethod;
    private Object instanceInputManagerObject;
    private Method setSourceMotionMethod;
    private int syncEventMode;

    InputManagerEventInjectionStrategy() {
        Preconditions.checkState(true, "Unsupported API level.");
    }

    void initialize() {
        if (this.initComplete) {
            return;
        }
        try {
            Log.d(TAG, "Creating injection strategy with input manager.");
            Class<?> cls = Class.forName("android.hardware.input.InputManager");
            Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(cls, new Object[0]);
            this.instanceInputManagerObject = objInvoke;
            Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("injectInputEvent", InputEvent.class, Integer.TYPE);
            this.injectInputEventMethod = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Field field = cls.getField("INJECT_INPUT_EVENT_MODE_WAIT_FOR_FINISH");
            field.setAccessible(true);
            this.syncEventMode = field.getInt(cls);
            if (Build.VERSION.SDK_INT >= 28) {
                this.asyncEventMode = 0;
            } else {
                Field field2 = cls.getField("INJECT_INPUT_EVENT_MODE_ASYNC");
                field2.setAccessible(true);
                this.asyncEventMode = field2.getInt(cls);
            }
            this.setSourceMotionMethod = MotionEvent.class.getDeclaredMethod("setSource", Integer.TYPE);
            this.initComplete = true;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchFieldException e3) {
            throw new RuntimeException(e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override // androidx.test.espresso.base.EventInjectionStrategy
    public boolean injectKeyEvent(KeyEvent keyEvent) throws InjectEventSecurityException {
        try {
            return ((Boolean) this.injectInputEventMethod.invoke(this.instanceInputManagerObject, keyEvent, Integer.valueOf(this.syncEventMode))).booleanValue();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e2) {
            throw new InjectEventSecurityException(e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof SecurityException) {
                throw new InjectEventSecurityException(cause);
            }
            throw new RuntimeException(e3);
        }
    }

    @Override // androidx.test.espresso.base.EventInjectionStrategy
    public boolean injectMotionEvent(MotionEvent motionEvent, boolean sync) throws InjectEventSecurityException {
        return innerInjectMotionEvent(motionEvent, true, sync);
    }

    private boolean innerInjectMotionEvent(MotionEvent motionEvent, boolean shouldRetry, boolean sync) throws InjectEventSecurityException {
        try {
            if ((motionEvent.getSource() & 2) == 0 && !isFromTouchpadInGlassDevice(motionEvent)) {
                this.setSourceMotionMethod.invoke(motionEvent, Integer.valueOf(InputDeviceCompat.SOURCE_TOUCHSCREEN));
            }
            return ((Boolean) this.injectInputEventMethod.invoke(this.instanceInputManagerObject, motionEvent, Integer.valueOf(sync ? this.syncEventMode : this.asyncEventMode))).booleanValue();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (SecurityException e3) {
            throw new InjectEventSecurityException(e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (!(cause instanceof SecurityException)) {
                throw new RuntimeException(e4);
            }
            if (shouldRetry) {
                Log.w(TAG, "Error performing a ViewAction! soft keyboard dismissal animation may have been in the way. Retrying once after: 1000 millis");
                SystemClock.sleep(KEYBOARD_DISMISSAL_DELAY_MILLIS);
                innerInjectMotionEvent(motionEvent, false, sync);
                return false;
            }
            throw new InjectEventSecurityException(cause);
        }
    }

    private static boolean isFromTouchpadInGlassDevice(MotionEvent motionEvent) {
        return (Build.DEVICE.contains("glass") || Build.DEVICE.contains("Glass") || Build.DEVICE.contains("wingman")) && (motionEvent.getSource() & InputDeviceCompat.SOURCE_TOUCHPAD) != 0;
    }
}

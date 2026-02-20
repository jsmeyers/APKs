package androidx.test.espresso.base;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.test.espresso.InjectEventSecurityException;

/* JADX INFO: loaded from: classes.dex */
interface EventInjectionStrategy {
    boolean injectKeyEvent(KeyEvent keyEvent) throws InjectEventSecurityException;

    boolean injectMotionEvent(MotionEvent me, boolean sync) throws InjectEventSecurityException;
}

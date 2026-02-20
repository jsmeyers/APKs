package androidx.test.espresso.base;

import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.UiController$$CC;
import androidx.test.internal.platform.ServiceLoaderWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UiControllerModule {
    public UiController provideUiController(UiControllerImpl uiControllerImpl) {
        List listLoadService = ServiceLoaderWrapper.loadService(androidx.test.platform.ui.UiController.class);
        if (listLoadService.isEmpty()) {
            return uiControllerImpl;
        }
        if (listLoadService.size() == 1) {
            return new EspressoUiControllerAdapter((androidx.test.platform.ui.UiController) listLoadService.get(0));
        }
        throw new IllegalStateException("Found more than one androidx.test.internal.platform.UiController");
    }

    private static class EspressoUiControllerAdapter implements InterruptableUiController {
        private final androidx.test.platform.ui.UiController platformUiController;

        @Override // androidx.test.espresso.UiController
        public boolean injectMotionEventSequence(Iterable iterable) throws InjectEventSecurityException {
            return UiController$$CC.injectMotionEventSequence$$dflt$$(this, iterable);
        }

        private EspressoUiControllerAdapter(androidx.test.platform.ui.UiController platformUiController) {
            this.platformUiController = platformUiController;
        }

        @Override // androidx.test.espresso.UiController
        public boolean injectMotionEvent(MotionEvent event) throws InjectEventSecurityException {
            try {
                return this.platformUiController.injectMotionEvent(event);
            } catch (androidx.test.platform.ui.InjectEventSecurityException e) {
                throw new InjectEventSecurityException(e);
            }
        }

        @Override // androidx.test.espresso.UiController
        public boolean injectKeyEvent(KeyEvent event) throws InjectEventSecurityException {
            try {
                return this.platformUiController.injectKeyEvent(event);
            } catch (androidx.test.platform.ui.InjectEventSecurityException e) {
                throw new InjectEventSecurityException(e);
            }
        }

        @Override // androidx.test.espresso.UiController
        public boolean injectString(String str) throws InjectEventSecurityException {
            try {
                return this.platformUiController.injectString(str);
            } catch (androidx.test.platform.ui.InjectEventSecurityException e) {
                throw new InjectEventSecurityException(e);
            }
        }

        @Override // androidx.test.espresso.UiController
        public void loopMainThreadUntilIdle() {
            this.platformUiController.loopMainThreadUntilIdle();
        }

        @Override // androidx.test.espresso.UiController
        public void loopMainThreadForAtLeast(long millisDelay) {
            this.platformUiController.loopMainThreadForAtLeast(millisDelay);
        }

        @Override // androidx.test.espresso.base.InterruptableUiController
        public void interruptEspressoTasks() {
            Log.w("UiController", "interruptEspressoTasks called, no-op");
        }
    }
}

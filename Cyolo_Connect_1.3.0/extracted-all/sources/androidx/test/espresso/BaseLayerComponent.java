package androidx.test.espresso;

import androidx.test.espresso.base.ActiveRootLister;
import androidx.test.espresso.base.BaseLayerModule;
import androidx.test.espresso.base.IdlingResourceRegistry;
import androidx.test.espresso.base.MainThread;
import androidx.test.internal.platform.os.ControlledLooper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface BaseLayerComponent {
    ActiveRootLister activeRootLister();

    ControlledLooper controlledLooper();

    FailureHandler failureHandler();

    BaseLayerModule.FailureHandlerHolder failureHolder();

    IdlingResourceRegistry idlingResourceRegistry();

    @MainThread
    Executor mainThreadExecutor();

    ViewInteractionComponent plus(ViewInteractionModule module);

    UiController uiController();
}

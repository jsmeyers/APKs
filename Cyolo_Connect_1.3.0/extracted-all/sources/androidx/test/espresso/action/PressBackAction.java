package androidx.test.espresso.action;

import android.app.Activity;
import android.view.View;
import androidx.test.espresso.UiController;
import androidx.test.espresso.action.EspressoKey;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class PressBackAction extends KeyEventActionBase {
    private final boolean conditional;

    @Override // androidx.test.espresso.action.KeyEventActionBase, androidx.test.espresso.ViewAction
    public /* bridge */ /* synthetic */ Matcher getConstraints() {
        return super.getConstraints();
    }

    @Override // androidx.test.espresso.action.KeyEventActionBase, androidx.test.espresso.ViewAction
    public /* bridge */ /* synthetic */ String getDescription() {
        return super.getDescription();
    }

    public PressBackAction(boolean conditional) {
        this(conditional, new EspressoKey.Builder().withKeyCode(4).build());
    }

    public PressBackAction(boolean conditional, EspressoKey espressoKey) {
        super(espressoKey);
        this.conditional = conditional;
    }

    @Override // androidx.test.espresso.action.KeyEventActionBase, androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        Activity currentActivity = getCurrentActivity();
        super.perform(uiController, view);
        waitForStageChangeInitialActivity(uiController, currentActivity);
        waitForPendingForegroundActivities(uiController, this.conditional);
    }
}

package androidx.test.espresso.action;

import android.view.KeyEvent;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.remote.annotation.RemoteMsgConstructor;
import androidx.test.espresso.remote.annotation.RemoteMsgField;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class EspressoKey {

    @RemoteMsgField(order = 0)
    private final int keyCode;

    @RemoteMsgField(order = 1)
    private final int metaState;

    private EspressoKey(Builder builder) {
        this(builder.builderKeyCode, builder.getMetaState());
    }

    @RemoteMsgConstructor
    EspressoKey(int keyCode, int metaState) {
        this.keyCode = keyCode;
        this.metaState = metaState;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    public int getMetaState() {
        return this.metaState;
    }

    public String toString() {
        return String.format(Locale.ROOT, "keyCode: %s, metaState: %s", Integer.valueOf(this.keyCode), Integer.valueOf(this.metaState));
    }

    public static class Builder {
        private int builderKeyCode = -1;
        private boolean isAltPressed;
        private boolean isCtrlPressed;
        private boolean isShiftPressed;

        public Builder withKeyCode(int keyCode) {
            this.builderKeyCode = keyCode;
            return this;
        }

        public Builder withShiftPressed(boolean shiftPressed) {
            this.isShiftPressed = shiftPressed;
            return this;
        }

        public Builder withCtrlPressed(boolean ctrlPressed) {
            this.isCtrlPressed = ctrlPressed;
            return this;
        }

        public Builder withAltPressed(boolean altPressed) {
            this.isAltPressed = altPressed;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        public int getMetaState() {
            boolean z = this.isShiftPressed;
            ?? r0 = z;
            if (this.isAltPressed) {
                r0 = (z ? 1 : 0) | 2;
            }
            return this.isCtrlPressed ? r0 | 4096 : r0;
        }

        public EspressoKey build() {
            int i = this.builderKeyCode;
            Preconditions.checkState(i > 0 && i < KeyEvent.getMaxKeyCode(), "Invalid key code: %s", this.builderKeyCode);
            return new EspressoKey(this);
        }
    }
}

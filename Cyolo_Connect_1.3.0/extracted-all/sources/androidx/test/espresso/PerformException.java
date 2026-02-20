package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.internal.platform.util.TestOutputEmitter;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class PerformException extends RuntimeException implements EspressoException {
    private static final String MESSAGE_FORMAT = "Error performing '%s' on view '%s'.";
    private final String actionDescription;
    private final String viewDescription;

    private PerformException(Builder builder) {
        super(String.format(Locale.ROOT, MESSAGE_FORMAT, builder.actionDescription, builder.viewDescription), builder.cause);
        this.actionDescription = (String) Preconditions.checkNotNull(builder.actionDescription);
        this.viewDescription = (String) Preconditions.checkNotNull(builder.viewDescription);
        TestOutputEmitter.dumpThreadStates("ThreadState-PerformException.txt");
    }

    public String getActionDescription() {
        return this.actionDescription;
    }

    public String getViewDescription() {
        return this.viewDescription;
    }

    public static class Builder {
        private String actionDescription;
        private Throwable cause;
        private String viewDescription;

        public Builder from(PerformException instance) {
            this.actionDescription = instance.getActionDescription();
            this.viewDescription = instance.getViewDescription();
            this.cause = instance.getCause();
            return this;
        }

        public Builder withActionDescription(String actionDescription) {
            this.actionDescription = actionDescription;
            return this;
        }

        public Builder withViewDescription(String viewDescription) {
            this.viewDescription = viewDescription;
            return this;
        }

        public Builder withCause(Throwable cause) {
            this.cause = cause;
            return this;
        }

        public PerformException build() {
            return new PerformException(this);
        }
    }
}

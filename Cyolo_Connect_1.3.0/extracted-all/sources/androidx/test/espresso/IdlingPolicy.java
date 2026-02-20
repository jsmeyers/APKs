package androidx.test.espresso;

import android.util.Log;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class IdlingPolicy {
    private static final String TAG = "IdlingPolicy";
    private final ResponseAction errorHandler;
    private final long idleTimeout;
    private final TimeUnit unit;

    private enum ResponseAction {
        THROW_APP_NOT_IDLE,
        THROW_IDLE_TIMEOUT,
        LOG_ERROR
    }

    /* synthetic */ IdlingPolicy(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public long getIdleTimeout() {
        return this.idleTimeout;
    }

    public TimeUnit getIdleTimeoutUnit() {
        return this.unit;
    }

    /* JADX INFO: renamed from: androidx.test.espresso.IdlingPolicy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$test$espresso$IdlingPolicy$ResponseAction;

        static {
            int[] iArr = new int[ResponseAction.values().length];
            $SwitchMap$androidx$test$espresso$IdlingPolicy$ResponseAction = iArr;
            try {
                iArr[ResponseAction.THROW_APP_NOT_IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$test$espresso$IdlingPolicy$ResponseAction[ResponseAction.THROW_IDLE_TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$test$espresso$IdlingPolicy$ResponseAction[ResponseAction.LOG_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void handleTimeout(List<String> busyResources, String message) {
        int i = AnonymousClass1.$SwitchMap$androidx$test$espresso$IdlingPolicy$ResponseAction[this.errorHandler.ordinal()];
        if (i == 1) {
            throw AppNotIdleException.create(busyResources, message);
        }
        if (i == 2) {
            throw new IdlingResourceTimeoutException(busyResources);
        }
        if (i == 3) {
            String strValueOf = String.valueOf(busyResources);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 30);
            sb.append("These resources are not idle: ");
            sb.append(strValueOf);
            Log.w(TAG, sb.toString());
            return;
        }
        String strValueOf2 = String.valueOf(busyResources);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 24);
        sb2.append("should never reach here.");
        sb2.append(strValueOf2);
        throw new IllegalStateException(sb2.toString());
    }

    Builder toBuilder() {
        return new Builder(this, null);
    }

    private IdlingPolicy(Builder builder) {
        Preconditions.checkArgument(builder.idleTimeout > 0);
        this.idleTimeout = builder.idleTimeout;
        this.unit = (TimeUnit) Preconditions.checkNotNull(builder.unit);
        this.errorHandler = (ResponseAction) Preconditions.checkNotNull(builder.errorHandler);
    }

    static class Builder {
        private ResponseAction errorHandler;
        private long idleTimeout;
        private TimeUnit unit;

        /* synthetic */ Builder(IdlingPolicy idlingPolicy, AnonymousClass1 anonymousClass1) {
            this(idlingPolicy);
        }

        public Builder() {
            this.idleTimeout = -1L;
            this.unit = null;
            this.errorHandler = null;
        }

        private Builder(IdlingPolicy copy) {
            this.idleTimeout = -1L;
            this.unit = null;
            this.errorHandler = null;
            this.idleTimeout = copy.idleTimeout;
            this.unit = copy.unit;
            this.errorHandler = copy.errorHandler;
        }

        public IdlingPolicy build() {
            return new IdlingPolicy(this, null);
        }

        public Builder withIdlingTimeout(long idleTimeout) {
            this.idleTimeout = idleTimeout;
            return this;
        }

        public Builder withIdlingTimeoutUnit(TimeUnit unit) {
            this.unit = unit;
            return this;
        }

        public Builder throwAppNotIdleException() {
            this.errorHandler = ResponseAction.THROW_APP_NOT_IDLE;
            return this;
        }

        public Builder throwIdlingResourceTimeoutException() {
            this.errorHandler = ResponseAction.THROW_IDLE_TIMEOUT;
            return this;
        }

        public Builder logWarning() {
            this.errorHandler = ResponseAction.LOG_ERROR;
            return this;
        }
    }
}

package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Thread implements JsonStream.Streamable {
    private final ThreadInternal impl;
    private final Logger logger;

    Thread(String str, String str2, ErrorType errorType, boolean z, State state, Logger logger) {
        this.impl = new ThreadInternal(str, str2, errorType, z, state.getDescriptor(), new Stacktrace(new ArrayList()));
        this.logger = logger;
    }

    Thread(String str, String str2, ErrorType errorType, boolean z, State state, Stacktrace stacktrace, Logger logger) {
        this.impl = new ThreadInternal(str, str2, errorType, z, state.getDescriptor(), stacktrace);
        this.logger = logger;
    }

    Thread(ThreadInternal threadInternal, Logger logger) {
        this.impl = threadInternal;
        this.logger = logger;
    }

    private void logNull(String str) {
        this.logger.e("Invalid null value supplied to thread." + str + ", ignoring");
    }

    public void setId(String str) {
        if (str != null) {
            this.impl.setId(str);
        } else {
            logNull("id");
        }
    }

    public String getId() {
        return this.impl.getId();
    }

    public void setName(String str) {
        if (str != null) {
            this.impl.setName(str);
        } else {
            logNull("name");
        }
    }

    public String getName() {
        return this.impl.getName();
    }

    public void setType(ErrorType errorType) {
        if (errorType != null) {
            this.impl.setType(errorType);
        } else {
            logNull("type");
        }
    }

    public ErrorType getType() {
        return this.impl.getType();
    }

    public void setState(State state) {
        if (state != null) {
            this.impl.setState(state.getDescriptor());
        } else {
            logNull("state");
        }
    }

    public State getState() {
        return State.byDescriptor(this.impl.getState());
    }

    public boolean getErrorReportingThread() {
        return this.impl.getIsErrorReportingThread();
    }

    public void setStacktrace(List<Stackframe> list) {
        if (!CollectionUtils.containsNullElements(list)) {
            this.impl.setStacktrace(list);
        } else {
            logNull("stacktrace");
        }
    }

    public List<Stackframe> getStacktrace() {
        return this.impl.getStacktrace();
    }

    public Stackframe addStackframe(String str, String str2, long j) {
        return this.impl.addStackframe(str, str2, j);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        this.impl.toStream(jsonStream);
    }

    public enum State {
        NEW("NEW"),
        BLOCKED("BLOCKED"),
        RUNNABLE("RUNNABLE"),
        TERMINATED("TERMINATED"),
        TIMED_WAITING("TIMED_WAITING"),
        WAITING("WAITING"),
        UNKNOWN("UNKNOWN");

        private final String descriptor;

        State(String str) {
            this.descriptor = str;
        }

        public String getDescriptor() {
            return this.descriptor;
        }

        public static State forThread(java.lang.Thread thread) {
            return getState(thread.getState());
        }

        public static State byDescriptor(String str) {
            if (str == null) {
                return UNKNOWN;
            }
            for (State state : values()) {
                if (state.getDescriptor().equals(str)) {
                    return state;
                }
            }
            return UNKNOWN;
        }

        private static State getState(Thread.State state) {
            switch (AnonymousClass1.$SwitchMap$java$lang$Thread$State[state.ordinal()]) {
                case 1:
                    return NEW;
                case 2:
                    return BLOCKED;
                case 3:
                    return RUNNABLE;
                case 4:
                    return TERMINATED;
                case 5:
                    return TIMED_WAITING;
                case 6:
                    return WAITING;
                default:
                    return UNKNOWN;
            }
        }
    }

    /* JADX INFO: renamed from: com.bugsnag.android.Thread$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$lang$Thread$State;

        static {
            int[] iArr = new int[Thread.State.values().length];
            $SwitchMap$java$lang$Thread$State = iArr;
            try {
                iArr[Thread.State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$lang$Thread$State[Thread.State.BLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$lang$Thread$State[Thread.State.RUNNABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$lang$Thread$State[Thread.State.TERMINATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$lang$Thread$State[Thread.State.TIMED_WAITING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$lang$Thread$State[Thread.State.WAITING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}

package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ErrorInternal.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B+\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/bugsnag/android/ErrorInternal;", "Lcom/bugsnag/android/JsonStream$Streamable;", "errorClass", "", "errorMessage", "stacktrace", "Lcom/bugsnag/android/Stacktrace;", "type", "Lcom/bugsnag/android/ErrorType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bugsnag/android/Stacktrace;Lcom/bugsnag/android/ErrorType;)V", "getErrorClass", "()Ljava/lang/String;", "setErrorClass", "(Ljava/lang/String;)V", "getErrorMessage", "setErrorMessage", "", "Lcom/bugsnag/android/Stackframe;", "getStacktrace", "()Ljava/util/List;", "getType", "()Lcom/bugsnag/android/ErrorType;", "setType", "(Lcom/bugsnag/android/ErrorType;)V", "addStackframe", "method", "file", "lineNumber", "", "toStream", "", "writer", "Lcom/bugsnag/android/JsonStream;", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ErrorInternal implements JsonStream.Streamable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String errorClass;
    private String errorMessage;
    private final List<Stackframe> stacktrace;
    private ErrorType type;

    public ErrorInternal(String str, String str2, Stacktrace stacktrace) {
        this(str, str2, stacktrace, null, 8, null);
    }

    public ErrorInternal(String str, String str2, Stacktrace stacktrace, ErrorType errorType) {
        this.errorClass = str;
        this.errorMessage = str2;
        this.type = errorType;
        this.stacktrace = stacktrace.getTrace();
    }

    public final String getErrorClass() {
        return this.errorClass;
    }

    public final void setErrorClass(String str) {
        this.errorClass = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public /* synthetic */ ErrorInternal(String str, String str2, Stacktrace stacktrace, ErrorType errorType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, stacktrace, (i & 8) != 0 ? ErrorType.ANDROID : errorType);
    }

    public final ErrorType getType() {
        return this.type;
    }

    public final void setType(ErrorType errorType) {
        this.type = errorType;
    }

    public final List<Stackframe> getStacktrace() {
        return this.stacktrace;
    }

    public final Stackframe addStackframe(String method, String file, long lineNumber) {
        Stackframe stackframe = new Stackframe(method, file, Long.valueOf(lineNumber), null, null, null, 48, null);
        this.stacktrace.add(stackframe);
        return stackframe;
    }

    /* JADX INFO: compiled from: ErrorInternal.kt */
    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/bugsnag/android/ErrorInternal$Companion;", "", "()V", "createError", "", "Lcom/bugsnag/android/Error;", "exc", "", "projectPackages", "", "", "logger", "Lcom/bugsnag/android/Logger;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Error> createError(Throwable exc, Collection<String> projectPackages, Logger logger) {
            List<Throwable> listSafeUnrollCauses = ThrowableUtils.safeUnrollCauses(exc);
            ArrayList arrayList = new ArrayList();
            for (Throwable th : listSafeUnrollCauses) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                if (stackTrace == null) {
                    stackTrace = new StackTraceElement[0];
                }
                arrayList.add(new Error(new ErrorInternal(th.getClass().getName(), th.getLocalizedMessage(), new Stacktrace(stackTrace, projectPackages, logger), null, 8, null), logger));
            }
            return arrayList;
        }
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) {
        writer.beginObject();
        writer.name("errorClass").value(this.errorClass);
        writer.name("message").value(this.errorMessage);
        writer.name("type").value(this.type.getDesc());
        writer.name("stacktrace").value(this.stacktrace);
        writer.endObject();
    }
}

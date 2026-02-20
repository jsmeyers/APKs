package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: ThreadInternal.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\"\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u00032\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lcom/bugsnag/android/ThreadInternal;", "Lcom/bugsnag/android/JsonStream$Streamable;", "id", "", "name", "type", "Lcom/bugsnag/android/ErrorType;", "isErrorReportingThread", "", "state", "stacktrace", "Lcom/bugsnag/android/Stacktrace;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bugsnag/android/ErrorType;ZLjava/lang/String;Lcom/bugsnag/android/Stacktrace;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "()Z", "getName", "setName", "", "Lcom/bugsnag/android/Stackframe;", "getStacktrace", "()Ljava/util/List;", "setStacktrace", "(Ljava/util/List;)V", "getState", "setState", "getType", "()Lcom/bugsnag/android/ErrorType;", "setType", "(Lcom/bugsnag/android/ErrorType;)V", "addStackframe", "method", "file", "lineNumber", "", "toStream", "", "writer", "Lcom/bugsnag/android/JsonStream;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ThreadInternal implements JsonStream.Streamable {
    private String id;
    private final boolean isErrorReportingThread;
    private String name;
    private List<Stackframe> stacktrace;
    private String state;
    private ErrorType type;

    public ThreadInternal(String str, String str2, ErrorType errorType, boolean z, String str3, Stacktrace stacktrace) {
        this.id = str;
        this.name = str2;
        this.type = errorType;
        this.isErrorReportingThread = z;
        this.state = str3;
        this.stacktrace = CollectionsKt.toMutableList((Collection) stacktrace.getTrace());
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final ErrorType getType() {
        return this.type;
    }

    public final void setType(ErrorType errorType) {
        this.type = errorType;
    }

    /* JADX INFO: renamed from: isErrorReportingThread, reason: from getter */
    public final boolean getIsErrorReportingThread() {
        return this.isErrorReportingThread;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final List<Stackframe> getStacktrace() {
        return this.stacktrace;
    }

    public final void setStacktrace(List<Stackframe> list) {
        this.stacktrace = list;
    }

    public final Stackframe addStackframe(String method, String file, long lineNumber) {
        Stackframe stackframe = new Stackframe(method, file, Long.valueOf(lineNumber), null, null, null, 48, null);
        this.stacktrace.add(stackframe);
        return stackframe;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws IOException {
        writer.beginObject();
        writer.name("id").value(this.id);
        writer.name("name").value(this.name);
        writer.name("type").value(this.type.getDesc());
        writer.name("state").value(this.state);
        writer.name("stacktrace");
        writer.beginArray();
        Iterator<T> it = this.stacktrace.iterator();
        while (it.hasNext()) {
            writer.value((Stackframe) it.next());
        }
        writer.endArray();
        if (this.isErrorReportingThread) {
            writer.name("errorReportingThread").value(true);
        }
        writer.endObject();
    }
}

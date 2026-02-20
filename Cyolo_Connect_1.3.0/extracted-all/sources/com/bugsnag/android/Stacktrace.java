package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: Stacktrace.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B+\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bugsnag/android/Stacktrace;", "Lcom/bugsnag/android/JsonStream$Streamable;", "frames", "", "Lcom/bugsnag/android/Stackframe;", "(Ljava/util/List;)V", "stacktrace", "", "Ljava/lang/StackTraceElement;", "projectPackages", "", "", "logger", "Lcom/bugsnag/android/Logger;", "([Ljava/lang/StackTraceElement;Ljava/util/Collection;Lcom/bugsnag/android/Logger;)V", "trace", "getTrace", "()Ljava/util/List;", "limitTraceLength", "toStream", "", "writer", "Lcom/bugsnag/android/JsonStream;", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Stacktrace implements JsonStream.Streamable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int STACKTRACE_TRIM_LENGTH = 200;
    private final List<Stackframe> trace;

    /* JADX INFO: compiled from: Stacktrace.kt */
    @kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u0010\u000bJ&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bugsnag/android/Stacktrace$Companion;", "", "()V", "STACKTRACE_TRIM_LENGTH", "", "inProject", "", "className", "", "projectPackages", "", "(Ljava/lang/String;Ljava/util/Collection;)Ljava/lang/Boolean;", "serializeStackframe", "Lcom/bugsnag/android/Stackframe;", "el", "Ljava/lang/StackTraceElement;", "logger", "Lcom/bugsnag/android/Logger;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Boolean inProject(String className, Collection<String> projectPackages) {
            Collection<String> collection = projectPackages;
            boolean z = false;
            if (!(collection instanceof Collection) || !collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    if (StringsKt.startsWith$default(className, (String) it.next(), false, 2, (Object) null)) {
                        z = true;
                        break;
                    }
                }
            }
            return z ? true : null;
        }

        public final Stackframe serializeStackframe(StackTraceElement el, Collection<String> projectPackages, Logger logger) {
            String methodName;
            try {
                String className = el.getClassName();
                if (className.length() > 0) {
                    methodName = className + FilenameUtils.EXTENSION_SEPARATOR + ((Object) el.getMethodName());
                } else {
                    methodName = el.getMethodName();
                }
                String str = methodName;
                String fileName = el.getFileName();
                if (fileName == null) {
                    fileName = "Unknown";
                }
                return new Stackframe(str, fileName, Integer.valueOf(el.getLineNumber()), inProject(className, projectPackages), null, null, 48, null);
            } catch (Exception e) {
                logger.w("Failed to serialize stacktrace", e);
                return null;
            }
        }
    }

    public final List<Stackframe> getTrace() {
        return this.trace;
    }

    public Stacktrace(List<Stackframe> list) {
        this.trace = limitTraceLength(list);
    }

    public Stacktrace(StackTraceElement[] stackTraceElementArr, Collection<String> collection, Logger logger) {
        int iMin = Math.min(200, stackTraceElementArr.length);
        this.trace = new ArrayList(iMin);
        int i = 0;
        while (i < iMin) {
            int i2 = i + 1;
            Stackframe stackframeSerializeStackframe = INSTANCE.serializeStackframe(stackTraceElementArr[i], collection, logger);
            if (stackframeSerializeStackframe != null) {
                this.trace.add(stackframeSerializeStackframe);
            }
            i = i2;
        }
    }

    private final List<Stackframe> limitTraceLength(List<Stackframe> frames) {
        return frames.size() >= 200 ? frames.subList(0, 200) : frames;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws Throwable {
        writer.beginArray();
        Iterator<T> it = this.trace.iterator();
        while (it.hasNext()) {
            writer.value((Stackframe) it.next());
        }
        writer.endArray();
    }
}

package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Notifier.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bugsnag/android/Notifier;", "Lcom/bugsnag/android/JsonStream$Streamable;", "name", "", "version", ImagesContract.URL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dependencies", "", "getDependencies", "()Ljava/util/List;", "setDependencies", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getUrl", "setUrl", "getVersion", "setVersion", "toStream", "", "writer", "Lcom/bugsnag/android/JsonStream;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Notifier implements JsonStream.Streamable {
    private List<Notifier> dependencies;
    private String name;
    private String url;
    private String version;

    public Notifier() {
        this(null, null, null, 7, null);
    }

    public Notifier(String str) {
        this(str, null, null, 6, null);
    }

    public Notifier(String str, String str2) {
        this(str, str2, null, 4, null);
    }

    public Notifier(String str, String str2, String str3) {
        this.name = str;
        this.version = str2;
        this.url = str3;
        this.dependencies = CollectionsKt.emptyList();
    }

    public /* synthetic */ Notifier(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Android Bugsnag Notifier" : str, (i & 2) != 0 ? "6.17.0" : str2, (i & 4) != 0 ? "https://bugsnag.com" : str3);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final List<Notifier> getDependencies() {
        return this.dependencies;
    }

    public final void setDependencies(List<Notifier> list) {
        this.dependencies = list;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws Throwable {
        writer.beginObject();
        writer.name("name").value(this.name);
        writer.name("version").value(this.version);
        writer.name(ImagesContract.URL).value(this.url);
        if (!this.dependencies.isEmpty()) {
            writer.name("dependencies");
            writer.beginArray();
            Iterator<T> it = this.dependencies.iterator();
            while (it.hasNext()) {
                writer.value((Notifier) it.next());
            }
            writer.endArray();
        }
        writer.endObject();
    }
}

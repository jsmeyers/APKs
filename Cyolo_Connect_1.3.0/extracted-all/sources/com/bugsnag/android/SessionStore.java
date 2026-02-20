package com.bugsnag.android;

import com.bugsnag.android.FileStore;
import com.bugsnag.android.SessionFilenameInfo;
import com.bugsnag.android.internal.dag.Provider;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.File;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SessionStore.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bugsnag/android/SessionStore;", "Lcom/bugsnag/android/FileStore;", "bugsnagDir", "Ljava/io/File;", "maxPersistedSessions", "", DynamicLink.Builder.KEY_API_KEY, "", "logger", "Lcom/bugsnag/android/Logger;", "delegate", "Lcom/bugsnag/android/internal/dag/Provider;", "Lcom/bugsnag/android/FileStore$Delegate;", "(Ljava/io/File;ILjava/lang/String;Lcom/bugsnag/android/Logger;Lcom/bugsnag/android/internal/dag/Provider;)V", "getCreationDate", "Ljava/util/Date;", "file", "getFilename", "obj", "", "isTooOld", "", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SessionStore extends FileStore {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Comparator<? super File> SESSION_COMPARATOR = new Comparator() { // from class: com.bugsnag.android.SessionStore$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return SessionStore.m254SESSION_COMPARATOR$lambda0((File) obj, (File) obj2);
        }
    };
    private final String apiKey;

    public SessionStore(File file, int i, String str, Logger logger, Provider<? extends FileStore.Delegate> provider) {
        super(new File(file, "sessions"), i, logger, provider);
        this.apiKey = str;
    }

    public final boolean isTooOld(File file) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -60);
        SessionFilenameInfo.Companion companion = SessionFilenameInfo.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(file);
        return companion.findTimestampInFilename(file) < calendar.getTimeInMillis();
    }

    public final Date getCreationDate(File file) {
        SessionFilenameInfo.Companion companion = SessionFilenameInfo.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(file);
        return new Date(companion.findTimestampInFilename(file));
    }

    /* JADX INFO: compiled from: SessionStore.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\b\b\u0000\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bugsnag/android/SessionStore$Companion;", "", "()V", "SESSION_COMPARATOR", "Ljava/util/Comparator;", "Ljava/io/File;", "getSESSION_COMPARATOR", "()Ljava/util/Comparator;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Comparator<? super File> getSESSION_COMPARATOR() {
            return SessionStore.SESSION_COMPARATOR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: SESSION_COMPARATOR$lambda-0, reason: not valid java name */
    public static final int m254SESSION_COMPARATOR$lambda0(File file, File file2) {
        if (file == null && file2 == null) {
            return 0;
        }
        if (file == null) {
            return 1;
        }
        if (file2 == null) {
            return -1;
        }
        return file.getName().compareTo(file2.getName());
    }

    @Override // com.bugsnag.android.FileStore
    public String getFilename(Object obj) {
        return SessionFilenameInfo.INSTANCE.defaultFilename(obj, this.apiKey).encode();
    }
}

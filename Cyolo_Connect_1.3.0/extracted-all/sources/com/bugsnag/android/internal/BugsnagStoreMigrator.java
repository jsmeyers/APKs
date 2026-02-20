package com.bugsnag.android.internal;

import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import net.openid.appauth.RegistrationRequest;

/* JADX INFO: compiled from: BugsnagStoreMigrator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bugsnag/android/internal/BugsnagStoreMigrator;", "", "()V", "migrateLegacyFiles", "Ljava/io/File;", "persistenceDir", "Lkotlin/Lazy;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BugsnagStoreMigrator {
    public static final BugsnagStoreMigrator INSTANCE = new BugsnagStoreMigrator();

    private BugsnagStoreMigrator() {
    }

    @JvmStatic
    public static final File migrateLegacyFiles(Lazy<? extends File> persistenceDir) {
        File value = persistenceDir.getValue();
        File file = new File(value, "bugsnag");
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("last-run-info", "last-run-info"), TuplesKt.to("bugsnag-sessions", "sessions"), TuplesKt.to("user-info", "user-info"), TuplesKt.to("bugsnag-native", RegistrationRequest.APPLICATION_TYPE_NATIVE), TuplesKt.to("bugsnag-errors", "errors")})) {
            String str = (String) pair.component1();
            String str2 = (String) pair.component2();
            File file2 = new File(value, str);
            if (file2.exists()) {
                file2.renameTo(new File(file, str2));
            }
        }
        return file;
    }
}

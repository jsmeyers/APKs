package dev.fluttercommunity.workmanager;

import android.content.Context;
import androidx.work.WorkManager;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkmanagerCallHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"success", "", "Lio/flutter/plugin/common/MethodChannel$Result;", "workManager", "Landroidx/work/WorkManager;", "Landroid/content/Context;", "workmanager_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class WorkmanagerCallHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkManager workManager(Context context) {
        WorkManager workManager = WorkManager.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(...)");
        return workManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void success(MethodChannel.Result result) {
        result.success(true);
    }
}

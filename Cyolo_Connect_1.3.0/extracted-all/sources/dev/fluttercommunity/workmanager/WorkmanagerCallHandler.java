package dev.fluttercommunity.workmanager;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import dev.fluttercommunity.workmanager.WorkManagerCall;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkmanagerCallHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkmanagerCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMethodCall", "", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WorkmanagerCallHandler implements MethodChannel.MethodCallHandler {
    private final Context ctx;

    public WorkmanagerCallHandler(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.ctx = ctx;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        WorkManagerCall workManagerCallExtractWorkManagerCallFromRawMethodName = Extractor.INSTANCE.extractWorkManagerCallFromRawMethodName(call);
        if (workManagerCallExtractWorkManagerCallFromRawMethodName instanceof WorkManagerCall.Initialize) {
            InitializeHandler.INSTANCE.handle(this.ctx, (WorkManagerCall.Initialize) workManagerCallExtractWorkManagerCallFromRawMethodName, result);
            return;
        }
        if (workManagerCallExtractWorkManagerCallFromRawMethodName instanceof WorkManagerCall.RegisterTask) {
            RegisterTaskHandler.INSTANCE.handle(this.ctx, (WorkManagerCall.RegisterTask) workManagerCallExtractWorkManagerCallFromRawMethodName, result);
            return;
        }
        if (workManagerCallExtractWorkManagerCallFromRawMethodName instanceof WorkManagerCall.CancelTask) {
            UnregisterTaskHandler.INSTANCE.handle(this.ctx, (WorkManagerCall.CancelTask) workManagerCallExtractWorkManagerCallFromRawMethodName, result);
            return;
        }
        if (workManagerCallExtractWorkManagerCallFromRawMethodName instanceof WorkManagerCall.Failed) {
            WorkManagerCall.Failed failed = (WorkManagerCall.Failed) workManagerCallExtractWorkManagerCallFromRawMethodName;
            new FailedTaskHandler(failed.getCode()).handle(this.ctx, failed, result);
        } else if (workManagerCallExtractWorkManagerCallFromRawMethodName instanceof WorkManagerCall.Unknown) {
            UnknownTaskHandler.INSTANCE.handle(this.ctx, (WorkManagerCall.Unknown) workManagerCallExtractWorkManagerCallFromRawMethodName, result);
        }
    }
}

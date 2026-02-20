package dev.fluttercommunity.workmanager;

import android.content.Context;
import dev.fluttercommunity.workmanager.WorkManagerCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: compiled from: WorkmanagerCallHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ldev/fluttercommunity/workmanager/FailedTaskHandler;", "Ldev/fluttercommunity/workmanager/CallHandler;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$Failed;", ResponseTypeValues.CODE, "", "(Ljava/lang/String;)V", "handle", "", "context", "Landroid/content/Context;", "convertedCall", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FailedTaskHandler implements CallHandler<WorkManagerCall.Failed> {
    private final String code;

    public FailedTaskHandler(String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.code = code;
    }

    @Override // dev.fluttercommunity.workmanager.CallHandler
    public void handle(Context context, WorkManagerCall.Failed convertedCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(convertedCall, "convertedCall");
        Intrinsics.checkNotNullParameter(result, "result");
        result.error(this.code, null, null);
    }
}

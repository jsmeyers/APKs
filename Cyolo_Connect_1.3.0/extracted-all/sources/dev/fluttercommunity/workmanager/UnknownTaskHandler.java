package dev.fluttercommunity.workmanager;

import android.content.Context;
import dev.fluttercommunity.workmanager.WorkManagerCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkmanagerCallHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Ldev/fluttercommunity/workmanager/UnknownTaskHandler;", "Ldev/fluttercommunity/workmanager/CallHandler;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$Unknown;", "()V", "handle", "", "context", "Landroid/content/Context;", "convertedCall", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class UnknownTaskHandler implements CallHandler<WorkManagerCall.Unknown> {
    public static final UnknownTaskHandler INSTANCE = new UnknownTaskHandler();

    private UnknownTaskHandler() {
    }

    @Override // dev.fluttercommunity.workmanager.CallHandler
    public void handle(Context context, WorkManagerCall.Unknown convertedCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(convertedCall, "convertedCall");
        Intrinsics.checkNotNullParameter(result, "result");
        result.notImplemented();
    }
}

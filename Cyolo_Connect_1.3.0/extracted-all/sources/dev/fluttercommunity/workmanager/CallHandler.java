package dev.fluttercommunity.workmanager;

import android.content.Context;
import dev.fluttercommunity.workmanager.WorkManagerCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;

/* JADX INFO: compiled from: WorkmanagerCallHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Ldev/fluttercommunity/workmanager/CallHandler;", "T", "Ldev/fluttercommunity/workmanager/WorkManagerCall;", "", "handle", "", "context", "Landroid/content/Context;", "convertedCall", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "(Landroid/content/Context;Ldev/fluttercommunity/workmanager/WorkManagerCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
interface CallHandler<T extends WorkManagerCall> {
    void handle(Context context, T convertedCall, MethodChannel.Result result);
}

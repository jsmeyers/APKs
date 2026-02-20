package dev.fluttercommunity.workmanager;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.work.ListenableWorker;
import dev.fluttercommunity.workmanager.WorkManagerCall;
import io.cyolo.android.MainActivity$$ExternalSyntheticApiModelOutline0;
import io.flutter.view.FlutterCallbackInformation;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DebugHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J:\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dJF\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\f\u0010#\u001a\u00020\u0010*\u00020$H\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Ldev/fluttercommunity/workmanager/DebugHelper;", "", "()V", "currentTime", "", "kotlin.jvm.PlatformType", "getCurrentTime", "()Ljava/lang/String;", "debugChannelId", "debugChannelName", "debugDateFormatter", "Ljava/text/DateFormat;", "mapMillisToSeconds", "milliseconds", "", "postNotification", "", "ctx", "Landroid/content/Context;", "messageId", "", "title", "contentText", "postTaskCompleteNotification", "threadIdentifier", "dartTask", "payload", "fetchDuration", "result", "Landroidx/work/ListenableWorker$Result;", "postTaskStarting", WorkManagerCall.Initialize.INITIALIZE_TASK_CALL_HANDLE_KEY, "callbackInfo", "Lio/flutter/view/FlutterCallbackInformation;", "dartBundlePath", "createNotificationChannel", "Landroid/app/NotificationManager;", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DebugHelper {
    private static final String debugChannelId = "WorkmanagerDebugChannelId";
    private static final String debugChannelName = "A helper channel to debug your background tasks.";
    public static final DebugHelper INSTANCE = new DebugHelper();
    private static final DateFormat debugDateFormatter = DateFormat.getDateTimeInstance(3, 2);

    private DebugHelper() {
    }

    private final String getCurrentTime() {
        return debugDateFormatter.format(new Date());
    }

    private final String mapMillisToSeconds(long milliseconds) {
        return TimeUnit.MILLISECONDS.toSeconds(milliseconds) + " seconds.";
    }

    public final void postTaskCompleteNotification(Context ctx, int threadIdentifier, String dartTask, String payload, long fetchDuration, ListenableWorker.Result result) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(dartTask, "dartTask");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = ThumbnailGenerator.INSTANCE.getWorkEmoji() + ' ' + getCurrentTime();
        StringBuilder sb = new StringBuilder("\n                    • Result: ");
        sb.append(ThumbnailGenerator.INSTANCE.mapResultToEmoji(result));
        sb.append(' ');
        sb.append(result.getClass().getSimpleName());
        sb.append("\n                    • dartTask: ");
        sb.append(dartTask);
        sb.append("\n                    • inputData: ");
        if (payload == null) {
            payload = "not found";
        }
        sb.append(payload);
        sb.append("\n                    • Elapsed time: ");
        sb.append(mapMillisToSeconds(fetchDuration));
        sb.append("\n            ");
        postNotification(ctx, threadIdentifier, str, StringsKt.trimIndent(sb.toString()));
    }

    public final void postTaskStarting(Context ctx, int threadIdentifier, String dartTask, String payload, long callbackHandle, FlutterCallbackInformation callbackInfo, String dartBundlePath) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(dartTask, "dartTask");
        String str = ThumbnailGenerator.INSTANCE.getWorkEmoji() + ' ' + getCurrentTime();
        StringBuilder sb = new StringBuilder("\n                • dartTask: ");
        sb.append(dartTask);
        sb.append("\n                • inputData: ");
        if (payload == null) {
            payload = "not found";
        }
        sb.append(payload);
        sb.append("\n                • callbackHandle: ");
        sb.append(callbackHandle);
        sb.append(" \n                • callBackName: ");
        String str2 = callbackInfo != null ? callbackInfo.callbackName : null;
        if (str2 == null) {
            str2 = "not found";
        }
        sb.append(str2);
        sb.append("\n                • callbackClassName: ");
        String str3 = callbackInfo != null ? callbackInfo.callbackClassName : null;
        if (str3 == null) {
            str3 = "not found";
        }
        sb.append(str3);
        sb.append("\n                • callbackLibraryPath: ");
        String str4 = callbackInfo != null ? callbackInfo.callbackLibraryPath : null;
        sb.append(str4 != null ? str4 : "not found");
        sb.append("\n                • dartBundlePath: ");
        sb.append(dartBundlePath);
        sb.append("\"\n            ");
        postNotification(ctx, threadIdentifier, str, StringsKt.trimIndent(sb.toString()));
    }

    private final void postNotification(Context ctx, int messageId, String title, String contentText) {
        Object systemService = ctx.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        INSTANCE.createNotificationChannel(notificationManager);
        String str = contentText;
        notificationManager.notify(messageId, new NotificationCompat.Builder(ctx, debugChannelId).setContentTitle(title).setContentText(str).setStyle(new NotificationCompat.BigTextStyle().bigText(str)).setSmallIcon(android.R.drawable.stat_notify_sync).build());
    }

    private final void createNotificationChannel(NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT >= 26) {
            MainActivity$$ExternalSyntheticApiModelOutline0.m371m$1();
            notificationManager.createNotificationChannel(MainActivity$$ExternalSyntheticApiModelOutline0.m(debugChannelId, debugChannelName, 3));
        }
    }
}

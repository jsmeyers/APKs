package dev.fluttercommunity.workmanager;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import dev.fluttercommunity.workmanager.WorkManagerCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkmanagerCallHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0002J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Ldev/fluttercommunity/workmanager/RegisterTaskHandler;", "Ldev/fluttercommunity/workmanager/CallHandler;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$RegisterTask;", "()V", "enqueueOneOffTask", "", "context", "Landroid/content/Context;", "convertedCall", "Ldev/fluttercommunity/workmanager/WorkManagerCall$RegisterTask$OneOffTask;", "enqueuePeriodicTask", "Ldev/fluttercommunity/workmanager/WorkManagerCall$RegisterTask$PeriodicTask;", "handle", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class RegisterTaskHandler implements CallHandler<WorkManagerCall.RegisterTask> {
    public static final RegisterTaskHandler INSTANCE = new RegisterTaskHandler();

    private RegisterTaskHandler() {
    }

    @Override // dev.fluttercommunity.workmanager.CallHandler
    public void handle(Context context, WorkManagerCall.RegisterTask convertedCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(convertedCall, "convertedCall");
        Intrinsics.checkNotNullParameter(result, "result");
        if (!SharedPreferenceHelper.INSTANCE.hasCallbackHandle(context)) {
            result.error("1", "You have not properly initialized the Flutter WorkManager Package. You should ensure you have called the 'initialize' function first! Example: \n\n`Workmanager().initialize(\n  callbackDispatcher,\n )`\n\nThe `callbackDispatcher` is a top level function. See example in repository.", null);
            return;
        }
        if (convertedCall instanceof WorkManagerCall.RegisterTask.OneOffTask) {
            enqueueOneOffTask(context, (WorkManagerCall.RegisterTask.OneOffTask) convertedCall);
        } else if (convertedCall instanceof WorkManagerCall.RegisterTask.PeriodicTask) {
            enqueuePeriodicTask(context, (WorkManagerCall.RegisterTask.PeriodicTask) convertedCall);
        }
        WorkmanagerCallHandlerKt.success(result);
    }

    private final void enqueuePeriodicTask(Context context, WorkManagerCall.RegisterTask.PeriodicTask convertedCall) {
        WM wm = WM.INSTANCE;
        String uniqueName = convertedCall.getUniqueName();
        String taskName = convertedCall.getTaskName();
        String tag = convertedCall.getTag();
        long frequencyInSeconds = convertedCall.getFrequencyInSeconds();
        boolean zIsInDebugMode = convertedCall.isInDebugMode();
        ExistingPeriodicWorkPolicy existingWorkPolicy = convertedCall.getExistingWorkPolicy();
        long initialDelaySeconds = convertedCall.getInitialDelaySeconds();
        Constraints constraintsConfig = convertedCall.getConstraintsConfig();
        BackoffPolicyTaskConfig backoffPolicyConfig = convertedCall.getBackoffPolicyConfig();
        wm.enqueuePeriodicTask(context, uniqueName, taskName, convertedCall.getPayload(), tag, frequencyInSeconds, zIsInDebugMode, existingWorkPolicy, initialDelaySeconds, constraintsConfig, convertedCall.getOutOfQuotaPolicy(), backoffPolicyConfig);
    }

    private final void enqueueOneOffTask(Context context, WorkManagerCall.RegisterTask.OneOffTask convertedCall) {
        WM wm = WM.INSTANCE;
        String uniqueName = convertedCall.getUniqueName();
        String taskName = convertedCall.getTaskName();
        String tag = convertedCall.getTag();
        boolean zIsInDebugMode = convertedCall.isInDebugMode();
        ExistingWorkPolicy existingWorkPolicy = convertedCall.getExistingWorkPolicy();
        long initialDelaySeconds = convertedCall.getInitialDelaySeconds();
        Constraints constraintsConfig = convertedCall.getConstraintsConfig();
        BackoffPolicyTaskConfig backoffPolicyConfig = convertedCall.getBackoffPolicyConfig();
        wm.enqueueOneOffTask(context, uniqueName, taskName, convertedCall.getPayload(), tag, zIsInDebugMode, existingWorkPolicy, initialDelaySeconds, constraintsConfig, convertedCall.getOutOfQuotaPolicy(), backoffPolicyConfig);
    }
}

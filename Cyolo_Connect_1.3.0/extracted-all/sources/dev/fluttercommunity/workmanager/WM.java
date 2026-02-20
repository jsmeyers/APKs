package dev.fluttercommunity.workmanager;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.PeriodicWorkRequest;
import dev.fluttercommunity.workmanager.WorkManagerCall;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkmanagerCallHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0006Jt\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ~\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020!2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¨\u0006\""}, d2 = {"Ldev/fluttercommunity/workmanager/WM;", "", "()V", "buildTaskInputData", "Landroidx/work/Data;", "dartTask", "", "isInDebugMode", "", "payload", "cancelAll", "Landroidx/work/Operation;", "context", "Landroid/content/Context;", "cancelByTag", "tag", "cancelByUniqueName", "uniqueWorkName", "enqueueOneOffTask", "", "uniqueName", WorkManagerCall.RegisterTask.REGISTER_TASK_EXISTING_WORK_POLICY_KEY, "Landroidx/work/ExistingWorkPolicy;", WorkManagerCall.RegisterTask.REGISTER_TASK_INITIAL_DELAY_SECONDS_KEY, "", "constraintsConfig", "Landroidx/work/Constraints;", WorkManagerCall.RegisterTask.REGISTER_TASK_OUT_OF_QUOTA_POLICY_KEY, "Landroidx/work/OutOfQuotaPolicy;", "backoffPolicyConfig", "Ldev/fluttercommunity/workmanager/BackoffPolicyTaskConfig;", "enqueuePeriodicTask", "frequencyInSeconds", "Landroidx/work/ExistingPeriodicWorkPolicy;", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WM {
    public static final WM INSTANCE = new WM();

    private WM() {
    }

    public final void enqueueOneOffTask(Context context, String uniqueName, String dartTask, String payload, String tag, boolean isInDebugMode, ExistingWorkPolicy existingWorkPolicy, long initialDelaySeconds, Constraints constraintsConfig, OutOfQuotaPolicy outOfQuotaPolicy, BackoffPolicyTaskConfig backoffPolicyConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uniqueName, "uniqueName");
        Intrinsics.checkNotNullParameter(dartTask, "dartTask");
        Intrinsics.checkNotNullParameter(existingWorkPolicy, "existingWorkPolicy");
        Intrinsics.checkNotNullParameter(constraintsConfig, "constraintsConfig");
        OneTimeWorkRequest.Builder constraints = new OneTimeWorkRequest.Builder(BackgroundWorker.class).setInputData(buildTaskInputData(dartTask, isInDebugMode, payload)).setInitialDelay(initialDelaySeconds, TimeUnit.SECONDS).setConstraints(constraintsConfig);
        if (backoffPolicyConfig != null) {
            constraints.setBackoffCriteria(backoffPolicyConfig.getBackoffPolicy(), backoffPolicyConfig.getBackoffDelay(), TimeUnit.MILLISECONDS);
        }
        if (tag != null) {
            constraints.addTag(tag);
        }
        if (outOfQuotaPolicy != null) {
            constraints.setExpedited(outOfQuotaPolicy);
        }
        WorkmanagerCallHandlerKt.workManager(context).enqueueUniqueWork(uniqueName, existingWorkPolicy, constraints.build());
    }

    public final void enqueuePeriodicTask(Context context, String uniqueName, String dartTask, String payload, String tag, long frequencyInSeconds, boolean isInDebugMode, ExistingPeriodicWorkPolicy existingWorkPolicy, long initialDelaySeconds, Constraints constraintsConfig, OutOfQuotaPolicy outOfQuotaPolicy, BackoffPolicyTaskConfig backoffPolicyConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uniqueName, "uniqueName");
        Intrinsics.checkNotNullParameter(dartTask, "dartTask");
        Intrinsics.checkNotNullParameter(existingWorkPolicy, "existingWorkPolicy");
        Intrinsics.checkNotNullParameter(constraintsConfig, "constraintsConfig");
        PeriodicWorkRequest.Builder constraints = new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) BackgroundWorker.class, frequencyInSeconds, TimeUnit.SECONDS).setInputData(buildTaskInputData(dartTask, isInDebugMode, payload)).setInitialDelay(initialDelaySeconds, TimeUnit.SECONDS).setConstraints(constraintsConfig);
        if (backoffPolicyConfig != null) {
            constraints.setBackoffCriteria(backoffPolicyConfig.getBackoffPolicy(), backoffPolicyConfig.getBackoffDelay(), TimeUnit.MILLISECONDS);
        }
        if (tag != null) {
            constraints.addTag(tag);
        }
        if (outOfQuotaPolicy != null) {
            constraints.setExpedited(outOfQuotaPolicy);
        }
        WorkmanagerCallHandlerKt.workManager(context).enqueueUniquePeriodicWork(uniqueName, existingWorkPolicy, constraints.build());
    }

    private final Data buildTaskInputData(String dartTask, boolean isInDebugMode, String payload) throws Throwable {
        Data.Builder builderPutBoolean = new Data.Builder().putString(BackgroundWorker.DART_TASK_KEY, dartTask).putBoolean(BackgroundWorker.IS_IN_DEBUG_MODE_KEY, isInDebugMode);
        if (payload != null) {
            builderPutBoolean.putString(BackgroundWorker.PAYLOAD_KEY, payload);
        }
        Data dataBuild = builderPutBoolean.build();
        Intrinsics.checkNotNullExpressionValue(dataBuild, "build(...)");
        return dataBuild;
    }

    public final Operation cancelByUniqueName(Context context, String uniqueWorkName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uniqueWorkName, "uniqueWorkName");
        Operation operationCancelUniqueWork = WorkmanagerCallHandlerKt.workManager(context).cancelUniqueWork(uniqueWorkName);
        Intrinsics.checkNotNullExpressionValue(operationCancelUniqueWork, "cancelUniqueWork(...)");
        return operationCancelUniqueWork;
    }

    public final Operation cancelByTag(Context context, String tag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Operation operationCancelAllWorkByTag = WorkmanagerCallHandlerKt.workManager(context).cancelAllWorkByTag(tag);
        Intrinsics.checkNotNullExpressionValue(operationCancelAllWorkByTag, "cancelAllWorkByTag(...)");
        return operationCancelAllWorkByTag;
    }

    public final Operation cancelAll(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Operation operationCancelAllWork = WorkmanagerCallHandlerKt.workManager(context).cancelAllWork();
        Intrinsics.checkNotNullExpressionValue(operationCancelAllWork, "cancelAllWork(...)");
        return operationCancelAllWork;
    }
}

package dev.fluttercommunity.workmanager;

import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import dev.fluttercommunity.workmanager.WorkManagerCall;
import io.flutter.plugin.common.MethodCall;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0019"}, d2 = {"Ldev/fluttercommunity/workmanager/Extractor;", "", "()V", "extractBackoffPolicyConfigFromCall", "Ldev/fluttercommunity/workmanager/BackoffPolicyTaskConfig;", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", "taskType", "Ldev/fluttercommunity/workmanager/TaskType;", "extractConstraintConfigFromCall", "Landroidx/work/Constraints;", "extractExistingPeriodicWorkPolicyFromCall", "Landroidx/work/ExistingPeriodicWorkPolicy;", "extractExistingWorkPolicyFromCall", "Landroidx/work/ExistingWorkPolicy;", "extractFrequencySecondsFromCall", "", "extractInitialDelayFromCall", "extractOutOfQuotaPolicyFromCall", "Landroidx/work/OutOfQuotaPolicy;", "extractPayload", "", "extractWorkManagerCallFromRawMethodName", "Ldev/fluttercommunity/workmanager/WorkManagerCall;", "PossibleWorkManagerCall", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Extractor {
    public static final Extractor INSTANCE = new Extractor();

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PossibleWorkManagerCall.values().length];
            try {
                iArr[PossibleWorkManagerCall.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PossibleWorkManagerCall.REGISTER_ONE_OFF_TASK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PossibleWorkManagerCall.REGISTER_PERIODIC_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PossibleWorkManagerCall.CANCEL_TASK_BY_UNIQUE_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PossibleWorkManagerCall.CANCEL_TASK_BY_TAG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PossibleWorkManagerCall.CANCEL_ALL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PossibleWorkManagerCall.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Ldev/fluttercommunity/workmanager/Extractor$PossibleWorkManagerCall;", "", "rawMethodName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawMethodName", "()Ljava/lang/String;", "INITIALIZE", "REGISTER_ONE_OFF_TASK", "REGISTER_PERIODIC_TASK", "CANCEL_TASK_BY_UNIQUE_NAME", "CANCEL_TASK_BY_TAG", "CANCEL_ALL", "UNKNOWN", "Companion", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class PossibleWorkManagerCall {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PossibleWorkManagerCall[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String rawMethodName;
        public static final PossibleWorkManagerCall INITIALIZE = new PossibleWorkManagerCall("INITIALIZE", 0, "initialize");
        public static final PossibleWorkManagerCall REGISTER_ONE_OFF_TASK = new PossibleWorkManagerCall("REGISTER_ONE_OFF_TASK", 1, "registerOneOffTask");
        public static final PossibleWorkManagerCall REGISTER_PERIODIC_TASK = new PossibleWorkManagerCall("REGISTER_PERIODIC_TASK", 2, "registerPeriodicTask");
        public static final PossibleWorkManagerCall CANCEL_TASK_BY_UNIQUE_NAME = new PossibleWorkManagerCall("CANCEL_TASK_BY_UNIQUE_NAME", 3, "cancelTaskByUniqueName");
        public static final PossibleWorkManagerCall CANCEL_TASK_BY_TAG = new PossibleWorkManagerCall("CANCEL_TASK_BY_TAG", 4, "cancelTaskByTag");
        public static final PossibleWorkManagerCall CANCEL_ALL = new PossibleWorkManagerCall("CANCEL_ALL", 5, "cancelAllTasks");
        public static final PossibleWorkManagerCall UNKNOWN = new PossibleWorkManagerCall("UNKNOWN", 6, null);

        private static final /* synthetic */ PossibleWorkManagerCall[] $values() {
            return new PossibleWorkManagerCall[]{INITIALIZE, REGISTER_ONE_OFF_TASK, REGISTER_PERIODIC_TASK, CANCEL_TASK_BY_UNIQUE_NAME, CANCEL_TASK_BY_TAG, CANCEL_ALL, UNKNOWN};
        }

        public static EnumEntries<PossibleWorkManagerCall> getEntries() {
            return $ENTRIES;
        }

        public static PossibleWorkManagerCall valueOf(String str) {
            return (PossibleWorkManagerCall) Enum.valueOf(PossibleWorkManagerCall.class, str);
        }

        public static PossibleWorkManagerCall[] values() {
            return (PossibleWorkManagerCall[]) $VALUES.clone();
        }

        private PossibleWorkManagerCall(String str, int i, String str2) {
            this.rawMethodName = str2;
        }

        public final String getRawMethodName() {
            return this.rawMethodName;
        }

        static {
            PossibleWorkManagerCall[] possibleWorkManagerCallArr$values = $values();
            $VALUES = possibleWorkManagerCallArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(possibleWorkManagerCallArr$values);
            INSTANCE = new Companion(null);
        }

        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Ldev/fluttercommunity/workmanager/Extractor$PossibleWorkManagerCall$Companion;", "", "()V", "fromRawMethodName", "Ldev/fluttercommunity/workmanager/Extractor$PossibleWorkManagerCall;", "methodName", "", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final PossibleWorkManagerCall fromRawMethodName(String methodName) {
                Object next;
                Intrinsics.checkNotNullParameter(methodName, "methodName");
                PossibleWorkManagerCall[] possibleWorkManagerCallArrValues = PossibleWorkManagerCall.values();
                ArrayList arrayList = new ArrayList();
                for (PossibleWorkManagerCall possibleWorkManagerCall : possibleWorkManagerCallArrValues) {
                    String rawMethodName = possibleWorkManagerCall.getRawMethodName();
                    if (!(rawMethodName == null || rawMethodName.length() == 0)) {
                        arrayList.add(possibleWorkManagerCall);
                    }
                }
                Iterator it = arrayList.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((PossibleWorkManagerCall) next).getRawMethodName(), methodName));
                PossibleWorkManagerCall possibleWorkManagerCall2 = (PossibleWorkManagerCall) next;
                return possibleWorkManagerCall2 == null ? PossibleWorkManagerCall.UNKNOWN : possibleWorkManagerCall2;
            }
        }
    }

    private Extractor() {
    }

    public final WorkManagerCall extractWorkManagerCallFromRawMethodName(MethodCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        PossibleWorkManagerCall.Companion companion = PossibleWorkManagerCall.INSTANCE;
        String method = call.method;
        Intrinsics.checkNotNullExpressionValue(method, "method");
        switch (WhenMappings.$EnumSwitchMapping$0[companion.fromRawMethodName(method).ordinal()]) {
            case 1:
                Number number = (Number) call.argument(WorkManagerCall.Initialize.INITIALIZE_TASK_CALL_HANDLE_KEY);
                Long lValueOf = number != null ? Long.valueOf(number.longValue()) : null;
                Boolean bool = (Boolean) call.argument("isInDebugMode");
                if (lValueOf == null || bool == null) {
                    return new WorkManagerCall.Failed("Invalid parameters passed");
                }
                return new WorkManagerCall.Initialize(lValueOf.longValue(), bool.booleanValue());
            case 2:
                Object objArgument = call.argument("isInDebugMode");
                Intrinsics.checkNotNull(objArgument);
                boolean zBooleanValue = ((Boolean) objArgument).booleanValue();
                Object objArgument2 = call.argument("uniqueName");
                Intrinsics.checkNotNull(objArgument2);
                String str = (String) objArgument2;
                Object objArgument3 = call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_NAME_VALUE_KEY);
                Intrinsics.checkNotNull(objArgument3);
                return new WorkManagerCall.RegisterTask.OneOffTask(zBooleanValue, str, (String) objArgument3, (String) call.argument("tag"), extractExistingWorkPolicyFromCall(call), extractInitialDelayFromCall(call), extractConstraintConfigFromCall(call), extractBackoffPolicyConfigFromCall(call, TaskType.ONE_OFF), extractOutOfQuotaPolicyFromCall(call), extractPayload(call));
            case 3:
                Object objArgument4 = call.argument("isInDebugMode");
                Intrinsics.checkNotNull(objArgument4);
                boolean zBooleanValue2 = ((Boolean) objArgument4).booleanValue();
                Object objArgument5 = call.argument("uniqueName");
                Intrinsics.checkNotNull(objArgument5);
                String str2 = (String) objArgument5;
                Object objArgument6 = call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_NAME_VALUE_KEY);
                Intrinsics.checkNotNull(objArgument6);
                return new WorkManagerCall.RegisterTask.PeriodicTask(zBooleanValue2, str2, (String) objArgument6, (String) call.argument("tag"), extractExistingPeriodicWorkPolicyFromCall(call), extractFrequencySecondsFromCall(call), extractInitialDelayFromCall(call), extractConstraintConfigFromCall(call), extractBackoffPolicyConfigFromCall(call, TaskType.PERIODIC), extractOutOfQuotaPolicyFromCall(call), extractPayload(call));
            case 4:
                Object objArgument7 = call.argument("uniqueName");
                Intrinsics.checkNotNull(objArgument7);
                return new WorkManagerCall.CancelTask.ByUniqueName((String) objArgument7);
            case 5:
                Object objArgument8 = call.argument("tag");
                Intrinsics.checkNotNull(objArgument8);
                return new WorkManagerCall.CancelTask.ByTag((String) objArgument8);
            case 6:
                return WorkManagerCall.CancelTask.All.INSTANCE;
            case 7:
                return WorkManagerCall.Unknown.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final ExistingWorkPolicy extractExistingWorkPolicyFromCall(MethodCall call) {
        try {
            Object objArgument = call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_EXISTING_WORK_POLICY_KEY);
            Intrinsics.checkNotNull(objArgument);
            String upperCase = ((String) objArgument).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return ExistingWorkPolicy.valueOf(upperCase);
        } catch (Exception unused) {
            return ExtractorKt.getDefaultOneOffExistingWorkPolicy();
        }
    }

    private final ExistingPeriodicWorkPolicy extractExistingPeriodicWorkPolicyFromCall(MethodCall call) {
        try {
            Object objArgument = call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_EXISTING_WORK_POLICY_KEY);
            Intrinsics.checkNotNull(objArgument);
            String upperCase = ((String) objArgument).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return ExistingPeriodicWorkPolicy.valueOf(upperCase);
        } catch (Exception unused) {
            return ExtractorKt.getDefaultPeriodExistingWorkPolicy();
        }
    }

    private final long extractFrequencySecondsFromCall(MethodCall call) {
        if (((Integer) call.argument(WorkManagerCall.RegisterTask.PeriodicTask.PERIODIC_TASK_FREQUENCY_SECONDS_KEY)) != null) {
            return r3.intValue();
        }
        return 900L;
    }

    private final long extractInitialDelayFromCall(MethodCall call) {
        if (((Integer) call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_INITIAL_DELAY_SECONDS_KEY)) != null) {
            return r3.intValue();
        }
        return 0L;
    }

    private final BackoffPolicyTaskConfig extractBackoffPolicyConfigFromCall(MethodCall call, TaskType taskType) {
        BackoffPolicy defaultBackOffPolicy;
        if (call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_BACK_OFF_POLICY_TYPE_KEY) == null) {
            return null;
        }
        try {
            Object objArgument = call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_BACK_OFF_POLICY_TYPE_KEY);
            Intrinsics.checkNotNull(objArgument);
            String upperCase = ((String) objArgument).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            defaultBackOffPolicy = BackoffPolicy.valueOf(upperCase);
        } catch (Exception unused) {
            defaultBackOffPolicy = ExtractorKt.getDefaultBackOffPolicy();
        }
        return new BackoffPolicyTaskConfig(defaultBackOffPolicy, ((Integer) call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_BACK_OFF_POLICY_DELAY_MILLIS_KEY)) != null ? r12.intValue() : 0L, taskType.getMinimumBackOffDelay(), 0L, 8, null);
    }

    public final OutOfQuotaPolicy extractOutOfQuotaPolicyFromCall(MethodCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        try {
            Object objArgument = call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_OUT_OF_QUOTA_POLICY_KEY);
            Intrinsics.checkNotNull(objArgument);
            String upperCase = ((String) objArgument).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return OutOfQuotaPolicy.valueOf(upperCase);
        } catch (Exception unused) {
            return ExtractorKt.getDefaultOutOfQuotaPolicy();
        }
    }

    private static final NetworkType extractConstraintConfigFromCall$extractNetworkTypeFromCall(MethodCall methodCall) {
        try {
            Object objArgument = methodCall.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_CONSTRAINTS_NETWORK_TYPE_KEY);
            Intrinsics.checkNotNull(objArgument);
            String upperCase = ((String) objArgument).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return NetworkType.valueOf(upperCase);
        } catch (Exception unused) {
            return ExtractorKt.getDefaultNetworkType();
        }
    }

    public final Constraints extractConstraintConfigFromCall(MethodCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        NetworkType networkTypeExtractConstraintConfigFromCall$extractNetworkTypeFromCall = extractConstraintConfigFromCall$extractNetworkTypeFromCall(call);
        Boolean bool = (Boolean) call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_CONSTRAINTS_BATTERY_NOT_LOW_KEY);
        if (bool == null) {
            bool = bool;
        }
        boolean zBooleanValue = bool.booleanValue();
        Boolean bool2 = (Boolean) call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_CONSTRAINTS_CHARGING_KEY);
        if (bool2 == null) {
            bool2 = bool;
        }
        boolean zBooleanValue2 = bool2.booleanValue();
        Boolean bool3 = (Boolean) call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_CONSTRAINTS_DEVICE_IDLE_KEY);
        if (bool3 == null) {
            bool3 = bool;
        }
        boolean zBooleanValue3 = bool3.booleanValue();
        Boolean bool4 = (Boolean) call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_CONSTRAINTS_STORAGE_NOT_LOW_KEY);
        Constraints.Builder requiresStorageNotLow = new Constraints.Builder().setRequiredNetworkType(networkTypeExtractConstraintConfigFromCall$extractNetworkTypeFromCall).setRequiresBatteryNotLow(zBooleanValue).setRequiresCharging(zBooleanValue2).setRequiresStorageNotLow((bool4 != null ? bool4 : false).booleanValue());
        if (Build.VERSION.SDK_INT >= 23) {
            requiresStorageNotLow.setRequiresDeviceIdle(zBooleanValue3);
        }
        return requiresStorageNotLow.build();
    }

    private final String extractPayload(MethodCall call) {
        return (String) call.argument(WorkManagerCall.RegisterTask.REGISTER_TASK_PAYLOAD_KEY);
    }
}

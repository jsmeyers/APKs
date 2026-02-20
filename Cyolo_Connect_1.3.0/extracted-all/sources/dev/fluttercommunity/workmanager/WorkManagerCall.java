package dev.fluttercommunity.workmanager;

import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OutOfQuotaPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkManagerCall;", "", "()V", "CancelTask", "Failed", "Initialize", "RegisterTask", "Unknown", "Ldev/fluttercommunity/workmanager/WorkManagerCall$CancelTask;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$Failed;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$Initialize;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$RegisterTask;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$Unknown;", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class WorkManagerCall {
    public /* synthetic */ WorkManagerCall(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private WorkManagerCall() {
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0015"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkManagerCall$Initialize;", "Ldev/fluttercommunity/workmanager/WorkManagerCall;", "callbackDispatcherHandleKey", "", "isInDebugMode", "", "(JZ)V", "getCallbackDispatcherHandleKey", "()J", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "KEYS", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Initialize extends WorkManagerCall {
        public static final String INITIALIZE_TASK_CALL_HANDLE_KEY = "callbackHandle";
        public static final String INITIALIZE_TASK_IS_IN_DEBUG_MODE_KEY = "isInDebugMode";
        private final long callbackDispatcherHandleKey;
        private final boolean isInDebugMode;

        public static /* synthetic */ Initialize copy$default(Initialize initialize, long j, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = initialize.callbackDispatcherHandleKey;
            }
            if ((i & 2) != 0) {
                z = initialize.isInDebugMode;
            }
            return initialize.copy(j, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getCallbackDispatcherHandleKey() {
            return this.callbackDispatcherHandleKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsInDebugMode() {
            return this.isInDebugMode;
        }

        public final Initialize copy(long callbackDispatcherHandleKey, boolean isInDebugMode) {
            return new Initialize(callbackDispatcherHandleKey, isInDebugMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Initialize)) {
                return false;
            }
            Initialize initialize = (Initialize) other;
            return this.callbackDispatcherHandleKey == initialize.callbackDispatcherHandleKey && this.isInDebugMode == initialize.isInDebugMode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            int iM = BackoffPolicyTaskConfig$$ExternalSyntheticBackport0.m(this.callbackDispatcherHandleKey) * 31;
            boolean z = this.isInDebugMode;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iM + r1;
        }

        public String toString() {
            return "Initialize(callbackDispatcherHandleKey=" + this.callbackDispatcherHandleKey + ", isInDebugMode=" + this.isInDebugMode + ')';
        }

        public final long getCallbackDispatcherHandleKey() {
            return this.callbackDispatcherHandleKey;
        }

        public final boolean isInDebugMode() {
            return this.isInDebugMode;
        }

        public Initialize(long j, boolean z) {
            super(null);
            this.callbackDispatcherHandleKey = j;
            this.isInDebugMode = z;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00182\u00020\u0001:\u0003\u0018\u0019\u001aB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0012\u0010\u0016\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011\u0082\u0001\u0002\u001b\u001c¨\u0006\u001d"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkManagerCall$RegisterTask;", "Ldev/fluttercommunity/workmanager/WorkManagerCall;", "()V", "constraintsConfig", "Landroidx/work/Constraints;", "getConstraintsConfig", "()Landroidx/work/Constraints;", RegisterTask.REGISTER_TASK_INITIAL_DELAY_SECONDS_KEY, "", "getInitialDelaySeconds", "()J", "isInDebugMode", "", "()Z", "payload", "", "getPayload", "()Ljava/lang/String;", "tag", "getTag", RegisterTask.REGISTER_TASK_NAME_VALUE_KEY, "getTaskName", "uniqueName", "getUniqueName", "KEYS", "OneOffTask", "PeriodicTask", "Ldev/fluttercommunity/workmanager/WorkManagerCall$RegisterTask$OneOffTask;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$RegisterTask$PeriodicTask;", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class RegisterTask extends WorkManagerCall {
        public static final String REGISTER_TASK_BACK_OFF_POLICY_DELAY_MILLIS_KEY = "backoffDelayInMilliseconds";
        public static final String REGISTER_TASK_BACK_OFF_POLICY_TYPE_KEY = "backoffPolicyType";
        public static final String REGISTER_TASK_CONSTRAINTS_BATTERY_NOT_LOW_KEY = "requiresBatteryNotLow";
        public static final String REGISTER_TASK_CONSTRAINTS_CHARGING_KEY = "requiresCharging";
        public static final String REGISTER_TASK_CONSTRAINTS_DEVICE_IDLE_KEY = "requiresDeviceIdle";
        public static final String REGISTER_TASK_CONSTRAINTS_NETWORK_TYPE_KEY = "networkType";
        public static final String REGISTER_TASK_CONSTRAINTS_STORAGE_NOT_LOW_KEY = "requiresStorageNotLow";
        public static final String REGISTER_TASK_EXISTING_WORK_POLICY_KEY = "existingWorkPolicy";
        public static final String REGISTER_TASK_INITIAL_DELAY_SECONDS_KEY = "initialDelaySeconds";
        public static final String REGISTER_TASK_IS_IN_DEBUG_MODE_KEY = "isInDebugMode";
        public static final String REGISTER_TASK_NAME_VALUE_KEY = "taskName";
        public static final String REGISTER_TASK_OUT_OF_QUOTA_POLICY_KEY = "outOfQuotaPolicy";
        public static final String REGISTER_TASK_PAYLOAD_KEY = "inputData";
        public static final String REGISTER_TASK_TAG_KEY = "tag";
        public static final String REGISTER_TASK_UNIQUE_NAME_KEY = "uniqueName";

        public /* synthetic */ RegisterTask(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Constraints getConstraintsConfig();

        public abstract long getInitialDelaySeconds();

        public abstract String getPayload();

        public abstract String getTag();

        public abstract String getTaskName();

        public abstract String getUniqueName();

        public abstract boolean isInDebugMode();

        private RegisterTask() {
            super(null);
        }

        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0011HÆ\u0003Ju\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 ¨\u00065"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkManagerCall$RegisterTask$OneOffTask;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$RegisterTask;", "isInDebugMode", "", "uniqueName", "", RegisterTask.REGISTER_TASK_NAME_VALUE_KEY, "tag", RegisterTask.REGISTER_TASK_EXISTING_WORK_POLICY_KEY, "Landroidx/work/ExistingWorkPolicy;", RegisterTask.REGISTER_TASK_INITIAL_DELAY_SECONDS_KEY, "", "constraintsConfig", "Landroidx/work/Constraints;", "backoffPolicyConfig", "Ldev/fluttercommunity/workmanager/BackoffPolicyTaskConfig;", RegisterTask.REGISTER_TASK_OUT_OF_QUOTA_POLICY_KEY, "Landroidx/work/OutOfQuotaPolicy;", "payload", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/work/ExistingWorkPolicy;JLandroidx/work/Constraints;Ldev/fluttercommunity/workmanager/BackoffPolicyTaskConfig;Landroidx/work/OutOfQuotaPolicy;Ljava/lang/String;)V", "getBackoffPolicyConfig", "()Ldev/fluttercommunity/workmanager/BackoffPolicyTaskConfig;", "getConstraintsConfig", "()Landroidx/work/Constraints;", "getExistingWorkPolicy", "()Landroidx/work/ExistingWorkPolicy;", "getInitialDelaySeconds", "()J", "()Z", "getOutOfQuotaPolicy", "()Landroidx/work/OutOfQuotaPolicy;", "getPayload", "()Ljava/lang/String;", "getTag", "getTaskName", "getUniqueName", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class OneOffTask extends RegisterTask {
            private final BackoffPolicyTaskConfig backoffPolicyConfig;
            private final Constraints constraintsConfig;
            private final ExistingWorkPolicy existingWorkPolicy;
            private final long initialDelaySeconds;
            private final boolean isInDebugMode;
            private final OutOfQuotaPolicy outOfQuotaPolicy;
            private final String payload;
            private final String tag;
            private final String taskName;
            private final String uniqueName;

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsInDebugMode() {
                return this.isInDebugMode;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final String getPayload() {
                return this.payload;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getUniqueName() {
                return this.uniqueName;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getTaskName() {
                return this.taskName;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getTag() {
                return this.tag;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final ExistingWorkPolicy getExistingWorkPolicy() {
                return this.existingWorkPolicy;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final long getInitialDelaySeconds() {
                return this.initialDelaySeconds;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final Constraints getConstraintsConfig() {
                return this.constraintsConfig;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final BackoffPolicyTaskConfig getBackoffPolicyConfig() {
                return this.backoffPolicyConfig;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final OutOfQuotaPolicy getOutOfQuotaPolicy() {
                return this.outOfQuotaPolicy;
            }

            public final OneOffTask copy(boolean isInDebugMode, String uniqueName, String taskName, String tag, ExistingWorkPolicy existingWorkPolicy, long initialDelaySeconds, Constraints constraintsConfig, BackoffPolicyTaskConfig backoffPolicyConfig, OutOfQuotaPolicy outOfQuotaPolicy, String payload) {
                Intrinsics.checkNotNullParameter(uniqueName, "uniqueName");
                Intrinsics.checkNotNullParameter(taskName, "taskName");
                Intrinsics.checkNotNullParameter(existingWorkPolicy, "existingWorkPolicy");
                Intrinsics.checkNotNullParameter(constraintsConfig, "constraintsConfig");
                return new OneOffTask(isInDebugMode, uniqueName, taskName, tag, existingWorkPolicy, initialDelaySeconds, constraintsConfig, backoffPolicyConfig, outOfQuotaPolicy, payload);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OneOffTask)) {
                    return false;
                }
                OneOffTask oneOffTask = (OneOffTask) other;
                return this.isInDebugMode == oneOffTask.isInDebugMode && Intrinsics.areEqual(this.uniqueName, oneOffTask.uniqueName) && Intrinsics.areEqual(this.taskName, oneOffTask.taskName) && Intrinsics.areEqual(this.tag, oneOffTask.tag) && this.existingWorkPolicy == oneOffTask.existingWorkPolicy && this.initialDelaySeconds == oneOffTask.initialDelaySeconds && Intrinsics.areEqual(this.constraintsConfig, oneOffTask.constraintsConfig) && Intrinsics.areEqual(this.backoffPolicyConfig, oneOffTask.backoffPolicyConfig) && this.outOfQuotaPolicy == oneOffTask.outOfQuotaPolicy && Intrinsics.areEqual(this.payload, oneOffTask.payload);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v20 */
            /* JADX WARN: Type inference failed for: r0v21 */
            public int hashCode() {
                boolean z = this.isInDebugMode;
                ?? r0 = z;
                if (z) {
                    r0 = 1;
                }
                int iHashCode = ((((r0 * 31) + this.uniqueName.hashCode()) * 31) + this.taskName.hashCode()) * 31;
                String str = this.tag;
                int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.existingWorkPolicy.hashCode()) * 31) + BackoffPolicyTaskConfig$$ExternalSyntheticBackport0.m(this.initialDelaySeconds)) * 31) + this.constraintsConfig.hashCode()) * 31;
                BackoffPolicyTaskConfig backoffPolicyTaskConfig = this.backoffPolicyConfig;
                int iHashCode3 = (iHashCode2 + (backoffPolicyTaskConfig == null ? 0 : backoffPolicyTaskConfig.hashCode())) * 31;
                OutOfQuotaPolicy outOfQuotaPolicy = this.outOfQuotaPolicy;
                int iHashCode4 = (iHashCode3 + (outOfQuotaPolicy == null ? 0 : outOfQuotaPolicy.hashCode())) * 31;
                String str2 = this.payload;
                return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "OneOffTask(isInDebugMode=" + this.isInDebugMode + ", uniqueName=" + this.uniqueName + ", taskName=" + this.taskName + ", tag=" + this.tag + ", existingWorkPolicy=" + this.existingWorkPolicy + ", initialDelaySeconds=" + this.initialDelaySeconds + ", constraintsConfig=" + this.constraintsConfig + ", backoffPolicyConfig=" + this.backoffPolicyConfig + ", outOfQuotaPolicy=" + this.outOfQuotaPolicy + ", payload=" + this.payload + ')';
            }

            public /* synthetic */ OneOffTask(boolean z, String str, String str2, String str3, ExistingWorkPolicy existingWorkPolicy, long j, Constraints constraints, BackoffPolicyTaskConfig backoffPolicyTaskConfig, OutOfQuotaPolicy outOfQuotaPolicy, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(z, str, str2, (i & 8) != 0 ? null : str3, existingWorkPolicy, j, constraints, backoffPolicyTaskConfig, outOfQuotaPolicy, (i & 512) != 0 ? null : str4);
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public boolean isInDebugMode() {
                return this.isInDebugMode;
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public String getUniqueName() {
                return this.uniqueName;
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public String getTaskName() {
                return this.taskName;
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public String getTag() {
                return this.tag;
            }

            public final ExistingWorkPolicy getExistingWorkPolicy() {
                return this.existingWorkPolicy;
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public long getInitialDelaySeconds() {
                return this.initialDelaySeconds;
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public Constraints getConstraintsConfig() {
                return this.constraintsConfig;
            }

            public final BackoffPolicyTaskConfig getBackoffPolicyConfig() {
                return this.backoffPolicyConfig;
            }

            public final OutOfQuotaPolicy getOutOfQuotaPolicy() {
                return this.outOfQuotaPolicy;
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public String getPayload() {
                return this.payload;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OneOffTask(boolean z, String uniqueName, String taskName, String str, ExistingWorkPolicy existingWorkPolicy, long j, Constraints constraintsConfig, BackoffPolicyTaskConfig backoffPolicyTaskConfig, OutOfQuotaPolicy outOfQuotaPolicy, String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(uniqueName, "uniqueName");
                Intrinsics.checkNotNullParameter(taskName, "taskName");
                Intrinsics.checkNotNullParameter(existingWorkPolicy, "existingWorkPolicy");
                Intrinsics.checkNotNullParameter(constraintsConfig, "constraintsConfig");
                this.isInDebugMode = z;
                this.uniqueName = uniqueName;
                this.taskName = taskName;
                this.tag = str;
                this.existingWorkPolicy = existingWorkPolicy;
                this.initialDelaySeconds = j;
                this.constraintsConfig = constraintsConfig;
                this.backoffPolicyConfig = backoffPolicyTaskConfig;
                this.outOfQuotaPolicy = outOfQuotaPolicy;
                this.payload = str2;
            }
        }

        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 82\u00020\u0001:\u00018Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003J\t\u0010.\u001a\u00020\u000bHÆ\u0003J\t\u0010/\u001a\u00020\u000eHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u007f\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\f\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"¨\u00069"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkManagerCall$RegisterTask$PeriodicTask;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$RegisterTask;", "isInDebugMode", "", "uniqueName", "", RegisterTask.REGISTER_TASK_NAME_VALUE_KEY, "tag", RegisterTask.REGISTER_TASK_EXISTING_WORK_POLICY_KEY, "Landroidx/work/ExistingPeriodicWorkPolicy;", "frequencyInSeconds", "", RegisterTask.REGISTER_TASK_INITIAL_DELAY_SECONDS_KEY, "constraintsConfig", "Landroidx/work/Constraints;", "backoffPolicyConfig", "Ldev/fluttercommunity/workmanager/BackoffPolicyTaskConfig;", RegisterTask.REGISTER_TASK_OUT_OF_QUOTA_POLICY_KEY, "Landroidx/work/OutOfQuotaPolicy;", "payload", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/work/ExistingPeriodicWorkPolicy;JJLandroidx/work/Constraints;Ldev/fluttercommunity/workmanager/BackoffPolicyTaskConfig;Landroidx/work/OutOfQuotaPolicy;Ljava/lang/String;)V", "getBackoffPolicyConfig", "()Ldev/fluttercommunity/workmanager/BackoffPolicyTaskConfig;", "getConstraintsConfig", "()Landroidx/work/Constraints;", "getExistingWorkPolicy", "()Landroidx/work/ExistingPeriodicWorkPolicy;", "getFrequencyInSeconds", "()J", "getInitialDelaySeconds", "()Z", "getOutOfQuotaPolicy", "()Landroidx/work/OutOfQuotaPolicy;", "getPayload", "()Ljava/lang/String;", "getTag", "getTaskName", "getUniqueName", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "KEYS", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PeriodicTask extends RegisterTask {
            public static final String PERIODIC_TASK_FREQUENCY_SECONDS_KEY = "frequency";
            private final BackoffPolicyTaskConfig backoffPolicyConfig;
            private final Constraints constraintsConfig;
            private final ExistingPeriodicWorkPolicy existingWorkPolicy;
            private final long frequencyInSeconds;
            private final long initialDelaySeconds;
            private final boolean isInDebugMode;
            private final OutOfQuotaPolicy outOfQuotaPolicy;
            private final String payload;
            private final String tag;
            private final String taskName;
            private final String uniqueName;

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsInDebugMode() {
                return this.isInDebugMode;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final OutOfQuotaPolicy getOutOfQuotaPolicy() {
                return this.outOfQuotaPolicy;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final String getPayload() {
                return this.payload;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getUniqueName() {
                return this.uniqueName;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getTaskName() {
                return this.taskName;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getTag() {
                return this.tag;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final ExistingPeriodicWorkPolicy getExistingWorkPolicy() {
                return this.existingWorkPolicy;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final long getFrequencyInSeconds() {
                return this.frequencyInSeconds;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final long getInitialDelaySeconds() {
                return this.initialDelaySeconds;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final Constraints getConstraintsConfig() {
                return this.constraintsConfig;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final BackoffPolicyTaskConfig getBackoffPolicyConfig() {
                return this.backoffPolicyConfig;
            }

            public final PeriodicTask copy(boolean isInDebugMode, String uniqueName, String taskName, String tag, ExistingPeriodicWorkPolicy existingWorkPolicy, long frequencyInSeconds, long initialDelaySeconds, Constraints constraintsConfig, BackoffPolicyTaskConfig backoffPolicyConfig, OutOfQuotaPolicy outOfQuotaPolicy, String payload) {
                Intrinsics.checkNotNullParameter(uniqueName, "uniqueName");
                Intrinsics.checkNotNullParameter(taskName, "taskName");
                Intrinsics.checkNotNullParameter(existingWorkPolicy, "existingWorkPolicy");
                Intrinsics.checkNotNullParameter(constraintsConfig, "constraintsConfig");
                return new PeriodicTask(isInDebugMode, uniqueName, taskName, tag, existingWorkPolicy, frequencyInSeconds, initialDelaySeconds, constraintsConfig, backoffPolicyConfig, outOfQuotaPolicy, payload);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PeriodicTask)) {
                    return false;
                }
                PeriodicTask periodicTask = (PeriodicTask) other;
                return this.isInDebugMode == periodicTask.isInDebugMode && Intrinsics.areEqual(this.uniqueName, periodicTask.uniqueName) && Intrinsics.areEqual(this.taskName, periodicTask.taskName) && Intrinsics.areEqual(this.tag, periodicTask.tag) && this.existingWorkPolicy == periodicTask.existingWorkPolicy && this.frequencyInSeconds == periodicTask.frequencyInSeconds && this.initialDelaySeconds == periodicTask.initialDelaySeconds && Intrinsics.areEqual(this.constraintsConfig, periodicTask.constraintsConfig) && Intrinsics.areEqual(this.backoffPolicyConfig, periodicTask.backoffPolicyConfig) && this.outOfQuotaPolicy == periodicTask.outOfQuotaPolicy && Intrinsics.areEqual(this.payload, periodicTask.payload);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v22 */
            /* JADX WARN: Type inference failed for: r0v23 */
            public int hashCode() {
                boolean z = this.isInDebugMode;
                ?? r0 = z;
                if (z) {
                    r0 = 1;
                }
                int iHashCode = ((((r0 * 31) + this.uniqueName.hashCode()) * 31) + this.taskName.hashCode()) * 31;
                String str = this.tag;
                int iHashCode2 = (((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.existingWorkPolicy.hashCode()) * 31) + BackoffPolicyTaskConfig$$ExternalSyntheticBackport0.m(this.frequencyInSeconds)) * 31) + BackoffPolicyTaskConfig$$ExternalSyntheticBackport0.m(this.initialDelaySeconds)) * 31) + this.constraintsConfig.hashCode()) * 31;
                BackoffPolicyTaskConfig backoffPolicyTaskConfig = this.backoffPolicyConfig;
                int iHashCode3 = (iHashCode2 + (backoffPolicyTaskConfig == null ? 0 : backoffPolicyTaskConfig.hashCode())) * 31;
                OutOfQuotaPolicy outOfQuotaPolicy = this.outOfQuotaPolicy;
                int iHashCode4 = (iHashCode3 + (outOfQuotaPolicy == null ? 0 : outOfQuotaPolicy.hashCode())) * 31;
                String str2 = this.payload;
                return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "PeriodicTask(isInDebugMode=" + this.isInDebugMode + ", uniqueName=" + this.uniqueName + ", taskName=" + this.taskName + ", tag=" + this.tag + ", existingWorkPolicy=" + this.existingWorkPolicy + ", frequencyInSeconds=" + this.frequencyInSeconds + ", initialDelaySeconds=" + this.initialDelaySeconds + ", constraintsConfig=" + this.constraintsConfig + ", backoffPolicyConfig=" + this.backoffPolicyConfig + ", outOfQuotaPolicy=" + this.outOfQuotaPolicy + ", payload=" + this.payload + ')';
            }

            public /* synthetic */ PeriodicTask(boolean z, String str, String str2, String str3, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, long j, long j2, Constraints constraints, BackoffPolicyTaskConfig backoffPolicyTaskConfig, OutOfQuotaPolicy outOfQuotaPolicy, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(z, str, str2, (i & 8) != 0 ? null : str3, existingPeriodicWorkPolicy, j, j2, constraints, backoffPolicyTaskConfig, outOfQuotaPolicy, (i & 1024) != 0 ? null : str4);
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public boolean isInDebugMode() {
                return this.isInDebugMode;
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public String getUniqueName() {
                return this.uniqueName;
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public String getTaskName() {
                return this.taskName;
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public String getTag() {
                return this.tag;
            }

            public final ExistingPeriodicWorkPolicy getExistingWorkPolicy() {
                return this.existingWorkPolicy;
            }

            public final long getFrequencyInSeconds() {
                return this.frequencyInSeconds;
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public long getInitialDelaySeconds() {
                return this.initialDelaySeconds;
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public Constraints getConstraintsConfig() {
                return this.constraintsConfig;
            }

            public final BackoffPolicyTaskConfig getBackoffPolicyConfig() {
                return this.backoffPolicyConfig;
            }

            public final OutOfQuotaPolicy getOutOfQuotaPolicy() {
                return this.outOfQuotaPolicy;
            }

            @Override // dev.fluttercommunity.workmanager.WorkManagerCall.RegisterTask
            public String getPayload() {
                return this.payload;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PeriodicTask(boolean z, String uniqueName, String taskName, String str, ExistingPeriodicWorkPolicy existingWorkPolicy, long j, long j2, Constraints constraintsConfig, BackoffPolicyTaskConfig backoffPolicyTaskConfig, OutOfQuotaPolicy outOfQuotaPolicy, String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(uniqueName, "uniqueName");
                Intrinsics.checkNotNullParameter(taskName, "taskName");
                Intrinsics.checkNotNullParameter(existingWorkPolicy, "existingWorkPolicy");
                Intrinsics.checkNotNullParameter(constraintsConfig, "constraintsConfig");
                this.isInDebugMode = z;
                this.uniqueName = uniqueName;
                this.taskName = taskName;
                this.tag = str;
                this.existingWorkPolicy = existingWorkPolicy;
                this.frequencyInSeconds = j;
                this.initialDelaySeconds = j2;
                this.constraintsConfig = constraintsConfig;
                this.backoffPolicyConfig = backoffPolicyTaskConfig;
                this.outOfQuotaPolicy = outOfQuotaPolicy;
                this.payload = str2;
            }
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkManagerCall$CancelTask;", "Ldev/fluttercommunity/workmanager/WorkManagerCall;", "()V", "All", "ByTag", "ByUniqueName", "Ldev/fluttercommunity/workmanager/WorkManagerCall$CancelTask$All;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$CancelTask$ByTag;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$CancelTask$ByUniqueName;", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class CancelTask extends WorkManagerCall {
        public /* synthetic */ CancelTask(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkManagerCall$CancelTask$ByUniqueName;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$CancelTask;", "uniqueName", "", "(Ljava/lang/String;)V", "getUniqueName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "KEYS", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ByUniqueName extends CancelTask {
            public static final String UNREGISTER_TASK_UNIQUE_NAME_KEY = "uniqueName";
            private final String uniqueName;

            public static /* synthetic */ ByUniqueName copy$default(ByUniqueName byUniqueName, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = byUniqueName.uniqueName;
                }
                return byUniqueName.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUniqueName() {
                return this.uniqueName;
            }

            public final ByUniqueName copy(String uniqueName) {
                Intrinsics.checkNotNullParameter(uniqueName, "uniqueName");
                return new ByUniqueName(uniqueName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ByUniqueName) && Intrinsics.areEqual(this.uniqueName, ((ByUniqueName) other).uniqueName);
            }

            public int hashCode() {
                return this.uniqueName.hashCode();
            }

            public String toString() {
                return "ByUniqueName(uniqueName=" + this.uniqueName + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ByUniqueName(String uniqueName) {
                super(null);
                Intrinsics.checkNotNullParameter(uniqueName, "uniqueName");
                this.uniqueName = uniqueName;
            }

            public final String getUniqueName() {
                return this.uniqueName;
            }
        }

        private CancelTask() {
            super(null);
        }

        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkManagerCall$CancelTask$ByTag;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$CancelTask;", "tag", "", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "KEYS", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ByTag extends CancelTask {
            public static final String UNREGISTER_TASK_TAG_KEY = "tag";
            private final String tag;

            public static /* synthetic */ ByTag copy$default(ByTag byTag, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = byTag.tag;
                }
                return byTag.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getTag() {
                return this.tag;
            }

            public final ByTag copy(String tag) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                return new ByTag(tag);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ByTag) && Intrinsics.areEqual(this.tag, ((ByTag) other).tag);
            }

            public int hashCode() {
                return this.tag.hashCode();
            }

            public String toString() {
                return "ByTag(tag=" + this.tag + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ByTag(String tag) {
                super(null);
                Intrinsics.checkNotNullParameter(tag, "tag");
                this.tag = tag;
            }

            public final String getTag() {
                return this.tag;
            }
        }

        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkManagerCall$CancelTask$All;", "Ldev/fluttercommunity/workmanager/WorkManagerCall$CancelTask;", "()V", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class All extends CancelTask {
            public static final All INSTANCE = new All();

            private All() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkManagerCall$Unknown;", "Ldev/fluttercommunity/workmanager/WorkManagerCall;", "()V", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Unknown extends WorkManagerCall {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldev/fluttercommunity/workmanager/WorkManagerCall$Failed;", "Ldev/fluttercommunity/workmanager/WorkManagerCall;", ResponseTypeValues.CODE, "", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Failed extends WorkManagerCall {
        private final String code;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(String code) {
            super(null);
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
        }

        public final String getCode() {
            return this.code;
        }
    }
}

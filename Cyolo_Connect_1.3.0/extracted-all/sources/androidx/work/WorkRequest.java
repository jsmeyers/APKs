package androidx.work;

import android.os.Build;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.DurationApi26Impl;
import dev.fluttercommunity.workmanager.WorkManagerCall;
import io.cyolo.android.ParamNames;
import j$.time.Duration;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\r\b&\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/work/WorkRequest;", "", "id", "Ljava/util/UUID;", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "tags", "", "", "(Ljava/util/UUID;Landroidx/work/impl/model/WorkSpec;Ljava/util/Set;)V", "getId", "()Ljava/util/UUID;", "stringId", "getStringId", "()Ljava/lang/String;", "getTags", "()Ljava/util/Set;", "getWorkSpec", "()Landroidx/work/impl/model/WorkSpec;", "Builder", "Companion", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class WorkRequest {
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    public static final long MIN_BACKOFF_MILLIS = 10000;
    private final UUID id;
    private final Set<String> tags;
    private final WorkSpec workSpec;

    public WorkRequest(UUID id, WorkSpec workSpec, Set<String> tags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.id = id;
        this.workSpec = workSpec;
        this.tags = tags;
    }

    public UUID getId() {
        return this.id;
    }

    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    public final Set<String> getTags() {
        return this.tags;
    }

    public final String getStringId() {
        String string = getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "id.toString()");
        return string;
    }

    /* JADX INFO: compiled from: WorkRequest.kt */
    @Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\n\b&\u0018\u0000*\u0012\b\u0000\u0010\u0001*\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0000*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B\u0019\b\u0000\u0012\u000e\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020908¢\u0006\u0004\bY\u0010ZJ\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000f\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u000f\u0010\u0013J\u0015\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b \u0010!J\u0017\u0010 \u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b \u0010\"J\u001f\u0010#\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b#\u0010!J\u0017\u0010#\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0004\b#\u0010\"J\u0017\u0010&\u001a\u00028\u00002\u0006\u0010%\u001a\u00020$H\u0017¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00028\u0001¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00028\u0001H ¢\u0006\u0004\b*\u0010)J\u0017\u0010.\u001a\u00028\u00002\u0006\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00028\u00002\u0006\u00101\u001a\u000200H\u0007¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b5\u0010!J\u001f\u00107\u001a\u00028\u00002\u0006\u00106\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b7\u0010!R\"\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u000209088\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR \u0010R\u001a\b\u0012\u0004\u0012\u00020\u001c0Q8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0014\u0010X\u001a\u00028\u00008 X \u0004¢\u0006\u0006\u001a\u0004\bV\u0010W¨\u0006["}, d2 = {"Landroidx/work/WorkRequest$Builder;", "B", "Landroidx/work/WorkRequest;", "W", "", "Ljava/util/UUID;", "id", "setId", "(Ljava/util/UUID;)Landroidx/work/WorkRequest$Builder;", "Landroidx/work/BackoffPolicy;", "backoffPolicy", "", "backoffDelay", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "setBackoffCriteria", "(Landroidx/work/BackoffPolicy;JLjava/util/concurrent/TimeUnit;)Landroidx/work/WorkRequest$Builder;", "j$/time/Duration", "duration", "(Landroidx/work/BackoffPolicy;Lj$/time/Duration;)Landroidx/work/WorkRequest$Builder;", "Landroidx/work/Constraints;", "constraints", "setConstraints", "(Landroidx/work/Constraints;)Landroidx/work/WorkRequest$Builder;", "Landroidx/work/Data;", WorkManagerCall.RegisterTask.REGISTER_TASK_PAYLOAD_KEY, "setInputData", "(Landroidx/work/Data;)Landroidx/work/WorkRequest$Builder;", "", "tag", "addTag", "(Ljava/lang/String;)Landroidx/work/WorkRequest$Builder;", "keepResultsForAtLeast", "(JLjava/util/concurrent/TimeUnit;)Landroidx/work/WorkRequest$Builder;", "(Lj$/time/Duration;)Landroidx/work/WorkRequest$Builder;", "setInitialDelay", "Landroidx/work/OutOfQuotaPolicy;", ParamNames.policy, "setExpedited", "(Landroidx/work/OutOfQuotaPolicy;)Landroidx/work/WorkRequest$Builder;", "build", "()Landroidx/work/WorkRequest;", "buildInternal$work_runtime_release", "buildInternal", "Landroidx/work/WorkInfo$State;", "state", "setInitialState", "(Landroidx/work/WorkInfo$State;)Landroidx/work/WorkRequest$Builder;", "", "runAttemptCount", "setInitialRunAttemptCount", "(I)Landroidx/work/WorkRequest$Builder;", "lastEnqueueTime", "setLastEnqueueTime", "scheduleRequestedAt", "setScheduleRequestedAt", "Ljava/lang/Class;", "Landroidx/work/ListenableWorker;", "workerClass", "Ljava/lang/Class;", "getWorkerClass$work_runtime_release", "()Ljava/lang/Class;", "", "backoffCriteriaSet", "Z", "getBackoffCriteriaSet$work_runtime_release", "()Z", "setBackoffCriteriaSet$work_runtime_release", "(Z)V", "Ljava/util/UUID;", "getId$work_runtime_release", "()Ljava/util/UUID;", "setId$work_runtime_release", "(Ljava/util/UUID;)V", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "getWorkSpec$work_runtime_release", "()Landroidx/work/impl/model/WorkSpec;", "setWorkSpec$work_runtime_release", "(Landroidx/work/impl/model/WorkSpec;)V", "", "tags", "Ljava/util/Set;", "getTags$work_runtime_release", "()Ljava/util/Set;", "getThisObject$work_runtime_release", "()Landroidx/work/WorkRequest$Builder;", "thisObject", "<init>", "(Ljava/lang/Class;)V", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {
        private boolean backoffCriteriaSet;
        private UUID id;
        private final Set<String> tags;
        private WorkSpec workSpec;
        private final Class<? extends ListenableWorker> workerClass;

        public abstract W buildInternal$work_runtime_release();

        public abstract B getThisObject$work_runtime_release();

        public Builder(Class<? extends ListenableWorker> workerClass) {
            Intrinsics.checkNotNullParameter(workerClass, "workerClass");
            this.workerClass = workerClass;
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
            this.id = uuidRandomUUID;
            String string = this.id.toString();
            Intrinsics.checkNotNullExpressionValue(string, "id.toString()");
            String name = workerClass.getName();
            Intrinsics.checkNotNullExpressionValue(name, "workerClass.name");
            this.workSpec = new WorkSpec(string, name);
            String name2 = workerClass.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "workerClass.name");
            this.tags = SetsKt.mutableSetOf(name2);
        }

        public final Class<? extends ListenableWorker> getWorkerClass$work_runtime_release() {
            return this.workerClass;
        }

        /* JADX INFO: renamed from: getBackoffCriteriaSet$work_runtime_release, reason: from getter */
        public final boolean getBackoffCriteriaSet() {
            return this.backoffCriteriaSet;
        }

        public final void setBackoffCriteriaSet$work_runtime_release(boolean z) {
            this.backoffCriteriaSet = z;
        }

        /* JADX INFO: renamed from: getId$work_runtime_release, reason: from getter */
        public final UUID getId() {
            return this.id;
        }

        public final void setId$work_runtime_release(UUID uuid) {
            Intrinsics.checkNotNullParameter(uuid, "<set-?>");
            this.id = uuid;
        }

        /* JADX INFO: renamed from: getWorkSpec$work_runtime_release, reason: from getter */
        public final WorkSpec getWorkSpec() {
            return this.workSpec;
        }

        public final void setWorkSpec$work_runtime_release(WorkSpec workSpec) {
            Intrinsics.checkNotNullParameter(workSpec, "<set-?>");
            this.workSpec = workSpec;
        }

        public final Set<String> getTags$work_runtime_release() {
            return this.tags;
        }

        public final B setId(UUID id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            String string = id.toString();
            Intrinsics.checkNotNullExpressionValue(string, "id.toString()");
            this.workSpec = new WorkSpec(string, this.workSpec);
            return (B) getThisObject$work_runtime_release();
        }

        public final B setBackoffCriteria(BackoffPolicy backoffPolicy, long backoffDelay, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.backoffCriteriaSet = true;
            this.workSpec.backoffPolicy = backoffPolicy;
            this.workSpec.setBackoffDelayDuration(timeUnit.toMillis(backoffDelay));
            return (B) getThisObject$work_runtime_release();
        }

        public final B setBackoffCriteria(BackoffPolicy backoffPolicy, Duration duration) {
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.backoffCriteriaSet = true;
            this.workSpec.backoffPolicy = backoffPolicy;
            this.workSpec.setBackoffDelayDuration(DurationApi26Impl.toMillisCompat(duration));
            return (B) getThisObject$work_runtime_release();
        }

        public final B setConstraints(Constraints constraints) {
            Intrinsics.checkNotNullParameter(constraints, "constraints");
            this.workSpec.constraints = constraints;
            return (B) getThisObject$work_runtime_release();
        }

        public final B setInputData(Data inputData) {
            Intrinsics.checkNotNullParameter(inputData, "inputData");
            this.workSpec.input = inputData;
            return (B) getThisObject$work_runtime_release();
        }

        public final B addTag(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.tags.add(tag);
            return (B) getThisObject$work_runtime_release();
        }

        public final B keepResultsForAtLeast(long duration, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.workSpec.minimumRetentionDuration = timeUnit.toMillis(duration);
            return (B) getThisObject$work_runtime_release();
        }

        public final B keepResultsForAtLeast(Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.workSpec.minimumRetentionDuration = DurationApi26Impl.toMillisCompat(duration);
            return (B) getThisObject$work_runtime_release();
        }

        public B setInitialDelay(long duration, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.workSpec.initialDelay = timeUnit.toMillis(duration);
            if (!(Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay)) {
                throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
            }
            return (B) getThisObject$work_runtime_release();
        }

        public B setInitialDelay(Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.workSpec.initialDelay = DurationApi26Impl.toMillisCompat(duration);
            if (!(Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay)) {
                throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
            }
            return (B) getThisObject$work_runtime_release();
        }

        public B setExpedited(OutOfQuotaPolicy policy) {
            Intrinsics.checkNotNullParameter(policy, "policy");
            this.workSpec.expedited = true;
            this.workSpec.outOfQuotaPolicy = policy;
            return (B) getThisObject$work_runtime_release();
        }

        public final W build() {
            W w = (W) buildInternal$work_runtime_release();
            Constraints constraints = this.workSpec.constraints;
            boolean z = (Build.VERSION.SDK_INT >= 24 && constraints.hasContentUriTriggers()) || constraints.getRequiresBatteryNotLow() || constraints.getRequiresCharging() || (Build.VERSION.SDK_INT >= 23 && constraints.getRequiresDeviceIdle());
            if (this.workSpec.expedited) {
                if (!(!z)) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints".toString());
                }
                if (!(this.workSpec.initialDelay <= 0)) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed".toString());
                }
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
            setId(uuidRandomUUID);
            return w;
        }

        public final B setInitialState(WorkInfo.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.workSpec.state = state;
            return (B) getThisObject$work_runtime_release();
        }

        public final B setInitialRunAttemptCount(int runAttemptCount) {
            this.workSpec.runAttemptCount = runAttemptCount;
            return (B) getThisObject$work_runtime_release();
        }

        public final B setLastEnqueueTime(long lastEnqueueTime, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.workSpec.lastEnqueueTime = timeUnit.toMillis(lastEnqueueTime);
            return (B) getThisObject$work_runtime_release();
        }

        public final B setScheduleRequestedAt(long scheduleRequestedAt, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.workSpec.scheduleRequestedAt = timeUnit.toMillis(scheduleRequestedAt);
            return (B) getThisObject$work_runtime_release();
        }
    }
}

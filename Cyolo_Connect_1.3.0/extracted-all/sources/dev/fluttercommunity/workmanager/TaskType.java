package dev.fluttercommunity.workmanager;

import androidx.work.WorkRequest;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ldev/fluttercommunity/workmanager/TaskType;", "", "minimumBackOffDelay", "", "(Ljava/lang/String;IJ)V", "getMinimumBackOffDelay", "()J", "ONE_OFF", "PERIODIC", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class TaskType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TaskType[] $VALUES;
    public static final TaskType ONE_OFF = new TaskType("ONE_OFF", 0, WorkRequest.MIN_BACKOFF_MILLIS);
    public static final TaskType PERIODIC = new TaskType("PERIODIC", 1, WorkRequest.MIN_BACKOFF_MILLIS);
    private final long minimumBackOffDelay;

    private static final /* synthetic */ TaskType[] $values() {
        return new TaskType[]{ONE_OFF, PERIODIC};
    }

    public static EnumEntries<TaskType> getEntries() {
        return $ENTRIES;
    }

    public static TaskType valueOf(String str) {
        return (TaskType) Enum.valueOf(TaskType.class, str);
    }

    public static TaskType[] values() {
        return (TaskType[]) $VALUES.clone();
    }

    private TaskType(String str, int i, long j) {
        this.minimumBackOffDelay = j;
    }

    public final long getMinimumBackOffDelay() {
        return this.minimumBackOffDelay;
    }

    static {
        TaskType[] taskTypeArr$values = $values();
        $VALUES = taskTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(taskTypeArr$values);
    }
}

package dev.fluttercommunity.workmanager;

import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import kotlin.Metadata;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u000e\u0010\u001a\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u001dX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"defaultBackOffPolicy", "Landroidx/work/BackoffPolicy;", "getDefaultBackOffPolicy", "()Landroidx/work/BackoffPolicy;", "defaultConstraints", "Landroidx/work/Constraints;", "getDefaultConstraints", "()Landroidx/work/Constraints;", "defaultInitialDelaySeconds", "", "defaultNetworkType", "Landroidx/work/NetworkType;", "getDefaultNetworkType", "()Landroidx/work/NetworkType;", "defaultOneOffExistingWorkPolicy", "Landroidx/work/ExistingWorkPolicy;", "getDefaultOneOffExistingWorkPolicy", "()Landroidx/work/ExistingWorkPolicy;", "defaultOutOfQuotaPolicy", "Landroidx/work/OutOfQuotaPolicy;", "getDefaultOutOfQuotaPolicy", "()Landroidx/work/OutOfQuotaPolicy;", "defaultPeriodExistingWorkPolicy", "Landroidx/work/ExistingPeriodicWorkPolicy;", "getDefaultPeriodExistingWorkPolicy", "()Landroidx/work/ExistingPeriodicWorkPolicy;", "defaultPeriodicRefreshFrequencyInSeconds", "defaultRequestedBackoffDelay", "logTag", "", "workmanager_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ExtractorKt {
    public static final long defaultInitialDelaySeconds = 0;
    private static final OutOfQuotaPolicy defaultOutOfQuotaPolicy = null;
    public static final long defaultPeriodicRefreshFrequencyInSeconds = 900;
    public static final long defaultRequestedBackoffDelay = 0;
    public static final String logTag = "Extractor";
    private static final BackoffPolicy defaultBackOffPolicy = BackoffPolicy.EXPONENTIAL;
    private static final NetworkType defaultNetworkType = NetworkType.NOT_REQUIRED;
    private static final ExistingWorkPolicy defaultOneOffExistingWorkPolicy = ExistingWorkPolicy.KEEP;
    private static final ExistingPeriodicWorkPolicy defaultPeriodExistingWorkPolicy = ExistingPeriodicWorkPolicy.KEEP;
    private static final Constraints defaultConstraints = Constraints.NONE;

    public static final BackoffPolicy getDefaultBackOffPolicy() {
        return defaultBackOffPolicy;
    }

    public static final NetworkType getDefaultNetworkType() {
        return defaultNetworkType;
    }

    public static final OutOfQuotaPolicy getDefaultOutOfQuotaPolicy() {
        return defaultOutOfQuotaPolicy;
    }

    public static final ExistingWorkPolicy getDefaultOneOffExistingWorkPolicy() {
        return defaultOneOffExistingWorkPolicy;
    }

    public static final ExistingPeriodicWorkPolicy getDefaultPeriodExistingWorkPolicy() {
        return defaultPeriodExistingWorkPolicy;
    }

    public static final Constraints getDefaultConstraints() {
        return defaultConstraints;
    }
}

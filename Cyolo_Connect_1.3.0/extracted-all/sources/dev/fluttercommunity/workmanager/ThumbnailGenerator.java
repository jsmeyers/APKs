package dev.fluttercommunity.workmanager;

import androidx.work.ListenableWorker;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: compiled from: DebugHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Ldev/fluttercommunity/workmanager/ThumbnailGenerator;", "", "()V", "workEmoji", "", "getWorkEmoji", "()Ljava/lang/String;", "mapResultToEmoji", "result", "Landroidx/work/ListenableWorker$Result;", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ThumbnailGenerator {
    public static final ThumbnailGenerator INSTANCE = new ThumbnailGenerator();

    private ThumbnailGenerator() {
    }

    public final String mapResultToEmoji(ListenableWorker.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return result instanceof ListenableWorker.Result.Success ? "🎉" : "🔥";
    }

    public final String getWorkEmoji() {
        return (String) CollectionsKt.random(CollectionsKt.listOf((Object[]) new String[]{"👷\u200d♀️", "👷\u200d♂️"}), Random.INSTANCE);
    }
}

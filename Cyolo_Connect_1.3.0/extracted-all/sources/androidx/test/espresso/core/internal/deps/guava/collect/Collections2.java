package androidx.test.espresso.core.internal.deps.guava.collect;

import java.util.Collection;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes.dex */
public final class Collections2 {
    static StringBuilder newStringBuilderForCollection(int size) {
        CollectPreconditions.checkNonnegative(size, "size");
        return new StringBuilder((int) Math.min(((long) size) * 8, FileUtils.ONE_GB));
    }

    static <T> Collection<T> cast(Iterable<T> iterable) {
        return (Collection) iterable;
    }
}

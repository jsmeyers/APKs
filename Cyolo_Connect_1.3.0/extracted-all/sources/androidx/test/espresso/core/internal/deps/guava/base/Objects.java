package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class Objects extends ExtraObjectsMethodsForWeb {
    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}

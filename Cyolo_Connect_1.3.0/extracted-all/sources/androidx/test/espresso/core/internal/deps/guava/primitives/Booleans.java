package androidx.test.espresso.core.internal.deps.guava.primitives;

/* JADX INFO: loaded from: classes.dex */
public final class Booleans {
    public static int compare(boolean a, boolean b) {
        if (a == b) {
            return 0;
        }
        return a ? 1 : -1;
    }
}

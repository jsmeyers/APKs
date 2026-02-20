package androidx.test.espresso.core.internal.deps.guava.collect;

/* JADX INFO: loaded from: classes.dex */
final class Hashing {
    static int smear(int hashCode) {
        return (int) (((long) Integer.rotateLeft((int) (((long) hashCode) * (-862048943)), 15)) * 461845907);
    }

    static int smearedHash(Object o) {
        return smear(o == null ? 0 : o.hashCode());
    }
}

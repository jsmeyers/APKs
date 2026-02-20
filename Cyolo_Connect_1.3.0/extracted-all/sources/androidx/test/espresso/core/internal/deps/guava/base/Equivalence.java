package androidx.test.espresso.core.internal.deps.guava.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class Equivalence<T> {
    protected abstract boolean doEquivalent(T a, T b);

    protected abstract int doHash(T t);

    protected Equivalence() {
    }

    public final boolean equivalent(T a, T b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return doEquivalent(a, b);
    }

    public final int hash(T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        Equals() {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.base.Equivalence
        protected boolean doEquivalent(Object a, Object b) {
            return a.equals(b);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.base.Equivalence
        protected int doHash(Object o) {
            return o.hashCode();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1;

        @Override // androidx.test.espresso.core.internal.deps.guava.base.Equivalence
        protected boolean doEquivalent(Object a, Object b) {
            return false;
        }

        Identity() {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.base.Equivalence
        protected int doHash(Object o) {
            return System.identityHashCode(o);
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }
}

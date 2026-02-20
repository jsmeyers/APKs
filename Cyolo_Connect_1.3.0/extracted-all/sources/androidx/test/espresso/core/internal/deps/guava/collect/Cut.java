package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.primitives.Booleans;
import java.io.Serializable;
import java.lang.Comparable;

/* JADX INFO: loaded from: classes.dex */
abstract class Cut<C extends Comparable> implements Serializable, Comparable<Cut<C>> {
    private static final long serialVersionUID = 0;
    final C endpoint;

    abstract void describeAsLowerBound(StringBuilder sb);

    abstract void describeAsUpperBound(StringBuilder sb);

    public abstract int hashCode();

    abstract boolean isLessThan(C value);

    Cut(C endpoint) {
        this.endpoint = endpoint;
    }

    @Override // java.lang.Comparable
    public int compareTo(Cut<C> that) {
        if (that == belowAll()) {
            return 1;
        }
        if (that == aboveAll()) {
            return -1;
        }
        int iCompareOrThrow = Range.compareOrThrow(this.endpoint, that.endpoint);
        return iCompareOrThrow != 0 ? iCompareOrThrow : Booleans.compare(this instanceof AboveValue, that instanceof AboveValue);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            return compareTo((Cut) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    static <C extends Comparable> Cut<C> belowAll() {
        return BelowAll.INSTANCE;
    }

    private static final class BelowAll extends Cut<Comparable<?>> {
        private static final BelowAll INSTANCE = new BelowAll();
        private static final long serialVersionUID = 0;

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut, java.lang.Comparable
        public int compareTo(Cut<Comparable<?>> o) {
            return o == this ? 0 : -1;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        boolean isLessThan(Comparable<?> value) {
            return true;
        }

        public String toString() {
            return "-∞";
        }

        private BelowAll() {
            super(null);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    static <C extends Comparable> Cut<C> aboveAll() {
        return AboveAll.INSTANCE;
    }

    private static final class AboveAll extends Cut<Comparable<?>> {
        private static final AboveAll INSTANCE = new AboveAll();
        private static final long serialVersionUID = 0;

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut, java.lang.Comparable
        public int compareTo(Cut<Comparable<?>> o) {
            return o == this ? 0 : 1;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        boolean isLessThan(Comparable<?> value) {
            return false;
        }

        public String toString() {
            return "+∞";
        }

        private AboveAll() {
            super(null);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    static <C extends Comparable> Cut<C> belowValue(C endpoint) {
        return new BelowValue(endpoint);
    }

    private static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        BelowValue(C endpoint) {
            super((Comparable) Preconditions.checkNotNull(endpoint));
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        boolean isLessThan(C value) {
            return Range.compareOrThrow(this.endpoint, value) <= 0;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            sb.append('[');
            sb.append(this.endpoint);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            sb.append(this.endpoint);
            sb.append(')');
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.endpoint);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 2);
            sb.append("\\");
            sb.append(strValueOf);
            sb.append("/");
            return sb.toString();
        }
    }

    static <C extends Comparable> Cut<C> aboveValue(C endpoint) {
        return new AboveValue(endpoint);
    }

    private static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        AboveValue(C endpoint) {
            super((Comparable) Preconditions.checkNotNull(endpoint));
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        boolean isLessThan(C value) {
            return Range.compareOrThrow(this.endpoint, value) < 0;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            sb.append('(');
            sb.append(this.endpoint);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            sb.append(this.endpoint);
            sb.append(']');
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.endpoint);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 2);
            sb.append("/");
            sb.append(strValueOf);
            sb.append("\\");
            return sb.toString();
        }
    }
}

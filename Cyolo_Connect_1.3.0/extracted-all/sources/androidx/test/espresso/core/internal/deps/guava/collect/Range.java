package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Predicate;
import java.io.Serializable;
import java.lang.Comparable;

/* JADX INFO: loaded from: classes.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C>, Serializable {
    private static final Range<Comparable> ALL = new Range<>(Cut.belowAll(), Cut.aboveAll());
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    static <C extends Comparable<?>> Range<C> create(Cut<C> lowerBound, Cut<C> upperBound) {
        return new Range<>(lowerBound, upperBound);
    }

    public static <C extends Comparable<?>> Range<C> closed(C lower, C upper) {
        return create(Cut.belowValue(lower), Cut.aboveValue(upper));
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    private Range(Cut<C> lowerBound, Cut<C> upperBound) {
        this.lowerBound = (Cut) Preconditions.checkNotNull(lowerBound);
        this.upperBound = (Cut) Preconditions.checkNotNull(upperBound);
        if (lowerBound.compareTo((Cut) upperBound) > 0 || lowerBound == Cut.aboveAll() || upperBound == Cut.belowAll()) {
            String strValueOf = String.valueOf(toString(lowerBound, upperBound));
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Invalid range: ".concat(strValueOf) : new String("Invalid range: "));
        }
    }

    public boolean contains(C value) {
        Preconditions.checkNotNull(value);
        return this.lowerBound.isLessThan(value) && !this.upperBound.isLessThan(value);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Predicate
    @Deprecated
    public boolean apply(C input) {
        return contains(input);
    }

    public boolean equals(Object object) {
        if (!(object instanceof Range)) {
            return false;
        }
        Range range = (Range) object;
        return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    private static String toString(Cut<?> lowerBound, Cut<?> upperBound) {
        StringBuilder sb = new StringBuilder(16);
        lowerBound.describeAsLowerBound(sb);
        sb.append("..");
        upperBound.describeAsUpperBound(sb);
        return sb.toString();
    }

    Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    static int compareOrThrow(Comparable left, Comparable right) {
        return left.compareTo(right);
    }
}

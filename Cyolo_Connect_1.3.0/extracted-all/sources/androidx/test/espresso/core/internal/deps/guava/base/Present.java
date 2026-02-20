package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public boolean isPresent() {
        return true;
    }

    Present(T reference) {
        this.reference = reference;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public T get() {
        return this.reference;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public T or(T defaultValue) {
        Preconditions.checkNotNull(defaultValue, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Optional<T> or(Optional<? extends T> secondChoice) {
        Preconditions.checkNotNull(secondChoice);
        return this;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public T or(Supplier<? extends T> supplier) {
        Preconditions.checkNotNull(supplier);
        return this.reference;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public T orNull() {
        return this.reference;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public <V> Optional<V> transform(Function<? super T, V> function) {
        return new Present(Preconditions.checkNotNull(function.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public boolean equals(Object object) {
        if (object instanceof Present) {
            return this.reference.equals(((Present) object).reference);
        }
        return false;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public String toString() {
        String strValueOf = String.valueOf(this.reference);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}

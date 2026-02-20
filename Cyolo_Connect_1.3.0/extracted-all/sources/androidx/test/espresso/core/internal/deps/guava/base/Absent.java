package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class Absent<T> extends Optional<T> {
    static final Absent<Object> INSTANCE = new Absent<>();
    private static final long serialVersionUID = 0;

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public boolean equals(Object object) {
        return object == this;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public int hashCode() {
        return 2040732332;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public T orNull() {
        return null;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    static <T> Optional<T> withType() {
        return INSTANCE;
    }

    private Absent() {
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public T or(T t) {
        return (T) Preconditions.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Optional<T> or(Optional<? extends T> secondChoice) {
        return (Optional) Preconditions.checkNotNull(secondChoice);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public T or(Supplier<? extends T> supplier) {
        return (T) Preconditions.checkNotNull(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public <V> Optional<V> transform(Function<? super T, V> function) {
        Preconditions.checkNotNull(function);
        return Optional.absent();
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

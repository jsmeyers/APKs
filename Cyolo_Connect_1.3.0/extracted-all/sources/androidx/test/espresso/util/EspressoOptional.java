package androidx.test.espresso.util;

import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Optional;
import androidx.test.espresso.core.internal.deps.guava.base.Supplier;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class EspressoOptional<T> {
    private static final long serialVersionUID = 0;
    private final Optional<T> delegate;

    public static <T> EspressoOptional<T> of(T reference) {
        return new EspressoOptional<>(Optional.of(reference));
    }

    public static <T> EspressoOptional<T> absent() {
        return new EspressoOptional<>(Optional.absent());
    }

    public static <T> EspressoOptional<T> fromNullable(T nullableReference) {
        return new EspressoOptional<>(Optional.fromNullable(nullableReference));
    }

    private EspressoOptional(Optional<T> op) {
        this.delegate = op;
    }

    public boolean isPresent() {
        return this.delegate.isPresent();
    }

    public T get() {
        return this.delegate.get();
    }

    public Optional<T> or(Optional<? extends T> secondChoice) {
        return this.delegate.or((Optional) secondChoice);
    }

    public T or(Supplier<? extends T> supplier) {
        return this.delegate.or((Supplier) supplier);
    }

    public T or(T defaultValue) {
        return this.delegate.or(defaultValue);
    }

    public T orNull() {
        return this.delegate.orNull();
    }

    public Set<T> asSet() {
        return this.delegate.asSet();
    }

    public boolean equals(Object object) {
        if (object instanceof EspressoOptional) {
            return ((EspressoOptional) object).delegate.equals(this.delegate);
        }
        return false;
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public String toString() {
        return this.delegate.toString();
    }

    public <V> Optional<V> transform(Function<? super T, V> function) {
        return this.delegate.transform(function);
    }

    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> optionals) {
        return Optional.presentInstances(optionals);
    }
}

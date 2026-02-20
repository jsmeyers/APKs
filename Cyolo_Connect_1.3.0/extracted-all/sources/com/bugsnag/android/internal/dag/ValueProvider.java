package com.bugsnag.android.internal.dag;

import io.cyolo.android.MainActivityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Provider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00028\u0000HÂ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\r\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/bugsnag/android/internal/dag/ValueProvider;", "T", "Lcom/bugsnag/android/internal/dag/Provider;", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "component1", "()Ljava/lang/Object;", "copy", "(Ljava/lang/Object;)Lcom/bugsnag/android/internal/dag/ValueProvider;", "equals", "", "other", "", "get", "getOrNull", "hashCode", "", "toString", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class ValueProvider<T> implements Provider<T> {
    private final T value;

    private final T component1() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ValueProvider copy$default(ValueProvider valueProvider, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = valueProvider.value;
        }
        return valueProvider.copy(obj);
    }

    public final ValueProvider<T> copy(T value) {
        return new ValueProvider<>(value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ValueProvider) && Intrinsics.areEqual(this.value, ((ValueProvider) other).value);
    }

    public int hashCode() {
        T t = this.value;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        return "ValueProvider(value=" + this.value + ')';
    }

    public ValueProvider(T t) {
        this.value = t;
    }

    @Override // com.bugsnag.android.internal.dag.Provider
    public T getOrNull() {
        return get();
    }

    @Override // com.bugsnag.android.internal.dag.Provider
    public T get() {
        return this.value;
    }
}

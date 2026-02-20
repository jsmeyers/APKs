package androidx.test.espresso.core.internal.deps.guava.collect;

/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingObject {
    protected abstract Object delegate();

    protected ForwardingObject() {
    }

    public String toString() {
        return delegate().toString();
    }
}

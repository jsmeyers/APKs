package androidx.test.espresso.core.internal.deps.guava.base;

/* JADX INFO: loaded from: classes.dex */
public abstract class Ticker {
    private static final Ticker SYSTEM_TICKER = new Ticker() { // from class: androidx.test.espresso.core.internal.deps.guava.base.Ticker.1
        @Override // androidx.test.espresso.core.internal.deps.guava.base.Ticker
        public long read() {
            return Platform.systemNanoTime();
        }
    };

    public abstract long read();

    protected Ticker() {
    }

    public static Ticker systemTicker() {
        return SYSTEM_TICKER;
    }
}

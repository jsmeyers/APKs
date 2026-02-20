package androidx.test.espresso.base;

/* JADX INFO: loaded from: classes.dex */
class NoopRunnableIdleNotifier implements IdleNotifier<Runnable> {
    @Override // androidx.test.espresso.base.IdleNotifier
    public void cancelCallback() {
    }

    @Override // androidx.test.espresso.base.IdleNotifier
    public boolean isIdleNow() {
        return true;
    }

    NoopRunnableIdleNotifier() {
    }

    @Override // androidx.test.espresso.base.IdleNotifier
    public void registerNotificationCallback(Runnable r) {
        r.run();
    }
}

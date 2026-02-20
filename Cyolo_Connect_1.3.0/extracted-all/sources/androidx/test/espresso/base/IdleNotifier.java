package androidx.test.espresso.base;

/* JADX INFO: loaded from: classes.dex */
interface IdleNotifier<CB> {
    void cancelCallback();

    boolean isIdleNow();

    void registerNotificationCallback(CB callback);
}

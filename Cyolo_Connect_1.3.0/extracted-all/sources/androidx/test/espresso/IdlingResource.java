package androidx.test.espresso;

/* JADX INFO: loaded from: classes.dex */
public interface IdlingResource {

    public interface ResourceCallback {
        void onTransitionToIdle();
    }

    String getName();

    boolean isIdleNow();

    void registerIdleTransitionCallback(ResourceCallback callback);
}

package androidx.test.espresso.remote;

import android.os.IBinder;
import android.view.View;
import androidx.test.espresso.Root;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import java.util.Map;
import java.util.concurrent.Callable;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public class NoopRemoteInteraction implements RemoteInteraction {
    @Override // androidx.test.espresso.remote.RemoteInteraction
    public boolean isRemoteProcess() {
        return false;
    }

    @Override // androidx.test.espresso.remote.RemoteInteraction
    public Callable<Void> createRemoteCheckCallable(Matcher<Root> rootMatcher, Matcher<View> viewMatcher, Map<String, IBinder> iBinders, ViewAssertion viewAssertion) {
        return new Callable<Void>(this) { // from class: androidx.test.espresso.remote.NoopRemoteInteraction.1
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                throw new NoRemoteEspressoInstanceException("No remote instances available");
            }
        };
    }

    @Override // androidx.test.espresso.remote.RemoteInteraction
    public Callable<Void> createRemotePerformCallable(Matcher<Root> rootMatcher, Matcher<View> viewMatcher, Map<String, IBinder> iBinders, ViewAction... viewActions) {
        return new Callable<Void>(this) { // from class: androidx.test.espresso.remote.NoopRemoteInteraction.2
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                throw new NoRemoteEspressoInstanceException("No remote instances available");
            }
        };
    }
}

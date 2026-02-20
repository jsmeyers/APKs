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
public interface RemoteInteraction {
    public static final String BUNDLE_EXECUTION_STATUS = "executionStatus";

    Callable<Void> createRemoteCheckCallable(Matcher<Root> rootMatcher, Matcher<View> viewMatcher, Map<String, IBinder> iBinders, ViewAssertion viewAssert);

    Callable<Void> createRemotePerformCallable(Matcher<Root> rootMatcher, Matcher<View> viewMatcher, Map<String, IBinder> iBinders, ViewAction... viewActions);

    boolean isRemoteProcess();
}

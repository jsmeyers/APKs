package androidx.test.espresso;

import android.view.View;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public interface FailureHandler {
    void handle(Throwable error, Matcher<View> viewMatcher);
}

package androidx.test.internal.platform.app;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public interface ActivityInvoker {
    void finishActivity(Activity activity);

    Instrumentation.ActivityResult getActivityResult();

    Intent getIntentForActivity(Class<? extends Activity> activityClass);

    void pauseActivity(Activity activity);

    void recreateActivity(Activity activity);

    void resumeActivity(Activity activity);

    void startActivity(Intent intent);

    void stopActivity(Activity activity);
}

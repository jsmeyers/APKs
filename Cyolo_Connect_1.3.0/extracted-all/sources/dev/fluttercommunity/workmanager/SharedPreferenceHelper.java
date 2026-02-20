package dev.fluttercommunity.workmanager;

import android.content.Context;
import android.content.SharedPreferences;
import dev.fluttercommunity.workmanager.WorkManagerCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedPreferenceHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007J\u0014\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010*\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ldev/fluttercommunity/workmanager/SharedPreferenceHelper;", "", "()V", "CALLBACK_DISPATCHER_HANDLE_KEY", "", "SHARED_PREFS_FILE_NAME", "getCallbackHandle", "", "ctx", "Landroid/content/Context;", "hasCallbackHandle", "", "saveCallbackDispatcherHandleKey", "", WorkManagerCall.Initialize.INITIALIZE_TASK_CALL_HANDLE_KEY, "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SharedPreferenceHelper {
    private static final String CALLBACK_DISPATCHER_HANDLE_KEY = "be.tramckrijte.workmanager.CALLBACK_DISPATCHER_HANDLE_KEY";
    public static final SharedPreferenceHelper INSTANCE = new SharedPreferenceHelper();
    private static final String SHARED_PREFS_FILE_NAME = "flutter_workmanager_plugin";

    private SharedPreferenceHelper() {
    }

    private final SharedPreferences prefs(Context context) {
        return context.getSharedPreferences(SHARED_PREFS_FILE_NAME, 0);
    }

    public final void saveCallbackDispatcherHandleKey(Context ctx, long callbackHandle) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        prefs(ctx).edit().putLong(CALLBACK_DISPATCHER_HANDLE_KEY, callbackHandle).apply();
    }

    public final long getCallbackHandle(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return prefs(ctx).getLong(CALLBACK_DISPATCHER_HANDLE_KEY, -1L);
    }

    public final boolean hasCallbackHandle(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return prefs(ctx).contains(CALLBACK_DISPATCHER_HANDLE_KEY);
    }
}

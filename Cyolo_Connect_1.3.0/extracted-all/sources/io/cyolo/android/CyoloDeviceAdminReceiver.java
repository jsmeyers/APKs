package io.cyolo.android;

import android.app.admin.DeviceAdminReceiver;
import android.content.ComponentName;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CyoloDeviceAdminReceiver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lio/cyolo/android/CyoloDeviceAdminReceiver;", "Landroid/app/admin/DeviceAdminReceiver;", "()V", "Companion", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CyoloDeviceAdminReceiver extends DeviceAdminReceiver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: CyoloDeviceAdminReceiver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lio/cyolo/android/CyoloDeviceAdminReceiver$Companion;", "", "()V", "getComponentName", "Landroid/content/ComponentName;", "context", "Landroid/content/Context;", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ComponentName getComponentName(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new ComponentName(context.getApplicationContext(), (Class<?>) CyoloDeviceAdminReceiver.class);
        }
    }
}

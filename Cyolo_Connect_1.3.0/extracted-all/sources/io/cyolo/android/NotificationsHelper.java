package io.cyolo.android;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import io.cyolo.android.model.Status;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationsHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lio/cyolo/android/NotificationsHelper;", "", "()V", "Companion", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NotificationsHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int NOTIFICATION_ID = 333;
    private static final String NOTIFICATION_STATUS_CHANNEL_ID = "io.cyolo.android.STATUS";
    private static final String NOTIFICATION_STATUS_GROUP_ID = "io.cyolo.android.STATUS";

    /* JADX INFO: compiled from: NotificationsHelper.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u0004J.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0011\u001a\u00020\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u00042\b\b\u0003\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J6\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lio/cyolo/android/NotificationsHelper$Companion;", "", "()V", "NOTIFICATION_ID", "", "NOTIFICATION_STATUS_CHANNEL_ID", "", "NOTIFICATION_STATUS_GROUP_ID", "createGroup", "Landroid/app/NotificationChannelGroup;", "context", "Landroid/content/Context;", "id", "name", "description", "createNotification", "Landroid/app/Notification;", "title", "text", "smallIcon", "createStatusGroup", "createStatusNotification", NotificationCompat.CATEGORY_STATUS, "Lio/cyolo/android/model/Status;", "getStatusNotificationSmallDrawable", "getStatusNotificationText", "registerChannel", "", "channelId", "group", "registerStatusChannel", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: NotificationsHelper.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Status.values().length];
                try {
                    iArr[Status.LOGGED_IN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Status.LOGGED_OUT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Status.ERROR.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NotificationChannelGroup createStatusGroup(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return createGroup(context, "io.cyolo.android.STATUS", R.string.notification_group_connection, R.string.notification_group_connection_description);
        }

        public final NotificationChannelGroup createGroup(Context context, String id, int name, int description) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (Build.VERSION.SDK_INT < 26) {
                return null;
            }
            MainActivity$$ExternalSyntheticApiModelOutline0.m365m();
            NotificationChannelGroup notificationChannelGroupM = MainActivity$$ExternalSyntheticApiModelOutline0.m(id, context.getString(name));
            if (Build.VERSION.SDK_INT >= 28) {
                notificationChannelGroupM.setDescription(context.getString(description));
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (notificationManager == null) {
                return null;
            }
            notificationManager.createNotificationChannelGroup(notificationChannelGroupM);
            return notificationChannelGroupM;
        }

        public final void registerStatusChannel(Context context, NotificationChannelGroup group) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (group == null) {
                group = createStatusGroup(context);
            }
            registerChannel(context, "io.cyolo.android.STATUS", R.string.notification_channel_vpn, R.string.notification_channel_vpn_description, group);
        }

        private final void registerChannel(Context context, String channelId, int name, int description, NotificationChannelGroup group) {
            NotificationManager notificationManager;
            if (Build.VERSION.SDK_INT >= 26 && (notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class)) != null) {
                MainActivity$$ExternalSyntheticApiModelOutline0.m371m$1();
                NotificationChannel notificationChannelM = MainActivity$$ExternalSyntheticApiModelOutline0.m(channelId, context.getString(name), 3);
                if (group != null) {
                    notificationChannelM.setGroup(group.getId());
                }
                notificationChannelM.setDescription(context.getString(description));
                notificationChannelM.setLockscreenVisibility(-1);
                notificationManager.createNotificationChannel(notificationChannelM);
            }
        }

        public final Notification createStatusNotification(Context context, Status status) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(status, "status");
            return createNotification(context, R.string.notification_title_vpn, getStatusNotificationText(status), getStatusNotificationSmallDrawable(status));
        }

        private final int getStatusNotificationText(Status status) {
            int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            if (i == 1) {
                return R.string.notification_text_status_logged_in;
            }
            if (i == 2) {
                return R.string.notification_text_status_logged_out;
            }
            if (i == 3) {
                return R.string.notification_text_status_error;
            }
            throw new NoWhenBranchMatchedException();
        }

        private final int getStatusNotificationSmallDrawable(Status status) {
            int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            if (i == 1) {
                return R.drawable.ic_cyolo_connect_logged_in;
            }
            if (i == 2) {
                return R.drawable.ic_cyolo_connect_logged_out;
            }
            if (i == 3) {
                return R.drawable.ic_cyolo_connect_error;
            }
            throw new NoWhenBranchMatchedException();
        }

        static /* synthetic */ Notification createNotification$default(Companion companion, Context context, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 8) != 0) {
                i3 = R.drawable.ic_cyolo_connect_logged_out;
            }
            return companion.createNotification(context, i, i2, i3);
        }

        private final Notification createNotification(Context context, int title, int text, int smallIcon) {
            Notification notificationBuild = new NotificationCompat.Builder(context, "io.cyolo.android.STATUS").setDefaults(-1).setSmallIcon(smallIcon).setShowWhen(false).setOngoing(true).setContentTitle(context.getString(title)).setContentText(context.getString(text)).setContentIntent(PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) MainActivity.class), 67108864)).build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
            return notificationBuild;
        }
    }
}

package androidx.core.graphics;

import android.app.Notification;
import android.app.NotificationChannelGroup;
import android.app.Person;
import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Icon;
import android.telephony.SubscriptionManager;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorKt$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ Notification.MessagingStyle m(Object obj) {
        return (Notification.MessagingStyle) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ NotificationChannelGroup m29m(Object obj) {
        return (NotificationChannelGroup) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Person m30m(Object obj) {
        return (Person) obj;
    }

    public static /* synthetic */ ShortcutInfo.Builder m(Context context, String str) {
        return new ShortcutInfo.Builder(context, str);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ShortcutInfo m33m(Object obj) {
        return (ShortcutInfo) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ShortcutManager m34m(Object obj) {
        return (ShortcutManager) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ImageDecoder.OnHeaderDecodedListener m38m(Object obj) {
        return (ImageDecoder.OnHeaderDecodedListener) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Icon m40m(Object obj) {
        return (Icon) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m44m() {
        return Notification.MessagingStyle.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m48m() {
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m55m(Object obj) {
        return obj instanceof Icon;
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return Notification.DecoratedCustomViewStyle.class;
    }

    public static /* bridge */ /* synthetic */ Class m$2() {
        return SubscriptionManager.class;
    }

    public static /* bridge */ /* synthetic */ Class m$3() {
        return ShortcutManager.class;
    }
}

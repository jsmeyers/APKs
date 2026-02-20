package androidx.activity;

import android.app.NotificationChannel;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.view.inspector.InspectionCompanion;
import android.view.textclassifier.TextClassificationManager;
import android.widget.ThemedSpinnerAdapter;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentDialog$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ NotificationChannel m(Object obj) {
        return (NotificationChannel) obj;
    }

    public static /* synthetic */ NotificationChannel m(String str, CharSequence charSequence, int i) {
        return new NotificationChannel(str, charSequence, i);
    }

    public static /* synthetic */ JobWorkItem m(Intent intent) {
        return new JobWorkItem(intent);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ InspectionCompanion.UninitializedPropertyMapException m9m() {
        return new InspectionCompanion.UninitializedPropertyMapException();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ TextClassificationManager m10m(Object obj) {
        return (TextClassificationManager) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ThemedSpinnerAdapter m12m(Object obj) {
        return (ThemedSpinnerAdapter) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m13m() {
        return TextClassificationManager.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m15m(Object obj) {
        return obj instanceof ThemedSpinnerAdapter;
    }
}

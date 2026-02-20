package io.cyolo.android;

import com.bugsnag.android.Bugsnag;
import io.flutter.app.FlutterApplication;
import kotlin.Metadata;

/* JADX INFO: compiled from: CyoloApp.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lio/cyolo/android/CyoloApp;", "Lio/flutter/app/FlutterApplication;", "()V", "onCreate", "", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CyoloApp extends FlutterApplication {
    @Override // io.flutter.app.FlutterApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        Bugsnag.start(this);
    }
}

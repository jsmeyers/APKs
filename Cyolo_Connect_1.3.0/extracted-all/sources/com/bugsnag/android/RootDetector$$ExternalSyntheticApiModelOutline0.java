package com.bugsnag.android;

import android.app.ApplicationExitInfo;
import android.app.job.JobInfo;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.ImageReader;
import android.net.Uri;
import android.view.DisplayCutout;
import android.webkit.SafeBrowsingResponse;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebViewRenderProcess;
import dalvik.system.DelegateLastClassLoader;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RootDetector$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ ApplicationExitInfo m(Object obj) {
        return (ApplicationExitInfo) obj;
    }

    public static /* synthetic */ JobInfo.TriggerContentUri m(Uri uri, int i) {
        return new JobInfo.TriggerContentUri(uri, i);
    }

    public static /* synthetic */ ImageReader.Builder m(int i, int i2) {
        return new ImageReader.Builder(i, i2);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ DisplayCutout m240m(Object obj) {
        return (DisplayCutout) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ SafeBrowsingResponse m241m(Object obj) {
        return (SafeBrowsingResponse) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ServiceWorkerWebSettings m242m(Object obj) {
        return (ServiceWorkerWebSettings) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ WebMessagePort m243m(Object obj) {
        return (WebMessagePort) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ WebResourceError m244m(Object obj) {
        return (WebResourceError) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ WebViewRenderProcess m245m(Object obj) {
        return (WebViewRenderProcess) obj;
    }

    public static /* synthetic */ DelegateLastClassLoader m(String str, ClassLoader classLoader) {
        return new DelegateLastClassLoader(str, classLoader);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m247m() {
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m251m(Object obj) {
        return obj instanceof DisplayCutout;
    }

    public static /* synthetic */ void m$1() {
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof AdaptiveIconDrawable;
    }

    public static /* synthetic */ void m$2() {
    }
}

package com.google.firebase.dynamiclinks;

import android.net.Uri;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FirebaseDynamicLinks.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u000b\u001a+\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u000b\u001a\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0086\u0002\u001a\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0011H\u0086\u0002\u001a\r\u0010\u0012\u001a\u00020\u0013*\u00020\u0010H\u0086\u0002\u001a\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u000f*\u00020\u0011H\u0086\u0002\u001a\r\u0010\u0014\u001a\u00020\u0015*\u00020\u0010H\u0086\u0002\u001a\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0011H\u0086\u0002\u001a#\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u000b\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b\u001a#\u0010\u001c\u001a\u00020\u0006*\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u000b\u001a;\u0010\u001c\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u000b\u001a+\u0010!\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\"\u001a\u00020\r2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u000b\u001a#\u0010$\u001a\u00020\u0006*\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u000b\u001a#\u0010&\u001a\u00020\u0006*\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u000b\u001a)\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110)*\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u000b\u001a1\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110)*\u00020\u00012\u0006\u0010*\u001a\u00020\u00132\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u000b\u001a#\u0010+\u001a\u00020\u0006*\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u000b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006-"}, d2 = {"dynamicLinks", "Lcom/google/firebase/dynamiclinks/FirebaseDynamicLinks;", "Lcom/google/firebase/Firebase;", "getDynamicLinks", "(Lcom/google/firebase/Firebase;)Lcom/google/firebase/dynamiclinks/FirebaseDynamicLinks;", "androidParameters", "", "Lcom/google/firebase/dynamiclinks/DynamicLink$Builder;", "init", "Lkotlin/Function1;", "Lcom/google/firebase/dynamiclinks/DynamicLink$AndroidParameters$Builder;", "Lkotlin/ExtensionFunctionType;", "packageName", "", "component1", "Landroid/net/Uri;", "Lcom/google/firebase/dynamiclinks/PendingDynamicLinkData;", "Lcom/google/firebase/dynamiclinks/ShortDynamicLink;", "component2", "", "component3", "", "", "Lcom/google/firebase/dynamiclinks/ShortDynamicLink$Warning;", DynamicLink.Builder.KEY_DYNAMIC_LINK, "Lcom/google/firebase/dynamiclinks/DynamicLink;", "app", "Lcom/google/firebase/FirebaseApp;", "googleAnalyticsParameters", "Lcom/google/firebase/dynamiclinks/DynamicLink$GoogleAnalyticsParameters$Builder;", "source", "medium", "campaign", "iosParameters", "bundleId", "Lcom/google/firebase/dynamiclinks/DynamicLink$IosParameters$Builder;", "itunesConnectAnalyticsParameters", "Lcom/google/firebase/dynamiclinks/DynamicLink$ItunesConnectAnalyticsParameters$Builder;", "navigationInfoParameters", "Lcom/google/firebase/dynamiclinks/DynamicLink$NavigationInfoParameters$Builder;", "shortLinkAsync", "Lcom/google/android/gms/tasks/Task;", DynamicLink.Builder.KEY_SUFFIX, "socialMetaTagParameters", "Lcom/google/firebase/dynamiclinks/DynamicLink$SocialMetaTagParameters$Builder;", "com.google.firebase-firebase-dynamic-links"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FirebaseDynamicLinksKt {
    public static final FirebaseDynamicLinks getDynamicLinks(Firebase firebase) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        FirebaseDynamicLinks firebaseDynamicLinks = FirebaseDynamicLinks.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseDynamicLinks, "getInstance()");
        return firebaseDynamicLinks;
    }

    public static final FirebaseDynamicLinks dynamicLinks(Firebase firebase, FirebaseApp app) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        Intrinsics.checkNotNullParameter(app, "app");
        FirebaseDynamicLinks firebaseDynamicLinks = FirebaseDynamicLinks.getInstance(app);
        Intrinsics.checkNotNullExpressionValue(firebaseDynamicLinks, "getInstance(app)");
        return firebaseDynamicLinks;
    }

    public static final void androidParameters(DynamicLink.Builder builder, Function1<? super DynamicLink.AndroidParameters.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        DynamicLink.AndroidParameters.Builder builder2 = new DynamicLink.AndroidParameters.Builder();
        init.invoke(builder2);
        builder.setAndroidParameters(builder2.build());
    }

    public static final void androidParameters(DynamicLink.Builder builder, String packageName, Function1<? super DynamicLink.AndroidParameters.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(init, "init");
        DynamicLink.AndroidParameters.Builder builder2 = new DynamicLink.AndroidParameters.Builder(packageName);
        init.invoke(builder2);
        builder.setAndroidParameters(builder2.build());
    }

    public static final void iosParameters(DynamicLink.Builder builder, String bundleId, Function1<? super DynamicLink.IosParameters.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(bundleId, "bundleId");
        Intrinsics.checkNotNullParameter(init, "init");
        DynamicLink.IosParameters.Builder builder2 = new DynamicLink.IosParameters.Builder(bundleId);
        init.invoke(builder2);
        builder.setIosParameters(builder2.build());
    }

    public static final void googleAnalyticsParameters(DynamicLink.Builder builder, Function1<? super DynamicLink.GoogleAnalyticsParameters.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        DynamicLink.GoogleAnalyticsParameters.Builder builder2 = new DynamicLink.GoogleAnalyticsParameters.Builder();
        init.invoke(builder2);
        builder.setGoogleAnalyticsParameters(builder2.build());
    }

    public static final void googleAnalyticsParameters(DynamicLink.Builder builder, String source, String medium, String campaign, Function1<? super DynamicLink.GoogleAnalyticsParameters.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(medium, "medium");
        Intrinsics.checkNotNullParameter(campaign, "campaign");
        Intrinsics.checkNotNullParameter(init, "init");
        DynamicLink.GoogleAnalyticsParameters.Builder builder2 = new DynamicLink.GoogleAnalyticsParameters.Builder(source, medium, campaign);
        init.invoke(builder2);
        builder.setGoogleAnalyticsParameters(builder2.build());
    }

    public static final void itunesConnectAnalyticsParameters(DynamicLink.Builder builder, Function1<? super DynamicLink.ItunesConnectAnalyticsParameters.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        DynamicLink.ItunesConnectAnalyticsParameters.Builder builder2 = new DynamicLink.ItunesConnectAnalyticsParameters.Builder();
        init.invoke(builder2);
        builder.setItunesConnectAnalyticsParameters(builder2.build());
    }

    public static final void socialMetaTagParameters(DynamicLink.Builder builder, Function1<? super DynamicLink.SocialMetaTagParameters.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        DynamicLink.SocialMetaTagParameters.Builder builder2 = new DynamicLink.SocialMetaTagParameters.Builder();
        init.invoke(builder2);
        builder.setSocialMetaTagParameters(builder2.build());
    }

    public static final void navigationInfoParameters(DynamicLink.Builder builder, Function1<? super DynamicLink.NavigationInfoParameters.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        DynamicLink.NavigationInfoParameters.Builder builder2 = new DynamicLink.NavigationInfoParameters.Builder();
        init.invoke(builder2);
        builder.setNavigationInfoParameters(builder2.build());
    }

    public static final DynamicLink dynamicLink(FirebaseDynamicLinks firebaseDynamicLinks, Function1<? super DynamicLink.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(firebaseDynamicLinks, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        DynamicLink.Builder builderCreateDynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink();
        Intrinsics.checkNotNullExpressionValue(builderCreateDynamicLink, "getInstance().createDynamicLink()");
        init.invoke(builderCreateDynamicLink);
        DynamicLink dynamicLinkBuildDynamicLink = builderCreateDynamicLink.buildDynamicLink();
        Intrinsics.checkNotNullExpressionValue(dynamicLinkBuildDynamicLink, "builder.buildDynamicLink()");
        return dynamicLinkBuildDynamicLink;
    }

    public static final Task<ShortDynamicLink> shortLinkAsync(FirebaseDynamicLinks firebaseDynamicLinks, Function1<? super DynamicLink.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(firebaseDynamicLinks, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        DynamicLink.Builder builderCreateDynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink();
        Intrinsics.checkNotNullExpressionValue(builderCreateDynamicLink, "getInstance().createDynamicLink()");
        init.invoke(builderCreateDynamicLink);
        Task<ShortDynamicLink> taskBuildShortDynamicLink = builderCreateDynamicLink.buildShortDynamicLink();
        Intrinsics.checkNotNullExpressionValue(taskBuildShortDynamicLink, "builder.buildShortDynamicLink()");
        return taskBuildShortDynamicLink;
    }

    public static final Task<ShortDynamicLink> shortLinkAsync(FirebaseDynamicLinks firebaseDynamicLinks, int i, Function1<? super DynamicLink.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(firebaseDynamicLinks, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        DynamicLink.Builder builderCreateDynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink();
        Intrinsics.checkNotNullExpressionValue(builderCreateDynamicLink, "getInstance().createDynamicLink()");
        init.invoke(builderCreateDynamicLink);
        Task<ShortDynamicLink> taskBuildShortDynamicLink = builderCreateDynamicLink.buildShortDynamicLink(i);
        Intrinsics.checkNotNullExpressionValue(taskBuildShortDynamicLink, "builder.buildShortDynamicLink(suffix)");
        return taskBuildShortDynamicLink;
    }

    public static final Uri component1(ShortDynamicLink shortDynamicLink) {
        Intrinsics.checkNotNullParameter(shortDynamicLink, "<this>");
        return shortDynamicLink.getShortLink();
    }

    public static final Uri component2(ShortDynamicLink shortDynamicLink) {
        Intrinsics.checkNotNullParameter(shortDynamicLink, "<this>");
        return shortDynamicLink.getPreviewLink();
    }

    public static final List<ShortDynamicLink.Warning> component3(ShortDynamicLink shortDynamicLink) {
        Intrinsics.checkNotNullParameter(shortDynamicLink, "<this>");
        List warnings = shortDynamicLink.getWarnings();
        Intrinsics.checkNotNullExpressionValue(warnings, "warnings");
        return warnings;
    }

    public static final Uri component1(PendingDynamicLinkData pendingDynamicLinkData) {
        Intrinsics.checkNotNullParameter(pendingDynamicLinkData, "<this>");
        return pendingDynamicLinkData.getLink();
    }

    public static final int component2(PendingDynamicLinkData pendingDynamicLinkData) {
        Intrinsics.checkNotNullParameter(pendingDynamicLinkData, "<this>");
        return pendingDynamicLinkData.getMinimumAppVersion();
    }

    public static final long component3(PendingDynamicLinkData pendingDynamicLinkData) {
        Intrinsics.checkNotNullParameter(pendingDynamicLinkData, "<this>");
        return pendingDynamicLinkData.getClickTimestamp();
    }
}

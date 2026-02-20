package com.bugsnag.android;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: ActivityBreadcrumbCollector.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BI\u0012B\u0010\u0002\u001a>\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\u0010\fJ\u0018\u0010\u0010\u001a\n \u0011*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J.\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0016H\u0002J\u001a\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\"\u0010!\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u00162\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002RJ\u0010\u0002\u001a>\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bugsnag/android/ActivityBreadcrumbCollector;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "cb", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "message", "", "", "method", "", "(Lkotlin/jvm/functions/Function2;)V", "prevState", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "getActivityName", "kotlin.jvm.PlatformType", "activity", "leaveBreadcrumb", "lifecycleCallback", "metadata", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "setActivityIntentMetadata", "intent", "Landroid/content/Intent;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ActivityBreadcrumbCollector implements Application.ActivityLifecycleCallbacks {
    private final Function2<String, Map<String, ? extends Object>, Unit> cb;
    private final WeakHashMap<Activity, String> prevState = new WeakHashMap<>();

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityBreadcrumbCollector(Function2<? super String, ? super Map<String, ? extends Object>, Unit> function2) {
        this.cb = function2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("hasBundle", Boolean.valueOf(savedInstanceState != null));
        setActivityIntentMetadata(linkedHashMap, activity.getIntent());
        Unit unit = Unit.INSTANCE;
        leaveBreadcrumb(activity, "onCreate()", linkedHashMap);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        leaveBreadcrumb$default(this, activity, "onStart()", null, 4, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        leaveBreadcrumb$default(this, activity, "onResume()", null, 4, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        leaveBreadcrumb$default(this, activity, "onPause()", null, 4, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        leaveBreadcrumb$default(this, activity, "onStop()", null, 4, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        leaveBreadcrumb$default(this, activity, "onSaveInstanceState()", null, 4, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        leaveBreadcrumb$default(this, activity, "onDestroy()", null, 4, null);
        this.prevState.remove(activity);
    }

    private final String getActivityName(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void leaveBreadcrumb$default(ActivityBreadcrumbCollector activityBreadcrumbCollector, Activity activity, String str, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = new LinkedHashMap();
        }
        activityBreadcrumbCollector.leaveBreadcrumb(activity, str, map);
    }

    private final void leaveBreadcrumb(Activity activity, String lifecycleCallback, Map<String, Object> metadata) {
        String str = this.prevState.get(activity);
        if (str != null) {
            metadata.put("previous", str);
        }
        String activityName = getActivityName(activity);
        this.cb.invoke(((Object) activityName) + '#' + lifecycleCallback, metadata);
        this.prevState.put(activity, lifecycleCallback);
    }

    private final void setActivityIntentMetadata(Map<String, Object> map, Intent intent) {
        Set<String> setKeySet;
        Object objJoinToString$default;
        String identifier;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (action != null) {
            map.put("action", action);
        }
        Set<String> categories = intent.getCategories();
        if (categories != null) {
            map.put("categories", CollectionsKt.joinToString$default(categories, ", ", null, null, 0, null, null, 62, null));
        }
        String type = intent.getType();
        if (type != null) {
            map.put("type", type);
        }
        if (intent.getFlags() != 0) {
            String string = Integer.toString(intent.getFlags(), CharsKt.checkRadix(16));
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            map.put("flags", kotlin.jvm.internal.Intrinsics.stringPlus("0x", string));
        }
        if (Build.VERSION.SDK_INT >= 29 && (identifier = intent.getIdentifier()) != null) {
            map.put("id", identifier);
        }
        map.put("hasData", Boolean.valueOf(intent.getData() != null));
        try {
            Bundle extras = intent.getExtras();
            if (extras == null || (setKeySet = extras.keySet()) == null || (objJoinToString$default = CollectionsKt.joinToString$default(setKeySet, ", ", null, null, 0, null, null, 62, null)) == null) {
                objJoinToString$default = false;
            }
            map.put("hasExtras", objJoinToString$default);
        } catch (Exception unused) {
        }
    }
}

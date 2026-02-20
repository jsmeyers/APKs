package com.bugsnag.android;

import com.google.firebase.messaging.Constants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: NdkPluginCaller.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eJ\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eJ3\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u000f2\u001a\u0010\u0014\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00160\u0015\"\u0006\u0012\u0002\b\u00030\u0016H\u0002¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0006\u001a\u00020\u0018J\u001a\u0010\u0007\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eJ\u000e\u0010\n\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u000b\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\f\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\tJ\u001a\u0010\r\u001a\u00020\u00192\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bugsnag/android/NdkPluginCaller;", "", "()V", "getCurrentCallbackSetCounts", "Ljava/lang/reflect/Method;", "getCurrentNativeApiCallUsage", "getSignalUnwindStackFunction", "initCallbackCounts", "ndkPlugin", "Lcom/bugsnag/android/Plugin;", "notifyAddCallback", "notifyRemoveCallback", "setInternalMetricsEnabled", "setStaticData", "", "", "", "", "getMethod", "name", "parameterTypes", "", "Ljava/lang/Class;", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "", "", "counts", "callback", "enabled", "setNdkPlugin", "plugin", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NdkPluginCaller {
    public static final NdkPluginCaller INSTANCE = new NdkPluginCaller();
    private static Method getCurrentCallbackSetCounts;
    private static Method getCurrentNativeApiCallUsage;
    private static Method getSignalUnwindStackFunction;
    private static Method initCallbackCounts;
    private static Plugin ndkPlugin;
    private static Method notifyAddCallback;
    private static Method notifyRemoveCallback;
    private static Method setInternalMetricsEnabled;
    private static Method setStaticData;

    private NdkPluginCaller() {
    }

    private final Method getMethod(String name, Class<?>... parameterTypes) {
        Plugin plugin = ndkPlugin;
        if (plugin == null) {
            return null;
        }
        return plugin.getClass().getMethod(name, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
    }

    public final void setNdkPlugin(Plugin plugin) {
        if (plugin != null) {
            ndkPlugin = plugin;
            setInternalMetricsEnabled = getMethod("setInternalMetricsEnabled", Boolean.TYPE);
            setStaticData = getMethod("setStaticData", Map.class);
            getSignalUnwindStackFunction = getMethod("getSignalUnwindStackFunction", new Class[0]);
            getCurrentCallbackSetCounts = getMethod("getCurrentCallbackSetCounts", new Class[0]);
            getCurrentNativeApiCallUsage = getMethod("getCurrentNativeApiCallUsage", new Class[0]);
            initCallbackCounts = getMethod("initCallbackCounts", Map.class);
            notifyAddCallback = getMethod("notifyAddCallback", String.class);
            notifyRemoveCallback = getMethod("notifyRemoveCallback", String.class);
        }
    }

    public final long getSignalUnwindStackFunction() throws IllegalAccessException, InvocationTargetException {
        Method method = getSignalUnwindStackFunction;
        if (method == null) {
            return 0L;
        }
        Object objInvoke = method.invoke(ndkPlugin, new Object[0]);
        if (objInvoke != null) {
            return ((Long) objInvoke).longValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    public final void setInternalMetricsEnabled(boolean enabled) {
        Method method = setInternalMetricsEnabled;
        if (method != null) {
            method.invoke(ndkPlugin, Boolean.valueOf(enabled));
        }
    }

    public final Map<String, Integer> getCurrentCallbackSetCounts() throws IllegalAccessException, InvocationTargetException {
        Method method = getCurrentCallbackSetCounts;
        if (method == null) {
            return null;
        }
        Object objInvoke = method.invoke(ndkPlugin, new Object[0]);
        if (objInvoke != null) {
            return (Map) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Int>");
    }

    public final Map<String, Boolean> getCurrentNativeApiCallUsage() throws IllegalAccessException, InvocationTargetException {
        Method method = getCurrentNativeApiCallUsage;
        if (method == null) {
            return null;
        }
        Object objInvoke = method.invoke(ndkPlugin, new Object[0]);
        if (objInvoke != null) {
            return (Map) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Boolean>");
    }

    public final void initCallbackCounts(Map<String, Integer> counts) throws IllegalAccessException, InvocationTargetException {
        Method method = initCallbackCounts;
        if (method != null) {
            method.invoke(ndkPlugin, counts);
        }
    }

    public final void notifyAddCallback(String callback) throws IllegalAccessException, InvocationTargetException {
        Method method = notifyAddCallback;
        if (method != null) {
            method.invoke(ndkPlugin, callback);
        }
    }

    public final void notifyRemoveCallback(String callback) throws IllegalAccessException, InvocationTargetException {
        Method method = notifyRemoveCallback;
        if (method != null) {
            method.invoke(ndkPlugin, callback);
        }
    }

    public final void setStaticData(Map<String, ? extends Object> data) throws IllegalAccessException, InvocationTargetException {
        Method method = setStaticData;
        if (method != null) {
            method.invoke(ndkPlugin, data);
        }
    }
}

package com.bugsnag.android;

import com.bugsnag.android.internal.ImmutableConfig;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: PluginClient.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0015J\u0016\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0015R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bugsnag/android/PluginClient;", "", "userPlugins", "", "Lcom/bugsnag/android/Plugin;", "immutableConfig", "Lcom/bugsnag/android/internal/ImmutableConfig;", "logger", "Lcom/bugsnag/android/Logger;", "(Ljava/util/Set;Lcom/bugsnag/android/internal/ImmutableConfig;Lcom/bugsnag/android/Logger;)V", "anrPlugin", "ndkPlugin", "plugins", "rnPlugin", "findPlugin", "clz", "Ljava/lang/Class;", "getNdkPlugin", "instantiatePlugin", "", "isWarningEnabled", "", "loadPluginInternal", "", "plugin", "client", "Lcom/bugsnag/android/Client;", "loadPlugins", "setAutoDetectAnrs", "autoDetectAnrs", "setAutoNotify", "autoNotify", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PluginClient {
    private static final String ANR_PLUGIN = "com.bugsnag.android.AnrPlugin";
    private static final String NDK_PLUGIN = "com.bugsnag.android.NdkPlugin";
    private static final String RN_PLUGIN = "com.bugsnag.android.BugsnagReactNativePlugin";
    private final Plugin anrPlugin;
    private final ImmutableConfig immutableConfig;
    private final Logger logger;
    private final Plugin ndkPlugin;
    private final Set<Plugin> plugins;
    private final Plugin rnPlugin;

    public PluginClient(Set<? extends Plugin> set, ImmutableConfig immutableConfig, Logger logger) {
        this.immutableConfig = immutableConfig;
        this.logger = logger;
        Plugin pluginInstantiatePlugin = instantiatePlugin(NDK_PLUGIN, immutableConfig.getEnabledErrorTypes().getNdkCrashes());
        this.ndkPlugin = pluginInstantiatePlugin;
        Plugin pluginInstantiatePlugin2 = instantiatePlugin(ANR_PLUGIN, immutableConfig.getEnabledErrorTypes().getAnrs());
        this.anrPlugin = pluginInstantiatePlugin2;
        Plugin pluginInstantiatePlugin3 = instantiatePlugin(RN_PLUGIN, immutableConfig.getEnabledErrorTypes().getUnhandledRejections());
        this.rnPlugin = pluginInstantiatePlugin3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set);
        if (pluginInstantiatePlugin != null) {
            linkedHashSet.add(pluginInstantiatePlugin);
        }
        if (pluginInstantiatePlugin2 != null) {
            linkedHashSet.add(pluginInstantiatePlugin2);
        }
        if (pluginInstantiatePlugin3 != null) {
            linkedHashSet.add(pluginInstantiatePlugin3);
        }
        this.plugins = CollectionsKt.toSet(linkedHashSet);
    }

    private final Plugin instantiatePlugin(String clz, boolean isWarningEnabled) {
        try {
            Object objNewInstance = Class.forName(clz).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (objNewInstance != null) {
                return (Plugin) objNewInstance;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.bugsnag.android.Plugin");
        } catch (ClassNotFoundException unused) {
            if (isWarningEnabled) {
                this.logger.d("Plugin '" + clz + "' is not on the classpath - functionality will not be enabled.");
            }
            return null;
        } catch (Throwable th) {
            this.logger.e("Failed to load plugin '" + clz + '\'', th);
            return null;
        }
    }

    public final Plugin getNdkPlugin() {
        return this.ndkPlugin;
    }

    public final void loadPlugins(Client client) {
        for (Plugin plugin : this.plugins) {
            try {
                loadPluginInternal(plugin, client);
            } catch (Throwable th) {
                this.logger.e("Failed to load plugin " + plugin + ", continuing with initialisation.", th);
            }
        }
    }

    public final void setAutoNotify(Client client, boolean autoNotify) {
        setAutoDetectAnrs(client, autoNotify);
        if (autoNotify) {
            Plugin plugin = this.ndkPlugin;
            if (plugin == null) {
                return;
            }
            plugin.load(client);
            return;
        }
        Plugin plugin2 = this.ndkPlugin;
        if (plugin2 == null) {
            return;
        }
        plugin2.unload();
    }

    public final void setAutoDetectAnrs(Client client, boolean autoDetectAnrs) {
        if (autoDetectAnrs) {
            Plugin plugin = this.anrPlugin;
            if (plugin == null) {
                return;
            }
            plugin.load(client);
            return;
        }
        Plugin plugin2 = this.anrPlugin;
        if (plugin2 == null) {
            return;
        }
        plugin2.unload();
    }

    public final Plugin findPlugin(Class<?> clz) {
        Object next;
        Iterator<T> it = this.plugins.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (kotlin.jvm.internal.Intrinsics.areEqual(((Plugin) next).getClass(), clz)) {
                return (Plugin) next;
            }
        }
        next = null;
        return (Plugin) next;
    }

    private final void loadPluginInternal(Plugin plugin, Client client) {
        String name = plugin.getClass().getName();
        ErrorTypes enabledErrorTypes = this.immutableConfig.getEnabledErrorTypes();
        if (kotlin.jvm.internal.Intrinsics.areEqual(name, NDK_PLUGIN)) {
            if (enabledErrorTypes.getNdkCrashes()) {
                plugin.load(client);
            }
        } else {
            if (kotlin.jvm.internal.Intrinsics.areEqual(name, ANR_PLUGIN)) {
                if (enabledErrorTypes.getAnrs()) {
                    plugin.load(client);
                    return;
                }
                return;
            }
            plugin.load(client);
        }
    }
}

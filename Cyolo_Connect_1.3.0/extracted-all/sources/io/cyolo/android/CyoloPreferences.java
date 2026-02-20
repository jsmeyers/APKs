package io.cyolo.android;

import android.content.Context;
import androidx.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.cyolo.android.model.Network;
import io.cyolo.android.model.ProxyPolicy;
import io.cyolo.android.model.Site;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CyoloPreferences.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lio/cyolo/android/CyoloPreferences;", "", "()V", "Companion", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CyoloPreferences {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_AUTHORIZATION = "authorization";
    private static final String KEY_BASE_URL = "base_url";
    private static final String KEY_NETWORKS = "networks";
    private static final String KEY_SITES = "sites";

    /* JADX INFO: compiled from: CyoloPreferences.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000bJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0004J\u001c\u0010\u001a\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0016\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0013J\u001c\u0010\u001e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lio/cyolo/android/CyoloPreferences$Companion;", "", "()V", "KEY_AUTHORIZATION", "", "KEY_BASE_URL", "KEY_NETWORKS", "KEY_SITES", "clearProxyPolicy", "", "applicationContext", "Landroid/content/Context;", "getAuthorization", "context", "getBaseUrl", "getNetworks", "", "Lio/cyolo/android/model/Network;", "getProxyPolicy", "Lio/cyolo/android/model/ProxyPolicy;", "getSites", "Lio/cyolo/android/model/Site;", "setAuthorization", "authorization", "setBaseUrl", "baseUrl", "setNetworks", CyoloPreferences.KEY_NETWORKS, "setProxyPolicy", "proxyPolicy", "setSites", CyoloPreferences.KEY_SITES, "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setAuthorization(Context context, String authorization) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(authorization, "authorization");
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString("authorization", authorization).apply();
        }

        public final String getAuthorization(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return PreferenceManager.getDefaultSharedPreferences(context).getString("authorization", null);
        }

        public final void setBaseUrl(Context context, String baseUrl) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(CyoloPreferences.KEY_BASE_URL, baseUrl).apply();
        }

        public final String getBaseUrl(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return PreferenceManager.getDefaultSharedPreferences(context).getString(CyoloPreferences.KEY_BASE_URL, null);
        }

        public final void setNetworks(Context context, List<Network> networks) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(networks, "networks");
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(CyoloPreferences.KEY_NETWORKS, new Gson().toJson(networks)).apply();
        }

        public final List<Network> getNetworks(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Gson gson = new Gson();
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(CyoloPreferences.KEY_NETWORKS, null);
            if (string == null) {
                return CollectionsKt.emptyList();
            }
            Object objFromJson = gson.fromJson(string, new TypeToken<List<? extends Network>>() { // from class: io.cyolo.android.CyoloPreferences$Companion$getNetworks$types$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
            return (List) objFromJson;
        }

        public final void setSites(Context context, List<Site> sites) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sites, "sites");
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(CyoloPreferences.KEY_SITES, new Gson().toJson(sites)).apply();
        }

        public final List<Site> getSites(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Gson gson = new Gson();
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(CyoloPreferences.KEY_SITES, null);
            if (string == null) {
                return CollectionsKt.emptyList();
            }
            Object objFromJson = gson.fromJson(string, new TypeToken<List<? extends Site>>() { // from class: io.cyolo.android.CyoloPreferences$Companion$getSites$type$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
            return (List) objFromJson;
        }

        public final void setProxyPolicy(Context applicationContext, ProxyPolicy proxyPolicy) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            Intrinsics.checkNotNullParameter(proxyPolicy, "proxyPolicy");
            PreferenceManager.getDefaultSharedPreferences(applicationContext).edit().putString("proxy_policy", new Gson().toJson(proxyPolicy)).apply();
        }

        public final ProxyPolicy getProxyPolicy(Context applicationContext) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            Gson gson = new Gson();
            String string = PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("proxy_policy", null);
            if (string == null) {
                return null;
            }
            return (ProxyPolicy) gson.fromJson(string, ProxyPolicy.class);
        }

        public final void clearProxyPolicy(Context applicationContext) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            PreferenceManager.getDefaultSharedPreferences(applicationContext).edit().remove("proxy_policy").apply();
        }
    }
}

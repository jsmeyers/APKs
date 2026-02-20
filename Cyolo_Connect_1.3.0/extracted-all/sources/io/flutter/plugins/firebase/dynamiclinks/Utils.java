package io.flutter.plugins.firebase.dynamiclinks;

import android.net.Uri;
import androidx.core.os.EnvironmentCompat;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import java.util.HashMap;
import java.util.Map;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    static Map<String, Object> getExceptionDetails(Exception exc) {
        HashMap map = new HashMap();
        map.put(ResponseTypeValues.CODE, EnvironmentCompat.MEDIA_UNKNOWN);
        if (exc != null) {
            map.put("message", exc.getMessage());
        } else {
            map.put("message", "An unknown error has occurred.");
        }
        return map;
    }

    static Map<String, Object> getMapFromPendingDynamicLinkData(PendingDynamicLinkData pendingDynamicLinkData) {
        if (pendingDynamicLinkData == null) {
            return null;
        }
        HashMap map = new HashMap();
        Uri link = pendingDynamicLinkData.getLink();
        map.put(DynamicLink.Builder.KEY_LINK, link != null ? link.toString() : null);
        HashMap map2 = new HashMap();
        for (String str : pendingDynamicLinkData.getUtmParameters().keySet()) {
            map2.put(str, pendingDynamicLinkData.getUtmParameters().get(str).toString());
        }
        map.put("utmParameters", map2);
        HashMap map3 = new HashMap();
        map3.put("clickTimestamp", Long.valueOf(pendingDynamicLinkData.getClickTimestamp()));
        map3.put("minimumVersion", Integer.valueOf(pendingDynamicLinkData.getMinimumAppVersion()));
        map.put("android", map3);
        return map;
    }
}

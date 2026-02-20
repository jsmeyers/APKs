package io.flutter.plugins.webview_cookie_manager;

import android.net.Uri;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import com.google.firebase.dynamiclinks.DynamicLink;
import io.cyolo.android.MainActivityKt;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class WebviewCookieManagerPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private MethodChannel channel;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodChannel(registrar.messenger(), "webview_cookie_manager").setMethodCallHandler(new WebviewCookieManagerPlugin());
    }

    private static void hasCookies(MethodChannel.Result result) {
        result.success(Boolean.valueOf(CookieManager.getInstance().hasCookies()));
    }

    private static void clearCookies(final MethodChannel.Result result) {
        CookieManager cookieManager = CookieManager.getInstance();
        final boolean zHasCookies = cookieManager.hasCookies();
        cookieManager.removeAllCookies(new ValueCallback<Boolean>() { // from class: io.flutter.plugins.webview_cookie_manager.WebviewCookieManagerPlugin.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Boolean bool) {
                result.success(Boolean.valueOf(zHasCookies));
            }
        });
    }

    private static void getCookies(MethodCall methodCall, MethodChannel.Result result) {
        ArrayList arrayList;
        if (!(methodCall.arguments() instanceof Map)) {
            result.error("Invalid argument. Expected Map<String,String>, received " + methodCall.arguments().getClass().getSimpleName(), null, null);
            return;
        }
        Map map = (Map) methodCall.arguments();
        CookieManager cookieManager = CookieManager.getInstance();
        String str = (String) map.get(ImagesContract.URL);
        String cookie = str != null ? cookieManager.getCookie(str) : null;
        if (cookie == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(Arrays.asList(cookie.split(";")));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                HttpCookie httpCookie = HttpCookie.parse((String) it.next()).get(0);
                if (httpCookie.getDomain() == null) {
                    httpCookie.setDomain(Uri.parse(str).getHost());
                }
                if (httpCookie.getPath() == null) {
                    httpCookie.setPath("/");
                }
                arrayList2.add(cookieToMap(httpCookie));
            } catch (IllegalArgumentException unused) {
            }
        }
        result.success(arrayList2);
    }

    private static void setCookies(MethodCall methodCall, MethodChannel.Result result) {
        if (!(methodCall.arguments() instanceof List)) {
            result.error("Invalid argument. Expected List<Map<String,String>>, received " + methodCall.arguments().getClass().getSimpleName(), null, null);
            return;
        }
        List<Map> list = (List) methodCall.arguments();
        CookieManager cookieManager = CookieManager.getInstance();
        for (Map map : list) {
            Object obj = map.get(HttpHeaders.ReferrerPolicyValues.ORIGIN);
            String str = obj instanceof String ? (String) obj : null;
            if (str == null) {
                Object obj2 = map.get(DynamicLink.Builder.KEY_DOMAIN);
                str = obj2 instanceof String ? (String) obj2 : "";
            }
            cookieManager.setCookie(str, map.get("asString").toString());
        }
        result.success(null);
    }

    private static Map<String, Object> cookieToMap(HttpCookie httpCookie) {
        HashMap map = new HashMap();
        map.put("name", httpCookie.getName());
        map.put(MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, httpCookie.getValue());
        map.put("path", httpCookie.getPath());
        map.put(DynamicLink.Builder.KEY_DOMAIN, httpCookie.getDomain());
        map.put("secure", Boolean.valueOf(httpCookie.getSecure()));
        if (!httpCookie.hasExpired() && !httpCookie.getDiscard() && httpCookie.getMaxAge() > 0) {
            map.put("expires", Long.valueOf((System.currentTimeMillis() / 1000) + httpCookie.getMaxAge()));
        }
        if (Build.VERSION.SDK_INT >= 24) {
            map.put("httpOnly", Boolean.valueOf(httpCookie.isHttpOnly()));
        }
        return map;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "webview_cookie_manager");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        switch (str) {
            case "hasCookies":
                hasCookies(result);
                break;
            case "setCookies":
                setCookies(methodCall, result);
                break;
            case "clearCookies":
                clearCookies(result);
                break;
            case "getCookies":
                getCookies(methodCall, result);
                break;
            default:
                result.notImplemented();
                break;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler(null);
        this.channel = null;
    }
}

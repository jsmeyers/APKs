package io.flutter.plugins.firebase.dynamiclinks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseDynamicLinksPlugin implements FlutterFirebasePlugin, FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler, PluginRegistry.NewIntentListener {
    private static final String METHOD_CHANNEL_NAME = "plugins.flutter.io/firebase_dynamic_links";
    private static final String TAG = "FLTFirebaseDynamicLinks";
    private final AtomicReference<Activity> activity = new AtomicReference<>(null);
    private Map<String, Object> cachedDynamicLinkData;
    private Map<String, Object> cachedDynamicLinkException;
    private MethodChannel channel;

    private void initInstance(BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, METHOD_CHANNEL_NAME);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        FlutterFirebasePluginRegistry.registerPlugin(METHOD_CHANNEL_NAME, this);
        checkForCachedData();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler(null);
        this.channel = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.activity.set(activityPluginBinding.getActivity());
        activityPluginBinding.addOnNewIntentListener(this);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        detachToActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        this.activity.set(activityPluginBinding.getActivity());
        activityPluginBinding.addOnNewIntentListener(this);
    }

    private void detachToActivity() {
        this.activity.set(null);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        detachToActivity();
    }

    static FirebaseDynamicLinks getDynamicLinkInstance(Map<String, Object> map) {
        String str;
        if (map != null && (str = (String) map.get(Constants.APP_NAME)) != null) {
            return FirebaseDynamicLinks.getInstance(FirebaseApp.getInstance(str));
        }
        return FirebaseDynamicLinks.getInstance();
    }

    @Override // io.flutter.plugin.common.PluginRegistry.NewIntentListener
    public boolean onNewIntent(Intent intent) {
        getDynamicLinkInstance(null).getDynamicLink(intent).addOnSuccessListener(new OnSuccessListener() { // from class: io.flutter.plugins.firebase.dynamiclinks.FlutterFirebaseDynamicLinksPlugin$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.m400x79fca916((PendingDynamicLinkData) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: io.flutter.plugins.firebase.dynamiclinks.FlutterFirebaseDynamicLinksPlugin$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f$0.m401xbc13d675(exc);
            }
        });
        return false;
    }

    /* JADX INFO: renamed from: lambda$onNewIntent$0$io-flutter-plugins-firebase-dynamiclinks-FlutterFirebaseDynamicLinksPlugin, reason: not valid java name */
    /* synthetic */ void m400x79fca916(PendingDynamicLinkData pendingDynamicLinkData) {
        Map<String, Object> mapFromPendingDynamicLinkData = Utils.getMapFromPendingDynamicLinkData(pendingDynamicLinkData);
        if (mapFromPendingDynamicLinkData != null) {
            MethodChannel methodChannel = this.channel;
            if (methodChannel != null) {
                methodChannel.invokeMethod("FirebaseDynamicLink#onLinkSuccess", mapFromPendingDynamicLinkData);
            } else {
                this.cachedDynamicLinkData = mapFromPendingDynamicLinkData;
            }
        }
    }

    /* JADX INFO: renamed from: lambda$onNewIntent$1$io-flutter-plugins-firebase-dynamiclinks-FlutterFirebaseDynamicLinksPlugin, reason: not valid java name */
    /* synthetic */ void m401xbc13d675(Exception exc) {
        Map<String, Object> exceptionDetails = Utils.getExceptionDetails(exc);
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("FirebaseDynamicLink#onLinkError", exceptionDetails);
        } else {
            this.cachedDynamicLinkException = exceptionDetails;
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        FirebaseDynamicLinks dynamicLinkInstance;
        Task<Map<String, Object>> dynamicLink;
        dynamicLinkInstance = getDynamicLinkInstance((Map) methodCall.arguments());
        String str = methodCall.method;
        str.hashCode();
        switch (str) {
            case "FirebaseDynamicLinks#getDynamicLink":
            case "FirebaseDynamicLinks#getInitialLink":
                dynamicLink = getDynamicLink(dynamicLinkInstance, (String) methodCall.argument(ImagesContract.URL));
                break;
            case "FirebaseDynamicLinks#buildShortLink":
                dynamicLink = buildShortLink((Map) Objects.requireNonNull((Map) methodCall.arguments()));
                break;
            case "FirebaseDynamicLinks#buildLink":
                result.success(buildLink((Map) methodCall.arguments()));
                return;
            default:
                result.notImplemented();
                return;
        }
        dynamicLink.addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.dynamiclinks.FlutterFirebaseDynamicLinksPlugin$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseDynamicLinksPlugin.lambda$onMethodCall$2(result, task);
            }
        });
    }

    static /* synthetic */ void lambda$onMethodCall$2(MethodChannel.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
        } else {
            Exception exception = task.getException();
            result.error(Constants.DEFAULT_ERROR_CODE, exception != null ? exception.getMessage() : null, Utils.getExceptionDetails(exception));
        }
    }

    private void checkForCachedData() {
        Map<String, Object> map = this.cachedDynamicLinkData;
        if (map != null) {
            this.channel.invokeMethod("FirebaseDynamicLink#onLinkSuccess", map);
            this.cachedDynamicLinkData = null;
        }
        Map<String, Object> map2 = this.cachedDynamicLinkException;
        if (map2 != null) {
            this.channel.invokeMethod("FirebaseDynamicLink#onLinkError", map2);
            this.cachedDynamicLinkException = null;
        }
    }

    private String buildLink(Map<String, Object> map) {
        return setupParameters(map).buildDynamicLink().getUri().toString();
    }

    private Task<Map<String, Object>> buildShortLink(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.dynamiclinks.FlutterFirebaseDynamicLinksPlugin$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m398x1cfda2ee(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: renamed from: lambda$buildShortLink$3$io-flutter-plugins-firebase-dynamiclinks-FlutterFirebaseDynamicLinksPlugin, reason: not valid java name */
    /* synthetic */ void m398x1cfda2ee(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            DynamicLink.Builder builder = setupParameters(map);
            String str = (String) map.get("longDynamicLink");
            if (str != null) {
                builder.setLongLink(Uri.parse(str));
            }
            Integer num = 1;
            Integer num2 = (Integer) map.get("shortLinkType");
            if (num2 != null) {
                int iIntValue = num2.intValue();
                if (iIntValue == 0) {
                    num = 1;
                } else if (iIntValue == 1) {
                    num = 2;
                }
            }
            HashMap map2 = new HashMap();
            ShortDynamicLink shortDynamicLink = (ShortDynamicLink) Tasks.await(builder.buildShortDynamicLink(num.intValue()));
            ArrayList arrayList = new ArrayList();
            Iterator<? extends ShortDynamicLink.Warning> it = shortDynamicLink.getWarnings().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getMessage());
            }
            map2.put(ImagesContract.URL, shortDynamicLink.getShortLink().toString());
            map2.put("warnings", arrayList);
            map2.put("previewLink", shortDynamicLink.getPreviewLink().toString());
            taskCompletionSource.setResult(map2);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Map<String, Object>> getDynamicLink(final FirebaseDynamicLinks firebaseDynamicLinks, final String str) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.dynamiclinks.FlutterFirebaseDynamicLinksPlugin$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m399x3873b052(str, firebaseDynamicLinks, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: renamed from: lambda$getDynamicLink$4$io-flutter-plugins-firebase-dynamiclinks-FlutterFirebaseDynamicLinksPlugin, reason: not valid java name */
    /* synthetic */ void m399x3873b052(String str, FirebaseDynamicLinks firebaseDynamicLinks, TaskCompletionSource taskCompletionSource) {
        PendingDynamicLinkData pendingDynamicLinkData;
        try {
            if (str == null) {
                if (this.activity.get() != null && this.activity.get().getIntent() != null && !this.activity.get().getIntent().getBooleanExtra("flutterfire-used-link", false)) {
                    this.activity.get().getIntent().putExtra("flutterfire-used-link", true);
                    pendingDynamicLinkData = (PendingDynamicLinkData) Tasks.await(firebaseDynamicLinks.getDynamicLink(this.activity.get().getIntent()));
                }
                taskCompletionSource.setResult(null);
                return;
            }
            pendingDynamicLinkData = (PendingDynamicLinkData) Tasks.await(firebaseDynamicLinks.getDynamicLink(Uri.parse(str)));
            taskCompletionSource.setResult(Utils.getMapFromPendingDynamicLinkData(pendingDynamicLinkData));
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private DynamicLink.Builder setupParameters(Map<String, Object> map) {
        DynamicLink.Builder builderCreateDynamicLink = getDynamicLinkInstance(map).createDynamicLink();
        String str = (String) Objects.requireNonNull(map.get("uriPrefix"));
        String str2 = (String) map.get(DynamicLink.Builder.KEY_LINK);
        builderCreateDynamicLink.setDomainUriPrefix(str);
        builderCreateDynamicLink.setLink(Uri.parse(str2));
        Map map2 = (Map) map.get("androidParameters");
        if (map2 != null) {
            String str3 = (String) valueFor("packageName", map2);
            String str4 = (String) valueFor("fallbackUrl", map2);
            Integer num = (Integer) valueFor("minimumVersion", map2);
            DynamicLink.AndroidParameters.Builder builder = new DynamicLink.AndroidParameters.Builder(str3);
            if (str4 != null) {
                builder.setFallbackUrl(Uri.parse(str4));
            }
            if (num != null) {
                builder.setMinimumVersion(num.intValue());
            }
            builderCreateDynamicLink.setAndroidParameters(builder.build());
        }
        Map map3 = (Map) map.get("googleAnalyticsParameters");
        if (map3 != null) {
            String str5 = (String) valueFor("campaign", map3);
            String str6 = (String) valueFor("content", map3);
            String str7 = (String) valueFor("medium", map3);
            String str8 = (String) valueFor("source", map3);
            String str9 = (String) valueFor("term", map3);
            DynamicLink.GoogleAnalyticsParameters.Builder builder2 = new DynamicLink.GoogleAnalyticsParameters.Builder();
            if (str5 != null) {
                builder2.setCampaign(str5);
            }
            if (str6 != null) {
                builder2.setContent(str6);
            }
            if (str7 != null) {
                builder2.setMedium(str7);
            }
            if (str8 != null) {
                builder2.setSource(str8);
            }
            if (str9 != null) {
                builder2.setTerm(str9);
            }
            builderCreateDynamicLink.setGoogleAnalyticsParameters(builder2.build());
        }
        Map map4 = (Map) map.get("iosParameters");
        if (map4 != null) {
            String str10 = (String) valueFor("bundleId", map4);
            String str11 = (String) valueFor("appStoreId", map4);
            String str12 = (String) valueFor("customScheme", map4);
            String str13 = (String) valueFor("fallbackUrl", map4);
            String str14 = (String) valueFor("ipadBundleId", map4);
            String str15 = (String) valueFor("ipadFallbackUrl", map4);
            String str16 = (String) valueFor("minimumVersion", map4);
            DynamicLink.IosParameters.Builder builder3 = new DynamicLink.IosParameters.Builder(str10);
            if (str11 != null) {
                builder3.setAppStoreId(str11);
            }
            if (str12 != null) {
                builder3.setCustomScheme(str12);
            }
            if (str13 != null) {
                builder3.setFallbackUrl(Uri.parse(str13));
            }
            if (str14 != null) {
                builder3.setIpadBundleId(str14);
            }
            if (str15 != null) {
                builder3.setIpadFallbackUrl(Uri.parse(str15));
            }
            if (str16 != null) {
                builder3.setMinimumVersion(str16);
            }
            builderCreateDynamicLink.setIosParameters(builder3.build());
        }
        Map map5 = (Map) map.get("itunesConnectAnalyticsParameters");
        if (map5 != null) {
            String str17 = (String) valueFor("affiliateToken", map5);
            String str18 = (String) valueFor("campaignToken", map5);
            String str19 = (String) valueFor("providerToken", map5);
            DynamicLink.ItunesConnectAnalyticsParameters.Builder builder4 = new DynamicLink.ItunesConnectAnalyticsParameters.Builder();
            if (str17 != null) {
                builder4.setAffiliateToken(str17);
            }
            if (str18 != null) {
                builder4.setCampaignToken(str18);
            }
            if (str19 != null) {
                builder4.setProviderToken(str19);
            }
            builderCreateDynamicLink.setItunesConnectAnalyticsParameters(builder4.build());
        }
        Map map6 = (Map) map.get("navigationInfoParameters");
        if (map6 != null) {
            Boolean bool = (Boolean) valueFor("forcedRedirectEnabled", map6);
            DynamicLink.NavigationInfoParameters.Builder builder5 = new DynamicLink.NavigationInfoParameters.Builder();
            if (bool != null) {
                builder5.setForcedRedirectEnabled(bool.booleanValue());
            }
            builderCreateDynamicLink.setNavigationInfoParameters(builder5.build());
        }
        Map map7 = (Map) map.get("socialMetaTagParameters");
        if (map7 != null) {
            String str20 = (String) valueFor("description", map7);
            String str21 = (String) valueFor("imageUrl", map7);
            String str22 = (String) valueFor("title", map7);
            DynamicLink.SocialMetaTagParameters.Builder builder6 = new DynamicLink.SocialMetaTagParameters.Builder();
            if (str20 != null) {
                builder6.setDescription(str20);
            }
            if (str21 != null) {
                builder6.setImageUrl(Uri.parse(str21));
            }
            if (str22 != null) {
                builder6.setTitle(str22);
            }
            builderCreateDynamicLink.setSocialMetaTagParameters(builder6.build());
        }
        return builderCreateDynamicLink;
    }

    private static <T> T valueFor(String str, Map<String, Object> map) {
        return (T) map.get(str);
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.dynamiclinks.FlutterFirebaseDynamicLinksPlugin$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                taskCompletionSource.setResult(null);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.dynamiclinks.FlutterFirebaseDynamicLinksPlugin$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                taskCompletionSource.setResult(null);
            }
        });
        return taskCompletionSource.getTask();
    }
}

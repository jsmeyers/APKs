package io.flutter.plugins;

import com.bottlepay.flutter_libphonenumber.FlutterLibphonenumberPlugin;
import com.bugsnag.flutter.BugsnagFlutterPlugin;
import com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin;
import com.it_nomads.fluttersecurestorage.FlutterSecureStoragePlugin;
import dev.flutter.plugins.integration_test.IntegrationTestPlugin;
import dev.fluttercommunity.plus.device_info.DeviceInfoPlusPlugin;
import dev.fluttercommunity.plus.network_info.NetworkInfoPlusPlugin;
import dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin;
import dev.fluttercommunity.workmanager.WorkmanagerPlugin;
import io.crossingthestreams.flutterappauth.FlutterAppauthPlugin;
import io.cyolo.linking.LinkingPlugin;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.dynamiclinks.FlutterFirebaseDynamicLinksPlugin;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin;
import io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin;
import io.flutter.plugins.localauth.LocalAuthPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.urllauncher.UrlLauncherPlugin;
import io.flutter.plugins.webview_cookie_manager.WebviewCookieManagerPlugin;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;
import net.jonhanson.flutter_native_splash.FlutterNativeSplashPlugin;
import net.touchcapture.qr.flutterqr.FlutterQrPlugin;

/* JADX INFO: loaded from: classes3.dex */
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add(new BugsnagFlutterPlugin());
        } catch (Exception e) {
            Log.e(TAG, "Error registering plugin bugsnag_flutter, com.bugsnag.flutter.BugsnagFlutterPlugin", e);
        }
        try {
            flutterEngine.getPlugins().add(new DeviceInfoPlusPlugin());
        } catch (Exception e2) {
            Log.e(TAG, "Error registering plugin device_info_plus, dev.fluttercommunity.plus.device_info.DeviceInfoPlusPlugin", e2);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterFirebaseCorePlugin());
        } catch (Exception e3) {
            Log.e(TAG, "Error registering plugin firebase_core, io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin", e3);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterFirebaseDynamicLinksPlugin());
        } catch (Exception e4) {
            Log.e(TAG, "Error registering plugin firebase_dynamic_links, io.flutter.plugins.firebase.dynamiclinks.FlutterFirebaseDynamicLinksPlugin", e4);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterFirebaseMessagingPlugin());
        } catch (Exception e5) {
            Log.e(TAG, "Error registering plugin firebase_messaging, io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin", e5);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterAppauthPlugin());
        } catch (Exception e6) {
            Log.e(TAG, "Error registering plugin flutter_appauth, io.crossingthestreams.flutterappauth.FlutterAppauthPlugin", e6);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterLibphonenumberPlugin());
        } catch (Exception e7) {
            Log.e(TAG, "Error registering plugin flutter_libphonenumber_android, com.bottlepay.flutter_libphonenumber.FlutterLibphonenumberPlugin", e7);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterLocalNotificationsPlugin());
        } catch (Exception e8) {
            Log.e(TAG, "Error registering plugin flutter_local_notifications, com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin", e8);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterNativeSplashPlugin());
        } catch (Exception e9) {
            Log.e(TAG, "Error registering plugin flutter_native_splash, net.jonhanson.flutter_native_splash.FlutterNativeSplashPlugin", e9);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterAndroidLifecyclePlugin());
        } catch (Exception e10) {
            Log.e(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e10);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterSecureStoragePlugin());
        } catch (Exception e11) {
            Log.e(TAG, "Error registering plugin flutter_secure_storage, com.it_nomads.fluttersecurestorage.FlutterSecureStoragePlugin", e11);
        }
        try {
            flutterEngine.getPlugins().add(new IntegrationTestPlugin());
        } catch (Exception e12) {
            Log.e(TAG, "Error registering plugin integration_test, dev.flutter.plugins.integration_test.IntegrationTestPlugin", e12);
        }
        try {
            flutterEngine.getPlugins().add(new LinkingPlugin());
        } catch (Exception e13) {
            Log.e(TAG, "Error registering plugin linking, io.cyolo.linking.LinkingPlugin", e13);
        }
        try {
            flutterEngine.getPlugins().add(new LocalAuthPlugin());
        } catch (Exception e14) {
            Log.e(TAG, "Error registering plugin local_auth_android, io.flutter.plugins.localauth.LocalAuthPlugin", e14);
        }
        try {
            flutterEngine.getPlugins().add(new NetworkInfoPlusPlugin());
        } catch (Exception e15) {
            Log.e(TAG, "Error registering plugin network_info_plus, dev.fluttercommunity.plus.network_info.NetworkInfoPlusPlugin", e15);
        }
        try {
            flutterEngine.getPlugins().add(new PackageInfoPlugin());
        } catch (Exception e16) {
            Log.e(TAG, "Error registering plugin package_info_plus, dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin", e16);
        }
        try {
            flutterEngine.getPlugins().add(new PathProviderPlugin());
        } catch (Exception e17) {
            Log.e(TAG, "Error registering plugin path_provider_android, io.flutter.plugins.pathprovider.PathProviderPlugin", e17);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterQrPlugin());
        } catch (Exception e18) {
            Log.e(TAG, "Error registering plugin qr_code_scanner, net.touchcapture.qr.flutterqr.FlutterQrPlugin", e18);
        }
        try {
            flutterEngine.getPlugins().add(new UrlLauncherPlugin());
        } catch (Exception e19) {
            Log.e(TAG, "Error registering plugin url_launcher_android, io.flutter.plugins.urllauncher.UrlLauncherPlugin", e19);
        }
        try {
            flutterEngine.getPlugins().add(new WebviewCookieManagerPlugin());
        } catch (Exception e20) {
            Log.e(TAG, "Error registering plugin webview_cookie_manager, io.flutter.plugins.webview_cookie_manager.WebviewCookieManagerPlugin", e20);
        }
        try {
            flutterEngine.getPlugins().add(new WebViewFlutterPlugin());
        } catch (Exception e21) {
            Log.e(TAG, "Error registering plugin webview_flutter_android, io.flutter.plugins.webviewflutter.WebViewFlutterPlugin", e21);
        }
        try {
            flutterEngine.getPlugins().add(new WorkmanagerPlugin());
        } catch (Exception e22) {
            Log.e(TAG, "Error registering plugin workmanager, dev.fluttercommunity.workmanager.WorkmanagerPlugin", e22);
        }
    }
}

package net.openid.appauth.browser;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class BrowserSelector {
    static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    static final Intent BROWSER_INTENT = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts("http", "", null));
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";

    public static List<BrowserDescriptor> getAllBrowsers(Context context) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i2 = Build.VERSION.SDK_INT >= 23 ? 131136 : 64;
        Intent intent = BROWSER_INTENT;
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        String str = resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo.packageName : null;
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, i2)) {
            if (isFullBrowser(resolveInfo)) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 64);
                    if (hasWarmupService(packageManager, resolveInfo.activityInfo.packageName)) {
                        i = 1;
                        BrowserDescriptor browserDescriptor = new BrowserDescriptor(packageInfo, true);
                        if (resolveInfo.activityInfo.packageName.equals(str)) {
                            arrayList.add(0, browserDescriptor);
                        } else {
                            arrayList.add(browserDescriptor);
                            i = 0;
                        }
                    } else {
                        i = 0;
                    }
                    BrowserDescriptor browserDescriptor2 = new BrowserDescriptor(packageInfo, false);
                    if (resolveInfo.activityInfo.packageName.equals(str)) {
                        arrayList.add(i, browserDescriptor2);
                    } else {
                        arrayList.add(browserDescriptor2);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        return arrayList;
    }

    public static BrowserDescriptor select(Context context, BrowserMatcher browserMatcher) {
        BrowserDescriptor browserDescriptor = null;
        for (BrowserDescriptor browserDescriptor2 : getAllBrowsers(context)) {
            if (browserMatcher.matches(browserDescriptor2)) {
                if (browserDescriptor2.useCustomTab.booleanValue()) {
                    return browserDescriptor2;
                }
                if (browserDescriptor == null) {
                    browserDescriptor = browserDescriptor2;
                }
            }
        }
        return browserDescriptor;
    }

    private static boolean hasWarmupService(PackageManager pm, String packageName) {
        Intent intent = new Intent();
        intent.setAction("android.support.customtabs.action.CustomTabsService");
        intent.setPackage(packageName);
        return pm.resolveService(intent, 0) != null;
    }

    private static boolean isFullBrowser(ResolveInfo resolveInfo) {
        if (resolveInfo.filter == null || !resolveInfo.filter.hasAction("android.intent.action.VIEW") || !resolveInfo.filter.hasCategory("android.intent.category.BROWSABLE") || resolveInfo.filter.schemesIterator() == null || resolveInfo.filter.authoritiesIterator() != null) {
            return false;
        }
        Iterator<String> itSchemesIterator = resolveInfo.filter.schemesIterator();
        boolean zEquals = false;
        boolean zEquals2 = false;
        while (itSchemesIterator.hasNext()) {
            String next = itSchemesIterator.next();
            zEquals |= "http".equals(next);
            zEquals2 |= "https".equals(next);
            if (zEquals && zEquals2) {
                return true;
            }
        }
        return false;
    }
}

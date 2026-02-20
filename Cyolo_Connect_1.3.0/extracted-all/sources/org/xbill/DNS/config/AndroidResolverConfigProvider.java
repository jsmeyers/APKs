package org.xbill.DNS.config;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidResolverConfigProvider extends BaseResolverConfigProvider {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) AndroidResolverConfigProvider.class);
    private static Context context = null;

    public static void setContext(Context context2) {
        context = context2;
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public void initialize() throws InitializationException {
        LinkProperties linkProperties;
        Context context2 = context;
        if (context2 == null) {
            throw new InitializationException("Context must be initialized by calling setContext");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService(ConnectivityManager.class);
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) == null) {
            return;
        }
        Iterator<InetAddress> it = linkProperties.getDnsServers().iterator();
        while (it.hasNext()) {
            addNameserver(new InetSocketAddress(it.next(), 53));
        }
        parseSearchPathList(linkProperties.getDomains(), ",");
    }

    @Override // org.xbill.DNS.config.BaseResolverConfigProvider, org.xbill.DNS.config.ResolverConfigProvider
    public boolean isEnabled() {
        return System.getProperty("java.vendor").contains("Android");
    }
}

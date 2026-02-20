package org.xbill.DNS.config;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class PropertyResolverConfigProvider extends BaseResolverConfigProvider {
    public static final String DNS_NDOTS_PROP = "dns.ndots";
    public static final String DNS_SEARCH_PROP = "dns.search";
    public static final String DNS_SERVER_PROP = "dns.server";
    private int ndots;

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public void initialize() {
        initialize(DNS_SERVER_PROP, DNS_SEARCH_PROP, DNS_NDOTS_PROP);
    }

    protected void initialize(String str, String str2, String str3) {
        String property = System.getProperty(str);
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                try {
                    URI uri = new URI("dns://" + strNextToken);
                    int i = 53;
                    if (uri.getHost() == null) {
                        addNameserver(new InetSocketAddress(strNextToken, 53));
                    } else {
                        int port = uri.getPort();
                        if (port != -1) {
                            i = port;
                        }
                        addNameserver(new InetSocketAddress(uri.getHost(), i));
                    }
                } catch (URISyntaxException unused) {
                    this.log.warn("Ignored invalid server {}", strNextToken);
                }
            }
        }
        parseSearchPathList(System.getProperty(str2), ",");
        this.ndots = parseNdots(System.getProperty(str3));
    }

    @Override // org.xbill.DNS.config.BaseResolverConfigProvider, org.xbill.DNS.config.ResolverConfigProvider
    public int ndots() {
        return this.ndots;
    }
}

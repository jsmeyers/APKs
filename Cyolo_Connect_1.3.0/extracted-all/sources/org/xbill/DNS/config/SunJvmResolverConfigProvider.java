package org.xbill.DNS.config;

import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SunJvmResolverConfigProvider extends BaseResolverConfigProvider {
    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public void initialize() throws InitializationException {
        try {
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            Object objInvoke = cls.getDeclaredMethod("open", new Class[0]).invoke(null, new Object[0]);
            Iterator it = ((List) cls.getMethod("nameservers", new Class[0]).invoke(objInvoke, new Object[0])).iterator();
            while (it.hasNext()) {
                addNameserver(new InetSocketAddress((String) it.next(), 53));
            }
            Iterator it2 = ((List) cls.getMethod("searchlist", new Class[0]).invoke(objInvoke, new Object[0])).iterator();
            while (it2.hasNext()) {
                addSearchPath((String) it2.next());
            }
        } catch (Exception e) {
            throw new InitializationException(e);
        }
    }

    @Override // org.xbill.DNS.config.BaseResolverConfigProvider, org.xbill.DNS.config.ResolverConfigProvider
    public boolean isEnabled() {
        return Boolean.getBoolean("dnsjava.configprovider.sunjvm.enabled");
    }
}

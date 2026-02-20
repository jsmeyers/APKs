package org.xbill.DNS.spi;

import sun.net.spi.nameservice.NameService;
import sun.net.spi.nameservice.NameServiceDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public class DNSJavaNameServiceDescriptor implements NameServiceDescriptor {
    public String getProviderName() {
        return "dnsjava";
    }

    public String getType() {
        return "dns";
    }

    public NameService createNameService() {
        return new DNSJavaNameService();
    }
}

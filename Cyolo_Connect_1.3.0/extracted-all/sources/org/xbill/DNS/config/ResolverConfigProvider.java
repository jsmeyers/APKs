package org.xbill.DNS.config;

import java.net.InetSocketAddress;
import java.util.List;
import org.xbill.DNS.Name;

/* JADX INFO: loaded from: classes2.dex */
public interface ResolverConfigProvider {

    /* JADX INFO: renamed from: org.xbill.DNS.config.ResolverConfigProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isEnabled(ResolverConfigProvider _this) {
            return true;
        }

        public static int $default$ndots(ResolverConfigProvider _this) {
            return 1;
        }
    }

    void initialize() throws InitializationException;

    boolean isEnabled();

    int ndots();

    List<Name> searchPaths();

    List<InetSocketAddress> servers();
}

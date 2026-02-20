package org.xbill.DNS.config;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.Name;
import org.xbill.DNS.config.ResolverConfigProvider;

/* JADX INFO: loaded from: classes2.dex */
public class JndiContextResolverConfigProvider implements ResolverConfigProvider {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) JndiContextResolverConfigProvider.class);
    private InnerJndiContextResolverConfigProvider inner;

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public /* synthetic */ int ndots() {
        return ResolverConfigProvider.CC.$default$ndots(this);
    }

    public JndiContextResolverConfigProvider() {
        if (System.getProperty("java.vendor").contains("Android")) {
            return;
        }
        try {
            this.inner = new InnerJndiContextResolverConfigProvider();
        } catch (NoClassDefFoundError unused) {
            log.debug("JNDI DNS not available");
        }
    }

    private static final class InnerJndiContextResolverConfigProvider extends BaseResolverConfigProvider {
        private static final Logger log;

        static {
            Logger logger = LoggerFactory.getLogger((Class<?>) InnerJndiContextResolverConfigProvider.class);
            log = logger;
            logger.debug("JNDI class: {}", DirContext.class.getName());
        }

        private InnerJndiContextResolverConfigProvider() {
        }

        @Override // org.xbill.DNS.config.ResolverConfigProvider
        public void initialize() {
            String str;
            InitialDirContext initialDirContext;
            Hashtable hashtable = new Hashtable();
            hashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
            hashtable.put("java.naming.provider.url", "dns://");
            String str2 = null;
            try {
                initialDirContext = new InitialDirContext(hashtable);
                str = (String) initialDirContext.getEnvironment().get("java.naming.provider.url");
            } catch (NamingException unused) {
            }
            try {
                initialDirContext.close();
            } catch (NamingException unused2) {
                str2 = str;
                str = str2;
            }
            if (str != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
                while (stringTokenizer.hasMoreTokens()) {
                    String strNextToken = stringTokenizer.nextToken();
                    try {
                        URI uri = new URI(strNextToken);
                        String host = uri.getHost();
                        if (host != null && !host.isEmpty()) {
                            int port = uri.getPort();
                            if (port == -1) {
                                port = 53;
                            }
                            addNameserver(new InetSocketAddress(host, port));
                        }
                    } catch (URISyntaxException e) {
                        log.debug("Could not parse {} as a dns server, ignoring", strNextToken, e);
                    }
                }
            }
        }
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public void initialize() {
        this.inner.initialize();
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public List<InetSocketAddress> servers() {
        return this.inner.servers();
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public List<Name> searchPaths() {
        return this.inner.searchPaths();
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public boolean isEnabled() {
        return this.inner != null;
    }
}

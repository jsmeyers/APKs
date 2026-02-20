package org.xbill.DNS.config;

import j$.util.Collection;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.Name;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.config.ResolverConfigProvider;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseResolverConfigProvider implements ResolverConfigProvider {
    private static final boolean ipv4only = Boolean.getBoolean("java.net.preferIPv4Stack");
    private static final boolean ipv6first = Boolean.getBoolean("java.net.preferIPv6Addresses");
    private final List<InetSocketAddress> nameservers = new ArrayList(3);
    final Logger log = LoggerFactory.getLogger(getClass());
    List<Name> searchlist = new ArrayList(1);

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public /* synthetic */ boolean isEnabled() {
        return ResolverConfigProvider.CC.$default$isEnabled(this);
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public /* synthetic */ int ndots() {
        return ResolverConfigProvider.CC.$default$ndots(this);
    }

    protected void parseSearchPathList(String str, String str2) {
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
            while (stringTokenizer.hasMoreTokens()) {
                addSearchPath(stringTokenizer.nextToken());
            }
        }
    }

    protected void addSearchPath(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            Name nameFromString = Name.fromString(str, Name.root);
            if (this.searchlist.contains(nameFromString)) {
                return;
            }
            this.searchlist.add(nameFromString);
            this.log.debug("Added {} to search paths", nameFromString);
        } catch (TextParseException unused) {
            this.log.warn("Could not parse search path {} as a dns name, ignoring", str);
        }
    }

    protected void addNameserver(InetSocketAddress inetSocketAddress) {
        if (this.nameservers.contains(inetSocketAddress)) {
            return;
        }
        this.nameservers.add(inetSocketAddress);
        this.log.debug("Added {} to nameservers", inetSocketAddress);
    }

    protected int parseNdots(String str) {
        if (str == null || str.isEmpty()) {
            return 1;
        }
        try {
            int i = Integer.parseInt(str);
            if (i < 0) {
                return 1;
            }
            if (i > 15) {
                return 15;
            }
            return i;
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public final List<InetSocketAddress> servers() {
        if (ipv6first) {
            return (List) Collection.EL.stream(this.nameservers).sorted(new Comparator() { // from class: org.xbill.DNS.config.BaseResolverConfigProvider$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Integer.compare(((InetSocketAddress) obj2).getAddress().getAddress().length, ((InetSocketAddress) obj).getAddress().getAddress().length);
                }
            }).collect(Collectors.toList());
        }
        if (ipv4only) {
            return (List) Collection.EL.stream(this.nameservers).filter(new Predicate() { // from class: org.xbill.DNS.config.BaseResolverConfigProvider$$ExternalSyntheticLambda1
                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate.CC.$default$and(this, predicate);
                }

                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate.CC.$default$negate(this);
                }

                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate.CC.$default$or(this, predicate);
                }

                @Override // j$.util.function.Predicate
                public final boolean test(Object obj) {
                    return BaseResolverConfigProvider.lambda$servers$1((InetSocketAddress) obj);
                }
            }).collect(Collectors.toList());
        }
        return Collections.unmodifiableList(this.nameservers);
    }

    static /* synthetic */ boolean lambda$servers$1(InetSocketAddress inetSocketAddress) {
        return inetSocketAddress.getAddress() instanceof Inet4Address;
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public final List<Name> searchPaths() {
        return Collections.unmodifiableList(this.searchlist);
    }
}

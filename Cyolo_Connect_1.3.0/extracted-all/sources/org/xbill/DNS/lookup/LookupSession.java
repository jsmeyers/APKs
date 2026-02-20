package org.xbill.DNS.lookup;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Optional;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import okio.NioSystemFileSystem$$ExternalSyntheticApiModelOutline0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.AAAARecord;
import org.xbill.DNS.ARecord;
import org.xbill.DNS.CNAMERecord;
import org.xbill.DNS.Cache;
import org.xbill.DNS.DNAMERecord;
import org.xbill.DNS.ExtendedResolver;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.NameTooLongException;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Rcode;
import org.xbill.DNS.Record;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.Resolver$$ExternalSyntheticApiModelOutline1;
import org.xbill.DNS.ResolverConfig;
import org.xbill.DNS.SetResponse;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.hosts.HostsFileParser;
import org.xbill.DNS.hosts.HostsFileParser$$ExternalSyntheticBackport1;
import org.xbill.DNS.lookup.LookupSession;

/* JADX INFO: loaded from: classes2.dex */
public class LookupSession {
    public static final int DEFAULT_MAX_ITERATIONS = 16;
    public static final int DEFAULT_NDOTS = 1;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) LookupSession.class);
    private final Map<Integer, Cache> caches;
    private final boolean cycleResults;
    private final Executor executor;
    private final HostsFileParser hostsFileParser;
    private final int maxRedirects;
    private final int ndots;
    private final Resolver resolver;
    private final List<Name> searchPath;

    static /* synthetic */ Cache lambda$new$0(Cache cache) {
        return cache;
    }

    private LookupSession(Resolver resolver, int i, int i2, List<Name> list, boolean z, List<Cache> list2, HostsFileParser hostsFileParser, Executor executor) {
        Map<Integer, Cache> mapEmptyMap;
        if (resolver == null) {
            throw new NullPointerException("resolver is marked non-null but is null");
        }
        this.resolver = resolver;
        this.maxRedirects = i;
        this.ndots = i2;
        this.searchPath = list;
        this.cycleResults = z;
        if (list2 == null) {
            mapEmptyMap = Collections.emptyMap();
        } else {
            mapEmptyMap = (Map) Collection.EL.stream(list2).collect(Collectors.toMap(new Function() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda3
                @Override // j$.util.function.Function
                public /* synthetic */ Function andThen(Function function) {
                    return Function.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((Cache) obj).getDClass());
                }

                @Override // j$.util.function.Function
                public /* synthetic */ Function compose(Function function) {
                    return Function.CC.$default$compose(this, function);
                }
            }, new Function() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda4
                @Override // j$.util.function.Function
                public /* synthetic */ Function andThen(Function function) {
                    return Function.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return LookupSession.lambda$new$0((Cache) obj);
                }

                @Override // j$.util.function.Function
                public /* synthetic */ Function compose(Function function) {
                    return Function.CC.$default$compose(this, function);
                }
            }));
        }
        this.caches = mapEmptyMap;
        this.hostsFileParser = hostsFileParser;
        this.executor = executor == null ? ForkJoinPool.commonPool() : executor;
    }

    public static class LookupSessionBuilder {
        private List<Cache> caches;
        private boolean cycleResults;
        private Executor executor;
        private HostsFileParser hostsFileParser;
        private int maxRedirects;
        private int ndots;
        private Resolver resolver;
        private List<Name> searchPath;

        public String toString() {
            return "LookupSession.LookupSessionBuilder(resolver=" + this.resolver + ", maxRedirects=" + this.maxRedirects + ", ndots=" + this.ndots + ", searchPath=" + this.searchPath + ", cycleResults=" + this.cycleResults + ", caches=" + this.caches + ", hostsFileParser=" + this.hostsFileParser + ", executor=" + this.executor + ")";
        }

        private LookupSessionBuilder() {
        }

        public LookupSessionBuilder resolver(Resolver resolver) {
            if (resolver == null) {
                throw new NullPointerException("resolver is marked non-null but is null");
            }
            this.resolver = resolver;
            return this;
        }

        public LookupSessionBuilder maxRedirects(int i) {
            this.maxRedirects = i;
            return this;
        }

        public LookupSessionBuilder ndots(int i) {
            this.ndots = i;
            return this;
        }

        public LookupSessionBuilder searchPath(Name name) {
            if (this.searchPath == null) {
                this.searchPath = new ArrayList();
            }
            this.searchPath.add(name);
            return this;
        }

        public LookupSessionBuilder searchPath(java.util.Collection<? extends Name> collection) {
            if (this.searchPath == null) {
                this.searchPath = new ArrayList();
            }
            this.searchPath.addAll(collection);
            return this;
        }

        public LookupSessionBuilder clearSearchPath() {
            List<Name> list = this.searchPath;
            if (list != null) {
                list.clear();
            }
            return this;
        }

        public LookupSessionBuilder cycleResults(boolean z) {
            this.cycleResults = z;
            return this;
        }

        public LookupSessionBuilder hostsFileParser(HostsFileParser hostsFileParser) {
            this.hostsFileParser = hostsFileParser;
            return this;
        }

        public LookupSessionBuilder executor(Executor executor) {
            this.executor = executor;
            return this;
        }

        public LookupSessionBuilder defaultHostsFileParser() {
            this.hostsFileParser = new HostsFileParser();
            return this;
        }

        public LookupSessionBuilder cache(Cache cache) {
            if (cache == null) {
                throw new NullPointerException("cache is marked non-null but is null");
            }
            if (this.caches == null) {
                this.caches = new ArrayList(1);
            }
            for (Cache cache2 : this.caches) {
                if (cache2.getDClass() == cache.getDClass()) {
                    this.caches.remove(cache2);
                    break;
                }
            }
            this.caches.add(cache);
            return this;
        }

        public LookupSessionBuilder caches(java.util.Collection<Cache> collection) {
            if (collection == null) {
                throw new NullPointerException("caches is marked non-null but is null");
            }
            Iterable.EL.forEach(collection, new Consumer() { // from class: org.xbill.DNS.lookup.LookupSession$LookupSessionBuilder$$ExternalSyntheticLambda1
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.cache((Cache) obj);
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.$default$andThen(this, consumer);
                }
            });
            return this;
        }

        public LookupSessionBuilder clearCaches() {
            List<Cache> list = this.caches;
            if (list != null) {
                list.clear();
            }
            return this;
        }

        @Deprecated
        public LookupSessionBuilder cache(Integer num, Cache cache) {
            if (num == null) {
                throw new NullPointerException("dclass is marked non-null but is null");
            }
            if (cache == null) {
                throw new NullPointerException("cache is marked non-null but is null");
            }
            cache(cache);
            return this;
        }

        @Deprecated
        public LookupSessionBuilder caches(Map<Integer, Cache> map) {
            if (map == null) {
                throw new NullPointerException("caches is marked non-null but is null");
            }
            return caches(map.values());
        }

        public LookupSession build() {
            List<Name> list = this.searchPath;
            if (list != null) {
                this.searchPath = (List) Collection.EL.stream(list).map(new Function() { // from class: org.xbill.DNS.lookup.LookupSession$LookupSessionBuilder$$ExternalSyntheticLambda0
                    @Override // j$.util.function.Function
                    public /* synthetic */ Function andThen(Function function) {
                        return Function.CC.$default$andThen(this, function);
                    }

                    @Override // j$.util.function.Function
                    public final Object apply(Object obj) {
                        return LookupSession.LookupSessionBuilder.lambda$build$0((Name) obj);
                    }

                    @Override // j$.util.function.Function
                    public /* synthetic */ Function compose(Function function) {
                        return Function.CC.$default$compose(this, function);
                    }
                }).collect(Collectors.toCollection(new LookupSession$$ExternalSyntheticLambda13()));
            } else {
                this.searchPath = Collections.emptyList();
            }
            return new LookupSession(this.resolver, this.maxRedirects, this.ndots, this.searchPath, this.cycleResults, this.caches, this.hostsFileParser, this.executor);
        }

        static /* synthetic */ Name lambda$build$0(Name name) {
            try {
                return Name.concatenate(name, Name.root);
            } catch (NameTooLongException unused) {
                throw new IllegalArgumentException("Search path name too long");
            }
        }
    }

    public static LookupSessionBuilder builder() {
        LookupSessionBuilder lookupSessionBuilder = new LookupSessionBuilder();
        lookupSessionBuilder.maxRedirects = 16;
        lookupSessionBuilder.ndots = 1;
        return lookupSessionBuilder;
    }

    public static LookupSessionBuilder defaultBuilder() {
        return builder().resolver(new ExtendedResolver((Iterable<Resolver>) Collection.EL.stream(ResolverConfig.getCurrentConfig().servers()).map(new Function() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda17
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return new SimpleResolver((InetSocketAddress) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        }).collect(Collectors.toList()))).ndots(ResolverConfig.getCurrentConfig().ndots()).cache(new Cache(1)).defaultHostsFileParser();
    }

    public CompletionStage<LookupResult> lookupAsync(Name name, int i) {
        return lookupAsync(name, i, 1);
    }

    public CompletionStage<LookupResult> lookupAsync(Name name, int i, int i2) {
        List<Name> listExpandName = expandName(name);
        LookupResult lookupResultLookupWithHosts = lookupWithHosts(listExpandName, i);
        if (lookupResultLookupWithHosts != null) {
            return CompletableFuture.completedFuture(lookupResultLookupWithHosts);
        }
        return lookupUntilSuccess(listExpandName.iterator(), i, i2);
    }

    List<Name> expandName(final Name name) {
        if (name.isAbsolute()) {
            return Collections.singletonList(name);
        }
        List<Name> list = (List) Collection.EL.stream(this.searchPath).map(new Function() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda11
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return LookupSession.safeConcat(name, (Name) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        }).filter(new Predicate() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda12
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
                return HostsFileParser$$ExternalSyntheticBackport1.m((Name) obj);
            }
        }).collect(Collectors.toCollection(new LookupSession$$ExternalSyntheticLambda13()));
        if (name.labels() > this.ndots) {
            list.add(0, safeConcat(name, Name.root));
        } else {
            list.add(safeConcat(name, Name.root));
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Name safeConcat(Name name, Name name2) {
        try {
            return Name.concatenate(name, name2);
        } catch (NameTooLongException unused) {
            return null;
        }
    }

    private LookupResult lookupWithHosts(List<Name> list, int i) {
        Object aAAARecord;
        if (this.hostsFileParser == null) {
            return null;
        }
        if (i != 1 && i != 28) {
            return null;
        }
        try {
            for (Name name : list) {
                Optional<InetAddress> addressForHost = this.hostsFileParser.getAddressForHost(name, i);
                if (addressForHost.isPresent()) {
                    if (i == 1) {
                        aAAARecord = new ARecord(name, 1, 0L, addressForHost.get());
                    } else {
                        aAAARecord = new AAAARecord(name, 1, 0L, addressForHost.get());
                    }
                    return new LookupResult(Collections.singletonList(aAAARecord), Collections.emptyList());
                }
            }
            return null;
        } catch (IOException e) {
            log.debug("Local hosts database parsing failed, ignoring and using resolver", (Throwable) e);
            return null;
        }
    }

    private CompletionStage<LookupResult> lookupUntilSuccess(final Iterator<Name> it, final int i, final int i2) {
        final Record recordNewRecord = Record.newRecord(it.next(), i, i2);
        return lookupWithCache(recordNewRecord, null).thenCompose(Function.Wrapper.convert(new Function() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda15
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m2266lambda$lookupUntilSuccess$2$orgxbillDNSlookupLookupSession(recordNewRecord, (LookupResult) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        })).handle(BiFunction.Wrapper.convert(new BiFunction() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda16
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.f$0.m2267lambda$lookupUntilSuccess$3$orgxbillDNSlookupLookupSession(it, i, i2, (LookupResult) obj, (Throwable) obj2);
            }
        })).thenCompose(Function.Wrapper.convert(Function.CC.identity()));
    }

    /* JADX INFO: renamed from: lambda$lookupUntilSuccess$3$org-xbill-DNS-lookup-LookupSession, reason: not valid java name */
    /* synthetic */ CompletionStage m2267lambda$lookupUntilSuccess$3$orgxbillDNSlookupLookupSession(Iterator it, int i, int i2, LookupResult lookupResult, Throwable th) {
        Throwable cause = th == null ? null : th.getCause();
        return ((cause instanceof NoSuchDomainException) || (cause instanceof NoSuchRRSetException)) ? it.hasNext() ? lookupUntilSuccess(it, i, i2) : completeExceptionally(cause) : cause != null ? completeExceptionally(cause) : CompletableFuture.completedFuture(lookupResult);
    }

    private CompletionStage<LookupResult> lookupWithCache(final Record record, final List<Name> list) {
        return Resolver$$ExternalSyntheticApiModelOutline1.m2261m(Optional.ofNullable(this.caches.get(Integer.valueOf(record.getDClass()))).map(new Function() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda8
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                Record record2 = record;
                return ((Cache) obj).lookupRecords(record2.getName(), record2.getType(), 3);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        }).map(new Function() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda9
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m2268lambda$lookupWithCache$5$orgxbillDNSlookupLookupSession(record, list, (SetResponse) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        }).orElseGet(new Supplier() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda10
            @Override // j$.util.function.Supplier
            public final Object get() {
                return this.f$0.m2269lambda$lookupWithCache$6$orgxbillDNSlookupLookupSession(record, list);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lookupWithResolver, reason: merged with bridge method [inline-methods] */
    public CompletionStage<LookupResult> m2269lambda$lookupWithCache$6$orgxbillDNSlookupLookupSession(final Record record, final List<Name> list) {
        return this.resolver.sendAsync(Message.newQuery(record), this.executor).thenApply(Function.Wrapper.convert(new Function() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda6
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.maybeAddToCache((Message) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        })).thenApply(Function.Wrapper.convert(new Function() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda7
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return LookupSession.buildResult((Message) obj, list, record);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message maybeAddToCache(final Message message) {
        for (RRset rRset : message.getSectionRRsets(1)) {
            if (rRset.getType() == 5 || rRset.getType() == 39) {
                if (rRset.size() != 1) {
                    throw new InvalidZoneDataException("Multiple CNAME RRs not allowed, see RFC1034 3.6.2");
                }
            }
        }
        Optional.ofNullable(this.caches.get(Integer.valueOf(message.getQuestion().getDClass()))).ifPresent(new Consumer() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda14
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                ((Cache) obj).addMessage(message);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        });
        return message;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setResponseToMessageFuture, reason: merged with bridge method [inline-methods] */
    public CompletionStage<LookupResult> m2268lambda$lookupWithCache$5$orgxbillDNSlookupLookupSession(SetResponse setResponse, Record record, List<Name> list) {
        if (setResponse.isNXDOMAIN()) {
            return completeExceptionally(new NoSuchDomainException(record.getName(), record.getType()));
        }
        if (setResponse.isNXRRSET()) {
            return completeExceptionally(new NoSuchRRSetException(record.getName(), record.getType()));
        }
        if (setResponse.isSuccessful()) {
            return CompletableFuture.completedFuture(new LookupResult((List) Collection.EL.stream(setResponse.answers()).flatMap(new Function() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda5
                @Override // j$.util.function.Function
                public /* synthetic */ Function andThen(Function function) {
                    return Function.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m2271x245078ca((RRset) obj);
                }

                @Override // j$.util.function.Function
                public /* synthetic */ Function compose(Function function) {
                    return Function.CC.$default$compose(this, function);
                }
            }).collect(Collectors.toList()), list));
        }
        return null;
    }

    /* JADX INFO: renamed from: lambda$setResponseToMessageFuture$9$org-xbill-DNS-lookup-LookupSession, reason: not valid java name */
    /* synthetic */ Stream m2271x245078ca(RRset rRset) {
        return Collection.EL.stream(rRset.rrs(this.cycleResults));
    }

    private <T extends Throwable> CompletionStage<LookupResult> completeExceptionally(T t) {
        CompletableFuture completableFutureM2226m = NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m2226m();
        completableFutureM2226m.completeExceptionally(t);
        return completableFutureM2226m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: resolveRedirects, reason: merged with bridge method [inline-methods] */
    public CompletionStage<LookupResult> m2266lambda$lookupUntilSuccess$2$orgxbillDNSlookupLookupSession(LookupResult lookupResult, Record record) {
        return m2270xfc7285e3(lookupResult, record, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: maybeFollowRedirect, reason: merged with bridge method [inline-methods] */
    public CompletionStage<LookupResult> m2270xfc7285e3(LookupResult lookupResult, Record record, int i) {
        if (i > this.maxRedirects) {
            throw new RedirectOverflowException(this.maxRedirects);
        }
        List<Record> records = lookupResult.getRecords();
        if (!records.isEmpty() && (records.get(0).getType() == 5 || records.get(0).getType() == 39)) {
            return maybeFollowRedirectsInAnswer(lookupResult, record, i);
        }
        return CompletableFuture.completedFuture(lookupResult);
    }

    private CompletionStage<LookupResult> maybeFollowRedirectsInAnswer(LookupResult lookupResult, Record record, int i) {
        ArrayList arrayList = new ArrayList(lookupResult.getAliases());
        ArrayList arrayList2 = new ArrayList();
        Name name = record.getName();
        for (Record record2 : lookupResult.getRecords()) {
            if (i > this.maxRedirects) {
                throw new RedirectOverflowException(this.maxRedirects);
            }
            if (record2.getDClass() == record.getDClass()) {
                if (record2.getType() == 5 && name.equals(record2.getName())) {
                    arrayList.add(name);
                    i++;
                    name = ((CNAMERecord) record2).getTarget();
                } else if (record2.getType() == 39 && name.subdomain(record2.getName())) {
                    arrayList.add(name);
                    i++;
                    try {
                        name = name.fromDNAME((DNAMERecord) record2);
                    } catch (NameTooLongException e) {
                        throw new InvalidZoneDataException("Cannot derive DNAME from " + record2 + " for " + name, e);
                    }
                } else if (record2.getType() == record.getType() && name.equals(record2.getName())) {
                    arrayList2.add(record2);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            return CompletableFuture.completedFuture(new LookupResult(arrayList2, arrayList));
        }
        if (i > this.maxRedirects) {
            throw new RedirectOverflowException(this.maxRedirects);
        }
        final int i2 = i + 1;
        final Record recordNewRecord = Record.newRecord(name, record.getType(), record.getDClass());
        return lookupWithCache(recordNewRecord, arrayList).thenCompose(Function.Wrapper.convert(new Function() { // from class: org.xbill.DNS.lookup.LookupSession$$ExternalSyntheticLambda2
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m2270xfc7285e3(recordNewRecord, i2, (LookupResult) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LookupResult buildResult(Message message, List<Name> list, Record record) {
        int rcode = message.getRcode();
        List<Record> section = message.getSection(1);
        if (!section.isEmpty() || rcode == 0) {
            return new LookupResult(section, list);
        }
        if (rcode == 2) {
            throw new ServerFailedException();
        }
        if (rcode == 3) {
            throw new NoSuchDomainException(record.getName(), record.getType());
        }
        if (rcode == 8) {
            throw new NoSuchRRSetException(record.getName(), record.getType());
        }
        throw new LookupFailedException(String.format("Unknown non-success error code %s", Rcode.string(rcode)));
    }
}

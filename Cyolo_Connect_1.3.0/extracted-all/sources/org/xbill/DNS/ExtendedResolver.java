package org.xbill.DNS;

import j$.time.Duration;
import j$.util.Collection;
import j$.util.Comparator;
import j$.util.concurrent.atomic.DesugarAtomicInteger;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.IntUnaryOperator;
import j$.util.function.Predicate;
import j$.util.function.ToIntFunction;
import j$.util.stream.Collectors;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import okio.NioSystemFileSystem$$ExternalSyntheticApiModelOutline0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.ExtendedResolver;
import org.xbill.DNS.Resolver;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendedResolver implements Resolver {
    private final AtomicInteger lbStart;
    private boolean loadBalance;
    private final List<ResolverEntry> resolvers;
    private int retries;
    private Duration timeout;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) ExtendedResolver.class);
    public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    public static final Duration DEFAULT_RESOLVER_TIMEOUT = Duration.ofSeconds(5);

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ Message send(Message message) {
        return Resolver.CC.$default$send(this, message);
    }

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ Object sendAsync(Message message, ResolverListener resolverListener) {
        return Resolver.CC.$default$sendAsync(this, message, resolverListener);
    }

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ void setEDNS(int i) {
        setEDNS(i, 0, 0, Collections.emptyList());
    }

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ void setEDNS(int i, int i2, int i3, EDNSOption... eDNSOptionArr) {
        setEDNS(i, i2, i3, eDNSOptionArr == null ? Collections.emptyList() : Arrays.asList(eDNSOptionArr));
    }

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ void setTimeout(int i) {
        setTimeout(Duration.ofSeconds(i));
    }

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ void setTimeout(int i, int i2) {
        setTimeout(Duration.ofMillis((((long) i) * 1000) + ((long) i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Resolution {
        private final int[] attempts;
        private int currentResolver;
        private final long endTime;
        private final Message query;
        private List<ResolverEntry> resolvers;
        private final int retriesPerResolver;

        Resolution(ExtendedResolver extendedResolver, Message message) {
            this.resolvers = new ArrayList(extendedResolver.resolvers);
            this.endTime = System.nanoTime() + extendedResolver.timeout.toNanos();
            if (extendedResolver.loadBalance) {
                int iUpdateAndGet = DesugarAtomicInteger.updateAndGet(extendedResolver.lbStart, new IntUnaryOperator() { // from class: org.xbill.DNS.ExtendedResolver$Resolution$$ExternalSyntheticLambda3
                    @Override // j$.util.function.IntUnaryOperator
                    public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
                        return IntUnaryOperator.CC.$default$andThen(this, intUnaryOperator);
                    }

                    @Override // j$.util.function.IntUnaryOperator
                    public final int applyAsInt(int i) {
                        return this.f$0.m2253lambda$new$0$orgxbillDNSExtendedResolver$Resolution(i);
                    }

                    @Override // j$.util.function.IntUnaryOperator
                    public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
                        return IntUnaryOperator.CC.$default$compose(this, intUnaryOperator);
                    }
                });
                if (iUpdateAndGet > 0) {
                    ArrayList arrayList = new ArrayList(this.resolvers.size());
                    for (int i = 0; i < this.resolvers.size(); i++) {
                        arrayList.add(this.resolvers.get((i + iUpdateAndGet) % this.resolvers.size()));
                    }
                    this.resolvers = arrayList;
                }
            } else {
                this.resolvers = (List) Collection.EL.stream(this.resolvers).sorted(Comparator.CC.comparingInt(new ToIntFunction() { // from class: org.xbill.DNS.ExtendedResolver$Resolution$$ExternalSyntheticLambda4
                    @Override // j$.util.function.ToIntFunction
                    public final int applyAsInt(Object obj) {
                        return ((ExtendedResolver.ResolverEntry) obj).failures.get();
                    }
                })).collect(Collectors.toList());
            }
            this.attempts = new int[this.resolvers.size()];
            this.retriesPerResolver = extendedResolver.retries;
            this.query = message;
        }

        /* JADX INFO: renamed from: lambda$new$0$org-xbill-DNS-ExtendedResolver$Resolution, reason: not valid java name */
        /* synthetic */ int m2253lambda$new$0$orgxbillDNSExtendedResolver$Resolution(int i) {
            return (i + 1) % this.resolvers.size();
        }

        private CompletionStage<Message> send(Executor executor) {
            ResolverEntry resolverEntry = this.resolvers.get(this.currentResolver);
            ExtendedResolver.log.debug("Sending {}/{}, id={} to resolver {} ({}), attempt {} of {}", this.query.getQuestion().getName(), Type.string(this.query.getQuestion().getType()), Integer.valueOf(this.query.getHeader().getID()), Integer.valueOf(this.currentResolver), resolverEntry.resolver, Integer.valueOf(this.attempts[this.currentResolver] + 1), Integer.valueOf(this.retriesPerResolver));
            int[] iArr = this.attempts;
            int i = this.currentResolver;
            iArr[i] = iArr[i] + 1;
            return resolverEntry.resolver.sendAsync(this.query, executor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CompletionStage<Message> startAsync(final Executor executor) {
            return send(executor).handle(BiFunction.Wrapper.convert(new BiFunction() { // from class: org.xbill.DNS.ExtendedResolver$Resolution$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiFunction
                public /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return this.f$0.m2254lambda$startAsync$2$orgxbillDNSExtendedResolver$Resolution(executor, (Message) obj, (Throwable) obj2);
                }
            })).thenCompose(Function.Wrapper.convert(Function.CC.identity()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: handle, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public CompletionStage<Message> m2254lambda$startAsync$2$orgxbillDNSExtendedResolver$Resolution(Message message, Throwable th, final Executor executor) {
            AtomicInteger atomicInteger = this.resolvers.get(this.currentResolver).failures;
            if (th != null) {
                ExtendedResolver.log.debug("Failed to resolve {}/{}, id={} with resolver {} ({}) on attempt {} of {}, reason={}", this.query.getQuestion().getName(), Type.string(this.query.getQuestion().getType()), Integer.valueOf(this.query.getHeader().getID()), Integer.valueOf(this.currentResolver), this.resolvers.get(this.currentResolver).resolver, Integer.valueOf(this.attempts[this.currentResolver]), Integer.valueOf(this.retriesPerResolver), th.getMessage());
                atomicInteger.incrementAndGet();
                if (this.endTime - System.nanoTime() < 0) {
                    CompletableFuture completableFutureM2226m = NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m2226m();
                    completableFutureM2226m.completeExceptionally(new IOException("Timed out while trying to resolve " + this.query.getQuestion().getName() + "/" + Type.string(this.query.getQuestion().type) + ", id=" + this.query.getHeader().getID()));
                    return completableFutureM2226m;
                }
                int size = (this.currentResolver + 1) % this.resolvers.size();
                this.currentResolver = size;
                if (this.attempts[size] < this.retriesPerResolver) {
                    return send(executor).handle(BiFunction.Wrapper.convert(new BiFunction() { // from class: org.xbill.DNS.ExtendedResolver$Resolution$$ExternalSyntheticLambda1
                        @Override // j$.util.function.BiFunction
                        public /* synthetic */ BiFunction andThen(Function function) {
                            return BiFunction.CC.$default$andThen(this, function);
                        }

                        @Override // j$.util.function.BiFunction
                        public final Object apply(Object obj, Object obj2) {
                            return this.f$0.m2252lambda$handle$3$orgxbillDNSExtendedResolver$Resolution(executor, (Message) obj, (Throwable) obj2);
                        }
                    })).thenCompose(Function.Wrapper.convert(Function.CC.identity()));
                }
                CompletableFuture completableFutureM2226m2 = NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m2226m();
                completableFutureM2226m2.completeExceptionally(th);
                return completableFutureM2226m2;
            }
            DesugarAtomicInteger.updateAndGet(atomicInteger, new IntUnaryOperator() { // from class: org.xbill.DNS.ExtendedResolver$Resolution$$ExternalSyntheticLambda2
                @Override // j$.util.function.IntUnaryOperator
                public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
                    return IntUnaryOperator.CC.$default$andThen(this, intUnaryOperator);
                }

                @Override // j$.util.function.IntUnaryOperator
                public final int applyAsInt(int i) {
                    return ExtendedResolver.Resolution.lambda$handle$4(i);
                }

                @Override // j$.util.function.IntUnaryOperator
                public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
                    return IntUnaryOperator.CC.$default$compose(this, intUnaryOperator);
                }
            });
            return CompletableFuture.completedFuture(message);
        }

        static /* synthetic */ int lambda$handle$4(int i) {
            if (i > 0) {
                return (int) Math.log(i);
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ResolverEntry {
        private final AtomicInteger failures;
        private final Resolver resolver;

        public ResolverEntry(Resolver resolver, AtomicInteger atomicInteger) {
            this.resolver = resolver;
            this.failures = atomicInteger;
        }

        ResolverEntry(Resolver resolver) {
            this(resolver, new AtomicInteger(0));
        }

        public String toString() {
            return this.resolver.toString();
        }
    }

    public ExtendedResolver() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.resolvers = copyOnWriteArrayList;
        this.lbStart = new AtomicInteger();
        this.retries = 3;
        this.timeout = DEFAULT_TIMEOUT;
        copyOnWriteArrayList.addAll((java.util.Collection) Collection.EL.stream(ResolverConfig.getCurrentConfig().servers()).map(new Function() { // from class: org.xbill.DNS.ExtendedResolver$$ExternalSyntheticLambda3
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return ExtendedResolver.lambda$new$0((InetSocketAddress) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        }).collect(Collectors.toList()));
    }

    static /* synthetic */ ResolverEntry lambda$new$0(InetSocketAddress inetSocketAddress) {
        SimpleResolver simpleResolver = new SimpleResolver(inetSocketAddress);
        simpleResolver.setTimeout(DEFAULT_RESOLVER_TIMEOUT);
        return new ResolverEntry(simpleResolver);
    }

    public ExtendedResolver(String[] strArr) throws UnknownHostException {
        this.resolvers = new CopyOnWriteArrayList();
        this.lbStart = new AtomicInteger();
        this.retries = 3;
        this.timeout = DEFAULT_TIMEOUT;
        for (String str : strArr) {
            SimpleResolver simpleResolver = new SimpleResolver(str);
            simpleResolver.setTimeout(DEFAULT_RESOLVER_TIMEOUT);
            this.resolvers.add(new ResolverEntry(simpleResolver));
        }
    }

    public ExtendedResolver(Resolver[] resolverArr) {
        this(Arrays.asList(resolverArr));
    }

    public ExtendedResolver(Iterable<Resolver> iterable) {
        this.resolvers = new CopyOnWriteArrayList();
        this.lbStart = new AtomicInteger();
        this.retries = 3;
        this.timeout = DEFAULT_TIMEOUT;
        Iterator<Resolver> it = iterable.iterator();
        while (it.hasNext()) {
            this.resolvers.add(new ResolverEntry(it.next()));
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setPort(int i) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setPort(i);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setTCP(boolean z) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setTCP(z);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setIgnoreTruncation(boolean z) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setIgnoreTruncation(z);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setEDNS(int i, int i2, int i3, List<EDNSOption> list) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setEDNS(i, i2, i3, list);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setTSIGKey(TSIG tsig) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setTSIGKey(tsig);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public Duration getTimeout() {
        return this.timeout;
    }

    @Override // org.xbill.DNS.Resolver
    public void setTimeout(Duration duration) {
        this.timeout = duration;
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message) {
        return sendAsync(message, ForkJoinPool.commonPool());
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message, Executor executor) {
        return new Resolution(this, message).startAsync(executor);
    }

    public Resolver getResolver(int i) {
        if (i < this.resolvers.size()) {
            return this.resolvers.get(i).resolver;
        }
        return null;
    }

    static /* synthetic */ Resolver[] lambda$getResolvers$2(int i) {
        return new Resolver[i];
    }

    public Resolver[] getResolvers() {
        return (Resolver[]) Collection.EL.stream(this.resolvers).map(new Function() { // from class: org.xbill.DNS.ExtendedResolver$$ExternalSyntheticLambda1
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return ((ExtendedResolver.ResolverEntry) obj).resolver;
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        }).toArray(new IntFunction() { // from class: org.xbill.DNS.ExtendedResolver$$ExternalSyntheticLambda2
            @Override // j$.util.function.IntFunction
            public final Object apply(int i) {
                return ExtendedResolver.lambda$getResolvers$2(i);
            }
        });
    }

    public void addResolver(Resolver resolver) {
        this.resolvers.add(new ResolverEntry(resolver));
    }

    static /* synthetic */ boolean lambda$deleteResolver$3(Resolver resolver, ResolverEntry resolverEntry) {
        return resolverEntry.resolver == resolver;
    }

    public void deleteResolver(final Resolver resolver) {
        Collection.EL.removeIf(this.resolvers, new Predicate() { // from class: org.xbill.DNS.ExtendedResolver$$ExternalSyntheticLambda0
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
                return ExtendedResolver.lambda$deleteResolver$3(resolver, (ExtendedResolver.ResolverEntry) obj);
            }
        });
    }

    public boolean getLoadBalance() {
        return this.loadBalance;
    }

    public void setLoadBalance(boolean z) {
        this.loadBalance = z;
    }

    public int getRetries() {
        return this.retries;
    }

    public void setRetries(int i) {
        this.retries = i;
    }

    public String toString() {
        return "ExtendedResolver of " + this.resolvers;
    }
}

package org.xbill.DNS;

import j$.util.Collection;
import j$.util.Optional;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.hosts.HostsFileParser;

/* JADX INFO: loaded from: classes2.dex */
public final class Lookup {
    public static final int HOST_NOT_FOUND = 3;
    public static final int SUCCESSFUL = 0;
    public static final int TRY_AGAIN = 2;
    public static final int TYPE_NOT_FOUND = 4;
    public static final int UNRECOVERABLE = 1;
    private static Map<Integer, Cache> defaultCaches;
    private static HostsFileParser defaultHostsFileParser;
    private static int defaultNdots;
    private static Resolver defaultResolver;
    private static List<Name> defaultSearchPath;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) Lookup.class);
    private static final Name[] noAliases = new Name[0];
    private List<Name> aliases;
    private Record[] answers;
    private boolean badresponse;
    private String badresponse_error;
    private Cache cache;
    private int credibility;
    private boolean cycleResults;
    private int dclass;
    private boolean done;
    private boolean doneCurrent;
    private String error;
    private boolean foundAlias;
    private HostsFileParser hostsFileParser;
    private int iterations;
    private int maxIterations;
    private Name name;
    private boolean nametoolong;
    private int ndots;
    private boolean networkerror;
    private boolean nxdomain;
    private boolean referral;
    private Resolver resolver;
    private int result;
    private List<Name> searchPath;
    private boolean temporary_cache;
    private boolean timedout;
    private int type;

    static {
        refreshDefault();
    }

    public HostsFileParser getHostsFileParser() {
        return this.hostsFileParser;
    }

    public void setHostsFileParser(HostsFileParser hostsFileParser) {
        this.hostsFileParser = hostsFileParser;
    }

    public static synchronized void refreshDefault() {
        defaultResolver = new ExtendedResolver();
        defaultSearchPath = ResolverConfig.getCurrentConfig().searchPath();
        defaultCaches = new HashMap();
        defaultNdots = ResolverConfig.getCurrentConfig().ndots();
        defaultHostsFileParser = new HostsFileParser();
    }

    public static synchronized Resolver getDefaultResolver() {
        return defaultResolver;
    }

    public static synchronized void setDefaultResolver(Resolver resolver) {
        defaultResolver = resolver;
    }

    public static synchronized Cache getDefaultCache(int i) {
        Cache cache;
        DClass.check(i);
        cache = defaultCaches.get(Integer.valueOf(i));
        if (cache == null) {
            cache = new Cache(i);
            defaultCaches.put(Integer.valueOf(i), cache);
        }
        return cache;
    }

    public static synchronized void setDefaultCache(Cache cache, int i) {
        DClass.check(i);
        defaultCaches.put(Integer.valueOf(i), cache);
    }

    public static synchronized List<Name> getDefaultSearchPath() {
        return defaultSearchPath;
    }

    public static synchronized void setDefaultSearchPath(List<Name> list) {
        defaultSearchPath = convertSearchPathDomainList(list);
    }

    public static synchronized void setDefaultSearchPath(Name... nameArr) {
        setDefaultSearchPath((List<Name>) Arrays.asList(nameArr));
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public static synchronized void setDefaultSearchPath(String... strArr) throws TextParseException {
        try {
            if (strArr == null) {
                defaultSearchPath = null;
                return;
            }
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(Name.fromString(str, Name.root));
            }
            defaultSearchPath = arrayList;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized HostsFileParser getDefaultHostsFileParser() {
        return defaultHostsFileParser;
    }

    public static synchronized void setDefaultHostsFileParser(HostsFileParser hostsFileParser) {
        defaultHostsFileParser = hostsFileParser;
    }

    private static List<Name> convertSearchPathDomainList(List<Name> list) {
        try {
            return (List) Collection.EL.stream(list).map(new Function() { // from class: org.xbill.DNS.Lookup$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                public /* synthetic */ Function andThen(Function function) {
                    return Function.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return Lookup.lambda$convertSearchPathDomainList$0((Name) obj);
                }

                @Override // j$.util.function.Function
                public /* synthetic */ Function compose(Function function) {
                    return Function.CC.$default$compose(this, function);
                }
            }).collect(Collectors.toList());
        } catch (RuntimeException e) {
            if (e.getCause() instanceof NameTooLongException) {
                throw new IllegalArgumentException(e.getCause());
            }
            throw e;
        }
    }

    static /* synthetic */ Name lambda$convertSearchPathDomainList$0(Name name) {
        try {
            return Name.concatenate(name, Name.root);
        } catch (NameTooLongException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void setPacketLogger(PacketLogger packetLogger) {
        NioClient.setPacketLogger(packetLogger);
    }

    private void reset() {
        this.iterations = 0;
        this.foundAlias = false;
        this.done = false;
        this.doneCurrent = false;
        this.aliases = null;
        this.answers = null;
        this.result = -1;
        this.error = null;
        this.nxdomain = false;
        this.badresponse = false;
        this.badresponse_error = null;
        this.networkerror = false;
        this.timedout = false;
        this.nametoolong = false;
        this.referral = false;
        if (this.temporary_cache) {
            this.cache.clearCache();
        }
    }

    public Lookup(Name name, int i, int i2) {
        this.cycleResults = true;
        Type.check(i);
        DClass.check(i2);
        if (!Type.isRR(i) && i != 255) {
            throw new IllegalArgumentException("Cannot query for meta-types other than ANY");
        }
        this.name = name;
        this.type = i;
        this.dclass = i2;
        synchronized (Lookup.class) {
            this.resolver = getDefaultResolver();
            this.searchPath = getDefaultSearchPath();
            this.cache = getDefaultCache(i2);
        }
        this.ndots = defaultNdots;
        this.credibility = 3;
        this.result = -1;
        this.maxIterations = Integer.parseInt(System.getProperty("dnsjava.lookup.max_iterations", "16"));
        if (Boolean.parseBoolean(System.getProperty("dnsjava.lookup.use_hosts_file", "true"))) {
            this.hostsFileParser = getDefaultHostsFileParser();
        }
    }

    public Lookup(Name name, int i) {
        this(name, i, 1);
    }

    public Lookup(Name name) {
        this(name, 1, 1);
    }

    public Lookup(String str, int i, int i2) throws TextParseException {
        this(Name.fromString(str), i, i2);
    }

    public Lookup(String str, int i) throws TextParseException {
        this(Name.fromString(str), i, 1);
    }

    public Lookup(String str) throws TextParseException {
        this(Name.fromString(str), 1, 1);
    }

    public void setResolver(Resolver resolver) {
        this.resolver = resolver;
    }

    public void setSearchPath(List<Name> list) {
        this.searchPath = convertSearchPathDomainList(list);
    }

    public void setSearchPath(Name... nameArr) {
        setSearchPath(Arrays.asList(nameArr));
    }

    public void setSearchPath(String... strArr) throws TextParseException {
        if (strArr == null) {
            this.searchPath = null;
            return;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(Name.fromString(str, Name.root));
        }
        this.searchPath = arrayList;
    }

    public void setCache(Cache cache) {
        if (cache == null) {
            this.cache = new Cache(this.dclass);
            this.temporary_cache = true;
        } else {
            this.cache = cache;
            this.temporary_cache = false;
        }
    }

    public static void setDefaultNdots(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Illegal ndots value: " + i);
        }
        defaultNdots = i;
    }

    public void setNdots(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Illegal ndots value: " + i);
        }
        this.ndots = i;
    }

    public void setCredibility(int i) {
        this.credibility = i;
    }

    public void setCycleResults(boolean z) {
        this.cycleResults = z;
    }

    private void follow(Name name, Name name2) {
        this.foundAlias = true;
        this.badresponse = false;
        this.networkerror = false;
        this.timedout = false;
        this.nxdomain = false;
        this.referral = false;
        int i = this.iterations + 1;
        this.iterations = i;
        if (i >= this.maxIterations || name.equals(name2)) {
            this.result = 1;
            this.error = "CNAME loop";
            this.done = true;
        } else {
            if (this.aliases == null) {
                this.aliases = new ArrayList();
            }
            this.aliases.add(name2);
            lookup(name);
        }
    }

    private void processResponse(Name name, SetResponse setResponse) {
        if (setResponse.isSuccessful()) {
            List<RRset> listAnswers = setResponse.answers();
            ArrayList arrayList = new ArrayList();
            Iterator<RRset> it = listAnswers.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().rrs(this.cycleResults));
            }
            this.result = 0;
            this.answers = (Record[]) arrayList.toArray(new Record[0]);
            this.done = true;
            return;
        }
        if (setResponse.isNXDOMAIN()) {
            this.nxdomain = true;
            this.doneCurrent = true;
            if (this.iterations > 0) {
                this.result = 3;
                this.done = true;
                return;
            }
            return;
        }
        if (setResponse.isNXRRSET()) {
            this.result = 4;
            this.answers = null;
            this.done = true;
        } else {
            if (setResponse.isCNAME()) {
                follow(setResponse.getCNAME().getTarget(), name);
                return;
            }
            if (setResponse.isDNAME()) {
                try {
                    follow(name.fromDNAME(setResponse.getDNAME()), name);
                    return;
                } catch (NameTooLongException unused) {
                    this.result = 1;
                    this.error = "Invalid DNAME target";
                    this.done = true;
                    return;
                }
            }
            if (setResponse.isDelegation()) {
                this.referral = true;
            }
        }
    }

    private void lookup(Name name) {
        if (lookupFromHostsFile(name)) {
            return;
        }
        SetResponse setResponseLookupRecords = this.cache.lookupRecords(name, this.type, this.credibility);
        Logger logger = log;
        logger.debug("Lookup for {}/{}, cache answer: {}", name, Type.string(this.type), setResponseLookupRecords);
        processResponse(name, setResponseLookupRecords);
        if (this.done || this.doneCurrent) {
            return;
        }
        Message messageNewQuery = Message.newQuery(Record.newRecord(name, this.type, this.dclass));
        try {
            Message messageSend = this.resolver.send(messageNewQuery);
            int rcode = messageSend.getHeader().getRcode();
            if (rcode != 0 && rcode != 3) {
                this.badresponse = true;
                this.badresponse_error = Rcode.string(rcode);
            } else {
                if (!messageNewQuery.getQuestion().equals(messageSend.getQuestion())) {
                    this.badresponse = true;
                    this.badresponse_error = "response does not match query";
                    return;
                }
                SetResponse setResponseAddMessage = this.cache.addMessage(messageSend);
                if (setResponseAddMessage == null) {
                    setResponseAddMessage = this.cache.lookupRecords(name, this.type, this.credibility);
                }
                logger.debug("Queried {}/{}, id={}: {}", name, Type.string(this.type), Integer.valueOf(messageSend.getHeader().getID()), setResponseAddMessage);
                processResponse(name, setResponseAddMessage);
            }
        } catch (IOException e) {
            log.debug("Lookup for {}/{}, id={} failed using resolver {}", name, Type.string(messageNewQuery.getQuestion().getType()), Integer.valueOf(messageNewQuery.getHeader().getID()), this.resolver, e);
            if (e instanceof InterruptedIOException) {
                this.timedout = true;
            } else {
                this.networkerror = true;
            }
        }
    }

    private boolean lookupFromHostsFile(Name name) {
        int i;
        HostsFileParser hostsFileParser = this.hostsFileParser;
        if (hostsFileParser != null && ((i = this.type) == 1 || i == 28)) {
            try {
                Optional<InetAddress> addressForHost = hostsFileParser.getAddressForHost(name, i);
                if (addressForHost.isPresent()) {
                    this.result = 0;
                    this.done = true;
                    if (this.type == 1) {
                        this.answers = new ARecord[]{new ARecord(name, this.dclass, 0L, addressForHost.get())};
                    } else {
                        this.answers = new AAAARecord[]{new AAAARecord(name, this.dclass, 0L, addressForHost.get())};
                    }
                    return true;
                }
            } catch (IOException e) {
                log.debug("Local hosts database parsing failed, ignoring and using resolver", (Throwable) e);
            }
        }
        return false;
    }

    private void resolve(Name name, Name name2) {
        this.doneCurrent = false;
        if (name2 != null) {
            try {
                name = Name.concatenate(name, name2);
            } catch (NameTooLongException unused) {
                this.nametoolong = true;
                return;
            }
        }
        lookup(name);
    }

    public Record[] run() {
        if (this.done) {
            reset();
        }
        if (this.name.isAbsolute()) {
            resolve(this.name, null);
        } else if (this.searchPath == null) {
            resolve(this.name, Name.root);
        } else {
            if (this.name.labels() > this.ndots) {
                resolve(this.name, Name.root);
            }
            if (this.done) {
                return this.answers;
            }
            Iterator<Name> it = this.searchPath.iterator();
            while (it.hasNext()) {
                resolve(this.name, it.next());
                if (this.done) {
                    return this.answers;
                }
                if (this.foundAlias) {
                    break;
                }
            }
            resolve(this.name, Name.root);
        }
        if (!this.done) {
            if (this.badresponse) {
                this.result = 2;
                this.error = this.badresponse_error;
                this.done = true;
            } else if (this.timedout) {
                this.result = 2;
                this.error = "timed out";
                this.done = true;
            } else if (this.networkerror) {
                this.result = 2;
                this.error = "network error";
                this.done = true;
            } else if (this.nxdomain) {
                this.result = 3;
                this.done = true;
            } else if (this.referral) {
                this.result = 1;
                this.error = "referral";
                this.done = true;
            } else if (this.nametoolong) {
                this.result = 1;
                this.error = "name too long";
                this.done = true;
            }
        }
        return this.answers;
    }

    private void checkDone() {
        if (!this.done || this.result == -1) {
            StringBuilder sb = new StringBuilder("Lookup of " + this.name + " ");
            int i = this.dclass;
            if (i != 1) {
                sb.append(DClass.string(i));
                sb.append(" ");
            }
            sb.append(Type.string(this.type));
            sb.append(" isn't done");
            throw new IllegalStateException(sb.toString());
        }
    }

    public Record[] getAnswers() {
        checkDone();
        return this.answers;
    }

    public Name[] getAliases() {
        checkDone();
        List<Name> list = this.aliases;
        if (list == null) {
            return noAliases;
        }
        return (Name[]) list.toArray(new Name[0]);
    }

    public int getResult() {
        checkDone();
        return this.result;
    }

    public String getErrorString() {
        checkDone();
        String str = this.error;
        if (str != null) {
            return str;
        }
        int i = this.result;
        if (i == 0) {
            return "successful";
        }
        if (i == 1) {
            return "unrecoverable error";
        }
        if (i == 2) {
            return "try again";
        }
        if (i == 3) {
            return "host not found";
        }
        if (i == 4) {
            return "type not found";
        }
        throw new IllegalStateException("unknown result");
    }
}

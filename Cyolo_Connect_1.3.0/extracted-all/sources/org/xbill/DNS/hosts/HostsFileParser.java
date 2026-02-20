package org.xbill.DNS.hosts;

import j$.time.Instant;
import j$.time.TimeConversions;
import j$.util.DesugarArrays;
import j$.util.Map;
import j$.util.Optional;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.Address;
import org.xbill.DNS.Name;
import org.xbill.DNS.TextParseException;

/* JADX INFO: loaded from: classes2.dex */
public final class HostsFileParser {
    private static final int MAX_FULL_CACHE_FILE_SIZE_BYTES = 16384;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) HostsFileParser.class);
    private final boolean clearCacheOnChange;
    private final Map<String, InetAddress> hostsCache;
    private boolean isEntireFileParsed;
    private Instant lastFileReadTime;
    private final Path path;

    /* JADX WARN: Illegal instructions before constructor call */
    public HostsFileParser() {
        Path path;
        if (System.getProperty("os.name").contains("Windows")) {
            path = Paths.get(System.getenv("SystemRoot"), "\\System32\\drivers\\etc\\hosts");
        } else {
            path = Paths.get("/etc/hosts", new String[0]);
        }
        this(path, true);
    }

    public HostsFileParser(Path path) {
        this(path, true);
    }

    public HostsFileParser(Path path, boolean z) {
        this.hostsCache = new HashMap();
        this.lastFileReadTime = Instant.MIN;
        this.path = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m1668m(Objects.requireNonNull(path, "path is required"));
        this.clearCacheOnChange = z;
        if (Files.isDirectory(path, new LinkOption[0])) {
            throw new IllegalArgumentException("path must be a file");
        }
    }

    public synchronized Optional<InetAddress> getAddressForHost(Name name, int i) throws IOException {
        Objects.requireNonNull(name, "name is required");
        if (i != 1 && i != 28) {
            throw new IllegalArgumentException("type can only be A or AAAA");
        }
        validateCache();
        InetAddress inetAddress = this.hostsCache.get(key(name, i));
        if (inetAddress != null) {
            return Optional.of(inetAddress);
        }
        if (!this.isEntireFileParsed && Files.exists(this.path, new LinkOption[0])) {
            if (Files.size(this.path) <= 16384) {
                parseEntireHostsFile();
            } else {
                searchHostsFileForEntry(name, i);
            }
            return Optional.ofNullable(this.hostsCache.get(key(name, i)));
        }
        return Optional.empty();
    }

    private void parseEntireHostsFile() throws IOException {
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(this.path, StandardCharsets.UTF_8);
        int i = 0;
        while (true) {
            try {
                String line = bufferedReaderNewBufferedReader.readLine();
                if (line == null) {
                    break;
                }
                i++;
                LineData line2 = parseLine(i, line);
                if (line2 != null) {
                    for (Name name : line2.names) {
                        Map.EL.putIfAbsent(this.hostsCache, key(name, line2.type), InetAddress.getByAddress(name.toString(true), line2.address));
                    }
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (bufferedReaderNewBufferedReader != null) {
                        try {
                            bufferedReaderNewBufferedReader.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        if (bufferedReaderNewBufferedReader != null) {
            bufferedReaderNewBufferedReader.close();
        }
        this.isEntireFileParsed = true;
    }

    private void searchHostsFileForEntry(Name name, int i) throws IOException {
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(this.path, StandardCharsets.UTF_8);
        int i2 = 0;
        while (true) {
            try {
                String line = bufferedReaderNewBufferedReader.readLine();
                if (line == null) {
                    if (bufferedReaderNewBufferedReader != null) {
                        bufferedReaderNewBufferedReader.close();
                        return;
                    }
                    return;
                }
                i2++;
                LineData line2 = parseLine(i2, line);
                if (line2 != null) {
                    for (Name name2 : line2.names) {
                        if (name2.equals(name) && i == line2.type) {
                            Map.EL.putIfAbsent(this.hostsCache, key(name2, line2.type), InetAddress.getByAddress(name2.toString(true), line2.address));
                            if (bufferedReaderNewBufferedReader != null) {
                                bufferedReaderNewBufferedReader.close();
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (bufferedReaderNewBufferedReader != null) {
                        try {
                            bufferedReaderNewBufferedReader.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    private static final class LineData {
        final byte[] address;
        final Iterable<? extends Name> names;
        final int type;

        public LineData(int i, byte[] bArr, Iterable<? extends Name> iterable) {
            this.type = i;
            this.address = bArr;
            this.names = iterable;
        }
    }

    private LineData parseLine(final int i, String str) {
        int i2;
        String[] lineTokens = getLineTokens(str);
        if (lineTokens.length < 2) {
            return null;
        }
        byte[] byteArray = Address.toByteArray(lineTokens[0], 1);
        if (byteArray == null) {
            byteArray = Address.toByteArray(lineTokens[0], 2);
            i2 = 28;
        } else {
            i2 = 1;
        }
        if (byteArray == null) {
            log.warn("Could not decode address {}, {}#L{}", lineTokens[0], this.path, Integer.valueOf(i));
            return null;
        }
        final Stream streamFilter = DesugarArrays.stream(lineTokens).skip(1L).map(new Function() { // from class: org.xbill.DNS.hosts.HostsFileParser$$ExternalSyntheticLambda4
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m2265lambda$parseLine$0$orgxbillDNShostsHostsFileParser(i, (String) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        }).filter(new Predicate() { // from class: org.xbill.DNS.hosts.HostsFileParser$$ExternalSyntheticLambda2
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
        });
        streamFilter.getClass();
        return new LineData(i2, byteArray, new Iterable() { // from class: org.xbill.DNS.hosts.HostsFileParser$$ExternalSyntheticLambda3
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return streamFilter.iterator2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: safeName, reason: merged with bridge method [inline-methods] */
    public Name m2265lambda$parseLine$0$orgxbillDNShostsHostsFileParser(String str, int i) {
        try {
            return Name.fromString(str, Name.root);
        } catch (TextParseException unused) {
            log.warn("Could not decode name {}, {}#L{}, skipping", str, this.path, Integer.valueOf(i));
            return null;
        }
    }

    private String[] getLineTokens(String str) {
        int iIndexOf = str.indexOf(35);
        if (iIndexOf == -1) {
            iIndexOf = str.length();
        }
        return str.substring(0, iIndexOf).trim().split("\\s+");
    }

    private void validateCache() throws IOException {
        if (this.clearCacheOnChange) {
            Instant instantConvert = Files.exists(this.path, new LinkOption[0]) ? TimeConversions.convert(Files.getLastModifiedTime(this.path, new LinkOption[0]).toInstant()) : Instant.MAX;
            if (instantConvert.isAfter(this.lastFileReadTime)) {
                if (!this.hostsCache.isEmpty()) {
                    log.info("Local hosts database has changed at {}, clearing cache", instantConvert);
                    this.hostsCache.clear();
                }
                this.isEntireFileParsed = false;
                this.lastFileReadTime = instantConvert;
            }
        }
    }

    private String key(Name name, int i) {
        return name.toString() + '\t' + i;
    }

    int cacheSize() {
        return this.hostsCache.size();
    }
}

package org.xbill.DNS.config;

import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class ResolvConfResolverConfigProvider extends BaseResolverConfigProvider {
    private int ndots = 1;

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public void initialize() {
        if (tryParseResolveConf("/etc/resolv.conf")) {
            return;
        }
        tryParseResolveConf("sys:/etc/resolv.cfg");
    }

    private boolean tryParseResolveConf(String str) {
        Path path = Paths.get(str, new String[0]);
        if (Files.exists(path, new LinkOption[0])) {
            try {
                InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
                try {
                    parseResolvConf(inputStreamNewInputStream);
                    if (inputStreamNewInputStream == null) {
                        return true;
                    }
                    inputStreamNewInputStream.close();
                    return true;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (inputStreamNewInputStream != null) {
                            try {
                                inputStreamNewInputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Found duplicated region for block: B:25:0x0056  */
    protected void parseResolvConf(InputStream inputStream) throws IOException {
        byte b;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        try {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        StringTokenizer stringTokenizer = new StringTokenizer(line);
                        if (stringTokenizer.hasMoreTokens()) {
                            String strNextToken = stringTokenizer.nextToken();
                            switch (strNextToken.hashCode()) {
                                case -1326197564:
                                    b = !strNextToken.equals(DynamicLink.Builder.KEY_DOMAIN) ? (byte) -1 : (byte) 1;
                                    break;
                                case -1249474914:
                                    if (strNextToken.equals("options")) {
                                        b = 3;
                                    }
                                    break;
                                case -906336856:
                                    if (strNextToken.equals("search")) {
                                        b = 2;
                                    }
                                    break;
                                case 154424718:
                                    if (strNextToken.equals("nameserver")) {
                                        b = 0;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            if (b == 0) {
                                addNameserver(new InetSocketAddress(stringTokenizer.nextToken(), 53));
                            } else if (b == 1) {
                                this.searchlist.clear();
                                if (stringTokenizer.hasMoreTokens()) {
                                    addSearchPath(stringTokenizer.nextToken());
                                }
                            } else {
                                if (b == 2) {
                                    this.searchlist.clear();
                                    while (stringTokenizer.hasMoreTokens()) {
                                        addSearchPath(stringTokenizer.nextToken());
                                    }
                                } else if (b != 3) {
                                }
                                while (stringTokenizer.hasMoreTokens()) {
                                    String strNextToken2 = stringTokenizer.nextToken();
                                    if (strNextToken2.startsWith("ndots:")) {
                                        this.ndots = parseNdots(strNextToken2.substring(6));
                                    }
                                }
                            }
                        }
                    } else {
                        bufferedReader.close();
                        inputStreamReader.close();
                        String str = System.getenv("LOCALDOMAIN");
                        if (str != null && !str.isEmpty()) {
                            this.searchlist.clear();
                            parseSearchPathList(str, " ");
                        }
                        String str2 = System.getenv("RES_OPTIONS");
                        if (str2 == null || str2.isEmpty()) {
                            return;
                        }
                        StringTokenizer stringTokenizer2 = new StringTokenizer(str2, " ");
                        while (stringTokenizer2.hasMoreTokens()) {
                            String strNextToken3 = stringTokenizer2.nextToken();
                            if (strNextToken3.startsWith("ndots:")) {
                                this.ndots = parseNdots(strNextToken3.substring(6));
                            }
                        }
                        return;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    @Override // org.xbill.DNS.config.BaseResolverConfigProvider, org.xbill.DNS.config.ResolverConfigProvider
    public int ndots() {
        return this.ndots;
    }

    @Override // org.xbill.DNS.config.BaseResolverConfigProvider, org.xbill.DNS.config.ResolverConfigProvider
    public boolean isEnabled() {
        return (System.getProperty("os.name").contains("Windows") || System.getProperty("java.specification.vendor").toLowerCase().contains("android")) ? false : true;
    }
}

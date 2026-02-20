package org.xbill.DNS.spi;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.AAAARecord;
import org.xbill.DNS.ARecord;
import org.xbill.DNS.ExtendedResolver;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Name;
import org.xbill.DNS.PTRRecord;
import org.xbill.DNS.Record;
import org.xbill.DNS.ReverseMap;
import org.xbill.DNS.TextParseException;
import sun.net.spi.nameservice.NameService;

/* JADX INFO: loaded from: classes2.dex */
public class DNSJavaNameService implements NameService {
    private static final String domainProperty = "sun.net.spi.nameservice.domain";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) DNSJavaNameService.class);
    private static final String nsProperty = "sun.net.spi.nameservice.nameservers";
    private static final String v6Property = "java.net.preferIPv6Addresses";
    private boolean addressesLoaded;
    private InetAddress[] localhostAddresses;
    private Name localhostName;
    private InetAddress[] localhostNamedAddresses;
    private boolean preferV6;

    protected DNSJavaNameService() {
        this.preferV6 = false;
        this.localhostName = null;
        this.localhostNamedAddresses = null;
        this.localhostAddresses = null;
        this.addressesLoaded = false;
        String property = System.getProperty(nsProperty);
        String property2 = System.getProperty(domainProperty);
        String property3 = System.getProperty(v6Property);
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            String[] strArr = new String[stringTokenizer.countTokens()];
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                strArr[i] = stringTokenizer.nextToken();
                i++;
            }
            try {
                Lookup.setDefaultResolver(new ExtendedResolver(strArr));
            } catch (UnknownHostException unused) {
                log.error("DNSJavaNameService: invalid {}", nsProperty);
            }
        }
        if (property2 != null) {
            try {
                Lookup.setDefaultSearchPath(property2);
            } catch (TextParseException unused2) {
                log.error("DNSJavaNameService: invalid {}", domainProperty);
            }
        }
        if (property3 != null && property3.equalsIgnoreCase("true")) {
            this.preferV6 = true;
        }
        try {
            Method declaredMethod = Class.forName("java.net.InetAddressImplFactory").getDeclaredMethod("create", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Class<?> cls = Class.forName("java.net.InetAddressImpl");
            Method method = cls.getMethod("getLocalHostName", new Class[0]);
            method.setAccessible(true);
            this.localhostName = Name.fromString((String) method.invoke(objInvoke, new Object[0]));
            Method method2 = cls.getMethod("lookupAllHostAddr", String.class);
            method2.setAccessible(true);
            this.localhostNamedAddresses = (InetAddress[]) method2.invoke(objInvoke, this.localhostName.toString());
            this.localhostAddresses = (InetAddress[]) method2.invoke(objInvoke, "localhost");
            this.addressesLoaded = true;
        } catch (Exception e) {
            log.error("Could not obtain localhost", (Throwable) e);
        }
    }

    public InetAddress[] lookupAllHostAddr(String str) throws UnknownHostException {
        try {
            Name name = new Name(str);
            if (this.addressesLoaded) {
                if (name.equals(this.localhostName)) {
                    return this.localhostNamedAddresses;
                }
                if ("localhost".equalsIgnoreCase(str)) {
                    return this.localhostAddresses;
                }
            }
            Record[] recordArrRun = this.preferV6 ? new Lookup(name, 28).run() : null;
            if (recordArrRun == null) {
                recordArrRun = new Lookup(name, 1).run();
            }
            if (recordArrRun == null && !this.preferV6) {
                recordArrRun = new Lookup(name, 28).run();
            }
            if (recordArrRun == null) {
                throw new UnknownHostException(str);
            }
            InetAddress[] inetAddressArr = new InetAddress[recordArrRun.length];
            for (int i = 0; i < recordArrRun.length; i++) {
                Record record = recordArrRun[i];
                if (record instanceof ARecord) {
                    inetAddressArr[i] = ((ARecord) record).getAddress();
                } else {
                    inetAddressArr[i] = ((AAAARecord) record).getAddress();
                }
            }
            return inetAddressArr;
        } catch (TextParseException unused) {
            throw new UnknownHostException(str);
        }
    }

    public String getHostByAddr(byte[] bArr) throws UnknownHostException {
        Name nameFromAddress = ReverseMap.fromAddress(InetAddress.getByAddress(bArr));
        Record[] recordArrRun = new Lookup(nameFromAddress, 12).run();
        if (recordArrRun == null) {
            throw new UnknownHostException("Unknown address: " + nameFromAddress);
        }
        return ((PTRRecord) recordArrRun[0]).getTarget().toString();
    }
}

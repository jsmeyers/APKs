package org.xbill.DNS;

import j$.util.Collection;
import j$.util.function.Function;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.xbill.DNS.SVCBBase;
import org.xbill.DNS.Tokenizer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SVCBBase extends Record {
    public static final int ALPN = 1;
    public static final int ECH = 5;

    @Deprecated
    public static final int ECHCONFIG = 5;
    public static final int IPV4HINT = 4;
    public static final int IPV6HINT = 6;
    public static final int MANDATORY = 0;
    public static final int NO_DEFAULT_ALPN = 2;
    public static final int PORT = 3;
    private static final ParameterMnemonic parameters;
    protected final Map<Integer, ParameterBase> svcParams;
    protected int svcPriority;
    protected Name targetName;

    protected SVCBBase() {
        this.svcParams = new TreeMap();
    }

    protected SVCBBase(Name name, int i, int i2, long j) {
        super(name, i, i2, j);
        this.svcParams = new TreeMap();
    }

    protected SVCBBase(Name name, int i, int i2, long j, int i3, Name name2, List<ParameterBase> list) {
        super(name, i, i2, j);
        this.svcPriority = i3;
        this.targetName = name2;
        this.svcParams = new TreeMap();
        for (ParameterBase parameterBase : list) {
            if (this.svcParams.containsKey(Integer.valueOf(parameterBase.getKey()))) {
                throw new IllegalArgumentException("Duplicate SvcParam for key " + parameterBase.getKey());
            }
            this.svcParams.put(Integer.valueOf(parameterBase.getKey()), parameterBase);
        }
    }

    public int getSvcPriority() {
        return this.svcPriority;
    }

    public Name getTargetName() {
        return this.targetName;
    }

    public Set<Integer> getSvcParamKeys() {
        return this.svcParams.keySet();
    }

    public ParameterBase getSvcParamValue(int i) {
        return this.svcParams.get(Integer.valueOf(i));
    }

    private static class ParameterMnemonic extends Mnemonic {
        private HashMap<Integer, Supplier<ParameterBase>> factories;

        public ParameterMnemonic() {
            super("SVCB/HTTPS Parameters", 3);
            setPrefix("key");
            setNumericAllowed(true);
            setMaximum(65535);
            this.factories = new HashMap<>();
        }

        public void add(int i, String str, Supplier<ParameterBase> supplier) {
            super.add(i, str);
            this.factories.put(Integer.valueOf(i), supplier);
        }

        public Supplier<ParameterBase> getFactory(int i) {
            return this.factories.get(Integer.valueOf(i));
        }
    }

    static {
        ParameterMnemonic parameterMnemonic = new ParameterMnemonic();
        parameters = parameterMnemonic;
        parameterMnemonic.add(0, "mandatory", new Supplier() { // from class: org.xbill.DNS.SVCBBase$$ExternalSyntheticLambda0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new SVCBBase.ParameterMandatory();
            }
        });
        parameterMnemonic.add(1, "alpn", new Supplier() { // from class: org.xbill.DNS.SVCBBase$$ExternalSyntheticLambda1
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new SVCBBase.ParameterAlpn();
            }
        });
        parameterMnemonic.add(2, "no-default-alpn", new Supplier() { // from class: org.xbill.DNS.SVCBBase$$ExternalSyntheticLambda2
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new SVCBBase.ParameterNoDefaultAlpn();
            }
        });
        parameterMnemonic.add(3, "port", new Supplier() { // from class: org.xbill.DNS.SVCBBase$$ExternalSyntheticLambda3
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new SVCBBase.ParameterPort();
            }
        });
        parameterMnemonic.add(4, "ipv4hint", new Supplier() { // from class: org.xbill.DNS.SVCBBase$$ExternalSyntheticLambda4
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new SVCBBase.ParameterIpv4Hint();
            }
        });
        parameterMnemonic.add(5, "ech", new Supplier() { // from class: org.xbill.DNS.SVCBBase$$ExternalSyntheticLambda5
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new SVCBBase.ParameterEch();
            }
        });
        parameterMnemonic.add(6, "ipv6hint", new Supplier() { // from class: org.xbill.DNS.SVCBBase$$ExternalSyntheticLambda6
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new SVCBBase.ParameterIpv6Hint();
            }
        });
        parameterMnemonic.addAlias(5, "echconfig");
    }

    public static abstract class ParameterBase {
        public abstract void fromString(String str) throws IOException;

        public abstract void fromWire(byte[] bArr) throws IOException;

        public abstract int getKey();

        public abstract String toString();

        public abstract byte[] toWire();

        public static String[] splitStringWithEscapedCommas(String str) {
            return str.split("(?<!\\\\),");
        }
    }

    public static class ParameterMandatory extends ParameterBase {
        private final List<Integer> values;

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 0;
        }

        public ParameterMandatory() {
            this.values = new ArrayList();
        }

        public ParameterMandatory(List<Integer> list) {
            this.values = list;
        }

        public List<Integer> getValues() {
            return this.values;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) throws IOException {
            this.values.clear();
            DNSInput dNSInput = new DNSInput(bArr);
            while (dNSInput.remaining() >= 2) {
                this.values.add(Integer.valueOf(dNSInput.readU16()));
            }
            if (dNSInput.remaining() > 0) {
                throw new WireParseException("Unexpected number of bytes in mandatory parameter");
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws TextParseException {
            this.values.clear();
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Non-empty list must be specified for mandatory");
            }
            for (String str2 : splitStringWithEscapedCommas(str)) {
                int value = SVCBBase.parameters.getValue(str2);
                if (value == 0) {
                    throw new TextParseException("Key mandatory must not appear in its own list");
                }
                if (this.values.contains(Integer.valueOf(value))) {
                    throw new TextParseException("Duplicate key " + str2 + " not allowed in mandatory list");
                }
                this.values.add(Integer.valueOf(value));
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            DNSOutput dNSOutput = new DNSOutput();
            Iterator<Integer> it = this.values.iterator();
            while (it.hasNext()) {
                dNSOutput.writeU16(it.next().intValue());
            }
            return dNSOutput.toByteArray();
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Integer num : this.values) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(SVCBBase.parameters.getText(num.intValue()));
            }
            return sb.toString();
        }
    }

    public static class ParameterAlpn extends ParameterBase {
        private final List<byte[]> values = new ArrayList();

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 1;
        }

        public ParameterAlpn() {
        }

        public ParameterAlpn(List<String> list) throws TextParseException {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.values.add(Record.byteArrayFromString(it.next()));
            }
        }

        public List<String> getValues() {
            ArrayList arrayList = new ArrayList();
            Iterator<byte[]> it = this.values.iterator();
            while (it.hasNext()) {
                arrayList.add(Record.byteArrayToString(it.next(), false));
            }
            return arrayList;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) throws IOException {
            this.values.clear();
            DNSInput dNSInput = new DNSInput(bArr);
            while (dNSInput.remaining() > 0) {
                this.values.add(dNSInput.readCountedString());
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws TextParseException {
            this.values.clear();
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Non-empty list must be specified for alpn");
            }
            for (String str2 : splitStringWithEscapedCommas(str)) {
                this.values.add(Record.byteArrayFromString(str2));
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            DNSOutput dNSOutput = new DNSOutput();
            Iterator<byte[]> it = this.values.iterator();
            while (it.hasNext()) {
                dNSOutput.writeCountedString(it.next());
            }
            return dNSOutput.toByteArray();
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr : this.values) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(Record.byteArrayToString(bArr, false).replaceAll(",", "\\\\,"));
            }
            return sb.toString();
        }
    }

    public static class ParameterNoDefaultAlpn extends ParameterBase {
        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 2;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            return "";
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            return new byte[0];
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) throws WireParseException {
            if (bArr.length > 0) {
                throw new WireParseException("No value can be specified for no-default-alpn");
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws TextParseException {
            if (str != null && !str.isEmpty()) {
                throw new TextParseException("No value can be specified for no-default-alpn");
            }
        }
    }

    public static class ParameterPort extends ParameterBase {
        private int port;

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 3;
        }

        public ParameterPort() {
        }

        public ParameterPort(int i) {
            this.port = i;
        }

        public int getPort() {
            return this.port;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) throws IOException {
            DNSInput dNSInput = new DNSInput(bArr);
            this.port = dNSInput.readU16();
            if (dNSInput.remaining() > 0) {
                throw new WireParseException("Unexpected number of bytes in port parameter");
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws TextParseException {
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Integer value must be specified for port");
            }
            this.port = Integer.parseInt(str);
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            DNSOutput dNSOutput = new DNSOutput();
            dNSOutput.writeU16(this.port);
            return dNSOutput.toByteArray();
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            return Integer.toString(this.port);
        }
    }

    public static class ParameterIpv4Hint extends ParameterBase {
        private final List<byte[]> addresses;

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 4;
        }

        public ParameterIpv4Hint() {
            this.addresses = new ArrayList();
        }

        public ParameterIpv4Hint(List<Inet4Address> list) {
            this.addresses = (List) Collection.EL.stream(list).map(new Function() { // from class: org.xbill.DNS.SVCBBase$ParameterIpv4Hint$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                public /* synthetic */ Function andThen(Function function) {
                    return Function.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return ((Inet4Address) obj).getAddress();
                }

                @Override // j$.util.function.Function
                public /* synthetic */ Function compose(Function function) {
                    return Function.CC.$default$compose(this, function);
                }
            }).collect(Collectors.toList());
        }

        public List<Inet4Address> getAddresses() throws UnknownHostException {
            LinkedList linkedList = new LinkedList();
            Iterator<byte[]> it = this.addresses.iterator();
            while (it.hasNext()) {
                InetAddress byAddress = InetAddress.getByAddress(it.next());
                if (byAddress instanceof Inet4Address) {
                    linkedList.add((Inet4Address) byAddress);
                }
            }
            return linkedList;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) throws IOException {
            this.addresses.clear();
            DNSInput dNSInput = new DNSInput(bArr);
            while (dNSInput.remaining() >= 4) {
                this.addresses.add(dNSInput.readByteArray(4));
            }
            if (dNSInput.remaining() > 0) {
                throw new WireParseException("Unexpected number of bytes in ipv4hint parameter");
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws IOException {
            this.addresses.clear();
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Non-empty IPv4 list must be specified for ipv4hint");
            }
            for (String str2 : str.split(",")) {
                byte[] byteArray = Address.toByteArray(str2, 1);
                if (byteArray == null) {
                    throw new TextParseException("Invalid ipv4hint value '" + str2 + "'");
                }
                this.addresses.add(byteArray);
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            DNSOutput dNSOutput = new DNSOutput();
            Iterator<byte[]> it = this.addresses.iterator();
            while (it.hasNext()) {
                dNSOutput.writeByteArray(it.next());
            }
            return dNSOutput.toByteArray();
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr : this.addresses) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(Address.toDottedQuad(bArr));
            }
            return sb.toString();
        }
    }

    public static class ParameterEch extends ParameterBase {
        private byte[] data;

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 5;
        }

        public ParameterEch() {
        }

        public ParameterEch(byte[] bArr) {
            this.data = bArr;
        }

        public byte[] getData() {
            return this.data;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) {
            this.data = bArr;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws TextParseException {
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Non-empty base64 value must be specified for ech");
            }
            this.data = Base64.getDecoder().decode(str);
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            return this.data;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            return Base64.getEncoder().encodeToString(this.data);
        }
    }

    @Deprecated
    public static class ParameterEchConfig extends ParameterBase {
        private byte[] data;

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 5;
        }

        public ParameterEchConfig() {
        }

        public ParameterEchConfig(byte[] bArr) {
            this.data = bArr;
        }

        public byte[] getData() {
            return this.data;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) {
            this.data = bArr;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws TextParseException {
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Non-empty base64 value must be specified for echconfig");
            }
            this.data = Base64.getDecoder().decode(str);
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            return this.data;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            return Base64.getEncoder().encodeToString(this.data);
        }
    }

    public static class ParameterIpv6Hint extends ParameterBase {
        private final List<byte[]> addresses;

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 6;
        }

        public ParameterIpv6Hint() {
            this.addresses = new ArrayList();
        }

        public ParameterIpv6Hint(List<Inet6Address> list) {
            this.addresses = (List) Collection.EL.stream(list).map(new Function() { // from class: org.xbill.DNS.SVCBBase$ParameterIpv6Hint$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                public /* synthetic */ Function andThen(Function function) {
                    return Function.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return ((Inet6Address) obj).getAddress();
                }

                @Override // j$.util.function.Function
                public /* synthetic */ Function compose(Function function) {
                    return Function.CC.$default$compose(this, function);
                }
            }).collect(Collectors.toList());
        }

        public List<Inet6Address> getAddresses() throws UnknownHostException {
            LinkedList linkedList = new LinkedList();
            Iterator<byte[]> it = this.addresses.iterator();
            while (it.hasNext()) {
                InetAddress byAddress = InetAddress.getByAddress(it.next());
                if (byAddress instanceof Inet6Address) {
                    linkedList.add((Inet6Address) byAddress);
                }
            }
            return linkedList;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) throws IOException {
            this.addresses.clear();
            DNSInput dNSInput = new DNSInput(bArr);
            while (dNSInput.remaining() >= 16) {
                this.addresses.add(dNSInput.readByteArray(16));
            }
            if (dNSInput.remaining() > 0) {
                throw new WireParseException("Unexpected number of bytes in ipv6hint parameter");
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws IOException {
            this.addresses.clear();
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Non-empty IPv6 list must be specified for ipv6hint");
            }
            for (String str2 : str.split(",")) {
                byte[] byteArray = Address.toByteArray(str2, 2);
                if (byteArray == null) {
                    throw new TextParseException("Invalid ipv6hint value '" + str2 + "'");
                }
                this.addresses.add(byteArray);
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            DNSOutput dNSOutput = new DNSOutput();
            Iterator<byte[]> it = this.addresses.iterator();
            while (it.hasNext()) {
                dNSOutput.writeByteArray(it.next());
            }
            return dNSOutput.toByteArray();
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr : this.addresses) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                try {
                    sb.append(InetAddress.getByAddress(null, bArr).getHostAddress());
                } catch (UnknownHostException e) {
                    return e.getMessage();
                }
            }
            return sb.toString();
        }
    }

    public static class ParameterUnknown extends ParameterBase {
        private int key;
        private byte[] value;

        public ParameterUnknown(int i) {
            this.key = i;
            this.value = new byte[0];
        }

        public ParameterUnknown(int i, byte[] bArr) {
            this.key = i;
            this.value = bArr;
        }

        public byte[] getValue() {
            return this.value;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return this.key;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) {
            this.value = bArr;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws IOException {
            if (str == null || str.isEmpty()) {
                this.value = new byte[0];
            } else {
                this.value = Record.byteArrayFromString(str);
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            return this.value;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            return Record.byteArrayToString(this.value, false);
        }
    }

    protected boolean checkMandatoryParams() {
        ParameterMandatory parameterMandatory = (ParameterMandatory) getSvcParamValue(0);
        if (parameterMandatory == null) {
            return true;
        }
        Iterator it = parameterMandatory.values.iterator();
        while (it.hasNext()) {
            if (getSvcParamValue(((Integer) it.next()).intValue()) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        ParameterBase parameterUnknown;
        this.svcPriority = dNSInput.readU16();
        this.targetName = new Name(dNSInput);
        this.svcParams.clear();
        while (dNSInput.remaining() >= 4) {
            int u16 = dNSInput.readU16();
            byte[] byteArray = dNSInput.readByteArray(dNSInput.readU16());
            Supplier<ParameterBase> factory = parameters.getFactory(u16);
            if (factory != null) {
                parameterUnknown = factory.get();
            } else {
                parameterUnknown = new ParameterUnknown(u16);
            }
            parameterUnknown.fromWire(byteArray);
            this.svcParams.put(Integer.valueOf(u16), parameterUnknown);
        }
        if (dNSInput.remaining() > 0) {
            throw new WireParseException("Record had unexpected number of bytes");
        }
        if (!checkMandatoryParams()) {
            throw new WireParseException("Not all mandatory SvcParams are specified");
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.svcPriority);
        sb.append(" ");
        sb.append(this.targetName);
        for (Integer num : this.svcParams.keySet()) {
            sb.append(" ");
            sb.append(parameters.getText(num.intValue()));
            String string = this.svcParams.get(num).toString();
            if (string != null && !string.isEmpty()) {
                sb.append("=");
                sb.append(string);
            }
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        String strSubstring;
        String strSubstring2;
        ParameterBase parameterUnknown;
        this.svcPriority = tokenizer.getUInt16();
        this.targetName = tokenizer.getName(name);
        this.svcParams.clear();
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (token.isString()) {
                int iIndexOf = token.value.indexOf(61);
                if (iIndexOf == -1) {
                    strSubstring2 = token.value;
                    strSubstring = null;
                } else if (iIndexOf == token.value.length() - 1) {
                    strSubstring2 = token.value.substring(0, iIndexOf);
                    Tokenizer.Token token2 = tokenizer.get();
                    if (!token2.isString()) {
                        throw new TextParseException("Expected value for parameter key '" + strSubstring2 + "'");
                    }
                    strSubstring = token2.value;
                } else if (iIndexOf > 0) {
                    String strSubstring3 = token.value.substring(0, iIndexOf);
                    strSubstring = token.value.substring(iIndexOf + 1);
                    strSubstring2 = strSubstring3;
                } else {
                    throw new TextParseException("Expected valid parameter key=value for '" + token.value + "'");
                }
                ParameterMnemonic parameterMnemonic = parameters;
                int value = parameterMnemonic.getValue(strSubstring2);
                if (value == -1) {
                    throw new TextParseException("Expected a valid parameter key for '" + strSubstring2 + "'");
                }
                if (this.svcParams.containsKey(Integer.valueOf(value))) {
                    throw new TextParseException("Duplicate parameter key for '" + strSubstring2 + "'");
                }
                Supplier<ParameterBase> factory = parameterMnemonic.getFactory(value);
                if (factory != null) {
                    parameterUnknown = factory.get();
                } else {
                    parameterUnknown = new ParameterUnknown(value);
                }
                parameterUnknown.fromString(strSubstring);
                this.svcParams.put(Integer.valueOf(value), parameterUnknown);
            } else {
                tokenizer.unget();
                if (this.svcPriority > 0 && this.svcParams.isEmpty()) {
                    throw new TextParseException("At least one parameter value must be specified for ServiceMode");
                }
                if (this.svcPriority == 0 && !this.svcParams.isEmpty()) {
                    throw new TextParseException("No parameter values allowed for AliasMode");
                }
                if (!checkMandatoryParams()) {
                    throw new TextParseException("Not all mandatory SvcParams are specified");
                }
                return;
            }
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.svcPriority);
        this.targetName.toWire(dNSOutput, null, z);
        for (Integer num : this.svcParams.keySet()) {
            dNSOutput.writeU16(num.intValue());
            byte[] wire = this.svcParams.get(num).toWire();
            dNSOutput.writeU16(wire.length);
            dNSOutput.writeByteArray(wire);
        }
    }
}

package org.xbill.DNS;

import io.flutter.embedding.android.KeyboardMap;
import j$.time.Clock;
import j$.time.Duration;
import j$.time.Instant;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.utils.base64;
import org.xbill.DNS.utils.hexdump;

/* JADX INFO: loaded from: classes2.dex */
public class TSIG {
    public static final Duration FUDGE;

    @Deprecated
    public static final Name HMAC;
    public static final Name HMAC_MD5;
    public static final Name HMAC_SHA1;
    public static final Name HMAC_SHA224;
    public static final Name HMAC_SHA256;
    public static final Name HMAC_SHA384;
    public static final Name HMAC_SHA512;
    private static final Map<Name, String> algMap;
    private final Name alg;
    private final Clock clock;
    private final String macAlgorithm;
    private final SecretKey macKey;
    private final Name name;
    private final Mac sharedHmac;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) TSIG.class);
    public static final Name GSS_TSIG = Name.fromConstantString("gss-tsig.");

    static {
        Name nameFromConstantString = Name.fromConstantString("HMAC-MD5.SIG-ALG.REG.INT.");
        HMAC_MD5 = nameFromConstantString;
        HMAC = nameFromConstantString;
        Name nameFromConstantString2 = Name.fromConstantString("hmac-sha1.");
        HMAC_SHA1 = nameFromConstantString2;
        Name nameFromConstantString3 = Name.fromConstantString("hmac-sha224.");
        HMAC_SHA224 = nameFromConstantString3;
        Name nameFromConstantString4 = Name.fromConstantString("hmac-sha256.");
        HMAC_SHA256 = nameFromConstantString4;
        Name nameFromConstantString5 = Name.fromConstantString("hmac-sha384.");
        HMAC_SHA384 = nameFromConstantString5;
        Name nameFromConstantString6 = Name.fromConstantString("hmac-sha512.");
        HMAC_SHA512 = nameFromConstantString6;
        HashMap map = new HashMap();
        map.put(nameFromConstantString, "HmacMD5");
        map.put(nameFromConstantString2, "HmacSHA1");
        map.put(nameFromConstantString3, "HmacSHA224");
        map.put(nameFromConstantString4, "HmacSHA256");
        map.put(nameFromConstantString5, "HmacSHA384");
        map.put(nameFromConstantString6, "HmacSHA512");
        algMap = Collections.unmodifiableMap(map);
        FUDGE = Duration.ofSeconds(300L);
    }

    public static Name algorithmToName(String str) {
        for (Map.Entry<Name, String> entry : algMap.entrySet()) {
            if (str.equalsIgnoreCase(entry.getValue())) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("Unknown algorithm: " + str);
    }

    public static String nameToAlgorithm(Name name) {
        String str = algMap.get(name);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Unknown algorithm: " + name);
    }

    private static boolean verify(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, 0, bArr3, 0, length);
            bArr = bArr3;
        }
        return Arrays.equals(bArr2, bArr);
    }

    private Mac initHmac() {
        Mac mac = this.sharedHmac;
        if (mac != null) {
            try {
                return (Mac) mac.clone();
            } catch (CloneNotSupportedException unused) {
                this.sharedHmac.reset();
                return this.sharedHmac;
            }
        }
        try {
            Mac mac2 = Mac.getInstance(this.macAlgorithm);
            mac2.init(this.macKey);
            return mac2;
        } catch (GeneralSecurityException e) {
            throw new IllegalArgumentException("Caught security exception setting up HMAC.", e);
        }
    }

    public TSIG(Name name, Name name2, String str) {
        this(name, name2, (byte[]) Objects.requireNonNull(base64.fromString(str)));
    }

    public TSIG(Name name, Name name2, byte[] bArr) {
        this(name, name2, new SecretKeySpec(bArr, nameToAlgorithm(name)));
    }

    public TSIG(Name name, Name name2, SecretKey secretKey) {
        this(name, name2, secretKey, Clock.systemUTC());
    }

    public TSIG(Name name, Name name2, SecretKey secretKey, Clock clock) {
        this.name = name2;
        this.alg = name;
        this.clock = clock;
        this.macAlgorithm = nameToAlgorithm(name);
        this.macKey = secretKey;
        this.sharedHmac = null;
    }

    @Deprecated
    public TSIG(Mac mac, Name name) {
        this.name = name;
        this.sharedHmac = mac;
        this.macAlgorithm = null;
        this.macKey = null;
        this.clock = Clock.systemUTC();
        this.alg = algorithmToName(mac.getAlgorithm());
    }

    @Deprecated
    public TSIG(Name name, byte[] bArr) {
        this(HMAC_MD5, name, bArr);
    }

    public TSIG(Name name, String str, String str2) {
        byte[] bArrFromString = base64.fromString(str2);
        if (bArrFromString == null) {
            throw new IllegalArgumentException("Invalid TSIG key string");
        }
        try {
            this.name = Name.fromString(str, Name.root);
            this.alg = name;
            this.clock = Clock.systemUTC();
            String strNameToAlgorithm = nameToAlgorithm(name);
            this.macAlgorithm = strNameToAlgorithm;
            this.sharedHmac = null;
            this.macKey = new SecretKeySpec(bArrFromString, strNameToAlgorithm);
        } catch (TextParseException unused) {
            throw new IllegalArgumentException("Invalid TSIG key name");
        }
    }

    public TSIG(String str, String str2, String str3) {
        this(algorithmToName(str), str2, str3);
    }

    @Deprecated
    public TSIG(String str, String str2) {
        this(HMAC_MD5, str, str2);
    }

    @Deprecated
    public static TSIG fromString(String str) {
        String[] strArrSplit = str.split("[:/]", 3);
        int length = strArrSplit.length;
        if (length == 2) {
            return new TSIG(HMAC_MD5, strArrSplit[0], strArrSplit[1]);
        }
        if (length == 3) {
            return new TSIG(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
        }
        throw new IllegalArgumentException("Invalid TSIG key specification");
    }

    public TSIGRecord generate(Message message, byte[] bArr, int i, TSIGRecord tSIGRecord) {
        return generate(message, bArr, i, tSIGRecord, true);
    }

    public TSIGRecord generate(Message message, byte[] bArr, int i, TSIGRecord tSIGRecord, boolean z) {
        Instant instant;
        Mac macInitHmac;
        boolean z2;
        Duration durationOfSeconds;
        byte[] bArrDoFinal;
        byte[] byteArray;
        if (i == 18) {
            instant = tSIGRecord.getTimeSigned();
        } else {
            instant = this.clock.instant();
        }
        Instant instant2 = instant;
        if (i == 0 || i == 18 || i == 22) {
            macInitHmac = initHmac();
            z2 = true;
        } else {
            macInitHmac = null;
            z2 = false;
        }
        int iIntValue = Options.intValue("tsigfudge");
        if (iIntValue < 0 || iIntValue > 32767) {
            durationOfSeconds = FUDGE;
        } else {
            durationOfSeconds = Duration.ofSeconds(iIntValue);
        }
        if (tSIGRecord != null && z2) {
            hmacAddSignature(macInitHmac, tSIGRecord);
        }
        if (z2) {
            Logger logger = log;
            if (logger.isTraceEnabled()) {
                logger.trace(hexdump.dump("TSIG-HMAC rendered message", bArr));
            }
            macInitHmac.update(bArr);
        }
        DNSOutput dNSOutput = new DNSOutput();
        if (z) {
            this.name.toWireCanonical(dNSOutput);
            dNSOutput.writeU16(255);
            dNSOutput.writeU32(0L);
            this.alg.toWireCanonical(dNSOutput);
        }
        writeTsigTimersVariables(instant2, durationOfSeconds, dNSOutput);
        if (z) {
            dNSOutput.writeU16(i);
            dNSOutput.writeU16(0);
        }
        if (z2) {
            byte[] byteArray2 = dNSOutput.toByteArray();
            Logger logger2 = log;
            if (logger2.isTraceEnabled()) {
                logger2.trace(hexdump.dump("TSIG-HMAC variables", byteArray2));
            }
            bArrDoFinal = macInitHmac.doFinal(byteArray2);
        } else {
            bArrDoFinal = new byte[0];
        }
        byte[] bArr2 = bArrDoFinal;
        if (i == 18) {
            DNSOutput dNSOutput2 = new DNSOutput(6);
            writeTsigTime(this.clock.instant(), dNSOutput2);
            byteArray = dNSOutput2.toByteArray();
        } else {
            byteArray = null;
        }
        return new TSIGRecord(this.name, 255, 0L, this.alg, instant2, durationOfSeconds, bArr2, message.getHeader().getID(), i, byteArray);
    }

    public void apply(Message message, TSIGRecord tSIGRecord) {
        apply(message, 0, tSIGRecord, true);
    }

    public void apply(Message message, int i, TSIGRecord tSIGRecord) {
        apply(message, i, tSIGRecord, true);
    }

    public void apply(Message message, TSIGRecord tSIGRecord, boolean z) {
        apply(message, 0, tSIGRecord, z);
    }

    public void apply(Message message, int i, TSIGRecord tSIGRecord, boolean z) {
        message.addRecord(generate(message, message.toWire(), i, tSIGRecord, z), 3);
        message.tsigState = 3;
    }

    @Deprecated
    public void applyStream(Message message, TSIGRecord tSIGRecord, boolean z) {
        apply(message, 0, tSIGRecord, z);
    }

    @Deprecated
    public byte verify(Message message, byte[] bArr, int i, TSIGRecord tSIGRecord) {
        return (byte) verify(message, bArr, tSIGRecord);
    }

    public int verify(Message message, byte[] bArr, TSIGRecord tSIGRecord) {
        return verify(message, bArr, tSIGRecord, true);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public int verify(Message message, byte[] bArr, TSIGRecord tSIGRecord, boolean z) {
        message.tsigState = 4;
        TSIGRecord tsig = message.getTSIG();
        if (tsig == null) {
            return 1;
        }
        if (!tsig.getName().equals(this.name) || !tsig.getAlgorithm().equals(this.alg)) {
            log.debug("BADKEY failure, expected: {}/{}, actual: {}/{}", this.name, this.alg, tsig.getName(), tsig.getAlgorithm());
            return 17;
        }
        Mac macInitHmac = initHmac();
        if (tSIGRecord != null && tsig.getError() != 17 && tsig.getError() != 16) {
            hmacAddSignature(macInitHmac, tSIGRecord);
        }
        message.getHeader().decCount(3);
        byte[] wire = message.getHeader().toWire();
        message.getHeader().incCount(3);
        Logger logger = log;
        if (logger.isTraceEnabled()) {
            logger.trace(hexdump.dump("TSIG-HMAC header", wire));
        }
        macInitHmac.update(wire);
        int length = message.tsigstart - wire.length;
        if (logger.isTraceEnabled()) {
            logger.trace(hexdump.dump("TSIG-HMAC message after header", bArr, wire.length, length));
        }
        macInitHmac.update(bArr, wire.length, length);
        DNSOutput dNSOutput = new DNSOutput();
        if (z) {
            tsig.getName().toWireCanonical(dNSOutput);
            dNSOutput.writeU16(tsig.dclass);
            dNSOutput.writeU32(tsig.ttl);
            tsig.getAlgorithm().toWireCanonical(dNSOutput);
        }
        writeTsigTimersVariables(tsig.getTimeSigned(), tsig.getFudge(), dNSOutput);
        if (z) {
            dNSOutput.writeU16(tsig.getError());
            if (tsig.getOther() != null) {
                dNSOutput.writeU16(tsig.getOther().length);
                dNSOutput.writeByteArray(tsig.getOther());
            } else {
                dNSOutput.writeU16(0);
            }
        }
        byte[] byteArray = dNSOutput.toByteArray();
        if (logger.isTraceEnabled()) {
            logger.trace(hexdump.dump("TSIG-HMAC variables", byteArray));
        }
        macInitHmac.update(byteArray);
        byte[] signature = tsig.getSignature();
        int macLength = macInitHmac.getMacLength();
        int iMax = Math.max(10, macLength / 2);
        if (signature.length > macLength) {
            logger.debug("BADSIG: signature too long, expected: {}, actual: {}", Integer.valueOf(macLength), Integer.valueOf(signature.length));
            return 16;
        }
        if (signature.length < iMax) {
            logger.debug("BADSIG: signature too short, expected: {} of {}, actual: {}", Integer.valueOf(iMax), Integer.valueOf(macLength), Integer.valueOf(signature.length));
            return 16;
        }
        byte[] bArrDoFinal = macInitHmac.doFinal();
        if (!verify(bArrDoFinal, signature)) {
            if (logger.isDebugEnabled()) {
                logger.debug("BADSIG: signature verification failed, expected: {}, actual: {}", base64.toString(bArrDoFinal), base64.toString(signature));
            }
            return 16;
        }
        Instant instant = this.clock.instant();
        if (Duration.between(instant, tsig.getTimeSigned()).abs().compareTo(tsig.getFudge()) > 0) {
            logger.debug("BADTIME failure, now {} +/- tsig {} > fudge {}", instant, tsig.getTimeSigned(), tsig.getFudge());
            return 18;
        }
        message.tsigState = 1;
        return 0;
    }

    public int recordLength() {
        return this.name.length() + 10 + this.alg.length() + 8 + 18 + 4 + 8;
    }

    private static void hmacAddSignature(Mac mac, TSIGRecord tSIGRecord) {
        byte[] u16 = DNSOutput.toU16(tSIGRecord.getSignature().length);
        Logger logger = log;
        if (logger.isTraceEnabled()) {
            logger.trace(hexdump.dump("TSIG-HMAC signature size", u16));
            logger.trace(hexdump.dump("TSIG-HMAC signature", tSIGRecord.getSignature()));
        }
        mac.update(u16);
        mac.update(tSIGRecord.getSignature());
    }

    private static void writeTsigTimersVariables(Instant instant, Duration duration, DNSOutput dNSOutput) {
        writeTsigTime(instant, dNSOutput);
        dNSOutput.writeU16((int) duration.getSeconds());
    }

    private static void writeTsigTime(Instant instant, DNSOutput dNSOutput) {
        long epochSecond = instant.getEpochSecond();
        int i = (int) (epochSecond >> 32);
        long j = epochSecond & KeyboardMap.kValueMask;
        dNSOutput.writeU16(i);
        dNSOutput.writeU32(j);
    }

    public static class StreamVerifier {
        private final TSIG key;
        private TSIGRecord lastTSIG;
        private int lastsigned;
        private int nresponses = 0;

        public StreamVerifier(TSIG tsig, TSIGRecord tSIGRecord) {
            this.key = tsig;
            this.lastTSIG = tSIGRecord;
        }

        public int verify(Message message, byte[] bArr) {
            TSIGRecord tsig = message.getTSIG();
            int i = this.nresponses + 1;
            this.nresponses = i;
            if (i == 1) {
                int iVerify = this.key.verify(message, bArr, this.lastTSIG);
                this.lastTSIG = tsig;
                return iVerify;
            }
            if (tsig != null) {
                int iVerify2 = this.key.verify(message, bArr, this.lastTSIG, false);
                this.lastsigned = this.nresponses;
                this.lastTSIG = tsig;
                return iVerify2;
            }
            if (i - this.lastsigned >= 100) {
                TSIG.log.debug("FORMERR: missing required signature on {}th message", Integer.valueOf(this.nresponses));
                message.tsigState = 4;
                return 1;
            }
            TSIG.log.trace("Intermediate message {} without signature", Integer.valueOf(this.nresponses));
            message.tsigState = 2;
            return 0;
        }
    }
}

package org.xbill.DNS;

import io.flutter.embedding.android.KeyboardMap;
import j$.util.function.Supplier;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;
import org.xbill.DNS.Tokenizer;
import org.xbill.DNS.utils.base16;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Record implements Cloneable, Comparable<Record> {
    private static final DecimalFormat byteFormat;
    protected int dclass;
    protected Name name;
    protected long ttl;
    protected int type;

    public Name getAdditionalName() {
        return null;
    }

    protected abstract void rdataFromString(Tokenizer tokenizer, Name name) throws IOException;

    protected abstract void rrFromWire(DNSInput dNSInput) throws IOException;

    protected abstract String rrToString();

    protected abstract void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z);

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        byteFormat = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    protected Record() {
    }

    protected Record(Name name, int i, int i2, long j) {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        Type.check(i);
        DClass.check(i2);
        TTL.check(j);
        this.name = name;
        this.type = i;
        this.dclass = i2;
        this.ttl = j;
    }

    private static Record getEmptyRecord(Name name, int i, int i2, long j, boolean z) {
        Record emptyRecord;
        if (z) {
            Supplier<Record> factory = Type.getFactory(i);
            if (factory != null) {
                emptyRecord = factory.get();
            } else {
                emptyRecord = new UNKRecord();
            }
        } else {
            emptyRecord = new EmptyRecord();
        }
        emptyRecord.name = name;
        emptyRecord.type = i;
        emptyRecord.dclass = i2;
        emptyRecord.ttl = j;
        return emptyRecord;
    }

    private static Record newRecord(Name name, int i, int i2, long j, int i3, DNSInput dNSInput) throws IOException {
        Record emptyRecord = getEmptyRecord(name, i, i2, j, dNSInput != null);
        if (dNSInput != null) {
            if (dNSInput.remaining() < i3) {
                throw new WireParseException("truncated record");
            }
            dNSInput.setActive(i3);
            emptyRecord.rrFromWire(dNSInput);
            if (dNSInput.remaining() > 0) {
                throw new WireParseException("invalid record length");
            }
            dNSInput.clearActive();
        }
        return emptyRecord;
    }

    public static Record newRecord(Name name, int i, int i2, long j, int i3, byte[] bArr) {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        Type.check(i);
        DClass.check(i2);
        TTL.check(j);
        try {
            return newRecord(name, i, i2, j, i3, bArr != null ? new DNSInput(bArr) : null);
        } catch (IOException unused) {
            return null;
        }
    }

    public static Record newRecord(Name name, int i, int i2, long j, byte[] bArr) {
        return newRecord(name, i, i2, j, bArr.length, bArr);
    }

    public static Record newRecord(Name name, int i, int i2, long j) {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        Type.check(i);
        DClass.check(i2);
        TTL.check(j);
        return getEmptyRecord(name, i, i2, j, false);
    }

    public static Record newRecord(Name name, int i, int i2) {
        return newRecord(name, i, i2, 0L);
    }

    static Record fromWire(DNSInput dNSInput, int i, boolean z) throws IOException {
        Name name = new Name(dNSInput);
        int u16 = dNSInput.readU16();
        int u162 = dNSInput.readU16();
        if (i == 0) {
            return newRecord(name, u16, u162);
        }
        long u32 = dNSInput.readU32();
        int u163 = dNSInput.readU16();
        if (u163 == 0 && z && (i == 1 || i == 2)) {
            return newRecord(name, u16, u162, u32);
        }
        return newRecord(name, u16, u162, u32, u163, dNSInput);
    }

    static Record fromWire(DNSInput dNSInput, int i) throws IOException {
        return fromWire(dNSInput, i, false);
    }

    public static Record fromWire(byte[] bArr, int i) throws IOException {
        return fromWire(new DNSInput(bArr), i, false);
    }

    void toWire(DNSOutput dNSOutput, int i, Compression compression) {
        this.name.toWire(dNSOutput, compression);
        dNSOutput.writeU16(this.type);
        dNSOutput.writeU16(this.dclass);
        if (i == 0) {
            return;
        }
        dNSOutput.writeU32(this.ttl);
        int iCurrent = dNSOutput.current();
        dNSOutput.writeU16(0);
        rrToWire(dNSOutput, compression, false);
        dNSOutput.writeU16At((dNSOutput.current() - iCurrent) - 2, iCurrent);
    }

    public byte[] toWire(int i) {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, i, null);
        return dNSOutput.toByteArray();
    }

    private void toWireCanonical(DNSOutput dNSOutput, boolean z) {
        this.name.toWireCanonical(dNSOutput);
        dNSOutput.writeU16(this.type);
        dNSOutput.writeU16(this.dclass);
        if (z) {
            dNSOutput.writeU32(0L);
        } else {
            dNSOutput.writeU32(this.ttl);
        }
        int iCurrent = dNSOutput.current();
        dNSOutput.writeU16(0);
        rrToWire(dNSOutput, null, true);
        dNSOutput.writeU16At((dNSOutput.current() - iCurrent) - 2, iCurrent);
    }

    private byte[] toWireCanonical(boolean z) {
        DNSOutput dNSOutput = new DNSOutput();
        toWireCanonical(dNSOutput, z);
        return dNSOutput.toByteArray();
    }

    public byte[] toWireCanonical() {
        return toWireCanonical(false);
    }

    public byte[] rdataToWireCanonical() {
        DNSOutput dNSOutput = new DNSOutput();
        rrToWire(dNSOutput, null, true);
        return dNSOutput.toByteArray();
    }

    public String rdataToString() {
        return rrToString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        if (sb.length() < 8) {
            sb.append("\t");
        }
        if (sb.length() < 16) {
            sb.append("\t");
        }
        sb.append("\t");
        if (Options.check("BINDTTL")) {
            sb.append(TTL.format(this.ttl));
        } else {
            sb.append(this.ttl);
        }
        sb.append("\t");
        if (this.dclass != 1 || !Options.check("noPrintIN")) {
            sb.append(DClass.string(this.dclass));
            sb.append("\t");
        }
        sb.append(Type.string(this.type));
        String strRrToString = rrToString();
        if (!strRrToString.equals("")) {
            sb.append("\t");
            sb.append(strRrToString);
        }
        return sb.toString();
    }

    protected static byte[] byteArrayFromString(String str) throws TextParseException {
        boolean z;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (bytes[i] == 92) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            if (bytes.length <= 255) {
                return bytes;
            }
            throw new TextParseException("text string too long");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        for (byte b : bytes) {
            if (z2) {
                if (b >= 48 && b <= 57) {
                    i2++;
                    i3 = (i3 * 10) + (b - 48);
                    if (i3 > 255) {
                        throw new TextParseException("bad escape");
                    }
                    if (i2 >= 3) {
                        b = (byte) i3;
                    }
                } else if (i2 > 0) {
                    throw new TextParseException("bad escape");
                }
                byteArrayOutputStream.write(b);
                z2 = false;
            } else if (b == 92) {
                i2 = 0;
                z2 = true;
                i3 = 0;
            } else {
                byteArrayOutputStream.write(b);
            }
        }
        if (i2 > 0 && i2 < 3) {
            throw new TextParseException("bad escape");
        }
        if (byteArrayOutputStream.toByteArray().length > 255) {
            throw new TextParseException("text string too long");
        }
        return byteArrayOutputStream.toByteArray();
    }

    protected static String byteArrayToString(byte[] bArr, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(Typography.quote);
        }
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 32 || i >= 127) {
                sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                sb.append(byteFormat.format(i));
            } else if (i == 34 || i == 92) {
                sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                sb.append((char) i);
            } else {
                sb.append((char) i);
            }
        }
        if (z) {
            sb.append(Typography.quote);
        }
        return sb.toString();
    }

    protected static String unknownToString(byte[] bArr) {
        return "\\# " + bArr.length + " " + base16.toString(bArr);
    }

    public static Record fromString(Name name, int i, int i2, long j, Tokenizer tokenizer, Name name2) throws IOException {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        Type.check(i);
        DClass.check(i2);
        TTL.check(j);
        Tokenizer.Token token = tokenizer.get();
        if (token.type == 3 && token.value.equals("\\#")) {
            int uInt16 = tokenizer.getUInt16();
            byte[] hex = tokenizer.getHex();
            if (hex == null) {
                hex = new byte[0];
            }
            if (uInt16 != hex.length) {
                throw tokenizer.exception("invalid unknown RR encoding: length mismatch");
            }
            return newRecord(name, i, i2, j, uInt16, new DNSInput(hex));
        }
        tokenizer.unget();
        Record emptyRecord = getEmptyRecord(name, i, i2, j, true);
        emptyRecord.rdataFromString(tokenizer, name2);
        Tokenizer.Token token2 = tokenizer.get();
        if (token2.type == 1 || token2.type == 0) {
            return emptyRecord;
        }
        throw tokenizer.exception("unexpected tokens at end of record (wanted EOL/EOF, got " + token2.toString() + ")");
    }

    public static Record fromString(Name name, int i, int i2, long j, String str, Name name2) throws IOException {
        return fromString(name, i, i2, j, new Tokenizer(str), name2);
    }

    public Name getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public int getRRsetType() {
        return this.type;
    }

    public int getDClass() {
        return this.dclass;
    }

    public long getTTL() {
        return this.ttl;
    }

    public boolean sameRRset(Record record) {
        return getRRsetType() == record.getRRsetType() && this.dclass == record.dclass && this.name.equals(record.name);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Record)) {
            return false;
        }
        Record record = (Record) obj;
        if (this.type == record.type && this.dclass == record.dclass && this.name.equals(record.name)) {
            return Arrays.equals(rdataToWireCanonical(), record.rdataToWireCanonical());
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        for (byte b : toWireCanonical(true)) {
            i += (i << 3) + (b & 255);
        }
        return i;
    }

    Record cloneRecord() {
        try {
            return (Record) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    public Record withName(Name name) {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        Record recordCloneRecord = cloneRecord();
        recordCloneRecord.name = name;
        return recordCloneRecord;
    }

    Record withDClass(int i, long j) {
        Record recordCloneRecord = cloneRecord();
        recordCloneRecord.dclass = i;
        recordCloneRecord.ttl = j;
        return recordCloneRecord;
    }

    void setTTL(long j) {
        this.ttl = j;
    }

    @Override // java.lang.Comparable
    public int compareTo(Record record) {
        if (this == record) {
            return 0;
        }
        int iCompareTo = this.name.compareTo(record.name);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i = this.dclass - record.dclass;
        if (i != 0) {
            return i;
        }
        int i2 = this.type - record.type;
        if (i2 != 0) {
            return i2;
        }
        byte[] bArrRdataToWireCanonical = rdataToWireCanonical();
        byte[] bArrRdataToWireCanonical2 = record.rdataToWireCanonical();
        int iMin = Math.min(bArrRdataToWireCanonical.length, bArrRdataToWireCanonical2.length);
        for (int i3 = 0; i3 < iMin; i3++) {
            byte b = bArrRdataToWireCanonical[i3];
            byte b2 = bArrRdataToWireCanonical2[i3];
            if (b != b2) {
                return (b & 255) - (b2 & 255);
            }
        }
        return bArrRdataToWireCanonical.length - bArrRdataToWireCanonical2.length;
    }

    static int checkU8(String str, int i) {
        if (i >= 0 && i <= 255) {
            return i;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i + " must be an unsigned 8 bit value");
    }

    static int checkU16(String str, int i) {
        if (i >= 0 && i <= 65535) {
            return i;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i + " must be an unsigned 16 bit value");
    }

    static long checkU32(String str, long j) {
        if (j >= 0 && j <= KeyboardMap.kValueMask) {
            return j;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + j + " must be an unsigned 32 bit value");
    }

    static Name checkName(String str, Name name) {
        if (name.isAbsolute()) {
            return name;
        }
        throw new RelativeNameException("'" + name + "' on field " + str + " is not an absolute name");
    }

    static byte[] checkByteArrayLength(String str, byte[] bArr, int i) {
        if (bArr.length > 65535) {
            throw new IllegalArgumentException("\"" + str + "\" array must have no more than " + i + " elements");
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}

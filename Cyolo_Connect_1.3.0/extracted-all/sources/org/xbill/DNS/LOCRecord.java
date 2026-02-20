package org.xbill.DNS;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.xbill.DNS.Tokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class LOCRecord extends Record {
    private static NumberFormat w2;
    private static NumberFormat w3;
    private long altitude;
    private long hPrecision;
    private long latitude;
    private long longitude;
    private long size;
    private long vPrecision;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        w2 = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(2);
        DecimalFormat decimalFormat2 = new DecimalFormat();
        w3 = decimalFormat2;
        decimalFormat2.setMinimumIntegerDigits(3);
    }

    LOCRecord() {
    }

    public LOCRecord(Name name, int i, long j, double d, double d2, double d3, double d4, double d5, double d6) {
        super(name, 29, i, j);
        this.latitude = (long) ((d * 3600.0d * 1000.0d) + 2.147483648E9d);
        this.longitude = (long) ((3600.0d * d2 * 1000.0d) + 2.147483648E9d);
        this.altitude = (long) ((d3 + 100000.0d) * 100.0d);
        this.size = (long) (d4 * 100.0d);
        this.hPrecision = (long) (d5 * 100.0d);
        this.vPrecision = (long) (d6 * 100.0d);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        if (dNSInput.readU8() != 0) {
            throw new WireParseException("Invalid LOC version");
        }
        this.size = parseLOCformat(dNSInput.readU8());
        this.hPrecision = parseLOCformat(dNSInput.readU8());
        this.vPrecision = parseLOCformat(dNSInput.readU8());
        this.latitude = dNSInput.readU32();
        this.longitude = dNSInput.readU32();
        this.altitude = dNSInput.readU32();
    }

    private double parseFixedPoint(String str) {
        if (str.matches("^-?\\d+$")) {
            return Integer.parseInt(str);
        }
        if (str.matches("^-?\\d+\\.\\d*$")) {
            String[] strArrSplit = str.split("\\.");
            double d = Integer.parseInt(strArrSplit[0]);
            double d2 = Integer.parseInt(strArrSplit[1]);
            if (d < 0.0d) {
                d2 *= -1.0d;
            }
            return d + (d2 / Math.pow(10.0d, strArrSplit[1].length()));
        }
        throw new NumberFormatException();
    }

    /* JADX WARN: Found duplicated region for block: B:32:0x0086  */
    /* JADX WARN: Found duplicated region for block: B:41:0x00b1  */
    /* JADX WARN: Found duplicated region for block: B:51:0x00d4  */
    private long parsePosition(Tokenizer tokenizer, String str) throws IOException {
        int i;
        double fixedPoint;
        boolean zEquals = str.equals("latitude");
        int uInt16 = tokenizer.getUInt16();
        if (uInt16 > 180 || (uInt16 > 90 && zEquals)) {
            throw tokenizer.exception("Invalid LOC " + str + " degrees");
        }
        String string = tokenizer.getString();
        double d = 0.0d;
        try {
            i = Integer.parseInt(string);
        } catch (NumberFormatException unused) {
            i = 0;
        }
        if (i < 0 || i > 59) {
            throw tokenizer.exception("Invalid LOC " + str + " minutes");
        }
        try {
            string = tokenizer.getString();
            fixedPoint = parseFixedPoint(string);
        } catch (NumberFormatException unused2) {
            fixedPoint = d;
            if (string.length() == 1) {
                throw tokenizer.exception("Invalid LOC " + str);
            }
            long j = (long) ((fixedPoint + ((((long) i) + (((long) uInt16) * 60)) * 60)) * 1000.0d);
            char upperCase = Character.toUpperCase(string.charAt(0));
            if (!zEquals) {
                if (zEquals) {
                    throw tokenizer.exception("Invalid LOC " + str);
                }
                throw tokenizer.exception("Invalid LOC " + str);
            }
            if (zEquals) {
                throw tokenizer.exception("Invalid LOC " + str);
            }
            throw tokenizer.exception("Invalid LOC " + str);
            return j + 2147483648L;
        }
        try {
        } catch (NumberFormatException unused3) {
            d = fixedPoint;
            fixedPoint = d;
        }
        if (fixedPoint < 0.0d || fixedPoint >= 60.0d) {
            throw tokenizer.exception("Invalid LOC " + str + " seconds");
        }
        string = tokenizer.getString();
        if (string.length() == 1) {
            throw tokenizer.exception("Invalid LOC " + str);
        }
        long j2 = (long) ((fixedPoint + ((((long) i) + (((long) uInt16) * 60)) * 60)) * 1000.0d);
        char upperCase2 = Character.toUpperCase(string.charAt(0));
        if ((!zEquals && upperCase2 == 'S') || (!zEquals && upperCase2 == 'W')) {
            j2 = -j2;
        } else if ((zEquals && upperCase2 != 'N') || (!zEquals && upperCase2 != 'E')) {
            throw tokenizer.exception("Invalid LOC " + str);
        }
        return j2 + 2147483648L;
    }

    private long parseDouble(Tokenizer tokenizer, String str, boolean z, long j, long j2, long j3) throws IOException {
        Tokenizer.Token token = tokenizer.get();
        if (token.isEOL()) {
            if (z) {
                throw tokenizer.exception("Invalid LOC " + str);
            }
            tokenizer.unget();
            return j3;
        }
        String strSubstring = token.value;
        if (strSubstring.length() > 1 && strSubstring.charAt(strSubstring.length() - 1) == 'm') {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        try {
            long fixedPoint = (long) (parseFixedPoint(strSubstring) * 100.0d);
            if (fixedPoint >= j && fixedPoint <= j2) {
                return fixedPoint;
            }
            throw tokenizer.exception("Invalid LOC " + str);
        } catch (NumberFormatException unused) {
            throw tokenizer.exception("Invalid LOC " + str);
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.latitude = parsePosition(tokenizer, "latitude");
        this.longitude = parsePosition(tokenizer, "longitude");
        this.altitude = parseDouble(tokenizer, "altitude", true, -10000000L, 4284967295L, 0L) + 10000000;
        this.size = parseDouble(tokenizer, "size", false, 0L, 9000000000L, 100L);
        this.hPrecision = parseDouble(tokenizer, "horizontal precision", false, 0L, 9000000000L, 1000000L);
        this.vPrecision = parseDouble(tokenizer, "vertical precision", false, 0L, 9000000000L, 1000L);
    }

    private void renderFixedPoint(StringBuffer stringBuffer, NumberFormat numberFormat, long j, long j2) {
        stringBuffer.append(j / j2);
        long j3 = j % j2;
        if (j3 != 0) {
            stringBuffer.append(".");
            stringBuffer.append(numberFormat.format(j3));
        }
    }

    private String positionToString(long j, char c, char c2) {
        StringBuffer stringBuffer = new StringBuffer();
        long j2 = j - 2147483648L;
        if (j2 < 0) {
            j2 = -j2;
            c = c2;
        }
        stringBuffer.append(j2 / 3600000);
        long j3 = j2 % 3600000;
        stringBuffer.append(" ");
        stringBuffer.append(j3 / 60000);
        stringBuffer.append(" ");
        renderFixedPoint(stringBuffer, w3, j3 % 60000, 1000L);
        stringBuffer.append(" ");
        stringBuffer.append(c);
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(positionToString(this.latitude, 'N', 'S'));
        stringBuffer.append(" ");
        stringBuffer.append(positionToString(this.longitude, 'E', 'W'));
        stringBuffer.append(" ");
        renderFixedPoint(stringBuffer, w2, this.altitude - 10000000, 100L);
        stringBuffer.append("m ");
        renderFixedPoint(stringBuffer, w2, this.size, 100L);
        stringBuffer.append("m ");
        renderFixedPoint(stringBuffer, w2, this.hPrecision, 100L);
        stringBuffer.append("m ");
        renderFixedPoint(stringBuffer, w2, this.vPrecision, 100L);
        stringBuffer.append("m");
        return stringBuffer.toString();
    }

    public double getLatitude() {
        return (this.latitude - 2147483648L) / 3600000.0d;
    }

    public double getLongitude() {
        return (this.longitude - 2147483648L) / 3600000.0d;
    }

    public double getAltitude() {
        return (this.altitude - 10000000) / 100.0d;
    }

    public double getSize() {
        return this.size / 100.0d;
    }

    public double getHPrecision() {
        return this.hPrecision / 100.0d;
    }

    public double getVPrecision() {
        return this.vPrecision / 100.0d;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(0);
        dNSOutput.writeU8(toLOCformat(this.size));
        dNSOutput.writeU8(toLOCformat(this.hPrecision));
        dNSOutput.writeU8(toLOCformat(this.vPrecision));
        dNSOutput.writeU32(this.latitude);
        dNSOutput.writeU32(this.longitude);
        dNSOutput.writeU32(this.altitude);
    }

    private static long parseLOCformat(int i) throws WireParseException {
        long j = i >> 4;
        int i2 = i & 15;
        if (j > 9 || i2 > 9) {
            throw new WireParseException("Invalid LOC Encoding");
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return j;
            }
            j *= 10;
            i2 = i3;
        }
    }

    private int toLOCformat(long j) {
        byte b = 0;
        while (j > 9) {
            b = (byte) (b + 1);
            j /= 10;
        }
        return (int) ((j << 4) + ((long) b));
    }
}

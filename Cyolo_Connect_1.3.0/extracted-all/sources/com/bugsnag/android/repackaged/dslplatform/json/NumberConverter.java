package com.bugsnag.android.repackaged.dslplatform.json;

import com.bugsnag.android.repackaged.dslplatform.json.JsonReader;
import com.bugsnag.android.repackaged.dslplatform.json.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public abstract class NumberConverter {
    private static final BigDecimal BD_MAX_LONG;
    private static final BigDecimal BD_MIN_LONG;
    private static final byte MINUS = 45;
    private static final byte[] MIN_INT;
    private static final byte[] MIN_LONG;
    public static final short[] SHORT_EMPTY_ARRAY = new short[0];
    public static final int[] INT_EMPTY_ARRAY = new int[0];
    public static final long[] LONG_EMPTY_ARRAY = new long[0];
    public static final float[] FLOAT_EMPTY_ARRAY = new float[0];
    public static final double[] DOUBLE_EMPTY_ARRAY = new double[0];
    public static final Short SHORT_ZERO = 0;
    public static final Integer INT_ZERO = 0;
    public static final Long LONG_ZERO = 0L;
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0d);
    private static final int[] DIGITS = new int[1000];
    private static final int[] DIFF = {111, 222, 444, 888, 1776};
    private static final int[] ERROR = {50, 100, 200, 400, 800};
    private static final int[] SCALE_10 = {10000, 1000, 100, 10, 1};
    private static final double[] POW_10 = {10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d, 1.0E23d, 1.0E24d, 1.0E25d, 1.0E26d, 1.0E27d, 1.0E28d, 1.0E29d, 1.0E30d, 1.0E31d, 1.0E32d, 1.0E33d, 1.0E34d, 1.0E35d, 1.0E36d, 1.0E37d, 1.0E38d, 1.0E39d, 1.0E40d, 1.0E41d, 1.0E42d, 1.0E43d, 1.0E44d, 1.0E45d, 1.0E46d, 1.0E47d, 1.0E48d, 1.0E49d, 1.0E50d, 1.0E51d, 1.0E52d, 1.0E53d, 1.0E54d, 1.0E55d, 1.0E56d, 1.0E57d, 1.0E58d, 1.0E59d, 1.0E60d, 1.0E61d, 1.0E62d, 1.0E63d, 1.0E64d, 1.0E65d};
    public static final JsonReader.ReadObject<Double> DOUBLE_READER = new JsonReader.ReadObject<Double>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Double read(JsonReader jsonReader) throws IOException {
            return Double.valueOf(NumberConverter.deserializeDouble(jsonReader));
        }
    };
    public static final JsonReader.ReadObject<Double> NULLABLE_DOUBLE_READER = new JsonReader.ReadObject<Double>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Double read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return Double.valueOf(NumberConverter.deserializeDouble(jsonReader));
        }
    };
    public static final JsonWriter.WriteObject<Double> DOUBLE_WRITER = new JsonWriter.WriteObject<Double>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.3
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, Double d) {
            NumberConverter.serializeNullable(d, jsonWriter);
        }
    };
    public static final JsonReader.ReadObject<double[]> DOUBLE_ARRAY_READER = new JsonReader.ReadObject<double[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.4
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public double[] read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            if (jsonReader.last() != 91) {
                throw jsonReader.newParseError("Expecting '[' for double array start");
            }
            jsonReader.getNextToken();
            return NumberConverter.deserializeDoubleArray(jsonReader);
        }
    };
    public static final JsonWriter.WriteObject<double[]> DOUBLE_ARRAY_WRITER = new JsonWriter.WriteObject<double[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.5
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, double[] dArr) {
            NumberConverter.serialize(dArr, jsonWriter);
        }
    };
    public static final JsonReader.ReadObject<Float> FLOAT_READER = new JsonReader.ReadObject<Float>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.6
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Float read(JsonReader jsonReader) throws IOException {
            return Float.valueOf(NumberConverter.deserializeFloat(jsonReader));
        }
    };
    public static final JsonReader.ReadObject<Float> NULLABLE_FLOAT_READER = new JsonReader.ReadObject<Float>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.7
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Float read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return Float.valueOf(NumberConverter.deserializeFloat(jsonReader));
        }
    };
    public static final JsonWriter.WriteObject<Float> FLOAT_WRITER = new JsonWriter.WriteObject<Float>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.8
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, Float f) {
            NumberConverter.serializeNullable(f, jsonWriter);
        }
    };
    public static final JsonReader.ReadObject<float[]> FLOAT_ARRAY_READER = new JsonReader.ReadObject<float[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.9
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public float[] read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            if (jsonReader.last() != 91) {
                throw jsonReader.newParseError("Expecting '[' for float array start");
            }
            jsonReader.getNextToken();
            return NumberConverter.deserializeFloatArray(jsonReader);
        }
    };
    public static final JsonWriter.WriteObject<float[]> FLOAT_ARRAY_WRITER = new JsonWriter.WriteObject<float[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.10
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, float[] fArr) {
            NumberConverter.serialize(fArr, jsonWriter);
        }
    };
    public static final JsonReader.ReadObject<Integer> INT_READER = new JsonReader.ReadObject<Integer>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.11
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Integer read(JsonReader jsonReader) throws IOException {
            return Integer.valueOf(NumberConverter.deserializeInt(jsonReader));
        }
    };
    public static final JsonReader.ReadObject<Integer> NULLABLE_INT_READER = new JsonReader.ReadObject<Integer>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.12
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Integer read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return Integer.valueOf(NumberConverter.deserializeInt(jsonReader));
        }
    };
    public static final JsonWriter.WriteObject<Integer> INT_WRITER = new JsonWriter.WriteObject<Integer>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.13
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, Integer num) {
            NumberConverter.serializeNullable(num, jsonWriter);
        }
    };
    public static final JsonReader.ReadObject<int[]> INT_ARRAY_READER = new JsonReader.ReadObject<int[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.14
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public int[] read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            if (jsonReader.last() != 91) {
                throw jsonReader.newParseError("Expecting '[' for int array start");
            }
            jsonReader.getNextToken();
            return NumberConverter.deserializeIntArray(jsonReader);
        }
    };
    public static final JsonWriter.WriteObject<int[]> INT_ARRAY_WRITER = new JsonWriter.WriteObject<int[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.15
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, int[] iArr) {
            NumberConverter.serialize(iArr, jsonWriter);
        }
    };
    public static final JsonReader.ReadObject<Short> SHORT_READER = new JsonReader.ReadObject<Short>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.16
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Short read(JsonReader jsonReader) throws IOException {
            return Short.valueOf(NumberConverter.deserializeShort(jsonReader));
        }
    };
    public static final JsonReader.ReadObject<Short> NULLABLE_SHORT_READER = new JsonReader.ReadObject<Short>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.17
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Short read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return Short.valueOf(NumberConverter.deserializeShort(jsonReader));
        }
    };
    public static final JsonWriter.WriteObject<Short> SHORT_WRITER = new JsonWriter.WriteObject<Short>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.18
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, Short sh) {
            if (sh == null) {
                jsonWriter.writeNull();
            } else {
                NumberConverter.serialize(sh.intValue(), jsonWriter);
            }
        }
    };
    public static final JsonReader.ReadObject<short[]> SHORT_ARRAY_READER = new JsonReader.ReadObject<short[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.19
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public short[] read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            if (jsonReader.last() != 91) {
                throw jsonReader.newParseError("Expecting '[' for short array start");
            }
            jsonReader.getNextToken();
            return NumberConverter.deserializeShortArray(jsonReader);
        }
    };
    public static final JsonWriter.WriteObject<short[]> SHORT_ARRAY_WRITER = new JsonWriter.WriteObject<short[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.20
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, short[] sArr) {
            NumberConverter.serialize(sArr, jsonWriter);
        }
    };
    public static final JsonReader.ReadObject<Long> LONG_READER = new JsonReader.ReadObject<Long>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.21
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Long read(JsonReader jsonReader) throws IOException {
            return Long.valueOf(NumberConverter.deserializeLong(jsonReader));
        }
    };
    public static final JsonReader.ReadObject<Long> NULLABLE_LONG_READER = new JsonReader.ReadObject<Long>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.22
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Long read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return Long.valueOf(NumberConverter.deserializeLong(jsonReader));
        }
    };
    public static final JsonWriter.WriteObject<Long> LONG_WRITER = new JsonWriter.WriteObject<Long>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.23
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, Long l) {
            NumberConverter.serializeNullable(l, jsonWriter);
        }
    };
    public static final JsonReader.ReadObject<long[]> LONG_ARRAY_READER = new JsonReader.ReadObject<long[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.24
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public long[] read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            if (jsonReader.last() != 91) {
                throw jsonReader.newParseError("Expecting '[' for long array start");
            }
            jsonReader.getNextToken();
            return NumberConverter.deserializeLongArray(jsonReader);
        }
    };
    public static final JsonWriter.WriteObject<long[]> LONG_ARRAY_WRITER = new JsonWriter.WriteObject<long[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.25
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, long[] jArr) {
            NumberConverter.serialize(jArr, jsonWriter);
        }
    };
    public static final JsonReader.ReadObject<BigDecimal> DecimalReader = new JsonReader.ReadObject<BigDecimal>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.26
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public BigDecimal read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return NumberConverter.deserializeDecimal(jsonReader);
        }
    };
    public static final JsonWriter.WriteObject<BigDecimal> DecimalWriter = new JsonWriter.WriteObject<BigDecimal>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.27
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) {
            NumberConverter.serializeNullable(bigDecimal, jsonWriter);
        }
    };
    static final JsonReader.ReadObject<Number> NumberReader = new JsonReader.ReadObject<Number>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.NumberConverter.28
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return NumberConverter.deserializeNumber(jsonReader);
        }
    };

    static {
        int i = 0;
        while (true) {
            int[] iArr = DIGITS;
            if (i < iArr.length) {
                iArr[i] = (i < 10 ? 33554432 : i < 100 ? 16777216 : 0) + (((i / 100) + 48) << 16) + ((((i / 10) % 10) + 48) << 8) + (i % 10) + 48;
                i++;
            } else {
                MIN_INT = "-2147483648".getBytes();
                MIN_LONG = "-9223372036854775808".getBytes();
                BD_MAX_LONG = BigDecimal.valueOf(Long.MAX_VALUE);
                BD_MIN_LONG = BigDecimal.valueOf(Long.MIN_VALUE);
                return;
            }
        }
    }

    static void write4(int i, byte[] bArr, int i2) {
        if (i > 9999) {
            throw new IllegalArgumentException("Only 4 digits numbers are supported. Provided: " + i);
        }
        int i3 = i / 1000;
        int i4 = DIGITS[i - (i3 * 1000)];
        bArr[i2] = (byte) (i3 + 48);
        bArr[i2 + 1] = (byte) (i4 >> 16);
        bArr[i2 + 2] = (byte) (i4 >> 8);
        bArr[i2 + 3] = (byte) i4;
    }

    static void write3(int i, byte[] bArr, int i2) {
        int i3 = DIGITS[i];
        bArr[i2] = (byte) (i3 >> 16);
        bArr[i2 + 1] = (byte) (i3 >> 8);
        bArr[i2 + 2] = (byte) i3;
    }

    static void write2(int i, byte[] bArr, int i2) {
        int i3 = DIGITS[i];
        bArr[i2] = (byte) (i3 >> 8);
        bArr[i2 + 1] = (byte) i3;
    }

    static int read2(char[] cArr, int i) {
        int i2 = cArr[i] - '0';
        return (((i2 << 3) + (i2 << 1)) + cArr[i + 1]) - 48;
    }

    static int read4(char[] cArr, int i) {
        int i2 = cArr[i + 1] - '0';
        int i3 = cArr[i + 2] - '0';
        return ((((((((cArr[i] - '0') * 1000) + (i2 << 6)) + (i2 << 5)) + (i2 << 2)) + (i3 << 3)) + (i3 << 1)) + cArr[i + 3]) - 48;
    }

    static void numberException(JsonReader jsonReader, int i, int i2, String str) throws ParsingException {
        int i3 = i2 - i;
        if (i3 > jsonReader.maxNumberDigits) {
            throw jsonReader.newParseErrorWith("Too many digits detected in number", i3, "", "Too many digits detected in number", Integer.valueOf(i2), "");
        }
        throw jsonReader.newParseErrorWith("Error parsing number", i3, "", str, null, ". Error parsing number");
    }

    static void numberException(JsonReader jsonReader, int i, int i2, String str, Object obj) throws ParsingException {
        int i3 = i2 - i;
        if (i3 > jsonReader.maxNumberDigits) {
            throw jsonReader.newParseErrorWith("Too many digits detected in number", i3, "", "Too many digits detected in number", Integer.valueOf(i2), "");
        }
        throw jsonReader.newParseErrorWith("Error parsing number", i3, "", str, obj, ". Error parsing number");
    }

    public static void serializeNullable(Double d, JsonWriter jsonWriter) {
        if (d == null) {
            jsonWriter.writeNull();
        } else {
            serialize(d.doubleValue(), jsonWriter);
        }
    }

    private static BigDecimal parseNumberGeneric(char[] cArr, int i, JsonReader jsonReader, boolean z) throws ParsingException {
        int i2;
        char c;
        int i3 = i;
        while (i3 > 0 && Character.isWhitespace(cArr[i3 - 1])) {
            i3--;
        }
        if (i3 > jsonReader.maxNumberDigits) {
            throw jsonReader.newParseErrorWith("Too many digits detected in number", i, "", "Too many digits detected in number", Integer.valueOf(i3), "");
        }
        int i4 = cArr[0] == '-' ? 1 : 0;
        if (cArr[i4] == '0' && i3 > (i2 = i4 + 1) && (c = cArr[i2]) >= '0' && c <= '9') {
            throw jsonReader.newParseErrorAt("Leading zero is not allowed. Error parsing number", i + (z ? 2 : 0));
        }
        try {
            return new BigDecimal(cArr, 0, i3);
        } catch (NumberFormatException e) {
            throw jsonReader.newParseErrorAt("Error parsing number", i + (z ? 2 : 0), e);
        }
    }

    public static void serialize(double d, JsonWriter jsonWriter) {
        jsonWriter.writeDouble(d);
    }

    public static void serialize(double[] dArr, JsonWriter jsonWriter) {
        if (dArr == null) {
            jsonWriter.writeNull();
            return;
        }
        if (dArr.length == 0) {
            jsonWriter.writeAscii(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_START);
        serialize(dArr[0], jsonWriter);
        for (int i = 1; i < dArr.length; i++) {
            jsonWriter.writeByte(JsonWriter.COMMA);
            serialize(dArr[i], jsonWriter);
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_END);
    }

    private static class NumberInfo {
        final char[] buffer;
        final int length;

        NumberInfo(char[] cArr, int i) {
            this.buffer = cArr;
            this.length = i;
        }
    }

    private static NumberInfo readLongNumber(JsonReader jsonReader, int i) throws IOException {
        int length = jsonReader.length() - i;
        char[] cArrPrepareBuffer = jsonReader.prepareBuffer(i, length);
        while (jsonReader.length() == jsonReader.getCurrentIndex() && !jsonReader.isEndOfStream()) {
            jsonReader.scanNumber();
            int currentIndex = jsonReader.getCurrentIndex();
            int i2 = length + currentIndex;
            if (i2 > jsonReader.maxNumberDigits) {
                throw jsonReader.newParseErrorFormat("Too many digits detected in number", i2, "Number of digits larger than %d. Unable to read number", Integer.valueOf(jsonReader.maxNumberDigits));
            }
            char[] cArr = new char[i2];
            System.arraycopy(cArrPrepareBuffer, 0, cArr, 0, length);
            System.arraycopy(jsonReader.prepareBuffer(0, currentIndex), 0, cArr, length, currentIndex);
            length = i2;
            cArrPrepareBuffer = cArr;
        }
        return new NumberInfo(cArrPrepareBuffer, length);
    }

    public static double deserializeDouble(JsonReader jsonReader) throws IOException {
        if (jsonReader.last() == 34) {
            return parseDoubleGeneric(jsonReader.readSimpleQuote(), (jsonReader.getCurrentIndex() - jsonReader.getCurrentIndex()) - 1, jsonReader, true);
        }
        int iScanNumber = jsonReader.scanNumber();
        int currentIndex = jsonReader.getCurrentIndex();
        byte[] bArr = jsonReader.buffer;
        if (bArr[iScanNumber] == 45) {
            return -parseDouble(bArr, jsonReader, iScanNumber, currentIndex, 1);
        }
        return parseDouble(bArr, jsonReader, iScanNumber, currentIndex, 0);
    }

    private static double parseDouble(byte[] bArr, JsonReader jsonReader, int i, int i2, int i3) throws IOException {
        byte b;
        byte b2;
        int i4;
        int i5;
        byte b3;
        int i6;
        int i7;
        byte b4;
        int i8 = (i2 - i) - i3;
        if (i8 > jsonReader.doubleLengthLimit) {
            if (i2 == jsonReader.length()) {
                NumberInfo longNumber = readLongNumber(jsonReader, i + i3);
                return parseDoubleGeneric(longNumber.buffer, longNumber.length, jsonReader, false);
            }
            return parseDoubleGeneric(jsonReader.prepareBuffer(i + i3, i8), i8, jsonReader, false);
        }
        int i9 = i + i3;
        boolean z = bArr[i9] == 48;
        int i10 = i9;
        long j = 0;
        byte b5 = 32;
        while (true) {
            b = 69;
            b2 = 101;
            if (i10 >= i2 || (b5 = bArr[i10]) == 46 || b5 == 101 || b5 == 69) {
                break;
            }
            int i11 = b5 - 48;
            if (i11 < 0 || i11 > 9) {
                if (z && i10 > i9 + 1) {
                    numberException(jsonReader, i, i2, "Leading zero is not allowed");
                }
                if (i10 > i9 && jsonReader.allWhitespace(i10, i2)) {
                    return j;
                }
                numberException(jsonReader, i, i2, "Unknown digit", Character.valueOf((char) b5));
            }
            j = (j << 3) + (j << 1) + ((long) i11);
            i10++;
        }
        if (i10 == i9) {
            numberException(jsonReader, i, i2, "Digit not found");
        } else if (z && b5 != 46 && i10 > i9 + 1) {
            numberException(jsonReader, i, i2, "Leading zero is not allowed");
        } else {
            if (i10 == i2) {
                return j;
            }
            if (b5 == 46) {
                int i12 = i10 + 1;
                if (i12 == i2) {
                    numberException(jsonReader, i, i2, "Number ends with a dot");
                }
                double d = 1.0E14d;
                if (j == 0) {
                    i4 = i12 + 15;
                    b5 = bArr[i12];
                    if (b5 == 48 && i2 > i4) {
                        return parseDoubleGeneric(jsonReader.prepareBuffer(i9, i8), i8, jsonReader, false);
                    }
                    if (b5 < 56) {
                        i5 = -1;
                        b3 = b5;
                        i6 = i4;
                        i7 = 1;
                    } else {
                        b3 = b5;
                        d = 1.0E15d;
                        i5 = 0;
                        i6 = i4;
                        i7 = 0;
                    }
                } else {
                    i4 = i9 + 16;
                    if (bArr[i9] < 56) {
                        i5 = (i12 - i4) + 14;
                        b3 = b5;
                        i6 = i4;
                        i7 = 1;
                    } else {
                        i5 = (i12 - i4) + 15;
                        b3 = b5;
                        d = 1.0E15d;
                        i6 = i4;
                        i7 = 0;
                    }
                }
                if (i6 >= i2) {
                    i6 = i2;
                }
                byte b6 = b3;
                int i13 = i12;
                while (true) {
                    if (i13 >= i6) {
                        b4 = b6;
                        break;
                    }
                    b4 = bArr[i13];
                    if (b4 == b2 || b4 == b) {
                        break;
                    }
                    int i14 = b4 - 48;
                    if (i14 < 0 || i14 > 9) {
                        if (jsonReader.allWhitespace(i13, i2)) {
                            return j / POW_10[(i13 - i12) - 1];
                        }
                        numberException(jsonReader, i, i2, "Unknown digit", Character.valueOf((char) bArr[i13]));
                    }
                    j = (j << 3) + (j << 1) + ((long) i14);
                    i13++;
                    b6 = b4;
                    b2 = 101;
                    b = 69;
                }
                if (i13 == i2) {
                    return j / POW_10[(i13 - i12) - 1];
                }
                if (b4 == 101 || b4 == 69) {
                    return doubleExponent(jsonReader, j, i13 - i12, 0.0d, bArr, i, i2, i3, i13);
                }
                if (jsonReader.doublePrecision == JsonReader.DoublePrecision.HIGH) {
                    return parseDoubleGeneric(jsonReader.prepareBuffer(i9, i8), i8, jsonReader, false);
                }
                int i15 = 0;
                int i16 = i9 + 18;
                if (i16 >= i2) {
                    i16 = i2;
                }
                int i17 = i13;
                while (i17 < i16) {
                    b4 = bArr[i17];
                    if (b4 == 101 || b4 == 69) {
                        break;
                    }
                    int i18 = b4 - 48;
                    if (i18 < 0 || i18 > 9) {
                        if (jsonReader.allWhitespace(i17, i2)) {
                            return approximateDouble(i15, j / d, (i17 - i13) - i7);
                        }
                        numberException(jsonReader, i, i2, "Unknown digit", Character.valueOf((char) bArr[i17]));
                    }
                    i15 = (i15 << 3) + (i15 << 1) + i18;
                    i17++;
                }
                double dApproximateDouble = approximateDouble(i15, j / d, (i17 - i13) - i7);
                int i19 = i17;
                while (i19 < i2 && b4 >= 48 && b4 <= 57) {
                    b4 = bArr[i19];
                    i19++;
                }
                if (b4 == 101 || b4 == 69) {
                    return doubleExponent(jsonReader, 0L, i5, dApproximateDouble, bArr, i, i2, i3, i19);
                }
                if (i5 > 0) {
                    return dApproximateDouble * POW_10[i5 - 1];
                }
                return i5 < 0 ? dApproximateDouble / POW_10[(-i5) - 1] : dApproximateDouble;
            }
            if (b5 == 101 || b5 == 69) {
                return doubleExponent(jsonReader, j, 0, 0.0d, bArr, i, i2, i3, i10);
            }
        }
        return j;
    }

    private static double approximateDouble(int i, double d, int i2) {
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        int i3 = ((int) (jDoubleToRawLongBits >> 52)) - 1022;
        return Double.longBitsToDouble(jDoubleToRawLongBits + ((long) (((i * SCALE_10[i2 + 1]) + ERROR[i3]) / DIFF[i3])));
    }

    private static double doubleExponent(JsonReader jsonReader, long j, int i, double d, byte[] bArr, int i2, int i3, int i4, int i5) throws IOException {
        int positiveInt;
        double d2;
        double d3;
        if (jsonReader.doublePrecision == JsonReader.DoublePrecision.EXACT) {
            int i6 = (i3 - i2) - i4;
            return parseDoubleGeneric(jsonReader.prepareBuffer(i2 + i4, i6), i6, jsonReader, false);
        }
        int i7 = i5 + 1;
        byte b = bArr[i7];
        if (b == 45) {
            positiveInt = parseNegativeInt(bArr, jsonReader, i7, i3);
        } else if (b == 43) {
            positiveInt = parsePositiveInt(bArr, jsonReader, i7, i3, 1);
        } else {
            positiveInt = parsePositiveInt(bArr, jsonReader, i7, i3, 0);
        }
        int i8 = positiveInt - i;
        if (d == 0.0d) {
            if (i8 == 0 || j == 0) {
                return j;
            }
            if (i8 > 0) {
                double[] dArr = POW_10;
                if (i8 < dArr.length) {
                    return j * dArr[i8 - 1];
                }
            }
            if (i8 < 0) {
                int i9 = -i8;
                double[] dArr2 = POW_10;
                if (i9 < dArr2.length) {
                    return j / dArr2[i9 - 1];
                }
            }
            if (jsonReader.doublePrecision != JsonReader.DoublePrecision.HIGH) {
                if (i8 > 0 && i8 < 300) {
                    return j * Math.pow(10.0d, i8);
                }
                if (i8 > -300 && i8 < 0) {
                    return j / Math.pow(10.0d, i8);
                }
            }
        } else {
            if (i8 == 0) {
                return j + d;
            }
            if (i8 > 0) {
                double[] dArr3 = POW_10;
                if (i8 < dArr3.length) {
                    double d4 = dArr3[i8 - 1];
                    d2 = d * d4;
                    d3 = j * d4;
                }
                return d2 + d3;
            }
            if (i8 < 0) {
                int i10 = -i8;
                double[] dArr4 = POW_10;
                if (i10 < dArr4.length) {
                    double d5 = dArr4[i10 - 1];
                    d2 = d / d5;
                    d3 = j / d5;
                    return d2 + d3;
                }
            }
            if (jsonReader.doublePrecision != JsonReader.DoublePrecision.HIGH) {
                if (i8 > 0 && i8 < 300) {
                    return j * Math.pow(10.0d, i8);
                }
                if (i8 > -300 && i8 < 0) {
                    return j / Math.pow(10.0d, i8);
                }
            }
        }
        int i11 = (i3 - i2) - i4;
        return parseDoubleGeneric(jsonReader.prepareBuffer(i2 + i4, i11), i11, jsonReader, false);
    }

    private static double parseDoubleGeneric(char[] cArr, int i, JsonReader jsonReader, boolean z) throws IOException {
        int i2;
        char c;
        int i3 = i;
        while (i3 > 0 && Character.isWhitespace(cArr[i3 - 1])) {
            i3--;
        }
        if (i3 > jsonReader.maxNumberDigits) {
            throw jsonReader.newParseErrorWith("Too many digits detected in number", i, "", "Too many digits detected in number", Integer.valueOf(i3), "");
        }
        int i4 = cArr[0] == '-' ? 1 : 0;
        if (cArr[i4] == '0' && i3 > (i2 = i4 + 1) && (c = cArr[i2]) >= '0' && c <= '9') {
            throw jsonReader.newParseErrorAt("Leading zero is not allowed. Error parsing number", i + (z ? 2 : 0));
        }
        try {
            return Double.parseDouble(new String(cArr, 0, i3));
        } catch (NumberFormatException e) {
            throw jsonReader.newParseErrorAt("Error parsing number", i + (z ? 2 : 0), e);
        }
    }

    public static ArrayList<Double> deserializeDoubleCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeCollectionCustom(DOUBLE_READER);
    }

    public static void deserializeDoubleCollection(JsonReader jsonReader, Collection<Double> collection) throws IOException {
        jsonReader.deserializeCollection(DOUBLE_READER, collection);
    }

    public static ArrayList<Double> deserializeDoubleNullableCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeNullableCollectionCustom(DOUBLE_READER);
    }

    public static void deserializeDoubleNullableCollection(JsonReader jsonReader, Collection<Double> collection) throws IOException {
        jsonReader.deserializeNullableCollection(DOUBLE_READER, collection);
    }

    public static void serializeNullable(Float f, JsonWriter jsonWriter) {
        if (f == null) {
            jsonWriter.writeNull();
        } else {
            serialize(f.floatValue(), jsonWriter);
        }
    }

    public static void serialize(float f, JsonWriter jsonWriter) {
        if (f == Float.POSITIVE_INFINITY) {
            jsonWriter.writeAscii("\"Infinity\"");
            return;
        }
        if (f == Float.NEGATIVE_INFINITY) {
            jsonWriter.writeAscii("\"-Infinity\"");
        } else if (f != f) {
            jsonWriter.writeAscii("\"NaN\"");
        } else {
            jsonWriter.writeAscii(Float.toString(f));
        }
    }

    public static void serialize(float[] fArr, JsonWriter jsonWriter) {
        if (fArr == null) {
            jsonWriter.writeNull();
            return;
        }
        if (fArr.length == 0) {
            jsonWriter.writeAscii(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_START);
        serialize(fArr[0], jsonWriter);
        for (int i = 1; i < fArr.length; i++) {
            jsonWriter.writeByte(JsonWriter.COMMA);
            serialize(fArr[i], jsonWriter);
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_END);
    }

    public static float deserializeFloat(JsonReader jsonReader) throws IOException {
        if (jsonReader.last() == 34) {
            return parseFloatGeneric(jsonReader.readSimpleQuote(), (jsonReader.getCurrentIndex() - jsonReader.getCurrentIndex()) - 1, jsonReader, true);
        }
        int iScanNumber = jsonReader.scanNumber();
        int currentIndex = jsonReader.getCurrentIndex();
        if (currentIndex == jsonReader.length()) {
            NumberInfo longNumber = readLongNumber(jsonReader, iScanNumber);
            return parseFloatGeneric(longNumber.buffer, longNumber.length, jsonReader, false);
        }
        byte[] bArr = jsonReader.buffer;
        if (bArr[iScanNumber] == 45) {
            return -parseFloat(bArr, jsonReader, iScanNumber, currentIndex, 1);
        }
        return parseFloat(bArr, jsonReader, iScanNumber, currentIndex, 0);
    }

    private static float parseFloat(byte[] bArr, JsonReader jsonReader, int i, int i2, int i3) throws IOException {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        int i8;
        int i9 = i + i3;
        boolean z2 = bArr[i9] == 48;
        int i10 = i9;
        long j = 0;
        byte b = 32;
        while (true) {
            i4 = 9;
            if (i10 >= i2 || (b = bArr[i10]) == 46 || b == 101 || b == 69) {
                break;
            }
            int i11 = b - 48;
            if (i11 < 0 || i11 > 9) {
                if (z2 && i10 > i9 + 1) {
                    numberException(jsonReader, i, i2, "Leading zero is not allowed");
                }
                if (i10 > i9 && jsonReader.allWhitespace(i10, i2)) {
                    return j;
                }
                numberException(jsonReader, i, i2, "Unknown digit", Character.valueOf((char) b));
            }
            j = (j << 3) + (j << 1) + ((long) i11);
            i10++;
        }
        if (i10 == i9) {
            numberException(jsonReader, i, i2, "Digit not found");
        } else if (z2 && b != 46 && i10 > i9 + 1) {
            numberException(jsonReader, i, i2, "Leading zero is not allowed");
        } else {
            if (i10 > i9 + 18) {
                int i12 = (i2 - i) - i3;
                return parseFloatGeneric(jsonReader.prepareBuffer(i9, i12), i12, jsonReader, false);
            }
            if (i10 == i2) {
                return j;
            }
            if (b == 46) {
                int i13 = i10 + 1;
                if (i13 == i2) {
                    numberException(jsonReader, i, i2, "Number ends with a dot");
                }
                if (j == 0) {
                    i6 = i13 + 1;
                    while (i13 < i2 && bArr[i13] == 48) {
                        i13++;
                    }
                    i5 = i13 + 17;
                    i7 = 0;
                } else {
                    i5 = i9 + 17;
                    i6 = i13;
                    i7 = 1;
                }
                if (i5 >= i2) {
                    i5 = i2;
                }
                while (true) {
                    if (i13 >= i5) {
                        z = false;
                        break;
                    }
                    b = bArr[i13];
                    if (b == 101 || b == 69) {
                        i13++;
                        z = true;
                        break;
                    }
                    int i14 = b - 48;
                    if (i14 < 0 || i14 > i4) {
                        if (jsonReader.allWhitespace(i13, i2)) {
                            return (float) (j / POW_10[(i13 - i6) - i7]);
                        }
                        numberException(jsonReader, i, i2, "Unknown digit", Character.valueOf((char) b));
                    }
                    j = (j << 3) + (j << 1) + ((long) i14);
                    i13++;
                    i4 = 9;
                }
                if (i13 != i5 || z) {
                    i8 = i13 - i7;
                } else {
                    i8 = (i13 + 1) - i7;
                    while (i13 < i2 && b >= 48 && b <= 57) {
                        b = bArr[i13];
                        i13++;
                    }
                }
                int currentIndex = i2;
                byte[] bArr2 = bArr;
                while (i13 == currentIndex && jsonReader.length() == currentIndex) {
                    int iScanNumber = jsonReader.scanNumber();
                    currentIndex = jsonReader.getCurrentIndex();
                    byte[] bArr3 = jsonReader.buffer;
                    while (true) {
                        i13 = iScanNumber;
                        if (i13 >= currentIndex || b < 48 || b > 57) {
                            break;
                        }
                        iScanNumber = i13 + 1;
                        b = bArr3[i13];
                    }
                    bArr2 = bArr3;
                }
                if (b == 101 || b == 69) {
                    return floatExponent(jsonReader, j, i8 - i6, bArr2, currentIndex, i13);
                }
                int i15 = i8 - i6;
                if (i15 > 0) {
                    return (float) (j / POW_10[i15 - 1]);
                }
                return i15 < 0 ? (float) (j * POW_10[(-i15) - 1]) : j;
            }
            if (b == 101 || b == 69) {
                return floatExponent(jsonReader, j, 0, bArr, i2, i10 + 1);
            }
        }
        return j;
    }

    private static float floatExponent(JsonReader jsonReader, long j, int i, byte[] bArr, int i2, int i3) throws IOException {
        int positiveInt;
        byte b = bArr[i3];
        if (b == 45) {
            positiveInt = parseNegativeInt(bArr, jsonReader, i3, i2);
        } else if (b == 43) {
            positiveInt = parsePositiveInt(bArr, jsonReader, i3, i2, 1);
        } else {
            positiveInt = parsePositiveInt(bArr, jsonReader, i3, i2, 0);
        }
        int i4 = positiveInt - i;
        if (i4 == 0 || j == 0) {
            return j;
        }
        if (i4 > 0) {
            double[] dArr = POW_10;
            if (i4 < dArr.length) {
                return (float) (j * dArr[i4 - 1]);
            }
        }
        if (i4 < 0) {
            int i5 = -i4;
            double[] dArr2 = POW_10;
            if (i5 < dArr2.length) {
                return (float) (j / dArr2[i5 - 1]);
            }
        }
        return i4 > 0 ? Float.POSITIVE_INFINITY : 0.0f;
    }

    private static float parseFloatGeneric(char[] cArr, int i, JsonReader jsonReader, boolean z) throws ParsingException {
        int i2;
        char c;
        int i3 = i;
        while (i3 > 0 && Character.isWhitespace(cArr[i3 - 1])) {
            i3--;
        }
        if (i3 > jsonReader.maxNumberDigits) {
            throw jsonReader.newParseErrorWith("Too many digits detected in number", i, "", "Too many digits detected in number", Integer.valueOf(i3), "");
        }
        int i4 = cArr[0] == '-' ? 1 : 0;
        if (cArr[i4] == '0' && i3 > (i2 = i4 + 1) && (c = cArr[i2]) >= '0' && c <= '9') {
            throw jsonReader.newParseErrorAt("Leading zero is not allowed. Error parsing number", i + (z ? 2 : 0));
        }
        try {
            return Float.parseFloat(new String(cArr, 0, i3));
        } catch (NumberFormatException e) {
            throw jsonReader.newParseErrorAt("Error parsing number", i + (z ? 2 : 0), e);
        }
    }

    public static ArrayList<Float> deserializeFloatCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeCollectionCustom(FLOAT_READER);
    }

    public static void deserializeFloatCollection(JsonReader jsonReader, Collection<Float> collection) throws IOException {
        jsonReader.deserializeCollection(FLOAT_READER, collection);
    }

    public static ArrayList<Float> deserializeFloatNullableCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeNullableCollectionCustom(FLOAT_READER);
    }

    public static void deserializeFloatNullableCollection(JsonReader jsonReader, Collection<Float> collection) throws IOException {
        jsonReader.deserializeNullableCollection(FLOAT_READER, collection);
    }

    public static void serializeNullable(Integer num, JsonWriter jsonWriter) {
        if (num == null) {
            jsonWriter.writeNull();
        } else {
            serialize(num.intValue(), jsonWriter);
        }
    }

    public static void serialize(int i, JsonWriter jsonWriter) {
        byte[] bArrEnsureCapacity = jsonWriter.ensureCapacity(11);
        int size = jsonWriter.size();
        jsonWriter.advance(serialize(bArrEnsureCapacity, size, i) - size);
    }

    private static int serialize(byte[] bArr, int i, int i2) {
        int iWriteFirstBuf;
        if (i2 < 0) {
            if (i2 == Integer.MIN_VALUE) {
                int i3 = 0;
                while (true) {
                    byte[] bArr2 = MIN_INT;
                    if (i3 < bArr2.length) {
                        bArr[i + i3] = bArr2[i3];
                        i3++;
                    } else {
                        return i + bArr2.length;
                    }
                }
            } else {
                i2 = -i2;
                bArr[i] = MINUS;
                i++;
            }
        }
        int i4 = i2 / 1000;
        if (i4 == 0) {
            return i + writeFirstBuf(bArr, DIGITS[i2], i);
        }
        int i5 = i2 - (i4 * 1000);
        int i6 = i4 / 1000;
        if (i6 == 0) {
            int[] iArr = DIGITS;
            int i7 = iArr[i5];
            int iWriteFirstBuf2 = writeFirstBuf(bArr, iArr[i4], i);
            writeBuf(bArr, i7, i + iWriteFirstBuf2);
            return i + 3 + iWriteFirstBuf2;
        }
        int i8 = i6 / 1000;
        int[] iArr2 = DIGITS;
        int i9 = iArr2[i5];
        int i10 = iArr2[i4 - (i6 * 1000)];
        if (i8 == 0) {
            iWriteFirstBuf = i + writeFirstBuf(bArr, iArr2[i6], i);
        } else {
            int i11 = i + 1;
            bArr[i] = (byte) (i8 + 48);
            writeBuf(bArr, iArr2[i6 - (i8 * 1000)], i11);
            iWriteFirstBuf = i11 + 3;
        }
        writeBuf(bArr, i10, iWriteFirstBuf);
        writeBuf(bArr, i9, iWriteFirstBuf + 3);
        return iWriteFirstBuf + 6;
    }

    public static void serialize(int[] iArr, JsonWriter jsonWriter) {
        if (iArr == null) {
            jsonWriter.writeNull();
            return;
        }
        if (iArr.length == 0) {
            jsonWriter.writeAscii(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        byte[] bArrEnsureCapacity = jsonWriter.ensureCapacity((iArr.length * 11) + 2);
        int size = jsonWriter.size();
        bArrEnsureCapacity[size] = JsonWriter.ARRAY_START;
        int iSerialize = serialize(bArrEnsureCapacity, size + 1, iArr[0]);
        for (int i = 1; i < iArr.length; i++) {
            bArrEnsureCapacity[iSerialize] = JsonWriter.COMMA;
            iSerialize = serialize(bArrEnsureCapacity, iSerialize + 1, iArr[i]);
        }
        bArrEnsureCapacity[iSerialize] = JsonWriter.ARRAY_END;
        jsonWriter.advance((iSerialize + 1) - jsonWriter.size());
    }

    public static void serialize(short[] sArr, JsonWriter jsonWriter) {
        if (sArr == null) {
            jsonWriter.writeNull();
            return;
        }
        if (sArr.length == 0) {
            jsonWriter.writeAscii(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_START);
        serialize((int) sArr[0], jsonWriter);
        for (int i = 1; i < sArr.length; i++) {
            jsonWriter.writeByte(JsonWriter.COMMA);
            serialize((int) sArr[i], jsonWriter);
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_END);
    }

    public static short deserializeShort(JsonReader jsonReader) throws IOException {
        int positiveInt;
        if (jsonReader.last() == 34) {
            int currentIndex = jsonReader.getCurrentIndex();
            try {
                return parseNumberGeneric(jsonReader.readSimpleQuote(), (jsonReader.getCurrentIndex() - currentIndex) - 1, jsonReader, true).shortValueExact();
            } catch (ArithmeticException unused) {
                throw jsonReader.newParseErrorAt("Short overflow detected", jsonReader.getCurrentIndex() - currentIndex);
            }
        }
        int iScanNumber = jsonReader.scanNumber();
        int currentIndex2 = jsonReader.getCurrentIndex();
        byte[] bArr = jsonReader.buffer;
        if (bArr[iScanNumber] == 45) {
            positiveInt = parseNegativeInt(bArr, jsonReader, iScanNumber, currentIndex2);
        } else {
            positiveInt = parsePositiveInt(bArr, jsonReader, iScanNumber, currentIndex2, 0);
        }
        if (positiveInt < -32768 || positiveInt > 32767) {
            throw jsonReader.newParseErrorAt("Short overflow detected", jsonReader.getCurrentIndex());
        }
        return (short) positiveInt;
    }

    public static int deserializeInt(JsonReader jsonReader) throws IOException {
        int i;
        byte b;
        byte b2;
        if (jsonReader.last() == 34) {
            int currentIndex = jsonReader.getCurrentIndex();
            try {
                return parseNumberGeneric(jsonReader.readSimpleQuote(), (jsonReader.getCurrentIndex() - currentIndex) - 1, jsonReader, true).intValueExact();
            } catch (ArithmeticException unused) {
                throw jsonReader.newParseErrorAt("Integer overflow detected", jsonReader.getCurrentIndex() - currentIndex);
            }
        }
        int iScanNumber = jsonReader.scanNumber();
        int currentIndex2 = jsonReader.getCurrentIndex();
        byte[] bArr = jsonReader.buffer;
        byte b3 = bArr[iScanNumber];
        if (b3 == 45) {
            int i2 = iScanNumber + 2;
            if (currentIndex2 > i2 && bArr[iScanNumber + 1] == 48 && (b2 = bArr[i2]) >= 48 && b2 <= 57) {
                numberException(jsonReader, iScanNumber, currentIndex2, "Leading zero is not allowed");
            }
            return parseNegativeInt(bArr, jsonReader, iScanNumber, currentIndex2);
        }
        if (b3 == 48 && currentIndex2 > (i = iScanNumber + 1) && (b = bArr[i]) >= 48 && b <= 57) {
            numberException(jsonReader, iScanNumber, currentIndex2, "Leading zero is not allowed");
        }
        return parsePositiveInt(bArr, jsonReader, iScanNumber, currentIndex2, 0);
    }

    private static int parsePositiveInt(byte[] bArr, JsonReader jsonReader, int i, int i2, int i3) throws IOException {
        int i4 = i3 + i;
        if (i4 == i2) {
            numberException(jsonReader, i, i2, "Digit not found");
        }
        int i5 = 0;
        for (int i6 = i4; i6 < i2; i6++) {
            int i7 = bArr[i6] - 48;
            if (i7 < 0 || i7 > 9) {
                if (i6 > i4 && jsonReader.allWhitespace(i6, i2)) {
                    return i5;
                }
                if (i6 == i2 - 1 && bArr[i6] == 46) {
                    numberException(jsonReader, i, i2, "Number ends with a dot");
                }
                int i8 = i2 - i;
                BigDecimal numberGeneric = parseNumberGeneric(jsonReader.prepareBuffer(i, i8), i8, jsonReader, false);
                if (numberGeneric.scale() > 0) {
                    numberException(jsonReader, i, i2, "Expecting int but found decimal value", numberGeneric);
                }
                return numberGeneric.intValue();
            }
            i5 = (i5 << 3) + (i5 << 1) + i7;
            if (i5 < 0) {
                numberException(jsonReader, i, i2, "Integer overflow detected");
            }
        }
        return i5;
    }

    private static int parseNegativeInt(byte[] bArr, JsonReader jsonReader, int i, int i2) throws IOException {
        int i3 = i + 1;
        if (i3 == i2) {
            numberException(jsonReader, i, i2, "Digit not found");
        }
        int i4 = 0;
        for (int i5 = i3; i5 < i2; i5++) {
            int i6 = bArr[i5] - 48;
            if (i6 < 0 || i6 > 9) {
                if (i5 > i3 && jsonReader.allWhitespace(i5, i2)) {
                    return i4;
                }
                if (i5 == i2 - 1 && bArr[i5] == 46) {
                    numberException(jsonReader, i, i2, "Number ends with a dot");
                }
                int i7 = i2 - i;
                BigDecimal numberGeneric = parseNumberGeneric(jsonReader.prepareBuffer(i, i7), i7, jsonReader, false);
                if (numberGeneric.scale() > 0) {
                    numberException(jsonReader, i, i2, "Expecting int but found decimal value", numberGeneric);
                }
                return numberGeneric.intValue();
            }
            i4 = ((i4 << 3) + (i4 << 1)) - i6;
            if (i4 > 0) {
                numberException(jsonReader, i, i2, "Integer overflow detected");
            }
        }
        return i4;
    }

    public static ArrayList<Integer> deserializeIntCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeCollectionCustom(INT_READER);
    }

    public static int[] deserializeIntArray(JsonReader jsonReader) throws IOException {
        if (jsonReader.last() == 93) {
            return INT_EMPTY_ARRAY;
        }
        int[] iArrCopyOf = new int[4];
        iArrCopyOf[0] = deserializeInt(jsonReader);
        int i = 1;
        while (jsonReader.getNextToken() == 44) {
            jsonReader.getNextToken();
            if (i == iArrCopyOf.length) {
                iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length << 1);
            }
            iArrCopyOf[i] = deserializeInt(jsonReader);
            i++;
        }
        jsonReader.checkArrayEnd();
        return Arrays.copyOf(iArrCopyOf, i);
    }

    public static short[] deserializeShortArray(JsonReader jsonReader) throws IOException {
        if (jsonReader.last() == 93) {
            return SHORT_EMPTY_ARRAY;
        }
        short[] sArrCopyOf = new short[4];
        sArrCopyOf[0] = (short) deserializeInt(jsonReader);
        int i = 1;
        while (jsonReader.getNextToken() == 44) {
            jsonReader.getNextToken();
            if (i == sArrCopyOf.length) {
                sArrCopyOf = Arrays.copyOf(sArrCopyOf, sArrCopyOf.length << 1);
            }
            sArrCopyOf[i] = (short) deserializeInt(jsonReader);
            i++;
        }
        jsonReader.checkArrayEnd();
        return Arrays.copyOf(sArrCopyOf, i);
    }

    public static long[] deserializeLongArray(JsonReader jsonReader) throws IOException {
        if (jsonReader.last() == 93) {
            return LONG_EMPTY_ARRAY;
        }
        long[] jArrCopyOf = new long[4];
        jArrCopyOf[0] = deserializeLong(jsonReader);
        int i = 1;
        while (jsonReader.getNextToken() == 44) {
            jsonReader.getNextToken();
            if (i == jArrCopyOf.length) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, jArrCopyOf.length << 1);
            }
            jArrCopyOf[i] = deserializeLong(jsonReader);
            i++;
        }
        jsonReader.checkArrayEnd();
        return Arrays.copyOf(jArrCopyOf, i);
    }

    public static float[] deserializeFloatArray(JsonReader jsonReader) throws IOException {
        if (jsonReader.last() == 93) {
            return FLOAT_EMPTY_ARRAY;
        }
        float[] fArrCopyOf = new float[4];
        fArrCopyOf[0] = deserializeFloat(jsonReader);
        int i = 1;
        while (jsonReader.getNextToken() == 44) {
            jsonReader.getNextToken();
            if (i == fArrCopyOf.length) {
                fArrCopyOf = Arrays.copyOf(fArrCopyOf, fArrCopyOf.length << 1);
            }
            fArrCopyOf[i] = deserializeFloat(jsonReader);
            i++;
        }
        jsonReader.checkArrayEnd();
        return Arrays.copyOf(fArrCopyOf, i);
    }

    public static double[] deserializeDoubleArray(JsonReader jsonReader) throws IOException {
        if (jsonReader.last() == 93) {
            return DOUBLE_EMPTY_ARRAY;
        }
        double[] dArrCopyOf = new double[4];
        dArrCopyOf[0] = deserializeDouble(jsonReader);
        int i = 1;
        while (jsonReader.getNextToken() == 44) {
            jsonReader.getNextToken();
            if (i == dArrCopyOf.length) {
                dArrCopyOf = Arrays.copyOf(dArrCopyOf, dArrCopyOf.length << 1);
            }
            dArrCopyOf[i] = deserializeDouble(jsonReader);
            i++;
        }
        jsonReader.checkArrayEnd();
        return Arrays.copyOf(dArrCopyOf, i);
    }

    public static void deserializeShortCollection(JsonReader jsonReader, Collection<Short> collection) throws IOException {
        jsonReader.deserializeCollection(SHORT_READER, collection);
    }

    public static ArrayList<Short> deserializeShortNullableCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeNullableCollectionCustom(SHORT_READER);
    }

    public static void deserializeShortNullableCollection(JsonReader jsonReader, Collection<Short> collection) throws IOException {
        jsonReader.deserializeNullableCollection(SHORT_READER, collection);
    }

    public static void deserializeIntCollection(JsonReader jsonReader, Collection<Integer> collection) throws IOException {
        jsonReader.deserializeCollection(INT_READER, collection);
    }

    public static ArrayList<Integer> deserializeIntNullableCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeNullableCollectionCustom(INT_READER);
    }

    public static void deserializeIntNullableCollection(JsonReader jsonReader, Collection<Integer> collection) throws IOException {
        jsonReader.deserializeNullableCollection(INT_READER, collection);
    }

    public static void serializeNullable(Long l, JsonWriter jsonWriter) {
        if (l == null) {
            jsonWriter.writeNull();
        } else {
            serialize(l.longValue(), jsonWriter);
        }
    }

    private static int writeFirstBuf(byte[] bArr, int i, int i2) {
        int i3 = i >> 24;
        if (i3 == 0) {
            int i4 = i2 + 1;
            bArr[i2] = (byte) (i >> 16);
            i2 = i4 + 1;
            bArr[i4] = (byte) (i >> 8);
        } else if (i3 == 1) {
            bArr[i2] = (byte) (i >> 8);
            i2++;
        }
        bArr[i2] = (byte) i;
        return 3 - i3;
    }

    private static void writeBuf(byte[] bArr, int i, int i2) {
        bArr[i2] = (byte) (i >> 16);
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) i;
    }

    public static void serialize(long j, JsonWriter jsonWriter) {
        byte[] bArrEnsureCapacity = jsonWriter.ensureCapacity(21);
        int size = jsonWriter.size();
        jsonWriter.advance(serialize(bArrEnsureCapacity, size, j) - size);
    }

    private static int serialize(byte[] bArr, int i, long j) {
        int iWriteFirstBuf;
        if (j < 0) {
            if (j == Long.MIN_VALUE) {
                int i2 = 0;
                while (true) {
                    byte[] bArr2 = MIN_LONG;
                    if (i2 < bArr2.length) {
                        bArr[i + i2] = bArr2[i2];
                        i2++;
                    } else {
                        return i + bArr2.length;
                    }
                }
            } else {
                j = -j;
                bArr[i] = MINUS;
                i++;
            }
        }
        long j2 = j / 1000;
        if (j2 == 0) {
            return i + writeFirstBuf(bArr, DIGITS[(int) j], i);
        }
        Long.signum(j2);
        int i3 = (int) (j - (j2 * 1000));
        long j3 = j2 / 1000;
        if (j3 == 0) {
            int[] iArr = DIGITS;
            int i4 = iArr[i3];
            int iWriteFirstBuf2 = writeFirstBuf(bArr, iArr[(int) j2], i);
            writeBuf(bArr, i4, i + iWriteFirstBuf2);
            return i + 3 + iWriteFirstBuf2;
        }
        int i5 = (int) (j2 - (j3 * 1000));
        long j4 = j3 / 1000;
        if (j4 == 0) {
            int[] iArr2 = DIGITS;
            int i6 = iArr2[i3];
            int i7 = iArr2[i5];
            int iWriteFirstBuf3 = i + writeFirstBuf(bArr, iArr2[(int) j3], i);
            writeBuf(bArr, i7, iWriteFirstBuf3);
            writeBuf(bArr, i6, iWriteFirstBuf3 + 3);
            return iWriteFirstBuf3 + 6;
        }
        int i8 = (int) (j3 - (j4 * 1000));
        int i9 = (int) (j4 / 1000);
        if (i9 == 0) {
            int[] iArr3 = DIGITS;
            int i10 = iArr3[i3];
            int i11 = iArr3[i5];
            int i12 = iArr3[i8];
            int iWriteFirstBuf4 = i + writeFirstBuf(bArr, iArr3[(int) j4], i);
            writeBuf(bArr, i12, iWriteFirstBuf4);
            writeBuf(bArr, i11, iWriteFirstBuf4 + 3);
            writeBuf(bArr, i10, iWriteFirstBuf4 + 6);
            return iWriteFirstBuf4 + 9;
        }
        int i13 = (int) (j4 - ((long) (i9 * 1000)));
        int i14 = i9 / 1000;
        if (i14 == 0) {
            int[] iArr4 = DIGITS;
            int i15 = iArr4[i3];
            int i16 = iArr4[i5];
            int i17 = iArr4[i8];
            int i18 = iArr4[i13];
            int iWriteFirstBuf5 = i + writeFirstBuf(bArr, iArr4[i9], i);
            writeBuf(bArr, i18, iWriteFirstBuf5);
            writeBuf(bArr, i17, iWriteFirstBuf5 + 3);
            writeBuf(bArr, i16, iWriteFirstBuf5 + 6);
            writeBuf(bArr, i15, iWriteFirstBuf5 + 9);
            return iWriteFirstBuf5 + 12;
        }
        int i19 = i14 / 1000;
        int[] iArr5 = DIGITS;
        int i20 = iArr5[i3];
        int i21 = iArr5[i5];
        int i22 = iArr5[i8];
        int i23 = iArr5[i13];
        int i24 = iArr5[i9 - (i14 * 1000)];
        if (i19 == 0) {
            iWriteFirstBuf = i + writeFirstBuf(bArr, iArr5[i14], i);
        } else {
            int i25 = i + 1;
            bArr[i] = (byte) (i19 + 48);
            writeBuf(bArr, iArr5[i14 - (i19 * 1000)], i25);
            iWriteFirstBuf = i25 + 3;
        }
        writeBuf(bArr, i24, iWriteFirstBuf);
        writeBuf(bArr, i23, iWriteFirstBuf + 3);
        writeBuf(bArr, i22, iWriteFirstBuf + 6);
        writeBuf(bArr, i21, iWriteFirstBuf + 9);
        writeBuf(bArr, i20, iWriteFirstBuf + 12);
        return iWriteFirstBuf + 15;
    }

    public static void serialize(long[] jArr, JsonWriter jsonWriter) {
        if (jArr == null) {
            jsonWriter.writeNull();
            return;
        }
        if (jArr.length == 0) {
            jsonWriter.writeAscii(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        byte[] bArrEnsureCapacity = jsonWriter.ensureCapacity((jArr.length * 21) + 2);
        int size = jsonWriter.size();
        bArrEnsureCapacity[size] = JsonWriter.ARRAY_START;
        int iSerialize = serialize(bArrEnsureCapacity, size + 1, jArr[0]);
        for (int i = 1; i < jArr.length; i++) {
            bArrEnsureCapacity[iSerialize] = JsonWriter.COMMA;
            iSerialize = serialize(bArrEnsureCapacity, iSerialize + 1, jArr[i]);
        }
        bArrEnsureCapacity[iSerialize] = JsonWriter.ARRAY_END;
        jsonWriter.advance((iSerialize + 1) - jsonWriter.size());
    }

    public static long deserializeLong(JsonReader jsonReader) throws IOException {
        boolean z;
        if (jsonReader.last() == 34) {
            int currentIndex = jsonReader.getCurrentIndex();
            try {
                return parseNumberGeneric(jsonReader.readSimpleQuote(), (jsonReader.getCurrentIndex() - currentIndex) - 1, jsonReader, true).longValueExact();
            } catch (ArithmeticException unused) {
                throw jsonReader.newParseErrorAt("Long overflow detected", jsonReader.getCurrentIndex() - currentIndex);
            }
        }
        int iScanNumber = jsonReader.scanNumber();
        int currentIndex2 = jsonReader.getCurrentIndex();
        byte[] bArr = jsonReader.buffer;
        byte b = bArr[iScanNumber];
        char c = 3;
        int i = 9;
        byte b2 = 48;
        if (b == 45) {
            int i2 = iScanNumber + 1;
            if (i2 == currentIndex2) {
                numberException(jsonReader, iScanNumber, currentIndex2, "Digit not found");
            }
            z = bArr[i2] == 48;
            int i3 = i2;
            long j = 0;
            while (i3 < currentIndex2) {
                int i4 = bArr[i3] - 48;
                if (i4 < 0 || i4 > i) {
                    if (z && i3 > iScanNumber + 2) {
                        numberException(jsonReader, iScanNumber, currentIndex2, "Leading zero is not allowed");
                    }
                    return (i3 <= i2 || !jsonReader.allWhitespace(i3, currentIndex2)) ? parseLongGeneric(jsonReader, iScanNumber, currentIndex2) : j;
                }
                j = ((j << c) + (j << 1)) - ((long) i4);
                if (j > 0) {
                    numberException(jsonReader, iScanNumber, currentIndex2, "Long overflow detected");
                }
                i3++;
                c = 3;
                i = 9;
            }
            if (z && i3 > iScanNumber + 2) {
                numberException(jsonReader, iScanNumber, currentIndex2, "Leading zero is not allowed");
            }
            return j;
        }
        if (iScanNumber == currentIndex2) {
            numberException(jsonReader, iScanNumber, currentIndex2, "Digit not found");
        }
        z = bArr[iScanNumber] == 48;
        int i5 = iScanNumber;
        long j2 = 0;
        while (i5 < currentIndex2) {
            int i6 = bArr[i5] - b2;
            if (i6 < 0 || i6 > 9) {
                if (z && i5 > iScanNumber + 1) {
                    numberException(jsonReader, iScanNumber, currentIndex2, "Leading zero is not allowed");
                }
                return (b == 43 && i5 > iScanNumber + 1 && jsonReader.allWhitespace(i5, currentIndex2)) ? j2 : (b == 43 || i5 <= iScanNumber || !jsonReader.allWhitespace(i5, currentIndex2)) ? parseLongGeneric(jsonReader, iScanNumber, currentIndex2) : j2;
            }
            j2 = (j2 << 3) + (j2 << 1) + ((long) i6);
            if (j2 < 0) {
                numberException(jsonReader, iScanNumber, currentIndex2, "Long overflow detected");
            }
            i5++;
            b2 = 48;
        }
        if (z && i5 > iScanNumber + 1) {
            numberException(jsonReader, iScanNumber, currentIndex2, "Leading zero is not allowed");
        }
        return j2;
    }

    private static long parseLongGeneric(JsonReader jsonReader, int i, int i2) throws IOException {
        int i3 = i2 - i;
        char[] cArrPrepareBuffer = jsonReader.prepareBuffer(i, i3);
        if (i3 > 0 && cArrPrepareBuffer[i3 - 1] == '.') {
            numberException(jsonReader, i, i2, "Number ends with a dot");
        }
        BigDecimal numberGeneric = parseNumberGeneric(cArrPrepareBuffer, i3, jsonReader, false);
        if (numberGeneric.scale() > 0) {
            numberException(jsonReader, i, i2, "Expecting long, but found decimal value ", numberGeneric);
        }
        return numberGeneric.longValue();
    }

    public static ArrayList<Long> deserializeLongCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeCollectionCustom(LONG_READER);
    }

    public static void deserializeLongCollection(JsonReader jsonReader, Collection<Long> collection) throws IOException {
        jsonReader.deserializeCollection(LONG_READER, collection);
    }

    public static ArrayList<Long> deserializeLongNullableCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeNullableCollectionCustom(LONG_READER);
    }

    public static void deserializeLongNullableCollection(JsonReader jsonReader, Collection<Long> collection) throws IOException {
        jsonReader.deserializeNullableCollection(LONG_READER, collection);
    }

    public static void serializeNullable(BigDecimal bigDecimal, JsonWriter jsonWriter) {
        if (bigDecimal == null) {
            jsonWriter.writeNull();
        } else {
            jsonWriter.writeAscii(bigDecimal.toString());
        }
    }

    public static void serialize(BigDecimal bigDecimal, JsonWriter jsonWriter) {
        jsonWriter.writeAscii(bigDecimal.toString());
    }

    public static BigDecimal deserializeDecimal(JsonReader jsonReader) throws IOException {
        if (jsonReader.last() == 34) {
            return parseNumberGeneric(jsonReader.chars, jsonReader.parseString(), jsonReader, true);
        }
        int iScanNumber = jsonReader.scanNumber();
        int currentIndex = jsonReader.getCurrentIndex();
        if (currentIndex == jsonReader.length()) {
            NumberInfo longNumber = readLongNumber(jsonReader, iScanNumber);
            return parseNumberGeneric(longNumber.buffer, longNumber.length, jsonReader, false);
        }
        int i = currentIndex - iScanNumber;
        if (i > 18) {
            return parseNumberGeneric(jsonReader.prepareBuffer(iScanNumber, i), i, jsonReader, false);
        }
        byte[] bArr = jsonReader.buffer;
        if (bArr[iScanNumber] == 45) {
            return parseNegativeDecimal(bArr, jsonReader, iScanNumber, currentIndex);
        }
        return parsePositiveDecimal(bArr, jsonReader, iScanNumber, currentIndex);
    }

    private static BigDecimal parsePositiveDecimal(byte[] bArr, JsonReader jsonReader, int i, int i2) throws IOException {
        int i3;
        int positiveInt;
        int positiveInt2;
        boolean z = bArr[i] == 48;
        long j = 0;
        byte b = 32;
        int i4 = i;
        while (true) {
            i3 = 9;
            if (i4 >= i2 || (b = bArr[i4]) == 46 || b == 101 || b == 69) {
                break;
            }
            int i5 = b - 48;
            if (i5 < 0 || i5 > 9) {
                if (z && i4 > i + 1) {
                    numberException(jsonReader, i, i2, "Leading zero is not allowed");
                }
                if (i4 > i && jsonReader.allWhitespace(i4, i2)) {
                    return BigDecimal.valueOf(j);
                }
                numberException(jsonReader, i, i2, "Unknown digit", Character.valueOf((char) b));
            }
            j = (j << 3) + (j << 1) + ((long) i5);
            i4++;
        }
        if (i4 == i) {
            numberException(jsonReader, i, i2, "Digit not found");
        } else if (z && b != 46 && i4 > i + 1) {
            numberException(jsonReader, i, i2, "Leading zero is not allowed");
        } else {
            if (i4 == i2) {
                return BigDecimal.valueOf(j);
            }
            if (b == 46) {
                int i6 = i4 + 1;
                if (i6 == i2) {
                    numberException(jsonReader, i, i2, "Number ends with a dot");
                }
                int i7 = i6;
                while (i7 < i2) {
                    b = bArr[i7];
                    if (b == 101 || b == 69) {
                        break;
                    }
                    int i8 = b - 48;
                    if (i8 < 0 || i8 > i3) {
                        if (jsonReader.allWhitespace(i7, i2)) {
                            return BigDecimal.valueOf(j, i7 - i6);
                        }
                        numberException(jsonReader, i, i2, "Unknown digit", Character.valueOf((char) b));
                    }
                    j = (j << 3) + (j << 1) + ((long) i8);
                    i7++;
                    i3 = 9;
                }
                if (i7 == i2) {
                    return BigDecimal.valueOf(j, i2 - i6);
                }
                if (b == 101 || b == 69) {
                    int i9 = i7 + 1;
                    byte b2 = bArr[i9];
                    if (b2 == 45) {
                        positiveInt2 = parseNegativeInt(bArr, jsonReader, i9, i2);
                    } else if (b2 == 43) {
                        positiveInt2 = parsePositiveInt(bArr, jsonReader, i9, i2, 1);
                    } else {
                        positiveInt2 = parsePositiveInt(bArr, jsonReader, i9, i2, 0);
                    }
                    return BigDecimal.valueOf(j, (i7 - i6) - positiveInt2);
                }
                return BigDecimal.valueOf(j, i2 - i6);
            }
            if (b == 101 || b == 69) {
                int i10 = i4 + 1;
                byte b3 = bArr[i10];
                if (b3 == 45) {
                    positiveInt = parseNegativeInt(bArr, jsonReader, i10, i2);
                } else if (b3 == 43) {
                    positiveInt = parsePositiveInt(bArr, jsonReader, i10, i2, 1);
                } else {
                    positiveInt = parsePositiveInt(bArr, jsonReader, i10, i2, 0);
                }
                return BigDecimal.valueOf(j, -positiveInt);
            }
        }
        return BigDecimal.valueOf(j);
    }

    private static BigDecimal parseNegativeDecimal(byte[] bArr, JsonReader jsonReader, int i, int i2) throws IOException {
        int i3;
        int positiveInt;
        int positiveInt2;
        int i4 = i + 1;
        boolean z = bArr[i4] == 48;
        long j = 0;
        byte b = 32;
        int i5 = i4;
        while (true) {
            i3 = 9;
            if (i5 >= i2 || (b = bArr[i5]) == 46 || b == 101 || b == 69) {
                break;
            }
            int i6 = b - 48;
            if (i6 < 0 || i6 > 9) {
                if (z && i5 > i + 2) {
                    numberException(jsonReader, i, i2, "Leading zero is not allowed");
                }
                if (i5 > i4 && jsonReader.allWhitespace(i5, i2)) {
                    return BigDecimal.valueOf(j);
                }
                numberException(jsonReader, i, i2, "Unknown digit", Character.valueOf((char) b));
            }
            j = ((j << 3) + (j << 1)) - ((long) i6);
            i5++;
        }
        if (i5 == i4) {
            numberException(jsonReader, i, i2, "Digit not found");
        } else if (z && b != 46 && i5 > i + 2) {
            numberException(jsonReader, i, i2, "Leading zero is not allowed");
        } else {
            if (i5 == i2) {
                return BigDecimal.valueOf(j);
            }
            if (b == 46) {
                int i7 = i5 + 1;
                if (i7 == i2) {
                    numberException(jsonReader, i, i2, "Number ends with a dot");
                }
                int i8 = i7;
                while (i8 < i2) {
                    b = bArr[i8];
                    if (b == 101 || b == 69) {
                        break;
                    }
                    int i9 = b - 48;
                    if (i9 < 0 || i9 > i3) {
                        if (jsonReader.allWhitespace(i8, i2)) {
                            return BigDecimal.valueOf(j, i8 - i7);
                        }
                        numberException(jsonReader, i, i2, "Unknown digit", Character.valueOf((char) b));
                    }
                    j = ((j << 3) + (j << 1)) - ((long) i9);
                    i8++;
                    i3 = 9;
                }
                if (i8 == i2) {
                    return BigDecimal.valueOf(j, i2 - i7);
                }
                if (b == 101 || b == 69) {
                    int i10 = i8 + 1;
                    byte b2 = bArr[i10];
                    if (b2 == 45) {
                        positiveInt2 = parseNegativeInt(bArr, jsonReader, i10, i2);
                    } else if (b2 == 43) {
                        positiveInt2 = parsePositiveInt(bArr, jsonReader, i10, i2, 1);
                    } else {
                        positiveInt2 = parsePositiveInt(bArr, jsonReader, i10, i2, 0);
                    }
                    return BigDecimal.valueOf(j, (i8 - i7) - positiveInt2);
                }
                return BigDecimal.valueOf(j, i2 - i7);
            }
            if (b == 101 || b == 69) {
                int i11 = i5 + 1;
                byte b3 = bArr[i11];
                if (b3 == 45) {
                    positiveInt = parseNegativeInt(bArr, jsonReader, i11, i2);
                } else if (b3 == 43) {
                    positiveInt = parsePositiveInt(bArr, jsonReader, i11, i2, 1);
                } else {
                    positiveInt = parsePositiveInt(bArr, jsonReader, i11, i2, 0);
                }
                return BigDecimal.valueOf(j, -positiveInt);
            }
        }
        return BigDecimal.valueOf(j);
    }

    private static Number bigDecimalOrDouble(BigDecimal bigDecimal, JsonReader.UnknownNumberParsing unknownNumberParsing) {
        return unknownNumberParsing == JsonReader.UnknownNumberParsing.LONG_AND_BIGDECIMAL ? bigDecimal : Double.valueOf(bigDecimal.doubleValue());
    }

    private static Number tryLongFromBigDecimal(char[] cArr, int i, JsonReader jsonReader) throws IOException {
        BigDecimal numberGeneric = parseNumberGeneric(cArr, i, jsonReader, false);
        if (numberGeneric.scale() == 0 && numberGeneric.precision() <= 19) {
            if (numberGeneric.signum() == 1) {
                if (numberGeneric.compareTo(BD_MAX_LONG) <= 0) {
                    return Long.valueOf(numberGeneric.longValue());
                }
            } else if (numberGeneric.compareTo(BD_MIN_LONG) >= 0) {
                return Long.valueOf(numberGeneric.longValue());
            }
        }
        return bigDecimalOrDouble(numberGeneric, jsonReader.unknownNumbers);
    }

    public static Number deserializeNumber(JsonReader jsonReader) throws IOException {
        if (jsonReader.unknownNumbers == JsonReader.UnknownNumberParsing.BIGDECIMAL) {
            return deserializeDecimal(jsonReader);
        }
        if (jsonReader.unknownNumbers == JsonReader.UnknownNumberParsing.DOUBLE) {
            return Double.valueOf(deserializeDouble(jsonReader));
        }
        int iScanNumber = jsonReader.scanNumber();
        int currentIndex = jsonReader.getCurrentIndex();
        if (currentIndex == jsonReader.length()) {
            NumberInfo longNumber = readLongNumber(jsonReader, iScanNumber);
            return tryLongFromBigDecimal(longNumber.buffer, longNumber.length, jsonReader);
        }
        int i = currentIndex - iScanNumber;
        if (i > 18) {
            return tryLongFromBigDecimal(jsonReader.prepareBuffer(iScanNumber, i), i, jsonReader);
        }
        byte[] bArr = jsonReader.buffer;
        if (bArr[iScanNumber] == 45) {
            return parseNegativeNumber(bArr, jsonReader, iScanNumber, currentIndex);
        }
        return parsePositiveNumber(bArr, jsonReader, iScanNumber, currentIndex);
    }

    private static Number parsePositiveNumber(byte[] bArr, JsonReader jsonReader, int i, int i2) throws IOException {
        int positiveInt;
        int positiveInt2;
        boolean z = bArr[i] == 48;
        long j = 0;
        byte b = 32;
        int i3 = i;
        while (i3 < i2 && (b = bArr[i3]) != 46 && b != 101 && b != 69) {
            int i4 = b - 48;
            if (i4 < 0 || i4 > 9) {
                if (z && i3 > i + 1) {
                    numberException(jsonReader, i, i2, "Leading zero is not allowed");
                }
                if (i3 > i && jsonReader.allWhitespace(i3, i2)) {
                    return Long.valueOf(j);
                }
                int i5 = i2 - i;
                return tryLongFromBigDecimal(jsonReader.prepareBuffer(i, i5), i5, jsonReader);
            }
            j = ((long) i4) + (j << 3) + (j << 1);
            i3++;
        }
        if (i3 == i) {
            numberException(jsonReader, i, i2, "Digit not found");
        } else if (z && b != 46 && i3 > i + 1) {
            numberException(jsonReader, i, i2, "Leading zero is not allowed");
        } else {
            if (i3 == i2) {
                return Long.valueOf(j);
            }
            if (b == 46) {
                int i6 = i3 + 1;
                if (i6 == i2) {
                    numberException(jsonReader, i, i2, "Number ends with a dot");
                }
                int i7 = i6;
                while (i7 < i2) {
                    b = bArr[i7];
                    if (b == 101 || b == 69) {
                        break;
                    }
                    int i8 = b - 48;
                    if (i8 < 0 || i8 > 9) {
                        if (jsonReader.allWhitespace(i7, i2)) {
                            return BigDecimal.valueOf(j, i7 - i6);
                        }
                        int i9 = i2 - i;
                        return tryLongFromBigDecimal(jsonReader.prepareBuffer(i, i9), i9, jsonReader);
                    }
                    j = (j << 3) + (j << 1) + ((long) i8);
                    i7++;
                }
                if (i7 == i2) {
                    return bigDecimalOrDouble(BigDecimal.valueOf(j, i2 - i6), jsonReader.unknownNumbers);
                }
                if (b == 101 || b == 69) {
                    int i10 = i7 + 1;
                    byte b2 = bArr[i10];
                    if (b2 == 45) {
                        positiveInt2 = parseNegativeInt(bArr, jsonReader, i10, i2);
                    } else if (b2 == 43) {
                        positiveInt2 = parsePositiveInt(bArr, jsonReader, i10, i2, 1);
                    } else {
                        positiveInt2 = parsePositiveInt(bArr, jsonReader, i10, i2, 0);
                    }
                    return bigDecimalOrDouble(BigDecimal.valueOf(j, (i7 - i6) - positiveInt2), jsonReader.unknownNumbers);
                }
                return BigDecimal.valueOf(j, i2 - i6);
            }
            if (b == 101 || b == 69) {
                int i11 = i3 + 1;
                byte b3 = bArr[i11];
                if (b3 == 45) {
                    positiveInt = parseNegativeInt(bArr, jsonReader, i11, i2);
                } else if (b3 == 43) {
                    positiveInt = parsePositiveInt(bArr, jsonReader, i11, i2, 1);
                } else {
                    positiveInt = parsePositiveInt(bArr, jsonReader, i11, i2, 0);
                }
                return bigDecimalOrDouble(BigDecimal.valueOf(j, -positiveInt), jsonReader.unknownNumbers);
            }
        }
        return bigDecimalOrDouble(BigDecimal.valueOf(j), jsonReader.unknownNumbers);
    }

    private static Number parseNegativeNumber(byte[] bArr, JsonReader jsonReader, int i, int i2) throws IOException {
        int positiveInt;
        int positiveInt2;
        int i3 = i + 1;
        boolean z = bArr[i3] == 48;
        long j = 0;
        byte b = 32;
        int i4 = i3;
        while (i4 < i2 && (b = bArr[i4]) != 46 && b != 101 && b != 69) {
            int i5 = b - 48;
            if (i5 < 0 || i5 > 9) {
                if (z && i4 > i + 2) {
                    numberException(jsonReader, i, i2, "Leading zero is not allowed");
                }
                if (i4 > i3 && jsonReader.allWhitespace(i4, i2)) {
                    return Long.valueOf(j);
                }
                int i6 = i2 - i;
                return tryLongFromBigDecimal(jsonReader.prepareBuffer(i, i6), i6, jsonReader);
            }
            j = ((j << 3) + (j << 1)) - ((long) i5);
            i4++;
        }
        if (i4 == i3) {
            numberException(jsonReader, i, i2, "Digit not found");
        } else if (z && b != 46 && i4 > i + 2) {
            numberException(jsonReader, i, i2, "Leading zero is not allowed");
        } else {
            if (i4 == i2) {
                return Long.valueOf(j);
            }
            if (b == 46) {
                int i7 = i4 + 1;
                if (i7 == i2) {
                    numberException(jsonReader, i, i2, "Number ends with a dot");
                }
                int i8 = i7;
                while (i8 < i2) {
                    b = bArr[i8];
                    if (b == 101 || b == 69) {
                        break;
                    }
                    int i9 = b - 48;
                    if (i9 < 0 || i9 > 9) {
                        if (jsonReader.allWhitespace(i8, i2)) {
                            return BigDecimal.valueOf(j, i8 - i7);
                        }
                        int i10 = i2 - i;
                        return tryLongFromBigDecimal(jsonReader.prepareBuffer(i, i10), i10, jsonReader);
                    }
                    j = ((j << 3) + (j << 1)) - ((long) i9);
                    i8++;
                }
                if (i8 == i2) {
                    return bigDecimalOrDouble(BigDecimal.valueOf(j, i2 - i7), jsonReader.unknownNumbers);
                }
                if (b == 101 || b == 69) {
                    int i11 = i8 + 1;
                    byte b2 = bArr[i11];
                    if (b2 == 45) {
                        positiveInt2 = parseNegativeInt(bArr, jsonReader, i11, i2);
                    } else if (b2 == 43) {
                        positiveInt2 = parsePositiveInt(bArr, jsonReader, i11, i2, 1);
                    } else {
                        positiveInt2 = parsePositiveInt(bArr, jsonReader, i11, i2, 0);
                    }
                    return bigDecimalOrDouble(BigDecimal.valueOf(j, (i8 - i7) - positiveInt2), jsonReader.unknownNumbers);
                }
                return bigDecimalOrDouble(BigDecimal.valueOf(j, i2 - i7), jsonReader.unknownNumbers);
            }
            if (b == 101 || b == 69) {
                int i12 = i4 + 1;
                byte b3 = bArr[i12];
                if (b3 == 45) {
                    positiveInt = parseNegativeInt(bArr, jsonReader, i12, i2);
                } else if (b3 == 43) {
                    positiveInt = parsePositiveInt(bArr, jsonReader, i12, i2, 1);
                } else {
                    positiveInt = parsePositiveInt(bArr, jsonReader, i12, i2, 0);
                }
                return bigDecimalOrDouble(BigDecimal.valueOf(j, -positiveInt), jsonReader.unknownNumbers);
            }
        }
        return bigDecimalOrDouble(BigDecimal.valueOf(j), jsonReader.unknownNumbers);
    }

    public static ArrayList<BigDecimal> deserializeDecimalCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeCollectionCustom(DecimalReader);
    }

    public static void deserializeDecimalCollection(JsonReader jsonReader, Collection<BigDecimal> collection) throws IOException {
        jsonReader.deserializeCollection(DecimalReader, collection);
    }

    public static ArrayList<BigDecimal> deserializeDecimalNullableCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeNullableCollectionCustom(DecimalReader);
    }

    public static void deserializeDecimalNullableCollection(JsonReader jsonReader, Collection<BigDecimal> collection) throws IOException {
        jsonReader.deserializeNullableCollection(DecimalReader, collection);
    }
}

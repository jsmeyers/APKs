package com.bugsnag.android.repackaged.dslplatform.json;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Formatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public final class JsonReader<TContext> {
    private static final boolean[] WHITESPACE;
    private static final EOFException eof;
    private static final Charset utf8 = Charset.forName("UTF-8");
    protected byte[] buffer;
    private int bufferLenWithExtraSpace;
    protected char[] chars;
    public final TContext context;
    private int currentIndex;
    private long currentPosition;
    protected final int doubleLengthLimit;
    protected final DoublePrecision doublePrecision;
    private final StringBuilder error;
    private final Formatter errorFormatter;
    protected final ErrorInfo errorInfo;
    private final StringCache keyCache;
    private byte last;
    private int lastNameLen;
    private int length;
    protected final int maxNumberDigits;
    private final int maxStringBuffer;
    private int nameEnd;
    private final byte[] originalBuffer;
    private final int originalBufferLenWithExtraSpace;
    private int readLimit;
    private InputStream stream;
    private final char[] tmp;
    private int tokenStart;
    private final TypeLookup typeLookup;
    protected final UnknownNumberParsing unknownNumbers;
    private final StringCache valuesCache;

    public interface BindObject<T> {
        T bind(JsonReader jsonReader, T t) throws IOException;
    }

    public enum ErrorInfo {
        WITH_STACK_TRACE,
        DESCRIPTION_AND_POSITION,
        DESCRIPTION_ONLY,
        MINIMAL
    }

    public interface ReadJsonObject<T extends JsonObject> {
        T deserialize(JsonReader jsonReader) throws IOException;
    }

    public interface ReadObject<T> {
        T read(JsonReader jsonReader) throws IOException;
    }

    public enum UnknownNumberParsing {
        LONG_AND_BIGDECIMAL,
        LONG_AND_DOUBLE,
        BIGDECIMAL,
        DOUBLE
    }

    static {
        boolean[] zArr = new boolean[256];
        WHITESPACE = zArr;
        zArr[137] = true;
        zArr[138] = true;
        zArr[139] = true;
        zArr[140] = true;
        zArr[141] = true;
        zArr[160] = true;
        zArr[32] = true;
        zArr[97] = true;
        zArr[98] = true;
        zArr[99] = true;
        eof = new EmptyEOFException();
    }

    public enum DoublePrecision {
        EXACT(0),
        HIGH(1),
        DEFAULT(3),
        LOW(4);

        final int level;

        DoublePrecision(int i) {
            this.level = i;
        }
    }

    private JsonReader(char[] cArr, byte[] bArr, int i, TContext tcontext, StringCache stringCache, StringCache stringCache2, TypeLookup typeLookup, ErrorInfo errorInfo, DoublePrecision doublePrecision, UnknownNumberParsing unknownNumberParsing, int i2, int i3) {
        this.currentIndex = 0;
        this.currentPosition = 0L;
        this.last = (byte) 32;
        StringBuilder sb = new StringBuilder(0);
        this.error = sb;
        this.errorFormatter = new Formatter(sb);
        this.tmp = cArr;
        this.buffer = bArr;
        this.length = i;
        this.bufferLenWithExtraSpace = bArr.length - 38;
        this.context = tcontext;
        this.chars = cArr;
        this.keyCache = stringCache;
        this.valuesCache = stringCache2;
        this.typeLookup = typeLookup;
        this.errorInfo = errorInfo;
        this.doublePrecision = doublePrecision;
        this.unknownNumbers = unknownNumberParsing;
        this.maxNumberDigits = i2;
        this.maxStringBuffer = i3;
        this.doubleLengthLimit = doublePrecision.level + 15;
        this.originalBuffer = bArr;
        this.originalBufferLenWithExtraSpace = this.bufferLenWithExtraSpace;
    }

    @Deprecated
    public JsonReader(byte[] bArr, TContext tcontext) {
        this(bArr, tcontext, (StringCache) null, (StringCache) null);
    }

    @Deprecated
    public JsonReader(byte[] bArr, TContext tcontext, StringCache stringCache, StringCache stringCache2) {
        this(bArr, bArr.length, tcontext, new char[64], stringCache, stringCache2);
    }

    @Deprecated
    public JsonReader(byte[] bArr, TContext tcontext, char[] cArr) {
        this(bArr, bArr.length, tcontext, cArr);
        if (cArr == null) {
            throw new IllegalArgumentException("tmp buffer provided as null.");
        }
    }

    @Deprecated
    public JsonReader(byte[] bArr, int i, TContext tcontext) {
        this(bArr, i, tcontext, new char[64]);
    }

    @Deprecated
    public JsonReader(byte[] bArr, int i, TContext tcontext, char[] cArr) {
        this(bArr, i, tcontext, cArr, null, null);
    }

    @Deprecated
    public JsonReader(byte[] bArr, int i, TContext tcontext, char[] cArr, StringCache stringCache, StringCache stringCache2) {
        this(cArr, bArr, i, tcontext, stringCache, stringCache2, (TypeLookup) null, ErrorInfo.WITH_STACK_TRACE, DoublePrecision.DEFAULT, UnknownNumberParsing.LONG_AND_BIGDECIMAL, 512, 268435456);
        if (cArr == null) {
            throw new IllegalArgumentException("tmp buffer provided as null.");
        }
        if (i > bArr.length) {
            throw new IllegalArgumentException("length can't be longer than buffer.length");
        }
        if (i < bArr.length) {
            bArr[i] = 0;
        }
    }

    JsonReader(byte[] bArr, int i, TContext tcontext, char[] cArr, StringCache stringCache, StringCache stringCache2, TypeLookup typeLookup, ErrorInfo errorInfo, DoublePrecision doublePrecision, UnknownNumberParsing unknownNumberParsing, int i2, int i3) {
        this(cArr, bArr, i, tcontext, stringCache, stringCache2, typeLookup, errorInfo, doublePrecision, unknownNumberParsing, i2, i3);
        if (cArr == null) {
            throw new IllegalArgumentException("tmp buffer provided as null.");
        }
        if (i > bArr.length) {
            throw new IllegalArgumentException("length can't be longer than buffer.length");
        }
        if (i < bArr.length) {
            bArr[i] = 0;
        }
    }

    @Deprecated
    public final void reset(InputStream inputStream) throws IOException {
        process(inputStream);
    }

    @Deprecated
    final void reset(int i) {
        process(null, i);
    }

    final void reset() {
        this.buffer = this.originalBuffer;
        this.bufferLenWithExtraSpace = this.originalBufferLenWithExtraSpace;
        this.currentIndex = 0;
        this.length = 0;
        this.readLimit = 0;
        this.stream = null;
    }

    public final JsonReader<TContext> process(InputStream inputStream) throws IOException {
        this.currentPosition = 0L;
        this.currentIndex = 0;
        this.stream = inputStream;
        if (inputStream != null) {
            int i = this.length;
            int i2 = this.bufferLenWithExtraSpace;
            if (i >= i2) {
                i = i2;
            }
            this.readLimit = i;
            int fully = readFully(this.buffer, inputStream, 0);
            int i3 = this.bufferLenWithExtraSpace;
            if (fully < i3) {
                i3 = fully;
            }
            this.readLimit = i3;
            this.length = fully;
        }
        return this;
    }

    public final JsonReader<TContext> process(byte[] bArr, int i) {
        if (bArr != null) {
            this.buffer = bArr;
            this.bufferLenWithExtraSpace = bArr.length - 38;
        }
        if (i > this.buffer.length) {
            throw new IllegalArgumentException("length can't be longer than buffer.length");
        }
        this.currentIndex = 0;
        this.length = i;
        this.stream = null;
        this.readLimit = i;
        return this;
    }

    public final int length() {
        return this.length;
    }

    public String toString() {
        return new String(this.buffer, 0, this.length, utf8);
    }

    private static int readFully(byte[] bArr, InputStream inputStream, int i) throws IOException {
        int i2;
        while (i < bArr.length && (i2 = inputStream.read(bArr, i, bArr.length - i)) != -1) {
            i += i2;
        }
        return i;
    }

    private static class EmptyEOFException extends EOFException {
        private EmptyEOFException() {
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    boolean withStackTrace() {
        return this.errorInfo == ErrorInfo.WITH_STACK_TRACE;
    }

    public final byte read() throws IOException {
        if (this.stream != null && this.currentIndex > this.readLimit) {
            prepareNextBlock();
        }
        int i = this.currentIndex;
        if (i >= this.length) {
            throw ParsingException.create("Unexpected end of JSON input", eof, withStackTrace());
        }
        byte[] bArr = this.buffer;
        this.currentIndex = i + 1;
        byte b = bArr[i];
        this.last = b;
        return b;
    }

    private int prepareNextBlock() throws IOException {
        int i = this.length;
        int i2 = this.currentIndex;
        int i3 = i - i2;
        byte[] bArr = this.buffer;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        int fully = readFully(this.buffer, this.stream, i3);
        long j = this.currentPosition;
        int i4 = this.currentIndex;
        this.currentPosition = j + ((long) i4);
        if (fully == i3) {
            int i5 = this.length - i4;
            this.readLimit = i5;
            this.length = i5;
            this.currentIndex = 0;
        } else {
            int i6 = this.bufferLenWithExtraSpace;
            if (fully < i6) {
                i6 = fully;
            }
            this.readLimit = i6;
            this.length = fully;
            this.currentIndex = 0;
        }
        return fully;
    }

    final boolean isEndOfStream() throws IOException {
        return this.stream == null ? this.length == this.currentIndex : this.length == this.currentIndex && prepareNextBlock() == 0;
    }

    public final byte last() {
        return this.last;
    }

    public String positionDescription() {
        return positionDescription(0);
    }

    public String positionDescription(int i) {
        StringBuilder sb = new StringBuilder(60);
        positionDescription(i, sb);
        return sb.toString();
    }

    private void positionDescription(int i, StringBuilder sb) {
        sb.append("at position: ");
        sb.append(positionInStream(i));
        int i2 = this.currentIndex;
        if (i2 > i) {
            try {
                int iMin = Math.min(i2 - i, 20);
                String str = new String(this.buffer, (this.currentIndex - i) - iMin, iMin, utf8);
                sb.append(", following: `");
                sb.append(str);
                sb.append('`');
            } catch (Exception unused) {
            }
        }
        int i3 = this.currentIndex;
        int i4 = i3 - i;
        int i5 = this.readLimit;
        if (i4 < i5) {
            try {
                String str2 = new String(this.buffer, this.currentIndex - i, Math.min((i5 - i3) + i, 20), utf8);
                sb.append(", before: `");
                sb.append(str2);
                sb.append('`');
            } catch (Exception unused2) {
            }
        }
    }

    public final ParsingException newParseError(String str) {
        return newParseError(str, 0);
    }

    public final ParsingException newParseError(String str, int i) {
        if (this.errorInfo == ErrorInfo.MINIMAL) {
            return ParsingException.create(str, false);
        }
        this.error.setLength(0);
        this.error.append(str);
        this.error.append(". Found ");
        this.error.append((char) this.last);
        if (this.errorInfo == ErrorInfo.DESCRIPTION_ONLY) {
            return ParsingException.create(this.error.toString(), false);
        }
        this.error.append(" ");
        positionDescription(i, this.error);
        return ParsingException.create(this.error.toString(), withStackTrace());
    }

    public final ParsingException newParseErrorAt(String str, int i) {
        if (this.errorInfo == ErrorInfo.MINIMAL || this.errorInfo == ErrorInfo.DESCRIPTION_ONLY) {
            return ParsingException.create(str, false);
        }
        this.error.setLength(0);
        this.error.append(str);
        this.error.append(" ");
        positionDescription(i, this.error);
        return ParsingException.create(this.error.toString(), withStackTrace());
    }

    public final ParsingException newParseErrorAt(String str, int i, Exception exc) {
        if (exc == null) {
            throw new IllegalArgumentException("cause can't be null");
        }
        if (this.errorInfo == ErrorInfo.MINIMAL) {
            return ParsingException.create(str, exc, false);
        }
        this.error.setLength(0);
        String message = exc.getMessage();
        if (message != null && message.length() > 0) {
            this.error.append(message);
            if (!message.endsWith(".")) {
                this.error.append(".");
            }
            this.error.append(" ");
        }
        this.error.append(str);
        if (this.errorInfo == ErrorInfo.DESCRIPTION_ONLY) {
            return ParsingException.create(this.error.toString(), exc, false);
        }
        this.error.append(" ");
        positionDescription(i, this.error);
        return ParsingException.create(this.error.toString(), withStackTrace());
    }

    public final ParsingException newParseErrorFormat(String str, int i, String str2, Object... objArr) {
        if (this.errorInfo == ErrorInfo.MINIMAL) {
            return ParsingException.create(str, false);
        }
        this.error.setLength(0);
        this.errorFormatter.format(str2, objArr);
        if (this.errorInfo == ErrorInfo.DESCRIPTION_ONLY) {
            return ParsingException.create(this.error.toString(), false);
        }
        this.error.append(" ");
        positionDescription(i, this.error);
        return ParsingException.create(this.error.toString(), withStackTrace());
    }

    public final ParsingException newParseErrorWith(String str, Object obj) {
        return newParseErrorWith(str, 0, "", str, obj, "");
    }

    public final ParsingException newParseErrorWith(String str, int i, String str2, String str3, Object obj, String str4) {
        if (this.errorInfo == ErrorInfo.MINIMAL) {
            return ParsingException.create(str, false);
        }
        this.error.setLength(0);
        this.error.append(str2);
        this.error.append(str3);
        if (obj != null) {
            this.error.append(": '");
            this.error.append(obj.toString());
            this.error.append("'");
        }
        this.error.append(str4);
        if (this.errorInfo == ErrorInfo.DESCRIPTION_ONLY) {
            return ParsingException.create(this.error.toString(), false);
        }
        this.error.append(" ");
        positionDescription(i, this.error);
        return ParsingException.create(this.error.toString(), withStackTrace());
    }

    public final int getTokenStart() {
        return this.tokenStart;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    @Deprecated
    public final char[] readNumber() {
        char[] cArr;
        int i = this.currentIndex;
        this.tokenStart = i - 1;
        char[] cArr2 = this.tmp;
        byte b = this.last;
        cArr2[0] = (char) b;
        int i2 = 1;
        while (true) {
            cArr = this.tmp;
            if (i2 >= cArr.length || i >= this.length) {
                break;
            }
            int i3 = i + 1;
            b = this.buffer[i];
            if (b == 44 || b == 125 || b == 93) {
                break;
            }
            cArr[i2] = (char) b;
            i2++;
            i = i3;
        }
        this.currentIndex += i2 - 1;
        this.last = b;
        return cArr;
    }

    public final int scanNumber() {
        int i = this.currentIndex;
        this.tokenStart = i - 1;
        byte b = this.last;
        int i2 = 1;
        while (i < this.length) {
            int i3 = i + 1;
            b = this.buffer[i];
            if (b == 44 || b == 125 || b == 93) {
                break;
            }
            i2++;
            i = i3;
        }
        this.currentIndex += i2 - 1;
        this.last = b;
        return this.tokenStart;
    }

    final char[] prepareBuffer(int i, int i2) throws ParsingException {
        char[] cArr;
        if (i2 > this.maxNumberDigits) {
            throw newParseErrorWith("Too many digits detected in number", i2, "", "Too many digits detected in number", Integer.valueOf(i2), "");
        }
        while (true) {
            cArr = this.chars;
            if (cArr.length >= i2) {
                break;
            }
            this.chars = Arrays.copyOf(cArr, cArr.length * 2);
        }
        byte[] bArr = this.buffer;
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = (char) bArr[i + i3];
        }
        return cArr;
    }

    final boolean allWhitespace(int i, int i2) {
        byte[] bArr = this.buffer;
        while (i < i2) {
            if (!WHITESPACE[bArr[i] + 128]) {
                return false;
            }
            i++;
        }
        return true;
    }

    final int findNonWhitespace(int i) {
        byte[] bArr = this.buffer;
        for (int i2 = i - 1; i2 > 0; i2--) {
            if (!WHITESPACE[bArr[i2] + 128]) {
                return i2 + 1;
            }
        }
        return 0;
    }

    public final String readSimpleString() throws ParsingException {
        char[] cArr;
        if (this.last != 34) {
            throw newParseError("Expecting '\"' for string start");
        }
        int i = this.currentIndex;
        int i2 = 0;
        while (true) {
            try {
                cArr = this.tmp;
                if (i2 >= cArr.length) {
                    break;
                }
                int i3 = i + 1;
                byte b = this.buffer[i];
                if (b == 34) {
                    i = i3;
                    break;
                }
                int i4 = i2 + 1;
                cArr[i2] = (char) b;
                i2 = i4;
                i = i3;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw newParseErrorAt("JSON string was not closed with a double quote", 0);
            }
        }
        if (i > this.length) {
            throw newParseErrorAt("JSON string was not closed with a double quote", 0);
        }
        this.currentIndex = i;
        return new String(cArr, 0, i2);
    }

    public final char[] readSimpleQuote() throws ParsingException {
        char[] cArr;
        if (this.last != 34) {
            throw newParseError("Expecting '\"' for string start");
        }
        int i = this.currentIndex;
        this.tokenStart = i;
        int i2 = 0;
        while (true) {
            try {
                cArr = this.tmp;
                if (i2 >= cArr.length) {
                    break;
                }
                int i3 = i + 1;
                byte b = this.buffer[i];
                if (b == 34) {
                    i = i3;
                    break;
                }
                cArr[i2] = (char) b;
                i2++;
                i = i3;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw newParseErrorAt("JSON string was not closed with a double quote", 0);
            }
        }
        if (i > this.length) {
            throw newParseErrorAt("JSON string was not closed with a double quote", 0);
        }
        this.currentIndex = i;
        return cArr;
    }

    public final String readString() throws IOException {
        int string = parseString();
        StringCache stringCache = this.valuesCache;
        return stringCache == null ? new String(this.chars, 0, string) : stringCache.get(this.chars, string);
    }

    public final StringBuilder appendString(StringBuilder sb) throws IOException {
        sb.append(this.chars, 0, parseString());
        return sb;
    }

    public final StringBuffer appendString(StringBuffer stringBuffer) throws IOException {
        stringBuffer.append(this.chars, 0, parseString());
        return stringBuffer;
    }

    final int parseString() throws IOException {
        int iHexToInt;
        int iHexToInt2;
        int i = this.currentIndex;
        if (this.last != 34) {
            throw newParseError("Expecting '\"' for string start");
        }
        int i2 = this.length;
        if (i == i2) {
            throw newParseErrorAt("Premature end of JSON string", 0);
        }
        char[] cArrCopyOf = this.chars;
        int length = i2 - i;
        if (cArrCopyOf.length < length) {
            length = cArrCopyOf.length;
        }
        int i3 = i;
        int i4 = 0;
        while (i4 < length) {
            int i5 = i3 + 1;
            byte b = this.buffer[i3];
            if (b == 34) {
                this.currentIndex = i5;
                return i4;
            }
            if ((b ^ JsonWriter.ESCAPE) < 1) {
                i3 = i5;
                break;
            }
            cArrCopyOf[i4] = (char) b;
            i4++;
            i3 = i5;
        }
        if (i4 == cArrCopyOf.length) {
            char[] cArr = this.chars;
            int length2 = cArr.length * 2;
            int i6 = this.maxStringBuffer;
            if (length2 > i6) {
                throw newParseErrorWith("Maximum string buffer limit exceeded", Integer.valueOf(i6));
            }
            cArrCopyOf = Arrays.copyOf(cArr, length2);
            this.chars = cArrCopyOf;
        }
        int length3 = cArrCopyOf.length;
        int i7 = i3 - 1;
        this.currentIndex = i7;
        int i8 = i7 - i;
        while (!isEndOfStream()) {
            int i9 = read();
            if (i9 == 34) {
                return i8;
            }
            if (i9 == 92) {
                if (i8 >= length3 - 6) {
                    char[] cArr2 = this.chars;
                    int length4 = cArr2.length * 2;
                    int i10 = this.maxStringBuffer;
                    if (length4 > i10) {
                        throw newParseErrorWith("Maximum string buffer limit exceeded", Integer.valueOf(i10));
                    }
                    cArrCopyOf = Arrays.copyOf(cArr2, length4);
                    this.chars = cArrCopyOf;
                    length3 = cArrCopyOf.length;
                }
                byte[] bArr = this.buffer;
                int i11 = this.currentIndex;
                int i12 = i11 + 1;
                this.currentIndex = i12;
                byte b2 = bArr[i11];
                if (b2 == 34 || b2 == 47 || b2 == 92) {
                    i9 = b2;
                } else if (b2 == 98) {
                    i9 = 8;
                } else if (b2 == 102) {
                    i9 = 12;
                } else if (b2 == 110) {
                    i9 = 10;
                } else if (b2 == 114) {
                    i9 = 13;
                } else if (b2 == 116) {
                    i9 = 9;
                } else if (b2 == 117) {
                    this.currentIndex = i12 + 1;
                    int iHexToInt3 = hexToInt(bArr[i12]) << 12;
                    byte[] bArr2 = this.buffer;
                    int i13 = this.currentIndex;
                    this.currentIndex = i13 + 1;
                    int iHexToInt4 = iHexToInt3 + (hexToInt(bArr2[i13]) << 8);
                    byte[] bArr3 = this.buffer;
                    int i14 = this.currentIndex;
                    this.currentIndex = i14 + 1;
                    iHexToInt = iHexToInt4 + (hexToInt(bArr3[i14]) << 4);
                    byte[] bArr4 = this.buffer;
                    int i15 = this.currentIndex;
                    this.currentIndex = i15 + 1;
                    iHexToInt2 = hexToInt(bArr4[i15]);
                    i9 = iHexToInt + iHexToInt2;
                } else {
                    throw newParseErrorWith("Invalid escape combination detected", Integer.valueOf(b2));
                }
                cArrCopyOf[i8] = (char) i9;
                i8++;
            } else {
                if ((i9 & 128) != 0) {
                    if (i8 >= length3 - 4) {
                        char[] cArr3 = this.chars;
                        int length5 = cArr3.length * 2;
                        int i16 = this.maxStringBuffer;
                        if (length5 > i16) {
                            throw newParseErrorWith("Maximum string buffer limit exceeded", Integer.valueOf(i16));
                        }
                        char[] cArrCopyOf2 = Arrays.copyOf(cArr3, length5);
                        this.chars = cArrCopyOf2;
                        cArrCopyOf = cArrCopyOf2;
                        length3 = cArrCopyOf2.length;
                    }
                    byte[] bArr5 = this.buffer;
                    int i17 = this.currentIndex;
                    int i18 = i17 + 1;
                    this.currentIndex = i18;
                    byte b3 = bArr5[i17];
                    if ((i9 & 224) == 192) {
                        iHexToInt = (i9 & 31) << 6;
                        iHexToInt2 = b3 & Utf8.REPLACEMENT_BYTE;
                    } else {
                        int i19 = i18 + 1;
                        this.currentIndex = i19;
                        byte b4 = bArr5[i18];
                        if ((i9 & 240) == 224) {
                            iHexToInt = ((i9 & 15) << 12) + ((b3 & Utf8.REPLACEMENT_BYTE) << 6);
                            iHexToInt2 = b4 & Utf8.REPLACEMENT_BYTE;
                        } else {
                            this.currentIndex = i19 + 1;
                            byte b5 = bArr5[i19];
                            if ((i9 & 248) != 240) {
                                throw newParseErrorAt("Invalid unicode character detected", 0);
                            }
                            i9 = ((i9 & 7) << 18) + ((b3 & Utf8.REPLACEMENT_BYTE) << 12) + ((b4 & Utf8.REPLACEMENT_BYTE) << 6) + (b5 & Utf8.REPLACEMENT_BYTE);
                            if (i9 >= 65536) {
                                if (i9 >= 1114112) {
                                    throw newParseErrorAt("Invalid unicode character detected", 0);
                                }
                                int i20 = i9 - 65536;
                                int i21 = i8 + 1;
                                cArrCopyOf[i8] = (char) ((i20 >>> 10) + 55296);
                                i8 = i21 + 1;
                                cArrCopyOf[i21] = (char) ((i20 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                            }
                        }
                    }
                    i9 = iHexToInt + iHexToInt2;
                } else if (i8 >= length3) {
                    char[] cArr4 = this.chars;
                    int length6 = cArr4.length * 2;
                    int i22 = this.maxStringBuffer;
                    if (length6 > i22) {
                        throw newParseErrorWith("Maximum string buffer limit exceeded", Integer.valueOf(i22));
                    }
                    char[] cArrCopyOf3 = Arrays.copyOf(cArr4, length6);
                    this.chars = cArrCopyOf3;
                    cArrCopyOf = cArrCopyOf3;
                    length3 = cArrCopyOf3.length;
                }
                cArrCopyOf[i8] = (char) i9;
                i8++;
            }
        }
        throw newParseErrorAt("JSON string was not closed with a double quote", 0);
    }

    private int hexToInt(byte b) throws ParsingException {
        if (b >= 48 && b <= 57) {
            return b - 48;
        }
        if (b >= 65 && b <= 70) {
            return b - 55;
        }
        if (b < 97 || b > 102) {
            throw newParseErrorWith("Could not parse unicode escape, expected a hexadecimal digit", Byte.valueOf(b));
        }
        return b - 87;
    }

    private boolean wasWhiteSpace() {
        byte b = this.last;
        if (b != -96 && b != 32) {
            switch (b) {
                case -31:
                    int i = this.currentIndex;
                    if (i + 1 < this.length) {
                        byte[] bArr = this.buffer;
                        if (bArr[i] == -102 && bArr[i + 1] == -128) {
                            this.currentIndex = i + 2;
                            this.last = (byte) 32;
                            return true;
                        }
                    }
                    return false;
                case -30:
                    int i2 = this.currentIndex;
                    if (i2 + 1 >= this.length) {
                        return false;
                    }
                    byte[] bArr2 = this.buffer;
                    byte b2 = bArr2[i2];
                    byte b3 = bArr2[i2 + 1];
                    if (b2 == -127 && b3 == -97) {
                        this.currentIndex = i2 + 2;
                        this.last = (byte) 32;
                        return true;
                    }
                    if (b2 != -128) {
                        return false;
                    }
                    if (b3 != -88 && b3 != -87 && b3 != -81) {
                        switch (b3) {
                            case -128:
                            case -127:
                            case -126:
                            case -125:
                            case -124:
                            case -123:
                            case -122:
                            case -121:
                            case -120:
                            case -119:
                            case -118:
                                break;
                            default:
                                return false;
                        }
                    }
                    this.currentIndex = i2 + 2;
                    this.last = (byte) 32;
                    return true;
                case -29:
                    int i3 = this.currentIndex;
                    if (i3 + 1 < this.length) {
                        byte[] bArr3 = this.buffer;
                        if (bArr3[i3] == -128 && bArr3[i3 + 1] == -128) {
                            this.currentIndex = i3 + 2;
                            this.last = (byte) 32;
                            return true;
                        }
                    }
                    return false;
                default:
                    switch (b) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            break;
                        default:
                            return false;
                    }
                    break;
            }
        }
        return true;
    }

    public final byte getNextToken() throws IOException {
        read();
        if (WHITESPACE[this.last + 128]) {
            while (wasWhiteSpace()) {
                read();
            }
        }
        return this.last;
    }

    public final long positionInStream() {
        return this.currentPosition + ((long) this.currentIndex);
    }

    public final long positionInStream(int i) {
        return (this.currentPosition + ((long) this.currentIndex)) - ((long) i);
    }

    public final int fillName() throws IOException {
        int iCalcHash = calcHash();
        if (read() == 58 || (wasWhiteSpace() && getNextToken() == 58)) {
            return iCalcHash;
        }
        throw newParseError("Expecting ':' after attribute name");
    }

    public final int fillNameWeakHash() throws IOException {
        int iCalcWeakHash = calcWeakHash();
        if (read() == 58 || (wasWhiteSpace() && getNextToken() == 58)) {
            return iCalcWeakHash;
        }
        throw newParseError("Expecting ':' after attribute name");
    }

    public final int calcHash() throws IOException {
        int i;
        if (this.last != 34) {
            throw newParseError("Expecting '\"' for attribute name start");
        }
        int i2 = this.currentIndex;
        this.tokenStart = i2;
        long j = -2128831035;
        if (this.stream != null) {
            while (true) {
                i = this.readLimit;
                if (i2 >= i) {
                    break;
                }
                byte[] bArr = this.buffer;
                byte b = bArr[i2];
                if (b == 92) {
                    if (i2 == i - 1) {
                        return calcHashAndCopyName(j, i2);
                    }
                    i2++;
                    b = bArr[i2];
                } else if (b == 34) {
                    break;
                }
                i2++;
                j = (j ^ ((long) b)) * 16777619;
            }
            if (i2 >= i) {
                return calcHashAndCopyName(j, i2);
            }
            int i3 = i2 + 1;
            this.currentIndex = i3;
            this.nameEnd = i3;
        } else {
            while (true) {
                byte[] bArr2 = this.buffer;
                if (i2 >= bArr2.length) {
                    break;
                }
                int i4 = i2 + 1;
                byte b2 = bArr2[i2];
                if (b2 == 92) {
                    if (i4 == bArr2.length) {
                        throw newParseError("Expecting '\"' for attribute name end");
                    }
                    byte b3 = bArr2[i4];
                    i4++;
                    b2 = b3;
                } else if (b2 == 34) {
                    i2 = i4;
                    break;
                }
                j = (j ^ ((long) b2)) * 16777619;
                i2 = i4;
            }
            this.currentIndex = i2;
            this.nameEnd = i2;
        }
        return (int) j;
    }

    public final int calcWeakHash() throws IOException {
        int i;
        if (this.last != 34) {
            throw newParseError("Expecting '\"' for attribute name start");
        }
        int i2 = this.currentIndex;
        this.tokenStart = i2;
        int i3 = 0;
        if (this.stream != null) {
            while (true) {
                i = this.readLimit;
                if (i2 >= i) {
                    break;
                }
                byte[] bArr = this.buffer;
                byte b = bArr[i2];
                if (b == 92) {
                    if (i2 == i - 1) {
                        return calcWeakHashAndCopyName(i3, i2);
                    }
                    i2++;
                    b = bArr[i2];
                } else if (b == 34) {
                    break;
                }
                i2++;
                i3 += b;
            }
            if (i2 >= i) {
                return calcWeakHashAndCopyName(i3, i2);
            }
            int i4 = i2 + 1;
            this.currentIndex = i4;
            this.nameEnd = i4;
        } else {
            while (true) {
                byte[] bArr2 = this.buffer;
                if (i2 >= bArr2.length) {
                    break;
                }
                int i5 = i2 + 1;
                byte b2 = bArr2[i2];
                if (b2 == 92) {
                    if (i5 == bArr2.length) {
                        throw newParseError("Expecting '\"' for attribute name end");
                    }
                    byte b3 = bArr2[i5];
                    i5++;
                    b2 = b3;
                } else if (b2 == 34) {
                    i2 = i5;
                    break;
                }
                i3 += b2;
                i2 = i5;
            }
            this.currentIndex = i2;
            this.nameEnd = i2;
        }
        return i3;
    }

    public final int getLastHash() {
        long j = -2128831035;
        if (this.stream != null && this.nameEnd == -1) {
            for (int i = 0; i < this.lastNameLen; i++) {
                j = (j ^ ((long) ((byte) this.chars[i]))) * 16777619;
            }
        } else {
            int i2 = this.nameEnd - 1;
            for (int i3 = this.tokenStart; i3 < i2; i3++) {
                j = (j ^ ((long) this.buffer[i3])) * 16777619;
            }
        }
        return (int) j;
    }

    private int calcHashAndCopyName(long j, int i) throws IOException {
        int i2 = i - this.tokenStart;
        long j2 = this.currentPosition - ((long) i2);
        while (true) {
            char[] cArr = this.chars;
            if (cArr.length >= i2) {
                break;
            }
            this.chars = Arrays.copyOf(cArr, cArr.length * 2);
        }
        int i3 = 0;
        while (i3 < i2) {
            this.chars[i3] = (char) this.buffer[this.tokenStart + i3];
            i3++;
        }
        this.currentIndex = i;
        while (true) {
            byte b = read();
            if (b == 92) {
                b = read();
            } else if (b == 34) {
                this.nameEnd = -1;
                this.lastNameLen = i3;
                return (int) j;
            }
            char[] cArr2 = this.chars;
            if (i3 == cArr2.length) {
                this.chars = Arrays.copyOf(cArr2, cArr2.length * 2);
            }
            int i4 = i3 + 1;
            this.chars[i3] = (char) b;
            j = (j ^ ((long) b)) * 16777619;
            if (isEndOfStream()) {
                throw newParseErrorAt("JSON string was not closed with a double quote", (int) j2);
            }
            i3 = i4;
        }
    }

    private int calcWeakHashAndCopyName(int i, int i2) throws IOException {
        int i3 = i2 - this.tokenStart;
        long j = this.currentPosition - ((long) i3);
        while (true) {
            char[] cArr = this.chars;
            if (cArr.length >= i3) {
                break;
            }
            this.chars = Arrays.copyOf(cArr, cArr.length * 2);
        }
        int i4 = 0;
        while (i4 < i3) {
            this.chars[i4] = (char) this.buffer[this.tokenStart + i4];
            i4++;
        }
        this.currentIndex = i2;
        while (true) {
            byte b = read();
            if (b == 92) {
                b = read();
            } else if (b == 34) {
                this.nameEnd = -1;
                this.lastNameLen = i4;
                return i;
            }
            char[] cArr2 = this.chars;
            if (i4 == cArr2.length) {
                this.chars = Arrays.copyOf(cArr2, cArr2.length * 2);
            }
            int i5 = i4 + 1;
            this.chars[i4] = (char) b;
            i += b;
            if (isEndOfStream()) {
                throw newParseErrorAt("JSON string was not closed with a double quote", (int) j);
            }
            i4 = i5;
        }
    }

    public final boolean wasLastName(String str) {
        if (this.stream != null && this.nameEnd == -1) {
            if (str.length() != this.lastNameLen) {
                return false;
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != this.chars[i]) {
                    return false;
                }
            }
            return true;
        }
        if (str.length() != (this.nameEnd - this.tokenStart) - 1) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) != this.buffer[this.tokenStart + i2]) {
                return false;
            }
        }
        return true;
    }

    public final boolean wasLastName(byte[] bArr) {
        if (this.stream != null && this.nameEnd == -1) {
            if (bArr.length != this.lastNameLen) {
                return false;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != this.chars[i]) {
                    return false;
                }
            }
            return true;
        }
        if (bArr.length != (this.nameEnd - this.tokenStart) - 1) {
            return false;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] != this.buffer[this.tokenStart + i2]) {
                return false;
            }
        }
        return true;
    }

    public final String getLastName() throws IOException {
        if (this.stream != null && this.nameEnd == -1) {
            return new String(this.chars, 0, this.lastNameLen);
        }
        return new String(this.buffer, this.tokenStart, (this.nameEnd - r2) - 1, "UTF-8");
    }

    private byte skipString() throws IOException {
        byte b = read();
        boolean z = false;
        while (true) {
            if (b != 34 || z) {
                z = !z && b == 92;
                b = read();
            } else {
                return getNextToken();
            }
        }
    }

    public final byte skip() throws IOException {
        byte b;
        byte b2 = this.last;
        if (b2 == 34) {
            return skipString();
        }
        if (b2 == 123) {
            byte nextToken = getNextToken();
            if (nextToken == 125) {
                return getNextToken();
            }
            if (nextToken == 34) {
                if (skipString() != 58) {
                    throw newParseError("Expecting ':' after attribute name");
                }
                getNextToken();
                byte bSkip = skip();
                while (bSkip == 44) {
                    if (getNextToken() == 34) {
                        if (skipString() != 58) {
                            throw newParseError("Expecting ':' after attribute name");
                        }
                        getNextToken();
                        bSkip = skip();
                    } else {
                        throw newParseError("Expecting '\"' for attribute name");
                    }
                }
                if (bSkip != 125) {
                    throw newParseError("Expecting '}' for object end");
                }
                return getNextToken();
            }
            throw newParseError("Expecting '\"' for attribute name");
        }
        if (b2 == 91) {
            getNextToken();
            byte bSkip2 = skip();
            while (bSkip2 == 44) {
                getNextToken();
                bSkip2 = skip();
            }
            if (bSkip2 != 93) {
                throw newParseError("Expecting ']' for array end");
            }
            return getNextToken();
        }
        if (b2 == 110) {
            if (!wasNull()) {
                throw newParseErrorAt("Expecting 'null' for null constant", 0);
            }
            return getNextToken();
        }
        if (b2 == 116) {
            if (!wasTrue()) {
                throw newParseErrorAt("Expecting 'true' for true constant", 0);
            }
            return getNextToken();
        }
        if (b2 == 102) {
            if (!wasFalse()) {
                throw newParseErrorAt("Expecting 'false' for false constant", 0);
            }
            return getNextToken();
        }
        while (true) {
            b = this.last;
            if (b == 44 || b == 125 || b == 93) {
                break;
            }
            read();
        }
        return b;
    }

    @Deprecated
    public String readNext() throws IOException {
        int i = this.currentIndex - 1;
        skip();
        return new String(this.buffer, i, (this.currentIndex - i) - 1, "UTF-8");
    }

    public final byte[] readBase64() throws IOException {
        if (this.stream != null && Base64.findEnd(this.buffer, this.currentIndex) == this.buffer.length) {
            int string = parseString();
            byte[] bArr = new byte[string];
            for (int i = 0; i < string; i++) {
                bArr[i] = (byte) this.chars[i];
            }
            return Base64.decodeFast(bArr, 0, string);
        }
        if (this.last != 34) {
            throw newParseError("Expecting '\"' for base64 start");
        }
        int i2 = this.currentIndex;
        int iFindEnd = Base64.findEnd(this.buffer, i2);
        byte[] bArr2 = this.buffer;
        int i3 = iFindEnd + 1;
        this.currentIndex = i3;
        byte b = bArr2[iFindEnd];
        this.last = b;
        if (b != 34) {
            throw newParseError("Expecting '\"' for base64 end");
        }
        return Base64.decodeFast(bArr2, i2, i3 - 1);
    }

    public final String readKey() throws IOException {
        int string = parseString();
        StringCache stringCache = this.keyCache;
        String str = stringCache != null ? stringCache.get(this.chars, string) : new String(this.chars, 0, string);
        if (getNextToken() != 58) {
            throw newParseError("Expecting ':' after attribute name");
        }
        getNextToken();
        return str;
    }

    public final boolean wasNull() throws ParsingException {
        if (this.last != 110) {
            return false;
        }
        int i = this.currentIndex;
        if (i + 2 < this.length) {
            byte[] bArr = this.buffer;
            if (bArr[i] == 117 && bArr[i + 1] == 108 && bArr[i + 2] == 108) {
                this.currentIndex = i + 3;
                this.last = (byte) 108;
                return true;
            }
        }
        throw newParseErrorAt("Invalid null constant found", 0);
    }

    public final boolean wasTrue() throws ParsingException {
        if (this.last != 116) {
            return false;
        }
        int i = this.currentIndex;
        if (i + 2 < this.length) {
            byte[] bArr = this.buffer;
            if (bArr[i] == 114 && bArr[i + 1] == 117 && bArr[i + 2] == 101) {
                this.currentIndex = i + 3;
                this.last = (byte) 101;
                return true;
            }
        }
        throw newParseErrorAt("Invalid true constant found", 0);
    }

    public final boolean wasFalse() throws ParsingException {
        if (this.last != 102) {
            return false;
        }
        int i = this.currentIndex;
        if (i + 3 < this.length) {
            byte[] bArr = this.buffer;
            if (bArr[i] == 97 && bArr[i + 1] == 108 && bArr[i + 2] == 115 && bArr[i + 3] == 101) {
                this.currentIndex = i + 4;
                this.last = (byte) 101;
                return true;
            }
        }
        throw newParseErrorAt("Invalid false constant found", 0);
    }

    public final void comma() throws IOException {
        if (getNextToken() != 44) {
            if (this.currentIndex < this.length) {
                throw newParseError("Expecting ','");
            }
            throw newParseErrorAt("Unexpected end in JSON", 0, eof);
        }
    }

    public final void semicolon() throws IOException {
        if (getNextToken() != 58) {
            if (this.currentIndex < this.length) {
                throw newParseError("Expecting ':'");
            }
            throw newParseErrorAt("Unexpected end in JSON", 0, eof);
        }
    }

    public final void startArray() throws IOException {
        if (getNextToken() != 91) {
            if (this.currentIndex < this.length) {
                throw newParseError("Expecting '[' as array start");
            }
            throw newParseErrorAt("Unexpected end in JSON", 0, eof);
        }
    }

    public final void endArray() throws IOException {
        if (getNextToken() != 93) {
            if (this.currentIndex < this.length) {
                throw newParseError("Expecting ']' as array end");
            }
            throw newParseErrorAt("Unexpected end in JSON", 0, eof);
        }
    }

    public final void startObject() throws IOException {
        if (getNextToken() != 123) {
            if (this.currentIndex < this.length) {
                throw newParseError("Expecting '{' as object start");
            }
            throw newParseErrorAt("Unexpected end in JSON", 0, eof);
        }
    }

    public final void endObject() throws IOException {
        if (getNextToken() != 125) {
            if (this.currentIndex < this.length) {
                throw newParseError("Expecting '}' as object end");
            }
            throw newParseErrorAt("Unexpected end in JSON", 0, eof);
        }
    }

    public final void startAttribute(String str) throws IOException {
        while (getNextToken() == 34) {
            fillNameWeakHash();
            if (wasLastName(str)) {
                return;
            }
            getNextToken();
            if (skip() != 44) {
                throw newParseErrorWith("Unable to find attribute", str);
            }
        }
        throw newParseError("Expecting '\"' as attribute start");
    }

    public final void checkArrayEnd() throws IOException {
        if (this.last != 93) {
            if (this.currentIndex < this.length) {
                throw newParseError("Expecting ']' as array end");
            }
            throw newParseErrorAt("Unexpected end of JSON in collection", 0, eof);
        }
    }

    public final void checkObjectEnd() throws IOException {
        if (this.last != 125) {
            if (this.currentIndex < this.length) {
                throw newParseError("Expecting '}' as object end");
            }
            throw newParseErrorAt("Unexpected end of JSON in object", 0, eof);
        }
    }

    private Object readNull(Class<?> cls) throws IOException {
        if (!wasNull()) {
            throw newParseErrorAt("Expecting 'null' as null constant", 0);
        }
        if (!cls.isPrimitive()) {
            return null;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (cls == Boolean.TYPE) {
            return false;
        }
        return cls == Character.TYPE ? (char) 0 : null;
    }

    public final <T> T next(Class<T> cls) throws IOException {
        if (cls == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (this.typeLookup == null) {
            throw new ConfigurationException("typeLookup is not defined for this JsonReader. Unable to lookup specified type " + cls);
        }
        if (getNextToken() == 110) {
            return (T) readNull(cls);
        }
        ReadObject<T> readObjectTryFindReader = this.typeLookup.tryFindReader(cls);
        if (readObjectTryFindReader == null) {
            throw new ConfigurationException("Reader not found for " + cls + ". Check if reader was registered");
        }
        return readObjectTryFindReader.read(this);
    }

    public final <T> T next(ReadObject<T> readObject) throws IOException {
        if (readObject == null) {
            throw new IllegalArgumentException("reader can't be null");
        }
        if (getNextToken() == 110) {
            if (wasNull()) {
                return null;
            }
            throw newParseErrorAt("Expecting 'null' as null constant", 0);
        }
        return readObject.read(this);
    }

    public final <T> T next(Class<T> cls, T t) throws IOException {
        if (cls == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (t == null) {
            throw new IllegalArgumentException("instance can't be null");
        }
        if (this.typeLookup == null) {
            throw new ConfigurationException("typeLookup is not defined for this JsonReader. Unable to lookup specified type " + cls);
        }
        if (getNextToken() == 110) {
            return (T) readNull(cls);
        }
        BindObject<T> bindObjectTryFindBinder = this.typeLookup.tryFindBinder(cls);
        if (bindObjectTryFindBinder == null) {
            throw new ConfigurationException("Binder not found for " + cls + ". Check if binder was registered");
        }
        return bindObjectTryFindBinder.bind(this, t);
    }

    public final <T> T next(BindObject<T> bindObject, T t) throws IOException {
        if (bindObject == null) {
            throw new IllegalArgumentException("binder can't be null");
        }
        if (t == null) {
            throw new IllegalArgumentException("instance can't be null");
        }
        if (getNextToken() == 110) {
            if (wasNull()) {
                return null;
            }
            throw newParseErrorAt("Expecting 'null' as null constant", 0);
        }
        return bindObject.bind(this, t);
    }

    public final <T> ArrayList<T> readCollection(ReadObject<T> readObject) throws IOException {
        if (wasNull()) {
            return null;
        }
        if (this.last != 91) {
            throw newParseError("Expecting '[' as collection start");
        }
        if (getNextToken() == 93) {
            return new ArrayList<>(0);
        }
        ArrayList<T> arrayList = new ArrayList<>(4);
        arrayList.add(readObject.read(this));
        while (getNextToken() == 44) {
            getNextToken();
            arrayList.add(readObject.read(this));
        }
        checkArrayEnd();
        return arrayList;
    }

    public final <T> LinkedHashSet<T> readSet(ReadObject<T> readObject) throws IOException {
        if (wasNull()) {
            return null;
        }
        if (this.last != 91) {
            throw newParseError("Expecting '[' as set start");
        }
        if (getNextToken() == 93) {
            return new LinkedHashSet<>(0);
        }
        LinkedHashSet<T> linkedHashSet = new LinkedHashSet<>(4);
        linkedHashSet.add(readObject.read(this));
        while (getNextToken() == 44) {
            getNextToken();
            linkedHashSet.add(readObject.read(this));
        }
        checkArrayEnd();
        return linkedHashSet;
    }

    public final <K, V> LinkedHashMap<K, V> readMap(ReadObject<K> readObject, ReadObject<V> readObject2) throws IOException {
        if (wasNull()) {
            return null;
        }
        if (this.last != 123) {
            throw newParseError("Expecting '{' as map start");
        }
        if (getNextToken() == 125) {
            return new LinkedHashMap<>(0);
        }
        LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<>(4);
        K k = readObject.read(this);
        if (k == null) {
            throw newParseErrorAt("Null detected as key", 0);
        }
        if (getNextToken() != 58) {
            throw newParseError("Expecting ':' after key attribute");
        }
        getNextToken();
        linkedHashMap.put(k, readObject2.read(this));
        while (getNextToken() == 44) {
            getNextToken();
            K k2 = readObject.read(this);
            if (k2 == null) {
                throw newParseErrorAt("Null detected as key", 0);
            }
            if (getNextToken() != 58) {
                throw newParseError("Expecting ':' after key attribute");
            }
            getNextToken();
            linkedHashMap.put(k2, readObject2.read(this));
        }
        checkObjectEnd();
        return linkedHashMap;
    }

    public final <T> T[] readArray(ReadObject<T> readObject, T[] tArr) throws IOException {
        if (wasNull()) {
            return null;
        }
        if (this.last != 91) {
            throw newParseError("Expecting '[' as array start");
        }
        if (getNextToken() == 93) {
            return tArr;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(readObject.read(this));
        while (getNextToken() == 44) {
            getNextToken();
            arrayList.add(readObject.read(this));
        }
        checkArrayEnd();
        return (T[]) arrayList.toArray(tArr);
    }

    public final <T, S extends T> ArrayList<T> deserializeCollectionCustom(ReadObject<S> readObject) throws IOException {
        ArrayList<T> arrayList = new ArrayList<>(4);
        deserializeCollection(readObject, arrayList);
        return arrayList;
    }

    public final <T, S extends T> void deserializeCollection(ReadObject<S> readObject, Collection<T> collection) throws IOException {
        collection.add(readObject.read(this));
        while (getNextToken() == 44) {
            getNextToken();
            collection.add(readObject.read(this));
        }
        checkArrayEnd();
    }

    public final <T, S extends T> ArrayList<T> deserializeNullableCollectionCustom(ReadObject<S> readObject) throws IOException {
        ArrayList<T> arrayList = new ArrayList<>(4);
        deserializeNullableCollection(readObject, arrayList);
        return arrayList;
    }

    public final <T, S extends T> void deserializeNullableCollection(ReadObject<S> readObject, Collection<T> collection) throws IOException {
        if (wasNull()) {
            collection.add(null);
        } else {
            collection.add(readObject.read(this));
        }
        while (getNextToken() == 44) {
            getNextToken();
            if (wasNull()) {
                collection.add(null);
            } else {
                collection.add(readObject.read(this));
            }
        }
        checkArrayEnd();
    }

    public final <T extends JsonObject> ArrayList<T> deserializeCollection(ReadJsonObject<T> readJsonObject) throws IOException {
        ArrayList<T> arrayList = new ArrayList<>(4);
        deserializeCollection(readJsonObject, arrayList);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends JsonObject> void deserializeCollection(ReadJsonObject<T> readJsonObject, Collection<T> collection) throws IOException {
        if (this.last == 123) {
            getNextToken();
            collection.add(readJsonObject.deserialize(this));
            while (getNextToken() == 44) {
                if (getNextToken() == 123) {
                    getNextToken();
                    collection.add(readJsonObject.deserialize(this));
                } else {
                    throw newParseError("Expecting '{' as object start within a collection");
                }
            }
            checkArrayEnd();
            return;
        }
        throw newParseError("Expecting '{' as collection start");
    }

    public final <T extends JsonObject> ArrayList<T> deserializeNullableCollection(ReadJsonObject<T> readJsonObject) throws IOException {
        ArrayList<T> arrayList = new ArrayList<>(4);
        deserializeNullableCollection(readJsonObject, arrayList);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends JsonObject> void deserializeNullableCollection(ReadJsonObject<T> readJsonObject, Collection<T> collection) throws IOException {
        if (this.last == 123) {
            getNextToken();
            collection.add(readJsonObject.deserialize(this));
        } else if (wasNull()) {
            collection.add(null);
        } else {
            throw newParseError("Expecting '{' as collection start");
        }
        while (getNextToken() == 44) {
            if (getNextToken() == 123) {
                getNextToken();
                collection.add(readJsonObject.deserialize(this));
            } else if (wasNull()) {
                collection.add(null);
            } else {
                throw newParseError("Expecting '{' as object start within a collection");
            }
        }
        checkArrayEnd();
    }

    public final <T> Iterator<T> iterateOverCustom(ReadObject<T> readObject) {
        return new WithReader(readObject, this);
    }

    public final <T extends JsonObject> Iterator<T> iterateOver(ReadJsonObject<T> readJsonObject) {
        return new WithObjectReader(readJsonObject, this);
    }

    private static class WithReader<T> implements Iterator<T> {
        private boolean hasNext = true;
        private final JsonReader json;
        private final ReadObject<T> reader;

        @Override // java.util.Iterator
        public void remove() {
        }

        WithReader(ReadObject<T> readObject, JsonReader jsonReader) {
            this.reader = readObject;
            this.json = jsonReader;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public T next() {
            T t;
            try {
                if (this.json.last() == 110) {
                    if (!this.json.wasNull()) {
                        throw this.json.newParseErrorAt("Expecting 'null' as null constant", 0);
                    }
                    t = null;
                } else {
                    t = this.reader.read(this.json);
                }
                boolean z = this.json.getNextToken() == 44;
                this.hasNext = z;
                if (z) {
                    this.json.getNextToken();
                } else if (this.json.last() != 93) {
                    throw this.json.newParseError("Expecting ']' for iteration end");
                }
                return t;
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }
    }

    private static class WithObjectReader<T extends JsonObject> implements Iterator<T> {
        private boolean hasNext = true;
        private final JsonReader json;
        private final ReadJsonObject<T> reader;

        @Override // java.util.Iterator
        public void remove() {
        }

        WithObjectReader(ReadJsonObject<T> readJsonObject, JsonReader jsonReader) {
            this.reader = readJsonObject;
            this.json = jsonReader;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public T next() {
            T t;
            try {
                byte bLast = this.json.last();
                if (bLast == 110) {
                    if (!this.json.wasNull()) {
                        throw this.json.newParseErrorAt("Expecting 'null' as null constant", 0);
                    }
                    t = null;
                } else if (bLast == 123) {
                    this.json.getNextToken();
                    t = (T) this.reader.deserialize(this.json);
                } else {
                    throw this.json.newParseError("Expecting '{' for object start in iteration");
                }
                boolean z = this.json.getNextToken() == 44;
                this.hasNext = z;
                if (z) {
                    this.json.getNextToken();
                } else if (this.json.last() != 93) {
                    throw this.json.newParseError("Expecting ']' for iteration end");
                }
                return t;
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }
    }
}

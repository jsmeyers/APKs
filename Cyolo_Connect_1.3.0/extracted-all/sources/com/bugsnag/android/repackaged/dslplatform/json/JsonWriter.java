package com.bugsnag.android.repackaged.dslplatform.json;

import com.bugsnag.android.repackaged.dslplatform.json.Grisu3;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import org.kxml2.wap.Wbxml;

/* JADX INFO: loaded from: classes.dex */
public final class JsonWriter {
    public static final byte ARRAY_END = 93;
    public static final byte ARRAY_START = 91;
    public static final byte COMMA = 44;
    public static final byte ESCAPE = 92;
    public static final byte OBJECT_END = 125;
    public static final byte OBJECT_START = 123;
    public static final byte QUOTE = 34;
    public static final byte SEMI = 58;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private byte[] buffer;
    private final Grisu3.FastDtoaBuilder doubleBuilder;
    private long flushed;
    private int position;
    private OutputStream target;
    private final UnknownSerializer unknownSerializer;

    public interface WriteObject<T> {
        void write(JsonWriter jsonWriter, T t);
    }

    final byte[] ensureCapacity(int i) {
        int i2 = this.position;
        if (i2 + i >= this.buffer.length) {
            enlargeOrFlush(i2, i);
        }
        return this.buffer;
    }

    void advance(int i) {
        this.position += i;
    }

    @Deprecated
    public JsonWriter() {
        this(512, (UnknownSerializer) null);
    }

    JsonWriter(UnknownSerializer unknownSerializer) {
        this(512, unknownSerializer);
    }

    JsonWriter(int i, UnknownSerializer unknownSerializer) {
        this(new byte[i], unknownSerializer);
    }

    JsonWriter(byte[] bArr, UnknownSerializer unknownSerializer) {
        this.doubleBuilder = new Grisu3.FastDtoaBuilder();
        this.buffer = bArr;
        this.unknownSerializer = unknownSerializer;
    }

    private void enlargeOrFlush(int i, int i2) {
        OutputStream outputStream = this.target;
        if (outputStream != null) {
            try {
                outputStream.write(this.buffer, 0, i);
                this.position = 0;
                this.flushed += (long) i;
                byte[] bArr = this.buffer;
                if (i2 > bArr.length) {
                    this.buffer = Arrays.copyOf(bArr, bArr.length + (bArr.length / 2) + i2);
                    return;
                }
                return;
            } catch (IOException e) {
                throw new SerializationException("Unable to write to target stream.", e);
            }
        }
        byte[] bArr2 = this.buffer;
        this.buffer = Arrays.copyOf(bArr2, bArr2.length + (bArr2.length / 2) + i2);
    }

    public final void writeNull() {
        int i = this.position;
        if (i + 4 >= this.buffer.length) {
            enlargeOrFlush(i, 0);
        }
        int i2 = this.position;
        byte[] bArr = this.buffer;
        bArr[i2] = 110;
        bArr[i2 + 1] = 117;
        bArr[i2 + 2] = 108;
        bArr[i2 + 3] = 108;
        this.position = i2 + 4;
    }

    public final void writeByte(byte b) {
        int i = this.position;
        if (i == this.buffer.length) {
            enlargeOrFlush(i, 0);
        }
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b;
    }

    public final void writeString(String str) {
        int length = str.length();
        int i = this.position;
        int i2 = length << 2;
        int i3 = length << 1;
        if (i + i2 + i3 + 2 >= this.buffer.length) {
            enlargeOrFlush(i, i2 + i3 + 2);
        }
        byte[] bArr = this.buffer;
        int i4 = this.position;
        bArr[i4] = QUOTE;
        int i5 = i4 + 1;
        int i6 = 0;
        while (i6 < length) {
            char cCharAt = str.charAt(i6);
            if (cCharAt > 31 && cCharAt != '\"' && cCharAt != '\\' && cCharAt < '~') {
                bArr[i5] = (byte) cCharAt;
                i6++;
                i5++;
            } else {
                writeQuotedString(str, i6, i5, length);
                return;
            }
        }
        bArr[i5] = QUOTE;
        this.position = i5 + 1;
    }

    public final void writeString(CharSequence charSequence) {
        int length = charSequence.length();
        int i = this.position;
        int i2 = length << 2;
        int i3 = length << 1;
        if (i + i2 + i3 + 2 >= this.buffer.length) {
            enlargeOrFlush(i, i2 + i3 + 2);
        }
        byte[] bArr = this.buffer;
        int i4 = this.position;
        bArr[i4] = QUOTE;
        int i5 = i4 + 1;
        int i6 = 0;
        while (i6 < length) {
            char cCharAt = charSequence.charAt(i6);
            if (cCharAt > 31 && cCharAt != '\"' && cCharAt != '\\' && cCharAt < '~') {
                bArr[i5] = (byte) cCharAt;
                i6++;
                i5++;
            } else {
                writeQuotedString(charSequence, i6, i5, length);
                return;
            }
        }
        bArr[i5] = QUOTE;
        this.position = i5 + 1;
    }

    private void writeQuotedString(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        byte[] bArr = this.buffer;
        int i5 = i;
        int i6 = i2;
        while (i5 < i3) {
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt == '\"') {
                int i7 = i6 + 1;
                bArr[i6] = ESCAPE;
                i6 = i7 + 1;
                bArr[i7] = QUOTE;
            } else if (cCharAt == '\\') {
                int i8 = i6 + 1;
                bArr[i6] = ESCAPE;
                i6 = i8 + 1;
                bArr[i8] = ESCAPE;
            } else if (cCharAt >= ' ') {
                if (cCharAt < 127) {
                    i4 = i6 + 1;
                    bArr[i6] = (byte) cCharAt;
                } else {
                    int iCodePointAt = Character.codePointAt(charSequence, i5);
                    if (Character.isSupplementaryCodePoint(iCodePointAt)) {
                        i5++;
                    }
                    if (iCodePointAt == 127) {
                        i4 = i6 + 1;
                        bArr[i6] = (byte) iCodePointAt;
                    } else if (iCodePointAt <= 2047) {
                        int i9 = i6 + 1;
                        bArr[i6] = (byte) (((iCodePointAt >> 6) & 31) | Wbxml.EXT_0);
                        i6 = i9 + 1;
                        bArr[i9] = (byte) ((iCodePointAt & 63) | 128);
                    } else if (iCodePointAt < 55296 || (iCodePointAt > 57343 && iCodePointAt <= 65535)) {
                        int i10 = i6 + 1;
                        bArr[i6] = (byte) (((iCodePointAt >> 12) & 15) | 224);
                        int i11 = i10 + 1;
                        bArr[i10] = (byte) (((iCodePointAt >> 6) & 63) | 128);
                        i4 = i11 + 1;
                        bArr[i11] = (byte) ((iCodePointAt & 63) | 128);
                    } else if (iCodePointAt >= 65536 && iCodePointAt <= 1114111) {
                        int i12 = i6 + 1;
                        bArr[i6] = (byte) (((iCodePointAt >> 18) & 7) | 240);
                        int i13 = i12 + 1;
                        bArr[i12] = (byte) (((iCodePointAt >> 12) & 63) | 128);
                        int i14 = i13 + 1;
                        bArr[i13] = (byte) (((iCodePointAt >> 6) & 63) | 128);
                        i6 = i14 + 1;
                        bArr[i14] = (byte) ((iCodePointAt & 63) | 128);
                    } else {
                        throw new SerializationException("Unknown unicode codepoint in string! " + Integer.toHexString(iCodePointAt));
                    }
                }
                i6 = i4;
            } else if (cCharAt == '\b') {
                int i15 = i6 + 1;
                bArr[i6] = ESCAPE;
                i6 = i15 + 1;
                bArr[i15] = 98;
            } else if (cCharAt == '\t') {
                int i16 = i6 + 1;
                bArr[i6] = ESCAPE;
                i6 = i16 + 1;
                bArr[i16] = 116;
            } else if (cCharAt == '\n') {
                int i17 = i6 + 1;
                bArr[i6] = ESCAPE;
                i6 = i17 + 1;
                bArr[i17] = 110;
            } else if (cCharAt == '\f') {
                int i18 = i6 + 1;
                bArr[i6] = ESCAPE;
                i6 = i18 + 1;
                bArr[i18] = 102;
            } else if (cCharAt == '\r') {
                int i19 = i6 + 1;
                bArr[i6] = ESCAPE;
                i6 = i19 + 1;
                bArr[i19] = 114;
            } else {
                bArr[i6] = ESCAPE;
                bArr[i6 + 1] = 117;
                bArr[i6 + 2] = 48;
                bArr[i6 + 3] = 48;
                switch (cCharAt) {
                    case 0:
                        bArr[i6 + 4] = 48;
                        bArr[i6 + 5] = 48;
                        break;
                    case 1:
                        bArr[i6 + 4] = 48;
                        bArr[i6 + 5] = 49;
                        break;
                    case 2:
                        bArr[i6 + 4] = 48;
                        bArr[i6 + 5] = 50;
                        break;
                    case 3:
                        bArr[i6 + 4] = 48;
                        bArr[i6 + 5] = 51;
                        break;
                    case 4:
                        bArr[i6 + 4] = 48;
                        bArr[i6 + 5] = 52;
                        break;
                    case 5:
                        bArr[i6 + 4] = 48;
                        bArr[i6 + 5] = 53;
                        break;
                    case 6:
                        bArr[i6 + 4] = 48;
                        bArr[i6 + 5] = 54;
                        break;
                    case 7:
                        bArr[i6 + 4] = 48;
                        bArr[i6 + 5] = 55;
                        break;
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    default:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 70;
                        break;
                    case 11:
                        bArr[i6 + 4] = 48;
                        bArr[i6 + 5] = 66;
                        break;
                    case 14:
                        bArr[i6 + 4] = 48;
                        bArr[i6 + 5] = 69;
                        break;
                    case 15:
                        bArr[i6 + 4] = 48;
                        bArr[i6 + 5] = 70;
                        break;
                    case 16:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 48;
                        break;
                    case 17:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 49;
                        break;
                    case 18:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 50;
                        break;
                    case 19:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 51;
                        break;
                    case 20:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 52;
                        break;
                    case 21:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 53;
                        break;
                    case 22:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 54;
                        break;
                    case 23:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 55;
                        break;
                    case 24:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 56;
                        break;
                    case 25:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 57;
                        break;
                    case 26:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 65;
                        break;
                    case 27:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 66;
                        break;
                    case 28:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 67;
                        break;
                    case 29:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 68;
                        break;
                    case 30:
                        bArr[i6 + 4] = 49;
                        bArr[i6 + 5] = 69;
                        break;
                }
                i6 += 6;
            }
            i5++;
        }
        bArr[i6] = QUOTE;
        this.position = i6 + 1;
    }

    public final void writeAscii(String str) {
        int length = str.length();
        int i = this.position;
        if (i + length >= this.buffer.length) {
            enlargeOrFlush(i, length);
        }
        str.getBytes(0, length, this.buffer, this.position);
        this.position += length;
    }

    public final void writeAscii(String str, int i) {
        int i2 = this.position;
        if (i2 + i >= this.buffer.length) {
            enlargeOrFlush(i2, i);
        }
        str.getBytes(0, i, this.buffer, this.position);
        this.position += i;
    }

    public final void writeAscii(byte[] bArr) {
        int length = bArr.length;
        int i = this.position;
        if (i + length >= this.buffer.length) {
            enlargeOrFlush(i, length);
        }
        int i2 = this.position;
        byte[] bArr2 = this.buffer;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr2[i2 + i3] = bArr[i3];
        }
        this.position += length;
    }

    public final void writeAscii(byte[] bArr, int i) {
        int i2 = this.position;
        if (i2 + i >= this.buffer.length) {
            enlargeOrFlush(i2, i);
        }
        int i3 = this.position;
        byte[] bArr2 = this.buffer;
        for (int i4 = 0; i4 < i; i4++) {
            bArr2[i3 + i4] = bArr[i4];
        }
        this.position += i;
    }

    public final void writeRaw(byte[] bArr, int i, int i2) {
        int i3 = this.position;
        if (i3 + i2 >= this.buffer.length) {
            enlargeOrFlush(i3, i2);
        }
        System.arraycopy(bArr, i, this.buffer, this.position, i2);
        this.position += i2;
    }

    public final void writeBinary(byte[] bArr) {
        int i = this.position;
        if ((bArr.length << 1) + i + 2 >= this.buffer.length) {
            enlargeOrFlush(i, (bArr.length << 1) + 2);
        }
        byte[] bArr2 = this.buffer;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        bArr2[i2] = QUOTE;
        int iEncodeToBytes = i3 + Base64.encodeToBytes(bArr, bArr2, i3);
        byte[] bArr3 = this.buffer;
        this.position = iEncodeToBytes + 1;
        bArr3[iEncodeToBytes] = QUOTE;
    }

    final void writeDouble(double d) {
        if (d == Double.POSITIVE_INFINITY) {
            writeAscii("\"Infinity\"");
            return;
        }
        if (d == Double.NEGATIVE_INFINITY) {
            writeAscii("\"-Infinity\"");
            return;
        }
        if (d != d) {
            writeAscii("\"NaN\"");
            return;
        }
        if (d == 0.0d) {
            writeAscii("0.0");
            return;
        }
        if (Grisu3.tryConvert(d, this.doubleBuilder)) {
            int i = this.position;
            if (i + 24 >= this.buffer.length) {
                enlargeOrFlush(i, 24);
            }
            this.position += this.doubleBuilder.copyTo(this.buffer, this.position);
            return;
        }
        writeAscii(Double.toString(d));
    }

    public String toString() {
        return new String(this.buffer, 0, this.position, UTF_8);
    }

    public final byte[] toByteArray() {
        if (this.target != null) {
            throw new ConfigurationException("Method is not available when targeting stream");
        }
        return Arrays.copyOf(this.buffer, this.position);
    }

    public final void toStream(OutputStream outputStream) throws IOException {
        if (this.target != null) {
            throw new ConfigurationException("Method should not be used when targeting streams. Instead use flush() to copy what's remaining in the buffer");
        }
        outputStream.write(this.buffer, 0, this.position);
        this.flushed += (long) this.position;
        this.position = 0;
    }

    public final byte[] getByteBuffer() {
        return this.buffer;
    }

    public final int size() {
        return this.position;
    }

    public final long flushed() {
        return this.flushed;
    }

    public final void reset() {
        reset(null);
    }

    public final void reset(OutputStream outputStream) {
        this.position = 0;
        this.target = outputStream;
        this.flushed = 0L;
    }

    public final void flush() {
        int i;
        OutputStream outputStream = this.target;
        if (outputStream == null || (i = this.position) == 0) {
            return;
        }
        try {
            outputStream.write(this.buffer, 0, i);
            this.flushed += (long) this.position;
            this.position = 0;
        } catch (IOException e) {
            throw new SerializationException("Unable to write to target stream.", e);
        }
    }

    @Deprecated
    public void close() throws IOException {
        int i;
        OutputStream outputStream = this.target;
        if (outputStream == null || (i = this.position) == 0) {
            return;
        }
        outputStream.write(this.buffer, 0, i);
        this.position = 0;
        this.flushed = 0L;
    }

    public <T extends JsonObject> void serialize(T[] tArr) {
        writeByte(ARRAY_START);
        if (tArr.length != 0) {
            tArr[0].serialize(this, false);
            for (int i = 1; i < tArr.length; i++) {
                writeByte(COMMA);
                tArr[i].serialize(this, false);
            }
        }
        writeByte(ARRAY_END);
    }

    public <T extends JsonObject> void serialize(T[] tArr, int i) {
        writeByte(ARRAY_START);
        if (tArr.length != 0 && i != 0) {
            tArr[0].serialize(this, false);
            for (int i2 = 1; i2 < i; i2++) {
                writeByte(COMMA);
                tArr[i2].serialize(this, false);
            }
        }
        writeByte(ARRAY_END);
    }

    public <T extends JsonObject> void serialize(List<T> list) {
        writeByte(ARRAY_START);
        if (list.size() != 0) {
            list.get(0).serialize(this, false);
            for (int i = 1; i < list.size(); i++) {
                writeByte(COMMA);
                list.get(i).serialize(this, false);
            }
        }
        writeByte(ARRAY_END);
    }

    public <T> void serialize(T[] tArr, WriteObject<T> writeObject) {
        if (tArr == null) {
            writeNull();
            return;
        }
        writeByte(ARRAY_START);
        if (tArr.length != 0) {
            T t = tArr[0];
            if (t != null) {
                writeObject.write(this, t);
            } else {
                writeNull();
            }
            for (int i = 1; i < tArr.length; i++) {
                writeByte(COMMA);
                T t2 = tArr[i];
                if (t2 != null) {
                    writeObject.write(this, t2);
                } else {
                    writeNull();
                }
            }
        }
        writeByte(ARRAY_END);
    }

    public <T> void serialize(List<T> list, WriteObject<T> writeObject) {
        if (list == null) {
            writeNull();
            return;
        }
        writeByte(ARRAY_START);
        if (!list.isEmpty()) {
            if (list instanceof RandomAccess) {
                T t = list.get(0);
                if (t != null) {
                    writeObject.write(this, t);
                } else {
                    writeNull();
                }
                for (int i = 1; i < list.size(); i++) {
                    writeByte(COMMA);
                    T t2 = list.get(i);
                    if (t2 != null) {
                        writeObject.write(this, t2);
                    } else {
                        writeNull();
                    }
                }
            } else {
                Iterator<T> it = list.iterator();
                T next = it.next();
                if (next != null) {
                    writeObject.write(this, next);
                } else {
                    writeNull();
                }
                while (it.hasNext()) {
                    writeByte(COMMA);
                    T next2 = it.next();
                    if (next2 != null) {
                        writeObject.write(this, next2);
                    } else {
                        writeNull();
                    }
                }
            }
        }
        writeByte(ARRAY_END);
    }

    public void serializeRaw(List list, WriteObject writeObject) {
        serialize(list, writeObject);
    }

    public <T> void serialize(Collection<T> collection, WriteObject<T> writeObject) {
        if (collection == null) {
            writeNull();
            return;
        }
        writeByte(ARRAY_START);
        if (!collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            T next = it.next();
            if (next != null) {
                writeObject.write(this, next);
            } else {
                writeNull();
            }
            while (it.hasNext()) {
                writeByte(COMMA);
                T next2 = it.next();
                if (next2 != null) {
                    writeObject.write(this, next2);
                } else {
                    writeNull();
                }
            }
        }
        writeByte(ARRAY_END);
    }

    public void serializeRaw(Collection collection, WriteObject writeObject) {
        serialize(collection, writeObject);
    }

    public <K, V> void serialize(Map<K, V> map, WriteObject<K> writeObject, WriteObject<V> writeObject2) {
        if (map == null) {
            writeNull();
            return;
        }
        writeByte(OBJECT_START);
        int size = map.size();
        if (size > 0) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            Map.Entry<K, V> next = it.next();
            writeQuoted(writeObject, next.getKey());
            writeByte(SEMI);
            writeObject2.write(this, next.getValue());
            for (int i = 1; i < size; i++) {
                writeByte(COMMA);
                Map.Entry<K, V> next2 = it.next();
                writeQuoted(writeObject, next2.getKey());
                writeByte(SEMI);
                writeObject2.write(this, next2.getValue());
            }
        }
        writeByte(OBJECT_END);
    }

    public void serializeRaw(Map map, WriteObject writeObject, WriteObject writeObject2) {
        serialize(map, writeObject, writeObject2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void writeQuoted(WriteObject<T> writeObject, T t) {
        if (t instanceof Double) {
            double dDoubleValue = ((Double) t).doubleValue();
            if (Double.isNaN(dDoubleValue)) {
                writeAscii("\"NaN\"");
                return;
            }
            if (dDoubleValue == Double.POSITIVE_INFINITY) {
                writeAscii("\"Infinity\"");
                return;
            } else {
                if (dDoubleValue == Double.NEGATIVE_INFINITY) {
                    writeAscii("\"-Infinity\"");
                    return;
                }
                writeByte(QUOTE);
                NumberConverter.serialize(dDoubleValue, this);
                writeByte(QUOTE);
                return;
            }
        }
        if (t instanceof Float) {
            float fFloatValue = ((Float) t).floatValue();
            if (Float.isNaN(fFloatValue)) {
                writeAscii("\"NaN\"");
                return;
            }
            if (fFloatValue == Float.POSITIVE_INFINITY) {
                writeAscii("\"Infinity\"");
                return;
            } else {
                if (fFloatValue == Float.NEGATIVE_INFINITY) {
                    writeAscii("\"-Infinity\"");
                    return;
                }
                writeByte(QUOTE);
                NumberConverter.serialize(fFloatValue, this);
                writeByte(QUOTE);
                return;
            }
        }
        if (t instanceof Number) {
            writeByte(QUOTE);
            writeObject.write(this, t);
            writeByte(QUOTE);
            return;
        }
        writeObject.write(this, t);
    }

    public void serializeObject(Object obj) {
        if (obj == null) {
            writeNull();
            return;
        }
        UnknownSerializer unknownSerializer = this.unknownSerializer;
        if (unknownSerializer != null) {
            try {
                unknownSerializer.serialize(this, obj);
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        } else {
            throw new ConfigurationException("Unable to serialize: " + obj.getClass() + ".\nCheck that JsonWriter was created through DslJson#newWriter.");
        }
    }
}

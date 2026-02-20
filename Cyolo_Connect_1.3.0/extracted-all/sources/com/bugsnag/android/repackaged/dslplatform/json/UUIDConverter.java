package com.bugsnag.android.repackaged.dslplatform.json;

import com.bugsnag.android.repackaged.dslplatform.json.JsonReader;
import com.bugsnag.android.repackaged.dslplatform.json.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class UUIDConverter {
    public static final UUID MIN_UUID = new UUID(0, 0);
    public static final JsonReader.ReadObject<UUID> READER = new JsonReader.ReadObject<UUID>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.UUIDConverter.1
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public UUID read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return UUIDConverter.deserialize(jsonReader);
        }
    };
    public static final JsonWriter.WriteObject<UUID> WRITER = new JsonWriter.WriteObject<UUID>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.UUIDConverter.2
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, UUID uuid) {
            UUIDConverter.serializeNullable(uuid, jsonWriter);
        }
    };
    private static final char[] Lookup = new char[256];
    private static final byte[] Values = new byte[55];

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = (i >> 4) & 15;
            int i3 = i & 15;
            Lookup[i] = (char) (((i2 < 10 ? i2 + 48 : (i2 + 97) - 10) << 8) + (i3 < 10 ? i3 + 48 : (i3 + 97) - 10));
        }
        for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
            int i4 = c - '0';
            Values[i4] = (byte) i4;
        }
        for (char c2 = 'a'; c2 <= 'f'; c2 = (char) (c2 + 1)) {
            Values[c2 - '0'] = (byte) ((c2 - 'a') + 10);
        }
        for (char c3 = 'A'; c3 <= 'F'; c3 = (char) (c3 + 1)) {
            Values[c3 - '0'] = (byte) ((c3 - 'A') + 10);
        }
    }

    public static void serializeNullable(UUID uuid, JsonWriter jsonWriter) {
        if (uuid == null) {
            jsonWriter.writeNull();
        } else {
            serialize(uuid, jsonWriter);
        }
    }

    public static void serialize(UUID uuid, JsonWriter jsonWriter) {
        serialize(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits(), jsonWriter);
    }

    public static void serialize(long j, long j2, JsonWriter jsonWriter) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        int i3 = (int) (j2 >> 32);
        int i4 = (int) j2;
        byte[] bArrEnsureCapacity = jsonWriter.ensureCapacity(38);
        int size = jsonWriter.size();
        bArrEnsureCapacity[size] = JsonWriter.QUOTE;
        char[] cArr = Lookup;
        char c = cArr[(i >> 24) & 255];
        bArrEnsureCapacity[size + 1] = (byte) (c >> '\b');
        bArrEnsureCapacity[size + 2] = (byte) c;
        char c2 = cArr[(i >> 16) & 255];
        bArrEnsureCapacity[size + 3] = (byte) (c2 >> '\b');
        bArrEnsureCapacity[size + 4] = (byte) c2;
        char c3 = cArr[(i >> 8) & 255];
        bArrEnsureCapacity[size + 5] = (byte) (c3 >> '\b');
        bArrEnsureCapacity[size + 6] = (byte) c3;
        char c4 = cArr[i & 255];
        bArrEnsureCapacity[size + 7] = (byte) (c4 >> '\b');
        bArrEnsureCapacity[size + 8] = (byte) c4;
        bArrEnsureCapacity[size + 9] = 45;
        char c5 = cArr[(i2 >> 24) & 255];
        bArrEnsureCapacity[size + 10] = (byte) (c5 >> '\b');
        bArrEnsureCapacity[size + 11] = (byte) c5;
        char c6 = cArr[(i2 >> 16) & 255];
        bArrEnsureCapacity[size + 12] = (byte) (c6 >> '\b');
        bArrEnsureCapacity[size + 13] = (byte) c6;
        bArrEnsureCapacity[size + 14] = 45;
        char c7 = cArr[(i2 >> 8) & 255];
        bArrEnsureCapacity[size + 15] = (byte) (c7 >> '\b');
        bArrEnsureCapacity[size + 16] = (byte) c7;
        char c8 = cArr[i2 & 255];
        bArrEnsureCapacity[size + 17] = (byte) (c8 >> '\b');
        bArrEnsureCapacity[size + 18] = (byte) c8;
        bArrEnsureCapacity[size + 19] = 45;
        char c9 = cArr[(i3 >> 24) & 255];
        bArrEnsureCapacity[size + 20] = (byte) (c9 >> '\b');
        bArrEnsureCapacity[size + 21] = (byte) c9;
        char c10 = cArr[(i3 >> 16) & 255];
        bArrEnsureCapacity[size + 22] = (byte) (c10 >> '\b');
        bArrEnsureCapacity[size + 23] = (byte) c10;
        bArrEnsureCapacity[size + 24] = 45;
        char c11 = cArr[(i3 >> 8) & 255];
        bArrEnsureCapacity[size + 25] = (byte) (c11 >> '\b');
        bArrEnsureCapacity[size + 26] = (byte) c11;
        char c12 = cArr[i3 & 255];
        bArrEnsureCapacity[size + 27] = (byte) (c12 >> '\b');
        bArrEnsureCapacity[size + 28] = (byte) c12;
        char c13 = cArr[(i4 >> 24) & 255];
        bArrEnsureCapacity[size + 29] = (byte) (c13 >> '\b');
        bArrEnsureCapacity[size + 30] = (byte) c13;
        char c14 = cArr[(i4 >> 16) & 255];
        bArrEnsureCapacity[size + 31] = (byte) (c14 >> '\b');
        bArrEnsureCapacity[size + 32] = (byte) c14;
        char c15 = cArr[(i4 >> 8) & 255];
        bArrEnsureCapacity[size + 33] = (byte) (c15 >> '\b');
        bArrEnsureCapacity[size + 34] = (byte) c15;
        char c16 = cArr[i4 & 255];
        bArrEnsureCapacity[size + 35] = (byte) (c16 >> '\b');
        bArrEnsureCapacity[size + 36] = (byte) c16;
        bArrEnsureCapacity[size + 37] = JsonWriter.QUOTE;
        jsonWriter.advance(38);
    }

    public static UUID deserialize(JsonReader jsonReader) throws IOException {
        int i;
        char[] simpleQuote = jsonReader.readSimpleQuote();
        int currentIndex = jsonReader.getCurrentIndex() - jsonReader.getTokenStart();
        long j = 0;
        if (currentIndex != 37 || simpleQuote[8] != '-' || simpleQuote[13] != '-' || simpleQuote[18] != '-' || simpleQuote[23] != '-') {
            if (currentIndex == 33) {
                long j2 = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= 16) {
                        break;
                    }
                    try {
                        j2 = (j2 << 4) + ((long) Values[simpleQuote[i2] - '0']);
                        i2++;
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        return UUID.fromString(new String(simpleQuote, 0, 32));
                    }
                    return UUID.fromString(new String(simpleQuote, 0, 32));
                }
                for (i = 16; i < 32; i++) {
                    j = (j << 4) + ((long) Values[simpleQuote[i] - '0']);
                }
                return new UUID(j2, j);
            }
            return UUID.fromString(new String(simpleQuote, 0, currentIndex - 1));
        }
        long j3 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            try {
                j3 = (j3 << 4) + ((long) Values[simpleQuote[i3] - '0']);
            } catch (ArrayIndexOutOfBoundsException unused2) {
                return UUID.fromString(new String(simpleQuote, 0, 36));
            }
        }
        for (int i4 = 9; i4 < 13; i4++) {
            j3 = (j3 << 4) + ((long) Values[simpleQuote[i4] - '0']);
        }
        for (int i5 = 14; i5 < 18; i5++) {
            j3 = (j3 << 4) + ((long) Values[simpleQuote[i5] - '0']);
        }
        for (int i6 = 19; i6 < 23; i6++) {
            j = (j << 4) + ((long) Values[simpleQuote[i6] - '0']);
        }
        for (int i7 = 24; i7 < 36; i7++) {
            j = (j << 4) + ((long) Values[simpleQuote[i7] - '0']);
        }
        return new UUID(j3, j);
    }

    public static ArrayList<UUID> deserializeCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeCollectionCustom(READER);
    }

    public static void deserializeCollection(JsonReader jsonReader, Collection<UUID> collection) throws IOException {
        jsonReader.deserializeCollection(READER, collection);
    }

    public static ArrayList<UUID> deserializeNullableCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeNullableCollectionCustom(READER);
    }

    public static void deserializeNullableCollection(JsonReader jsonReader, Collection<UUID> collection) throws IOException {
        jsonReader.deserializeNullableCollection(READER, collection);
    }
}

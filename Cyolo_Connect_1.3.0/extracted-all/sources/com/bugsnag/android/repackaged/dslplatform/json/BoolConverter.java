package com.bugsnag.android.repackaged.dslplatform.json;

import com.bugsnag.android.repackaged.dslplatform.json.JsonReader;
import com.bugsnag.android.repackaged.dslplatform.json.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public abstract class BoolConverter {
    public static final boolean[] EMPTY_ARRAY = new boolean[0];
    public static final JsonReader.ReadObject<Boolean> READER = new JsonReader.ReadObject<Boolean>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.BoolConverter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Boolean read(JsonReader jsonReader) throws IOException {
            return Boolean.valueOf(BoolConverter.deserialize(jsonReader));
        }
    };
    public static final JsonReader.ReadObject<Boolean> NULLABLE_READER = new JsonReader.ReadObject<Boolean>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.BoolConverter.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Boolean read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return Boolean.valueOf(BoolConverter.deserialize(jsonReader));
        }
    };
    public static final JsonWriter.WriteObject<Boolean> WRITER = new JsonWriter.WriteObject<Boolean>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.BoolConverter.3
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, Boolean bool) {
            BoolConverter.serializeNullable(bool, jsonWriter);
        }
    };
    public static final JsonReader.ReadObject<boolean[]> ARRAY_READER = new JsonReader.ReadObject<boolean[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.BoolConverter.4
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public boolean[] read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            if (jsonReader.last() != 91) {
                throw jsonReader.newParseError("Expecting '[' for boolean array start");
            }
            jsonReader.getNextToken();
            return BoolConverter.deserializeBoolArray(jsonReader);
        }
    };
    public static final JsonWriter.WriteObject<boolean[]> ARRAY_WRITER = new JsonWriter.WriteObject<boolean[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.BoolConverter.5
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, boolean[] zArr) {
            BoolConverter.serialize(zArr, jsonWriter);
        }
    };

    public static void serializeNullable(Boolean bool, JsonWriter jsonWriter) {
        if (bool == null) {
            jsonWriter.writeNull();
        } else if (bool.booleanValue()) {
            jsonWriter.writeAscii("true");
        } else {
            jsonWriter.writeAscii("false");
        }
    }

    public static void serialize(boolean z, JsonWriter jsonWriter) {
        if (z) {
            jsonWriter.writeAscii("true");
        } else {
            jsonWriter.writeAscii("false");
        }
    }

    public static void serialize(boolean[] zArr, JsonWriter jsonWriter) {
        if (zArr == null) {
            jsonWriter.writeNull();
            return;
        }
        if (zArr.length == 0) {
            jsonWriter.writeAscii(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_START);
        jsonWriter.writeAscii(zArr[0] ? "true" : "false");
        for (int i = 1; i < zArr.length; i++) {
            jsonWriter.writeAscii(zArr[i] ? ",true" : ",false");
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_END);
    }

    public static boolean deserialize(JsonReader jsonReader) throws IOException {
        if (jsonReader.wasTrue()) {
            return true;
        }
        if (jsonReader.wasFalse()) {
            return false;
        }
        throw jsonReader.newParseErrorAt("Found invalid boolean value", 0);
    }

    public static boolean[] deserializeBoolArray(JsonReader jsonReader) throws IOException {
        if (jsonReader.last() == 93) {
            return EMPTY_ARRAY;
        }
        boolean[] zArrCopyOf = new boolean[4];
        zArrCopyOf[0] = deserialize(jsonReader);
        int i = 1;
        while (jsonReader.getNextToken() == 44) {
            jsonReader.getNextToken();
            if (i == zArrCopyOf.length) {
                zArrCopyOf = Arrays.copyOf(zArrCopyOf, zArrCopyOf.length << 1);
            }
            zArrCopyOf[i] = deserialize(jsonReader);
            i++;
        }
        jsonReader.checkArrayEnd();
        return Arrays.copyOf(zArrCopyOf, i);
    }

    public static ArrayList<Boolean> deserializeCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeCollectionCustom(READER);
    }

    public static void deserializeCollection(JsonReader jsonReader, Collection<Boolean> collection) throws IOException {
        jsonReader.deserializeCollection(READER, collection);
    }

    public static ArrayList<Boolean> deserializeNullableCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeNullableCollectionCustom(READER);
    }

    public static void deserializeNullableCollection(JsonReader jsonReader, Collection<Boolean> collection) throws IOException {
        jsonReader.deserializeNullableCollection(READER, collection);
    }
}

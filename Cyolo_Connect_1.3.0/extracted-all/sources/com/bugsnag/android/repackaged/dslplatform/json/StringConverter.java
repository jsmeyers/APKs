package com.bugsnag.android.repackaged.dslplatform.json;

import com.bugsnag.android.repackaged.dslplatform.json.JsonReader;
import com.bugsnag.android.repackaged.dslplatform.json.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class StringConverter {
    public static final JsonReader.ReadObject<String> READER = new JsonReader.ReadObject<String>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.StringConverter.1
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public String read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return jsonReader.readString();
        }
    };
    public static final JsonWriter.WriteObject<String> WRITER = new JsonWriter.WriteObject<String>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.StringConverter.2
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, String str) {
            StringConverter.serializeNullable(str, jsonWriter);
        }
    };
    public static final JsonWriter.WriteObject<CharSequence> WRITER_CHARS = new JsonWriter.WriteObject<CharSequence>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.StringConverter.3
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, CharSequence charSequence) {
            if (charSequence == null) {
                jsonWriter.writeNull();
            } else {
                jsonWriter.writeString(charSequence);
            }
        }
    };
    public static final JsonReader.ReadObject<StringBuilder> READER_BUILDER = new JsonReader.ReadObject<StringBuilder>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.StringConverter.4
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public StringBuilder read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return jsonReader.appendString(new StringBuilder());
        }
    };
    public static final JsonReader.ReadObject<StringBuffer> READER_BUFFER = new JsonReader.ReadObject<StringBuffer>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.StringConverter.5
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public StringBuffer read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return jsonReader.appendString(new StringBuffer());
        }
    };

    public static void serializeShortNullable(String str, JsonWriter jsonWriter) {
        if (str == null) {
            jsonWriter.writeNull();
        } else {
            jsonWriter.writeString(str);
        }
    }

    public static void serializeShort(String str, JsonWriter jsonWriter) {
        jsonWriter.writeString(str);
    }

    public static void serializeNullable(String str, JsonWriter jsonWriter) {
        if (str == null) {
            jsonWriter.writeNull();
        } else {
            jsonWriter.writeString(str);
        }
    }

    public static void serialize(String str, JsonWriter jsonWriter) {
        jsonWriter.writeString(str);
    }

    public static String deserialize(JsonReader jsonReader) throws IOException {
        return jsonReader.readString();
    }

    public static String deserializeNullable(JsonReader jsonReader) throws IOException {
        if (jsonReader.last() == 110) {
            if (jsonReader.wasNull()) {
                return null;
            }
            throw jsonReader.newParseErrorAt("Expecting 'null' for null constant", 0);
        }
        return jsonReader.readString();
    }

    public static ArrayList<String> deserializeCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeCollectionCustom(READER);
    }

    public static void deserializeCollection(JsonReader jsonReader, Collection<String> collection) throws IOException {
        jsonReader.deserializeCollection(READER, collection);
    }

    public static ArrayList<String> deserializeNullableCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeNullableCollectionCustom(READER);
    }

    public static void deserializeNullableCollection(JsonReader jsonReader, Collection<String> collection) throws IOException {
        jsonReader.deserializeNullableCollection(READER, collection);
    }

    public static void serialize(List<String> list, JsonWriter jsonWriter) {
        jsonWriter.writeByte(JsonWriter.ARRAY_START);
        if (list.size() != 0) {
            jsonWriter.writeString(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                jsonWriter.writeByte(JsonWriter.COMMA);
                jsonWriter.writeString(list.get(i));
            }
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_END);
    }
}

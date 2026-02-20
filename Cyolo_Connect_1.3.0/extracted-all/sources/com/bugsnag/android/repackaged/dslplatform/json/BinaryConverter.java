package com.bugsnag.android.repackaged.dslplatform.json;

import com.bugsnag.android.repackaged.dslplatform.json.JsonReader;
import com.bugsnag.android.repackaged.dslplatform.json.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class BinaryConverter {
    static final JsonReader.ReadObject<byte[]> Base64Reader = new JsonReader.ReadObject<byte[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.BinaryConverter.1
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public byte[] read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return BinaryConverter.deserialize(jsonReader);
        }
    };
    static final JsonWriter.WriteObject<byte[]> Base64Writer = new JsonWriter.WriteObject<byte[]>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.BinaryConverter.2
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, byte[] bArr) {
            BinaryConverter.serialize(bArr, jsonWriter);
        }
    };

    public static void serialize(byte[] bArr, JsonWriter jsonWriter) {
        if (bArr == null) {
            jsonWriter.writeNull();
        } else if (bArr.length == 0) {
            jsonWriter.writeAscii("\"\"");
        } else {
            jsonWriter.writeBinary(bArr);
        }
    }

    public static byte[] deserialize(JsonReader jsonReader) throws IOException {
        return jsonReader.readBase64();
    }

    public static ArrayList<byte[]> deserializeCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeCollectionCustom(Base64Reader);
    }

    public static void deserializeCollection(JsonReader jsonReader, Collection<byte[]> collection) throws IOException {
        jsonReader.deserializeCollection(Base64Reader, collection);
    }

    public static ArrayList<byte[]> deserializeNullableCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeNullableCollectionCustom(Base64Reader);
    }

    public static void deserializeNullableCollection(JsonReader jsonReader, Collection<byte[]> collection) throws IOException {
        jsonReader.deserializeNullableCollection(Base64Reader, collection);
    }
}

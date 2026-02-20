package com.bugsnag.android.repackaged.dslplatform.json;

import com.bugsnag.android.repackaged.dslplatform.json.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class MapConverter {
    private static final JsonReader.ReadObject<Map<String, String>> TypedMapReader = new JsonReader.ReadObject<Map<String, String>>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.MapConverter.1
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Map<String, String> read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return MapConverter.deserialize(jsonReader);
        }
    };

    public static void serializeNullable(Map<String, String> map, JsonWriter jsonWriter) {
        if (map == null) {
            jsonWriter.writeNull();
        } else {
            serialize(map, jsonWriter);
        }
    }

    public static void serialize(Map<String, String> map, JsonWriter jsonWriter) {
        jsonWriter.writeByte(JsonWriter.OBJECT_START);
        int size = map.size();
        if (size > 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            Map.Entry<String, String> next = it.next();
            StringConverter.serializeShort(next.getKey(), jsonWriter);
            jsonWriter.writeByte(JsonWriter.SEMI);
            StringConverter.serializeNullable(next.getValue(), jsonWriter);
            for (int i = 1; i < size; i++) {
                jsonWriter.writeByte(JsonWriter.COMMA);
                Map.Entry<String, String> next2 = it.next();
                StringConverter.serializeShort(next2.getKey(), jsonWriter);
                jsonWriter.writeByte(JsonWriter.SEMI);
                StringConverter.serializeNullable(next2.getValue(), jsonWriter);
            }
        }
        jsonWriter.writeByte(JsonWriter.OBJECT_END);
    }

    public static Map<String, String> deserialize(JsonReader jsonReader) throws IOException {
        if (jsonReader.last() != 123) {
            throw jsonReader.newParseError("Expecting '{' for map start");
        }
        if (jsonReader.getNextToken() == 125) {
            return new LinkedHashMap(0);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strDeserialize = StringConverter.deserialize(jsonReader);
        if (jsonReader.getNextToken() != 58) {
            throw jsonReader.newParseError("Expecting ':' after attribute name");
        }
        jsonReader.getNextToken();
        linkedHashMap.put(strDeserialize, StringConverter.deserializeNullable(jsonReader));
        while (true) {
            byte nextToken = jsonReader.getNextToken();
            if (nextToken != 44) {
                if (nextToken == 125) {
                    return linkedHashMap;
                }
                throw jsonReader.newParseError("Expecting '}' for map end");
            }
            jsonReader.getNextToken();
            String strDeserialize2 = StringConverter.deserialize(jsonReader);
            if (jsonReader.getNextToken() != 58) {
                throw jsonReader.newParseError("Expecting ':' after attribute name");
            }
            jsonReader.getNextToken();
            linkedHashMap.put(strDeserialize2, StringConverter.deserializeNullable(jsonReader));
        }
    }

    public static ArrayList<Map<String, String>> deserializeCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeCollectionCustom(TypedMapReader);
    }

    public static void deserializeCollection(JsonReader jsonReader, Collection<Map<String, String>> collection) throws IOException {
        jsonReader.deserializeCollection(TypedMapReader, collection);
    }

    public static ArrayList<Map<String, String>> deserializeNullableCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeNullableCollectionCustom(TypedMapReader);
    }

    public static void deserializeNullableCollection(JsonReader jsonReader, Collection<Map<String, String>> collection) throws IOException {
        jsonReader.deserializeNullableCollection(TypedMapReader, collection);
    }
}

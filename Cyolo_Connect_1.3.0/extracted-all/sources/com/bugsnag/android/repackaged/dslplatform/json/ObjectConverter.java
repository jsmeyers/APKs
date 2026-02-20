package com.bugsnag.android.repackaged.dslplatform.json;

import com.bugsnag.android.repackaged.dslplatform.json.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ObjectConverter {
    private static final JsonReader.ReadObject<Map<String, Object>> TypedMapReader = new JsonReader.ReadObject<Map<String, Object>>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.ObjectConverter.1
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public Map<String, Object> read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return ObjectConverter.deserializeMap(jsonReader);
        }
    };
    static final JsonReader.ReadObject<LinkedHashMap> MapReader = new JsonReader.ReadObject<LinkedHashMap>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.ObjectConverter.2
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
        public LinkedHashMap read(JsonReader jsonReader) throws IOException {
            if (jsonReader.wasNull()) {
                return null;
            }
            return ObjectConverter.deserializeMap(jsonReader);
        }
    };

    public static void serializeNullableMap(Map<String, Object> map, JsonWriter jsonWriter) {
        if (map == null) {
            jsonWriter.writeNull();
        } else {
            serializeMap(map, jsonWriter);
        }
    }

    public static void serializeMap(Map<String, Object> map, JsonWriter jsonWriter) {
        jsonWriter.writeByte(JsonWriter.OBJECT_START);
        int size = map.size();
        if (size > 0) {
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            Map.Entry<String, Object> next = it.next();
            jsonWriter.writeString(next.getKey());
            jsonWriter.writeByte(JsonWriter.SEMI);
            jsonWriter.serializeObject(next.getValue());
            for (int i = 1; i < size; i++) {
                jsonWriter.writeByte(JsonWriter.COMMA);
                Map.Entry<String, Object> next2 = it.next();
                jsonWriter.writeString(next2.getKey());
                jsonWriter.writeByte(JsonWriter.SEMI);
                jsonWriter.serializeObject(next2.getValue());
            }
        }
        jsonWriter.writeByte(JsonWriter.OBJECT_END);
    }

    public static void serializeObject(Object obj, JsonWriter jsonWriter) throws IOException {
        jsonWriter.serializeObject(obj);
    }

    public static Object deserializeObject(JsonReader jsonReader) throws IOException {
        byte bLast = jsonReader.last();
        if (bLast == 34) {
            return jsonReader.readString();
        }
        if (bLast == 91) {
            return deserializeList(jsonReader);
        }
        if (bLast == 102) {
            if (!jsonReader.wasFalse()) {
                throw jsonReader.newParseErrorAt("Expecting 'false' for false constant", 0);
            }
            return false;
        }
        if (bLast == 110) {
            if (jsonReader.wasNull()) {
                return null;
            }
            throw jsonReader.newParseErrorAt("Expecting 'null' for null constant", 0);
        }
        if (bLast != 116) {
            if (bLast == 123) {
                return deserializeMap(jsonReader);
            }
            return NumberConverter.deserializeNumber(jsonReader);
        }
        if (!jsonReader.wasTrue()) {
            throw jsonReader.newParseErrorAt("Expecting 'true' for true constant", 0);
        }
        return true;
    }

    public static ArrayList<Object> deserializeList(JsonReader jsonReader) throws IOException {
        byte nextToken;
        if (jsonReader.last() != 91) {
            throw jsonReader.newParseError("Expecting '[' for list start");
        }
        if (jsonReader.getNextToken() == 93) {
            return new ArrayList<>(0);
        }
        ArrayList<Object> arrayList = new ArrayList<>(4);
        arrayList.add(deserializeObject(jsonReader));
        while (true) {
            nextToken = jsonReader.getNextToken();
            if (nextToken != 44) {
                break;
            }
            jsonReader.getNextToken();
            arrayList.add(deserializeObject(jsonReader));
        }
        if (nextToken == 93) {
            return arrayList;
        }
        throw jsonReader.newParseError("Expecting ']' for list end");
    }

    public static LinkedHashMap<String, Object> deserializeMap(JsonReader jsonReader) throws IOException {
        byte nextToken;
        if (jsonReader.last() != 123) {
            throw jsonReader.newParseError("Expecting '{' for map start");
        }
        if (jsonReader.getNextToken() == 125) {
            return new LinkedHashMap<>(0);
        }
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(jsonReader.readKey(), deserializeObject(jsonReader));
        while (true) {
            nextToken = jsonReader.getNextToken();
            if (nextToken != 44) {
                break;
            }
            jsonReader.getNextToken();
            linkedHashMap.put(jsonReader.readKey(), deserializeObject(jsonReader));
        }
        if (nextToken == 125) {
            return linkedHashMap;
        }
        throw jsonReader.newParseError("Expecting '}' for map end");
    }

    public static ArrayList<Map<String, Object>> deserializeMapCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeCollectionCustom(TypedMapReader);
    }

    public static void deserializeMapCollection(JsonReader jsonReader, Collection<Map<String, Object>> collection) throws IOException {
        jsonReader.deserializeCollection(TypedMapReader, collection);
    }

    public static ArrayList<Map<String, Object>> deserializeNullableMapCollection(JsonReader jsonReader) throws IOException {
        return jsonReader.deserializeNullableCollectionCustom(TypedMapReader);
    }

    public static void deserializeNullableMapCollection(JsonReader jsonReader, Collection<Map<String, Object>> collection) throws IOException {
        jsonReader.deserializeNullableCollection(TypedMapReader, collection);
    }
}

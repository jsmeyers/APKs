package com.google.crypto.tink;

import androidx.core.app.NotificationCompat;
import com.google.crypto.tink.internal.JsonParser;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.cyolo.android.MainActivityKt;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonKeysetReader implements KeysetReader {
    private static final long MAX_KEY_ID = 4294967295L;
    private static final long MIN_KEY_ID = -2147483648L;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final InputStream inputStream;
    private boolean urlSafeBase64 = false;

    private JsonKeysetReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public static JsonKeysetReader withInputStream(InputStream input) throws IOException {
        return new JsonKeysetReader(input);
    }

    @Deprecated
    public static JsonKeysetReader withJsonObject(Object input) {
        return withString(input.toString());
    }

    public static JsonKeysetReader withString(String input) {
        return new JsonKeysetReader(new ByteArrayInputStream(input.getBytes(UTF_8)));
    }

    public static JsonKeysetReader withBytes(final byte[] bytes) {
        return new JsonKeysetReader(new ByteArrayInputStream(bytes));
    }

    @Deprecated
    public static JsonKeysetReader withFile(File file) throws IOException {
        return withInputStream(new FileInputStream(file));
    }

    @Deprecated
    public static JsonKeysetReader withPath(String path) throws IOException {
        return withInputStream(new FileInputStream(new File(path)));
    }

    @Deprecated
    public static JsonKeysetReader withPath(Path path) throws IOException {
        return withInputStream(new FileInputStream(path.toFile()));
    }

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        try {
            try {
                Keyset keysetKeysetFromJson = keysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                return keysetKeysetFromJson;
            } catch (Throwable th) {
                InputStream inputStream2 = this.inputStream;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                throw th;
            }
        } catch (JsonParseException | IllegalStateException e) {
            throw new IOException(e);
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            try {
                EncryptedKeyset encryptedKeysetEncryptedKeysetFromJson = encryptedKeysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                return encryptedKeysetEncryptedKeysetFromJson;
            } catch (Throwable th) {
                InputStream inputStream2 = this.inputStream;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                throw th;
            }
        } catch (JsonParseException | IllegalStateException e) {
            throw new IOException(e);
        }
    }

    private static int getKeyId(JsonElement element) throws IOException {
        try {
            long parsedNumberAsLongOrThrow = JsonParser.getParsedNumberAsLongOrThrow(element);
            if (parsedNumberAsLongOrThrow > 4294967295L || parsedNumberAsLongOrThrow < MIN_KEY_ID) {
                throw new IOException("invalid key id");
            }
            return (int) element.getAsLong();
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    private Keyset keysetFromJson(JsonObject json) throws IOException {
        validateKeyset(json);
        Keyset.Builder builderNewBuilder = Keyset.newBuilder();
        if (json.has("primaryKeyId")) {
            builderNewBuilder.setPrimaryKeyId(getKeyId(json.get("primaryKeyId")));
        }
        JsonArray asJsonArray = json.getAsJsonArray("key");
        for (int i = 0; i < asJsonArray.size(); i++) {
            builderNewBuilder.addKey(keyFromJson(asJsonArray.get(i).getAsJsonObject()));
        }
        return (Keyset) builderNewBuilder.build();
    }

    private EncryptedKeyset encryptedKeysetFromJson(JsonObject json) throws IOException {
        byte[] bArrDecode;
        validateEncryptedKeyset(json);
        if (this.urlSafeBase64) {
            bArrDecode = Base64.urlSafeDecode(json.get("encryptedKeyset").getAsString());
        } else {
            bArrDecode = Base64.decode(json.get("encryptedKeyset").getAsString());
        }
        if (json.has("keysetInfo")) {
            return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArrDecode)).setKeysetInfo(keysetInfoFromJson(json.getAsJsonObject("keysetInfo"))).build();
        }
        return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArrDecode)).build();
    }

    private Keyset.Key keyFromJson(JsonObject json) throws IOException {
        validateKey(json);
        return (Keyset.Key) Keyset.Key.newBuilder().setStatus(getStatus(json.get(NotificationCompat.CATEGORY_STATUS).getAsString())).setKeyId(getKeyId(json.get("keyId"))).setOutputPrefixType(getOutputPrefixType(json.get("outputPrefixType").getAsString())).setKeyData(keyDataFromJson(json.getAsJsonObject("keyData"))).build();
    }

    private static KeysetInfo keysetInfoFromJson(JsonObject json) throws IOException {
        KeysetInfo.Builder builderNewBuilder = KeysetInfo.newBuilder();
        if (json.has("primaryKeyId")) {
            builderNewBuilder.setPrimaryKeyId(getKeyId(json.get("primaryKeyId")));
        }
        if (json.has("keyInfo")) {
            JsonArray asJsonArray = json.getAsJsonArray("keyInfo");
            for (int i = 0; i < asJsonArray.size(); i++) {
                builderNewBuilder.addKeyInfo(keyInfoFromJson(asJsonArray.get(i).getAsJsonObject()));
            }
        }
        return (KeysetInfo) builderNewBuilder.build();
    }

    private static KeysetInfo.KeyInfo keyInfoFromJson(JsonObject json) throws IOException {
        return (KeysetInfo.KeyInfo) KeysetInfo.KeyInfo.newBuilder().setStatus(getStatus(json.get(NotificationCompat.CATEGORY_STATUS).getAsString())).setKeyId(getKeyId(json.get("keyId"))).setOutputPrefixType(getOutputPrefixType(json.get("outputPrefixType").getAsString())).setTypeUrl(json.get("typeUrl").getAsString()).build();
    }

    private KeyData keyDataFromJson(JsonObject json) {
        byte[] bArrDecode;
        validateKeyData(json);
        if (this.urlSafeBase64) {
            bArrDecode = Base64.urlSafeDecode(json.get(MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE).getAsString());
        } else {
            bArrDecode = Base64.decode(json.get(MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE).getAsString());
        }
        return (KeyData) KeyData.newBuilder().setTypeUrl(json.get("typeUrl").getAsString()).setValue(ByteString.copyFrom(bArrDecode)).setKeyMaterialType(getKeyMaterialType(json.get("keyMaterialType").getAsString())).build();
    }

    private static KeyStatusType getStatus(String status) {
        status.hashCode();
        switch (status) {
            case "ENABLED":
                return KeyStatusType.ENABLED;
            case "DESTROYED":
                return KeyStatusType.DESTROYED;
            case "DISABLED":
                return KeyStatusType.DISABLED;
            default:
                throw new JsonParseException("unknown status: " + status);
        }
    }

    private static OutputPrefixType getOutputPrefixType(String type) {
        type.hashCode();
        switch (type) {
            case "LEGACY":
                return OutputPrefixType.LEGACY;
            case "RAW":
                return OutputPrefixType.RAW;
            case "TINK":
                return OutputPrefixType.TINK;
            case "CRUNCHY":
                return OutputPrefixType.CRUNCHY;
            default:
                throw new JsonParseException("unknown output prefix type: " + type);
        }
    }

    private static KeyData.KeyMaterialType getKeyMaterialType(String type) {
        type.hashCode();
        switch (type) {
            case "REMOTE":
                return KeyData.KeyMaterialType.REMOTE;
            case "SYMMETRIC":
                return KeyData.KeyMaterialType.SYMMETRIC;
            case "ASYMMETRIC_PRIVATE":
                return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
            case "ASYMMETRIC_PUBLIC":
                return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
            default:
                throw new JsonParseException("unknown key material type: " + type);
        }
    }

    private static void validateKeyset(JsonObject json) {
        if (!json.has("key") || json.getAsJsonArray("key").size() == 0) {
            throw new JsonParseException("invalid keyset");
        }
    }

    private static void validateEncryptedKeyset(JsonObject json) {
        if (!json.has("encryptedKeyset")) {
            throw new JsonParseException("invalid encrypted keyset");
        }
    }

    private static void validateKey(JsonObject json) {
        if (!json.has("keyData") || !json.has(NotificationCompat.CATEGORY_STATUS) || !json.has("keyId") || !json.has("outputPrefixType")) {
            throw new JsonParseException("invalid key");
        }
    }

    private static void validateKeyData(JsonObject json) {
        if (!json.has("typeUrl") || !json.has(MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE) || !json.has("keyMaterialType")) {
            throw new JsonParseException("invalid keyData");
        }
    }
}

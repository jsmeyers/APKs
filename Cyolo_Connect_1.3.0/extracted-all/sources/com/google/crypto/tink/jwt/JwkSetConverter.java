package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.google.crypto.tink.proto.JwtEcdsaPublicKey;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey;
import com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Base64;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import j$.util.Optional;
import java.io.IOException;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class JwkSetConverter {
    private static final String JWT_ECDSA_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
    private static final String JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey";
    private static final String JWT_RSA_SSA_PSS_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey";

    public static String fromPublicKeysetHandle(KeysetHandle handle) throws GeneralSecurityException, IOException {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < handle.size(); i++) {
            KeysetHandle.Entry at = handle.getAt(i);
            if (at.getStatus() == KeyStatus.ENABLED) {
                Key key = at.getKey();
                if (!(key instanceof LegacyProtoKey)) {
                    throw new GeneralSecurityException("only LegacyProtoKey is currently supported");
                }
                ProtoKeySerialization serialization = ((LegacyProtoKey) key).getSerialization(null);
                if (serialization.getOutputPrefixType() != OutputPrefixType.RAW && serialization.getOutputPrefixType() != OutputPrefixType.TINK) {
                    throw new GeneralSecurityException("only OutputPrefixType RAW and TINK are supported");
                }
                if (serialization.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                    throw new GeneralSecurityException("only public keys can be converted");
                }
                String typeUrl = serialization.getTypeUrl();
                typeUrl.hashCode();
                switch (typeUrl) {
                    case "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey":
                        jsonArray.add(convertJwtEcdsaKey(serialization));
                        break;
                    case "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey":
                        jsonArray.add(convertJwtRsaSsaPkcs1(serialization));
                        break;
                    case "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey":
                        jsonArray.add(convertJwtRsaSsaPss(serialization));
                        break;
                    default:
                        throw new GeneralSecurityException(String.format("key type %s is not supported", serialization.getTypeUrl()));
                }
            }
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("keys", jsonArray);
        return jsonObject.toString();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Found duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Found duplicated region for block: B:24:0x008e  */
    /* JADX WARN: Found duplicated region for block: B:25:0x0093  */
    /* JADX WARN: Found duplicated region for block: B:43:0x0071 A[SYNTHETIC] */
    public static KeysetHandle toPublicKeysetHandle(String jwkSet) throws GeneralSecurityException, IOException {
        ProtoKeySerialization protoKeySerializationConvertToEcdsaKey;
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(jwkSet));
            jsonReader.setLenient(false);
            JsonObject asJsonObject = Streams.parse(jsonReader).getAsJsonObject();
            KeysetHandle.Builder builderNewBuilder = KeysetHandle.newBuilder();
            Iterator<JsonElement> it = asJsonObject.get("keys").getAsJsonArray().iterator();
            while (it.hasNext()) {
                JsonObject asJsonObject2 = it.next().getAsJsonObject();
                byte b = 2;
                String strSubstring = getStringItem(asJsonObject2, "alg").substring(0, 2);
                strSubstring.hashCode();
                switch (strSubstring.hashCode()) {
                    case 2222:
                        if (strSubstring.equals("ES")) {
                            b = 0;
                        }
                        switch (b) {
                            case 0:
                                protoKeySerializationConvertToEcdsaKey = convertToEcdsaKey(asJsonObject2);
                                break;
                            case 1:
                                protoKeySerializationConvertToEcdsaKey = convertToRsaSsaPssKey(asJsonObject2);
                                break;
                            case 2:
                                protoKeySerializationConvertToEcdsaKey = convertToRsaSsaPkcs1Key(asJsonObject2);
                                break;
                            default:
                                throw new GeneralSecurityException("unexpected alg value: " + getStringItem(asJsonObject2, "alg"));
                        }
                        builderNewBuilder.addEntry(KeysetHandle.importKey(new LegacyProtoKey(protoKeySerializationConvertToEcdsaKey, null)).withRandomId());
                        break;
                    case 2563:
                        if (strSubstring.equals("PS")) {
                            b = 1;
                        }
                        switch (b) {
                            case 0:
                                protoKeySerializationConvertToEcdsaKey = convertToEcdsaKey(asJsonObject2);
                                break;
                            case 1:
                                protoKeySerializationConvertToEcdsaKey = convertToRsaSsaPssKey(asJsonObject2);
                                break;
                            case 2:
                                protoKeySerializationConvertToEcdsaKey = convertToRsaSsaPkcs1Key(asJsonObject2);
                                break;
                            default:
                                throw new GeneralSecurityException("unexpected alg value: " + getStringItem(asJsonObject2, "alg"));
                        }
                        builderNewBuilder.addEntry(KeysetHandle.importKey(new LegacyProtoKey(protoKeySerializationConvertToEcdsaKey, null)).withRandomId());
                        break;
                    case 2625:
                        if (!strSubstring.equals("RS")) {
                        }
                        switch (b) {
                            case 0:
                                protoKeySerializationConvertToEcdsaKey = convertToEcdsaKey(asJsonObject2);
                                break;
                            case 1:
                                protoKeySerializationConvertToEcdsaKey = convertToRsaSsaPssKey(asJsonObject2);
                                break;
                            case 2:
                                protoKeySerializationConvertToEcdsaKey = convertToRsaSsaPkcs1Key(asJsonObject2);
                                break;
                            default:
                                throw new GeneralSecurityException("unexpected alg value: " + getStringItem(asJsonObject2, "alg"));
                        }
                        builderNewBuilder.addEntry(KeysetHandle.importKey(new LegacyProtoKey(protoKeySerializationConvertToEcdsaKey, null)).withRandomId());
                        break;
                }
                b = -1;
                switch (b) {
                    case 0:
                        protoKeySerializationConvertToEcdsaKey = convertToEcdsaKey(asJsonObject2);
                        break;
                    case 1:
                        protoKeySerializationConvertToEcdsaKey = convertToRsaSsaPssKey(asJsonObject2);
                        break;
                    case 2:
                        protoKeySerializationConvertToEcdsaKey = convertToRsaSsaPkcs1Key(asJsonObject2);
                        break;
                    default:
                        throw new GeneralSecurityException("unexpected alg value: " + getStringItem(asJsonObject2, "alg"));
                }
                builderNewBuilder.addEntry(KeysetHandle.importKey(new LegacyProtoKey(protoKeySerializationConvertToEcdsaKey, null)).withRandomId());
            }
            if (builderNewBuilder.size() <= 0) {
                throw new GeneralSecurityException("empty keyset");
            }
            builderNewBuilder.getAt(0).makePrimary();
            return builderNewBuilder.build();
        } catch (JsonParseException | IllegalStateException | StackOverflowError e) {
            throw new GeneralSecurityException("JWK set is invalid JSON", e);
        }
    }

    private static Optional<String> getKid(@Nullable Integer idRequirement) {
        if (idRequirement == null) {
            return Optional.empty();
        }
        return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(idRequirement.intValue()).array()));
    }

    private static JsonObject convertJwtEcdsaKey(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        String str2;
        try {
            JwtEcdsaPublicKey from = JwtEcdsaPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[from.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "ES256";
                str2 = "P-256";
            } else if (i == 2) {
                str = "ES384";
                str2 = "P-384";
            } else {
                if (i != 3) {
                    throw new GeneralSecurityException("unknown algorithm");
                }
                str = "ES512";
                str2 = "P-521";
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kty", "EC");
            jsonObject.addProperty("crv", str2);
            jsonObject.addProperty("x", Base64.urlSafeEncode(from.getX().toByteArray()));
            jsonObject.addProperty("y", Base64.urlSafeEncode(from.getY().toByteArray()));
            jsonObject.addProperty("use", "sig");
            jsonObject.addProperty("alg", str);
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("verify");
            jsonObject.add("key_ops", jsonArray);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (kid.isPresent()) {
                jsonObject.addProperty("kid", kid.get());
            } else if (from.hasCustomKid()) {
                jsonObject.addProperty("kid", from.getCustomKid().getValue());
            }
            return jsonObject;
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("failed to parse value as JwtEcdsaPublicKey proto", e);
        }
    }

    private static JsonObject convertJwtRsaSsaPkcs1(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        try {
            JwtRsaSsaPkcs1PublicKey from = JwtRsaSsaPkcs1PublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[from.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "RS256";
            } else if (i == 2) {
                str = "RS384";
            } else {
                if (i != 3) {
                    throw new GeneralSecurityException("unknown algorithm");
                }
                str = "RS512";
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kty", "RSA");
            jsonObject.addProperty("n", Base64.urlSafeEncode(from.getN().toByteArray()));
            jsonObject.addProperty("e", Base64.urlSafeEncode(from.getE().toByteArray()));
            jsonObject.addProperty("use", "sig");
            jsonObject.addProperty("alg", str);
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("verify");
            jsonObject.add("key_ops", jsonArray);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (kid.isPresent()) {
                jsonObject.addProperty("kid", kid.get());
            } else if (from.hasCustomKid()) {
                jsonObject.addProperty("kid", from.getCustomKid().getValue());
            }
            return jsonObject;
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("failed to parse value as JwtRsaSsaPkcs1PublicKey proto", e);
        }
    }

    private static JsonObject convertJwtRsaSsaPss(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        try {
            JwtRsaSsaPssPublicKey from = JwtRsaSsaPssPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[from.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "PS256";
            } else if (i == 2) {
                str = "PS384";
            } else {
                if (i != 3) {
                    throw new GeneralSecurityException("unknown algorithm");
                }
                str = "PS512";
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kty", "RSA");
            jsonObject.addProperty("n", Base64.urlSafeEncode(from.getN().toByteArray()));
            jsonObject.addProperty("e", Base64.urlSafeEncode(from.getE().toByteArray()));
            jsonObject.addProperty("use", "sig");
            jsonObject.addProperty("alg", str);
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("verify");
            jsonObject.add("key_ops", jsonArray);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (kid.isPresent()) {
                jsonObject.addProperty("kid", kid.get());
            } else if (from.hasCustomKid()) {
                jsonObject.addProperty("kid", from.getCustomKid().getValue());
            }
            return jsonObject;
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("failed to parse value as JwtRsaSsaPssPublicKey proto", e);
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwkSetConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm;

        static {
            int[] iArr = new int[JwtRsaSsaPssAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm = iArr;
            try {
                iArr[JwtRsaSsaPssAlgorithm.PS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[JwtRsaSsaPssAlgorithm.PS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[JwtRsaSsaPssAlgorithm.PS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[JwtRsaSsaPkcs1Algorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm = iArr2;
            try {
                iArr2[JwtRsaSsaPkcs1Algorithm.RS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[JwtRsaSsaPkcs1Algorithm.RS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[JwtRsaSsaPkcs1Algorithm.RS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[JwtEcdsaAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = iArr3;
            try {
                iArr3[JwtEcdsaAlgorithm.ES256.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES384.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES512.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private static String getStringItem(JsonObject obj, String name) throws GeneralSecurityException {
        if (!obj.has(name)) {
            throw new GeneralSecurityException(name + " not found");
        }
        if (!obj.get(name).isJsonPrimitive() || !obj.get(name).getAsJsonPrimitive().isString()) {
            throw new GeneralSecurityException(name + " is not a string");
        }
        return obj.get(name).getAsString();
    }

    private static void expectStringItem(JsonObject obj, String name, String expectedValue) throws GeneralSecurityException {
        String stringItem = getStringItem(obj, name);
        if (stringItem.equals(expectedValue)) {
            return;
        }
        throw new GeneralSecurityException("unexpected " + name + " value: " + stringItem);
    }

    private static void validateUseIsSig(JsonObject jsonKey) throws GeneralSecurityException {
        if (jsonKey.has("use")) {
            expectStringItem(jsonKey, "use", "sig");
        }
    }

    private static void validateKeyOpsIsVerify(JsonObject jsonKey) throws GeneralSecurityException {
        if (jsonKey.has("key_ops")) {
            if (!jsonKey.get("key_ops").isJsonArray()) {
                throw new GeneralSecurityException("key_ops is not an array");
            }
            JsonArray asJsonArray = jsonKey.get("key_ops").getAsJsonArray();
            if (asJsonArray.size() != 1) {
                throw new GeneralSecurityException("key_ops must contain exactly one element");
            }
            if (!asJsonArray.get(0).isJsonPrimitive() || !asJsonArray.get(0).getAsJsonPrimitive().isString()) {
                throw new GeneralSecurityException("key_ops is not a string");
            }
            if (asJsonArray.get(0).getAsString().equals("verify")) {
                return;
            }
            throw new GeneralSecurityException("unexpected keyOps value: " + asJsonArray.get(0).getAsString());
        }
    }

    private static ProtoKeySerialization convertToRsaSsaPkcs1Key(JsonObject jsonKey) throws GeneralSecurityException {
        JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm;
        String stringItem = getStringItem(jsonKey, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "RS256":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS256;
                break;
            case "RS384":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS384;
                break;
            case "RS512":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonKey, "alg"));
        }
        if (jsonKey.has("p") || jsonKey.has("q") || jsonKey.has("dp") || jsonKey.has("dq") || jsonKey.has("d") || jsonKey.has("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(jsonKey, "kty", "RSA");
        validateUseIsSig(jsonKey);
        validateKeyOpsIsVerify(jsonKey);
        JwtRsaSsaPkcs1PublicKey.Builder n = JwtRsaSsaPkcs1PublicKey.newBuilder().setVersion(0).setAlgorithm(jwtRsaSsaPkcs1Algorithm).setE(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonKey, "e")))).setN(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonKey, "n"))));
        if (jsonKey.has("kid")) {
            n.setCustomKid((JwtRsaSsaPkcs1PublicKey.CustomKid) JwtRsaSsaPkcs1PublicKey.CustomKid.newBuilder().setValue(getStringItem(jsonKey, "kid")).build());
        }
        return ProtoKeySerialization.create(JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL, ((JwtRsaSsaPkcs1PublicKey) n.build()).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static ProtoKeySerialization convertToRsaSsaPssKey(JsonObject jsonKey) throws GeneralSecurityException {
        JwtRsaSsaPssAlgorithm jwtRsaSsaPssAlgorithm;
        String stringItem = getStringItem(jsonKey, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "PS256":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS256;
                break;
            case "PS384":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS384;
                break;
            case "PS512":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonKey, "alg"));
        }
        if (jsonKey.has("p") || jsonKey.has("q") || jsonKey.has("dq") || jsonKey.has("dq") || jsonKey.has("d") || jsonKey.has("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(jsonKey, "kty", "RSA");
        validateUseIsSig(jsonKey);
        validateKeyOpsIsVerify(jsonKey);
        JwtRsaSsaPssPublicKey.Builder n = JwtRsaSsaPssPublicKey.newBuilder().setVersion(0).setAlgorithm(jwtRsaSsaPssAlgorithm).setE(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonKey, "e")))).setN(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonKey, "n"))));
        if (jsonKey.has("kid")) {
            n.setCustomKid((JwtRsaSsaPssPublicKey.CustomKid) JwtRsaSsaPssPublicKey.CustomKid.newBuilder().setValue(getStringItem(jsonKey, "kid")).build());
        }
        return ProtoKeySerialization.create(JWT_RSA_SSA_PSS_PUBLIC_KEY_URL, ((JwtRsaSsaPssPublicKey) n.build()).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static ProtoKeySerialization convertToEcdsaKey(JsonObject jsonKey) throws GeneralSecurityException {
        JwtEcdsaAlgorithm jwtEcdsaAlgorithm;
        String stringItem = getStringItem(jsonKey, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "ES256":
                expectStringItem(jsonKey, "crv", "P-256");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES256;
                break;
            case "ES384":
                expectStringItem(jsonKey, "crv", "P-384");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES384;
                break;
            case "ES512":
                expectStringItem(jsonKey, "crv", "P-521");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Ecdsa Algorithm: " + getStringItem(jsonKey, "alg"));
        }
        if (jsonKey.has("d")) {
            throw new UnsupportedOperationException("importing ECDSA private keys is not implemented");
        }
        expectStringItem(jsonKey, "kty", "EC");
        validateUseIsSig(jsonKey);
        validateKeyOpsIsVerify(jsonKey);
        JwtEcdsaPublicKey.Builder y = JwtEcdsaPublicKey.newBuilder().setVersion(0).setAlgorithm(jwtEcdsaAlgorithm).setX(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonKey, "x")))).setY(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonKey, "y"))));
        if (jsonKey.has("kid")) {
            y.setCustomKid((JwtEcdsaPublicKey.CustomKid) JwtEcdsaPublicKey.CustomKid.newBuilder().setValue(getStringItem(jsonKey, "kid")).build());
        }
        return ProtoKeySerialization.create(JWT_ECDSA_PUBLIC_KEY_URL, ((JwtEcdsaPublicKey) y.build()).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    @Deprecated
    public static String fromKeysetHandle(KeysetHandle handle, KeyAccess keyAccess) throws GeneralSecurityException, IOException {
        return fromPublicKeysetHandle(handle);
    }

    @Deprecated
    public static KeysetHandle toKeysetHandle(String jwkSet, KeyAccess keyAccess) throws GeneralSecurityException, IOException {
        return toPublicKeysetHandle(jwkSet);
    }

    private JwkSetConverter() {
    }
}

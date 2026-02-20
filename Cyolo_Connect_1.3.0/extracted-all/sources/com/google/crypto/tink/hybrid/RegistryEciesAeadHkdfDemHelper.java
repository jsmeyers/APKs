package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.hybrid.subtle.AeadOrDaead;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesGcmKey;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.AesSivKey;
import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.EciesAeadHkdfDemHelper;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class RegistryEciesAeadHkdfDemHelper implements EciesAeadHkdfDemHelper {
    private AesCtrHmacAeadKey aesCtrHmacAeadKey;
    private int aesCtrKeySize;
    private AesGcmKey aesGcmKey;
    private AesSivKey aesSivKey;
    private final String demKeyTypeUrl;
    private final int symmetricKeySize;

    RegistryEciesAeadHkdfDemHelper(KeyTemplate demTemplate) throws GeneralSecurityException {
        String typeUrl = demTemplate.getTypeUrl();
        this.demKeyTypeUrl = typeUrl;
        if (typeUrl.equals(AeadConfig.AES_GCM_TYPE_URL)) {
            try {
                AesGcmKeyFormat from = AesGcmKeyFormat.parseFrom(demTemplate.getValue(), ExtensionRegistryLite.getEmptyRegistry());
                this.aesGcmKey = (AesGcmKey) Registry.newKey(demTemplate);
                this.symmetricKeySize = from.getKeySize();
                return;
            } catch (InvalidProtocolBufferException e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        }
        if (typeUrl.equals(AeadConfig.AES_CTR_HMAC_AEAD_TYPE_URL)) {
            try {
                AesCtrHmacAeadKeyFormat from2 = AesCtrHmacAeadKeyFormat.parseFrom(demTemplate.getValue(), ExtensionRegistryLite.getEmptyRegistry());
                this.aesCtrHmacAeadKey = (AesCtrHmacAeadKey) Registry.newKey(demTemplate);
                this.aesCtrKeySize = from2.getAesCtrKeyFormat().getKeySize();
                this.symmetricKeySize = this.aesCtrKeySize + from2.getHmacKeyFormat().getKeySize();
                return;
            } catch (InvalidProtocolBufferException e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        }
        if (typeUrl.equals(DeterministicAeadConfig.AES_SIV_TYPE_URL)) {
            try {
                AesSivKeyFormat from3 = AesSivKeyFormat.parseFrom(demTemplate.getValue(), ExtensionRegistryLite.getEmptyRegistry());
                this.aesSivKey = (AesSivKey) Registry.newKey(demTemplate);
                this.symmetricKeySize = from3.getKeySize();
                return;
            } catch (InvalidProtocolBufferException e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        }
        throw new GeneralSecurityException("unsupported AEAD DEM key type: " + typeUrl);
    }

    @Override // com.google.crypto.tink.subtle.EciesAeadHkdfDemHelper
    public int getSymmetricKeySizeInBytes() {
        return this.symmetricKeySize;
    }

    @Override // com.google.crypto.tink.subtle.EciesAeadHkdfDemHelper
    public AeadOrDaead getAeadOrDaead(final byte[] symmetricKeyValue) throws GeneralSecurityException {
        if (symmetricKeyValue.length != getSymmetricKeySizeInBytes()) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.demKeyTypeUrl.equals(AeadConfig.AES_GCM_TYPE_URL)) {
            return new AeadOrDaead((Aead) Registry.getPrimitive(this.demKeyTypeUrl, (AesGcmKey) AesGcmKey.newBuilder().mergeFrom(this.aesGcmKey).setKeyValue(ByteString.copyFrom(symmetricKeyValue, 0, this.symmetricKeySize)).build(), Aead.class));
        }
        if (this.demKeyTypeUrl.equals(AeadConfig.AES_CTR_HMAC_AEAD_TYPE_URL)) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(symmetricKeyValue, 0, this.aesCtrKeySize);
            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(symmetricKeyValue, this.aesCtrKeySize, this.symmetricKeySize);
            AesCtrKey aesCtrKey = (AesCtrKey) AesCtrKey.newBuilder().mergeFrom(this.aesCtrHmacAeadKey.getAesCtrKey()).setKeyValue(ByteString.copyFrom(bArrCopyOfRange)).build();
            return new AeadOrDaead((Aead) Registry.getPrimitive(this.demKeyTypeUrl, (AesCtrHmacAeadKey) AesCtrHmacAeadKey.newBuilder().setVersion(this.aesCtrHmacAeadKey.getVersion()).setAesCtrKey(aesCtrKey).setHmacKey((HmacKey) HmacKey.newBuilder().mergeFrom(this.aesCtrHmacAeadKey.getHmacKey()).setKeyValue(ByteString.copyFrom(bArrCopyOfRange2)).build()).build(), Aead.class));
        }
        if (this.demKeyTypeUrl.equals(DeterministicAeadConfig.AES_SIV_TYPE_URL)) {
            return new AeadOrDaead((DeterministicAead) Registry.getPrimitive(this.demKeyTypeUrl, (AesSivKey) AesSivKey.newBuilder().mergeFrom(this.aesSivKey).setKeyValue(ByteString.copyFrom(symmetricKeyValue, 0, this.symmetricKeySize)).build(), DeterministicAead.class));
        }
        throw new GeneralSecurityException("unknown DEM key type");
    }
}

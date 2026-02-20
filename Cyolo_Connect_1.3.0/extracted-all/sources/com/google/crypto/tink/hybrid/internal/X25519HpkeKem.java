package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.X25519;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
final class X25519HpkeKem implements HpkeKem {
    private final HkdfHpkeKdf hkdf;

    X25519HpkeKem(HkdfHpkeKdf hkdf) {
        this.hkdf = hkdf;
    }

    private byte[] deriveKemSharedSecret(byte[] dhSharedSecret, byte[] senderPublicKey, byte[] recipientPublicKey) throws GeneralSecurityException {
        byte[] bArrConcat = Bytes.concat(senderPublicKey, recipientPublicKey);
        byte[] bArrKemSuiteId = HpkeUtil.kemSuiteId(HpkeUtil.X25519_HKDF_SHA256_KEM_ID);
        HkdfHpkeKdf hkdfHpkeKdf = this.hkdf;
        return hkdfHpkeKdf.extractAndExpand(null, dhSharedSecret, "eae_prk", bArrConcat, "shared_secret", bArrKemSuiteId, hkdfHpkeKdf.getMacLength());
    }

    HpkeKemEncapOutput encapsulate(byte[] recipientPublicKey, byte[] senderPrivateKey) throws GeneralSecurityException {
        byte[] bArrComputeSharedSecret = X25519.computeSharedSecret(senderPrivateKey, recipientPublicKey);
        byte[] bArrPublicFromPrivate = X25519.publicFromPrivate(senderPrivateKey);
        return new HpkeKemEncapOutput(deriveKemSharedSecret(bArrComputeSharedSecret, bArrPublicFromPrivate, recipientPublicKey), bArrPublicFromPrivate);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public HpkeKemEncapOutput encapsulate(byte[] recipientPublicKey) throws GeneralSecurityException {
        return encapsulate(recipientPublicKey, X25519.generatePrivateKey());
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] decapsulate(byte[] encapsulatedKey, HpkeKemPrivateKey recipientPrivateKey) throws GeneralSecurityException {
        return deriveKemSharedSecret(X25519.computeSharedSecret(recipientPrivateKey.getSerializedPrivate().toByteArray(), encapsulatedKey), encapsulatedKey, recipientPrivateKey.getSerializedPublic().toByteArray());
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] getKemId() throws GeneralSecurityException {
        if (Arrays.equals(this.hkdf.getKdfId(), HpkeUtil.HKDF_SHA256_KDF_ID)) {
            return HpkeUtil.X25519_HKDF_SHA256_KEM_ID;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}

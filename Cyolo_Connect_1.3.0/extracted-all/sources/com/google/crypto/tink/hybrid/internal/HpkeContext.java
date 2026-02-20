package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.proto.HpkePublicKey;
import com.google.crypto.tink.subtle.Bytes;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
final class HpkeContext {
    private static final byte[] EMPTY_IKM = new byte[0];
    private final HpkeAead aead;
    private final byte[] baseNonce;
    private final byte[] encapsulatedKey;
    private final byte[] key;
    private final BigInteger maxSequenceNumber;
    private BigInteger sequenceNumber = BigInteger.ZERO;

    private HpkeContext(byte[] encapsulatedKey, byte[] key, byte[] baseNonce, BigInteger maxSequenceNumber, HpkeAead aead) {
        this.encapsulatedKey = encapsulatedKey;
        this.key = key;
        this.baseNonce = baseNonce;
        this.maxSequenceNumber = maxSequenceNumber;
        this.aead = aead;
    }

    static HpkeContext createContext(byte[] encapsulatedKey, byte[] sharedSecret, HpkeKem kem, HpkeKdf kdf, HpkeAead aead, byte[] info) throws GeneralSecurityException {
        byte[] bArrHpkeSuiteId = HpkeUtil.hpkeSuiteId(kem.getKemId(), kdf.getKdfId(), aead.getAeadId());
        byte[] bArr = HpkeUtil.EMPTY_SALT;
        byte[] bArr2 = EMPTY_IKM;
        byte[] bArrConcat = Bytes.concat(HpkeUtil.BASE_MODE, kdf.labeledExtract(bArr, bArr2, "psk_id_hash", bArrHpkeSuiteId), kdf.labeledExtract(HpkeUtil.EMPTY_SALT, info, "info_hash", bArrHpkeSuiteId));
        byte[] bArrLabeledExtract = kdf.labeledExtract(sharedSecret, bArr2, "secret", bArrHpkeSuiteId);
        return new HpkeContext(encapsulatedKey, kdf.labeledExpand(bArrLabeledExtract, bArrConcat, "key", bArrHpkeSuiteId, aead.getKeyLength()), kdf.labeledExpand(bArrLabeledExtract, bArrConcat, "base_nonce", bArrHpkeSuiteId, aead.getNonceLength()), maxSequenceNumber(aead.getNonceLength()), aead);
    }

    static HpkeContext createSenderContext(HpkePublicKey recipientPublicKey, HpkeKem kem, HpkeKdf kdf, HpkeAead aead, byte[] info) throws GeneralSecurityException {
        HpkeKemEncapOutput hpkeKemEncapOutputEncapsulate = kem.encapsulate(recipientPublicKey.getPublicKey().toByteArray());
        return createContext(hpkeKemEncapOutputEncapsulate.getEncapsulatedKey(), hpkeKemEncapOutputEncapsulate.getSharedSecret(), kem, kdf, aead, info);
    }

    static HpkeContext createRecipientContext(byte[] encapsulatedKey, HpkeKemPrivateKey recipientPrivateKey, HpkeKem kem, HpkeKdf kdf, HpkeAead aead, byte[] info) throws GeneralSecurityException {
        return createContext(encapsulatedKey, kem.decapsulate(encapsulatedKey, recipientPrivateKey), kem, kdf, aead, info);
    }

    private static BigInteger maxSequenceNumber(int nonceLength) {
        return BigInteger.ONE.shiftLeft(nonceLength * 8).subtract(BigInteger.ONE);
    }

    private void incrementSequenceNumber() throws GeneralSecurityException {
        if (this.sequenceNumber.compareTo(this.maxSequenceNumber) >= 0) {
            throw new GeneralSecurityException("message limit reached");
        }
        this.sequenceNumber = this.sequenceNumber.add(BigInteger.ONE);
    }

    private byte[] computeNonce() throws GeneralSecurityException {
        return Bytes.xor(this.baseNonce, BigIntegerEncoding.toBigEndianBytesOfFixedLength(this.sequenceNumber, this.aead.getNonceLength()));
    }

    private synchronized byte[] computeNonceAndIncrementSequenceNumber() throws GeneralSecurityException {
        byte[] bArrComputeNonce;
        bArrComputeNonce = computeNonce();
        incrementSequenceNumber();
        return bArrComputeNonce;
    }

    byte[] getKey() {
        return this.key;
    }

    byte[] getBaseNonce() {
        return this.baseNonce;
    }

    byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    byte[] seal(byte[] plaintext, byte[] associatedData) throws GeneralSecurityException {
        return this.aead.seal(this.key, computeNonceAndIncrementSequenceNumber(), plaintext, associatedData);
    }

    byte[] open(byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException {
        return this.aead.open(this.key, computeNonceAndIncrementSequenceNumber(), ciphertext, associatedData);
    }
}

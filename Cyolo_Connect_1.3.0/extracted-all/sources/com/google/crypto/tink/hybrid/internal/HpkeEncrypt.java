package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.proto.HpkeParams;
import com.google.crypto.tink.proto.HpkePublicKey;
import com.google.crypto.tink.subtle.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
final class HpkeEncrypt implements HybridEncrypt {
    private static final byte[] EMPTY_ASSOCIATED_DATA = new byte[0];
    private final HpkeAead aead;
    private final HpkeKdf kdf;
    private final HpkeKem kem;
    private final HpkePublicKey recipientPublicKey;

    private HpkeEncrypt(HpkePublicKey recipientPublicKey, HpkeKem kem, HpkeKdf kdf, HpkeAead aead) {
        this.recipientPublicKey = recipientPublicKey;
        this.kem = kem;
        this.kdf = kdf;
        this.aead = aead;
    }

    static HpkeEncrypt createHpkeEncrypt(HpkePublicKey recipientPublicKey) throws GeneralSecurityException {
        if (recipientPublicKey.getPublicKey().isEmpty()) {
            throw new IllegalArgumentException("HpkePublicKey.public_key is empty.");
        }
        HpkeParams params = recipientPublicKey.getParams();
        return new HpkeEncrypt(recipientPublicKey, HpkePrimitiveFactory.createKem(params), HpkePrimitiveFactory.createKdf(params), HpkePrimitiveFactory.createAead(params));
    }

    @Override // com.google.crypto.tink.HybridEncrypt
    public byte[] encrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException {
        if (contextInfo == null) {
            contextInfo = new byte[0];
        }
        HpkeContext hpkeContextCreateSenderContext = HpkeContext.createSenderContext(this.recipientPublicKey, this.kem, this.kdf, this.aead, contextInfo);
        return Bytes.concat(hpkeContextCreateSenderContext.getEncapsulatedKey(), hpkeContextCreateSenderContext.seal(plaintext, EMPTY_ASSOCIATED_DATA));
    }
}

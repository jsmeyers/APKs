package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20Poly1305;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class XChaCha20Poly1305 implements Aead {
    private final InsecureNonceXChaCha20Poly1305 cipher;

    public XChaCha20Poly1305(final byte[] key) throws GeneralSecurityException {
        this.cipher = new InsecureNonceXChaCha20Poly1305(key);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(plaintext.length + 24 + 16);
        byte[] bArrRandBytes = Random.randBytes(24);
        byteBufferAllocate.put(bArrRandBytes);
        this.cipher.encrypt(byteBufferAllocate, bArrRandBytes, plaintext, associatedData);
        return byteBufferAllocate.array();
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext.length < 40) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArrCopyOf = Arrays.copyOf(ciphertext, 24);
        return this.cipher.decrypt(ByteBuffer.wrap(ciphertext, 24, ciphertext.length - 24), bArrCopyOf, associatedData);
    }
}

package com.google.crypto.tink.subtle;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.mac.internal.AesUtil;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class AesSiv implements DeterministicAead {
    private final byte[] aesCtrKey;
    private final PrfAesCmac cmacForS2V;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final Collection<Integer> KEY_SIZES = Arrays.asList(64);
    private static final byte[] BLOCK_ZERO = new byte[16];
    private static final byte[] BLOCK_ONE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    public AesSiv(final byte[] key) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (!KEY_SIZES.contains(Integer.valueOf(key.length))) {
            throw new InvalidKeyException("invalid key size: " + key.length + " bytes; key must have 64 bytes");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(key, 0, key.length / 2);
        this.aesCtrKey = Arrays.copyOfRange(key, key.length / 2, key.length);
        this.cmacForS2V = new PrfAesCmac(bArrCopyOfRange);
    }

    private byte[] s2v(final byte[]... s) throws GeneralSecurityException {
        byte[] bArrXor;
        if (s.length == 0) {
            return this.cmacForS2V.compute(BLOCK_ONE, 16);
        }
        byte[] bArrCompute = this.cmacForS2V.compute(BLOCK_ZERO, 16);
        for (int i = 0; i < s.length - 1; i++) {
            byte[] bArr = s[i];
            if (bArr == null) {
                bArr = new byte[0];
            }
            bArrCompute = Bytes.xor(AesUtil.dbl(bArrCompute), this.cmacForS2V.compute(bArr, 16));
        }
        byte[] bArr2 = s[s.length - 1];
        if (bArr2.length >= 16) {
            bArrXor = Bytes.xorEnd(bArr2, bArrCompute);
        } else {
            bArrXor = Bytes.xor(AesUtil.cmacPad(bArr2), AesUtil.dbl(bArrCompute));
        }
        return this.cmacForS2V.compute(bArrXor, 16);
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public byte[] encryptDeterministically(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext.length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
        byte[] bArrS2v = s2v(associatedData, plaintext);
        byte[] bArr = (byte[]) bArrS2v.clone();
        bArr[8] = (byte) (bArr[8] & 127);
        bArr[12] = (byte) (bArr[12] & 127);
        engineFactory.init(1, new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(bArr));
        return Bytes.concat(bArrS2v, engineFactory.doFinal(plaintext));
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public byte[] decryptDeterministically(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext.length < 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
        byte[] bArrCopyOfRange = Arrays.copyOfRange(ciphertext, 0, 16);
        byte[] bArr = (byte[]) bArrCopyOfRange.clone();
        bArr[8] = (byte) (bArr[8] & 127);
        bArr[12] = (byte) (bArr[12] & 127);
        engineFactory.init(2, new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(bArr));
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(ciphertext, 16, ciphertext.length);
        byte[] bArrDoFinal = engineFactory.doFinal(bArrCopyOfRange2);
        if (bArrCopyOfRange2.length == 0 && bArrDoFinal == null && SubtleUtil.isAndroid()) {
            bArrDoFinal = new byte[0];
        }
        if (Bytes.equal(bArrCopyOfRange, s2v(associatedData, bArrDoFinal))) {
            return bArrDoFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }
}

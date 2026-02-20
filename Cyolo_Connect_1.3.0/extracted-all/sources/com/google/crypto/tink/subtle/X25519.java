package com.google.crypto.tink.subtle;

import com.google.common.primitives.SignedBytes;
import java.security.InvalidKeyException;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
public final class X25519 {
    public static byte[] generatePrivateKey() {
        byte[] bArrRandBytes = Random.randBytes(32);
        bArrRandBytes[0] = (byte) (bArrRandBytes[0] | 7);
        byte b = (byte) (bArrRandBytes[31] & Utf8.REPLACEMENT_BYTE);
        bArrRandBytes[31] = b;
        bArrRandBytes[31] = (byte) (b | 128);
        return bArrRandBytes;
    }

    public static byte[] computeSharedSecret(byte[] privateKey, byte[] peersPublicValue) throws InvalidKeyException {
        if (privateKey.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] bArrCopyOf = Arrays.copyOf(privateKey, 32);
        bArrCopyOf[0] = (byte) (bArrCopyOf[0] & 248);
        byte b = (byte) (bArrCopyOf[31] & 127);
        bArrCopyOf[31] = b;
        bArrCopyOf[31] = (byte) (b | SignedBytes.MAX_POWER_OF_TWO);
        Curve25519.curveMult(jArr, bArrCopyOf, peersPublicValue);
        return Field25519.contract(jArr);
    }

    public static byte[] publicFromPrivate(byte[] privateKey) throws InvalidKeyException {
        if (privateKey.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        byte[] bArr = new byte[32];
        bArr[0] = 9;
        return computeSharedSecret(privateKey, bArr);
    }

    private X25519() {
    }
}

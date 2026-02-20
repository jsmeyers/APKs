package com.it_nomads.fluttersecurestorage.ciphers;

/* JADX INFO: loaded from: classes3.dex */
public interface StorageCipher {
    byte[] decrypt(byte[] bArr) throws Exception;

    byte[] encrypt(byte[] bArr) throws Exception;
}

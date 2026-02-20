package com.it_nomads.fluttersecurestorage.ciphers;

import java.security.Key;

/* JADX INFO: loaded from: classes3.dex */
public interface KeyCipher {
    Key unwrap(byte[] bArr, String str) throws Exception;

    byte[] wrap(Key key) throws Exception;
}

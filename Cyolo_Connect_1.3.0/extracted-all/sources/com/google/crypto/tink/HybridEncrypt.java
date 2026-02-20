package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public interface HybridEncrypt {
    byte[] encrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException;
}

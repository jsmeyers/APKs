package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public interface PublicKeyVerify {
    void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException;
}

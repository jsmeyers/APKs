package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public interface PublicKeySign {
    byte[] sign(final byte[] data) throws GeneralSecurityException;
}

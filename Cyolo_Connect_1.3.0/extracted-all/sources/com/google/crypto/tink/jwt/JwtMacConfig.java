package com.google.crypto.tink.jwt;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public final class JwtMacConfig {
    public static final String JWT_HMAC_TYPE_URL = new JwtHmacKeyManager().getKeyType();

    public static void register() throws GeneralSecurityException {
        JwtHmacKeyManager.register(true);
        JwtMacWrapper.register();
    }

    private JwtMacConfig() {
    }
}

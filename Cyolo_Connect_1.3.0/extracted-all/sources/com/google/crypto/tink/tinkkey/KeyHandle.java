package com.google.crypto.tink.tinkkey;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@Deprecated
public class KeyHandle {
    private final int id;
    private final TinkKey key;
    private final KeyStatusType status;

    public enum KeyStatusType {
        ENABLED,
        DISABLED,
        DESTROYED
    }

    public static KeyHandle createFromKey(TinkKey key, KeyAccess access) throws GeneralSecurityException {
        KeyHandle keyHandle = new KeyHandle(key);
        keyHandle.checkAccess(access);
        return keyHandle;
    }

    @Deprecated
    public static KeyHandle createFromKey(KeyData keyData, KeyTemplate.OutputPrefixType opt) {
        return new KeyHandle(new ProtoKey(keyData, opt));
    }

    private KeyHandle(TinkKey key) {
        this.key = key;
        this.status = KeyStatusType.ENABLED;
        this.id = Util.randKeyId();
    }

    protected KeyHandle(TinkKey key, KeyStatusType status, int keyId) {
        this.key = key;
        this.status = status;
        this.id = keyId;
    }

    public static KeyHandle generateNew(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return new KeyHandle(new ProtoKey(Registry.newKeyData(keyTemplate), keyTemplate.getOutputPrefixType()));
    }

    public boolean hasSecret() {
        return this.key.hasSecret();
    }

    public KeyStatusType getStatus() {
        return this.status;
    }

    public int getId() {
        return this.id;
    }

    public TinkKey getKey(KeyAccess access) throws GeneralSecurityException {
        checkAccess(access);
        return this.key;
    }

    public KeyTemplate getKeyTemplate() {
        return this.key.getKeyTemplate();
    }

    private void checkAccess(KeyAccess access) throws GeneralSecurityException {
        if (hasSecret() && !access.canAccessSecret()) {
            throw new GeneralSecurityException("No access");
        }
    }
}

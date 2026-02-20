package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.InputStream;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public class PrivilegedRegistry {
    private PrivilegedRegistry() {
    }

    public static KeyData deriveKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate, InputStream randomStream) throws GeneralSecurityException {
        return Registry.deriveKey(keyTemplate, randomStream);
    }

    public static MessageLite parseKeyData(KeyData keyData) throws InvalidProtocolBufferException, GeneralSecurityException {
        return Registry.parseKeyData(keyData);
    }
}

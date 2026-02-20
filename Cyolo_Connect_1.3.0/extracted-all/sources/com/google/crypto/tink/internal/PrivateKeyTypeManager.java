package com.google.crypto.tink.internal;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PrivateKeyTypeManager<KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> extends KeyTypeManager<KeyProtoT> {
    private final Class<PublicKeyProtoT> publicKeyClazz;

    public abstract PublicKeyProtoT getPublicKey(KeyProtoT keyProto) throws GeneralSecurityException;

    @SafeVarargs
    protected PrivateKeyTypeManager(Class<KeyProtoT> clazz, Class<PublicKeyProtoT> publicKeyClazz, PrimitiveFactory<?, KeyProtoT>... factories) {
        super(clazz, factories);
        this.publicKeyClazz = publicKeyClazz;
    }

    public final Class<PublicKeyProtoT> getPublicKeyClass() {
        return this.publicKeyClazz;
    }
}

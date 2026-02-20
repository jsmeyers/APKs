package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> messageType);
}

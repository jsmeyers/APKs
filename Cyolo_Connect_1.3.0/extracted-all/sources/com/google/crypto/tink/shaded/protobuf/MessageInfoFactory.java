package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
interface MessageInfoFactory {
    boolean isSupported(Class<?> clazz);

    MessageInfo messageInfoFor(Class<?> clazz);
}

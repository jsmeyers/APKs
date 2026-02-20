package com.it_nomads.fluttersecurestorage.ciphers;

import android.content.Context;

/* JADX INFO: compiled from: StorageCipherFactory.java */
/* JADX INFO: loaded from: classes3.dex */
@FunctionalInterface
interface KeyCipherFunction {
    KeyCipher apply(Context context) throws Exception;
}

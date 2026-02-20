package com.it_nomads.fluttersecurestorage.ciphers;

import android.content.Context;

/* JADX INFO: compiled from: StorageCipherFactory.java */
/* JADX INFO: loaded from: classes3.dex */
@FunctionalInterface
interface StorageCipherFunction {
    StorageCipher apply(Context context, KeyCipher keyCipher) throws Exception;
}

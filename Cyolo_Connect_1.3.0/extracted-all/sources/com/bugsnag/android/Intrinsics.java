package com.bugsnag.android;

/* JADX INFO: loaded from: classes.dex */
class Intrinsics {
    Intrinsics() {
    }

    static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}

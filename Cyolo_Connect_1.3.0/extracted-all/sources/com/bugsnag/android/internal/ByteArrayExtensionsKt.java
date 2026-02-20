package com.bugsnag.android.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: ByteArrayExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"HEX_RADIX", "", "toHexString", "", "", "bugsnag-android-core_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ByteArrayExtensionsKt {
    private static final int HEX_RADIX = 16;

    public static final String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            byte b = bArr[i];
            i++;
            int i2 = b & 255;
            if (i2 < 16) {
                sb.append('0');
            }
            String string = Integer.toString(i2, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            sb.append(string);
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder(capacity).…builderAction).toString()");
        return string2;
    }
}

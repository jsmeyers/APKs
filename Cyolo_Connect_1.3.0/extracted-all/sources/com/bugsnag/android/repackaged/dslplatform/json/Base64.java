package com.bugsnag.android.repackaged.dslplatform.json;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
abstract class Base64 {
    private static final byte[] BA;
    private static final char[] CA;
    private static final byte[] EMPTY_ARRAY;
    private static final int[] IA;

    Base64() {
    }

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            IA[CA[i]] = i;
        }
        IA[61] = 0;
        BA = new byte[CA.length];
        int i2 = 0;
        while (true) {
            char[] cArr = CA;
            if (i2 < cArr.length) {
                BA[i2] = (byte) cArr[i2];
                i2++;
            } else {
                EMPTY_ARRAY = new byte[0];
                return;
            }
        }
    }

    static int encodeToBytes(byte[] bArr, byte[] bArr2, int i) {
        int length = bArr.length;
        int i2 = (length / 3) * 3;
        int i3 = length - 1;
        int i4 = ((i3 / 3) + 1) << 2;
        int i5 = i;
        int i6 = 0;
        while (i6 < i2) {
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 8);
            int i10 = i8 + 1;
            int i11 = i9 | (bArr[i8] & 255);
            int i12 = i5 + 1;
            byte[] bArr3 = BA;
            bArr2[i5] = bArr3[(i11 >>> 18) & 63];
            int i13 = i12 + 1;
            bArr2[i12] = bArr3[(i11 >>> 12) & 63];
            int i14 = i13 + 1;
            bArr2[i13] = bArr3[(i11 >>> 6) & 63];
            i5 = i14 + 1;
            bArr2[i14] = bArr3[i11 & 63];
            i6 = i10;
        }
        int i15 = length - i2;
        if (i15 > 0) {
            int i16 = ((bArr[i2] & 255) << 10) | (i15 == 2 ? (bArr[i3] & 255) << 2 : 0);
            int i17 = i + i4;
            byte[] bArr4 = BA;
            bArr2[i17 - 4] = bArr4[i16 >> 12];
            bArr2[i17 - 3] = bArr4[(i16 >>> 6) & 63];
            bArr2[i17 - 2] = i15 == 2 ? bArr4[i16 & 63] : kotlin.io.encoding.Base64.padSymbol;
            bArr2[i17 - 1] = kotlin.io.encoding.Base64.padSymbol;
        }
        return i4;
    }

    static int findEnd(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (IA[bArr[i] & 255] < 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    static byte[] decodeFast(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = i2 - i;
        if (i4 == 0) {
            return EMPTY_ARRAY;
        }
        int i5 = i2 - 1;
        while (i < i5 && IA[bArr[i] & 255] < 0) {
            i++;
        }
        while (i5 > 0 && IA[bArr[i5] & 255] < 0) {
            i5--;
        }
        int i6 = 0;
        int i7 = bArr[i5] == 61 ? bArr[i5 + (-1)] == 61 ? 2 : 1 : 0;
        int i8 = (i5 - i) + 1;
        if (i4 > 76) {
            i3 = (bArr[76] == 13 ? i8 / 78 : 0) << 1;
        } else {
            i3 = 0;
        }
        int i9 = (((i8 - i3) * 6) >> 3) - i7;
        byte[] bArr2 = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int[] iArr = IA;
            int i13 = i + 1;
            int i14 = i13 + 1;
            int i15 = (iArr[bArr[i]] << 18) | (iArr[bArr[i13]] << 12);
            int i16 = i14 + 1;
            int i17 = i15 | (iArr[bArr[i14]] << 6);
            int i18 = i16 + 1;
            int i19 = i17 | iArr[bArr[i16]];
            int i20 = i11 + 1;
            bArr2[i11] = (byte) (i19 >> 16);
            int i21 = i20 + 1;
            bArr2[i20] = (byte) (i19 >> 8);
            int i22 = i21 + 1;
            bArr2[i21] = (byte) i19;
            if (i3 <= 0 || (i12 = i12 + 1) != 19) {
                i = i18;
            } else {
                i = i18 + 2;
                i12 = 0;
            }
            i11 = i22;
        }
        if (i11 < i9) {
            int i23 = 0;
            while (i <= i5 - i7) {
                i6 |= IA[bArr[i]] << (18 - (i23 * 6));
                i23++;
                i++;
            }
            int i24 = 16;
            while (i11 < i9) {
                bArr2[i11] = (byte) (i6 >> i24);
                i24 -= 8;
                i11++;
            }
        }
        return bArr2;
    }
}

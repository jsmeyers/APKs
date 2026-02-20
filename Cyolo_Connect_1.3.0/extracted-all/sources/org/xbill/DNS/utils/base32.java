package org.xbill.DNS.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class base32 {
    private String alphabet;
    private boolean lowercase;
    private boolean padding;

    private static int blockLenToPadding(int i) {
        if (i == 1) {
            return 6;
        }
        if (i == 2) {
            return 4;
        }
        if (i == 3) {
            return 3;
        }
        if (i != 4) {
            return i != 5 ? -1 : 0;
        }
        return 1;
    }

    private static int paddingToBlockLen(int i) {
        if (i == 0) {
            return 5;
        }
        if (i == 1) {
            return 4;
        }
        if (i == 3) {
            return 3;
        }
        if (i != 4) {
            return i != 6 ? -1 : 1;
        }
        return 2;
    }

    public static class Alphabet {
        public static final String BASE32 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=";
        public static final String BASE32HEX = "0123456789ABCDEFGHIJKLMNOPQRSTUV=";

        private Alphabet() {
        }
    }

    public base32(String str, boolean z, boolean z2) {
        this.alphabet = str;
        this.padding = z;
        this.lowercase = z2;
    }

    public String toString(byte[] bArr) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < (bArr.length + 4) / 5; i2++) {
            short[] sArr = new short[5];
            int[] iArr = new int[8];
            int i3 = 5;
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = (i2 * 5) + i4;
                if (i5 < bArr.length) {
                    sArr[i4] = (short) (bArr[i5] & 255);
                } else {
                    sArr[i4] = 0;
                    i3--;
                }
            }
            int iBlockLenToPadding = blockLenToPadding(i3);
            short s = sArr[0];
            iArr[0] = (byte) ((s >> 3) & 31);
            short s2 = sArr[1];
            iArr[1] = (byte) (((s & 7) << 2) | ((s2 >> 6) & 3));
            iArr[2] = (byte) ((s2 >> 1) & 31);
            short s3 = sArr[2];
            iArr[3] = (byte) (((s2 & 1) << 4) | ((s3 >> 4) & 15));
            int i6 = (s3 & 15) << 1;
            short s4 = sArr[3];
            iArr[4] = (byte) (i6 | (1 & (s4 >> 7)));
            iArr[5] = (byte) ((s4 >> 2) & 31);
            short s5 = sArr[4];
            iArr[6] = (byte) (((s5 >> 5) & 7) | ((s4 & 3) << 3));
            iArr[7] = (byte) (s5 & 31);
            int i7 = 0;
            while (true) {
                i = 8 - iBlockLenToPadding;
                if (i7 >= i) {
                    break;
                }
                char cCharAt = this.alphabet.charAt(iArr[i7]);
                if (this.lowercase) {
                    cCharAt = Character.toLowerCase(cCharAt);
                }
                byteArrayOutputStream.write(cCharAt);
                i7++;
            }
            if (this.padding) {
                while (i < 8) {
                    byteArrayOutputStream.write(61);
                    i++;
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public byte[] fromString(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b : str.getBytes()) {
            char c = (char) b;
            if (!Character.isWhitespace(c)) {
                byteArrayOutputStream.write((byte) Character.toUpperCase(c));
            }
        }
        if (this.padding) {
            if (byteArrayOutputStream.size() % 8 != 0) {
                return null;
            }
        } else {
            while (byteArrayOutputStream.size() % 8 != 0) {
                byteArrayOutputStream.write(61);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i = 0; i < byteArray.length / 8; i++) {
            short[] sArr = new short[8];
            int[] iArr = new int[5];
            int i2 = 8;
            for (int i3 = 0; i3 < 8; i3++) {
                byte b2 = byteArray[(i * 8) + i3];
                if (((char) b2) == '=') {
                    break;
                }
                short sIndexOf = (short) this.alphabet.indexOf(b2);
                sArr[i3] = sIndexOf;
                if (sIndexOf < 0) {
                    return null;
                }
                i2--;
            }
            int iPaddingToBlockLen = paddingToBlockLen(i2);
            if (iPaddingToBlockLen < 0) {
                return null;
            }
            int i4 = sArr[0] << 3;
            short s = sArr[1];
            iArr[0] = i4 | (s >> 2);
            int i5 = ((s & 3) << 6) | (sArr[2] << 1);
            short s2 = sArr[3];
            iArr[1] = i5 | (s2 >> 4);
            int i6 = (s2 & 15) << 4;
            short s3 = sArr[4];
            iArr[2] = i6 | ((s3 >> 1) & 15);
            int i7 = (s3 << 7) | (sArr[5] << 2);
            short s4 = sArr[6];
            iArr[3] = i7 | (s4 >> 3);
            iArr[4] = sArr[7] | ((s4 & 7) << 5);
            for (int i8 = 0; i8 < iPaddingToBlockLen; i8++) {
                try {
                    dataOutputStream.writeByte((byte) (iArr[i8] & 255));
                } catch (IOException unused) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}

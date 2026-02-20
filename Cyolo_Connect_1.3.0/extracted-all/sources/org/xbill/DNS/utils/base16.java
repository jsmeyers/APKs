package org.xbill.DNS.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class base16 {
    private static final String Base16 = "0123456789ABCDEF";

    private base16() {
    }

    public static String toString(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b : bArr) {
            short s = (short) (b & 255);
            byteArrayOutputStream.write(Base16.charAt((byte) (s >> 4)));
            byteArrayOutputStream.write(Base16.charAt((byte) (s & 15)));
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public static byte[] fromString(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b : str.getBytes()) {
            if (!Character.isWhitespace((char) b)) {
                byteArrayOutputStream.write(b);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length % 2 != 0) {
            return null;
        }
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i = 0; i < byteArray.length; i += 2) {
            try {
                dataOutputStream.writeByte((((byte) Base16.indexOf(Character.toUpperCase((char) byteArray[i]))) << 4) + ((byte) Base16.indexOf(Character.toUpperCase((char) byteArray[i + 1]))));
            } catch (IOException unused) {
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}

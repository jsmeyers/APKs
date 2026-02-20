package net.openid.appauth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes3.dex */
class Utils {
    private static final int INITIAL_READ_BUFFER_SIZE = 1024;

    private Utils() {
        throw new IllegalStateException("This type is not intended to be instantiated");
    }

    public static String readInputStream(InputStream in) throws IOException {
        if (in == null) {
            throw new IOException("Input stream must not be null");
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        char[] cArr = new char[1024];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = bufferedReader.read(cArr);
            if (i != -1) {
                sb.append(cArr, 0, i);
            } else {
                return sb.toString();
            }
        }
    }

    public static void closeQuietly(InputStream in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException unused) {
            }
        }
    }
}

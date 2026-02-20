package com.bugsnag.android;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import org.xbill.DNS.TTL;

/* JADX INFO: loaded from: classes.dex */
class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;

    IOUtils() {
    }

    static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    static int copy(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[4096];
        long j = 0;
        while (true) {
            int i = reader.read(cArr);
            if (-1 == i) {
                break;
            }
            writer.write(cArr, 0, i);
            j += (long) i;
        }
        if (j > TTL.MAX_VALUE) {
            return -1;
        }
        return (int) j;
    }

    static void deleteFile(File file, Logger logger) {
        try {
            if (file.delete()) {
                return;
            }
            file.deleteOnExit();
        } catch (Exception e) {
            logger.w("Failed to delete file", e);
        }
    }
}

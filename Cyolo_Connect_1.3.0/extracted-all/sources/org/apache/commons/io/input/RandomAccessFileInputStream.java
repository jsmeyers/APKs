package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Objects;
import org.xbill.DNS.TTL;

/* JADX INFO: loaded from: classes3.dex */
public class RandomAccessFileInputStream extends InputStream {
    private final boolean closeOnClose;
    private final RandomAccessFile randomAccessFile;

    public RandomAccessFileInputStream(RandomAccessFile randomAccessFile) {
        this(randomAccessFile, false);
    }

    public RandomAccessFileInputStream(RandomAccessFile randomAccessFile, boolean z) {
        this.randomAccessFile = (RandomAccessFile) Objects.requireNonNull(randomAccessFile, "file");
        this.closeOnClose = z;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long jAvailableLong = availableLong();
        if (jAvailableLong > TTL.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) jAvailableLong;
    }

    public long availableLong() throws IOException {
        return this.randomAccessFile.length() - this.randomAccessFile.getFilePointer();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.closeOnClose) {
            this.randomAccessFile.close();
        }
    }

    public RandomAccessFile getRandomAccessFile() {
        return this.randomAccessFile;
    }

    public boolean isCloseOnClose() {
        return this.closeOnClose;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.randomAccessFile.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.randomAccessFile.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.randomAccessFile.read(bArr, i, i2);
    }

    private void seek(long j) throws IOException {
        this.randomAccessFile.seek(j);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        long filePointer = this.randomAccessFile.getFilePointer();
        long length = this.randomAccessFile.length();
        if (filePointer >= length) {
            return 0L;
        }
        long j2 = j + filePointer;
        if (j2 > length) {
            j2 = length - 1;
        }
        if (j2 > 0) {
            seek(j2);
        }
        return this.randomAccessFile.getFilePointer() - filePointer;
    }
}

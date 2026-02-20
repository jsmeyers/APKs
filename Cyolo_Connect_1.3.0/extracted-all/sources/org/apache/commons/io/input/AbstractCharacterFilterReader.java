package org.apache.commons.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractCharacterFilterReader extends FilterReader {
    protected abstract boolean filter(int i);

    protected AbstractCharacterFilterReader(Reader reader) {
        super(reader);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws IOException {
        int i;
        do {
            i = this.in.read();
        } while (filter(i));
        return i;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3 = super.read(cArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        int i4 = i - 1;
        for (int i5 = i; i5 < i + i3; i5++) {
            if (!filter(cArr[i5]) && (i4 = i4 + 1) < i5) {
                cArr[i4] = cArr[i5];
            }
        }
        return (i4 - i) + 1;
    }
}

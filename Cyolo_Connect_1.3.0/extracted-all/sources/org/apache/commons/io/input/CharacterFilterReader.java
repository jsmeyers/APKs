package org.apache.commons.io.input;

import java.io.Reader;

/* JADX INFO: loaded from: classes3.dex */
public class CharacterFilterReader extends AbstractCharacterFilterReader {
    private final int skip;

    public CharacterFilterReader(Reader reader, int i) {
        super(reader);
        this.skip = i;
    }

    @Override // org.apache.commons.io.input.AbstractCharacterFilterReader
    protected boolean filter(int i) {
        return i == this.skip;
    }
}

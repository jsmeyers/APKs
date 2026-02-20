package org.xbill.DNS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.xbill.DNS.Tokenizer;

/* JADX INFO: loaded from: classes2.dex */
abstract class TXTBase extends Record {
    protected List<byte[]> strings;

    protected TXTBase() {
    }

    protected TXTBase(Name name, int i, int i2, long j) {
        super(name, i, i2, j);
    }

    protected TXTBase(Name name, int i, int i2, long j, List<String> list) {
        super(name, i, i2, j);
        if (list == null) {
            throw new IllegalArgumentException("strings must not be null");
        }
        this.strings = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                this.strings.add(byteArrayFromString(it.next()));
            } catch (TextParseException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }

    protected TXTBase(Name name, int i, int i2, long j, String str) {
        this(name, i, i2, j, (List<String>) Collections.singletonList(str));
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.strings = new ArrayList(2);
        while (dNSInput.remaining() > 0) {
            this.strings.add(dNSInput.readCountedString());
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.strings = new ArrayList(2);
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (token.isString()) {
                try {
                    this.strings.add(byteArrayFromString(token.value));
                } catch (TextParseException e) {
                    throw tokenizer.exception(e.getMessage());
                }
            } else {
                tokenizer.unget();
                return;
            }
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        Iterator<byte[]> it = this.strings.iterator();
        while (it.hasNext()) {
            sb.append(byteArrayToString(it.next(), true));
            if (it.hasNext()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public List<String> getStrings() {
        ArrayList arrayList = new ArrayList(this.strings.size());
        Iterator<byte[]> it = this.strings.iterator();
        while (it.hasNext()) {
            arrayList.add(byteArrayToString(it.next(), false));
        }
        return arrayList;
    }

    public List<byte[]> getStringsAsByteArrays() {
        return this.strings;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        Iterator<byte[]> it = this.strings.iterator();
        while (it.hasNext()) {
            dNSOutput.writeCountedString(it.next());
        }
    }
}

package org.xbill.DNS;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TXTRecord extends TXTBase {
    @Override // org.xbill.DNS.TXTBase
    public /* bridge */ /* synthetic */ List getStrings() {
        return super.getStrings();
    }

    @Override // org.xbill.DNS.TXTBase
    public /* bridge */ /* synthetic */ List getStringsAsByteArrays() {
        return super.getStringsAsByteArrays();
    }

    TXTRecord() {
    }

    public TXTRecord(Name name, int i, long j, List<String> list) {
        super(name, 16, i, j, list);
    }

    public TXTRecord(Name name, int i, long j, String str) {
        super(name, 16, i, j, str);
    }
}

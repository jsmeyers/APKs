package org.xbill.DNS;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SPFRecord extends TXTBase {
    @Override // org.xbill.DNS.TXTBase
    public /* bridge */ /* synthetic */ List getStrings() {
        return super.getStrings();
    }

    @Override // org.xbill.DNS.TXTBase
    public /* bridge */ /* synthetic */ List getStringsAsByteArrays() {
        return super.getStringsAsByteArrays();
    }

    SPFRecord() {
    }

    public SPFRecord(Name name, int i, long j, List<String> list) {
        super(name, 99, i, j, list);
    }

    public SPFRecord(Name name, int i, long j, String str) {
        super(name, 99, i, j, str);
    }
}

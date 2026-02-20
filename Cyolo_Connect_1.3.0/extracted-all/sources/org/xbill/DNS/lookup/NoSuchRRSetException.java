package org.xbill.DNS.lookup;

import org.xbill.DNS.Name;

/* JADX INFO: loaded from: classes2.dex */
public class NoSuchRRSetException extends LookupFailedException {
    public NoSuchRRSetException(Name name, int i) {
        super(name, i);
    }
}

package org.xbill.DNS.lookup;

import org.xbill.DNS.Name;

/* JADX INFO: loaded from: classes2.dex */
public class NoSuchDomainException extends LookupFailedException {
    public NoSuchDomainException(Name name, int i) {
        super(name, i);
    }
}

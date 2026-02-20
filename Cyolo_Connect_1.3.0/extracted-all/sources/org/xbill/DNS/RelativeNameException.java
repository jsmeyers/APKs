package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class RelativeNameException extends IllegalArgumentException {
    public RelativeNameException(Name name) {
        super("'" + name + "' is not an absolute name");
    }

    public RelativeNameException(String str) {
        super(str);
    }
}

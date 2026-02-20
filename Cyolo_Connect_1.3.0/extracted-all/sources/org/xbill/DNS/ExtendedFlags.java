package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public final class ExtendedFlags {
    public static final int DO = 32768;
    private static Mnemonic extflags;

    static {
        Mnemonic mnemonic = new Mnemonic("EDNS Flag", 3);
        extflags = mnemonic;
        mnemonic.setMaximum(65535);
        extflags.setPrefix("FLAG");
        extflags.setNumericAllowed(true);
        extflags.add(32768, "do");
    }

    private ExtendedFlags() {
    }

    public static String string(int i) {
        return extflags.getText(i);
    }

    public static int value(String str) {
        return extflags.getValue(str);
    }
}

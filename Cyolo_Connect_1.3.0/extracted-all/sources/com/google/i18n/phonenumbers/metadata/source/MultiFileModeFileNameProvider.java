package com.google.i18n.phonenumbers.metadata.source;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class MultiFileModeFileNameProvider implements PhoneMetadataFileNameProvider {
    private static final Pattern ALPHANUMERIC = Pattern.compile("^[\\p{L}\\p{N}]+$");
    private final String phoneMetadataFileNamePrefix;

    public MultiFileModeFileNameProvider(String str) {
        this.phoneMetadataFileNamePrefix = str + "_";
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.PhoneMetadataFileNameProvider
    public String getFor(Object obj) {
        String string = obj.toString();
        if (!ALPHANUMERIC.matcher(string).matches()) {
            throw new IllegalArgumentException("Invalid key: " + string);
        }
        return this.phoneMetadataFileNamePrefix + obj;
    }
}

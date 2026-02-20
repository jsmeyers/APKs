package com.google.i18n.phonenumbers.metadata.source;

/* JADX INFO: loaded from: classes3.dex */
public final class SingleFileModeFileNameProvider implements PhoneMetadataFileNameProvider {
    private final String phoneMetadataFileName;

    public SingleFileModeFileNameProvider(String str) {
        this.phoneMetadataFileName = str;
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.PhoneMetadataFileNameProvider
    public String getFor(Object obj) {
        return this.phoneMetadataFileName;
    }
}

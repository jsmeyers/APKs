package com.google.i18n.phonenumbers.metadata;

import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.metadata.init.ClassPathResourceMetadataLoader;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;
import com.google.i18n.phonenumbers.metadata.source.FormattingMetadataSource;
import com.google.i18n.phonenumbers.metadata.source.FormattingMetadataSourceImpl;
import com.google.i18n.phonenumbers.metadata.source.MetadataSource;
import com.google.i18n.phonenumbers.metadata.source.MetadataSourceImpl;
import com.google.i18n.phonenumbers.metadata.source.MultiFileModeFileNameProvider;
import com.google.i18n.phonenumbers.metadata.source.PhoneMetadataFileNameProvider;
import com.google.i18n.phonenumbers.metadata.source.RegionMetadataSource;
import com.google.i18n.phonenumbers.metadata.source.RegionMetadataSourceImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultMetadataDependenciesProvider {
    private static final DefaultMetadataDependenciesProvider INSTANCE = new DefaultMetadataDependenciesProvider();
    private final PhoneMetadataFileNameProvider alternateFormatsMetadataFileNameProvider;
    private final FormattingMetadataSource alternateFormatsMetadataSource;
    private final MetadataLoader metadataLoader;
    private final MetadataParser metadataParser;
    private final PhoneMetadataFileNameProvider phoneNumberMetadataFileNameProvider;
    private final MetadataSource phoneNumberMetadataSource;
    private final PhoneMetadataFileNameProvider shortNumberMetadataFileNameProvider;
    private final RegionMetadataSource shortNumberMetadataSource;

    public String getCarrierDataDirectory() {
        return "/com/google/i18n/phonenumbers/carrier/data/";
    }

    public String getGeocodingDataDirectory() {
        return "/com/google/i18n/phonenumbers/geocoding/data/";
    }

    public static DefaultMetadataDependenciesProvider getInstance() {
        return INSTANCE;
    }

    private DefaultMetadataDependenciesProvider() {
        MetadataParser metadataParserNewLenientParser = MetadataParser.newLenientParser();
        this.metadataParser = metadataParserNewLenientParser;
        ClassPathResourceMetadataLoader classPathResourceMetadataLoader = new ClassPathResourceMetadataLoader();
        this.metadataLoader = classPathResourceMetadataLoader;
        MultiFileModeFileNameProvider multiFileModeFileNameProvider = new MultiFileModeFileNameProvider("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto");
        this.phoneNumberMetadataFileNameProvider = multiFileModeFileNameProvider;
        this.phoneNumberMetadataSource = new MetadataSourceImpl(multiFileModeFileNameProvider, classPathResourceMetadataLoader, metadataParserNewLenientParser);
        MultiFileModeFileNameProvider multiFileModeFileNameProvider2 = new MultiFileModeFileNameProvider("/com/google/i18n/phonenumbers/data/ShortNumberMetadataProto");
        this.shortNumberMetadataFileNameProvider = multiFileModeFileNameProvider2;
        this.shortNumberMetadataSource = new RegionMetadataSourceImpl(multiFileModeFileNameProvider2, classPathResourceMetadataLoader, metadataParserNewLenientParser);
        MultiFileModeFileNameProvider multiFileModeFileNameProvider3 = new MultiFileModeFileNameProvider("/com/google/i18n/phonenumbers/data/PhoneNumberAlternateFormatsProto");
        this.alternateFormatsMetadataFileNameProvider = multiFileModeFileNameProvider3;
        this.alternateFormatsMetadataSource = new FormattingMetadataSourceImpl(multiFileModeFileNameProvider3, classPathResourceMetadataLoader, metadataParserNewLenientParser);
    }

    public MetadataParser getMetadataParser() {
        return this.metadataParser;
    }

    public MetadataLoader getMetadataLoader() {
        return this.metadataLoader;
    }

    public PhoneMetadataFileNameProvider getPhoneNumberMetadataFileNameProvider() {
        return this.phoneNumberMetadataFileNameProvider;
    }

    public MetadataSource getPhoneNumberMetadataSource() {
        return this.phoneNumberMetadataSource;
    }

    public PhoneMetadataFileNameProvider getShortNumberMetadataFileNameProvider() {
        return this.shortNumberMetadataFileNameProvider;
    }

    public RegionMetadataSource getShortNumberMetadataSource() {
        return this.shortNumberMetadataSource;
    }

    public PhoneMetadataFileNameProvider getAlternateFormatsMetadataFileNameProvider() {
        return this.alternateFormatsMetadataFileNameProvider;
    }

    public FormattingMetadataSource getAlternateFormatsMetadataSource() {
        return this.alternateFormatsMetadataSource;
    }
}

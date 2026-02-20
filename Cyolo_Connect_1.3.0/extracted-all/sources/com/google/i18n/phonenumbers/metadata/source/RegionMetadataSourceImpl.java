package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.internal.GeoEntityUtility;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;

/* JADX INFO: loaded from: classes3.dex */
public final class RegionMetadataSourceImpl implements RegionMetadataSource {
    private final MetadataBootstrappingGuard<MapBackedMetadataContainer<String>> bootstrappingGuard;
    private final PhoneMetadataFileNameProvider phoneMetadataFileNameProvider;

    public RegionMetadataSourceImpl(PhoneMetadataFileNameProvider phoneMetadataFileNameProvider, MetadataBootstrappingGuard<MapBackedMetadataContainer<String>> metadataBootstrappingGuard) {
        this.phoneMetadataFileNameProvider = phoneMetadataFileNameProvider;
        this.bootstrappingGuard = metadataBootstrappingGuard;
    }

    public RegionMetadataSourceImpl(PhoneMetadataFileNameProvider phoneMetadataFileNameProvider, MetadataLoader metadataLoader, MetadataParser metadataParser) {
        this(phoneMetadataFileNameProvider, new BlockingMetadataBootstrappingGuard(metadataLoader, metadataParser, MapBackedMetadataContainer.byRegionCode()));
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.RegionMetadataSource
    public Phonemetadata.PhoneMetadata getMetadataForRegion(String str) {
        if (!GeoEntityUtility.isGeoEntity(str)) {
            throw new IllegalArgumentException(str + " region code is a non-geo entity");
        }
        return ((MapBackedMetadataContainer) this.bootstrappingGuard.getOrBootstrap(this.phoneMetadataFileNameProvider.getFor(str))).getMetadataBy(str);
    }
}

package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.internal.GeoEntityUtility;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;

/* JADX INFO: loaded from: classes3.dex */
public final class MetadataSourceImpl implements MetadataSource {
    private final MetadataBootstrappingGuard<CompositeMetadataContainer> bootstrappingGuard;
    private final PhoneMetadataFileNameProvider phoneMetadataFileNameProvider;

    public MetadataSourceImpl(PhoneMetadataFileNameProvider phoneMetadataFileNameProvider, MetadataBootstrappingGuard<CompositeMetadataContainer> metadataBootstrappingGuard) {
        this.phoneMetadataFileNameProvider = phoneMetadataFileNameProvider;
        this.bootstrappingGuard = metadataBootstrappingGuard;
    }

    public MetadataSourceImpl(PhoneMetadataFileNameProvider phoneMetadataFileNameProvider, MetadataLoader metadataLoader, MetadataParser metadataParser) {
        this(phoneMetadataFileNameProvider, new BlockingMetadataBootstrappingGuard(metadataLoader, metadataParser, new CompositeMetadataContainer()));
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.NonGeographicalEntityMetadataSource
    public Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int i) {
        if (GeoEntityUtility.isGeoEntity(i)) {
            throw new IllegalArgumentException(i + " calling code belongs to a geo entity");
        }
        return ((CompositeMetadataContainer) this.bootstrappingGuard.getOrBootstrap(this.phoneMetadataFileNameProvider.getFor(Integer.valueOf(i)))).getMetadataBy(i);
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.RegionMetadataSource
    public Phonemetadata.PhoneMetadata getMetadataForRegion(String str) {
        if (!GeoEntityUtility.isGeoEntity(str)) {
            throw new IllegalArgumentException(str + " region code is a non-geo entity");
        }
        return ((CompositeMetadataContainer) this.bootstrappingGuard.getOrBootstrap(this.phoneMetadataFileNameProvider.getFor(str))).getMetadataBy(str);
    }
}

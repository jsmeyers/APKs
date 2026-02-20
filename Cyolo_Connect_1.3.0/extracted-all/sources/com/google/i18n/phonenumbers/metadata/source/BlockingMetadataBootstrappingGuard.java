package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;
import com.google.i18n.phonenumbers.metadata.source.MetadataContainer;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class BlockingMetadataBootstrappingGuard<T extends MetadataContainer> implements MetadataBootstrappingGuard<T> {
    private final Map<String, String> loadedFiles = new ConcurrentHashMap();
    private final T metadataContainer;
    private final MetadataLoader metadataLoader;
    private final MetadataParser metadataParser;

    BlockingMetadataBootstrappingGuard(MetadataLoader metadataLoader, MetadataParser metadataParser, T t) {
        this.metadataLoader = metadataLoader;
        this.metadataParser = metadataParser;
        this.metadataContainer = t;
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.MetadataBootstrappingGuard
    public T getOrBootstrap(String str) {
        if (!this.loadedFiles.containsKey(str)) {
            bootstrapMetadata(str);
        }
        return this.metadataContainer;
    }

    private synchronized void bootstrapMetadata(String str) {
        if (this.loadedFiles.containsKey(str)) {
            return;
        }
        Iterator<Phonemetadata.PhoneMetadata> it = read(str).iterator();
        while (it.hasNext()) {
            this.metadataContainer.accept(it.next());
        }
        this.loadedFiles.put(str, str);
    }

    private Collection<Phonemetadata.PhoneMetadata> read(String str) {
        try {
            return this.metadataParser.parse(this.metadataLoader.loadMetadata(str));
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw new IllegalStateException("Failed to read file " + str, e);
        }
    }
}

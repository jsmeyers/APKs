package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.metadata.source.MetadataContainer;

/* JADX INFO: loaded from: classes3.dex */
public interface MetadataBootstrappingGuard<T extends MetadataContainer> {
    T getOrBootstrap(String str);
}

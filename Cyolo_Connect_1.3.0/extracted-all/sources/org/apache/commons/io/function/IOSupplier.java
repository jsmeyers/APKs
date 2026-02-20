package org.apache.commons.io.function;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
@FunctionalInterface
public interface IOSupplier<T> {
    T get() throws IOException;
}

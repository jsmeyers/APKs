package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public interface Function<F, T> {
    @NullableDecl
    T apply(@NullableDecl F f);

    boolean equals(@NullableDecl Object obj);
}

package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}

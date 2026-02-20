package com.google.common.base;

/* JADX INFO: loaded from: classes.dex */
interface PatternCompiler {
    CommonPattern compile(String str);

    boolean isPcreLike();
}

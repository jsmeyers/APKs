package j$.util;

import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DesugarLinkedHashSet {
    public static Spliterator spliterator(LinkedHashSet linkedHashSet) {
        return Spliterators.spliterator(linkedHashSet, 17);
    }
}

package com.bugsnag.android;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class CollectionUtils {
    CollectionUtils() {
    }

    static <T> boolean containsNullElements(Collection<T> collection) {
        if (collection == null) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                return true;
            }
        }
        return false;
    }
}

package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Function;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Maps {

    private enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY { // from class: androidx.test.espresso.core.internal.deps.guava.collect.Maps.EntryFunction.1
            @Override // androidx.test.espresso.core.internal.deps.guava.base.Function
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: androidx.test.espresso.core.internal.deps.guava.collect.Maps.EntryFunction.2
            @Override // androidx.test.espresso.core.internal.deps.guava.base.Function
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        /* synthetic */ EntryFunction(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static <V> Function<Map.Entry<?, V>, V> valueFunction() {
        return EntryFunction.VALUE;
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.test.espresso.core.internal.deps.guava.collect.Maps$1, reason: invalid class name */
    class AnonymousClass1<K, V> extends TransformedIterator<Map.Entry<K, V>, K> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.test.espresso.core.internal.deps.guava.collect.TransformedIterator
        public K transform(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    static boolean equalsImpl(Map<?, ?> map, Object object) {
        if (map == object) {
            return true;
        }
        if (object instanceof Map) {
            return map.entrySet().equals(((Map) object).entrySet());
        }
        return false;
    }

    static String toStringImpl(Map<?, ?> map) {
        StringBuilder sbNewStringBuilderForCollection = Collections2.newStringBuilderForCollection(map.size());
        sbNewStringBuilderForCollection.append('{');
        boolean z = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z) {
                sbNewStringBuilderForCollection.append(", ");
            }
            sbNewStringBuilderForCollection.append(entry.getKey());
            sbNewStringBuilderForCollection.append('=');
            sbNewStringBuilderForCollection.append(entry.getValue());
            z = false;
        }
        sbNewStringBuilderForCollection.append('}');
        return sbNewStringBuilderForCollection.toString();
    }
}

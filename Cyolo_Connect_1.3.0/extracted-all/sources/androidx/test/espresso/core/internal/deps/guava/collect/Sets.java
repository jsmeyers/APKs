package androidx.test.espresso.core.internal.deps.guava.collect;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Sets {
    static int hashCodeImpl(Set<?> s) {
        Iterator<?> it = s.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    static boolean equalsImpl(Set<?> s, Object object) {
        if (s == object) {
            return true;
        }
        if (object instanceof Set) {
            Set set = (Set) object;
            try {
                return s.size() == set.size() && s.containsAll(set);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}

package j$.lang;

import j$.util.Collection;
import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public interface Iterable {

    /* JADX INFO: renamed from: j$.lang.Iterable$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$forEach(java.lang.Iterable iterable, Consumer consumer) {
            if (DesugarCollections.SYNCHRONIZED_COLLECTION.isInstance(iterable)) {
                DesugarCollections.forEach(iterable, consumer);
                return;
            }
            Objects.requireNonNull(consumer);
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                consumer.accept(it.next());
            }
        }
    }

    /* JADX INFO: renamed from: j$.lang.Iterable$-EL, reason: invalid class name */
    public final /* synthetic */ class EL {
        public static /* synthetic */ void forEach(java.lang.Iterable iterable, Consumer consumer) {
            if (iterable instanceof Iterable) {
                ((Iterable) iterable).forEach(consumer);
            } else if (iterable instanceof Collection) {
                Collection.CC.$default$forEach((java.util.Collection) iterable, consumer);
            } else {
                CC.$default$forEach(iterable, consumer);
            }
        }
    }

    void forEach(Consumer consumer);
}

package j$.util;

import j$.util.function.UnaryOperator;
import java.util.Arrays;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes4.dex */
public interface List<E> extends Collection {

    /* JADX INFO: renamed from: j$.util.List$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$replaceAll(java.util.List list, UnaryOperator unaryOperator) {
            if (DesugarCollections.SYNCHRONIZED_LIST.isInstance(list)) {
                DesugarCollections.replaceAll(list, unaryOperator);
                return;
            }
            Objects.requireNonNull(unaryOperator);
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                listIterator.set(unaryOperator.apply(listIterator.next()));
            }
        }

        public static void $default$sort(java.util.List list, java.util.Comparator comparator) {
            if (DesugarCollections.SYNCHRONIZED_LIST.isInstance(list)) {
                DesugarCollections.sort(list, comparator);
                return;
            }
            Object[] array = list.toArray();
            Arrays.sort(array, comparator);
            ListIterator<E> listIterator = list.listIterator();
            for (Object obj : array) {
                listIterator.next();
                listIterator.set(obj);
            }
        }
    }

    /* JADX INFO: renamed from: j$.util.List$-EL, reason: invalid class name */
    public final /* synthetic */ class EL {
        public static /* synthetic */ void replaceAll(java.util.List list, UnaryOperator unaryOperator) {
            if (list instanceof List) {
                ((List) list).replaceAll(unaryOperator);
            } else {
                CC.$default$replaceAll(list, unaryOperator);
            }
        }

        public static /* synthetic */ void sort(java.util.List list, java.util.Comparator comparator) {
            if (list instanceof List) {
                ((List) list).sort(comparator);
            } else {
                CC.$default$sort(list, comparator);
            }
        }
    }

    void replaceAll(UnaryOperator<E> unaryOperator);

    void sort(java.util.Comparator<? super E> comparator);

    @Override // j$.util.Collection
    Spliterator<E> spliterator();
}

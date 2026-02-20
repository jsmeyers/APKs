package j$.util;

import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.IntConsumer;
import j$.util.function.LongConsumer;
import java.util.PrimitiveIterator;

/* JADX INFO: loaded from: classes4.dex */
public interface PrimitiveIterator extends java.util.Iterator {

    public interface OfDouble extends PrimitiveIterator {

        /* JADX INFO: renamed from: j$.util.PrimitiveIterator$OfDouble$-CC, reason: invalid class name */
        public abstract /* synthetic */ class CC {
            public static void $default$forEachRemaining(OfDouble ofDouble, Consumer consumer) {
                if (consumer instanceof DoubleConsumer) {
                    ofDouble.forEachRemaining((DoubleConsumer) consumer);
                    return;
                }
                Objects.requireNonNull(consumer);
                if (Tripwire.ENABLED) {
                    Tripwire.trip(ofDouble.getClass(), "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
                }
                Objects.requireNonNull(consumer);
                ofDouble.forEachRemaining((DoubleConsumer) new PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0(consumer));
            }

            public static void $default$forEachRemaining(OfDouble ofDouble, DoubleConsumer doubleConsumer) {
                Objects.requireNonNull(doubleConsumer);
                while (ofDouble.hasNext()) {
                    doubleConsumer.accept(ofDouble.nextDouble());
                }
            }

            public static Double $default$next(OfDouble ofDouble) {
                if (Tripwire.ENABLED) {
                    Tripwire.trip(ofDouble.getClass(), "{0} calling PrimitiveIterator.OfDouble.nextLong()");
                }
                return Double.valueOf(ofDouble.nextDouble());
            }
        }

        public final /* synthetic */ class Wrapper implements PrimitiveIterator.OfDouble {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ PrimitiveIterator.OfDouble convert(OfDouble ofDouble) {
                if (ofDouble == null) {
                    return null;
                }
                return ofDouble.new Wrapper();
            }

            public /* synthetic */ boolean equals(Object obj) {
                OfDouble ofDouble = OfDouble.this;
                if (obj instanceof Wrapper) {
                    obj = OfDouble.this;
                }
                return ofDouble.equals(obj);
            }

            @Override // java.util.PrimitiveIterator
            public /* synthetic */ void forEachRemaining(java.util.function.DoubleConsumer doubleConsumer) {
                OfDouble.this.forEachRemaining(doubleConsumer);
            }

            @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfDouble.this.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.PrimitiveIterator.OfDouble
            /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
            public /* synthetic */ void forEachRemaining2(java.util.function.DoubleConsumer doubleConsumer) {
                OfDouble.this.forEachRemaining(DoubleConsumer.VivifiedWrapper.convert(doubleConsumer));
            }

            @Override // java.util.Iterator
            public /* synthetic */ boolean hasNext() {
                return OfDouble.this.hasNext();
            }

            public /* synthetic */ int hashCode() {
                return OfDouble.this.hashCode();
            }

            @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
            public /* synthetic */ Double next() {
                return OfDouble.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
            public /* synthetic */ Object next() {
                return OfDouble.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfDouble
            public /* synthetic */ double nextDouble() {
                return OfDouble.this.nextDouble();
            }

            @Override // java.util.Iterator
            public /* synthetic */ void remove() {
                OfDouble.this.remove();
            }
        }

        void forEachRemaining(Consumer consumer);

        void forEachRemaining(DoubleConsumer doubleConsumer);

        @Override // java.util.Iterator
        Double next();

        double nextDouble();
    }

    public interface OfInt extends PrimitiveIterator {

        /* JADX INFO: renamed from: j$.util.PrimitiveIterator$OfInt$-CC, reason: invalid class name */
        public abstract /* synthetic */ class CC {
            public static void $default$forEachRemaining(OfInt ofInt, Consumer consumer) {
                if (consumer instanceof IntConsumer) {
                    ofInt.forEachRemaining((IntConsumer) consumer);
                    return;
                }
                Objects.requireNonNull(consumer);
                if (Tripwire.ENABLED) {
                    Tripwire.trip(ofInt.getClass(), "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
                }
                Objects.requireNonNull(consumer);
                ofInt.forEachRemaining((IntConsumer) new PrimitiveIterator$OfInt$$ExternalSyntheticLambda0(consumer));
            }

            public static void $default$forEachRemaining(OfInt ofInt, IntConsumer intConsumer) {
                Objects.requireNonNull(intConsumer);
                while (ofInt.hasNext()) {
                    intConsumer.accept(ofInt.nextInt());
                }
            }

            public static Integer $default$next(OfInt ofInt) {
                if (Tripwire.ENABLED) {
                    Tripwire.trip(ofInt.getClass(), "{0} calling PrimitiveIterator.OfInt.nextInt()");
                }
                return Integer.valueOf(ofInt.nextInt());
            }
        }

        public final /* synthetic */ class Wrapper implements PrimitiveIterator.OfInt {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ PrimitiveIterator.OfInt convert(OfInt ofInt) {
                if (ofInt == null) {
                    return null;
                }
                return ofInt.new Wrapper();
            }

            public /* synthetic */ boolean equals(Object obj) {
                OfInt ofInt = OfInt.this;
                if (obj instanceof Wrapper) {
                    obj = OfInt.this;
                }
                return ofInt.equals(obj);
            }

            @Override // java.util.PrimitiveIterator
            public /* synthetic */ void forEachRemaining(java.util.function.IntConsumer intConsumer) {
                OfInt.this.forEachRemaining(intConsumer);
            }

            @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfInt.this.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.PrimitiveIterator.OfInt
            /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
            public /* synthetic */ void forEachRemaining2(java.util.function.IntConsumer intConsumer) {
                OfInt.this.forEachRemaining(IntConsumer.VivifiedWrapper.convert(intConsumer));
            }

            @Override // java.util.Iterator
            public /* synthetic */ boolean hasNext() {
                return OfInt.this.hasNext();
            }

            public /* synthetic */ int hashCode() {
                return OfInt.this.hashCode();
            }

            @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
            public /* synthetic */ Integer next() {
                return OfInt.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
            public /* synthetic */ Object next() {
                return OfInt.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfInt
            public /* synthetic */ int nextInt() {
                return OfInt.this.nextInt();
            }

            @Override // java.util.Iterator
            public /* synthetic */ void remove() {
                OfInt.this.remove();
            }
        }

        void forEachRemaining(Consumer consumer);

        void forEachRemaining(IntConsumer intConsumer);

        @Override // java.util.Iterator
        Integer next();

        int nextInt();
    }

    public interface OfLong extends PrimitiveIterator {

        /* JADX INFO: renamed from: j$.util.PrimitiveIterator$OfLong$-CC, reason: invalid class name */
        public abstract /* synthetic */ class CC {
            public static void $default$forEachRemaining(OfLong ofLong, Consumer consumer) {
                if (consumer instanceof LongConsumer) {
                    ofLong.forEachRemaining((LongConsumer) consumer);
                    return;
                }
                Objects.requireNonNull(consumer);
                if (Tripwire.ENABLED) {
                    Tripwire.trip(ofLong.getClass(), "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
                }
                Objects.requireNonNull(consumer);
                ofLong.forEachRemaining((LongConsumer) new PrimitiveIterator$OfLong$$ExternalSyntheticLambda0(consumer));
            }

            public static void $default$forEachRemaining(OfLong ofLong, LongConsumer longConsumer) {
                Objects.requireNonNull(longConsumer);
                while (ofLong.hasNext()) {
                    longConsumer.accept(ofLong.nextLong());
                }
            }

            public static Long $default$next(OfLong ofLong) {
                if (Tripwire.ENABLED) {
                    Tripwire.trip(ofLong.getClass(), "{0} calling PrimitiveIterator.OfLong.nextLong()");
                }
                return Long.valueOf(ofLong.nextLong());
            }
        }

        public final /* synthetic */ class Wrapper implements PrimitiveIterator.OfLong {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ PrimitiveIterator.OfLong convert(OfLong ofLong) {
                if (ofLong == null) {
                    return null;
                }
                return ofLong.new Wrapper();
            }

            public /* synthetic */ boolean equals(Object obj) {
                OfLong ofLong = OfLong.this;
                if (obj instanceof Wrapper) {
                    obj = OfLong.this;
                }
                return ofLong.equals(obj);
            }

            @Override // java.util.PrimitiveIterator
            public /* synthetic */ void forEachRemaining(java.util.function.LongConsumer longConsumer) {
                OfLong.this.forEachRemaining(longConsumer);
            }

            @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfLong.this.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.PrimitiveIterator.OfLong
            /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
            public /* synthetic */ void forEachRemaining2(java.util.function.LongConsumer longConsumer) {
                OfLong.this.forEachRemaining(LongConsumer.VivifiedWrapper.convert(longConsumer));
            }

            @Override // java.util.Iterator
            public /* synthetic */ boolean hasNext() {
                return OfLong.this.hasNext();
            }

            public /* synthetic */ int hashCode() {
                return OfLong.this.hashCode();
            }

            @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
            public /* synthetic */ Long next() {
                return OfLong.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
            public /* synthetic */ Object next() {
                return OfLong.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfLong
            public /* synthetic */ long nextLong() {
                return OfLong.this.nextLong();
            }

            @Override // java.util.Iterator
            public /* synthetic */ void remove() {
                OfLong.this.remove();
            }
        }

        void forEachRemaining(Consumer consumer);

        void forEachRemaining(LongConsumer longConsumer);

        @Override // java.util.Iterator
        Long next();

        long nextLong();
    }

    void forEachRemaining(Object obj);
}

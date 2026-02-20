package j$.util;

import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.IntConsumer;
import j$.util.function.LongConsumer;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes4.dex */
public interface Spliterator<T> {

    /* JADX INFO: renamed from: j$.util.Spliterator$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static java.util.Comparator $default$getComparator(Spliterator spliterator) {
            throw new IllegalStateException();
        }

        public static long $default$getExactSizeIfKnown(Spliterator spliterator) {
            if ((spliterator.characteristics() & 64) == 0) {
                return -1L;
            }
            return spliterator.estimateSize();
        }

        public static boolean $default$hasCharacteristics(Spliterator spliterator, int i) {
            return (spliterator.characteristics() & i) == i;
        }
    }

    public interface OfDouble extends OfPrimitive {

        /* JADX INFO: renamed from: j$.util.Spliterator$OfDouble$-CC, reason: invalid class name */
        public abstract /* synthetic */ class CC {
            public static void $default$forEachRemaining(OfDouble ofDouble, Consumer consumer) {
                if (consumer instanceof DoubleConsumer) {
                    ofDouble.forEachRemaining((DoubleConsumer) consumer);
                    return;
                }
                if (Tripwire.ENABLED) {
                    Tripwire.trip(ofDouble.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
                }
                Objects.requireNonNull(consumer);
                ofDouble.forEachRemaining((DoubleConsumer) new PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0(consumer));
            }

            public static boolean $default$tryAdvance(OfDouble ofDouble, Consumer consumer) {
                if (consumer instanceof DoubleConsumer) {
                    return ofDouble.tryAdvance((DoubleConsumer) consumer);
                }
                if (Tripwire.ENABLED) {
                    Tripwire.trip(ofDouble.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
                }
                Objects.requireNonNull(consumer);
                return ofDouble.tryAdvance((DoubleConsumer) new PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0(consumer));
            }
        }

        public final /* synthetic */ class Wrapper implements Spliterator.OfDouble {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ Spliterator.OfDouble convert(OfDouble ofDouble) {
                if (ofDouble == null) {
                    return null;
                }
                return ofDouble.new Wrapper();
            }

            @Override // java.util.Spliterator
            public /* synthetic */ int characteristics() {
                return OfDouble.this.characteristics();
            }

            public /* synthetic */ boolean equals(Object obj) {
                OfDouble ofDouble = OfDouble.this;
                if (obj instanceof Wrapper) {
                    obj = OfDouble.this;
                }
                return ofDouble.equals(obj);
            }

            @Override // java.util.Spliterator
            public /* synthetic */ long estimateSize() {
                return OfDouble.this.estimateSize();
            }

            @Override // java.util.Spliterator.OfPrimitive
            public /* synthetic */ void forEachRemaining(java.util.function.DoubleConsumer doubleConsumer) {
                OfDouble.this.forEachRemaining(doubleConsumer);
            }

            @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfDouble.this.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.Spliterator.OfDouble
            /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
            public /* synthetic */ void forEachRemaining2(java.util.function.DoubleConsumer doubleConsumer) {
                OfDouble.this.forEachRemaining(DoubleConsumer.VivifiedWrapper.convert(doubleConsumer));
            }

            @Override // java.util.Spliterator
            public /* synthetic */ java.util.Comparator getComparator() {
                return OfDouble.this.getComparator();
            }

            @Override // java.util.Spliterator
            public /* synthetic */ long getExactSizeIfKnown() {
                return OfDouble.this.getExactSizeIfKnown();
            }

            @Override // java.util.Spliterator
            public /* synthetic */ boolean hasCharacteristics(int i) {
                return OfDouble.this.hasCharacteristics(i);
            }

            public /* synthetic */ int hashCode() {
                return OfDouble.this.hashCode();
            }

            @Override // java.util.Spliterator.OfPrimitive
            public /* synthetic */ boolean tryAdvance(java.util.function.DoubleConsumer doubleConsumer) {
                return OfDouble.this.tryAdvance(doubleConsumer);
            }

            @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
            public /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
                return OfDouble.this.tryAdvance(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.Spliterator.OfDouble
            /* JADX INFO: renamed from: tryAdvance, reason: avoid collision after fix types in other method */
            public /* synthetic */ boolean tryAdvance2(java.util.function.DoubleConsumer doubleConsumer) {
                return OfDouble.this.tryAdvance(DoubleConsumer.VivifiedWrapper.convert(doubleConsumer));
            }

            @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* synthetic */ Spliterator.OfDouble trySplit() {
                return convert(OfDouble.this.trySplit());
            }

            @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return OfPrimitive.Wrapper.convert(OfDouble.this.trySplit());
            }

            @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* synthetic */ java.util.Spliterator trySplit() {
                return Wrapper.convert(OfDouble.this.trySplit());
            }
        }

        @Override // j$.util.Spliterator
        void forEachRemaining(Consumer consumer);

        void forEachRemaining(DoubleConsumer doubleConsumer);

        @Override // j$.util.Spliterator
        boolean tryAdvance(Consumer consumer);

        boolean tryAdvance(DoubleConsumer doubleConsumer);

        @Override // j$.util.Spliterator.OfPrimitive, j$.util.Spliterator
        OfDouble trySplit();
    }

    public interface OfInt extends OfPrimitive {

        /* JADX INFO: renamed from: j$.util.Spliterator$OfInt$-CC, reason: invalid class name */
        public abstract /* synthetic */ class CC {
            public static void $default$forEachRemaining(OfInt ofInt, Consumer consumer) {
                if (consumer instanceof IntConsumer) {
                    ofInt.forEachRemaining((IntConsumer) consumer);
                    return;
                }
                if (Tripwire.ENABLED) {
                    Tripwire.trip(ofInt.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
                }
                Objects.requireNonNull(consumer);
                ofInt.forEachRemaining((IntConsumer) new PrimitiveIterator$OfInt$$ExternalSyntheticLambda0(consumer));
            }

            public static boolean $default$tryAdvance(OfInt ofInt, Consumer consumer) {
                if (consumer instanceof IntConsumer) {
                    return ofInt.tryAdvance((IntConsumer) consumer);
                }
                if (Tripwire.ENABLED) {
                    Tripwire.trip(ofInt.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
                }
                Objects.requireNonNull(consumer);
                return ofInt.tryAdvance((IntConsumer) new PrimitiveIterator$OfInt$$ExternalSyntheticLambda0(consumer));
            }
        }

        public final /* synthetic */ class Wrapper implements Spliterator.OfInt {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ Spliterator.OfInt convert(OfInt ofInt) {
                if (ofInt == null) {
                    return null;
                }
                return ofInt.new Wrapper();
            }

            @Override // java.util.Spliterator
            public /* synthetic */ int characteristics() {
                return OfInt.this.characteristics();
            }

            public /* synthetic */ boolean equals(Object obj) {
                OfInt ofInt = OfInt.this;
                if (obj instanceof Wrapper) {
                    obj = OfInt.this;
                }
                return ofInt.equals(obj);
            }

            @Override // java.util.Spliterator
            public /* synthetic */ long estimateSize() {
                return OfInt.this.estimateSize();
            }

            @Override // java.util.Spliterator.OfPrimitive
            public /* synthetic */ void forEachRemaining(java.util.function.IntConsumer intConsumer) {
                OfInt.this.forEachRemaining(intConsumer);
            }

            @Override // java.util.Spliterator.OfInt, java.util.Spliterator
            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfInt.this.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.Spliterator.OfInt
            /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
            public /* synthetic */ void forEachRemaining2(java.util.function.IntConsumer intConsumer) {
                OfInt.this.forEachRemaining(IntConsumer.VivifiedWrapper.convert(intConsumer));
            }

            @Override // java.util.Spliterator
            public /* synthetic */ java.util.Comparator getComparator() {
                return OfInt.this.getComparator();
            }

            @Override // java.util.Spliterator
            public /* synthetic */ long getExactSizeIfKnown() {
                return OfInt.this.getExactSizeIfKnown();
            }

            @Override // java.util.Spliterator
            public /* synthetic */ boolean hasCharacteristics(int i) {
                return OfInt.this.hasCharacteristics(i);
            }

            public /* synthetic */ int hashCode() {
                return OfInt.this.hashCode();
            }

            @Override // java.util.Spliterator.OfPrimitive
            public /* synthetic */ boolean tryAdvance(java.util.function.IntConsumer intConsumer) {
                return OfInt.this.tryAdvance(intConsumer);
            }

            @Override // java.util.Spliterator.OfInt, java.util.Spliterator
            public /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
                return OfInt.this.tryAdvance(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.Spliterator.OfInt
            /* JADX INFO: renamed from: tryAdvance, reason: avoid collision after fix types in other method */
            public /* synthetic */ boolean tryAdvance2(java.util.function.IntConsumer intConsumer) {
                return OfInt.this.tryAdvance(IntConsumer.VivifiedWrapper.convert(intConsumer));
            }

            @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* synthetic */ Spliterator.OfInt trySplit() {
                return convert(OfInt.this.trySplit());
            }

            @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return OfPrimitive.Wrapper.convert(OfInt.this.trySplit());
            }

            @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* synthetic */ java.util.Spliterator trySplit() {
                return Wrapper.convert(OfInt.this.trySplit());
            }
        }

        @Override // j$.util.Spliterator
        void forEachRemaining(Consumer consumer);

        void forEachRemaining(IntConsumer intConsumer);

        @Override // j$.util.Spliterator
        boolean tryAdvance(Consumer consumer);

        boolean tryAdvance(IntConsumer intConsumer);

        @Override // j$.util.Spliterator.OfPrimitive, j$.util.Spliterator
        OfInt trySplit();
    }

    public interface OfLong extends OfPrimitive {

        /* JADX INFO: renamed from: j$.util.Spliterator$OfLong$-CC, reason: invalid class name */
        public abstract /* synthetic */ class CC {
            public static void $default$forEachRemaining(OfLong ofLong, Consumer consumer) {
                if (consumer instanceof LongConsumer) {
                    ofLong.forEachRemaining((LongConsumer) consumer);
                    return;
                }
                if (Tripwire.ENABLED) {
                    Tripwire.trip(ofLong.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
                }
                Objects.requireNonNull(consumer);
                ofLong.forEachRemaining((LongConsumer) new PrimitiveIterator$OfLong$$ExternalSyntheticLambda0(consumer));
            }

            public static boolean $default$tryAdvance(OfLong ofLong, Consumer consumer) {
                if (consumer instanceof LongConsumer) {
                    return ofLong.tryAdvance((LongConsumer) consumer);
                }
                if (Tripwire.ENABLED) {
                    Tripwire.trip(ofLong.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
                }
                Objects.requireNonNull(consumer);
                return ofLong.tryAdvance((LongConsumer) new PrimitiveIterator$OfLong$$ExternalSyntheticLambda0(consumer));
            }
        }

        public final /* synthetic */ class Wrapper implements Spliterator.OfLong {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ Spliterator.OfLong convert(OfLong ofLong) {
                if (ofLong == null) {
                    return null;
                }
                return ofLong.new Wrapper();
            }

            @Override // java.util.Spliterator
            public /* synthetic */ int characteristics() {
                return OfLong.this.characteristics();
            }

            public /* synthetic */ boolean equals(Object obj) {
                OfLong ofLong = OfLong.this;
                if (obj instanceof Wrapper) {
                    obj = OfLong.this;
                }
                return ofLong.equals(obj);
            }

            @Override // java.util.Spliterator
            public /* synthetic */ long estimateSize() {
                return OfLong.this.estimateSize();
            }

            @Override // java.util.Spliterator.OfPrimitive
            public /* synthetic */ void forEachRemaining(java.util.function.LongConsumer longConsumer) {
                OfLong.this.forEachRemaining(longConsumer);
            }

            @Override // java.util.Spliterator.OfLong, java.util.Spliterator
            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfLong.this.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.Spliterator.OfLong
            /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
            public /* synthetic */ void forEachRemaining2(java.util.function.LongConsumer longConsumer) {
                OfLong.this.forEachRemaining(LongConsumer.VivifiedWrapper.convert(longConsumer));
            }

            @Override // java.util.Spliterator
            public /* synthetic */ java.util.Comparator getComparator() {
                return OfLong.this.getComparator();
            }

            @Override // java.util.Spliterator
            public /* synthetic */ long getExactSizeIfKnown() {
                return OfLong.this.getExactSizeIfKnown();
            }

            @Override // java.util.Spliterator
            public /* synthetic */ boolean hasCharacteristics(int i) {
                return OfLong.this.hasCharacteristics(i);
            }

            public /* synthetic */ int hashCode() {
                return OfLong.this.hashCode();
            }

            @Override // java.util.Spliterator.OfPrimitive
            public /* synthetic */ boolean tryAdvance(java.util.function.LongConsumer longConsumer) {
                return OfLong.this.tryAdvance(longConsumer);
            }

            @Override // java.util.Spliterator.OfLong, java.util.Spliterator
            public /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
                return OfLong.this.tryAdvance(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.Spliterator.OfLong
            /* JADX INFO: renamed from: tryAdvance, reason: avoid collision after fix types in other method */
            public /* synthetic */ boolean tryAdvance2(java.util.function.LongConsumer longConsumer) {
                return OfLong.this.tryAdvance(LongConsumer.VivifiedWrapper.convert(longConsumer));
            }

            @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* synthetic */ Spliterator.OfLong trySplit() {
                return convert(OfLong.this.trySplit());
            }

            @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return OfPrimitive.Wrapper.convert(OfLong.this.trySplit());
            }

            @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* synthetic */ java.util.Spliterator trySplit() {
                return Wrapper.convert(OfLong.this.trySplit());
            }
        }

        @Override // j$.util.Spliterator
        void forEachRemaining(Consumer consumer);

        void forEachRemaining(LongConsumer longConsumer);

        @Override // j$.util.Spliterator
        boolean tryAdvance(Consumer consumer);

        boolean tryAdvance(LongConsumer longConsumer);

        @Override // j$.util.Spliterator.OfPrimitive, j$.util.Spliterator
        OfLong trySplit();
    }

    public interface OfPrimitive extends Spliterator {

        public final /* synthetic */ class Wrapper implements Spliterator.OfPrimitive {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ Spliterator.OfPrimitive convert(OfPrimitive ofPrimitive) {
                if (ofPrimitive == null) {
                    return null;
                }
                return ofPrimitive instanceof OfDouble ? OfDouble.Wrapper.convert((OfDouble) ofPrimitive) : ofPrimitive instanceof OfInt ? OfInt.Wrapper.convert((OfInt) ofPrimitive) : ofPrimitive instanceof OfLong ? OfLong.Wrapper.convert((OfLong) ofPrimitive) : ofPrimitive.new Wrapper();
            }

            @Override // java.util.Spliterator
            public /* synthetic */ int characteristics() {
                return OfPrimitive.this.characteristics();
            }

            public /* synthetic */ boolean equals(Object obj) {
                OfPrimitive ofPrimitive = OfPrimitive.this;
                if (obj instanceof Wrapper) {
                    obj = OfPrimitive.this;
                }
                return ofPrimitive.equals(obj);
            }

            @Override // java.util.Spliterator
            public /* synthetic */ long estimateSize() {
                return OfPrimitive.this.estimateSize();
            }

            @Override // java.util.Spliterator.OfPrimitive
            public /* synthetic */ void forEachRemaining(Object obj) {
                OfPrimitive.this.forEachRemaining(obj);
            }

            @Override // java.util.Spliterator
            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfPrimitive.this.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.Spliterator
            public /* synthetic */ java.util.Comparator getComparator() {
                return OfPrimitive.this.getComparator();
            }

            @Override // java.util.Spliterator
            public /* synthetic */ long getExactSizeIfKnown() {
                return OfPrimitive.this.getExactSizeIfKnown();
            }

            @Override // java.util.Spliterator
            public /* synthetic */ boolean hasCharacteristics(int i) {
                return OfPrimitive.this.hasCharacteristics(i);
            }

            public /* synthetic */ int hashCode() {
                return OfPrimitive.this.hashCode();
            }

            @Override // java.util.Spliterator.OfPrimitive
            public /* synthetic */ boolean tryAdvance(Object obj) {
                return OfPrimitive.this.tryAdvance(obj);
            }

            @Override // java.util.Spliterator
            public /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
                return OfPrimitive.this.tryAdvance(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return convert(OfPrimitive.this.trySplit());
            }

            @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* synthetic */ java.util.Spliterator trySplit() {
                return Wrapper.convert(OfPrimitive.this.trySplit());
            }
        }

        void forEachRemaining(Object obj);

        boolean tryAdvance(Object obj);

        @Override // j$.util.Spliterator
        OfPrimitive trySplit();
    }

    public final /* synthetic */ class Wrapper implements java.util.Spliterator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.Spliterator convert(Spliterator spliterator) {
            if (spliterator == null) {
                return null;
            }
            return spliterator instanceof OfPrimitive ? OfPrimitive.Wrapper.convert((OfPrimitive) spliterator) : new Wrapper();
        }

        @Override // java.util.Spliterator
        public /* synthetic */ int characteristics() {
            return Spliterator.this.characteristics();
        }

        public /* synthetic */ boolean equals(Object obj) {
            Spliterator spliterator = Spliterator.this;
            if (obj instanceof Wrapper) {
                obj = Spliterator.this;
            }
            return spliterator.equals(obj);
        }

        @Override // java.util.Spliterator
        public /* synthetic */ long estimateSize() {
            return Spliterator.this.estimateSize();
        }

        @Override // java.util.Spliterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Spliterator.this.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Spliterator
        public /* synthetic */ java.util.Comparator getComparator() {
            return Spliterator.this.getComparator();
        }

        @Override // java.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.this.getExactSizeIfKnown();
        }

        @Override // java.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.this.hasCharacteristics(i);
        }

        public /* synthetic */ int hashCode() {
            return Spliterator.this.hashCode();
        }

        @Override // java.util.Spliterator
        public /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
            return Spliterator.this.tryAdvance(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Spliterator
        public /* synthetic */ java.util.Spliterator trySplit() {
            return convert(Spliterator.this.trySplit());
        }
    }

    int characteristics();

    long estimateSize();

    void forEachRemaining(Consumer consumer);

    java.util.Comparator getComparator();

    long getExactSizeIfKnown();

    boolean hasCharacteristics(int i);

    boolean tryAdvance(Consumer consumer);

    Spliterator trySplit();
}

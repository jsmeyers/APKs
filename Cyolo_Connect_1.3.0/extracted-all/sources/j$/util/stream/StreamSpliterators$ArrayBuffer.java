package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.IntConsumer;
import j$.util.function.LongConsumer;

/* JADX INFO: loaded from: classes4.dex */
abstract class StreamSpliterators$ArrayBuffer {
    int index;

    static final class OfDouble extends OfPrimitive implements DoubleConsumer {
        final double[] array;

        OfDouble(int i) {
            this.array = new double[i];
        }

        @Override // j$.util.function.DoubleConsumer
        public void accept(double d) {
            double[] dArr = this.array;
            int i = ((OfPrimitive) this).index;
            ((OfPrimitive) this).index = i + 1;
            dArr[i] = d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // j$.util.stream.StreamSpliterators$ArrayBuffer.OfPrimitive
        public void forEach(DoubleConsumer doubleConsumer, long j) {
            for (int i = 0; i < j; i++) {
                doubleConsumer.accept(this.array[i]);
            }
        }
    }

    static final class OfInt extends OfPrimitive implements IntConsumer {
        final int[] array;

        OfInt(int i) {
            this.array = new int[i];
        }

        @Override // j$.util.function.IntConsumer
        public void accept(int i) {
            int[] iArr = this.array;
            int i2 = ((OfPrimitive) this).index;
            ((OfPrimitive) this).index = i2 + 1;
            iArr[i2] = i;
        }

        @Override // j$.util.stream.StreamSpliterators$ArrayBuffer.OfPrimitive
        public void forEach(IntConsumer intConsumer, long j) {
            for (int i = 0; i < j; i++) {
                intConsumer.accept(this.array[i]);
            }
        }
    }

    static final class OfLong extends OfPrimitive implements LongConsumer {
        final long[] array;

        OfLong(int i) {
            this.array = new long[i];
        }

        @Override // j$.util.function.LongConsumer
        public void accept(long j) {
            long[] jArr = this.array;
            int i = ((OfPrimitive) this).index;
            ((OfPrimitive) this).index = i + 1;
            jArr[i] = j;
        }

        @Override // j$.util.stream.StreamSpliterators$ArrayBuffer.OfPrimitive
        public void forEach(LongConsumer longConsumer, long j) {
            for (int i = 0; i < j; i++) {
                longConsumer.accept(this.array[i]);
            }
        }
    }

    static abstract class OfPrimitive extends StreamSpliterators$ArrayBuffer {
        int index;

        OfPrimitive() {
        }

        abstract void forEach(Object obj, long j);

        @Override // j$.util.stream.StreamSpliterators$ArrayBuffer
        void reset() {
            this.index = 0;
        }
    }

    static final class OfRef extends StreamSpliterators$ArrayBuffer implements Consumer {
        final Object[] array;

        OfRef(int i) {
            this.array = new Object[i];
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            Object[] objArr = this.array;
            int i = this.index;
            this.index = i + 1;
            objArr[i] = obj;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public void forEach(Consumer consumer, long j) {
            for (int i = 0; i < j; i++) {
                consumer.accept(this.array[i]);
            }
        }
    }

    StreamSpliterators$ArrayBuffer() {
    }

    void reset() {
        this.index = 0;
    }
}

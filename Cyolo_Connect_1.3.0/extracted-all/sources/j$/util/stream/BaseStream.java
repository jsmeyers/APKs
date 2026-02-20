package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.BaseStream;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes4.dex */
public interface BaseStream<T, S extends BaseStream<T, S>> extends AutoCloseable {

    public final /* synthetic */ class Wrapper implements java.util.stream.BaseStream {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.BaseStream convert(BaseStream baseStream) {
            if (baseStream == null) {
                return null;
            }
            return baseStream instanceof DoubleStream ? DoubleStream.Wrapper.convert((DoubleStream) baseStream) : baseStream instanceof IntStream ? IntStream.Wrapper.convert((IntStream) baseStream) : baseStream instanceof LongStream ? LongStream.Wrapper.convert((LongStream) baseStream) : baseStream instanceof Stream ? Stream.Wrapper.convert((Stream) baseStream) : new Wrapper();
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            BaseStream.this.close();
        }

        public /* synthetic */ boolean equals(Object obj) {
            BaseStream baseStream = BaseStream.this;
            if (obj instanceof Wrapper) {
                obj = BaseStream.this;
            }
            return baseStream.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return BaseStream.this.hashCode();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ boolean isParallel() {
            return BaseStream.this.isParallel();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ Iterator iterator() {
            return BaseStream.this.iterator();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream onClose(Runnable runnable) {
            return convert(BaseStream.this.onClose(runnable));
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream parallel() {
            return convert(BaseStream.this.parallel());
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream sequential() {
            return convert(BaseStream.this.sequential());
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ Spliterator spliterator() {
            return Spliterator.Wrapper.convert(BaseStream.this.spliterator());
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream unordered() {
            return convert(BaseStream.this.unordered());
        }
    }

    @Override // java.lang.AutoCloseable
    void close();

    boolean isParallel();

    Iterator<T> iterator();

    BaseStream onClose(Runnable runnable);

    BaseStream parallel();

    BaseStream sequential();

    j$.util.Spliterator spliterator();

    BaseStream unordered();
}

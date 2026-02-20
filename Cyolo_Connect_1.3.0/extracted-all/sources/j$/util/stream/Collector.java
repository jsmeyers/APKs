package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface Collector<T, A, R> {

    public enum Characteristics {
        CONCURRENT,
        UNORDERED,
        IDENTITY_FINISH
    }

    public final /* synthetic */ class VivifiedWrapper implements Collector {
        public final /* synthetic */ java.util.stream.Collector wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.stream.Collector collector) {
            this.wrappedValue = collector;
        }

        public static /* synthetic */ Collector convert(java.util.stream.Collector collector) {
            if (collector == null) {
                return null;
            }
            return new VivifiedWrapper(collector);
        }

        @Override // j$.util.stream.Collector
        public /* synthetic */ BiConsumer accumulator() {
            return BiConsumer.VivifiedWrapper.convert(this.wrappedValue.accumulator());
        }

        @Override // j$.util.stream.Collector
        public /* synthetic */ Set characteristics() {
            return this.wrappedValue.characteristics();
        }

        @Override // j$.util.stream.Collector
        public /* synthetic */ BinaryOperator combiner() {
            return BinaryOperator.VivifiedWrapper.convert(this.wrappedValue.combiner());
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.stream.Collector collector = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return collector.equals(obj);
        }

        @Override // j$.util.stream.Collector
        public /* synthetic */ Function finisher() {
            return Function.VivifiedWrapper.convert(this.wrappedValue.finisher());
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }

        @Override // j$.util.stream.Collector
        public /* synthetic */ Supplier supplier() {
            return Supplier.VivifiedWrapper.convert(this.wrappedValue.supplier());
        }
    }

    BiConsumer accumulator();

    Set characteristics();

    BinaryOperator combiner();

    Function finisher();

    Supplier supplier();
}

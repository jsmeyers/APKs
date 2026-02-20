package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface LongUnaryOperator {

    public final /* synthetic */ class VivifiedWrapper implements LongUnaryOperator {
        public final /* synthetic */ java.util.function.LongUnaryOperator wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongUnaryOperator longUnaryOperator) {
            this.wrappedValue = longUnaryOperator;
        }

        public static /* synthetic */ LongUnaryOperator convert(java.util.function.LongUnaryOperator longUnaryOperator) {
            if (longUnaryOperator == null) {
                return null;
            }
            return new VivifiedWrapper(longUnaryOperator);
        }

        @Override // j$.util.function.LongUnaryOperator
        public /* synthetic */ long applyAsLong(long j) {
            return this.wrappedValue.applyAsLong(j);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.LongUnaryOperator longUnaryOperator = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return longUnaryOperator.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    long applyAsLong(long j);
}

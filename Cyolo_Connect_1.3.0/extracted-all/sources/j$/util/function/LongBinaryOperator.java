package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface LongBinaryOperator {

    public final /* synthetic */ class VivifiedWrapper implements LongBinaryOperator {
        public final /* synthetic */ java.util.function.LongBinaryOperator wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongBinaryOperator longBinaryOperator) {
            this.wrappedValue = longBinaryOperator;
        }

        public static /* synthetic */ LongBinaryOperator convert(java.util.function.LongBinaryOperator longBinaryOperator) {
            if (longBinaryOperator == null) {
                return null;
            }
            return new VivifiedWrapper(longBinaryOperator);
        }

        @Override // j$.util.function.LongBinaryOperator
        public /* synthetic */ long applyAsLong(long j, long j2) {
            return this.wrappedValue.applyAsLong(j, j2);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.LongBinaryOperator longBinaryOperator = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return longBinaryOperator.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    long applyAsLong(long j, long j2);
}

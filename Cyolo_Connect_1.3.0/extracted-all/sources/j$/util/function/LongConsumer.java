package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface LongConsumer {

    public final /* synthetic */ class VivifiedWrapper implements LongConsumer {
        public final /* synthetic */ java.util.function.LongConsumer wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongConsumer longConsumer) {
            this.wrappedValue = longConsumer;
        }

        public static /* synthetic */ LongConsumer convert(java.util.function.LongConsumer longConsumer) {
            if (longConsumer == null) {
                return null;
            }
            return new VivifiedWrapper(longConsumer);
        }

        @Override // j$.util.function.LongConsumer
        public /* synthetic */ void accept(long j) {
            this.wrappedValue.accept(j);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.LongConsumer longConsumer = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return longConsumer.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    void accept(long j);
}

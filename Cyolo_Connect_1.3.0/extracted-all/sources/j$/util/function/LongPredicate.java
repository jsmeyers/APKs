package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface LongPredicate {

    public final /* synthetic */ class VivifiedWrapper implements LongPredicate {
        public final /* synthetic */ java.util.function.LongPredicate wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongPredicate longPredicate) {
            this.wrappedValue = longPredicate;
        }

        public static /* synthetic */ LongPredicate convert(java.util.function.LongPredicate longPredicate) {
            if (longPredicate == null) {
                return null;
            }
            return new VivifiedWrapper(longPredicate);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.LongPredicate longPredicate = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return longPredicate.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }

        @Override // j$.util.function.LongPredicate
        public /* synthetic */ boolean test(long j) {
            return this.wrappedValue.test(j);
        }
    }

    boolean test(long j);
}

package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface ToIntFunction<T> {

    public final /* synthetic */ class VivifiedWrapper implements ToIntFunction {
        public final /* synthetic */ java.util.function.ToIntFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToIntFunction toIntFunction) {
            this.wrappedValue = toIntFunction;
        }

        public static /* synthetic */ ToIntFunction convert(java.util.function.ToIntFunction toIntFunction) {
            if (toIntFunction == null) {
                return null;
            }
            return new VivifiedWrapper(toIntFunction);
        }

        @Override // j$.util.function.ToIntFunction
        public /* synthetic */ int applyAsInt(Object obj) {
            return this.wrappedValue.applyAsInt(obj);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.ToIntFunction toIntFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return toIntFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    int applyAsInt(T t);
}

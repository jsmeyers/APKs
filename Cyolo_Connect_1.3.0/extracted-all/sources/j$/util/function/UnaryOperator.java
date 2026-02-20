package j$.util.function;

import j$.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public interface UnaryOperator<T> extends Function<T, T> {

    public final /* synthetic */ class VivifiedWrapper implements UnaryOperator {
        public final /* synthetic */ java.util.function.UnaryOperator wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.UnaryOperator unaryOperator) {
            this.wrappedValue = unaryOperator;
        }

        public static /* synthetic */ UnaryOperator convert(java.util.function.UnaryOperator unaryOperator) {
            if (unaryOperator == null) {
                return null;
            }
            return unaryOperator instanceof Wrapper ? UnaryOperator.this : new VivifiedWrapper(unaryOperator);
        }

        @Override // j$.util.function.Function
        public /* synthetic */ Function andThen(Function function) {
            return Function.VivifiedWrapper.convert(this.wrappedValue.andThen(Function.Wrapper.convert(function)));
        }

        @Override // j$.util.function.Function
        public /* synthetic */ Object apply(Object obj) {
            return this.wrappedValue.apply(obj);
        }

        @Override // j$.util.function.Function
        public /* synthetic */ Function compose(Function function) {
            return Function.VivifiedWrapper.convert(this.wrappedValue.compose(Function.Wrapper.convert(function)));
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.UnaryOperator unaryOperator = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return unaryOperator.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.function.UnaryOperator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.UnaryOperator convert(UnaryOperator unaryOperator) {
            if (unaryOperator == null) {
                return null;
            }
            return unaryOperator instanceof VivifiedWrapper ? ((VivifiedWrapper) unaryOperator).wrappedValue : new Wrapper();
        }

        @Override // java.util.function.Function
        public /* synthetic */ java.util.function.Function andThen(java.util.function.Function function) {
            return Function.Wrapper.convert(UnaryOperator.this.andThen(Function.VivifiedWrapper.convert(function)));
        }

        @Override // java.util.function.Function
        public /* synthetic */ Object apply(Object obj) {
            return UnaryOperator.this.apply(obj);
        }

        @Override // java.util.function.Function
        public /* synthetic */ java.util.function.Function compose(java.util.function.Function function) {
            return Function.Wrapper.convert(UnaryOperator.this.compose(Function.VivifiedWrapper.convert(function)));
        }

        public /* synthetic */ boolean equals(Object obj) {
            UnaryOperator unaryOperator = UnaryOperator.this;
            if (obj instanceof Wrapper) {
                obj = UnaryOperator.this;
            }
            return unaryOperator.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return UnaryOperator.this.hashCode();
        }
    }
}

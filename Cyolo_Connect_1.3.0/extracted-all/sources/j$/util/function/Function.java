package j$.util.function;

import j$.util.Objects;
import j$.util.function.Function;
import j$.util.function.UnaryOperator;

/* JADX INFO: loaded from: classes4.dex */
public interface Function<T, R> {

    /* JADX INFO: renamed from: j$.util.function.Function$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Function $default$andThen(final Function function, final Function function2) {
            Objects.requireNonNull(function2);
            return new Function() { // from class: j$.util.function.Function$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                public /* synthetic */ Function andThen(Function function3) {
                    return Function.CC.$default$andThen(this, function3);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return function2.apply(function.apply(obj));
                }

                @Override // j$.util.function.Function
                public /* synthetic */ Function compose(Function function3) {
                    return Function.CC.$default$compose(this, function3);
                }
            };
        }

        public static Function $default$compose(final Function function, final Function function2) {
            Objects.requireNonNull(function2);
            return new Function() { // from class: j$.util.function.Function$$ExternalSyntheticLambda2
                @Override // j$.util.function.Function
                public /* synthetic */ Function andThen(Function function3) {
                    return Function.CC.$default$andThen(this, function3);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return function.apply(function2.apply(obj));
                }

                @Override // j$.util.function.Function
                public /* synthetic */ Function compose(Function function3) {
                    return Function.CC.$default$compose(this, function3);
                }
            };
        }

        public static <T> Function<T, T> identity() {
            return new Function() { // from class: j$.util.function.Function$$ExternalSyntheticLambda1
                @Override // j$.util.function.Function
                public /* synthetic */ Function andThen(Function function) {
                    return Function.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return Function.CC.lambda$identity$2(obj);
                }

                @Override // j$.util.function.Function
                public /* synthetic */ Function compose(Function function) {
                    return Function.CC.$default$compose(this, function);
                }
            };
        }

        public static /* synthetic */ Object lambda$identity$2(Object obj) {
            return obj;
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements Function {
        public final /* synthetic */ java.util.function.Function wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.Function function) {
            this.wrappedValue = function;
        }

        public static /* synthetic */ Function convert(java.util.function.Function function) {
            if (function == null) {
                return null;
            }
            return function instanceof Wrapper ? Function.this : function instanceof java.util.function.UnaryOperator ? UnaryOperator.VivifiedWrapper.convert((java.util.function.UnaryOperator) function) : new VivifiedWrapper(function);
        }

        @Override // j$.util.function.Function
        public /* synthetic */ Function andThen(Function function) {
            return convert(this.wrappedValue.andThen(Wrapper.convert(function)));
        }

        @Override // j$.util.function.Function
        public /* synthetic */ Object apply(Object obj) {
            return this.wrappedValue.apply(obj);
        }

        @Override // j$.util.function.Function
        public /* synthetic */ Function compose(Function function) {
            return convert(this.wrappedValue.compose(Wrapper.convert(function)));
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.Function function = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return function.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.function.Function {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.Function convert(Function function) {
            if (function == null) {
                return null;
            }
            return function instanceof VivifiedWrapper ? ((VivifiedWrapper) function).wrappedValue : function instanceof UnaryOperator ? UnaryOperator.Wrapper.convert((UnaryOperator) function) : new Wrapper();
        }

        @Override // java.util.function.Function
        public /* synthetic */ java.util.function.Function andThen(java.util.function.Function function) {
            return convert(Function.this.andThen(VivifiedWrapper.convert(function)));
        }

        @Override // java.util.function.Function
        public /* synthetic */ Object apply(Object obj) {
            return Function.this.apply(obj);
        }

        @Override // java.util.function.Function
        public /* synthetic */ java.util.function.Function compose(java.util.function.Function function) {
            return convert(Function.this.compose(VivifiedWrapper.convert(function)));
        }

        public /* synthetic */ boolean equals(Object obj) {
            Function function = Function.this;
            if (obj instanceof Wrapper) {
                obj = Function.this;
            }
            return function.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return Function.this.hashCode();
        }
    }

    <V> Function<T, V> andThen(Function<? super R, ? extends V> function);

    R apply(T t);

    <V> Function<V, R> compose(Function<? super V, ? extends T> function);
}

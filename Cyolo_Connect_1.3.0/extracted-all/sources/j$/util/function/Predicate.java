package j$.util.function;

import j$.util.Objects;
import j$.util.function.Predicate;

/* JADX INFO: loaded from: classes4.dex */
public interface Predicate<T> {

    /* JADX INFO: renamed from: j$.util.function.Predicate$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Predicate $default$and(final Predicate predicate, final Predicate predicate2) {
            Objects.requireNonNull(predicate2);
            return new Predicate() { // from class: j$.util.function.Predicate$$ExternalSyntheticLambda2
                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate3) {
                    return Predicate.CC.$default$and(this, predicate3);
                }

                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate.CC.$default$negate(this);
                }

                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate3) {
                    return Predicate.CC.$default$or(this, predicate3);
                }

                @Override // j$.util.function.Predicate
                public final boolean test(Object obj) {
                    return Predicate.CC.$private$lambda$and$0(predicate, predicate2, obj);
                }
            };
        }

        public static Predicate $default$negate(final Predicate predicate) {
            return new Predicate() { // from class: j$.util.function.Predicate$$ExternalSyntheticLambda3
                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate2) {
                    return Predicate.CC.$default$and(this, predicate2);
                }

                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate.CC.$default$negate(this);
                }

                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate2) {
                    return Predicate.CC.$default$or(this, predicate2);
                }

                @Override // j$.util.function.Predicate
                public final boolean test(Object obj) {
                    return Predicate.CC.$private$lambda$negate$1(predicate, obj);
                }
            };
        }

        public static Predicate $default$or(final Predicate predicate, final Predicate predicate2) {
            Objects.requireNonNull(predicate2);
            return new Predicate() { // from class: j$.util.function.Predicate$$ExternalSyntheticLambda4
                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate3) {
                    return Predicate.CC.$default$and(this, predicate3);
                }

                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate.CC.$default$negate(this);
                }

                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate3) {
                    return Predicate.CC.$default$or(this, predicate3);
                }

                @Override // j$.util.function.Predicate
                public final boolean test(Object obj) {
                    return Predicate.CC.$private$lambda$or$2(predicate, predicate2, obj);
                }
            };
        }

        public static /* synthetic */ boolean $private$lambda$and$0(Predicate predicate, Predicate predicate2, Object obj) {
            return predicate.test(obj) && predicate2.test(obj);
        }

        public static /* synthetic */ boolean $private$lambda$negate$1(Predicate predicate, Object obj) {
            return !predicate.test(obj);
        }

        public static /* synthetic */ boolean $private$lambda$or$2(Predicate predicate, Predicate predicate2, Object obj) {
            return predicate.test(obj) || predicate2.test(obj);
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements Predicate {
        public final /* synthetic */ java.util.function.Predicate wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.Predicate predicate) {
            this.wrappedValue = predicate;
        }

        public static /* synthetic */ Predicate convert(java.util.function.Predicate predicate) {
            if (predicate == null) {
                return null;
            }
            return predicate instanceof Wrapper ? Predicate.this : new VivifiedWrapper(predicate);
        }

        @Override // j$.util.function.Predicate
        public /* synthetic */ Predicate and(Predicate predicate) {
            return convert(this.wrappedValue.and(Wrapper.convert(predicate)));
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.Predicate predicate = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return predicate.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }

        @Override // j$.util.function.Predicate
        public /* synthetic */ Predicate negate() {
            return convert(this.wrappedValue.negate());
        }

        @Override // j$.util.function.Predicate
        public /* synthetic */ Predicate or(Predicate predicate) {
            return convert(this.wrappedValue.or(Wrapper.convert(predicate)));
        }

        @Override // j$.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return this.wrappedValue.test(obj);
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.function.Predicate {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.Predicate convert(Predicate predicate) {
            if (predicate == null) {
                return null;
            }
            return predicate instanceof VivifiedWrapper ? ((VivifiedWrapper) predicate).wrappedValue : new Wrapper();
        }

        @Override // java.util.function.Predicate
        public /* synthetic */ java.util.function.Predicate and(java.util.function.Predicate predicate) {
            return convert(Predicate.this.and(VivifiedWrapper.convert(predicate)));
        }

        public /* synthetic */ boolean equals(Object obj) {
            Predicate predicate = Predicate.this;
            if (obj instanceof Wrapper) {
                obj = Predicate.this;
            }
            return predicate.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return Predicate.this.hashCode();
        }

        @Override // java.util.function.Predicate
        public /* synthetic */ java.util.function.Predicate negate() {
            return convert(Predicate.this.negate());
        }

        @Override // java.util.function.Predicate
        public /* synthetic */ java.util.function.Predicate or(java.util.function.Predicate predicate) {
            return convert(Predicate.this.or(VivifiedWrapper.convert(predicate)));
        }

        @Override // java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return Predicate.this.test(obj);
        }
    }

    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> predicate);

    boolean test(T t);
}

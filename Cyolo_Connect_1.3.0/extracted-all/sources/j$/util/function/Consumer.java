package j$.util.function;

import j$.util.Objects;
import j$.util.function.Consumer;

/* JADX INFO: loaded from: classes4.dex */
public interface Consumer<T> {

    /* JADX INFO: renamed from: j$.util.function.Consumer$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Consumer $default$andThen(final Consumer consumer, final Consumer consumer2) {
            Objects.requireNonNull(consumer2);
            return new Consumer() { // from class: j$.util.function.Consumer$$ExternalSyntheticLambda0
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    Consumer.CC.$private$lambda$andThen$0(consumer, consumer2, obj);
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer3) {
                    return Consumer.CC.$default$andThen(this, consumer3);
                }
            };
        }

        public static /* synthetic */ void $private$lambda$andThen$0(Consumer consumer, Consumer consumer2, Object obj) {
            consumer.accept(obj);
            consumer2.accept(obj);
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements Consumer {
        public final /* synthetic */ java.util.function.Consumer wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.Consumer consumer) {
            this.wrappedValue = consumer;
        }

        public static /* synthetic */ Consumer convert(java.util.function.Consumer consumer) {
            if (consumer == null) {
                return null;
            }
            return consumer instanceof Wrapper ? Consumer.this : new VivifiedWrapper(consumer);
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ void accept(Object obj) {
            this.wrappedValue.accept(obj);
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return convert(this.wrappedValue.andThen(Wrapper.convert(consumer)));
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.Consumer consumer = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return consumer.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.function.Consumer {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.Consumer convert(Consumer consumer) {
            if (consumer == null) {
                return null;
            }
            return consumer instanceof VivifiedWrapper ? ((VivifiedWrapper) consumer).wrappedValue : new Wrapper();
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ void accept(Object obj) {
            Consumer.this.accept(obj);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ java.util.function.Consumer andThen(java.util.function.Consumer consumer) {
            return convert(Consumer.this.andThen(VivifiedWrapper.convert(consumer)));
        }

        public /* synthetic */ boolean equals(Object obj) {
            Consumer consumer = Consumer.this;
            if (obj instanceof Wrapper) {
                obj = Consumer.this;
            }
            return consumer.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return Consumer.this.hashCode();
        }
    }

    void accept(T t);

    Consumer<T> andThen(Consumer<? super T> consumer);
}

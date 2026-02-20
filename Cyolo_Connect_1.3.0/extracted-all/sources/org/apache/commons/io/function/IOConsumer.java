package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: loaded from: classes3.dex */
@FunctionalInterface
public interface IOConsumer<T> {
    void accept(T t) throws IOException;

    IOConsumer<T> andThen(IOConsumer<? super T> iOConsumer);

    /* JADX INFO: renamed from: org.apache.commons.io.function.IOConsumer$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static IOConsumer $default$andThen(final IOConsumer _this, final IOConsumer iOConsumer) {
            Objects.requireNonNull(iOConsumer);
            return new IOConsumer() { // from class: org.apache.commons.io.function.IOConsumer$$ExternalSyntheticLambda0
                @Override // org.apache.commons.io.function.IOConsumer
                public final void accept(Object obj) throws IOException {
                    IOConsumer.CC.$private$lambda$andThen$0(_this, iOConsumer, obj);
                }

                @Override // org.apache.commons.io.function.IOConsumer
                public /* synthetic */ IOConsumer andThen(IOConsumer iOConsumer2) {
                    return IOConsumer.CC.$default$andThen(this, iOConsumer2);
                }
            };
        }

        public static /* synthetic */ void $private$lambda$andThen$0(IOConsumer _this, IOConsumer iOConsumer, Object obj) throws IOException {
            _this.accept(obj);
            iOConsumer.accept(obj);
        }
    }
}

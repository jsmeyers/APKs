package androidx.test.espresso.core.internal.deps.guava.base;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Joiner {
    private final String separator;

    public static Joiner on(String separator) {
        return new Joiner(separator);
    }

    private Joiner(String separator) {
        this.separator = (String) Preconditions.checkNotNull(separator);
    }

    public <A extends Appendable> A appendTo(A appendable, Iterator<?> parts) throws IOException {
        Preconditions.checkNotNull(appendable);
        if (parts.hasNext()) {
            appendable.append(toString(parts.next()));
            while (parts.hasNext()) {
                appendable.append(this.separator);
                appendable.append(toString(parts.next()));
            }
        }
        return appendable;
    }

    public final StringBuilder appendTo(StringBuilder builder, Iterable<?> parts) {
        return appendTo(builder, parts.iterator());
    }

    public final StringBuilder appendTo(StringBuilder builder, Iterator<?> parts) {
        try {
            appendTo(builder, parts);
            return builder;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final String join(Iterable<?> parts) {
        return join(parts.iterator());
    }

    public final String join(Iterator<?> parts) {
        return appendTo(new StringBuilder(), parts).toString();
    }

    CharSequence toString(Object part) {
        Preconditions.checkNotNull(part);
        return part instanceof CharSequence ? (CharSequence) part : part.toString();
    }
}

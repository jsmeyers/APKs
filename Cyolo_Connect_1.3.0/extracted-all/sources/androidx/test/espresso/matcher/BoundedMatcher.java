package androidx.test.espresso.matcher;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import org.hamcrest.BaseMatcher;

/* JADX INFO: loaded from: classes.dex */
public abstract class BoundedMatcher<T, S extends T> extends BaseMatcher<T> {
    private final Class<?> expectedType;
    private final Class<?>[] interfaceTypes;

    protected abstract boolean matchesSafely(S item);

    public BoundedMatcher(Class<? extends S> expectedType) {
        this.expectedType = (Class) Preconditions.checkNotNull(expectedType);
        this.interfaceTypes = new Class[0];
    }

    public BoundedMatcher(Class<?> expectedType, Class<?> interfaceType1, Class<?>... otherInterfaces) {
        this.expectedType = (Class) Preconditions.checkNotNull(expectedType);
        Preconditions.checkNotNull(otherInterfaces);
        Class<?>[] clsArr = new Class[otherInterfaces.length + 1];
        this.interfaceTypes = clsArr;
        clsArr[0] = (Class) Preconditions.checkNotNull(interfaceType1);
        Preconditions.checkArgument(interfaceType1.isInterface());
        int i = 1;
        for (Class<?> cls : otherInterfaces) {
            this.interfaceTypes[i] = (Class) Preconditions.checkNotNull(cls);
            Preconditions.checkArgument(cls.isInterface());
            i++;
        }
    }

    @Override // org.hamcrest.Matcher
    public final boolean matches(Object item) {
        if (item == null || !this.expectedType.isInstance(item)) {
            return false;
        }
        for (Class<?> cls : this.interfaceTypes) {
            if (!cls.isInstance(item)) {
                return false;
            }
        }
        return matchesSafely(item);
    }
}

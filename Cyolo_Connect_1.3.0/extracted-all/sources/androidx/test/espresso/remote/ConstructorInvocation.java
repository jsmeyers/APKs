package androidx.test.espresso.remote;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.cache.Cache;
import androidx.test.espresso.core.internal.deps.guava.cache.CacheBuilder;
import androidx.test.internal.util.LogUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ConstructorInvocation {
    private static final String TAG = "ConstructorInvocation";
    private static final Cache<ConstructorKey, Constructor<?>> constructorCache = CacheBuilder.newBuilder().maximumSize(256).build();
    private final Class<? extends Annotation> annotationClass;
    private final Class<?> clazz;
    private final Class<?>[] parameterTypes;

    public ConstructorInvocation(Class<?> clazz, Class<? extends Annotation> annotationClass, Class<?>... parameterTypes) {
        this.clazz = (Class) Preconditions.checkNotNull(clazz, "clazz cannot be null!");
        this.annotationClass = annotationClass;
        this.parameterTypes = parameterTypes;
    }

    static void invalidateCache() {
        constructorCache.invalidateAll();
    }

    public Object invokeConstructor(Object... constructorParams) {
        return invokeConstructorExplosively(constructorParams);
    }

    private Object invokeConstructorExplosively(Object... constructorParams) {
        ConstructorKey constructorKey = new ConstructorKey(this.clazz, this.parameterTypes);
        Constructor<?> constructor = null;
        try {
            try {
                try {
                    try {
                        Constructor<?> ifPresent = constructorCache.getIfPresent(constructorKey);
                        try {
                            if (ifPresent == null) {
                                LogUtil.logDebug(TAG, "Cache miss for constructor: %s(%s). Loading into cache.", this.clazz.getSimpleName(), Arrays.toString(constructorParams));
                                if (this.annotationClass == null) {
                                    constructor = ifPresent;
                                    break;
                                }
                                Constructor<?>[] declaredConstructors = this.clazz.getDeclaredConstructors();
                                int length = declaredConstructors.length;
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        constructor = ifPresent;
                                        break;
                                    }
                                    Constructor<?> constructor2 = declaredConstructors[i];
                                    if (constructor2.isAnnotationPresent(this.annotationClass)) {
                                        constructor = constructor2;
                                        break;
                                    }
                                    i++;
                                }
                                if (constructor == null) {
                                    constructor = this.clazz.getConstructor(this.parameterTypes);
                                }
                                Preconditions.checkState(constructor != null, "No constructor found for annotation: %s, or parameter types: %s", this.annotationClass, Arrays.asList(this.parameterTypes));
                                constructorCache.put(constructorKey, constructor);
                            } else {
                                LogUtil.logDebug(TAG, "Cache hit for constructor: %s(%s).", this.clazz.getSimpleName(), Arrays.toString(constructorParams));
                                constructor = ifPresent;
                            }
                            constructor.setAccessible(true);
                            Object objNewInstance = constructor.newInstance(constructorParams);
                            LogUtil.logDebug(TAG, "%s(%s)", this.clazz.getSimpleName(), Arrays.toString(constructorParams));
                            return objNewInstance;
                        } catch (SecurityException e) {
                            e = e;
                            constructor = ifPresent;
                            throw new RemoteProtocolException(String.format(Locale.ROOT, "Constructor not accessible: %s", constructor.getName()), e);
                        } catch (InvocationTargetException e2) {
                            e = e2;
                            constructor = ifPresent;
                            throw new RemoteProtocolException(String.format(Locale.ROOT, "Cannot invoke constructor %s with constructorParams [%s] on clazz %s", constructor, Arrays.toString(constructorParams), this.clazz.getName()), e);
                        }
                    } catch (InstantiationException e3) {
                        throw new RemoteProtocolException(String.format(Locale.ROOT, "Cannot create instance of %s", this.clazz.getName()), e3);
                    }
                } catch (IllegalAccessException e4) {
                    throw new RemoteProtocolException(String.format(Locale.ROOT, "Cannot create instance of %s", this.clazz.getName()), e4);
                } catch (NoSuchMethodException e5) {
                    throw new RemoteProtocolException(String.format(Locale.ROOT, "No constructor found for clazz: %s. Available constructors: %s", this.clazz.getName(), Arrays.asList(this.clazz.getConstructors())), e5);
                }
            } catch (Throwable th) {
                LogUtil.logDebug(TAG, "%s(%s)", this.clazz.getSimpleName(), Arrays.toString(constructorParams));
                throw th;
            }
        } catch (SecurityException e6) {
            e = e6;
        } catch (InvocationTargetException e7) {
            e = e7;
        }
    }

    private static final class ConstructorKey {
        private final Class<?>[] parameterTypes;
        private final Class<?> type;

        public ConstructorKey(Class<?> type, Class<?>[] parameterTypes) {
            this.type = type;
            this.parameterTypes = parameterTypes;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ConstructorKey constructorKey = (ConstructorKey) o;
            if (this.type.equals(constructorKey.type)) {
                return Arrays.equals(this.parameterTypes, constructorKey.parameterTypes);
            }
            return false;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + Arrays.hashCode(this.parameterTypes);
        }
    }
}

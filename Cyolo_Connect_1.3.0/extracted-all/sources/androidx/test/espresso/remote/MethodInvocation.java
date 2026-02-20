package androidx.test.espresso.remote;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.cache.Cache;
import androidx.test.espresso.core.internal.deps.guava.cache.CacheBuilder;
import androidx.test.internal.util.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class MethodInvocation {
    private static final String TAG = "MethodInvocation";
    private static final Cache<MethodKey, Method> methodCache = CacheBuilder.newBuilder().maximumSize(256).build();
    private final Class<?> clazz;
    private final Object instance;
    private final String methodName;
    private final Class<?>[] parameterTypes;

    public MethodInvocation(Class<?> clazz, Object instance, String methodName, Class<?>... parameterTypes) {
        this.clazz = (Class) Preconditions.checkNotNull(clazz, "clazz cannot be null!");
        this.instance = instance;
        Preconditions.checkArgument((methodName == null || methodName.isEmpty()) ? false : true, "methodName cannot be null or empty");
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
    }

    private static Method getMethod(MethodKey methodKey) throws NoSuchMethodException {
        return getMethodInternal(methodKey, false);
    }

    private static Method getDeclaredMethod(MethodKey methodKey) throws NoSuchMethodException {
        return getMethodInternal(methodKey, true);
    }

    private static Method getMethodInternal(MethodKey methodKey, boolean declaredMethod) throws NoSuchMethodException {
        Cache<MethodKey, Method> cache = methodCache;
        Method ifPresent = cache.getIfPresent(methodKey);
        if (ifPresent == null) {
            LogUtil.logDebug(TAG, "Cache miss for method: %s#%s(%s). Loading into cache.", methodKey.type.getSimpleName(), methodKey.methodName, Arrays.toString(methodKey.parameterTypes));
            Method declaredMethod2 = declaredMethod ? methodKey.type.getDeclaredMethod(methodKey.methodName, methodKey.parameterTypes) : methodKey.type.getMethod(methodKey.methodName, methodKey.parameterTypes);
            cache.put(methodKey, declaredMethod2);
            return declaredMethod2;
        }
        LogUtil.logDebug(TAG, "Cache hit for method: %s#%s(%s).", methodKey.type.getSimpleName(), methodKey.methodName, Arrays.toString(methodKey.parameterTypes));
        return ifPresent;
    }

    public static void invalidateCache() {
        methodCache.invalidateAll();
    }

    public Object invokeDeclaredMethod(Object... methodParams) {
        try {
            return invokeMethodExplosively(getDeclaredMethod(new MethodKey(this.clazz, this.methodName, this.parameterTypes)), methodParams);
        } catch (NoSuchMethodException e) {
            throw new RemoteProtocolException(String.format(Locale.ROOT, "No method: %s(%s) found for clazz: %s Available methods: %s", this.methodName, Arrays.asList(this.parameterTypes), this.clazz.getName(), Arrays.asList(this.clazz.getDeclaredMethods())), e);
        }
    }

    public Object invokeMethod(Object... methodParams) {
        try {
            return invokeMethodExplosively(getMethod(new MethodKey(this.clazz, this.methodName, this.parameterTypes)), methodParams);
        } catch (NoSuchMethodException e) {
            throw new RemoteProtocolException(String.format(Locale.ROOT, "No method: %s found for clazz: %s. Available methods: %s", this.methodName, this.clazz.getName(), Arrays.asList(this.clazz.getMethods())), e);
        }
    }

    private Object invokeMethodExplosively(Method method, Object... args) {
        try {
            try {
                try {
                    method.setAccessible(true);
                    Object objInvoke = method.invoke(this.instance, args);
                    LogUtil.logDebug(TAG, "%s.invokeMethodExplosively(%s,%s)", this.clazz.getSimpleName(), this.methodName, Arrays.toString(args));
                    return objInvoke;
                } catch (SecurityException e) {
                    throw new RemoteProtocolException(String.format(Locale.ROOT, "Method not accessible: %s", method.getName()), e);
                }
            } catch (IllegalAccessException e2) {
                throw new RemoteProtocolException(String.format(Locale.ROOT, "Cannot create instance of %s", this.clazz.getName()), e2);
            } catch (InvocationTargetException e3) {
                throw new RemoteProtocolException(String.format(Locale.ROOT, "Cannot invoke method %s with args [%s] on builder %s", method, Arrays.toString(args), this.clazz.getName()), e3);
            }
        } catch (Throwable th) {
            LogUtil.logDebug(TAG, "%s.invokeMethodExplosively(%s,%s)", this.clazz.getSimpleName(), this.methodName, Arrays.toString(args));
            throw th;
        }
    }

    private static final class MethodKey {
        private final String methodName;
        private final Class<?>[] parameterTypes;
        private final Class<?> type;

        public MethodKey(Class<?> type, String methodName, Class<?>[] parameterTypes) {
            this.type = type;
            this.methodName = methodName;
            this.parameterTypes = parameterTypes;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MethodKey methodKey = (MethodKey) o;
            if (this.type.equals(methodKey.type) && this.methodName.equals(methodKey.methodName)) {
                return Arrays.equals(this.parameterTypes, methodKey.parameterTypes);
            }
            return false;
        }

        public int hashCode() {
            return (((this.type.hashCode() * 31) + this.methodName.hashCode()) * 31) + Arrays.hashCode(this.parameterTypes);
        }
    }
}

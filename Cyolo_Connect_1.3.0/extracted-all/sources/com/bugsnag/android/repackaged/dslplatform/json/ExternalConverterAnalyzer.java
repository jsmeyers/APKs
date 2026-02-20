package com.bugsnag.android.repackaged.dslplatform.json;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class ExternalConverterAnalyzer {
    private final ClassLoader[] classLoaders;
    private final Set<String> lookedUpClasses = new HashSet();

    ExternalConverterAnalyzer(Collection<ClassLoader> collection) {
        this.classLoaders = (ClassLoader[]) collection.toArray(new ClassLoader[0]);
    }

    synchronized boolean tryFindConverter(Class<?> cls, DslJson<?> dslJson) {
        String name = cls.getName();
        if (!this.lookedUpClasses.add(name)) {
            return false;
        }
        String[] strArrResolveExternalConverterClassNames = resolveExternalConverterClassNames(name);
        for (ClassLoader classLoader : this.classLoaders) {
            for (String str : strArrResolveExternalConverterClassNames) {
                try {
                    Class<?> clsLoadClass = classLoader.loadClass(str);
                    if (Configuration.class.isAssignableFrom(clsLoadClass)) {
                        ((Configuration) clsLoadClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).configure(dslJson);
                        return true;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                }
            }
        }
        return false;
    }

    private String[] resolveExternalConverterClassNames(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            return new String[]{String.format("_%s_DslJsonConverter", str)};
        }
        String strSubstring = str.substring(0, iLastIndexOf);
        String strSubstring2 = str.substring(iLastIndexOf + 1);
        return new String[]{String.format("%s._%s_DslJsonConverter", strSubstring, strSubstring2), String.format("dsl_json.%s._%s_DslJsonConverter", strSubstring, strSubstring2), String.format("dsl_json.%s.%sDslJsonConverter", strSubstring, strSubstring2)};
    }
}

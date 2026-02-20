package org.hamcrest;

/* JADX INFO: loaded from: classes3.dex */
public class JavaLangMatcherAssert {
    private JavaLangMatcherAssert() {
    }

    public static <T> boolean that(T t, Matcher<? super T> matcher) {
        return matcher.matches(t);
    }
}

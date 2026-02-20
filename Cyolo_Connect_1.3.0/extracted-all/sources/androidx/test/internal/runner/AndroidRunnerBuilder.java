package androidx.test.internal.runner;

import androidx.test.internal.runner.junit3.AndroidJUnit3Builder;
import androidx.test.internal.runner.junit3.AndroidSuiteBuilder;
import androidx.test.internal.runner.junit4.AndroidAnnotatedBuilder;
import androidx.test.internal.runner.junit4.AndroidJUnit4Builder;
import androidx.test.internal.util.AndroidRunnerParams;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.internal.builders.AnnotatedBuilder;
import org.junit.internal.builders.IgnoredBuilder;
import org.junit.internal.builders.JUnit3Builder;
import org.junit.internal.builders.JUnit4Builder;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/* JADX INFO: loaded from: classes.dex */
class AndroidRunnerBuilder extends AllDefaultPossibilitiesBuilder {
    private final AndroidAnnotatedBuilder androidAnnotatedBuilder;
    private final AndroidJUnit3Builder androidJUnit3Builder;
    private final AndroidJUnit4Builder androidJUnit4Builder;
    private final AndroidSuiteBuilder androidSuiteBuilder;
    private final List<RunnerBuilder> customRunnerBuilders;
    private final IgnoredBuilder ignoredBuilder;

    public AndroidRunnerBuilder(AndroidRunnerParams runnerParams) {
        this(null, runnerParams, false, Collections.emptyList());
    }

    AndroidRunnerBuilder(AndroidRunnerParams runnerParams, boolean scanningPath, List<Class<? extends RunnerBuilder>> customRunnerBuilderClasses) {
        this(null, runnerParams, scanningPath, customRunnerBuilderClasses);
    }

    AndroidRunnerBuilder(RunnerBuilder suiteBuilder, AndroidRunnerParams runnerParams, boolean scanningPath, List<Class<? extends RunnerBuilder>> customRunnerBuilderClasses) {
        super(true);
        this.androidJUnit3Builder = new AndroidJUnit3Builder(runnerParams, scanningPath);
        this.androidJUnit4Builder = new AndroidJUnit4Builder(runnerParams, scanningPath);
        this.androidSuiteBuilder = new AndroidSuiteBuilder(runnerParams);
        this.androidAnnotatedBuilder = new AndroidAnnotatedBuilder(suiteBuilder == null ? this : suiteBuilder, runnerParams);
        this.ignoredBuilder = new IgnoredBuilder();
        this.customRunnerBuilders = instantiateRunnerBuilders(customRunnerBuilderClasses);
    }

    private List<RunnerBuilder> instantiateRunnerBuilders(List<Class<? extends RunnerBuilder>> customRunnerBuilderClasses) {
        ArrayList arrayList = new ArrayList();
        for (Class<? extends RunnerBuilder> cls : customRunnerBuilderClasses) {
            try {
                arrayList.add(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (IllegalAccessException e) {
                String strValueOf = String.valueOf(cls);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 113);
                sb.append("Could not create instance of ");
                sb.append(strValueOf);
                sb.append(", make sure that it is a public concrete class with a public no-argument constructor");
                throw new IllegalStateException(sb.toString(), e);
            } catch (InstantiationException e2) {
                String strValueOf2 = String.valueOf(cls);
                StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 113);
                sb2.append("Could not create instance of ");
                sb2.append(strValueOf2);
                sb2.append(", make sure that it is a public concrete class with a public no-argument constructor");
                throw new IllegalStateException(sb2.toString(), e2);
            } catch (NoSuchMethodException e3) {
                String strValueOf3 = String.valueOf(cls);
                StringBuilder sb3 = new StringBuilder(String.valueOf(strValueOf3).length() + 113);
                sb3.append("Could not create instance of ");
                sb3.append(strValueOf3);
                sb3.append(", make sure that it is a public concrete class with a public no-argument constructor");
                throw new IllegalStateException(sb3.toString(), e3);
            } catch (InvocationTargetException e4) {
                String strValueOf4 = String.valueOf(cls);
                StringBuilder sb4 = new StringBuilder(String.valueOf(strValueOf4).length() + 74);
                sb4.append("Could not create instance of ");
                sb4.append(strValueOf4);
                sb4.append(", the constructor must not throw an exception");
                throw new IllegalStateException(sb4.toString(), e4);
            }
        }
        return arrayList;
    }

    @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder, org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> testClass) throws Throwable {
        Iterator<RunnerBuilder> it = this.customRunnerBuilders.iterator();
        while (it.hasNext()) {
            Runner runnerSafeRunnerForClass = it.next().safeRunnerForClass(testClass);
            if (runnerSafeRunnerForClass != null) {
                return runnerSafeRunnerForClass;
            }
        }
        return super.runnerForClass(testClass);
    }

    @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder
    protected JUnit4Builder junit4Builder() {
        return this.androidJUnit4Builder;
    }

    @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder
    protected JUnit3Builder junit3Builder() {
        return this.androidJUnit3Builder;
    }

    @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder
    protected AnnotatedBuilder annotatedBuilder() {
        return this.androidAnnotatedBuilder;
    }

    @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder
    protected IgnoredBuilder ignoredBuilder() {
        return this.ignoredBuilder;
    }

    @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder
    protected RunnerBuilder suiteMethodBuilder() {
        return this.androidSuiteBuilder;
    }
}

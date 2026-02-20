package androidx.test.internal.runner;

import android.util.Log;
import androidx.test.internal.runner.junit3.AndroidJUnit3Builder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.RunnerBuilder;

/* JADX INFO: loaded from: classes.dex */
class TestLoader {
    private static final String LOG_TAG = "TestLoader";
    private final ClassLoader classLoader;
    private final RunnerBuilder runnerBuilder;
    private final Map<String, Runner> runnersMap = new LinkedHashMap();

    static TestLoader testLoader(ClassLoader classLoader, RunnerBuilder runnerBuilder, boolean scanningPath) {
        if (scanningPath) {
            runnerBuilder = new ScanningRunnerBuilder(runnerBuilder);
        }
        if (classLoader == null) {
            classLoader = TestLoader.class.getClassLoader();
        }
        return new TestLoader(classLoader, runnerBuilder);
    }

    private TestLoader(ClassLoader classLoader, RunnerBuilder runnerBuilder) {
        this.classLoader = classLoader;
        this.runnerBuilder = runnerBuilder;
    }

    /* JADX WARN: Found duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Found duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    private void doCreateRunner(String className, boolean isScanningPath) {
        Class<?> cls;
        Runner runnerSafeRunnerForClass;
        if (this.runnersMap.containsKey(className)) {
            return;
        }
        Runner unloadableClassRunner = null;
        try {
            cls = Class.forName(className, false, this.classLoader);
            runnerSafeRunnerForClass = this.runnerBuilder.safeRunnerForClass(cls);
            unloadableClassRunner = runnerSafeRunnerForClass;
        } catch (ClassNotFoundException e) {
            Log.e(LOG_TAG, String.format("Could not find class: %s", className));
            Description descriptionCreateSuiteDescription = Description.createSuiteDescription(className, new Annotation[0]);
            Failure failure = new Failure(descriptionCreateSuiteDescription, e);
            if (!isScanningPath) {
                unloadableClassRunner = new UnloadableClassRunner(descriptionCreateSuiteDescription, failure);
            }
        }
        if (runnerSafeRunnerForClass != null) {
            if (runnerSafeRunnerForClass == AndroidJUnit3Builder.NOT_A_VALID_TEST) {
                logDebug(String.format("Skipping class %s: not a valid test", cls.getName()));
            }
            if (unloadableClassRunner != null) {
                this.runnersMap.put(className, unloadableClassRunner);
            }
        }
        logDebug(String.format("Skipping class %s: not a test", cls.getName()));
        if (unloadableClassRunner != null) {
            this.runnersMap.put(className, unloadableClassRunner);
        }
    }

    List<Runner> getRunnersFor(Collection<String> classNames, boolean isScanningPath) {
        Iterator<String> it = classNames.iterator();
        while (it.hasNext()) {
            doCreateRunner(it.next(), isScanningPath);
        }
        return new ArrayList(this.runnersMap.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logDebug(String msg) {
        if (Log.isLoggable(LOG_TAG, 3)) {
            Log.d(LOG_TAG, msg);
        }
    }

    private static class ScanningRunnerBuilder extends RunnerBuilder {
        private final RunnerBuilder runnerBuilder;

        ScanningRunnerBuilder(RunnerBuilder runnerBuilder) {
            this.runnerBuilder = runnerBuilder;
        }

        @Override // org.junit.runners.model.RunnerBuilder
        public Runner runnerForClass(Class<?> testClass) throws Throwable {
            if (Modifier.isAbstract(testClass.getModifiers())) {
                TestLoader.logDebug(String.format("Skipping abstract class %s: not a test", testClass.getName()));
                return null;
            }
            return this.runnerBuilder.runnerForClass(testClass);
        }
    }

    static class UnloadableClassRunner extends Runner {
        private final Description description;
        private final Failure failure;

        UnloadableClassRunner(Description description, Failure failure) {
            this.description = description;
            this.failure = failure;
        }

        @Override // org.junit.runner.Runner, org.junit.runner.Describable
        public Description getDescription() {
            return this.description;
        }

        @Override // org.junit.runner.Runner
        public void run(RunNotifier notifier) {
            notifier.fireTestStarted(this.description);
            notifier.fireTestFailure(this.failure);
            notifier.fireTestFinished(this.description);
        }
    }
}

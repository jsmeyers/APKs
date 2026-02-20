package dev.flutter.plugins.integration_test;

import android.util.Log;
import androidx.test.rule.ActivityTestRule;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterTestRunner extends Runner {
    private static final String TAG = "FlutterTestRunner";
    TestRule rule;
    final Class<?> testClass;

    public FlutterTestRunner(Class<?> cls) {
        this.rule = null;
        this.testClass = cls;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(Rule.class)) {
                try {
                    Object objNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (field.get(objNewInstance) instanceof ActivityTestRule) {
                        this.rule = (TestRule) field.get(objNewInstance);
                        return;
                    }
                } catch (IllegalAccessException e) {
                    e = e;
                    throw new RuntimeException("Unable to access activity rule", e);
                } catch (InstantiationException e2) {
                    e = e2;
                    throw new RuntimeException("Unable to access activity rule", e);
                } catch (NoSuchMethodException | InvocationTargetException unused) {
                    throw new RuntimeException("Unable to contruct " + cls.getName() + " object for testing");
                }
            }
        }
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        return Description.createTestDescription(this.testClass, "Flutter Tests");
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        TestRule testRule = this.rule;
        if (testRule == null) {
            throw new RuntimeException("Unable to run tests due to missing activity rule");
        }
        try {
            if (testRule instanceof ActivityTestRule) {
                ((ActivityTestRule) testRule).launchActivity(null);
            }
        } catch (RuntimeException e) {
            Log.v(TAG, "launchActivity failed, possibly because the activity was already running. " + e);
            Log.v(TAG, "Try disabling auto-launch of the activity, e.g. ActivityTestRule<>(MainActivity.class, true, false);");
        }
        try {
            Map<String, String> map = IntegrationTestPlugin.testResults.get();
            for (String str : map.keySet()) {
                Description descriptionCreateTestDescription = Description.createTestDescription(this.testClass, str);
                runNotifier.fireTestStarted(descriptionCreateTestDescription);
                String str2 = map.get(str);
                if (!str2.equals("success")) {
                    runNotifier.fireTestFailure(new Failure(descriptionCreateTestDescription, new Exception(str2)));
                }
                runNotifier.fireTestFinished(descriptionCreateTestDescription);
            }
        } catch (InterruptedException | ExecutionException unused) {
            throw new IllegalThreadStateException("Unable to get test results");
        }
    }
}

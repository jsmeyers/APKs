package androidx.test.internal.runner.listener;

import android.app.Instrumentation;
import android.os.Bundle;
import android.util.Log;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import org.junit.runner.Result;

/* JADX INFO: loaded from: classes.dex */
public class CoverageListener extends InstrumentationRunListener {
    private static final String DEFAULT_COVERAGE_FILE_NAME = "coverage.ec";
    private static final String EMMA_RUNTIME_CLASS = "com.vladium.emma.rt.RT";
    private static final String REPORT_KEY_COVERAGE_PATH = "coverageFilePath";
    private static final String TAG = "CoverageListener";
    private String coverageFilePath;

    public CoverageListener(String customCoverageFilePath) {
        this.coverageFilePath = customCoverageFilePath;
    }

    @Override // androidx.test.internal.runner.listener.InstrumentationRunListener
    public void setInstrumentation(Instrumentation instr) {
        super.setInstrumentation(instr);
        if (this.coverageFilePath == null) {
            String absolutePath = instr.getTargetContext().getFilesDir().getAbsolutePath();
            String str = File.separator;
            StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 11 + String.valueOf(str).length());
            sb.append(absolutePath);
            sb.append(str);
            sb.append(DEFAULT_COVERAGE_FILE_NAME);
            this.coverageFilePath = sb.toString();
        }
    }

    @Override // androidx.test.internal.runner.listener.InstrumentationRunListener
    public void instrumentationRunFinished(PrintStream writer, Bundle results, Result junitResults) {
        generateCoverageReport(writer, results);
    }

    private void generateCoverageReport(PrintStream writer, Bundle results) {
        Class<?> cls;
        File file = new File(this.coverageFilePath);
        try {
            try {
                try {
                    cls = Class.forName(EMMA_RUNTIME_CLASS, true, getInstrumentation().getTargetContext().getClassLoader());
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName(EMMA_RUNTIME_CLASS, true, getInstrumentation().getContext().getClassLoader());
                    Log.w(TAG, "Generating coverage for alternate test context.");
                    writer.format("\nWarning: %s", "Generating coverage for alternate test context.");
                }
                cls.getMethod("dumpCoverageData", file.getClass(), Boolean.TYPE, Boolean.TYPE).invoke(null, file, false, false);
                results.putString(REPORT_KEY_COVERAGE_PATH, this.coverageFilePath);
                writer.format("\nGenerated code coverage data to %s", this.coverageFilePath);
            } catch (ClassNotFoundException e) {
                reportEmmaError(writer, "Is Emma/JaCoCo jar on classpath?", e);
            }
        } catch (IllegalAccessException e2) {
            reportEmmaError(writer, e2);
        } catch (IllegalArgumentException e3) {
            reportEmmaError(writer, e3);
        } catch (NoSuchMethodException e4) {
            reportEmmaError(writer, e4);
        } catch (SecurityException e5) {
            reportEmmaError(writer, e5);
        } catch (InvocationTargetException e6) {
            reportEmmaError(writer, e6);
        }
    }

    private void reportEmmaError(PrintStream writer, Exception e) {
        reportEmmaError(writer, "", e);
    }

    private void reportEmmaError(PrintStream writer, String hint, Exception e) {
        String strValueOf = String.valueOf(hint);
        String strConcat = strValueOf.length() != 0 ? "Failed to generate Emma/JaCoCo coverage. ".concat(strValueOf) : new String("Failed to generate Emma/JaCoCo coverage. ");
        Log.e(TAG, strConcat, e);
        writer.format("\nError: %s", strConcat);
    }
}

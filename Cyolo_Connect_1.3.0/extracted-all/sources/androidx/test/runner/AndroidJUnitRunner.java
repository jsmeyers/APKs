package androidx.test.runner;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import androidx.test.internal.runner.RunnerArgs;
import androidx.test.internal.runner.TestExecutor;
import androidx.test.internal.runner.TestRequestBuilder;
import androidx.test.internal.runner.listener.ActivityFinisherRunListener;
import androidx.test.internal.runner.listener.CoverageListener;
import androidx.test.internal.runner.listener.DelayInjector;
import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import androidx.test.internal.runner.listener.LogRunListener;
import androidx.test.internal.runner.listener.SuiteAssignmentPrinter;
import androidx.test.internal.runner.tracker.AnalyticsBasedUsageTracker;
import androidx.test.internal.runner.tracker.UsageTrackerRegistry;
import androidx.test.internal.util.ReflectionUtil;
import androidx.test.orchestrator.instrumentationlistener.OrchestratedInstrumentationListener;
import androidx.test.runner.MonitoringInstrumentation;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitorRegistry;
import androidx.test.runner.screenshot.Screenshot;
import java.util.HashSet;
import java.util.Iterator;
import org.junit.runner.Request;
import org.junit.runner.notification.RunListener;

/* JADX INFO: loaded from: classes.dex */
public class AndroidJUnitRunner extends MonitoringInstrumentation implements OrchestratedInstrumentationListener.OnConnectListener {
    private static final String LOG_TAG = "AndroidJUnitRunner";
    private Bundle arguments;
    private InstrumentationResultPrinter instrumentationResultPrinter = new InstrumentationResultPrinter();
    private OrchestratedInstrumentationListener orchestratorListener;
    private RunnerArgs runnerArgs;
    private UsageTrackerFacilitator usageTrackerFacilitator;

    @Override // androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public void onCreate(Bundle arguments) {
        this.arguments = arguments;
        parseRunnerArgs(arguments);
        if (waitForDebugger(this.runnerArgs)) {
            Log.i("AndroidJUnitRunner", "Waiting for debugger to connect...");
            Debug.waitForDebugger();
            Log.i("AndroidJUnitRunner", "Debugger connected.");
        }
        if (isPrimaryInstrProcess(this.runnerArgs.targetProcess)) {
            this.usageTrackerFacilitator = new UsageTrackerFacilitator(this.runnerArgs);
        } else {
            this.usageTrackerFacilitator = new UsageTrackerFacilitator(false);
        }
        super.onCreate(arguments);
        Iterator<ApplicationLifecycleCallback> it = this.runnerArgs.appListeners.iterator();
        while (it.hasNext()) {
            ApplicationLifecycleMonitorRegistry.getInstance().addLifecycleCallback(it.next());
        }
        addScreenCaptureProcessors(this.runnerArgs);
        if (this.runnerArgs.orchestratorService != null && isPrimaryInstrProcess(this.runnerArgs.targetProcess)) {
            OrchestratedInstrumentationListener orchestratedInstrumentationListener = new OrchestratedInstrumentationListener(this);
            this.orchestratorListener = orchestratedInstrumentationListener;
            orchestratedInstrumentationListener.connect(getContext());
            return;
        }
        start();
    }

    private boolean waitForDebugger(RunnerArgs arguments) {
        return arguments.debug && !arguments.listTestsForOrchestrator;
    }

    @Override // androidx.test.orchestrator.instrumentationlistener.OrchestratedInstrumentationListener.OnConnectListener
    public void onOrchestratorConnect() {
        start();
    }

    private void parseRunnerArgs(Bundle arguments) {
        this.runnerArgs = new RunnerArgs.Builder().fromManifest(this).fromBundle(this, arguments).build();
    }

    private Bundle getArguments() {
        return this.arguments;
    }

    InstrumentationResultPrinter getInstrumentationResultPrinter() {
        return this.instrumentationResultPrinter;
    }

    @Override // androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public void onStart() {
        setJsBridgeClassName("androidx.test.espresso.web.bridge.JavaScriptBridge");
        super.onStart();
        if (this.runnerArgs.listTestsForOrchestrator && isPrimaryInstrProcess(this.runnerArgs.targetProcess)) {
            this.orchestratorListener.addTests(buildRequest(this.runnerArgs, getArguments()).getRunner().getDescription());
            finish(-1, new Bundle());
            return;
        }
        if (this.runnerArgs.remoteMethod != null) {
            ReflectionUtil.reflectivelyInvokeRemoteMethod(this.runnerArgs.remoteMethod.testClassName, this.runnerArgs.remoteMethod.methodName);
        }
        if (!isPrimaryInstrProcess(this.runnerArgs.targetProcess)) {
            Log.i("AndroidJUnitRunner", "Runner is idle...");
            return;
        }
        Bundle bundle = new Bundle();
        try {
            TestExecutor.Builder builder = new TestExecutor.Builder(this);
            addListeners(this.runnerArgs, builder);
            bundle = builder.build().execute(buildRequest(this.runnerArgs, getArguments()));
        } catch (RuntimeException e) {
            Log.e("AndroidJUnitRunner", "Fatal exception when running tests", e);
            String strValueOf = String.valueOf(Log.getStackTraceString(e));
            bundle.putString("stream", strValueOf.length() != 0 ? "Fatal exception when running tests\n".concat(strValueOf) : new String("Fatal exception when running tests\n"));
        }
        finish(-1, bundle);
    }

    @Override // androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public void finish(int resultCode, Bundle results) {
        try {
            this.usageTrackerFacilitator.trackUsage("AndroidJUnitRunner", UsageTrackerRegistry.AxtVersions.RUNNER_VERSION);
            this.usageTrackerFacilitator.sendUsages();
        } catch (RuntimeException e) {
            Log.w("AndroidJUnitRunner", "Failed to send analytics.", e);
        }
        super.finish(resultCode, results);
    }

    final void addListeners(RunnerArgs args, TestExecutor.Builder builder) {
        if (args.newRunListenerMode) {
            addListenersNewOrder(args, builder);
        } else {
            addListenersLegacyOrder(args, builder);
        }
    }

    private void addListenersLegacyOrder(RunnerArgs args, TestExecutor.Builder builder) {
        if (args.logOnly) {
            builder.addRunListener(getInstrumentationResultPrinter());
        } else if (args.suiteAssignment) {
            builder.addRunListener(new SuiteAssignmentPrinter());
        } else {
            builder.addRunListener(new LogRunListener());
            OrchestratedInstrumentationListener orchestratedInstrumentationListener = this.orchestratorListener;
            if (orchestratedInstrumentationListener != null) {
                builder.addRunListener(orchestratedInstrumentationListener);
            } else {
                builder.addRunListener(getInstrumentationResultPrinter());
            }
            builder.addRunListener(new ActivityFinisherRunListener(this, new MonitoringInstrumentation.ActivityFinisher(), new Runnable() { // from class: androidx.test.runner.AndroidJUnitRunner.1
                @Override // java.lang.Runnable
                public void run() {
                    AndroidJUnitRunner.this.waitForActivitiesToComplete();
                }
            }));
            addDelayListener(args, builder);
            addCoverageListener(args, builder);
        }
        addListenersFromArg(args, builder);
    }

    private void addListenersNewOrder(RunnerArgs args, TestExecutor.Builder builder) {
        addListenersFromArg(args, builder);
        if (args.logOnly) {
            builder.addRunListener(getInstrumentationResultPrinter());
            return;
        }
        if (args.suiteAssignment) {
            builder.addRunListener(new SuiteAssignmentPrinter());
            return;
        }
        builder.addRunListener(new LogRunListener());
        addDelayListener(args, builder);
        addCoverageListener(args, builder);
        OrchestratedInstrumentationListener orchestratedInstrumentationListener = this.orchestratorListener;
        if (orchestratedInstrumentationListener != null) {
            builder.addRunListener(orchestratedInstrumentationListener);
        } else {
            builder.addRunListener(getInstrumentationResultPrinter());
        }
        builder.addRunListener(new ActivityFinisherRunListener(this, new MonitoringInstrumentation.ActivityFinisher(), new Runnable() { // from class: androidx.test.runner.AndroidJUnitRunner.2
            @Override // java.lang.Runnable
            public void run() {
                AndroidJUnitRunner.this.waitForActivitiesToComplete();
            }
        }));
    }

    private void addScreenCaptureProcessors(RunnerArgs args) {
        Screenshot.addScreenCaptureProcessors(new HashSet(args.screenCaptureProcessors));
    }

    private void addCoverageListener(RunnerArgs args, TestExecutor.Builder builder) {
        if (args.codeCoverage) {
            builder.addRunListener(new CoverageListener(args.codeCoveragePath));
        }
    }

    private void addDelayListener(RunnerArgs args, TestExecutor.Builder builder) {
        if (args.delayInMillis > 0) {
            builder.addRunListener(new DelayInjector(args.delayInMillis));
        } else {
            boolean z = args.logOnly;
        }
    }

    private void addListenersFromArg(RunnerArgs args, TestExecutor.Builder builder) {
        Iterator<RunListener> it = args.listeners.iterator();
        while (it.hasNext()) {
            builder.addRunListener(it.next());
        }
    }

    @Override // androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public boolean onException(Object obj, Throwable e) {
        InstrumentationResultPrinter instrumentationResultPrinter = getInstrumentationResultPrinter();
        if (instrumentationResultPrinter != null) {
            instrumentationResultPrinter.reportProcessCrash(e);
        }
        return super.onException(obj, e);
    }

    Request buildRequest(RunnerArgs runnerArgs, Bundle bundleArgs) {
        TestRequestBuilder testRequestBuilderCreateTestRequestBuilder = createTestRequestBuilder(this, bundleArgs);
        testRequestBuilderCreateTestRequestBuilder.addPathsToScan(runnerArgs.classpathToScan);
        if (runnerArgs.classpathToScan.isEmpty()) {
            testRequestBuilderCreateTestRequestBuilder.addPathToScan(getContext().getPackageCodePath());
        }
        testRequestBuilderCreateTestRequestBuilder.addFromRunnerArgs(runnerArgs);
        registerUserTracker();
        return testRequestBuilderCreateTestRequestBuilder.build();
    }

    private void registerUserTracker() {
        Context targetContext = getTargetContext();
        if (targetContext != null) {
            this.usageTrackerFacilitator.registerUsageTracker(new AnalyticsBasedUsageTracker.Builder(targetContext).buildIfPossible());
        }
    }

    TestRequestBuilder createTestRequestBuilder(Instrumentation instr, Bundle arguments) {
        return new TestRequestBuilder(instr, arguments);
    }
}

package androidx.test.espresso.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.test.espresso.FailureHandler;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.base.IdlingResourceRegistry;
import androidx.test.espresso.core.internal.deps.guava.base.Optional;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListeningExecutorService;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.MoreExecutors;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ThreadFactoryBuilder;
import androidx.test.espresso.internal.inject.TargetContext;
import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.platform.os.ControlledLooper;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class BaseLayerModule {
    public ActiveRootLister provideActiveRootLister(RootsOracle rootsOracle) {
        return rootsOracle;
    }

    @Default
    FailureHandler provideFailureHander(DefaultFailureHandler impl) {
        return impl;
    }

    public ActivityLifecycleMonitor provideLifecycleMonitor() {
        return ActivityLifecycleMonitorRegistry.getInstance();
    }

    @TargetContext
    public Context provideTargetContext() {
        return InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    public Looper provideMainLooper() {
        return Looper.getMainLooper();
    }

    @CompatAsyncTask
    public IdleNotifier<Runnable> provideCompatAsyncTaskMonitor(ThreadPoolExecutorExtractor extractor) {
        Optional<ThreadPoolExecutor> compatAsyncTaskThreadPool = extractor.getCompatAsyncTaskThreadPool();
        if (compatAsyncTaskThreadPool.isPresent()) {
            return new AsyncTaskPoolMonitor(compatAsyncTaskThreadPool.get()).asIdleNotifier();
        }
        return new NoopRunnableIdleNotifier();
    }

    @MainThread
    public Executor provideMainThreadExecutor(Looper mainLooper) {
        final Handler handler = new Handler(mainLooper);
        return new Executor(this) { // from class: androidx.test.espresso.base.BaseLayerModule.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> provideDynamicNotifer(IdlingResourceRegistry dynamicRegistry) {
        dynamicRegistry.sync(IdlingRegistry.getInstance().getResources(), IdlingRegistry.getInstance().getLoopers());
        return dynamicRegistry.asIdleNotifier();
    }

    @SdkAsyncTask
    public IdleNotifier<Runnable> provideSdkAsyncTaskMonitor(ThreadPoolExecutorExtractor extractor) {
        return new AsyncTaskPoolMonitor(extractor.getAsyncTaskThreadPool()).asIdleNotifier();
    }

    public EventInjector provideEventInjector() {
        InputManagerEventInjectionStrategy inputManagerEventInjectionStrategy = new InputManagerEventInjectionStrategy();
        inputManagerEventInjectionStrategy.initialize();
        return new EventInjector(inputManagerEventInjectionStrategy);
    }

    public static class FailureHandlerHolder {
        private final AtomicReference<FailureHandler> holder;

        public FailureHandlerHolder(@Default FailureHandler defaultHandler) {
            this.holder = new AtomicReference<>(defaultHandler);
        }

        public void update(FailureHandler handler) {
            this.holder.set(handler);
        }

        public FailureHandler get() {
            return this.holder.get();
        }
    }

    FailureHandler provideFailureHandler(FailureHandlerHolder holder) {
        return holder.get();
    }

    public ListeningExecutorService provideRemoteExecutor() {
        return MoreExecutors.listeningDecorator(new ThreadPoolExecutor(0, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryBuilder().setNameFormat("Espresso Remote #%d").build()));
    }

    DefaultFailureHandler provideDefaultFailureHander(@TargetContext Context context) {
        return new DefaultFailureHandler(context);
    }

    public ControlledLooper provideControlledLooper() {
        return (ControlledLooper) ServiceLoaderWrapper.loadSingleService(ControlledLooper.class, BaseLayerModule$$Lambda$0.$instance);
    }
}

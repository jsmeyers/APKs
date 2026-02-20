package androidx.test.espresso;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import androidx.test.espresso.base.ActiveRootLister;
import androidx.test.espresso.base.BaseLayerModule;
import androidx.test.espresso.base.BaseLayerModule_FailureHandlerHolder_Factory;
import androidx.test.espresso.base.BaseLayerModule_ProvideActiveRootListerFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideControlledLooperFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideDefaultFailureHanderFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideDynamicNotiferFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideEventInjectorFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideFailureHanderFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideFailureHandlerFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideLifecycleMonitorFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideMainLooperFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideMainThreadExecutorFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideRemoteExecutorFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideSdkAsyncTaskMonitorFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideTargetContextFactory;
import androidx.test.espresso.base.DefaultFailureHandler;
import androidx.test.espresso.base.IdlingResourceRegistry;
import androidx.test.espresso.base.IdlingResourceRegistry_Factory;
import androidx.test.espresso.base.RootViewPicker;
import androidx.test.espresso.base.RootViewPicker_Factory;
import androidx.test.espresso.base.RootViewPicker_RootResultFetcher_Factory;
import androidx.test.espresso.base.RootsOracle_Factory;
import androidx.test.espresso.base.ThreadPoolExecutorExtractor_Factory;
import androidx.test.espresso.base.UiControllerImpl_Factory;
import androidx.test.espresso.base.UiControllerModule;
import androidx.test.espresso.base.UiControllerModule_ProvideUiControllerFactory;
import androidx.test.espresso.base.ViewFinderImpl;
import androidx.test.espresso.base.ViewFinderImpl_Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.DoubleCheck;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListeningExecutorService;
import androidx.test.internal.platform.os.ControlledLooper;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Provider;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class DaggerBaseLayerComponent implements BaseLayerComponent {
    private final BaseLayerModule baseLayerModule;
    private Provider<BaseLayerModule.FailureHandlerHolder> failureHandlerHolderProvider;
    private Provider<IdlingResourceRegistry> idlingResourceRegistryProvider;
    private Provider<ActiveRootLister> provideActiveRootListerProvider;
    private Provider provideCompatAsyncTaskMonitorProvider;
    private Provider<ControlledLooper> provideControlledLooperProvider;
    private Provider<DefaultFailureHandler> provideDefaultFailureHanderProvider;
    private Provider provideDynamicNotiferProvider;
    private Provider provideEventInjectorProvider;
    private Provider<FailureHandler> provideFailureHanderProvider;
    private Provider<ActivityLifecycleMonitor> provideLifecycleMonitorProvider;
    private Provider<Looper> provideMainLooperProvider;
    private Provider<Executor> provideMainThreadExecutorProvider;
    private Provider<ListeningExecutorService> provideRemoteExecutorProvider;
    private Provider provideSdkAsyncTaskMonitorProvider;
    private Provider<Context> provideTargetContextProvider;
    private Provider<UiController> provideUiControllerProvider;
    private Provider rootsOracleProvider;
    private Provider threadPoolExecutorExtractorProvider;
    private Provider uiControllerImplProvider;

    private DaggerBaseLayerComponent(BaseLayerModule baseLayerModuleParam, UiControllerModule uiControllerModuleParam) {
        this.baseLayerModule = baseLayerModuleParam;
        initialize(baseLayerModuleParam, uiControllerModuleParam);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static BaseLayerComponent create() {
        return new Builder().build();
    }

    private Object getRootsOracle() {
        return RootsOracle_Factory.newInstance(this.provideMainLooperProvider.get2());
    }

    private void initialize(final BaseLayerModule baseLayerModuleParam, final UiControllerModule uiControllerModuleParam) {
        BaseLayerModule_ProvideTargetContextFactory baseLayerModule_ProvideTargetContextFactoryCreate = BaseLayerModule_ProvideTargetContextFactory.create(baseLayerModuleParam);
        this.provideTargetContextProvider = baseLayerModule_ProvideTargetContextFactoryCreate;
        BaseLayerModule_ProvideDefaultFailureHanderFactory baseLayerModule_ProvideDefaultFailureHanderFactoryCreate = BaseLayerModule_ProvideDefaultFailureHanderFactory.create(baseLayerModuleParam, baseLayerModule_ProvideTargetContextFactoryCreate);
        this.provideDefaultFailureHanderProvider = baseLayerModule_ProvideDefaultFailureHanderFactoryCreate;
        BaseLayerModule_ProvideFailureHanderFactory baseLayerModule_ProvideFailureHanderFactoryCreate = BaseLayerModule_ProvideFailureHanderFactory.create(baseLayerModuleParam, baseLayerModule_ProvideDefaultFailureHanderFactoryCreate);
        this.provideFailureHanderProvider = baseLayerModule_ProvideFailureHanderFactoryCreate;
        this.failureHandlerHolderProvider = DoubleCheck.provider(BaseLayerModule_FailureHandlerHolder_Factory.create(baseLayerModule_ProvideFailureHanderFactoryCreate));
        Provider<Looper> provider = DoubleCheck.provider(BaseLayerModule_ProvideMainLooperFactory.create(baseLayerModuleParam));
        this.provideMainLooperProvider = provider;
        this.idlingResourceRegistryProvider = DoubleCheck.provider(IdlingResourceRegistry_Factory.create(provider));
        this.provideEventInjectorProvider = DoubleCheck.provider(BaseLayerModule_ProvideEventInjectorFactory.create(baseLayerModuleParam));
        Provider provider2 = DoubleCheck.provider(ThreadPoolExecutorExtractor_Factory.create(this.provideMainLooperProvider));
        this.threadPoolExecutorExtractorProvider = provider2;
        this.provideSdkAsyncTaskMonitorProvider = DoubleCheck.provider(BaseLayerModule_ProvideSdkAsyncTaskMonitorFactory.create(baseLayerModuleParam, provider2));
        this.provideCompatAsyncTaskMonitorProvider = DoubleCheck.provider(BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory.create(baseLayerModuleParam, this.threadPoolExecutorExtractorProvider));
        BaseLayerModule_ProvideDynamicNotiferFactory baseLayerModule_ProvideDynamicNotiferFactoryCreate = BaseLayerModule_ProvideDynamicNotiferFactory.create(baseLayerModuleParam, this.idlingResourceRegistryProvider);
        this.provideDynamicNotiferProvider = baseLayerModule_ProvideDynamicNotiferFactoryCreate;
        Provider provider3 = DoubleCheck.provider(UiControllerImpl_Factory.create(this.provideEventInjectorProvider, this.provideSdkAsyncTaskMonitorProvider, this.provideCompatAsyncTaskMonitorProvider, baseLayerModule_ProvideDynamicNotiferFactoryCreate, this.provideMainLooperProvider, this.idlingResourceRegistryProvider));
        this.uiControllerImplProvider = provider3;
        this.provideUiControllerProvider = DoubleCheck.provider(UiControllerModule_ProvideUiControllerFactory.create(uiControllerModuleParam, provider3));
        this.provideMainThreadExecutorProvider = DoubleCheck.provider(BaseLayerModule_ProvideMainThreadExecutorFactory.create(baseLayerModuleParam, this.provideMainLooperProvider));
        this.provideControlledLooperProvider = DoubleCheck.provider(BaseLayerModule_ProvideControlledLooperFactory.create(baseLayerModuleParam));
        RootsOracle_Factory rootsOracle_FactoryCreate = RootsOracle_Factory.create(this.provideMainLooperProvider);
        this.rootsOracleProvider = rootsOracle_FactoryCreate;
        this.provideActiveRootListerProvider = BaseLayerModule_ProvideActiveRootListerFactory.create(baseLayerModuleParam, rootsOracle_FactoryCreate);
        this.provideLifecycleMonitorProvider = BaseLayerModule_ProvideLifecycleMonitorFactory.create(baseLayerModuleParam);
        this.provideRemoteExecutorProvider = DoubleCheck.provider(BaseLayerModule_ProvideRemoteExecutorFactory.create(baseLayerModuleParam));
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public BaseLayerModule.FailureHandlerHolder failureHolder() {
        return this.failureHandlerHolderProvider.get2();
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public FailureHandler failureHandler() {
        return BaseLayerModule_ProvideFailureHandlerFactory.provideFailureHandler(this.baseLayerModule, this.failureHandlerHolderProvider.get2());
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public ActiveRootLister activeRootLister() {
        return BaseLayerModule_ProvideActiveRootListerFactory.provideActiveRootLister(this.baseLayerModule, getRootsOracle());
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public IdlingResourceRegistry idlingResourceRegistry() {
        return this.idlingResourceRegistryProvider.get2();
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public UiController uiController() {
        return this.provideUiControllerProvider.get2();
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public Executor mainThreadExecutor() {
        return this.provideMainThreadExecutorProvider.get2();
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public ControlledLooper controlledLooper() {
        return this.provideControlledLooperProvider.get2();
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public ViewInteractionComponent plus(ViewInteractionModule module) {
        Preconditions.checkNotNull(module);
        return new ViewInteractionComponentImpl(module);
    }

    public static final class Builder {
        private BaseLayerModule baseLayerModule;
        private UiControllerModule uiControllerModule;

        private Builder() {
        }

        public Builder baseLayerModule(BaseLayerModule baseLayerModule) {
            this.baseLayerModule = (BaseLayerModule) Preconditions.checkNotNull(baseLayerModule);
            return this;
        }

        public Builder uiControllerModule(UiControllerModule uiControllerModule) {
            this.uiControllerModule = (UiControllerModule) Preconditions.checkNotNull(uiControllerModule);
            return this;
        }

        public BaseLayerComponent build() {
            if (this.baseLayerModule == null) {
                this.baseLayerModule = new BaseLayerModule();
            }
            if (this.uiControllerModule == null) {
                this.uiControllerModule = new UiControllerModule();
            }
            return new DaggerBaseLayerComponent(this.baseLayerModule, this.uiControllerModule);
        }
    }

    private final class ViewInteractionComponentImpl implements ViewInteractionComponent {
        private Provider<AtomicReference<Boolean>> provideNeedsActivityProvider;
        private Provider<AtomicReference<Matcher<Root>>> provideRootMatcherProvider;
        private Provider<View> provideRootViewProvider;
        private Provider rootResultFetcherProvider;
        private Provider<RootViewPicker> rootViewPickerProvider;
        private final ViewInteractionModule viewInteractionModule;

        private ViewInteractionComponentImpl(ViewInteractionModule module) {
            this.viewInteractionModule = module;
            initialize(module);
        }

        private ViewFinderImpl getViewFinderImpl() {
            return ViewFinderImpl_Factory.newInstance(ViewInteractionModule_ProvideViewMatcherFactory.provideViewMatcher(this.viewInteractionModule), this.provideRootViewProvider);
        }

        private ViewFinder getViewFinder() {
            return ViewInteractionModule_ProvideViewFinderFactory.provideViewFinder(this.viewInteractionModule, getViewFinderImpl());
        }

        private void initialize(final ViewInteractionModule module) {
            this.provideRootMatcherProvider = ViewInteractionModule_ProvideRootMatcherFactory.create(module);
            this.rootResultFetcherProvider = RootViewPicker_RootResultFetcher_Factory.create(DaggerBaseLayerComponent.this.provideActiveRootListerProvider, this.provideRootMatcherProvider);
            this.provideNeedsActivityProvider = ViewInteractionModule_ProvideNeedsActivityFactory.create(module);
            Provider<RootViewPicker> provider = DoubleCheck.provider(RootViewPicker_Factory.create(DaggerBaseLayerComponent.this.provideUiControllerProvider, this.rootResultFetcherProvider, DaggerBaseLayerComponent.this.provideLifecycleMonitorProvider, this.provideNeedsActivityProvider, DaggerBaseLayerComponent.this.provideControlledLooperProvider));
            this.rootViewPickerProvider = provider;
            this.provideRootViewProvider = ViewInteractionModule_ProvideRootViewFactory.create(module, provider);
        }

        @Override // androidx.test.espresso.ViewInteractionComponent
        public ViewInteraction viewInteraction() {
            return new ViewInteraction((UiController) DaggerBaseLayerComponent.this.provideUiControllerProvider.get2(), getViewFinder(), (Executor) DaggerBaseLayerComponent.this.provideMainThreadExecutorProvider.get2(), DaggerBaseLayerComponent.this.failureHandler(), ViewInteractionModule_ProvideViewMatcherFactory.provideViewMatcher(this.viewInteractionModule), ViewInteractionModule_ProvideRootMatcherFactory.provideRootMatcher(this.viewInteractionModule), ViewInteractionModule_ProvideNeedsActivityFactory.provideNeedsActivity(this.viewInteractionModule), ViewInteractionModule_ProvideRemoteInteractionFactory.provideRemoteInteraction(this.viewInteractionModule), (ListeningExecutorService) DaggerBaseLayerComponent.this.provideRemoteExecutorProvider.get2(), (ControlledLooper) DaggerBaseLayerComponent.this.provideControlledLooperProvider.get2());
        }
    }
}

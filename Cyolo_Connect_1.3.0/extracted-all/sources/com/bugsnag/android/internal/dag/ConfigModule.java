package com.bugsnag.android.internal.dag;

import com.bugsnag.android.Configuration;
import com.bugsnag.android.Connectivity;
import com.bugsnag.android.internal.BackgroundTaskService;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.ImmutableConfigKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConfigModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bugsnag/android/internal/dag/ConfigModule;", "Lcom/bugsnag/android/internal/dag/BackgroundDependencyModule;", "contextModule", "Lcom/bugsnag/android/internal/dag/ContextModule;", "configuration", "Lcom/bugsnag/android/Configuration;", "connectivity", "Lcom/bugsnag/android/Connectivity;", "bgTaskExecutor", "Lcom/bugsnag/android/internal/BackgroundTaskService;", "(Lcom/bugsnag/android/internal/dag/ContextModule;Lcom/bugsnag/android/Configuration;Lcom/bugsnag/android/Connectivity;Lcom/bugsnag/android/internal/BackgroundTaskService;)V", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "getConfig", "()Lcom/bugsnag/android/internal/ImmutableConfig;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ConfigModule extends BackgroundDependencyModule {
    private final ImmutableConfig config;

    public ConfigModule(ContextModule contextModule, Configuration configuration, Connectivity connectivity, BackgroundTaskService backgroundTaskService) {
        super(backgroundTaskService, null, 2, null);
        this.config = ImmutableConfigKt.sanitiseConfiguration(contextModule.getCtx(), configuration, connectivity, backgroundTaskService);
    }

    public final ImmutableConfig getConfig() {
        return this.config;
    }
}

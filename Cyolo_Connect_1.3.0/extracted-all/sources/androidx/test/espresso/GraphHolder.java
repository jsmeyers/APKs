package androidx.test.espresso;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.internal.runner.tracker.UsageTrackerRegistry;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class GraphHolder {
    private static final AtomicReference<GraphHolder> instance = new AtomicReference<>(null);
    private final BaseLayerComponent component;

    private GraphHolder(BaseLayerComponent component) {
        this.component = (BaseLayerComponent) Preconditions.checkNotNull(component);
    }

    static BaseLayerComponent baseLayer() {
        AtomicReference<GraphHolder> atomicReference = instance;
        GraphHolder graphHolder = atomicReference.get();
        if (graphHolder == null) {
            GraphHolder graphHolder2 = new GraphHolder(DaggerBaseLayerComponent.create());
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, graphHolder2)) {
                UsageTrackerRegistry.getInstance().trackUsage("Espresso", UsageTrackerRegistry.AxtVersions.ESPRESSO_VERSION);
                return graphHolder2.component;
            }
            return atomicReference.get().component;
        }
        return graphHolder.component;
    }
}

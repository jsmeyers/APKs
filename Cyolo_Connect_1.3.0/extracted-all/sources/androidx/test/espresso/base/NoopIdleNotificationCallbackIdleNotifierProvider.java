package androidx.test.espresso.base;

import androidx.test.espresso.base.IdlingResourceRegistry;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
final class NoopIdleNotificationCallbackIdleNotifierProvider implements Provider<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> {
    NoopIdleNotificationCallbackIdleNotifierProvider() {
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> get2() {
        return new NoopIdleNotificationCallbackIdleNotifier();
    }

    private static class NoopIdleNotificationCallbackIdleNotifier implements IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> {
        @Override // androidx.test.espresso.base.IdleNotifier
        public void cancelCallback() {
        }

        @Override // androidx.test.espresso.base.IdleNotifier
        public boolean isIdleNow() {
            return true;
        }

        private NoopIdleNotificationCallbackIdleNotifier() {
        }

        @Override // androidx.test.espresso.base.IdleNotifier
        public void registerNotificationCallback(IdlingResourceRegistry.IdleNotificationCallback cb) {
            cb.allResourcesIdle();
        }
    }
}

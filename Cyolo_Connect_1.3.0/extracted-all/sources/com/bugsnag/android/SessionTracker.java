package com.bugsnag.android;

import android.app.Activity;
import androidx.work.WorkRequest;
import com.bugsnag.android.StateEvent;
import com.bugsnag.android.internal.BackgroundTaskService;
import com.bugsnag.android.internal.DateUtils;
import com.bugsnag.android.internal.ForegroundDetector;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.TaskType;
import com.bugsnag.android.internal.dag.Provider;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
class SessionTracker extends BaseObservable implements ForegroundDetector.OnActivityCallback {
    private static final int DEFAULT_TIMEOUT_MS = 30000;
    final BackgroundTaskService backgroundTaskService;
    private final CallbackState callbackState;
    private final Client client;
    private final ImmutableConfig configuration;
    private volatile Session currentSession;
    private final Deque<String> foregroundActivities;
    final Logger logger;
    final Provider<SessionStore> sessionStore;
    private boolean shouldSuppressFirstAutoSession;
    private final long timeoutMs;

    SessionTracker(ImmutableConfig immutableConfig, CallbackState callbackState, Client client, Provider<SessionStore> provider, Logger logger, BackgroundTaskService backgroundTaskService) {
        this(immutableConfig, callbackState, client, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, provider, logger, backgroundTaskService);
    }

    SessionTracker(ImmutableConfig immutableConfig, CallbackState callbackState, Client client, long j, Provider<SessionStore> provider, Logger logger, BackgroundTaskService backgroundTaskService) {
        this.foregroundActivities = new ArrayDeque();
        this.currentSession = null;
        this.shouldSuppressFirstAutoSession = true;
        this.configuration = immutableConfig;
        this.callbackState = callbackState;
        this.client = client;
        this.timeoutMs = j;
        this.sessionStore = provider;
        this.backgroundTaskService = backgroundTaskService;
        this.logger = logger;
    }

    Session startNewSession(Date date, User user, boolean z) {
        if (shouldDiscardSession(z)) {
            return null;
        }
        Session session = new Session(UUID.randomUUID().toString(), date, user, z, this.client.getNotifier(), this.logger, this.configuration.getApiKey());
        if (trackSessionIfNeeded(session)) {
            return session;
        }
        return null;
    }

    Session startSession(boolean z) {
        if (shouldDiscardSession(z)) {
            return null;
        }
        return startNewSession(new Date(), this.client.getUser(), z);
    }

    private boolean shouldDiscardSession(boolean z) {
        if (this.client.getConfig().shouldDiscardSession(z)) {
            return true;
        }
        Session session = this.currentSession;
        if (z && session != null && !session.isAutoCaptured() && this.shouldSuppressFirstAutoSession) {
            this.shouldSuppressFirstAutoSession = false;
            return true;
        }
        if (z) {
            this.shouldSuppressFirstAutoSession = false;
        }
        return false;
    }

    void pauseSession() {
        Session session = this.currentSession;
        if (session != null) {
            session.markPaused();
            updateState(StateEvent.PauseSession.INSTANCE);
        }
    }

    boolean resumeSession() {
        boolean zMarkResumed;
        Session sessionStartSession = this.currentSession;
        if (sessionStartSession == null) {
            sessionStartSession = startSession(false);
            zMarkResumed = false;
        } else {
            zMarkResumed = sessionStartSession.markResumed();
        }
        if (sessionStartSession != null) {
            notifySessionStartObserver(sessionStartSession);
        }
        return zMarkResumed;
    }

    private void notifySessionStartObserver(Session session) {
        updateState(new StateEvent.StartSession(session.getId(), DateUtils.toIso8601(session.getStartedAt()), session.getHandledCount(), session.getUnhandledCount()));
    }

    Session registerExistingSession(Date date, String str, User user, int i, int i2) {
        Session session = null;
        if (this.client.getConfig().shouldDiscardSession(false)) {
            return null;
        }
        if (date != null && str != null) {
            session = new Session(str, date, user, i, i2, this.client.getNotifier(), this.logger, this.configuration.getApiKey());
            notifySessionStartObserver(session);
        } else {
            updateState(StateEvent.PauseSession.INSTANCE);
        }
        this.currentSession = session;
        return session;
    }

    private boolean trackSessionIfNeeded(Session session) {
        this.logger.d("SessionTracker#trackSessionIfNeeded() - session captured by Client");
        session.setApp(this.client.getAppDataCollector().generateApp());
        session.setDevice(this.client.getDeviceDataCollector().generateDevice());
        if (!this.callbackState.runOnSessionTasks(session, this.logger) || !session.markTracked()) {
            return false;
        }
        this.currentSession = session;
        notifySessionStartObserver(session);
        flushInMemorySession(session);
        flushAsync();
        return true;
    }

    Session getCurrentSession() {
        Session session = this.currentSession;
        if (session == null || session.isPaused()) {
            return null;
        }
        return session;
    }

    Session incrementUnhandledAndCopy() {
        Session currentSession = getCurrentSession();
        if (currentSession != null) {
            return currentSession.incrementUnhandledAndCopy();
        }
        return null;
    }

    Session incrementHandledAndCopy() {
        Session currentSession = getCurrentSession();
        if (currentSession != null) {
            return currentSession.incrementHandledAndCopy();
        }
        return null;
    }

    void flushAsync() {
        try {
            this.backgroundTaskService.submitTask(TaskType.SESSION_REQUEST, new Runnable() { // from class: com.bugsnag.android.SessionTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    SessionTracker.this.flushStoredSessions();
                }
            });
        } catch (RejectedExecutionException e) {
            this.logger.w("Failed to flush session reports", e);
        }
    }

    void flushStoredSessions() {
        Iterator<File> it = this.sessionStore.get().findStoredFiles().iterator();
        while (it.hasNext()) {
            flushStoredSession(it.next());
        }
    }

    void flushStoredSession(File file) {
        this.logger.d("SessionTracker#flushStoredSession() - attempting delivery");
        Session session = new Session(file, this.client.getNotifier(), this.logger, this.configuration.getApiKey());
        if (session.isLegacyPayload()) {
            session.setApp(this.client.getAppDataCollector().generateApp());
            session.setDevice(this.client.getDeviceDataCollector().generateDevice());
        }
        DeliveryStatus deliveryStatusDeliverSessionPayload = deliverSessionPayload(session);
        SessionStore sessionStore = this.sessionStore.get();
        int i = AnonymousClass3.$SwitchMap$com$bugsnag$android$DeliveryStatus[deliveryStatusDeliverSessionPayload.ordinal()];
        if (i == 1) {
            sessionStore.deleteStoredFiles(Collections.singletonList(file));
            this.logger.d("Sent 1 new session to Bugsnag");
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            this.logger.w("Deleting invalid session tracking payload");
            sessionStore.deleteStoredFiles(Collections.singletonList(file));
            return;
        }
        if (sessionStore.isTooOld(file)) {
            this.logger.w("Discarding historical session (from {" + sessionStore.getCreationDate(file) + "}) after failed delivery");
            sessionStore.deleteStoredFiles(Collections.singletonList(file));
            return;
        }
        sessionStore.cancelQueuedFiles(Collections.singletonList(file));
        this.logger.w("Leaving session payload for future delivery");
    }

    /* JADX INFO: renamed from: com.bugsnag.android.SessionTracker$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$bugsnag$android$DeliveryStatus;

        static {
            int[] iArr = new int[DeliveryStatus.values().length];
            $SwitchMap$com$bugsnag$android$DeliveryStatus = iArr;
            try {
                iArr[DeliveryStatus.DELIVERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bugsnag$android$DeliveryStatus[DeliveryStatus.UNDELIVERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bugsnag$android$DeliveryStatus[DeliveryStatus.FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void flushInMemorySession(final Session session) {
        try {
            this.backgroundTaskService.submitTask(TaskType.SESSION_REQUEST, new Runnable() { // from class: com.bugsnag.android.SessionTracker.2
                @Override // java.lang.Runnable
                public void run() {
                    SessionTracker.this.deliverInMemorySession(session);
                }
            });
        } catch (RejectedExecutionException unused) {
            this.sessionStore.get().write(session);
        }
    }

    void deliverInMemorySession(Session session) {
        try {
            this.logger.d("SessionTracker#trackSessionIfNeeded() - attempting initial delivery");
            int i = AnonymousClass3.$SwitchMap$com$bugsnag$android$DeliveryStatus[deliverSessionPayload(session).ordinal()];
            if (i == 1) {
                this.logger.d("Sent 1 new session to Bugsnag");
            } else if (i == 2) {
                this.logger.w("Storing session payload for future delivery");
                this.sessionStore.get().write(session);
            } else if (i == 3) {
                this.logger.w("Dropping invalid session tracking payload");
            }
        } catch (Exception e) {
            this.logger.w("Session tracking payload failed", e);
        }
    }

    DeliveryStatus deliverSessionPayload(Session session) {
        return this.configuration.getDelivery().deliver(session, this.configuration.getSessionApiDeliveryParams(session));
    }

    @Override // com.bugsnag.android.internal.ForegroundDetector.OnActivityCallback
    public void onActivityStarted(Activity activity) {
        updateContext(activity.getClass().getSimpleName(), true);
    }

    @Override // com.bugsnag.android.internal.ForegroundDetector.OnActivityCallback
    public void onActivityStopped(Activity activity) {
        updateContext(activity.getClass().getSimpleName(), false);
    }

    void updateContext(String str, boolean z) {
        if (z) {
            synchronized (this.foregroundActivities) {
                this.foregroundActivities.add(str);
            }
        } else {
            synchronized (this.foregroundActivities) {
                this.foregroundActivities.removeLastOccurrence(str);
            }
        }
        this.client.getContextState().setAutomaticContext(getContextActivity());
    }

    boolean isInForeground() {
        return ForegroundDetector.isInForeground();
    }

    long getLastEnteredForegroundMs() {
        return ForegroundDetector.getLastEnteredForegroundMs();
    }

    String getContextActivity() {
        String strPeekLast;
        synchronized (this.foregroundActivities) {
            strPeekLast = this.foregroundActivities.peekLast();
        }
        return strPeekLast;
    }

    @Override // com.bugsnag.android.internal.ForegroundDetector.OnActivityCallback
    public void onForegroundStatus(boolean z, long j) {
        if (z && j - ForegroundDetector.getLastExitedForegroundMs() >= this.timeoutMs && this.configuration.getAutoTrackSessions()) {
            startNewSession(new Date(), this.client.getUser(), true);
        }
        updateState(new StateEvent.UpdateInForeground(z, getContextActivity()));
    }
}

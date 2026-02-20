package com.bugsnag.android;

import android.os.SystemClock;
import com.bugsnag.android.EventFilenameInfo;
import com.bugsnag.android.FileStore;
import com.bugsnag.android.JsonStream;
import com.bugsnag.android.internal.BackgroundTaskService;
import com.bugsnag.android.internal.ForegroundDetector;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.TaskType;
import com.bugsnag.android.internal.dag.Provider;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.File;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: EventStore.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 F2\u00020\u0001:\u0001FBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001a\u0010\"\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0016H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010*\u001a\u0004\u0018\u00010$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020$0,J\u0006\u0010-\u001a\u00020\u0017J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010/\u001a\u00020\u0017H\u0002J\u0006\u00100\u001a\u00020\u0017J\u0016\u00101\u001a\u00020\u00172\f\u00102\u001a\b\u0012\u0004\u0012\u00020$0,H\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020$H\u0002J\u0012\u00106\u001a\u00020&2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u00109\u001a\u00020&2\b\u00107\u001a\u0004\u0018\u0001082\b\u0010%\u001a\u0004\u0018\u00010&J\u001c\u0010:\u001a\u00020\u00172\n\u0010;\u001a\u00060<j\u0002`=2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010>\u001a\u00020\u00112\u0006\u00105\u001a\u00020$H\u0002J\u0010\u0010?\u001a\u00020\u00112\u0006\u00105\u001a\u00020$H\u0002J\b\u0010@\u001a\u00020\u0017H\u0002J\u0010\u0010A\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010B\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010C2\u0006\u0010D\u001a\u00020ER\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006G"}, d2 = {"Lcom/bugsnag/android/EventStore;", "Lcom/bugsnag/android/FileStore;", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "logger", "Lcom/bugsnag/android/Logger;", "notifier", "Lcom/bugsnag/android/Notifier;", "bgTaskService", "Lcom/bugsnag/android/internal/BackgroundTaskService;", "delegate", "Lcom/bugsnag/android/internal/dag/Provider;", "Lcom/bugsnag/android/FileStore$Delegate;", "callbackState", "Lcom/bugsnag/android/CallbackState;", "(Lcom/bugsnag/android/internal/ImmutableConfig;Lcom/bugsnag/android/Logger;Lcom/bugsnag/android/Notifier;Lcom/bugsnag/android/internal/BackgroundTaskService;Lcom/bugsnag/android/internal/dag/Provider;Lcom/bugsnag/android/CallbackState;)V", "isEmptyEventCallbackCalled", "", "getLogger", "()Lcom/bugsnag/android/Logger;", "onDiscardEventCallback", "Lkotlin/Function1;", "Lcom/bugsnag/android/EventPayload;", "", "getOnDiscardEventCallback", "()Lkotlin/jvm/functions/Function1;", "setOnDiscardEventCallback", "(Lkotlin/jvm/functions/Function1;)V", "onEventStoreEmptyCallback", "Lkotlin/Function0;", "getOnEventStoreEmptyCallback", "()Lkotlin/jvm/functions/Function0;", "setOnEventStoreEmptyCallback", "(Lkotlin/jvm/functions/Function0;)V", "createEventPayload", "eventFile", "Ljava/io/File;", DynamicLink.Builder.KEY_API_KEY, "", "deliverEventPayload", "payload", "discardEvents", "findLaunchCrashReport", "storedFiles", "", "flushAsync", "flushEventFile", "flushLaunchCrashReport", "flushOnLaunch", "flushReports", "storedReports", "getCreationDate", "Ljava/util/Date;", "file", "getFilename", "obj", "", "getNdkFilename", "handleEventFlushFailure", "exc", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isTooBig", "isTooOld", "notifyEventQueueEmpty", "undeliveredEventPayload", "writeAndDeliver", "Ljava/util/concurrent/Future;", "streamable", "Lcom/bugsnag/android/JsonStream$Streamable;", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EventStore extends FileStore {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Comparator<? super File> EVENT_COMPARATOR = new Comparator() { // from class: com.bugsnag.android.EventStore$$ExternalSyntheticLambda2
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return EventStore.m231EVENT_COMPARATOR$lambda6((File) obj, (File) obj2);
        }
    };
    private static final long LAUNCH_CRASH_TIMEOUT_MS = 2000;
    private static final long oneMegabyte = 1048576;
    private final BackgroundTaskService bgTaskService;
    private final CallbackState callbackState;
    private final ImmutableConfig config;
    private boolean isEmptyEventCallbackCalled;
    private final Logger logger;
    private final Notifier notifier;
    private Function1<? super EventPayload, Unit> onDiscardEventCallback;
    private Function0<Unit> onEventStoreEmptyCallback;

    /* JADX INFO: compiled from: EventStore.kt */
    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeliveryStatus.values().length];
            iArr[DeliveryStatus.DELIVERED.ordinal()] = 1;
            iArr[DeliveryStatus.UNDELIVERED.ordinal()] = 2;
            iArr[DeliveryStatus.FAILURE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public EventStore(ImmutableConfig immutableConfig, Logger logger, Notifier notifier, BackgroundTaskService backgroundTaskService, Provider<? extends FileStore.Delegate> provider, CallbackState callbackState) {
        super(new File(immutableConfig.getPersistenceDirectory().getValue(), "bugsnag/errors"), immutableConfig.getMaxPersistedEvents(), logger, provider);
        this.config = immutableConfig;
        this.onEventStoreEmptyCallback = new Function0<Unit>() { // from class: com.bugsnag.android.EventStore$onEventStoreEmptyCallback$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.onDiscardEventCallback = new Function1<EventPayload, Unit>() { // from class: com.bugsnag.android.EventStore$onDiscardEventCallback$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EventPayload eventPayload) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EventPayload eventPayload) {
                invoke2(eventPayload);
                return Unit.INSTANCE;
            }
        };
        this.logger = logger;
        this.notifier = notifier;
        this.bgTaskService = backgroundTaskService;
        this.callbackState = callbackState;
    }

    @Override // com.bugsnag.android.FileStore
    protected Logger getLogger() {
        return this.logger;
    }

    public final Function0<Unit> getOnEventStoreEmptyCallback() {
        return this.onEventStoreEmptyCallback;
    }

    public final void setOnEventStoreEmptyCallback(Function0<Unit> function0) {
        this.onEventStoreEmptyCallback = function0;
    }

    public final Function1<EventPayload, Unit> getOnDiscardEventCallback() {
        return this.onDiscardEventCallback;
    }

    public final void setOnDiscardEventCallback(Function1<? super EventPayload, Unit> function1) {
        this.onDiscardEventCallback = function1;
    }

    public final void flushOnLaunch() {
        if (this.config.getSendLaunchCrashesSynchronously()) {
            try {
                Future<?> futureSubmitTask = this.bgTaskService.submitTask(TaskType.ERROR_REQUEST, new Runnable() { // from class: com.bugsnag.android.EventStore$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        EventStore.m233flushOnLaunch$lambda0(this.f$0);
                    }
                });
                try {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - ForegroundDetector.INSTANCE.getStartupTime$bugsnag_android_core_release();
                    long j = LAUNCH_CRASH_TIMEOUT_MS;
                    long j2 = LAUNCH_CRASH_TIMEOUT_MS - jElapsedRealtime;
                    if (j2 > 0) {
                        j = j2;
                    }
                    futureSubmitTask.get(j, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    getLogger().d("Failed to send launch crash reports within timeout, continuing.", e);
                } catch (ExecutionException e2) {
                    getLogger().d("Failed to send launch crash reports within timeout, continuing.", e2);
                } catch (TimeoutException e3) {
                    getLogger().d("Failed to send launch crash reports within timeout, continuing.", e3);
                }
            } catch (RejectedExecutionException e4) {
                getLogger().d("Failed to flush launch crash reports, continuing.", e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: flushOnLaunch$lambda-0, reason: not valid java name */
    public static final void m233flushOnLaunch$lambda0(EventStore eventStore) {
        eventStore.flushLaunchCrashReport();
        eventStore.notifyEventQueueEmpty();
    }

    private final void flushLaunchCrashReport() {
        List<File> listFindStoredFiles = findStoredFiles();
        List<File> list = listFindStoredFiles;
        File fileFindLaunchCrashReport = findLaunchCrashReport(list);
        if (fileFindLaunchCrashReport != null) {
            listFindStoredFiles.remove(fileFindLaunchCrashReport);
        }
        cancelQueuedFiles(list);
        if (fileFindLaunchCrashReport != null) {
            getLogger().i("Attempting to send the most recent launch crash report");
            flushReports(CollectionsKt.listOf(fileFindLaunchCrashReport));
            getLogger().i("Continuing with Bugsnag initialisation");
            return;
        }
        getLogger().d("No startupcrash events to flush to Bugsnag.");
    }

    public final File findLaunchCrashReport(Collection<? extends File> storedFiles) {
        return (File) SequencesKt.maxWithOrNull(SequencesKt.filter(CollectionsKt.asSequence(storedFiles), new Function1<File, Boolean>() { // from class: com.bugsnag.android.EventStore.findLaunchCrashReport.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File file) {
                return Boolean.valueOf(EventFilenameInfo.INSTANCE.fromFile(file, EventStore.this.config).isLaunchCrashReport());
            }
        }), EVENT_COMPARATOR);
    }

    public final Future<String> writeAndDeliver(JsonStream.Streamable streamable) {
        final String strWrite = write(streamable);
        if (strWrite == null) {
            return null;
        }
        try {
            return this.bgTaskService.submitTask(TaskType.ERROR_REQUEST, new Callable() { // from class: com.bugsnag.android.EventStore$$ExternalSyntheticLambda3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return EventStore.m234writeAndDeliver$lambda2(this.f$0, strWrite);
                }
            });
        } catch (RejectedExecutionException unused) {
            getLogger().w("Failed to flush all on-disk errors, retaining unsent errors for later.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: writeAndDeliver$lambda-2, reason: not valid java name */
    public static final String m234writeAndDeliver$lambda2(EventStore eventStore, String str) {
        eventStore.flushEventFile(new File(str));
        return str;
    }

    public final void flushAsync() {
        try {
            this.bgTaskService.submitTask(TaskType.ERROR_REQUEST, new Runnable() { // from class: com.bugsnag.android.EventStore$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    EventStore.m232flushAsync$lambda3(this.f$0);
                }
            });
        } catch (RejectedExecutionException unused) {
            getLogger().w("Failed to flush all on-disk errors, retaining unsent errors for later.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: flushAsync$lambda-3, reason: not valid java name */
    public static final void m232flushAsync$lambda3(EventStore eventStore) {
        List<File> listFindStoredFiles = eventStore.findStoredFiles();
        if (listFindStoredFiles.isEmpty()) {
            eventStore.getLogger().d("No regular events to flush to Bugsnag.");
        }
        eventStore.flushReports(listFindStoredFiles);
        eventStore.notifyEventQueueEmpty();
    }

    private final void flushReports(Collection<? extends File> storedReports) {
        if (storedReports.isEmpty()) {
            return;
        }
        int size = storedReports.size();
        getLogger().i("Sending " + size + " saved error(s) to Bugsnag");
        Iterator<? extends File> it = storedReports.iterator();
        while (it.hasNext()) {
            flushEventFile(it.next());
        }
    }

    private final void flushEventFile(File eventFile) {
        try {
            EventPayload eventPayloadCreateEventPayload = createEventPayload(eventFile, EventFilenameInfo.INSTANCE.fromFile(eventFile, this.config).getApiKey());
            if (eventPayloadCreateEventPayload == null) {
                deleteStoredFiles(SetsKt.setOf(eventFile));
            } else {
                deliverEventPayload(eventFile, eventPayloadCreateEventPayload);
            }
        } catch (Exception e) {
            handleEventFlushFailure(e, eventFile);
        }
    }

    private final void deliverEventPayload(File eventFile, EventPayload payload) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.config.getDelivery().deliver(payload, this.config.getErrorApiDeliveryParams(payload)).ordinal()];
        if (i != 1) {
            if (i == 2) {
                undeliveredEventPayload(eventFile);
                return;
            } else {
                if (i != 3) {
                    return;
                }
                handleEventFlushFailure(new RuntimeException("Failed to deliver event payload"), eventFile);
                return;
            }
        }
        deleteStoredFiles(SetsKt.setOf(eventFile));
        getLogger().i("Deleting sent error file " + eventFile + ".name");
    }

    private final void undeliveredEventPayload(File eventFile) {
        if (isTooBig(eventFile)) {
            getLogger().w("Discarding over-sized event (" + eventFile.length() + ") after failed delivery");
            discardEvents(eventFile);
            deleteStoredFiles(SetsKt.setOf(eventFile));
            return;
        }
        if (isTooOld(eventFile)) {
            getLogger().w("Discarding historical event (from " + getCreationDate(eventFile) + ") after failed delivery");
            discardEvents(eventFile);
            deleteStoredFiles(SetsKt.setOf(eventFile));
            return;
        }
        cancelQueuedFiles(SetsKt.setOf(eventFile));
        getLogger().w("Could not send previously saved error(s) to Bugsnag, will try again later");
    }

    private final EventPayload createEventPayload(File eventFile, String apiKey) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(apiKey);
        MarshalledEventSource marshalledEventSource = new MarshalledEventSource(eventFile, apiKey, getLogger());
        try {
            if (!this.callbackState.runOnSendTasks(marshalledEventSource, getLogger())) {
                return null;
            }
        } catch (Exception e) {
            getLogger().w("could not parse event payload", e);
            marshalledEventSource.clear();
        }
        Event event = marshalledEventSource.getEvent();
        if (event != null) {
            return new EventPayload(event.getApiKey(), event, null, this.notifier, this.config);
        }
        return new EventPayload(apiKey, null, eventFile, this.notifier, this.config);
    }

    private final void handleEventFlushFailure(Exception exc, File eventFile) {
        Logger logger = getLogger();
        String message = exc.getMessage();
        if (message == null) {
            message = "Failed to send event";
        }
        logger.e(message, exc);
        deleteStoredFiles(SetsKt.setOf(eventFile));
    }

    @Override // com.bugsnag.android.FileStore
    public String getFilename(Object obj) {
        EventFilenameInfo eventFilenameInfoFromEvent$default;
        String strEncode;
        return (obj == null || (eventFilenameInfoFromEvent$default = EventFilenameInfo.Companion.fromEvent$default(EventFilenameInfo.INSTANCE, obj, null, null, 0L, this.config, null, 42, null)) == null || (strEncode = eventFilenameInfoFromEvent$default.encode()) == null) ? "" : strEncode;
    }

    public final String getNdkFilename(Object obj, String apiKey) {
        EventFilenameInfo eventFilenameInfoFromEvent$default;
        String strEncode;
        return (obj == null || (eventFilenameInfoFromEvent$default = EventFilenameInfo.Companion.fromEvent$default(EventFilenameInfo.INSTANCE, obj, null, apiKey, 0L, this.config, null, 42, null)) == null || (strEncode = eventFilenameInfoFromEvent$default.encode()) == null) ? "" : strEncode;
    }

    private final boolean isTooBig(File file) {
        return file.length() > 1048576;
    }

    private final boolean isTooOld(File file) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -60);
        return EventFilenameInfo.INSTANCE.findTimestampInFilename(file) < calendar.getTimeInMillis();
    }

    private final Date getCreationDate(File file) {
        return new Date(EventFilenameInfo.INSTANCE.findTimestampInFilename(file));
    }

    private final void notifyEventQueueEmpty() {
        if (!isEmpty() || this.isEmptyEventCallbackCalled) {
            return;
        }
        this.onEventStoreEmptyCallback.invoke();
        this.isEmptyEventCallbackCalled = true;
    }

    private final void discardEvents(File eventFile) {
        this.onDiscardEventCallback.invoke(new EventPayload(EventFilenameInfo.INSTANCE.fromFile(eventFile, this.config).getApiKey(), null, eventFile, this.notifier, this.config));
    }

    /* JADX INFO: compiled from: EventStore.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R)\u0010\u0003\u001a\u001a\u0012\b\b\u0000\u0012\u0004\u0018\u00010\u00050\u0004j\f\u0012\b\b\u0000\u0012\u0004\u0018\u00010\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bugsnag/android/EventStore$Companion;", "", "()V", "EVENT_COMPARATOR", "Ljava/util/Comparator;", "Ljava/io/File;", "Lkotlin/Comparator;", "getEVENT_COMPARATOR", "()Ljava/util/Comparator;", "LAUNCH_CRASH_TIMEOUT_MS", "", "oneMegabyte", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Comparator<? super File> getEVENT_COMPARATOR() {
            return EventStore.EVENT_COMPARATOR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: EVENT_COMPARATOR$lambda-6, reason: not valid java name */
    public static final int m231EVENT_COMPARATOR$lambda6(File file, File file2) {
        if (file == null && file2 == null) {
            return 0;
        }
        if (file == null) {
            return 1;
        }
        if (file2 == null) {
            return -1;
        }
        return file.compareTo(file2);
    }
}

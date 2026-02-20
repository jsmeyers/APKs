package com.bugsnag.android.ndk;

import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.bugsnag.android.BreadcrumbType;
import com.bugsnag.android.Logger;
import com.bugsnag.android.NativeInterface;
import com.bugsnag.android.StateEvent;
import com.bugsnag.android.internal.BackgroundTaskService;
import com.bugsnag.android.internal.StateObserver;
import com.bugsnag.android.internal.TaskType;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.messaging.Constants;
import io.cyolo.android.MainActivityKt;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NativeBridge.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0082 J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0086 J\t\u0010\u001b\u001a\u00020\u0011H\u0086 J!\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\bH\u0086 J!\u0010 \u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020!H\u0086 J!\u0010\"\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0086 J!\u0010#\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0086 J\t\u0010$\u001a\u00020\u0011H\u0086 J\u0011\u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086 J\t\u0010&\u001a\u00020\u0011H\u0086 J\u0011\u0010'\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0013H\u0086 J\b\u0010(\u001a\u00020\u0011H\u0002J\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0015\u0018\u00010*H\u0086 J\u0017\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b\u0018\u00010*H\u0086 J\t\u0010,\u001a\u00020-H\u0086 J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u00112\u0006\u0010/\u001a\u000202H\u0002J\u001d\u00103\u001a\u00020\u00112\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00150*H\u0086 JY\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u0015H\u0086 J\u0012\u0010?\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010\u0018H\u0002J\u0011\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0013H\u0086 J\u0011\u0010C\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0013H\u0086 J\u0010\u0010D\u001a\u00020\u00112\u0006\u0010E\u001a\u00020FH\u0016J\t\u0010G\u001a\u00020\u0011H\u0086 J\t\u0010H\u001a\u00020\u0011H\u0086 J\u0019\u0010I\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013H\u0086 J\u0011\u0010J\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\bH\u0086 J\u0011\u0010L\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\u0013H\u0086 J)\u0010N\u001a\u00020\u00112\u0006\u0010O\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00152\u0006\u0010Q\u001a\u00020\u0015H\u0086 J\u0011\u0010R\u001a\u00020\u00112\u0006\u0010S\u001a\u00020\u0013H\u0086 J\u0019\u0010T\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\u0013H\u0086 J\u0011\u0010W\u001a\u00020\u00112\u0006\u0010X\u001a\u00020\bH\u0086 J\u0019\u0010Y\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020\b2\u0006\u0010[\u001a\u00020\u0013H\u0086 J\u0011\u0010\\\u001a\u00020\u00112\u0006\u0010]\u001a\u00020\u0013H\u0086 J\u0011\u0010^\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020\u0013H\u0086 J\u0011\u0010_\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020\u0013H\u0086 J\u0011\u0010`\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020\u0013H\u0086 J\f\u0010a\u001a\u00020\u0015*\u00020bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/bugsnag/android/ndk/NativeBridge;", "Lcom/bugsnag/android/internal/StateObserver;", "bgTaskService", "Lcom/bugsnag/android/internal/BackgroundTaskService;", "(Lcom/bugsnag/android/internal/BackgroundTaskService;)V", "installed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "is32bit", "", "()Z", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "logger", "Lcom/bugsnag/android/Logger;", "reportDirectory", "Ljava/io/File;", "addBreadcrumb", "", "name", "", "type", "", "timestamp", "metadata", "", "addFeatureFlag", "variant", "addHandledEvent", "addMetadataBoolean", "tab", "key", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "addMetadataDouble", "", "addMetadataOpaque", "addMetadataString", "addUnhandledEvent", "clearFeatureFlag", "clearFeatureFlags", "clearMetadataTab", "deliverPendingReports", "getCurrentCallbackSetCounts", "", "getCurrentNativeApiCallUsage", "getSignalUnwindStackFunction", "", "handleAddMetadata", "arg", "Lcom/bugsnag/android/StateEvent$AddMetadata;", "handleInstallMessage", "Lcom/bugsnag/android/StateEvent$Install;", "initCallbackCounts", "counts", "install", DynamicLink.Builder.KEY_API_KEY, "reportingDirectory", "lastRunInfoPath", "eventUUID", "consecutiveLaunchCrashes", "autoDetectNdkCrashes", "apiLevel", "threadSendPolicy", "maxBreadcrumbs", "isInvalidMessage", NotificationCompat.CATEGORY_MESSAGE, "notifyAddCallback", "callback", "notifyRemoveCallback", "onStateChange", NotificationCompat.CATEGORY_EVENT, "Lcom/bugsnag/android/StateEvent;", "pausedSession", "refreshSymbolTable", "removeMetadata", "setInternalMetricsEnabled", "enabled", "setStaticJsonData", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "startedSession", "sessionID", "handledCount", "unhandledCount", "updateContext", "context", "updateInForeground", "inForeground", "activityName", "updateIsLaunching", "isLaunching", "updateLowMemory", "newValue", "memoryTrimLevelDescription", "updateOrientation", "orientation", "updateUserEmail", "updateUserId", "updateUserName", "toNativeValue", "Lcom/bugsnag/android/BreadcrumbType;", "bugsnag-plugin-android-ndk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NativeBridge implements StateObserver {
    private final BackgroundTaskService bgTaskService;
    private final ReentrantLock lock = new ReentrantLock();
    private final AtomicBoolean installed = new AtomicBoolean(false);
    private final File reportDirectory = NativeInterface.getNativeReportPath();
    private final Logger logger = NativeInterface.getLogger();

    /* JADX INFO: compiled from: NativeBridge.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BreadcrumbType.values().length];
            iArr[BreadcrumbType.ERROR.ordinal()] = 1;
            iArr[BreadcrumbType.LOG.ordinal()] = 2;
            iArr[BreadcrumbType.MANUAL.ordinal()] = 3;
            iArr[BreadcrumbType.NAVIGATION.ordinal()] = 4;
            iArr[BreadcrumbType.PROCESS.ordinal()] = 5;
            iArr[BreadcrumbType.REQUEST.ordinal()] = 6;
            iArr[BreadcrumbType.STATE.ordinal()] = 7;
            iArr[BreadcrumbType.USER.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final native void addBreadcrumb(String name, int type, String timestamp, Object metadata);

    public final native void addFeatureFlag(String name, String variant);

    public final native void addHandledEvent();

    public final native void addMetadataBoolean(String tab, String key, boolean value);

    public final native void addMetadataDouble(String tab, String key, double value);

    public final native void addMetadataOpaque(String tab, String key, String value);

    public final native void addMetadataString(String tab, String key, String value);

    public final native void addUnhandledEvent();

    public final native void clearFeatureFlag(String name);

    public final native void clearFeatureFlags();

    public final native void clearMetadataTab(String tab);

    public final native Map<String, Integer> getCurrentCallbackSetCounts();

    public final native Map<String, Boolean> getCurrentNativeApiCallUsage();

    public final native long getSignalUnwindStackFunction();

    public final native void initCallbackCounts(Map<String, Integer> counts);

    public final native void install(String apiKey, String reportingDirectory, String lastRunInfoPath, String eventUUID, int consecutiveLaunchCrashes, boolean autoDetectNdkCrashes, int apiLevel, boolean is32bit, int threadSendPolicy, int maxBreadcrumbs);

    public final native void notifyAddCallback(String callback);

    public final native void notifyRemoveCallback(String callback);

    public final native void pausedSession();

    public final native void refreshSymbolTable();

    public final native void removeMetadata(String tab, String key);

    public final native void setInternalMetricsEnabled(boolean enabled);

    public final native void setStaticJsonData(String data);

    public final native void startedSession(String sessionID, String key, int handledCount, int unhandledCount);

    public final native void updateContext(String context);

    public final native void updateInForeground(boolean inForeground, String activityName);

    public final native void updateIsLaunching(boolean isLaunching);

    public final native void updateLowMemory(boolean newValue, String memoryTrimLevelDescription);

    public final native void updateOrientation(String orientation);

    public final native void updateUserEmail(String newValue);

    public final native void updateUserId(String newValue);

    public final native void updateUserName(String newValue);

    public NativeBridge(BackgroundTaskService backgroundTaskService) {
        this.bgTaskService = backgroundTaskService;
    }

    private final boolean is32bit() {
        String[] cpuAbi = NativeInterface.getCpuAbi();
        int length = cpuAbi.length;
        boolean z = false;
        int i = 0;
        while (i < length) {
            String str = cpuAbi[i];
            i++;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "64", false, 2, (Object) null)) {
                z = true;
                break;
            }
        }
        return !z;
    }

    public final void addBreadcrumb(String name, String type, String timestamp, Object metadata) {
        BreadcrumbType breadcrumbType;
        BreadcrumbType[] breadcrumbTypeArrValues = BreadcrumbType.values();
        int length = breadcrumbTypeArrValues.length;
        int i = 0;
        do {
            if (i >= length) {
                breadcrumbType = null;
                break;
            } else {
                breadcrumbType = breadcrumbTypeArrValues[i];
                i++;
            }
        } while (!Intrinsics.areEqual(breadcrumbType.getType(), type));
        if (breadcrumbType == null) {
            breadcrumbType = BreadcrumbType.MANUAL;
        }
        addBreadcrumb(name, toNativeValue(breadcrumbType), timestamp, metadata);
    }

    @Override // com.bugsnag.android.internal.StateObserver
    public void onStateChange(StateEvent event) {
        if (isInvalidMessage(event)) {
            return;
        }
        if (event instanceof StateEvent.Install) {
            handleInstallMessage((StateEvent.Install) event);
            return;
        }
        if (event instanceof StateEvent.DeliverPending) {
            deliverPendingReports();
            return;
        }
        if (event instanceof StateEvent.AddMetadata) {
            handleAddMetadata((StateEvent.AddMetadata) event);
            return;
        }
        if (event instanceof StateEvent.ClearMetadataSection) {
            clearMetadataTab(((StateEvent.ClearMetadataSection) event).section);
            return;
        }
        if (event instanceof StateEvent.ClearMetadataValue) {
            StateEvent.ClearMetadataValue clearMetadataValue = (StateEvent.ClearMetadataValue) event;
            String str = clearMetadataValue.section;
            String str2 = clearMetadataValue.key;
            removeMetadata(str, str2 != null ? str2 : "");
            return;
        }
        if (event instanceof StateEvent.AddBreadcrumb) {
            StateEvent.AddBreadcrumb addBreadcrumb = (StateEvent.AddBreadcrumb) event;
            addBreadcrumb(addBreadcrumb.message, toNativeValue(addBreadcrumb.type), addBreadcrumb.timestamp, addBreadcrumb.metadata);
            return;
        }
        if (Intrinsics.areEqual(event, StateEvent.NotifyHandled.INSTANCE)) {
            addHandledEvent();
            return;
        }
        if (Intrinsics.areEqual(event, StateEvent.NotifyUnhandled.INSTANCE)) {
            addUnhandledEvent();
            return;
        }
        if (Intrinsics.areEqual(event, StateEvent.PauseSession.INSTANCE)) {
            pausedSession();
            return;
        }
        if (event instanceof StateEvent.StartSession) {
            StateEvent.StartSession startSession = (StateEvent.StartSession) event;
            startedSession(startSession.id, startSession.startedAt, startSession.handledCount, startSession.getUnhandledCount());
            return;
        }
        if (event instanceof StateEvent.UpdateContext) {
            String str3 = ((StateEvent.UpdateContext) event).context;
            updateContext(str3 != null ? str3 : "");
            return;
        }
        if (event instanceof StateEvent.UpdateInForeground) {
            StateEvent.UpdateInForeground updateInForeground = (StateEvent.UpdateInForeground) event;
            boolean z = updateInForeground.inForeground;
            String contextActivity = updateInForeground.getContextActivity();
            updateInForeground(z, contextActivity != null ? contextActivity : "");
            return;
        }
        if (event instanceof StateEvent.UpdateIsLaunching) {
            StateEvent.UpdateIsLaunching updateIsLaunching = (StateEvent.UpdateIsLaunching) event;
            updateIsLaunching(updateIsLaunching.isLaunching);
            if (updateIsLaunching.isLaunching) {
                return;
            }
            this.bgTaskService.submitTask(TaskType.DEFAULT, new Runnable() { // from class: com.bugsnag.android.ndk.NativeBridge$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.refreshSymbolTable();
                }
            });
            return;
        }
        if (event instanceof StateEvent.UpdateOrientation) {
            String str4 = ((StateEvent.UpdateOrientation) event).orientation;
            updateOrientation(str4 != null ? str4 : "");
            return;
        }
        if (event instanceof StateEvent.UpdateUser) {
            StateEvent.UpdateUser updateUser = (StateEvent.UpdateUser) event;
            String id = updateUser.user.getId();
            if (id == null) {
                id = "";
            }
            updateUserId(id);
            String name = updateUser.user.getName();
            if (name == null) {
                name = "";
            }
            updateUserName(name);
            String email = updateUser.user.getEmail();
            updateUserEmail(email != null ? email : "");
            return;
        }
        if (event instanceof StateEvent.UpdateMemoryTrimEvent) {
            StateEvent.UpdateMemoryTrimEvent updateMemoryTrimEvent = (StateEvent.UpdateMemoryTrimEvent) event;
            updateLowMemory(updateMemoryTrimEvent.isLowMemory, updateMemoryTrimEvent.memoryTrimLevelDescription);
        } else if (event instanceof StateEvent.AddFeatureFlag) {
            StateEvent.AddFeatureFlag addFeatureFlag = (StateEvent.AddFeatureFlag) event;
            addFeatureFlag(addFeatureFlag.name, addFeatureFlag.variant);
        } else if (event instanceof StateEvent.ClearFeatureFlag) {
            clearFeatureFlag(((StateEvent.ClearFeatureFlag) event).name);
        } else if (event instanceof StateEvent.ClearFeatureFlags) {
            clearFeatureFlags();
        }
    }

    private final void deliverPendingReports() {
        ReportDiscardScanner reportDiscardScanner = new ReportDiscardScanner(this.logger, null, 2, null);
        File[] fileArrListFiles = this.reportDirectory.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        int length = fileArrListFiles.length;
        int i = 0;
        while (i < length) {
            File file = fileArrListFiles[i];
            i++;
            if (reportDiscardScanner.shouldDiscard(file)) {
                file.delete();
            } else {
                NativeInterface.deliverReport(file);
            }
        }
    }

    private final boolean isInvalidMessage(Object msg) {
        if (msg == null || !(msg instanceof StateEvent)) {
            return true;
        }
        if (this.installed.get() || (msg instanceof StateEvent.Install)) {
            return false;
        }
        this.logger.w(Intrinsics.stringPlus("Received message before INSTALL: ", msg));
        return true;
    }

    private final void handleInstallMessage(StateEvent.Install arg) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.installed.get()) {
                this.logger.w(Intrinsics.stringPlus("Received duplicate setup message with arg: ", arg));
            } else {
                install(arg.apiKey, this.reportDirectory.getAbsolutePath(), arg.lastRunInfoPath, UUID.randomUUID().toString(), arg.consecutiveLaunchCrashes, arg.autoDetectNdkCrashes, Build.VERSION.SDK_INT, is32bit(), arg.sendThreads.ordinal(), arg.maxBreadcrumbs);
                this.installed.set(true);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void handleAddMetadata(StateEvent.AddMetadata arg) {
        if (arg.key != null) {
            Object objMakeSafe = OpaqueValue.INSTANCE.makeSafe(arg.value);
            if (objMakeSafe instanceof String) {
                String str = arg.section;
                String str2 = arg.key;
                Intrinsics.checkNotNull(str2);
                addMetadataString(str, str2, (String) objMakeSafe);
                return;
            }
            if (objMakeSafe instanceof Boolean) {
                String str3 = arg.section;
                String str4 = arg.key;
                Intrinsics.checkNotNull(str4);
                addMetadataBoolean(str3, str4, ((Boolean) objMakeSafe).booleanValue());
                return;
            }
            if (objMakeSafe instanceof Number) {
                String str5 = arg.section;
                String str6 = arg.key;
                Intrinsics.checkNotNull(str6);
                addMetadataDouble(str5, str6, ((Number) objMakeSafe).doubleValue());
                return;
            }
            if (objMakeSafe instanceof OpaqueValue) {
                String str7 = arg.section;
                String str8 = arg.key;
                Intrinsics.checkNotNull(str8);
                addMetadataOpaque(str7, str8, ((OpaqueValue) objMakeSafe).getJson());
            }
        }
    }

    private final int toNativeValue(BreadcrumbType breadcrumbType) {
        switch (WhenMappings.$EnumSwitchMapping$0[breadcrumbType.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}

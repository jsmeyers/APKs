package com.bugsnag.android;

import com.google.firebase.dynamiclinks.DynamicLink;
import io.cyolo.android.MainActivityKt;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StateEvent.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0014\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0014\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*¨\u0006+"}, d2 = {"Lcom/bugsnag/android/StateEvent;", "", "()V", "AddBreadcrumb", "AddFeatureFlag", "AddMetadata", "ClearFeatureFlag", "ClearFeatureFlags", "ClearMetadataSection", "ClearMetadataValue", "DeliverPending", "Install", "NotifyHandled", "NotifyUnhandled", "PauseSession", "StartSession", "UpdateContext", "UpdateInForeground", "UpdateIsLaunching", "UpdateLastRunInfo", "UpdateMemoryTrimEvent", "UpdateOrientation", "UpdateUser", "Lcom/bugsnag/android/StateEvent$Install;", "Lcom/bugsnag/android/StateEvent$DeliverPending;", "Lcom/bugsnag/android/StateEvent$AddMetadata;", "Lcom/bugsnag/android/StateEvent$ClearMetadataSection;", "Lcom/bugsnag/android/StateEvent$ClearMetadataValue;", "Lcom/bugsnag/android/StateEvent$AddBreadcrumb;", "Lcom/bugsnag/android/StateEvent$NotifyHandled;", "Lcom/bugsnag/android/StateEvent$NotifyUnhandled;", "Lcom/bugsnag/android/StateEvent$PauseSession;", "Lcom/bugsnag/android/StateEvent$StartSession;", "Lcom/bugsnag/android/StateEvent$UpdateContext;", "Lcom/bugsnag/android/StateEvent$UpdateInForeground;", "Lcom/bugsnag/android/StateEvent$UpdateLastRunInfo;", "Lcom/bugsnag/android/StateEvent$UpdateIsLaunching;", "Lcom/bugsnag/android/StateEvent$UpdateOrientation;", "Lcom/bugsnag/android/StateEvent$UpdateUser;", "Lcom/bugsnag/android/StateEvent$UpdateMemoryTrimEvent;", "Lcom/bugsnag/android/StateEvent$AddFeatureFlag;", "Lcom/bugsnag/android/StateEvent$ClearFeatureFlag;", "Lcom/bugsnag/android/StateEvent$ClearFeatureFlags;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class StateEvent {
    public /* synthetic */ StateEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StateEvent() {
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0002\u0010\u000fR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bugsnag/android/StateEvent$Install;", "Lcom/bugsnag/android/StateEvent;", DynamicLink.Builder.KEY_API_KEY, "", "autoDetectNdkCrashes", "", "appVersion", "buildUuid", "releaseStage", "lastRunInfoPath", "consecutiveLaunchCrashes", "", "sendThreads", "Lcom/bugsnag/android/ThreadSendPolicy;", "maxBreadcrumbs", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/bugsnag/android/ThreadSendPolicy;I)V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Install extends StateEvent {
        public final String apiKey;
        public final String appVersion;
        public final boolean autoDetectNdkCrashes;
        public final String buildUuid;
        public final int consecutiveLaunchCrashes;
        public final String lastRunInfoPath;
        public final int maxBreadcrumbs;
        public final String releaseStage;
        public final ThreadSendPolicy sendThreads;

        public Install(String str, boolean z, String str2, String str3, String str4, String str5, int i, ThreadSendPolicy threadSendPolicy, int i2) {
            super(null);
            this.apiKey = str;
            this.autoDetectNdkCrashes = z;
            this.appVersion = str2;
            this.buildUuid = str3;
            this.releaseStage = str4;
            this.lastRunInfoPath = str5;
            this.consecutiveLaunchCrashes = i;
            this.sendThreads = threadSendPolicy;
            this.maxBreadcrumbs = i2;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bugsnag/android/StateEvent$DeliverPending;", "Lcom/bugsnag/android/StateEvent;", "()V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DeliverPending extends StateEvent {
        public static final DeliverPending INSTANCE = new DeliverPending();

        private DeliverPending() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bugsnag/android/StateEvent$AddMetadata;", "Lcom/bugsnag/android/StateEvent;", "section", "", "key", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AddMetadata extends StateEvent {
        public final String key;
        public final String section;
        public final Object value;

        public AddMetadata(String str, String str2, Object obj) {
            super(null);
            this.section = str;
            this.key = str2;
            this.value = obj;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bugsnag/android/StateEvent$ClearMetadataSection;", "Lcom/bugsnag/android/StateEvent;", "section", "", "(Ljava/lang/String;)V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ClearMetadataSection extends StateEvent {
        public final String section;

        public ClearMetadataSection(String str) {
            super(null);
            this.section = str;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bugsnag/android/StateEvent$ClearMetadataValue;", "Lcom/bugsnag/android/StateEvent;", "section", "", "key", "(Ljava/lang/String;Ljava/lang/String;)V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ClearMetadataValue extends StateEvent {
        public final String key;
        public final String section;

        public ClearMetadataValue(String str, String str2) {
            super(null);
            this.section = str;
            this.key = str2;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\u0002\u0010\nR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bugsnag/android/StateEvent$AddBreadcrumb;", "Lcom/bugsnag/android/StateEvent;", "message", "", "type", "Lcom/bugsnag/android/BreadcrumbType;", "timestamp", "metadata", "", "", "(Ljava/lang/String;Lcom/bugsnag/android/BreadcrumbType;Ljava/lang/String;Ljava/util/Map;)V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AddBreadcrumb extends StateEvent {
        public final String message;
        public final Map<String, Object> metadata;
        public final String timestamp;
        public final BreadcrumbType type;

        public AddBreadcrumb(String str, BreadcrumbType breadcrumbType, String str2, Map<String, Object> map) {
            super(null);
            this.message = str;
            this.type = breadcrumbType;
            this.timestamp = str2;
            this.metadata = map;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bugsnag/android/StateEvent$NotifyHandled;", "Lcom/bugsnag/android/StateEvent;", "()V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NotifyHandled extends StateEvent {
        public static final NotifyHandled INSTANCE = new NotifyHandled();

        private NotifyHandled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bugsnag/android/StateEvent$NotifyUnhandled;", "Lcom/bugsnag/android/StateEvent;", "()V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NotifyUnhandled extends StateEvent {
        public static final NotifyUnhandled INSTANCE = new NotifyUnhandled();

        private NotifyUnhandled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bugsnag/android/StateEvent$PauseSession;", "Lcom/bugsnag/android/StateEvent;", "()V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PauseSession extends StateEvent {
        public static final PauseSession INSTANCE = new PauseSession();

        private PauseSession() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bugsnag/android/StateEvent$StartSession;", "Lcom/bugsnag/android/StateEvent;", "id", "", "startedAt", "handledCount", "", "unhandledCount", "(Ljava/lang/String;Ljava/lang/String;II)V", "getUnhandledCount", "()I", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class StartSession extends StateEvent {
        public final int handledCount;
        public final String id;
        public final String startedAt;
        private final int unhandledCount;

        public final int getUnhandledCount() {
            return this.unhandledCount;
        }

        public StartSession(String str, String str2, int i, int i2) {
            super(null);
            this.id = str;
            this.startedAt = str2;
            this.handledCount = i;
            this.unhandledCount = i2;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bugsnag/android/StateEvent$UpdateContext;", "Lcom/bugsnag/android/StateEvent;", "context", "", "(Ljava/lang/String;)V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UpdateContext extends StateEvent {
        public final String context;

        public UpdateContext(String str) {
            super(null);
            this.context = str;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bugsnag/android/StateEvent$UpdateInForeground;", "Lcom/bugsnag/android/StateEvent;", "inForeground", "", "contextActivity", "", "(ZLjava/lang/String;)V", "getContextActivity", "()Ljava/lang/String;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UpdateInForeground extends StateEvent {
        private final String contextActivity;
        public final boolean inForeground;

        public final String getContextActivity() {
            return this.contextActivity;
        }

        public UpdateInForeground(boolean z, String str) {
            super(null);
            this.inForeground = z;
            this.contextActivity = str;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bugsnag/android/StateEvent$UpdateLastRunInfo;", "Lcom/bugsnag/android/StateEvent;", "consecutiveLaunchCrashes", "", "(I)V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UpdateLastRunInfo extends StateEvent {
        public final int consecutiveLaunchCrashes;

        public UpdateLastRunInfo(int i) {
            super(null);
            this.consecutiveLaunchCrashes = i;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bugsnag/android/StateEvent$UpdateIsLaunching;", "Lcom/bugsnag/android/StateEvent;", "isLaunching", "", "(Z)V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UpdateIsLaunching extends StateEvent {
        public final boolean isLaunching;

        public UpdateIsLaunching(boolean z) {
            super(null);
            this.isLaunching = z;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bugsnag/android/StateEvent$UpdateOrientation;", "Lcom/bugsnag/android/StateEvent;", "orientation", "", "(Ljava/lang/String;)V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UpdateOrientation extends StateEvent {
        public final String orientation;

        public UpdateOrientation(String str) {
            super(null);
            this.orientation = str;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bugsnag/android/StateEvent$UpdateUser;", "Lcom/bugsnag/android/StateEvent;", "user", "Lcom/bugsnag/android/User;", "(Lcom/bugsnag/android/User;)V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UpdateUser extends StateEvent {
        public final User user;

        public UpdateUser(User user) {
            super(null);
            this.user = user;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bugsnag/android/StateEvent$UpdateMemoryTrimEvent;", "Lcom/bugsnag/android/StateEvent;", "isLowMemory", "", "memoryTrimLevel", "", "memoryTrimLevelDescription", "", "(ZLjava/lang/Integer;Ljava/lang/String;)V", "Ljava/lang/Integer;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UpdateMemoryTrimEvent extends StateEvent {
        public final boolean isLowMemory;
        public final Integer memoryTrimLevel;
        public final String memoryTrimLevelDescription;

        public /* synthetic */ UpdateMemoryTrimEvent(boolean z, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? "None" : str);
        }

        public UpdateMemoryTrimEvent(boolean z, Integer num, String str) {
            super(null);
            this.isLowMemory = z;
            this.memoryTrimLevel = num;
            this.memoryTrimLevelDescription = str;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bugsnag/android/StateEvent$AddFeatureFlag;", "Lcom/bugsnag/android/StateEvent;", "name", "", "variant", "(Ljava/lang/String;Ljava/lang/String;)V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AddFeatureFlag extends StateEvent {
        public final String name;
        public final String variant;

        public /* synthetic */ AddFeatureFlag(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public AddFeatureFlag(String str, String str2) {
            super(null);
            this.name = str;
            this.variant = str2;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bugsnag/android/StateEvent$ClearFeatureFlag;", "Lcom/bugsnag/android/StateEvent;", "name", "", "(Ljava/lang/String;)V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ClearFeatureFlag extends StateEvent {
        public final String name;

        public ClearFeatureFlag(String str) {
            super(null);
            this.name = str;
        }
    }

    /* JADX INFO: compiled from: StateEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bugsnag/android/StateEvent$ClearFeatureFlags;", "Lcom/bugsnag/android/StateEvent;", "()V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ClearFeatureFlags extends StateEvent {
        public static final ClearFeatureFlags INSTANCE = new ClearFeatureFlags();

        private ClearFeatureFlags() {
            super(null);
        }
    }
}

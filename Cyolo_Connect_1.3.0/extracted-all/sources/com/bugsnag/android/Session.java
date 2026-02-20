package com.bugsnag.android;

import com.bugsnag.android.Deliverable;
import com.bugsnag.android.JsonStream;
import com.bugsnag.android.internal.DateUtils;
import com.bugsnag.android.internal.JsonHelper;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class Session implements JsonStream.Streamable, Deliverable, UserAware {
    private String apiKey;
    private App app;
    private volatile boolean autoCaptured;
    private Device device;
    private final File file;
    private final AtomicInteger handledCount;
    private String id;
    private final AtomicBoolean isPaused;
    private final Logger logger;
    private final Notifier notifier;
    private Date startedAt;
    private final AtomicBoolean tracked;
    private final AtomicInteger unhandledCount;
    private User user;

    static Session copySession(Session session) {
        Session session2 = new Session(session.id, session.startedAt, session.user, session.unhandledCount.get(), session.handledCount.get(), session.notifier, session.logger, session.getApiKey());
        session2.tracked.set(session.tracked.get());
        session2.autoCaptured = session.isAutoCaptured();
        return session2;
    }

    Session(Map<String, Object> map, Logger logger, String str) {
        this(null, null, logger, str);
        setId((String) map.get("id"));
        setStartedAt(DateUtils.fromIso8601((String) map.get("startedAt")));
        Map map2 = (Map) map.get("events");
        this.handledCount.set(((Number) map2.get("handled")).intValue());
        this.unhandledCount.set(((Number) map2.get("unhandled")).intValue());
    }

    Session(String str, Date date, User user, boolean z, Notifier notifier, Logger logger, String str2) {
        this(null, notifier, logger, str2);
        this.id = str;
        this.startedAt = new Date(date.getTime());
        this.user = user;
        this.autoCaptured = z;
        this.apiKey = str2;
    }

    Session(String str, Date date, User user, int i, int i2, Notifier notifier, Logger logger, String str2) {
        this(str, date, user, false, notifier, logger, str2);
        this.unhandledCount.set(i);
        this.handledCount.set(i2);
        this.tracked.set(true);
        this.apiKey = str2;
    }

    Session(File file, Notifier notifier, Logger logger, String str) {
        this.autoCaptured = false;
        this.unhandledCount = new AtomicInteger();
        this.handledCount = new AtomicInteger();
        this.tracked = new AtomicBoolean(false);
        this.isPaused = new AtomicBoolean(false);
        this.file = file;
        this.logger = logger;
        this.apiKey = SessionFilenameInfo.findApiKeyInFilename(file, str);
        if (notifier != null) {
            Notifier notifier2 = new Notifier(notifier.getName(), notifier.getVersion(), notifier.getUrl());
            notifier2.setDependencies(new ArrayList(notifier.getDependencies()));
            this.notifier = notifier2;
            return;
        }
        this.notifier = null;
    }

    private void logNull(String str) {
        this.logger.e("Invalid null value supplied to session." + str + ", ignoring");
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        if (str != null) {
            this.id = str;
        } else {
            logNull("id");
        }
    }

    public Date getStartedAt() {
        return this.startedAt;
    }

    public void setStartedAt(Date date) {
        if (date != null) {
            this.startedAt = date;
        } else {
            logNull("startedAt");
        }
    }

    @Override // com.bugsnag.android.UserAware
    /* JADX INFO: renamed from: getUser */
    public User getUserImpl() {
        return this.user;
    }

    @Override // com.bugsnag.android.UserAware
    public void setUser(String str, String str2, String str3) {
        this.user = new User(str, str2, str3);
    }

    public App getApp() {
        return this.app;
    }

    public Device getDevice() {
        return this.device;
    }

    void setApp(App app) {
        this.app = app;
    }

    void setDevice(Device device) {
        this.device = device;
    }

    int getUnhandledCount() {
        return this.unhandledCount.intValue();
    }

    int getHandledCount() {
        return this.handledCount.intValue();
    }

    Session incrementHandledAndCopy() {
        this.handledCount.incrementAndGet();
        return copySession(this);
    }

    Session incrementUnhandledAndCopy() {
        this.unhandledCount.incrementAndGet();
        return copySession(this);
    }

    boolean markTracked() {
        return this.tracked.compareAndSet(false, true);
    }

    boolean markResumed() {
        return this.isPaused.compareAndSet(true, false);
    }

    void markPaused() {
        this.isPaused.set(true);
    }

    boolean isPaused() {
        return this.isPaused.get();
    }

    boolean isAutoCaptured() {
        return this.autoCaptured;
    }

    void setAutoCaptured(boolean z) {
        this.autoCaptured = z;
    }

    boolean isLegacyPayload() {
        File file = this.file;
        return file == null || !(file.getName().endsWith("_v2.json") || this.file.getName().endsWith("_v3.json"));
    }

    Notifier getNotifier() {
        return this.notifier;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws Throwable {
        if (this.file != null) {
            if (!isLegacyPayload()) {
                serializePayload(jsonStream);
                return;
            } else {
                serializeLegacyPayload(jsonStream);
                return;
            }
        }
        jsonStream.beginObject();
        jsonStream.name("notifier").value(this.notifier);
        jsonStream.name("app").value(this.app);
        jsonStream.name("device").value(this.device);
        jsonStream.name("sessions").beginArray();
        serializeSessionInfo(jsonStream);
        jsonStream.endArray();
        jsonStream.endObject();
    }

    @Override // com.bugsnag.android.Deliverable
    public byte[] toByteArray() throws IOException {
        return JsonHelper.INSTANCE.serialize((JsonStream.Streamable) this);
    }

    @Override // com.bugsnag.android.Deliverable
    public String getIntegrityToken() {
        return Deliverable.DefaultImpls.getIntegrityToken(this);
    }

    private void serializePayload(JsonStream jsonStream) throws Throwable {
        jsonStream.value(this.file);
    }

    private void serializeLegacyPayload(JsonStream jsonStream) throws Throwable {
        jsonStream.beginObject();
        jsonStream.name("notifier").value(this.notifier);
        jsonStream.name("app").value(this.app);
        jsonStream.name("device").value(this.device);
        jsonStream.name("sessions").beginArray();
        jsonStream.value(this.file);
        jsonStream.endArray();
        jsonStream.endObject();
    }

    void serializeSessionInfo(JsonStream jsonStream) throws Throwable {
        jsonStream.beginObject();
        jsonStream.name("id").value(this.id);
        jsonStream.name("startedAt").value(this.startedAt);
        jsonStream.name("user").value(this.user);
        jsonStream.endObject();
    }

    public void setApiKey(String str) {
        if (str != null) {
            this.apiKey = str;
        } else {
            logNull(DynamicLink.Builder.KEY_API_KEY);
        }
    }

    public String getApiKey() {
        return this.apiKey;
    }
}

package com.bugsnag.android;

import android.util.JsonReader;
import com.bugsnag.android.DeviceIdStore;
import com.bugsnag.android.StateEvent;
import com.bugsnag.android.User;
import com.bugsnag.android.internal.StateObserver;
import com.bugsnag.android.internal.dag.Provider;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: UserStore.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0011H\u0002R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bugsnag/android/UserStore;", "", "persist", "", "persistentDir", "Lcom/bugsnag/android/internal/dag/Provider;", "Ljava/io/File;", "deviceIdStore", "Lcom/bugsnag/android/DeviceIdStore$DeviceIds;", "file", "sharedPrefMigrator", "Lcom/bugsnag/android/SharedPrefMigrator;", "logger", "Lcom/bugsnag/android/Logger;", "(ZLcom/bugsnag/android/internal/dag/Provider;Lcom/bugsnag/android/internal/dag/Provider;Ljava/io/File;Lcom/bugsnag/android/internal/dag/Provider;Lcom/bugsnag/android/Logger;)V", "previousUser", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/bugsnag/android/User;", "synchronizedStreamableStore", "Lcom/bugsnag/android/SynchronizedStreamableStore;", "load", "Lcom/bugsnag/android/UserState;", "initialUser", "loadPersistedUser", "save", "", "user", "validUser", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UserStore {
    private final Provider<DeviceIdStore.DeviceIds> deviceIdStore;
    private final Logger logger;
    private final boolean persist;
    private final Provider<File> persistentDir;
    private final AtomicReference<User> previousUser;
    private final Provider<SharedPrefMigrator> sharedPrefMigrator;
    private final SynchronizedStreamableStore<User> synchronizedStreamableStore;

    public UserStore(boolean z, Provider<File> provider, Provider<DeviceIdStore.DeviceIds> provider2, File file, Provider<SharedPrefMigrator> provider3, Logger logger) {
        this.persist = z;
        this.persistentDir = provider;
        this.deviceIdStore = provider2;
        this.sharedPrefMigrator = provider3;
        this.logger = logger;
        this.previousUser = new AtomicReference<>(null);
        this.synchronizedStreamableStore = new SynchronizedStreamableStore<>(file);
    }

    public /* synthetic */ UserStore(boolean z, Provider provider, Provider provider2, File file, Provider provider3, Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, provider, provider2, (i & 8) != 0 ? new File((File) provider.get(), "user-info") : file, provider3, logger);
    }

    public final UserState load(User initialUser) {
        UserState userState;
        if (!validUser(initialUser)) {
            initialUser = this.persist ? loadPersistedUser() : null;
        }
        if (initialUser == null || !validUser(initialUser)) {
            DeviceIdStore.DeviceIds deviceIds = this.deviceIdStore.get();
            userState = new UserState(new User(deviceIds == null ? null : deviceIds.getDeviceId(), null, null));
        } else {
            userState = new UserState(initialUser);
        }
        userState.addObserver(new StateObserver() { // from class: com.bugsnag.android.UserStore$$ExternalSyntheticLambda0
            @Override // com.bugsnag.android.internal.StateObserver
            public final void onStateChange(StateEvent stateEvent) {
                UserStore.m256load$lambda0(this.f$0, stateEvent);
            }
        });
        return userState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: load$lambda-0, reason: not valid java name */
    public static final void m256load$lambda0(UserStore userStore, StateEvent stateEvent) {
        if (stateEvent instanceof StateEvent.UpdateUser) {
            userStore.save(((StateEvent.UpdateUser) stateEvent).user);
        }
    }

    public final void save(User user) {
        if (!this.persist || kotlin.jvm.internal.Intrinsics.areEqual(user, this.previousUser.getAndSet(user))) {
            return;
        }
        try {
            this.synchronizedStreamableStore.persist(user);
        } catch (Exception e) {
            this.logger.w("Failed to persist user info", e);
        }
    }

    private final boolean validUser(User user) {
        return (user.getId() == null && user.getName() == null && user.getEmail() == null) ? false : true;
    }

    private final User loadPersistedUser() {
        if (this.sharedPrefMigrator.get().hasPrefs()) {
            SharedPrefMigrator sharedPrefMigrator = this.sharedPrefMigrator.get();
            DeviceIdStore.DeviceIds deviceIds = this.deviceIdStore.get();
            User userLoadUser = sharedPrefMigrator.loadUser(deviceIds != null ? deviceIds.getDeviceId() : null);
            save(userLoadUser);
            return userLoadUser;
        }
        if (this.synchronizedStreamableStore.getFile().canRead() && this.synchronizedStreamableStore.getFile().length() > 0 && this.persist) {
            try {
                return (User) this.synchronizedStreamableStore.load(new AnonymousClass1(User.INSTANCE));
            } catch (Exception e) {
                this.logger.w("Failed to load user info", e);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: com.bugsnag.android.UserStore$loadPersistedUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: UserStore.kt */
    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<JsonReader, User> {
        AnonymousClass1(Object obj) {
            super(1, obj, User.Companion.class, "fromReader", "fromReader(Landroid/util/JsonReader;)Lcom/bugsnag/android/User;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final User invoke(JsonReader jsonReader) {
            return ((User.Companion) this.receiver).fromReader(jsonReader);
        }
    }
}

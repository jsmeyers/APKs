package com.bugsnag.android;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SharedPrefMigrator.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bugsnag/android/SharedPrefMigrator;", "Lcom/bugsnag/android/DeviceIdPersistence;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "deleteLegacyPrefs", "", "hasPrefs", "", "loadDeviceId", "", "requestCreateIfDoesNotExist", "loadUser", "Lcom/bugsnag/android/User;", "deviceId", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SharedPrefMigrator implements DeviceIdPersistence {
    private static final String INSTALL_ID_KEY = "install.iud";
    private static final String USER_EMAIL_KEY = "user.email";
    private static final String USER_ID_KEY = "user.id";
    private static final String USER_NAME_KEY = "user.name";
    private final SharedPreferences prefs;

    public SharedPrefMigrator(Context context) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences("com.bugsnag.android", 0);
        } catch (RuntimeException unused) {
            sharedPreferences = null;
        }
        this.prefs = sharedPreferences;
    }

    @Override // com.bugsnag.android.DeviceIdPersistence
    public String loadDeviceId(boolean requestCreateIfDoesNotExist) {
        SharedPreferences sharedPreferences = this.prefs;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(INSTALL_ID_KEY, null);
    }

    public final User loadUser(String deviceId) {
        SharedPreferences sharedPreferences = this.prefs;
        String string = sharedPreferences == null ? null : sharedPreferences.getString(USER_ID_KEY, deviceId);
        SharedPreferences sharedPreferences2 = this.prefs;
        String string2 = sharedPreferences2 == null ? null : sharedPreferences2.getString(USER_EMAIL_KEY, null);
        SharedPreferences sharedPreferences3 = this.prefs;
        return new User(string, string2, sharedPreferences3 != null ? sharedPreferences3.getString(USER_NAME_KEY, null) : null);
    }

    public final boolean hasPrefs() {
        SharedPreferences sharedPreferences = this.prefs;
        return sharedPreferences != null && sharedPreferences.contains(INSTALL_ID_KEY);
    }

    public final void deleteLegacyPrefs() {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorClear;
        if (!hasPrefs() || (sharedPreferences = this.prefs) == null || (editorEdit = sharedPreferences.edit()) == null || (editorClear = editorEdit.clear()) == null) {
            return;
        }
        editorClear.commit();
    }
}

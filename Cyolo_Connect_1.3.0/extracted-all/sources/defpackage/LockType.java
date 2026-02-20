package defpackage;

import android.content.ContentResolver;
import android.os.Environment;
import android.provider.Settings;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LockType.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"LLockType;", "", "()V", "FACE_WITH_PATTERN", "", "FACE_WITH_PIN", "FACE_WITH_SOMETHING_ELSE", "NONE_OR_SLIDER", "PASSWORD_ALPHABETIC", "PASSWORD_ALPHANUMERIC", "PASSWORD_TYPE_KEY", "", "PATTERN", "PIN", "SOMETHING_ELSE", "getCurrent", "contentResolver", "Landroid/content/ContentResolver;", "nonEmptyFileExists", "", "filename", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LockType {
    public static final int FACE_WITH_PATTERN = 3;
    public static final int FACE_WITH_PIN = 4;
    public static final int FACE_WITH_SOMETHING_ELSE = 9;
    public static final LockType INSTANCE = new LockType();
    public static final int NONE_OR_SLIDER = 1;
    public static final int PASSWORD_ALPHABETIC = 12;
    public static final int PASSWORD_ALPHANUMERIC = 13;
    private static final String PASSWORD_TYPE_KEY = "lockscreen.password_type";
    public static final int PATTERN = 10;
    public static final int PIN = 11;
    public static final int SOMETHING_ELSE = 0;

    private LockType() {
    }

    public final int getCurrent(ContentResolver contentResolver) {
        int i = Settings.Secure.getInt(contentResolver, PASSWORD_TYPE_KEY, 65536);
        if (i != 32768) {
            if (i == 65536) {
                return Settings.Secure.getInt(contentResolver, "lock_pattern_autolock", 0) == 1 ? 10 : 1;
            }
            if (i == 131072) {
                return 11;
            }
            if (i != 262144) {
                return i != 327680 ? 0 : 13;
            }
            return 12;
        }
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        if (nonEmptyFileExists(absolutePath + "/system/gesture.key")) {
            return 3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(absolutePath);
        sb.append("/system/password.key");
        return nonEmptyFileExists(sb.toString()) ? 4 : 9;
    }

    private final boolean nonEmptyFileExists(String filename) {
        File file = new File(filename);
        return file.exists() && file.length() > 0;
    }
}

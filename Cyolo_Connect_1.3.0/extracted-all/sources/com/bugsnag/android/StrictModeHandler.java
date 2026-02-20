package com.bugsnag.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class StrictModeHandler {
    private static final int DETECT_CUSTOM = 8;
    private static final int DETECT_DISK_READ = 2;
    private static final int DETECT_DISK_WRITE = 1;
    private static final int DETECT_NETWORK = 4;
    private static final int DETECT_RESOURCE_MISMATCH = 16;
    private static final int DETECT_VM_ACTIVITY_LEAKS = 1024;
    private static final int DETECT_VM_CLEARTEXT_NETWORK = 16384;
    private static final int DETECT_VM_CLOSABLE_LEAKS = 512;
    private static final int DETECT_VM_CURSOR_LEAKS = 256;
    private static final int DETECT_VM_FILE_URI_EXPOSURE = 8192;
    private static final int DETECT_VM_INSTANCE_LEAKS = 2048;
    private static final int DETECT_VM_REGISTRATION_LEAKS = 4096;
    private static final Map<Integer, String> POLICY_CODE_MAP;
    private static final String STRICT_MODE_CLZ_NAME = "android.os.strictmode";

    StrictModeHandler() {
    }

    static {
        HashMap map = new HashMap();
        POLICY_CODE_MAP = map;
        map.put(1, "DiskWrite");
        map.put(2, "DiskRead");
        map.put(4, "NetworkOperation");
        map.put(8, "CustomSlowCall");
        map.put(16, "ResourceMismatch");
        map.put(256, "CursorLeak");
        map.put(512, "CloseableLeak");
        map.put(1024, "ActivityLeak");
        map.put(2048, "InstanceLeak");
        map.put(4096, "RegistrationLeak");
        map.put(8192, "FileUriLeak");
        map.put(16384, "CleartextNetwork");
    }

    boolean isStrictModeThrowable(Throwable th) {
        return getRootCause(th).getClass().getName().toLowerCase(Locale.US).startsWith(STRICT_MODE_CLZ_NAME);
    }

    String getViolationDescription(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        int iLastIndexOf = str.lastIndexOf("violation=");
        if (iLastIndexOf == -1) {
            return null;
        }
        String strReplace = str.substring(iLastIndexOf).replace("violation=", "");
        if (!TextUtils.isDigitsOnly(strReplace)) {
            return null;
        }
        return POLICY_CODE_MAP.get(Integer.valueOf(strReplace));
    }

    private Throwable getRootCause(Throwable th) {
        return ThrowableUtils.safeUnrollCauses(th).get(r2.size() - 1);
    }
}

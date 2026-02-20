package org.apache.commons.io.file;

/* JADX INFO: loaded from: classes3.dex */
public enum StandardDeleteOption implements DeleteOption {
    OVERRIDE_READ_ONLY;

    public static boolean overrideReadOnly(DeleteOption[] deleteOptionArr) {
        if (deleteOptionArr != null && deleteOptionArr.length != 0) {
            for (DeleteOption deleteOption : deleteOptionArr) {
                if (deleteOption == OVERRIDE_READ_ONLY) {
                    return true;
                }
            }
        }
        return false;
    }
}

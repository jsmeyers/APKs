package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzi implements DynamiteModule.VersionPolicy {
    zzi() {
    }

    /* JADX WARN: Found duplicated region for block: B:7:0x001c A[DONT_INVERT, PHI: r4
      0x001c: PHI (r4v2 int) = (r4v1 int), (r4v3 int) binds: [B:3:0x0014, B:5:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Found duplicated region for block: B:9:0x0022  */
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.localVersion = iVersions.zza(context, str);
        int iZzb = iVersions.zzb(context, str, true);
        selectionResult.remoteVersion = iZzb;
        int i = selectionResult.localVersion;
        if (i == 0) {
            i = 0;
            if (iZzb == 0) {
                selectionResult.selection = 0;
            } else if (i >= iZzb) {
                selectionResult.selection = -1;
            } else {
                selectionResult.selection = 1;
            }
        } else if (i >= iZzb) {
            selectionResult.selection = -1;
        } else {
            selectionResult.selection = 1;
        }
        return selectionResult;
    }
}

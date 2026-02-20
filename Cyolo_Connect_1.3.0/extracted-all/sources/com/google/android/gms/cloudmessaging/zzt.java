package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.firebase.messaging.Constants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzt extends zzr {
    zzt(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.zzr
    final void zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zzd(bundle2);
    }

    @Override // com.google.android.gms.cloudmessaging.zzr
    final boolean zzb() {
        return false;
    }
}

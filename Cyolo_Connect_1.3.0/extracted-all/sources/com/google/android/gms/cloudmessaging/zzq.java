package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzq extends zzr {
    zzq(int i, int i2, Bundle bundle) {
        super(i, i2, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.zzr
    final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zzd(null);
        } else {
            zzc(new zzs(4, "Invalid response to one way request", null));
        }
    }

    @Override // com.google.android.gms.cloudmessaging.zzr
    final boolean zzb() {
        return true;
    }
}

package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import java.lang.ref.SoftReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    private static SoftReference zza;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
    public static final class IntentActionKeys {
        public static final String NOTIFICATION_DISMISS = "com.google.firebase.messaging.NOTIFICATION_DISMISS";
        public static final String NOTIFICATION_OPEN = "com.google.firebase.messaging.NOTIFICATION_OPEN";

        private IntentActionKeys() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
    public static final class IntentKeys {
        public static final String PENDING_INTENT = "pending_intent";
        public static final String WRAPPED_INTENT = "wrapped_intent";

        private IntentKeys() {
        }
    }

    private final int zzb(Context context, Intent intent) {
        Task taskZzc;
        if (intent.getExtras() == null) {
            return 500;
        }
        CloudMessage cloudMessage = new CloudMessage(intent);
        if (TextUtils.isEmpty(cloudMessage.getMessageId())) {
            taskZzc = Tasks.forResult(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.MessagePayloadKeys.MSGID, cloudMessage.getMessageId());
            Integer numZza = cloudMessage.zza();
            if (numZza != null) {
                bundle.putInt(Constants.MessagePayloadKeys.PRODUCT_ID, numZza.intValue());
            }
            bundle.putBoolean("supports_message_handled", true);
            taskZzc = zzu.zzb(context).zzc(2, bundle);
        }
        int iOnMessageReceive = onMessageReceive(context, cloudMessage);
        try {
            Tasks.await(taskZzc, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            Log.w("CloudMessagingReceiver", "Message ack failed: ".concat(e.toString()));
        }
        return iOnMessageReceive;
    }

    private final int zzc(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(IntentKeys.PENDING_INTENT);
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove(IntentKeys.PENDING_INTENT);
        } else {
            extras = new Bundle();
        }
        String action = intent.getAction();
        if (action == IntentActionKeys.NOTIFICATION_DISMISS || (action != null && action.equals(IntentActionKeys.NOTIFICATION_DISMISS))) {
            onNotificationDismissed(context, extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    protected Executor getBroadcastExecutor() {
        ExecutorService executorServiceUnconfigurableExecutorService;
        synchronized (CloudMessagingReceiver.class) {
            SoftReference softReference = zza;
            executorServiceUnconfigurableExecutorService = softReference != null ? (ExecutorService) softReference.get() : null;
            if (executorServiceUnconfigurableExecutorService == null) {
                com.google.android.gms.internal.cloudmessaging.zze.zza();
                executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new NamedThreadFactory("firebase-iid-executor")));
                zza = new SoftReference(executorServiceUnconfigurableExecutorService);
            }
        }
        return executorServiceUnconfigurableExecutorService;
    }

    protected abstract int onMessageReceive(Context context, CloudMessage cloudMessage);

    protected void onNotificationDismissed(Context context, Bundle bundle) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean zIsOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        getBroadcastExecutor().execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(intent, context, zIsOrderedBroadcast, pendingResultGoAsync);
            }
        });
    }

    final /* synthetic */ void zza(Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra(IntentKeys.WRAPPED_INTENT);
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            int iZzc = intent2 != null ? zzc(context, intent2) : zzb(context, intent);
            if (z) {
                pendingResult.setResultCode(iZzc);
            }
        } finally {
            pendingResult.finish();
        }
    }
}

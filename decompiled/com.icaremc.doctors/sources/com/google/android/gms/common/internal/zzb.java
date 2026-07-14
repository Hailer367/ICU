package com.google.android.gms.common.internal;

import O.a;
import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzb extends com.google.android.gms.internal.common.zzg {
    final /* synthetic */ BaseGmsClient zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        java.util.Objects.requireNonNull(baseGmsClient);
        this.zza = baseGmsClient;
    }

    private static final void zza(Message message) {
        zzc zzcVar = (zzc) message.obj;
        if (zzcVar != null) {
            zzcVar.zze();
        }
    }

    private static final boolean zzb(Message message) {
        int i2 = message.what;
        if (i2 == 2 || i2 == 1 || i2 == 7) {
            return true;
        }
        return false;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        BaseGmsClient baseGmsClient = this.zza;
        if (baseGmsClient.zzd.get() != message.arg1) {
            if (zzb(message)) {
                zza(message);
                return;
            }
            return;
        }
        int i2 = message.what;
        if ((i2 != 1 && i2 != 7 && ((i2 != 4 || baseGmsClient.enableLocalFallback()) && message.what != 5)) || baseGmsClient.isConnecting()) {
            int i3 = message.what;
            PendingIntent pendingIntent = null;
            if (i3 == 4) {
                baseGmsClient.zzn(new ConnectionResult(message.arg2));
                if (baseGmsClient.zzg() && !baseGmsClient.zzo()) {
                    baseGmsClient.zzd(3, null);
                    return;
                }
                if (baseGmsClient.zzm() != null) {
                    connectionResult2 = baseGmsClient.zzm();
                } else {
                    connectionResult2 = new ConnectionResult(8);
                }
                baseGmsClient.zzc.onReportServiceBinding(connectionResult2);
                baseGmsClient.onConnectionFailed(connectionResult2);
                return;
            }
            if (i3 == 5) {
                if (baseGmsClient.zzm() != null) {
                    connectionResult = baseGmsClient.zzm();
                } else {
                    connectionResult = new ConnectionResult(8);
                }
                baseGmsClient.zzc.onReportServiceBinding(connectionResult);
                baseGmsClient.onConnectionFailed(connectionResult);
                return;
            }
            if (i3 == 3) {
                Object obj = message.obj;
                if (obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) obj;
                }
                ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, pendingIntent);
                baseGmsClient.zzc.onReportServiceBinding(connectionResult3);
                baseGmsClient.onConnectionFailed(connectionResult3);
                return;
            }
            if (i3 == 6) {
                baseGmsClient.zzd(5, null);
                if (baseGmsClient.zzk() != null) {
                    baseGmsClient.zzk().onConnectionSuspended(message.arg2);
                }
                baseGmsClient.onConnectionSuspended(message.arg2);
                baseGmsClient.zze(5, 1, null);
                return;
            }
            if (i3 == 2 && !baseGmsClient.isConnected()) {
                zza(message);
                return;
            } else if (zzb(message)) {
                ((zzc) message.obj).zzd();
                return;
            } else {
                int i4 = message.what;
                Log.wtf("GmsClient", a.h(new StringBuilder(String.valueOf(i4).length() + 34), "Don't know how to handle message: ", i4), new Exception());
                return;
            }
        }
        zza(message);
    }
}

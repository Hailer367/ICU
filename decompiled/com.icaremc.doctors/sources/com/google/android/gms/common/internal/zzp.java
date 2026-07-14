package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzp implements Handler.Callback {
    final /* synthetic */ zzq zza;

    public /* synthetic */ zzp(zzq zzqVar, byte[] bArr) {
        java.util.Objects.requireNonNull(zzqVar);
        this.zza = zzqVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            zzq zzqVar = this.zza;
            synchronized (zzqVar.zzf()) {
                try {
                    zzn zznVar = (zzn) message.obj;
                    zzo zzoVar = (zzo) zzqVar.zzf().get(zznVar);
                    if (zzoVar != null && zzoVar.zze() == 3) {
                        String valueOf = String.valueOf(zznVar);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 47);
                        sb.append("Timeout waiting for ServiceConnection callback ");
                        sb.append(valueOf);
                        Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                        ComponentName zzi = zzoVar.zzi();
                        if (zzi == null) {
                            zzi = zznVar.zzc();
                        }
                        if (zzi == null) {
                            String zzb = zznVar.zzb();
                            Preconditions.checkNotNull(zzb);
                            zzi = new ComponentName(zzb, "unknown");
                        }
                        zzoVar.onServiceDisconnected(zzi);
                    }
                } finally {
                }
            }
            return true;
        }
        zzq zzqVar2 = this.zza;
        synchronized (zzqVar2.zzf()) {
            try {
                zzn zznVar2 = (zzn) message.obj;
                zzo zzoVar2 = (zzo) zzqVar2.zzf().get(zznVar2);
                if (zzoVar2 != null && zzoVar2.zzg()) {
                    if (zzoVar2.zzd()) {
                        zzoVar2.zza("GmsClientSupervisor");
                    }
                    zzqVar2.zzf().remove(zznVar2);
                }
            } finally {
            }
        }
        return true;
    }
}

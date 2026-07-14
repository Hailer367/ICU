package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzq extends GmsClientSupervisor {
    private final HashMap zzb = new HashMap();
    private final Context zzc;
    private volatile Handler zzd;
    private final zzp zze;
    private final ConnectionTracker zzf;
    private final long zzg;
    private final long zzh;
    private volatile Executor zzi;

    public zzq(Context context, Looper looper, Executor executor) {
        zzp zzpVar = new zzp(this, null);
        this.zze = zzpVar;
        this.zzc = context.getApplicationContext();
        this.zzd = new com.google.android.gms.internal.common.zzg(looper, zzpVar);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = 5000L;
        this.zzh = 300000L;
        this.zzi = executor;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final ConnectionResult zza(zzn zznVar, ServiceConnection serviceConnection, String str, Executor executor) {
        ConnectionResult connectionResult;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        HashMap hashMap = this.zzb;
        synchronized (hashMap) {
            try {
                zzo zzoVar = (zzo) hashMap.get(zznVar);
                if (executor == null) {
                    executor = this.zzi;
                }
                if (zzoVar == null) {
                    zzoVar = new zzo(this, zznVar);
                    zzoVar.zzb(serviceConnection, serviceConnection, str);
                    connectionResult = zzoVar.zzj(str, executor);
                    hashMap.put(zznVar, zzoVar);
                } else {
                    this.zzd.removeMessages(0, zznVar);
                    if (!zzoVar.zzf(serviceConnection)) {
                        zzoVar.zzb(serviceConnection, serviceConnection, str);
                        int zze = zzoVar.zze();
                        if (zze != 1) {
                            if (zze == 2) {
                                connectionResult = zzoVar.zzj(str, executor);
                            }
                        } else {
                            serviceConnection.onServiceConnected(zzoVar.zzi(), zzoVar.zzh());
                        }
                        connectionResult = null;
                    } else {
                        String zznVar2 = zznVar.toString();
                        StringBuilder sb = new StringBuilder(zznVar2.length() + 81);
                        sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb.append(zznVar2);
                        throw new IllegalStateException(sb.toString());
                    }
                }
                if (zzoVar.zzd()) {
                    return ConnectionResult.RESULT_SUCCESS;
                }
                if (connectionResult == null) {
                    connectionResult = new ConnectionResult(-1);
                }
                return connectionResult;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final void zzc(zzn zznVar, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        HashMap hashMap = this.zzb;
        synchronized (hashMap) {
            try {
                zzo zzoVar = (zzo) hashMap.get(zznVar);
                if (zzoVar != null) {
                    if (zzoVar.zzf(serviceConnection)) {
                        zzoVar.zzc(serviceConnection, str);
                        if (zzoVar.zzg()) {
                            this.zzd.sendMessageDelayed(this.zzd.obtainMessage(0, zznVar), this.zzg);
                        }
                    } else {
                        String zznVar2 = zznVar.toString();
                        StringBuilder sb = new StringBuilder(zznVar2.length() + 76);
                        sb.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                        sb.append(zznVar2);
                        throw new IllegalStateException(sb.toString());
                    }
                } else {
                    String zznVar3 = zznVar.toString();
                    StringBuilder sb2 = new StringBuilder(zznVar3.length() + 50);
                    sb2.append("Nonexistent connection status for service config: ");
                    sb2.append(zznVar3);
                    throw new IllegalStateException(sb2.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzd(Looper looper) {
        synchronized (this.zzb) {
            this.zzd = new com.google.android.gms.internal.common.zzg(looper, this.zze);
        }
    }

    public final void zze(Executor executor) {
        synchronized (this.zzb) {
            this.zzi = executor;
        }
    }

    public final /* synthetic */ HashMap zzf() {
        return this.zzb;
    }

    public final /* synthetic */ Context zzg() {
        return this.zzc;
    }

    public final /* synthetic */ Handler zzh() {
        return this.zzd;
    }

    public final /* synthetic */ ConnectionTracker zzi() {
        return this.zzf;
    }

    public final /* synthetic */ long zzj() {
        return this.zzh;
    }
}

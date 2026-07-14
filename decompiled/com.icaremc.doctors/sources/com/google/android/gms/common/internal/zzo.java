package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzo implements ServiceConnection, zzr {
    final /* synthetic */ zzq zza;
    private final Map zzb;
    private int zzc;
    private boolean zzd;
    private IBinder zze;
    private final zzn zzf;
    private ComponentName zzg;

    public zzo(zzq zzqVar, zzn zznVar) {
        java.util.Objects.requireNonNull(zzqVar);
        this.zza = zzqVar;
        this.zzf = zznVar;
        this.zzb = new HashMap();
        this.zzc = 2;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzq zzqVar = this.zza;
        synchronized (zzqVar.zzf()) {
            try {
                zzqVar.zzh().removeMessages(1, this.zzf);
                this.zze = iBinder;
                this.zzg = componentName;
                Iterator it = this.zzb.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.zzc = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzq zzqVar = this.zza;
        synchronized (zzqVar.zzf()) {
            try {
                zzqVar.zzh().removeMessages(1, this.zzf);
                this.zze = null;
                this.zzg = componentName;
                Iterator it = this.zzb.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.zzc = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zza(String str) {
        zzn zznVar = this.zzf;
        zzq zzqVar = this.zza;
        zzqVar.zzh().removeMessages(1, zznVar);
        zzqVar.zzi().unbindService(zzqVar.zzg(), this);
        this.zzd = false;
        this.zzc = 2;
    }

    public final void zzb(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.zzb.put(serviceConnection, serviceConnection2);
    }

    public final void zzc(ServiceConnection serviceConnection, String str) {
        this.zzb.remove(serviceConnection);
    }

    public final boolean zzd() {
        return this.zzd;
    }

    public final int zze() {
        return this.zzc;
    }

    public final boolean zzf(ServiceConnection serviceConnection) {
        return this.zzb.containsKey(serviceConnection);
    }

    public final boolean zzg() {
        return this.zzb.isEmpty();
    }

    public final IBinder zzh() {
        return this.zze;
    }

    public final ComponentName zzi() {
        return this.zzg;
    }

    public final /* synthetic */ ConnectionResult zzj(String str, Executor executor) {
        zzq zzqVar;
        ConnectionTracker zzi;
        Context zzg;
        zzn zznVar;
        try {
            Intent zza = zzah.zza(this.zza.zzg(), this.zzf);
            this.zzc = 3;
            StrictMode.VmPolicy zza2 = com.google.android.gms.common.util.zzd.zza();
            try {
                zzqVar = this.zza;
                zzi = zzqVar.zzi();
                zzg = zzqVar.zzg();
                zznVar = this.zzf;
            } catch (Throwable th) {
                th = th;
            }
            try {
                boolean zza3 = zzi.zza(zzg, str, zza, this, 4225, executor);
                this.zzd = zza3;
                if (zza3) {
                    zzqVar.zzh().sendMessageDelayed(zzqVar.zzh().obtainMessage(1, zznVar), zzqVar.zzj());
                    ConnectionResult connectionResult = ConnectionResult.RESULT_SUCCESS;
                    StrictMode.setVmPolicy(zza2);
                    return connectionResult;
                }
                this.zzc = 2;
                try {
                    zzqVar.zzi().unbindService(zzqVar.zzg(), this);
                } catch (IllegalArgumentException unused) {
                }
                ConnectionResult connectionResult2 = new ConnectionResult(16);
                StrictMode.setVmPolicy(zza2);
                return connectionResult2;
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                StrictMode.setVmPolicy(zza2);
                throw th3;
            }
        } catch (zzaf e2) {
            return e2.zza;
        }
    }
}

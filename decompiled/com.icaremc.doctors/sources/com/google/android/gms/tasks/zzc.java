package com.google.android.gms.tasks;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzc implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzd zzb;

    public zzc(zzd zzdVar, Task task) {
        this.zza = task;
        Objects.requireNonNull(zzdVar);
        this.zzb = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Task task = this.zza;
        if (task.isCanceled()) {
            this.zzb.zzd().zze();
            return;
        }
        try {
            this.zzb.zzd().zza(this.zzb.zzc().then(task));
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                zzd zzdVar = this.zzb;
                zzdVar.zzd().zzc((Exception) e2.getCause());
                return;
            }
            this.zzb.zzd().zzc(e2);
        } catch (Exception e3) {
            this.zzb.zzd().zzc(e3);
        }
    }
}

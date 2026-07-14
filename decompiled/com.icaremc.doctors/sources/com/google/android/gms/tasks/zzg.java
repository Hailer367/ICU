package com.google.android.gms.tasks;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzg implements Runnable {
    final /* synthetic */ zzh zza;

    public zzg(zzh zzhVar) {
        Objects.requireNonNull(zzhVar);
        this.zza = zzhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzh zzhVar = this.zza;
        synchronized (zzhVar.zzc()) {
            try {
                if (zzhVar.zzd() != null) {
                    zzhVar.zzd().onCanceled();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

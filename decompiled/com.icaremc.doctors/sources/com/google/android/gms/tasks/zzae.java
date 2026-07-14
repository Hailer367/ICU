package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzae<T> implements zzab<T> {
    private final Object zza = new Object();
    private final int zzb;
    private final zzw zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private Exception zzg;
    private boolean zzh;

    public zzae(int i2, zzw zzwVar) {
        this.zzb = i2;
        this.zzc = zzwVar;
    }

    private final void zza() {
        int i2 = this.zzd + this.zze + this.zzf;
        int i3 = this.zzb;
        if (i2 == i3) {
            if (this.zzg != null) {
                zzw zzwVar = this.zzc;
                int i4 = this.zze;
                int length = String.valueOf(i4).length();
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + length + 8 + 24);
                sb.append(i4);
                sb.append(" out of ");
                sb.append(i3);
                sb.append(" underlying tasks failed");
                zzwVar.zzc(new ExecutionException(sb.toString(), this.zzg));
                return;
            }
            if (this.zzh) {
                this.zzc.zze();
            } else {
                this.zzc.zza(null);
            }
        }
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.zza) {
            this.zzf++;
            this.zzh = true;
            zza();
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.zza) {
            this.zze++;
            this.zzg = exc;
            zza();
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(T t2) {
        synchronized (this.zza) {
            this.zzd++;
            zza();
        }
    }
}

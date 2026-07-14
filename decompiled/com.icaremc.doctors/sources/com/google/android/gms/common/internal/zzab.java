package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzab extends com.google.android.gms.internal.common.zza implements zzad {
    public zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final boolean zze(com.google.android.gms.common.zzt zztVar, IObjectWrapper iObjectWrapper) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zztVar);
        com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
        Parcel zzB = zzB(5, zza);
        boolean zza2 = com.google.android.gms.internal.common.zzc.zza(zzB);
        zzB.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final com.google.android.gms.common.zzr zzf(com.google.android.gms.common.zzp zzpVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzpVar);
        Parcel zzB = zzB(6, zza);
        com.google.android.gms.common.zzr zzrVar = (com.google.android.gms.common.zzr) com.google.android.gms.internal.common.zzc.zzb(zzB, com.google.android.gms.common.zzr.CREATOR);
        zzB.recycle();
        return zzrVar;
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final boolean zzg() {
        Parcel zzB = zzB(7, zza());
        boolean zza = com.google.android.gms.internal.common.zzc.zza(zzB);
        zzB.recycle();
        return zza;
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final com.google.android.gms.common.zzr zzh(com.google.android.gms.common.zzp zzpVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzpVar);
        Parcel zzB = zzB(8, zza);
        com.google.android.gms.common.zzr zzrVar = (com.google.android.gms.common.zzr) com.google.android.gms.internal.common.zzc.zzb(zzB, com.google.android.gms.common.zzr.CREATOR);
        zzB.recycle();
        return zzrVar;
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final boolean zzi() {
        Parcel zzB = zzB(9, zza());
        boolean zza = com.google.android.gms.internal.common.zzc.zza(zzB);
        zzB.recycle();
        return zza;
    }
}

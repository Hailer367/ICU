package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
abstract class zzm extends zzj {
    private static final WeakReference zzb = new WeakReference(null);
    private WeakReference zza;

    public zzm(byte[] bArr) {
        super(bArr);
        this.zza = zzb;
    }

    public abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzj
    public final byte[] zzc() {
        byte[] bArr;
        synchronized (this) {
            try {
                bArr = (byte[]) this.zza.get();
                if (bArr == null) {
                    bArr = zzb();
                    this.zza = new WeakReference(bArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr;
    }
}

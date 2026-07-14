package com.google.android.play.core.appupdate.internal;

/* loaded from: classes.dex */
public final class zzad implements zzaf {
    private static final Object zza = new Object();
    private volatile zzaf zzb;
    private volatile Object zzc = zza;

    private zzad(zzaf zzafVar) {
        this.zzb = zzafVar;
    }

    public static zzaf zzb(zzaf zzafVar) {
        zzafVar.getClass();
        if (zzafVar instanceof zzad) {
            return zzafVar;
        }
        return new zzad(zzafVar);
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final Object zza() {
        Object obj;
        Object obj2 = this.zzc;
        Object obj3 = zza;
        if (obj2 == obj3) {
            synchronized (this) {
                try {
                    obj = this.zzc;
                    if (obj == obj3) {
                        obj = this.zzb.zza();
                        Object obj4 = this.zzc;
                        if (obj4 != obj3 && obj4 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                        this.zzc = obj;
                        this.zzb = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return obj;
        }
        return obj2;
    }
}

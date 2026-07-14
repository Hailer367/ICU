package com.google.android.play.core.appupdate;

/* loaded from: classes.dex */
public final class zzab {
    private zzi zza;

    private zzab() {
    }

    public final zza zza() {
        zzi zziVar = this.zza;
        if (zziVar != null) {
            return new zzz(zziVar, null);
        }
        throw new IllegalStateException(String.valueOf(zzi.class.getCanonicalName()).concat(" must be set"));
    }

    public final zzab zzb(zzi zziVar) {
        this.zza = zziVar;
        return this;
    }

    public /* synthetic */ zzab(zzaa zzaaVar) {
    }
}

package com.google.android.gms.internal.common;

/* loaded from: classes.dex */
final class zzae extends zzz {
    private final zzah zza;

    public zzae(zzah zzahVar, int i2) {
        super(zzahVar.size(), i2);
        this.zza = zzahVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    public final Object zza(int i2) {
        return this.zza.get(i2);
    }
}

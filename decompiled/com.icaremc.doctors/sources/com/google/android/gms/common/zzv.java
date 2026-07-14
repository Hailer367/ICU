package com.google.android.gms.common;

/* loaded from: classes.dex */
final class zzv {
    private String zza = null;
    private Boolean zzb = null;
    private Boolean zzc = null;

    private zzv() {
    }

    public final zzv zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzv zzb(boolean z) {
        this.zzb = Boolean.valueOf(z);
        return this;
    }

    public final zzv zzc(boolean z) {
        this.zzc = Boolean.valueOf(z);
        return this;
    }

    public final zzw zzd() {
        Boolean bool = this.zzb;
        if (bool != null) {
            if (this.zzc != null) {
                return new zzw(this.zza, bool.booleanValue(), false, false, this.zzc.booleanValue(), false, null);
            }
            throw new IllegalStateException("isGoogleOrPlatformOnly must be set");
        }
        throw new IllegalStateException("allowTestKeys must be set");
    }

    public /* synthetic */ zzv(byte[] bArr) {
    }
}

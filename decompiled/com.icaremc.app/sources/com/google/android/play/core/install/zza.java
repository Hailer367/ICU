package com.google.android.play.core.install;

/* loaded from: classes.dex */
public final class zza {

    /* renamed from: a, reason: collision with root package name */
    public final int f3395a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3396b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3397c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3398d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3399e;

    public zza(int i4, long j4, long j5, int i5, String str) {
        this.f3395a = i4;
        this.f3396b = j4;
        this.f3397c = j5;
        this.f3398d = i5;
        if (str != null) {
            this.f3399e = str;
            return;
        }
        throw new NullPointerException("Null packageName");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zza) {
            zza zzaVar = (zza) obj;
            if (this.f3395a == zzaVar.f3395a && this.f3396b == zzaVar.f3396b && this.f3397c == zzaVar.f3397c && this.f3398d == zzaVar.f3398d && this.f3399e.equals(zzaVar.f3399e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.f3395a ^ 1000003;
        long j4 = this.f3396b;
        long j5 = this.f3397c;
        return (((((((i4 * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003) ^ this.f3398d) * 1000003) ^ this.f3399e.hashCode();
    }

    public final String toString() {
        return "InstallState{installStatus=" + this.f3395a + ", bytesDownloaded=" + this.f3396b + ", totalBytesToDownload=" + this.f3397c + ", installErrorCode=" + this.f3398d + ", packageName=" + this.f3399e + "}";
    }
}

package com.google.android.gms.internal.common;

import O.a;

/* loaded from: classes.dex */
public final class zzr {
    public static void zza(boolean z) {
        if (z) {
        } else {
            throw new IllegalStateException();
        }
    }

    public static int zzb(int i2, int i3, String str) {
        String zza;
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        if (i2 >= 0) {
            if (i3 < 0) {
                throw new IllegalArgumentException(a.h(new StringBuilder(String.valueOf(i3).length() + 15), "negative size: ", i3));
            }
            zza = zzx.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            zza = zzx.zza("%s (%s) must not be negative", "index", Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzc(int i2, int i3, String str) {
        if (i2 >= 0 && i2 <= i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(zze(i2, i3, "index"));
    }

    public static void zzd(int i2, int i3, int i4) {
        String zze;
        if (i2 >= 0 && i3 >= i2 && i3 <= i4) {
            return;
        }
        if (i2 >= 0 && i2 <= i4) {
            if (i3 >= 0 && i3 <= i4) {
                zze = zzx.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
            } else {
                zze = zze(i3, i4, "end index");
            }
        } else {
            zze = zze(i2, i4, "start index");
        }
        throw new IndexOutOfBoundsException(zze);
    }

    private static String zze(int i2, int i3, String str) {
        if (i2 < 0) {
            return zzx.zza("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return zzx.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException(a.h(new StringBuilder(String.valueOf(i3).length() + 15), "negative size: ", i3));
    }
}

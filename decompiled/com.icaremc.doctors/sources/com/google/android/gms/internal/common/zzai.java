package com.google.android.gms.internal.common;

import O.a;

/* loaded from: classes.dex */
public final class zzai {
    public static Object[] zza(Object[] objArr, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (objArr[i3] == null) {
                throw new NullPointerException(a.h(new StringBuilder(String.valueOf(i3).length() + 9), "at index ", i3));
            }
        }
        return objArr;
    }
}

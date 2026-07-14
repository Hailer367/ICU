package com.google.android.gms.internal.common;

import java.util.Objects;

/* loaded from: classes.dex */
public final class zzq {
    public static final CharSequence zza(Object obj, String str) {
        Objects.requireNonNull(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }
}

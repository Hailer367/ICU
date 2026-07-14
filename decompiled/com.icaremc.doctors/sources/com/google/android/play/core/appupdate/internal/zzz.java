package com.google.android.play.core.appupdate.internal;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzz {
    public static Context zza(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            return applicationContext;
        }
        return context;
    }
}

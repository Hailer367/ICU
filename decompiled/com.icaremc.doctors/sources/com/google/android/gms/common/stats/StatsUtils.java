package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.encoders.json.BuildConfig;

@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public class StatsUtils {
    @KeepForSdk
    public static String getEventKey(PowerManager.WakeLock wakeLock, String str) {
        String valueOf = String.valueOf((Process.myPid() << 32) | System.identityHashCode(wakeLock));
        if (true == TextUtils.isEmpty(str)) {
            str = BuildConfig.FLAVOR;
        }
        return String.valueOf(valueOf).concat(String.valueOf(str));
    }
}

package com.dexterous.flutterlocalnotifications.utils;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class StringUtils {
    public static Boolean isNullOrEmpty(String str) {
        boolean z;
        if (str != null && !str.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}

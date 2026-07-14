package com.dexterous.flutterlocalnotifications.utils;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class BooleanUtils {
    public static boolean getValue(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }
}

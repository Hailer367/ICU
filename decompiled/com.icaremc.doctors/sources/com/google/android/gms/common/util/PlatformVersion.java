package com.google.android.gms.common.util;

import A.c;
import android.os.Build;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Locale;
import kotlin.jvm.internal.h;

@KeepForSdk
/* loaded from: classes.dex */
public final class PlatformVersion {
    private PlatformVersion() {
    }

    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastHoneycomb() {
        return true;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastHoneycombMR1() {
        return true;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastIceCreamSandwich() {
        return true;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastIceCreamSandwichMR1() {
        return true;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastJellyBean() {
        return true;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastJellyBeanMR1() {
        return true;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastJellyBeanMR2() {
        return true;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastKitKat() {
        return true;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastKitKatWatch() {
        return true;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastLollipop() {
        return true;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastLollipopMR1() {
        return true;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastM() {
        return true;
    }

    @KeepForSdk
    public static boolean isAtLeastN() {
        return true;
    }

    @KeepForSdk
    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @KeepForSdk
    public static boolean isAtLeastP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @KeepForSdk
    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @KeepForSdk
    public static boolean isAtLeastR() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @KeepForSdk
    public static boolean isAtLeastS() {
        return Build.VERSION.SDK_INT >= 31;
    }

    @KeepForSdk
    public static boolean isAtLeastSv2() {
        return Build.VERSION.SDK_INT >= 32;
    }

    @KeepForSdk
    public static boolean isAtLeastT() {
        return Build.VERSION.SDK_INT >= 33;
    }

    @KeepForSdk
    public static boolean isAtLeastU() {
        return Build.VERSION.SDK_INT >= 34;
    }

    @KeepForSdk
    public static boolean isAtLeastV() {
        Integer num;
        Integer num2 = 0;
        int i2 = c.f0a;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 35) {
            if (i3 >= 34) {
                String CODENAME = Build.VERSION.CODENAME;
                h.d(CODENAME, "CODENAME");
                if (!"REL".equals(CODENAME)) {
                    Locale locale = Locale.ROOT;
                    String upperCase = CODENAME.toUpperCase(locale);
                    h.d(upperCase, "toUpperCase(...)");
                    if (upperCase.equals("BAKLAVA")) {
                        num = num2;
                    } else {
                        num = null;
                    }
                    String upperCase2 = "VanillaIceCream".toUpperCase(locale);
                    h.d(upperCase2, "toUpperCase(...)");
                    if (!upperCase2.equals("BAKLAVA")) {
                        num2 = null;
                    }
                    if (num != null && num2 != null) {
                        if (num.intValue() >= num2.intValue()) {
                            return true;
                        }
                    } else if (num == null && num2 == null) {
                        String upperCase3 = CODENAME.toUpperCase(locale);
                        h.d(upperCase3, "toUpperCase(...)");
                        String upperCase4 = "VanillaIceCream".toUpperCase(locale);
                        h.d(upperCase4, "toUpperCase(...)");
                        if (upperCase3.compareTo(upperCase4) >= 0) {
                            return true;
                        }
                    } else if (num != null) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}

package com.pichillilorenzo.flutter_inappwebview_android.types;

import A2.i;

/* loaded from: classes.dex */
public enum PreferredContentModeOptionType {
    RECOMMENDED(0),
    MOBILE(1),
    DESKTOP(2);

    private final int value;

    PreferredContentModeOptionType(int i4) {
        this.value = i4;
    }

    public static PreferredContentModeOptionType fromValue(int i4) {
        for (PreferredContentModeOptionType preferredContentModeOptionType : values()) {
            if (i4 == preferredContentModeOptionType.toValue()) {
                return preferredContentModeOptionType;
            }
        }
        throw new IllegalArgumentException(i.g(i4, "No enum constant: "));
    }

    public boolean equalsValue(int i4) {
        if (this.value == i4) {
            return true;
        }
        return false;
    }

    public int toValue() {
        return this.value;
    }
}

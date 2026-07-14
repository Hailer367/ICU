package com.pichillilorenzo.flutter_inappwebview_android.types;

import A2.i;

/* loaded from: classes.dex */
public enum NavigationActionPolicy {
    CANCEL(0),
    ALLOW(1);

    private final int value;

    NavigationActionPolicy(int i4) {
        this.value = i4;
    }

    public static NavigationActionPolicy fromValue(int i4) {
        for (NavigationActionPolicy navigationActionPolicy : values()) {
            if (i4 == navigationActionPolicy.value) {
                return navigationActionPolicy;
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

    public int rawValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.value);
    }
}

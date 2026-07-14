package com.pichillilorenzo.flutter_inappwebview_android.types;

import A2.i;

/* loaded from: classes.dex */
public enum UserScriptInjectionTime {
    AT_DOCUMENT_START(0),
    AT_DOCUMENT_END(1);

    private final int value;

    UserScriptInjectionTime(int i4) {
        this.value = i4;
    }

    public static UserScriptInjectionTime fromValue(int i4) {
        for (UserScriptInjectionTime userScriptInjectionTime : values()) {
            if (i4 == userScriptInjectionTime.toValue()) {
                return userScriptInjectionTime;
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

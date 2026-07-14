package com.google.firebase.platforminfo;

import Q0.b;

/* loaded from: classes.dex */
public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            b.f712d.getClass();
            return "2.2.20";
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}

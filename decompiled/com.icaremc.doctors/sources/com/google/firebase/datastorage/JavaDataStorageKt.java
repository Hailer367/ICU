package com.google.firebase.datastorage;

import O.e;
import O.g;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class JavaDataStorageKt {
    public static final <T> T getOrDefault(g gVar, e key, T t2) {
        h.e(gVar, "<this>");
        h.e(key, "key");
        T t3 = (T) gVar.b(key);
        if (t3 == null) {
            return t2;
        }
        return t3;
    }
}

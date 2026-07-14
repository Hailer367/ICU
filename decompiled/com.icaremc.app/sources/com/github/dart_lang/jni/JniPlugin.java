package com.github.dart_lang.jni;

import o2.b;
import o2.c;

/* loaded from: classes.dex */
public class JniPlugin implements c {
    static {
        System.loadLibrary("dartjni");
        setClassLoader(JniPlugin.class.getClassLoader());
    }

    public static native void setClassLoader(ClassLoader classLoader);

    @Override // o2.c
    public void onAttachedToEngine(b bVar) {
    }

    @Override // o2.c
    public void onDetachedFromEngine(b bVar) {
    }
}

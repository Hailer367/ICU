package com.github.dart_lang.jni;

/* loaded from: classes.dex */
public class JniUtils {
    static {
        System.loadLibrary("dartjni");
    }

    public static native Object fromReferenceAddress(long j2);
}

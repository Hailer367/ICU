package com.github.dart_lang.jni;

import K2.d;
import K2.i;
import b3.A;
import i3.e;

/* loaded from: classes.dex */
public class PortContinuation<T> implements d {
    private final long port;

    static {
        System.loadLibrary("dartjni");
    }

    public PortContinuation(long j4) {
        this.port = j4;
    }

    private native void _resumeWith(long j4, Object obj);

    @Override // K2.d
    public i getContext() {
        e eVar = A.f3236a;
        return i3.d.f4172h;
    }

    @Override // K2.d
    public void resumeWith(Object obj) {
        _resumeWith(this.port, obj);
    }
}

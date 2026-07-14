package com.github.dart_lang.jni;

import T0.d;
import T0.i;
import l1.C;
import s1.e;

/* loaded from: classes.dex */
public class PortContinuation<T> implements d {
    private final long port;

    static {
        System.loadLibrary("dartjni");
    }

    public PortContinuation(long j2) {
        this.port = j2;
    }

    private native void _resumeWith(long j2, Object obj);

    @Override // T0.d
    public i getContext() {
        e eVar = C.f2950a;
        return s1.d.f3615e;
    }

    @Override // T0.d
    public void resumeWith(Object obj) {
        _resumeWith(this.port, obj);
    }
}

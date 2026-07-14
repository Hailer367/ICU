package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2048a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultHeartBeatController f2049b;

    public /* synthetic */ b(DefaultHeartBeatController defaultHeartBeatController, int i2) {
        this.f2048a = i2;
        this.f2049b = defaultHeartBeatController;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f2048a) {
            case 0:
                return DefaultHeartBeatController.a(this.f2049b);
            default:
                return DefaultHeartBeatController.d(this.f2049b);
        }
    }
}

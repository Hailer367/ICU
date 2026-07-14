package io.flutter.view;

import android.view.Choreographer;

/* loaded from: classes.dex */
public final class s implements Choreographer.FrameCallback {

    /* renamed from: a, reason: collision with root package name */
    public long f4544a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f4545b;

    public s(t tVar, long j4) {
        this.f4545b = tVar;
        this.f4544a = j4;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j4) {
        long j5;
        long nanoTime = System.nanoTime() - j4;
        if (nanoTime < 0) {
            j5 = 0;
        } else {
            j5 = nanoTime;
        }
        t tVar = this.f4545b;
        tVar.f4549b.onVsync(j5, tVar.f4548a, this.f4544a);
        tVar.f4550c = this;
    }
}

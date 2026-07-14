package io.flutter.embedding.engine.renderer;

import io.flutter.embedding.engine.FlutterJNI;

/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final long f4210f;

    /* renamed from: g, reason: collision with root package name */
    public final FlutterJNI f4211g;

    public h(long j4, FlutterJNI flutterJNI) {
        this.f4210f = j4;
        this.f4211g = flutterJNI;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlutterJNI flutterJNI = this.f4211g;
        if (!flutterJNI.isAttached()) {
            return;
        }
        flutterJNI.unregisterTexture(this.f4210f);
    }
}

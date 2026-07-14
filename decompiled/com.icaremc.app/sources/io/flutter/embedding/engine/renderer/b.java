package io.flutter.embedding.engine.renderer;

import io.flutter.view.q;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4195f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q f4196g;

    public /* synthetic */ b(q qVar, int i4) {
        this.f4195f = i4;
        this.f4196g = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4195f) {
            case 0:
                FlutterRenderer$ImageReaderSurfaceProducer.a((FlutterRenderer$ImageReaderSurfaceProducer) this.f4196g);
                return;
            default:
                ((g) this.f4196g).getClass();
                return;
        }
    }
}

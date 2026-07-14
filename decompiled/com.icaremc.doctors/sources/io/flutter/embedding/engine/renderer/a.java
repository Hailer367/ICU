package io.flutter.embedding.engine.renderer;

import io.flutter.embedding.engine.renderer.FlutterRenderer;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2380c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2381d;

    public /* synthetic */ a(int i2, Object obj) {
        this.f2380c = i2;
        this.f2381d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2380c) {
            case 0:
                FlutterRenderer.ImageReaderSurfaceProducer.a((FlutterRenderer.ImageReaderSurfaceProducer) this.f2381d);
                return;
            default:
                FlutterRenderer.SurfaceTextureRegistryEntry.b((FlutterRenderer.SurfaceTextureRegistryEntry) this.f2381d);
                return;
        }
    }
}

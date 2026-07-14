package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry$GLTextureConsumer;
import io.flutter.view.TextureRegistry$SurfaceProducer;
import io.flutter.view.r;

/* loaded from: classes.dex */
public final class n implements TextureRegistry$SurfaceProducer, TextureRegistry$GLTextureConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final long f4241a;

    /* renamed from: b, reason: collision with root package name */
    public int f4242b;

    /* renamed from: c, reason: collision with root package name */
    public int f4243c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4244d;

    /* renamed from: e, reason: collision with root package name */
    public Surface f4245e;

    /* renamed from: f, reason: collision with root package name */
    public final g f4246f;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f4247g;

    /* renamed from: h, reason: collision with root package name */
    public final FlutterJNI f4248h;

    public n(long j4, Handler handler, FlutterJNI flutterJNI, g gVar) {
        this.f4241a = j4;
        this.f4247g = handler;
        this.f4248h = flutterJNI;
        this.f4246f = gVar;
    }

    public final void finalize() {
        try {
            if (this.f4244d) {
                return;
            }
            release();
            this.f4247g.post(new h(this.f4241a, this.f4248h));
        } finally {
            super.finalize();
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final Surface getForcedNewSurface() {
        this.f4245e = null;
        return getSurface();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final int getHeight() {
        return this.f4243c;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final Surface getSurface() {
        Surface surface = this.f4245e;
        if (surface == null || !surface.isValid()) {
            this.f4245e = new Surface(this.f4246f.f4206b.surfaceTexture());
        }
        return this.f4245e;
    }

    @Override // io.flutter.view.TextureRegistry$GLTextureConsumer
    public final SurfaceTexture getSurfaceTexture() {
        return this.f4246f.f4206b.surfaceTexture();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final int getWidth() {
        return this.f4242b;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final boolean handlesCropAndRotation() {
        return true;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final long id() {
        return this.f4241a;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final void release() {
        this.f4246f.release();
        this.f4245e.release();
        this.f4245e = null;
        this.f4244d = true;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final void scheduleFrame() {
        this.f4248h.markTextureFrameAvailable(this.f4241a);
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final void setCallback(r rVar) {
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final void setSize(int i4, int i5) {
        this.f4242b = i4;
        this.f4243c = i5;
        this.f4246f.f4206b.surfaceTexture().setDefaultBufferSize(i4, i5);
    }
}

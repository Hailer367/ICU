package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry$SurfaceTextureEntry;
import io.flutter.view.p;
import io.flutter.view.q;

/* loaded from: classes.dex */
public final class g implements TextureRegistry$SurfaceTextureEntry, q {

    /* renamed from: a, reason: collision with root package name */
    public final long f4205a;

    /* renamed from: b, reason: collision with root package name */
    public final SurfaceTextureWrapper f4206b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4207c;

    /* renamed from: d, reason: collision with root package name */
    public q f4208d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j f4209e;

    public g(j jVar, long j4, SurfaceTexture surfaceTexture) {
        this.f4209e = jVar;
        this.f4205a = j4;
        SurfaceTextureWrapper surfaceTextureWrapper = new SurfaceTextureWrapper(surfaceTexture, new b(this, 1));
        this.f4206b = surfaceTextureWrapper;
        surfaceTextureWrapper.surfaceTexture().setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.embedding.engine.renderer.f
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                g gVar = g.this;
                FlutterJNI flutterJNI = gVar.f4209e.f4233a;
                if (!gVar.f4207c && flutterJNI.isAttached()) {
                    gVar.f4206b.markDirty();
                    flutterJNI.scheduleFrame();
                }
            }
        }, new Handler());
    }

    public final void finalize() {
        try {
            if (this.f4207c) {
                return;
            }
            j jVar = this.f4209e;
            jVar.f4237e.post(new h(this.f4205a, jVar.f4233a));
        } finally {
            super.finalize();
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceTextureEntry
    public final long id() {
        return this.f4205a;
    }

    @Override // io.flutter.view.q
    public final void onTrimMemory(int i4) {
        q qVar = this.f4208d;
        if (qVar != null) {
            qVar.onTrimMemory(i4);
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceTextureEntry
    public final void release() {
        if (this.f4207c) {
            return;
        }
        this.f4206b.release();
        long j4 = this.f4205a;
        j jVar = this.f4209e;
        jVar.f4233a.unregisterTexture(j4);
        jVar.h(this);
        this.f4207c = true;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceTextureEntry
    public final void setOnFrameConsumedListener(p pVar) {
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceTextureEntry
    public final void setOnTrimMemoryListener(q qVar) {
        this.f4208d = qVar;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceTextureEntry
    public final SurfaceTexture surfaceTexture() {
        return this.f4206b.surfaceTexture();
    }
}

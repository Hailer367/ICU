package io.flutter.plugin.platform;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* loaded from: classes.dex */
public final class z implements i {

    /* renamed from: f, reason: collision with root package name */
    public final io.flutter.embedding.engine.renderer.g f4404f;

    /* renamed from: g, reason: collision with root package name */
    public SurfaceTexture f4405g;

    /* renamed from: h, reason: collision with root package name */
    public Surface f4406h;

    /* renamed from: i, reason: collision with root package name */
    public int f4407i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f4408j = 0;
    public boolean k = false;

    public z(io.flutter.embedding.engine.renderer.g gVar) {
        y yVar = new y(this);
        this.f4404f = gVar;
        this.f4405g = gVar.f4206b.surfaceTexture();
        gVar.f4208d = yVar;
    }

    @Override // io.flutter.plugin.platform.i
    public final void b(int i4, int i5) {
        this.f4407i = i4;
        this.f4408j = i5;
        SurfaceTexture surfaceTexture = this.f4405g;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i4, i5);
        }
    }

    @Override // io.flutter.plugin.platform.i
    public final int getHeight() {
        return this.f4408j;
    }

    @Override // io.flutter.plugin.platform.i
    public final long getId() {
        return this.f4404f.f4205a;
    }

    @Override // io.flutter.plugin.platform.i
    public final Surface getSurface() {
        boolean isReleased;
        Surface surface = this.f4406h;
        if (surface == null || this.k) {
            if (surface != null) {
                surface.release();
                this.f4406h = null;
            }
            this.f4406h = new Surface(this.f4405g);
            this.k = false;
        }
        SurfaceTexture surfaceTexture = this.f4405g;
        if (surfaceTexture != null) {
            isReleased = surfaceTexture.isReleased();
            if (!isReleased) {
                return this.f4406h;
            }
        }
        return null;
    }

    @Override // io.flutter.plugin.platform.i
    public final int getWidth() {
        return this.f4407i;
    }

    @Override // io.flutter.plugin.platform.i
    public final void release() {
        this.f4405g = null;
        Surface surface = this.f4406h;
        if (surface != null) {
            surface.release();
            this.f4406h = null;
        }
    }
}

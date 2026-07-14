package h2;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;

/* loaded from: classes.dex */
public final class j implements TextureView.SurfaceTextureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f4003a;

    public j(k kVar) {
        this.f4003a = kVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
        k kVar = this.f4003a;
        kVar.f4004f = true;
        if (kVar.f4006h != null && !kVar.f4005g) {
            kVar.e();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        k kVar = this.f4003a;
        kVar.f4004f = false;
        io.flutter.embedding.engine.renderer.j jVar = kVar.f4006h;
        if (jVar != null && !kVar.f4005g) {
            if (jVar != null) {
                jVar.j();
                Surface surface = kVar.f4007i;
                if (surface != null) {
                    surface.release();
                    kVar.f4007i = null;
                }
            } else {
                throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
            }
        }
        Surface surface2 = kVar.f4007i;
        if (surface2 != null) {
            surface2.release();
            kVar.f4007i = null;
            return true;
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
        k kVar = this.f4003a;
        io.flutter.embedding.engine.renderer.j jVar = kVar.f4006h;
        if (jVar != null && !kVar.f4005g) {
            if (jVar != null) {
                jVar.f4233a.onSurfaceChanged(i4, i5);
                return;
            }
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

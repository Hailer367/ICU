package h2;

import android.view.SurfaceHolder;

/* renamed from: h2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class SurfaceHolderCallbackC0355h implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0356i f3997a;

    public SurfaceHolderCallbackC0355h(C0356i c0356i) {
        this.f3997a = c0356i;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        C0356i c0356i = this.f3997a;
        io.flutter.embedding.engine.renderer.j jVar = c0356i.f4000h;
        if (jVar != null && !c0356i.f3999g) {
            if (jVar != null) {
                jVar.f4233a.onSurfaceChanged(i5, i6);
                return;
            }
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        C0356i c0356i = this.f3997a;
        c0356i.f3998f = true;
        if (c0356i.f4000h != null && !c0356i.f3999g) {
            c0356i.e();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C0356i c0356i = this.f3997a;
        c0356i.f3998f = false;
        io.flutter.embedding.engine.renderer.j jVar = c0356i.f4000h;
        if (jVar != null && !c0356i.f3999g) {
            if (jVar != null) {
                jVar.j();
                return;
            }
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
    }
}

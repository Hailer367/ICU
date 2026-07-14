package h2;

import android.os.Build;
import android.view.SurfaceHolder;

/* renamed from: h2.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class SurfaceHolderCallback2C0347G implements SurfaceHolder.Callback2 {

    /* renamed from: a, reason: collision with root package name */
    public final C0356i f3960a;

    /* renamed from: b, reason: collision with root package name */
    public io.flutter.embedding.engine.renderer.j f3961b;

    /* renamed from: c, reason: collision with root package name */
    public final SurfaceHolderCallbackC0355h f3962c;

    /* renamed from: d, reason: collision with root package name */
    public final C0350c f3963d = new C0350c(2, this);

    /* renamed from: e, reason: collision with root package name */
    public final C0346F f3964e;

    public SurfaceHolderCallback2C0347G(SurfaceHolderCallbackC0355h surfaceHolderCallbackC0355h, C0356i c0356i, io.flutter.embedding.engine.renderer.j jVar) {
        boolean z;
        C0346F c0346f;
        if (Build.VERSION.SDK_INT < 26) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            c0346f = new C0346F(this, 1);
        } else {
            c0346f = new C0346F(this, 0);
        }
        this.f3964e = c0346f;
        this.f3962c = surfaceHolderCallbackC0355h;
        this.f3961b = jVar;
        this.f3960a = c0356i;
        if (z) {
            c0356i.setAlpha(0.0f);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        SurfaceHolderCallbackC0355h surfaceHolderCallbackC0355h = this.f3962c;
        if (surfaceHolderCallbackC0355h != null) {
            surfaceHolderCallbackC0355h.surfaceChanged(surfaceHolder, i4, i5, i6);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceHolderCallbackC0355h surfaceHolderCallbackC0355h = this.f3962c;
        if (surfaceHolderCallbackC0355h != null) {
            surfaceHolderCallbackC0355h.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceHolderCallbackC0355h surfaceHolderCallbackC0355h = this.f3962c;
        if (surfaceHolderCallbackC0355h != null) {
            surfaceHolderCallbackC0355h.surfaceDestroyed(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public final void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        io.flutter.embedding.engine.renderer.j jVar = this.f3961b;
        if (jVar == null) {
            return;
        }
        jVar.a(new C0345E(this, runnable));
    }

    @Override // android.view.SurfaceHolder.Callback2
    public final void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }
}

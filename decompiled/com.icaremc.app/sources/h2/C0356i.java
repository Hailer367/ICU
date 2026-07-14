package h2;

import android.graphics.Region;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import io.flutter.embedding.engine.FlutterJNI;
import q1.AbstractC0602b;

/* renamed from: h2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0356i extends SurfaceView implements io.flutter.embedding.engine.renderer.m {

    /* renamed from: f, reason: collision with root package name */
    public boolean f3998f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3999g;

    /* renamed from: h, reason: collision with root package name */
    public io.flutter.embedding.engine.renderer.j f4000h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f4001i;

    /* renamed from: j, reason: collision with root package name */
    public final SurfaceHolderCallback2C0347G f4002j;

    public C0356i(AbstractActivityC0349b abstractActivityC0349b, boolean z) {
        super(abstractActivityC0349b, null);
        this.f3998f = false;
        this.f3999g = false;
        this.f4001i = false;
        SurfaceHolderCallback2C0347G surfaceHolderCallback2C0347G = new SurfaceHolderCallback2C0347G(new SurfaceHolderCallbackC0355h(this), this, this.f4000h);
        this.f4002j = surfaceHolderCallback2C0347G;
        if (z) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        this.f4001i = AbstractC0602b.I(getContext());
        getHolder().addCallback(surfaceHolderCallback2C0347G);
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void a() {
        if (this.f4000h != null) {
            if (getWindowToken() != null) {
                io.flutter.embedding.engine.renderer.j jVar = this.f4000h;
                if (jVar != null) {
                    jVar.j();
                } else {
                    throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
                }
            }
            C0346F c0346f = this.f4002j.f3964e;
            switch (c0346f.f3958a) {
                case 0:
                    c0346f.f3959b.f3961b = null;
                    break;
                default:
                    SurfaceHolderCallback2C0347G surfaceHolderCallback2C0347G = c0346f.f3959b;
                    surfaceHolderCallback2C0347G.f3960a.setAlpha(0.0f);
                    io.flutter.embedding.engine.renderer.j jVar2 = surfaceHolderCallback2C0347G.f3961b;
                    if (jVar2 != null) {
                        jVar2.g(surfaceHolderCallback2C0347G.f3963d);
                    }
                    surfaceHolderCallback2C0347G.f3961b = null;
                    break;
            }
            this.f4000h = null;
            return;
        }
        Log.w("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void b() {
        if (this.f4000h == null) {
            Log.w("FlutterSurfaceView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        C0346F c0346f = this.f4002j.f3964e;
        switch (c0346f.f3958a) {
            case 0:
                break;
            default:
                SurfaceHolderCallback2C0347G surfaceHolderCallback2C0347G = c0346f.f3959b;
                io.flutter.embedding.engine.renderer.j jVar = surfaceHolderCallback2C0347G.f3961b;
                if (jVar != null) {
                    jVar.a(surfaceHolderCallback2C0347G.f3963d);
                    break;
                }
                break;
        }
        if (this.f3998f) {
            e();
        }
        this.f3999g = false;
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void c(io.flutter.embedding.engine.renderer.j jVar) {
        io.flutter.embedding.engine.renderer.j jVar2 = this.f4000h;
        if (jVar2 != null) {
            jVar2.j();
        }
        this.f4000h = jVar;
        C0346F c0346f = this.f4002j.f3964e;
        switch (c0346f.f3958a) {
            case 0:
                c0346f.f3959b.f3961b = jVar;
                break;
            default:
                SurfaceHolderCallback2C0347G surfaceHolderCallback2C0347G = c0346f.f3959b;
                io.flutter.embedding.engine.renderer.j jVar3 = surfaceHolderCallback2C0347G.f3961b;
                if (jVar3 != null) {
                    jVar3.g(surfaceHolderCallback2C0347G.f3963d);
                }
                surfaceHolderCallback2C0347G.f3961b = jVar;
                break;
        }
        b();
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void d() {
        if (this.f4000h == null) {
            Log.w("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.f3999g = true;
        }
    }

    public final void e() {
        if (this.f4000h != null && getHolder() != null) {
            io.flutter.embedding.engine.renderer.j jVar = this.f4000h;
            Surface surface = getHolder().getSurface();
            boolean z = this.f3999g;
            FlutterJNI flutterJNI = jVar.f4233a;
            if (!z) {
                jVar.j();
            }
            jVar.f4235c = surface;
            if (z) {
                flutterJNI.onSurfaceWindowChanged(surface);
                return;
            } else {
                flutterJNI.onSurfaceCreated(surface);
                return;
            }
        }
        throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
    }

    @Override // android.view.SurfaceView, android.view.View
    public final boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i4 = iArr[0];
        region.op(i4, iArr[1], (getRight() + i4) - getLeft(), (getBottom() + iArr[1]) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public io.flutter.embedding.engine.renderer.j getAttachedRenderer() {
        return this.f4000h;
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        if (this.f4001i) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            int mode2 = View.MeasureSpec.getMode(i5);
            int size2 = View.MeasureSpec.getSize(i5);
            int i7 = 0;
            if (mode2 == 0) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            int max = Math.max(size2, i6);
            if (mode == 0) {
                i7 = 1;
            }
            setMeasuredDimension(Math.max(size, i7), max);
            return;
        }
        super.onMeasure(i4, i5);
    }
}

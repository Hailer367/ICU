package h2;

import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import io.flutter.embedding.engine.FlutterJNI;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class k extends TextureView implements io.flutter.embedding.engine.renderer.m {

    /* renamed from: f, reason: collision with root package name */
    public boolean f4004f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4005g;

    /* renamed from: h, reason: collision with root package name */
    public io.flutter.embedding.engine.renderer.j f4006h;

    /* renamed from: i, reason: collision with root package name */
    public Surface f4007i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f4008j;

    public k(AbstractActivityC0349b abstractActivityC0349b) {
        super(abstractActivityC0349b, null);
        this.f4004f = false;
        this.f4005g = false;
        this.f4008j = false;
        setSurfaceTextureListener(new j(this));
        this.f4008j = AbstractC0602b.I(getContext());
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void a() {
        if (this.f4006h != null) {
            if (getWindowToken() != null) {
                io.flutter.embedding.engine.renderer.j jVar = this.f4006h;
                if (jVar != null) {
                    jVar.j();
                    Surface surface = this.f4007i;
                    if (surface != null) {
                        surface.release();
                        this.f4007i = null;
                    }
                } else {
                    throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
                }
            }
            this.f4006h = null;
            return;
        }
        Log.w("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void b() {
        if (this.f4006h == null) {
            Log.w("FlutterTextureView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (this.f4004f) {
            e();
        }
        this.f4005g = false;
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void c(io.flutter.embedding.engine.renderer.j jVar) {
        io.flutter.embedding.engine.renderer.j jVar2 = this.f4006h;
        if (jVar2 != null) {
            jVar2.j();
        }
        this.f4006h = jVar;
        b();
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void d() {
        if (this.f4006h == null) {
            Log.w("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.f4005g = true;
        }
    }

    public final void e() {
        if (this.f4006h != null && getSurfaceTexture() != null) {
            Surface surface = this.f4007i;
            if (surface != null) {
                surface.release();
                this.f4007i = null;
            }
            Surface surface2 = new Surface(getSurfaceTexture());
            this.f4007i = surface2;
            io.flutter.embedding.engine.renderer.j jVar = this.f4006h;
            boolean z = this.f4005g;
            FlutterJNI flutterJNI = jVar.f4233a;
            if (!z) {
                jVar.j();
            }
            jVar.f4235c = surface2;
            if (z) {
                flutterJNI.onSurfaceWindowChanged(surface2);
                return;
            } else {
                flutterJNI.onSurfaceCreated(surface2);
                return;
            }
        }
        throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public io.flutter.embedding.engine.renderer.j getAttachedRenderer() {
        return this.f4006h;
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        if (this.f4008j) {
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

    public void setRenderSurface(Surface surface) {
        this.f4007i = surface;
    }
}

package h2;

import android.os.Build;
import java.util.Iterator;

/* renamed from: h2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0350c implements io.flutter.embedding.engine.renderer.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3976a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3977b;

    public /* synthetic */ C0350c(int i4, Object obj) {
        this.f3976a = i4;
        this.f3977b = obj;
    }

    @Override // io.flutter.embedding.engine.renderer.k
    public final void a() {
        switch (this.f3976a) {
            case 0:
                C0353f c0353f = (C0353f) this.f3977b;
                c0353f.f3980a.getClass();
                c0353f.f3987h = false;
                return;
            case 1:
                p pVar = (p) this.f3977b;
                pVar.f4030n = false;
                Iterator it = pVar.f4029m.iterator();
                while (it.hasNext()) {
                    ((io.flutter.embedding.engine.renderer.k) it.next()).a();
                }
                return;
            case 2:
                return;
            default:
                ((io.flutter.embedding.engine.renderer.j) this.f3977b).f4236d = false;
                return;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.k
    public final void b() {
        switch (this.f3976a) {
            case 0:
                C0353f c0353f = (C0353f) this.f3977b;
                AbstractActivityC0349b abstractActivityC0349b = c0353f.f3980a;
                if (Build.VERSION.SDK_INT >= 29) {
                    abstractActivityC0349b.reportFullyDrawn();
                } else {
                    abstractActivityC0349b.getClass();
                }
                c0353f.f3987h = true;
                c0353f.f3988i = true;
                return;
            case 1:
                p pVar = (p) this.f3977b;
                pVar.f4030n = true;
                Iterator it = pVar.f4029m.iterator();
                while (it.hasNext()) {
                    ((io.flutter.embedding.engine.renderer.k) it.next()).b();
                }
                return;
            case 2:
                SurfaceHolderCallback2C0347G surfaceHolderCallback2C0347G = (SurfaceHolderCallback2C0347G) this.f3977b;
                surfaceHolderCallback2C0347G.f3960a.setAlpha(1.0f);
                io.flutter.embedding.engine.renderer.j jVar = surfaceHolderCallback2C0347G.f3961b;
                if (jVar != null) {
                    jVar.g(this);
                    return;
                }
                return;
            default:
                ((io.flutter.embedding.engine.renderer.j) this.f3977b).f4236d = true;
                return;
        }
    }

    private final void c() {
    }
}

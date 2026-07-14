package t1;

import Q0.j;
import c1.q;
import l1.C0229g;
import l1.C0230h;
import l1.InterfaceC0228f;
import l1.j0;
import q1.r;

/* loaded from: classes.dex */
public final class b implements InterfaceC0228f, j0 {

    /* renamed from: c, reason: collision with root package name */
    public final C0230h f3654c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f3655d;

    public b(c cVar, C0230h c0230h) {
        this.f3655d = cVar;
        this.f3654c = c0230h;
    }

    @Override // l1.j0
    public final void a(r rVar, int i2) {
        this.f3654c.a(rVar, i2);
    }

    @Override // l1.InterfaceC0228f
    public final F.h f(Object obj, q qVar) {
        c cVar = this.f3655d;
        C0229g c0229g = new C0229g(cVar, this);
        F.h f2 = this.f3654c.f((j) obj, c0229g);
        if (f2 != null) {
            c.f3656g.set(cVar, null);
        }
        return f2;
    }

    @Override // T0.d
    public final T0.i getContext() {
        return this.f3654c.f2994g;
    }

    @Override // l1.InterfaceC0228f
    public final void j(Object obj) {
        this.f3654c.j(obj);
    }

    @Override // T0.d
    public final void resumeWith(Object obj) {
        this.f3654c.resumeWith(obj);
    }
}

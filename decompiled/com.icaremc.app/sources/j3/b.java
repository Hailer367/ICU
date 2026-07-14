package j3;

import S2.q;
import b3.C0231f;
import b3.C0232g;
import b3.InterfaceC0230e;
import b3.i0;
import g3.r;

/* loaded from: classes.dex */
public final class b implements InterfaceC0230e, i0 {

    /* renamed from: f, reason: collision with root package name */
    public final C0232g f5087f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c f5088g;

    public b(c cVar, C0232g c0232g) {
        this.f5088g = cVar;
        this.f5087f = c0232g;
    }

    @Override // b3.i0
    public final void a(r rVar, int i4) {
        this.f5087f.a(rVar, i4);
    }

    @Override // K2.d
    public final K2.i getContext() {
        return this.f5087f.f3277j;
    }

    @Override // b3.InterfaceC0230e
    public final R1.c h(Object obj, q qVar) {
        c cVar = this.f5088g;
        C0231f c0231f = new C0231f(cVar, this);
        R1.c h3 = this.f5087f.h((H2.i) obj, c0231f);
        if (h3 != null) {
            c.f5089g.set(cVar, null);
        }
        return h3;
    }

    @Override // b3.InterfaceC0230e
    public final void l(Object obj) {
        this.f5087f.l(obj);
    }

    @Override // K2.d
    public final void resumeWith(Object obj) {
        this.f5087f.resumeWith(obj);
    }
}

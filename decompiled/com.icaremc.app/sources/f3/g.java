package f3;

import b3.AbstractC0245u;

/* loaded from: classes.dex */
public final class g extends e {

    /* renamed from: i, reason: collision with root package name */
    public final e3.d f3723i;

    public g(e3.d dVar, K2.i iVar, int i4, d3.a aVar) {
        super(iVar, i4, aVar);
        this.f3723i = dVar;
    }

    @Override // f3.e
    public final Object a(d3.r rVar, K2.d dVar) {
        Object u3 = this.f3723i.u(new p(rVar), dVar);
        H2.i iVar = H2.i.f681a;
        L2.a aVar = L2.a.f1019f;
        if (u3 != aVar) {
            u3 = iVar;
        }
        if (u3 == aVar) {
            return u3;
        }
        return iVar;
    }

    @Override // f3.e
    public final String toString() {
        return this.f3723i + " -> " + super.toString();
    }

    @Override // f3.e, e3.d
    public final Object u(e3.e eVar, K2.d dVar) {
        K2.i a4;
        int i4 = this.f3719g;
        L2.a aVar = L2.a.f1019f;
        H2.i iVar = H2.i.f681a;
        if (i4 == -3) {
            K2.i context = dVar.getContext();
            Boolean bool = Boolean.FALSE;
            K2.b bVar = new K2.b(2);
            K2.i iVar2 = this.f3718f;
            if (!((Boolean) iVar2.k(bool, bVar)).booleanValue()) {
                a4 = context.j(iVar2);
            } else {
                a4 = AbstractC0245u.a(context, iVar2, false);
            }
            if (T2.h.a(a4, context)) {
                Object u3 = this.f3723i.u(eVar, dVar);
                if (u3 != aVar) {
                    u3 = iVar;
                }
                if (u3 == aVar) {
                    return u3;
                }
            } else {
                K2.e eVar2 = K2.e.f941f;
                if (T2.h.a(a4.e(eVar2), context.e(eVar2))) {
                    K2.i context2 = dVar.getContext();
                    if (!(eVar instanceof p)) {
                        eVar = new B2.q(eVar, context2);
                    }
                    Object b4 = k.b(a4, eVar, g3.a.k(a4), new f(this, null), dVar);
                    if (b4 == aVar) {
                        return b4;
                    }
                }
            }
            return iVar;
        }
        Object u4 = super.u(eVar, dVar);
        if (u4 == aVar) {
            return u4;
        }
        return iVar;
    }
}

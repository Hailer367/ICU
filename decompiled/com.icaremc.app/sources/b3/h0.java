package b3;

import a.AbstractC0141a;

/* loaded from: classes.dex */
public final class h0 implements K2.g, K2.h {

    /* renamed from: f, reason: collision with root package name */
    public static final h0 f3280f = new Object();

    @Override // K2.i
    public final K2.i c(K2.h hVar) {
        return AbstractC0141a.v(this, hVar);
    }

    @Override // K2.i
    public final K2.g e(K2.h hVar) {
        return AbstractC0141a.s(this, hVar);
    }

    @Override // K2.i
    public final K2.i j(K2.i iVar) {
        T2.h.e(iVar, "context");
        if (iVar == K2.j.f942f) {
            return this;
        }
        return (K2.i) iVar.k(this, new K2.b(1));
    }

    @Override // K2.i
    public final Object k(Object obj, S2.p pVar) {
        return pVar.e(obj, this);
    }

    @Override // K2.g
    public final K2.h getKey() {
        return this;
    }
}

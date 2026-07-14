package K;

import a.AbstractC0051a;

/* loaded from: classes.dex */
public final class k0 extends V0.h implements c1.p {
    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        return new V0.h(2, dVar);
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        k0 k0Var = (k0) create((o1.e) obj, (T0.d) obj2);
        Q0.j jVar = Q0.j.f722a;
        k0Var.invokeSuspend(jVar);
        return jVar;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        AbstractC0051a.V(obj);
        return Q0.j.f722a;
    }
}

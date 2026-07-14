package p1;

import l1.AbstractC0244w;

/* loaded from: classes.dex */
public final class g extends e {

    /* renamed from: f, reason: collision with root package name */
    public final o1.d f3484f;

    public g(o1.d dVar, T0.i iVar, int i2, n1.a aVar) {
        super(iVar, i2, aVar);
        this.f3484f = dVar;
    }

    @Override // p1.e
    public final Object b(n1.r rVar, T0.d dVar) {
        Object collect = this.f3484f.collect(new p(rVar), dVar);
        U0.a aVar = U0.a.f780c;
        Q0.j jVar = Q0.j.f722a;
        if (collect != aVar) {
            collect = jVar;
        }
        if (collect == aVar) {
            return collect;
        }
        return jVar;
    }

    @Override // p1.e
    public final e c(T0.i iVar, int i2, n1.a aVar) {
        return new g(this.f3484f, iVar, i2, aVar);
    }

    @Override // p1.e, o1.d
    public final Object collect(o1.e eVar, T0.d dVar) {
        T0.i a2;
        int i2 = this.f3479d;
        Q0.j jVar = Q0.j.f722a;
        if (i2 == -3) {
            T0.i context = dVar.getContext();
            Boolean bool = Boolean.FALSE;
            T0.b bVar = new T0.b(2);
            T0.i iVar = this.f3478c;
            if (!((Boolean) iVar.c(bool, bVar)).booleanValue()) {
                a2 = context.d(iVar);
            } else {
                a2 = AbstractC0244w.a(context, iVar, false);
            }
            if (kotlin.jvm.internal.h.a(a2, context)) {
                Object collect = this.f3484f.collect(eVar, dVar);
                U0.a aVar = U0.a.f780c;
                if (collect != aVar) {
                    collect = jVar;
                }
                if (collect == aVar) {
                    return collect;
                }
            } else {
                T0.e eVar2 = T0.e.f773c;
                if (kotlin.jvm.internal.h.a(a2.k(eVar2), context.k(eVar2))) {
                    T0.i context2 = dVar.getContext();
                    if (!(eVar instanceof p)) {
                        eVar = new o1.m(eVar, context2);
                    }
                    Object b2 = k.b(a2, eVar, q1.a.k(a2), new f(this, null), dVar);
                    if (b2 == U0.a.f780c) {
                        return b2;
                    }
                }
            }
            return jVar;
        }
        Object collect2 = super.collect(eVar, dVar);
        if (collect2 == U0.a.f780c) {
            return collect2;
        }
        return jVar;
    }

    @Override // p1.e
    public final String toString() {
        return this.f3484f + " -> " + super.toString();
    }
}

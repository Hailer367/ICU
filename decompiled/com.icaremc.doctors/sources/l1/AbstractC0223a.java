package l1;

import a.AbstractC0051a;

/* renamed from: l1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0223a extends X implements T0.d, InterfaceC0242u {

    /* renamed from: e, reason: collision with root package name */
    public final T0.i f2979e;

    public AbstractC0223a(T0.i iVar, boolean z) {
        super(z);
        B((O) iVar.k(C0241t.f3012d));
        this.f2979e = iVar.d(this);
    }

    @Override // l1.X
    public final void A(Q0.d dVar) {
        AbstractC0244w.d(this.f2979e, dVar);
    }

    @Override // l1.X
    public final void I(Object obj) {
        boolean z;
        if (obj instanceof C0238p) {
            C0238p c0238p = (C0238p) obj;
            Throwable th = c0238p.f3007a;
            if (C0238p.f3006b.get(c0238p) != 0) {
                z = true;
            } else {
                z = false;
            }
            Q(th, z);
            return;
        }
        R(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S(EnumC0243v enumC0243v, AbstractC0223a abstractC0223a, c1.p pVar) {
        int ordinal = enumC0243v.ordinal();
        Q0.j jVar = Q0.j.f722a;
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        try {
                            T0.i iVar = this.f2979e;
                            Object l2 = q1.a.l(iVar, null);
                            try {
                                kotlin.jvm.internal.t.a(2, pVar);
                                Object invoke = pVar.invoke(abstractC0223a, this);
                                if (invoke != U0.a.f780c) {
                                    resumeWith(invoke);
                                    return;
                                }
                                return;
                            } finally {
                                q1.a.g(iVar, l2);
                            }
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    throw new RuntimeException();
                }
                android.support.v4.media.session.a.v(((V0.a) pVar).create(abstractC0223a, this)).resumeWith(jVar);
                return;
            }
            return;
        }
        try {
            q1.a.h(android.support.v4.media.session.a.v(((V0.a) pVar).create(abstractC0223a, this)), jVar);
        } finally {
            resumeWith(AbstractC0051a.j(th));
        }
    }

    @Override // l1.InterfaceC0242u
    public final T0.i e() {
        return this.f2979e;
    }

    @Override // T0.d
    public final T0.i getContext() {
        return this.f2979e;
    }

    @Override // l1.X
    public final String q() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // T0.d
    public final void resumeWith(Object obj) {
        Throwable a2 = Q0.g.a(obj);
        if (a2 != null) {
            obj = new C0238p(a2, false);
        }
        Object F2 = F(obj);
        if (F2 == AbstractC0244w.f3019d) {
            return;
        }
        m(F2);
    }

    public void R(Object obj) {
    }

    public void Q(Throwable th, boolean z) {
    }
}

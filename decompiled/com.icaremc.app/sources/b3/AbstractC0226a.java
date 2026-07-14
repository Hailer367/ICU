package b3;

/* renamed from: b3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0226a extends W implements K2.d, InterfaceC0243s {

    /* renamed from: h, reason: collision with root package name */
    public final K2.i f3265h;

    public AbstractC0226a(K2.i iVar, boolean z) {
        super(z);
        C((N) iVar.e(r.f3295g));
        this.f3265h = iVar.j(this);
    }

    @Override // b3.W
    public final void B(E0.b bVar) {
        AbstractC0245u.d(this.f3265h, bVar);
    }

    @Override // b3.W
    public final void J(Object obj) {
        boolean z;
        if (obj instanceof C0240o) {
            C0240o c0240o = (C0240o) obj;
            Throwable th = c0240o.f3290a;
            if (C0240o.f3289b.get(c0240o) != 0) {
                z = true;
            } else {
                z = false;
            }
            R(th, z);
            return;
        }
        S(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T(EnumC0244t enumC0244t, AbstractC0226a abstractC0226a, S2.p pVar) {
        int ordinal = enumC0244t.ordinal();
        H2.i iVar = H2.i.f681a;
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        try {
                            K2.i iVar2 = this.f3265h;
                            Object l3 = g3.a.l(iVar2, null);
                            try {
                                T2.s.a(2, pVar);
                                Object e4 = pVar.e(abstractC0226a, this);
                                if (e4 != L2.a.f1019f) {
                                    resumeWith(e4);
                                    return;
                                }
                                return;
                            } finally {
                                g3.a.g(iVar2, l3);
                            }
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    throw new RuntimeException();
                }
                k3.b.r(((M2.a) pVar).i(this, abstractC0226a)).resumeWith(iVar);
                return;
            }
            return;
        }
        try {
            g3.a.h(k3.b.r(((M2.a) pVar).i(this, abstractC0226a)), iVar);
        } finally {
            resumeWith(k3.b.f(th));
        }
    }

    @Override // b3.InterfaceC0243s
    public final K2.i f() {
        return this.f3265h;
    }

    @Override // K2.d
    public final K2.i getContext() {
        return this.f3265h;
    }

    @Override // b3.W
    public final String r() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // K2.d
    public final void resumeWith(Object obj) {
        Throwable a4 = H2.f.a(obj);
        if (a4 != null) {
            obj = new C0240o(a4, false);
        }
        Object G3 = G(obj);
        if (G3 == AbstractC0245u.f3302d) {
            return;
        }
        n(G3);
    }

    public void S(Object obj) {
    }

    public void R(Throwable th, boolean z) {
    }
}

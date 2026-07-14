package l1;

/* renamed from: l1.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0236n extends X implements InterfaceC0235m {
    public final Object Q(V0.h hVar) {
        Object k2;
        while (true) {
            Object obj = X.f2976c.get(this);
            if (!(obj instanceof L)) {
                if (!(obj instanceof C0238p)) {
                    k2 = AbstractC0244w.k(obj);
                } else {
                    throw ((C0238p) obj).f3007a;
                }
            } else if (M(obj) >= 0) {
                U u2 = new U(android.support.v4.media.session.a.v(hVar), this);
                u2.r();
                u2.t(new C0227e(1, AbstractC0244w.e(this, true, new C0232j(2, u2))));
                k2 = u2.q();
                U0.a aVar = U0.a.f780c;
                break;
            }
        }
        U0.a aVar2 = U0.a.f780c;
        return k2;
    }
}

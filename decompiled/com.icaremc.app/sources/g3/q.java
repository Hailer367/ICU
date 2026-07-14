package g3;

import b3.AbstractC0226a;
import b3.AbstractC0245u;

/* loaded from: classes.dex */
public class q extends AbstractC0226a implements M2.d {

    /* renamed from: i, reason: collision with root package name */
    public final K2.d f3805i;

    public q(K2.d dVar, K2.i iVar) {
        super(iVar, true);
        this.f3805i = dVar;
    }

    @Override // b3.W
    public final boolean E() {
        return true;
    }

    @Override // M2.d
    public final M2.d d() {
        K2.d dVar = this.f3805i;
        if (dVar instanceof M2.d) {
            return (M2.d) dVar;
        }
        return null;
    }

    @Override // b3.W
    public void m(Object obj) {
        a.h(k3.b.r(this.f3805i), AbstractC0245u.g(obj));
    }

    @Override // b3.W
    public void n(Object obj) {
        this.f3805i.resumeWith(AbstractC0245u.g(obj));
    }
}

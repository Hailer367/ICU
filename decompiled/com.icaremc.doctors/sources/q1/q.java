package q1;

import l1.AbstractC0223a;
import l1.AbstractC0244w;

/* loaded from: classes.dex */
public class q extends AbstractC0223a implements V0.d {

    /* renamed from: f, reason: collision with root package name */
    public final T0.d f3540f;

    public q(T0.d dVar, T0.i iVar) {
        super(iVar, true);
        this.f3540f = dVar;
    }

    @Override // l1.X
    public final boolean D() {
        return true;
    }

    @Override // V0.d
    public final V0.d getCallerFrame() {
        T0.d dVar = this.f3540f;
        if (dVar instanceof V0.d) {
            return (V0.d) dVar;
        }
        return null;
    }

    @Override // l1.X
    public void l(Object obj) {
        a.h(android.support.v4.media.session.a.v(this.f3540f), AbstractC0244w.g(obj));
    }

    @Override // l1.X
    public void m(Object obj) {
        this.f3540f.resumeWith(AbstractC0244w.g(obj));
    }
}

package n1;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import l1.AbstractC0223a;
import l1.AbstractC0244w;
import l1.C0238p;
import l1.P;
import l1.W;
import l1.X;

/* loaded from: classes.dex */
public final class q extends AbstractC0223a implements r, g {

    /* renamed from: f, reason: collision with root package name */
    public final c f3353f;

    public q(T0.i iVar, c cVar) {
        super(iVar, true);
        this.f3353f = cVar;
    }

    @Override // l1.AbstractC0223a
    public final void Q(Throwable th, boolean z) {
        if (!this.f3353f.f(th, false) && !z) {
            AbstractC0244w.d(this.f2979e, th);
        }
    }

    @Override // l1.AbstractC0223a
    public final void R(Object obj) {
        this.f3353f.f(null, false);
    }

    public final boolean T(Throwable th) {
        return this.f3353f.f(th, false);
    }

    public final void U(p pVar) {
        c cVar = this.f3353f;
        cVar.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f3321l;
        while (!atomicReferenceFieldUpdater.compareAndSet(cVar, null, pVar)) {
            if (atomicReferenceFieldUpdater.get(cVar) != null) {
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(cVar);
                    F.h hVar = e.q;
                    if (obj == hVar) {
                        F.h hVar2 = e.f3339r;
                        while (!atomicReferenceFieldUpdater.compareAndSet(cVar, hVar, hVar2)) {
                            if (atomicReferenceFieldUpdater.get(cVar) != hVar) {
                                break;
                            }
                        }
                        pVar.invoke(cVar.m());
                        return;
                    }
                    if (obj == e.f3339r) {
                        throw new IllegalStateException("Another handler was already registered and successfully invoked");
                    }
                    throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                }
            }
        }
    }

    @Override // l1.X, l1.O
    public final void b(CancellationException cancellationException) {
        Object obj = X.f2976c.get(this);
        if (!(obj instanceof C0238p)) {
            if (!(obj instanceof W) || !((W) obj).e()) {
                if (cancellationException == null) {
                    cancellationException = new P(q(), null, this);
                }
                o(cancellationException);
            }
        }
    }

    @Override // n1.t
    public final Object h(T0.d dVar, Object obj) {
        return this.f3353f.h(dVar, obj);
    }

    @Override // n1.t
    public final Object i(Object obj) {
        return this.f3353f.i(obj);
    }

    @Override // l1.X
    public final void o(CancellationException cancellationException) {
        this.f3353f.f(cancellationException, true);
        n(cancellationException);
    }
}

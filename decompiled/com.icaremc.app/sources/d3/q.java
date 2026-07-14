package d3;

import b3.AbstractC0226a;
import b3.AbstractC0245u;
import b3.C0240o;
import b3.O;
import b3.V;
import b3.W;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class q extends AbstractC0226a implements r, g {

    /* renamed from: i, reason: collision with root package name */
    public final c f3539i;

    public q(K2.i iVar, c cVar) {
        super(iVar, true);
        this.f3539i = cVar;
    }

    @Override // b3.AbstractC0226a
    public final void R(Throwable th, boolean z) {
        if (!this.f3539i.f(th, false) && !z) {
            AbstractC0245u.d(this.f3265h, th);
        }
    }

    @Override // b3.AbstractC0226a
    public final void S(Object obj) {
        this.f3539i.f(null, false);
    }

    public final void U(p pVar) {
        c cVar = this.f3539i;
        cVar.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f3506o;
        while (!atomicReferenceFieldUpdater.compareAndSet(cVar, null, pVar)) {
            if (atomicReferenceFieldUpdater.get(cVar) != null) {
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(cVar);
                    R1.c cVar2 = e.f3524q;
                    if (obj == cVar2) {
                        R1.c cVar3 = e.f3525r;
                        while (!atomicReferenceFieldUpdater.compareAndSet(cVar, cVar2, cVar3)) {
                            if (atomicReferenceFieldUpdater.get(cVar) != cVar2) {
                                break;
                            }
                        }
                        pVar.f(cVar.m());
                        return;
                    }
                    if (obj == e.f3525r) {
                        throw new IllegalStateException("Another handler was already registered and successfully invoked");
                    }
                    throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                }
            }
        }
    }

    @Override // b3.W, b3.N
    public final void b(CancellationException cancellationException) {
        Object obj = W.f3262f.get(this);
        if (!(obj instanceof C0240o)) {
            if (!(obj instanceof V) || !((V) obj).e()) {
                if (cancellationException == null) {
                    cancellationException = new O(r(), null, this);
                }
                p(cancellationException);
            }
        }
    }

    @Override // d3.t
    public final Object g(K2.d dVar, Object obj) {
        return this.f3539i.g(dVar, obj);
    }

    @Override // d3.t
    public final Object i(Object obj) {
        return this.f3539i.i(obj);
    }

    @Override // b3.W
    public final void p(CancellationException cancellationException) {
        this.f3539i.f(cancellationException, true);
        o(cancellationException);
    }
}

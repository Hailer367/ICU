package b3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: b3.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0234i extends S {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3281e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f3282f;

    public /* synthetic */ C0234i(int i4, Object obj) {
        this.f3281e = i4;
        this.f3282f = obj;
    }

    @Override // b3.S
    public final boolean j() {
        switch (this.f3281e) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return false;
        }
    }

    @Override // b3.S
    public final void k(Throwable th) {
        switch (this.f3281e) {
            case 0:
                C0232g c0232g = (C0232g) this.f3282f;
                Throwable q2 = c0232g.q(i());
                if (c0232g.v()) {
                    g3.f fVar = (g3.f) c0232g.f3276i;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g3.f.f3782m;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(fVar);
                        R1.c cVar = g3.a.f3772c;
                        if (T2.h.a(obj, cVar)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, cVar, q2)) {
                                if (atomicReferenceFieldUpdater.get(fVar) != cVar) {
                                    break;
                                }
                            }
                            return;
                        } else {
                            if (obj instanceof Throwable) {
                                return;
                            }
                            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                                if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                                    break;
                                }
                            }
                        }
                    }
                }
                c0232g.n(q2);
                if (!c0232g.v()) {
                    c0232g.o();
                    return;
                }
                return;
            case 1:
                ((S2.l) this.f3282f).f(th);
                return;
            default:
                T t3 = (T) this.f3282f;
                Object obj2 = W.f3262f.get(i());
                if (obj2 instanceof C0240o) {
                    t3.resumeWith(k3.b.f(((C0240o) obj2).f3290a));
                    return;
                } else {
                    t3.resumeWith(AbstractC0245u.k(obj2));
                    return;
                }
        }
    }
}

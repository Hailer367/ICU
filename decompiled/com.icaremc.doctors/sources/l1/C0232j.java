package l1;

import a.AbstractC0051a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: l1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0232j extends T {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2998e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f2999f;

    public /* synthetic */ C0232j(int i2, Object obj) {
        this.f2998e = i2;
        this.f2999f = obj;
    }

    @Override // l1.T
    public final boolean j() {
        switch (this.f2998e) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return false;
        }
    }

    @Override // l1.T
    public final void k(Throwable th) {
        switch (this.f2998e) {
            case 0:
                C0230h c0230h = (C0230h) this.f2999f;
                Throwable p = c0230h.p(i());
                if (c0230h.u()) {
                    q1.f fVar = (q1.f) c0230h.f2993f;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = q1.f.f3515j;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(fVar);
                        F.h hVar = q1.a.f3505c;
                        if (kotlin.jvm.internal.h.a(obj, hVar)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, hVar, p)) {
                                if (atomicReferenceFieldUpdater.get(fVar) != hVar) {
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
                c0230h.m(p);
                if (!c0230h.u()) {
                    c0230h.n();
                    return;
                }
                return;
            case 1:
                ((c1.l) this.f2999f).invoke(th);
                return;
            default:
                U u2 = (U) this.f2999f;
                Object obj2 = X.f2976c.get(i());
                if (obj2 instanceof C0238p) {
                    u2.resumeWith(AbstractC0051a.j(((C0238p) obj2).f3007a));
                    return;
                } else {
                    u2.resumeWith(AbstractC0244w.k(obj2));
                    return;
                }
        }
    }
}

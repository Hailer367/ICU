package K;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import l1.C0236n;
import l1.C0238p;

/* loaded from: classes.dex */
public final class g0 extends kotlin.jvm.internal.i implements c1.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ M f478c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ B0.q f479d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(M m2, B0.q qVar) {
        super(1);
        this.f478c = m2;
        this.f479d = qVar;
    }

    @Override // c1.l
    public final Object invoke(Object obj) {
        Object hVar;
        l1.j0 j0Var;
        Q0.j jVar;
        Q0.j jVar2;
        Throwable th;
        Throwable th2 = (Throwable) obj;
        this.f478c.invoke(th2);
        n1.c cVar = (n1.c) this.f479d.f132e;
        cVar.f(th2, false);
        do {
            cVar.getClass();
            AtomicLongFieldUpdater atomicLongFieldUpdater = n1.c.f3314e;
            long j2 = atomicLongFieldUpdater.get(cVar);
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = n1.c.f3313d;
            long j3 = atomicLongFieldUpdater2.get(cVar);
            if (cVar.r(j3, true)) {
                hVar = new n1.h(cVar.m());
            } else {
                long j4 = j3 & 1152921504606846975L;
                n1.i iVar = n1.j.f3345a;
                if (j2 < j4) {
                    Object obj2 = n1.e.f3334k;
                    n1.k kVar = (n1.k) n1.c.f3318i.get(cVar);
                    while (true) {
                        if (cVar.r(atomicLongFieldUpdater2.get(cVar), true)) {
                            hVar = new n1.h(cVar.m());
                            break;
                        }
                        long andIncrement = atomicLongFieldUpdater.getAndIncrement(cVar);
                        long j5 = n1.e.f3325b;
                        long j6 = andIncrement / j5;
                        int i2 = (int) (andIncrement % j5);
                        if (kVar.f3542c != j6) {
                            n1.k l2 = cVar.l(j6, kVar);
                            if (l2 == null) {
                                continue;
                            } else {
                                kVar = l2;
                            }
                        }
                        Object A2 = cVar.A(kVar, i2, andIncrement, obj2);
                        if (A2 == n1.e.f3336m) {
                            if (obj2 instanceof l1.j0) {
                                j0Var = (l1.j0) obj2;
                            } else {
                                j0Var = null;
                            }
                            if (j0Var != null) {
                                j0Var.a(kVar, i2);
                            }
                            cVar.C(andIncrement);
                            kVar.h();
                        } else if (A2 == n1.e.f3338o) {
                            if (andIncrement < cVar.p()) {
                                kVar.a();
                            }
                        } else if (A2 != n1.e.f3337n) {
                            kVar.a();
                            hVar = A2;
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    }
                }
                hVar = iVar;
            }
            jVar = null;
            if (hVar instanceof n1.i) {
                hVar = null;
            }
            jVar2 = Q0.j.f722a;
            if (hVar != null) {
                C0236n c0236n = ((d0) hVar).f460b;
                if (th2 == null) {
                    th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                } else {
                    th = th2;
                }
                c0236n.getClass();
                c0236n.E(new C0238p(th, false));
                jVar = jVar2;
            }
        } while (jVar != null);
        return jVar2;
    }
}

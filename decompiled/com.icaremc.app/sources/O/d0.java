package O;

import b3.C0238m;
import b3.C0240o;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes.dex */
public final class d0 extends T2.i implements S2.l {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ J f1176g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ P1.y f1177h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(J j4, P1.y yVar) {
        super(1);
        this.f1176g = j4;
        this.f1177h = yVar;
    }

    @Override // S2.l
    public final Object f(Object obj) {
        Object hVar;
        b3.i0 i0Var;
        H2.i iVar;
        H2.i iVar2;
        Throwable th;
        Throwable th2 = (Throwable) obj;
        this.f1176g.f(th2);
        d3.c cVar = (d3.c) this.f1177h.f1471h;
        cVar.f(th2, false);
        do {
            cVar.getClass();
            AtomicLongFieldUpdater atomicLongFieldUpdater = d3.c.f3500h;
            long j4 = atomicLongFieldUpdater.get(cVar);
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = d3.c.f3499g;
            long j5 = atomicLongFieldUpdater2.get(cVar);
            if (cVar.r(j5, true)) {
                hVar = new d3.h(cVar.m());
            } else {
                long j6 = j5 & 1152921504606846975L;
                d3.i iVar3 = d3.j.f3531a;
                if (j4 < j6) {
                    Object obj2 = d3.e.k;
                    d3.k kVar = (d3.k) d3.c.f3503l.get(cVar);
                    while (true) {
                        if (cVar.r(atomicLongFieldUpdater2.get(cVar), true)) {
                            hVar = new d3.h(cVar.m());
                            break;
                        }
                        long andIncrement = atomicLongFieldUpdater.getAndIncrement(cVar);
                        long j7 = d3.e.f3510b;
                        long j8 = andIncrement / j7;
                        int i4 = (int) (andIncrement % j7);
                        if (kVar.f3807c != j8) {
                            d3.k l3 = cVar.l(j8, kVar);
                            if (l3 == null) {
                                continue;
                            } else {
                                kVar = l3;
                            }
                        }
                        Object A3 = cVar.A(kVar, i4, andIncrement, obj2);
                        if (A3 == d3.e.f3520m) {
                            if (obj2 instanceof b3.i0) {
                                i0Var = (b3.i0) obj2;
                            } else {
                                i0Var = null;
                            }
                            if (i0Var != null) {
                                i0Var.a(kVar, i4);
                            }
                            cVar.C(andIncrement);
                            kVar.h();
                        } else if (A3 == d3.e.f3522o) {
                            if (andIncrement < cVar.p()) {
                                kVar.a();
                            }
                        } else if (A3 != d3.e.f3521n) {
                            kVar.a();
                            hVar = A3;
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    }
                }
                hVar = iVar3;
            }
            iVar = null;
            if (hVar instanceof d3.i) {
                hVar = null;
            }
            iVar2 = H2.i.f681a;
            if (hVar != null) {
                C0238m c0238m = ((a0) hVar).f1166b;
                if (th2 == null) {
                    th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                } else {
                    th = th2;
                }
                c0238m.getClass();
                c0238m.F(new C0240o(th, false));
                iVar = iVar2;
            }
        } while (iVar != null);
        return iVar2;
    }
}

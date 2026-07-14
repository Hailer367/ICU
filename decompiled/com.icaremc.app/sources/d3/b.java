package d3;

import b3.AbstractC0245u;
import b3.C0232g;
import b3.i0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class b implements i0 {

    /* renamed from: f, reason: collision with root package name */
    public Object f3496f = e.f3523p;

    /* renamed from: g, reason: collision with root package name */
    public C0232g f3497g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f3498h;

    public b(c cVar) {
        this.f3498h = cVar;
    }

    @Override // b3.i0
    public final void a(g3.r rVar, int i4) {
        C0232g c0232g = this.f3497g;
        if (c0232g != null) {
            c0232g.a(rVar, i4);
        }
    }

    public final Object b(e3.f fVar) {
        k kVar;
        Boolean bool;
        k kVar2;
        Object obj = this.f3496f;
        boolean z = true;
        if (obj == e.f3523p || obj == e.f3519l) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f3503l;
            c cVar = this.f3498h;
            k kVar3 = (k) atomicReferenceFieldUpdater.get(cVar);
            while (!cVar.r(c.f3499g.get(cVar), true)) {
                long andIncrement = c.f3500h.getAndIncrement(cVar);
                long j4 = e.f3510b;
                long j5 = andIncrement / j4;
                int i4 = (int) (andIncrement % j4);
                if (kVar3.f3807c != j5) {
                    k l3 = cVar.l(j5, kVar3);
                    if (l3 == null) {
                        continue;
                    } else {
                        kVar = l3;
                    }
                } else {
                    kVar = kVar3;
                }
                Object A3 = cVar.A(kVar, i4, andIncrement, null);
                R1.c cVar2 = e.f3520m;
                if (A3 != cVar2) {
                    R1.c cVar3 = e.f3522o;
                    if (A3 == cVar3) {
                        if (andIncrement < cVar.p()) {
                            kVar.a();
                        }
                        kVar3 = kVar;
                    } else if (A3 == e.f3521n) {
                        C0232g c4 = AbstractC0245u.c(k3.b.r(fVar));
                        try {
                            this.f3497g = c4;
                            try {
                                Object A4 = cVar.A(kVar, i4, andIncrement, this);
                                if (A4 == cVar2) {
                                    a(kVar, i4);
                                } else {
                                    if (A4 == cVar3) {
                                        if (andIncrement < cVar.p()) {
                                            kVar.a();
                                        }
                                        k kVar4 = (k) c.f3503l.get(cVar);
                                        while (true) {
                                            if (cVar.r(c.f3499g.get(cVar), true)) {
                                                C0232g c0232g = this.f3497g;
                                                T2.h.b(c0232g);
                                                this.f3497g = null;
                                                this.f3496f = e.f3519l;
                                                Throwable m3 = cVar.m();
                                                if (m3 == null) {
                                                    c0232g.resumeWith(Boolean.FALSE);
                                                } else {
                                                    c0232g.resumeWith(k3.b.f(m3));
                                                }
                                            } else {
                                                long andIncrement2 = c.f3500h.getAndIncrement(cVar);
                                                long j6 = e.f3510b;
                                                long j7 = andIncrement2 / j6;
                                                int i5 = (int) (andIncrement2 % j6);
                                                if (kVar4.f3807c != j7) {
                                                    kVar2 = cVar.l(j7, kVar4);
                                                    if (kVar2 == null) {
                                                    }
                                                } else {
                                                    kVar2 = kVar4;
                                                }
                                                Object A5 = cVar.A(kVar2, i5, andIncrement2, this);
                                                if (A5 == e.f3520m) {
                                                    a(kVar2, i5);
                                                    break;
                                                }
                                                if (A5 == e.f3522o) {
                                                    if (andIncrement2 < cVar.p()) {
                                                        kVar2.a();
                                                    }
                                                    kVar4 = kVar2;
                                                } else if (A5 != e.f3521n) {
                                                    kVar2.a();
                                                    this.f3496f = A5;
                                                    this.f3497g = null;
                                                    bool = Boolean.TRUE;
                                                } else {
                                                    throw new IllegalStateException("unexpected");
                                                }
                                            }
                                        }
                                    } else {
                                        kVar.a();
                                        this.f3496f = A4;
                                        this.f3497g = null;
                                        bool = Boolean.TRUE;
                                    }
                                    c4.z(bool, null);
                                }
                                return c4.r();
                            } catch (Throwable th) {
                                th = th;
                                c4.y();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        kVar.a();
                        this.f3496f = A3;
                        return Boolean.valueOf(z);
                    }
                } else {
                    throw new IllegalStateException("unreachable");
                }
            }
            this.f3496f = e.f3519l;
            Throwable m4 = cVar.m();
            if (m4 == null) {
                z = false;
            } else {
                int i6 = g3.s.f3808a;
                throw m4;
            }
        }
        return Boolean.valueOf(z);
    }
}

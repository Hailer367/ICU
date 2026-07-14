package n1;

import a.AbstractC0051a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import l1.AbstractC0244w;
import l1.C0230h;
import l1.j0;

/* loaded from: classes.dex */
public final class b implements j0 {

    /* renamed from: c, reason: collision with root package name */
    public Object f3310c = e.p;

    /* renamed from: d, reason: collision with root package name */
    public C0230h f3311d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c f3312e;

    public b(c cVar) {
        this.f3312e = cVar;
    }

    @Override // l1.j0
    public final void a(q1.r rVar, int i2) {
        C0230h c0230h = this.f3311d;
        if (c0230h != null) {
            c0230h.a(rVar, i2);
        }
    }

    public final Object b(o1.f fVar) {
        k kVar;
        Boolean bool;
        k kVar2;
        Object obj = this.f3310c;
        boolean z = true;
        if (obj == e.p || obj == e.f3335l) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f3318i;
            c cVar = this.f3312e;
            k kVar3 = (k) atomicReferenceFieldUpdater.get(cVar);
            while (!cVar.r(c.f3313d.get(cVar), true)) {
                long andIncrement = c.f3314e.getAndIncrement(cVar);
                long j2 = e.f3325b;
                long j3 = andIncrement / j2;
                int i2 = (int) (andIncrement % j2);
                if (kVar3.f3542c != j3) {
                    k l2 = cVar.l(j3, kVar3);
                    if (l2 == null) {
                        continue;
                    } else {
                        kVar = l2;
                    }
                } else {
                    kVar = kVar3;
                }
                Object A2 = cVar.A(kVar, i2, andIncrement, null);
                F.h hVar = e.f3336m;
                if (A2 != hVar) {
                    F.h hVar2 = e.f3338o;
                    if (A2 == hVar2) {
                        if (andIncrement < cVar.p()) {
                            kVar.a();
                        }
                        kVar3 = kVar;
                    } else if (A2 == e.f3337n) {
                        C0230h c2 = AbstractC0244w.c(android.support.v4.media.session.a.v(fVar));
                        try {
                            this.f3311d = c2;
                            try {
                                Object A3 = cVar.A(kVar, i2, andIncrement, this);
                                if (A3 == hVar) {
                                    a(kVar, i2);
                                } else {
                                    if (A3 == hVar2) {
                                        if (andIncrement < cVar.p()) {
                                            kVar.a();
                                        }
                                        k kVar4 = (k) c.f3318i.get(cVar);
                                        while (true) {
                                            if (cVar.r(c.f3313d.get(cVar), true)) {
                                                C0230h c0230h = this.f3311d;
                                                kotlin.jvm.internal.h.b(c0230h);
                                                this.f3311d = null;
                                                this.f3310c = e.f3335l;
                                                Throwable m2 = cVar.m();
                                                if (m2 == null) {
                                                    c0230h.resumeWith(Boolean.FALSE);
                                                } else {
                                                    c0230h.resumeWith(AbstractC0051a.j(m2));
                                                }
                                            } else {
                                                long andIncrement2 = c.f3314e.getAndIncrement(cVar);
                                                long j4 = e.f3325b;
                                                long j5 = andIncrement2 / j4;
                                                int i3 = (int) (andIncrement2 % j4);
                                                if (kVar4.f3542c != j5) {
                                                    kVar2 = cVar.l(j5, kVar4);
                                                    if (kVar2 == null) {
                                                    }
                                                } else {
                                                    kVar2 = kVar4;
                                                }
                                                Object A4 = cVar.A(kVar2, i3, andIncrement2, this);
                                                if (A4 == e.f3336m) {
                                                    a(kVar2, i3);
                                                    break;
                                                }
                                                if (A4 == e.f3338o) {
                                                    if (andIncrement2 < cVar.p()) {
                                                        kVar2.a();
                                                    }
                                                    kVar4 = kVar2;
                                                } else if (A4 != e.f3337n) {
                                                    kVar2.a();
                                                    this.f3310c = A4;
                                                    this.f3311d = null;
                                                    bool = Boolean.TRUE;
                                                } else {
                                                    throw new IllegalStateException("unexpected");
                                                }
                                            }
                                        }
                                    } else {
                                        kVar.a();
                                        this.f3310c = A3;
                                        this.f3311d = null;
                                        bool = Boolean.TRUE;
                                    }
                                    c2.y(bool, null);
                                }
                                Object q = c2.q();
                                U0.a aVar = U0.a.f780c;
                                return q;
                            } catch (Throwable th) {
                                th = th;
                                c2.x();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        kVar.a();
                        this.f3310c = A2;
                        return Boolean.valueOf(z);
                    }
                } else {
                    throw new IllegalStateException("unreachable");
                }
            }
            this.f3310c = e.f3335l;
            Throwable m3 = cVar.m();
            if (m3 == null) {
                z = false;
            } else {
                int i4 = q1.s.f3543a;
                throw m3;
            }
        }
        return Boolean.valueOf(z);
    }
}

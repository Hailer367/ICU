package b3;

import a.AbstractC0141a;
import f1.AbstractC0286a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* renamed from: b3.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0245u {

    /* renamed from: a, reason: collision with root package name */
    public static final R1.c f3299a;

    /* renamed from: b, reason: collision with root package name */
    public static final R1.c f3300b;

    /* renamed from: c, reason: collision with root package name */
    public static final R1.c f3301c;

    /* renamed from: d, reason: collision with root package name */
    public static final R1.c f3302d;

    /* renamed from: e, reason: collision with root package name */
    public static final R1.c f3303e;

    /* renamed from: f, reason: collision with root package name */
    public static final R1.c f3304f;

    /* renamed from: g, reason: collision with root package name */
    public static final R1.c f3305g;

    /* renamed from: h, reason: collision with root package name */
    public static final D f3306h = new D(false);

    /* renamed from: i, reason: collision with root package name */
    public static final D f3307i = new D(true);

    static {
        int i4 = 21;
        f3299a = new R1.c(i4, "RESUME_TOKEN");
        f3300b = new R1.c(i4, "CLOSED_EMPTY");
        f3301c = new R1.c(i4, "COMPLETING_ALREADY");
        f3302d = new R1.c(i4, "COMPLETING_WAITING_CHILDREN");
        f3303e = new R1.c(i4, "COMPLETING_RETRY");
        f3304f = new R1.c(i4, "TOO_LATE_TO_CANCEL");
        f3305g = new R1.c(i4, "SEALED");
    }

    public static final K2.i a(K2.i iVar, K2.i iVar2, boolean z) {
        Boolean bool = Boolean.FALSE;
        boolean booleanValue = ((Boolean) iVar.k(bool, new K2.b(2))).booleanValue();
        boolean booleanValue2 = ((Boolean) iVar2.k(bool, new K2.b(2))).booleanValue();
        if (!booleanValue && !booleanValue2) {
            return iVar.j(iVar2);
        }
        K2.b bVar = new K2.b(3);
        K2.j jVar = K2.j.f942f;
        K2.i iVar3 = (K2.i) iVar.k(jVar, bVar);
        Object obj = iVar2;
        if (booleanValue2) {
            obj = iVar2.k(jVar, new K2.b(4));
        }
        return iVar3.j((K2.i) obj);
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final C0232g c(K2.d dVar) {
        C0232g c0232g;
        C0232g c0232g2;
        if (!(dVar instanceof g3.f)) {
            return new C0232g(1, dVar);
        }
        g3.f fVar = (g3.f) dVar;
        R1.c cVar = g3.a.f3772c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g3.f.f3782m;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            c0232g = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(fVar, cVar);
                c0232g2 = null;
                break;
            }
            if (obj instanceof C0232g) {
                while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, cVar)) {
                    if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                        break;
                    }
                }
                c0232g2 = (C0232g) obj;
                break loop0;
            }
            if (obj != cVar && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (c0232g2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C0232g.f3274l;
            Object obj2 = atomicReferenceFieldUpdater2.get(c0232g2);
            if ((obj2 instanceof C0239n) && ((C0239n) obj2).f3287d != null) {
                c0232g2.o();
            } else {
                C0232g.k.set(c0232g2, 536870911);
                atomicReferenceFieldUpdater2.set(c0232g2, C0227b.f3266a);
                c0232g = c0232g2;
            }
            if (c0232g != null) {
                return c0232g;
            }
        }
        return new C0232g(2, dVar);
    }

    public static final void d(K2.i iVar, Throwable th) {
        try {
            c3.b bVar = (c3.b) iVar.e(r.f3294f);
            if (bVar != null) {
                bVar.d(th);
            } else {
                g3.a.d(iVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                AbstractC0286a.a(runtimeException, th);
                th = runtimeException;
            }
            g3.a.d(iVar, th);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T2.g, b3.Q, java.lang.Object] */
    public static final B e(N n3, boolean z, S s3) {
        S c0234i;
        if (n3 instanceof W) {
            return ((W) n3).D(z, s3);
        }
        boolean j4 = s3.j();
        ?? gVar = new T2.g(1, s3, S.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 0);
        W w2 = (W) n3;
        if (j4) {
            c0234i = new M(gVar);
        } else {
            c0234i = new C0234i(1, gVar);
        }
        return w2.D(z, c0234i);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [b3.b0, b3.a] */
    public static b0 f(InterfaceC0243s interfaceC0243s, S2.p pVar) {
        K2.i a4 = a(interfaceC0243s.f(), K2.j.f942f, true);
        i3.e eVar = A.f3236a;
        if (a4 != eVar && a4.e(K2.e.f941f) == null) {
            a4 = a4.j(eVar);
        }
        ?? abstractC0226a = new AbstractC0226a(a4, true);
        abstractC0226a.T(EnumC0244t.f3296f, abstractC0226a, pVar);
        return abstractC0226a;
    }

    public static final Object g(Object obj) {
        if (obj instanceof C0240o) {
            return k3.b.f(((C0240o) obj).f3290a);
        }
        return obj;
    }

    public static final void h(C0232g c0232g, K2.d dVar, boolean z) {
        Object f4;
        g0 g0Var;
        Object obj = C0232g.f3274l.get(c0232g);
        Throwable e4 = c0232g.e(obj);
        if (e4 != null) {
            f4 = k3.b.f(e4);
        } else {
            f4 = c0232g.f(obj);
        }
        if (z) {
            T2.h.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            g3.f fVar = (g3.f) dVar;
            M2.c cVar = fVar.f3784j;
            Object obj2 = fVar.f3785l;
            K2.i context = cVar.getContext();
            Object l3 = g3.a.l(context, obj2);
            if (l3 != g3.a.f3773d) {
                g0Var = l(cVar, context, l3);
            } else {
                g0Var = null;
            }
            try {
                cVar.resumeWith(f4);
                if (g0Var != null && !g0Var.U()) {
                    return;
                }
                g3.a.g(context, l3);
                return;
            } catch (Throwable th) {
                if (g0Var == null || g0Var.U()) {
                    g3.a.g(context, l3);
                }
                throw th;
            }
        }
        dVar.resumeWith(f4);
    }

    public static Object i(S2.p pVar) {
        long j4;
        C0240o c0240o;
        Thread currentThread = Thread.currentThread();
        G a4 = e0.a();
        K2.i a5 = a(K2.j.f942f, a4, true);
        i3.e eVar = A.f3236a;
        if (a5 != eVar && a5.e(K2.e.f941f) == null) {
            a5 = a5.j(eVar);
        }
        C0228c c0228c = new C0228c(a5, currentThread, a4);
        c0228c.T(EnumC0244t.f3296f, c0228c, pVar);
        G g4 = c0228c.f3268j;
        if (g4 != null) {
            int i4 = G.k;
            g4.l(false);
        }
        while (!Thread.interrupted()) {
            try {
                if (g4 != null) {
                    j4 = g4.m();
                } else {
                    j4 = Long.MAX_VALUE;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = W.f3262f;
                if (atomicReferenceFieldUpdater.get(c0228c) instanceof K) {
                    LockSupport.parkNanos(c0228c, j4);
                } else {
                    if (g4 != null) {
                        int i5 = G.k;
                        g4.h(false);
                    }
                    Object k = k(atomicReferenceFieldUpdater.get(c0228c));
                    if (k instanceof C0240o) {
                        c0240o = (C0240o) k;
                    } else {
                        c0240o = null;
                    }
                    if (c0240o == null) {
                        return k;
                    }
                    throw c0240o.f3290a;
                }
            } catch (Throwable th) {
                if (g4 != null) {
                    int i6 = G.k;
                    g4.h(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        c0228c.o(interruptedException);
        throw interruptedException;
    }

    public static final String j(K2.d dVar) {
        Object f4;
        if (dVar instanceof g3.f) {
            return ((g3.f) dVar).toString();
        }
        try {
            f4 = dVar + '@' + b(dVar);
        } catch (Throwable th) {
            f4 = k3.b.f(th);
        }
        if (H2.f.a(f4) != null) {
            f4 = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) f4;
    }

    public static final Object k(Object obj) {
        L l3;
        K k;
        if (obj instanceof L) {
            l3 = (L) obj;
        } else {
            l3 = null;
        }
        if (l3 != null && (k = l3.f3247a) != null) {
            return k;
        }
        return obj;
    }

    public static final g0 l(K2.d dVar, K2.i iVar, Object obj) {
        g0 g0Var = null;
        if ((dVar instanceof M2.d) && iVar.e(h0.f3280f) != null) {
            M2.d dVar2 = (M2.d) dVar;
            while (true) {
                if ((dVar2 instanceof C0249y) || (dVar2 = dVar2.d()) == null) {
                    break;
                }
                if (dVar2 instanceof g0) {
                    g0Var = (g0) dVar2;
                    break;
                }
            }
            if (g0Var != null) {
                g0Var.V(iVar, obj);
            }
        }
        return g0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object m(K2.i iVar, S2.p pVar, M2.h hVar) {
        K2.i a4;
        K2.i iVar2 = hVar.f1052g;
        T2.h.b(iVar2);
        if (!((Boolean) iVar.k(Boolean.FALSE, new K2.b(2))).booleanValue()) {
            a4 = iVar2.j(iVar);
        } else {
            a4 = a(iVar2, iVar, false);
        }
        N n3 = (N) a4.e(r.f3295g);
        if (n3 != null && !n3.a()) {
            throw ((W) n3).w();
        }
        if (a4 == iVar2) {
            g3.q qVar = new g3.q(hVar, a4);
            return AbstractC0141a.G(qVar, qVar, pVar);
        }
        K2.e eVar = K2.e.f941f;
        if (T2.h.a(a4.e(eVar), iVar2.e(eVar))) {
            g0 g0Var = new g0(a4, hVar);
            K2.i iVar3 = g0Var.f3265h;
            Object l3 = g3.a.l(iVar3, null);
            try {
                return AbstractC0141a.G(g0Var, g0Var, pVar);
            } finally {
                g3.a.g(iVar3, l3);
            }
        }
        g3.q qVar2 = new g3.q(hVar, a4);
        try {
            g3.a.h(k3.b.r(((M2.a) pVar).i(qVar2, qVar2)), H2.i.f681a);
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C0249y.f3311j;
            do {
                int i4 = atomicIntegerFieldUpdater.get(qVar2);
                if (i4 != 0) {
                    if (i4 == 2) {
                        Object k = k(W.f3262f.get(qVar2));
                        if (k instanceof C0240o) {
                            throw ((C0240o) k).f3290a;
                        }
                        return k;
                    }
                    throw new IllegalStateException("Already suspended");
                }
            } while (!atomicIntegerFieldUpdater.compareAndSet(qVar2, 0, 1));
            return L2.a.f1019f;
        } catch (Throwable th) {
            qVar2.resumeWith(k3.b.f(th));
            throw th;
        }
    }
}

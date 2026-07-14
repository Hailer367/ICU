package l1;

import a.AbstractC0051a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* renamed from: l1.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0244w {

    /* renamed from: a, reason: collision with root package name */
    public static final F.h f3016a;

    /* renamed from: b, reason: collision with root package name */
    public static final F.h f3017b;

    /* renamed from: c, reason: collision with root package name */
    public static final F.h f3018c;

    /* renamed from: d, reason: collision with root package name */
    public static final F.h f3019d;

    /* renamed from: e, reason: collision with root package name */
    public static final F.h f3020e;

    /* renamed from: f, reason: collision with root package name */
    public static final F.h f3021f;

    /* renamed from: g, reason: collision with root package name */
    public static final F.h f3022g;

    /* renamed from: h, reason: collision with root package name */
    public static final E f3023h = new E(false);

    /* renamed from: i, reason: collision with root package name */
    public static final E f3024i = new E(true);

    static {
        int i2 = 17;
        f3016a = new F.h(i2, "RESUME_TOKEN");
        f3017b = new F.h(i2, "CLOSED_EMPTY");
        f3018c = new F.h(i2, "COMPLETING_ALREADY");
        f3019d = new F.h(i2, "COMPLETING_WAITING_CHILDREN");
        f3020e = new F.h(i2, "COMPLETING_RETRY");
        f3021f = new F.h(i2, "TOO_LATE_TO_CANCEL");
        f3022g = new F.h(i2, "SEALED");
    }

    public static final T0.i a(T0.i iVar, T0.i iVar2, boolean z) {
        Boolean bool = Boolean.FALSE;
        boolean booleanValue = ((Boolean) iVar.c(bool, new T0.b(2))).booleanValue();
        boolean booleanValue2 = ((Boolean) iVar2.c(bool, new T0.b(2))).booleanValue();
        if (!booleanValue && !booleanValue2) {
            return iVar.d(iVar2);
        }
        T0.b bVar = new T0.b(3);
        T0.j jVar = T0.j.f774c;
        T0.i iVar3 = (T0.i) iVar.c(jVar, bVar);
        Object obj = iVar2;
        if (booleanValue2) {
            obj = iVar2.c(jVar, new T0.b(4));
        }
        return iVar3.d((T0.i) obj);
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final C0230h c(T0.d dVar) {
        C0230h c0230h;
        C0230h c0230h2;
        if (!(dVar instanceof q1.f)) {
            return new C0230h(1, dVar);
        }
        q1.f fVar = (q1.f) dVar;
        F.h hVar = q1.a.f3505c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = q1.f.f3515j;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            c0230h = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(fVar, hVar);
                c0230h2 = null;
                break;
            }
            if (obj instanceof C0230h) {
                while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, hVar)) {
                    if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                        break;
                    }
                }
                c0230h2 = (C0230h) obj;
                break loop0;
            }
            if (obj != hVar && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (c0230h2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C0230h.f2991i;
            Object obj2 = atomicReferenceFieldUpdater2.get(c0230h2);
            if ((obj2 instanceof C0237o) && ((C0237o) obj2).f3004d != null) {
                c0230h2.n();
            } else {
                C0230h.f2990h.set(c0230h2, 536870911);
                atomicReferenceFieldUpdater2.set(c0230h2, C0224b.f2980a);
                c0230h = c0230h2;
            }
            if (c0230h != null) {
                return c0230h;
            }
        }
        return new C0230h(2, dVar);
    }

    public static final void d(T0.i iVar, Throwable th) {
        try {
            m1.b bVar = (m1.b) iVar.k(C0241t.f3011c);
            if (bVar != null) {
                bVar.e(th);
            } else {
                q1.a.d(iVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                android.support.v4.media.session.a.c(runtimeException, th);
                th = runtimeException;
            }
            q1.a.d(iVar, th);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, l1.S, kotlin.jvm.internal.g] */
    public static final D e(O o2, boolean z, T t2) {
        T c0232j;
        if (o2 instanceof X) {
            return ((X) o2).C(z, t2);
        }
        boolean j2 = t2.j();
        ?? gVar = new kotlin.jvm.internal.g(1, t2, T.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 0);
        X x2 = (X) o2;
        if (j2) {
            c0232j = new N(gVar);
        } else {
            c0232j = new C0232j(1, gVar);
        }
        return x2.C(z, c0232j);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [l1.a, l1.c0] */
    public static c0 f(InterfaceC0242u interfaceC0242u, c1.p pVar) {
        EnumC0243v enumC0243v = EnumC0243v.f3013c;
        T0.i a2 = a(interfaceC0242u.e(), T0.j.f774c, true);
        s1.e eVar = C.f2950a;
        if (a2 != eVar && a2.k(T0.e.f773c) == null) {
            a2 = a2.d(eVar);
        }
        EnumC0243v enumC0243v2 = EnumC0243v.f3013c;
        ?? abstractC0223a = new AbstractC0223a(a2, true);
        abstractC0223a.S(enumC0243v, abstractC0223a, pVar);
        return abstractC0223a;
    }

    public static final Object g(Object obj) {
        if (obj instanceof C0238p) {
            return AbstractC0051a.j(((C0238p) obj).f3007a);
        }
        return obj;
    }

    public static final void h(C0230h c0230h, T0.d dVar, boolean z) {
        Object e2;
        h0 h0Var;
        Object obj = C0230h.f2991i.get(c0230h);
        Throwable d2 = c0230h.d(obj);
        if (d2 != null) {
            e2 = AbstractC0051a.j(d2);
        } else {
            e2 = c0230h.e(obj);
        }
        if (z) {
            kotlin.jvm.internal.h.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            q1.f fVar = (q1.f) dVar;
            V0.c cVar = fVar.f3517g;
            Object obj2 = fVar.f3519i;
            T0.i context = cVar.getContext();
            Object l2 = q1.a.l(context, obj2);
            if (l2 != q1.a.f3506d) {
                h0Var = l(cVar, context, l2);
            } else {
                h0Var = null;
            }
            try {
                cVar.resumeWith(e2);
                if (h0Var != null && !h0Var.T()) {
                    return;
                }
                q1.a.g(context, l2);
                return;
            } catch (Throwable th) {
                if (h0Var == null || h0Var.T()) {
                    q1.a.g(context, l2);
                }
                throw th;
            }
        }
        dVar.resumeWith(e2);
    }

    public static Object i(c1.p pVar) {
        long j2;
        C0238p c0238p;
        Thread currentThread = Thread.currentThread();
        H a2 = f0.a();
        T0.i a3 = a(T0.j.f774c, a2, true);
        s1.e eVar = C.f2950a;
        if (a3 != eVar && a3.k(T0.e.f773c) == null) {
            a3 = a3.d(eVar);
        }
        C0225c c0225c = new C0225c(a3, currentThread, a2);
        c0225c.S(EnumC0243v.f3013c, c0225c, pVar);
        H h2 = c0225c.f2982g;
        if (h2 != null) {
            int i2 = H.f2955h;
            h2.l(false);
        }
        while (!Thread.interrupted()) {
            try {
                if (h2 != null) {
                    j2 = h2.m();
                } else {
                    j2 = Long.MAX_VALUE;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = X.f2976c;
                if (atomicReferenceFieldUpdater.get(c0225c) instanceof L) {
                    LockSupport.parkNanos(c0225c, j2);
                } else {
                    if (h2 != null) {
                        int i3 = H.f2955h;
                        h2.i(false);
                    }
                    Object k2 = k(atomicReferenceFieldUpdater.get(c0225c));
                    if (k2 instanceof C0238p) {
                        c0238p = (C0238p) k2;
                    } else {
                        c0238p = null;
                    }
                    if (c0238p == null) {
                        return k2;
                    }
                    throw c0238p.f3007a;
                }
            } catch (Throwable th) {
                if (h2 != null) {
                    int i4 = H.f2955h;
                    h2.i(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        c0225c.n(interruptedException);
        throw interruptedException;
    }

    public static final String j(T0.d dVar) {
        Object j2;
        if (dVar instanceof q1.f) {
            return ((q1.f) dVar).toString();
        }
        try {
            j2 = dVar + '@' + b(dVar);
        } catch (Throwable th) {
            j2 = AbstractC0051a.j(th);
        }
        if (Q0.g.a(j2) != null) {
            j2 = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) j2;
    }

    public static final Object k(Object obj) {
        M m2;
        L l2;
        if (obj instanceof M) {
            m2 = (M) obj;
        } else {
            m2 = null;
        }
        if (m2 != null && (l2 = m2.f2961a) != null) {
            return l2;
        }
        return obj;
    }

    public static final h0 l(T0.d dVar, T0.i iVar, Object obj) {
        h0 h0Var = null;
        if ((dVar instanceof V0.d) && iVar.k(i0.f2997c) != null) {
            V0.d dVar2 = (V0.d) dVar;
            while (true) {
                if ((dVar2 instanceof A) || (dVar2 = dVar2.getCallerFrame()) == null) {
                    break;
                }
                if (dVar2 instanceof h0) {
                    h0Var = (h0) dVar2;
                    break;
                }
            }
            if (h0Var != null) {
                h0Var.U(iVar, obj);
            }
        }
        return h0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object m(T0.i iVar, c1.p pVar, T0.d dVar) {
        T0.i a2;
        Object k2;
        T0.i context = dVar.getContext();
        if (!((Boolean) iVar.c(Boolean.FALSE, new T0.b(2))).booleanValue()) {
            a2 = context.d(iVar);
        } else {
            a2 = a(context, iVar, false);
        }
        O o2 = (O) a2.k(C0241t.f3012d);
        if (o2 != null && !o2.a()) {
            throw ((X) o2).v();
        }
        if (a2 == context) {
            q1.q qVar = new q1.q(dVar, a2);
            k2 = android.support.v4.media.session.a.G(qVar, qVar, pVar);
        } else {
            T0.e eVar = T0.e.f773c;
            if (kotlin.jvm.internal.h.a(a2.k(eVar), context.k(eVar))) {
                h0 h0Var = new h0(dVar, a2);
                T0.i iVar2 = h0Var.f2979e;
                Object l2 = q1.a.l(iVar2, null);
                try {
                    Object G2 = android.support.v4.media.session.a.G(h0Var, h0Var, pVar);
                    q1.a.g(iVar2, l2);
                    k2 = G2;
                } catch (Throwable th) {
                    q1.a.g(iVar2, l2);
                    throw th;
                }
            } else {
                q1.q qVar2 = new q1.q(dVar, a2);
                try {
                    q1.a.h(android.support.v4.media.session.a.v(((V0.a) pVar).create(qVar2, qVar2)), Q0.j.f722a);
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = A.f2948g;
                    while (true) {
                        int i2 = atomicIntegerFieldUpdater.get(qVar2);
                        if (i2 != 0) {
                            if (i2 == 2) {
                                k2 = k(X.f2976c.get(qVar2));
                                if (k2 instanceof C0238p) {
                                    throw ((C0238p) k2).f3007a;
                                }
                            } else {
                                throw new IllegalStateException("Already suspended");
                            }
                        } else if (atomicIntegerFieldUpdater.compareAndSet(qVar2, 0, 1)) {
                            k2 = U0.a.f780c;
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    qVar2.resumeWith(AbstractC0051a.j(th2));
                    throw th2;
                }
            }
        }
        U0.a aVar = U0.a.f780c;
        return k2;
    }
}

package b3;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: b3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0232g extends AbstractC0250z implements InterfaceC0230e, M2.d, i0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(C0232g.class, "_decisionAndIndex$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3274l = AtomicReferenceFieldUpdater.newUpdater(C0232g.class, Object.class, "_state$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3275m = AtomicReferenceFieldUpdater.newUpdater(C0232g.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: i, reason: collision with root package name */
    public final K2.d f3276i;

    /* renamed from: j, reason: collision with root package name */
    public final K2.i f3277j;

    public C0232g(int i4, K2.d dVar) {
        super(i4);
        this.f3276i = dVar;
        this.f3277j = dVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = C0227b.f3266a;
    }

    public static Object B(Z z, Object obj, int i4, S2.q qVar) {
        C c4;
        if (obj instanceof C0240o) {
            return obj;
        }
        if (i4 != 1 && i4 != 2) {
            return obj;
        }
        if (qVar == null && !(z instanceof C)) {
            return obj;
        }
        if (z instanceof C) {
            c4 = (C) z;
        } else {
            c4 = null;
        }
        return new C0239n(obj, c4, qVar, (CancellationException) null, 16);
    }

    public static void w(Z z, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + z + ", already has " + obj).toString());
    }

    public final void A(Object obj, int i4, S2.q qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3274l;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof Z) {
                Object B3 = B((Z) obj2, obj, i4, qVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, B3)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!v()) {
                    o();
                }
                p(i4);
                return;
            }
            if (obj2 instanceof C0233h) {
                C0233h c0233h = (C0233h) obj2;
                c0233h.getClass();
                if (C0233h.f3279c.compareAndSet(c0233h, 0, 1)) {
                    if (qVar != null) {
                        k(qVar, c0233h.f3290a, obj);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }

    @Override // b3.i0
    public final void a(g3.r rVar, int i4) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i5;
        do {
            atomicIntegerFieldUpdater = k;
            i5 = atomicIntegerFieldUpdater.get(this);
            if ((i5 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, ((i5 >> 29) << 29) + i4));
        u(rVar);
    }

    @Override // b3.AbstractC0250z
    public final void b(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3274l;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof Z)) {
                if (!(obj instanceof C0240o)) {
                    if (obj instanceof C0239n) {
                        C0239n c0239n = (C0239n) obj;
                        if (c0239n.f3288e == null) {
                            C0239n a4 = C0239n.a(c0239n, null, cancellationException, 15);
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, a4)) {
                                if (atomicReferenceFieldUpdater.get(this) != obj) {
                                    cancellationException2 = cancellationException;
                                }
                            }
                            C c4 = c0239n.f3285b;
                            if (c4 != null) {
                                j(c4);
                            }
                            S2.q qVar = c0239n.f3286c;
                            if (qVar != null) {
                                k(qVar, cancellationException, c0239n.f3284a);
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException("Must be called at most once");
                    }
                    cancellationException2 = cancellationException;
                    C0239n c0239n2 = new C0239n(obj, (C) null, (S2.q) null, cancellationException2, 14);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0239n2)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    return;
                    cancellationException = cancellationException2;
                } else {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed");
            }
        }
    }

    @Override // b3.AbstractC0250z
    public final K2.d c() {
        return this.f3276i;
    }

    @Override // M2.d
    public final M2.d d() {
        K2.d dVar = this.f3276i;
        if (dVar instanceof M2.d) {
            return (M2.d) dVar;
        }
        return null;
    }

    @Override // b3.AbstractC0250z
    public final Throwable e(Object obj) {
        Throwable e4 = super.e(obj);
        if (e4 != null) {
            return e4;
        }
        return null;
    }

    @Override // b3.AbstractC0250z
    public final Object f(Object obj) {
        if (obj instanceof C0239n) {
            return ((C0239n) obj).f3284a;
        }
        return obj;
    }

    @Override // K2.d
    public final K2.i getContext() {
        return this.f3277j;
    }

    @Override // b3.InterfaceC0230e
    public final R1.c h(Object obj, S2.q qVar) {
        R1.c cVar = AbstractC0245u.f3299a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3274l;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof Z) {
                Object B3 = B((Z) obj2, obj, this.f3312h, qVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, B3)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!v()) {
                    o();
                }
                return cVar;
            }
            return null;
        }
    }

    @Override // b3.AbstractC0250z
    public final Object i() {
        return f3274l.get(this);
    }

    public final void j(C c4) {
        try {
            c4.f3237a.dispose();
        } catch (Throwable th) {
            AbstractC0245u.d(this.f3277j, new RuntimeException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    public final void k(S2.q qVar, Throwable th, Object obj) {
        K2.i iVar = this.f3277j;
        try {
            qVar.c(th, obj, iVar);
        } catch (Throwable th2) {
            AbstractC0245u.d(iVar, new RuntimeException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // b3.InterfaceC0230e
    public final void l(Object obj) {
        p(this.f3312h);
    }

    public final void m(g3.r rVar, Throwable th) {
        K2.i iVar = this.f3277j;
        int i4 = k.get(this) & 536870911;
        if (i4 != 536870911) {
            try {
                rVar.g(i4, iVar);
                return;
            } catch (Throwable th2) {
                AbstractC0245u.d(iVar, new RuntimeException("Exception in invokeOnCancellation handler for " + this, th2));
                return;
            }
        }
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
    }

    public final void n(Throwable th) {
        boolean z;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3274l;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof Z)) {
                return;
            }
            if (!(obj instanceof C) && !(obj instanceof g3.r)) {
                z = false;
            } else {
                z = true;
            }
            C0233h c0233h = new C0233h(this, th, z);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0233h)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            Z z3 = (Z) obj;
            if (z3 instanceof C) {
                j((C) obj);
            } else if (z3 instanceof g3.r) {
                m((g3.r) obj, th);
            }
            if (!v()) {
                o();
            }
            p(this.f3312h);
            return;
        }
    }

    public final void o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3275m;
        B b4 = (B) atomicReferenceFieldUpdater.get(this);
        if (b4 == null) {
            return;
        }
        b4.dispose();
        atomicReferenceFieldUpdater.set(this, Y.f3264a);
    }

    public final void p(int i4) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i5;
        boolean z;
        boolean z3;
        do {
            atomicIntegerFieldUpdater = k;
            i5 = atomicIntegerFieldUpdater.get(this);
            int i6 = i5 >> 29;
            if (i6 != 0) {
                if (i6 == 1) {
                    boolean z4 = false;
                    if (i4 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    K2.d dVar = this.f3276i;
                    if (!z && (dVar instanceof g3.f)) {
                        if (i4 != 1 && i4 != 2) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        int i7 = this.f3312h;
                        if (i7 == 1 || i7 == 2) {
                            z4 = true;
                        }
                        if (z3 == z4) {
                            g3.f fVar = (g3.f) dVar;
                            AbstractC0242q abstractC0242q = fVar.f3783i;
                            K2.i context = fVar.f3784j.getContext();
                            if (abstractC0242q.f(context)) {
                                abstractC0242q.d(context, this);
                                return;
                            }
                            G a4 = e0.a();
                            if (a4.f3242h >= 4294967296L) {
                                I2.c cVar = a4.f3244j;
                                if (cVar == null) {
                                    cVar = new I2.c();
                                    a4.f3244j = cVar;
                                }
                                cVar.addLast(this);
                                return;
                            }
                            a4.l(true);
                            try {
                                AbstractC0245u.h(this, dVar, true);
                                do {
                                } while (a4.n());
                            } finally {
                                try {
                                    return;
                                } finally {
                                }
                            }
                            return;
                        }
                    }
                    AbstractC0245u.h(this, dVar, z);
                    return;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, 1073741824 + (536870911 & i5)));
    }

    public Throwable q(W w2) {
        return w2.w();
    }

    public final Object r() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i4;
        N n3;
        boolean v3 = v();
        do {
            atomicIntegerFieldUpdater = k;
            i4 = atomicIntegerFieldUpdater.get(this);
            int i5 = i4 >> 29;
            if (i5 != 0) {
                if (i5 == 2) {
                    if (v3) {
                        y();
                    }
                    Object obj = f3274l.get(this);
                    if (!(obj instanceof C0240o)) {
                        int i6 = this.f3312h;
                        if ((i6 == 1 || i6 == 2) && (n3 = (N) this.f3277j.e(r.f3295g)) != null && !n3.a()) {
                            CancellationException w2 = ((W) n3).w();
                            b(w2);
                            throw w2;
                        }
                        return f(obj);
                    }
                    throw ((C0240o) obj).f3290a;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, 536870912 + (536870911 & i4)));
        if (((B) f3275m.get(this)) == null) {
            t();
        }
        if (v3) {
            y();
        }
        return L2.a.f1019f;
    }

    @Override // K2.d
    public final void resumeWith(Object obj) {
        Throwable a4 = H2.f.a(obj);
        if (a4 != null) {
            obj = new C0240o(a4, false);
        }
        A(obj, this.f3312h, null);
    }

    public final void s() {
        B t3 = t();
        if (t3 != null && !(f3274l.get(this) instanceof Z)) {
            t3.dispose();
            f3275m.set(this, Y.f3264a);
        }
    }

    public final B t() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        N n3 = (N) this.f3277j.e(r.f3295g);
        if (n3 == null) {
            return null;
        }
        B e4 = AbstractC0245u.e(n3, true, new C0234i(0, this));
        do {
            atomicReferenceFieldUpdater = f3275m;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, e4)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return e4;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(x());
        sb.append('(');
        sb.append(AbstractC0245u.j(this.f3276i));
        sb.append("){");
        Object obj = f3274l.get(this);
        if (obj instanceof Z) {
            str = "Active";
        } else if (obj instanceof C0233h) {
            str = "Cancelled";
        } else {
            str = "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(AbstractC0245u.b(this));
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00aa, code lost:
    
        w(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ad, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(b3.Z r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = b3.C0232g.f3274l
            java.lang.Object r2 = r0.get(r7)
            boolean r1 = r2 instanceof b3.C0227b
            if (r1 == 0) goto L19
        La:
            boolean r1 = r0.compareAndSet(r7, r2, r8)
            if (r1 == 0) goto L12
            goto La1
        L12:
            java.lang.Object r1 = r0.get(r7)
            if (r1 == r2) goto La
            goto L0
        L19:
            boolean r1 = r2 instanceof b3.C
            r3 = 0
            if (r1 != 0) goto Laa
            boolean r1 = r2 instanceof g3.r
            if (r1 != 0) goto Laa
            boolean r1 = r2 instanceof b3.C0240o
            if (r1 == 0) goto L56
            r0 = r2
            b3.o r0 = (b3.C0240o) r0
            r0.getClass()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = b3.C0240o.f3289b
            r4 = 0
            r5 = 1
            boolean r1 = r1.compareAndSet(r0, r4, r5)
            if (r1 == 0) goto L52
            boolean r1 = r2 instanceof b3.C0233h
            if (r1 == 0) goto La1
            if (r2 == 0) goto L3d
            goto L3e
        L3d:
            r0 = r3
        L3e:
            if (r0 == 0) goto L42
            java.lang.Throwable r3 = r0.f3290a
        L42:
            boolean r0 = r8 instanceof b3.C
            if (r0 == 0) goto L4c
            b3.C r8 = (b3.C) r8
            r7.j(r8)
            return
        L4c:
            g3.r r8 = (g3.r) r8
            r7.m(r8, r3)
            return
        L52:
            w(r8, r2)
            throw r3
        L56:
            boolean r1 = r2 instanceof b3.C0239n
            if (r1 == 0) goto L8a
            r1 = r2
            b3.n r1 = (b3.C0239n) r1
            b3.C r4 = r1.f3285b
            if (r4 != 0) goto L86
            boolean r4 = r8 instanceof g3.r
            if (r4 == 0) goto L66
            goto La1
        L66:
            r4 = r8
            b3.C r4 = (b3.C) r4
            java.lang.Throwable r5 = r1.f3288e
            if (r5 == 0) goto L71
            r7.j(r4)
            return
        L71:
            r5 = 29
            b3.n r1 = b3.C0239n.a(r1, r4, r3, r5)
        L77:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L7e
            goto La1
        L7e:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L77
            goto L0
        L86:
            w(r8, r2)
            throw r3
        L8a:
            boolean r1 = r8 instanceof g3.r
            if (r1 == 0) goto L8f
            goto La1
        L8f:
            r3 = r8
            b3.C r3 = (b3.C) r3
            b3.n r1 = new b3.n
            r5 = 0
            r6 = 28
            r4 = 0
            r1.<init>(r2, r3, r4, r5, r6)
        L9b:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto La2
        La1:
            return
        La2:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L9b
            goto L0
        Laa:
            w(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.C0232g.u(b3.Z):void");
    }

    public final boolean v() {
        if (this.f3312h == 2) {
            K2.d dVar = this.f3276i;
            T2.h.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (g3.f.f3782m.get((g3.f) dVar) != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String x() {
        return "CancellableContinuation";
    }

    public final void y() {
        g3.f fVar;
        K2.d dVar = this.f3276i;
        Throwable th = null;
        if (dVar instanceof g3.f) {
            fVar = (g3.f) dVar;
        } else {
            fVar = null;
        }
        if (fVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g3.f.f3782m;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                R1.c cVar = g3.a.f3772c;
                if (obj != cVar) {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(fVar, cVar, this)) {
                    if (atomicReferenceFieldUpdater.get(fVar) != cVar) {
                        break;
                    }
                }
            }
            if (th != null) {
                o();
                n(th);
            }
        }
    }

    public final void z(Object obj, S2.q qVar) {
        A(obj, this.f3312h, qVar);
    }
}

package l1;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: l1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0230h extends B implements InterfaceC0228f, V0.d, j0 {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2990h = AtomicIntegerFieldUpdater.newUpdater(C0230h.class, "_decisionAndIndex$volatile");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2991i = AtomicReferenceFieldUpdater.newUpdater(C0230h.class, Object.class, "_state$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2992j = AtomicReferenceFieldUpdater.newUpdater(C0230h.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: f, reason: collision with root package name */
    public final T0.d f2993f;

    /* renamed from: g, reason: collision with root package name */
    public final T0.i f2994g;

    public C0230h(int i2, T0.d dVar) {
        super(i2);
        this.f2993f = dVar;
        this.f2994g = dVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = C0224b.f2980a;
    }

    public static Object A(a0 a0Var, Object obj, int i2, c1.q qVar) {
        C0227e c0227e;
        if (obj instanceof C0238p) {
            return obj;
        }
        if (i2 != 1 && i2 != 2) {
            return obj;
        }
        if (qVar == null && !(a0Var instanceof C0227e)) {
            return obj;
        }
        if (a0Var instanceof C0227e) {
            c0227e = (C0227e) a0Var;
        } else {
            c0227e = null;
        }
        return new C0237o(obj, c0227e, qVar, (CancellationException) null, 16);
    }

    public static void v(a0 a0Var, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + a0Var + ", already has " + obj).toString());
    }

    @Override // l1.j0
    public final void a(q1.r rVar, int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = f2990h;
            i3 = atomicIntegerFieldUpdater.get(this);
            if ((i3 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, ((i3 >> 29) << 29) + i2));
        t(rVar);
    }

    @Override // l1.B
    public final void b(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2991i;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof a0)) {
                if (!(obj instanceof C0238p)) {
                    if (obj instanceof C0237o) {
                        C0237o c0237o = (C0237o) obj;
                        if (c0237o.f3005e == null) {
                            C0237o a2 = C0237o.a(c0237o, null, cancellationException, 15);
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, a2)) {
                                if (atomicReferenceFieldUpdater.get(this) != obj) {
                                    cancellationException2 = cancellationException;
                                }
                            }
                            C0227e c0227e = c0237o.f3002b;
                            if (c0227e != null) {
                                i(c0227e, cancellationException);
                            }
                            c1.q qVar = c0237o.f3003c;
                            if (qVar != null) {
                                k(qVar, cancellationException, c0237o.f3001a);
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException("Must be called at most once");
                    }
                    cancellationException2 = cancellationException;
                    C0237o c0237o2 = new C0237o(obj, (C0227e) null, (c1.q) null, cancellationException2, 14);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0237o2)) {
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

    @Override // l1.B
    public final T0.d c() {
        return this.f2993f;
    }

    @Override // l1.B
    public final Throwable d(Object obj) {
        Throwable d2 = super.d(obj);
        if (d2 != null) {
            return d2;
        }
        return null;
    }

    @Override // l1.B
    public final Object e(Object obj) {
        if (obj instanceof C0237o) {
            return ((C0237o) obj).f3001a;
        }
        return obj;
    }

    @Override // l1.InterfaceC0228f
    public final F.h f(Object obj, c1.q qVar) {
        F.h hVar = AbstractC0244w.f3016a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2991i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof a0) {
                Object A2 = A((a0) obj2, obj, this.f2949e, qVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, A2)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!u()) {
                    n();
                }
                return hVar;
            }
            return null;
        }
    }

    @Override // V0.d
    public final V0.d getCallerFrame() {
        T0.d dVar = this.f2993f;
        if (dVar instanceof V0.d) {
            return (V0.d) dVar;
        }
        return null;
    }

    @Override // T0.d
    public final T0.i getContext() {
        return this.f2994g;
    }

    @Override // l1.B
    public final Object h() {
        return f2991i.get(this);
    }

    public final void i(C0227e c0227e, Throwable th) {
        try {
            switch (c0227e.f2984a) {
                case 0:
                    ((c1.l) c0227e.f2985b).invoke(th);
                    return;
                default:
                    ((D) c0227e.f2985b).dispose();
                    return;
            }
        } catch (Throwable th2) {
            AbstractC0244w.d(this.f2994g, new RuntimeException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // l1.InterfaceC0228f
    public final void j(Object obj) {
        o(this.f2949e);
    }

    public final void k(c1.q qVar, Throwable th, Object obj) {
        T0.i iVar = this.f2994g;
        try {
            qVar.a(th, obj, iVar);
        } catch (Throwable th2) {
            AbstractC0244w.d(iVar, new RuntimeException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void l(q1.r rVar, Throwable th) {
        T0.i iVar = this.f2994g;
        int i2 = f2990h.get(this) & 536870911;
        if (i2 != 536870911) {
            try {
                rVar.g(i2, iVar);
                return;
            } catch (Throwable th2) {
                AbstractC0244w.d(iVar, new RuntimeException("Exception in invokeOnCancellation handler for " + this, th2));
                return;
            }
        }
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
    }

    public final void m(Throwable th) {
        boolean z;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2991i;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof a0)) {
                return;
            }
            if (!(obj instanceof C0227e) && !(obj instanceof q1.r)) {
                z = false;
            } else {
                z = true;
            }
            C0231i c0231i = new C0231i(this, th, z);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0231i)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            a0 a0Var = (a0) obj;
            if (a0Var instanceof C0227e) {
                i((C0227e) obj, th);
            } else if (a0Var instanceof q1.r) {
                l((q1.r) obj, th);
            }
            if (!u()) {
                n();
            }
            o(this.f2949e);
            return;
        }
    }

    public final void n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2992j;
        D d2 = (D) atomicReferenceFieldUpdater.get(this);
        if (d2 == null) {
            return;
        }
        d2.dispose();
        atomicReferenceFieldUpdater.set(this, Z.f2978a);
    }

    public final void o(int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        boolean z;
        boolean z2;
        do {
            atomicIntegerFieldUpdater = f2990h;
            i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = i3 >> 29;
            if (i4 != 0) {
                if (i4 == 1) {
                    boolean z3 = false;
                    if (i2 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    T0.d dVar = this.f2993f;
                    if (!z && (dVar instanceof q1.f)) {
                        if (i2 != 1 && i2 != 2) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        int i5 = this.f2949e;
                        if (i5 == 1 || i5 == 2) {
                            z3 = true;
                        }
                        if (z2 == z3) {
                            q1.f fVar = (q1.f) dVar;
                            AbstractC0240s abstractC0240s = fVar.f3516f;
                            T0.i context = fVar.f3517g.getContext();
                            if (abstractC0240s.f(context)) {
                                abstractC0240s.e(context, this);
                                return;
                            }
                            H a2 = f0.a();
                            if (a2.f2956e >= 4294967296L) {
                                R0.h hVar = a2.f2958g;
                                if (hVar == null) {
                                    hVar = new R0.h();
                                    a2.f2958g = hVar;
                                }
                                hVar.addLast(this);
                                return;
                            }
                            a2.l(true);
                            try {
                                AbstractC0244w.h(this, dVar, true);
                                do {
                                } while (a2.n());
                            } finally {
                                try {
                                    return;
                                } finally {
                                }
                            }
                            return;
                        }
                    }
                    AbstractC0244w.h(this, dVar, z);
                    return;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, 1073741824 + (536870911 & i3)));
    }

    public Throwable p(X x2) {
        return x2.v();
    }

    public final Object q() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        O o2;
        boolean u2 = u();
        do {
            atomicIntegerFieldUpdater = f2990h;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 == 2) {
                    if (u2) {
                        x();
                    }
                    Object obj = f2991i.get(this);
                    if (!(obj instanceof C0238p)) {
                        int i4 = this.f2949e;
                        if ((i4 == 1 || i4 == 2) && (o2 = (O) this.f2994g.k(C0241t.f3012d)) != null && !o2.a()) {
                            CancellationException v2 = ((X) o2).v();
                            b(v2);
                            throw v2;
                        }
                        return e(obj);
                    }
                    throw ((C0238p) obj).f3007a;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 536870912 + (536870911 & i2)));
        if (((D) f2992j.get(this)) == null) {
            s();
        }
        if (u2) {
            x();
        }
        return U0.a.f780c;
    }

    public final void r() {
        D s2 = s();
        if (s2 != null && !(f2991i.get(this) instanceof a0)) {
            s2.dispose();
            f2992j.set(this, Z.f2978a);
        }
    }

    @Override // T0.d
    public final void resumeWith(Object obj) {
        Throwable a2 = Q0.g.a(obj);
        if (a2 != null) {
            obj = new C0238p(a2, false);
        }
        z(obj, this.f2949e, null);
    }

    public final D s() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        O o2 = (O) this.f2994g.k(C0241t.f3012d);
        if (o2 == null) {
            return null;
        }
        D e2 = AbstractC0244w.e(o2, true, new C0232j(0, this));
        do {
            atomicReferenceFieldUpdater = f2992j;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, e2)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return e2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00aa, code lost:
    
        v(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ad, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(l1.a0 r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = l1.C0230h.f2991i
            java.lang.Object r2 = r0.get(r7)
            boolean r1 = r2 instanceof l1.C0224b
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
            boolean r1 = r2 instanceof l1.C0227e
            r3 = 0
            if (r1 != 0) goto Laa
            boolean r1 = r2 instanceof q1.r
            if (r1 != 0) goto Laa
            boolean r1 = r2 instanceof l1.C0238p
            if (r1 == 0) goto L56
            r0 = r2
            l1.p r0 = (l1.C0238p) r0
            r0.getClass()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = l1.C0238p.f3006b
            r4 = 0
            r5 = 1
            boolean r1 = r1.compareAndSet(r0, r4, r5)
            if (r1 == 0) goto L52
            boolean r1 = r2 instanceof l1.C0231i
            if (r1 == 0) goto La1
            if (r2 == 0) goto L3d
            goto L3e
        L3d:
            r0 = r3
        L3e:
            if (r0 == 0) goto L42
            java.lang.Throwable r3 = r0.f3007a
        L42:
            boolean r0 = r8 instanceof l1.C0227e
            if (r0 == 0) goto L4c
            l1.e r8 = (l1.C0227e) r8
            r7.i(r8, r3)
            return
        L4c:
            q1.r r8 = (q1.r) r8
            r7.l(r8, r3)
            return
        L52:
            v(r8, r2)
            throw r3
        L56:
            boolean r1 = r2 instanceof l1.C0237o
            if (r1 == 0) goto L8a
            r1 = r2
            l1.o r1 = (l1.C0237o) r1
            l1.e r4 = r1.f3002b
            if (r4 != 0) goto L86
            boolean r4 = r8 instanceof q1.r
            if (r4 == 0) goto L66
            goto La1
        L66:
            r4 = r8
            l1.e r4 = (l1.C0227e) r4
            java.lang.Throwable r5 = r1.f3005e
            if (r5 == 0) goto L71
            r7.i(r4, r5)
            return
        L71:
            r5 = 29
            l1.o r1 = l1.C0237o.a(r1, r4, r3, r5)
        L77:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L7e
            goto La1
        L7e:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L77
            goto L0
        L86:
            v(r8, r2)
            throw r3
        L8a:
            boolean r1 = r8 instanceof q1.r
            if (r1 == 0) goto L8f
            goto La1
        L8f:
            r3 = r8
            l1.e r3 = (l1.C0227e) r3
            l1.o r1 = new l1.o
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
            v(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.C0230h.t(l1.a0):void");
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(w());
        sb.append('(');
        sb.append(AbstractC0244w.j(this.f2993f));
        sb.append("){");
        Object obj = f2991i.get(this);
        if (obj instanceof a0) {
            str = "Active";
        } else if (obj instanceof C0231i) {
            str = "Cancelled";
        } else {
            str = "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(AbstractC0244w.b(this));
        return sb.toString();
    }

    public final boolean u() {
        if (this.f2949e == 2) {
            T0.d dVar = this.f2993f;
            kotlin.jvm.internal.h.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (q1.f.f3515j.get((q1.f) dVar) != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String w() {
        return "CancellableContinuation";
    }

    public final void x() {
        q1.f fVar;
        T0.d dVar = this.f2993f;
        Throwable th = null;
        if (dVar instanceof q1.f) {
            fVar = (q1.f) dVar;
        } else {
            fVar = null;
        }
        if (fVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = q1.f.f3515j;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                F.h hVar = q1.a.f3505c;
                if (obj != hVar) {
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
                while (!atomicReferenceFieldUpdater.compareAndSet(fVar, hVar, this)) {
                    if (atomicReferenceFieldUpdater.get(fVar) != hVar) {
                        break;
                    }
                }
            }
            if (th != null) {
                n();
                m(th);
            }
        }
    }

    public final void y(Object obj, c1.q qVar) {
        z(obj, this.f2949e, qVar);
    }

    public final void z(Object obj, int i2, c1.q qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2991i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof a0) {
                Object A2 = A((a0) obj2, obj, i2, qVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, A2)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!u()) {
                    n();
                }
                o(i2);
                return;
            }
            if (obj2 instanceof C0231i) {
                C0231i c0231i = (C0231i) obj2;
                c0231i.getClass();
                if (C0231i.f2996c.compareAndSet(c0231i, 0, 1)) {
                    if (qVar != null) {
                        k(qVar, c0231i.f3007a, obj);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }
}

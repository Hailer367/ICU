package l1;

import a.AbstractC0051a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class X implements O, b0 {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2976c = AtomicReferenceFieldUpdater.newUpdater(X.class, Object.class, "_state$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2977d = AtomicReferenceFieldUpdater.newUpdater(X.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public X(boolean z) {
        E e2;
        if (z) {
            e2 = AbstractC0244w.f3024i;
        } else {
            e2 = AbstractC0244w.f3023h;
        }
        this._state$volatile = e2;
    }

    public static C0234l G(q1.j jVar) {
        while (jVar.h()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = q1.j.f3527b;
            q1.j e2 = jVar.e();
            if (e2 == null) {
                Object obj = atomicReferenceFieldUpdater.get(jVar);
                while (true) {
                    jVar = (q1.j) obj;
                    if (!jVar.h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(jVar);
                }
            } else {
                jVar = e2;
            }
        }
        while (true) {
            jVar = jVar.g();
            if (!jVar.h()) {
                if (jVar instanceof C0234l) {
                    return (C0234l) jVar;
                }
                if (jVar instanceof Y) {
                    return null;
                }
            }
        }
    }

    public static String N(Object obj) {
        if (obj instanceof W) {
            W w2 = (W) obj;
            if (w2.e()) {
                return "Cancelling";
            }
            if (W.f2972b.get(w2) == 0) {
                return "Active";
            }
            return "Completing";
        }
        if (obj instanceof L) {
            if (((L) obj).a()) {
                return "Active";
            }
            return "New";
        }
        if (obj instanceof C0238p) {
            return "Cancelled";
        }
        return "Completed";
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
    
        if (r4 != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [l1.l, q1.j, l1.T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, l1.D] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r5v8, types: [l1.Y, q1.j] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(l1.O r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = l1.X.f2977d
            l1.Z r1 = l1.Z.f2978a
            if (r8 != 0) goto La
            r0.set(r7, r1)
            return
        La:
            l1.X r8 = (l1.X) r8
        Lc:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = l1.X.f2976c
            java.lang.Object r3 = r2.get(r8)
            int r3 = r8.M(r3)
            if (r3 == 0) goto L1c
            r4 = 1
            if (r3 == r4) goto L1c
            goto Lc
        L1c:
            l1.l r3 = new l1.l
            r3.<init>(r7)
            r3.f2966d = r8
        L23:
            java.lang.Object r4 = r2.get(r8)
            boolean r5 = r4 instanceof l1.E
            if (r5 == 0) goto L45
            r5 = r4
            l1.E r5 = (l1.E) r5
            boolean r6 = r5.f2951a
            if (r6 == 0) goto L41
        L32:
            boolean r5 = r2.compareAndSet(r8, r4, r3)
            if (r5 == 0) goto L3a
            goto La2
        L3a:
            java.lang.Object r5 = r2.get(r8)
            if (r5 == r4) goto L32
            goto L23
        L41:
            r8.K(r5)
            goto L23
        L45:
            boolean r5 = r4 instanceof l1.L
            r6 = 0
            if (r5 == 0) goto L8e
            r5 = r4
            l1.L r5 = (l1.L) r5
            l1.Y r5 = r5.c()
            if (r5 != 0) goto L5e
            java.lang.String r5 = "null cannot be cast to non-null type kotlinx.coroutines.JobNode"
            kotlin.jvm.internal.h.c(r4, r5)
            l1.T r4 = (l1.T) r4
            r8.L(r4)
            goto L23
        L5e:
            r4 = 7
            boolean r4 = r5.d(r3, r4)
            if (r4 == 0) goto L66
            goto La2
        L66:
            r4 = 3
            boolean r4 = r5.d(r3, r4)
            java.lang.Object r8 = r2.get(r8)
            boolean r5 = r8 instanceof l1.W
            if (r5 == 0) goto L7a
            l1.W r8 = (l1.W) r8
            java.lang.Throwable r6 = r8.d()
            goto L86
        L7a:
            boolean r5 = r8 instanceof l1.C0238p
            if (r5 == 0) goto L81
            l1.p r8 = (l1.C0238p) r8
            goto L82
        L81:
            r8 = r6
        L82:
            if (r8 == 0) goto L86
            java.lang.Throwable r6 = r8.f3007a
        L86:
            r3.k(r6)
            if (r4 == 0) goto L8c
            goto La2
        L8c:
            r3 = r1
            goto La2
        L8e:
            java.lang.Object r8 = r2.get(r8)
            boolean r4 = r8 instanceof l1.C0238p
            if (r4 == 0) goto L99
            l1.p r8 = (l1.C0238p) r8
            goto L9a
        L99:
            r8 = r6
        L9a:
            if (r8 == 0) goto L9e
            java.lang.Throwable r6 = r8.f3007a
        L9e:
            r3.k(r6)
            goto L8c
        La2:
            r0.set(r7, r3)
            java.lang.Object r8 = r2.get(r7)
            boolean r8 = r8 instanceof l1.L
            if (r8 != 0) goto Lb3
            r3.dispose()
            r0.set(r7, r1)
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.X.B(l1.O):void");
    }

    public final D C(boolean z, T t2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Z z2;
        boolean z3;
        Throwable th;
        C0238p c0238p;
        boolean d2;
        W w2;
        Throwable th2;
        t2.f2966d = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = f2976c;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z4 = obj instanceof E;
            z2 = Z.f2978a;
            z3 = true;
            th = null;
            if (z4) {
                E e2 = (E) obj;
                if (e2.f2951a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, t2)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                K(e2);
            } else if (obj instanceof L) {
                L l2 = (L) obj;
                Y c2 = l2.c();
                if (c2 == null) {
                    kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    L((T) obj);
                } else {
                    if (t2.j()) {
                        if (l2 instanceof W) {
                            w2 = (W) l2;
                        } else {
                            w2 = null;
                        }
                        if (w2 != null) {
                            th2 = w2.d();
                        } else {
                            th2 = null;
                        }
                        if (th2 == null) {
                            d2 = c2.d(t2, 5);
                        } else if (z) {
                            t2.k(th2);
                            return z2;
                        }
                    } else {
                        d2 = c2.d(t2, 1);
                    }
                    if (d2) {
                        break;
                    }
                }
            } else {
                z3 = false;
                break;
            }
        }
        if (z3) {
            return t2;
        }
        if (z) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof C0238p) {
                c0238p = (C0238p) obj2;
            } else {
                c0238p = null;
            }
            if (c0238p != null) {
                th = c0238p.f3007a;
            }
            t2.k(th);
        }
        return z2;
    }

    public boolean D() {
        return this instanceof C0225c;
    }

    public final boolean E(Object obj) {
        Object O2;
        do {
            O2 = O(f2976c.get(this), obj);
            if (O2 == AbstractC0244w.f3018c) {
                return false;
            }
            if (O2 == AbstractC0244w.f3019d) {
                return true;
            }
        } while (O2 == AbstractC0244w.f3020e);
        l(O2);
        return true;
    }

    public final Object F(Object obj) {
        Object O2;
        C0238p c0238p;
        do {
            O2 = O(f2976c.get(this), obj);
            if (O2 == AbstractC0244w.f3018c) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                Throwable th = null;
                if (obj instanceof C0238p) {
                    c0238p = (C0238p) obj;
                } else {
                    c0238p = null;
                }
                if (c0238p != null) {
                    th = c0238p.f3007a;
                }
                throw new IllegalStateException(str, th);
            }
        } while (O2 == AbstractC0244w.f3020e);
        return O2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [Q0.d, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final void H(Y y, Throwable th) {
        y.d(new q1.h(4), 4);
        Object obj = q1.j.f3526a.get(y);
        kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        q1.j jVar = (q1.j) obj;
        Q0.d dVar = 0;
        while (!jVar.equals(y)) {
            if ((jVar instanceof T) && ((T) jVar).j()) {
                try {
                    ((T) jVar).k(th);
                } catch (Throwable th2) {
                    if (dVar != 0) {
                        android.support.v4.media.session.a.c(dVar, th2);
                    } else {
                        dVar = new RuntimeException("Exception in completion handler " + jVar + " for " + this, th2);
                    }
                }
            }
            jVar = jVar.g();
            dVar = dVar;
        }
        if (dVar != 0) {
            A(dVar);
        }
        p(th);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [l1.Y, q1.j] */
    public final void K(E e2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? jVar = new q1.j();
        K k2 = jVar;
        if (!e2.f2951a) {
            k2 = new K(jVar);
        }
        do {
            atomicReferenceFieldUpdater = f2976c;
            if (atomicReferenceFieldUpdater.compareAndSet(this, e2, k2)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == e2);
    }

    public final void L(T t2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        q1.j jVar = new q1.j();
        t2.getClass();
        q1.j.f3527b.set(jVar, t2);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = q1.j.f3526a;
        atomicReferenceFieldUpdater2.set(jVar, t2);
        loop0: while (true) {
            if (atomicReferenceFieldUpdater2.get(t2) != t2) {
                break;
            }
            while (!atomicReferenceFieldUpdater2.compareAndSet(t2, t2, jVar)) {
                if (atomicReferenceFieldUpdater2.get(t2) != t2) {
                    break;
                }
            }
            jVar.f(t2);
        }
        q1.j g2 = t2.g();
        do {
            atomicReferenceFieldUpdater = f2976c;
            if (atomicReferenceFieldUpdater.compareAndSet(this, t2, g2)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == t2);
    }

    public final int M(Object obj) {
        boolean z = obj instanceof E;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2976c;
        if (z) {
            if (!((E) obj).f2951a) {
                E e2 = AbstractC0244w.f3024i;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, e2)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        return -1;
                    }
                }
                return 1;
            }
            return 0;
        }
        if (obj instanceof K) {
            Y y = ((K) obj).f2960a;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, y)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            return 1;
        }
        return 0;
    }

    public final Object O(Object obj, Object obj2) {
        Object obj3;
        W w2;
        boolean z;
        C0238p c0238p;
        if (!(obj instanceof L)) {
            return AbstractC0244w.f3018c;
        }
        if (((obj instanceof E) || (obj instanceof T)) && !(obj instanceof C0234l) && !(obj2 instanceof C0238p)) {
            L l2 = (L) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2976c;
            if (obj2 instanceof L) {
                obj3 = new M((L) obj2);
            } else {
                obj3 = obj2;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, l2, obj3)) {
                if (atomicReferenceFieldUpdater.get(this) != l2) {
                    return AbstractC0244w.f3020e;
                }
            }
            I(obj2);
            s(l2, obj2);
            return obj2;
        }
        L l3 = (L) obj;
        Y y = y(l3);
        if (y == null) {
            return AbstractC0244w.f3020e;
        }
        Throwable th = null;
        if (l3 instanceof W) {
            w2 = (W) l3;
        } else {
            w2 = null;
        }
        if (w2 == null) {
            w2 = new W(y, null);
        }
        synchronized (w2) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = W.f2972b;
            if (atomicIntegerFieldUpdater.get(w2) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return AbstractC0244w.f3018c;
            }
            atomicIntegerFieldUpdater.set(w2, 1);
            if (w2 != l3) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f2976c;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, l3, w2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != l3) {
                        return AbstractC0244w.f3020e;
                    }
                }
            }
            boolean e2 = w2.e();
            if (obj2 instanceof C0238p) {
                c0238p = (C0238p) obj2;
            } else {
                c0238p = null;
            }
            if (c0238p != null) {
                w2.b(c0238p.f3007a);
            }
            Throwable d2 = w2.d();
            if (!e2) {
                th = d2;
            }
            if (th != null) {
                H(y, th);
            }
            C0234l G2 = G(y);
            if (G2 != null && P(w2, G2, obj2)) {
                return AbstractC0244w.f3019d;
            }
            y.d(new q1.h(2), 2);
            C0234l G3 = G(y);
            if (G3 != null && P(w2, G3, obj2)) {
                return AbstractC0244w.f3019d;
            }
            return u(w2, obj2);
        }
    }

    public final boolean P(W w2, C0234l c0234l, Object obj) {
        while (AbstractC0244w.e(c0234l.f3000e, false, new V(this, w2, c0234l, obj)) == Z.f2978a) {
            c0234l = G(c0234l);
            if (c0234l == null) {
                return false;
            }
        }
        return true;
    }

    @Override // l1.O
    public boolean a() {
        Object obj = f2976c.get(this);
        if ((obj instanceof L) && ((L) obj).a()) {
            return true;
        }
        return false;
    }

    @Override // l1.O
    public void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new P(q(), null, this);
        }
        o(cancellationException);
    }

    @Override // T0.i
    public final Object c(Object obj, c1.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // T0.i
    public final T0.i d(T0.i context) {
        kotlin.jvm.internal.h.e(context, "context");
        if (context == T0.j.f774c) {
            return this;
        }
        return (T0.i) context.c(this, new T0.b(1));
    }

    @Override // T0.i
    public final T0.i g(T0.h hVar) {
        return AbstractC0051a.H(this, hVar);
    }

    @Override // T0.g
    public final T0.h getKey() {
        return C0241t.f3012d;
    }

    @Override // T0.i
    public final T0.g k(T0.h hVar) {
        return AbstractC0051a.w(this, hVar);
    }

    public void m(Object obj) {
        l(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        r0 = l1.AbstractC0244w.f3018c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
    
        if (r0 != l1.AbstractC0244w.f3019d) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0106, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        r0 = O(r0, new l1.C0238p(t(r10), false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        if (r0 == l1.AbstractC0244w.f3020e) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        if (r0 != l1.AbstractC0244w.f3018c) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        r0 = null;
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        r4 = l1.X.f2976c;
        r5 = r4.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        if ((r5 instanceof l1.W) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009d, code lost:
    
        if ((r5 instanceof l1.L) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009f, code lost:
    
        if (r1 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a1, code lost:
    
        r1 = t(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a5, code lost:
    
        r6 = (l1.L) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0008, code lost:
    
        if (x() != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ac, code lost:
    
        if (r6.a() == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ce, code lost:
    
        r4 = O(r5, new l1.C0238p(r1, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d9, code lost:
    
        if (r4 == l1.AbstractC0244w.f3018c) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00dd, code lost:
    
        if (r4 == l1.AbstractC0244w.f3020e) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00df, code lost:
    
        r0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        r0 = l1.X.f2976c.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f8, code lost:
    
        throw new java.lang.IllegalStateException(("Cannot happen in " + r5).toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ae, code lost:
    
        r7 = y(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b2, code lost:
    
        if (r7 != null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b5, code lost:
    
        r8 = new l1.W(r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00be, code lost:
    
        if (r4.compareAndSet(r9, r6, r8) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if ((r0 instanceof l1.L) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ca, code lost:
    
        if (r4.get(r9) == r6) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c0, code lost:
    
        H(r7, r1);
        r10 = l1.AbstractC0244w.f3018c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x006a, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f9, code lost:
    
        r10 = l1.AbstractC0244w.f3021f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0051, code lost:
    
        monitor-enter(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0052, code lost:
    
        r4 = (l1.W) r5;
        r4.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0060, code lost:
    
        if (l1.W.f2974d.get(r4) != l1.AbstractC0244w.f3022g) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0062, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0065, code lost:
    
        if (r4 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0067, code lost:
    
        r10 = l1.AbstractC0244w.f3021f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0069, code lost:
    
        monitor-exit(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x006f, code lost:
    
        r4 = ((l1.W) r5).e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if ((r0 instanceof l1.W) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0076, code lost:
    
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0078, code lost:
    
        r1 = t(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x007c, code lost:
    
        ((l1.W) r5).b(r1);
        r10 = ((l1.W) r5).d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0089, code lost:
    
        if (r4 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x008b, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x008c, code lost:
    
        monitor-exit(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x008d, code lost:
    
        if (r0 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x008f, code lost:
    
        H(((l1.W) r5).f2975a, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0096, code lost:
    
        r10 = l1.AbstractC0244w.f3018c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0064, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        r1 = (l1.W) r0;
        r1.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00ff, code lost:
    
        if (r0 != l1.AbstractC0244w.f3018c) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0104, code lost:
    
        if (r0 != l1.AbstractC0244w.f3019d) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0109, code lost:
    
        if (r0 != l1.AbstractC0244w.f3021f) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x010b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x010c, code lost:
    
        l(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (l1.W.f2972b.get(r1) == 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x010f, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.X.n(java.lang.Object):boolean");
    }

    public void o(CancellationException cancellationException) {
        n(cancellationException);
    }

    public final boolean p(Throwable th) {
        if (!D()) {
            boolean z = th instanceof CancellationException;
            InterfaceC0233k interfaceC0233k = (InterfaceC0233k) f2977d.get(this);
            if (interfaceC0233k != null && interfaceC0233k != Z.f2978a) {
                if (!interfaceC0233k.b(th) && !z) {
                    return false;
                }
                return true;
            }
            return z;
        }
        return true;
    }

    public String q() {
        return "Job was cancelled";
    }

    public boolean r(Throwable th) {
        if (!(th instanceof CancellationException)) {
            if (n(th) && w()) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [Q0.d, java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r1v4, types: [Q0.d, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final void s(L l2, Object obj) {
        C0238p c0238p;
        Throwable th;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2977d;
        InterfaceC0233k interfaceC0233k = (InterfaceC0233k) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0233k != null) {
            interfaceC0233k.dispose();
            atomicReferenceFieldUpdater.set(this, Z.f2978a);
        }
        Q0.d dVar = 0;
        if (obj instanceof C0238p) {
            c0238p = (C0238p) obj;
        } else {
            c0238p = null;
        }
        if (c0238p != null) {
            th = c0238p.f3007a;
        } else {
            th = null;
        }
        if (l2 instanceof T) {
            try {
                ((T) l2).k(th);
                return;
            } catch (Throwable th2) {
                A(new RuntimeException("Exception in completion handler " + l2 + " for " + this, th2));
                return;
            }
        }
        Y c2 = l2.c();
        if (c2 != null) {
            c2.d(new q1.h(1), 1);
            Object obj2 = q1.j.f3526a.get(c2);
            kotlin.jvm.internal.h.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            q1.j jVar = (q1.j) obj2;
            while (!jVar.equals(c2)) {
                if (jVar instanceof T) {
                    try {
                        ((T) jVar).k(th);
                    } catch (Throwable th3) {
                        if (dVar != 0) {
                            android.support.v4.media.session.a.c(dVar, th3);
                        } else {
                            dVar = new RuntimeException("Exception in completion handler " + jVar + " for " + this, th3);
                        }
                    }
                }
                jVar = jVar.g();
                dVar = dVar;
            }
            if (dVar != 0) {
                A(dVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    public final Throwable t(Object obj) {
        CancellationException cancellationException;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        X x2 = (X) ((b0) obj);
        Object obj2 = f2976c.get(x2);
        CancellationException cancellationException2 = null;
        if (obj2 instanceof W) {
            cancellationException = ((W) obj2).d();
        } else if (obj2 instanceof C0238p) {
            cancellationException = ((C0238p) obj2).f3007a;
        } else if (!(obj2 instanceof L)) {
            cancellationException = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj2).toString());
        }
        if (cancellationException instanceof CancellationException) {
            cancellationException2 = cancellationException;
        }
        if (cancellationException2 == null) {
            return new P("Parent job is ".concat(N(obj2)), cancellationException, x2);
        }
        return cancellationException2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + N(f2976c.get(this)) + '}');
        sb.append('@');
        sb.append(AbstractC0244w.b(this));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object u(W w2, Object obj) {
        C0238p c0238p;
        Throwable th;
        Object obj2;
        Throwable th2 = null;
        if (obj instanceof C0238p) {
            c0238p = (C0238p) obj;
        } else {
            c0238p = null;
        }
        if (c0238p != null) {
            th = c0238p.f3007a;
        } else {
            th = null;
        }
        synchronized (w2) {
            w2.e();
            ArrayList f2 = w2.f(th);
            if (f2.isEmpty()) {
                if (w2.e()) {
                    th2 = new P(q(), null, this);
                }
            } else {
                int size = f2.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    Object obj3 = f2.get(i2);
                    i2++;
                    if (!(((Throwable) obj3) instanceof CancellationException)) {
                        th2 = obj3;
                        break;
                    }
                }
                th2 = th2;
                if (th2 == null) {
                    th2 = (Throwable) f2.get(0);
                }
            }
            if (th2 != null && f2.size() > 1) {
                Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(f2.size()));
                int size2 = f2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj4 = f2.get(i3);
                    i3++;
                    Throwable th3 = (Throwable) obj4;
                    if (th3 != th2 && th3 != th2 && !(th3 instanceof CancellationException) && newSetFromMap.add(th3)) {
                        android.support.v4.media.session.a.c(th2, th3);
                    }
                }
            }
        }
        if (th2 != null && th2 != th) {
            obj = new C0238p(th2, false);
        }
        if (th2 != null && (p(th2) || z(th2))) {
            kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            C0238p.f3006b.compareAndSet((C0238p) obj, 0, 1);
        }
        I(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2976c;
        if (obj instanceof L) {
            obj2 = new M((L) obj);
        } else {
            obj2 = obj;
        }
        while (!atomicReferenceFieldUpdater.compareAndSet(this, w2, obj2) && atomicReferenceFieldUpdater.get(this) == w2) {
        }
        s(w2, obj);
        return obj;
    }

    public final CancellationException v() {
        Object obj = f2976c.get(this);
        CancellationException cancellationException = null;
        if (obj instanceof W) {
            Throwable d2 = ((W) obj).d();
            if (d2 != null) {
                String concat = getClass().getSimpleName().concat(" is cancelling");
                if (d2 instanceof CancellationException) {
                    cancellationException = (CancellationException) d2;
                }
                if (cancellationException == null) {
                    if (concat == null) {
                        concat = q();
                    }
                    return new P(concat, d2, this);
                }
                return cancellationException;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(obj instanceof L)) {
            if (obj instanceof C0238p) {
                Throwable th = ((C0238p) obj).f3007a;
                if (th instanceof CancellationException) {
                    cancellationException = (CancellationException) th;
                }
                if (cancellationException == null) {
                    return new P(q(), th, this);
                }
                return cancellationException;
            }
            return new P(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public boolean w() {
        return true;
    }

    public boolean x() {
        return this instanceof C0236n;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [l1.Y, q1.j] */
    public final Y y(L l2) {
        Y c2 = l2.c();
        if (c2 == null) {
            if (l2 instanceof E) {
                return new q1.j();
            }
            if (l2 instanceof T) {
                L((T) l2);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + l2).toString());
        }
        return c2;
    }

    public boolean z(Throwable th) {
        return false;
    }

    public void J() {
    }

    public void A(Q0.d dVar) {
        throw dVar;
    }

    public void I(Object obj) {
    }

    public void l(Object obj) {
    }
}

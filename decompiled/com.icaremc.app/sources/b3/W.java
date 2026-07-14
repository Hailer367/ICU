package b3;

import a.AbstractC0141a;
import f1.AbstractC0286a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class W implements N, a0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3262f = AtomicReferenceFieldUpdater.newUpdater(W.class, Object.class, "_state$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3263g = AtomicReferenceFieldUpdater.newUpdater(W.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public W(boolean z) {
        D d4;
        if (z) {
            d4 = AbstractC0245u.f3307i;
        } else {
            d4 = AbstractC0245u.f3306h;
        }
        this._state$volatile = d4;
    }

    public static C0236k H(g3.j jVar) {
        while (jVar.h()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g3.j.f3792b;
            g3.j e4 = jVar.e();
            if (e4 == null) {
                Object obj = atomicReferenceFieldUpdater.get(jVar);
                while (true) {
                    jVar = (g3.j) obj;
                    if (!jVar.h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(jVar);
                }
            } else {
                jVar = e4;
            }
        }
        while (true) {
            jVar = jVar.g();
            if (!jVar.h()) {
                if (jVar instanceof C0236k) {
                    return (C0236k) jVar;
                }
                if (jVar instanceof X) {
                    return null;
                }
            }
        }
    }

    public static String O(Object obj) {
        if (obj instanceof V) {
            V v3 = (V) obj;
            if (v3.e()) {
                return "Cancelling";
            }
            if (V.f3258b.get(v3) == 0) {
                return "Active";
            }
            return "Completing";
        }
        if (obj instanceof K) {
            if (((K) obj).a()) {
                return "Active";
            }
            return "New";
        }
        if (obj instanceof C0240o) {
            return "Cancelled";
        }
        return "Completed";
    }

    public boolean A(Throwable th) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
    
        if (r4 != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [b3.k, g3.j, java.lang.Object, b3.S] */
    /* JADX WARN: Type inference failed for: r3v3, types: [b3.B, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r5v8, types: [b3.X, g3.j] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(b3.N r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = b3.W.f3263g
            b3.Y r1 = b3.Y.f3264a
            if (r8 != 0) goto La
            r0.set(r7, r1)
            return
        La:
            b3.W r8 = (b3.W) r8
        Lc:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = b3.W.f3262f
            java.lang.Object r3 = r2.get(r8)
            int r3 = r8.N(r3)
            if (r3 == 0) goto L1c
            r4 = 1
            if (r3 == r4) goto L1c
            goto Lc
        L1c:
            b3.k r3 = new b3.k
            r3.<init>(r7)
            r3.f3252d = r8
        L23:
            java.lang.Object r4 = r2.get(r8)
            boolean r5 = r4 instanceof b3.D
            if (r5 == 0) goto L45
            r5 = r4
            b3.D r5 = (b3.D) r5
            boolean r6 = r5.f3238a
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
            r8.L(r5)
            goto L23
        L45:
            boolean r5 = r4 instanceof b3.K
            r6 = 0
            if (r5 == 0) goto L8e
            r5 = r4
            b3.K r5 = (b3.K) r5
            b3.X r5 = r5.c()
            if (r5 != 0) goto L5e
            java.lang.String r5 = "null cannot be cast to non-null type kotlinx.coroutines.JobNode"
            T2.h.c(r4, r5)
            b3.S r4 = (b3.S) r4
            r8.M(r4)
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
            boolean r5 = r8 instanceof b3.V
            if (r5 == 0) goto L7a
            b3.V r8 = (b3.V) r8
            java.lang.Throwable r6 = r8.d()
            goto L86
        L7a:
            boolean r5 = r8 instanceof b3.C0240o
            if (r5 == 0) goto L81
            b3.o r8 = (b3.C0240o) r8
            goto L82
        L81:
            r8 = r6
        L82:
            if (r8 == 0) goto L86
            java.lang.Throwable r6 = r8.f3290a
        L86:
            r3.k(r6)
            if (r4 == 0) goto L8c
            goto La2
        L8c:
            r3 = r1
            goto La2
        L8e:
            java.lang.Object r8 = r2.get(r8)
            boolean r4 = r8 instanceof b3.C0240o
            if (r4 == 0) goto L99
            b3.o r8 = (b3.C0240o) r8
            goto L9a
        L99:
            r8 = r6
        L9a:
            if (r8 == 0) goto L9e
            java.lang.Throwable r6 = r8.f3290a
        L9e:
            r3.k(r6)
            goto L8c
        La2:
            r0.set(r7, r3)
            java.lang.Object r8 = r2.get(r7)
            boolean r8 = r8 instanceof b3.K
            if (r8 != 0) goto Lb3
            r3.dispose()
            r0.set(r7, r1)
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.W.C(b3.N):void");
    }

    public final B D(boolean z, S s3) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Y y3;
        boolean z3;
        Throwable th;
        C0240o c0240o;
        boolean d4;
        V v3;
        Throwable th2;
        s3.f3252d = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = f3262f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z4 = obj instanceof D;
            y3 = Y.f3264a;
            z3 = true;
            th = null;
            if (z4) {
                D d5 = (D) obj;
                if (d5.f3238a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, s3)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                L(d5);
            } else if (obj instanceof K) {
                K k = (K) obj;
                X c4 = k.c();
                if (c4 == null) {
                    T2.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    M((S) obj);
                } else {
                    if (s3.j()) {
                        if (k instanceof V) {
                            v3 = (V) k;
                        } else {
                            v3 = null;
                        }
                        if (v3 != null) {
                            th2 = v3.d();
                        } else {
                            th2 = null;
                        }
                        if (th2 == null) {
                            d4 = c4.d(s3, 5);
                        } else if (z) {
                            s3.k(th2);
                            return y3;
                        }
                    } else {
                        d4 = c4.d(s3, 1);
                    }
                    if (d4) {
                        break;
                    }
                }
            } else {
                z3 = false;
                break;
            }
        }
        if (z3) {
            return s3;
        }
        if (z) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof C0240o) {
                c0240o = (C0240o) obj2;
            } else {
                c0240o = null;
            }
            if (c0240o != null) {
                th = c0240o.f3290a;
            }
            s3.k(th);
        }
        return y3;
    }

    public boolean E() {
        return this instanceof C0228c;
    }

    public final boolean F(Object obj) {
        Object P;
        do {
            P = P(f3262f.get(this), obj);
            if (P == AbstractC0245u.f3301c) {
                return false;
            }
            if (P == AbstractC0245u.f3302d) {
                return true;
            }
        } while (P == AbstractC0245u.f3303e);
        m(P);
        return true;
    }

    public final Object G(Object obj) {
        Object P;
        C0240o c0240o;
        do {
            P = P(f3262f.get(this), obj);
            if (P == AbstractC0245u.f3301c) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                Throwable th = null;
                if (obj instanceof C0240o) {
                    c0240o = (C0240o) obj;
                } else {
                    c0240o = null;
                }
                if (c0240o != null) {
                    th = c0240o.f3290a;
                }
                throw new IllegalStateException(str, th);
            }
        } while (P == AbstractC0245u.f3303e);
        return P;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Throwable, E0.b] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r5v0, types: [b3.W, java.lang.Object] */
    public final void I(X x3, Throwable th) {
        x3.d(new g3.h(4), 4);
        Object obj = g3.j.f3791a.get(x3);
        T2.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        g3.j jVar = (g3.j) obj;
        ?? r12 = 0;
        while (!jVar.equals(x3)) {
            if ((jVar instanceof S) && ((S) jVar).j()) {
                try {
                    ((S) jVar).k(th);
                } catch (Throwable th2) {
                    if (r12 != 0) {
                        AbstractC0286a.a(r12, th2);
                    } else {
                        r12 = new RuntimeException("Exception in completion handler " + jVar + " for " + ((Object) this), th2);
                    }
                }
            }
            jVar = jVar.g();
            r12 = r12;
        }
        if (r12 != 0) {
            B(r12);
        }
        q(th);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [b3.X, g3.j] */
    public final void L(D d4) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? jVar = new g3.j();
        J j4 = jVar;
        if (!d4.f3238a) {
            j4 = new J(jVar);
        }
        do {
            atomicReferenceFieldUpdater = f3262f;
            if (atomicReferenceFieldUpdater.compareAndSet(this, d4, j4)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == d4);
    }

    public final void M(S s3) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        g3.j jVar = new g3.j();
        s3.getClass();
        g3.j.f3792b.set(jVar, s3);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = g3.j.f3791a;
        atomicReferenceFieldUpdater2.set(jVar, s3);
        loop0: while (true) {
            if (atomicReferenceFieldUpdater2.get(s3) != s3) {
                break;
            }
            while (!atomicReferenceFieldUpdater2.compareAndSet(s3, s3, jVar)) {
                if (atomicReferenceFieldUpdater2.get(s3) != s3) {
                    break;
                }
            }
            jVar.f(s3);
        }
        g3.j g4 = s3.g();
        do {
            atomicReferenceFieldUpdater = f3262f;
            if (atomicReferenceFieldUpdater.compareAndSet(this, s3, g4)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == s3);
    }

    public final int N(Object obj) {
        boolean z = obj instanceof D;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3262f;
        if (z) {
            if (!((D) obj).f3238a) {
                D d4 = AbstractC0245u.f3307i;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, d4)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        return -1;
                    }
                }
                return 1;
            }
            return 0;
        }
        if (obj instanceof J) {
            X x3 = ((J) obj).f3246a;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, x3)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            return 1;
        }
        return 0;
    }

    public final Object P(Object obj, Object obj2) {
        Object obj3;
        V v3;
        boolean z;
        C0240o c0240o;
        if (!(obj instanceof K)) {
            return AbstractC0245u.f3301c;
        }
        if (((obj instanceof D) || (obj instanceof S)) && !(obj instanceof C0236k) && !(obj2 instanceof C0240o)) {
            K k = (K) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3262f;
            if (obj2 instanceof K) {
                obj3 = new L((K) obj2);
            } else {
                obj3 = obj2;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, k, obj3)) {
                if (atomicReferenceFieldUpdater.get(this) != k) {
                    return AbstractC0245u.f3303e;
                }
            }
            J(obj2);
            t(k, obj2);
            return obj2;
        }
        K k4 = (K) obj;
        X z3 = z(k4);
        if (z3 == null) {
            return AbstractC0245u.f3303e;
        }
        Throwable th = null;
        if (k4 instanceof V) {
            v3 = (V) k4;
        } else {
            v3 = null;
        }
        if (v3 == null) {
            v3 = new V(z3, null);
        }
        synchronized (v3) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = V.f3258b;
            if (atomicIntegerFieldUpdater.get(v3) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return AbstractC0245u.f3301c;
            }
            atomicIntegerFieldUpdater.set(v3, 1);
            if (v3 != k4) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f3262f;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, k4, v3)) {
                    if (atomicReferenceFieldUpdater2.get(this) != k4) {
                        return AbstractC0245u.f3303e;
                    }
                }
            }
            boolean e4 = v3.e();
            if (obj2 instanceof C0240o) {
                c0240o = (C0240o) obj2;
            } else {
                c0240o = null;
            }
            if (c0240o != null) {
                v3.b(c0240o.f3290a);
            }
            Throwable d4 = v3.d();
            if (!e4) {
                th = d4;
            }
            if (th != null) {
                I(z3, th);
            }
            C0236k H3 = H(z3);
            if (H3 != null && Q(v3, H3, obj2)) {
                return AbstractC0245u.f3302d;
            }
            z3.d(new g3.h(2), 2);
            C0236k H4 = H(z3);
            if (H4 != null && Q(v3, H4, obj2)) {
                return AbstractC0245u.f3302d;
            }
            return v(v3, obj2);
        }
    }

    public final boolean Q(V v3, C0236k c0236k, Object obj) {
        while (AbstractC0245u.e(c0236k.f3283e, false, new U(this, v3, c0236k, obj)) == Y.f3264a) {
            c0236k = H(c0236k);
            if (c0236k == null) {
                return false;
            }
        }
        return true;
    }

    @Override // b3.N
    public boolean a() {
        Object obj = f3262f.get(this);
        if ((obj instanceof K) && ((K) obj).a()) {
            return true;
        }
        return false;
    }

    @Override // b3.N
    public void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new O(r(), null, this);
        }
        p(cancellationException);
    }

    @Override // K2.i
    public final K2.i c(K2.h hVar) {
        return AbstractC0141a.v(this, hVar);
    }

    @Override // K2.i
    public final K2.g e(K2.h hVar) {
        return AbstractC0141a.s(this, hVar);
    }

    @Override // K2.g
    public final K2.h getKey() {
        return r.f3295g;
    }

    @Override // K2.i
    public final K2.i j(K2.i iVar) {
        T2.h.e(iVar, "context");
        if (iVar == K2.j.f942f) {
            return this;
        }
        return (K2.i) iVar.k(this, new K2.b(1));
    }

    @Override // K2.i
    public final Object k(Object obj, S2.p pVar) {
        return pVar.e(obj, this);
    }

    public void n(Object obj) {
        m(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        r0 = b3.AbstractC0245u.f3301c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
    
        if (r0 != b3.AbstractC0245u.f3302d) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0106, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        r0 = P(r0, new b3.C0240o(u(r10), false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        if (r0 == b3.AbstractC0245u.f3303e) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        if (r0 != b3.AbstractC0245u.f3301c) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        r0 = null;
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        r4 = b3.W.f3262f;
        r5 = r4.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        if ((r5 instanceof b3.V) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009d, code lost:
    
        if ((r5 instanceof b3.K) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009f, code lost:
    
        if (r1 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a1, code lost:
    
        r1 = u(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a5, code lost:
    
        r6 = (b3.K) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0008, code lost:
    
        if (y() != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ac, code lost:
    
        if (r6.a() == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ce, code lost:
    
        r4 = P(r5, new b3.C0240o(r1, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d9, code lost:
    
        if (r4 == b3.AbstractC0245u.f3301c) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00dd, code lost:
    
        if (r4 == b3.AbstractC0245u.f3303e) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00df, code lost:
    
        r0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        r0 = b3.W.f3262f.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f8, code lost:
    
        throw new java.lang.IllegalStateException(("Cannot happen in " + r5).toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ae, code lost:
    
        r7 = z(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b2, code lost:
    
        if (r7 != null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b5, code lost:
    
        r8 = new b3.V(r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00be, code lost:
    
        if (r4.compareAndSet(r9, r6, r8) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if ((r0 instanceof b3.K) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ca, code lost:
    
        if (r4.get(r9) == r6) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c0, code lost:
    
        I(r7, r1);
        r10 = b3.AbstractC0245u.f3301c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x006a, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f9, code lost:
    
        r10 = b3.AbstractC0245u.f3304f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0051, code lost:
    
        monitor-enter(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0052, code lost:
    
        r4 = (b3.V) r5;
        r4.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0060, code lost:
    
        if (b3.V.f3260d.get(r4) != b3.AbstractC0245u.f3305g) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0062, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0065, code lost:
    
        if (r4 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0067, code lost:
    
        r10 = b3.AbstractC0245u.f3304f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0069, code lost:
    
        monitor-exit(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x006f, code lost:
    
        r4 = ((b3.V) r5).e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if ((r0 instanceof b3.V) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0076, code lost:
    
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0078, code lost:
    
        r1 = u(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x007c, code lost:
    
        ((b3.V) r5).b(r1);
        r10 = ((b3.V) r5).d();
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
    
        I(((b3.V) r5).f3261a, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0096, code lost:
    
        r10 = b3.AbstractC0245u.f3301c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0064, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        r1 = (b3.V) r0;
        r1.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00ff, code lost:
    
        if (r0 != b3.AbstractC0245u.f3301c) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0104, code lost:
    
        if (r0 != b3.AbstractC0245u.f3302d) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0109, code lost:
    
        if (r0 != b3.AbstractC0245u.f3304f) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x010b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x010c, code lost:
    
        m(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (b3.V.f3258b.get(r1) == 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x010f, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.W.o(java.lang.Object):boolean");
    }

    public void p(CancellationException cancellationException) {
        o(cancellationException);
    }

    public final boolean q(Throwable th) {
        if (!E()) {
            boolean z = th instanceof CancellationException;
            InterfaceC0235j interfaceC0235j = (InterfaceC0235j) f3263g.get(this);
            if (interfaceC0235j != null && interfaceC0235j != Y.f3264a) {
                if (!interfaceC0235j.b(th) && !z) {
                    return false;
                }
                return true;
            }
            return z;
        }
        return true;
    }

    public String r() {
        return "Job was cancelled";
    }

    public boolean s(Throwable th) {
        if (!(th instanceof CancellationException)) {
            if (o(th) && x()) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.RuntimeException, E0.b] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Throwable, E0.b] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [b3.W, java.lang.Object] */
    public final void t(K k, Object obj) {
        C0240o c0240o;
        Throwable th;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3263g;
        InterfaceC0235j interfaceC0235j = (InterfaceC0235j) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0235j != null) {
            interfaceC0235j.dispose();
            atomicReferenceFieldUpdater.set(this, Y.f3264a);
        }
        ?? r12 = 0;
        if (obj instanceof C0240o) {
            c0240o = (C0240o) obj;
        } else {
            c0240o = null;
        }
        if (c0240o != null) {
            th = c0240o.f3290a;
        } else {
            th = null;
        }
        if (k instanceof S) {
            try {
                ((S) k).k(th);
                return;
            } catch (Throwable th2) {
                B(new RuntimeException("Exception in completion handler " + k + " for " + ((Object) this), th2));
                return;
            }
        }
        X c4 = k.c();
        if (c4 != null) {
            c4.d(new g3.h(1), 1);
            Object obj2 = g3.j.f3791a.get(c4);
            T2.h.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            g3.j jVar = (g3.j) obj2;
            while (!jVar.equals(c4)) {
                if (jVar instanceof S) {
                    try {
                        ((S) jVar).k(th);
                    } catch (Throwable th3) {
                        if (r12 != 0) {
                            AbstractC0286a.a(r12, th3);
                        } else {
                            r12 = new RuntimeException("Exception in completion handler " + jVar + " for " + ((Object) this), th3);
                        }
                    }
                }
                jVar = jVar.g();
                r12 = r12;
            }
            if (r12 != 0) {
                B(r12);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + O(f3262f.get(this)) + '}');
        sb.append('@');
        sb.append(AbstractC0245u.b(this));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    public final Throwable u(Object obj) {
        CancellationException cancellationException;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        W w2 = (W) ((a0) obj);
        Object obj2 = f3262f.get(w2);
        CancellationException cancellationException2 = null;
        if (obj2 instanceof V) {
            cancellationException = ((V) obj2).d();
        } else if (obj2 instanceof C0240o) {
            cancellationException = ((C0240o) obj2).f3290a;
        } else if (!(obj2 instanceof K)) {
            cancellationException = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj2).toString());
        }
        if (cancellationException instanceof CancellationException) {
            cancellationException2 = cancellationException;
        }
        if (cancellationException2 == null) {
            return new O("Parent job is ".concat(O(obj2)), cancellationException, w2);
        }
        return cancellationException2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object v(V v3, Object obj) {
        C0240o c0240o;
        Throwable th;
        Object obj2;
        Throwable th2 = null;
        if (obj instanceof C0240o) {
            c0240o = (C0240o) obj;
        } else {
            c0240o = null;
        }
        if (c0240o != null) {
            th = c0240o.f3290a;
        } else {
            th = null;
        }
        synchronized (v3) {
            v3.e();
            ArrayList f4 = v3.f(th);
            if (f4.isEmpty()) {
                if (v3.e()) {
                    th2 = new O(r(), null, this);
                }
            } else {
                int size = f4.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    Object obj3 = f4.get(i4);
                    i4++;
                    if (!(((Throwable) obj3) instanceof CancellationException)) {
                        th2 = obj3;
                        break;
                    }
                }
                th2 = th2;
                if (th2 == null) {
                    th2 = (Throwable) f4.get(0);
                }
            }
            if (th2 != null && f4.size() > 1) {
                Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(f4.size()));
                int size2 = f4.size();
                int i5 = 0;
                while (i5 < size2) {
                    Object obj4 = f4.get(i5);
                    i5++;
                    Throwable th3 = (Throwable) obj4;
                    if (th3 != th2 && th3 != th2 && !(th3 instanceof CancellationException) && newSetFromMap.add(th3)) {
                        AbstractC0286a.a(th2, th3);
                    }
                }
            }
        }
        if (th2 != null && th2 != th) {
            obj = new C0240o(th2, false);
        }
        if (th2 != null && (q(th2) || A(th2))) {
            T2.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            C0240o.f3289b.compareAndSet((C0240o) obj, 0, 1);
        }
        J(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3262f;
        if (obj instanceof K) {
            obj2 = new L((K) obj);
        } else {
            obj2 = obj;
        }
        while (!atomicReferenceFieldUpdater.compareAndSet(this, v3, obj2) && atomicReferenceFieldUpdater.get(this) == v3) {
        }
        t(v3, obj);
        return obj;
    }

    public final CancellationException w() {
        Object obj = f3262f.get(this);
        CancellationException cancellationException = null;
        if (obj instanceof V) {
            Throwable d4 = ((V) obj).d();
            if (d4 != null) {
                String concat = getClass().getSimpleName().concat(" is cancelling");
                if (d4 instanceof CancellationException) {
                    cancellationException = (CancellationException) d4;
                }
                if (cancellationException == null) {
                    if (concat == null) {
                        concat = r();
                    }
                    return new O(concat, d4, this);
                }
                return cancellationException;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(obj instanceof K)) {
            if (obj instanceof C0240o) {
                Throwable th = ((C0240o) obj).f3290a;
                if (th instanceof CancellationException) {
                    cancellationException = (CancellationException) th;
                }
                if (cancellationException == null) {
                    return new O(r(), th, this);
                }
                return cancellationException;
            }
            return new O(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public boolean x() {
        return true;
    }

    public boolean y() {
        return this instanceof C0238m;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [b3.X, g3.j] */
    public final X z(K k) {
        X c4 = k.c();
        if (c4 == null) {
            if (k instanceof D) {
                return new g3.j();
            }
            if (k instanceof S) {
                M((S) k);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + k).toString());
        }
        return c4;
    }

    public void K() {
    }

    public void B(E0.b bVar) {
        throw bVar;
    }

    public void J(Object obj) {
    }

    public void m(Object obj) {
    }
}

package n1;

import K.InterfaceC0028c;
import a.AbstractC0051a;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import l1.C0230h;
import l1.InterfaceC0228f;
import l1.j0;

/* loaded from: classes.dex */
public class c implements g {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3313d = AtomicLongFieldUpdater.newUpdater(c.class, "sendersAndCloseStatus$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3314e = AtomicLongFieldUpdater.newUpdater(c.class, "receivers$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3315f = AtomicLongFieldUpdater.newUpdater(c.class, "bufferEnd$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3316g = AtomicLongFieldUpdater.newUpdater(c.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3317h = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "sendSegment$volatile");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3318i = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "receiveSegment$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3319j = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3320k = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_closeCause$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3321l = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* renamed from: c, reason: collision with root package name */
    public final int f3322c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public c(int i2) {
        long j2;
        this.f3322c = i2;
        if (i2 >= 0) {
            k kVar = e.f3324a;
            if (i2 != 0) {
                if (i2 != Integer.MAX_VALUE) {
                    j2 = i2;
                } else {
                    j2 = Long.MAX_VALUE;
                }
            } else {
                j2 = 0;
            }
            this.bufferEnd$volatile = j2;
            this.completedExpandBuffersAndPauseFlag$volatile = f3315f.get(this);
            k kVar2 = new k(0L, null, this, 3);
            this.sendSegment$volatile = kVar2;
            this.receiveSegment$volatile = kVar2;
            if (u()) {
                kVar2 = e.f3324a;
                kotlin.jvm.internal.h.c(kVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment$volatile = kVar2;
            this._closeCause$volatile = e.f3340s;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i2 + ", should be >=0").toString());
    }

    public static final k a(c cVar, long j2, k kVar) {
        Object b2;
        c cVar2;
        k kVar2 = e.f3324a;
        d dVar = d.f3323e;
        loop0: while (true) {
            b2 = q1.a.b(kVar, j2, dVar);
            if (!q1.a.e(b2)) {
                q1.r c2 = q1.a.c(b2);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3317h;
                    q1.r rVar = (q1.r) atomicReferenceFieldUpdater.get(cVar);
                    if (rVar.f3542c >= c2.f3542c) {
                        break loop0;
                    }
                    if (!c2.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(cVar, rVar, c2)) {
                        if (atomicReferenceFieldUpdater.get(cVar) != rVar) {
                            if (c2.e()) {
                                c2.d();
                            }
                        }
                    }
                    if (rVar.e()) {
                        rVar.d();
                    }
                }
            } else {
                break;
            }
        }
        boolean e2 = q1.a.e(b2);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3314e;
        if (e2) {
            cVar.s();
            if (kVar.f3542c * e.f3325b < atomicLongFieldUpdater.get(cVar)) {
                kVar.a();
                return null;
            }
        } else {
            k kVar3 = (k) q1.a.c(b2);
            long j3 = kVar3.f3542c;
            if (j3 > j2) {
                long j4 = e.f3325b * j3;
                while (true) {
                    long j5 = f3313d.get(cVar);
                    long j6 = 1152921504606846975L & j5;
                    if (j6 >= j4) {
                        cVar2 = cVar;
                        break;
                    }
                    cVar2 = cVar;
                    if (f3313d.compareAndSet(cVar2, j5, (((int) (j5 >> 60)) << 60) + j6)) {
                        break;
                    }
                    cVar = cVar2;
                }
                if (j3 * e.f3325b < atomicLongFieldUpdater.get(cVar2)) {
                    kVar3.a();
                }
            } else {
                return kVar3;
            }
        }
        return null;
    }

    public static final void c(c cVar, Object obj, C0230h c0230h) {
        c0230h.resumeWith(AbstractC0051a.j(cVar.o()));
    }

    public static final int d(c cVar, k kVar, int i2, Object obj, long j2, Object obj2, boolean z) {
        kVar.m(i2, obj);
        if (z) {
            return cVar.B(kVar, i2, obj, j2, obj2, z);
        }
        Object k2 = kVar.k(i2);
        if (k2 == null) {
            if (cVar.e(j2)) {
                if (kVar.j(i2, null, e.f3327d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (kVar.j(i2, null, obj2)) {
                    return 2;
                }
            }
        } else if (k2 instanceof j0) {
            kVar.m(i2, null);
            if (cVar.y(k2, obj)) {
                kVar.n(i2, e.f3332i);
                return 0;
            }
            F.h hVar = e.f3334k;
            if (kVar.f3347f.getAndSet((i2 * 2) + 1, hVar) != hVar) {
                kVar.l(i2, true);
                return 5;
            }
            return 5;
        }
        return cVar.B(kVar, i2, obj, j2, obj2, z);
    }

    public static void q(c cVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3316g;
        if ((atomicLongFieldUpdater.addAndGet(cVar, 1L) & 4611686018427387904L) == 0) {
            return;
        }
        do {
        } while ((atomicLongFieldUpdater.get(cVar) & 4611686018427387904L) != 0);
    }

    public static boolean z(Object obj) {
        if (obj instanceof InterfaceC0228f) {
            kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            InterfaceC0228f interfaceC0228f = (InterfaceC0228f) obj;
            k kVar = e.f3324a;
            F.h f2 = interfaceC0228f.f(Q0.j.f722a, null);
            if (f2 != null) {
                interfaceC0228f.j(f2);
                return true;
            }
            return false;
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public final Object A(k kVar, int i2, long j2, Object obj) {
        AtomicReferenceArray atomicReferenceArray = kVar.f3347f;
        Object k2 = kVar.k(i2);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3313d;
        if (k2 == null) {
            if (j2 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return e.f3337n;
                }
                if (kVar.j(i2, k2, obj)) {
                    k();
                    return e.f3336m;
                }
            }
        } else if (k2 == e.f3327d && kVar.j(i2, k2, e.f3332i)) {
            k();
            Object obj2 = atomicReferenceArray.get(i2 * 2);
            kVar.m(i2, null);
            return obj2;
        }
        while (true) {
            Object k3 = kVar.k(i2);
            if (k3 != null && k3 != e.f3328e) {
                if (k3 == e.f3327d) {
                    if (kVar.j(i2, k3, e.f3332i)) {
                        k();
                        Object obj3 = atomicReferenceArray.get(i2 * 2);
                        kVar.m(i2, null);
                        return obj3;
                    }
                } else {
                    F.h hVar = e.f3333j;
                    if (k3 == hVar) {
                        return e.f3338o;
                    }
                    if (k3 == e.f3331h) {
                        return e.f3338o;
                    }
                    if (k3 == e.f3335l) {
                        k();
                        return e.f3338o;
                    }
                    if (k3 != e.f3330g && kVar.j(i2, k3, e.f3329f)) {
                        boolean z = k3 instanceof u;
                        if (z) {
                            k3 = ((u) k3).f3354a;
                        }
                        if (z(k3)) {
                            kVar.n(i2, e.f3332i);
                            k();
                            Object obj4 = atomicReferenceArray.get(i2 * 2);
                            kVar.m(i2, null);
                            return obj4;
                        }
                        kVar.n(i2, hVar);
                        kVar.h();
                        if (z) {
                            k();
                        }
                        return e.f3338o;
                    }
                }
            } else if (j2 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (kVar.j(i2, k3, e.f3331h)) {
                    k();
                    return e.f3338o;
                }
            } else {
                if (obj == null) {
                    return e.f3337n;
                }
                if (kVar.j(i2, k3, obj)) {
                    k();
                    return e.f3336m;
                }
            }
        }
    }

    public final int B(k kVar, int i2, Object obj, long j2, Object obj2, boolean z) {
        while (true) {
            Object k2 = kVar.k(i2);
            if (k2 == null) {
                if (e(j2) && !z) {
                    if (kVar.j(i2, null, e.f3327d)) {
                        break;
                    }
                } else if (z) {
                    if (kVar.j(i2, null, e.f3333j)) {
                        kVar.h();
                        return 4;
                    }
                } else {
                    if (obj2 == null) {
                        return 3;
                    }
                    if (kVar.j(i2, null, obj2)) {
                        return 2;
                    }
                }
            } else if (k2 == e.f3328e) {
                if (kVar.j(i2, k2, e.f3327d)) {
                    break;
                }
            } else {
                F.h hVar = e.f3334k;
                if (k2 == hVar) {
                    kVar.m(i2, null);
                    return 5;
                }
                if (k2 == e.f3331h) {
                    kVar.m(i2, null);
                    return 5;
                }
                if (k2 == e.f3335l) {
                    kVar.m(i2, null);
                    s();
                    return 4;
                }
                kVar.m(i2, null);
                if (k2 instanceof u) {
                    k2 = ((u) k2).f3354a;
                }
                if (y(k2, obj)) {
                    kVar.n(i2, e.f3332i);
                    return 0;
                }
                if (kVar.f3347f.getAndSet((i2 * 2) + 1, hVar) != hVar) {
                    kVar.l(i2, true);
                }
                return 5;
            }
        }
        return 1;
    }

    public final void C(long j2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        boolean z;
        c cVar = this;
        if (!cVar.u()) {
            while (true) {
                atomicLongFieldUpdater = f3315f;
                if (atomicLongFieldUpdater.get(cVar) > j2) {
                    break;
                } else {
                    cVar = this;
                }
            }
            int i2 = e.f3326c;
            int i3 = 0;
            while (true) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = f3316g;
                if (i3 < i2) {
                    long j3 = atomicLongFieldUpdater.get(cVar);
                    if (j3 != (4611686018427387903L & atomicLongFieldUpdater2.get(cVar)) || j3 != atomicLongFieldUpdater.get(cVar)) {
                        i3++;
                    } else {
                        return;
                    }
                } else {
                    while (true) {
                        long j4 = atomicLongFieldUpdater2.get(cVar);
                        if (atomicLongFieldUpdater2.compareAndSet(cVar, j4, (j4 & 4611686018427387903L) + 4611686018427387904L)) {
                            break;
                        } else {
                            cVar = this;
                        }
                    }
                    while (true) {
                        long j5 = atomicLongFieldUpdater.get(cVar);
                        long j6 = atomicLongFieldUpdater2.get(cVar);
                        long j7 = j6 & 4611686018427387903L;
                        if ((j6 & 4611686018427387904L) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (j5 == j7 && j5 == atomicLongFieldUpdater.get(cVar)) {
                            break;
                        }
                        if (!z) {
                            cVar = this;
                            atomicLongFieldUpdater2.compareAndSet(cVar, j6, 4611686018427387904L + j7);
                        } else {
                            cVar = this;
                        }
                    }
                    while (true) {
                        long j8 = atomicLongFieldUpdater2.get(cVar);
                        if (atomicLongFieldUpdater2.compareAndSet(cVar, j8, j8 & 4611686018427387903L)) {
                            return;
                        } else {
                            cVar = this;
                        }
                    }
                }
            }
        }
    }

    @Override // n1.s
    public final void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        f(cancellationException, true);
    }

    public final boolean e(long j2) {
        if (j2 >= f3315f.get(this) && j2 >= f3314e.get(this) + this.f3322c) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
    
        if (r6.compareAndSet(r12, r5, r13) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
    
        if (r6.get(r12) == r5) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (r14 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        r5 = r3.get(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        if (r3.compareAndSet(r4, r5, (3 << 60) + (r5 & 1152921504606846975L)) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        s();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        if (r10 == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        r13 = n1.c.f3321l;
        r14 = r13.get(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
    
        if (r14 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
    
        r0 = n1.e.q;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007f, code lost:
    
        if (r13.compareAndSet(r12, r14, r0) == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0095, code lost:
    
        if (r13.get(r12) == r14) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000a, code lost:
    
        if (r14 != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0081, code lost:
    
        if (r14 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
    
        kotlin.jvm.internal.t.a(1, r14);
        ((c1.l) r14).invoke(m());
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0079, code lost:
    
        r0 = n1.e.f3339r;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        r5 = r3.get(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x004c, code lost:
    
        r5 = r3.get(r12);
        r13 = (int) (r5 >> 60);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0053, code lost:
    
        if (r13 == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0055, code lost:
    
        if (r13 == 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0058, code lost:
    
        r13 = r5 & 1152921504606846975L;
        r7 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0067, code lost:
    
        if (r3.compareAndSet(r4, r5, (r7 << 60) + r13) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
    
        if (((int) (r5 >> 60)) != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x005e, code lost:
    
        r13 = r5 & 1152921504606846975L;
        r7 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x002f, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0024, code lost:
    
        r4 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        r4 = n1.e.f3324a;
        r4 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if (r3.compareAndSet(r4, r5, (r5 & 1152921504606846975L) + (1 << 60)) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
    
        r5 = n1.e.f3340s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        r6 = n1.c.f3320k;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.lang.Throwable r13, boolean r14) {
        /*
            r12 = this;
            r0 = 60
            r1 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = n1.c.f3313d
            r9 = 1
            if (r14 == 0) goto L24
        Lc:
            long r5 = r3.get(r12)
            long r7 = r5 >> r0
            int r4 = (int) r7
            if (r4 != 0) goto L24
            long r7 = r5 & r1
            n1.k r4 = n1.e.f3324a
            long r10 = (long) r9
            long r10 = r10 << r0
            long r7 = r7 + r10
            r4 = r12
            boolean r5 = r3.compareAndSet(r4, r5, r7)
            if (r5 == 0) goto Lc
            goto L25
        L24:
            r4 = r12
        L25:
            F.h r5 = n1.e.f3340s
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = n1.c.f3320k
            boolean r7 = r6.compareAndSet(r12, r5, r13)
            if (r7 == 0) goto L31
            r10 = r9
            goto L39
        L31:
            java.lang.Object r6 = r6.get(r12)
            if (r6 == r5) goto L27
            r13 = 0
            r10 = r13
        L39:
            r11 = 3
            if (r14 == 0) goto L4c
        L3c:
            long r5 = r3.get(r12)
            long r13 = r5 & r1
            long r7 = (long) r11
            long r7 = r7 << r0
            long r7 = r7 + r13
            boolean r13 = r3.compareAndSet(r4, r5, r7)
            if (r13 == 0) goto L3c
            goto L69
        L4c:
            long r5 = r3.get(r12)
            long r13 = r5 >> r0
            int r13 = (int) r13
            if (r13 == 0) goto L5e
            if (r13 == r9) goto L58
            goto L69
        L58:
            long r13 = r5 & r1
            long r7 = (long) r11
        L5b:
            long r7 = r7 << r0
            long r7 = r7 + r13
            goto L63
        L5e:
            long r13 = r5 & r1
            r7 = 2
            long r7 = (long) r7
            goto L5b
        L63:
            boolean r13 = r3.compareAndSet(r4, r5, r7)
            if (r13 == 0) goto L4c
        L69:
            r12.s()
            if (r10 == 0) goto L98
        L6e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r13 = n1.c.f3321l
            java.lang.Object r14 = r13.get(r12)
            if (r14 != 0) goto L79
            F.h r0 = n1.e.q
            goto L7b
        L79:
            F.h r0 = n1.e.f3339r
        L7b:
            boolean r1 = r13.compareAndSet(r12, r14, r0)
            if (r1 == 0) goto L91
            if (r14 != 0) goto L84
            goto L98
        L84:
            kotlin.jvm.internal.t.a(r9, r14)
            c1.l r14 = (c1.l) r14
            java.lang.Throwable r13 = r12.m()
            r14.invoke(r13)
            return r10
        L91:
            java.lang.Object r1 = r13.get(r12)
            if (r1 == r14) goto L7b
            goto L6e
        L98:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.c.f(java.lang.Throwable, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x008d, code lost:
    
        r1 = (n1.k) ((q1.b) q1.b.f3511b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final n1.k g(long r13) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.c.g(long):n1.k");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0189, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00c6, code lost:
    
        c(r1, r4, r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0173 A[RETURN] */
    @Override // n1.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(T0.d r24, java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.c.h(T0.d, java.lang.Object):java.lang.Object");
    }

    @Override // n1.t
    public Object i(Object obj) {
        boolean z;
        j0 j0Var;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3313d;
        long j2 = atomicLongFieldUpdater.get(this);
        boolean z2 = false;
        long j3 = 1152921504606846975L;
        if (r(j2, false)) {
            z = false;
        } else {
            z = !e(j2 & 1152921504606846975L);
        }
        i iVar = j.f3345a;
        if (z) {
            return iVar;
        }
        InterfaceC0028c interfaceC0028c = e.f3333j;
        k kVar = (k) f3317h.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j4 = andIncrement & j3;
            boolean r2 = r(andIncrement, z2);
            int i2 = e.f3325b;
            long j5 = i2;
            long j6 = j4 / j5;
            int i3 = (int) (j4 % j5);
            if (kVar.f3542c != j6) {
                k a2 = a(this, j6, kVar);
                if (a2 == null) {
                    if (r2) {
                        return new h(o());
                    }
                    z2 = false;
                    j3 = 1152921504606846975L;
                } else {
                    kVar = a2;
                }
            }
            int d2 = d(this, kVar, i3, obj, j4, interfaceC0028c, r2);
            Q0.j jVar = Q0.j.f722a;
            if (d2 != 0) {
                if (d2 != 1) {
                    if (d2 != 2) {
                        if (d2 != 3) {
                            if (d2 != 4) {
                                if (d2 == 5) {
                                    kVar.a();
                                }
                                z2 = false;
                                j3 = 1152921504606846975L;
                            } else {
                                if (j4 < f3314e.get(this)) {
                                    kVar.a();
                                }
                                return new h(o());
                            }
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    } else {
                        if (r2) {
                            kVar.h();
                            return new h(o());
                        }
                        if (interfaceC0028c instanceof j0) {
                            j0Var = (j0) interfaceC0028c;
                        } else {
                            j0Var = null;
                        }
                        if (j0Var != null) {
                            j0Var.a(kVar, i3 + i2);
                        }
                        kVar.h();
                        return iVar;
                    }
                } else {
                    return jVar;
                }
            } else {
                kVar.a();
                return jVar;
            }
        }
    }

    public final void j(long j2) {
        k kVar = (k) f3318i.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f3314e;
            long j3 = atomicLongFieldUpdater.get(this);
            if (j2 < Math.max(this.f3322c + j3, f3315f.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j3, 1 + j3)) {
                long j4 = e.f3325b;
                long j5 = j3 / j4;
                int i2 = (int) (j3 % j4);
                if (kVar.f3542c != j5) {
                    k l2 = l(j5, kVar);
                    if (l2 != null) {
                        kVar = l2;
                    }
                }
                k kVar2 = kVar;
                if (A(kVar2, i2, j3, null) == e.f3338o) {
                    if (j3 < p()) {
                        kVar2.a();
                    }
                } else {
                    kVar2.a();
                }
                kVar = kVar2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x00bd, code lost:
    
        if ((r0.addAndGet(r15, r4 - r8) & 4611686018427387904L) != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x00c6, code lost:
    
        if ((r0.get(r15) & 4611686018427387904L) == 0) goto L144;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.c.k():void");
    }

    public final k l(long j2, k kVar) {
        Object b2;
        long j3;
        k kVar2 = e.f3324a;
        d dVar = d.f3323e;
        loop0: while (true) {
            b2 = q1.a.b(kVar, j2, dVar);
            if (!q1.a.e(b2)) {
                q1.r c2 = q1.a.c(b2);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3318i;
                    q1.r rVar = (q1.r) atomicReferenceFieldUpdater.get(this);
                    if (rVar.f3542c >= c2.f3542c) {
                        break loop0;
                    }
                    if (!c2.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, rVar, c2)) {
                        if (atomicReferenceFieldUpdater.get(this) != rVar) {
                            if (c2.e()) {
                                c2.d();
                            }
                        }
                    }
                    if (rVar.e()) {
                        rVar.d();
                    }
                }
            } else {
                break;
            }
        }
        if (q1.a.e(b2)) {
            s();
            if (kVar.f3542c * e.f3325b < p()) {
                kVar.a();
                return null;
            }
        } else {
            k kVar3 = (k) q1.a.c(b2);
            long j4 = kVar3.f3542c;
            if (!u() && j2 <= f3315f.get(this) / e.f3325b) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f3319j;
                    q1.r rVar2 = (q1.r) atomicReferenceFieldUpdater2.get(this);
                    if (rVar2.f3542c >= j4) {
                        break;
                    }
                    if (!kVar3.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, rVar2, kVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != rVar2) {
                            if (kVar3.e()) {
                                kVar3.d();
                            }
                        }
                    }
                    if (rVar2.e()) {
                        rVar2.d();
                    }
                }
            }
            if (j4 > j2) {
                long j5 = j4 * e.f3325b;
                do {
                    j3 = f3314e.get(this);
                    if (j3 >= j5) {
                        break;
                    }
                } while (!f3314e.compareAndSet(this, j3, j5));
                if (j4 * e.f3325b < p()) {
                    kVar3.a();
                }
            } else {
                return kVar3;
            }
        }
        return null;
    }

    public final Throwable m() {
        return (Throwable) f3320k.get(this);
    }

    public final Throwable n() {
        Throwable m2 = m();
        if (m2 == null) {
            return new NoSuchElementException("Channel was closed");
        }
        return m2;
    }

    public final Throwable o() {
        Throwable m2 = m();
        if (m2 == null) {
            return new IllegalStateException("Channel was closed");
        }
        return m2;
    }

    public final long p() {
        return f3313d.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x00a2, code lost:
    
        r0 = (n1.k) ((q1.b) q1.b.f3511b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(long r14, boolean r16) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.c.r(long, boolean):boolean");
    }

    public final boolean s() {
        return r(f3313d.get(this), false);
    }

    public boolean t() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0194, code lost:
    
        r16 = r7;
        r3 = (n1.k) r3.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x019d, code lost:
    
        if (r3 != null) goto L83;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.c.toString():java.lang.String");
    }

    public final boolean u() {
        long j2 = f3315f.get(this);
        if (j2 != 0 && j2 != Long.MAX_VALUE) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(long r5, n1.k r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f3542c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            q1.b r0 = r7.b()
            n1.k r0 = (n1.k) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.c()
            if (r5 == 0) goto L22
            q1.b r5 = r7.b()
            n1.k r5 = (n1.k) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = n1.c.f3319j
            java.lang.Object r6 = r5.get(r4)
            q1.r r6 = (q1.r) r6
            long r0 = r6.f3542c
            long r2 = r7.f3542c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.i()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r5 = r6.e()
            if (r5 == 0) goto L49
            r6.d()
        L49:
            return
        L4a:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3a
            boolean r5 = r7.e()
            if (r5 == 0) goto L22
            r7.d()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.c.v(long, n1.k):void");
    }

    public final Object w(T0.d dVar, Object obj) {
        C0230h c0230h = new C0230h(1, android.support.v4.media.session.a.v(dVar));
        c0230h.r();
        c0230h.resumeWith(AbstractC0051a.j(o()));
        Object q = c0230h.q();
        if (q == U0.a.f780c) {
            return q;
        }
        return Q0.j.f722a;
    }

    public final void x(j0 j0Var, boolean z) {
        Throwable o2;
        if (j0Var instanceof InterfaceC0228f) {
            T0.d dVar = (T0.d) j0Var;
            if (z) {
                o2 = n();
            } else {
                o2 = o();
            }
            dVar.resumeWith(AbstractC0051a.j(o2));
            return;
        }
        if (j0Var instanceof b) {
            b bVar = (b) j0Var;
            C0230h c0230h = bVar.f3311d;
            kotlin.jvm.internal.h.b(c0230h);
            bVar.f3311d = null;
            bVar.f3310c = e.f3335l;
            Throwable m2 = bVar.f3312e.m();
            if (m2 == null) {
                c0230h.resumeWith(Boolean.FALSE);
                return;
            } else {
                c0230h.resumeWith(AbstractC0051a.j(m2));
                return;
            }
        }
        throw new IllegalStateException(("Unexpected waiter: " + j0Var).toString());
    }

    public final boolean y(Object obj, Object obj2) {
        if (obj instanceof b) {
            kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            b bVar = (b) obj;
            C0230h c0230h = bVar.f3311d;
            kotlin.jvm.internal.h.b(c0230h);
            bVar.f3311d = null;
            bVar.f3310c = obj2;
            Boolean bool = Boolean.TRUE;
            k kVar = e.f3324a;
            F.h f2 = c0230h.f(bool, null);
            if (f2 == null) {
                return false;
            }
            c0230h.j(f2);
            return true;
        }
        if (obj instanceof InterfaceC0228f) {
            kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            InterfaceC0228f interfaceC0228f = (InterfaceC0228f) obj;
            k kVar2 = e.f3324a;
            F.h f3 = interfaceC0228f.f(obj2, null);
            if (f3 == null) {
                return false;
            }
            interfaceC0228f.j(f3);
            return true;
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }
}

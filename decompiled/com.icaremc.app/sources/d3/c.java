package d3;

import Z0.InterfaceC0136b;
import b3.C0232g;
import b3.InterfaceC0230e;
import b3.i0;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class c implements g {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3499g = AtomicLongFieldUpdater.newUpdater(c.class, "sendersAndCloseStatus$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3500h = AtomicLongFieldUpdater.newUpdater(c.class, "receivers$volatile");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3501i = AtomicLongFieldUpdater.newUpdater(c.class, "bufferEnd$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3502j = AtomicLongFieldUpdater.newUpdater(c.class, "completedExpandBuffersAndPauseFlag$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "sendSegment$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3503l = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "receiveSegment$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3504m = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3505n = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_closeCause$volatile");

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3506o = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;

    /* renamed from: f, reason: collision with root package name */
    public final int f3507f;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public c(int i4) {
        long j4;
        this.f3507f = i4;
        if (i4 >= 0) {
            k kVar = e.f3509a;
            if (i4 != 0) {
                if (i4 != Integer.MAX_VALUE) {
                    j4 = i4;
                } else {
                    j4 = Long.MAX_VALUE;
                }
            } else {
                j4 = 0;
            }
            this.bufferEnd$volatile = j4;
            this.completedExpandBuffersAndPauseFlag$volatile = f3501i.get(this);
            k kVar2 = new k(0L, null, this, 3);
            this.sendSegment$volatile = kVar2;
            this.receiveSegment$volatile = kVar2;
            if (u()) {
                kVar2 = e.f3509a;
                T2.h.c(kVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment$volatile = kVar2;
            this._closeCause$volatile = e.f3526s;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i4 + ", should be >=0").toString());
    }

    public static final k a(c cVar, long j4, k kVar) {
        Object b4;
        c cVar2;
        k kVar2 = e.f3509a;
        d dVar = d.f3508n;
        loop0: while (true) {
            b4 = g3.a.b(kVar, j4, dVar);
            if (!g3.a.e(b4)) {
                g3.r c4 = g3.a.c(b4);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k;
                    g3.r rVar = (g3.r) atomicReferenceFieldUpdater.get(cVar);
                    if (rVar.f3807c >= c4.f3807c) {
                        break loop0;
                    }
                    if (!c4.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(cVar, rVar, c4)) {
                        if (atomicReferenceFieldUpdater.get(cVar) != rVar) {
                            if (c4.e()) {
                                c4.d();
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
        boolean e4 = g3.a.e(b4);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3500h;
        if (e4) {
            cVar.s();
            if (kVar.f3807c * e.f3510b < atomicLongFieldUpdater.get(cVar)) {
                kVar.a();
                return null;
            }
        } else {
            k kVar3 = (k) g3.a.c(b4);
            long j5 = kVar3.f3807c;
            if (j5 > j4) {
                long j6 = e.f3510b * j5;
                while (true) {
                    long j7 = f3499g.get(cVar);
                    long j8 = 1152921504606846975L & j7;
                    if (j8 >= j6) {
                        cVar2 = cVar;
                        break;
                    }
                    cVar2 = cVar;
                    if (f3499g.compareAndSet(cVar2, j7, (((int) (j7 >> 60)) << 60) + j8)) {
                        break;
                    }
                    cVar = cVar2;
                }
                if (j5 * e.f3510b < atomicLongFieldUpdater.get(cVar2)) {
                    kVar3.a();
                }
            } else {
                return kVar3;
            }
        }
        return null;
    }

    public static final void c(c cVar, Object obj, C0232g c0232g) {
        c0232g.resumeWith(k3.b.f(cVar.o()));
    }

    public static final int d(c cVar, k kVar, int i4, Object obj, long j4, Object obj2, boolean z) {
        kVar.m(i4, obj);
        if (z) {
            return cVar.B(kVar, i4, obj, j4, obj2, z);
        }
        Object k4 = kVar.k(i4);
        if (k4 == null) {
            if (cVar.e(j4)) {
                if (kVar.j(i4, null, e.f3512d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (kVar.j(i4, null, obj2)) {
                    return 2;
                }
            }
        } else if (k4 instanceof i0) {
            kVar.m(i4, null);
            if (cVar.y(k4, obj)) {
                kVar.n(i4, e.f3517i);
                return 0;
            }
            R1.c cVar2 = e.k;
            if (kVar.f3533f.getAndSet((i4 * 2) + 1, cVar2) != cVar2) {
                kVar.l(i4, true);
                return 5;
            }
            return 5;
        }
        return cVar.B(kVar, i4, obj, j4, obj2, z);
    }

    public static void q(c cVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3502j;
        if ((atomicLongFieldUpdater.addAndGet(cVar, 1L) & 4611686018427387904L) == 0) {
            return;
        }
        do {
        } while ((atomicLongFieldUpdater.get(cVar) & 4611686018427387904L) != 0);
    }

    public static boolean z(Object obj) {
        if (obj instanceof InterfaceC0230e) {
            T2.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            InterfaceC0230e interfaceC0230e = (InterfaceC0230e) obj;
            k kVar = e.f3509a;
            R1.c h3 = interfaceC0230e.h(H2.i.f681a, null);
            if (h3 != null) {
                interfaceC0230e.l(h3);
                return true;
            }
            return false;
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public final Object A(k kVar, int i4, long j4, Object obj) {
        AtomicReferenceArray atomicReferenceArray = kVar.f3533f;
        Object k4 = kVar.k(i4);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3499g;
        if (k4 == null) {
            if (j4 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return e.f3521n;
                }
                if (kVar.j(i4, k4, obj)) {
                    k();
                    return e.f3520m;
                }
            }
        } else if (k4 == e.f3512d && kVar.j(i4, k4, e.f3517i)) {
            k();
            Object obj2 = atomicReferenceArray.get(i4 * 2);
            kVar.m(i4, null);
            return obj2;
        }
        while (true) {
            Object k5 = kVar.k(i4);
            if (k5 != null && k5 != e.f3513e) {
                if (k5 == e.f3512d) {
                    if (kVar.j(i4, k5, e.f3517i)) {
                        k();
                        Object obj3 = atomicReferenceArray.get(i4 * 2);
                        kVar.m(i4, null);
                        return obj3;
                    }
                } else {
                    R1.c cVar = e.f3518j;
                    if (k5 == cVar) {
                        return e.f3522o;
                    }
                    if (k5 == e.f3516h) {
                        return e.f3522o;
                    }
                    if (k5 == e.f3519l) {
                        k();
                        return e.f3522o;
                    }
                    if (k5 != e.f3515g && kVar.j(i4, k5, e.f3514f)) {
                        boolean z = k5 instanceof u;
                        if (z) {
                            k5 = ((u) k5).f3540a;
                        }
                        if (z(k5)) {
                            kVar.n(i4, e.f3517i);
                            k();
                            Object obj4 = atomicReferenceArray.get(i4 * 2);
                            kVar.m(i4, null);
                            return obj4;
                        }
                        kVar.n(i4, cVar);
                        kVar.h();
                        if (z) {
                            k();
                        }
                        return e.f3522o;
                    }
                }
            } else if (j4 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (kVar.j(i4, k5, e.f3516h)) {
                    k();
                    return e.f3522o;
                }
            } else {
                if (obj == null) {
                    return e.f3521n;
                }
                if (kVar.j(i4, k5, obj)) {
                    k();
                    return e.f3520m;
                }
            }
        }
    }

    public final int B(k kVar, int i4, Object obj, long j4, Object obj2, boolean z) {
        while (true) {
            Object k4 = kVar.k(i4);
            if (k4 == null) {
                if (e(j4) && !z) {
                    if (kVar.j(i4, null, e.f3512d)) {
                        break;
                    }
                } else if (z) {
                    if (kVar.j(i4, null, e.f3518j)) {
                        kVar.h();
                        return 4;
                    }
                } else {
                    if (obj2 == null) {
                        return 3;
                    }
                    if (kVar.j(i4, null, obj2)) {
                        return 2;
                    }
                }
            } else if (k4 == e.f3513e) {
                if (kVar.j(i4, k4, e.f3512d)) {
                    break;
                }
            } else {
                R1.c cVar = e.k;
                if (k4 == cVar) {
                    kVar.m(i4, null);
                    return 5;
                }
                if (k4 == e.f3516h) {
                    kVar.m(i4, null);
                    return 5;
                }
                if (k4 == e.f3519l) {
                    kVar.m(i4, null);
                    s();
                    return 4;
                }
                kVar.m(i4, null);
                if (k4 instanceof u) {
                    k4 = ((u) k4).f3540a;
                }
                if (y(k4, obj)) {
                    kVar.n(i4, e.f3517i);
                    return 0;
                }
                if (kVar.f3533f.getAndSet((i4 * 2) + 1, cVar) != cVar) {
                    kVar.l(i4, true);
                }
                return 5;
            }
        }
        return 1;
    }

    public final void C(long j4) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        boolean z;
        c cVar = this;
        if (!cVar.u()) {
            while (true) {
                atomicLongFieldUpdater = f3501i;
                if (atomicLongFieldUpdater.get(cVar) > j4) {
                    break;
                } else {
                    cVar = this;
                }
            }
            int i4 = e.f3511c;
            int i5 = 0;
            while (true) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = f3502j;
                if (i5 < i4) {
                    long j5 = atomicLongFieldUpdater.get(cVar);
                    if (j5 != (4611686018427387903L & atomicLongFieldUpdater2.get(cVar)) || j5 != atomicLongFieldUpdater.get(cVar)) {
                        i5++;
                    } else {
                        return;
                    }
                } else {
                    while (true) {
                        long j6 = atomicLongFieldUpdater2.get(cVar);
                        if (atomicLongFieldUpdater2.compareAndSet(cVar, j6, (j6 & 4611686018427387903L) + 4611686018427387904L)) {
                            break;
                        } else {
                            cVar = this;
                        }
                    }
                    while (true) {
                        long j7 = atomicLongFieldUpdater.get(cVar);
                        long j8 = atomicLongFieldUpdater2.get(cVar);
                        long j9 = j8 & 4611686018427387903L;
                        if ((j8 & 4611686018427387904L) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (j7 == j9 && j7 == atomicLongFieldUpdater.get(cVar)) {
                            break;
                        }
                        if (!z) {
                            cVar = this;
                            atomicLongFieldUpdater2.compareAndSet(cVar, j8, 4611686018427387904L + j9);
                        } else {
                            cVar = this;
                        }
                    }
                    while (true) {
                        long j10 = atomicLongFieldUpdater2.get(cVar);
                        if (atomicLongFieldUpdater2.compareAndSet(cVar, j10, j10 & 4611686018427387903L)) {
                            return;
                        } else {
                            cVar = this;
                        }
                    }
                }
            }
        }
    }

    @Override // d3.s
    public final void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        f(cancellationException, true);
    }

    public final boolean e(long j4) {
        if (j4 >= f3501i.get(this) && j4 >= f3500h.get(this) + this.f3507f) {
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
    
        r13 = d3.c.f3506o;
        r14 = r13.get(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
    
        if (r14 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
    
        r0 = d3.e.f3524q;
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
    
        T2.s.a(1, r14);
        ((S2.l) r14).f(m());
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0079, code lost:
    
        r0 = d3.e.f3525r;
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
    
        r4 = d3.e.f3509a;
        r4 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if (r3.compareAndSet(r4, r5, (r5 & 1152921504606846975L) + (1 << 60)) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
    
        r5 = d3.e.f3526s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        r6 = d3.c.f3505n;
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
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = d3.c.f3499g
            r9 = 1
            if (r14 == 0) goto L24
        Lc:
            long r5 = r3.get(r12)
            long r7 = r5 >> r0
            int r4 = (int) r7
            if (r4 != 0) goto L24
            long r7 = r5 & r1
            d3.k r4 = d3.e.f3509a
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
            R1.c r5 = d3.e.f3526s
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = d3.c.f3505n
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
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r13 = d3.c.f3506o
            java.lang.Object r14 = r13.get(r12)
            if (r14 != 0) goto L79
            R1.c r0 = d3.e.f3524q
            goto L7b
        L79:
            R1.c r0 = d3.e.f3525r
        L7b:
            boolean r1 = r13.compareAndSet(r12, r14, r0)
            if (r1 == 0) goto L91
            if (r14 != 0) goto L84
            goto L98
        L84:
            T2.s.a(r9, r14)
            S2.l r14 = (S2.l) r14
            java.lang.Throwable r13 = r12.m()
            r14.f(r13)
            return r10
        L91:
            java.lang.Object r1 = r13.get(r12)
            if (r1 == r14) goto L7b
            goto L6e
        L98:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.c.f(java.lang.Throwable, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0177, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00c2, code lost:
    
        c(r1, r4, r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0163 A[RETURN] */
    @Override // d3.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(K2.d r23, java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.c.g(K2.d, java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x008d, code lost:
    
        r1 = (d3.k) ((g3.b) g3.b.f3778b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d3.k h(long r13) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.c.h(long):d3.k");
    }

    @Override // d3.t
    public Object i(Object obj) {
        boolean z;
        i0 i0Var;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3499g;
        long j4 = atomicLongFieldUpdater.get(this);
        boolean z3 = false;
        long j5 = 1152921504606846975L;
        if (r(j4, false)) {
            z = false;
        } else {
            z = !e(j4 & 1152921504606846975L);
        }
        i iVar = j.f3531a;
        if (z) {
            return iVar;
        }
        InterfaceC0136b interfaceC0136b = e.f3518j;
        k kVar = (k) k.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j6 = andIncrement & j5;
            boolean r3 = r(andIncrement, z3);
            int i4 = e.f3510b;
            long j7 = i4;
            long j8 = j6 / j7;
            int i5 = (int) (j6 % j7);
            if (kVar.f3807c != j8) {
                k a4 = a(this, j8, kVar);
                if (a4 == null) {
                    if (r3) {
                        return new h(o());
                    }
                    z3 = false;
                    j5 = 1152921504606846975L;
                } else {
                    kVar = a4;
                }
            }
            int d4 = d(this, kVar, i5, obj, j6, interfaceC0136b, r3);
            H2.i iVar2 = H2.i.f681a;
            if (d4 != 0) {
                if (d4 != 1) {
                    if (d4 != 2) {
                        if (d4 != 3) {
                            if (d4 != 4) {
                                if (d4 == 5) {
                                    kVar.a();
                                }
                                z3 = false;
                                j5 = 1152921504606846975L;
                            } else {
                                if (j6 < f3500h.get(this)) {
                                    kVar.a();
                                }
                                return new h(o());
                            }
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    } else {
                        if (r3) {
                            kVar.h();
                            return new h(o());
                        }
                        if (interfaceC0136b instanceof i0) {
                            i0Var = (i0) interfaceC0136b;
                        } else {
                            i0Var = null;
                        }
                        if (i0Var != null) {
                            i0Var.a(kVar, i5 + i4);
                        }
                        kVar.h();
                        return iVar;
                    }
                } else {
                    return iVar2;
                }
            } else {
                kVar.a();
                return iVar2;
            }
        }
    }

    public final void j(long j4) {
        k kVar = (k) f3503l.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f3500h;
            long j5 = atomicLongFieldUpdater.get(this);
            if (j4 < Math.max(this.f3507f + j5, f3501i.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j5, 1 + j5)) {
                long j6 = e.f3510b;
                long j7 = j5 / j6;
                int i4 = (int) (j5 % j6);
                if (kVar.f3807c != j7) {
                    k l3 = l(j7, kVar);
                    if (l3 != null) {
                        kVar = l3;
                    }
                }
                k kVar2 = kVar;
                if (A(kVar2, i4, j5, null) == e.f3522o) {
                    if (j5 < p()) {
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
        throw new UnsupportedOperationException("Method not decompiled: d3.c.k():void");
    }

    public final k l(long j4, k kVar) {
        Object b4;
        long j5;
        k kVar2 = e.f3509a;
        d dVar = d.f3508n;
        loop0: while (true) {
            b4 = g3.a.b(kVar, j4, dVar);
            if (!g3.a.e(b4)) {
                g3.r c4 = g3.a.c(b4);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3503l;
                    g3.r rVar = (g3.r) atomicReferenceFieldUpdater.get(this);
                    if (rVar.f3807c >= c4.f3807c) {
                        break loop0;
                    }
                    if (!c4.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, rVar, c4)) {
                        if (atomicReferenceFieldUpdater.get(this) != rVar) {
                            if (c4.e()) {
                                c4.d();
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
        if (g3.a.e(b4)) {
            s();
            if (kVar.f3807c * e.f3510b < p()) {
                kVar.a();
                return null;
            }
        } else {
            k kVar3 = (k) g3.a.c(b4);
            long j6 = kVar3.f3807c;
            if (!u() && j4 <= f3501i.get(this) / e.f3510b) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f3504m;
                    g3.r rVar2 = (g3.r) atomicReferenceFieldUpdater2.get(this);
                    if (rVar2.f3807c >= j6) {
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
            if (j6 > j4) {
                long j7 = j6 * e.f3510b;
                do {
                    j5 = f3500h.get(this);
                    if (j5 >= j7) {
                        break;
                    }
                } while (!f3500h.compareAndSet(this, j5, j7));
                if (j6 * e.f3510b < p()) {
                    kVar3.a();
                }
            } else {
                return kVar3;
            }
        }
        return null;
    }

    public final Throwable m() {
        return (Throwable) f3505n.get(this);
    }

    public final Throwable n() {
        Throwable m3 = m();
        if (m3 == null) {
            return new NoSuchElementException("Channel was closed");
        }
        return m3;
    }

    public final Throwable o() {
        Throwable m3 = m();
        if (m3 == null) {
            return new IllegalStateException("Channel was closed");
        }
        return m3;
    }

    public final long p() {
        return f3499g.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x00a2, code lost:
    
        r0 = (d3.k) ((g3.b) g3.b.f3778b.get(r0));
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
        throw new UnsupportedOperationException("Method not decompiled: d3.c.r(long, boolean):boolean");
    }

    public final boolean s() {
        return r(f3499g.get(this), false);
    }

    public boolean t() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0194, code lost:
    
        r16 = r7;
        r3 = (d3.k) r3.b();
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
        throw new UnsupportedOperationException("Method not decompiled: d3.c.toString():java.lang.String");
    }

    public final boolean u() {
        long j4 = f3501i.get(this);
        if (j4 != 0 && j4 != Long.MAX_VALUE) {
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
    public final void v(long r5, d3.k r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f3807c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            g3.b r0 = r7.b()
            d3.k r0 = (d3.k) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.c()
            if (r5 == 0) goto L22
            g3.b r5 = r7.b()
            d3.k r5 = (d3.k) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = d3.c.f3504m
            java.lang.Object r6 = r5.get(r4)
            g3.r r6 = (g3.r) r6
            long r0 = r6.f3807c
            long r2 = r7.f3807c
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
        throw new UnsupportedOperationException("Method not decompiled: d3.c.v(long, d3.k):void");
    }

    public final Object w(K2.d dVar, Object obj) {
        C0232g c0232g = new C0232g(1, k3.b.r(dVar));
        c0232g.s();
        c0232g.resumeWith(k3.b.f(o()));
        Object r3 = c0232g.r();
        if (r3 == L2.a.f1019f) {
            return r3;
        }
        return H2.i.f681a;
    }

    public final void x(i0 i0Var, boolean z) {
        Throwable o3;
        if (i0Var instanceof InterfaceC0230e) {
            K2.d dVar = (K2.d) i0Var;
            if (z) {
                o3 = n();
            } else {
                o3 = o();
            }
            dVar.resumeWith(k3.b.f(o3));
            return;
        }
        if (i0Var instanceof b) {
            b bVar = (b) i0Var;
            C0232g c0232g = bVar.f3497g;
            T2.h.b(c0232g);
            bVar.f3497g = null;
            bVar.f3496f = e.f3519l;
            Throwable m3 = bVar.f3498h.m();
            if (m3 == null) {
                c0232g.resumeWith(Boolean.FALSE);
                return;
            } else {
                c0232g.resumeWith(k3.b.f(m3));
                return;
            }
        }
        throw new IllegalStateException(("Unexpected waiter: " + i0Var).toString());
    }

    public final boolean y(Object obj, Object obj2) {
        if (obj instanceof b) {
            T2.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            b bVar = (b) obj;
            C0232g c0232g = bVar.f3497g;
            T2.h.b(c0232g);
            bVar.f3497g = null;
            bVar.f3496f = obj2;
            Boolean bool = Boolean.TRUE;
            k kVar = e.f3509a;
            R1.c h3 = c0232g.h(bool, null);
            if (h3 == null) {
                return false;
            }
            c0232g.l(h3);
            return true;
        }
        if (obj instanceof InterfaceC0230e) {
            T2.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            InterfaceC0230e interfaceC0230e = (InterfaceC0230e) obj;
            k kVar2 = e.f3509a;
            R1.c h4 = interfaceC0230e.h(obj2, null);
            if (h4 == null) {
                return false;
            }
            interfaceC0230e.l(h4);
            return true;
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }
}

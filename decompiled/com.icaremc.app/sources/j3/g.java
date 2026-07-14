package j3;

import D2.M;
import b3.C0231f;
import b3.C0232g;
import b3.InterfaceC0230e;
import g3.r;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5093b = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "head$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f5094c = AtomicLongFieldUpdater.newUpdater(g.class, "deqIdx$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5095d = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "tail$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f5096e = AtomicLongFieldUpdater.newUpdater(g.class, "enqIdx$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5097f = AtomicIntegerFieldUpdater.newUpdater(g.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final C0231f f5098a;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public g() {
        i iVar = new i(0L, null, 2);
        this.head$volatile = iVar;
        this.tail$volatile = iVar;
        this._availablePermits$volatile = 1;
        this.f5098a = new C0231f(2, this);
    }

    public final void a(b bVar) {
        Object b4;
        i iVar;
        C0232g c0232g = bVar.f5087f;
        c cVar = bVar.f5088g;
        while (true) {
            int andDecrement = f5097f.getAndDecrement(this);
            if (andDecrement <= 1) {
                H2.i iVar2 = H2.i.f681a;
                if (andDecrement > 0) {
                    c.f5089g.set(cVar, null);
                    c0232g.A(iVar2, c0232g.f3312h, new C0231f(0, new M(cVar, bVar)));
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5095d;
                i iVar3 = (i) atomicReferenceFieldUpdater.get(this);
                long andIncrement = f5096e.getAndIncrement(this);
                e eVar = e.f5091n;
                long j4 = andIncrement / h.f5104f;
                while (true) {
                    b4 = g3.a.b(iVar3, j4, eVar);
                    if (!g3.a.e(b4)) {
                        r c4 = g3.a.c(b4);
                        while (true) {
                            r rVar = (r) atomicReferenceFieldUpdater.get(this);
                            iVar = iVar3;
                            if (rVar.f3807c >= c4.f3807c) {
                                break;
                            }
                            if (!c4.i()) {
                                break;
                            }
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, rVar, c4)) {
                                if (atomicReferenceFieldUpdater.get(this) != rVar) {
                                    if (c4.e()) {
                                        c4.d();
                                    }
                                    iVar3 = iVar;
                                }
                            }
                            if (rVar.e()) {
                                rVar.d();
                            }
                        }
                    } else {
                        break;
                    }
                    iVar3 = iVar;
                }
                i iVar4 = (i) g3.a.c(b4);
                AtomicReferenceArray atomicReferenceArray = iVar4.f5105e;
                int i4 = (int) (andIncrement % h.f5104f);
                while (!atomicReferenceArray.compareAndSet(i4, null, bVar)) {
                    if (atomicReferenceArray.get(i4) != null) {
                        R1.c cVar2 = h.f5100b;
                        R1.c cVar3 = h.f5101c;
                        while (!atomicReferenceArray.compareAndSet(i4, cVar2, cVar3)) {
                            if (atomicReferenceArray.get(i4) != cVar2) {
                                break;
                            }
                        }
                        c.f5089g.set(cVar, null);
                        c0232g.A(iVar2, c0232g.f3312h, new C0231f(0, new M(cVar, bVar)));
                        return;
                    }
                }
                bVar.a(iVar4, i4);
                return;
            }
        }
    }

    public final void b() {
        boolean z;
        int i4;
        Object b4;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f5097f;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            z = true;
            if (andIncrement < 1) {
                if (andIncrement < 0) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5093b;
                    i iVar = (i) atomicReferenceFieldUpdater.get(this);
                    long andIncrement2 = f5094c.getAndIncrement(this);
                    long j4 = andIncrement2 / h.f5104f;
                    f fVar = f.f5092n;
                    while (true) {
                        b4 = g3.a.b(iVar, j4, fVar);
                        if (!g3.a.e(b4)) {
                            r c4 = g3.a.c(b4);
                            while (true) {
                                r rVar = (r) atomicReferenceFieldUpdater.get(this);
                                if (rVar.f3807c >= c4.f3807c) {
                                    break;
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
                    i iVar2 = (i) g3.a.c(b4);
                    AtomicReferenceArray atomicReferenceArray = iVar2.f5105e;
                    iVar2.a();
                    boolean z3 = false;
                    if (iVar2.f3807c <= j4) {
                        int i5 = (int) (andIncrement2 % h.f5104f);
                        Object andSet = atomicReferenceArray.getAndSet(i5, h.f5100b);
                        if (andSet == null) {
                            int i6 = h.f5099a;
                            int i7 = 0;
                            while (true) {
                                if (i7 < i6) {
                                    if (atomicReferenceArray.get(i5) == h.f5101c) {
                                        break;
                                    } else {
                                        i7++;
                                    }
                                } else {
                                    R1.c cVar = h.f5100b;
                                    R1.c cVar2 = h.f5102d;
                                    while (true) {
                                        if (atomicReferenceArray.compareAndSet(i5, cVar, cVar2)) {
                                            z3 = true;
                                            break;
                                        } else if (atomicReferenceArray.get(i5) != cVar) {
                                            break;
                                        }
                                    }
                                    z = true ^ z3;
                                }
                            }
                        } else if (andSet != h.f5103e) {
                            if (andSet instanceof InterfaceC0230e) {
                                InterfaceC0230e interfaceC0230e = (InterfaceC0230e) andSet;
                                R1.c h3 = interfaceC0230e.h(H2.i.f681a, this.f5098a);
                                if (h3 != null) {
                                    interfaceC0230e.l(h3);
                                }
                            } else {
                                throw new IllegalStateException(("unexpected: " + andSet).toString());
                            }
                        }
                    }
                    z = false;
                } else {
                    return;
                }
            } else {
                do {
                    i4 = atomicIntegerFieldUpdater.get(this);
                    if (i4 <= 1) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, 1));
                throw new IllegalStateException("The number of released permits cannot be greater than 1".toString());
            }
        } while (!z);
    }
}

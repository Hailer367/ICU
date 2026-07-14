package t1;

import Q0.j;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import l1.C0229g;
import l1.C0230h;
import l1.InterfaceC0228f;
import q1.r;

/* loaded from: classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3660b = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "head$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3661c = AtomicLongFieldUpdater.newUpdater(g.class, "deqIdx$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3662d = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "tail$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3663e = AtomicLongFieldUpdater.newUpdater(g.class, "enqIdx$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3664f = AtomicIntegerFieldUpdater.newUpdater(g.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final C0229g f3665a;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public g() {
        i iVar = new i(0L, null, 2);
        this.head$volatile = iVar;
        this.tail$volatile = iVar;
        this._availablePermits$volatile = 1;
        this.f3665a = new C0229g(2, this);
    }

    public final void a(b bVar) {
        Object b2;
        i iVar;
        C0230h c0230h = bVar.f3654c;
        c cVar = bVar.f3655d;
        while (true) {
            int andDecrement = f3664f.getAndDecrement(this);
            if (andDecrement <= 1) {
                j jVar = j.f722a;
                if (andDecrement > 0) {
                    c.f3656g.set(cVar, null);
                    c0230h.z(jVar, c0230h.f2949e, new C0229g(0, new R0.a(cVar, bVar)));
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3662d;
                i iVar2 = (i) atomicReferenceFieldUpdater.get(this);
                long andIncrement = f3663e.getAndIncrement(this);
                e eVar = e.f3658e;
                long j2 = andIncrement / h.f3671f;
                while (true) {
                    b2 = q1.a.b(iVar2, j2, eVar);
                    if (!q1.a.e(b2)) {
                        r c2 = q1.a.c(b2);
                        while (true) {
                            r rVar = (r) atomicReferenceFieldUpdater.get(this);
                            iVar = iVar2;
                            if (rVar.f3542c >= c2.f3542c) {
                                break;
                            }
                            if (!c2.i()) {
                                break;
                            }
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, rVar, c2)) {
                                if (atomicReferenceFieldUpdater.get(this) != rVar) {
                                    if (c2.e()) {
                                        c2.d();
                                    }
                                    iVar2 = iVar;
                                }
                            }
                            if (rVar.e()) {
                                rVar.d();
                            }
                        }
                    } else {
                        break;
                    }
                    iVar2 = iVar;
                }
                i iVar3 = (i) q1.a.c(b2);
                AtomicReferenceArray atomicReferenceArray = iVar3.f3672e;
                int i2 = (int) (andIncrement % h.f3671f);
                while (!atomicReferenceArray.compareAndSet(i2, null, bVar)) {
                    if (atomicReferenceArray.get(i2) != null) {
                        F.h hVar = h.f3667b;
                        F.h hVar2 = h.f3668c;
                        while (!atomicReferenceArray.compareAndSet(i2, hVar, hVar2)) {
                            if (atomicReferenceArray.get(i2) != hVar) {
                                break;
                            }
                        }
                        c.f3656g.set(cVar, null);
                        c0230h.z(jVar, c0230h.f2949e, new C0229g(0, new R0.a(cVar, bVar)));
                        return;
                    }
                }
                bVar.a(iVar3, i2);
                return;
            }
        }
    }

    public final void b() {
        boolean z;
        int i2;
        Object b2;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3664f;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            z = true;
            if (andIncrement < 1) {
                if (andIncrement < 0) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3660b;
                    i iVar = (i) atomicReferenceFieldUpdater.get(this);
                    long andIncrement2 = f3661c.getAndIncrement(this);
                    long j2 = andIncrement2 / h.f3671f;
                    f fVar = f.f3659e;
                    while (true) {
                        b2 = q1.a.b(iVar, j2, fVar);
                        if (!q1.a.e(b2)) {
                            r c2 = q1.a.c(b2);
                            while (true) {
                                r rVar = (r) atomicReferenceFieldUpdater.get(this);
                                if (rVar.f3542c >= c2.f3542c) {
                                    break;
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
                    i iVar2 = (i) q1.a.c(b2);
                    AtomicReferenceArray atomicReferenceArray = iVar2.f3672e;
                    iVar2.a();
                    boolean z2 = false;
                    if (iVar2.f3542c <= j2) {
                        int i3 = (int) (andIncrement2 % h.f3671f);
                        Object andSet = atomicReferenceArray.getAndSet(i3, h.f3667b);
                        if (andSet == null) {
                            int i4 = h.f3666a;
                            int i5 = 0;
                            while (true) {
                                if (i5 < i4) {
                                    if (atomicReferenceArray.get(i3) == h.f3668c) {
                                        break;
                                    } else {
                                        i5++;
                                    }
                                } else {
                                    F.h hVar = h.f3667b;
                                    F.h hVar2 = h.f3669d;
                                    while (true) {
                                        if (atomicReferenceArray.compareAndSet(i3, hVar, hVar2)) {
                                            z2 = true;
                                            break;
                                        } else if (atomicReferenceArray.get(i3) != hVar) {
                                            break;
                                        }
                                    }
                                    z = true ^ z2;
                                }
                            }
                        } else if (andSet != h.f3670e) {
                            if (andSet instanceof InterfaceC0228f) {
                                InterfaceC0228f interfaceC0228f = (InterfaceC0228f) andSet;
                                F.h f2 = interfaceC0228f.f(j.f722a, this.f3665a);
                                if (f2 != null) {
                                    interfaceC0228f.j(f2);
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
                    i2 = atomicIntegerFieldUpdater.get(this);
                    if (i2 <= 1) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 1));
                throw new IllegalStateException("The number of released permits cannot be greater than 1".toString());
            }
        } while (!z);
    }
}

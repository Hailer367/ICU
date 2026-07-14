package b3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class S extends g3.j implements B, K {

    /* renamed from: d, reason: collision with root package name */
    public W f3252d;

    @Override // b3.K
    public final boolean a() {
        return true;
    }

    @Override // b3.K
    public final X c() {
        return null;
    }

    @Override // b3.B
    public final void dispose() {
        W i4 = i();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = W.f3262f;
            Object obj = atomicReferenceFieldUpdater.get(i4);
            if (obj instanceof S) {
                if (obj == this) {
                    D d4 = AbstractC0245u.f3307i;
                    while (!atomicReferenceFieldUpdater.compareAndSet(i4, obj, d4)) {
                        if (atomicReferenceFieldUpdater.get(i4) != obj) {
                            break;
                        }
                    }
                    return;
                }
                return;
            }
            if (!(obj instanceof K) || ((K) obj).c() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = g3.j.f3791a;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof g3.o) {
                    g3.j jVar = ((g3.o) obj2).f3804a;
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                T2.h.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                g3.j jVar2 = (g3.j) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = g3.j.f3793c;
                g3.o oVar = (g3.o) atomicReferenceFieldUpdater3.get(jVar2);
                if (oVar == null) {
                    oVar = new g3.o(jVar2);
                    atomicReferenceFieldUpdater3.set(jVar2, oVar);
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, oVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                        break;
                    }
                }
                jVar2.e();
                return;
            }
        }
    }

    public N getParent() {
        return i();
    }

    public final W i() {
        W w2 = this.f3252d;
        if (w2 != null) {
            return w2;
        }
        T2.h.g("job");
        throw null;
    }

    public abstract boolean j();

    public abstract void k(Throwable th);

    @Override // g3.j
    public final String toString() {
        return getClass().getSimpleName() + '@' + AbstractC0245u.b(this) + "[job@" + AbstractC0245u.b(i()) + ']';
    }
}

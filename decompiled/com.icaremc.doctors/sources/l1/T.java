package l1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class T extends q1.j implements D, L {

    /* renamed from: d, reason: collision with root package name */
    public X f2966d;

    @Override // l1.L
    public final boolean a() {
        return true;
    }

    @Override // l1.L
    public final Y c() {
        return null;
    }

    @Override // l1.D
    public final void dispose() {
        X i2 = i();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = X.f2976c;
            Object obj = atomicReferenceFieldUpdater.get(i2);
            if (obj instanceof T) {
                if (obj == this) {
                    E e2 = AbstractC0244w.f3024i;
                    while (!atomicReferenceFieldUpdater.compareAndSet(i2, obj, e2)) {
                        if (atomicReferenceFieldUpdater.get(i2) != obj) {
                            break;
                        }
                    }
                    return;
                }
                return;
            }
            if (!(obj instanceof L) || ((L) obj).c() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = q1.j.f3526a;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof q1.o) {
                    q1.j jVar = ((q1.o) obj2).f3539a;
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                kotlin.jvm.internal.h.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                q1.j jVar2 = (q1.j) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = q1.j.f3528c;
                q1.o oVar = (q1.o) atomicReferenceFieldUpdater3.get(jVar2);
                if (oVar == null) {
                    oVar = new q1.o(jVar2);
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

    public O getParent() {
        return i();
    }

    public final X i() {
        X x2 = this.f2966d;
        if (x2 != null) {
            return x2;
        }
        kotlin.jvm.internal.h.g("job");
        throw null;
    }

    public abstract boolean j();

    public abstract void k(Throwable th);

    @Override // q1.j
    public final String toString() {
        return getClass().getSimpleName() + '@' + AbstractC0244w.b(this) + "[job@" + AbstractC0244w.b(i()) + ']';
    }
}

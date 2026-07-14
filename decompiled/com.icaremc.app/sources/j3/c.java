package j3;

import b3.AbstractC0245u;
import b3.C0232g;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class c extends g implements a {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5089g = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile = d.f5090a;

    public final Object c(M2.c cVar) {
        boolean d4 = d();
        H2.i iVar = H2.i.f681a;
        if (!d4) {
            C0232g c4 = AbstractC0245u.c(k3.b.r(cVar));
            try {
                a(new b(this, c4));
                Object r3 = c4.r();
                L2.a aVar = L2.a.f1019f;
                if (r3 != aVar) {
                    r3 = iVar;
                }
                if (r3 == aVar) {
                    return r3;
                }
            } catch (Throwable th) {
                c4.y();
                throw th;
            }
        }
        return iVar;
    }

    public final boolean d() {
        int i4;
        char c4;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g.f5097f;
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 > 1) {
                do {
                    i4 = atomicIntegerFieldUpdater.get(this);
                    if (i4 > 1) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, 1));
            } else {
                if (i5 <= 0) {
                    c4 = 1;
                    break;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i5, i5 - 1)) {
                    f5089g.set(this, null);
                    c4 = 0;
                    break;
                }
            }
        }
        if (c4 == 0) {
            return true;
        }
        if (c4 == 1) {
            return false;
        }
        if (c4 != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException("This mutex is already locked by the specified owner: null".toString());
    }

    public final void e(Object obj) {
        while (Math.max(g.f5097f.get(this), 0) == 0) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5089g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            R1.c cVar = d.f5090a;
            if (obj2 != cVar) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, cVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                b();
                return;
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Mutex@");
        sb.append(AbstractC0245u.b(this));
        sb.append("[isLocked=");
        boolean z = false;
        if (Math.max(g.f5097f.get(this), 0) == 0) {
            z = true;
        }
        sb.append(z);
        sb.append(",owner=");
        sb.append(f5089g.get(this));
        sb.append(']');
        return sb.toString();
    }
}

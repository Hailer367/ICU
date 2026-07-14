package t1;

import Q0.j;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import l1.AbstractC0244w;
import l1.C0230h;

/* loaded from: classes.dex */
public final class c extends g implements a {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3656g = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile = d.f3657a;

    public final Object c(V0.c cVar) {
        boolean d2 = d();
        j jVar = j.f722a;
        if (!d2) {
            C0230h c2 = AbstractC0244w.c(android.support.v4.media.session.a.v(cVar));
            try {
                a(new b(this, c2));
                Object q = c2.q();
                U0.a aVar = U0.a.f780c;
                if (q != aVar) {
                    q = jVar;
                }
                if (q == aVar) {
                    return q;
                }
            } catch (Throwable th) {
                c2.x();
                throw th;
            }
        }
        return jVar;
    }

    public final boolean d() {
        int i2;
        char c2;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g.f3664f;
            int i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 > 1) {
                do {
                    i2 = atomicIntegerFieldUpdater.get(this);
                    if (i2 > 1) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 1));
            } else {
                if (i3 <= 0) {
                    c2 = 1;
                    break;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i3, i3 - 1)) {
                    f3656g.set(this, null);
                    c2 = 0;
                    break;
                }
            }
        }
        if (c2 == 0) {
            return true;
        }
        if (c2 == 1) {
            return false;
        }
        if (c2 != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException("This mutex is already locked by the specified owner: null".toString());
    }

    public final void e(Object obj) {
        while (Math.max(g.f3664f.get(this), 0) == 0) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3656g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            F.h hVar = d.f3657a;
            if (obj2 != hVar) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, hVar)) {
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
        sb.append(AbstractC0244w.b(this));
        sb.append("[isLocked=");
        boolean z = false;
        if (Math.max(g.f3664f.get(this), 0) == 0) {
            z = true;
        }
        sb.append(z);
        sb.append(",owner=");
        sb.append(f3656g.get(this));
        sb.append(']');
        return sb.toString();
    }
}

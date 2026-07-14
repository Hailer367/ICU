package v;

import a.AbstractC0141a;

/* renamed from: v.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0674f extends AbstractC0141a {
    @Override // a.AbstractC0141a
    public final void B(C0675g c0675g, C0675g c0675g2) {
        c0675g.f6252b = c0675g2;
    }

    @Override // a.AbstractC0141a
    public final void C(C0675g c0675g, Thread thread) {
        c0675g.f6251a = thread;
    }

    @Override // a.AbstractC0141a
    public final boolean b(AbstractFutureC0676h abstractFutureC0676h, C0672d c0672d) {
        C0672d c0672d2 = C0672d.f6243b;
        synchronized (abstractFutureC0676h) {
            try {
                if (abstractFutureC0676h.f6257g == c0672d) {
                    abstractFutureC0676h.f6257g = c0672d2;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.AbstractC0141a
    public final boolean c(AbstractFutureC0676h abstractFutureC0676h, Object obj, Object obj2) {
        synchronized (abstractFutureC0676h) {
            try {
                if (abstractFutureC0676h.f6256f == obj) {
                    abstractFutureC0676h.f6256f = obj2;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.AbstractC0141a
    public final boolean d(AbstractFutureC0676h abstractFutureC0676h, C0675g c0675g, C0675g c0675g2) {
        synchronized (abstractFutureC0676h) {
            try {
                if (abstractFutureC0676h.f6258h == c0675g) {
                    abstractFutureC0676h.f6258h = c0675g2;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

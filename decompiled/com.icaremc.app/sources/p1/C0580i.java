package p1;

import Z0.r;

/* renamed from: p1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0580i {

    /* renamed from: a, reason: collision with root package name */
    public final C0585n f5821a = new C0585n();

    public final void a(Exception exc) {
        this.f5821a.m(exc);
    }

    public final void b(Object obj) {
        this.f5821a.l(obj);
    }

    public final boolean c(Exception exc) {
        C0585n c0585n = this.f5821a;
        c0585n.getClass();
        r.f(exc, "Exception must not be null");
        synchronized (c0585n.f5832a) {
            try {
                if (c0585n.f5834c) {
                    return false;
                }
                c0585n.f5834c = true;
                c0585n.f5837f = exc;
                c0585n.f5833b.c(c0585n);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(Object obj) {
        C0585n c0585n = this.f5821a;
        synchronized (c0585n.f5832a) {
            try {
                if (c0585n.f5834c) {
                    return;
                }
                c0585n.f5834c = true;
                c0585n.f5836e = obj;
                c0585n.f5833b.c(c0585n);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

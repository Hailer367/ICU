package p1;

import Z0.r;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* renamed from: p1.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0585n extends AbstractC0579h {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5832a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Y0.h f5833b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5834c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f5835d;

    /* renamed from: e, reason: collision with root package name */
    public Object f5836e;

    /* renamed from: f, reason: collision with root package name */
    public Exception f5837f;

    /* JADX WARN: Type inference failed for: r0v1, types: [Y0.h, java.lang.Object] */
    public C0585n() {
        ?? obj = new Object();
        obj.f2045c = new Object();
        this.f5833b = obj;
    }

    @Override // p1.AbstractC0579h
    public final C0585n a(Executor executor, InterfaceC0575d interfaceC0575d) {
        this.f5833b.b(new C0583l(executor, interfaceC0575d));
        p();
        return this;
    }

    @Override // p1.AbstractC0579h
    public final C0585n b(Executor executor, InterfaceC0576e interfaceC0576e) {
        this.f5833b.b(new C0583l(executor, interfaceC0576e));
        p();
        return this;
    }

    @Override // p1.AbstractC0579h
    public final Exception c() {
        Exception exc;
        synchronized (this.f5832a) {
            exc = this.f5837f;
        }
        return exc;
    }

    @Override // p1.AbstractC0579h
    public final Object d() {
        Object obj;
        synchronized (this.f5832a) {
            try {
                if (this.f5834c) {
                    if (!this.f5835d) {
                        Exception exc = this.f5837f;
                        if (exc == null) {
                            obj = this.f5836e;
                        } else {
                            throw new RuntimeException(exc);
                        }
                    } else {
                        throw new CancellationException("Task is already canceled.");
                    }
                } else {
                    throw new IllegalStateException("Task is not yet complete");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // p1.AbstractC0579h
    public final boolean e() {
        boolean z;
        synchronized (this.f5832a) {
            z = this.f5834c;
        }
        return z;
    }

    @Override // p1.AbstractC0579h
    public final boolean f() {
        boolean z;
        synchronized (this.f5832a) {
            try {
                z = false;
                if (this.f5834c && !this.f5835d && this.f5837f == null) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    public final C0585n g(Executor executor, InterfaceC0574c interfaceC0574c) {
        this.f5833b.b(new C0583l(executor, interfaceC0574c));
        p();
        return this;
    }

    public final C0585n h(InterfaceC0574c interfaceC0574c) {
        this.f5833b.b(new C0583l(AbstractC0581j.f5822a, interfaceC0574c));
        p();
        return this;
    }

    public final C0585n i(Executor executor, InterfaceC0572a interfaceC0572a) {
        C0585n c0585n = new C0585n();
        this.f5833b.b(new C0582k(executor, interfaceC0572a, c0585n, 0));
        p();
        return c0585n;
    }

    public final C0585n j(Executor executor, InterfaceC0572a interfaceC0572a) {
        C0585n c0585n = new C0585n();
        this.f5833b.b(new C0582k(executor, interfaceC0572a, c0585n, 1));
        p();
        return c0585n;
    }

    public final C0585n k(Executor executor, InterfaceC0578g interfaceC0578g) {
        C0585n c0585n = new C0585n();
        this.f5833b.b(new C0583l(executor, interfaceC0578g, c0585n));
        p();
        return c0585n;
    }

    public final void l(Object obj) {
        synchronized (this.f5832a) {
            o();
            this.f5834c = true;
            this.f5836e = obj;
        }
        this.f5833b.c(this);
    }

    public final void m(Exception exc) {
        r.f(exc, "Exception must not be null");
        synchronized (this.f5832a) {
            o();
            this.f5834c = true;
            this.f5837f = exc;
        }
        this.f5833b.c(this);
    }

    public final void n() {
        synchronized (this.f5832a) {
            try {
                if (this.f5834c) {
                    return;
                }
                this.f5834c = true;
                this.f5835d = true;
                this.f5833b.c(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o() {
        String str;
        if (this.f5834c) {
            int i4 = d3.m.f3534f;
            if (e()) {
                Exception c4 = c();
                if (c4 == null) {
                    if (!f()) {
                        if (this.f5835d) {
                            str = "cancellation";
                        } else {
                            str = "unknown issue";
                        }
                    } else {
                        str = "result ".concat(String.valueOf(d()));
                    }
                } else {
                    str = "failure";
                }
                throw new IllegalStateException("Complete with: ".concat(str), c4);
            }
            throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
    }

    public final void p() {
        synchronized (this.f5832a) {
            try {
                if (!this.f5834c) {
                    return;
                }
                this.f5833b.c(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

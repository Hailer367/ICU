package p1;

import java.util.concurrent.Executor;

/* renamed from: p1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0583l implements InterfaceC0584m, InterfaceC0576e, InterfaceC0575d, InterfaceC0573b {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5828f;

    /* renamed from: g, reason: collision with root package name */
    public final Executor f5829g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f5830h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f5831i;

    public C0583l(Executor executor, InterfaceC0573b interfaceC0573b) {
        this.f5828f = 0;
        this.f5830h = new Object();
        this.f5829g = executor;
        this.f5831i = interfaceC0573b;
    }

    @Override // p1.InterfaceC0584m
    public final void a(AbstractC0579h abstractC0579h) {
        switch (this.f5828f) {
            case 0:
                if (((C0585n) abstractC0579h).f5835d) {
                    synchronized (this.f5830h) {
                        try {
                            if (((InterfaceC0573b) this.f5831i) != null) {
                                this.f5829g.execute(new F.b(18, this));
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            case 1:
                synchronized (this.f5830h) {
                }
                this.f5829g.execute(new F.a(9, this, abstractC0579h, false));
                return;
            case 2:
                if (!abstractC0579h.f() && !((C0585n) abstractC0579h).f5835d) {
                    synchronized (this.f5830h) {
                        try {
                            if (((InterfaceC0575d) this.f5831i) != null) {
                                this.f5829g.execute(new F.a(10, this, abstractC0579h, false));
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            case 3:
                if (abstractC0579h.f()) {
                    synchronized (this.f5830h) {
                        try {
                            if (((InterfaceC0576e) this.f5831i) != null) {
                                this.f5829g.execute(new F.a(11, this, abstractC0579h, false));
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            default:
                this.f5829g.execute(new F.a(12, this, abstractC0579h, false));
                return;
        }
    }

    @Override // p1.InterfaceC0573b
    public void b() {
        ((C0585n) this.f5831i).n();
    }

    @Override // p1.InterfaceC0575d
    public void c(Exception exc) {
        ((C0585n) this.f5831i).m(exc);
    }

    @Override // p1.InterfaceC0576e
    public void e(Object obj) {
        ((C0585n) this.f5831i).l(obj);
    }

    public C0583l(Executor executor, InterfaceC0574c interfaceC0574c) {
        this.f5828f = 1;
        this.f5830h = new Object();
        this.f5829g = executor;
        this.f5831i = interfaceC0574c;
    }

    public C0583l(Executor executor, InterfaceC0575d interfaceC0575d) {
        this.f5828f = 2;
        this.f5830h = new Object();
        this.f5829g = executor;
        this.f5831i = interfaceC0575d;
    }

    public C0583l(Executor executor, InterfaceC0576e interfaceC0576e) {
        this.f5828f = 3;
        this.f5830h = new Object();
        this.f5829g = executor;
        this.f5831i = interfaceC0576e;
    }

    public C0583l(Executor executor, InterfaceC0578g interfaceC0578g, C0585n c0585n) {
        this.f5828f = 4;
        this.f5829g = executor;
        this.f5830h = interfaceC0578g;
        this.f5831i = c0585n;
    }
}

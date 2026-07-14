package p1;

import java.util.concurrent.Executor;

/* renamed from: p1.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0582k implements InterfaceC0584m, InterfaceC0576e, InterfaceC0575d, InterfaceC0573b {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5824f;

    /* renamed from: g, reason: collision with root package name */
    public final Executor f5825g;

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceC0572a f5826h;

    /* renamed from: i, reason: collision with root package name */
    public final C0585n f5827i;

    public /* synthetic */ C0582k(Executor executor, InterfaceC0572a interfaceC0572a, C0585n c0585n, int i4) {
        this.f5824f = i4;
        this.f5825g = executor;
        this.f5826h = interfaceC0572a;
        this.f5827i = c0585n;
    }

    @Override // p1.InterfaceC0584m
    public final void a(AbstractC0579h abstractC0579h) {
        switch (this.f5824f) {
            case 0:
                this.f5825g.execute(new F.a(7, this, abstractC0579h, false));
                return;
            default:
                this.f5825g.execute(new F.a(8, this, abstractC0579h, false));
                return;
        }
    }

    @Override // p1.InterfaceC0573b
    public void b() {
        this.f5827i.n();
    }

    @Override // p1.InterfaceC0575d
    public void c(Exception exc) {
        this.f5827i.m(exc);
    }

    @Override // p1.InterfaceC0576e
    public void e(Object obj) {
        this.f5827i.l(obj);
    }
}

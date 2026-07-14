package A0;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class d implements x0.b {

    /* renamed from: c, reason: collision with root package name */
    public final P0.a f21c;

    /* renamed from: d, reason: collision with root package name */
    public final P0.a f22d;

    /* renamed from: e, reason: collision with root package name */
    public final g f23e;

    /* renamed from: f, reason: collision with root package name */
    public final P0.a f24f;

    /* renamed from: g, reason: collision with root package name */
    public final P0.a f25g;

    public d(P0.a aVar, P0.a aVar2, g gVar, P0.a aVar3, P0.a aVar4) {
        this.f21c = aVar;
        this.f22d = aVar2;
        this.f23e = gVar;
        this.f24f = aVar3;
        this.f25g = aVar4;
    }

    @Override // P0.a
    public final Object get() {
        return new c((Executor) this.f21c.get(), (w0.e) this.f22d.get(), (B0.d) this.f23e.get(), (C0.d) this.f24f.get(), (D0.c) this.f25g.get());
    }
}

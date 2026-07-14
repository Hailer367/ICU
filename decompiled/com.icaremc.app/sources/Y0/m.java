package Y0;

import Z0.InterfaceC0136b;
import Z0.InterfaceC0139e;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class m implements InterfaceC0136b {

    /* renamed from: f, reason: collision with root package name */
    public final X0.c f2060f;

    /* renamed from: g, reason: collision with root package name */
    public final a f2061g;

    /* renamed from: h, reason: collision with root package name */
    public InterfaceC0139e f2062h;

    /* renamed from: i, reason: collision with root package name */
    public Set f2063i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2064j;
    public final /* synthetic */ d k;

    public m(d dVar, X0.c cVar, a aVar) {
        Objects.requireNonNull(dVar);
        this.k = dVar;
        this.f2062h = null;
        this.f2063i = null;
        this.f2064j = false;
        this.f2060f = cVar;
        this.f2061g = aVar;
    }

    public final void a(W0.a aVar) {
        k kVar = (k) this.k.f2039j.get(this.f2061g);
        if (kVar != null) {
            kVar.m(aVar);
        }
    }

    @Override // Z0.InterfaceC0136b
    public final void b(W0.a aVar) {
        this.k.f2041m.post(new F.a(4, this, aVar, false));
    }
}

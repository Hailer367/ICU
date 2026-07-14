package d;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final W.e f2140a;

    /* renamed from: b, reason: collision with root package name */
    public final R0.r f2141b;

    /* renamed from: c, reason: collision with root package name */
    public final R0.r f2142c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2143d;

    /* renamed from: e, reason: collision with root package name */
    public W.c f2144e;

    /* renamed from: f, reason: collision with root package name */
    public final p f2145f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2146g;

    public o(p pVar, W.e eVar) {
        boolean isEnabled = pVar.isEnabled();
        this.f2140a = eVar;
        R0.r rVar = R0.r.f750c;
        this.f2141b = rVar;
        this.f2142c = rVar;
        this.f2143d = isEnabled;
        this.f2145f = pVar;
        this.f2146g = true;
    }

    public final void a() {
        W.c cVar = this.f2144e;
        if (cVar != null && cVar.f796c.remove(this)) {
            W.g gVar = cVar.f795b;
            gVar.getClass();
            if (equals(gVar.f807f)) {
                if (gVar.f808g == -1) {
                    this.f2145f.handleOnBackCancelled();
                }
                gVar.f807f = null;
                gVar.f808g = 0;
                gVar.f809h = null;
            }
            gVar.f805d.remove(this);
            gVar.f806e.remove(this);
            this.f2144e = null;
            gVar.b();
        }
    }

    public final void b(boolean z) {
        boolean z2;
        W.g gVar;
        this.f2146g = z;
        if (z && this.f2145f.isEnabled()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f2143d != z2) {
            this.f2143d = z2;
            W.c cVar = this.f2144e;
            if (cVar != null && (gVar = cVar.f795b) != null) {
                gVar.b();
            }
        }
    }
}

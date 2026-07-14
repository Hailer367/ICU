package l1;

/* loaded from: classes.dex */
public final class V extends T {

    /* renamed from: e, reason: collision with root package name */
    public final X f2968e;

    /* renamed from: f, reason: collision with root package name */
    public final W f2969f;

    /* renamed from: g, reason: collision with root package name */
    public final C0234l f2970g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f2971h;

    public V(X x2, W w2, C0234l c0234l, Object obj) {
        this.f2968e = x2;
        this.f2969f = w2;
        this.f2970g = c0234l;
        this.f2971h = obj;
    }

    @Override // l1.T
    public final boolean j() {
        return false;
    }

    @Override // l1.T
    public final void k(Throwable th) {
        C0234l c0234l = this.f2970g;
        C0234l G2 = X.G(c0234l);
        X x2 = this.f2968e;
        W w2 = this.f2969f;
        Object obj = this.f2971h;
        if (G2 == null || !x2.P(w2, G2, obj)) {
            w2.f2975a.d(new q1.h(2), 2);
            C0234l G3 = X.G(c0234l);
            if (G3 != null && x2.P(w2, G3, obj)) {
                return;
            }
            x2.l(x2.u(w2, obj));
        }
    }
}

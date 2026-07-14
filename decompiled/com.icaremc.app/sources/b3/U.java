package b3;

/* loaded from: classes.dex */
public final class U extends S {

    /* renamed from: e, reason: collision with root package name */
    public final W f3254e;

    /* renamed from: f, reason: collision with root package name */
    public final V f3255f;

    /* renamed from: g, reason: collision with root package name */
    public final C0236k f3256g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f3257h;

    public U(W w2, V v3, C0236k c0236k, Object obj) {
        this.f3254e = w2;
        this.f3255f = v3;
        this.f3256g = c0236k;
        this.f3257h = obj;
    }

    @Override // b3.S
    public final boolean j() {
        return false;
    }

    @Override // b3.S
    public final void k(Throwable th) {
        C0236k c0236k = this.f3256g;
        C0236k H3 = W.H(c0236k);
        W w2 = this.f3254e;
        V v3 = this.f3255f;
        Object obj = this.f3257h;
        if (H3 == null || !w2.Q(v3, H3, obj)) {
            v3.f3261a.d(new g3.h(2), 2);
            C0236k H4 = W.H(c0236k);
            if (H4 != null && w2.Q(v3, H4, obj)) {
                return;
            }
            w2.m(w2.v(v3, obj));
        }
    }
}

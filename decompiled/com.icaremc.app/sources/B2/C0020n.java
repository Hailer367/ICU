package B2;

/* renamed from: B2.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0020n implements e3.d {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f209f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e3.d f210g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ S.d f211h;

    public /* synthetic */ C0020n(e3.d dVar, S.d dVar2, int i4) {
        this.f209f = i4;
        this.f210g = dVar;
        this.f211h = dVar2;
    }

    @Override // e3.d
    public final Object u(e3.e eVar, K2.d dVar) {
        switch (this.f209f) {
            case 0:
                Object u3 = this.f210g.u(new C0019m(eVar, this.f211h, 0), dVar);
                if (u3 != L2.a.f1019f) {
                    return H2.i.f681a;
                }
                return u3;
            case 1:
                Object u4 = this.f210g.u(new C0019m(eVar, this.f211h, 1), dVar);
                if (u4 != L2.a.f1019f) {
                    return H2.i.f681a;
                }
                return u4;
            case 2:
                Object u5 = this.f210g.u(new C0019m(eVar, this.f211h, 2), dVar);
                if (u5 != L2.a.f1019f) {
                    return H2.i.f681a;
                }
                return u5;
            default:
                Object u6 = this.f210g.u(new C0019m(eVar, this.f211h, 3), dVar);
                if (u6 != L2.a.f1019f) {
                    return H2.i.f681a;
                }
                return u6;
        }
    }
}

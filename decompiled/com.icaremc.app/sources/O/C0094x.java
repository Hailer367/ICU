package O;

/* renamed from: O.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0094x implements e3.e {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1257f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1258g;

    public /* synthetic */ C0094x(int i4, Object obj) {
        this.f1257f = i4;
        this.f1258g = obj;
    }

    @Override // e3.e
    public final Object g(Object obj, K2.d dVar) {
        Object e4;
        switch (this.f1257f) {
            case 0:
                N n3 = (N) this.f1258g;
                if ((n3.f1126m.k() instanceof Z) || (e4 = N.e(n3, true, dVar)) != L2.a.f1019f) {
                    return H2.i.f681a;
                }
                return e4;
            case 1:
                ((T2.p) this.f1258g).f1645f = obj;
                throw new f3.a(this);
            default:
                ((H.a) this.f1258g).accept(obj);
                return H2.i.f681a;
        }
    }
}

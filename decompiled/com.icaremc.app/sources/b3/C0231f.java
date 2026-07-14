package b3;

/* renamed from: b3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0231f implements S2.q {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3271f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3272g;

    public /* synthetic */ C0231f(int i4, Object obj) {
        this.f3271f = i4;
        this.f3272g = obj;
    }

    @Override // S2.q
    public final Object c(Object obj, Object obj2, Object obj3) {
        switch (this.f3271f) {
            case 0:
                ((D2.M) this.f3272g).f((Throwable) obj);
                break;
            case 1:
                j3.c cVar = (j3.c) this.f3272g;
                j3.c.f5089g.set(cVar, null);
                cVar.e(null);
                break;
            default:
                ((j3.g) this.f3272g).b();
                break;
        }
        return H2.i.f681a;
    }

    public /* synthetic */ C0231f(j3.c cVar, j3.b bVar) {
        this.f3271f = 1;
        this.f3272g = cVar;
    }
}

package l1;

/* renamed from: l1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0229g implements c1.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2987c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2988d;

    public /* synthetic */ C0229g(int i2, Object obj) {
        this.f2987c = i2;
        this.f2988d = obj;
    }

    @Override // c1.q
    public final Object a(Object obj, Object obj2, Object obj3) {
        switch (this.f2987c) {
            case 0:
                ((R0.a) this.f2988d).invoke((Throwable) obj);
                break;
            case 1:
                t1.c cVar = (t1.c) this.f2988d;
                t1.c.f3656g.set(cVar, null);
                cVar.e(null);
                break;
            default:
                ((t1.g) this.f2988d).b();
                break;
        }
        return Q0.j.f722a;
    }

    public /* synthetic */ C0229g(t1.c cVar, t1.b bVar) {
        this.f2987c = 1;
        this.f2988d = cVar;
    }
}

package f3;

/* loaded from: classes.dex */
public final class d extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f3716j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ e f3717l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, K2.d dVar) {
        super(2, dVar);
        this.f3717l = eVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((d) i((K2.d) obj2, (d3.r) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        d dVar2 = new d(this.f3717l, dVar);
        dVar2.k = obj;
        return dVar2;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f3716j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            d3.r rVar = (d3.r) this.k;
            this.f3716j = 1;
            Object a4 = this.f3717l.a(rVar, this);
            L2.a aVar = L2.a.f1019f;
            if (a4 == aVar) {
                return aVar;
            }
        }
        return H2.i.f681a;
    }
}

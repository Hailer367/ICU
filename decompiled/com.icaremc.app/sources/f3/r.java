package f3;

/* loaded from: classes.dex */
public final class r extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f3738j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ e3.e f3739l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(e3.e eVar, K2.d dVar) {
        super(2, dVar);
        this.f3739l = eVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((r) i((K2.d) obj2, obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        r rVar = new r(this.f3739l, dVar);
        rVar.k = obj;
        return rVar;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f3738j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            Object obj2 = this.k;
            this.f3738j = 1;
            Object g4 = this.f3739l.g(obj2, this);
            L2.a aVar = L2.a.f1019f;
            if (g4 == aVar) {
                return aVar;
            }
        }
        return H2.i.f681a;
    }
}

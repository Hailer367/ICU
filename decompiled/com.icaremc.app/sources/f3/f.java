package f3;

/* loaded from: classes.dex */
public final class f extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f3721j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ g f3722l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, K2.d dVar) {
        super(2, dVar);
        this.f3722l = gVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((f) i((K2.d) obj2, (e3.e) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        f fVar = new f(this.f3722l, dVar);
        fVar.k = obj;
        return fVar;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f3721j;
        H2.i iVar = H2.i.f681a;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            e3.e eVar = (e3.e) this.k;
            this.f3721j = 1;
            Object u3 = this.f3722l.f3723i.u(eVar, this);
            L2.a aVar = L2.a.f1019f;
            if (u3 != aVar) {
                u3 = iVar;
            }
            if (u3 == aVar) {
                return aVar;
            }
        }
        return iVar;
    }
}

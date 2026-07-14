package O;

/* loaded from: classes.dex */
public final class K extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f1109j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ N f1110l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(N n3, K2.d dVar) {
        super(2, dVar);
        this.f1110l = n3;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((K) i((K2.d) obj2, (a0) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        K k = new K(this.f1110l, dVar);
        k.k = obj;
        return k;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f1109j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            a0 a0Var = (a0) this.k;
            this.f1109j = 1;
            Object c4 = N.c(this.f1110l, a0Var, this);
            L2.a aVar = L2.a.f1019f;
            if (c4 == aVar) {
                return aVar;
            }
        }
        return H2.i.f681a;
    }
}

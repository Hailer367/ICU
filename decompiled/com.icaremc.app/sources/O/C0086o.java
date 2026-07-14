package O;

/* renamed from: O.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0086o extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f1234j;
    public final /* synthetic */ N k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0086o(N n3, K2.d dVar) {
        super(2, dVar);
        this.k = n3;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C0086o) i((K2.d) obj2, (e3.e) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new C0086o(this.k, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f1234j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            this.f1234j = 1;
            Object d4 = N.d(this.k, this);
            L2.a aVar = L2.a.f1019f;
            if (d4 == aVar) {
                return aVar;
            }
        }
        return H2.i.f681a;
    }
}

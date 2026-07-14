package B2;

/* loaded from: classes.dex */
public final class E extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f156j;
    public final /* synthetic */ S.d k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ double f157l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(S.d dVar, double d4, K2.d dVar2) {
        super(2, dVar2);
        this.k = dVar;
        this.f157l = d4;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        E e4 = (E) i((K2.d) obj2, (S.b) obj);
        H2.i iVar = H2.i.f681a;
        e4.k(iVar);
        return iVar;
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        E e4 = new E(this.k, this.f157l, dVar);
        e4.f156j = obj;
        return e4;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        S.b bVar = (S.b) this.f156j;
        k3.b.A(obj);
        bVar.e(this.k, new Double(this.f157l));
        return H2.i.f681a;
    }
}

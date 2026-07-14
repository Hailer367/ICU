package B2;

/* loaded from: classes.dex */
public final class B extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f148j;
    public final /* synthetic */ S.d k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f149l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(S.d dVar, boolean z, K2.d dVar2) {
        super(2, dVar2);
        this.k = dVar;
        this.f149l = z;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        B b4 = (B) i((K2.d) obj2, (S.b) obj);
        H2.i iVar = H2.i.f681a;
        b4.k(iVar);
        return iVar;
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        B b4 = new B(this.k, this.f149l, dVar);
        b4.f148j = obj;
        return b4;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        S.b bVar = (S.b) this.f148j;
        k3.b.A(obj);
        bVar.e(this.k, Boolean.valueOf(this.f149l));
        return H2.i.f681a;
    }
}

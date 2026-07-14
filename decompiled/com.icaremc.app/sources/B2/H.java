package B2;

/* loaded from: classes.dex */
public final class H extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f164j;
    public final /* synthetic */ S.d k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f165l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(S.d dVar, long j4, K2.d dVar2) {
        super(2, dVar2);
        this.k = dVar;
        this.f165l = j4;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        H h3 = (H) i((K2.d) obj2, (S.b) obj);
        H2.i iVar = H2.i.f681a;
        h3.k(iVar);
        return iVar;
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        H h3 = new H(this.k, this.f165l, dVar);
        h3.f164j = obj;
        return h3;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        S.b bVar = (S.b) this.f164j;
        k3.b.A(obj);
        bVar.e(this.k, new Long(this.f165l));
        return H2.i.f681a;
    }
}

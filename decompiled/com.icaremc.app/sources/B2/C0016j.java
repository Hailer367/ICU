package B2;

/* renamed from: B2.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0016j extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f200j;
    public final /* synthetic */ S.d k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f201l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0016j(S.d dVar, String str, K2.d dVar2) {
        super(2, dVar2);
        this.k = dVar;
        this.f201l = str;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        C0016j c0016j = (C0016j) i((K2.d) obj2, (S.b) obj);
        H2.i iVar = H2.i.f681a;
        c0016j.k(iVar);
        return iVar;
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        C0016j c0016j = new C0016j(this.k, this.f201l, dVar);
        c0016j.f200j = obj;
        return c0016j;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        S.b bVar = (S.b) this.f200j;
        k3.b.A(obj);
        bVar.e(this.k, this.f201l);
        return H2.i.f681a;
    }
}

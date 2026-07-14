package O;

/* renamed from: O.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0087p extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f1235j;

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C0087p) i((K2.d) obj2, (j0) obj)).k(H2.i.f681a);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [O.p, M2.h, K2.d] */
    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        ?? hVar = new M2.h(2, dVar);
        hVar.f1235j = obj;
        return hVar;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        k3.b.A(obj);
        return Boolean.valueOf(!(((j0) this.f1235j) instanceof Z));
    }
}

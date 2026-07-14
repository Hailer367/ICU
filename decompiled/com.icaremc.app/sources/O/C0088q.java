package O;

/* renamed from: O.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0088q extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f1236j;
    public final /* synthetic */ j0 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0088q(j0 j0Var, K2.d dVar) {
        super(2, dVar);
        this.k = j0Var;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C0088q) i((K2.d) obj2, (j0) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        C0088q c0088q = new C0088q(this.k, dVar);
        c0088q.f1236j = obj;
        return c0088q;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        boolean z;
        k3.b.A(obj);
        j0 j0Var = (j0) this.f1236j;
        if ((j0Var instanceof C0075d) && j0Var.f1207a <= this.k.f1207a) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}

package O;

import b3.InterfaceC0243s;

/* loaded from: classes.dex */
public final class H extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f1103j;
    public final /* synthetic */ M2.h k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0075d f1104l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public H(S2.p pVar, C0075d c0075d, K2.d dVar) {
        super(2, dVar);
        this.k = (M2.h) pVar;
        this.f1104l = c0075d;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((H) i((K2.d) obj2, (InterfaceC0243s) obj)).k(H2.i.f681a);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [S2.p, M2.h] */
    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new H(this.k, this.f1104l, dVar);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [S2.p, M2.h] */
    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f1103j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        k3.b.A(obj);
        Object obj2 = this.f1104l.f1174b;
        this.f1103j = 1;
        Object e4 = this.k.e(obj2, this);
        L2.a aVar = L2.a.f1019f;
        if (e4 == aVar) {
            return aVar;
        }
        return e4;
    }
}

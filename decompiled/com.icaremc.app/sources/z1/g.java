package z1;

import H2.i;
import O.InterfaceC0080i;
import S2.p;
import a.AbstractC0141a;
import b3.InterfaceC0243s;

/* loaded from: classes.dex */
public final class g extends M2.h implements p {

    /* renamed from: j, reason: collision with root package name */
    public int f6644j;
    public final /* synthetic */ h k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ S.d f6645l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Long f6646m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, S.d dVar, Long l3, K2.d dVar2) {
        super(2, dVar2);
        this.k = hVar;
        this.f6645l = dVar;
        this.f6646m = l3;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((g) i((K2.d) obj2, (InterfaceC0243s) obj)).k(i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new g(this.k, this.f6645l, this.f6646m, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f6644j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        k3.b.A(obj);
        InterfaceC0080i interfaceC0080i = this.k.f6650c;
        C0753f c0753f = new C0753f(this.f6645l, this.f6646m, null);
        this.f6644j = 1;
        Object p3 = AbstractC0141a.p(interfaceC0080i, c0753f, this);
        L2.a aVar = L2.a.f1019f;
        if (p3 == aVar) {
            return aVar;
        }
        return p3;
    }
}

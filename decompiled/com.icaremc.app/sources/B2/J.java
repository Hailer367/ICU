package B2;

import b3.InterfaceC0243s;

/* loaded from: classes.dex */
public final class J extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f169j;
    public final /* synthetic */ K k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f170l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f171m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(K k, String str, String str2, K2.d dVar) {
        super(2, dVar);
        this.k = k;
        this.f170l = str;
        this.f171m = str2;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((J) i((K2.d) obj2, (InterfaceC0243s) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new J(this.k, this.f170l, this.f171m, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f169j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            this.f169j = 1;
            Object g4 = K.g(this.k, this.f170l, this.f171m, this);
            L2.a aVar = L2.a.f1019f;
            if (g4 == aVar) {
                return aVar;
            }
        }
        return H2.i.f681a;
    }
}

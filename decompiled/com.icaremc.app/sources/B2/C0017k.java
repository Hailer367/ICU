package B2;

import b3.InterfaceC0243s;
import java.util.List;

/* renamed from: B2.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0017k extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f202j;
    public final /* synthetic */ K k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ List f203l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0017k(K k, List list, K2.d dVar) {
        super(2, dVar);
        this.k = k;
        this.f203l = list;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C0017k) i((K2.d) obj2, (InterfaceC0243s) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new C0017k(this.k, this.f203l, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f202j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        k3.b.A(obj);
        this.f202j = 1;
        Object h3 = K.h(this.k, this.f203l, this);
        L2.a aVar = L2.a.f1019f;
        if (h3 == aVar) {
            return aVar;
        }
        return h3;
    }
}

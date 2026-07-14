package O;

import a.AbstractC0141a;
import java.util.List;

/* renamed from: O.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0076e extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f1178j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ List f1179l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0076e(List list, K2.d dVar) {
        super(2, dVar);
        this.f1179l = list;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C0076e) i((K2.d) obj2, (C0083l) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        C0076e c0076e = new C0076e(this.f1179l, dVar);
        c0076e.k = obj;
        return c0076e;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f1178j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            C0083l c0083l = (C0083l) this.k;
            this.f1178j = 1;
            Object a4 = AbstractC0141a.a(this.f1179l, c0083l, this);
            L2.a aVar = L2.a.f1019f;
            if (a4 == aVar) {
                return aVar;
            }
        }
        return H2.i.f681a;
    }
}

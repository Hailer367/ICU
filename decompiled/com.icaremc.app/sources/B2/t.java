package B2;

import O.InterfaceC0080i;
import android.content.Context;
import b3.InterfaceC0243s;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class t extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public T2.p f228j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f229l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ K f230m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ T2.p f231n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(String str, K k, T2.p pVar, K2.d dVar) {
        super(2, dVar);
        this.f229l = str;
        this.f230m = k;
        this.f231n = pVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((t) i((K2.d) obj2, (InterfaceC0243s) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new t(this.f229l, this.f230m, this.f231n, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        T2.p pVar;
        int i4 = this.k;
        if (i4 != 0) {
            if (i4 == 1) {
                pVar = this.f228j;
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            S.d K3 = AbstractC0602b.K(this.f229l);
            Context context = this.f230m.f172f;
            if (context != null) {
                C0020n c0020n = new C0020n(((InterfaceC0080i) ((R1.c) L.a(context)).f1532g).getData(), K3, 1);
                pVar = this.f231n;
                this.f228j = pVar;
                this.k = 1;
                obj = e3.s.c(c0020n, this);
                L2.a aVar = L2.a.f1019f;
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                T2.h.g("context");
                throw null;
            }
        }
        pVar.f1645f = obj;
        return H2.i.f681a;
    }
}

package B2;

import O.InterfaceC0080i;
import android.content.Context;
import b3.InterfaceC0243s;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class r extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public T2.p f222j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f223l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ K f224m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ T2.p f225n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(String str, K k, T2.p pVar, K2.d dVar) {
        super(2, dVar);
        this.f223l = str;
        this.f224m = k;
        this.f225n = pVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((r) i((K2.d) obj2, (InterfaceC0243s) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new r(this.f223l, this.f224m, this.f225n, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        T2.p pVar;
        int i4 = this.k;
        if (i4 != 0) {
            if (i4 == 1) {
                pVar = this.f222j;
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            S.d U3 = AbstractC0602b.U(this.f223l);
            K k = this.f224m;
            Context context = k.f172f;
            if (context != null) {
                A2.t tVar = new A2.t(((InterfaceC0080i) ((R1.c) L.a(context)).f1532g).getData(), U3, k, 2);
                pVar = this.f225n;
                this.f222j = pVar;
                this.k = 1;
                obj = e3.s.c(tVar, this);
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

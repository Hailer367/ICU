package B2;

import O.InterfaceC0080i;
import a.AbstractC0141a;
import android.content.Context;
import b3.InterfaceC0243s;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class I extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f166j;
    public final /* synthetic */ String k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ K f167l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f168m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(String str, K k, long j4, K2.d dVar) {
        super(2, dVar);
        this.k = str;
        this.f167l = k;
        this.f168m = j4;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((I) i((K2.d) obj2, (InterfaceC0243s) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new I(this.k, this.f167l, this.f168m, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f166j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            S.d K3 = AbstractC0602b.K(this.k);
            Context context = this.f167l.f172f;
            if (context != null) {
                InterfaceC0080i a4 = L.a(context);
                H h3 = new H(K3, this.f168m, null);
                this.f166j = 1;
                Object p3 = AbstractC0141a.p(a4, h3, this);
                L2.a aVar = L2.a.f1019f;
                if (p3 == aVar) {
                    return aVar;
                }
            } else {
                T2.h.g("context");
                throw null;
            }
        }
        return H2.i.f681a;
    }
}

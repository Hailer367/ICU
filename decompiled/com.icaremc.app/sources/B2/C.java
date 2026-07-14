package B2;

import O.InterfaceC0080i;
import a.AbstractC0141a;
import android.content.Context;
import b3.InterfaceC0243s;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class C extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f150j;
    public final /* synthetic */ String k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ K f151l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f152m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(String str, K k, boolean z, K2.d dVar) {
        super(2, dVar);
        this.k = str;
        this.f151l = k;
        this.f152m = z;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C) i((K2.d) obj2, (InterfaceC0243s) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new C(this.k, this.f151l, this.f152m, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f150j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            S.d e4 = AbstractC0602b.e(this.k);
            Context context = this.f151l.f172f;
            if (context != null) {
                InterfaceC0080i a4 = L.a(context);
                B b4 = new B(e4, this.f152m, null);
                this.f150j = 1;
                Object p3 = AbstractC0141a.p(a4, b4, this);
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

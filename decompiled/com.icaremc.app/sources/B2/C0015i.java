package B2;

import O.InterfaceC0080i;
import a.AbstractC0141a;
import android.content.Context;
import b3.InterfaceC0243s;
import java.util.List;

/* renamed from: B2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0015i extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f198j;
    public final /* synthetic */ K k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ List f199l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0015i(K k, List list, K2.d dVar) {
        super(2, dVar);
        this.k = k;
        this.f199l = list;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C0015i) i((K2.d) obj2, (InterfaceC0243s) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new C0015i(this.k, this.f199l, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f198j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        k3.b.A(obj);
        Context context = this.k.f172f;
        if (context != null) {
            InterfaceC0080i a4 = L.a(context);
            C0014h c0014h = new C0014h(this.f199l, null);
            this.f198j = 1;
            Object p3 = AbstractC0141a.p(a4, c0014h, this);
            L2.a aVar = L2.a.f1019f;
            if (p3 == aVar) {
                return aVar;
            }
            return p3;
        }
        T2.h.g("context");
        throw null;
    }
}

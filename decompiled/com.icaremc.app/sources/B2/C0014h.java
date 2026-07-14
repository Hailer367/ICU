package B2;

import java.util.Iterator;
import java.util.List;
import q1.AbstractC0602b;

/* renamed from: B2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0014h extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f197j;
    public final /* synthetic */ List k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0014h(List list, K2.d dVar) {
        super(2, dVar);
        this.k = list;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        C0014h c0014h = (C0014h) i((K2.d) obj2, (S.b) obj);
        H2.i iVar = H2.i.f681a;
        c0014h.k(iVar);
        return iVar;
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        C0014h c0014h = new C0014h(this.k, dVar);
        c0014h.f197j = obj;
        return c0014h;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        S.b bVar = (S.b) this.f197j;
        k3.b.A(obj);
        List list = this.k;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bVar.d(AbstractC0602b.e((String) it.next()));
            }
        } else {
            bVar.b();
            bVar.f1534a.clear();
        }
        return H2.i.f681a;
    }
}

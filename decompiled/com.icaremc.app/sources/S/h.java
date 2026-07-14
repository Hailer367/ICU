package S;

import H2.i;
import S2.p;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class h extends M2.h implements p {

    /* renamed from: j, reason: collision with root package name */
    public int f1541j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ M2.h f1542l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h(p pVar, K2.d dVar) {
        super(2, dVar);
        this.f1542l = (M2.h) pVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((h) i((K2.d) obj2, (b) obj)).k(i.f681a);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [S2.p, M2.h] */
    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        h hVar = new h(this.f1542l, dVar);
        hVar.k = obj;
        return hVar;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [S2.p, M2.h] */
    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f1541j;
        if (i4 != 0) {
            if (i4 == 1) {
                b bVar = (b) this.k;
                k3.b.A(obj);
                return bVar;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        k3.b.A(obj);
        b bVar2 = new b(new LinkedHashMap(((b) this.k).a()), false);
        this.k = bVar2;
        this.f1541j = 1;
        Object e4 = this.f1542l.e(bVar2, this);
        L2.a aVar = L2.a.f1019f;
        if (e4 == aVar) {
            return aVar;
        }
        return bVar2;
    }
}

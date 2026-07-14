package S;

import H2.i;
import S2.p;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class c extends M2.h implements p {

    /* renamed from: j, reason: collision with root package name */
    public int f1536j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ M2.h f1537l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(p pVar, K2.d dVar) {
        super(2, dVar);
        this.f1537l = (M2.h) pVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((c) i((K2.d) obj2, (b) obj)).k(i.f681a);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [S2.p, M2.h] */
    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        c cVar = new c(this.f1537l, dVar);
        cVar.k = obj;
        return cVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [S2.p, M2.h] */
    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f1536j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            b bVar = (b) this.k;
            this.f1536j = 1;
            obj = this.f1537l.e(bVar, this);
            L2.a aVar = L2.a.f1019f;
            if (obj == aVar) {
                return aVar;
            }
        }
        b bVar2 = (b) obj;
        T2.h.c(bVar2, "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
        ((AtomicBoolean) bVar2.f1535b.f93g).set(true);
        return bVar2;
    }
}

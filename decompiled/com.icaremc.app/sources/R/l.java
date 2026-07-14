package R;

import S2.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class l extends M2.h implements p {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f1524j;
    public final /* synthetic */ Set k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Set set, K2.d dVar) {
        super(2, dVar);
        this.k = set;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((l) i((K2.d) obj2, (S.b) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        l lVar = new l(this.k, dVar);
        lVar.f1524j = obj;
        return lVar;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        k3.b.A(obj);
        Set keySet = ((S.b) this.f1524j).a().keySet();
        ArrayList arrayList = new ArrayList(I2.g.D(keySet));
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((S.d) it.next()).f1538a);
        }
        LinkedHashSet linkedHashSet = m.f1525a;
        boolean z = true;
        Set set = this.k;
        if (set != linkedHashSet) {
            if (set == null || !set.isEmpty()) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    if (!arrayList.contains((String) it2.next())) {
                        break;
                    }
                }
            }
            z = false;
        }
        return Boolean.valueOf(z);
    }
}

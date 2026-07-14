package N;

import a.AbstractC0051a;
import c1.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class l extends V0.h implements p {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f623c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Set f624d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Set set, T0.d dVar) {
        super(2, dVar);
        this.f624d = set;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        l lVar = new l(this.f624d, dVar);
        lVar.f623c = obj;
        return lVar;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((l) create((O.g) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        AbstractC0051a.V(obj);
        Set keySet = ((O.g) this.f623c).a().keySet();
        ArrayList arrayList = new ArrayList(R0.l.O(keySet));
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((O.e) it.next()).f632a);
        }
        LinkedHashSet linkedHashSet = m.f625a;
        boolean z = true;
        Set set = this.f624d;
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

package N;

import R0.u;
import a.AbstractC0051a;
import c1.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class k extends V0.h implements q {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ M.f f621c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ O.g f622d;

    /* JADX WARN: Type inference failed for: r0v0, types: [V0.h, N.k] */
    @Override // c1.q
    public final Object a(Object obj, Object obj2, Object obj3) {
        ?? hVar = new V0.h(3, (T0.d) obj3);
        hVar.f621c = (M.f) obj;
        hVar.f622d = (O.g) obj2;
        return hVar.invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        AbstractC0051a.V(obj);
        M.f fVar = this.f621c;
        O.g gVar = this.f622d;
        Set keySet = gVar.a().keySet();
        ArrayList arrayList = new ArrayList(R0.l.O(keySet));
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((O.e) it.next()).f632a);
        }
        Map<String, ?> all = fVar.f610a.getAll();
        kotlin.jvm.internal.h.d(all, "prefs.all");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it2.next();
            String key = next.getKey();
            Set set = fVar.f611b;
            if (set != null) {
                z = set.contains(key);
            }
            if (z) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(u.X(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key2 = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Set) {
                value = R0.j.W((Iterable) value);
            }
            linkedHashMap2.put(key2, value);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            if (!arrayList.contains((String) entry2.getKey())) {
                linkedHashMap3.put(entry2.getKey(), entry2.getValue());
            }
        }
        O.c cVar = new O.c(new LinkedHashMap(gVar.a()), false);
        for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
            String name = (String) entry3.getKey();
            Object value2 = entry3.getValue();
            if (value2 instanceof Boolean) {
                cVar.f(AbstractC0051a.b(name), value2);
            } else if (value2 instanceof Float) {
                kotlin.jvm.internal.h.e(name, "name");
                cVar.f(new O.e(name), value2);
            } else if (value2 instanceof Integer) {
                kotlin.jvm.internal.h.e(name, "name");
                cVar.f(new O.e(name), value2);
            } else if (value2 instanceof Long) {
                cVar.f(AbstractC0051a.F(name), value2);
            } else if (value2 instanceof String) {
                cVar.f(AbstractC0051a.T(name), value2);
            } else if (value2 instanceof Set) {
                O.e U2 = AbstractC0051a.U(name);
                kotlin.jvm.internal.h.c(value2, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                cVar.f(U2, (Set) value2);
            }
        }
        return new O.c(new LinkedHashMap(cVar.a()), true);
    }
}

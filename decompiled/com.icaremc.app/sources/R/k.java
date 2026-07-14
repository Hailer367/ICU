package R;

import I2.p;
import S2.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class k extends M2.h implements q {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Q.f f1523j;
    public /* synthetic */ S.b k;

    /* JADX WARN: Type inference failed for: r0v0, types: [M2.h, R.k] */
    @Override // S2.q
    public final Object c(Object obj, Object obj2, Object obj3) {
        ?? hVar = new M2.h(3, (K2.d) obj3);
        hVar.f1523j = (Q.f) obj;
        hVar.k = (S.b) obj2;
        return hVar.k(H2.i.f681a);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        k3.b.A(obj);
        Q.f fVar = this.f1523j;
        S.b bVar = this.k;
        Set keySet = bVar.a().keySet();
        ArrayList arrayList = new ArrayList(I2.g.D(keySet));
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((S.d) it.next()).f1538a);
        }
        Map<String, ?> all = fVar.f1491a.getAll();
        T2.h.d(all, "prefs.all");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it2.next();
            String key = next.getKey();
            Set set = fVar.f1492b;
            if (set != null) {
                z = set.contains(key);
            }
            if (z) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(p.Q(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key2 = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Set) {
                value = I2.e.K((Iterable) value);
            }
            linkedHashMap2.put(key2, value);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            if (!arrayList.contains((String) entry2.getKey())) {
                linkedHashMap3.put(entry2.getKey(), entry2.getValue());
            }
        }
        S.b bVar2 = new S.b(new LinkedHashMap(bVar.a()), false);
        for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
            String str = (String) entry3.getKey();
            Object value2 = entry3.getValue();
            if (value2 instanceof Boolean) {
                bVar2.f(AbstractC0602b.e(str), value2);
            } else if (value2 instanceof Float) {
                T2.h.e(str, "name");
                bVar2.f(new S.d(str), value2);
            } else if (value2 instanceof Integer) {
                T2.h.e(str, "name");
                bVar2.f(new S.d(str), value2);
            } else if (value2 instanceof Long) {
                bVar2.f(AbstractC0602b.K(str), value2);
            } else if (value2 instanceof String) {
                bVar2.f(AbstractC0602b.U(str), value2);
            } else if (value2 instanceof Set) {
                S.d V3 = AbstractC0602b.V(str);
                T2.h.c(value2, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                bVar2.f(V3, (Set) value2);
            }
        }
        return new S.b(new LinkedHashMap(bVar2.a()), true);
    }
}

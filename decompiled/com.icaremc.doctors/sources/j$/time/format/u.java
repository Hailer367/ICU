package j$.time.format;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final Map f2598a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f2599b;

    public u(Map map) {
        this.f2598a = map;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                String str = (String) entry2.getValue();
                String str2 = (String) entry2.getValue();
                Long l2 = (Long) entry2.getKey();
                t tVar = a.f2548b;
                hashMap2.put(str, new AbstractMap.SimpleImmutableEntry(str2, l2));
            }
            ArrayList arrayList2 = new ArrayList(hashMap2.values());
            Collections.sort(arrayList2, a.f2548b);
            hashMap.put((z) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            hashMap.put(null, arrayList);
        }
        Collections.sort(arrayList, a.f2548b);
        this.f2599b = hashMap;
    }

    public final String a(long j2, z zVar) {
        Map map = (Map) this.f2598a.get(zVar);
        if (map != null) {
            return (String) map.get(Long.valueOf(j2));
        }
        return null;
    }
}

package I2;

import f1.AbstractC0286a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class p extends AbstractC0286a {
    public static int Q(int i4) {
        if (i4 < 0) {
            return i4;
        }
        if (i4 < 3) {
            return i4 + 1;
        }
        if (i4 < 1073741824) {
            return (int) ((i4 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map R(ArrayList arrayList) {
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(Q(arrayList.size()));
                int size2 = arrayList.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    H2.d dVar = (H2.d) obj;
                    linkedHashMap.put(dVar.f673f, dVar.f674g);
                }
                return linkedHashMap;
            }
            H2.d dVar2 = (H2.d) arrayList.get(0);
            T2.h.e(dVar2, "pair");
            Map singletonMap = Collections.singletonMap(dVar2.f673f, dVar2.f674g);
            T2.h.d(singletonMap, "singletonMap(...)");
            return singletonMap;
        }
        return n.f863f;
    }
}

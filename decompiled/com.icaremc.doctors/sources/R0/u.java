package R0;

import a.AbstractC0051a;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class u extends AbstractC0051a {
    public static int X(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static Map Y(ArrayList arrayList) {
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(X(arrayList.size()));
                int size2 = arrayList.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    Q0.e eVar = (Q0.e) obj;
                    linkedHashMap.put(eVar.f714c, eVar.f715d);
                }
                return linkedHashMap;
            }
            Q0.e pair = (Q0.e) arrayList.get(0);
            kotlin.jvm.internal.h.e(pair, "pair");
            Map singletonMap = Collections.singletonMap(pair.f714c, pair.f715d);
            kotlin.jvm.internal.h.d(singletonMap, "singletonMap(...)");
            return singletonMap;
        }
        return s.f751c;
    }
}

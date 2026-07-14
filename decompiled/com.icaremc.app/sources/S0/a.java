package S0;

import A2.i;
import F0.d;
import android.util.SparseArray;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f1543a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f1544b;

    static {
        HashMap hashMap = new HashMap();
        f1544b = hashMap;
        hashMap.put(d.f526f, 0);
        hashMap.put(d.f527g, 1);
        hashMap.put(d.f528h, 2);
        for (d dVar : hashMap.keySet()) {
            f1543a.append(((Integer) f1544b.get(dVar)).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = (Integer) f1544b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i4) {
        d dVar = (d) f1543a.get(i4);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(i.g(i4, "Unknown Priority for value "));
    }
}

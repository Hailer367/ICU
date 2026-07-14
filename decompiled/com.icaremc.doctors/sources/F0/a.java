package F0;

import android.util.SparseArray;
import java.util.HashMap;
import s0.d;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f275a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f276b;

    static {
        HashMap hashMap = new HashMap();
        f276b = hashMap;
        hashMap.put(d.f3585c, 0);
        hashMap.put(d.f3586d, 1);
        hashMap.put(d.f3587e, 2);
        for (d dVar : hashMap.keySet()) {
            f275a.append(((Integer) f276b.get(dVar)).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = (Integer) f276b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i2) {
        d dVar = (d) f275a.get(i2);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(O.a.c(i2, "Unknown Priority for value "));
    }
}

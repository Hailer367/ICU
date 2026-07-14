package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0195b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3002a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3003b;

    public C0195b(HashMap hashMap) {
        this.f3003b = hashMap;
        for (Map.Entry entry : hashMap.entrySet()) {
            EnumC0206m enumC0206m = (EnumC0206m) entry.getValue();
            List list = (List) this.f3002a.get(enumC0206m);
            if (list == null) {
                list = new ArrayList();
                this.f3002a.put(enumC0206m, list);
            }
            list.add((C0196c) entry.getKey());
        }
    }

    public static void a(List list, InterfaceC0212t interfaceC0212t, EnumC0206m enumC0206m, Object obj) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                C0196c c0196c = (C0196c) list.get(size);
                Method method = c0196c.f3005b;
                try {
                    int i4 = c0196c.f3004a;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 == 2) {
                                method.invoke(obj, interfaceC0212t, enumC0206m);
                            }
                        } else {
                            method.invoke(obj, interfaceC0212t);
                        }
                    } else {
                        method.invoke(obj, null);
                    }
                } catch (IllegalAccessException e4) {
                    throw new RuntimeException(e4);
                } catch (InvocationTargetException e5) {
                    throw new RuntimeException("Failed to call observer method", e5.getCause());
                }
            }
        }
    }
}

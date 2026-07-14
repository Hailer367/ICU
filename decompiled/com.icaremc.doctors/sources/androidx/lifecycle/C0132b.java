package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0132b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1828a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f1829b;

    public C0132b(HashMap hashMap) {
        this.f1829b = hashMap;
        for (Map.Entry entry : hashMap.entrySet()) {
            EnumC0144n enumC0144n = (EnumC0144n) entry.getValue();
            List list = (List) this.f1828a.get(enumC0144n);
            if (list == null) {
                list = new ArrayList();
                this.f1828a.put(enumC0144n, list);
            }
            list.add((C0133c) entry.getKey());
        }
    }

    public static void a(List list, InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n, Object obj) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                C0133c c0133c = (C0133c) list.get(size);
                Method method = c0133c.f1832b;
                try {
                    int i2 = c0133c.f1831a;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2) {
                                method.invoke(obj, interfaceC0150u, enumC0144n);
                            }
                        } else {
                            method.invoke(obj, interfaceC0150u);
                        }
                    } else {
                        method.invoke(obj, null);
                    }
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException("Failed to call observer method", e3.getCause());
                }
            }
        }
    }
}

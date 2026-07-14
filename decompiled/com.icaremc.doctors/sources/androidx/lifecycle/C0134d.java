package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0134d {

    /* renamed from: c, reason: collision with root package name */
    public static final C0134d f1834c = new C0134d();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1835a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f1836b = new HashMap();

    public static void b(HashMap hashMap, C0133c c0133c, EnumC0144n enumC0144n, Class cls) {
        EnumC0144n enumC0144n2 = (EnumC0144n) hashMap.get(c0133c);
        if (enumC0144n2 != null && enumC0144n != enumC0144n2) {
            throw new IllegalArgumentException("Method " + c0133c.f1832b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + enumC0144n2 + ", new value " + enumC0144n);
        }
        if (enumC0144n2 == null) {
            hashMap.put(c0133c, enumC0144n);
        }
    }

    public final C0132b a(Class cls, Method[] methodArr) {
        int i2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = this.f1835a;
        if (superclass != null) {
            C0132b c0132b = (C0132b) hashMap2.get(superclass);
            if (c0132b == null) {
                c0132b = a(superclass, null);
            }
            hashMap.putAll(c0132b.f1829b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            C0132b c0132b2 = (C0132b) hashMap2.get(cls2);
            if (c0132b2 == null) {
                c0132b2 = a(cls2, null);
            }
            for (Map.Entry entry : c0132b2.f1829b.entrySet()) {
                b(hashMap, (C0133c) entry.getKey(), (EnumC0144n) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e2) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            F f2 = (F) method.getAnnotation(F.class);
            if (f2 != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 0) {
                    if (InterfaceC0150u.class.isAssignableFrom(parameterTypes[0])) {
                        i2 = 1;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                } else {
                    i2 = 0;
                }
                EnumC0144n value = f2.value();
                if (parameterTypes.length > 1) {
                    if (EnumC0144n.class.isAssignableFrom(parameterTypes[1])) {
                        if (value == EnumC0144n.ON_ANY) {
                            i2 = 2;
                        } else {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    b(hashMap, new C0133c(method, i2), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0132b c0132b3 = new C0132b(hashMap);
        hashMap2.put(cls, c0132b3);
        this.f1836b.put(cls, Boolean.valueOf(z));
        return c0132b3;
    }
}

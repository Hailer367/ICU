package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0197d {

    /* renamed from: c, reason: collision with root package name */
    public static final C0197d f3006c = new C0197d();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3007a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3008b = new HashMap();

    public static void b(HashMap hashMap, C0196c c0196c, EnumC0206m enumC0206m, Class cls) {
        EnumC0206m enumC0206m2 = (EnumC0206m) hashMap.get(c0196c);
        if (enumC0206m2 != null && enumC0206m != enumC0206m2) {
            throw new IllegalArgumentException("Method " + c0196c.f3005b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + enumC0206m2 + ", new value " + enumC0206m);
        }
        if (enumC0206m2 == null) {
            hashMap.put(c0196c, enumC0206m);
        }
    }

    public final C0195b a(Class cls, Method[] methodArr) {
        int i4;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = this.f3007a;
        if (superclass != null) {
            C0195b c0195b = (C0195b) hashMap2.get(superclass);
            if (c0195b == null) {
                c0195b = a(superclass, null);
            }
            hashMap.putAll(c0195b.f3003b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            C0195b c0195b2 = (C0195b) hashMap2.get(cls2);
            if (c0195b2 == null) {
                c0195b2 = a(cls2, null);
            }
            for (Map.Entry entry : c0195b2.f3003b.entrySet()) {
                b(hashMap, (C0196c) entry.getKey(), (EnumC0206m) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e4) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e4);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            B b4 = (B) method.getAnnotation(B.class);
            if (b4 != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 0) {
                    if (InterfaceC0212t.class.isAssignableFrom(parameterTypes[0])) {
                        i4 = 1;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                } else {
                    i4 = 0;
                }
                EnumC0206m value = b4.value();
                if (parameterTypes.length > 1) {
                    if (EnumC0206m.class.isAssignableFrom(parameterTypes[1])) {
                        if (value == EnumC0206m.ON_ANY) {
                            i4 = 2;
                        } else {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    b(hashMap, new C0196c(i4, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0195b c0195b3 = new C0195b(hashMap);
        hashMap2.put(cls, c0195b3);
        this.f3008b.put(cls, Boolean.valueOf(z));
        return c0195b3;
    }
}

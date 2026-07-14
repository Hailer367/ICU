package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* renamed from: androidx.lifecycle.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0215w {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f3031a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f3032b = new HashMap();

    public static void a(Constructor constructor, InterfaceC0211s interfaceC0211s) {
        try {
            T2.h.d(constructor.newInstance(interfaceC0211s), "{\n            constructo…tance(`object`)\n        }");
            throw new ClassCastException();
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    public static final String b(String str) {
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        int indexOf = str.indexOf(".", 0);
        if (indexOf >= 0) {
            int length = str.length();
            if (length >= 0) {
                StringBuilder sb2 = new StringBuilder(length);
                do {
                    sb2.append((CharSequence) str, i4, indexOf);
                    sb2.append("_");
                    i4 = indexOf + 1;
                    if (indexOf >= str.length()) {
                        break;
                    }
                    indexOf = str.indexOf(".", i4);
                } while (indexOf > 0);
                sb2.append((CharSequence) str, i4, str.length());
                str = sb2.toString();
                T2.h.d(str, "toString(...)");
            } else {
                throw new OutOfMemoryError();
            }
        }
        return r2.k.c(sb, str, "_LifecycleAdapter");
    }

    public static int c(Class cls) {
        Constructor<?> constructor;
        boolean z;
        boolean z3;
        boolean z4;
        String str;
        HashMap hashMap = f3031a;
        Integer num = (Integer) hashMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i4 = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r3 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                if (r3 != null) {
                    str = r3.getName();
                } else {
                    str = "";
                }
                T2.h.d(str, "fullPackage");
                if (str.length() != 0) {
                    T2.h.d(canonicalName, "name");
                    canonicalName = canonicalName.substring(str.length() + 1);
                    T2.h.d(canonicalName, "this as java.lang.String).substring(startIndex)");
                }
                T2.h.d(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
                String b4 = b(canonicalName);
                if (str.length() != 0) {
                    b4 = str + '.' + b4;
                }
                constructor = Class.forName(b4).getDeclaredConstructor(cls);
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException(e4);
            }
            HashMap hashMap2 = f3032b;
            if (constructor != null) {
                hashMap2.put(cls, android.support.v4.media.session.a.p(constructor));
            } else {
                C0197d c0197d = C0197d.f3006c;
                HashMap hashMap3 = c0197d.f3008b;
                Boolean bool = (Boolean) hashMap3.get(cls);
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 < length) {
                                if (((B) declaredMethods[i5].getAnnotation(B.class)) != null) {
                                    c0197d.a(cls, declaredMethods);
                                    z = true;
                                    break;
                                }
                                i5++;
                            } else {
                                hashMap3.put(cls, Boolean.FALSE);
                                z = false;
                                break;
                            }
                        }
                    } catch (NoClassDefFoundError e5) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e5);
                    }
                }
                if (!z) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && InterfaceC0211s.class.isAssignableFrom(superclass)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        T2.h.d(superclass, "superclass");
                        if (c(superclass) != 1) {
                            Object obj = hashMap2.get(superclass);
                            T2.h.b(obj);
                            arrayList = new ArrayList((Collection) obj);
                        }
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    T2.h.d(interfaces, "klass.interfaces");
                    int length2 = interfaces.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 < length2) {
                            Class<?> cls2 = interfaces[i6];
                            if (cls2 != null && InterfaceC0211s.class.isAssignableFrom(cls2)) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                T2.h.d(cls2, "intrface");
                                if (c(cls2) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                Object obj2 = hashMap2.get(cls2);
                                T2.h.b(obj2);
                                arrayList.addAll((Collection) obj2);
                            }
                            i6++;
                        } else if (arrayList != null) {
                            hashMap2.put(cls, arrayList);
                        }
                    }
                }
            }
            i4 = 2;
        }
        hashMap.put(cls, Integer.valueOf(i4));
        return i4;
    }
}

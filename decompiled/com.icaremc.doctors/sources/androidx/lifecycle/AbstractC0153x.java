package androidx.lifecycle;

import com.google.firebase.encoders.json.BuildConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* renamed from: androidx.lifecycle.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0153x {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f1862a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f1863b = new HashMap();

    public static void a(Constructor constructor, InterfaceC0149t interfaceC0149t) {
        try {
            kotlin.jvm.internal.h.d(constructor.newInstance(interfaceC0149t), "{\n            constructo…tance(`object`)\n        }");
            throw new ClassCastException();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static final String b(String str) {
        StringBuilder sb = new StringBuilder();
        int O2 = k1.h.O(str, ".", 0, false);
        if (O2 >= 0) {
            int length = str.length();
            if (length >= 0) {
                StringBuilder sb2 = new StringBuilder(length);
                int i2 = 0;
                do {
                    sb2.append((CharSequence) str, i2, O2);
                    sb2.append("_");
                    i2 = O2 + 1;
                    if (O2 >= str.length()) {
                        break;
                    }
                    O2 = k1.h.O(str, ".", i2, false);
                } while (O2 > 0);
                sb2.append((CharSequence) str, i2, str.length());
                str = sb2.toString();
                kotlin.jvm.internal.h.d(str, "toString(...)");
            } else {
                throw new OutOfMemoryError();
            }
        }
        return O.a.i(sb, str, "_LifecycleAdapter");
    }

    public static int c(Class cls) {
        Constructor<?> constructor;
        boolean z;
        boolean z2;
        boolean z3;
        String fullPackage;
        HashMap hashMap = f1862a;
        Integer num = (Integer) hashMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i2 = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r3 = cls.getPackage();
                String name = cls.getCanonicalName();
                if (r3 != null) {
                    fullPackage = r3.getName();
                } else {
                    fullPackage = BuildConfig.FLAVOR;
                }
                kotlin.jvm.internal.h.d(fullPackage, "fullPackage");
                if (fullPackage.length() != 0) {
                    kotlin.jvm.internal.h.d(name, "name");
                    name = name.substring(fullPackage.length() + 1);
                    kotlin.jvm.internal.h.d(name, "this as java.lang.String).substring(startIndex)");
                }
                kotlin.jvm.internal.h.d(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
                String b2 = b(name);
                if (fullPackage.length() != 0) {
                    b2 = fullPackage + '.' + b2;
                }
                constructor = Class.forName(b2).getDeclaredConstructor(cls);
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            }
            HashMap hashMap2 = f1863b;
            if (constructor != null) {
                hashMap2.put(cls, android.support.v4.media.session.a.y(constructor));
            } else {
                C0134d c0134d = C0134d.f1834c;
                HashMap hashMap3 = c0134d.f1836b;
                Boolean bool = (Boolean) hashMap3.get(cls);
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                if (((F) declaredMethods[i3].getAnnotation(F.class)) != null) {
                                    c0134d.a(cls, declaredMethods);
                                    z = true;
                                    break;
                                }
                                i3++;
                            } else {
                                hashMap3.put(cls, Boolean.FALSE);
                                z = false;
                                break;
                            }
                        }
                    } catch (NoClassDefFoundError e3) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e3);
                    }
                }
                if (!z) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && InterfaceC0149t.class.isAssignableFrom(superclass)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        kotlin.jvm.internal.h.d(superclass, "superclass");
                        if (c(superclass) != 1) {
                            Object obj = hashMap2.get(superclass);
                            kotlin.jvm.internal.h.b(obj);
                            arrayList = new ArrayList((Collection) obj);
                        }
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    kotlin.jvm.internal.h.d(interfaces, "klass.interfaces");
                    int length2 = interfaces.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length2) {
                            Class<?> intrface = interfaces[i4];
                            if (intrface != null && InterfaceC0149t.class.isAssignableFrom(intrface)) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                kotlin.jvm.internal.h.d(intrface, "intrface");
                                if (c(intrface) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                Object obj2 = hashMap2.get(intrface);
                                kotlin.jvm.internal.h.b(obj2);
                                arrayList.addAll((Collection) obj2);
                            }
                            i4++;
                        } else if (arrayList != null) {
                            hashMap2.put(cls, arrayList);
                        }
                    }
                }
            }
            i2 = 2;
        }
        hashMap.put(cls, Integer.valueOf(i2));
        return i2;
    }
}

package s0;

import H2.i;
import T2.q;
import T2.s;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import x0.C0716b;

/* loaded from: classes.dex */
public final class c implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final T2.e f6129a;

    /* renamed from: b, reason: collision with root package name */
    public final C0716b f6130b;

    public c(T2.e eVar, C0716b c0716b) {
        this.f6129a = eVar;
        this.f6130b = c0716b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object[] objArr2;
        Object[] objArr3;
        Class cls;
        boolean isInstance;
        String b4;
        T2.h.e(obj, "obj");
        T2.h.e(method, "method");
        boolean a4 = T2.h.a(method.getName(), "accept");
        C0716b c0716b = this.f6130b;
        Object obj2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        String str = null;
        boolean z = false;
        if (a4 && objArr != null && objArr.length == 1) {
            Object obj3 = objArr[0];
            Class cls2 = this.f6129a.f1636a;
            T2.h.e(cls2, "jClass");
            Map map = T2.e.f1635b;
            T2.h.c(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(cls2);
            if (num != null) {
                isInstance = s.c(num.intValue(), obj3);
            } else {
                if (cls2.isPrimitive()) {
                    cls = k3.b.i(q.a(cls2));
                } else {
                    cls = cls2;
                }
                isInstance = cls.isInstance(obj3);
            }
            if (!isInstance) {
                StringBuilder sb = new StringBuilder("Value cannot be cast to ");
                if (!cls2.isAnonymousClass() && !cls2.isLocalClass()) {
                    if (cls2.isArray()) {
                        Class<?> componentType = cls2.getComponentType();
                        if (componentType.isPrimitive() && (b4 = s.b(componentType.getName())) != null) {
                            str = b4.concat("Array");
                        }
                        if (str == null) {
                            str = "kotlin.Array";
                        }
                    } else {
                        str = s.b(cls2.getName());
                        if (str == null) {
                            str = cls2.getCanonicalName();
                        }
                    }
                }
                sb.append(str);
                throw new ClassCastException(sb.toString());
            }
            T2.h.c(obj3, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            c0716b.f(obj3);
            return i.f681a;
        }
        if (T2.h.a(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1) {
            objArr2 = true;
        } else {
            objArr2 = false;
        }
        if (objArr2 != false) {
            if (objArr != null) {
                obj2 = objArr[0];
            }
            if (obj == obj2) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        if (T2.h.a(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null) {
            objArr3 = true;
        } else {
            objArr3 = false;
        }
        if (objArr3 != false) {
            return Integer.valueOf(c0716b.hashCode());
        }
        if (T2.h.a(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null) {
            z = true;
        }
        if (z) {
            return c0716b.toString();
        }
        throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
    }
}

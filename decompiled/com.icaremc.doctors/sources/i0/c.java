package i0;

import Q0.j;
import a.AbstractC0051a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;

/* loaded from: classes.dex */
public final class c implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final kotlin.jvm.internal.d f2335a;

    /* renamed from: b, reason: collision with root package name */
    public final n0.b f2336b;

    public c(kotlin.jvm.internal.d dVar, n0.b bVar) {
        this.f2335a = dVar;
        this.f2336b = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object[] objArr2;
        Object[] objArr3;
        Class cls;
        boolean isInstance;
        String b2;
        kotlin.jvm.internal.h.e(obj, "obj");
        kotlin.jvm.internal.h.e(method, "method");
        boolean a2 = kotlin.jvm.internal.h.a(method.getName(), "accept");
        n0.b bVar = this.f2336b;
        Object obj2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        String str = null;
        boolean z = false;
        if (a2 && objArr != null && objArr.length == 1) {
            Object obj3 = objArr[0];
            Class jClass = this.f2335a.f2782c;
            kotlin.jvm.internal.h.e(jClass, "jClass");
            Map map = kotlin.jvm.internal.d.f2781d;
            kotlin.jvm.internal.h.c(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                isInstance = t.c(num.intValue(), obj3);
            } else {
                if (jClass.isPrimitive()) {
                    cls = AbstractC0051a.y(r.a(jClass));
                } else {
                    cls = jClass;
                }
                isInstance = cls.isInstance(obj3);
            }
            if (!isInstance) {
                StringBuilder sb = new StringBuilder("Value cannot be cast to ");
                if (!jClass.isAnonymousClass() && !jClass.isLocalClass()) {
                    if (jClass.isArray()) {
                        Class<?> componentType = jClass.getComponentType();
                        if (componentType.isPrimitive() && (b2 = t.b(componentType.getName())) != null) {
                            str = b2.concat("Array");
                        }
                        if (str == null) {
                            str = "kotlin.Array";
                        }
                    } else {
                        str = t.b(jClass.getName());
                        if (str == null) {
                            str = jClass.getCanonicalName();
                        }
                    }
                }
                sb.append(str);
                throw new ClassCastException(sb.toString());
            }
            kotlin.jvm.internal.h.c(obj3, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            bVar.invoke(obj3);
            return j.f722a;
        }
        if (kotlin.jvm.internal.h.a(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1) {
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
        if (kotlin.jvm.internal.h.a(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null) {
            objArr3 = true;
        } else {
            objArr3 = false;
        }
        if (objArr3 != false) {
            return Integer.valueOf(bVar.hashCode());
        }
        if (kotlin.jvm.internal.h.a(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null) {
            z = true;
        }
        if (z) {
            return bVar.toString();
        }
        throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
    }
}

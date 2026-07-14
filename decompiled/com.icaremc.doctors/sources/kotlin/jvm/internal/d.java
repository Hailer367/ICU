package kotlin.jvm.internal;

import a.AbstractC0051a;
import c1.u;
import c1.v;
import c1.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class d implements i1.c, c {

    /* renamed from: d, reason: collision with root package name */
    public static final Map f2781d;

    /* renamed from: c, reason: collision with root package name */
    public final Class f2782c;

    static {
        List N2 = R0.k.N(c1.a.class, c1.l.class, c1.p.class, c1.q.class, c1.r.class, c1.s.class, c1.t.class, u.class, v.class, w.class, c1.b.class, c1.c.class, c1.d.class, c1.e.class, c1.f.class, c1.g.class, c1.h.class, c1.i.class, c1.j.class, c1.k.class, c1.m.class, c1.n.class, c1.o.class);
        ArrayList arrayList = new ArrayList(R0.l.O(N2));
        int i2 = 0;
        for (Object obj : N2) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                arrayList.add(new Q0.e((Class) obj, Integer.valueOf(i2)));
                i2 = i3;
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        f2781d = R0.u.Y(arrayList);
    }

    public d(Class jClass) {
        h.e(jClass, "jClass");
        this.f2782c = jClass;
    }

    @Override // kotlin.jvm.internal.c
    public final Class a() {
        return this.f2782c;
    }

    public final String b() {
        String d2;
        Class jClass = this.f2782c;
        h.e(jClass, "jClass");
        String str = null;
        if (jClass.isAnonymousClass()) {
            return null;
        }
        if (jClass.isLocalClass()) {
            String simpleName = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return k1.h.Q(simpleName, enclosingMethod.getName() + '$');
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                return k1.h.Q(simpleName, enclosingConstructor.getName() + '$');
            }
            int indexOf = simpleName.indexOf(36, 0);
            if (indexOf == -1) {
                return simpleName;
            }
            String substring = simpleName.substring(indexOf + 1, simpleName.length());
            h.d(substring, "substring(...)");
            return substring;
        }
        if (jClass.isArray()) {
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (d2 = t.d(componentType.getName())) != null) {
                str = d2.concat("Array");
            }
            if (str == null) {
                return "Array";
            }
            return str;
        }
        String d3 = t.d(jClass.getName());
        if (d3 == null) {
            return jClass.getSimpleName();
        }
        return d3;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof d) && AbstractC0051a.y(this).equals(AbstractC0051a.y((i1.c) obj))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0051a.y(this).hashCode();
    }

    public final String toString() {
        return this.f2782c.toString() + " (Kotlin reflection is not available)";
    }
}

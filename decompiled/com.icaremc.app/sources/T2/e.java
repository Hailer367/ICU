package T2;

import S2.t;
import S2.u;
import S2.v;
import S2.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e implements Y2.b, d {

    /* renamed from: b, reason: collision with root package name */
    public static final Map f1635b;

    /* renamed from: a, reason: collision with root package name */
    public final Class f1636a;

    static {
        List C3 = I2.f.C(S2.a.class, S2.l.class, S2.p.class, S2.q.class, S2.r.class, S2.s.class, t.class, u.class, v.class, w.class, S2.b.class, S2.c.class, S2.d.class, S2.e.class, S2.f.class, S2.g.class, S2.h.class, S2.i.class, S2.j.class, S2.k.class, S2.m.class, S2.n.class, S2.o.class);
        ArrayList arrayList = new ArrayList(C3.size());
        int i4 = 0;
        for (Object obj : C3) {
            int i5 = i4 + 1;
            if (i4 >= 0) {
                arrayList.add(new H2.d((Class) obj, Integer.valueOf(i4)));
                i4 = i5;
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        f1635b = I2.p.R(arrayList);
    }

    public e(Class cls) {
        h.e(cls, "jClass");
        this.f1636a = cls;
    }

    @Override // T2.d
    public final Class a() {
        return this.f1636a;
    }

    public final String b() {
        String d4;
        Class cls = this.f1636a;
        h.e(cls, "jClass");
        String str = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (cls.isLocalClass()) {
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                return a3.h.E(simpleName, enclosingMethod.getName() + '$');
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                return a3.h.E(simpleName, enclosingConstructor.getName() + '$');
            }
            int indexOf = simpleName.indexOf(36, 0);
            if (indexOf == -1) {
                return simpleName;
            }
            String substring = simpleName.substring(indexOf + 1, simpleName.length());
            h.d(substring, "substring(...)");
            return substring;
        }
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (d4 = s.d(componentType.getName())) != null) {
                str = d4.concat("Array");
            }
            if (str == null) {
                return "Array";
            }
            return str;
        }
        String d5 = s.d(cls.getName());
        if (d5 == null) {
            return cls.getSimpleName();
        }
        return d5;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof e) && k3.b.i(this).equals(k3.b.i((Y2.b) obj))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return k3.b.i(this).hashCode();
    }

    public final String toString() {
        return this.f1636a.toString() + " (Kotlin reflection is not available)";
    }
}

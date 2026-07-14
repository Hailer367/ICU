package W1;

import b2.C0223a;
import b2.C0224b;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: W1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0119j extends T1.s {

    /* renamed from: d, reason: collision with root package name */
    public static final C0118i f1940d = new C0118i();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1941a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f1942b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f1943c = new HashMap();

    public C0119j(Class cls) {
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i4 = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i4] = field;
                    i4++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i4);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r4 = (Enum) field2.get(null);
                String name = r4.name();
                String str = r4.toString();
                U1.b bVar = (U1.b) field2.getAnnotation(U1.b.class);
                if (bVar != null) {
                    name = bVar.value();
                    for (String str2 : bVar.alternate()) {
                        this.f1941a.put(str2, r4);
                    }
                }
                this.f1941a.put(name, r4);
                this.f1942b.put(str, r4);
                this.f1943c.put(r4, name);
            }
        } catch (IllegalAccessException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        String v3 = c0223a.v();
        Enum r02 = (Enum) this.f1941a.get(v3);
        if (r02 == null) {
            return (Enum) this.f1942b.get(v3);
        }
        return r02;
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        String str;
        Enum r3 = (Enum) obj;
        if (r3 == null) {
            str = null;
        } else {
            str = (String) this.f1943c.get(r3);
        }
        c0224b.r(str);
    }
}

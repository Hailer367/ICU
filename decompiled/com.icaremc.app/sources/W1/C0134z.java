package W1;

import b2.C0223a;
import f1.AbstractC0286a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: W1.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0134z extends AbstractC0131w {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f1983e;

    /* renamed from: b, reason: collision with root package name */
    public final Constructor f1984b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f1985c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f1986d;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Byte.TYPE, (byte) 0);
        hashMap.put(Short.TYPE, (short) 0);
        hashMap.put(Integer.TYPE, 0);
        hashMap.put(Long.TYPE, 0L);
        hashMap.put(Float.TYPE, Float.valueOf(0.0f));
        hashMap.put(Double.TYPE, Double.valueOf(0.0d));
        hashMap.put(Character.TYPE, (char) 0);
        hashMap.put(Boolean.TYPE, Boolean.FALSE);
        f1983e = hashMap;
    }

    public C0134z(Class cls, C0133y c0133y) {
        super(c0133y);
        this.f1986d = new HashMap();
        AbstractC0286a abstractC0286a = Y1.c.f2084a;
        Constructor m3 = abstractC0286a.m(cls);
        this.f1984b = m3;
        Y1.c.f(m3);
        String[] s3 = abstractC0286a.s(cls);
        for (int i4 = 0; i4 < s3.length; i4++) {
            this.f1986d.put(s3[i4], Integer.valueOf(i4));
        }
        Class<?>[] parameterTypes = this.f1984b.getParameterTypes();
        this.f1985c = new Object[parameterTypes.length];
        for (int i5 = 0; i5 < parameterTypes.length; i5++) {
            this.f1985c[i5] = f1983e.get(parameterTypes[i5]);
        }
    }

    @Override // W1.AbstractC0131w
    public final Object d() {
        return (Object[]) this.f1985c.clone();
    }

    @Override // W1.AbstractC0131w
    public final Object e(Object obj) {
        Object[] objArr = (Object[]) obj;
        Constructor constructor = this.f1984b;
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e4) {
            AbstractC0286a abstractC0286a = Y1.c.f2084a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.12.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e4);
        } catch (IllegalArgumentException e5) {
            e = e5;
            throw new RuntimeException("Failed to invoke constructor '" + Y1.c.b(constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException("Failed to invoke constructor '" + Y1.c.b(constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException("Failed to invoke constructor '" + Y1.c.b(constructor) + "' with args " + Arrays.toString(objArr), e7.getCause());
        }
    }

    @Override // W1.AbstractC0131w
    public final void f(Object obj, C0223a c0223a, C0130v c0130v) {
        Object[] objArr = (Object[]) obj;
        String str = c0130v.f1972c;
        Integer num = (Integer) this.f1986d.get(str);
        if (num != null) {
            int intValue = num.intValue();
            Object b4 = c0130v.f1975f.b(c0223a);
            if (b4 == null && c0130v.f1976g) {
                throw new RuntimeException("null is not allowed as value for record component '" + str + "' of primitive type; at path " + c0223a.h());
            }
            objArr[intValue] = b4;
            return;
        }
        throw new IllegalStateException("Could not find the index in the constructor '" + Y1.c.b(this.f1984b) + "' for field with name '" + str + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
    }
}

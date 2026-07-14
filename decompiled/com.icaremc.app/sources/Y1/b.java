package Y1;

import f1.AbstractC0286a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class b extends AbstractC0286a {

    /* renamed from: d, reason: collision with root package name */
    public final Method f2080d = Class.class.getMethod("isRecord", null);

    /* renamed from: e, reason: collision with root package name */
    public final Method f2081e = Class.class.getMethod("getRecordComponents", null);

    /* renamed from: f, reason: collision with root package name */
    public final Method f2082f;

    /* renamed from: g, reason: collision with root package name */
    public final Method f2083g;

    public b() {
        Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
        this.f2082f = cls.getMethod("getName", null);
        this.f2083g = cls.getMethod("getType", null);
    }

    @Override // f1.AbstractC0286a
    public final Method l(Class cls, Field field) {
        try {
            return cls.getMethod(field.getName(), null);
        } catch (ReflectiveOperationException e4) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.12.0). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e4);
        }
    }

    @Override // f1.AbstractC0286a
    public final Constructor m(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f2081e.invoke(cls, null);
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i4 = 0; i4 < objArr.length; i4++) {
                clsArr[i4] = (Class) this.f2083g.invoke(objArr[i4], null);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (ReflectiveOperationException e4) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.12.0). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e4);
        }
    }

    @Override // f1.AbstractC0286a
    public final String[] s(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f2081e.invoke(cls, null);
            String[] strArr = new String[objArr.length];
            for (int i4 = 0; i4 < objArr.length; i4++) {
                strArr[i4] = (String) this.f2082f.invoke(objArr[i4], null);
            }
            return strArr;
        } catch (ReflectiveOperationException e4) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.12.0). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e4);
        }
    }

    @Override // f1.AbstractC0286a
    public final boolean x(Class cls) {
        try {
            return ((Boolean) this.f2080d.invoke(cls, null)).booleanValue();
        } catch (ReflectiveOperationException e4) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.12.0). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e4);
        }
    }
}

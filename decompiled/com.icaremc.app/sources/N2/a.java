package N2;

import T2.h;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f1073a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        h.b(methods);
        int length = methods.length;
        int i4 = 0;
        while (true) {
            method = null;
            Class<?> cls = null;
            if (i4 >= length) {
                break;
            }
            Method method2 = methods[i4];
            if (h.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                h.d(parameterTypes, "getParameterTypes(...)");
                if (parameterTypes.length == 1) {
                    cls = parameterTypes[0];
                }
                if (h.a(cls, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i4++;
        }
        f1073a = method;
        int length2 = methods.length;
        for (int i5 = 0; i5 < length2 && !h.a(methods[i5].getName(), "getSuppressed"); i5++) {
        }
    }
}

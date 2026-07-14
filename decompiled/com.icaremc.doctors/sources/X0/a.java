package X0;

import java.lang.reflect.Method;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f836a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        h.b(methods);
        int length = methods.length;
        int i2 = 0;
        while (true) {
            method = null;
            Class<?> cls = null;
            if (i2 >= length) {
                break;
            }
            Method method2 = methods[i2];
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
            i2++;
        }
        f836a = method;
        int length2 = methods.length;
        for (int i3 = 0; i3 < length2 && !h.a(methods[i3].getName(), "getSuppressed"); i3++) {
        }
    }
}

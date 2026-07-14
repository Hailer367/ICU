package g3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final List f3780a;

    static {
        try {
            Iterator it = Arrays.asList(new c3.b()).iterator();
            T2.h.e(it, "<this>");
            f3780a = Z2.e.D(new Z2.a(new Z2.g(it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}

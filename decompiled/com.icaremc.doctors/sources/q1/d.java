package q1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final List f3513a;

    static {
        try {
            Iterator it = Arrays.asList(new m1.b()).iterator();
            kotlin.jvm.internal.h.e(it, "<this>");
            f3513a = j1.e.X(new j1.a(new j1.g(it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}

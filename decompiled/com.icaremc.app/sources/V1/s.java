package V1;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class s extends u {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f1769b;

    public s(Method method) {
        this.f1769b = method;
    }

    @Override // V1.u
    public final Object a(Class cls) {
        String f4 = E0.a.f(cls);
        if (f4 == null) {
            return this.f1769b.invoke(null, cls, Object.class);
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(f4));
    }
}

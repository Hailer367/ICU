package V1;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class r extends u {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f1767b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1768c;

    public r(int i4, Method method) {
        this.f1767b = method;
        this.f1768c = i4;
    }

    @Override // V1.u
    public final Object a(Class cls) {
        String f4 = E0.a.f(cls);
        if (f4 == null) {
            return this.f1767b.invoke(null, cls, Integer.valueOf(this.f1768c));
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(f4));
    }
}

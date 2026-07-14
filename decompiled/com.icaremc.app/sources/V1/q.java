package V1;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class q extends u {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f1765b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1766c;

    public q(Method method, Object obj) {
        this.f1765b = method;
        this.f1766c = obj;
    }

    @Override // V1.u
    public final Object a(Class cls) {
        String f4 = E0.a.f(cls);
        if (f4 == null) {
            return this.f1765b.invoke(this.f1766c, cls);
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(f4));
    }
}

package l1;

import a.AbstractC0051a;

/* loaded from: classes.dex */
public final class i0 implements T0.g, T0.h {

    /* renamed from: c, reason: collision with root package name */
    public static final i0 f2997c = new Object();

    @Override // T0.i
    public final Object c(Object obj, c1.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // T0.i
    public final T0.i d(T0.i context) {
        kotlin.jvm.internal.h.e(context, "context");
        if (context == T0.j.f774c) {
            return this;
        }
        return (T0.i) context.c(this, new T0.b(1));
    }

    @Override // T0.i
    public final T0.i g(T0.h hVar) {
        return AbstractC0051a.H(this, hVar);
    }

    @Override // T0.i
    public final T0.g k(T0.h hVar) {
        return AbstractC0051a.w(this, hVar);
    }

    @Override // T0.g
    public final T0.h getKey() {
        return this;
    }
}

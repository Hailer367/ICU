package K;

import a.AbstractC0051a;

/* loaded from: classes.dex */
public final class q0 implements T0.g {

    /* renamed from: c, reason: collision with root package name */
    public final q0 f539c;

    /* renamed from: d, reason: collision with root package name */
    public final Q f540d;

    public q0(q0 q0Var, Q q) {
        this.f539c = q0Var;
        this.f540d = q;
    }

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

    public final void e(Q q) {
        if (this.f540d != q) {
            q0 q0Var = this.f539c;
            if (q0Var != null) {
                q0Var.e(q);
                return;
            }
            return;
        }
        throw new IllegalStateException("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
    }

    @Override // T0.i
    public final T0.i g(T0.h hVar) {
        return AbstractC0051a.H(this, hVar);
    }

    @Override // T0.g
    public final T0.h getKey() {
        return p0.f536c;
    }

    @Override // T0.i
    public final T0.g k(T0.h hVar) {
        return AbstractC0051a.w(this, hVar);
    }
}

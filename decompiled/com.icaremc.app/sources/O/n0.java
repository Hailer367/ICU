package O;

import a.AbstractC0141a;

/* loaded from: classes.dex */
public final class n0 implements K2.g {

    /* renamed from: f, reason: collision with root package name */
    public final n0 f1232f;

    /* renamed from: g, reason: collision with root package name */
    public final N f1233g;

    public n0(n0 n0Var, N n3) {
        this.f1232f = n0Var;
        this.f1233g = n3;
    }

    @Override // K2.i
    public final K2.i c(K2.h hVar) {
        return AbstractC0141a.v(this, hVar);
    }

    public final void d(N n3) {
        if (this.f1233g != n3) {
            n0 n0Var = this.f1232f;
            if (n0Var != null) {
                n0Var.d(n3);
                return;
            }
            return;
        }
        throw new IllegalStateException("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
    }

    @Override // K2.i
    public final K2.g e(K2.h hVar) {
        return AbstractC0141a.s(this, hVar);
    }

    @Override // K2.g
    public final K2.h getKey() {
        return m0.f1229f;
    }

    @Override // K2.i
    public final K2.i j(K2.i iVar) {
        T2.h.e(iVar, "context");
        if (iVar == K2.j.f942f) {
            return this;
        }
        return (K2.i) iVar.k(this, new K2.b(1));
    }

    @Override // K2.i
    public final Object k(Object obj, S2.p pVar) {
        return pVar.e(obj, this);
    }
}

package androidx.lifecycle;

import i0.C0362e;

/* loaded from: classes.dex */
public final class K implements r {

    /* renamed from: f, reason: collision with root package name */
    public final String f2975f;

    /* renamed from: g, reason: collision with root package name */
    public final J f2976g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2977h;

    public K(String str, J j4) {
        this.f2975f = str;
        this.f2976g = j4;
    }

    @Override // androidx.lifecycle.r
    public final void d(InterfaceC0212t interfaceC0212t, EnumC0206m enumC0206m) {
        if (enumC0206m == EnumC0206m.ON_DESTROY) {
            this.f2977h = false;
            interfaceC0212t.getLifecycle().b(this);
        }
    }

    public final void h(AbstractC0208o abstractC0208o, C0362e c0362e) {
        T2.h.e(c0362e, "registry");
        T2.h.e(abstractC0208o, "lifecycle");
        if (!this.f2977h) {
            this.f2977h = true;
            abstractC0208o.a(this);
            c0362e.c(this.f2975f, this.f2976g.f2974e);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }
}

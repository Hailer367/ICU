package androidx.lifecycle;

import b0.C0163e;

/* loaded from: classes.dex */
public final class P implements InterfaceC0148s {

    /* renamed from: c, reason: collision with root package name */
    public final String f1803c;

    /* renamed from: d, reason: collision with root package name */
    public final O f1804d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1805e;

    public P(String str, O o2) {
        this.f1803c = str;
        this.f1804d = o2;
    }

    @Override // androidx.lifecycle.InterfaceC0148s
    public final void a(InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n) {
        if (enumC0144n == EnumC0144n.ON_DESTROY) {
            this.f1805e = false;
            interfaceC0150u.getLifecycle().b(this);
        }
    }

    public final void b(AbstractC0146p lifecycle, C0163e registry) {
        kotlin.jvm.internal.h.e(registry, "registry");
        kotlin.jvm.internal.h.e(lifecycle, "lifecycle");
        if (!this.f1805e) {
            this.f1805e = true;
            lifecycle.a(this);
            registry.c(this.f1803c, this.f1804d.f1802e);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }
}

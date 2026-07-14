package androidx.lifecycle;

/* loaded from: classes.dex */
public final class A extends B implements InterfaceC0148s {

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC0150u f1777g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ C f1778h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(C c2, InterfaceC0150u interfaceC0150u, E e2) {
        super(c2, e2);
        this.f1778h = c2;
        this.f1777g = interfaceC0150u;
    }

    @Override // androidx.lifecycle.InterfaceC0148s
    public final void a(InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n) {
        InterfaceC0150u interfaceC0150u2 = this.f1777g;
        EnumC0145o enumC0145o = ((C0152w) interfaceC0150u2.getLifecycle()).f1855c;
        if (enumC0145o == EnumC0145o.f1844c) {
            this.f1778h.removeObserver(this.f1779c);
            return;
        }
        EnumC0145o enumC0145o2 = null;
        while (enumC0145o2 != enumC0145o) {
            b(e());
            enumC0145o2 = enumC0145o;
            enumC0145o = ((C0152w) interfaceC0150u2.getLifecycle()).f1855c;
        }
    }

    @Override // androidx.lifecycle.B
    public final void c() {
        this.f1777g.getLifecycle().b(this);
    }

    @Override // androidx.lifecycle.B
    public final boolean d(InterfaceC0150u interfaceC0150u) {
        if (this.f1777g == interfaceC0150u) {
            return true;
        }
        return false;
    }

    @Override // androidx.lifecycle.B
    public final boolean e() {
        if (((C0152w) this.f1777g.getLifecycle()).f1855c.compareTo(EnumC0145o.f1847f) >= 0) {
            return true;
        }
        return false;
    }
}

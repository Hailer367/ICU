package androidx.lifecycle;

/* renamed from: androidx.lifecycle.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0213u {

    /* renamed from: a, reason: collision with root package name */
    public EnumC0207n f3020a;

    /* renamed from: b, reason: collision with root package name */
    public r f3021b;

    public final void a(InterfaceC0212t interfaceC0212t, EnumC0206m enumC0206m) {
        EnumC0207n a4 = enumC0206m.a();
        EnumC0207n enumC0207n = this.f3020a;
        T2.h.e(enumC0207n, "state1");
        if (a4.compareTo(enumC0207n) < 0) {
            enumC0207n = a4;
        }
        this.f3020a = enumC0207n;
        this.f3021b.d(interfaceC0212t, enumC0206m);
        this.f3020a = a4;
    }
}

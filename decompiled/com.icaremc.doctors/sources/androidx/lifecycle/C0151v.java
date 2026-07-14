package androidx.lifecycle;

/* renamed from: androidx.lifecycle.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0151v {

    /* renamed from: a, reason: collision with root package name */
    public EnumC0145o f1851a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC0148s f1852b;

    public final void a(InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n) {
        EnumC0145o a2 = enumC0144n.a();
        EnumC0145o state1 = this.f1851a;
        kotlin.jvm.internal.h.e(state1, "state1");
        if (a2.compareTo(state1) < 0) {
            state1 = a2;
        }
        this.f1851a = state1;
        this.f1852b.a(interfaceC0150u, enumC0144n);
        this.f1851a = a2;
    }
}

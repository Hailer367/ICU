package androidx.lifecycle;

import java.util.HashMap;

/* renamed from: androidx.lifecycle.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0135e implements InterfaceC0148s {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1837c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1838d;

    public /* synthetic */ C0135e(int i2, Object obj) {
        this.f1837c = i2;
        this.f1838d = obj;
    }

    @Override // androidx.lifecycle.InterfaceC0148s
    public final void a(InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n) {
        switch (this.f1837c) {
            case 0:
                new HashMap();
                InterfaceC0139i[] interfaceC0139iArr = (InterfaceC0139i[]) this.f1838d;
                if (interfaceC0139iArr.length <= 0) {
                    if (interfaceC0139iArr.length <= 0) {
                        return;
                    }
                    InterfaceC0139i interfaceC0139i = interfaceC0139iArr[0];
                    throw null;
                }
                InterfaceC0139i interfaceC0139i2 = interfaceC0139iArr[0];
                throw null;
            default:
                if (enumC0144n == EnumC0144n.ON_CREATE) {
                    interfaceC0150u.getLifecycle().b(this);
                    ((T) this.f1838d).b();
                    return;
                } else {
                    throw new IllegalStateException(("Next event must be ON_CREATE, it was " + enumC0144n).toString());
                }
        }
    }
}

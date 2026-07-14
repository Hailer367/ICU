package E;

import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.EnumC0144n;
import androidx.lifecycle.InterfaceC0148s;
import androidx.lifecycle.InterfaceC0150u;

/* renamed from: E.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0012l implements InterfaceC0148s {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f235c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f236d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f237e;

    public /* synthetic */ C0012l(int i2, Object obj, Object obj2) {
        this.f235c = i2;
        this.f236d = obj;
        this.f237e = obj2;
    }

    @Override // androidx.lifecycle.InterfaceC0148s
    public final void a(InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        switch (this.f235c) {
            case 0:
                C0014n c0014n = (C0014n) this.f236d;
                InterfaceC0016p interfaceC0016p = (InterfaceC0016p) this.f237e;
                if (enumC0144n == EnumC0144n.ON_DESTROY) {
                    c0014n.a(interfaceC0016p);
                    return;
                } else {
                    c0014n.getClass();
                    return;
                }
            default:
                d.t tVar = (d.t) this.f236d;
                d.k kVar = (d.k) this.f237e;
                if (enumC0144n == EnumC0144n.ON_CREATE) {
                    onBackInvokedDispatcher = kVar.getOnBackInvokedDispatcher();
                    kotlin.jvm.internal.h.d(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
                    tVar.c(onBackInvokedDispatcher);
                    return;
                }
                return;
        }
    }
}

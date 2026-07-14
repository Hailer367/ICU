package I;

import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.EnumC0206m;
import androidx.lifecycle.InterfaceC0212t;

/* renamed from: I.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0059m implements androidx.lifecycle.r {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f768f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f769g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f770h;

    public /* synthetic */ C0059m(int i4, Object obj, Object obj2) {
        this.f768f = i4;
        this.f769g = obj;
        this.f770h = obj2;
    }

    @Override // androidx.lifecycle.r
    public final void d(InterfaceC0212t interfaceC0212t, EnumC0206m enumC0206m) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        switch (this.f768f) {
            case 0:
                C0061o c0061o = (C0061o) this.f769g;
                InterfaceC0062p interfaceC0062p = (InterfaceC0062p) this.f770h;
                if (enumC0206m == EnumC0206m.ON_DESTROY) {
                    c0061o.b(interfaceC0062p);
                    return;
                } else {
                    c0061o.getClass();
                    return;
                }
            default:
                e.t tVar = (e.t) this.f769g;
                e.l lVar = (e.l) this.f770h;
                if (enumC0206m == EnumC0206m.ON_CREATE) {
                    onBackInvokedDispatcher = lVar.getOnBackInvokedDispatcher();
                    T2.h.d(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
                    tVar.b(onBackInvokedDispatcher);
                    return;
                }
                return;
        }
    }
}

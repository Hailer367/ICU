package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;

/* renamed from: androidx.fragment.app.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0184p extends A {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2875f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractComponentCallbacksC0187t f2876g;

    public C0184p(DialogInterfaceOnCancelListenerC0185q dialogInterfaceOnCancelListenerC0185q, C0184p c0184p) {
        this.f2876g = dialogInterfaceOnCancelListenerC0185q;
    }

    @Override // androidx.fragment.app.A
    public final View b(int i4) {
        switch (this.f2875f) {
            case 0:
                Dialog dialog = ((DialogInterfaceOnCancelListenerC0185q) this.f2876g).f2886g0;
                if (dialog != null) {
                    return dialog.findViewById(i4);
                }
                return null;
            default:
                throw new IllegalStateException("Fragment " + this.f2876g + " does not have a view");
        }
    }

    @Override // androidx.fragment.app.A
    public final boolean c() {
        switch (this.f2875f) {
            case 0:
                return ((DialogInterfaceOnCancelListenerC0185q) this.f2876g).f2890k0;
            default:
                return false;
        }
    }

    public C0184p(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        this.f2876g = abstractComponentCallbacksC0187t;
    }
}

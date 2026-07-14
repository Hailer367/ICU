package androidx.fragment.app;

import android.view.View;

/* renamed from: androidx.fragment.app.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0125u extends P {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ P f1756c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0126v f1757d;

    public C0125u(DialogInterfaceOnCancelListenerC0126v dialogInterfaceOnCancelListenerC0126v, P p) {
        this.f1757d = dialogInterfaceOnCancelListenerC0126v;
        this.f1756c = p;
    }

    @Override // androidx.fragment.app.P
    public final View b(int i2) {
        P p = this.f1756c;
        if (p.c()) {
            return p.b(i2);
        }
        return this.f1757d.onFindViewById(i2);
    }

    @Override // androidx.fragment.app.P
    public final boolean c() {
        if (!this.f1756c.c() && !this.f1757d.onHasView()) {
            return false;
        }
        return true;
    }
}

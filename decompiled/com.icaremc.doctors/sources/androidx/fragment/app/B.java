package androidx.fragment.app;

import android.view.View;
import androidx.lifecycle.EnumC0144n;
import androidx.lifecycle.InterfaceC0148s;
import androidx.lifecycle.InterfaceC0150u;

/* loaded from: classes.dex */
public final class B implements InterfaceC0148s {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ H f1502c;

    public B(H h2) {
        this.f1502c = h2;
    }

    @Override // androidx.lifecycle.InterfaceC0148s
    public final void a(InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n) {
        View view;
        if (enumC0144n == EnumC0144n.ON_STOP && (view = this.f1502c.mView) != null) {
            view.cancelPendingInputEvents();
        }
    }
}

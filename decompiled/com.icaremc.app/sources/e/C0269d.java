package e;

import android.view.View;
import android.view.Window;
import androidx.fragment.app.AbstractActivityC0192y;
import androidx.lifecycle.EnumC0206m;
import androidx.lifecycle.InterfaceC0212t;
import i0.C0362e;

/* renamed from: e.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0269d implements androidx.lifecycle.r {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3550f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3551g;

    public /* synthetic */ C0269d(int i4, Object obj) {
        this.f3550f = i4;
        this.f3551g = obj;
    }

    @Override // androidx.lifecycle.r
    public final void d(InterfaceC0212t interfaceC0212t, EnumC0206m enumC0206m) {
        Window window;
        View peekDecorView;
        switch (this.f3550f) {
            case 0:
                AbstractActivityC0192y abstractActivityC0192y = (AbstractActivityC0192y) this.f3551g;
                if (enumC0206m == EnumC0206m.ON_STOP && (window = abstractActivityC0192y.getWindow()) != null && (peekDecorView = window.peekDecorView()) != null) {
                    peekDecorView.cancelPendingInputEvents();
                    return;
                }
                return;
            case 1:
                l.c((AbstractActivityC0192y) this.f3551g, interfaceC0212t, enumC0206m);
                return;
            default:
                C0362e c0362e = (C0362e) this.f3551g;
                T2.h.e(c0362e, "this$0");
                if (enumC0206m == EnumC0206m.ON_START) {
                    c0362e.f4099f = true;
                    return;
                } else {
                    if (enumC0206m == EnumC0206m.ON_STOP) {
                        c0362e.f4099f = false;
                        return;
                    }
                    return;
                }
        }
    }
}

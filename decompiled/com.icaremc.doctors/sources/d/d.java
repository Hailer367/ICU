package d;

import android.view.View;
import android.view.Window;
import androidx.fragment.app.M;
import androidx.lifecycle.EnumC0144n;
import androidx.lifecycle.InterfaceC0148s;
import androidx.lifecycle.InterfaceC0150u;
import b0.C0163e;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements InterfaceC0148s {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2120c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2121d;

    public /* synthetic */ d(int i2, Object obj) {
        this.f2120c = i2;
        this.f2121d = obj;
    }

    @Override // androidx.lifecycle.InterfaceC0148s
    public final void a(InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n) {
        Window window;
        View peekDecorView;
        switch (this.f2120c) {
            case 0:
                M m2 = (M) this.f2121d;
                if (enumC0144n == EnumC0144n.ON_STOP && (window = m2.getWindow()) != null && (peekDecorView = window.peekDecorView()) != null) {
                    peekDecorView.cancelPendingInputEvents();
                    return;
                }
                return;
            case 1:
                k.c((M) this.f2121d, interfaceC0150u, enumC0144n);
                return;
            default:
                C0163e this$0 = (C0163e) this.f2121d;
                kotlin.jvm.internal.h.e(this$0, "this$0");
                if (enumC0144n == EnumC0144n.ON_START) {
                    this$0.f1978f = true;
                    return;
                } else {
                    if (enumC0144n == EnumC0144n.ON_STOP) {
                        this$0.f1978f = false;
                        return;
                    }
                    return;
                }
        }
    }
}

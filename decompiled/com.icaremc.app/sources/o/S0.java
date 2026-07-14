package o;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class S0 extends AbstractC0486M0 implements InterfaceC0488N0 {

    /* renamed from: H, reason: collision with root package name */
    public static final Method f5516H;

    /* renamed from: G, reason: collision with root package name */
    public j.O f5517G;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f5516H = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // o.InterfaceC0488N0
    public final void e(n.n nVar, MenuItem menuItem) {
        j.O o3 = this.f5517G;
        if (o3 != null) {
            o3.e(nVar, menuItem);
        }
    }

    @Override // o.InterfaceC0488N0
    public final void o(n.n nVar, n.q qVar) {
        j.O o3 = this.f5517G;
        if (o3 != null) {
            o3.o(nVar, qVar);
        }
    }

    @Override // o.AbstractC0486M0
    public final C0462A0 q(Context context, boolean z) {
        R0 r02 = new R0(context, z);
        r02.setHoverListener(this);
        return r02;
    }
}

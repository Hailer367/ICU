package E;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class D {
    public static k0 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        k0 a2 = k0.a(null, rootWindowInsets);
        g0 g0Var = a2.f234a;
        g0Var.t(a2);
        View rootView = view.getRootView();
        g0Var.d(rootView);
        g0Var.m(rootView);
        g0Var.n();
        return a2;
    }
}

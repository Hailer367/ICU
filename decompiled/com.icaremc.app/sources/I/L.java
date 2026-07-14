package I;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class L {
    public static v0 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        v0 c4 = v0.c(rootWindowInsets, null);
        r0 r0Var = c4.f788a;
        r0Var.v(c4);
        View rootView = view.getRootView();
        r0Var.d(rootView);
        r0Var.n(rootView);
        r0Var.o();
        return c4;
    }
}

package E;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.Objects;

/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: b, reason: collision with root package name */
    public static final k0 f233b;

    /* renamed from: a, reason: collision with root package name */
    public final g0 f234a;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            f233b = d0.f222w;
        } else if (i2 >= 30) {
            f233b = b0.f213v;
        } else {
            f233b = g0.f227b;
        }
    }

    public k0(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 35) {
            this.f234a = new f0(this, windowInsets);
            return;
        }
        if (i2 >= 34) {
            this.f234a = new d0(this, windowInsets);
            return;
        }
        if (i2 >= 31) {
            this.f234a = new c0(this, windowInsets);
            return;
        }
        if (i2 >= 30) {
            this.f234a = new b0(this, windowInsets);
            return;
        }
        if (i2 >= 29) {
            this.f234a = new Z(this, windowInsets);
        } else if (i2 >= 28) {
            this.f234a = new Y(this, windowInsets);
        } else {
            this.f234a = new X(this, windowInsets);
        }
    }

    public static k0 a(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        k0 k0Var = new k0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            Field field = J.f180a;
            k0 a2 = D.a(view);
            g0 g0Var = k0Var.f234a;
            g0Var.t(a2);
            View rootView = view.getRootView();
            g0Var.d(rootView);
            g0Var.m(rootView);
            g0Var.n();
            g0Var.v(view.getWindowSystemUiVisibility());
        }
        return k0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        return Objects.equals(this.f234a, ((k0) obj).f234a);
    }

    public final int hashCode() {
        g0 g0Var = this.f234a;
        if (g0Var == null) {
            return 0;
        }
        return g0Var.hashCode();
    }

    public k0() {
        this.f234a = new g0(this);
    }
}

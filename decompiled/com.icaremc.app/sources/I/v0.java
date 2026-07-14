package I;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: b, reason: collision with root package name */
    public static final v0 f787b;

    /* renamed from: a, reason: collision with root package name */
    public final r0 f788a;

    static {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 34) {
            f787b = o0.f777w;
        } else if (i4 >= 30) {
            f787b = m0.f771v;
        } else {
            f787b = r0.f783b;
        }
    }

    public v0(WindowInsets windowInsets) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 35) {
            this.f788a = new q0(this, windowInsets);
            return;
        }
        if (i4 >= 34) {
            this.f788a = new o0(this, windowInsets);
            return;
        }
        if (i4 >= 31) {
            this.f788a = new n0(this, windowInsets);
            return;
        }
        if (i4 >= 30) {
            this.f788a = new m0(this, windowInsets);
            return;
        }
        if (i4 >= 29) {
            this.f788a = new l0(this, windowInsets);
        } else if (i4 >= 28) {
            this.f788a = new k0(this, windowInsets);
        } else {
            this.f788a = new j0(this, windowInsets);
        }
    }

    public static B.c a(B.c cVar, int i4, int i5, int i6, int i7) {
        int max = Math.max(0, cVar.f124a - i4);
        int max2 = Math.max(0, cVar.f125b - i5);
        int max3 = Math.max(0, cVar.f126c - i6);
        int max4 = Math.max(0, cVar.f127d - i7);
        if (max == i4 && max2 == i5 && max3 == i6 && max4 == i7) {
            return cVar;
        }
        return B.c.b(max, max2, max3, max4);
    }

    public static v0 c(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        v0 v0Var = new v0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = T.f702a;
            v0 a4 = L.a(view);
            r0 r0Var = v0Var.f788a;
            r0Var.v(a4);
            View rootView = view.getRootView();
            r0Var.d(rootView);
            r0Var.n(rootView);
            r0Var.o();
            r0Var.x(view.getWindowSystemUiVisibility());
        }
        return v0Var;
    }

    public final WindowInsets b() {
        r0 r0Var = this.f788a;
        if (r0Var instanceof i0) {
            return ((i0) r0Var).f751c;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        return Objects.equals(this.f788a, ((v0) obj).f788a);
    }

    public final int hashCode() {
        r0 r0Var = this.f788a;
        if (r0Var == null) {
            return 0;
        }
        return r0Var.hashCode();
    }

    public v0() {
        this.f788a = new r0(this);
    }
}

package I;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class r0 {

    /* renamed from: b, reason: collision with root package name */
    public static final v0 f783b;

    /* renamed from: a, reason: collision with root package name */
    public final v0 f784a;

    static {
        h0 a0Var;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 36) {
            a0Var = new g0();
        } else if (i4 >= 35) {
            a0Var = new f0();
        } else if (i4 >= 34) {
            a0Var = new e0();
        } else if (i4 >= 31) {
            a0Var = new d0();
        } else if (i4 >= 30) {
            a0Var = new c0();
        } else if (i4 >= 29) {
            a0Var = new b0();
        } else {
            a0Var = new a0();
        }
        f783b = a0Var.b().f788a.a().f788a.b().f788a.c();
    }

    public r0(v0 v0Var) {
        this.f784a = v0Var;
    }

    public v0 a() {
        return this.f784a;
    }

    public v0 b() {
        return this.f784a;
    }

    public v0 c() {
        return this.f784a;
    }

    public List<Rect> e(int i4) {
        return Collections.EMPTY_LIST;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        if (r() == r0Var.r() && q() == r0Var.q() && Objects.equals(l(), r0Var.l()) && Objects.equals(j(), r0Var.j()) && Objects.equals(g(), r0Var.g())) {
            return true;
        }
        return false;
    }

    public List<Rect> f(int i4) {
        return Collections.EMPTY_LIST;
    }

    public C0054h g() {
        return null;
    }

    public B.c h(int i4) {
        return B.c.f123e;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(r()), Boolean.valueOf(q()), l(), j(), g());
    }

    public B.c i() {
        return l();
    }

    public B.c j() {
        return B.c.f123e;
    }

    public B.c k() {
        return l();
    }

    public B.c l() {
        return B.c.f123e;
    }

    public B.c m() {
        return l();
    }

    public v0 p(int i4, int i5, int i6, int i7) {
        return f783b;
    }

    public boolean q() {
        return false;
    }

    public boolean r() {
        return false;
    }

    public boolean s(int i4) {
        return true;
    }

    public void o() {
    }

    public void d(View view) {
    }

    public void n(View view) {
    }

    public void t(C0056j c0056j) {
    }

    public void u(B.c[] cVarArr) {
    }

    public void v(v0 v0Var) {
    }

    public void w(B.c cVar) {
    }

    public void x(int i4) {
    }

    public void y(Rect[][] rectArr) {
    }

    public void z(Rect[][] rectArr) {
    }
}

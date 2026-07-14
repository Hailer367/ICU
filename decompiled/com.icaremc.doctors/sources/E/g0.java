package E;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class g0 {

    /* renamed from: b, reason: collision with root package name */
    public static final k0 f227b;

    /* renamed from: a, reason: collision with root package name */
    public final k0 f228a;

    static {
        V m2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 36) {
            m2 = new U();
        } else if (i2 >= 35) {
            m2 = new T();
        } else if (i2 >= 34) {
            m2 = new S();
        } else if (i2 >= 31) {
            m2 = new Q();
        } else if (i2 >= 30) {
            m2 = new P();
        } else if (i2 >= 29) {
            m2 = new O();
        } else {
            m2 = new M();
        }
        f227b = m2.b().f234a.a().f234a.b().f234a.c();
    }

    public g0(k0 k0Var) {
        this.f228a = k0Var;
    }

    public k0 a() {
        return this.f228a;
    }

    public k0 b() {
        return this.f228a;
    }

    public k0 c() {
        return this.f228a;
    }

    public List<Rect> e(int i2) {
        return Collections.EMPTY_LIST;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        if (p() == g0Var.p() && o() == g0Var.o() && Objects.equals(k(), g0Var.k()) && Objects.equals(i(), g0Var.i()) && Objects.equals(g(), g0Var.g())) {
            return true;
        }
        return false;
    }

    public List<Rect> f(int i2) {
        return Collections.EMPTY_LIST;
    }

    public C0006f g() {
        return null;
    }

    public x.b h() {
        return k();
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(p()), Boolean.valueOf(o()), k(), i(), g());
    }

    public x.b i() {
        return x.b.f3959e;
    }

    public x.b j() {
        return k();
    }

    public x.b k() {
        return x.b.f3959e;
    }

    public x.b l() {
        return k();
    }

    public boolean o() {
        return false;
    }

    public boolean p() {
        return false;
    }

    public boolean q(int i2) {
        return true;
    }

    public void n() {
    }

    public void d(View view) {
    }

    public void m(View view) {
    }

    public void r(C0008h c0008h) {
    }

    public void s(x.b[] bVarArr) {
    }

    public void t(k0 k0Var) {
    }

    public void u(x.b bVar) {
    }

    public void v(int i2) {
    }

    public void w(Rect[][] rectArr) {
    }

    public void x(Rect[][] rectArr) {
    }
}
